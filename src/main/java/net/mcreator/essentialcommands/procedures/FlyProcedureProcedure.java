package net.mcreator.essentialcommands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.essentialcommands.network.EssentialCommandsModVariables;
import net.mcreator.essentialcommands.EssentialCommandsMod;

public class FlyProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).Flight == false) {
			{
				boolean _setval = true;
				entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Flight = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = true;
				_player.onUpdateAbilities();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p [\"\",{\"text\":\"Flight \",\"color\":\"gold\"},{\"text\":\"enabled\",\"color\":\"yellow\"}]");
		} else if ((entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EssentialCommandsModVariables.PlayerVariables())).Flight == true) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
			{
				boolean _setval = false;
				entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Flight = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 1, false, false));
			{
				boolean _setval = true;
				entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GodMode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EssentialCommandsMod.queueServerWork(80, () -> {
				{
					boolean _setval = false;
					entity.getCapability(EssentialCommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GodMode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
