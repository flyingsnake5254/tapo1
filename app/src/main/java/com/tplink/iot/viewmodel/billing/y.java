package com.tplink.iot.viewmodel.billing;

import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class y implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ y f9880c = new y();

    private /* synthetic */ y() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return Integer.valueOf(((VerifyReceiptResult) obj).getStatus());
    }
}
