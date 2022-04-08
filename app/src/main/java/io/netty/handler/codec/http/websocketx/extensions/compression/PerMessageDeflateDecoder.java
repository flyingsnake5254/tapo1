package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import java.util.List;

/* loaded from: classes3.dex */
class PerMessageDeflateDecoder extends DeflateDecoder {
    private boolean compressing;

    PerMessageDeflateDecoder(boolean z) {
        super(z, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (!super.acceptInboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (!extensionDecoderFilter().mustSkip(webSocketFrame)) {
            return (((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) && (webSocketFrame.rsv() & 4) > 0) || ((webSocketFrame instanceof ContinuationWebSocketFrame) && this.compressing);
        }
        if (!this.compressing) {
            return false;
        }
        throw new IllegalStateException("Cannot skip per message deflate decoder, compression in progress");
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected boolean appendFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder, io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected int newRsv(WebSocketFrame webSocketFrame) {
        return (webSocketFrame.rsv() & 4) > 0 ? webSocketFrame.rsv() ^ 4 : webSocketFrame.rsv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PerMessageDeflateDecoder(boolean z, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(z, webSocketExtensionFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        super.decode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }
}
