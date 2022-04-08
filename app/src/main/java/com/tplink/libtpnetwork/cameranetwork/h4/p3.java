package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.ConnectResult;
import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p3 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ p3 f14845c = new p3();

    private /* synthetic */ p3() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(Model.typeCast((Wrappers) ((Response) obj).getResult(), ConnectResult.class));
        return repack;
    }
}
