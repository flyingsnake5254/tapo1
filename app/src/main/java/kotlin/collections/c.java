package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r.a;

/* compiled from: AbstractIterator.kt */
/* loaded from: classes4.dex */
public abstract class c<T> implements Iterator<T>, a {

    /* renamed from: c  reason: collision with root package name */
    private i0 f16314c = i0.NotReady;

    /* renamed from: d  reason: collision with root package name */
    private T f16315d;

    private final boolean d() {
        this.f16314c = i0.Failed;
        a();
        return this.f16314c == i0.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f16314c = i0.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(T t) {
        this.f16315d = t;
        this.f16314c = i0.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        i0 i0Var = this.f16314c;
        if (i0Var != i0.Failed) {
            int i = b.a[i0Var.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i != 2) {
                return d();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f16314c = i0.NotReady;
            return this.f16315d;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
