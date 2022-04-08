package com.tplink.iot.viewmodel.iotbulb;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class BulbDetailViewModel extends AndroidViewModel {
    private BulbRepository a;

    /* renamed from: b  reason: collision with root package name */
    private MediatorLiveData<BaseALIoTDevice> f10151b = new MediatorLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<IoTBulbDevice> f10152c = new MediatorLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<ThingUsage> f10153d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> f10154e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<Boolean> f10155f = new MutableLiveData<>();
    private boolean g;
    private String h;
    private String i;
    private io.reactivex.e0.c j;
    private io.reactivex.e0.c k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements io.reactivex.g0.g<CloudConnectStateResult> {
        a() {
        }

        /* renamed from: a */
        public void accept(CloudConnectStateResult cloudConnectStateResult) throws Exception {
            BulbDetailViewModel.this.f10154e.postValue(new com.tplink.iot.viewmodel.quicksetup.i(0, cloudConnectStateResult));
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
            BulbDetailViewModel.this.f10151b.postValue(BulbDetailViewModel.this.p(this.a.getDeviceIdMD5(), list));
        }
    }

    /* loaded from: classes2.dex */
    class c implements Observer<IoTBulbDevice> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable IoTBulbDevice ioTBulbDevice) {
            BulbDetailViewModel.this.f10152c.postValue(ioTBulbDevice);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Observer<ThingUsage> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingUsage thingUsage) {
            BulbDetailViewModel.this.f10153d.postValue(thingUsage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Function<NextEvent, BulbNextEvent> {
        e() {
        }

        /* renamed from: a */
        public BulbNextEvent apply(NextEvent nextEvent) {
            return new BulbNextEvent(nextEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements io.reactivex.g0.g<Long> {
        f() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            BulbDetailViewModel.this.E();
            BulbDetailViewModel.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements io.reactivex.g0.a {
        final /* synthetic */ boolean a;

        g(boolean z) {
            this.a = z;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            BulbDetailViewModel.this.f10155f.postValue(Boolean.valueOf(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements io.reactivex.g0.g<Long> {
        h() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            if (BulbDetailViewModel.this.a.D()) {
                BulbDetailViewModel.this.A();
            } else if (BulbDetailViewModel.this.j != null) {
                BulbDetailViewModel.this.j.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements io.reactivex.g0.g<Long> {
        i() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            BulbDetailViewModel.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements io.reactivex.g0.g<Throwable> {
        j() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            BulbDetailViewModel.this.f10154e.postValue(new com.tplink.iot.viewmodel.quicksetup.i(1, null));
        }
    }

    public BulbDetailViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.g = false;
        this.i = thingContext.getDeviceIdMD5();
        this.a = (BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, BulbRepository.class);
        this.f10151b.addSource(((TPIoTClientManager) b.d.b.f.b.a(thingContext.getAccountContext(), TPIoTClientManager.class)).C1(), new b(thingContext));
        this.f10152c.addSource(this.a.r5(), new c());
        this.f10153d.addSource(this.a.t1(), new d());
        this.g = com.tplink.iot.Utils.w0.a.j(thingContext.getDeviceIdMD5());
        if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().getLocalIoTDevice() != null) {
            this.h = thingContext.getIoTDevice().getLocalIoTDevice().getRegion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(long j2) throws Exception {
        com.tplink.iot.Utils.x0.j.c(this.i, System.currentTimeMillis() - j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(long j2, Throwable th) throws Exception {
        com.tplink.iot.Utils.x0.j.c(this.i, System.currentTimeMillis() - j2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseALIoTDevice p(String str, List<BaseALIoTDevice> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                if (baseALIoTDevice.getDeviceIdMD5().equals(str)) {
                    return baseALIoTDevice;
                }
            }
        }
        return null;
    }

    @SuppressLint({"CheckResult"})
    public void A() {
        this.a.n1().L0(io.reactivex.l0.a.c()).F0();
    }

    public void B() {
        this.a.s1().L0(io.reactivex.l0.a.c()).F0();
    }

    public LiveData<ThingUsage> C() {
        return this.f10153d;
    }

    public LiveData<ThingFirmware> D() {
        return this.a.w1();
    }

    public void E() {
        this.a.x1().L0(io.reactivex.l0.a.c()).F0();
    }

    public LiveData<BulbNextEvent> F() {
        return Transformations.map(this.a.y1(), new e());
    }

    public void G() {
        this.a.p5().F0();
    }

    public boolean H() {
        return this.g;
    }

    @SuppressLint({"CheckResult"})
    public void M() {
        q.e0(1L, 3L, 0L, 2L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f());
    }

    public void N(AutoLightBean autoLightBean) {
        this.a.W5(autoLightBean).y();
    }

    public void O(int i2) {
        this.a.X5(i2).y();
    }

    public void P(boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.a.i(z).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.iotbulb.b
            @Override // io.reactivex.g0.a
            public final void run() {
                BulbDetailViewModel.this.J(currentTimeMillis);
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.iotbulb.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbDetailViewModel.this.L(currentTimeMillis, (Throwable) obj);
            }
        }).y();
    }

    public void Q(LightStateBean lightStateBean) {
        this.a.b6(lightStateBean).y();
    }

    public void R() {
        T();
        this.k = q.e0(1L, 2L, 0L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new i());
    }

    public void S() {
        io.reactivex.e0.c cVar = this.j;
        if (cVar != null) {
            cVar.dispose();
        }
        if (!this.a.D()) {
            A();
        } else {
            this.j = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new h());
        }
    }

    public void T() {
        io.reactivex.e0.c cVar = this.k;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public void U() {
        io.reactivex.e0.c cVar = this.j;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public void n(boolean z) {
        this.a.J0(z).i(new g(z)).y();
    }

    public void o(EditPresetRule editPresetRule) {
        this.a.j5(editPresetRule).y();
    }

    public LiveData<BaseALIoTDevice> r() {
        return this.f10151b;
    }

    public void s() {
        if (this.a.D()) {
            this.a.m5().F0();
        }
    }

    public LiveData<List<Integer>> t() {
        return this.a.o5();
    }

    public LiveData<IoTBulbDevice> u() {
        return this.f10152c;
    }

    public LiveData<Boolean> v() {
        return this.a.d1();
    }

    public LiveData<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> w() {
        return this.f10154e;
    }

    public void x() {
        this.a.b1().E(new a()).C(new j()).F0();
    }

    public LiveData<List<LightStateBean>> y() {
        return this.a.q5();
    }

    public String z() {
        return this.h;
    }
}
