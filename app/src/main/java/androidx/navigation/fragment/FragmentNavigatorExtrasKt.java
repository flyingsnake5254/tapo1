package androidx.navigation.fragment;

import android.view.View;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Pair;
import kotlin.jvm.internal.j;

/* compiled from: FragmentNavigatorExtras.kt */
/* loaded from: classes.dex */
public final class FragmentNavigatorExtrasKt {
    public static final FragmentNavigator.Extras FragmentNavigatorExtras(Pair<? extends View, String>... sharedElements) {
        j.f(sharedElements, "sharedElements");
        FragmentNavigator.Extras.Builder builder = new FragmentNavigator.Extras.Builder();
        for (Pair<? extends View, String> pair : sharedElements) {
            builder.addSharedElement((View) pair.component1(), pair.component2());
        }
        FragmentNavigator.Extras build = builder.build();
        j.b(build, "FragmentNavigator.Extras…      }\n        }.build()");
        return build;
    }
}
