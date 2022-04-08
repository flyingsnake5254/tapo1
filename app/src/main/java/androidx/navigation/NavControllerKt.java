package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: NavController.kt */
/* loaded from: classes.dex */
public final class NavControllerKt {
    public static final NavGraph createGraph(NavController createGraph, @IdRes int i, @IdRes int i2, l<? super NavGraphBuilder, p> builder) {
        j.f(createGraph, "$this$createGraph");
        j.f(builder, "builder");
        NavigatorProvider navigatorProvider = createGraph.getNavigatorProvider();
        j.b(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController createGraph, int i, int i2, l builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        j.f(createGraph, "$this$createGraph");
        j.f(builder, "builder");
        NavigatorProvider navigatorProvider = createGraph.getNavigatorProvider();
        j.b(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
