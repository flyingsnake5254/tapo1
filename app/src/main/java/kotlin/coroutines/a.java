package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> key) {
        j.e(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        j.e(operation, "operation");
        return (R) f.b.a.a(this, r, operation);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        j.e(key, "key");
        return (E) f.b.a.b(this, key);
    }

    @Override // kotlin.coroutines.f.b
    public f.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        j.e(key, "key");
        return f.b.a.c(this, key);
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        j.e(context, "context");
        return f.b.a.d(this, context);
    }
}
