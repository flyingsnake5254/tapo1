package com.tplink.iot.viewmodel.iotplug;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.w;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class PlugSettingLocationViewModel extends AndroidViewModel {
    private PlugRepository a;

    /* renamed from: b  reason: collision with root package name */
    private SingleLiveEvent<Integer> f10328b = new SingleLiveEvent<>();

    /* loaded from: classes2.dex */
    class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            PlugSettingLocationViewModel.this.f10328b.postValue(0);
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                w.f();
            } else {
                PlugSettingLocationViewModel.this.f10328b.postValue(-1);
            }
        }
    }

    public PlugSettingLocationViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (PlugRepository) e.a(thingContext, PlugRepository.class);
    }

    public String g() {
        LocalIoTBaseDevice value = this.a.j1().getValue();
        return value != null ? value.getLocation() : "";
    }

    public SingleLiveEvent<Integer> h() {
        return this.f10328b;
    }

    @SuppressLint({"CheckResult"})
    public void i(String str) {
        this.a.n5(str).r(io.reactivex.d0.b.a.a()).A(new a(), new b());
    }
}
