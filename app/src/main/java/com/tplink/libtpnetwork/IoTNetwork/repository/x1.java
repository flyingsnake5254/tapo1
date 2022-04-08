package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class x1 implements g {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbstractThingRepository f13534c;

    public /* synthetic */ x1(AbstractThingRepository abstractThingRepository) {
        this.f13534c = abstractThingRepository;
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        this.f13534c.Y4((DeviceRunningInfoResult) obj);
    }
}
