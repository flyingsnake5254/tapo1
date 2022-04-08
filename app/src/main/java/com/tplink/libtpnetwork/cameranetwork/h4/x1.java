package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class x1 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ x1 f14894c = new x1();

    private /* synthetic */ x1() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(new DetectionList((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
