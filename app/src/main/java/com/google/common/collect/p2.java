package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

/* compiled from: ReverseNaturalOrdering.java */
/* loaded from: classes2.dex */
final class p2 extends a2<Comparable> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    static final p2 f4584c = new p2();

    private p2() {
    }

    @Override // com.google.common.collect.a2
    public <S extends Comparable> a2<S> j() {
        return a2.g();
    }

    /* renamed from: k */
    public int compare(Comparable comparable, Comparable comparable2) {
        n.o(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    /* renamed from: l */
    public <E extends Comparable> E d(E e2, E e3) {
        return (E) ((Comparable) w1.f4636c.f(e2, e3));
    }

    /* renamed from: m */
    public <E extends Comparable> E f(E e2, E e3) {
        return (E) ((Comparable) w1.f4636c.d(e2, e3));
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
