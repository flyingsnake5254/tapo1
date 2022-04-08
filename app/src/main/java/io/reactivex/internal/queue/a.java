package io.reactivex.internal.queue;

import io.reactivex.h0.b.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes4.dex */
public final class a<T> implements h<T> {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<C0312a<T>> f16155c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<C0312a<T>> f16156d = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: io.reactivex.internal.queue.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0312a<E> extends AtomicReference<C0312a<E>> {

        /* renamed from: c  reason: collision with root package name */
        private E f16157c;

        C0312a() {
        }

        public E a() {
            E b2 = b();
            g(null);
            return b2;
        }

        public E b() {
            return this.f16157c;
        }

        public C0312a<E> d() {
            return get();
        }

        public void f(C0312a<E> aVar) {
            lazySet(aVar);
        }

        public void g(E e2) {
            this.f16157c = e2;
        }

        C0312a(E e2) {
            g(e2);
        }
    }

    public a() {
        C0312a<T> aVar = new C0312a<>();
        d(aVar);
        e(aVar);
    }

    C0312a<T> a() {
        return this.f16156d.get();
    }

    C0312a<T> b() {
        return this.f16156d.get();
    }

    C0312a<T> c() {
        return this.f16155c.get();
    }

    @Override // io.reactivex.h0.b.i
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(C0312a<T> aVar) {
        this.f16156d.lazySet(aVar);
    }

    C0312a<T> e(C0312a<T> aVar) {
        return this.f16155c.getAndSet(aVar);
    }

    @Override // io.reactivex.h0.b.i
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.h0.b.i
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        C0312a<T> aVar = new C0312a<>(t);
        e(aVar).f(aVar);
        return true;
    }

    @Override // io.reactivex.h0.b.h, io.reactivex.h0.b.i
    public T poll() {
        C0312a<T> d2;
        C0312a<T> a = a();
        C0312a<T> d3 = a.d();
        if (d3 != null) {
            T a2 = d3.a();
            d(d3);
            return a2;
        } else if (a == c()) {
            return null;
        } else {
            do {
                d2 = a.d();
            } while (d2 == null);
            T a3 = d2.a();
            d(d2);
            return a3;
        }
    }
}
