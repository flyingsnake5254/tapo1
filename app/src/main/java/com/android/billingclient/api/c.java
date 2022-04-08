package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.android.billingclient.api.Purchase;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    /* loaded from: classes.dex */
    public static final class a {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f1186b;

        /* renamed from: c  reason: collision with root package name */
        private k f1187c;

        /* synthetic */ a(Context context, j0 j0Var) {
            this.f1186b = context;
        }

        @NonNull
        @UiThread
        public c a() {
            Context context = this.f1186b;
            if (context != null) {
                k kVar = this.f1187c;
                if (kVar == null) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                } else if (this.a) {
                    return new d(null, true, context, kVar);
                } else {
                    throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                }
            } else {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
        }

        @NonNull
        @UiThread
        public a b() {
            this.a = true;
            return this;
        }

        @NonNull
        @UiThread
        public a c(@NonNull k kVar) {
            this.f1187c = kVar;
            return this;
        }
    }

    @NonNull
    @UiThread
    public static a g(@NonNull Context context) {
        return new a(context, null);
    }

    public abstract void a(@NonNull a aVar, @NonNull b bVar);

    public abstract void b(@NonNull h hVar, @NonNull i iVar);

    @UiThread
    public abstract void c();

    @NonNull
    @UiThread
    public abstract g d(@NonNull String str);

    @UiThread
    public abstract boolean e();

    @NonNull
    @UiThread
    public abstract g f(@NonNull Activity activity, @NonNull f fVar);

    @NonNull
    public abstract Purchase.a h(@NonNull String str);

    public abstract void i(@NonNull l lVar, @NonNull m mVar);

    @UiThread
    public abstract void j(@NonNull e eVar);
}
