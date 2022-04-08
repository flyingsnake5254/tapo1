package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdListParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HubChildDeviceViewModel extends AndroidViewModel {
    private TPIoTClientManager a;

    /* renamed from: b  reason: collision with root package name */
    private HubRepository f10263b;

    /* renamed from: c  reason: collision with root package name */
    private String f10264c;

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<Integer> f10265d = new SingleLiveEvent<>();

    /* renamed from: e  reason: collision with root package name */
    private BaseALIoTDevice f10266e;

    public HubChildDeviceViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.f10264c = thingContext.getDeviceIdMD5();
        this.f10266e = thingContext.getIoTDevice();
        this.a = (TPIoTClientManager) b.a(thingContext.getAccountContext(), TPIoTClientManager.class);
        this.f10263b = (HubRepository) e.a(thingContext, HubRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ List m(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) it.next();
                if (baseALIoTDevice.isSubDevice() && TextUtils.equals(baseALIoTDevice.getParentDeviceIDMD5(), this.f10264c)) {
                    arrayList.add(new k(baseALIoTDevice));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(List list, DeviceIdListParams deviceIdListParams, c cVar) throws Exception {
        this.f10265d.postValue(0);
        this.a.m1(list);
        this.f10263b.H6(deviceIdListParams).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r() throws Exception {
        this.f10265d.postValue(1);
    }

    public boolean f() {
        return p.a(this.f10266e, this.a.C1().getValue());
    }

    public q<Boolean> g() {
        ThingFirmware value = this.f10263b.w1().getValue();
        if (value != null) {
            return q.f0(Boolean.valueOf(value.isNeedToUpgrade()));
        }
        return this.f10263b.v1().g0(a.f10286c);
    }

    public MutableLiveData<List<com.tplink.iot.model.home.e>> h() {
        return (MutableLiveData) Transformations.map(this.a.C1(), new Function() { // from class: com.tplink.iot.viewmodel.iothub.c
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return HubChildDeviceViewModel.this.m((List) obj);
            }
        });
    }

    public LiveData<a<BaseALIoTDevice>> i() {
        return this.a.T1();
    }

    public SingleLiveEvent<Integer> j() {
        return this.f10265d;
    }

    public void k() {
        this.f10263b.r5().F0();
    }

    public void s(final List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            arrayList.add(new DeviceIdBean(baseALIoTDevice.getDeviceId()));
        }
        final DeviceIdListParams deviceIdListParams = new DeviceIdListParams(arrayList);
        q.f0(Boolean.TRUE).F(new g() { // from class: com.tplink.iot.viewmodel.iothub.b
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubChildDeviceViewModel.this.o(list, deviceIdListParams, (c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.iothub.d
            @Override // io.reactivex.g0.a
            public final void run() {
                HubChildDeviceViewModel.this.r();
            }
        }).L0(io.reactivex.l0.a.c()).F0();
    }

    public void t(@NonNull BaseALIoTDevice baseALIoTDevice, boolean z) {
        if (baseALIoTDevice.isSwitch()) {
            ((SwitchRepository) e.d(baseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).i(z).y();
        }
    }
}
