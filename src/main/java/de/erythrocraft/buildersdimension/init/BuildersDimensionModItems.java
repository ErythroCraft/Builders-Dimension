
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.erythrocraft.buildersdimension.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import de.erythrocraft.buildersdimension.item.BuildersDimensionItem;
import de.erythrocraft.buildersdimension.BuildersDimensionMod;

public class BuildersDimensionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BuildersDimensionMod.MODID);
	public static final RegistryObject<Item> GATE_BLOCK = block(BuildersDimensionModBlocks.GATE_BLOCK);
	public static final RegistryObject<Item> DIMENSION_BLOCK = block(BuildersDimensionModBlocks.DIMENSION_BLOCK);
	public static final RegistryObject<Item> BUILDERS_PORTAL_BLOCK = block(BuildersDimensionModBlocks.BUILDERS_PORTAL_BLOCK);
	public static final RegistryObject<Item> BUILDERS_DIMENSION = REGISTRY.register("builders_dimension", () -> new BuildersDimensionItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
