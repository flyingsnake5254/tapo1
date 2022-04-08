package io.netty.handler.codec.http2;

import com.github.mikephil.charting.utils.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
public class DefaultHttp2LocalFlowController implements Http2LocalFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final FlowState REDUCED_FLOW_STATE = new FlowState() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.2
        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i) throws Http2Exception {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i) {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f2) {
            throw new UnsupportedOperationException();
        }
    };
    private final Http2Connection connection;
    private ChannelHandlerContext ctx;
    private Http2FrameWriter frameWriter;
    private int initialWindowSize;
    private final Http2Connection.a stateKey;
    private float windowUpdateRatio;

    /* loaded from: classes3.dex */
    private final class AutoRefillState extends DefaultState {
        AutoRefillState(Http2Stream http2Stream, int i) {
            super(http2Stream, i);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            super.receiveFlowControlledFrame(i);
            super.consumeBytes(i);
        }
    }

    /* loaded from: classes3.dex */
    private class DefaultState implements FlowState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean endOfStream;
        private int initialStreamWindowSize;
        private int lowerBound;
        private int processedWindow;
        private final Http2Stream stream;
        private float streamWindowUpdateRatio;
        private int window;

        DefaultState(Http2Stream http2Stream, int i) {
            this.stream = http2Stream;
            window(i);
            this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
        }

        private void returnProcessedBytes(int i) throws Http2Exception {
            int i2 = this.processedWindow;
            if (i2 - i >= this.window) {
                this.processedWindow = i2 - i;
                return;
            }
            throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
        }

        private void writeWindowUpdate() throws Http2Exception {
            int i = this.initialStreamWindowSize - this.processedWindow;
            try {
                incrementFlowControlWindows(i);
                DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i, DefaultHttp2LocalFlowController.this.ctx.newPromise());
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i) throws Http2Exception {
            returnProcessedBytes(i);
            return writeWindowUpdateIfNeeded();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z) {
            this.endOfStream = z;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i) throws Http2Exception {
            if (i <= 0 || this.window <= Integer.MAX_VALUE - i) {
                this.window += i;
                this.processedWindow += i;
                if (i >= 0) {
                    i = 0;
                }
                this.lowerBound = i;
                return;
            }
            throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", Integer.valueOf(this.stream.id()));
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i) {
            int min = (int) Math.min(2147483647L, Math.max(0L, this.initialStreamWindowSize + i));
            int i2 = this.initialStreamWindowSize;
            this.initialStreamWindowSize = i2 + (min - i2);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return this.initialStreamWindowSize;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            int i2 = this.window - i;
            this.window = i2;
            if (i2 < this.lowerBound) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return this.processedWindow - this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i) {
            this.initialStreamWindowSize = i;
            this.processedWindow = i;
            this.window = i;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            return this.streamWindowUpdateRatio;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            if (!this.endOfStream && this.initialStreamWindowSize > 0 && !DefaultHttp2LocalFlowController.isClosed(this.stream)) {
                if (this.processedWindow <= ((int) (this.initialStreamWindowSize * this.streamWindowUpdateRatio))) {
                    writeWindowUpdate();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f2) {
            this.streamWindowUpdateRatio = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface FlowState {
        boolean consumeBytes(int i) throws Http2Exception;

        void endOfStream(boolean z);

        void incrementFlowControlWindows(int i) throws Http2Exception;

        void incrementInitialStreamWindow(int i);

        int initialWindowSize();

        void receiveFlowControlledFrame(int i) throws Http2Exception;

        int unconsumedBytes();

        void window(int i);

        int windowSize();

        float windowUpdateRatio();

        void windowUpdateRatio(float f2);

        boolean writeWindowUpdateIfNeeded() throws Http2Exception;
    }

    /* loaded from: classes3.dex */
    private final class WindowUpdateVisitor implements Http2StreamVisitor {
        private Http2Exception.CompositeStreamException compositeException;
        private final int delta;

        WindowUpdateVisitor(int i) {
            this.delta = i;
        }

        public void throwIfError() throws Http2Exception.CompositeStreamException {
            Http2Exception.CompositeStreamException compositeStreamException = this.compositeException;
            if (compositeStreamException != null) {
                throw compositeStreamException;
            }
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            try {
                FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                state.incrementFlowControlWindows(this.delta);
                state.incrementInitialStreamWindow(this.delta);
                return true;
            } catch (Http2Exception.StreamException e2) {
                if (this.compositeException == null) {
                    this.compositeException = new Http2Exception.CompositeStreamException(e2.error(), 4);
                }
                this.compositeException.add(e2);
                return true;
            }
        }
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection) {
        this(http2Connection, 0.5f, false);
    }

    private static void checkValidRatio(float f2) {
        double d2 = f2;
        if (Double.compare(d2, Utils.DOUBLE_EPSILON) <= 0 || Double.compare(d2, 1.0d) >= 0) {
            throw new IllegalArgumentException("Invalid ratio: " + f2);
        }
    }

    private FlowState connectionState() {
        return (FlowState) this.connection.connectionStream().getProperty(this.stateKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean consumeAllBytes(FlowState flowState, int i) throws Http2Exception {
        return flowState.consumeBytes(i) | connectionState().consumeBytes(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isClosed(Http2Stream http2Stream) {
        return http2Stream.state() == Http2Stream.State.CLOSED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public boolean consumeBytes(Http2Stream http2Stream, int i) throws Http2Exception {
        ObjectUtil.checkPositiveOrZero(i, "numBytes");
        if (i == 0 || http2Stream == null || isClosed(http2Stream)) {
            return false;
        }
        if (http2Stream.id() != 0) {
            return consumeAllBytes(state(http2Stream), i);
        }
        throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i) throws Http2Exception {
        FlowState state = state(http2Stream);
        state.incrementInitialStreamWindow(i);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i) throws Http2Exception {
        this.initialWindowSize = i;
        WindowUpdateVisitor windowUpdateVisitor = new WindowUpdateVisitor(i - this.initialWindowSize);
        this.connection.forEachActiveStream(windowUpdateVisitor);
        windowUpdateVisitor.throwIfError();
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i, boolean z) throws Http2Exception {
        int readableBytes = byteBuf.readableBytes() + i;
        FlowState connectionState = connectionState();
        connectionState.receiveFlowControlledFrame(readableBytes);
        if (http2Stream != null && !isClosed(http2Stream)) {
            FlowState state = state(http2Stream);
            state.endOfStream(z);
            state.receiveFlowControlledFrame(readableBytes);
        } else if (readableBytes > 0) {
            connectionState.consumeBytes(readableBytes);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int unconsumedBytes(Http2Stream http2Stream) {
        return state(http2Stream).unconsumedBytes();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public void windowUpdateRatio(float f2) {
        checkValidRatio(f2);
        this.windowUpdateRatio = f2;
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection, float f2, boolean z) {
        Object obj;
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        windowUpdateRatio(f2);
        Http2Connection.a newKey = http2Connection.newKey();
        this.stateKey = newKey;
        if (z) {
            obj = new AutoRefillState(http2Connection.connectionStream(), this.initialWindowSize);
        } else {
            obj = new DefaultState(http2Connection.connectionStream(), this.initialWindowSize);
        }
        http2Connection.connectionStream().setProperty(newKey, obj);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                Http2Connection.a aVar = DefaultHttp2LocalFlowController.this.stateKey;
                DefaultHttp2LocalFlowController defaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
                http2Stream.setProperty(aVar, new DefaultState(http2Stream, defaultHttp2LocalFlowController.initialWindowSize));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                try {
                    try {
                        FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                        int unconsumedBytes = state.unconsumedBytes();
                        if (DefaultHttp2LocalFlowController.this.ctx != null && unconsumedBytes > 0 && DefaultHttp2LocalFlowController.this.consumeAllBytes(state, unconsumedBytes)) {
                            DefaultHttp2LocalFlowController.this.ctx.flush();
                        }
                    } catch (Http2Exception e2) {
                        PlatformDependent.throwException(e2);
                    }
                } finally {
                    http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
                }
            }
        });
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    public float windowUpdateRatio() {
        return this.windowUpdateRatio;
    }

    public void windowUpdateRatio(Http2Stream http2Stream, float f2) throws Http2Exception {
        checkValidRatio(f2);
        FlowState state = state(http2Stream);
        state.windowUpdateRatio(f2);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int initialWindowSize(Http2Stream http2Stream) {
        return state(http2Stream).initialWindowSize();
    }

    public float windowUpdateRatio(Http2Stream http2Stream) throws Http2Exception {
        return state(http2Stream).windowUpdateRatio();
    }
}
