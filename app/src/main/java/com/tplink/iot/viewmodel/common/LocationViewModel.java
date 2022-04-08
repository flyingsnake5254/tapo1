package com.tplink.iot.viewmodel.common;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class LocationViewModel extends AndroidViewModel {
    private MediatorLiveData<Integer> a = new MediatorLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    private AbstractThingRepository f9943b;

    /* renamed from: c  reason: collision with root package name */
    private AbstractSubThingRepository f9944c;

    /* loaded from: classes2.dex */
    class a implements g<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            LocationViewModel.this.a.postValue(30);
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<DeviceLocationInfo> {
        b() {
        }

        /* renamed from: a */
        public void accept(DeviceLocationInfo deviceLocationInfo) throws Exception {
            if (deviceLocationInfo == null || deviceLocationInfo.getLatitude() == null || deviceLocationInfo.getLongitude() == null) {
                LocationViewModel.this.a.postValue(30);
                return;
            }
            int intValue = deviceLocationInfo.getLatitude().intValue();
            int intValue2 = deviceLocationInfo.getLongitude().intValue();
            if (com.tplink.iot.view.quicksetup.base.d.P(Integer.valueOf(intValue2), Integer.valueOf(intValue))) {
                LocationViewModel.this.i(intValue2, intValue);
            } else {
                LocationViewModel.this.a.postValue(30);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            LocationViewModel.this.a.postValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                LocationViewModel.this.a.postValue(-1012);
            } else {
                LocationViewModel.this.a.postValue(-1);
            }
        }
    }

    public LocationViewModel(@NonNull Application application, @NonNull ThingContext thingContext) {
        super(application);
        ThingBaseRepository c2 = com.tplink.libtpnetwork.IoTNetwork.util.c.c(thingContext);
        if (c2 instanceof AbstractThingRepository) {
            this.f9943b = (AbstractThingRepository) c2;
        } else if (c2 instanceof AbstractSubThingRepository) {
            this.f9944c = (AbstractSubThingRepository) c2;
        } else {
            this.f9943b = (AbstractThingRepository) e.a(thingContext, PlugRepository.class);
        }
    }

    public void g() {
        com.tplink.iot.view.quicksetup.base.f.c.h().g(AbstractTrafficShapingHandler.DEFAULT_MAX_TIME).E(new b()).C(new a()).F0();
    }

    public LiveData<Integer> h() {
        return this.a;
    }

    @SuppressLint({"CheckResult"})
    public void i(int i, int i2) {
        io.reactivex.a m = io.reactivex.a.m(new Throwable("Null Device Repository"));
        AbstractThingRepository abstractThingRepository = this.f9943b;
        if (abstractThingRepository != null) {
            m = abstractThingRepository.N4(i, i2);
        } else {
            AbstractSubThingRepository abstractSubThingRepository = this.f9944c;
            if (abstractSubThingRepository != null) {
                m = abstractSubThingRepository.Z3(i, i2);
            }
        }
        m.r(io.reactivex.d0.b.a.a()).A(new c(), new d());
    }
}
