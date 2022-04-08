package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.n;
import com.google.common.base.o;
import java.util.Iterator;

/* compiled from: FluentIterable.java */
/* loaded from: classes2.dex */
public abstract class m0<E> implements Iterable<E> {

    /* renamed from: c  reason: collision with root package name */
    private final Optional<Iterable<E>> f4535c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FluentIterable.java */
    /* loaded from: classes2.dex */
    public static class a extends m0<E> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterable f4536d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f4536d = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f4536d.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FluentIterable.java */
    /* loaded from: classes2.dex */
    public static class b extends m0<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterable[] f4537d;

        /* compiled from: FluentIterable.java */
        /* loaded from: classes2.dex */
        class a extends b<Iterator<? extends T>> {
            a(int i) {
                super(i);
            }

            /* renamed from: b */
            public Iterator<? extends T> a(int i) {
                return b.this.f4537d[i].iterator();
            }
        }

        b(Iterable[] iterableArr) {
            this.f4537d = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return k1.e(new a(this.f4537d.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m0() {
        this.f4535c = Optional.absent();
    }

    public static <T> m0<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    private static <T> m0<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            n.o(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> m0<E> d(Iterable<E> iterable) {
        return iterable instanceof m0 ? (m0) iterable : new a(iterable, iterable);
    }

    private Iterable<E> e() {
        return this.f4535c.or((Optional<Iterable<E>>) this);
    }

    public final m0<E> c(o<? super E> oVar) {
        return d(j1.d(e(), oVar));
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return j1.n(e());
    }

    m0(Iterable<E> iterable) {
        n.o(iterable);
        this.f4535c = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
