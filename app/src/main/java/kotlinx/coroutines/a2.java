package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* compiled from: Unconfined.kt */
/* loaded from: classes4.dex */
public final class a2 extends y {

    /* renamed from: c  reason: collision with root package name */
    public static final a2 f16419c = new a2();

    private a2() {
    }

    @Override // kotlinx.coroutines.y
    public void dispatch(f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        throw new UnsupportedOperationException();
    }

    @Override // kotlinx.coroutines.y
    public boolean isDispatchNeeded(f context) {
        j.f(context, "context");
        return false;
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        return "Unconfined";
    }
}
