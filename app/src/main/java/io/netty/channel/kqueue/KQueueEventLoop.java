package io.netty.channel.kqueue;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class KQueueEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final KQueueEventArray eventList;
    private final FileDescriptor kqueueFd;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(KQueueEventLoop.class);
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");
    private final IovArray iovArray = new IovArray();
    private final IntSupplier selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.kqueue.KQueueEventLoop.1
        @Override // io.netty.util.IntSupplier
        public int get() throws Exception {
            return KQueueEventLoop.this.kqueueWaitNow();
        }
    };
    private final IntObjectMap<AbstractKQueueChannel> channels = new IntObjectHashMap(4096);
    private volatile int ioRatio = 50;

    static {
        KQueue.ensureAvailability();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory), rejectedExecutionHandler);
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        FileDescriptor newKQueue = Native.newKQueue();
        this.kqueueFd = newKQueue;
        if (i == 0) {
            this.allowGrowing = true;
            i = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(i);
        this.eventList = new KQueueEventArray(i);
        int keventAddUserEvent = Native.keventAddUserEvent(newKQueue.intValue(), 0);
        if (keventAddUserEvent < 0) {
            cleanup();
            throw new IllegalStateException("kevent failed to add user event with errno: " + (-keventAddUserEvent));
        }
    }

    private void closeAll() {
        AbstractKQueueChannel[] abstractKQueueChannelArr;
        try {
            kqueueWaitNow();
        } catch (IOException unused) {
        }
        for (AbstractKQueueChannel abstractKQueueChannel : (AbstractKQueueChannel[]) this.channels.values().toArray(new AbstractKQueueChannel[0])) {
            abstractKQueueChannel.unsafe().close(abstractKQueueChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private int kqueueWait(boolean z) throws IOException {
        if (z && hasTasks()) {
            return kqueueWaitNow();
        }
        long delayNanos = delayNanos(System.nanoTime());
        int min = (int) Math.min(delayNanos / 1000000000, 2147483647L);
        return kqueueWait(min, (int) Math.min(delayNanos - (min * 1000000000), 2147483647L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
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

    private void processReady(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short filter = this.eventList.filter(i2);
            short flags = this.eventList.flags(i2);
            int fd = this.eventList.fd(i2);
            if (filter != Native.EVFILT_USER && (Native.EV_ERROR & flags) == 0) {
                AbstractKQueueChannel abstractKQueueChannel = this.channels.get(fd);
                if (abstractKQueueChannel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i2), Integer.valueOf(this.eventList.fd(i2)), Short.valueOf(filter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) abstractKQueueChannel.unsafe();
                    if (filter == Native.EVFILT_WRITE) {
                        abstractKQueueUnsafe.writeReady();
                    } else if (filter == Native.EVFILT_READ) {
                        abstractKQueueUnsafe.readReady(this.eventList.data(i2));
                    } else if (filter == Native.EVFILT_SOCK && (this.eventList.fflags(i2) & Native.NOTE_RDHUP) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                    if ((Native.EV_EOF & flags) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(AbstractKQueueChannel abstractKQueueChannel) {
        this.channels.put(abstractKQueueChannel.fd().intValue(), (int) abstractKQueueChannel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            try {
                this.kqueueFd.close();
            } catch (IOException e2) {
                logger.warn("Failed to close the kqueue fd.", (Throwable) e2);
            }
        } finally {
            this.changeList.free();
            this.eventList.free();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s, short s2, int i) {
        this.changeList.evSet(abstractKQueueChannel, s, s2, i);
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.channels.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(AbstractKQueueChannel abstractKQueueChannel) throws Exception {
        int intValue = abstractKQueueChannel.fd().intValue();
        AbstractKQueueChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractKQueueChannel) {
            this.channels.put(intValue, (int) remove);
        } else if (abstractKQueueChannel.isOpen()) {
            abstractKQueueChannel.unregisterFilters();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:(2:42|2)|(1:45)(2:4|(2:50|49)(3:44|6|(11:8|16|17|(2:(1:20)|21)(3:22|(1:24)|25)|26|(1:30)|40|33|48|(3:46|35|(2:47|37)(1:52))(1:51)|49)))|9|(1:11)(1:12)|13|(1:15)|16|17|(0)(0)|26|(2:28|30)|40|33|48|(0)(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        handleLoopException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #3 {all -> 0x007f, blocks: (B:2:0x0000, B:9:0x0017, B:13:0x0023, B:15:0x002b, B:16:0x002e, B:21:0x003f, B:22:0x0043, B:25:0x005e, B:26:0x006d, B:28:0x0071, B:30:0x0079, B:20:0x0036, B:24:0x0049), top: B:42:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r7 = this;
        L_0x0000:
            io.netty.channel.SelectStrategy r0 = r7.selectStrategy     // Catch: all -> 0x007f
            io.netty.util.IntSupplier r1 = r7.selectNowSupplier     // Catch: all -> 0x007f
            boolean r2 = r7.hasTasks()     // Catch: all -> 0x007f
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: all -> 0x007f
            r1 = -3
            r2 = 0
            if (r0 == r1) goto L_0x0017
            r1 = -2
            if (r0 == r1) goto L_0x0000
            r1 = -1
            if (r0 == r1) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.channel.kqueue.KQueueEventLoop> r0 = io.netty.channel.kqueue.KQueueEventLoop.WAKEN_UP_UPDATER     // Catch: all -> 0x007f
            int r0 = r0.getAndSet(r7, r2)     // Catch: all -> 0x007f
            r1 = 1
            if (r0 != r1) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            int r0 = r7.kqueueWait(r0)     // Catch: all -> 0x007f
            int r3 = r7.wakenUp     // Catch: all -> 0x007f
            if (r3 != r1) goto L_0x002e
            r7.wakeup()     // Catch: all -> 0x007f
        L_0x002e:
            int r1 = r7.ioRatio     // Catch: all -> 0x007f
            r3 = 100
            if (r1 != r3) goto L_0x0043
            if (r0 <= 0) goto L_0x003f
            r7.processReady(r0)     // Catch: all -> 0x003a
            goto L_0x003f
        L_0x003a:
            r0 = move-exception
            r7.runAllTasks()     // Catch: all -> 0x007f
            throw r0     // Catch: all -> 0x007f
        L_0x003f:
            r7.runAllTasks()     // Catch: all -> 0x007f
            goto L_0x006d
        L_0x0043:
            long r3 = java.lang.System.nanoTime()     // Catch: all -> 0x007f
            if (r0 <= 0) goto L_0x005e
            r7.processReady(r0)     // Catch: all -> 0x004d
            goto L_0x005e
        L_0x004d:
            r0 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch: all -> 0x007f
            long r5 = r5 - r3
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: all -> 0x007f
            long r5 = r5 * r2
            long r1 = (long) r1     // Catch: all -> 0x007f
            long r5 = r5 / r1
            r7.runAllTasks(r5)     // Catch: all -> 0x007f
            throw r0     // Catch: all -> 0x007f
        L_0x005e:
            long r5 = java.lang.System.nanoTime()     // Catch: all -> 0x007f
            long r5 = r5 - r3
            int r3 = 100 - r1
            long r3 = (long) r3     // Catch: all -> 0x007f
            long r5 = r5 * r3
            long r3 = (long) r1     // Catch: all -> 0x007f
            long r5 = r5 / r3
            r7.runAllTasks(r5)     // Catch: all -> 0x007f
        L_0x006d:
            boolean r1 = r7.allowGrowing     // Catch: all -> 0x007f
            if (r1 == 0) goto L_0x0083
            io.netty.channel.kqueue.KQueueEventArray r1 = r7.eventList     // Catch: all -> 0x007f
            int r1 = r1.capacity()     // Catch: all -> 0x007f
            if (r0 != r1) goto L_0x0083
            io.netty.channel.kqueue.KQueueEventArray r0 = r7.eventList     // Catch: all -> 0x007f
            r0.realloc(r2)     // Catch: all -> 0x007f
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            handleLoopException(r0)
        L_0x0083:
            boolean r0 = r7.isShuttingDown()     // Catch: all -> 0x0093
            if (r0 == 0) goto L_0x0000
            r7.closeAll()     // Catch: all -> 0x0093
            boolean r0 = r7.confirmShutdown()     // Catch: all -> 0x0093
            if (r0 == 0) goto L_0x0000
            return
        L_0x0093:
            r0 = move-exception
            handleLoopException(r0)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueEventLoop.run():void");
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
        if (!z && WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            wakeup();
        }
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }

    private int kqueueWait(int i, int i2) throws IOException {
        int keventWait = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, i, i2);
        this.changeList.clear();
        return keventWait;
    }
}
