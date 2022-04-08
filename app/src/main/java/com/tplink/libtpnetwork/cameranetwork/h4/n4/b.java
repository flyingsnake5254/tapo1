package com.tplink.libtpnetwork.cameranetwork.h4.n4;

import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;

/* compiled from: IoTRemoteCameraTransport.java */
/* loaded from: classes3.dex */
public class b extends h4 {

    /* renamed from: c  reason: collision with root package name */
    private c f14796c;

    /* renamed from: d  reason: collision with root package name */
    private d f14797d;

    public b(d dVar) {
        this.f14797d = dVar;
        this.f14796c = new c(dVar.b(), dVar.a());
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> c3(Request<MultipleRequest> request) {
        return this.f14796c.c(this.f14797d.b(), request);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<MultipleResponse>> d3(Request<MultipleRequest> request) {
        return this.f14796c.d(this.f14797d.b(), request);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> e3(Request request) {
        return this.f14796c.e(request);
    }

    public void h4(d dVar) {
        this.f14797d = dVar;
    }
}
