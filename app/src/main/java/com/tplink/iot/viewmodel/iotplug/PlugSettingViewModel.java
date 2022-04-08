package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.o;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugSettingViewModel extends AndroidViewModel {
    private PlugRepository a;

    /* renamed from: b  reason: collision with root package name */
    private IoTCommonFeatureRepository f10330b;

    /* renamed from: c  reason: collision with root package name */
    private TPIoTClientManager f10331c;

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<BaseALIoTDevice> f10332d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<i<CloudResult<Void>>> f10333e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<i<Void>> f10334f = new MutableLiveData<>();
    private MediatorLiveData<LedInfoBean> g = new MediatorLiveData<>();
    public int h;

    /* loaded from: classes2.dex */
    class a implements Observer<List<BaseALIoTDevice>> {
        final /* synthetic */ ThingContext a;

        a(ThingContext thingContext) {
            this.a = thingContext;
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            PlugSettingViewModel.this.f10332d.postValue(PlugSettingViewModel.this.l(this.a.getDeviceIdMD5(), list));
        }
    }

    /* loaded from: classes2.dex */
    class b implements Observer<LedInfoBean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable LedInfoBean ledInfoBean) {
            PlugSettingViewModel.this.g.postValue(ledInfoBean);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                PlugSettingViewModel.this.f10334f.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                PlugSettingViewModel.this.f10334f.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            PlugSettingViewModel.this.f10334f.postValue(new i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                PlugSettingViewModel.this.f10333e.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                PlugSettingViewModel.this.f10333e.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            PlugSettingViewModel.this.f10333e.postValue(new i(0, null));
        }
    }

    public PlugSettingViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (PlugRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, PlugRepository.class);
        this.f10330b = (IoTCommonFeatureRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, IoTCommonFeatureRepository.class);
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.d.b.f.b.a(thingContext.getAccountContext(), TPIoTClientManager.class);
        this.f10331c = tPIoTClientManager;
        this.f10332d.addSource(tPIoTClientManager.C1(), new a(thingContext));
        this.g.addSource(this.f10330b.c1(), new b());
        if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().getLocalIoTDevice() != null) {
            this.h = thingContext.getIoTDevice().getLocalIoTDevice().getComponentVersion(EnumIoTComponent.DEVICE);
        }
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
        this.f10331c.w(arrayList).i(new f()).j(new e()).y();
    }

    public LiveData<i<CloudResult<Void>>> m() {
        return this.f10333e;
    }

    public LiveData<BaseALIoTDevice> n() {
        return this.f10332d;
    }

    public String o() {
        return (this.a.b() == null || this.a.b().getIoTDevice() == null) ? "" : this.a.b().getIoTDevice().getDeviceName();
    }

    public void p() {
        this.a.p1().F0();
    }

    public void r() {
        this.a.v1().F0();
    }

    public LiveData<ThingFirmware> s() {
        return this.a.w1();
    }

    public void t() {
        this.f10330b.a1().F0();
    }

    public LiveData<LedInfoBean> u() {
        return this.g;
    }

    public LiveData<IoTPlugDevice> v() {
        return this.a.e5();
    }

    public LiveData<i<Void>> w() {
        return this.f10334f;
    }

    public void x(String str) {
        o.u(this.f10332d.getValue());
        this.f10331c.n1(str).L0(io.reactivex.l0.a.c()).E(new d()).C(new c()).F0();
    }
}
