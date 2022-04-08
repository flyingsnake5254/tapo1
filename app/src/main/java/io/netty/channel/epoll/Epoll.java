package io.netty.channel.epoll;

import io.netty.channel.unix.FileDescriptor;
import io.netty.util.internal.SystemPropertyUtil;

/* loaded from: classes3.dex */
public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        FileDescriptor fileDescriptor;
        FileDescriptor newEventFd;
        UnsupportedOperationException th = null;
        try {
            if (SystemPropertyUtil.getBoolean("io.netty.transport.noNative", false)) {
                th = new UnsupportedOperationException("Native transport was explicit disabled with -Dio.netty.transport.noNative=true");
            } else {
                try {
                    fileDescriptor = Native.newEpollCreate();
                    try {
                        newEventFd = Native.newEventFd();
                        if (fileDescriptor != null) {
                            try {
                                fileDescriptor.close();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileDescriptor != null) {
                            fileDescriptor.close();
                        }
                        UNAVAILABILITY_CAUSE = th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileDescriptor = null;
                }
                if (newEventFd != null) {
                    newEventFd.close();
                }
            }
        } catch (Exception unused2) {
        }
        UNAVAILABILITY_CAUSE = th;
    }

    private Epoll() {
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }
}
