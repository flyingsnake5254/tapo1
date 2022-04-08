package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;
import com.tplink.iot.model.iot.e;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SubGHubListViewModel extends SubGBaseViewModel {
    private final TPIoTClientManager a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, e> f11330b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final MediatorLiveData<List<e>> f11331c;

    public SubGHubListViewModel(@NonNull Application application) {
        super(application);
        MediatorLiveData<List<e>> mediatorLiveData = new MediatorLiveData<>();
        this.f11331c = mediatorLiveData;
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(a.f(), TPIoTClientManager.class);
        this.a = tPIoTClientManager;
        mediatorLiveData.addSource(tPIoTClientManager.C1(), new Observer() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubGHubListViewModel.this.l((List) obj);
            }
        });
    }

    private HubRepository i(@NonNull BaseALIoTDevice baseALIoTDevice) {
        return (HubRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), HubRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice.isHub()) {
                if (baseALIoTDevice.isOnline() && !baseALIoTDevice.isUserRoleTypeDevice()) {
                    arrayList.add(baseALIoTDevice);
                }
                t(baseALIoTDevice);
            }
        }
        s();
        k(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(BaseALIoTDevice baseALIoTDevice, LoadInfoBean loadInfoBean) throws Exception {
        u(baseALIoTDevice, loadInfoBean);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(BaseALIoTDevice baseALIoTDevice, ThingFirmware thingFirmware) throws Exception {
        v(baseALIoTDevice, thingFirmware);
        s();
    }

    private void s() {
        this.f11331c.postValue(new ArrayList(this.f11330b.values()));
    }

    private void t(@NonNull BaseALIoTDevice baseALIoTDevice) {
        e eVar = this.f11330b.get(baseALIoTDevice.getDeviceIdMD5());
        if (eVar == null) {
            this.f11330b.put(baseALIoTDevice.getDeviceIdMD5(), new e(baseALIoTDevice));
            return;
        }
        eVar.f(baseALIoTDevice);
    }

    private void u(@NonNull BaseALIoTDevice baseALIoTDevice, @NonNull LoadInfoBean loadInfoBean) {
        e eVar = this.f11330b.get(baseALIoTDevice.getDeviceIdMD5());
        if (eVar == null) {
            this.f11330b.put(baseALIoTDevice.getDeviceIdMD5(), new e(baseALIoTDevice, loadInfoBean, null));
            return;
        }
        eVar.g(loadInfoBean);
    }

    private void v(@NonNull BaseALIoTDevice baseALIoTDevice, @NonNull ThingFirmware thingFirmware) {
        e eVar = this.f11330b.get(baseALIoTDevice.getDeviceIdMD5());
        if (eVar == null) {
            this.f11330b.put(baseALIoTDevice.getDeviceIdMD5(), new e(baseALIoTDevice, null, thingFirmware));
            return;
        }
        eVar.e(thingFirmware);
    }

    public boolean f(@NonNull BaseALIoTDevice baseALIoTDevice) {
        return p.a(baseALIoTDevice, this.a.C1().getValue());
    }

    public MediatorLiveData<List<e>> g() {
        return this.f11331c;
    }

    public q<ThingFirmware> h(@NonNull BaseALIoTDevice baseALIoTDevice) {
        return i(baseALIoTDevice).v1();
    }

    public q<ThingSupportCategory> j(@NonNull BaseALIoTDevice baseALIoTDevice) {
        HubRepository i = i(baseALIoTDevice);
        List<SubThingCategoryBean> value = i.s5().getValue();
        String deviceFwVer = baseALIoTDevice.getDeviceFwVer();
        String k5 = i.k5();
        boolean z = value != null && !value.isEmpty() && TextUtils.equals(deviceFwVer, k5);
        b.d.w.c.a.d("currentFwVer: [" + deviceFwVer + "] fwVerOfSupportCategories: [" + k5 + "]");
        if (z) {
            b.d.w.c.a.d("Use Cache SupportSubCategoryList: " + i.f(value));
            ThingSupportCategory thingSupportCategory = new ThingSupportCategory();
            thingSupportCategory.setDeviceCategoryList(value);
            return q.f0(thingSupportCategory);
        }
        b.d.w.c.a.d("SupportSubCategoryList: null or empty. Request from hub.");
        return i.r5();
    }

    public void k(@NonNull List<BaseALIoTDevice> list) {
        for (final BaseALIoTDevice baseALIoTDevice : list) {
            HubRepository i = i(baseALIoTDevice);
            LoadInfoBean value = i.n5().getValue();
            if (value != null) {
                u(baseALIoTDevice, value);
            } else {
                i.j5().E(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.e
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        SubGHubListViewModel.this.o(baseALIoTDevice, (LoadInfoBean) obj);
                    }
                }).F0();
            }
            ThingFirmware value2 = i.w1().getValue();
            if (value2 != null) {
                v(baseALIoTDevice, value2);
            } else {
                i.v1().E(new g() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.d
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        SubGHubListViewModel.this.r(baseALIoTDevice, (ThingFirmware) obj);
                    }
                }).F0();
            }
        }
        s();
    }
}
