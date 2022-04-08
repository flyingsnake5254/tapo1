package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.extension.g;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.iothub.a;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.j;

/* compiled from: HubAlarmLogViewModel.kt */
/* loaded from: classes2.dex */
public final class HubAlarmLogViewModel extends AndroidViewModel {
    private final HubRepository a;

    /* renamed from: b  reason: collision with root package name */
    private final TPIoTClientManager f10256b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10257c;

    /* renamed from: d  reason: collision with root package name */
    private final MediatorLiveData<List<com.tplink.iot.adapter.iothub.a>> f10258d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f10259e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f10260f;

    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<List<HubAlarmLog>> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(List<HubAlarmLog> list) {
            if (list != null) {
                HubAlarmLogViewModel.this.r(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final b a = new b();

        private b() {
        }

        public final String a(long j, TimeZone timeZone) {
            j.e(timeZone, "timeZone");
            return g.b(new Date(j), AppContext.f6185c, timeZone, null, 4, null);
        }

        public final String b(long j, TimeZone timeZone) {
            j.e(timeZone, "timeZone");
            return com.tplink.iot.Utils.extension.b.d(new Date(j), "MM.dd EEEE", timeZone, null, 4, null);
        }

        public final long c(long j, TimeZone timeZone) {
            j.e(timeZone, "timeZone");
            Date date = new Date(j);
            Calendar instance = Calendar.getInstance(timeZone);
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            j.d(instance, "calendar.apply {\n       …ISECOND, 0)\n            }");
            Date time = instance.getTime();
            j.d(time, "calendar.apply {\n       …ND, 0)\n            }.time");
            return time.getTime();
        }
    }

    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements io.reactivex.g0.g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            HubAlarmLogViewModel.this.f10259e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
        }
    }

    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d implements io.reactivex.g0.a {
        d() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            HubAlarmLogViewModel.this.f10259e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
    }

    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements io.reactivex.g0.g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            HubAlarmLogViewModel.this.f10259e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
        }
    }

    /* compiled from: HubAlarmLogViewModel.kt */
    /* loaded from: classes2.dex */
    static final class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            HubAlarmLogViewModel.this.f10259e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubAlarmLogViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        j.e(application, "application");
        j.e(iotDeviceContext, "iotDeviceContext");
        HubRepository mHubRepository = (HubRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(iotDeviceContext, HubRepository.class);
        this.a = mHubRepository;
        this.f10256b = (TPIoTClientManager) b.d.b.f.b.a(iotDeviceContext.getAccountContext(), TPIoTClientManager.class);
        String deviceIdMD5 = iotDeviceContext.getDeviceIdMD5();
        this.f10257c = deviceIdMD5 == null ? "" : deviceIdMD5;
        MediatorLiveData<List<com.tplink.iot.adapter.iothub.a>> mediatorLiveData = new MediatorLiveData<>();
        this.f10258d = mediatorLiveData;
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> mutableLiveData = new MutableLiveData<>();
        this.f10259e = mutableLiveData;
        this.f10260f = mutableLiveData;
        j.d(mHubRepository, "mHubRepository");
        mediatorLiveData.addSource(mHubRepository.f5(), new a());
    }

    private final List<BaseALIoTDevice<?>> j() {
        TPIoTClientManager mTPIoTClientManager = this.f10256b;
        j.d(mTPIoTClientManager, "mTPIoTClientManager");
        MutableLiveData<List<BaseALIoTDevice>> C1 = mTPIoTClientManager.C1();
        j.d(C1, "mTPIoTClientManager.allIoTDeviceLiveData");
        List<BaseALIoTDevice> value = C1.getValue();
        if (value == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            BaseALIoTDevice it = (BaseALIoTDevice) obj;
            j.d(it, "it");
            if (it.isSubDevice() && j.a(it.getParentDeviceIDMD5(), this.f10257c)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String l(String str, String str2) {
        if (str2 == null) {
            return str != null ? str : "";
        }
        List<BaseALIoTDevice<?>> j = j();
        BaseALIoTDevice baseALIoTDevice = null;
        if (j != null) {
            Iterator<T> it = j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (j.a(((BaseALIoTDevice) next).getDeviceId(), str2)) {
                    baseALIoTDevice = next;
                    break;
                }
            }
            baseALIoTDevice = baseALIoTDevice;
        }
        if (baseALIoTDevice == null) {
            return str != null ? str : "";
        }
        String c2 = l.c(getApplication(), baseALIoTDevice);
        j.d(c2, "DeviceCommonUtils.getDev…getApplication(), device)");
        return c2;
    }

    private final BaseALIoTDevice<?> n() {
        return this.f10256b.Z1(this.f10257c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(List<HubAlarmLog> list) {
        List<Number> N;
        List h;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BaseALIoTDevice<?> n = n();
        TimeZone deviceTimeZone = p0.d(n != null ? n.getDeviceRegion() : null);
        for (HubAlarmLog hubAlarmLog : list) {
            b bVar = b.a;
            long e2 = com.tplink.iot.Utils.extension.b.e(hubAlarmLog.getTimestamp());
            j.d(deviceTimeZone, "deviceTimeZone");
            long c2 = bVar.c(e2, deviceTimeZone);
            List list2 = (List) linkedHashMap.get(Long.valueOf(c2));
            if (list2 == null) {
                h = n.h(hubAlarmLog);
                linkedHashMap.put(Long.valueOf(c2), h);
            } else {
                list2.add(hubAlarmLog);
            }
        }
        N = v.N(linkedHashMap.keySet());
        ArrayList arrayList = new ArrayList();
        for (Number number : N) {
            long longValue = number.longValue();
            b bVar2 = b.a;
            j.d(deviceTimeZone, "deviceTimeZone");
            arrayList.add(new com.tplink.iot.adapter.iothub.a(1, bVar2.b(longValue, deviceTimeZone), null, 4, null));
            List<HubAlarmLog> list3 = (List) linkedHashMap.get(Long.valueOf(longValue));
            if (list3 != null) {
                for (HubAlarmLog hubAlarmLog2 : list3) {
                    arrayList.add(new com.tplink.iot.adapter.iothub.a(2, null, new a.b(b.a.a(com.tplink.iot.Utils.extension.b.e(hubAlarmLog2.getTimestamp()), deviceTimeZone), hubAlarmLog2.getEnumGuardMode(), l(hubAlarmLog2.getNickname(), hubAlarmLog2.getDeviceId())), 2, null));
                }
            }
        }
        this.f10258d.postValue(arrayList);
    }

    public final io.reactivex.a h() {
        io.reactivex.a G6 = this.a.G6();
        j.d(G6, "mHubRepository.removeAllAlarmLogs()");
        return G6;
    }

    public final LiveData<List<com.tplink.iot.adapter.iothub.a>> i() {
        return this.f10258d;
    }

    public final LiveData<Boolean> k() {
        HubRepository mHubRepository = this.a;
        j.d(mHubRepository, "mHubRepository");
        LiveData<Boolean> g5 = mHubRepository.g5();
        j.d(g5, "mHubRepository.canLoadMoreLiveData");
        return g5;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m() {
        return this.f10260f;
    }

    public final void o() {
        this.a.w6();
    }

    public final void p() {
        this.a.x6().j(new c()).i(new d()).y();
    }

    public final void s() {
        this.a.D6().j(new e()).i(new f()).y();
    }
}
