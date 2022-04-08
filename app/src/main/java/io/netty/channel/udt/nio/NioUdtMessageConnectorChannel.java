package io.netty.channel.udt.nio;

import com.barchart.udt.StatusUDT;
import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtChannelConfig;
import io.netty.channel.udt.UdtMessage;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ScatteringByteChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class NioUdtMessageConnectorChannel extends AbstractNioMessageChannel implements UdtChannel {
    private final UdtChannelConfig config;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioUdtMessageConnectorChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);

    /* renamed from: io.netty.channel.udt.nio.NioUdtMessageConnectorChannel$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$StatusUDT;

        static {
            int[] iArr = new int[StatusUDT.values().length];
            $SwitchMap$com$barchart$udt$StatusUDT = iArr;
            try {
                iArr[StatusUDT.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$barchart$udt$StatusUDT[StatusUDT.OPENED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NioUdtMessageConnectorChannel() {
        this(TypeUDT.DATAGRAM);
    }

    private static void privilegedBind(final SocketChannelUDT socketChannelUDT, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.channel.udt.nio.NioUdtMessageConnectorChannel.1
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socketChannelUDT.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getCause());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        privilegedBind(javaChannel(), socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 == null) {
            socketAddress2 = new InetSocketAddress(0);
        }
        doBind(socketAddress2);
        try {
            boolean connect = SocketUtils.connect(javaChannel(), socketAddress);
            if (!connect) {
                selectionKey().interestOps(selectionKey().interestOps() | 8);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        if (javaChannel().finishConnect()) {
            selectionKey().interestOps(selectionKey().interestOps() & (-9));
            return;
        }
        throw new Error("Provider error: failed to finish connect. Provider library should be upgraded.");
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        int receiveBufferSize = this.config.getReceiveBufferSize();
        ByteBuf directBuffer = this.config.getAllocator().directBuffer(receiveBufferSize);
        int writeBytes = directBuffer.writeBytes((ScatteringByteChannel) javaChannel(), receiveBufferSize);
        if (writeBytes <= 0) {
            directBuffer.release();
            return 0;
        } else if (writeBytes < receiveBufferSize) {
            list.add(new UdtMessage(directBuffer));
            return 1;
        } else {
            javaChannel().close();
            throw new ChannelException("Invalid config : increase receive buffer size to avoid message truncation");
        }
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long j;
        ByteBuf content = ((UdtMessage) obj).content();
        int readableBytes = content.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        if (content.nioBufferCount() == 1) {
            j = javaChannel().write(content.nioBuffer());
        } else {
            j = javaChannel().write(content.nioBuffers());
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i <= 0 || j == readableBytes) {
            return i > 0;
        }
        throw new Error("Provider error: failed to write message. Provider library should be upgraded.");
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        SocketChannelUDT javaChannel = javaChannel();
        return javaChannel.isOpen() && javaChannel.isConnectFinished();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    public NioUdtMessageConnectorChannel(Channel channel, SocketChannelUDT socketChannelUDT) {
        super(channel, socketChannelUDT, 1);
        try {
            socketChannelUDT.configureBlocking(false);
            int i = AnonymousClass2.$SwitchMap$com$barchart$udt$StatusUDT[socketChannelUDT.socketUDT().status().ordinal()];
            if (i == 1 || i == 2) {
                this.config = new DefaultUdtChannelConfig(this, socketChannelUDT, true);
            } else {
                this.config = new DefaultUdtChannelConfig(this, socketChannelUDT, false);
            }
        } catch (Exception e2) {
            try {
                socketChannelUDT.close();
            } catch (Exception e3) {
                logger.warn("Failed to close channel.", (Throwable) e3);
            }
            throw new ChannelException("Failed to configure channel.", e2);
        }
    }

    @Override // io.netty.channel.Channel
    public UdtChannelConfig config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    public SocketChannelUDT javaChannel() {
        return super.javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public NioUdtMessageConnectorChannel(SocketChannelUDT socketChannelUDT) {
        this(null, socketChannelUDT);
    }

    public NioUdtMessageConnectorChannel(TypeUDT typeUDT) {
        this(NioUdtProvider.newConnectorChannelUDT(typeUDT));
    }
}