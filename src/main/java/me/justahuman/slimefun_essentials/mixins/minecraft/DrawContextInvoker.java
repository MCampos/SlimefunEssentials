package me.justahuman.slimefun_essentials.mixins.minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.resources.ResourceLocation;

@Mixin(GuiGraphics.class)
public interface DrawContextInvoker {
    @Invoker void callRenderTooltipInternal(Font textRenderer, List<ClientTooltipComponent> components, int x, int y, ClientTooltipPositioner positioner, ResourceLocation texture);
}
