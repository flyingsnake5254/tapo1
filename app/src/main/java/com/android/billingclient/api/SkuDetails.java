package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public class SkuDetails {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f1183b;

    public SkuDetails(@NonNull String str) throws JSONException {
        this.a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f1183b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        } else if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    @NonNull
    public String a() {
        return this.f1183b.optString("description");
    }

    @NonNull
    public String b() {
        return this.f1183b.optString("introductoryPrice");
    }

    public long c() {
        return this.f1183b.optLong("introductoryPriceAmountMicros");
    }

    public int d() {
        return this.f1183b.optInt("introductoryPriceCycles");
    }

    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDetails)) {
            return false;
        }
        return TextUtils.equals(this.a, ((SkuDetails) obj).a);
    }

    public long f() {
        if (this.f1183b.has("original_price_micros")) {
            return this.f1183b.optLong("original_price_micros");
        }
        return g();
    }

    public long g() {
        return this.f1183b.optLong("price_amount_micros");
    }

    @NonNull
    public String h() {
        return this.f1183b.optString("price_currency_code");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String i() {
        return this.f1183b.optString("productId");
    }

    @NonNull
    public String j() {
        return this.f1183b.optString("subscriptionPeriod");
    }

    @NonNull
    public String k() {
        return this.f1183b.optString("title");
    }

    @NonNull
    public String l() {
        return this.f1183b.optString("type");
    }

    @NonNull
    public final String m() {
        return this.f1183b.optString("packageName");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String n() {
        return this.f1183b.optString("skuDetailsToken");
    }

    @NonNull
    public String o() {
        return this.f1183b.optString("offer_id");
    }

    public int p() {
        return this.f1183b.optInt("offer_type");
    }

    @NonNull
    public String toString() {
        String valueOf = String.valueOf(this.a);
        return valueOf.length() != 0 ? "SkuDetails: ".concat(valueOf) : new String("SkuDetails: ");
    }
}
