package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class m<T, R> implements f<R> {
    private final f<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, R> f16372b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<R>, kotlin.jvm.internal.r.a {

        /* renamed from: c  reason: collision with root package name */
        private final Iterator<T> f16373c;

        a() {
            this.f16373c = m.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16373c.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) m.this.f16372b.invoke(this.f16373c.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(f<? extends T> sequence, l<? super T, ? extends R> transformer) {
        j.e(sequence, "sequence");
        j.e(transformer, "transformer");
        this.a = sequence;
        this.f16372b = transformer;
    }

    @Override // kotlin.sequences.f
    public Iterator<R> iterator() {
        return new a();
    }
}
