package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;
import java.util.Objects;
import java.util.UUID;

/* compiled from: ActivityMviDelegateImpl.java */
/* loaded from: classes2.dex */
public class b<V extends com.hannesdorfmann.mosby3.k.b, P extends d<V, ?>> implements a {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f5050b;

    /* renamed from: c  reason: collision with root package name */
    private f<V, P> f5051c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f5052d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5053e;

    /* renamed from: f  reason: collision with root package name */
    private P f5054f;

    public b(@NonNull Activity activity, @NonNull f<V, P> fVar) {
        this(activity, fVar, true);
    }

    private P d() {
        P D = this.f5051c.D();
        if (D != null) {
            if (this.f5053e) {
                String uuid = UUID.randomUUID().toString();
                this.f5050b = uuid;
                g.g(this.f5052d, uuid, D);
            }
            return D;
        }
        throw new NullPointerException("Presenter returned from createPresenter() is null. Activity is " + this.f5052d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(boolean z, Activity activity) {
        return z && (activity.isChangingConfigurations() || !activity.isFinishing());
    }

    @Override // com.hannesdorfmann.mosby3.a
    public Object a() {
        return null;
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void b(Bundle bundle) {
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void c() {
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onContentChanged() {
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onCreate(@Nullable Bundle bundle) {
        if (this.f5053e && bundle != null) {
            this.f5050b = bundle.getString("com.hannesdorfmann.mosby3.activity.mvi.id");
        }
        if (a) {
            Log.d("ActivityMviDelegateImpl", "MosbyView ID = " + this.f5050b + " for MvpView: " + this.f5051c.getMvpView());
        }
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onDestroy() {
        if (this.f5054f != null && !e(this.f5053e, this.f5052d)) {
            this.f5054f.destroy();
            String str = this.f5050b;
            if (str != null) {
                g.h(this.f5052d, str);
            }
            Log.d("ActivityMviDelegateImpl", "Destroying Presenter permanently " + this.f5054f);
        }
        this.f5054f = null;
        this.f5052d = null;
        this.f5051c = null;
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onPause() {
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onResume() {
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f5053e && bundle != null) {
            bundle.putString("com.hannesdorfmann.mosby3.activity.mvi.id", this.f5050b);
            if (a) {
                Log.d("ActivityMviDelegateImpl", "Saving MosbyViewId into Bundle. ViewId: " + this.f5050b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    @Override // com.hannesdorfmann.mosby3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStart() {
        /*
            r6 = this;
            java.lang.String r0 = r6.f5050b
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ActivityMviDelegateImpl"
            if (r0 != 0) goto L_0x0037
            com.hannesdorfmann.mosby3.mvi.d r0 = r6.d()
            r6.f5054f = r0
            boolean r0 = com.hannesdorfmann.mosby3.b.a
            if (r0 == 0) goto L_0x0063
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "new Presenter instance created: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.f5054f
            r0.append(r4)
            java.lang.String r4 = " for "
            r0.append(r4)
            com.hannesdorfmann.mosby3.f<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r4 = r6.f5051c
            com.hannesdorfmann.mosby3.k.b r4 = r4.getMvpView()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            goto L_0x0063
        L_0x0037:
            android.app.Activity r4 = r6.f5052d
            java.lang.Object r0 = com.hannesdorfmann.mosby3.g.f(r4, r0)
            com.hannesdorfmann.mosby3.mvi.d r0 = (com.hannesdorfmann.mosby3.mvi.d) r0
            r6.f5054f = r0
            if (r0 != 0) goto L_0x0065
            com.hannesdorfmann.mosby3.mvi.d r0 = r6.d()
            r6.f5054f = r0
            boolean r0 = com.hannesdorfmann.mosby3.b.a
            if (r0 == 0) goto L_0x0063
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.f5054f
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x0063:
            r0 = 0
            goto L_0x0080
        L_0x0065:
            boolean r0 = com.hannesdorfmann.mosby3.b.a
            if (r0 == 0) goto L_0x007f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Presenter instance reused from internal cache: "
            r0.append(r4)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r4 = r6.f5054f
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x007f:
            r0 = 1
        L_0x0080:
            com.hannesdorfmann.mosby3.f<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r4 = r6.f5051c
            com.hannesdorfmann.mosby3.k.b r4 = r4.getMvpView()
            if (r4 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x008f
            com.hannesdorfmann.mosby3.f<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r5 = r6.f5051c
            r5.setRestoringViewState(r1)
        L_0x008f:
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r1 = r6.f5054f
            r1.a(r4)
            if (r0 == 0) goto L_0x009b
            com.hannesdorfmann.mosby3.f<V extends com.hannesdorfmann.mosby3.k.b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>> r0 = r6.f5051c
            r0.setRestoringViewState(r2)
        L_0x009b:
            boolean r0 = com.hannesdorfmann.mosby3.b.a
            if (r0 == 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "MvpView attached to Presenter. MvpView: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = "   Presenter: "
            r0.append(r1)
            P extends com.hannesdorfmann.mosby3.mvi.d<V, ?> r1 = r6.f5054f
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x00bd:
            return
        L_0x00be:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "MvpView returned from getMvpView() is null. Returned by "
            r1.append(r2)
            android.app.Activity r2 = r6.f5052d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hannesdorfmann.mosby3.b.onStart():void");
    }

    @Override // com.hannesdorfmann.mosby3.a
    public void onStop() {
        this.f5054f.b();
        if (a) {
            Log.d("ActivityMviDelegateImpl", "detached MvpView from Presenter. MvpView " + this.f5051c.getMvpView() + "   Presenter: " + this.f5054f);
        }
    }

    public b(@NonNull Activity activity, @NonNull f<V, P> fVar, boolean z) {
        this.f5050b = null;
        Objects.requireNonNull(activity, "Activity is null");
        Objects.requireNonNull(fVar, "MvpDelegateCallback is null!");
        this.f5051c = fVar;
        this.f5052d = activity;
        this.f5053e = z;
    }
}
