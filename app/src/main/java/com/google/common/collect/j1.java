package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Iterables.java */
/* loaded from: classes2.dex */
public final class j1 {

    /* compiled from: Iterables.java */
    /* loaded from: classes2.dex */
    static class a extends m0<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterable f4485d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ o f4486f;

        a(Iterable iterable, o oVar) {
            this.f4485d = iterable;
            this.f4486f = oVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return k1.k(this.f4485d.iterator(), this.f4486f);
        }
    }

    /* compiled from: Iterables.java */
    /* loaded from: classes2.dex */
    static class b extends m0<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterable f4487d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ h f4488f;

        b(Iterable iterable, h hVar) {
            this.f4487d = iterable;
            this.f4488f = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return k1.x(this.f4487d.iterator(), this.f4488f);
        }
    }

    /* compiled from: Iterables.java */
    /* loaded from: classes2.dex */
    static class c extends m0<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterable f4489d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f4490f;

        /* compiled from: Iterables.java */
        /* loaded from: classes2.dex */
        class a implements Iterator<T> {

            /* renamed from: c  reason: collision with root package name */
            boolean f4491c = true;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Iterator f4492d;

            a(Iterator it) {
                this.f4492d = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4492d.hasNext();
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // java.util.Iterator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public T next() {
                /*
                    r2 = this;
                    java.util.Iterator r0 = r2.f4492d
                    java.lang.Object r0 = r0.next()
                    r1 = 0
                    r2.f4491c = r1
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.j1.c.a.next():java.lang.Object");
            }

            @Override // java.util.Iterator
            public void remove() {
                v.e(!this.f4491c);
                this.f4492d.remove();
            }
        }

        c(Iterable iterable, int i) {
            this.f4489d = iterable;
            this.f4490f = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f4489d;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f4490f), list.size()).iterator();
            }
            Iterator it = iterable.iterator();
            k1.b(it, this.f4490f);
            return new a(it);
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(w.a(iterable));
        }
        return k1.a(collection, ((Iterable) n.o(iterable)).iterator());
    }

    private static <E> Collection<E> b(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : n1.j(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m0.a(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, o<? super T> oVar) {
        n.o(iterable);
        n.o(oVar);
        return new a(iterable, oVar);
    }

    @NullableDecl
    public static <T> T e(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) k1.n(iterable.iterator(), t);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) k1.l(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return (T) h(list);
        }
        throw new NoSuchElementException();
    }

    @NullableDecl
    public static <T> T g(Iterable<? extends T> iterable, @NullableDecl T t) {
        if (iterable instanceof Collection) {
            if (w.a(iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) h(n1.a(iterable));
            }
        }
        return (T) k1.m(iterable.iterator(), t);
    }

    private static <T> T h(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T i(Iterable<T> iterable) {
        return (T) k1.o(iterable.iterator());
    }

    public static boolean j(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> k(Iterable<T> iterable, int i) {
        n.o(iterable);
        n.e(i >= 0, "number to skip cannot be negative");
        return new c(iterable, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] l(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] m(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String n(Iterable<?> iterable) {
        return k1.w(iterable.iterator());
    }

    public static <F, T> Iterable<T> o(Iterable<F> iterable, h<? super F, ? extends T> hVar) {
        n.o(iterable);
        n.o(hVar);
        return new b(iterable, hVar);
    }
}
