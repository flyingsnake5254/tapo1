package io.netty.handler.codec.redis;

/* loaded from: classes3.dex */
public class BulkStringHeaderRedisMessage implements a {
    private final int bulkStringLength;

    public BulkStringHeaderRedisMessage(int i) {
        if (i > 0) {
            this.bulkStringLength = i;
            return;
        }
        throw new RedisCodecException("bulkStringLength: " + i + " (expected: > 0)");
    }

    public final int bulkStringLength() {
        return this.bulkStringLength;
    }

    public boolean isNull() {
        return this.bulkStringLength == -1;
    }
}
