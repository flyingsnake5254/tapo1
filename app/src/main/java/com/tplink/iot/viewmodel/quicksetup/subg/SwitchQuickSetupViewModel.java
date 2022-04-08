package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SubGQuickSetupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: SwitchQuickSetupViewModel.kt */
/* loaded from: classes3.dex */
public final class SwitchQuickSetupViewModel extends AndroidViewModel {
    public static final b a = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private String f11339d;
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g;
    private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h;
    private int i;
    private final MutableLiveData<Integer> j;
    private final LiveData<Integer> k;
    private io.reactivex.m0.e<Integer> l;
    private io.reactivex.e0.c m;
    private io.reactivex.e0.c n;
    private boolean o;
    private boolean p;
    private final ThingCloudRepository q;
    private final kotlin.f r;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<SwitchButton, ALIoTDevice> f11337b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<SwitchButton, a> f11338c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private String f11340e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f11341f = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f11342b;

        /* renamed from: c  reason: collision with root package name */
        private String f11343c;

        public a() {
            this(null, null, null, 7, null);
        }

        public a(String name, String avatar, String location) {
            kotlin.jvm.internal.j.e(name, "name");
            kotlin.jvm.internal.j.e(avatar, "avatar");
            kotlin.jvm.internal.j.e(location, "location");
            this.a = name;
            this.f11342b = avatar;
            this.f11343c = location;
        }

        public final String a() {
            return this.f11342b;
        }

        public final String b() {
            return this.a;
        }

        public final void c(String str) {
            kotlin.jvm.internal.j.e(str, "<set-?>");
            this.f11342b = str;
        }

        public final void d(String str) {
            kotlin.jvm.internal.j.e(str, "<set-?>");
            this.f11343c = str;
        }

        public final void e(String str) {
            kotlin.jvm.internal.j.e(str, "<set-?>");
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.j.a(this.a, aVar.a) && kotlin.jvm.internal.j.a(this.f11342b, aVar.f11342b) && kotlin.jvm.internal.j.a(this.f11343c, aVar.f11343c);
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f11342b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f11343c;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "ButtonSetupInfo(name=" + this.a + ", avatar=" + this.f11342b + ", location=" + this.f11343c + ")";
        }

        public /* synthetic */ a(String str, String str2, String str3, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
        }
    }

    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c<T, R> implements io.reactivex.g0.j<Long, t<? extends Boolean>> {
        c() {
        }

        /* renamed from: a */
        public final t<? extends Boolean> apply(Long it) {
            kotlin.jvm.internal.j.e(it, "it");
            return SwitchQuickSetupViewModel.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements io.reactivex.g0.g<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void accept(Boolean isFind) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByCloud doNext find: " + isFind);
            kotlin.jvm.internal.j.d(isFind, "isFind");
            if (isFind.booleanValue()) {
                SwitchQuickSetupViewModel.this.u();
            } else {
                SwitchQuickSetupViewModel.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class e<T> implements io.reactivex.g0.g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByCloud doOnError throwable: " + th);
            SwitchQuickSetupViewModel.this.H();
        }
    }

    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    static final class f<T> implements io.reactivex.g0.g<Integer> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Integer findType) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByTDPAndCloud doOnNext findType: " + findType);
            SwitchQuickSetupViewModel.this.r();
            SwitchQuickSetupViewModel switchQuickSetupViewModel = SwitchQuickSetupViewModel.this;
            kotlin.jvm.internal.j.d(findType, "findType");
            switchQuickSetupViewModel.R(findType.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class g<T> implements io.reactivex.g0.g<List<IoTSubDevice>> {
        g() {
        }

        /* renamed from: a */
        public final void accept(List<IoTSubDevice> list) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "getChildDeviceList list " + list.size());
            int i = 0;
            for (IoTSubDevice it : list) {
                kotlin.jvm.internal.j.d(it, "it");
                if (kotlin.jvm.internal.j.a(it.getOriginalDeviceId(), SwitchQuickSetupViewModel.this.f11340e)) {
                    i++;
                    SwitchButton a = SwitchButton.Companion.a(it.getPosition());
                    if (a != null) {
                        SwitchQuickSetupViewModel.this.X(a, it, null);
                    }
                }
            }
            if (i >= 2) {
                SwitchQuickSetupViewModel.this.W();
            } else {
                SwitchQuickSetupViewModel.this.J();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class h<T> implements io.reactivex.g0.g<Throwable> {
        h() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "getChildDeviceList error " + th);
            SwitchQuickSetupViewModel.this.J();
        }
    }

    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    static final class i extends Lambda implements kotlin.jvm.b.a<SubGQuickSetupRepository> {
        i() {
            super(0);
        }

        /* renamed from: a */
        public final SubGQuickSetupRepository invoke() {
            return (SubGQuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(SwitchQuickSetupViewModel.this.f11341f, SubGQuickSetupRepository.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class j<T, R> implements io.reactivex.g0.j<List<ThingInfo>, Boolean> {
        j() {
        }

        /* renamed from: a */
        public final Boolean apply(List<ThingInfo> thingInfoList) {
            kotlin.jvm.internal.j.e(thingInfoList, "thingInfoList");
            boolean z = false;
            int i = 0;
            for (ThingInfo info : thingInfoList) {
                kotlin.jvm.internal.j.d(info, "info");
                if (kotlin.jvm.internal.j.a(info.getOriginalThingName(), SwitchQuickSetupViewModel.this.f11340e)) {
                    i++;
                    SwitchButton a = SwitchButton.Companion.a(info.getPosition());
                    if (a != null) {
                        SwitchQuickSetupViewModel.this.X(a, null, new ThingDevice(info));
                    }
                }
            }
            if (i >= 2) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class k implements io.reactivex.g0.a {
        k() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoCloud onComplete");
            SwitchQuickSetupViewModel.this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class l<T> implements io.reactivex.g0.g<Throwable> {
        l() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoCloud onError");
            SwitchQuickSetupViewModel.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class m implements io.reactivex.g0.a {
        m() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoLocal onComplete");
            SwitchQuickSetupViewModel.this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchQuickSetupViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class n<T> implements io.reactivex.g0.g<Throwable> {
        n() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoLocal onError");
            SwitchQuickSetupViewModel.this.v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchQuickSetupViewModel(Application application) {
        super(application);
        kotlin.f b2;
        kotlin.jvm.internal.j.e(application, "application");
        MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> mutableLiveData = new MutableLiveData<>();
        this.g = mutableLiveData;
        this.h = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>(Integer.valueOf(this.i));
        this.j = mutableLiveData2;
        this.k = mutableLiveData2;
        b.d.b.f.a a2 = b.d.b.f.b.a(b.d.s.a.a.f(), ThingCloudRepository.class);
        kotlin.jvm.internal.j.d(a2, "CloudRepositoryProviders…udRepository::class.java)");
        this.q = (ThingCloudRepository) a2;
        b2 = kotlin.i.b(new i());
        this.r = b2;
    }

    private final void C() {
        this.m = E().Y0().E(new g()).C(new h()).F0();
    }

    private final SubGQuickSetupRepository E() {
        return (SubGQuickSetupRepository) this.r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        this.o = true;
        I(548);
    }

    private final void I(int i2) {
        io.reactivex.m0.e<Integer> eVar;
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "noFindDeviceResult errorCode: " + i2);
        if (this.p && this.o && (eVar = this.l) != null) {
            if (!(!eVar.j1())) {
                eVar = null;
            }
            if (eVar != null) {
                eVar.onNext(0);
                eVar.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "noTDPFindDeviceResult error");
        this.p = true;
        I(543);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q<Boolean> L() {
        q g0 = this.q.S().g0(new j());
        kotlin.jvm.internal.j.d(g0, "mThingCloudRepository.al… count >= 2\n            }");
        return g0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(int i2) {
        r();
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfo findType: " + i2);
        if (i2 == 1) {
            T();
        } else {
            S();
        }
    }

    private final void S() {
        SwitchButton[] values = SwitchButton.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (SwitchButton switchButton : values) {
            arrayList.add(E().g5(A(switchButton), B(switchButton), z(switchButton)));
        }
        SubThingQuickSetupInfoListParams subThingQuickSetupInfoListParams = new SubThingQuickSetupInfoListParams();
        subThingQuickSetupInfoListParams.setDataList(arrayList);
        E().o5(subThingQuickSetupInfoListParams).i(new k()).j(new l()).y();
    }

    private final void T() {
        SwitchButton[] values = SwitchButton.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (SwitchButton switchButton : values) {
            arrayList.add(E().p5(new DeviceInfoParams(B(switchButton), z(switchButton)), A(switchButton)));
        }
        io.reactivex.a.p(arrayList).i(new m()).j(new n()).y();
    }

    private final a V(SwitchButton switchButton) {
        a aVar = this.f11338c.get(switchButton);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(null, null, null, 7, null);
        this.f11338c.put(switchButton, aVar2);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "tdpFindDeviceResult success");
        this.p = true;
        y(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(SwitchButton switchButton, IoTSubDevice ioTSubDevice, ThingDevice thingDevice) {
        HashMap<SwitchButton, ALIoTDevice> hashMap = this.f11337b;
        ALIoTDevice aLIoTDevice = hashMap.get(switchButton);
        if (aLIoTDevice == null) {
            aLIoTDevice = new ALIoTDevice(ioTSubDevice);
            hashMap.put(switchButton, aLIoTDevice);
        }
        ALIoTDevice aLIoTDevice2 = aLIoTDevice;
        if (ioTSubDevice != null) {
            aLIoTDevice2.setLocalIoTDevice((LocalIoTBaseDevice) ioTSubDevice);
        }
        if (thingDevice != null) {
            aLIoTDevice2.setThingDevice(thingDevice);
        }
    }

    private final void s() {
        io.reactivex.e0.c cVar = this.n;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
    }

    private final void t() {
        io.reactivex.e0.c cVar = this.m;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.o = true;
        y(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        this.i++;
        this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        this.j.postValue(Integer.valueOf(this.i));
    }

    private final void w() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.n = q.W0(3L, timeUnit).N(new c()).T0(20L, timeUnit).E(new d()).C(new e()).F0();
    }

    private final void y(int i2) {
        io.reactivex.m0.e<Integer> eVar = this.l;
        if (eVar != null) {
            if (!(!eVar.j1())) {
                eVar = null;
            }
            if (eVar != null) {
                eVar.onNext(Integer.valueOf(i2));
                eVar.onComplete();
                if (!this.p) {
                    t();
                }
                if (!this.o) {
                    s();
                }
            }
        }
    }

    public final String A(SwitchButton button) {
        kotlin.jvm.internal.j.e(button, "button");
        ALIoTDevice aLIoTDevice = this.f11337b.get(button);
        String deviceId = aLIoTDevice != null ? aLIoTDevice.getDeviceId() : null;
        if (deviceId == null || deviceId.length() == 0) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "getButtonDeviceId concat");
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(button.getPos() - 1);
            String sb2 = sb.toString();
            return this.f11340e + sb2;
        }
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "getButtonDeviceId direct");
        return deviceId;
    }

    public final String B(SwitchButton button) {
        kotlin.jvm.internal.j.e(button, "button");
        return V(button).b();
    }

    public final String D() {
        String str = this.f11339d;
        return str != null ? str : "";
    }

    public final LiveData<Integer> F() {
        return this.k;
    }

    public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> G() {
        return this.h;
    }

    public final void K() {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "Switch QuickSetup Info: " + this.f11338c);
    }

    public final void M(SwitchButton button, String avatar) {
        kotlin.jvm.internal.j.e(button, "button");
        kotlin.jvm.internal.j.e(avatar, "avatar");
        V(button).c(avatar);
    }

    public final void N(SwitchButton button, String name) {
        kotlin.jvm.internal.j.e(button, "button");
        kotlin.jvm.internal.j.e(name, "name");
        V(button).e(name);
    }

    public final void O(String str) {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "setHubDeviceIdMD5: " + str);
        if (str == null) {
            str = "";
        }
        this.f11341f = str;
    }

    public final void P(SwitchButton button, String location) {
        kotlin.jvm.internal.j.e(button, "button");
        kotlin.jvm.internal.j.e(location, "location");
        V(button).d(location);
    }

    public final void Q(String location) {
        kotlin.jvm.internal.j.e(location, "location");
        this.f11339d = location;
        for (SwitchButton switchButton : SwitchButton.values()) {
            P(switchButton, location);
        }
    }

    public final void U(String str) {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "setSwitchDeviceId deviceId: " + str);
        if (str == null) {
            str = "";
        }
        this.f11340e = str;
    }

    public final void r() {
        t();
        s();
    }

    public final void x() {
        b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByTDPAndCloud setupInfo: " + this.f11338c);
        if (this.f11340e.length() == 0) {
            b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByTDPAndCloud false");
            this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
            return;
        }
        this.o = false;
        this.p = false;
        io.reactivex.m0.e<Integer> n1 = io.reactivex.m0.e.n1();
        n1.T0(30L, TimeUnit.SECONDS).q0(0).E(new f()).F0();
        p pVar = p.a;
        this.l = n1;
        w();
        C();
    }

    public final String z(SwitchButton button) {
        kotlin.jvm.internal.j.e(button, "button");
        return V(button).a();
    }
}
