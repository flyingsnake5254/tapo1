package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SctpMessageCompletionHandler extends MessageToMessageDecoder<SctpMessage> {
    private final IntObjectMap<ByteBuf> fragments = new IntObjectHashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List list) throws Exception {
        decode2(channelHandlerContext, sctpMessage, (List<Object>) list);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        for (ByteBuf byteBuf : this.fragments.values()) {
            byteBuf.release();
        }
        this.fragments.clear();
        super.handlerRemoved(channelHandlerContext);
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List<Object> list) throws Exception {
        ByteBuf content = sctpMessage.content();
        int protocolIdentifier = sctpMessage.protocolIdentifier();
        int streamIdentifier = sctpMessage.streamIdentifier();
        boolean isComplete = sctpMessage.isComplete();
        boolean isUnordered = sctpMessage.isUnordered();
        ByteBuf remove = this.fragments.remove(streamIdentifier);
        if (remove == null) {
            remove = Unpooled.EMPTY_BUFFER;
        }
        if (isComplete && !remove.isReadable()) {
            list.add(sctpMessage);
        } else if (!isComplete && remove.isReadable()) {
            this.fragments.put(streamIdentifier, (int) Unpooled.wrappedBuffer(remove, content));
        } else if (!isComplete || !remove.isReadable()) {
            this.fragments.put(streamIdentifier, (int) content);
        } else {
            list.add(new SctpMessage(protocolIdentifier, streamIdentifier, isUnordered, Unpooled.wrappedBuffer(remove, content)));
        }
        content.retain();
    }
}
