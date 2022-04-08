package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.j;

/* compiled from: FragmentTransaction.kt */
/* loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, @IdRes int i, String str, Bundle bundle) {
        j.f(add, "$this$add");
        j.j(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        j.b(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        j.f(add, "$this$add");
        j.j(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        j.b(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction replace, @IdRes int i, String str, Bundle bundle) {
        j.f(replace, "$this$replace");
        j.j(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        j.b(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        j.f(replace, "$this$replace");
        j.j(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        j.b(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, String tag, Bundle bundle) {
        j.f(add, "$this$add");
        j.f(tag, "tag");
        j.j(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        j.b(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        j.f(add, "$this$add");
        j.f(tag, "tag");
        j.j(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        j.b(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
