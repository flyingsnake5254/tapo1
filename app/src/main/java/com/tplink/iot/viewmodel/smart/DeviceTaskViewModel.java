package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingService;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DeviceTaskViewModel extends AndroidViewModel {

    /* renamed from: d  reason: collision with root package name */
    private BulbRepository f11402d;

    /* renamed from: e  reason: collision with root package name */
    private LightStripRepository f11403e;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private ThingContext p;
    private MediatorLiveData<List<Integer>> a = new MediatorLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    private MediatorLiveData<List<LightStateBean>> f11400b = new MediatorLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<List<LightStateBean>> f11401c = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private ThingCloudRepository f11404f = (ThingCloudRepository) b.a(b.d.s.a.a.f(), ThingCloudRepository.class);

    /* loaded from: classes3.dex */
    class a implements Observer<List<LightStateBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<LightStateBean> list) {
            DeviceTaskViewModel.this.f11400b.postValue(list);
        }
    }

    public DeviceTaskViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        boolean z = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = thingContext;
        if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().isLightStrip()) {
            LightStripRepository lightStripRepository = (LightStripRepository) e.a(thingContext, LightStripRepository.class);
            this.f11403e = lightStripRepository;
            this.f11401c.addSource(lightStripRepository.u5(), new Observer() { // from class: com.tplink.iot.viewmodel.smart.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceTaskViewModel.this.w((List) obj);
                }
            });
        } else if (thingContext.getIoTDevice() != null && thingContext.getIoTDevice().isBulb()) {
            BulbRepository bulbRepository = (BulbRepository) e.a(thingContext, BulbRepository.class);
            this.f11402d = bulbRepository;
            this.a.addSource(bulbRepository.o5(), new Observer() { // from class: com.tplink.iot.viewmodel.smart.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceTaskViewModel.this.y((List) obj);
                }
            });
            this.f11400b.addSource(this.f11402d.q5(), new a());
        }
        if (!(thingContext.getIoTDevice() == null || thingContext.getIoTDevice().getLocalIoTDevice() == null)) {
            this.g = thingContext.getIoTDevice().getLocalIoTDevice().isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
        }
        ThingModel l = l();
        if (!(l == null || l.getProperties() == null)) {
            this.h = l.getThingProperty("on") != null;
            this.i = l.getThingProperty(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT) != null ? true : z;
        }
        HashMap hashMap = new HashMap();
        if (!(l == null || l.getServices() == null)) {
            for (ThingService thingService : l.getServices()) {
                hashMap.put(thingService.getId(), Boolean.TRUE);
            }
            this.j = hashMap.containsKey(ThingModelDefine.Service.SERVICE_REVERSE_STATUS);
            this.k = hashMap.containsKey(ThingModelDefine.Service.SERVICE_INCREASE_BRIGHTNESS);
            this.l = hashMap.containsKey(ThingModelDefine.Service.SERVICE_DECREASE_BRIGHTNESS);
            this.m = hashMap.containsKey(ThingModelDefine.Service.SERVICE_INCREASE_COLOR_TEMP);
            this.n = hashMap.containsKey(ThingModelDefine.Service.SERVICE_DECREASE_COLOR_TEMP);
            this.o = hashMap.containsKey(ThingModelDefine.Service.SERVICE_RANDOM_COLOR);
        }
        b.d.w.c.a.n("Smart", "ThingModel of " + this.p.getDeviceIdMD5() + SSLClient.WHITE_SPACE + i.j(l));
    }

    private ThingModel l() {
        ThingCloudRepository thingCloudRepository;
        ThingContext thingContext = this.p;
        if (thingContext == null) {
            return null;
        }
        if (thingContext.getThingModel() != null) {
            return this.p.getThingModel();
        }
        ThingDevice thingDevice = this.p.getThingDevice();
        if (thingDevice == null || (thingCloudRepository = this.f11404f) == null) {
            return null;
        }
        return thingCloudRepository.m0(thingDevice.getThingModelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(List list) {
        this.f11401c.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(List list) {
        this.a.postValue(list);
    }

    public String g() {
        LightStripRepository lightStripRepository = this.f11403e;
        if (lightStripRepository != null) {
            return lightStripRepository.q5();
        }
        BulbRepository bulbRepository = this.f11402d;
        if (bulbRepository != null) {
            return bulbRepository.n5();
        }
        return null;
    }

    public MediatorLiveData<List<Integer>> h() {
        return this.a;
    }

    public MediatorLiveData<List<LightStateBean>> i() {
        return this.f11400b;
    }

    public MediatorLiveData<List<LightStateBean>> j() {
        return this.f11401c;
    }

    public void k() {
        LightStripRepository lightStripRepository = this.f11403e;
        if (lightStripRepository != null) {
            lightStripRepository.w5().F0();
        }
        BulbRepository bulbRepository = this.f11402d;
        if (bulbRepository != null) {
            bulbRepository.p5().F0();
        }
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return this.h;
    }

    public boolean o() {
        return this.l;
    }

    public boolean p() {
        return this.n;
    }

    public boolean r() {
        return this.k;
    }

    public boolean s() {
        return this.m;
    }

    public boolean t() {
        return this.o;
    }

    public boolean u() {
        return this.j;
    }
}
