package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class RenameProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setHoverName(Component.literal((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "name").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()));
	}
}
