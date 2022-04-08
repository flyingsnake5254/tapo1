package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class r3 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ r3 f14866c = new r3();

    private /* synthetic */ r3() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(Model.typeCast((Wrappers) ((Response) obj).getResult(), AlarmInfo.class));
        return repack;
    }
}
