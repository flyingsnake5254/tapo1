package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* loaded from: classes2.dex */
    static class a implements Iterable<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterable f4111c;

        /* renamed from: com.google.common.base.Optional$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0149a extends b<T> {

            /* renamed from: f  reason: collision with root package name */
            private final Iterator<? extends Optional<? extends T>> f4112f;

            C0149a() {
                this.f4112f = (Iterator) n.o(a.this.f4111c.iterator());
            }

            @Override // com.google.common.base.b
            protected T a() {
                while (this.f4112f.hasNext()) {
                    Optional optional = (Optional) this.f4112f.next();
                    if (optional.isPresent()) {
                        return (T) optional.get();
                    }
                }
                return b();
            }
        }

        a(Iterable iterable) {
            this.f4111c = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0149a();
        }
    }

    public static <T> Optional<T> absent() {
        return a.a();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t) {
        return t == null ? absent() : new q(t);
    }

    public static <T> Optional<T> of(T t) {
        return new q(n.o(t));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        n.o(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(t<? extends T> tVar);

    public abstract T or(T t);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(h<? super T, V> hVar);
}
