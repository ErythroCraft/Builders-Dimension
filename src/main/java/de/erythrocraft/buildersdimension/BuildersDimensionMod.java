package de.erythrocraft.buildersdimension;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.HashMap;

import de.erythrocraft.buildersdimension.init.BuildersDimensionModTabs;
import de.erythrocraft.buildersdimension.init.BuildersDimensionModItems;
import de.erythrocraft.buildersdimension.init.BuildersDimensionModBlocks;

@Mod("builders_dimension")
public class BuildersDimensionMod {
	public static final Logger LOGGER = LogManager.getLogger(BuildersDimensionMod.class);
	public static final String MODID = "builders_dimension";

	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();
	private static final ConcurrentLinkedQueue<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public BuildersDimensionMod(IEventBus modEventBus) {
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		BuildersDimensionModBlocks.REGISTRY.register(modEventBus);
		BuildersDimensionModItems.REGISTRY.register(modEventBus);
		BuildersDimensionModTabs.REGISTRY.register(modEventBus);
	}

	// Nutze RegistryFriendlyByteBuf als Basis für Play-Netzwerkpakete
	private record NetworkMessage<T extends CustomPacketPayload>(
			StreamCodec<? super net.minecraft.network.RegistryFriendlyByteBuf, T> reader,
			IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(
			CustomPacketPayload.Type<T> id,
			StreamCodec<? super net.minecraft.network.RegistryFriendlyByteBuf, T> reader,
			IPayloadHandler<T> handler) {
		if (networkingRegistered) {
			throw new IllegalStateException(
					"Cannot register new network messages after networking has been registered");
		}
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, message) -> registerMessageHelper(registrar, id, message));
		networkingRegistered = true;
	}

	// Jetzt passen die Typen perfekt zusammen:
	@SuppressWarnings("unchecked")
	private <T extends CustomPacketPayload> void registerMessageHelper(
			PayloadRegistrar registrar,
			CustomPacketPayload.Type<?> id,
			NetworkMessage<?> message) {
		CustomPacketPayload.Type<T> castedId = (CustomPacketPayload.Type<T>) id;
		NetworkMessage<T> castedMessage = (NetworkMessage<T>) message;
		registrar.playBidirectional(castedId, castedMessage.reader(), castedMessage.handler());
	}

	/**
	 * Reiht eine Aufgabe ein, die nach einer bestimmten Anzahl an Ticks auf dem
	 * Server ausgeführt wird.
	 */
	public static void queueServerWork(int tick, Runnable action) {
		// Fügt die Arbeit sicher zur Queue hinzu; die Validierung des Threads erfolgt
		// im Tick-Event selbst
		workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		// Sicheres Abarbeiten der Queue ohne ConcurrentModificationException
		int size = workQueue.size();
		for (int i = 0; i < size; i++) {
			Tuple<Runnable, Integer> work = workQueue.poll();
			if (work == null)
				break;

			// Dekrementieren und Prüfen
			int remainingTicks = work.getB() - 1;
			if (remainingTicks <= 0) {
				// Ausführen auf dem Hauptthread des Servers
				event.getServer().execute(work.getA());
			} else {
				// Wenn noch Ticks übrig sind, wieder hinten anreihen
				work.setB(remainingTicks);
				workQueue.add(work);
			}
		}
	}
}
