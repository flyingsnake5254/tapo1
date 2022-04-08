package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: PlugEnergyMonitorViewModel.kt */
/* loaded from: classes2.dex */
public final class PlugEnergyMonitorViewModel extends AndroidViewModel {
    private final f a;

    /* compiled from: PlugEnergyMonitorViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<PlugRepository> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThingContext f10325c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ThingContext thingContext) {
            super(0);
            this.f10325c = thingContext;
        }

        /* renamed from: a */
        public final PlugRepository invoke() {
            return (PlugRepository) e.a(this.f10325c, PlugRepository.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlugEnergyMonitorViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        f b2;
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
        b2 = i.b(new a(iotDeviceContext));
        this.a = b2;
    }

    private final PlugRepository g() {
        return (PlugRepository) this.a.getValue();
    }

    public final void f() {
        if (h().getValue() == null) {
            PlugRepository mPlugRepository = g();
            j.d(mPlugRepository, "mPlugRepository");
            mPlugRepository.f5().F0();
        }
    }

    public final LiveData<EnergyUsageResult> h() {
        PlugRepository mPlugRepository = g();
        j.d(mPlugRepository, "mPlugRepository");
        LiveData<EnergyUsageResult> g5 = mPlugRepository.g5();
        j.d(g5, "mPlugRepository.energyUsageLiveData");
        return g5;
    }
}
