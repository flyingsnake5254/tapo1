package com.android.billingclient.api;

import android.text.TextUtils;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class e0 {
    private String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e0(d0 d0Var) {
    }

    public final e0 a(String str) {
        this.a = str;
        return this;
    }

    public final f0 b() {
        if (!TextUtils.isEmpty(this.a)) {
            return new f0(this.a, null, null);
        }
        throw new IllegalArgumentException("SKU must be set.");
    }
}
