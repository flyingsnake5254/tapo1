package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.jvm.a;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

/* compiled from: FragmentNavigatorDestinationBuilder.kt */
@NavDestinationDsl
/* loaded from: classes.dex */
public final class FragmentNavigatorDestinationBuilder extends NavDestinationBuilder<FragmentNavigator.Destination> {
    private final c<? extends Fragment> fragmentClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(FragmentNavigator navigator, @IdRes int i, c<? extends Fragment> fragmentClass) {
        super(navigator, i);
        j.f(navigator, "navigator");
        j.f(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public FragmentNavigator.Destination build() {
        FragmentNavigator.Destination destination = (FragmentNavigator.Destination) super.build();
        destination.setClassName(a.a(this.fragmentClass).getName());
        return destination;
    }
}
