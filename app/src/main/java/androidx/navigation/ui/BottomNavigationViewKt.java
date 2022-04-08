package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.jvm.internal.j;

/* compiled from: BottomNavigationView.kt */
/* loaded from: classes.dex */
public final class BottomNavigationViewKt {
    public static final void setupWithNavController(BottomNavigationView setupWithNavController, NavController navController) {
        j.f(setupWithNavController, "$this$setupWithNavController");
        j.f(navController, "navController");
        NavigationUI.setupWithNavController(setupWithNavController, navController);
    }
}
