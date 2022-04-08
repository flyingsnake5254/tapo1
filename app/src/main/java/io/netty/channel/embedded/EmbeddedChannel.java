package io.netty.channel.embedded;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes3.dex */
public class EmbeddedChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ChannelConfig config;
    private Queue<Object> inboundMessages;
    private Throwable lastException;
    private final EmbeddedEventLoop loop;
    private final ChannelMetadata metadata;
    private Queue<Object> outboundMessages;
    private final ChannelFutureListener recordExceptionListener;
    private State state;
    private static final SocketAddress LOCAL_ADDRESS = new EmbeddedSocketAddress();
    private static final SocketAddress REMOTE_ADDRESS = new EmbeddedSocketAddress();
    private static final ChannelHandler[] EMPTY_HANDLERS = new ChannelHandler[0];
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(EmbeddedChannel.class);
    private static final ChannelMetadata METADATA_NO_DISCONNECT = new ChannelMetadata(false);
    private static final ChannelMetadata METADATA_DISCONNECT = new ChannelMetadata(true);

    /* loaded from: classes3.dex */
    private final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        EmbeddedChannelPipeline(EmbeddedChannel embeddedChannel) {
            super(embeddedChannel);
        }

        @Override // io.netty.channel.DefaultChannelPipeline
        protected void onUnhandledInboundException(Throwable th) {
            EmbeddedChannel.this.recordException(th);
        }

        @Override // io.netty.channel.DefaultChannelPipeline
        protected void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext, Object obj) {
            EmbeddedChannel.this.handleInboundMessage(obj);
        }
    }

    /* loaded from: classes3.dex */
    private final class EmbeddedUnsafe extends AbstractChannel.AbstractUnsafe {
        final Channel.Unsafe wrapped;

        private EmbeddedUnsafe() {
            super();
            this.wrapped = new Channel.Unsafe() { // from class: io.netty.channel.embedded.EmbeddedChannel.EmbeddedUnsafe.1
                @Override // io.netty.channel.Channel.Unsafe
                public void beginRead() {
                    EmbeddedUnsafe.this.beginRead();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.bind(socketAddress, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void close(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.close(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void closeForcibly() {
                    EmbeddedUnsafe.this.closeForcibly();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.connect(socketAddress, socketAddress2, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void deregister(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.deregister(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void disconnect(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.disconnect(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void flush() {
                    EmbeddedUnsafe.this.flush();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public SocketAddress localAddress() {
                    return EmbeddedUnsafe.this.localAddress();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public ChannelOutboundBuffer outboundBuffer() {
                    return EmbeddedUnsafe.this.outboundBuffer();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public RecvByteBufAllocator.Handle recvBufAllocHandle() {
                    return EmbeddedUnsafe.this.recvBufAllocHandle();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void register(EventLoop eventLoop, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.register(eventLoop, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public SocketAddress remoteAddress() {
                    return EmbeddedUnsafe.this.remoteAddress();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public ChannelPromise voidPromise() {
                    return EmbeddedUnsafe.this.voidPromise();
                }

                @Override // io.netty.channel.Channel.Unsafe
                public void write(Object obj, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.write(obj, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }
            };
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            safeSetSuccess(channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        OPEN,
        ACTIVE,
        CLOSED
    }

    public EmbeddedChannel() {
        this(EMPTY_HANDLERS);
    }

    private ChannelFuture checkException(ChannelPromise channelPromise) {
        Throwable th = this.lastException;
        if (th == null) {
            return channelPromise.setSuccess();
        }
        this.lastException = null;
        if (channelPromise.isVoid()) {
            PlatformDependent.throwException(th);
        }
        return channelPromise.setFailure(th);
    }

    private boolean checkOpen(boolean z) {
        if (isOpen()) {
            return true;
        }
        if (!z) {
            return false;
        }
        recordException(new ClosedChannelException());
        return false;
    }

    private void finishPendingTasks(boolean z) {
        runPendingTasks();
        if (z) {
            this.loop.cancelScheduledTasks();
        }
    }

    private void flushOutbound0() {
        runPendingTasks();
        flush();
    }

    private static boolean isNotEmpty(Queue<Object> queue) {
        return queue != null && !queue.isEmpty();
    }

    private static ChannelMetadata metadata(boolean z) {
        return z ? METADATA_DISCONNECT : METADATA_NO_DISCONNECT;
    }

    private static Object poll(Queue<Object> queue) {
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordException(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            recordException(channelFuture.cause());
        }
    }

    private static boolean releaseAll(Queue<Object> queue) {
        if (!isNotEmpty(queue)) {
            return false;
        }
        while (true) {
            Object poll = queue.poll();
            if (poll == null) {
                return true;
            }
            ReferenceCountUtil.release(poll);
        }
    }

    private void setup(boolean z, final ChannelHandler... channelHandlerArr) {
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        pipeline().addLast(new ChannelInitializer<Channel>() { // from class: io.netty.channel.embedded.EmbeddedChannel.2
            @Override // io.netty.channel.ChannelInitializer
            protected void initChannel(Channel channel) throws Exception {
                ChannelHandler[] channelHandlerArr2;
                ChannelPipeline pipeline = channel.pipeline();
                for (ChannelHandler channelHandler : channelHandlerArr) {
                    if (channelHandler != null) {
                        pipeline.addLast(channelHandler);
                    } else {
                        return;
                    }
                }
            }
        });
        if (z) {
            this.loop.register(this);
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.state = State.CLOSED;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        if (!this.metadata.hasDisconnect()) {
            doClose();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.state = State.ACTIVE;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current != null) {
                ReferenceCountUtil.retain(current);
                handleOutboundMessage(current);
                channelOutboundBuffer.remove();
            } else {
                return;
            }
        }
    }

    protected final void ensureOpen() {
        if (!checkOpen(true)) {
            checkException();
        }
    }

    public boolean finish() {
        return finish(false);
    }

    public boolean finishAndReleaseAll() {
        return finish(true);
    }

    public EmbeddedChannel flushInbound() {
        flushInbound(true, voidPromise());
        return this;
    }

    public EmbeddedChannel flushOutbound() {
        if (checkOpen(true)) {
            flushOutbound0();
        }
        checkException(voidPromise());
        return this;
    }

    protected void handleInboundMessage(Object obj) {
        inboundMessages().add(obj);
    }

    protected void handleOutboundMessage(Object obj) {
        outboundMessages().add(obj);
    }

    public Queue<Object> inboundMessages() {
        if (this.inboundMessages == null) {
            this.inboundMessages = new ArrayDeque();
        }
        return this.inboundMessages;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EmbeddedEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Deprecated
    public Queue<Object> lastInboundBuffer() {
        return inboundMessages();
    }

    @Deprecated
    public Queue<Object> lastOutboundBuffer() {
        return outboundMessages();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        if (isActive()) {
            return LOCAL_ADDRESS;
        }
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected final DefaultChannelPipeline newChannelPipeline() {
        return new EmbeddedChannelPipeline(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new EmbeddedUnsafe();
    }

    public Queue<Object> outboundMessages() {
        if (this.outboundMessages == null) {
            this.outboundMessages = new ArrayDeque();
        }
        return this.outboundMessages;
    }

    public <T> T readInbound() {
        T t = (T) poll(this.inboundMessages);
        if (t != null) {
            ReferenceCountUtil.touch(t, "Caller of readInbound() will handle the message from this point");
        }
        return t;
    }

    public <T> T readOutbound() {
        T t = (T) poll(this.outboundMessages);
        if (t != null) {
            ReferenceCountUtil.touch(t, "Caller of readOutbound() will handle the message from this point.");
        }
        return t;
    }

    public void register() throws Exception {
        Throwable cause = this.loop.register(this).cause();
        if (cause != null) {
            PlatformDependent.throwException(cause);
        }
    }

    public boolean releaseInbound() {
        return releaseAll(this.inboundMessages);
    }

    public boolean releaseOutbound() {
        return releaseAll(this.outboundMessages);
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        if (isActive()) {
            return REMOTE_ADDRESS;
        }
        return null;
    }

    public void runPendingTasks() {
        try {
            this.loop.runTasks();
        } catch (Exception e2) {
            recordException(e2);
        }
        try {
            this.loop.runScheduledTasks();
        } catch (Exception e3) {
            recordException(e3);
        }
    }

    public long runScheduledPendingTasks() {
        try {
            return this.loop.runScheduledTasks();
        } catch (Exception e2) {
            recordException(e2);
            return this.loop.nextScheduledTask();
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return ((EmbeddedUnsafe) super.unsafe()).wrapped;
    }

    public boolean writeInbound(Object... objArr) {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.inboundMessages);
        }
        ChannelPipeline pipeline = pipeline();
        for (Object obj : objArr) {
            pipeline.fireChannelRead(obj);
        }
        flushInbound(false, voidPromise());
        return isNotEmpty(this.inboundMessages);
    }

    public ChannelFuture writeOneInbound(Object obj) {
        return writeOneInbound(obj, newPromise());
    }

    public ChannelFuture writeOneOutbound(Object obj) {
        return writeOneOutbound(obj, newPromise());
    }

    public boolean writeOutbound(Object... objArr) {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.outboundMessages);
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(objArr.length);
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    break;
                }
                newInstance.add(write(obj));
            }
            flushOutbound0();
            int size = newInstance.size();
            for (int i = 0; i < size; i++) {
                ChannelFuture channelFuture = (ChannelFuture) newInstance.get(i);
                if (channelFuture.isDone()) {
                    recordException(channelFuture);
                } else {
                    channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) this.recordExceptionListener);
                }
            }
            checkException();
            return isNotEmpty(this.outboundMessages);
        } finally {
            newInstance.recycle();
        }
    }

    public EmbeddedChannel(ChannelId channelId) {
        this(channelId, EMPTY_HANDLERS);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean finish(boolean r2) {
        /*
            r1 = this;
            r1.close()
            r1.checkException()     // Catch: all -> 0x0027
            java.util.Queue<java.lang.Object> r0 = r1.inboundMessages     // Catch: all -> 0x0027
            boolean r0 = isNotEmpty(r0)     // Catch: all -> 0x0027
            if (r0 != 0) goto L_0x0019
            java.util.Queue<java.lang.Object> r0 = r1.outboundMessages     // Catch: all -> 0x0027
            boolean r0 = isNotEmpty(r0)     // Catch: all -> 0x0027
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r2 == 0) goto L_0x0026
            java.util.Queue<java.lang.Object> r2 = r1.inboundMessages
            releaseAll(r2)
            java.util.Queue<java.lang.Object> r2 = r1.outboundMessages
            releaseAll(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = move-exception
            if (r2 == 0) goto L_0x0034
            java.util.Queue<java.lang.Object> r2 = r1.inboundMessages
            releaseAll(r2)
            java.util.Queue<java.lang.Object> r2 = r1.outboundMessages
            releaseAll(r2)
        L_0x0034:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.embedded.EmbeddedChannel.finish(boolean):boolean");
    }

    private ChannelFuture flushInbound(boolean z, ChannelPromise channelPromise) {
        if (checkOpen(z)) {
            pipeline().fireChannelReadComplete();
            runPendingTasks();
        }
        return checkException(channelPromise);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise channelPromise) {
        runPendingTasks();
        ChannelFuture close = super.close(channelPromise);
        finishPendingTasks(true);
        return close;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        ChannelFuture disconnect = super.disconnect(channelPromise);
        finishPendingTasks(!this.metadata.hasDisconnect());
        return disconnect;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return this.metadata;
    }

    public ChannelFuture writeOneInbound(Object obj, ChannelPromise channelPromise) {
        if (checkOpen(true)) {
            pipeline().fireChannelRead(obj);
        }
        return checkException(channelPromise);
    }

    public ChannelFuture writeOneOutbound(Object obj, ChannelPromise channelPromise) {
        if (checkOpen(true)) {
            return write(obj, channelPromise);
        }
        return checkException(channelPromise);
    }

    public EmbeddedChannel(ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, channelHandlerArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordException(Throwable th) {
        if (this.lastException == null) {
            this.lastException = th;
        } else {
            logger.warn("More than one exception was raised. Will report only the first one and log others.", th);
        }
    }

    public EmbeddedChannel(boolean z, ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, z, channelHandlerArr);
    }

    public EmbeddedChannel(boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, z, z2, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, ChannelHandler... channelHandlerArr) {
        this(channelId, false, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, ChannelHandler... channelHandlerArr) {
        this(channelId, true, z, channelHandlerArr);
    }

    public void checkException() {
        checkException(voidPromise());
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        this(null, channelId, z, z2, channelHandlerArr);
    }

    public EmbeddedChannel(Channel channel, ChannelId channelId, boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        super(channel, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.embedded.EmbeddedChannel.1
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                EmbeddedChannel.this.recordException(channelFuture);
            }
        };
        this.metadata = metadata(z2);
        this.config = new DefaultChannelConfig(this);
        setup(z, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, ChannelConfig channelConfig, ChannelHandler... channelHandlerArr) {
        super(null, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.embedded.EmbeddedChannel.1
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                EmbeddedChannel.this.recordException(channelFuture);
            }
        };
        this.metadata = metadata(z);
        this.config = (ChannelConfig) ObjectUtil.checkNotNull(channelConfig, "config");
        setup(true, channelHandlerArr);
    }
}
