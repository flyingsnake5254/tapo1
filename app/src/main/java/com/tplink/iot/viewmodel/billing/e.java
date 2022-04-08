package com.tplink.iot.viewmodel.billing;

import com.tplink.iab.beans.SubscriptionState;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ e f9856c = new e();

    private /* synthetic */ e() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Integer valueOf;
        Boolean bool = (Boolean) obj;
        valueOf = Integer.valueOf(r0.booleanValue() ? 0 : SubscriptionState.ACKNOWLEDGEMENT_ERROR);
        return valueOf;
    }
}
