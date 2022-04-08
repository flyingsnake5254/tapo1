package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d3 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ d3 f14735c = new d3();

    private /* synthetic */ d3() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(((Response) obj).getResult());
        return repack;
    }
}
