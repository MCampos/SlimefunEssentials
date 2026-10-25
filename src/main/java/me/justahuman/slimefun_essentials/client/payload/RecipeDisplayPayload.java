package me.justahuman.slimefun_essentials.client.payload;

import me.justahuman.slimefun_essentials.client.display.BasicDisplay;
import me.justahuman.slimefun_essentials.utils.JsonUtils;
import me.justahuman.slimefun_essentials.utils.Payloads;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class RecipeDisplayPayload implements CustomPacketPayload {
    private static final RecipeDisplayPayload EMPTY = new RecipeDisplayPayload();
    public static final StreamCodec<FriendlyByteBuf, RecipeDisplayPayload> CODEC =
            Payloads.newSplitCodec(input -> {
                Payloads.readVersion(input);
                BasicDisplay.deserialize(input);
                Payloads.checkMetExpected();
                return EMPTY;
            }, EMPTY);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return Payloads.RECIPE_DISPLAY_CHANNEL;
    }
}
