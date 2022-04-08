package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import java.util.List;

/* loaded from: classes2.dex */
public class TimerViewModel extends AndroidViewModel {
    private IoTCommonFeatureRepository a;

    /* renamed from: b  reason: collision with root package name */
    private MutableLiveData<Integer> f10248b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private ThingContext f10249c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10250d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10251e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10252f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    /* loaded from: classes2.dex */
    class a implements Function<ThingRuleTimer, CountdownRuleBean> {
        a() {
        }

        /* renamed from: a */
        public CountdownRuleBean apply(ThingRuleTimer thingRuleTimer) {
            return new CountdownRuleBean(thingRuleTimer);
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<ThingRuleUpdateResult> {
        b() {
        }

        /* renamed from: a */
        public void accept(ThingRuleUpdateResult thingRuleUpdateResult) throws Exception {
            if (TextUtils.isEmpty(thingRuleUpdateResult.getId())) {
                TimerViewModel.this.f10248b.postValue(-1);
            } else if (thingRuleUpdateResult.getConflictId() == null) {
                TimerViewModel.this.f10248b.postValue(0);
            } else {
                TimerViewModel.this.f10248b.postValue(10000);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                TimerViewModel.this.f10248b.postValue(-1012);
            } else {
                TimerViewModel.this.f10248b.postValue(-1);
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                TimerViewModel.this.f10248b.postValue(-1012);
            } else {
                TimerViewModel.this.f10248b.postValue(-1);
            }
        }
    }

    public TimerViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        boolean z = false;
        this.f10250d = false;
        this.f10251e = false;
        this.f10252f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.f10249c = thingContext;
        this.a = (IoTCommonFeatureRepository) e.a(thingContext, IoTCommonFeatureRepository.class);
        if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().getLocalIoTDevice() != null) {
            LocalIoTBaseDevice localIoTDevice = thingContext.getIoTDevice().getLocalIoTDevice();
            this.f10250d = localIoTDevice.getComponentVersion(EnumIoTComponent.COUNTDOWN) >= 2 ? true : z;
            this.f10251e = localIoTDevice.isSupportComponent(EnumIoTComponent.BRIGHTNESS);
            this.f10252f = localIoTDevice.isSupportColorAndColorTemp();
            this.g = localIoTDevice.isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
            this.h = thingContext.getIoTDevice().isLightStrip();
            this.i = localIoTDevice.isSupportComponent(EnumIoTComponent.TEMP_CONTROL);
            this.j = localIoTDevice.isSupportComponent(EnumIoTComponent.FROST_PROTECTION);
        }
    }

    @SuppressLint({"CheckResult"})
    public void g(CountdownRuleBean countdownRuleBean) {
        this.f10248b.postValue(1);
        this.a.P0(countdownRuleBean).l0(io.reactivex.d0.b.a.a()).H0(new b(), new c());
    }

    public String h() {
        if (this.f10249c.getIoTDevice() == null || !this.f10249c.getIoTDevice().isBulb()) {
            return null;
        }
        if (this.f10249c.getIoTDevice().isLightStrip()) {
            return ((LightStripRepository) e.a(this.f10249c, LightStripRepository.class)).q5();
        }
        ((BulbRepository) e.a(this.f10249c, BulbRepository.class)).n5();
        return null;
    }

    public LiveData<List<Integer>> i() {
        if (this.f10249c.getIoTDevice() == null || !this.f10249c.getIoTDevice().isBulb()) {
            return new MutableLiveData();
        }
        return ((BulbRepository) e.a(this.f10249c, BulbRepository.class)).o5();
    }

    public LiveData<List<LightStateBean>> j() {
        if (this.f10249c.getIoTDevice() == null || !this.f10249c.getIoTDevice().isBulb()) {
            return new MutableLiveData();
        }
        return ((BulbRepository) e.a(this.f10249c, BulbRepository.class)).q5();
    }

    public LiveData<CountdownRuleBean> k() {
        return Transformations.map(this.a.Y0(), new a());
    }

    public void l() {
        this.a.Z0().F0();
    }

    public int m() {
        Integer value = this.a.i1().getValue();
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public boolean n() {
        LocalIoTBaseDevice localIoTDevice;
        ThingContext b2 = this.a.b();
        if (b2 == null || b2.getIoTDevice() == null || (localIoTDevice = b2.getIoTDevice().getLocalIoTDevice()) == null) {
            return false;
        }
        return localIoTDevice.isDeviceOn();
    }

    public LiveData<List<LightStateBean>> o() {
        if (this.f10249c.getIoTDevice() == null || !this.f10249c.getIoTDevice().isLightStrip()) {
            return new MutableLiveData();
        }
        return ((LightStripRepository) e.a(this.f10249c, LightStripRepository.class)).u5();
    }

    public LiveData<Integer> p() {
        return this.f10248b;
    }

    public LiveData<? extends LocalIoTBaseDevice> r() {
        if (this.f10249c.getIoTDevice() == null || !com.tplink.iot.g.d.a.b.k(this.f10249c.getIoTDevice())) {
            return new MutableLiveData();
        }
        return ((TRVRepository) e.a(this.f10249c, TRVRepository.class)).Y0();
    }

    public boolean s() {
        return this.a.k1();
    }

    public boolean t() {
        return this.f10250d;
    }

    public void u(CountdownRuleBean countdownRuleBean) {
        this.a.S0(countdownRuleBean).C(new d()).F0();
    }
}
