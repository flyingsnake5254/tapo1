package io.netty.util.concurrent;

import io.netty.util.concurrent.ProgressiveFuture;

/* loaded from: classes3.dex */
public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>> extends GenericFutureListener<F> {
    void operationProgressed(F f2, long j, long j2) throws Exception;
}
