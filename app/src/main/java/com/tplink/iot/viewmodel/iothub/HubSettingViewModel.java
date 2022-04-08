package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HubSettingViewModel extends AndroidViewModel {
    private HubRepository a;

    /* renamed from: b  reason: collision with root package name */
    private IoTCommonFeatureRepository f10277b;

    /* renamed from: c  reason: collision with root package name */
    private TPIoTClientManager f10278c;

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<BaseALIoTDevice> f10279d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<i<CloudResult<Void>>> f10280e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<i<Void>> f10281f = new MutableLiveData<>();
    private MediatorLiveData<LedInfoBean> g = new MediatorLiveData<>();
    public ObservableBoolean h = new ObservableBoolean(false);

    /* loaded from: classes2.dex */
    class a implements Observer<List<BaseALIoTDevice>> {
        final /* synthetic */ ThingContext a;

        a(ThingContext thingContext) {
            this.a = thingContext;
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            HubSettingViewModel.this.f10279d.postValue(HubSettingViewModel.this.l(this.a.getDeviceIdMD5(), list));
        }
    }

    /* loaded from: classes2.dex */
    class b implements Observer<LedInfoBean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable LedInfoBean ledInfoBean) {
            HubSettingViewModel.this.g.postValue(ledInfoBean);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                HubSettingViewModel.this.f10281f.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                HubSettingViewModel.this.f10281f.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            HubSettingViewModel.this.f10281f.postValue(new i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                HubSettingViewModel.this.f10280e.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                HubSettingViewModel.this.f10280e.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            HubSettingViewModel.this.f10280e.postValue(new i(0, null));
        }
    }

    public HubSettingViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (HubRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, HubRepository.class);
        this.f10277b = (IoTCommonFeatureRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, IoTCommonFeatureRepository.class);
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.d.b.f.b.a(thingContext.getAccountContext(), TPIoTClientManager.class);
        this.f10278c = tPIoTClientManager;
        this.f10279d.addSource(tPIoTClientManager.C1(), new a(thingContext));
        this.g.addSource(this.f10277b.c1(), new b());
        this.h.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseALIoTDevice l(String str, List<BaseALIoTDevice> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                if (baseALIoTDevice.getDeviceIdMD5().equals(str)) {
                    return baseALIoTDevice;
                }
            }
        }
        return null;
    }

    public void f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f10278c.w(arrayList).i(new f()).j(new e()).y();
    }

    public LiveData<i<CloudResult<Void>>> m() {
        return this.f10280e;
    }

    public LiveData<BaseALIoTDevice> n() {
        return this.f10279d;
    }

    public void o() {
        if (this.a.D()) {
            this.a.i5().F0();
        }
    }

    public String p() {
        return (this.a.b() == null || this.a.b().getIoTDevice() == null) ? "" : this.a.b().getIoTDevice().getDeviceName();
    }

    public void r() {
        this.a.p1().F0();
    }

    public void s() {
        this.a.v1().F0();
    }

    public LiveData<ThingFirmware> t() {
        return this.a.w1();
    }

    public LiveData<IoTHubDevice> u() {
        return this.a.h5();
    }

    public void v() {
        this.f10277b.a1().F0();
    }

    public LiveData<LedInfoBean> w() {
        return this.g;
    }

    public LiveData<LoadInfoBean> x() {
        return this.a.n5();
    }

    public LiveData<i<Void>> y() {
        return this.f10281f;
    }

    public void z(String str) {
        this.f10278c.n1(str).L0(io.reactivex.l0.a.c()).E(new d()).C(new c()).F0();
    }
}
