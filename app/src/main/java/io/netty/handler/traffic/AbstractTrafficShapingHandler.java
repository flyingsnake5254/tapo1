package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    public static final long DEFAULT_CHECK_INTERVAL = 1000;
    static final long DEFAULT_MAX_SIZE = 4194304;
    public static final long DEFAULT_MAX_TIME = 15000;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final long MINIMAL_WAIT = 10;
    protected volatile long checkInterval;
    protected volatile long maxTime;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    private volatile long readLimit;
    protected TrafficCounter trafficCounter;
    final int userDefinedWritabilityIndex;
    private volatile long writeLimit;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractTrafficShapingHandler.class);
    static final AttributeKey<Boolean> READ_SUSPENDED = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".READ_SUSPENDED");
    static final AttributeKey<Runnable> REOPEN_TASK = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".REOPEN_TASK");

    /* loaded from: classes3.dex */
    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReopenReadTimerTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            Channel channel = this.ctx.channel();
            ChannelConfig config = channel.config();
            if (config.isAutoRead() || !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if (!config.isAutoRead() || AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                            InternalLogger internalLogger = AbstractTrafficShapingHandler.logger;
                            internalLogger.debug("Normal unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                        }
                    } else if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                        InternalLogger internalLogger2 = AbstractTrafficShapingHandler.logger;
                        internalLogger2.debug("Unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
                config.setAutoRead(true);
                channel.read();
            } else {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    InternalLogger internalLogger3 = AbstractTrafficShapingHandler.logger;
                    internalLogger3.debug("Not unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
            }
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                InternalLogger internalLogger4 = AbstractTrafficShapingHandler.logger;
                internalLogger4.debug("Unsuspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j, long j2, long j3, long j4) {
        this.maxTime = DEFAULT_MAX_TIME;
        this.checkInterval = 1000L;
        this.maxWriteDelay = 4000L;
        this.maxWriteSize = 4194304L;
        if (j4 > 0) {
            this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
            this.writeLimit = j;
            this.readLimit = j2;
            this.checkInterval = j3;
            this.maxTime = j4;
            return;
        }
        throw new IllegalArgumentException("maxTime must be positive");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isHandlerActive(ChannelHandlerContext channelHandlerContext) {
        Boolean bool = (Boolean) channelHandlerContext.channel().attr(READ_SUSPENDED).get();
        return bool == null || Boolean.FALSE.equals(bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long calculateSize(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        return -1L;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext, this.trafficCounter.readTimeToWait(calculateSize, this.readLimit, this.maxTime, milliSecondFromNano), milliSecondFromNano);
            if (checkWaitReadTime >= MINIMAL_WAIT) {
                Channel channel = channelHandlerContext.channel();
                ChannelConfig config = channel.config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read suspend: " + checkWaitReadTime + ':' + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext));
                }
                if (config.isAutoRead() && isHandlerActive(channelHandlerContext)) {
                    config.setAutoRead(false);
                    channel.attr(READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attr = channel.attr(REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new ReopenReadTimerTask(channelHandlerContext);
                        attr.set(runnable);
                    }
                    channelHandlerContext.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        }
        informReadOperation(channelHandlerContext, milliSecondFromNano);
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        setUserDefinedWritability(channelHandlerContext, true);
        super.channelRegistered(channelHandlerContext);
    }

    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkWriteSuspend(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        if (j2 > this.maxWriteSize || j > this.maxWriteDelay) {
            setUserDefinedWritability(channelHandlerContext, false);
        }
    }

    public void configure(long j, long j2, long j3) {
        configure(j, j2);
        configure(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doAccounting(TrafficCounter trafficCounter) {
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channel channel = channelHandlerContext.channel();
        AttributeKey<Runnable> attributeKey = REOPEN_TASK;
        if (channel.hasAttr(attributeKey)) {
            channel.attr(attributeKey).set(null);
        }
        super.handlerRemoved(channelHandlerContext);
    }

    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j) {
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        if (isHandlerActive(channelHandlerContext)) {
            channelHandlerContext.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseReadSuspended(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        channel.attr(READ_SUSPENDED).set(Boolean.FALSE);
        channel.config().setAutoRead(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseWriteSuspended(ChannelHandlerContext channelHandlerContext) {
        setUserDefinedWritability(channelHandlerContext, true);
    }

    public void setCheckInterval(long j) {
        this.checkInterval = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(j);
        }
    }

    public void setMaxTimeWait(long j) {
        if (j > 0) {
            this.maxTime = j;
            return;
        }
        throw new IllegalArgumentException("maxTime must be positive");
    }

    public void setMaxWriteDelay(long j) {
        if (j > 0) {
            this.maxWriteDelay = j;
            return;
        }
        throw new IllegalArgumentException("maxWriteDelay must be positive");
    }

    public void setMaxWriteSize(long j) {
        this.maxWriteSize = j;
    }

    public void setReadLimit(long j) {
        this.readLimit = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTrafficCounter(TrafficCounter trafficCounter) {
        this.trafficCounter = trafficCounter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserDefinedWritability(ChannelHandlerContext channelHandlerContext, boolean z) {
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.setUserDefinedWritability(this.userDefinedWritabilityIndex, z);
        }
    }

    public void setWriteLimit(long j) {
        this.writeLimit = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    abstract void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise);

    @Deprecated
    protected void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, ChannelPromise channelPromise) {
        submitWrite(channelHandlerContext, obj, calculateSize(obj), j, TrafficCounter.milliSecondFromNano(), channelPromise);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(290);
        sb.append("TrafficShaping with Write Limit: ");
        sb.append(this.writeLimit);
        sb.append(" Read Limit: ");
        sb.append(this.readLimit);
        sb.append(" CheckInterval: ");
        sb.append(this.checkInterval);
        sb.append(" maxDelay: ");
        sb.append(this.maxWriteDelay);
        sb.append(" maxSize: ");
        sb.append(this.maxWriteSize);
        sb.append(" and Counter: ");
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            sb.append(trafficCounter);
        } else {
            sb.append("none");
        }
        return sb.toString();
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    protected int userDefinedWritabilityIndex() {
        return 1;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, this.writeLimit, this.maxTime, milliSecondFromNano);
            if (writeTimeToWait >= MINIMAL_WAIT) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + ':' + channelHandlerContext.channel().config().isAutoRead() + ':' + isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, milliSecondFromNano, channelPromise);
                return;
            }
        }
        submitWrite(channelHandlerContext, obj, calculateSize, 0L, milliSecondFromNano, channelPromise);
    }

    public void configure(long j, long j2) {
        this.writeLimit = j;
        this.readLimit = j2;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public void configure(long j) {
        this.checkInterval = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(this.checkInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j, long j2, long j3) {
        this(j, j2, j3, DEFAULT_MAX_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j, long j2) {
        this(j, j2, 1000L, DEFAULT_MAX_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler() {
        this(0L, 0L, 1000L, DEFAULT_MAX_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j) {
        this(0L, 0L, j, DEFAULT_MAX_TIME);
    }
}
