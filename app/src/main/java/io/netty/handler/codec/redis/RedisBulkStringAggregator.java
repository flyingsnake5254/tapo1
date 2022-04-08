package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

/* loaded from: classes3.dex */
public final class RedisBulkStringAggregator extends MessageAggregator<a, BulkStringHeaderRedisMessage, BulkStringRedisContent, FullBulkStringRedisMessage> {
    public RedisBulkStringAggregator() {
        super(536870912);
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object newContinueResponse(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, int i, ChannelPipeline channelPipeline) throws Exception {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FullBulkStringRedisMessage beginAggregation(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, ByteBuf byteBuf) throws Exception {
        return new FullBulkStringRedisMessage(byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAggregated(a aVar) throws Exception {
        return aVar instanceof FullBulkStringRedisMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentLengthInvalid(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, int i) throws Exception {
        return bulkStringHeaderRedisMessage.bulkStringLength() > i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentMessage(a aVar) throws Exception {
        return aVar instanceof BulkStringRedisContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLastContentMessage(BulkStringRedisContent bulkStringRedisContent) throws Exception {
        return bulkStringRedisContent instanceof LastBulkStringRedisContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isStartMessage(a aVar) throws Exception {
        return (aVar instanceof BulkStringHeaderRedisMessage) && !isAggregated(aVar);
    }
}
