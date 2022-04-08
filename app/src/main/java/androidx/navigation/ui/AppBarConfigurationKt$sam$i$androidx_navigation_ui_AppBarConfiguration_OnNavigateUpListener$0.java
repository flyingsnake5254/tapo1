package androidx.navigation.ui;

import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

/* compiled from: AppBarConfiguration.kt */
/* loaded from: classes.dex */
public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener {
    private final /* synthetic */ a function;

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(a aVar) {
        this.function = aVar;
    }

    @Override // androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        Object invoke = this.function.invoke();
        j.b(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
