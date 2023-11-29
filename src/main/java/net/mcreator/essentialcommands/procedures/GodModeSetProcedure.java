package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.essentialcommands.network.EssentialCommandsModVariables;

public class GodModeSetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).GodMode == false) {
			{
				boolean _setval = true;
				entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GodMode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p {\"text\":\"God mode activated!\",\"color\":\"light_purple\"}");
		} else if ((entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).GodMode == true) {
			{
				boolean _setval = false;
				entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GodMode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p {\"text\":\"God mode deactivated!\",\"color\":\"light_purple\"}");
		}
	}
}
