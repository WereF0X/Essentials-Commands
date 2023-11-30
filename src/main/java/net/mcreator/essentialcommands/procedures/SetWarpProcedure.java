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

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SetWarpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (EssentialCommandsModVariables.MapVariables.get(world).Warp1 == false) {
			EssentialCommandsModVariables.MapVariables.get(world).Warp1 = true;
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp1X = entity.getX();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp1Y = entity.getY();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp1Z = entity.getZ();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp1Name = StringArgumentType.getString(arguments, "name");
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw @p {\"text\":\"Set Warp to " + "" + new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp1X) + " "
								+ new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp1Y) + " "
								+ new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp1Z) + "!\",\"color\":\"yellow\"}"));
		} else if (EssentialCommandsModVariables.MapVariables.get(world).Warp1 == true) {
			EssentialCommandsModVariables.MapVariables.get(world).Warp2 = true;
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp2X = entity.getX();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp2Y = entity.getY();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp2Z = entity.getZ();
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			EssentialCommandsModVariables.MapVariables.get(world).Warp2Name = StringArgumentType.getString(arguments, "name");
			EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw @p {\"text\":\"Set Warp to " + "" + new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp2X) + " "
								+ new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp2Y) + " "
								+ new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).Warp2Z) + "!\",\"color\":\"yellow\"}"));
		}
	}
}
