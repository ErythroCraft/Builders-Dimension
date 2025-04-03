
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.erythrocraft.buildersdimension.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import de.erythrocraft.buildersdimension.block.GateBlockBlock;
import de.erythrocraft.buildersdimension.block.DimensionBlockBlock;
import de.erythrocraft.buildersdimension.block.BuildersPortalBlockBlock;
import de.erythrocraft.buildersdimension.block.BuildersDimensionPortalBlock;
import de.erythrocraft.buildersdimension.BuildersDimensionMod;

public class BuildersDimensionModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BuildersDimensionMod.MODID);
	public static final RegistryObject<Block> GATE_BLOCK = REGISTRY.register("gate_block", () -> new GateBlockBlock());
	public static final RegistryObject<Block> DIMENSION_BLOCK = REGISTRY.register("dimension_block", () -> new DimensionBlockBlock());
	public static final RegistryObject<Block> BUILDERS_PORTAL_BLOCK = REGISTRY.register("builders_portal_block", () -> new BuildersPortalBlockBlock());
	public static final RegistryObject<Block> BUILDERS_DIMENSION_PORTAL = REGISTRY.register("builders_dimension_portal", () -> new BuildersDimensionPortalBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
