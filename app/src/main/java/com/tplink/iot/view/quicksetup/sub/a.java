package com.tplink.iot.view.quicksetup.sub;

import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f9675c = new a();

    private /* synthetic */ a() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return Boolean.valueOf(((ThingFirmware) obj).isNeedToUpgrade());
    }
}
