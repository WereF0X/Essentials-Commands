
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.essentialcommands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.essentialcommands.world.inventory.DisposalGUIMenu;
import net.mcreator.essentialcommands.EssentialCommandsMod;

public class EssentialCommandsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EssentialCommandsMod.MODID);
	public static final RegistryObject<MenuType<DisposalGUIMenu>> DISPOSAL_GUI = REGISTRY.register("disposal_gui", () -> IForgeMenuType.create(DisposalGUIMenu::new));
}
