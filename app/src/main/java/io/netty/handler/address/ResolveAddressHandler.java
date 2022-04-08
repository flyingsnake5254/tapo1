package io.netty.handler.address;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

@ChannelHandler.a
/* loaded from: classes3.dex */
public class ResolveAddressHandler extends ChannelOutboundHandlerAdapter {
    private final AddressResolverGroup<? extends SocketAddress> resolverGroup;

    public ResolveAddressHandler(AddressResolverGroup<? extends SocketAddress> addressResolverGroup) {
        this.resolverGroup = (AddressResolverGroup) ObjectUtil.checkNotNull(addressResolverGroup, "resolverGroup");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void connect(final ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        AddressResolver<? extends SocketAddress> resolver = this.resolverGroup.getResolver(channelHandlerContext.executor());
        if (!resolver.isSupported(socketAddress) || resolver.isResolved(socketAddress)) {
            channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
            channelHandlerContext.pipeline().remove(this);
            return;
        }
        resolver.resolve(socketAddress).addListener(new a<SocketAddress>() { // from class: io.netty.handler.address.ResolveAddressHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<SocketAddress> future) {
                Throwable cause = future.cause();
                if (cause != null) {
                    channelPromise.setFailure(cause);
                } else {
                    channelHandlerContext.connect(future.getNow(), socketAddress2, channelPromise);
                }
                channelHandlerContext.pipeline().remove(ResolveAddressHandler.this);
            }
        });
    }
}
