package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import io.reactivex.l0.a;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class ResolutionRepository extends c {
    public ResolutionRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    public q<Boolean> t(ResolutionType resolutionType) {
        return l().U2(resolutionType).L0(a.c()).l0(io.reactivex.d0.b.a.a()).g0(m6.f14527c);
    }
}
