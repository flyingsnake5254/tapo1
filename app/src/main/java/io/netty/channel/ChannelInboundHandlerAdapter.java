package io.netty.channel;

import io.netty.channel.ChannelHandlerMask;

/* loaded from: classes3.dex */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @ChannelHandlerMask.a
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelActive();
    }

    @ChannelHandlerMask.a
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelInactive();
    }

    @ChannelHandlerMask.a
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        channelHandlerContext.fireChannelRead(obj);
    }

    @ChannelHandlerMask.a
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelUnregistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
