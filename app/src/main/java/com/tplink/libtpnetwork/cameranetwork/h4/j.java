package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Response;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements io.reactivex.g0.j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ j f14765c = new j();

    private /* synthetic */ j() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(((Response) obj).getResult());
        return repack;
    }
}
