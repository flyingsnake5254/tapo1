package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import kotlin.jvm.internal.j;

/* compiled from: SensorSetSensitivityViewModel.kt */
/* loaded from: classes2.dex */
public final class SensorSetSensitivityViewModel extends AndroidViewModel {
    private final ObservableInt a = new ObservableInt(1);

    /* renamed from: b  reason: collision with root package name */
    private int f10357b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final SingleLiveEvent<Boolean> f10358c = new SingleLiveEvent<>();

    /* renamed from: d  reason: collision with root package name */
    private final SingleLiveEvent<Integer> f10359d = new SingleLiveEvent<>();

    /* renamed from: e  reason: collision with root package name */
    private final SensorRepository f10360e;

    /* renamed from: f  reason: collision with root package name */
    private final MediatorLiveData<String> f10361f;
    private final LiveData<String> g;

    /* compiled from: SensorSetSensitivityViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<String> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(String str) {
            SensorSetSensitivityViewModel.this.f10361f.postValue(str);
        }
    }

    /* compiled from: SensorSetSensitivityViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            SensorSetSensitivityViewModel.this.l().setValue(0);
            SensorSetSensitivityViewModel sensorSetSensitivityViewModel = SensorSetSensitivityViewModel.this;
            sensorSetSensitivityViewModel.f10357b = sensorSetSensitivityViewModel.k().get();
        }
    }

    /* compiled from: SensorSetSensitivityViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            SensorSetSensitivityViewModel.this.k().set(SensorSetSensitivityViewModel.this.f10357b);
            SensorSetSensitivityViewModel.this.l().setValue(-1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SensorSetSensitivityViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.c a2 = e.a(iotDeviceContext, SensorRepository.class);
        j.d(a2, "IoTDeviceRepositoryProvi…orRepository::class.java)");
        SensorRepository sensorRepository = (SensorRepository) a2;
        this.f10360e = sensorRepository;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.f10361f = mediatorLiveData;
        this.g = mediatorLiveData;
        mediatorLiveData.addSource(sensorRepository.n4(), new a());
    }

    public final SingleLiveEvent<Boolean> i() {
        return this.f10358c;
    }

    public final LiveData<String> j() {
        return this.g;
    }

    public final ObservableInt k() {
        return this.a;
    }

    public final SingleLiveEvent<Integer> l() {
        return this.f10359d;
    }

    public final void m() {
        if (this.a.get() != this.f10357b) {
            this.f10358c.setValue(Boolean.TRUE);
        }
    }

    public final void n(String sensitivity) {
        j.e(sensitivity, "sensitivity");
        ObservableInt observableInt = this.a;
        int hashCode = sensitivity.hashCode();
        int i = 1;
        if (hashCode == -1039745817) {
            sensitivity.equals("normal");
        } else if (hashCode != 107348) {
            if (hashCode == 3202466 && sensitivity.equals("high")) {
                i = 2;
            }
        } else if (sensitivity.equals("low")) {
            i = 0;
        }
        observableInt.set(i);
        this.f10357b = this.a.get();
    }

    public final void o() {
        String str;
        int i = this.a.get();
        if (i == 0) {
            str = "low";
        } else if (i == 1) {
            str = "normal";
        } else if (i == 2) {
            str = "high";
        } else {
            return;
        }
        this.f10360e.q4(str).r(io.reactivex.d0.b.a.a()).i(new b()).j(new c()).y();
    }
}
