package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.essentialcommands.network.EssentialCommandsModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class DelWarpProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		if ((StringArgumentType.getString(arguments, "name")).equals(EssentialCommandsModVariables.MapVariables.get(world).Warp1Name)) {
			if (EssentialCommandsModVariables.MapVariables.get(world).Warp1 == true) {
				EssentialCommandsModVariables.MapVariables.get(world).Warp1 = false;
				EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"Deleted Warp!\",\"color\":\"yellow\"}");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"Warp doesn't exist!\",\"color\":\"yellow\"}");
			}
		}
		if ((StringArgumentType.getString(arguments, "name")).equals(EssentialCommandsModVariables.MapVariables.get(world).Warp2Name)) {
			if (EssentialCommandsModVariables.MapVariables.get(world).Warp2 == true) {
				EssentialCommandsModVariables.MapVariables.get(world).Warp2 = false;
				EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"Deleted Warp!\",\"color\":\"yellow\"}");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"Warp doesn't exist!\",\"color\":\"yellow\"}");
			}
		}
	}
}
