package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class b0 {
    @Nullable
    private final List<SkuDetails> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1184b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1185c;

    public b0(int i, String str, @Nullable List<SkuDetails> list) {
        this.f1184b = i;
        this.f1185c = str;
        this.a = list;
    }

    @Nullable
    public final List<SkuDetails> a() {
        return this.a;
    }

    public final int b() {
        return this.f1184b;
    }

    public final String c() {
        return this.f1185c;
    }
}
