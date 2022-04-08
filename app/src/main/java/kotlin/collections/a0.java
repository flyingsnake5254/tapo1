package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.r.a;

/* compiled from: Iterators.kt */
/* loaded from: classes4.dex */
public abstract class a0 implements Iterator<Long>, a {
    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
