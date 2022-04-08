package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class AwayModeViewModel extends AndroidViewModel {
    private IoTCommonFeatureRepository a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10228b;

    /* renamed from: c  reason: collision with root package name */
    private String f10229c;

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<Integer> f10230d = new SingleLiveEvent<>();

    /* loaded from: classes2.dex */
    class a implements g<ThingRuleUpdateResult> {
        a() {
        }

        /* renamed from: a */
        public void accept(ThingRuleUpdateResult thingRuleUpdateResult) throws Exception {
            if (TextUtils.isEmpty(thingRuleUpdateResult.getId())) {
                AwayModeViewModel.this.f10230d.postValue(-1);
            } else if (thingRuleUpdateResult.getConflictId() == null) {
                AwayModeViewModel.this.f10230d.postValue(0);
            } else {
                AwayModeViewModel.this.f10230d.postValue(10000);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                AwayModeViewModel.this.f10230d.postValue(-1012);
            } else {
                AwayModeViewModel.this.f10230d.postValue(-1);
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
                AwayModeViewModel.this.f10230d.postValue(-1012);
            } else {
                AwayModeViewModel.this.f10230d.postValue(-1);
            }
        }
    }

    public AwayModeViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.f10228b = false;
        this.a = (IoTCommonFeatureRepository) e.a(thingContext, IoTCommonFeatureRepository.class);
        if (thingContext.getIoTDevice() != null) {
            ALIoTDevice ioTDevice = thingContext.getIoTDevice();
            this.f10228b = ioTDevice.isSupportDeviceLocalTime();
            if (ioTDevice.getLocalIoTDevice() != null) {
                this.f10229c = ioTDevice.getLocalIoTDevice().getRegion();
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public void g(ThingRuleAwayMode thingRuleAwayMode) {
        this.f10230d.postValue(1);
        this.a.O0(thingRuleAwayMode).l0(io.reactivex.d0.b.a.a()).H0(new a(), new b());
    }

    public LiveData<ThingRuleAwayMode> h() {
        return this.a.W0();
    }

    public void i() {
        this.a.X0().F0();
    }

    public int j(int i) {
        return p0.b(i, this.f10228b, this.f10229c);
    }

    public String k() {
        return this.f10229c;
    }

    public int l(int i) {
        return p0.c(i, this.f10228b, this.f10229c);
    }

    public SingleLiveEvent<Integer> m() {
        return this.f10230d;
    }

    public boolean n() {
        return this.a.j1();
    }

    public boolean o() {
        return this.f10228b;
    }

    public void p(ThingRuleAwayMode thingRuleAwayMode) {
        this.a.R0(thingRuleAwayMode).C(new c()).F0();
    }
}
