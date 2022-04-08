package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/* loaded from: classes3.dex */
public final class EpollServerSocketChannelConfig extends EpollServerChannelConfig implements ServerSocketChannelConfig {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollServerSocketChannelConfig(EpollServerSocketChannel epollServerSocketChannel) {
        super(epollServerSocketChannel);
        setReuseAddress(true);
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            return (T) Boolean.valueOf(isReusePort());
        }
        if (channelOption == EpollChannelOption.IP_FREEBIND) {
            return (T) Boolean.valueOf(isFreeBind());
        }
        if (channelOption == EpollChannelOption.IP_TRANSPARENT) {
            return (T) Boolean.valueOf(isIpTransparent());
        }
        if (channelOption == EpollChannelOption.TCP_DEFER_ACCEPT) {
            return (T) Integer.valueOf(getTcpDeferAccept());
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_DEFER_ACCEPT);
    }

    public int getTcpDeferAccept() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.getTcpDeferAccept();
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public boolean isFreeBind() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpFreeBind();
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public boolean isReusePort() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public EpollServerSocketChannelConfig setFreeBind(boolean z) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpFreeBind(z);
            return this;
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public EpollServerSocketChannelConfig setIpTransparent(boolean z) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpTransparent(z);
            return this;
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == EpollChannelOption.IP_FREEBIND) {
            setFreeBind(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) t);
            return true;
        } else if (channelOption != EpollChannelOption.TCP_DEFER_ACCEPT) {
            return super.setOption(channelOption, t);
        } else {
            setTcpDeferAccept(((Integer) t).intValue());
            return true;
        }
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setPerformancePreferences(int i, int i2, int i3) {
        return this;
    }

    public EpollServerSocketChannelConfig setReusePort(boolean z) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setReusePort(z);
            return this;
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public EpollServerSocketChannelConfig setTcpDeferAccept(int i) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setTcpDeferAccept(i);
            return this;
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    public EpollServerSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> map) {
        try {
            ((EpollServerSocketChannel) this.channel).setTcpMd5Sig(map);
            return this;
        } catch (IOException e2) {
            throw new ChannelException(e2);
        }
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setBacklog(int i) {
        super.setBacklog(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReceiveBufferSize(int i) {
        super.setReceiveBufferSize(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReuseAddress(boolean z) {
        super.setReuseAddress(z);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
