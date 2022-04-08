package io.reactivex.m0;

import io.reactivex.q;
import io.reactivex.v;

/* compiled from: Subject.java */
/* loaded from: classes4.dex */
public abstract class g<T> extends q<T> implements v<T> {
    public abstract boolean j1();

    public abstract boolean k1();

    public final g<T> l1() {
        return this instanceof f ? this : new f(this);
    }
}
