package me.justahuman.slimefun_essentials.client.payload;

import me.justahuman.slimefun_essentials.client.RecipeCategory;
import me.justahuman.slimefun_essentials.utils.Payloads;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class RecipeCategoriesPayload implements CustomPacketPayload {
    private static final RecipeCategoriesPayload EMPTY = new RecipeCategoriesPayload();
    public static final StreamCodec<FriendlyByteBuf, RecipeCategoriesPayload> CODEC =
            Payloads.newSplitCodec(input -> {
                Payloads.readVersion(input);
                int size = input.readInt();
                for (int i = 0; i < size; i++) {
                    RecipeCategory.deserialize(input);
                }
                Payloads.checkMetExpectedLater();
                return EMPTY;
            }, EMPTY);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return Payloads.RECIPE_CATEGORIES_CHANNEL;
    }
}
