package net.mcreator.essentialcommands.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.essentialcommands.world.inventory.DisposalGUIMenu;
import net.mcreator.essentialcommands.procedures.ReturnDisposalProcedureProcedure;
import net.mcreator.essentialcommands.network.DisposalGUIButtonMessage;
import net.mcreator.essentialcommands.EssentialCommandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DisposalGUIScreen extends AbstractContainerScreen<DisposalGUIMenu> {
	private final static HashMap<String, Object> guistate = DisposalGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_clean;

	public DisposalGUIScreen(DisposalGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("essential_commands:textures/screens/disposal_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 70 && mouseX < leftPos + 94 && mouseY > topPos + 44 && mouseY < topPos + 68)
			guiGraphics.renderTooltip(font, Component.literal(ReturnDisposalProcedureProcedure.execute()), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_clean = Button.builder(Component.translatable("gui.essential_commands.disposal_gui.button_clean"), e -> {
			if (true) {
				EssentialCommandsMod.PACKET_HANDLER.sendToServer(new DisposalGUIButtonMessage(0, x, y, z));
				DisposalGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 56, this.topPos + 45, 51, 20).build();
		guistate.put("button:button_clean", button_clean);
		this.addRenderableWidget(button_clean);
	}
}
