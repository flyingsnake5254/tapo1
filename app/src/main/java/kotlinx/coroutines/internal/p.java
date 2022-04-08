package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public final class p {
    public final i a;

    public p(i ref) {
        j.f(ref, "ref");
        this.a = ref;
    }

    public String toString() {
        return "Removed[" + this.a + ']';
    }
}
