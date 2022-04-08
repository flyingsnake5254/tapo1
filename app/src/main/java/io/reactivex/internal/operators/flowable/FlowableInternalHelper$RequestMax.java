package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.g;

/* loaded from: classes4.dex */
public enum FlowableInternalHelper$RequestMax implements g<c> {
    INSTANCE;

    public void accept(c cVar) throws Exception {
        cVar.request(Long.MAX_VALUE);
    }
}
