package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.util.List;

/* compiled from: DiscoveryDeviceStrategy.java */
/* loaded from: classes2.dex */
public class b implements com.tplink.iot.view.home.f0.b.b {
    private final MutableLiveData<List<TDPIoTDevice>> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<TDPIoTDevice> f8539b;

    public b(MutableLiveData<List<TDPIoTDevice>> mutableLiveData, List<TDPIoTDevice> list) {
        this.a = mutableLiveData;
        this.f8539b = list;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public int a() {
        return 1150;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public String b() {
        return "dialog_flag_discovery_device";
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void clear() {
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void show() {
        this.a.postValue(this.f8539b);
    }
}
