package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0092zaa> zacl;

    public zaa(Activity activity) {
        this(C0092zaa.zaa(activity));
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0092zaa zaaVar = this.zacl.get();
        if (zaaVar != null) {
            zaaVar.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    @VisibleForTesting(otherwise = 2)
    private zaa(C0092zaa zaaVar) {
        this.zacl = new WeakReference<>(zaaVar);
    }

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0092zaa extends LifecycleCallback {
        private List<Runnable> zacm = new ArrayList();

        private C0092zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0092zaa zaa(Activity activity) {
            C0092zaa zaaVar;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaaVar = (C0092zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0092zaa.class);
                if (zaaVar == null) {
                    zaaVar = new C0092zaa(fragment);
                }
            }
            return zaaVar;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacm;
                this.zacm = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacm.add(runnable);
        }
    }
}
