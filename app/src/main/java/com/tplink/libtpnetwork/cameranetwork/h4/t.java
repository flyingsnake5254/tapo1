package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class t implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ t f14872c = new t();

    private /* synthetic */ t() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(IntrusionDetectionRegion.Companion.fromResponse2((Response<Wrappers>) obj));
        return repack;
    }
}
