package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.j;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes4.dex */
public final class a<T> implements f<T> {
    private final AtomicReference<f<T>> a;

    public a(f<? extends T> sequence) {
        j.e(sequence, "sequence");
        this.a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.f
    public Iterator<T> iterator() {
        f<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
