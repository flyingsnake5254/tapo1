package io.netty.channel.epoll;

import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class Native {
    public static final int EPOLLERR;
    public static final int EPOLLET;
    public static final int EPOLLIN;
    public static final int EPOLLOUT;
    public static final int EPOLLRDHUP;
    static final boolean IS_SUPPORTING_RECVMMSG;
    public static final boolean IS_SUPPORTING_SENDMMSG;
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    public static final String KERNEL_VERSION;
    public static final int TCP_MD5SIG_MAXKEYLEN;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Native.class);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 == null) goto L_0x001f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        io.netty.channel.unix.Socket.initialize();
        io.netty.channel.epoll.Native.EPOLLIN = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollin();
        io.netty.channel.epoll.Native.EPOLLOUT = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollout();
        io.netty.channel.epoll.Native.EPOLLRDHUP = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollrdhup();
        io.netty.channel.epoll.Native.EPOLLET = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollet();
        io.netty.channel.epoll.Native.EPOLLERR = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollerr();
        io.netty.channel.epoll.Native.IS_SUPPORTING_SENDMMSG = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
        io.netty.channel.epoll.Native.IS_SUPPORTING_RECVMMSG = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg();
        io.netty.channel.epoll.Native.IS_SUPPORTING_TCP_FASTOPEN = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingTcpFastopen();
        io.netty.channel.epoll.Native.TCP_MD5SIG_MAXKEYLEN = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
        io.netty.channel.epoll.Native.KERNEL_VERSION = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.kernelVersion();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r0 != null) goto L_0x0013;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
        r0.close();
     */
    static {
        /*
            java.lang.Class<io.netty.channel.epoll.Native> r0 = io.netty.channel.epoll.Native.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance(r0)
            io.netty.channel.epoll.Native.logger = r0
            java.nio.channels.Selector r0 = java.nio.channels.Selector.open()     // Catch: IOException -> 0x000d
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            offsetofEpollData()     // Catch: all -> 0x0017, UnsatisfiedLinkError -> 0x0019
            if (r0 == 0) goto L_0x001f
        L_0x0013:
            r0.close()     // Catch: IOException -> 0x001f
            goto L_0x001f
        L_0x0017:
            r1 = move-exception
            goto L_0x005f
        L_0x0019:
            loadNativeLibrary()     // Catch: all -> 0x0017
            if (r0 == 0) goto L_0x001f
            goto L_0x0013
        L_0x001f:
            io.netty.channel.unix.Socket.initialize()
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollin()
            io.netty.channel.epoll.Native.EPOLLIN = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollout()
            io.netty.channel.epoll.Native.EPOLLOUT = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollrdhup()
            io.netty.channel.epoll.Native.EPOLLRDHUP = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollet()
            io.netty.channel.epoll.Native.EPOLLET = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollerr()
            io.netty.channel.epoll.Native.EPOLLERR = r0
            boolean r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingSendmmsg()
            io.netty.channel.epoll.Native.IS_SUPPORTING_SENDMMSG = r0
            boolean r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg()
            io.netty.channel.epoll.Native.IS_SUPPORTING_RECVMMSG = r0
            boolean r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingTcpFastopen()
            io.netty.channel.epoll.Native.IS_SUPPORTING_TCP_FASTOPEN = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen()
            io.netty.channel.epoll.Native.TCP_MD5SIG_MAXKEYLEN = r0
            java.lang.String r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.kernelVersion()
            io.netty.channel.epoll.Native.KERNEL_VERSION = r0
            return
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch: IOException -> 0x0064
        L_0x0064:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.Native.<clinit>():void");
    }

    private Native() {
    }

    public static int epollBusyWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray) throws IOException {
        int epollBusyWait0 = epollBusyWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length());
        if (epollBusyWait0 >= 0) {
            return epollBusyWait0;
        }
        throw Errors.newIOException("epoll_wait", epollBusyWait0);
    }

    private static native int epollBusyWait0(int i, long j, int i2);

    private static native int epollCreate();

    public static void epollCtlAdd(int i, int i2, int i3) throws IOException {
        int epollCtlAdd0 = epollCtlAdd0(i, i2, i3);
        if (epollCtlAdd0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlAdd0);
        }
    }

    private static native int epollCtlAdd0(int i, int i2, int i3);

    public static void epollCtlDel(int i, int i2) throws IOException {
        int epollCtlDel0 = epollCtlDel0(i, i2);
        if (epollCtlDel0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlDel0);
        }
    }

    private static native int epollCtlDel0(int i, int i2);

    public static void epollCtlMod(int i, int i2, int i3) throws IOException {
        int epollCtlMod0 = epollCtlMod0(i, i2, i3);
        if (epollCtlMod0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlMod0);
        }
    }

    private static native int epollCtlMod0(int i, int i2, int i3);

    private static native int epollWait(int i, long j, int i2, int i3);

    @Deprecated
    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, FileDescriptor fileDescriptor2, int i, int i2) throws IOException {
        int i3;
        int i4;
        if (i == 0 && i2 == 0) {
            return epollWait(fileDescriptor, epollEventArray, 0);
        }
        if (i == Integer.MAX_VALUE) {
            i4 = 0;
            i3 = 0;
        } else {
            i4 = i;
            i3 = i2;
        }
        int epollWait0 = epollWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), fileDescriptor2.intValue(), i4, i3);
        if (epollWait0 >= 0) {
            return epollWait0;
        }
        throw Errors.newIOException("epoll_wait", epollWait0);
    }

    private static native int epollWait0(int i, long j, int i2, int i3, int i4, int i5);

    private static native int eventFd();

    public static native void eventFdRead(int i);

    public static native void eventFdWrite(int i, long j);

    private static void loadNativeLibrary() {
        if (SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim().startsWith("linux")) {
            String str = "netty_transport_native_epoll_" + PlatformDependent.normalizedArch();
            ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
            try {
                NativeLibraryLoader.load(str, classLoader);
            } catch (UnsatisfiedLinkError e2) {
                try {
                    NativeLibraryLoader.load("netty_transport_native_epoll", classLoader);
                    logger.debug("Failed to load {}", str, e2);
                } catch (UnsatisfiedLinkError e3) {
                    ThrowableUtil.addSuppressed(e2, e3);
                    throw e2;
                }
            }
        } else {
            throw new IllegalStateException("Only supported on Linux");
        }
    }

    public static FileDescriptor newEpollCreate() {
        return new FileDescriptor(epollCreate());
    }

    public static FileDescriptor newEventFd() {
        return new FileDescriptor(eventFd());
    }

    public static FileDescriptor newTimerFd() {
        return new FileDescriptor(timerFd());
    }

    public static native int offsetofEpollData();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int recvmmsg(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        int recvmmsg0 = recvmmsg0(i, z, nativeDatagramPacketArr, i2, i3);
        return recvmmsg0 >= 0 ? recvmmsg0 : Errors.ioResult("recvmmsg", recvmmsg0);
    }

    private static native int recvmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    @Deprecated
    public static int sendmmsg(int i, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        return sendmmsg(i, Socket.isIPv6Preferred(), nativeDatagramPacketArr, i2, i3);
    }

    private static native int sendmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    public static native int sizeofEpollEvent();

    public static int splice(int i, long j, int i2, long j2, long j3) throws IOException {
        int splice0 = splice0(i, j, i2, j2, j3);
        return splice0 >= 0 ? splice0 : Errors.ioResult("splice", splice0);
    }

    private static native int splice0(int i, long j, int i2, long j2, long j3);

    private static native int timerFd();

    static native void timerFdRead(int i);

    static native void timerFdSetTime(int i, int i2, int i3) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sendmmsg(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        int sendmmsg0 = sendmmsg0(i, z, nativeDatagramPacketArr, i2, i3);
        return sendmmsg0 >= 0 ? sendmmsg0 : Errors.ioResult("sendmmsg", sendmmsg0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, boolean z) throws IOException {
        return epollWait(fileDescriptor, epollEventArray, z ? 0 : -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, int i) throws IOException {
        int epollWait = epollWait(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), i);
        if (epollWait >= 0) {
            return epollWait;
        }
        throw Errors.newIOException("epoll_wait", epollWait);
    }
}
