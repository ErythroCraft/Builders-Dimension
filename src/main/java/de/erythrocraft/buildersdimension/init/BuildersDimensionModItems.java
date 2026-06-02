/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.erythrocraft.buildersdimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import de.erythrocraft.buildersdimension.item.BuildersDimensionItem;
import de.erythrocraft.buildersdimension.BuildersDimensionMod;

public class BuildersDimensionModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BuildersDimensionMod.MODID);
	public static final DeferredItem<Item> GATE_BLOCK = block(BuildersDimensionModBlocks.GATE_BLOCK);
	public static final DeferredItem<Item> DIMENSION_BLOCK = block(BuildersDimensionModBlocks.DIMENSION_BLOCK);
	public static final DeferredItem<Item> BUILDERS_PORTAL_BLOCK = block(BuildersDimensionModBlocks.BUILDERS_PORTAL_BLOCK);
	public static final DeferredItem<Item> BUILDERS_DIMENSION = REGISTRY.register("builders_dimension", BuildersDimensionItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}