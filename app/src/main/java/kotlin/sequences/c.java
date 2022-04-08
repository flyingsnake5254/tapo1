package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class c<T, K> implements f<T> {
    private final f<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, K> f16361b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(f<? extends T> source, l<? super T, ? extends K> keySelector) {
        j.e(source, "source");
        j.e(keySelector, "keySelector");
        this.a = source;
        this.f16361b = keySelector;
    }

    @Override // kotlin.sequences.f
    public Iterator<T> iterator() {
        return new b(this.a.iterator(), this.f16361b);
    }
}
