package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* loaded from: classes3.dex */
public final class IntegerRedisMessage implements a {
    private final long value;

    public IntegerRedisMessage(long j) {
        this.value = j;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[value=" + this.value + ']';
    }

    public long value() {
        return this.value;
    }
}
