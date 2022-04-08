package com.tplink.libtpnetwork.cameranetwork.business.repo;

import b.d.b.f.b;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;

@Deprecated
/* loaded from: classes3.dex */
public class MotionDetectRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private ALCameraDevice f14287d;

    /* renamed from: e  reason: collision with root package name */
    private TCMessagePushRepository f14288e;

    public MotionDetectRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        this.f14287d = tPCameraDeviceContext.getCameraDevice();
        this.f14288e = (TCMessagePushRepository) b.c(tPCameraDeviceContext.getAccountContext()).a(TCMessagePushRepository.class);
    }
}
