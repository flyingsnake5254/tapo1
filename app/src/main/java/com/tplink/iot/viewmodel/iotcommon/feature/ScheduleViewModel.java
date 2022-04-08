package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.Utils.y;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class ScheduleViewModel extends AndroidViewModel {
    private IoTCommonFeatureRepository a;

    /* renamed from: b  reason: collision with root package name */
    private String f10234b;

    /* renamed from: c  reason: collision with root package name */
    private ThingContext f10235c;

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<Integer> f10236d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<Integer> f10237e = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MediatorLiveData<i<ScheduleRuleBean>> f10238f = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> g = new MediatorLiveData<>();
    private MediatorLiveData<Integer> h = new MediatorLiveData<>();
    private boolean i;
    private String j;
    private boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public BaseALIoTDevice s;

    /* loaded from: classes2.dex */
    class a implements Function<List<ThingRuleSchedule>, List<ScheduleRuleBean>> {
        a() {
        }

        /* renamed from: a */
        public List<ScheduleRuleBean> apply(List<ThingRuleSchedule> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (ThingRuleSchedule thingRuleSchedule : list) {
                    arrayList.add(new ScheduleRuleBean(thingRuleSchedule));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements io.reactivex.g0.g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (!IoTTransportException.isCancelException(th)) {
                ScheduleViewModel.this.g.postValue(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements io.reactivex.g0.g<ThingRuleUpdateResult> {
        c() {
        }

        /* renamed from: a */
        public void accept(ThingRuleUpdateResult thingRuleUpdateResult) throws Exception {
            ScheduleViewModel.this.G();
            if (thingRuleUpdateResult.getConflictId() == null) {
                ScheduleViewModel.this.f10236d.setValue(0);
            } else {
                ScheduleViewModel.this.f10236d.setValue(10000);
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                ScheduleViewModel.this.f10236d.setValue(-1012);
            } else {
                ScheduleViewModel.this.f10236d.setValue(Integer.valueOf(y.a(th)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements io.reactivex.g0.g<ThingRuleUpdateResult> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f10242c;

        e(boolean z) {
            this.f10242c = z;
        }

        /* renamed from: a */
        public void accept(ThingRuleUpdateResult thingRuleUpdateResult) throws Exception {
            ScheduleViewModel.this.G();
            if (thingRuleUpdateResult.getConflictId() == null) {
                ScheduleViewModel.this.f10237e.setValue(0);
            } else {
                ScheduleViewModel.this.f10237e.setValue(10000);
            }
            if (this.f10242c) {
                com.tplink.iot.Utils.x0.i.B(ScheduleViewModel.this.f10234b, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f10244c;

        f(boolean z) {
            this.f10244c = z;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                ScheduleViewModel.this.f10237e.setValue(-1012);
            } else {
                ScheduleViewModel.this.f10237e.setValue(Integer.valueOf(y.a(th)));
            }
            if (this.f10244c) {
                com.tplink.iot.Utils.x0.i.B(ScheduleViewModel.this.f10234b, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            ScheduleViewModel.this.G();
            ScheduleViewModel.this.f10238f.setValue(new i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class h implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScheduleRuleBean f10246c;

        h(ScheduleRuleBean scheduleRuleBean) {
            this.f10246c = scheduleRuleBean;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                ScheduleViewModel.this.f10238f.setValue(new i(-1012, this.f10246c));
            } else {
                ScheduleViewModel.this.f10238f.setValue(new i(-1, this.f10246c));
            }
        }
    }

    public ScheduleViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        boolean z = false;
        this.i = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.f10235c = thingContext;
        this.f10234b = thingContext.getDeviceIdMD5();
        this.a = (IoTCommonFeatureRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, IoTCommonFeatureRepository.class);
        this.s = thingContext.getIoTDevice();
        if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().getLocalIoTDevice() != null) {
            LocalIoTBaseDevice localIoTDevice = thingContext.getIoTDevice().getLocalIoTDevice();
            this.k = localIoTDevice.getComponentVersion(EnumIoTComponent.SCHEDULE) >= 2 ? true : z;
            this.i = localIoTDevice.isSupportComponent(EnumIoTComponent.DEVICE_LOCAL_TIME);
            this.j = localIoTDevice.getRegion();
            this.l = localIoTDevice.isSupportComponent(EnumIoTComponent.BRIGHTNESS);
            this.m = localIoTDevice.isSupportColorAndColorTemp();
            this.n = localIoTDevice.isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
            this.o = thingContext.getIoTDevice().isLightStrip();
            this.p = localIoTDevice.isSupportComponent(EnumIoTComponent.TEMP_CONTROL);
            this.q = localIoTDevice.isSupportComponent(EnumIoTComponent.FROST_PROTECTION);
            this.r = localIoTDevice.isSupportComponent(EnumIoTComponent.EARLY_START);
        }
    }

    @SuppressLint({"CheckResult"})
    private void n() {
        this.a.f1().l0(io.reactivex.d0.b.a.a()).C(new b()).F0();
    }

    public LiveData<i<ScheduleRuleBean>> A() {
        return this.f10238f;
    }

    public LiveData<List<ScheduleRuleBean>> B() {
        return Transformations.map(this.a.e1(), new a());
    }

    public LiveData<? extends LocalIoTBaseDevice> C() {
        if (this.f10235c.getIoTDevice() == null || !com.tplink.iot.g.d.a.b.k(this.f10235c.getIoTDevice())) {
            return new MutableLiveData();
        }
        return ((TRVRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, TRVRepository.class)).Y0();
    }

    public boolean D() {
        return this.k;
    }

    public boolean E() {
        return this.i;
    }

    public void F(String str, ScheduleRuleBean scheduleRuleBean) {
        com.tplink.iot.Utils.x0.i.i(str, scheduleRuleBean);
    }

    public void G() {
        n();
    }

    @SuppressLint({"CheckResult"})
    public void H(ScheduleRuleBean scheduleRuleBean) {
        this.a.w2(false, Arrays.asList(scheduleRuleBean.getId())).r(io.reactivex.d0.b.a.a()).A(new g(), new h(scheduleRuleBean));
    }

    @SuppressLint({"CheckResult"})
    public void k(ScheduleRuleBean scheduleRuleBean) {
        this.a.Q0(scheduleRuleBean.toThingRuleSchedule()).l0(io.reactivex.d0.b.a.a()).H0(new c(), new d());
    }

    public void l(ScheduleRuleBean scheduleRuleBean) {
        m(scheduleRuleBean, false);
    }

    @SuppressLint({"CheckResult"})
    public void m(ScheduleRuleBean scheduleRuleBean, boolean z) {
        this.a.T0(scheduleRuleBean.toThingRuleSchedule()).l0(io.reactivex.d0.b.a.a()).H0(new e(z), new f(z));
    }

    public String o() {
        if (this.f10235c.getIoTDevice() == null || !this.f10235c.getIoTDevice().isBulb()) {
            return null;
        }
        if (this.f10235c.getIoTDevice().isLightStrip()) {
            return ((LightStripRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, LightStripRepository.class)).q5();
        }
        return ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, BulbRepository.class)).n5();
    }

    public LiveData<List<Integer>> p() {
        if (this.f10235c.getIoTDevice() == null || !this.f10235c.getIoTDevice().isBulb()) {
            return new MutableLiveData();
        }
        return ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, BulbRepository.class)).o5();
    }

    public LiveData<List<LightStateBean>> r() {
        if (this.f10235c.getIoTDevice() == null || !this.f10235c.getIoTDevice().isBulb()) {
            return new MutableLiveData();
        }
        return ((BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, BulbRepository.class)).q5();
    }

    public int s(int i) {
        return p0.b(i, this.i, this.j);
    }

    public String t() {
        return this.j;
    }

    public int u(int i) {
        return p0.c(i, this.i, this.j);
    }

    public LiveData<Boolean> v() {
        return this.g;
    }

    public LiveData<List<LightStateBean>> w() {
        if (this.f10235c.getIoTDevice() == null || !this.f10235c.getIoTDevice().isLightStrip()) {
            return new MutableLiveData();
        }
        return ((LightStripRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(this.f10235c, LightStripRepository.class)).u5();
    }

    public LiveData<Integer> x() {
        return this.f10236d;
    }

    public LiveData<Integer> y() {
        return this.f10237e;
    }

    public int z() {
        return this.a.d1();
    }
}
