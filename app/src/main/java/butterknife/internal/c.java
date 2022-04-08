package butterknife.internal;

import android.util.TypedValue;
import android.view.View;
import androidx.annotation.IdRes;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class c {
    private static final TypedValue a = new TypedValue();

    public static <T> T a(Object obj, String str, int i, String str2, int i2, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Parameter #" + (i + 1) + " of method '" + str + "' was of the wrong type for parameter #" + (i2 + 1) + " of method '" + str2 + "'. See cause for more info.", e2);
        }
    }

    public static <T> T b(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e2) {
            String e3 = e(view, i);
            throw new IllegalStateException("View '" + e3 + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e2);
        }
    }

    public static View c(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String e2 = e(view, i);
        throw new IllegalStateException("Required view '" + e2 + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T d(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) b(c(view, i, str), i, str, cls);
    }

    private static String e(View view, @IdRes int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }
}
