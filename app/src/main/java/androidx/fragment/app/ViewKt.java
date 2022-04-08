package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.j;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View findFragment) {
        j.f(findFragment, "$this$findFragment");
        F f2 = (F) FragmentManager.findFragment(findFragment);
        j.b(f2, "FragmentManager.findFragment(this)");
        return f2;
    }
}
