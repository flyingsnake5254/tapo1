package androidx.core.app;

import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class BackstackAccessor {
    private BackstackAccessor() {
        throw new IllegalStateException("Not instantiatable");
    }

    public static boolean isFragmentOnBackStack(Fragment fragment) {
        try {
            return fragment.isInBackStack();
        } catch (IllegalAccessError unused) {
            return isInBackStackAndroidX(fragment);
        }
    }

    private static boolean isInBackStackAndroidX(Fragment fragment) {
        StringWriter stringWriter = new StringWriter();
        fragment.dump("", null, new PrintWriter(stringWriter), null);
        return !stringWriter.toString().contains("mBackStackNesting=0");
    }
}
