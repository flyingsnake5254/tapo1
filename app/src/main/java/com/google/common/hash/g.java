package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: Hasher.java */
@CanIgnoreReturnValue
/* loaded from: classes2.dex */
public interface g extends m {
    <T> g a(T t, Funnel<? super T> funnel);

    e hash();
}
