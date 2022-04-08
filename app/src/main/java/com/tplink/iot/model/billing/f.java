package com.tplink.iot.model.billing;

import com.android.billingclient.api.SkuDetails;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ f f8038c = new f();

    private /* synthetic */ f() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return BillingManager.V((SkuDetails) obj, (SkuDetails) obj2);
    }
}
