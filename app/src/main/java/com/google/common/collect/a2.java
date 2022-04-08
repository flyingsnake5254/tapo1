package com.google.common.collect;

import com.google.common.base.h;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Ordering.java */
/* loaded from: classes2.dex */
public abstract class a2<T> implements Comparator<T> {
    public static <T> a2<T> a(Comparator<T> comparator) {
        return comparator instanceof a2 ? (a2) comparator : new b0(comparator);
    }

    public static <C extends Comparable> a2<C> g() {
        return w1.f4636c;
    }

    public <E extends T> ImmutableList<E> b(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E d(@NullableDecl E e2, @NullableDecl E e3) {
        return compare(e2, e3) >= 0 ? e2 : e3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E f(@NullableDecl E e2, @NullableDecl E e3) {
        return compare(e2, e3) <= 0 ? e2 : e3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T2 extends T> a2<Map.Entry<T2, ?>> h() {
        return (a2<Map.Entry<T2, ?>>) i(q1.k());
    }

    public <F> a2<F> i(h<F, ? extends T> hVar) {
        return new u(hVar, this);
    }

    public <S extends T> a2<S> j() {
        return new q2(this);
    }
}
