package androidx.core.os;

import kotlin.jvm.b.a;

/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ a $action;

    public HandlerKt$postDelayed$runnable$1(a aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
