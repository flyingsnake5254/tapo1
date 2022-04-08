package androidx.navigation;

import android.app.Activity;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: ActivityNavArgsLazy.kt */
/* loaded from: classes.dex */
public final class ActivityNavArgsLazyKt {
    @MainThread
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Activity navArgs) {
        j.f(navArgs, "$this$navArgs");
        j.j(4, "Args");
        return new NavArgsLazy<>(m.b(NavArgs.class), new ActivityNavArgsLazyKt$navArgs$1(navArgs));
    }
}
