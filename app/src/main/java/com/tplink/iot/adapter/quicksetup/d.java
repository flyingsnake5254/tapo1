package com.tplink.iot.adapter.quicksetup;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;

/* compiled from: DiscoveryDeviceBean.java */
/* loaded from: classes2.dex */
public class d {
    private int a = 1;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private TDPIoTDevice f5939b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f5940c;

    public d(@Nullable TDPIoTDevice tDPIoTDevice) {
        this.f5939b = tDPIoTDevice;
    }

    @Nullable
    public TDPIoTDevice a() {
        return this.f5939b;
    }

    @Nullable
    public String b() {
        return this.f5940c;
    }

    public int c() {
        return this.a;
    }
}
