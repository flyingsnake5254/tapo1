package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public class DefaultChannelConfig implements ChannelConfig {
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private volatile ByteBufAllocator allocator;
    private volatile boolean autoClose;
    private volatile int autoRead;
    protected final Channel channel;
    private volatile int connectTimeoutMillis;
    private volatile MessageSizeEstimator msgSizeEstimator;
    private volatile boolean pinEventExecutor;
    private volatile RecvByteBufAllocator rcvBufAllocator;
    private volatile WriteBufferWaterMark writeBufferWaterMark;
    private volatile int writeSpinCount;
    private static final MessageSizeEstimator DEFAULT_MSG_SIZE_ESTIMATOR = DefaultMessageSizeEstimator.DEFAULT;
    private static final AtomicIntegerFieldUpdater<DefaultChannelConfig> AUTOREAD_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultChannelConfig.class, "autoRead");
    private static final AtomicReferenceFieldUpdater<DefaultChannelConfig, WriteBufferWaterMark> WATERMARK_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelConfig.class, WriteBufferWaterMark.class, "writeBufferWaterMark");

    public DefaultChannelConfig(Channel channel) {
        this(channel, new AdaptiveRecvByteBufAllocator());
    }

    private boolean getPinEventExecutorPerGroup() {
        return this.pinEventExecutor;
    }

    private ChannelConfig setPinEventExecutorPerGroup(boolean z) {
        this.pinEventExecutor = z;
        return this;
    }

    protected void autoReadCleared() {
    }

    @Override // io.netty.channel.ChannelConfig
    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    public int getMaxMessagesPerRead() {
        try {
            return ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead();
        } catch (ClassCastException e2) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e2);
        }
    }

    @Override // io.netty.channel.ChannelConfig
    public MessageSizeEstimator getMessageSizeEstimator() {
        return this.msgSizeEstimator;
    }

    @Override // io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        ObjectUtil.checkNotNull(channelOption, "option");
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            return (T) Integer.valueOf(getConnectTimeoutMillis());
        }
        if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            return (T) Integer.valueOf(getMaxMessagesPerRead());
        }
        if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            return (T) Integer.valueOf(getWriteSpinCount());
        }
        if (channelOption == ChannelOption.ALLOCATOR) {
            return (T) getAllocator();
        }
        if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            return (T) getRecvByteBufAllocator();
        }
        if (channelOption == ChannelOption.AUTO_READ) {
            return (T) Boolean.valueOf(isAutoRead());
        }
        if (channelOption == ChannelOption.AUTO_CLOSE) {
            return (T) Boolean.valueOf(isAutoClose());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            return (T) Integer.valueOf(getWriteBufferHighWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            return (T) Integer.valueOf(getWriteBufferLowWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            return (T) getWriteBufferWaterMark();
        }
        if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            return (T) getMessageSizeEstimator();
        }
        if (channelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            return (T) Boolean.valueOf(getPinEventExecutorPerGroup());
        }
        return null;
    }

    @Override // io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(null, ChannelOption.CONNECT_TIMEOUT_MILLIS, ChannelOption.MAX_MESSAGES_PER_READ, ChannelOption.WRITE_SPIN_COUNT, ChannelOption.ALLOCATOR, ChannelOption.AUTO_READ, ChannelOption.AUTO_CLOSE, ChannelOption.RCVBUF_ALLOCATOR, ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, ChannelOption.WRITE_BUFFER_WATER_MARK, ChannelOption.MESSAGE_SIZE_ESTIMATOR, ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
    }

    @Override // io.netty.channel.ChannelConfig
    public <T extends RecvByteBufAllocator> T getRecvByteBufAllocator() {
        return (T) this.rcvBufAllocator;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferWaterMark.high();
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferWaterMark.low();
    }

    @Override // io.netty.channel.ChannelConfig
    public WriteBufferWaterMark getWriteBufferWaterMark() {
        return this.writeBufferWaterMark;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean isAutoClose() {
        return this.autoClose;
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean isAutoRead() {
        return this.autoRead == 1;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        this.allocator = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "allocator");
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        this.autoClose = z;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        boolean z2 = true;
        if (AUTOREAD_UPDATER.getAndSet(this, z ? 1 : 0) != 1) {
            z2 = false;
        }
        if (z && !z2) {
            this.channel.read();
        } else if (!z && z2) {
            autoReadCleared();
        }
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int i) {
        ObjectUtil.checkPositiveOrZero(i, "connectTimeoutMillis");
        this.connectTimeoutMillis = i;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int i) {
        try {
            ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead(i);
            return this;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e2);
        }
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        this.msgSizeEstimator = (MessageSizeEstimator) ObjectUtil.checkNotNull(messageSizeEstimator, "estimator");
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            setConnectTimeoutMillis(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            setMaxMessagesPerRead(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            setWriteSpinCount(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.ALLOCATOR) {
            setAllocator((ByteBufAllocator) t);
            return true;
        } else if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            setRecvByteBufAllocator((RecvByteBufAllocator) t);
            return true;
        } else if (channelOption == ChannelOption.AUTO_READ) {
            setAutoRead(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.AUTO_CLOSE) {
            setAutoClose(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            setWriteBufferHighWaterMark(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            setWriteBufferLowWaterMark(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            setWriteBufferWaterMark((WriteBufferWaterMark) t);
            return true;
        } else if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            setMessageSizeEstimator((MessageSizeEstimator) t);
            return true;
        } else if (channelOption != ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            return false;
        } else {
            setPinEventExecutorPerGroup(((Boolean) t).booleanValue());
            return true;
        }
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean setOptions(Map<ChannelOption<?>, ?> map) {
        ObjectUtil.checkNotNull(map, "options");
        boolean z = true;
        for (Map.Entry<ChannelOption<?>, ?> entry : map.entrySet()) {
            if (!setOption(entry.getKey(), entry.getValue())) {
                z = false;
            }
        }
        return z;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        this.rcvBufAllocator = (RecvByteBufAllocator) ObjectUtil.checkNotNull(recvByteBufAllocator, "allocator");
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int i) {
        WriteBufferWaterMark writeBufferWaterMark;
        ObjectUtil.checkPositiveOrZero(i, "writeBufferHighWaterMark");
        do {
            writeBufferWaterMark = this.writeBufferWaterMark;
            if (i < writeBufferWaterMark.low()) {
                throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + writeBufferWaterMark.low() + "): " + i);
            }
        } while (!WATERMARK_UPDATER.compareAndSet(this, writeBufferWaterMark, new WriteBufferWaterMark(writeBufferWaterMark.low(), i, false)));
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int i) {
        WriteBufferWaterMark writeBufferWaterMark;
        ObjectUtil.checkPositiveOrZero(i, "writeBufferLowWaterMark");
        do {
            writeBufferWaterMark = this.writeBufferWaterMark;
            if (i > writeBufferWaterMark.high()) {
                throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + writeBufferWaterMark.high() + "): " + i);
            }
        } while (!WATERMARK_UPDATER.compareAndSet(this, writeBufferWaterMark, new WriteBufferWaterMark(i, writeBufferWaterMark.high(), false)));
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        this.writeBufferWaterMark = (WriteBufferWaterMark) ObjectUtil.checkNotNull(writeBufferWaterMark, "writeBufferWaterMark");
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int i) {
        ObjectUtil.checkPositive(i, "writeSpinCount");
        if (i == Integer.MAX_VALUE) {
            i--;
        }
        this.writeSpinCount = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void validate(ChannelOption<T> channelOption, T t) {
        ((ChannelOption) ObjectUtil.checkNotNull(channelOption, "option")).validate(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultChannelConfig(Channel channel, RecvByteBufAllocator recvByteBufAllocator) {
        this.allocator = ByteBufAllocator.DEFAULT;
        this.msgSizeEstimator = DEFAULT_MSG_SIZE_ESTIMATOR;
        this.connectTimeoutMillis = DEFAULT_CONNECT_TIMEOUT;
        this.writeSpinCount = 16;
        this.autoRead = 1;
        this.autoClose = true;
        this.writeBufferWaterMark = WriteBufferWaterMark.DEFAULT;
        this.pinEventExecutor = true;
        setRecvByteBufAllocator(recvByteBufAllocator, channel.metadata());
        this.channel = channel;
    }

    private void setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator, ChannelMetadata channelMetadata) {
        if (recvByteBufAllocator instanceof MaxMessagesRecvByteBufAllocator) {
            ((MaxMessagesRecvByteBufAllocator) recvByteBufAllocator).maxMessagesPerRead(channelMetadata.defaultMaxMessagesPerRead());
        } else {
            Objects.requireNonNull(recvByteBufAllocator, "allocator");
        }
        setRecvByteBufAllocator(recvByteBufAllocator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<ChannelOption<?>, Object> getOptions(Map<ChannelOption<?>, Object> map, ChannelOption<?>... channelOptionArr) {
        if (map == null) {
            map = new IdentityHashMap<>();
        }
        for (ChannelOption<?> channelOption : channelOptionArr) {
            map.put(channelOption, getOption(channelOption));
        }
        return map;
    }
}