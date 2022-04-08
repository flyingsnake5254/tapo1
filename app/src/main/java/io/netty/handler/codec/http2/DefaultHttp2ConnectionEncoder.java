package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CoalescingBufferQueue;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes3.dex */
public class DefaultHttp2ConnectionEncoder implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer {
    private final Http2Connection connection;
    private final Http2FrameWriter frameWriter;
    private Http2LifecycleManager lifecycleManager;
    private final Queue<Http2Settings> outstandingLocalSettingsQueue = new ArrayDeque(4);
    private Queue<Http2Settings> outstandingRemoteSettingsQueue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public abstract class FlowControlledBase implements Http2RemoteFlowController.FlowControlled, ChannelFutureListener {
        protected boolean endOfStream;
        protected int padding;
        protected ChannelPromise promise;
        protected final Http2Stream stream;

        FlowControlledBase(Http2Stream http2Stream, int i, boolean z, ChannelPromise channelPromise) {
            ObjectUtil.checkPositiveOrZero(i, "padding");
            this.padding = i;
            this.endOfStream = z;
            this.stream = http2Stream;
            this.promise = channelPromise;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void writeComplete() {
            if (this.endOfStream) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.closeStreamLocal(this.stream, this.promise);
            }
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (!channelFuture.isSuccess()) {
                error(DefaultHttp2ConnectionEncoder.this.flowController().channelHandlerContext(), channelFuture.cause());
            }
        }
    }

    /* loaded from: classes3.dex */
    private final class FlowControlledData extends FlowControlledBase {
        private int dataSize;
        private final CoalescingBufferQueue queue;

        FlowControlledData(Http2Stream http2Stream, ByteBuf byteBuf, int i, boolean z, ChannelPromise channelPromise) {
            super(http2Stream, i, z, channelPromise);
            CoalescingBufferQueue coalescingBufferQueue = new CoalescingBufferQueue(channelPromise.channel());
            this.queue = coalescingBufferQueue;
            coalescingBufferQueue.add(byteBuf, channelPromise);
            this.dataSize = coalescingBufferQueue.readableBytes();
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            this.queue.releaseAndFailAll(th);
            DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            if (FlowControlledData.class != flowControlled.getClass()) {
                return false;
            }
            FlowControlledData flowControlledData = (FlowControlledData) flowControlled;
            if (Integer.MAX_VALUE - flowControlledData.size() < size()) {
                return false;
            }
            flowControlledData.queue.copyTo(this.queue);
            this.dataSize = this.queue.readableBytes();
            this.padding = Math.max(this.padding, flowControlledData.padding);
            this.endOfStream = flowControlledData.endOfStream;
            return true;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return this.dataSize + this.padding;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v11, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference failed for: r9v0, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Unknown variable types count: 2 */
        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void write(io.netty.channel.ChannelHandlerContext r11, int r12) {
            /*
                r10 = this;
                io.netty.channel.CoalescingBufferQueue r0 = r10.queue
                int r0 = r0.readableBytes()
                boolean r1 = r10.endOfStream
                r2 = 0
                if (r1 != 0) goto L_0x002f
                if (r0 != 0) goto L_0x002c
                io.netty.channel.CoalescingBufferQueue r12 = r10.queue
                boolean r12 = r12.isEmpty()
                if (r12 == 0) goto L_0x001a
                r10.dataSize = r2
                r10.padding = r2
                goto L_0x002b
            L_0x001a:
                io.netty.channel.ChannelPromise r12 = r11.newPromise()
                io.netty.channel.ChannelPromise r12 = r12.addListener(r10)
                io.netty.channel.CoalescingBufferQueue r0 = r10.queue
                io.netty.buffer.ByteBuf r0 = r0.remove(r2, r12)
                r11.write(r0, r12)
            L_0x002b:
                return
            L_0x002c:
                if (r12 != 0) goto L_0x002f
                return
            L_0x002f:
                int r0 = java.lang.Math.min(r0, r12)
                io.netty.channel.ChannelPromise r1 = r11.newPromise()
                io.netty.channel.ChannelPromise r9 = r1.addListener(r10)
                io.netty.channel.CoalescingBufferQueue r1 = r10.queue
                io.netty.buffer.ByteBuf r6 = r1.remove(r0, r9)
                io.netty.channel.CoalescingBufferQueue r1 = r10.queue
                int r1 = r1.readableBytes()
                r10.dataSize = r1
                int r12 = r12 - r0
                int r0 = r10.padding
                int r7 = java.lang.Math.min(r12, r0)
                int r12 = r10.padding
                int r12 = r12 - r7
                r10.padding = r12
                io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder r12 = io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.this
                io.netty.handler.codec.http2.Http2FrameWriter r3 = r12.frameWriter()
                io.netty.handler.codec.http2.Http2Stream r12 = r10.stream
                int r5 = r12.id()
                boolean r12 = r10.endOfStream
                if (r12 == 0) goto L_0x006e
                int r12 = r10.size()
                if (r12 != 0) goto L_0x006e
                r2 = 1
                r8 = 1
                goto L_0x006f
            L_0x006e:
                r8 = 0
            L_0x006f:
                r4 = r11
                r3.writeData(r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.FlowControlledData.write(io.netty.channel.ChannelHandlerContext, int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class FlowControlledHeaders extends FlowControlledBase {
        private final boolean exclusive;
        private final boolean hasPriorty;
        private final Http2Headers headers;
        private final int streamDependency;
        private final short weight;

        FlowControlledHeaders(Http2Stream http2Stream, Http2Headers http2Headers, boolean z, int i, short s, boolean z2, int i2, boolean z3, ChannelPromise channelPromise) {
            super(http2Stream, i2, z3, channelPromise.unvoid());
            this.headers = http2Headers;
            this.hasPriorty = z;
            this.streamDependency = i;
            this.weight = s;
            this.exclusive = z2;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            if (channelHandlerContext != null) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th);
            }
            this.promise.tryFailure(th);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void write(ChannelHandlerContext channelHandlerContext, int i) {
            boolean validateHeadersSentState = DefaultHttp2ConnectionEncoder.validateHeadersSentState(this.stream, this.headers, DefaultHttp2ConnectionEncoder.this.connection.isServer(), this.endOfStream);
            this.promise.addListener((GenericFutureListener<? extends Future<? super Void>>) this);
            if (DefaultHttp2ConnectionEncoder.sendHeaders(DefaultHttp2ConnectionEncoder.this.frameWriter, channelHandlerContext, this.stream.id(), this.headers, this.hasPriorty, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise).cause() == null) {
                this.stream.headersSent(validateHeadersSentState);
            }
        }
    }

    public DefaultHttp2ConnectionEncoder(Http2Connection http2Connection, Http2FrameWriter http2FrameWriter) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        if (http2Connection.remote().flowController() == null) {
            http2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(http2Connection));
        }
    }

    private void notifyLifecycleManagerOnError(ChannelFuture channelFuture, final ChannelHandlerContext channelHandlerContext) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.1
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                Throwable cause = channelFuture2.cause();
                if (cause != null) {
                    DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, cause);
                }
            }
        });
    }

    private Http2Stream requireStream(int i) {
        String str;
        Http2Stream stream = this.connection.stream(i);
        if (stream != null) {
            return stream;
        }
        if (this.connection.streamMayHaveExisted(i)) {
            str = "Stream no longer exists: " + i;
        } else {
            str = "Stream does not exist: " + i;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChannelFuture sendHeaders(Http2FrameWriter http2FrameWriter, ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, boolean z, int i2, short s, boolean z2, int i3, boolean z3, ChannelPromise channelPromise) {
        if (z) {
            return http2FrameWriter.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z2, i3, z3, channelPromise);
        }
        return http2FrameWriter.writeHeaders(channelHandlerContext, i, http2Headers, i3, z3, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateHeadersSentState(Http2Stream http2Stream, Http2Headers http2Headers, boolean z, boolean z2) {
        boolean z3 = z && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
        if (((!z3 && z2) || !http2Stream.isHeadersSent()) && !http2Stream.isTrailersSent()) {
            return z3;
        }
        throw new IllegalStateException("Stream " + http2Stream.id() + " sent too many headers EOS: " + z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private ChannelFuture writeHeaders0(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, boolean z, int i2, short s, boolean z2, int i3, boolean z3, ChannelPromise channelPromise) {
        int i4;
        Throwable th;
        Http2Stream stream;
        boolean validateHeadersSentState;
        ChannelFuture sendHeaders;
        Throwable cause;
        Http2Stream http2Stream;
        ChannelPromise channelPromise2 = channelPromise;
        try {
            stream = this.connection.stream(i);
            if (stream == null) {
                try {
                    stream = this.connection.local().createStream(i, false);
                } catch (Http2Exception e2) {
                    if (this.connection.remote().mayHaveCreatedStream(i)) {
                        channelPromise2.tryFailure(new IllegalStateException("Stream no longer exists: " + i, e2));
                        return channelPromise2;
                    }
                    throw e2;
                }
            } else {
                int i5 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                if (!(i5 == 1 || i5 == 2)) {
                    if (i5 == 3) {
                        stream.open(z3);
                    } else {
                        throw new IllegalStateException("Stream " + stream.id() + " in unexpected state " + stream.state());
                    }
                }
            }
            Http2RemoteFlowController flowController = flowController();
            if (z3) {
                try {
                    if (flowController.hasFlowControlled(stream)) {
                        flowController.addFlowControlled(stream, new FlowControlledHeaders(stream, http2Headers, z, i2, s, z2, i3, true, channelPromise));
                        return channelPromise2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i4 = channelHandlerContext;
                    this.lifecycleManager.onError(i4, true, th);
                    channelPromise2.tryFailure(th);
                    return channelPromise2;
                }
            }
            channelPromise2 = channelPromise.unvoid();
            validateHeadersSentState = validateHeadersSentState(stream, http2Headers, this.connection.isServer(), z3);
            i4 = i;
            sendHeaders = sendHeaders(this.frameWriter, channelHandlerContext, i4, http2Headers, z, i2, s, z2, i3, z3, channelPromise2);
            cause = sendHeaders.cause();
        } catch (Throwable th3) {
            th = th3;
            i4 = channelHandlerContext;
        }
        try {
            if (cause == null) {
                stream.headersSent(validateHeadersSentState);
                if (!sendHeaders.isSuccess()) {
                    ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                    http2Stream = stream;
                    notifyLifecycleManagerOnError(sendHeaders, channelHandlerContext2);
                    i4 = channelHandlerContext2;
                } else {
                    i4 = channelHandlerContext;
                    http2Stream = stream;
                }
            } else {
                ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                http2Stream = stream;
                this.lifecycleManager.onError(channelHandlerContext3, true, cause);
                i4 = channelHandlerContext3;
            }
            if (z3) {
                this.lifecycleManager.closeStreamLocal(http2Stream, sendHeaders);
            }
            return sendHeaders;
        } catch (Throwable th4) {
            th = th4;
            this.lifecycleManager.onError(i4, true, th);
            channelPromise2.tryFailure(th);
            return channelPromise2;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameWriter.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.frameWriter.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsReceivedConsumer
    public void consumeReceivedSettings(Http2Settings http2Settings) {
        if (this.outstandingRemoteSettingsQueue == null) {
            this.outstandingRemoteSettingsQueue = new ArrayDeque(2);
        }
        this.outstandingRemoteSettingsQueue.add(http2Settings);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public final Http2RemoteFlowController flowController() {
        return connection().remote().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2FrameWriter frameWriter() {
        return this.frameWriter;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Settings pollSentSettings() {
        return this.outstandingLocalSettingsQueue.poll();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        Boolean pushEnabled = http2Settings.pushEnabled();
        Http2FrameWriter.Configuration configuration = configuration();
        Http2HeadersEncoder.Configuration headersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        if (pushEnabled != null) {
            if (this.connection.isServer() || !pushEnabled.booleanValue()) {
                this.connection.remote().allowPushTo(pushEnabled.booleanValue());
            } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client received a value of ENABLE_PUSH specified to other than 0", new Object[0]);
            }
        }
        Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
        if (maxConcurrentStreams != null) {
            this.connection.local().maxActiveStreams((int) Math.min(maxConcurrentStreams.longValue(), 2147483647L));
        }
        Long headerTableSize = http2Settings.headerTableSize();
        if (headerTableSize != null) {
            headersConfiguration.maxHeaderTableSize((int) Math.min(headerTableSize.longValue(), 2147483647L));
        }
        Long maxHeaderListSize = http2Settings.maxHeaderListSize();
        if (maxHeaderListSize != null) {
            headersConfiguration.maxHeaderListSize(maxHeaderListSize.longValue());
        }
        Integer maxFrameSize = http2Settings.maxFrameSize();
        if (maxFrameSize != null) {
            frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
        }
        Integer initialWindowSize = http2Settings.initialWindowSize();
        if (initialWindowSize != null) {
            flowController().initialWindowSize(initialWindowSize.intValue());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        try {
            Http2Stream requireStream = requireStream(i);
            int i3 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[requireStream.state().ordinal()];
            if (!(i3 == 1 || i3 == 2)) {
                throw new IllegalStateException("Stream " + requireStream.id() + " in unexpected state " + requireStream.state());
            }
            flowController().addFlowControlled(requireStream, new FlowControlledData(requireStream, byteBuf, i2, z, channelPromise));
            return channelPromise;
        } catch (Throwable th) {
            byteBuf.release();
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b2, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.frameWriter.writeFrame(channelHandlerContext, b2, i, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.lifecycleManager.goAway(channelHandlerContext, i, j, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i, http2Headers, false, 0, (short) 0, false, i2, z, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
        return this.frameWriter.writePing(channelHandlerContext, z, j, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z, ChannelPromise channelPromise) {
        return this.frameWriter.writePriority(channelHandlerContext, i, i2, s, z, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3, ChannelPromise channelPromise) {
        ChannelPromise channelPromise2;
        Throwable th;
        try {
            if (!this.connection.goAwayReceived()) {
                Http2Stream requireStream = requireStream(i);
                this.connection.local().reservePushStream(i2, requireStream);
                channelPromise2 = channelPromise.unvoid();
                try {
                    ChannelFuture writePushPromise = this.frameWriter.writePushPromise(channelHandlerContext, i, i2, http2Headers, i3, channelPromise2);
                    Throwable cause = writePushPromise.cause();
                    if (cause == null) {
                        requireStream.pushPromiseSent();
                        if (!writePushPromise.isSuccess()) {
                            notifyLifecycleManagerOnError(writePushPromise, channelHandlerContext);
                        }
                    } else {
                        this.lifecycleManager.onError(channelHandlerContext, true, cause);
                    }
                    return writePushPromise;
                } catch (Throwable th2) {
                    th = th2;
                    this.lifecycleManager.onError(channelHandlerContext, true, th);
                    channelPromise2.tryFailure(th);
                    return channelPromise2;
                }
            } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Sending PUSH_PROMISE after GO_AWAY received.", new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            channelPromise2 = channelPromise;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        return this.lifecycleManager.resetStream(channelHandlerContext, i, j, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        this.outstandingLocalSettingsQueue.add(http2Settings);
        try {
            if (http2Settings.pushEnabled() != null && this.connection.isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
            }
            return this.frameWriter.writeSettings(channelHandlerContext, http2Settings, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        Queue<Http2Settings> queue = this.outstandingRemoteSettingsQueue;
        if (queue == null) {
            return this.frameWriter.writeSettingsAck(channelHandlerContext, channelPromise);
        }
        Http2Settings poll = queue.poll();
        if (poll == null) {
            return channelPromise.setFailure((Throwable) new Http2Exception(Http2Error.INTERNAL_ERROR, "attempted to write a SETTINGS ACK with no  pending SETTINGS"));
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        this.frameWriter.writeSettingsAck(channelHandlerContext, simpleChannelPromiseAggregator.newPromise());
        ChannelPromise newPromise = simpleChannelPromiseAggregator.newPromise();
        try {
            remoteSettings(poll);
            newPromise.setSuccess();
        } catch (Throwable th) {
            newPromise.setFailure(th);
            this.lifecycleManager.onError(channelHandlerContext, true, th);
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
        return channelPromise.setFailure((Throwable) new UnsupportedOperationException("Use the Http2[Inbound|Outbound]FlowController objects to control window sizes"));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i, http2Headers, true, i2, s, z, i3, z2, channelPromise);
    }
}
