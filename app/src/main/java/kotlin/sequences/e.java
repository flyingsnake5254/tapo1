package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class e<T> implements f<T> {
    private final kotlin.jvm.b.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, T> f16367b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.r.a {

        /* renamed from: c  reason: collision with root package name */
        private T f16368c;

        /* renamed from: d  reason: collision with root package name */
        private int f16369d = -2;

        a() {
        }

        private final void a() {
            T t;
            if (this.f16369d == -2) {
                t = (T) e.this.a.invoke();
            } else {
                l lVar = e.this.f16367b;
                T t2 = this.f16368c;
                j.c(t2);
                t = (T) lVar.invoke(t2);
            }
            this.f16368c = t;
            this.f16369d = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16369d < 0) {
                a();
            }
            return this.f16369d == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f16369d < 0) {
                a();
            }
            if (this.f16369d != 0) {
                T t = this.f16368c;
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                this.f16369d = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(kotlin.jvm.b.a<? extends T> getInitialValue, l<? super T, ? extends T> getNextValue) {
        j.e(getInitialValue, "getInitialValue");
        j.e(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.f16367b = getNextValue;
    }

    @Override // kotlin.sequences.f
    public Iterator<T> iterator() {
        return new a();
    }
}
