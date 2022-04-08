package com.tplink.ssh2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/* compiled from: SSH2NioSocketHandler.java */
/* loaded from: classes3.dex */
public class c0 extends SimpleChannelInboundHandler<byte[]> {

    /* renamed from: c  reason: collision with root package name */
    private w f15175c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(w wVar) {
        this.f15175c = wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, byte[] bArr) throws Exception {
        w wVar = this.f15175c;
        if (wVar != null) {
            wVar.c(bArr);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.f15175c != null) {
            this.f15175c.d(new a0(10), EnumSSH2Status.SSH2_STATUS_DISCONNECTED);
        }
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
        if (this.f15175c != null) {
            a0 a0Var = new a0(9);
            if (th != null) {
                a0Var.c(th.getMessage());
            }
            this.f15175c.d(a0Var, EnumSSH2Status.SSH2_STATUS_DISCONNECTED);
        }
        channelHandlerContext.channel().close();
    }
}
