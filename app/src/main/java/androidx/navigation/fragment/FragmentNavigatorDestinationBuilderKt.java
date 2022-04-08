package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.p;

/* compiled from: FragmentNavigatorDestinationBuilder.kt */
/* loaded from: classes.dex */
public final class FragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder fragment, @IdRes int i, l<? super FragmentNavigatorDestinationBuilder, p> builder) {
        j.f(fragment, "$this$fragment");
        j.f(builder, "builder");
        Navigator navigator = fragment.getProvider().getNavigator(FragmentNavigator.class);
        j.b(navigator, "getNavigator(clazz.java)");
        j.j(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, m.b(Fragment.class));
        builder.invoke(fragmentNavigatorDestinationBuilder);
        fragment.destination(fragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder fragment, @IdRes int i) {
        j.f(fragment, "$this$fragment");
        Navigator navigator = fragment.getProvider().getNavigator(FragmentNavigator.class);
        j.b(navigator, "getNavigator(clazz.java)");
        j.j(4, "F");
        fragment.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, m.b(Fragment.class)));
    }
}
