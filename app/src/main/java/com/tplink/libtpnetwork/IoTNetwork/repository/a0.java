package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import io.reactivex.g0.l;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a0 implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a0 f13150c = new a0();

    private /* synthetic */ a0() {
    }

    @Override // io.reactivex.g0.l
    public final boolean test(Object obj) {
        return AbstractSubThingRepository.p2((ThingEventLogResult) obj);
    }
}
