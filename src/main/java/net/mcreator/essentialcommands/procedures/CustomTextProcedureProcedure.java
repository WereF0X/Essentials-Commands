package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class CustomTextProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/tellraw @a" + " {\"text\":\"" + (new Object() {
							public String getMessage() {
								try {
									return MessageArgument.getMessage(arguments, "message").getString();
								} catch (CommandSyntaxException ignored) {
									return "";
								}
							}
						}).getMessage() + "\",\"color\":\"" + StringArgumentType.getString(arguments, "color") + "\"}"));
			}
		}
	}
}
