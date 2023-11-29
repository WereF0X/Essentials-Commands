package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class TopProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}
