package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class w3 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ w3 f14891c = new w3();

    private /* synthetic */ w3() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(new CoverConfigInfo((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
