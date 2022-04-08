package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AntiTheftRuleResult;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class ab implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ ab f13162c = new ab();

    private /* synthetic */ ab() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return new AntiTheftRuleResult((ThingRuleListResult) obj);
    }
}
