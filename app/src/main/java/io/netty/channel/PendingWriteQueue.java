package io.netty.channel;

import androidx.core.app.NotificationCompat;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: classes3.dex */
public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long bytes;
    private final ChannelHandlerContext ctx;
    private PendingWrite head;
    private int size;
    private PendingWrite tail;
    private final PendingBytesTracker tracker;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PendingWriteQueue.class);
    private static final int PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PendingWrite {
        private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        });
        private final ObjectPool.Handle<PendingWrite> handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        static PendingWrite newInstance(Object obj, int i, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = i;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        private PendingWrite(ObjectPool.Handle<PendingWrite> handle) {
            this.handle = handle;
        }
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        this.tracker = PendingBytesTracker.newTracker(channelHandlerContext.channel());
        this.ctx = channelHandlerContext;
    }

    private void assertEmpty() {
    }

    private void recycle(PendingWrite pendingWrite, boolean z) {
        PendingWrite pendingWrite2 = pendingWrite.next;
        long j = pendingWrite.size;
        if (z) {
            if (pendingWrite2 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
            } else {
                this.head = pendingWrite2;
                this.size--;
                this.bytes -= j;
            }
        }
        pendingWrite.recycle();
        this.tracker.decrementPendingOutboundBytes(j);
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.tryFailure(th)) {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
        }
    }

    public void add(Object obj, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE);
        ObjectUtil.checkNotNull(channelPromise, "promise");
        int size = size(obj);
        PendingWrite newInstance = PendingWrite.newInstance(obj, size, channelPromise);
        PendingWrite pendingWrite = this.tail;
        if (pendingWrite == null) {
            this.head = newInstance;
            this.tail = newInstance;
        } else {
            pendingWrite.next = newInstance;
            this.tail = newInstance;
        }
        this.size++;
        this.bytes += size;
        this.tracker.incrementPendingOutboundBytes(newInstance.size);
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise channelPromise = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return channelPromise;
    }

    public void removeAndFail(Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        PendingWrite pendingWrite = this.head;
        if (pendingWrite != null) {
            ReferenceCountUtil.safeRelease(pendingWrite.msg);
            safeFail(pendingWrite.promise, th);
            recycle(pendingWrite, true);
        }
    }

    public void removeAndFailAll(Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        while (true) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite != null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
                while (pendingWrite != null) {
                    PendingWrite pendingWrite2 = pendingWrite.next;
                    ReferenceCountUtil.safeRelease(pendingWrite.msg);
                    ChannelPromise channelPromise = pendingWrite.promise;
                    recycle(pendingWrite, false);
                    safeFail(channelPromise, th);
                    pendingWrite = pendingWrite2;
                }
            } else {
                assertEmpty();
                return;
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object obj = pendingWrite.msg;
        ChannelPromise channelPromise = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.ctx.write(obj, channelPromise);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[EDGE_INSN: B:21:0x0047->B:14:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:6:0x0019, B:8:0x001d, B:10:0x002a, B:12:0x003d, B:13:0x0040, B:14:0x0047), top: B:19:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture removeAndWriteAll() {
        /*
            r8 = this;
            boolean r0 = r8.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            io.netty.channel.ChannelHandlerContext r0 = r8.ctx
            io.netty.channel.ChannelPromise r0 = r0.newPromise()
            io.netty.util.concurrent.PromiseCombiner r2 = new io.netty.util.concurrent.PromiseCombiner
            io.netty.channel.ChannelHandlerContext r3 = r8.ctx
            io.netty.util.concurrent.EventExecutor r3 = r3.executor()
            r2.<init>(r3)
        L_0x0019:
            io.netty.channel.PendingWriteQueue$PendingWrite r3 = r8.head     // Catch: all -> 0x004b
            if (r3 == 0) goto L_0x0047
            r8.tail = r1     // Catch: all -> 0x004b
            r8.head = r1     // Catch: all -> 0x004b
            r4 = 0
            r8.size = r4     // Catch: all -> 0x004b
            r5 = 0
            r8.bytes = r5     // Catch: all -> 0x004b
        L_0x0028:
            if (r3 == 0) goto L_0x0019
            io.netty.channel.PendingWriteQueue$PendingWrite r5 = io.netty.channel.PendingWriteQueue.PendingWrite.access$000(r3)     // Catch: all -> 0x004b
            java.lang.Object r6 = io.netty.channel.PendingWriteQueue.PendingWrite.access$200(r3)     // Catch: all -> 0x004b
            io.netty.channel.ChannelPromise r7 = io.netty.channel.PendingWriteQueue.PendingWrite.access$300(r3)     // Catch: all -> 0x004b
            r8.recycle(r3, r4)     // Catch: all -> 0x004b
            boolean r3 = r7 instanceof io.netty.channel.VoidChannelPromise     // Catch: all -> 0x004b
            if (r3 != 0) goto L_0x0040
            r2.add(r7)     // Catch: all -> 0x004b
        L_0x0040:
            io.netty.channel.ChannelHandlerContext r3 = r8.ctx     // Catch: all -> 0x004b
            r3.write(r6, r7)     // Catch: all -> 0x004b
            r3 = r5
            goto L_0x0028
        L_0x0047:
            r2.finish(r0)     // Catch: all -> 0x004b
            goto L_0x004f
        L_0x004b:
            r1 = move-exception
            r0.setFailure(r1)
        L_0x004f:
            r8.assertEmpty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.PendingWriteQueue.removeAndWriteAll():io.netty.channel.ChannelFuture");
    }

    public int size() {
        return this.size;
    }

    private int size(Object obj) {
        int size = this.tracker.size(obj);
        if (size < 0) {
            size = 0;
        }
        return size + PENDING_WRITE_OVERHEAD;
    }
}
