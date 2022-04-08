package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.internal.j;

/* compiled from: NavController.kt */
/* loaded from: classes.dex */
public final class NavControllerKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    public static final boolean navigateUp(NavController navigateUp, Openable openable) {
        j.f(navigateUp, "$this$navigateUp");
        NavGraph graph = navigateUp.getGraph();
        j.b(graph, "graph");
        AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(openable);
        if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
            appBarConfigurationKt$AppBarConfiguration$1 = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
        }
        AppBarConfiguration build = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) appBarConfigurationKt$AppBarConfiguration$1).build();
        j.b(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return NavigationUI.navigateUp(navigateUp, build);
    }

    public static final boolean navigateUp(NavController navigateUp, AppBarConfiguration appBarConfiguration) {
        j.f(navigateUp, "$this$navigateUp");
        j.f(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navigateUp, appBarConfiguration);
    }
}
