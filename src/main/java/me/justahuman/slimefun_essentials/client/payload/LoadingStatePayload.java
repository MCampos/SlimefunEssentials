package me.justahuman.slimefun_essentials.client.payload;

import me.justahuman.slimefun_essentials.utils.Payloads;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record LoadingStatePayload(int typePackets, int itemPackets, int categoryPackets, int displayPackets) implements CustomPacketPayload {
    public static final StreamCodec<FriendlyByteBuf, LoadingStatePayload> CODEC = Payloads.newCodec(input -> new LoadingStatePayload(
            input.readInt(),
            input.readInt(),
            input.readInt(),
            input.readInt()
    ));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return Payloads.LOADING_STATE_CHANNEL;
    }
}
