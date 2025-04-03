
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.erythrocraft.buildersdimension.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import de.erythrocraft.buildersdimension.BuildersDimensionMod;

public class BuildersDimensionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildersDimensionMod.MODID);
	public static final RegistryObject<CreativeModeTab> BUILDERS_TAB = REGISTRY.register("builders_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.builders_dimension.builders_tab")).icon(() -> new ItemStack(BuildersDimensionModBlocks.GATE_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BuildersDimensionModBlocks.GATE_BLOCK.get().asItem());
				tabData.accept(BuildersDimensionModBlocks.DIMENSION_BLOCK.get().asItem());
				tabData.accept(BuildersDimensionModItems.BUILDERS_DIMENSION.get());
			}).build());
}
