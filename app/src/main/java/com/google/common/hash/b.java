package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: AbstractHasher.java */
@CanIgnoreReturnValue
/* loaded from: classes2.dex */
abstract class b implements g {
    @Override // com.google.common.hash.g
    public <T> g a(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }
}
