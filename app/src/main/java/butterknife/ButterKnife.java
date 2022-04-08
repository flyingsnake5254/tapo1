package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ButterKnife {
    private static boolean a = false;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f861b = new LinkedHashMap();

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @UiThread
    public static Unbinder a(@NonNull Activity activity) {
        return b(activity, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder b(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (a) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> c2 = c(cls);
        if (c2 == null) {
            return Unbinder.a;
        }
        try {
            return (Unbinder) c2.newInstance(obj, view);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + c2, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + c2, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    @Nullable
    @CheckResult
    @UiThread
    private static Constructor<? extends Unbinder> c(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Map<Class<?>, Constructor<? extends Unbinder>> map = f861b;
        Constructor<? extends Unbinder> constructor2 = map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            if (a) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor2;
        }
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
                if (a) {
                    Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
                }
            } catch (ClassNotFoundException unused) {
                if (a) {
                    Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                constructor = c(cls.getSuperclass());
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e2);
            }
            f861b.put(cls, constructor);
            return constructor;
        } else if (!a) {
            return null;
        } else {
            Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            return null;
        }
    }
}
