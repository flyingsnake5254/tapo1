package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.DatagramSocketAddress;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        EpollDatagramChannelUnsafe() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            boolean isConnected;
            int i;
            boolean z;
            EpollDatagramChannelConfig config = EpollDatagramChannel.this.config();
            if (EpollDatagramChannel.this.shouldBreakEpollInReady(config)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.edgeTriggered(EpollDatagramChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = EpollDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = config.getAllocator();
            recvBufAllocHandle.reset(config);
            epollInBefore();
            Throwable th = null;
            try {
                isConnected = EpollDatagramChannel.this.isConnected();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                do {
                    ByteBuf allocate = recvBufAllocHandle.allocate(allocator);
                    int maxDatagramPayloadSize = EpollDatagramChannel.this.config().getMaxDatagramPayloadSize();
                    if (Native.IS_SUPPORTING_RECVMMSG) {
                        i = maxDatagramPayloadSize == 0 ? 1 : allocate.writableBytes() / maxDatagramPayloadSize;
                    } else {
                        i = 0;
                    }
                    if (i > 1) {
                        z = EpollDatagramChannel.this.scatteringRead(recvBufAllocHandle, allocate, maxDatagramPayloadSize, i);
                    } else if (isConnected) {
                        try {
                            z = EpollDatagramChannel.this.connectedRead(recvBufAllocHandle, allocate, maxDatagramPayloadSize);
                        } catch (Errors.NativeIoException e2) {
                            if (isConnected) {
                                throw EpollDatagramChannel.this.translateForConnected(e2);
                            }
                            throw e2;
                        }
                    } else {
                        z = EpollDatagramChannel.this.read(recvBufAllocHandle, allocate, maxDatagramPayloadSize);
                    }
                    if (z) {
                        this.readPending = false;
                    }
                    break;
                } while (recvBufAllocHandle.continueReading());
                break;
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                epollInFinally(config);
            }
        }
    }

    public EpollDatagramChannel() {
        this((InternetProtocolFamily) null);
    }

    private NativeDatagramPacketArray cleanDatagramPacketArray() {
        return ((EpollEventLoop) eventLoop()).cleanDatagramPacketArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean connectedRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, ByteBuf byteBuf, int i) throws Exception {
        int i2;
        int i3;
        try {
            if (i != 0) {
                i2 = Math.min(byteBuf.writableBytes(), i);
            } else {
                i2 = byteBuf.writableBytes();
            }
            epollRecvByteAllocatorHandle.attemptedBytesRead(i2);
            int writerIndex = byteBuf.writerIndex();
            if (byteBuf.hasMemoryAddress()) {
                i3 = this.socket.readAddress(byteBuf.memoryAddress(), writerIndex, writerIndex + i2);
            } else {
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, i2);
                i3 = this.socket.read(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
            }
            if (i3 <= 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(i3);
                byteBuf.release();
                return false;
            }
            byteBuf.writerIndex(writerIndex + i3);
            if (i <= 0) {
                i2 = i3;
            }
            epollRecvByteAllocatorHandle.lastBytesRead(i2);
            DatagramPacket datagramPacket = new DatagramPacket(byteBuf, localAddress(), remoteAddress());
            epollRecvByteAllocatorHandle.incMessagesRead(1);
            pipeline().fireChannelRead((Object) datagramPacket);
            return true;
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean doWriteMessage(java.lang.Object r13) throws java.lang.Exception {
        /*
            r12 = this;
            boolean r0 = r13 instanceof io.netty.channel.AddressedEnvelope
            if (r0 == 0) goto L_0x0013
            io.netty.channel.AddressedEnvelope r13 = (io.netty.channel.AddressedEnvelope) r13
            java.lang.Object r0 = r13.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            java.net.SocketAddress r13 = r13.recipient()
            java.net.InetSocketAddress r13 = (java.net.InetSocketAddress) r13
            goto L_0x0017
        L_0x0013:
            r0 = r13
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r13 = 0
        L_0x0017:
            int r1 = r0.readableBytes()
            r2 = 1
            if (r1 != 0) goto L_0x001f
            return r2
        L_0x001f:
            boolean r1 = r0.hasMemoryAddress()
            r3 = 0
            if (r1 == 0) goto L_0x0053
            long r5 = r0.memoryAddress()
            if (r13 != 0) goto L_0x003c
            io.netty.channel.epoll.LinuxSocket r13 = r12.socket
            int r1 = r0.readerIndex()
            int r0 = r0.writerIndex()
            int r13 = r13.writeAddress(r5, r1, r0)
            goto L_0x00c5
        L_0x003c:
            io.netty.channel.epoll.LinuxSocket r4 = r12.socket
            int r7 = r0.readerIndex()
            int r8 = r0.writerIndex()
            java.net.InetAddress r9 = r13.getAddress()
            int r10 = r13.getPort()
            int r13 = r4.sendToAddress(r5, r7, r8, r9, r10)
            goto L_0x00c5
        L_0x0053:
            int r1 = r0.nioBufferCount()
            if (r1 <= r2) goto L_0x0092
            io.netty.channel.EventLoop r1 = r12.eventLoop()
            io.netty.channel.epoll.EpollEventLoop r1 = (io.netty.channel.epoll.EpollEventLoop) r1
            io.netty.channel.unix.IovArray r1 = r1.cleanIovArray()
            int r4 = r0.readerIndex()
            int r5 = r0.readableBytes()
            r1.add(r0, r4, r5)
            int r9 = r1.count()
            if (r13 != 0) goto L_0x007f
            io.netty.channel.epoll.LinuxSocket r13 = r12.socket
            long r0 = r1.memoryAddress(r3)
            long r0 = r13.writevAddresses(r0, r9)
            goto L_0x00c6
        L_0x007f:
            io.netty.channel.epoll.LinuxSocket r6 = r12.socket
            long r7 = r1.memoryAddress(r3)
            java.net.InetAddress r10 = r13.getAddress()
            int r11 = r13.getPort()
            int r13 = r6.sendToAddresses(r7, r9, r10, r11)
            goto L_0x00c5
        L_0x0092:
            int r1 = r0.readerIndex()
            int r4 = r0.readableBytes()
            java.nio.ByteBuffer r6 = r0.internalNioBuffer(r1, r4)
            if (r13 != 0) goto L_0x00af
            io.netty.channel.epoll.LinuxSocket r13 = r12.socket
            int r0 = r6.position()
            int r1 = r6.limit()
            int r13 = r13.write(r6, r0, r1)
            goto L_0x00c5
        L_0x00af:
            io.netty.channel.epoll.LinuxSocket r5 = r12.socket
            int r7 = r6.position()
            int r8 = r6.limit()
            java.net.InetAddress r9 = r13.getAddress()
            int r10 = r13.getPort()
            int r13 = r5.sendTo(r6, r7, r8, r9, r10)
        L_0x00c5:
            long r0 = (long) r13
        L_0x00c6:
            r4 = 0
            int r13 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r2 = 0
        L_0x00ce:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.doWriteMessage(java.lang.Object):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean read(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, ByteBuf byteBuf, int i) throws IOException {
        int i2;
        DatagramSocketAddress datagramSocketAddress;
        try {
            if (i != 0) {
                i2 = Math.min(byteBuf.writableBytes(), i);
            } else {
                i2 = byteBuf.writableBytes();
            }
            epollRecvByteAllocatorHandle.attemptedBytesRead(i2);
            int writerIndex = byteBuf.writerIndex();
            if (byteBuf.hasMemoryAddress()) {
                datagramSocketAddress = this.socket.recvFromAddress(byteBuf.memoryAddress(), writerIndex, writerIndex + i2);
            } else {
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, i2);
                datagramSocketAddress = this.socket.recvFrom(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
            }
            if (datagramSocketAddress == null) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                byteBuf.release();
                return false;
            }
            InetSocketAddress localAddress = datagramSocketAddress.localAddress();
            if (localAddress == null) {
                localAddress = localAddress();
            }
            int receivedAmount = datagramSocketAddress.receivedAmount();
            if (i <= 0) {
                i2 = receivedAmount;
            }
            epollRecvByteAllocatorHandle.lastBytesRead(i2);
            byteBuf.writerIndex(writerIndex + receivedAmount);
            epollRecvByteAllocatorHandle.incMessagesRead(1);
            pipeline().fireChannelRead((Object) new DatagramPacket(byteBuf, localAddress, datagramSocketAddress));
            return true;
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scatteringRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, ByteBuf byteBuf, int i, int i2) throws IOException {
        RecyclableArrayList recyclableArrayList = null;
        try {
            int writerIndex = byteBuf.writerIndex();
            NativeDatagramPacketArray cleanDatagramPacketArray = cleanDatagramPacketArray();
            int i3 = 0;
            while (i3 < i2 && cleanDatagramPacketArray.addWritable(byteBuf, writerIndex, i)) {
                i3++;
                writerIndex += i;
            }
            epollRecvByteAllocatorHandle.attemptedBytesRead(writerIndex - byteBuf.writerIndex());
            NativeDatagramPacketArray.NativeDatagramPacket[] packets = cleanDatagramPacketArray.packets();
            int recvmmsg = this.socket.recvmmsg(packets, 0, cleanDatagramPacketArray.count());
            if (recvmmsg == 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                byteBuf.release();
                return false;
            }
            int i4 = recvmmsg * i;
            byteBuf.writerIndex(i4);
            InetSocketAddress localAddress = localAddress();
            if (recvmmsg == 1) {
                DatagramPacket newDatagramPacket = packets[0].newDatagramPacket(byteBuf, localAddress);
                epollRecvByteAllocatorHandle.lastBytesRead(i);
                epollRecvByteAllocatorHandle.incMessagesRead(1);
                pipeline().fireChannelRead((Object) newDatagramPacket);
                return true;
            }
            RecyclableArrayList newInstance = RecyclableArrayList.newInstance();
            for (int i5 = 0; i5 < recvmmsg; i5++) {
                newInstance.add(packets[i5].newDatagramPacket(byteBuf.readRetainedSlice(i), localAddress));
            }
            epollRecvByteAllocatorHandle.lastBytesRead(i4);
            epollRecvByteAllocatorHandle.incMessagesRead(recvmmsg);
            for (int i6 = 0; i6 < recvmmsg; i6++) {
                pipeline().fireChannelRead(newInstance.set(i6, Unpooled.EMPTY_BUFFER));
            }
            newInstance.recycle();
            byteBuf.release();
            return true;
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            if (0 != 0) {
                for (int i7 = 0; i7 < recyclableArrayList.size(); i7++) {
                    ReferenceCountUtil.release(recyclableArrayList.get(i7));
                }
                recyclableArrayList.recycle();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOException translateForConnected(Errors.NativeIoException nativeIoException) {
        if (nativeIoException.expectedErr() != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return nativeIoException;
        }
        PortUnreachableException portUnreachableException = new PortUnreachableException(nativeIoException.getMessage());
        portUnreachableException.initCause(nativeIoException);
        return portUnreachableException;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.getAddress().isAnyLocalAddress() && (inetSocketAddress.getAddress() instanceof Inet4Address) && Socket.isIPv6Preferred()) {
                socketAddress = new InetSocketAddress(LinuxSocket.INET6_ANY, inetSocketAddress.getPort());
            }
        }
        super.doBind(socketAddress);
        this.active = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
        resetCachedAddresses();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        boolean z;
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearFlag(Native.EPOLLOUT);
                return;
            }
            try {
                z = false;
            } catch (IOException e2) {
                channelOutboundBuffer.remove(e2);
            }
            if (Native.IS_SUPPORTING_SENDMMSG && channelOutboundBuffer.size() > 1) {
                NativeDatagramPacketArray cleanDatagramPacketArray = cleanDatagramPacketArray();
                cleanDatagramPacketArray.add(channelOutboundBuffer, isConnected());
                int count = cleanDatagramPacketArray.count();
                if (count >= 1) {
                    NativeDatagramPacketArray.NativeDatagramPacket[] packets = cleanDatagramPacketArray.packets();
                    int i = 0;
                    while (count > 0) {
                        int sendmmsg = this.socket.sendmmsg(packets, i, count);
                        if (sendmmsg == 0) {
                            setFlag(Native.EPOLLOUT);
                            return;
                        }
                        for (int i2 = 0; i2 < sendmmsg; i2++) {
                            channelOutboundBuffer.remove();
                        }
                        count -= sendmmsg;
                        i += sendmmsg;
                    }
                    continue;
                }
            }
            int writeSpinCount = config().getWriteSpinCount();
            while (true) {
                if (writeSpinCount <= 0) {
                    break;
                } else if (doWriteMessage(current)) {
                    z = true;
                    break;
                } else {
                    writeSpinCount--;
                }
            }
            if (z) {
                channelOutboundBuffer.remove();
            } else {
                setFlag(Native.EPOLLOUT);
                return;
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf content = datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(content) ? new DatagramPacket(newDirectBuffer(datagramPacket, content), datagramPacket.recipient()) : obj;
        } else if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        } else {
            if (obj instanceof AddressedEnvelope) {
                AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
                if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                    ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                    return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), (InetSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EpollDatagramChannel(io.netty.channel.socket.InternetProtocolFamily r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x000c
            boolean r3 = io.netty.channel.unix.Socket.isIPv6Preferred()
        L_0x0007:
            io.netty.channel.epoll.LinuxSocket r3 = io.netty.channel.epoll.LinuxSocket.newSocketDgram(r3)
            goto L_0x0014
        L_0x000c:
            io.netty.channel.socket.InternetProtocolFamily r1 = io.netty.channel.socket.InternetProtocolFamily.IPv6
            if (r3 != r1) goto L_0x0012
            r3 = 1
            goto L_0x0007
        L_0x0012:
            r3 = 0
            goto L_0x0007
        L_0x0014:
            r2.<init>(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.<init>(io.netty.channel.socket.InternetProtocolFamily):void");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(inetAddress2, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return joinGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (IOException e2) {
            channelPromise.setFailure((Throwable) e2);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (IOException e2) {
            channelPromise.setFailure((Throwable) e2);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public EpollDatagramChannel(int i) {
        this(new LinuxSocket(i), true);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    private EpollDatagramChannel(LinuxSocket linuxSocket, boolean z) {
        super((Channel) null, linuxSocket, z);
        this.config = new EpollDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        try {
            this.socket.joinGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e2) {
            channelPromise.setFailure((Throwable) e2);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        try {
            this.socket.leaveGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e2) {
            channelPromise.setFailure((Throwable) e2);
        }
        return channelPromise;
    }
}
