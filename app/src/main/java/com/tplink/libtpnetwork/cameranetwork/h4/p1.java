package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p1 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ p1 f14843c = new p1();

    private /* synthetic */ p1() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(new IntrusionDetectionInfo((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
