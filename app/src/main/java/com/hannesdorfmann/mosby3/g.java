package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.hannesdorfmann.mosby3.k.b;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* compiled from: PresenterManager.java */
/* loaded from: classes2.dex */
public final class g {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Activity, String> f5060b = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, c> f5061c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    static final Application.ActivityLifecycleCallbacks f5062d = new a();

    /* compiled from: PresenterManager.java */
    /* loaded from: classes2.dex */
    static class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String string;
            if (bundle != null && (string = bundle.getString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId")) != null) {
                g.f5060b.put(activity, string);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String str;
            if (!activity.isChangingConfigurations() && (str = (String) g.f5060b.get(activity)) != null) {
                c cVar = (c) g.f5061c.get(str);
                if (cVar != null) {
                    cVar.a();
                    g.f5061c.remove(str);
                }
                if (g.f5061c.isEmpty()) {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(g.f5062d);
                    if (g.a) {
                        Log.d("PresenterManager", "Unregistering ActivityLifecycleCallbacks");
                    }
                }
            }
            g.f5060b.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            String str = (String) g.f5060b.get(activity);
            if (str != null) {
                bundle.putString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId", str);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    @NonNull
    public static Activity c(@NonNull Context context) {
        Objects.requireNonNull(context, "context == null");
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        throw new IllegalStateException("Could not find the surrounding Activity");
    }

    @Nullable
    @MainThread
    static c d(@NonNull Activity activity) {
        Objects.requireNonNull(activity, "Activity is null");
        String str = f5060b.get(activity);
        if (str == null) {
            return null;
        }
        return f5061c.get(str);
    }

    @NonNull
    @MainThread
    static c e(@NonNull Activity activity) {
        Objects.requireNonNull(activity, "Activity is null");
        Map<Activity, String> map = f5060b;
        String str = map.get(activity);
        if (str == null) {
            str = UUID.randomUUID().toString();
            map.put(activity, str);
            if (map.size() == 1) {
                activity.getApplication().registerActivityLifecycleCallbacks(f5062d);
                if (a) {
                    Log.d("PresenterManager", "Registering ActivityLifecycleCallbacks");
                }
            }
        }
        Map<String, c> map2 = f5061c;
        c cVar = map2.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        map2.put(str, cVar2);
        return cVar2;
    }

    @Nullable
    public static <P> P f(@NonNull Activity activity, @NonNull String str) {
        Objects.requireNonNull(activity, "Activity is null");
        Objects.requireNonNull(str, "View id is null");
        c d2 = d(activity);
        if (d2 == null) {
            return null;
        }
        return (P) d2.b(str);
    }

    public static void g(@NonNull Activity activity, @NonNull String str, @NonNull com.hannesdorfmann.mosby3.k.a<? extends b> aVar) {
        Objects.requireNonNull(activity, "Activity is null");
        e(activity).c(str, aVar);
    }

    public static void h(@NonNull Activity activity, @NonNull String str) {
        Objects.requireNonNull(activity, "Activity is null");
        c d2 = d(activity);
        if (d2 != null) {
            d2.d(str);
        }
    }
}
