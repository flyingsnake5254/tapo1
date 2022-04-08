package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.a;
import kotlin.jvm.internal.j;

/* compiled from: SensorSetReportIntervalViewModel.kt */
/* loaded from: classes2.dex */
public final class SensorSetReportIntervalViewModel extends AndroidViewModel {
    private final SensorRepository a;

    /* renamed from: b  reason: collision with root package name */
    private final LiveData<Integer> f10356b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SensorSetReportIntervalViewModel(Application application, ThingContext thingContext) {
        super(application);
        j.e(application, "application");
        j.e(thingContext, "thingContext");
        c a = e.a(thingContext, SensorRepository.class);
        j.d(a, "IoTDeviceRepositoryProvi…orRepository::class.java)");
        SensorRepository sensorRepository = (SensorRepository) a;
        this.a = sensorRepository;
        this.f10356b = sensorRepository.l4();
    }

    public final LiveData<Integer> f() {
        return this.f10356b;
    }

    public final a g(int i) {
        return this.a.p4(i);
    }
}
