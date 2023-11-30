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

public class SetSpawnProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		EssentialCommandsModVariables.MapVariables.get(world).SpawnX = entity.getX();
		EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
		EssentialCommandsModVariables.MapVariables.get(world).SpawnY = entity.getY();
		EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
		EssentialCommandsModVariables.MapVariables.get(world).SpawnZ = entity.getZ();
		EssentialCommandsModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/tellraw @p [\"\",{\"text\":\"Spawn set to \",\"color\":\"yellow\"},{\"text\":\"" + "" + new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).SpawnX) + " "
							+ new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).SpawnY) + " " + new java.text.DecimalFormat("##.##").format(EssentialCommandsModVariables.MapVariables.get(world).SpawnZ)
							+ "\",\"color\":\"gold\"}]"));
	}
}
