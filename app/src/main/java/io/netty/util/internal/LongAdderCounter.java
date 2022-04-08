package io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* loaded from: classes3.dex */
final class LongAdderCounter extends LongAdder implements LongCounter {
    @Override // io.netty.util.internal.LongCounter
    public long value() {
        return longValue();
    }
}
