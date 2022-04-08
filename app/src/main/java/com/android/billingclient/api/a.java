package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class a {
    private String a;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    /* renamed from: com.android.billingclient.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0039a {
        private String a;

        /* synthetic */ C0039a(n nVar) {
        }

        @NonNull
        public a a() {
            if (this.a != null) {
                a aVar = new a(null);
                aVar.a = this.a;
                return aVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        @NonNull
        public C0039a b(@NonNull String str) {
            this.a = str;
            return this;
        }
    }

    /* synthetic */ a(n nVar) {
    }

    @NonNull
    public static C0039a b() {
        return new C0039a(null);
    }

    @NonNull
    public String a() {
        return this.a;
    }
}
