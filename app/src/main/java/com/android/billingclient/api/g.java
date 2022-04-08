package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class g {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private String f1203b;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    /* loaded from: classes.dex */
    public static class a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private String f1204b = "";

        /* synthetic */ a(x xVar) {
        }

        @NonNull
        public g a() {
            g gVar = new g();
            gVar.a = this.a;
            gVar.f1203b = this.f1204b;
            return gVar;
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f1204b = str;
            return this;
        }

        @NonNull
        public a c(int i) {
            this.a = i;
            return this;
        }
    }

    @NonNull
    public static a b() {
        return new a(null);
    }

    public int a() {
        return this.a;
    }
}
