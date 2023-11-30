package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.essentialcommands.network.EssentialCommandsModVariables;
import net.mcreator.essentialcommands.EssentialCommandsMod;

public class SpawnProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/tellraw @p [\"\",{\"text\":\"<<\",\"bold\":true,\"color\":\"dark_aqua\"},{\"text\":\"Spawn\",\"bold\":true,\"color\":\"green\"},{\"text\":\"Protection\",\"bold\":true,\"color\":\"aqua\"},{\"text\":\">> \",\"bold\":true,\"color\":\"dark_aqua\"},{\"text\":\"Teleporting in 5 seconds...\",\"color\":\"green\"}]");
		EssentialCommandsMod.queueServerWork(100, () -> {
			if (!entity.isSprinting()) {
				{
					Entity _ent = entity;
					_ent.teleportTo(EssentialCommandsModVariables.MapVariables.get(world).SpawnX, EssentialCommandsModVariables.MapVariables.get(world).SpawnY, EssentialCommandsModVariables.MapVariables.get(world).SpawnZ);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(EssentialCommandsModVariables.MapVariables.get(world).SpawnX, EssentialCommandsModVariables.MapVariables.get(world).SpawnY, EssentialCommandsModVariables.MapVariables.get(world).SpawnZ,
								_ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p [\"\",{\"text\":\"<<\",\"bold\":true,\"color\":\"dark_aqua\"},{\"text\":\"Spawn\",\"bold\":true,\"color\":\"green\"},{\"text\":\"Protection\",\"bold\":true,\"color\":\"aqua\"},{\"text\":\">> \",\"bold\":true,\"color\":\"dark_aqua\"},{\"text\":\"Teleported!\",\"color\":\"green\"}]");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"You moved and your teleport was canceled!.\",\"color\":\"yellow\"}");
			}
		});
	}
}
