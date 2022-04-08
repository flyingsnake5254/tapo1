package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* loaded from: classes3.dex */
public class Utf8FrameValidator extends ChannelInboundHandlerAdapter {
    private int fragmentedFramesCount;
    private Utf8Validator utf8Validator;

    private void checkUTF8String(ByteBuf byteBuf) {
        if (this.utf8Validator == null) {
            this.utf8Validator = new Utf8Validator();
        }
        this.utf8Validator.check(byteBuf);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Utf8Validator utf8Validator;
        if (obj instanceof WebSocketFrame) {
            WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
            try {
                if (!((WebSocketFrame) obj).isFinalFragment()) {
                    if (this.fragmentedFramesCount != 0) {
                        Utf8Validator utf8Validator2 = this.utf8Validator;
                        if (utf8Validator2 != null && utf8Validator2.isChecking()) {
                            checkUTF8String(webSocketFrame.content());
                        }
                    } else if (webSocketFrame instanceof TextWebSocketFrame) {
                        checkUTF8String(webSocketFrame.content());
                    }
                    this.fragmentedFramesCount++;
                } else if (!(webSocketFrame instanceof PingWebSocketFrame)) {
                    this.fragmentedFramesCount = 0;
                    if ((webSocketFrame instanceof TextWebSocketFrame) || ((utf8Validator = this.utf8Validator) != null && utf8Validator.isChecking())) {
                        checkUTF8String(webSocketFrame.content());
                        this.utf8Validator.finish();
                    }
                }
            } catch (CorruptedWebSocketFrameException e2) {
                webSocketFrame.release();
                throw e2;
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if ((th instanceof CorruptedFrameException) && channelHandlerContext.channel().isOpen()) {
            channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        }
        super.exceptionCaught(channelHandlerContext, th);
    }
}
