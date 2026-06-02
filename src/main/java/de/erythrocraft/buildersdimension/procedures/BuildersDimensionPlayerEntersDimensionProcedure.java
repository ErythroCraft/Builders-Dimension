package de.erythrocraft.buildersdimension.procedures;

import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameType;

public class BuildersDimensionPlayerEntersDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player) {
			ListTag survivalInv = new ListTag();
			_player.getInventory().save(survivalInv);

			_player.getPersistentData().put("BuildersDimensionSurvivalInv", survivalInv);

			_player.getInventory().clearContent();

			_player.setGameMode(GameType.CREATIVE);
		}
	}
}
