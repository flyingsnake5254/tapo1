package io.netty.channel;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.b;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_COMPLETE = 2;
    private static final int ADD_PENDING = 1;
    private static final int INIT = 0;
    private static final int REMOVE_COMPLETE = 3;
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState = 0;
    private Tasks invokeTasks;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private ChannelFuture succeededFuture;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractChannelHandlerContext.class);
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Tasks {
        private final AbstractChannelHandlerContext next;
        private final Runnable invokeChannelReadCompleteTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        private final Runnable invokeReadTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.2
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        private final Runnable invokeChannelWritableStateChangedTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.3
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        private final Runnable invokeFlushTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.4
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };

        Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.next = abstractChannelHandlerContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WriteTask implements Runnable {
        private AbstractChannelHandlerContext ctx;
        private final ObjectPool.Handle<WriteTask> handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;
        private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<WriteTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteTask.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public WriteTask newObject(ObjectPool.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        });
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes(this.size & Integer.MAX_VALUE);
            }
        }

        protected static void init(WriteTask writeTask, AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            writeTask.ctx = abstractChannelHandlerContext;
            writeTask.msg = obj;
            writeTask.promise = channelPromise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                writeTask.size = abstractChannelHandlerContext.pipeline.estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes(writeTask.size);
            } else {
                writeTask.size = 0;
            }
            if (z) {
                writeTask.size |= Integer.MIN_VALUE;
            }
        }

        static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            WriteTask writeTask = RECYCLER.get();
            init(writeTask, abstractChannelHandlerContext, obj, channelPromise, z);
            return writeTask;
        }

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                decrementPendingOutboundBytes();
                if (this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                } else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
            } finally {
                recycle();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private WriteTask(ObjectPool.Handle<? extends WriteTask> handle) {
            this.handle = handle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, Class<? extends ChannelHandler> cls) {
        boolean z = false;
        this.name = (String) ObjectUtil.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.pipeline = defaultChannelPipeline;
        this.executor = eventExecutor;
        this.executionMask = ChannelHandlerMask.mask(cls);
        this.ordered = (eventExecutor == null || (eventExecutor instanceof b)) ? true : z;
    }

    private AbstractChannelHandlerContext findContextInbound(int i) {
        EventExecutor executor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
        } while (skipContext(abstractChannelHandlerContext, executor, i, 510));
        return abstractChannelHandlerContext;
    }

    private AbstractChannelHandlerContext findContextOutbound(int i) {
        EventExecutor executor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
        } while (skipContext(abstractChannelHandlerContext, executor, i, 130560));
        return abstractChannelHandlerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeBind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).bind(this, socketAddress, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            bind(socketAddress, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelActive();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelActive();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelInactive();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelInactive();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj) {
        final Object obj2 = abstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE), abstractChannelHandlerContext);
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRead(obj2);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.7
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRead(obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor.execute(tasks.invokeChannelReadCompleteTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRegistered();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRegistered();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelUnregistered();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelUnregistered();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClose(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).close(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            close(channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeConnect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).connect(this, socketAddress, socketAddress2, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDeregister(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).deregister(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            deregister(channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDisconnect(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).disconnect(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            disconnect(channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext, final Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeExceptionCaught(th);
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.5
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeExceptionCaught(th);
                }
            });
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to submit an exceptionCaught() event.", th2);
                internalLogger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ((ChannelOutboundHandler) handler()).flush(this);
        } catch (Throwable th) {
            invokeExceptionCaught(th);
        }
    }

    private boolean invokeHandler() {
        int i = this.handlerState;
        if (i != 2) {
            return !this.ordered && i == 1;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRead() {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).read(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext, final Object obj) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_EVENT);
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeUserEventTriggered(obj);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeUserEventTriggered(obj);
                }
            });
        }
    }

    private void invokeWrite0(Object obj, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) handler()).write(this, obj, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise, boolean z) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        } else if (channelPromise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise.channel(), channel()));
        } else if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return false;
        } else {
            if (!z && (channelPromise instanceof VoidChannelPromise)) {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
            } else if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
                return false;
            } else {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
            }
        }
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static boolean safeExecute(EventExecutor eventExecutor, Runnable runnable, ChannelPromise channelPromise, Object obj, boolean z) {
        if (z) {
            try {
                if (eventExecutor instanceof AbstractEventExecutor) {
                    ((AbstractEventExecutor) eventExecutor).lazyExecute(runnable);
                    return true;
                }
            } catch (Throwable th) {
                try {
                    channelPromise.setFailure(th);
                } finally {
                    if (obj != null) {
                        ReferenceCountUtil.release(obj);
                    }
                }
            }
        }
        eventExecutor.execute(runnable);
        return true;
    }

    private static boolean skipContext(AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor, int i, int i2) {
        return ((i2 | i) & abstractChannelHandlerContext.executionMask) == 0 || (abstractChannelHandlerContext.executor() == eventExecutor && (abstractChannelHandlerContext.executionMask & i) == 0);
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return channel().attr(attributeKey);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return bind(socketAddress, newPromise());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void callHandlerAdded() throws Exception {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void callHandlerRemoved() throws Exception {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return connect(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        EventExecutor eventExecutor = this.executor;
        return eventExecutor == null ? channel().eventLoop() : eventExecutor;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return channel().hasAttr(attributeKey);
    }

    void invokeWrite(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
        } else {
            write(obj, channelPromise);
        }
    }

    void invokeWriteAndFlush(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
            invokeFlush0();
            return;
        }
        writeAndFlush(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(channel(), executor(), th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture = this.succeededFuture;
        if (channelFuture != null) {
            return channelFuture;
        }
        SucceededChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
        this.succeededFuture = succeededChannelFuture;
        return succeededChannelFuture;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean setAddComplete() {
        int i;
        do {
            i = this.handlerState;
            if (i == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i, 2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setAddPending() {
        HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRemoved() {
        this.handlerState = 3;
    }

    @Override // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return '\'' + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        write(obj, true, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "localAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(512);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeBind(socketAddress, channelPromise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.8
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeBind(socketAddress, channelPromise);
                }
            }, channelPromise, null, false);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(4096);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeClose(channelPromise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.11
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeClose(channelPromise);
                }
            }, channelPromise, null, false);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return connect(socketAddress, socketAddress2, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(8192);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeDeregister(channelPromise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.12
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeDeregister(channelPromise);
                }
            }, channelPromise, null, false);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(final ChannelPromise channelPromise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(channelPromise);
        }
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(2048);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeDisconnect(channelPromise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.10
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeDisconnect(channelPromise);
                }
            }, channelPromise, null, false);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRead(Object obj) {
        invokeChannelRead(findContextInbound(32), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        invokeExceptionCaught(findContextInbound(1), th);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        invokeUserEventTriggered(findContextInbound(128), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(65536);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeFlush();
        } else {
            Tasks tasks = findContextOutbound.invokeTasks;
            if (tasks == null) {
                tasks = new Tasks(findContextOutbound);
                findContextOutbound.invokeTasks = tasks;
            }
            safeExecute(executor, tasks.invokeFlushTask, channel().voidPromise(), null, false);
        }
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(16384);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeRead();
        } else {
            Tasks tasks = findContextOutbound.invokeTasks;
            if (tasks == null) {
                tasks = new Tasks(findContextOutbound);
                findContextOutbound.invokeTasks = tasks;
            }
            executor.execute(tasks.invokeReadTask);
        }
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        write(obj, false, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    private void write(Object obj, boolean z, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE);
        try {
            if (isNotValidPromise(channelPromise, true)) {
                ReferenceCountUtil.release(obj);
                return;
            }
            AbstractChannelHandlerContext findContextOutbound = findContextOutbound(z ? 98304 : 32768);
            Object obj2 = this.pipeline.touch(obj, findContextOutbound);
            EventExecutor executor = findContextOutbound.executor();
            if (!executor.inEventLoop()) {
                WriteTask newInstance = WriteTask.newInstance(findContextOutbound, obj2, channelPromise, z);
                if (!safeExecute(executor, newInstance, channelPromise, obj2, !z)) {
                    newInstance.cancel();
                }
            } else if (z) {
                findContextOutbound.invokeWriteAndFlush(obj2, channelPromise);
            } else {
                findContextOutbound.invokeWrite(obj2, channelPromise);
            }
        } catch (RuntimeException e2) {
            ReferenceCountUtil.release(obj);
            throw e2;
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return connect(socketAddress, null, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(1024);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.9
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
                }
            }, channelPromise, null, false);
        }
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelActive(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelActive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelInactive(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelInactive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRegistered(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelRegistered();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelUnregistered(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelUnregistered();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRead(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRead(this, obj);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelRead(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeUserEventTriggered(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).userEventTriggered(this, obj);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireUserEventTriggered(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelReadComplete(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelReadComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelWritabilityChanged(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelWritabilityChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable th) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, th);
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                } else if (internalLogger.isWarnEnabled()) {
                    internalLogger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                }
            }
        } else {
            fireExceptionCaught(th);
        }
    }
}
