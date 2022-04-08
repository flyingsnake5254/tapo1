package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import kotlin.jvm.internal.j;

/* compiled from: MenuItem.kt */
/* loaded from: classes.dex */
public final class MenuItemKt {
    public static final boolean onNavDestinationSelected(MenuItem onNavDestinationSelected, NavController navController) {
        j.f(onNavDestinationSelected, "$this$onNavDestinationSelected");
        j.f(navController, "navController");
        return NavigationUI.onNavDestinationSelected(onNavDestinationSelected, navController);
    }
}
