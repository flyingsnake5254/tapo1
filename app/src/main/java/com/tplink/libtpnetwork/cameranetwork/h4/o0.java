package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpMultiInfo;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class o0 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ o0 f14807c = new o0();

    private /* synthetic */ o0() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(UpnpMultiInfo.Companion.fromMultipleResponse((MultipleResponse) ((Response) obj).getResult()));
        return repack;
    }
}
