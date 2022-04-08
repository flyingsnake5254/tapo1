package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$1 extends Lambda implements l<Animator, p> {
    public static final AnimatorKt$addListener$1 INSTANCE = new AnimatorKt$addListener$1();

    public AnimatorKt$addListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ p invoke(Animator animator) {
        invoke2(animator);
        return p.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Animator it) {
        j.f(it, "it");
    }
}
