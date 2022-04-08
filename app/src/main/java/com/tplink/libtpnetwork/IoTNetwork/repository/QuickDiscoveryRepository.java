package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.c.c.a;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class QuickDiscoveryRepository extends AbstractIoTCloudRepository {
    private final Map<String, TDPIoTDevice> h = new ConcurrentHashMap();
    private final Set<String> i = new HashSet();
    private final Set<String> j = new HashSet();
    private final MutableLiveData<List<TDPIoTDevice>> k = new MutableLiveData<>();
    private final MutableLiveData<List<TDPIoTDevice>> l = new MutableLiveData<>();

    public QuickDiscoveryRepository(a aVar) {
        super(aVar);
    }

    private boolean A(@NonNull TDPIoTDevice tDPIoTDevice) {
        return this.j.contains(tDPIoTDevice.getDeviceIdMd5());
    }

    private static void B(String str) {
        b.d.w.c.a.n("QuickDiscovery", str);
    }

    private void E() {
        if (!this.h.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, TDPIoTDevice> entry : this.h.entrySet()) {
                if (!A(entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.i.clear();
            this.i.addAll(hashMap.keySet());
            ArrayList arrayList = new ArrayList(this.h.values());
            ArrayList arrayList2 = new ArrayList(hashMap.values());
            this.k.postValue(arrayList);
            this.l.postValue(arrayList2);
            B("sendDiscoveryDevicesData consumed: " + i.j(this.j));
            B("sendDiscoveryDevicesData new: " + i.j(hashMap));
            return;
        }
        this.k.postValue(new ArrayList());
        this.l.postValue(new ArrayList());
        B("sendDiscoveryDevicesData empty data");
    }

    private void G(TDPIoTDevice tDPIoTDevice) {
        boolean equals = "apple".equals(tDPIoTDevice.getObdSrc());
        boolean z = !TextUtils.isEmpty(tDPIoTDevice.getDeviceIdMd5());
        boolean isEmpty = TextUtils.isEmpty(tDPIoTDevice.getOwner());
        boolean z2 = !tDPIoTDevice.isFactoryDefault();
        if (equals && z && isEmpty && z2) {
            this.h.put(tDPIoTDevice.getDeviceIdMd5(), tDPIoTDevice);
        }
    }

    public void C() {
        B("markConsumedDevices");
        this.j.addAll(this.i);
        this.i.clear();
    }

    public void D(String str) {
        B("removeDiscoveryDevice deviceIdMD5: " + str);
        if (this.h.remove(str) != null) {
            this.j.remove(str);
            E();
        }
    }

    public void F() {
        B("startDiscovery");
    }

    public void H(Map<String, ? extends TDPIoTDevice> map) {
        B("storeThirdPartyOnboardingDevices " + i.f(map));
        for (Map.Entry<String, ? extends TDPIoTDevice> entry : map.entrySet()) {
            TDPIoTDevice tDPIoTDevice = (TDPIoTDevice) entry.getValue();
            if (!TextUtils.isEmpty(tDPIoTDevice.getObdSrc())) {
                G(tDPIoTDevice);
            }
        }
    }

    public void w() {
        B("completeDiscovery");
        E();
    }

    public boolean x() {
        return !this.h.isEmpty();
    }

    public LiveData<List<TDPIoTDevice>> y() {
        return this.k;
    }

    public LiveData<List<TDPIoTDevice>> z() {
        return this.l;
    }
}
