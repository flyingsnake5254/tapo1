package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class KQueueSocketChannel extends AbstractKQueueStreamChannel implements SocketChannel {
    private final KQueueSocketChannelConfig config = new KQueueSocketChannelConfig(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class KQueueSocketChannelUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueSocketChannelUnsafe() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            try {
                if (!KQueueSocketChannel.this.isOpen() || KQueueSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((KQueueEventLoop) KQueueSocketChannel.this.eventLoop()).remove(KQueueSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public KQueueSocketChannel() {
        super((Channel) null, BsdSocket.newSocketStream(), false);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueSocketChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueSocketChannel(int i) {
        super(new BsdSocket(i));
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueSocketChannelConfig config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueSocketChannel(Channel channel, BsdSocket bsdSocket, InetSocketAddress inetSocketAddress) {
        super(channel, bsdSocket, inetSocketAddress);
    }
}
