package com.tplink.iot.model.smart;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* compiled from: SmartDeviceListBean.java */
/* loaded from: classes2.dex */
public class h {
    private BaseALIoTDevice a;

    /* renamed from: b  reason: collision with root package name */
    private String f8203b;

    /* renamed from: c  reason: collision with root package name */
    private int f8204c;

    public h(BaseALIoTDevice baseALIoTDevice, int i) {
        this.a = baseALIoTDevice;
        this.f8204c = i;
    }

    public BaseALIoTDevice a() {
        return this.a;
    }

    public String b() {
        return this.f8203b;
    }

    public int c() {
        return this.f8204c;
    }

    public h(String str, int i) {
        this.f8203b = str;
        this.f8204c = i;
    }
}
