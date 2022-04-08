package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.r.a;

/* compiled from: Iterators.kt */
/* loaded from: classes4.dex */
public abstract class k implements Iterator<Boolean>, a {
    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
