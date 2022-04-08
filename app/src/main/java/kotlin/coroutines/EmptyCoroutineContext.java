package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public final class EmptyCoroutineContext implements f, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        j.e(operation, "operation");
        return r;
    }

    @Override // kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        j.e(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        j.e(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        j.e(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
