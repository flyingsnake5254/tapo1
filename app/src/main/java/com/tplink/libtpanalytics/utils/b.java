package com.tplink.libtpanalytics.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Stack;

/* compiled from: ActivityLifecycleMonitor.java */
/* loaded from: classes3.dex */
public class b {
    private static b a;

    /* renamed from: b  reason: collision with root package name */
    private AbstractC0249b f12003b;

    /* renamed from: c  reason: collision with root package name */
    private c f12004c;

    /* renamed from: d  reason: collision with root package name */
    private Stack<Activity> f12005d = new Stack<>();

    /* renamed from: e  reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f12006e = new a();

    /* compiled from: ActivityLifecycleMonitor.java */
    /* loaded from: classes3.dex */
    class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: c  reason: collision with root package name */
        private int f12007c = 0;

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            FragmentStateMonitor.h().m(activity);
            b.this.f12005d.push(activity);
            String simpleName = b.this.f12005d.size() > 1 ? ((Activity) b.this.f12005d.get(b.this.f12005d.size() - 2)).getClass().getSimpleName() : "";
            if (b.this.f12004c != null) {
                b.this.f12004c.a(simpleName);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            FragmentStateMonitor.h().o(activity);
            if (b.this.f12005d.indexOf(activity) == b.this.f12005d.size() - 1) {
                String simpleName = ((Activity) b.this.f12005d.peek()).getClass().getSimpleName();
                b.this.f12005d.remove(activity);
                if (b.this.f12004c != null) {
                    b.this.f12004c.a(simpleName);
                    return;
                }
                return;
            }
            b.this.f12005d.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i = this.f12007c + 1;
            this.f12007c = i;
            if (i == 1 && b.this.f12003b != null) {
                b.this.f12003b.a();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i = this.f12007c - 1;
            this.f12007c = i;
            if (i == 0 && b.this.f12003b != null) {
                b.this.f12003b.b();
            }
        }
    }

    /* compiled from: ActivityLifecycleMonitor.java */
    /* renamed from: com.tplink.libtpanalytics.utils.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0249b {
        void a();

        void b();
    }

    /* compiled from: ActivityLifecycleMonitor.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    private b() {
    }

    public static b f() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void d() {
        this.f12003b = null;
        this.f12004c = null;
    }

    public void e(AbstractC0249b bVar, c cVar) {
        this.f12003b = bVar;
        this.f12004c = cVar;
    }

    public String g() {
        return this.f12005d.size() != 0 ? this.f12005d.peek().getClass().getSimpleName() : "";
    }

    public void h(Application application) {
        application.registerActivityLifecycleCallbacks(this.f12006e);
    }
}
