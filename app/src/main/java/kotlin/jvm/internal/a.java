package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes4.dex */
final class a<T> implements Iterator<T>, kotlin.jvm.internal.r.a {

    /* renamed from: c  reason: collision with root package name */
    private int f16343c;

    /* renamed from: d  reason: collision with root package name */
    private final T[] f16344d;

    public a(T[] array) {
        j.e(array, "array");
        this.f16344d = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16343c < this.f16344d.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f16344d;
            int i = this.f16343c;
            this.f16343c = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16343c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
