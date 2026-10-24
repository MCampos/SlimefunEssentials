package me.justahuman.slimefun_essentials.client.screen;

import java.util.function.BooleanSupplier;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ReloadingScreen extends Screen {
    private final BooleanSupplier isReloading;
    private final Runnable finished;

    public ReloadingScreen(BooleanSupplier isReloading, Runnable finished) {
        super(Component.translatable("slimefun_essentials.reloading"));
        this.isReloading = isReloading;
        this.finished = finished;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        if (!isReloading.getAsBoolean()) {
            finished.run();
            return;
        }

        super.render(graphics, mouseX, mouseY, delta);
        String text = switch ((int) (Util.getMillis() / 300L % 4L)) {
            case 1, 3 -> "o O o";
            case 2 -> "o o O";
            default -> "O o o";
        };
        int width = Math.max(font.width(text), font.width(title));
        int height = 18;
        int x = this.width / 2 - width / 2;
        int k = x - 12;
        int l = this.height / 2 - height / 2 - 12;
        int m = width + 12 * 2;
        int n = height + 12 * 2;
        int o = this.isFocused() ? -1 : -6250336;
        graphics.fill(k + 1, l, k + m, l + n, -16777216);
        graphics.renderOutline(k, l, m, n, o);
        graphics.drawCenteredString(this.font, title, this.width / 2, l + 12, 0xffffff);
        graphics.drawCenteredString(this.font, text, this.width / 2, l + 12 + 9, 0x808080);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
