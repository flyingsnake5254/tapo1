package io.netty.util.internal;

/* loaded from: classes3.dex */
public interface LongCounter {
    void add(long j);

    void decrement();

    void increment();

    long value();
}
