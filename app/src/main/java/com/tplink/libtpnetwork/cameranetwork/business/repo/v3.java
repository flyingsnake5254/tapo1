package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.ResetSupportInfo;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class v3 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ v3 f14620c = new v3();

    private /* synthetic */ v3() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Boolean valueOf;
        valueOf = Boolean.valueOf("1".equals(((ResetSupportInfo) obj).getResetWifiSupported()));
        return valueOf;
    }
}
