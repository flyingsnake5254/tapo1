package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ d f14731c = new d();

    private /* synthetic */ d() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(Model.getP2PSharePasswordFromWrapper((Wrappers) ((Response) obj).getResult()));
        return repack;
    }
}
