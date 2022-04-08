package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.c;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
abstract class WebSocketProtocolHandler extends MessageToMessageDecoder<WebSocketFrame> implements ChannelOutboundHandler {
    private ChannelPromise closeSent;
    private final WebSocketCloseStatus closeStatus;
    private final boolean dropPongFrames;
    private final long forceCloseTimeoutMillis;

    WebSocketProtocolHandler() {
        this(true);
    }

    private void applyCloseSentTimeout(ChannelHandlerContext channelHandlerContext) {
        if (!this.closeSent.isDone() && this.forceCloseTimeoutMillis >= 0) {
            final c<?> schedule = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!WebSocketProtocolHandler.this.closeSent.isDone()) {
                        WebSocketProtocolHandler.this.closeSent.tryFailure(new WebSocketHandshakeException("send close frame timed out"));
                    }
                }
            }, this.forceCloseTimeoutMillis, TimeUnit.MILLISECONDS);
            this.closeSent.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler.3
                public void operationComplete(ChannelFuture channelFuture) {
                    schedule.cancel(false);
                }
            });
        }
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        if (this.closeStatus == null || !channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        if (this.closeSent == null) {
            write(channelHandlerContext, new CloseWebSocketFrame(this.closeStatus), channelHandlerContext.newPromise());
        }
        flush(channelHandlerContext);
        applyCloseSentTimeout(channelHandlerContext);
        this.closeSent.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler.1
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.closeSent != null) {
            ReferenceCountUtil.release(obj);
            channelPromise.setFailure((Throwable) new ClosedChannelException());
        } else if (obj instanceof CloseWebSocketFrame) {
            this.closeSent = channelPromise.unvoid();
            channelHandlerContext.write(obj).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, this.closeSent));
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketProtocolHandler(boolean z) {
        this(z, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof PingWebSocketFrame) {
            webSocketFrame.content().retain();
            channelHandlerContext.channel().writeAndFlush(new PongWebSocketFrame(webSocketFrame.content()));
            readIfNeeded(channelHandlerContext);
        } else if (!(webSocketFrame instanceof PongWebSocketFrame) || !this.dropPongFrames) {
            list.add(webSocketFrame.retain());
        } else {
            readIfNeeded(channelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketProtocolHandler(boolean z, WebSocketCloseStatus webSocketCloseStatus, long j) {
        this.dropPongFrames = z;
        this.closeStatus = webSocketCloseStatus;
        this.forceCloseTimeoutMillis = j;
    }
}
