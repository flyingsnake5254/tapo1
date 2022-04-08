package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.params.PlugDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* loaded from: classes3.dex */
public class PlugRepository extends AbstractThingRepository {
    private MutableLiveData<EnergyUsageResult> C = new MutableLiveData<>();

    /* loaded from: classes3.dex */
    class a implements Function<LocalIoTBaseDevice, IoTPlugDevice> {
        a() {
        }

        /* renamed from: a */
        public IoTPlugDevice apply(LocalIoTBaseDevice localIoTBaseDevice) {
            if (localIoTBaseDevice instanceof IoTPlugDevice) {
                return (IoTPlugDevice) localIoTBaseDevice;
            }
            return null;
        }
    }

    public PlugRepository(ThingContext thingContext) {
        super(thingContext, IoTPlugDevice.class, PlugDeviceRunningInfoResult.class);
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        if (ioTDevice == null || !(ioTDevice.getLocalIoTDevice() instanceof IoTPlugDevice)) {
            this.n.postValue(new IoTPlugDevice());
            return;
        }
        this.n.postValue((IoTPlugDevice) ioTDevice.getLocalIoTDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h5 */
    public /* synthetic */ t i5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.v0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName()).N(h8.f13265c);
        }
        return q.J(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j5 */
    public /* synthetic */ void k5(EnergyUsageResult energyUsageResult) throws Exception {
        this.C.postValue(energyUsageResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t l5(ThingUsage thingUsage) throws Exception {
        if (thingUsage.getEnergyUsage() == null) {
            return q.J(new Throwable("EnergyUsage is null."));
        }
        return q.f0(new EnergyUsageResult(thingUsage.getEnergyUsage()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository, com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository, com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void e() {
        this.f13333c.l();
        super.e();
    }

    public LiveData<IoTPlugDevice> e5() {
        return Transformations.map(super.j1(), new a());
    }

    public q<EnergyUsageResult> f5() {
        return y0("get_energy_usage", null, EnergyUsageResult.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.f8
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return PlugRepository.this.i5((Throwable) obj);
            }
        }).E(new g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.g8
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlugRepository.this.k5((EnergyUsageResult) obj);
            }
        });
    }

    public LiveData<EnergyUsageResult> g5() {
        return this.C;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.a i(boolean z) {
        return J4(new PlugDeviceInfoParams(Boolean.valueOf(z)));
    }

    public io.reactivex.a m5(DefaultStatesBean defaultStatesBean) {
        return G4(new PlugDeviceInfoParams(defaultStatesBean));
    }

    public io.reactivex.a n5(String str) {
        return G4(new PlugDeviceInfoParams(str));
    }
}
