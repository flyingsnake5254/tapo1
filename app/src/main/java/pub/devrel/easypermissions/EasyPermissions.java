package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class EasyPermissions {

    /* loaded from: classes4.dex */
    public interface PermissionCallbacks extends ActivityCompat.OnRequestPermissionsResultCallback {
        void E0(int i, List<String> list);

        void t(int i, List<String> list);
    }

    public static boolean a(@NonNull Context context, @NonNull String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
            return true;
        }
        for (String str : strArr) {
            if (!(ContextCompat.checkSelfPermission(context, str) == 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(@NonNull Object obj) {
        if (!obj.getClass().getSimpleName().endsWith("_")) {
            return false;
        }
        try {
            return Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void c(Object obj, int i, @NonNull String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = 0;
        }
        d(i, strArr, iArr, obj);
    }

    public static void d(int i, @NonNull String[] strArr, @NonNull int[] iArr, @NonNull Object... objArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        for (Object obj : objArr) {
            if (!arrayList.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).E0(i, arrayList);
            }
            if (!arrayList2.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).t(i, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                i(obj, i);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void e(@NonNull Activity activity, @NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        if (a(activity, strArr)) {
            c(activity, i3, strArr);
        } else if (j(activity, strArr)) {
            l(activity.getFragmentManager(), str, i, i2, i3, strArr);
        } else {
            ActivityCompat.requestPermissions(activity, strArr, i3);
        }
    }

    public static void f(@NonNull Activity activity, @NonNull String str, int i, @NonNull String... strArr) {
        e(activity, str, 17039370, 17039360, i, strArr);
    }

    @SuppressLint({"NewApi"})
    public static void g(@NonNull Fragment fragment, @NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        if (a(fragment.getContext(), strArr)) {
            c(fragment, i3, strArr);
        } else if (j(fragment, strArr)) {
            RationaleDialogFragmentCompat.A0(i, i2, str, i3, strArr).show(fragment.getChildFragmentManager(), "RationaleDialogFragmentCompat");
        } else {
            fragment.requestPermissions(strArr, i3);
        }
    }

    public static void h(@NonNull Fragment fragment, @NonNull String str, int i, @NonNull String... strArr) {
        g(fragment, str, 17039370, 17039360, i, strArr);
    }

    private static void i(@NonNull Object obj, int i) {
        Method[] declaredMethods;
        Class<?> cls = obj.getClass();
        if (b(obj)) {
            cls = cls.getSuperclass();
        }
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(a.class) && ((a) method.getAnnotation(a.class)).value() == i) {
                    if (method.getParameterTypes().length <= 0) {
                        try {
                            if (!method.isAccessible()) {
                                method.setAccessible(true);
                            }
                            method.invoke(obj, new Object[0]);
                        } catch (IllegalAccessException e2) {
                            Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", e2);
                        } catch (InvocationTargetException e3) {
                            Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", e3);
                        }
                    } else {
                        throw new RuntimeException("Cannot execute method " + method.getName() + " because it is non-void method and/or has input parameters.");
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    private static boolean j(@NonNull Object obj, @NonNull String[] strArr) {
        boolean z = false;
        for (String str : strArr) {
            z = z || k(obj, str);
        }
        return z;
    }

    private static boolean k(@NonNull Object obj, @NonNull String str) {
        if (obj instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) obj, str);
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        if (!(obj instanceof android.app.Fragment)) {
            throw new IllegalArgumentException("Object was neither an Activity nor a Fragment.");
        } else if (Build.VERSION.SDK_INT >= 23) {
            return ((android.app.Fragment) obj).shouldShowRequestPermissionRationale(str);
        } else {
            throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
        }
    }

    @RequiresApi(api = 11)
    private static void l(@NonNull FragmentManager fragmentManager, @NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        e.a(i, i2, str, i3, strArr).show(fragmentManager, "RationaleDialogFragmentCompat");
    }
}
