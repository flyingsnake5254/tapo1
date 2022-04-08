package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g0 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ g0 f14747c = new g0();

    private /* synthetic */ g0() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(new MotionDetectionInfo((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
