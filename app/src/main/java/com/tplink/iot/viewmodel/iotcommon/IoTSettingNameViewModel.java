package com.tplink.iot.viewmodel.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.IoTNetwork.util.c;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class IoTSettingNameViewModel extends AndroidViewModel {
    private SingleLiveEvent<Integer> a = new SingleLiveEvent<>();

    /* renamed from: b  reason: collision with root package name */
    private AbstractThingRepository f10216b;

    /* renamed from: c  reason: collision with root package name */
    private AbstractSubThingRepository f10217c;

    /* renamed from: d  reason: collision with root package name */
    private final ThingContext f10218d;

    /* renamed from: e  reason: collision with root package name */
    private EnumDeviceType f10219e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10220f;

    /* loaded from: classes2.dex */
    class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            IoTSettingNameViewModel.this.a.postValue(0);
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
                IoTSettingNameViewModel.this.a.postValue(-1);
            }
        }
    }

    public IoTSettingNameViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.f10219e = EnumDeviceType.PLUG;
        this.f10220f = false;
        this.f10218d = thingContext;
        if (thingContext.getIoTDevice() != null) {
            this.f10219e = EnumDeviceType.fromType(thingContext.getIoTDevice().getDeviceType());
            this.f10220f = thingContext.getIoTDevice().isSubDevice();
        }
        ThingBaseRepository a2 = c.a(thingContext);
        if (a2 instanceof AbstractThingRepository) {
            this.f10216b = (AbstractThingRepository) a2;
        } else if (a2 instanceof AbstractSubThingRepository) {
            this.f10217c = (AbstractSubThingRepository) a2;
        } else {
            this.f10216b = (AbstractThingRepository) e.a(thingContext, PlugRepository.class);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThingRepository class: ");
        sb.append(a2 != null ? a2.getClass().getSimpleName() : "");
        b.d.w.c.a.e("DeviceCommon", sb.toString());
    }

    private String h() {
        return (this.f10218d.getIoTDevice() == null || this.f10218d.getIoTDevice().getDeviceModel() == null) ? "" : this.f10218d.getIoTDevice().getDeviceModel();
    }

    private String i() {
        return (this.f10218d.getIoTDevice() == null || this.f10218d.getIoTDevice().getDeviceName() == null) ? "" : this.f10218d.getIoTDevice().getDeviceName();
    }

    public String g(Context context) {
        EnumDeviceType enumDeviceType = this.f10219e;
        return enumDeviceType != null ? l.e(context, enumDeviceType.getDeviceType(), i(), h()) : "";
    }

    public String j() {
        return i();
    }

    @SuppressLint({"CheckResult"})
    public void k(String str) {
        io.reactivex.a aVar;
        if (this.f10220f) {
            AbstractSubThingRepository abstractSubThingRepository = this.f10217c;
            aVar = abstractSubThingRepository != null ? abstractSubThingRepository.a4(str) : io.reactivex.a.m(new Throwable("Null Device Repository"));
        } else {
            AbstractThingRepository abstractThingRepository = this.f10216b;
            aVar = abstractThingRepository != null ? abstractThingRepository.O4(str) : io.reactivex.a.m(new Throwable("Null Device Repository"));
        }
        aVar.r(io.reactivex.d0.b.a.a()).A(new a(), new b());
    }
}
