package kotlin.v;

import kotlin.jvm.internal.j;

/* compiled from: Ranges.kt */
/* loaded from: classes4.dex */
class f {
    public static final void a(boolean z, Number step) {
        j.e(step, "step");
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
        }
    }
}
