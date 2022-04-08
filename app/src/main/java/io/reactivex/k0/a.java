package io.reactivex.k0;

import io.reactivex.h;
import io.reactivex.k;

/* compiled from: FlowableProcessor.java */
/* loaded from: classes4.dex */
public abstract class a<T> extends h<T> implements k<T>, e.b.a, k {
    public final a<T> M() {
        return this instanceof b ? this : new b(this);
    }
}
