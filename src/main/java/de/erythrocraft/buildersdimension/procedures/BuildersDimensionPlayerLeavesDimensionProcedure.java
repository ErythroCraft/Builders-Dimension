package de.erythrocraft.buildersdimension.procedures;

import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameType;

public class BuildersDimensionPlayerLeavesDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player) {
			_player.getInventory().clearContent();

			if (_player.getPersistentData().contains("BuildersDimensionSurvivalInv", 9)) {
				ListTag originalInv = _player.getPersistentData().getList("BuildersDimensionSurvivalInv", 10);
				_player.getInventory().load(originalInv);

				_player.getPersistentData().remove("BuildersDimensionSurvivalInv");
			}

			_player.setGameMode(GameType.SURVIVAL);
		}
	}
}
