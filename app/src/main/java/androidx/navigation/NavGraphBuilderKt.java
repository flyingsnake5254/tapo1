package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: NavGraphBuilder.kt */
/* loaded from: classes.dex */
public final class NavGraphBuilderKt {
    public static final NavGraph navigation(NavigatorProvider navigation, @IdRes int i, @IdRes int i2, l<? super NavGraphBuilder, p> builder) {
        j.f(navigation, "$this$navigation");
        j.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigation, int i, int i2, l builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        j.f(navigation, "$this$navigation");
        j.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(NavGraphBuilder navigation, @IdRes int i, @IdRes int i2, l<? super NavGraphBuilder, p> builder) {
        j.f(navigation, "$this$navigation");
        j.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation.getProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        navigation.destination(navGraphBuilder);
    }
}
