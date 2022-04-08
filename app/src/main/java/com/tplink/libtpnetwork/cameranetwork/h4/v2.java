package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class v2 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ v2 f14885c = new v2();

    private /* synthetic */ v2() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(OsdConfig.Companion.fromResponse((Response<Wrappers>) obj));
        return repack;
    }
}
