package net.mcreator.essentialcommands.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GiveProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player) {
			ItemStack _setstack = (ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance());
			_setstack.setCount((int) DoubleArgumentType.getDouble(arguments, "amount"));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/tellraw @p [\"\",{\"text\":\"Given \",\"color\":\"yellow\"},{\"text\":\"" + "" + new java.text.DecimalFormat("##.##").format(DoubleArgumentType.getDouble(arguments, "amount"))
							+ " \",\"color\":\"gold\"},{\"text\":\"of \",\"color\":\"yellow\"},{\"text\":\"" + (ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance()).getDisplayName().getString()
							+ " \",\"color\":\"gold\"},{\"text\":\"to \",\"color\":\"yellow\"},{\"text\":\"" + (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getDisplayName().getString() + "\",\"color\":\"gold\"}]"));
	}
}
