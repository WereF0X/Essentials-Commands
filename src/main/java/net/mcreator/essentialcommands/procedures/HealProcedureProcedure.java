package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HealProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(20);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(20);
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(20);
	}
}
