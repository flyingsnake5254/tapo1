package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.CameraInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ i f14760c = new i();

    private /* synthetic */ i() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(new CameraInfo((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
