package androidx.navigation.fragment;

import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavArgsLazy;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: FragmentNavArgsLazy.kt */
/* loaded from: classes.dex */
public final class FragmentNavArgsLazyKt {
    @MainThread
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Fragment navArgs) {
        j.f(navArgs, "$this$navArgs");
        j.j(4, "Args");
        return new NavArgsLazy<>(m.b(NavArgs.class), new FragmentNavArgsLazyKt$navArgs$1(navArgs));
    }
}
