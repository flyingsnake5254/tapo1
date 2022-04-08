package com.tplink.libtpnetwork.cameranetwork.h4.n4;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.h4.i4;

/* compiled from: IoTRemoteTransportParams.java */
/* loaded from: classes3.dex */
public class d extends i4 {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private TPCameraDeviceContext f14805b;

    public d(String str, TPCameraDeviceContext tPCameraDeviceContext) {
        this.a = str;
        this.f14805b = tPCameraDeviceContext;
    }

    public TPCameraDeviceContext a() {
        return this.f14805b;
    }

    public String b() {
        return this.a;
    }
}
