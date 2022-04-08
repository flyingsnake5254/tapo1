package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;
import java.util.Objects;
import java.util.UUID;

/* compiled from: ViewGroupMviDelegateImpl.java */
/* loaded from: classes2.dex */
public class j<V extends b, P extends d<V, ?>> implements h<V, P>, Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5063c = false;

    /* renamed from: d  reason: collision with root package name */
    private i<V, P> f5064d;

    /* renamed from: f  reason: collision with root package name */
    private String f5065f;
    private boolean p0 = false;
    private boolean p1 = false;
    private boolean p2 = false;
    private final boolean q;
    private final boolean x;
    private P y;
    private final Activity z;

    public j(@NonNull View view, @NonNull i<V, P> iVar, boolean z) {
        Objects.requireNonNull(view, "View is null!");
        Objects.requireNonNull(iVar, "MvpDelegateCallback is null!");
        this.f5064d = iVar;
        this.q = z;
        boolean isInEditMode = view.isInEditMode();
        this.x = isInEditMode;
        if (!isInEditMode) {
            Activity c2 = g.c(iVar.getContext());
            this.z = c2;
            c2.getApplication().registerActivityLifecycleCallbacks(this);
            return;
        }
        this.z = null;
    }

    private P a() {
        P D = this.f5064d.D();
        Objects.requireNonNull(D, "Presenter returned from createPresenter() is null.");
        if (this.q) {
            Context context = this.f5064d.getContext();
            this.f5065f = UUID.randomUUID().toString();
            g.g(g.c(context), this.f5065f, D);
        }
        return D;
    }

    private void b() {
        if (!this.p2) {
            this.y.destroy();
            this.p2 = true;
            if (f5063c) {
                Log.d("ViewGroupMviDelegateImp", "Presenter destroyed: " + this.y);
            }
            String str = this.f5065f;
            if (str != null) {
                g.h(this.z, str);
            }
            this.f5065f = null;
        }
    }

    private void c() {
        if (!this.p1) {
            this.y.b();
            this.p1 = true;
            if (f5063c) {
                Log.d("ViewGroupMviDelegateImp", "view " + this.f5064d.getMvpView() + " detached from Presenter " + this.y);
            }
        }
    }

    @NonNull
    private Context d() {
        Context context = this.f5064d.getContext();
        if (context != null) {
            return context;
        }
        throw new NullPointerException("Context returned from " + this.f5064d + " is null");
    }

    private void e(MosbySavedState mosbySavedState) {
        this.f5065f = mosbySavedState.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity == this.z) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.p0 = true;
            if (!b.e(this.q, activity)) {
                c();
                b();
            }
        }
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    @Override // com.hannesdorfmann.mosby3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r6 = this;
            boolean r0 = r6.x
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r6.f5065f
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ViewGroupMviDelegateImp"
            if (r0 != 0) goto L_0x002e
            com.hannesdorfmann.mosby3.mvi.d r0 = r6.a()
            r6.y = r0
            boolean r0 = com.hannesdorfmann.mosby3.j.f5063c
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "new Presenter instance created: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.y
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            goto L_0x005f
        L_0x002e:
            r6.d()
            android.app.Activity r0 = r6.z
            java.lang.String r4 = r6.f5065f
            java.lang.Object r0 = com.hannesdorfmann.mosby3.g.f(r0, r4)
            com.hannesdorfmann.mosby3.mvi.d r0 = (com.hannesdorfmann.mosby3.mvi.d) r0
            r6.y = r0
            if (r0 != 0) goto L_0x0061
            com.hannesdorfmann.mosby3.mvi.d r0 = r6.a()
            r6.y = r0
            boolean r0 = com.hannesdorfmann.mosby3.j.f5063c
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.y
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x005f:
            r0 = 0
            goto L_0x007c
        L_0x0061:
            boolean r0 = com.hannesdorfmann.mosby3.j.f5063c
            if (r0 == 0) goto L_0x007b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Presenter instance reused from internal cache: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.y
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x007b:
            r0 = 1
        L_0x007c:
            com.hannesdorfmann.mosby3.i<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r4 = r6.f5064d
            com.hannesdorfmann.mosby3.k.b r4 = r4.getMvpView()
            if (r4 == 0) goto L_0x00ba
            if (r0 == 0) goto L_0x008b
            com.hannesdorfmann.mosby3.i<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r5 = r6.f5064d
            r5.setRestoringViewState(r1)
        L_0x008b:
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r1 = r6.y
            r1.a(r4)
            if (r0 == 0) goto L_0x0097
            com.hannesdorfmann.mosby3.i<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r0 = r6.f5064d
            r0.setRestoringViewState(r2)
        L_0x0097:
            boolean r0 = com.hannesdorfmann.mosby3.j.f5063c
            if (r0 == 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "MvpView attached to Presenter. MvpView: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = "   Presenter: "
            r0.append(r1)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r1 = r6.y
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x00b9:
            return
        L_0x00ba:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "MvpView returned from getMvpView() is null. Returned by "
            r1.append(r2)
            com.hannesdorfmann.mosby3.i<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r2 = r6.f5064d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hannesdorfmann.mosby3.j.onAttachedToWindow():void");
    }

    @Override // com.hannesdorfmann.mosby3.h
    public void onDetachedFromWindow() {
        if (!this.x) {
            c();
            if (this.p0) {
                return;
            }
            if (!b.e(this.q, this.z)) {
                b();
            } else if (!this.z.isFinishing()) {
                b();
            }
        }
    }

    @Override // com.hannesdorfmann.mosby3.h
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.x) {
            if (!(parcelable instanceof MosbySavedState)) {
                this.f5064d.n0(parcelable);
                return;
            }
            MosbySavedState mosbySavedState = (MosbySavedState) parcelable;
            e(mosbySavedState);
            this.f5064d.n0(mosbySavedState.getSuperState());
        }
    }

    @Override // com.hannesdorfmann.mosby3.h
    public Parcelable onSaveInstanceState() {
        if (this.x) {
            return null;
        }
        Parcelable r = this.f5064d.r();
        return this.q ? new MosbySavedState(r, this.f5065f) : r;
    }
}
