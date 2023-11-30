package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.entity.Entity;

public class ExtinguishProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.clearFire();
	}
}
