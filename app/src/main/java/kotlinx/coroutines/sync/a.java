package kotlinx.coroutines.sync;

import kotlin.jvm.internal.j;

/* compiled from: Mutex.kt */
/* loaded from: classes4.dex */
final class a {
    public final Object a;

    public a(Object locked) {
        j.f(locked, "locked");
        this.a = locked;
    }

    public String toString() {
        return "Empty[" + this.a + ']';
    }
}
