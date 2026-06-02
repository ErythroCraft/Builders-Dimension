package de.erythrocraft.buildersdimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import de.erythrocraft.buildersdimension.block.GateBlockBlock;
import de.erythrocraft.buildersdimension.block.DimensionBlockBlock;
import de.erythrocraft.buildersdimension.block.BuildersPortalBlockBlock;
import de.erythrocraft.buildersdimension.block.BuildersDimensionPortalBlock;
import de.erythrocraft.buildersdimension.BuildersDimensionMod;

public class BuildersDimensionModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BuildersDimensionMod.MODID);
	public static final DeferredBlock<Block> GATE_BLOCK = REGISTRY.register("gate_block", GateBlockBlock::new);
	public static final DeferredBlock<Block> DIMENSION_BLOCK = REGISTRY.register("dimension_block", DimensionBlockBlock::new);
	public static final DeferredBlock<Block> BUILDERS_PORTAL_BLOCK = REGISTRY.register("builders_portal_block", BuildersPortalBlockBlock::new);
	public static final DeferredBlock<Block> BUILDERS_DIMENSION_PORTAL = REGISTRY.register("builders_dimension_portal", BuildersDimensionPortalBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
