package io.netty.channel.epoll;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
class EpollEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AWAKE = -1;
    private static final long MAX_SCHEDULED_TIMERFD_NS = 999999999;
    private static final long NONE = Long.MAX_VALUE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollEventLoop.class);
    private final boolean allowGrowing;
    private NativeDatagramPacketArray datagramPacketArray;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final EpollEventArray events;
    private IovArray iovArray;
    private boolean pendingWakeup;
    private final SelectStrategy selectStrategy;
    private final FileDescriptor timerFd;
    private final IntObjectMap<AbstractEpollChannel> channels = new IntObjectHashMap(4096);
    private final IntSupplier selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.epoll.EpollEventLoop.1
        @Override // io.netty.util.IntSupplier
        public int get() throws Exception {
            return EpollEventLoop.this.epollWaitNow();
        }
    };
    private final AtomicLong nextWakeupNanos = new AtomicLong(-1);
    private volatile int ioRatio = 50;

    static {
        Epoll.ensureAvailability();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory), rejectedExecutionHandler);
        Throwable th;
        FileDescriptor fileDescriptor;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        if (i == 0) {
            this.allowGrowing = true;
            this.events = new EpollEventArray(4096);
        } else {
            this.allowGrowing = false;
            this.events = new EpollEventArray(i);
        }
        FileDescriptor fileDescriptor2 = null;
        try {
            FileDescriptor newEpollCreate = Native.newEpollCreate();
            try {
                this.epollFd = newEpollCreate;
                fileDescriptor = Native.newEventFd();
                try {
                    this.eventFd = fileDescriptor;
                    try {
                        int intValue = newEpollCreate.intValue();
                        int intValue2 = fileDescriptor.intValue();
                        int i2 = Native.EPOLLIN;
                        int i3 = Native.EPOLLET;
                        Native.epollCtlAdd(intValue, intValue2, i2 | i3);
                        fileDescriptor2 = Native.newTimerFd();
                        this.timerFd = fileDescriptor2;
                        try {
                            Native.epollCtlAdd(newEpollCreate.intValue(), fileDescriptor2.intValue(), i2 | i3);
                        } catch (IOException e2) {
                            throw new IllegalStateException("Unable to add timerFd filedescriptor to epoll", e2);
                        }
                    } catch (IOException e3) {
                        throw new IllegalStateException("Unable to add eventFd filedescriptor to epoll", e3);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptor2 = newEpollCreate;
                    if (fileDescriptor2 != null) {
                        try {
                            fileDescriptor2.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (fileDescriptor != null) {
                        try {
                            fileDescriptor.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (fileDescriptor2 != null) {
                        try {
                            fileDescriptor2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor = null;
                fileDescriptor2 = newEpollCreate;
                fileDescriptor2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileDescriptor2 = null;
            fileDescriptor = null;
        }
    }

    private void closeAll() {
        AbstractEpollChannel[] abstractEpollChannelArr;
        for (AbstractEpollChannel abstractEpollChannel : (AbstractEpollChannel[]) this.channels.values().toArray(new AbstractEpollChannel[0])) {
            abstractEpollChannel.unsafe().close(abstractEpollChannel.unsafe().voidPromise());
        }
    }

    private int epollBusyWait() throws IOException {
        return Native.epollBusyWait(this.epollFd, this.events);
    }

    private int epollWait(long j) throws IOException {
        if (j == NONE) {
            return Native.epollWait(this.epollFd, this.events, this.timerFd, Integer.MAX_VALUE, 0);
        }
        long deadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j);
        int min = (int) Math.min(deadlineToDelayNanos / 1000000000, 2147483647L);
        return Native.epollWait(this.epollFd, this.events, this.timerFd, min, (int) Math.min(deadlineToDelayNanos - (min * 1000000000), (long) MAX_SCHEDULED_TIMERFD_NS));
    }

    private int epollWaitNoTimerChange() throws IOException {
        return Native.epollWait(this.epollFd, this.events, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int epollWaitNow() throws IOException {
        return Native.epollWait(this.epollFd, this.events, true);
    }

    private int epollWaitTimeboxed() throws IOException {
        return Native.epollWait(this.epollFd, this.events, 1000);
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        if (eventLoopTaskQueueFactory == null) {
            return newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
        }
        return eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i) {
        if (i == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i);
    }

    private boolean processReady(EpollEventArray epollEventArray, int i) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int fd = epollEventArray.fd(i2);
            if (fd == this.eventFd.intValue()) {
                this.pendingWakeup = false;
            } else if (fd == this.timerFd.intValue()) {
                z = true;
            } else {
                long events = epollEventArray.events(i2);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    int i3 = Native.EPOLLERR;
                    if (((Native.EPOLLOUT | i3) & events) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if (((i3 | Native.EPOLLIN) & events) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events & Native.EPOLLRDHUP) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        Native.epollCtlAdd(this.epollFd.intValue(), intValue, abstractEpollChannel.flags);
        this.channels.put(intValue, (int) abstractEpollChannel);
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean afterScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean beforeScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        NativeDatagramPacketArray nativeDatagramPacketArray = this.datagramPacketArray;
        if (nativeDatagramPacketArray == null) {
            this.datagramPacketArray = new NativeDatagramPacketArray();
        } else {
            nativeDatagramPacketArray.clear();
        }
        return this.datagramPacketArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IovArray cleanIovArray() {
        IovArray iovArray = this.iovArray;
        if (iovArray == null) {
            this.iovArray = new IovArray();
        } else {
            iovArray.clear();
        }
        return this.iovArray;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.netty.channel.epoll.NativeDatagramPacketArray, io.netty.channel.unix.IovArray] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void cleanup() {
        /*
            r6 = this;
        L_0x0000:
            r0 = 0
            boolean r1 = r6.pendingWakeup     // Catch: all -> 0x0066
            if (r1 == 0) goto L_0x0024
            int r1 = r6.epollWaitTimeboxed()     // Catch: IOException -> 0x0000, all -> 0x0066
            if (r1 != 0) goto L_0x000c
            goto L_0x0024
        L_0x000c:
            r2 = 0
            r3 = 0
        L_0x000e:
            if (r3 >= r1) goto L_0x0000
            io.netty.channel.epoll.EpollEventArray r4 = r6.events     // Catch: IOException -> 0x0000, all -> 0x0066
            int r4 = r4.fd(r3)     // Catch: IOException -> 0x0000, all -> 0x0066
            io.netty.channel.unix.FileDescriptor r5 = r6.eventFd     // Catch: IOException -> 0x0000, all -> 0x0066
            int r5 = r5.intValue()     // Catch: IOException -> 0x0000, all -> 0x0066
            if (r4 != r5) goto L_0x0021
            r6.pendingWakeup = r2     // Catch: IOException -> 0x0000, all -> 0x0066
            goto L_0x0000
        L_0x0021:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0024:
            io.netty.channel.unix.FileDescriptor r1 = r6.eventFd     // Catch: IOException -> 0x002a, all -> 0x0066
            r1.close()     // Catch: IOException -> 0x002a, all -> 0x0066
            goto L_0x0032
        L_0x002a:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.epoll.EpollEventLoop.logger     // Catch: all -> 0x0066
            java.lang.String r3 = "Failed to close the event fd."
            r2.warn(r3, r1)     // Catch: all -> 0x0066
        L_0x0032:
            io.netty.channel.unix.FileDescriptor r1 = r6.timerFd     // Catch: IOException -> 0x0038, all -> 0x0066
            r1.close()     // Catch: IOException -> 0x0038, all -> 0x0066
            goto L_0x0040
        L_0x0038:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.epoll.EpollEventLoop.logger     // Catch: all -> 0x0066
            java.lang.String r3 = "Failed to close the timer fd."
            r2.warn(r3, r1)     // Catch: all -> 0x0066
        L_0x0040:
            io.netty.channel.unix.FileDescriptor r1 = r6.epollFd     // Catch: IOException -> 0x0046, all -> 0x0066
            r1.close()     // Catch: IOException -> 0x0046, all -> 0x0066
            goto L_0x004e
        L_0x0046:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.epoll.EpollEventLoop.logger     // Catch: all -> 0x0066
            java.lang.String r3 = "Failed to close the epoll fd."
            r2.warn(r3, r1)     // Catch: all -> 0x0066
        L_0x004e:
            io.netty.channel.unix.IovArray r1 = r6.iovArray
            if (r1 == 0) goto L_0x0057
            r1.release()
            r6.iovArray = r0
        L_0x0057:
            io.netty.channel.epoll.NativeDatagramPacketArray r1 = r6.datagramPacketArray
            if (r1 == 0) goto L_0x0060
            r1.release()
            r6.datagramPacketArray = r0
        L_0x0060:
            io.netty.channel.epoll.EpollEventArray r0 = r6.events
            r0.free()
            return
        L_0x0066:
            r1 = move-exception
            io.netty.channel.unix.IovArray r2 = r6.iovArray
            if (r2 == 0) goto L_0x0070
            r2.release()
            r6.iovArray = r0
        L_0x0070:
            io.netty.channel.epoll.NativeDatagramPacketArray r2 = r6.datagramPacketArray
            if (r2 == 0) goto L_0x0079
            r2.release()
            r6.datagramPacketArray = r0
        L_0x0079:
            io.netty.channel.epoll.EpollEventArray r0 = r6.events
            r0.free()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.cleanup():void");
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void modify(AbstractEpollChannel abstractEpollChannel) throws IOException {
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.socket.intValue(), abstractEpollChannel.flags);
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.channels.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        AbstractEpollChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractEpollChannel) {
            this.channels.put(intValue, (int) remove);
        } else if (abstractEpollChannel.isOpen()) {
            Native.epollCtlDel(this.epollFd.intValue(), intValue);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:76|3|(2:5|(2:89|88)(3:83|7|(11:10|(2:12|(1:14)(2:15|(1:17)))|18|(1:20)|21|22|78|23|(2:25|(1:27)(3:74|28|29))|32|(1:36))(1:9)))(2:82|44)|45|46|(2:(1:51)|52)(1:(4:54|55|(1:57)|58)(1:59))|60|(1:64)|80|67|87|(3:84|69|(2:86|71)(1:91))(1:90)|88) */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x010d, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010e, code lost:
        handleLoopException(r4);
     */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.run():void");
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z) {
        if (!z && this.nextWakeupNanos.getAndSet(-1L) != -1) {
            Native.eventFdWrite(this.eventFd.intValue(), 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }
}
