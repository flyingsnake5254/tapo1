package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.p;

/* compiled from: DialogFragmentNavigatorDestinationBuilder.kt */
/* loaded from: classes.dex */
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder dialog, @IdRes int i, l<? super DialogFragmentNavigatorDestinationBuilder, p> builder) {
        j.f(dialog, "$this$dialog");
        j.f(builder, "builder");
        Navigator navigator = dialog.getProvider().getNavigator(DialogFragmentNavigator.class);
        j.b(navigator, "getNavigator(clazz.java)");
        j.j(4, "F");
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i, m.b(DialogFragment.class));
        builder.invoke(dialogFragmentNavigatorDestinationBuilder);
        dialog.destination(dialogFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder dialog, @IdRes int i) {
        j.f(dialog, "$this$dialog");
        Navigator navigator = dialog.getProvider().getNavigator(DialogFragmentNavigator.class);
        j.b(navigator, "getNavigator(clazz.java)");
        j.j(4, "F");
        dialog.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i, m.b(DialogFragment.class)));
    }
}
