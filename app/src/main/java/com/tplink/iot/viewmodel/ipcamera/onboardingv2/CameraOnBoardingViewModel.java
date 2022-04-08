package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.i;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.n;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.v;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.model.CameraErrorCode;
import com.tplink.libtpnetwork.cameranetwork.business.repo.OnBoardingRepository;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.WifiList;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import com.tplink.libtpnetwork.cameranetwork.util.i;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class CameraOnBoardingViewModel extends AndroidViewModel {
    private Wifi C;
    private String D;
    private String E;
    private String F;
    private TDPCameraDevice H;
    private OnBoardingRepository I;
    private ALCameraDevice O;
    private CameraAvatarInfo P;
    private CameraComponent W;
    public String X;
    private io.reactivex.e0.c Z;
    private DeviceCloudProduct c0;
    public final ObservableField<String> a = new ObservableField<>("");

    /* renamed from: b  reason: collision with root package name */
    public final ObservableField<String> f10404b = new ObservableField<>("");

    /* renamed from: c  reason: collision with root package name */
    public final ObservableField<String> f10405c = new ObservableField<>("");

    /* renamed from: d  reason: collision with root package name */
    public final ObservableBoolean f10406d = new ObservableBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final ObservableBoolean f10407e = new ObservableBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    public final ObservableInt f10408f = new ObservableInt(0);
    public final ObservableInt g = new ObservableInt(0);
    public final ObservableList<ScanResult> h = new ObservableArrayList();
    public final ObservableList<Wifi> i = new ObservableArrayList();
    public final ObservableBoolean j = new ObservableBoolean(false);
    public final ObservableBoolean k = new ObservableBoolean(false);
    public final ObservableBoolean l = new ObservableBoolean(false);
    private List<WirelessInfoParams> m = new ArrayList();
    public final ObservableList<TDPCameraDevice> n = new ObservableArrayList();
    private int o = 10002;
    private boolean p = false;
    private boolean q = true;
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> r = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> s = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> t = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> u = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> v = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> w = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> x = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> y = new MutableLiveData<>();
    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> z = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> A = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> B = new MutableLiveData<>();
    private DeviceModel G = DeviceModel.CAMERA_C200;
    private io.reactivex.e0.b N = new io.reactivex.e0.b();
    private boolean Q = false;
    private TCDeviceBean R = null;
    private ThingDevice S = null;
    private BasicInfo T = null;
    private boolean U = false;
    private boolean V = false;
    public boolean Y = true;
    private boolean a0 = false;
    private boolean b0 = false;
    public final ObservableList<TDPCameraDevice> d0 = new ObservableArrayList();
    private TPIoTClientManager J = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    private ThingCloudRepository K = (ThingCloudRepository) b.d.b.f.b.a(b.d.s.a.a.f(), ThingCloudRepository.class);
    private TCDeviceRepository L = (TCDeviceRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCDeviceRepository.class);
    private FamilyManagerRepository M = (FamilyManagerRepository) b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class);

    /* loaded from: classes2.dex */
    class a implements l<Throwable> {
        a() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            if (!CameraOnBoardingViewModel.this.b0(th)) {
                return false;
            }
            b.d.w.c.a.d("scanCameraWifi NetInterruptException");
            e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class b implements l<Throwable> {
        b() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            if (!CameraOnBoardingViewModel.this.b0(th) || CameraOnBoardingViewModel.this.U) {
                return false;
            }
            e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class c implements l<Throwable> {
        c() {
        }

        /* renamed from: a */
        public boolean test(@NonNull Throwable th) throws Exception {
            if (!CameraOnBoardingViewModel.this.b0(th)) {
                return false;
            }
            e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class d implements l<Throwable> {
        d() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            if (!CameraOnBoardingViewModel.this.b0(th) || CameraOnBoardingViewModel.this.U) {
                return false;
            }
            e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements l<Throwable> {
        e() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return CameraOnBoardingViewModel.this.b0(th) && !CameraOnBoardingViewModel.this.U;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements j<List<TCDeviceBean>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10414c;

        f(String str) {
            this.f10414c = str;
        }

        /* renamed from: a */
        public Boolean apply(@NonNull List<TCDeviceBean> list) throws Exception {
            for (TCDeviceBean tCDeviceBean : list) {
                if (TextUtils.equals(this.f10414c, b.d.w.h.a.g(tCDeviceBean.getDeviceId()))) {
                    CameraOnBoardingViewModel.this.R = tCDeviceBean;
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.g<DeviceCloudProduct> {
        g() {
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            CameraOnBoardingViewModel.this.c0 = deviceCloudProduct;
        }
    }

    public CameraOnBoardingViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A0(Throwable th) throws Exception {
        b.d.w.c.a.d("camera findDeviceThroughIoTCloud---error");
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(Boolean bool) throws Exception {
        if (org.apache.commons.lang.b.b(bool)) {
            this.U = true;
            com.tplink.iot.Utils.x0.f.d(this.H);
            b.d.w.c.a.e("cameraIsSetFindDevice", "findDeviceThroughIoTCloud--- true");
            this.z.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public /* synthetic */ void C1(String str, String str2, Response response) throws Exception {
        T1(str, str2);
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        com.tplink.iot.Utils.x0.f.c(this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ Boolean E0(String str, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ThingDevice thingDevice = (ThingDevice) it.next();
            if (TextUtils.equals(str, b.d.w.h.a.g(thingDevice.getThingName()))) {
                this.S = thingDevice;
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1 */
    public /* synthetic */ void E1(Throwable th) throws Exception {
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        com.tplink.iot.Utils.x0.f.b(this.H);
    }

    @Nullable
    private String E() {
        TDPCameraDevice tDPCameraDevice = this.H;
        if (tDPCameraDevice != null && !TextUtils.isEmpty(tDPCameraDevice.getDeviceId())) {
            return this.H.getDeviceId();
        }
        TCDeviceBean tCDeviceBean = this.R;
        if (tCDeviceBean != null && !TextUtils.isEmpty(tCDeviceBean.getDeviceId())) {
            return this.R.getDeviceId();
        }
        ThingDevice thingDevice = this.S;
        if (thingDevice == null || TextUtils.isEmpty(thingDevice.getThingName())) {
            return null;
        }
        return this.S.getThingName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(CameraComponent cameraComponent) throws Exception {
        b.d.w.c.a.c("CameraComponent", "get component success");
        this.W = cameraComponent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int G1(Wifi wifi, Wifi wifi2) {
        if ((wifi.isWEP() || wifi2.isWEP()) && (!wifi.isWEP() || !wifi2.isWEP())) {
            return wifi.isWEP() ? 1 : -1;
        }
        return wifi2.getRssi() - wifi.getRssi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int H1(Wifi wifi, Wifi wifi2) {
        if ((wifi.isWEP() || wifi.isWPA3()) && wifi2.isCommon()) {
            return 1;
        }
        if (!wifi.isCommon() || (!wifi2.isWEP() && !wifi2.isWPA3())) {
            return wifi2.getRssi() - wifi.getRssi();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(CameraInfo cameraInfo) throws Exception {
        this.T = cameraInfo.getBasicInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I1 */
    public /* synthetic */ void J1(f4 f4Var) throws Exception {
        this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1 */
    public /* synthetic */ void L1(Throwable th) throws Exception {
        this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    private f4 M() {
        if (!g0() || this.S == null) {
            f4 f4Var = new f4();
            com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
            String c2 = n.c();
            TCDeviceBean tCDeviceBean = this.R;
            if (tCDeviceBean != null && !TextUtils.isEmpty(tCDeviceBean.getAppServerUrl())) {
                c2 = this.R.getAppServerUrl();
            }
            f4Var.h3(f2, this.H.getDeviceId(), c2);
            return f4Var;
        }
        TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), new ALCameraDevice(this.S));
        f4 f4Var2 = new f4();
        f4Var2.u(new com.tplink.libtpnetwork.cameranetwork.h4.n4.d(this.S.getThingName(), tPCameraDeviceContext));
        return f4Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public /* synthetic */ void N0(f4 f4Var) throws Exception {
        P1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean M1(ALCameraDevice aLCameraDevice, boolean z, String str, Object obj) throws Exception {
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
        if (cameraAvatarInfo == null) {
            cameraAvatarInfo = new CameraAvatarInfo();
            aLCameraDevice.setCameraAvatarInfo(cameraAvatarInfo);
        }
        cameraAvatarInfo.setAvatarDefault(Boolean.valueOf(z));
        cameraAvatarInfo.setAvatarName(str);
        cameraAvatarInfo.setAvatarNameModified(Boolean.FALSE);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(TPCameraDeviceContext tPCameraDeviceContext, Throwable th) throws Exception {
        if ((th instanceof CameraException) && CameraErrorCode.SESSION_EXPIRED.isEqual(((CameraException) th).getErrorCode())) {
            s2(tPCameraDeviceContext);
        }
    }

    private void P1() {
        this.I.G().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.e0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.R0((Boolean) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.m
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.T0((Throwable) obj);
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(Boolean bool) throws Exception {
        this.B.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(Throwable th) throws Exception {
        th.printStackTrace();
        this.B.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    private String T(String str) {
        return o.h0().V(str);
    }

    private void U(Response response, Throwable th) {
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ t V0(Boolean bool) throws Exception {
        return ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).s4(this.O);
    }

    private void V1() {
        TDPCameraDevice tDPCameraDevice = this.H;
        this.Z = v.e(AppContext.f6185c, null, 60, tDPCameraDevice == null ? null : tDPCameraDevice.getDeviceIdMd5(), this.j.get()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.a1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.d1((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.x
            @Override // io.reactivex.g0.a
            public final void run() {
                CameraOnBoardingViewModel.this.f1();
            }
        }).n(new TDPCameraDevice()).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.v
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.h1((TDPCameraDevice) obj);
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0() throws Exception {
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    private void X1(final String str, final String str2) {
        this.N.b(this.I.l().t2(this.f10405c.get(), x()).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(y0.f10497c).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.q0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.k1(str, str2, (Boolean) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.p0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.m1((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0(WifiList wifiList) throws Exception {
        if (wifiList != null) {
            b.d.w.c.a.a("Camera扫描到WiFi列表，Wpa3Supported为：" + wifiList.getWpa3Supported());
            this.k.set(wifiList.getWpa3Supported());
            boolean u2 = u2(wifiList.getWifiList());
            this.p = u2;
            this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.valueOf(u2)));
        }
    }

    private void Y1(int i) {
        this.N.b(this.I.I(new AutoUpdateInfo("on", r2(i), 120)).L0(io.reactivex.l0.a.c()).Z().v(1L, new e()).r(io.reactivex.d0.b.a.a()).i(u0.a).j(w.f10493c).y());
    }

    private void Z1(int i) {
        if (this.I != null) {
            this.N.b(M().o2(new AutoUpdateInfo("on", r2(i), 120)).H0(n.f10469c, y.f10496c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1(Throwable th) throws Exception {
        this.i.clear();
        this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b0(Throwable th) {
        return (th instanceof ConnectException) || (th instanceof IoTTransportException) || (th instanceof TimeoutException) || (th instanceof InterruptedIOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1(io.reactivex.e0.c cVar) throws Exception {
        this.a0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1() throws Exception {
        this.a0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(TDPCameraDevice tDPCameraDevice) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(tDPCameraDevice.getDeviceIdMd5())) {
            arrayList.add(tDPCameraDevice);
        }
        t(arrayList);
    }

    private void h2(final String str, final String str2) {
        if (this.I != null) {
            this.N.b(M().t2(str, str2).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.d1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.C1(str, str2, (Response) obj);
                }
            }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.n0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.E1((Throwable) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Response response) throws Exception {
        if (!Method.CHANGE_ADMIN_PASSWORD.getValue().equals(response.getMethod())) {
            return;
        }
        if (response.isSuccess()) {
            this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        } else {
            this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(String str, String str2, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            T1(str, str2);
            this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
            com.tplink.iot.Utils.x0.f.g(this.H);
            return;
        }
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        com.tplink.iot.Utils.x0.f.f(this.H);
    }

    private void k() {
        Account account = new Account(i.a(), i.c() != null ? i.c() : "", false);
        i.b d2 = com.tplink.libtpnetwork.cameranetwork.util.i.d();
        String formatRecordSchedules = ScheduleParser.formatRecordSchedules(Collections.singletonList(new Schedule(0, 0, 24, 0, 2)));
        RecordPlanInfo recordPlanInfo = new RecordPlanInfo(OptionSwitch.ON.toString(), formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules);
        f4 l = this.I.l();
        String c2 = this.b0 ? null : d2.c();
        String d3 = this.b0 ? null : d2.d();
        if (this.b0) {
            recordPlanInfo = null;
        }
        this.N.b(l.d3(account, c2, d3, recordPlanInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.t0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.j0((Response) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.o
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.l0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(Throwable th) throws Exception {
        this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(Throwable th) throws Exception {
        this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(f4 f4Var) throws Exception {
        k();
    }

    private void n(final boolean z) {
        this.I.s().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.r0(z, (Boolean) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.h0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.t0((Throwable) obj);
            }
        }).F0();
    }

    private void o() {
        ALCameraDevice aLCameraDevice = new ALCameraDevice(this.H);
        TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), aLCameraDevice);
        OnBoardingRepository onBoardingRepository = this.I;
        onBoardingRepository.n(tPCameraDeviceContext, new Account("guest", f0.a(aLCameraDevice.getDeviceMac()) + "softReset", false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS, true)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.k0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.v0((f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.z0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.x0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(TPCameraDeviceContext tPCameraDeviceContext, Throwable th) throws Exception {
        if (!(th instanceof CameraException) || !CameraErrorCode.SESSION_EXPIRED.isEqual(((CameraException) th).getErrorCode())) {
            this.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        } else {
            s2(tPCameraDeviceContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p1(Response response) throws Exception {
    }

    private void p2(List<Wifi> list) {
        if (this.k.get()) {
            Collections.sort(list, i0.f10456c);
        } else {
            Collections.sort(list, z.f10498c);
        }
        this.i.clear();
        this.i.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(boolean z, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.valueOf(z)));
            return;
        }
        this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        b.d.w.c.a.e("cameraIsFindDevice", "1111--- false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q1(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(int i, f4 f4Var) throws Exception {
        Y1(i);
    }

    private String r2(int i) {
        StringBuilder sb;
        String str;
        int i2 = (i / 60) % 24;
        int i3 = i % 60;
        if (i2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(i2);
        String sb2 = sb.toString();
        if (i3 < 10) {
            str = "0" + i3;
        } else {
            str = "" + i3;
        }
        return sb2 + SSLClient.COLON + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(Throwable th) throws Exception {
        if ((th instanceof CameraException) && ((CameraException) th).getErrorCode() == -40210) {
            this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
            b.d.w.c.a.e("cameraIsFindDevice", "1111--- false");
        }
        th.printStackTrace();
    }

    private void s2(TPCameraDeviceContext tPCameraDeviceContext) {
        this.N.b(this.I.m(tPCameraDeviceContext).L0(io.reactivex.l0.a.c()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.w0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.J1((f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.l
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.L1((Throwable) obj);
            }
        }));
    }

    private List<TDPCameraDevice> t(List<TDPCameraDevice> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.o;
        if (i == 10002) {
            Iterator<TDPCameraDevice> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TDPCameraDevice next = it.next();
                if (next.getMac() != null) {
                    t2(next);
                    W();
                    if (TextUtils.isEmpty(next.getOwner())) {
                        m();
                        arrayList.add(next);
                        break;
                    } else if (!this.j.get() || !next.isResetWiFi()) {
                        if (TextUtils.equals("192.168.191.1", next.getIp())) {
                            q2();
                            e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
                            if (b.d.q.b.i.b() == null || !next.getOwner().equals(b.d.w.h.a.g(b.d.q.b.i.b()).toUpperCase())) {
                                o();
                            } else {
                                n(true);
                            }
                        }
                    } else if (b.d.q.b.i.b() == null || !next.getOwner().equals(b.d.w.h.a.g(b.d.q.b.i.b()).toUpperCase())) {
                        this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
                    } else {
                        this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
                    }
                }
            }
        } else if (i == 10003) {
            Iterator<TDPCameraDevice> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TDPCameraDevice next2 = it2.next();
                if (this.H != null && TextUtils.equals(next2.getMac(), this.H.getMac()) && !TextUtils.isEmpty(next2.getConnectSsid())) {
                    arrayList.add(next2);
                    this.H = next2;
                    this.V = true;
                    this.z.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
                    b.d.w.c.a.e("cameraIsSetFindDevice", "3333333333333--- true");
                    q2();
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1(Throwable th) throws Exception {
        U(null, th);
    }

    private void t2(TDPCameraDevice tDPCameraDevice) {
        this.H = tDPCameraDevice;
        DeviceModel fromValue = DeviceModel.fromValue(tDPCameraDevice.getDeviceModel());
        if (fromValue == null || fromValue == DeviceModel.CAMERA_OTHER) {
            fromValue = DeviceModel.CAMERA_C200;
        }
        DeviceModel deviceModel = this.G;
        if (deviceModel != null && deviceModel != fromValue) {
            f2(fromValue);
            b.d.w.c.a.e("cameraModelNotMatch", "go on config...");
        }
    }

    private q<Boolean> u(String str) {
        return this.L.y().g0(new f(str)).q0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(f4 f4Var) throws Exception {
        n(false);
    }

    private boolean u2(List<Wifi> list) {
        p2(list);
        ArrayList<Wifi> arrayList = new ArrayList();
        for (Wifi wifi : list) {
            for (WirelessInfoParams wirelessInfoParams : this.m) {
                if (TextUtils.equals(wifi.getSsid(), wirelessInfoParams.getSsid())) {
                    arrayList.add(wifi);
                }
            }
        }
        boolean z = false;
        if (arrayList.size() == 0) {
            return false;
        }
        Wifi wifi2 = null;
        int i = 0;
        for (Wifi wifi3 : arrayList) {
            if (wifi3.getRssi() > i) {
                i = wifi3.getRssi();
                wifi2 = wifi3;
            }
        }
        if (wifi2 != null) {
            ObservableBoolean observableBoolean = this.f10406d;
            if (wifi2.getAuth() != 0) {
                z = true;
            }
            observableBoolean.set(z);
            this.C = wifi2;
            String str = "";
            this.a.set(!TextUtils.isEmpty(wifi2.getSsid()) ? wifi2.getSsid() : str);
            String T = T(wifi2.getSsid());
            if (wifi2.getAuth() == 0 && !TextUtils.isEmpty(T)) {
                o.h0().r0(new WirelessInfoParams(this.a.get(), str, str));
                T = str;
            }
            ObservableField<String> observableField = this.f10404b;
            if (!TextUtils.isEmpty(T)) {
                str = T;
            }
            observableField.set(str);
            this.f10407e.set(!TextUtils.isEmpty(T));
        }
        return true;
    }

    private q<Boolean> v2(final ALCameraDevice aLCameraDevice, final String str, final boolean z) {
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        String deviceId = aLCameraDevice.getDeviceId();
        String cloudUserName = f2.c().getCloudUserName();
        String token = f2.c().getToken();
        this.E = str;
        DeviceFeatureInfo deviceFeatureInfo = new DeviceFeatureInfo();
        deviceFeatureInfo.setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
        deviceFeatureInfo.setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(z), str));
        return ((TCDeviceRepository) b.d.b.f.b.c(f2).a(TCDeviceRepository.class)).X(cloudUserName, deviceId, JsonUtils.g(deviceFeatureInfo), token).C(io.reactivex.l0.a.c()).J().g0(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.s
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CameraOnBoardingViewModel.M1(ALCameraDevice.this, z, str, obj);
            }
        });
    }

    private q<Boolean> w(final String str) {
        return this.K.U().g0(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.k
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CameraOnBoardingViewModel.this.E0(str, (List) obj);
            }
        }).q0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(Throwable th) throws Exception {
        th.printStackTrace();
        if ((th instanceof CameraException) && ((CameraException) th).getErrorCode() == -40411) {
            this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
            b.d.w.c.a.e("cameraIsFindDevice", "1111--- false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public /* synthetic */ void y1(String str, String str2, f4 f4Var) throws Exception {
        X1(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ t z0(Boolean bool) throws Exception {
        if (org.apache.commons.lang.b.b(bool)) {
            return M().K().i(m.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.c1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.J0((CameraInfo) obj);
                }
            }).g0(m0.f10468c);
        }
        return q.f0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z1 */
    public /* synthetic */ void A1(Throwable th) throws Exception {
        U(null, th);
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> A() {
        return this.t;
    }

    public TDPCameraDevice B() {
        return this.H;
    }

    public String C() {
        return this.E;
    }

    public DeviceModel D() {
        return this.G;
    }

    public String F() {
        TDPCameraDevice tDPCameraDevice = this.H;
        return tDPCameraDevice != null ? tDPCameraDevice.getHardwareVer() : "";
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> G() {
        return this.r;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> H() {
        return this.y;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> I() {
        return this.v;
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> J() {
        return this.B;
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> K() {
        return this.A;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> L() {
        return this.s;
    }

    public OnBoardingRepository N() {
        return this.I;
    }

    public void N1() {
        List<WirelessInfoParams> z = o.h0().z();
        this.m.clear();
        this.m.addAll(z);
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> O() {
        return this.u;
    }

    public q<Boolean> O1() {
        e0.a(AppContext.f6185c);
        return q.W0(5L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).g0(l0.f10466c);
    }

    public String P() {
        return this.F;
    }

    public String Q() {
        return this.D;
    }

    @SuppressLint({"CheckResult"})
    public void Q1(boolean z) {
        if (this.I == null) {
            W();
        }
        if (z) {
            P1();
            return;
        }
        ALCameraDevice aLCameraDevice = new ALCameraDevice(this.H);
        final TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), aLCameraDevice);
        OnBoardingRepository onBoardingRepository = this.I;
        onBoardingRepository.n(tPCameraDeviceContext, new Account("guest", f0.a(aLCameraDevice.getDeviceMac()) + "softReset", false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS, true)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.r
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.N0((f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.u
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.P0(tPCameraDeviceContext, (Throwable) obj);
            }
        });
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> R() {
        return this.x;
    }

    public void R1() {
        String mac;
        int length;
        TDPCameraDevice tDPCameraDevice = this.H;
        if (tDPCameraDevice != null && (mac = tDPCameraDevice.getMac()) != null && (length = mac.length()) >= 4) {
            ObservableField<String> observableField = this.f10405c;
            observableField.set(this.H.getDeviceName() + "_" + mac.substring(length - 4, length));
        }
    }

    public int S() {
        DeviceCloudProduct deviceCloudProduct = this.c0;
        return (deviceCloudProduct != null && deviceCloudProduct.getTrialQualified()) ? 0 : 8;
    }

    public void S1() {
        this.C = null;
        this.H = null;
        this.S = null;
        this.R = null;
        this.T = null;
        this.W = null;
        this.a.set("");
        this.f10404b.set("");
        this.d0.clear();
        this.f10405c.set("");
        this.I = null;
        this.h.clear();
        this.j.set(false);
        this.U = false;
        this.V = false;
        Boolean bool = Boolean.FALSE;
        this.v = new MutableLiveData<>(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(bool, true));
        this.z = new MutableLiveData<>(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(bool, true));
        this.b0 = false;
        this.A = new MutableLiveData<>(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(bool, true));
    }

    public void T1(String str, String str2) {
        if (!g0()) {
            this.H.setOwner(com.tplink.libtpnetwork.cameranetwork.util.j.a(b.d.s.a.a.f().c().getCloudUserName()));
            this.O.setTDPIoTDevice(this.H);
            this.O.setCameraAvatarInfo(this.P);
            v2(this.O, this.P.getAvatarName(), true).q0(Boolean.TRUE).N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.g0
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return CameraOnBoardingViewModel.this.V0((Boolean) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.t
                @Override // io.reactivex.g0.a
                public final void run() {
                    CameraOnBoardingViewModel.this.X0();
                }
            }).F0();
        }
    }

    public void U1() {
        OnBoardingRepository onBoardingRepository = this.I;
        if (onBoardingRepository != null) {
            this.N.b(onBoardingRepository.H().v0(1L, new a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.f0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.Z0((WifiList) obj);
                }
            }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.j0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.b1((Throwable) obj);
                }
            }));
            return;
        }
        this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    public boolean V() {
        return this.Q;
    }

    public void W() {
        TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), new ALCameraDevice(this.H));
        if (this.H != null) {
            this.I = (OnBoardingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(tPCameraDeviceContext, OnBoardingRepository.class);
        }
    }

    public void W1() {
        V1();
    }

    public boolean X() {
        return com.tplink.iot.Utils.v0.d.a();
    }

    public boolean Y(String str) {
        return TextUtils.equals(SSLClient.DOUBLE_QUOTATION + str + SSLClient.DOUBLE_QUOTATION, com.tplink.libtpwifi.b.k().l());
    }

    public boolean Z() {
        return this.W != null;
    }

    public boolean a0() {
        return this.b0;
    }

    public void a2(final int i) {
        if (this.U) {
            Z1(i);
        }
        Account account = new Account("admin", b.d.q.b.i.c() != null ? b.d.q.b.i.c() : "", false);
        this.O = new ALCameraDevice(this.H);
        this.N.b(this.I.n(new TPCameraDeviceContext(b.d.s.a.a.f(), this.O), account).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS)).v0(1L, new d()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.b0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.s1(i, (f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.o0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.u1((Throwable) obj);
            }
        }));
    }

    public void b2(CameraAvatarInfo cameraAvatarInfo) {
        this.P = cameraAvatarInfo;
    }

    public boolean c0(String str, int i) {
        if (i == 0) {
            return false;
        }
        return !b.d.w.e.b.b(str);
    }

    public void c2(Wifi wifi) {
        this.C = wifi;
    }

    public boolean d0() {
        String l = com.tplink.libtpwifi.b.k().l();
        StringBuilder sb = new StringBuilder();
        sb.append(SSLClient.DOUBLE_QUOTATION);
        sb.append(this.D);
        sb.append(SSLClient.DOUBLE_QUOTATION);
        return TextUtils.equals(l, sb.toString()) && com.tplink.iot.view.ipcamera.base.e.a(getApplication());
    }

    public void d2() {
        if (this.I != null) {
            boolean g0 = g0();
            if (a0.j() && g0) {
                this.N.b(this.I.J(a0.a()).w0(new c()).H0(b1.f10434c, p.f10473c));
            }
        }
    }

    public boolean e0(String str) {
        return TextUtils.isEmpty(str) || str.length() > 32 || str.length() == 0;
    }

    public void e2(TDPCameraDevice tDPCameraDevice) {
        this.H = tDPCameraDevice;
    }

    public boolean f0() {
        CameraComponent cameraComponent = this.W;
        return cameraComponent != null && cameraComponent.isSupportFwAutoUpdate();
    }

    public void f2(DeviceModel deviceModel) {
        this.G = deviceModel;
    }

    public boolean g0() {
        TDPCameraDevice tDPCameraDevice = this.H;
        if (tDPCameraDevice != null) {
            return tDPCameraDevice.isSupportIoTCloud();
        }
        CameraComponent cameraComponent = this.W;
        if (cameraComponent != null) {
            return cameraComponent.isSupportIoTCloud();
        }
        return false;
    }

    public void g2() {
        final String str = this.f10405c.get();
        final String x = x();
        if (this.U) {
            h2(str, x);
        }
        Account account = new Account("admin", b.d.q.b.i.c() != null ? b.d.q.b.i.c() : "", false);
        this.O = new ALCameraDevice(this.H);
        this.N.b(this.I.n(new TPCameraDeviceContext(b.d.s.a.a.f(), this.O), account).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS)).v0(1L, new b()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.q
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.y1(str, x, (f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.s0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.A1((Throwable) obj);
            }
        }));
    }

    public boolean h0() {
        return this.a0;
    }

    public void i2(boolean z) {
        this.Q = z;
    }

    public void j() {
        String E = E();
        b.d.w.c.a.n("HomeSort", "addCameraToCurrentFamilyCommonSortList deviceId: " + E);
        if (!TextUtils.isEmpty(E)) {
            this.M.O0(Collections.singletonList(E));
        }
    }

    public void j2(boolean z) {
        this.b0 = z;
    }

    public void k2() {
        if (this.I != null) {
            this.N.b(this.I.K(Locale.getDefault().toString().startsWith("en_") ? "EN" : "other").C(v0.f10492c).F0());
        }
    }

    public void l() {
        TDPCameraDevice tDPCameraDevice = this.H;
        if (tDPCameraDevice == null) {
            U(null, new RuntimeException("currentDevice is null"));
            return;
        }
        this.O = new ALCameraDevice(tDPCameraDevice);
        final TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), this.O);
        OnBoardingRepository onBoardingRepository = this.I;
        if (onBoardingRepository == null) {
            U(null, new RuntimeException("repository is null"));
            return;
        }
        this.N.b(onBoardingRepository.n(tPCameraDeviceContext, new Account("admin", "admin", false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, PathInterpolatorCompat.MAX_NUM_POINTS, true)).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.c0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.n0((f4) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.r0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraOnBoardingViewModel.this.p0(tPCameraDeviceContext, (Throwable) obj);
            }
        }));
    }

    public void l2(String str) {
        this.F = str;
    }

    public void m() {
        e0.b(AppContext.f6185c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
        this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        b.d.w.c.a.e("cameraIsFindDevice", "2222222222--- true");
    }

    public void m2(String str) {
        this.D = str;
    }

    public void n2(int i) {
        this.o = i;
    }

    public void o2(int i) {
        this.x.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        q2();
    }

    public void p() {
        com.tplink.cloud.context.b f2;
        TDPCameraDevice tDPCameraDevice = this.H;
        if (tDPCameraDevice != null && tDPCameraDevice.getDeviceIdMd5() != null) {
            BaseALIoTDevice Z1 = this.J.Z1(this.H.getDeviceIdMd5());
            if (!(Z1 instanceof ALCameraDevice)) {
                Z1 = new ALCameraDevice();
            }
            ALCameraDevice aLCameraDevice = (ALCameraDevice) Z1;
            if (!(!TextUtils.isEmpty(this.H.getOwner()) || (f2 = b.d.s.a.a.f()) == null || f2.c() == null || f2.c().getCloudUserName() == null)) {
                this.H.setOwner(b.d.w.h.a.g(f2.c().getCloudUserName()));
            }
            if (this.U) {
                if (this.V) {
                    aLCameraDevice.setTDPIoTDevice(this.H);
                }
                aLCameraDevice.setThingDevice(this.S);
                aLCameraDevice.setCloudIoTDevice(this.R);
            } else {
                aLCameraDevice.setTDPIoTDevice(this.H);
            }
            aLCameraDevice.setDeviceAlias(this.f10405c.get());
            if (g0()) {
                aLCameraDevice.setCameraAvatar(x());
            } else {
                aLCameraDevice.setCameraAvatarInfo(this.P);
            }
            aLCameraDevice.setBasicInfo(this.T);
            aLCameraDevice.setCameraComponent(this.W);
            this.J.Y3(aLCameraDevice);
        }
    }

    public void q2() {
        this.a0 = false;
        io.reactivex.e0.c cVar = this.Z;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @SuppressLint({"CheckResult"})
    public q<DeviceCloudProduct> r() {
        return h.i(B().getDeviceIdMd5(), false).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g());
    }

    public void s(Wifi wifi) {
        this.a.set(!TextUtils.isEmpty(wifi.getSsid()) ? wifi.getSsid() : "");
        String T = T(wifi.getSsid());
        if (wifi.getAuth() == 0 && !TextUtils.isEmpty(T)) {
            o.h0().r0(new WirelessInfoParams(this.a.get(), "", ""));
            T = "";
        }
        if (!TextUtils.isEmpty(T)) {
            this.f10407e.set(true);
            this.f10404b.set(T);
            return;
        }
        this.f10407e.set(false);
        this.f10404b.set("");
    }

    public void v() {
        if (this.I != null && !this.U) {
            this.N.b((g0() ? w(this.H.getDeviceIdMd5()) : u(this.H.getDeviceIdMd5())).N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.x0
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return CameraOnBoardingViewModel.this.z0((Boolean) obj);
                }
            }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(a0.f10429c).G0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.e1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.C0((Boolean) obj);
                }
            }));
        }
    }

    public String x() {
        CameraAvatarInfo cameraAvatarInfo;
        if (!g0() || (cameraAvatarInfo = this.P) == null) {
            return null;
        }
        return cameraAvatarInfo.getAvatarName();
    }

    public void y() {
        OnBoardingRepository onBoardingRepository = this.I;
        if (onBoardingRepository != null) {
            this.N.b(onBoardingRepository.u().H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.f1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraOnBoardingViewModel.this.G0((CameraComponent) obj);
                }
            }, d0.f10439c));
        }
    }

    public Wifi z() {
        return this.C;
    }
}
