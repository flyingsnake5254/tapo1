package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt$addListener$5 extends Lambda implements l<Transition, p> {
    public static final TransitionKt$addListener$5 INSTANCE = new TransitionKt$addListener$5();

    public TransitionKt$addListener$5() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ p invoke(Transition transition) {
        invoke2(transition);
        return p.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Transition it) {
        j.f(it, "it");
    }
}
