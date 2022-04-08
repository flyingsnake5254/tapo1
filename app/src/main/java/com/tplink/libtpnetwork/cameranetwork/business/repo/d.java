package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.business.model.b;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import io.reactivex.g0.c;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ d f14368c = new d();

    private /* synthetic */ d() {
    }

    @Override // io.reactivex.g0.c
    public final Object apply(Object obj, Object obj2) {
        b w;
        w = AlarmSettingRepository.w((AlarmInfo) obj, (AlarmPlanInfo) obj2);
        return w;
    }
}
