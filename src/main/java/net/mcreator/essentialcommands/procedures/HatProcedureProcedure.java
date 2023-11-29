package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

public class HatProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
			}
		}
	}
}
