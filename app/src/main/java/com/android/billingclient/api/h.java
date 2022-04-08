package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class h {
    private String a;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    /* loaded from: classes.dex */
    public static final class a {
        private String a;

        /* synthetic */ a(z zVar) {
        }

        @NonNull
        public h a() {
            if (this.a != null) {
                h hVar = new h(null);
                hVar.a = this.a;
                return hVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        @NonNull
        public a b(@NonNull String str) {
            this.a = str;
            return this;
        }
    }

    /* synthetic */ h(z zVar) {
    }

    @NonNull
    public static a b() {
        return new a(null);
    }

    @NonNull
    public String a() {
        return this.a;
    }
}
