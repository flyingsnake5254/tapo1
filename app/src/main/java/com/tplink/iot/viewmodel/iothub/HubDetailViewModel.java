package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.GuardModeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class HubDetailViewModel extends AndroidViewModel {
    private HubRepository a;

    /* renamed from: b  reason: collision with root package name */
    private MediatorLiveData<BaseALIoTDevice> f10267b = new MediatorLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private SingleLiveEvent<Boolean> f10268c = new SingleLiveEvent<>();

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<Boolean> f10269d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<i<CloudConnectStateResult>> f10270e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f10271f = new MutableLiveData<>();
    private io.reactivex.e0.c g;

    /* loaded from: classes2.dex */
    class a implements Observer<ThingFirmware> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingFirmware thingFirmware) {
            HubDetailViewModel.this.f10268c.postValue(Boolean.valueOf(thingFirmware != null && thingFirmware.isNeedToUpgrade()));
        }
    }

    /* loaded from: classes2.dex */
    class b implements Observer<List<BaseALIoTDevice>> {
        final /* synthetic */ ThingContext a;

        b(ThingContext thingContext) {
            this.a = thingContext;
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            HubDetailViewModel.this.f10267b.postValue(HubDetailViewModel.this.o(this.a.getDeviceIdMD5(), list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements g<Long> {
        c() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            if (HubDetailViewModel.this.a.D()) {
                HubDetailViewModel.this.v();
            } else if (HubDetailViewModel.this.g != null) {
                HubDetailViewModel.this.g.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements io.reactivex.g0.a {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            HubDetailViewModel.this.f10269d.postValue(Boolean.valueOf(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            HubDetailViewModel.this.f10270e.postValue(new i(1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements g<CloudConnectStateResult> {
        f() {
        }

        /* renamed from: a */
        public void accept(CloudConnectStateResult cloudConnectStateResult) throws Exception {
            HubDetailViewModel.this.f10270e.postValue(new i(0, cloudConnectStateResult));
        }
    }

    public HubDetailViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (HubRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, HubRepository.class);
        this.f10268c.addSource(this.a.w1(), new a());
        this.f10267b.addSource(((TPIoTClientManager) b.d.b.f.b.a(thingContext.getAccountContext(), TPIoTClientManager.class)).C1(), new b(thingContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Throwable th) throws Exception {
        this.f10271f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseALIoTDevice o(String str, List<BaseALIoTDevice> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                if (baseALIoTDevice.getDeviceIdMD5().equals(str)) {
                    return baseALIoTDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(GuardModeRuleResult guardModeRuleResult) throws Exception {
        boolean z;
        if (guardModeRuleResult.getRuleList() != null) {
            Iterator<ThingRuleGuardMode> it = guardModeRuleResult.getRuleList().iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                ThingRuleGuardMode next = it.next();
                if (next.getDeviceIdList() != null && !next.getDeviceIdList().isEmpty()) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            this.f10271f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.valueOf(z)));
            return;
        }
        this.f10271f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    public void D(String str, boolean z) {
        this.a.M6(new GuardModeParams(z, str)).y();
    }

    public void E() {
        io.reactivex.e0.c cVar = this.g;
        if (cVar != null) {
            cVar.dispose();
        }
        if (!this.a.D()) {
            v();
        } else {
            this.g = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new c());
        }
    }

    public void F() {
        this.a.P6().y();
    }

    public void G() {
        io.reactivex.e0.c cVar = this.g;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public void m(boolean z) {
        this.a.J0(z).i(new d(z)).y();
    }

    public void n() {
        if (this.a.l5().getValue() != null) {
            boolean z = true;
            Iterator<GuardModeConfigBean> it = this.a.l5().getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().getDeviceIdList().isEmpty()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f10271f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.valueOf(z)));
            return;
        }
        this.a.m5().E(new g() { // from class: com.tplink.iot.viewmodel.iothub.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubDetailViewModel.this.A((GuardModeRuleResult) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.iothub.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubDetailViewModel.this.C((Throwable) obj);
            }
        }).F0();
    }

    public LiveData<BaseALIoTDevice> p() {
        return this.f10267b;
    }

    public LiveData<i<CloudConnectStateResult>> r() {
        return this.f10270e;
    }

    public void s() {
        this.a.b1().E(new f()).C(new e()).F0();
    }

    public LiveData<IoTHubDevice> t() {
        return this.a.h5();
    }

    public String u() {
        return (this.a.b() == null || this.a.b().getIoTDevice() == null) ? "" : this.a.b().getIoTDevice().getDeviceName();
    }

    public void v() {
        this.a.k1().F0();
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> w() {
        return this.f10271f;
    }

    public LiveData<Boolean> x() {
        return this.f10268c;
    }

    public void y() {
        if (this.a.q5().getValue() == null) {
            this.a.p5().F0();
        }
    }
}
