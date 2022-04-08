package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleResult;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class t5 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ t5 f13480c = new t5();

    private /* synthetic */ t5() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return new CountdownRuleResult((ThingRuleListResult) obj);
    }
}
