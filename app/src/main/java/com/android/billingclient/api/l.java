package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public class l {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f1209b;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    /* loaded from: classes.dex */
    public static class a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f1210b;

        /* synthetic */ a(c0 c0Var) {
        }

        @NonNull
        public l a() {
            if (this.a == null) {
                throw new IllegalArgumentException("SKU type must be set");
            } else if (this.f1210b != null) {
                l lVar = new l();
                lVar.a = this.a;
                lVar.f1209b = this.f1210b;
                return lVar;
            } else {
                throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
            }
        }

        @NonNull
        public a b(@NonNull List<String> list) {
            this.f1210b = new ArrayList(list);
            return this;
        }

        @NonNull
        public a c(@NonNull String str) {
            this.a = str;
            return this;
        }
    }

    @NonNull
    public static a c() {
        return new a(null);
    }

    @NonNull
    public String a() {
        return this.a;
    }

    @NonNull
    public List<String> b() {
        return this.f1209b;
    }
}
