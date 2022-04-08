package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: classes3.dex */
public final class CleartextHttp2ServerUpgradeHandler extends ByteToMessageDecoder {
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Http2CodecUtil.connectionPrefaceBuf());
    private final ChannelHandler http2ServerHandler;
    private final HttpServerCodec httpServerCodec;
    private final HttpServerUpgradeHandler httpServerUpgradeHandler;

    /* loaded from: classes3.dex */
    public static final class PriorKnowledgeUpgradeEvent {
        private static final PriorKnowledgeUpgradeEvent INSTANCE = new PriorKnowledgeUpgradeEvent();

        private PriorKnowledgeUpgradeEvent() {
        }
    }

    public CleartextHttp2ServerUpgradeHandler(HttpServerCodec httpServerCodec, HttpServerUpgradeHandler httpServerUpgradeHandler, ChannelHandler channelHandler) {
        this.httpServerCodec = (HttpServerCodec) ObjectUtil.checkNotNull(httpServerCodec, "httpServerCodec");
        this.httpServerUpgradeHandler = (HttpServerUpgradeHandler) ObjectUtil.checkNotNull(httpServerUpgradeHandler, "httpServerUpgradeHandler");
        this.http2ServerHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "http2ServerHandler");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBuf2 = CONNECTION_PREFACE;
        int readableBytes = byteBuf2.readableBytes();
        int min = Math.min(byteBuf.readableBytes(), readableBytes);
        if (!ByteBufUtil.equals(byteBuf2, byteBuf2.readerIndex(), byteBuf, byteBuf.readerIndex(), min)) {
            channelHandlerContext.pipeline().remove(this);
        } else if (min == readableBytes) {
            channelHandlerContext.pipeline().remove(this.httpServerCodec).remove(this.httpServerUpgradeHandler);
            channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), null, this.http2ServerHandler);
            channelHandlerContext.pipeline().remove(this);
            channelHandlerContext.fireUserEventTriggered((Object) PriorKnowledgeUpgradeEvent.INSTANCE);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), null, this.httpServerUpgradeHandler).addAfter(channelHandlerContext.name(), null, this.httpServerCodec);
    }
}
