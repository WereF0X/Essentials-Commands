package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.essentialcommands.network.EssentialCommandsModVariables;
import net.mcreator.essentialcommands.EssentialCommandsMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class TempBanProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		{
			double _setval = DoubleArgumentType.getDouble(arguments, "seconds");
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TempBan = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("ban " + (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getDisplayName().getString() + " You have been banned for " + ((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).TempBan + " seconds. Reason: " + (new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "reason").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()));
		EssentialCommandsMod.queueServerWork((int) (20 * ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).TempBan), () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("pardon " + (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getDisplayName().getString()));
		});
	}
}
