package com.tplink.iot.viewmodel.cloudvideo;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceVideoDateResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class CloudVideoViewModel extends AndroidViewModel {
    private CloudVideoRepository a;

    /* renamed from: b  reason: collision with root package name */
    private b.d.w.g.a f9910b;
    private io.reactivex.e0.c r;
    private io.reactivex.e0.c s;
    private String t;
    private com.tplink.iot.Utils.v0.f.a v;

    /* renamed from: c  reason: collision with root package name */
    private SingleLiveEvent<List<CloudVideo>> f9911c = new SingleLiveEvent<>();

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<com.tplink.iot.model.cloudvideo.a> f9912d = new SingleLiveEvent<>();

    /* renamed from: e  reason: collision with root package name */
    private SingleLiveEvent<DeviceCloudProduct> f9913e = new SingleLiveEvent<>();

    /* renamed from: f  reason: collision with root package name */
    private SingleLiveEvent<Boolean> f9914f = new SingleLiveEvent<>();
    private MediatorLiveData<List<OrderInfo>> g = new MediatorLiveData<>();
    private SingleLiveEvent<List<HasVideoTime>> h = new SingleLiveEvent<>();
    private SingleLiveEvent<List<HasVideoTime>> i = new SingleLiveEvent<>();
    private MediatorLiveData<Boolean> j = new MediatorLiveData<>();
    private MutableLiveData<Boolean> k = new MutableLiveData<>();
    private MutableLiveData<Boolean> l = new MutableLiveData<>();
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m = new MutableLiveData<>();
    private MutableLiveData<SummarySupportResult> n = new MutableLiveData<>();
    private MutableLiveData<Boolean> o = new MutableLiveData<>();
    private List<CloudVideoItem> p = Collections.synchronizedList(new ArrayList());
    private io.reactivex.e0.b q = new io.reactivex.e0.b();
    private long u = 0;
    private final SimpleDateFormat w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private String x = TimeZone.getDefault().getID();

    /* loaded from: classes2.dex */
    class a implements Observer<List<OrderInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<OrderInfo> list) {
            CloudVideoViewModel.this.g.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudVideoViewModel.this.f9912d.postValue(new com.tplink.iot.model.cloudvideo.a(true, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements j<DeviceCloudProduct, Boolean> {
        c() {
        }

        /* renamed from: a */
        public Boolean apply(DeviceCloudProduct deviceCloudProduct) throws Exception {
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudVideoViewModel.this.f9914f.postValue(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            CloudVideoViewModel.this.f9914f.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudVideoViewModel.this.u = -1L;
            CloudVideoViewModel.this.f9913e.postValue(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements io.reactivex.g0.g<DeviceCloudProduct> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9919c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements io.reactivex.g0.c<SdCardStatus, Boolean, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CameraSettingRepository f9921c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ DeviceCloudProduct f9922d;

            a(CameraSettingRepository cameraSettingRepository, DeviceCloudProduct deviceCloudProduct) {
                this.f9921c = cameraSettingRepository;
                this.f9922d = deviceCloudProduct;
            }

            /* renamed from: a */
            public Boolean apply(SdCardStatus sdCardStatus, Boolean bool) throws Exception {
                AccountInfoCache accountInfo = this.f9921c.x().getAccountInfo();
                String username = accountInfo != null ? accountInfo.getUsername() : "";
                if (!CloudVideoViewModel.this.X(this.f9922d) || !CloudVideoViewModel.this.V(sdCardStatus) || TextUtils.isEmpty(username) || "---".equals(username)) {
                    o.h0().C0(g.this.f9919c, true);
                } else {
                    CloudVideoViewModel.this.m.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
                }
                return Boolean.TRUE;
            }
        }

        g(String str) {
            this.f9919c = str;
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            CloudVideoViewModel.this.u = deviceCloudProduct.getEndTime();
            CloudVideoViewModel.this.f9913e.postValue(deviceCloudProduct);
            CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(b.d.w.h.a.g(this.f9919c), CameraSettingRepository.class);
            q.f1(cameraSettingRepository.H(), cameraSettingRepository.M(), new a(cameraSettingRepository, deviceCloudProduct)).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    public CloudVideoViewModel(@NonNull Application application) {
        super(application);
        com.tplink.iot.Utils.v0.f.b bVar = new com.tplink.iot.Utils.v0.f.b(application);
        this.v = bVar;
        bVar.d();
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.t = f2.c().getAccountId();
        CloudVideoRepository cloudVideoRepository = (CloudVideoRepository) b.d.b.f.b.a(f2, CloudVideoRepository.class);
        this.a = cloudVideoRepository;
        this.g.addSource(cloudVideoRepository.c0(), new a());
        this.j.addSource(this.a.V(), new Observer() { // from class: com.tplink.iot.viewmodel.cloudvideo.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CloudVideoViewModel.this.q0((List) obj);
            }
        });
        this.f9910b = new b.d.w.g.a(application.getApplicationContext(), "DailySummary");
    }

    private void E0(String str) {
        List<Long> f2 = this.v.f(str);
        ArrayList arrayList = new ArrayList();
        if (f2 != null) {
            for (Long l : f2) {
                if (l != null) {
                    HasVideoTime hasVideoTime = new HasVideoTime();
                    hasVideoTime.setUtcTime(l.longValue());
                    hasVideoTime.setDeviceLocalTime(this.w.format(new Date(l.longValue())));
                    arrayList.add(hasVideoTime);
                }
            }
        }
        this.i.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V(SdCardStatus sdCardStatus) {
        return sdCardStatus == SdCardStatus.NORMAL || sdCardStatus == SdCardStatus.FULL;
    }

    private boolean W(String str, long j) {
        int i;
        DeviceCloudProduct value = this.f9913e.getValue();
        if (value == null) {
            return false;
        }
        TrialResult trial = value.getTrial();
        if ((trial != null && "active".equals(trial.getStatus())) || value.isAutoRenew() || j <= 0) {
            return false;
        }
        long timestamp = j - value.getTimestamp();
        if (timestamp < 0 || timestamp > 604800000) {
            o.h0().e1(str, false);
            o.h0().f1(str, false);
            o.h0().f1(str, false);
            return false;
        }
        int i2 = (timestamp > 259200000L ? 1 : (timestamp == 259200000L ? 0 : -1));
        if (i2 > 0 && i < 0) {
            return !o.h0().Z(str);
        }
        int i3 = (timestamp > 86400000L ? 1 : (timestamp == 86400000L ? 0 : -1));
        return (i3 <= 0 || i2 >= 0) ? i3 < 0 && !o.h0().Y(str) : !o.h0().a0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0(CloudVideoDevicesResult cloudVideoDevicesResult) throws Exception {
        if (cloudVideoDevicesResult.getTotal() > 0) {
            this.j.postValue(Boolean.TRUE);
            o.h0().E0(this.t, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ void c0(String str, long j, List list, DeviceVideoDateResult deviceVideoDateResult) throws Exception {
        if (deviceVideoDateResult == null || deviceVideoDateResult.getDateList() == null || deviceVideoDateResult.getDateList().size() == 0) {
            this.v.h(str, j);
            x0(list);
            this.h.postValue(list);
            return;
        }
        List<HasVideoTime> dateList = deviceVideoDateResult.getDateList();
        m(dateList.get(0));
        dateList.addAll(list);
        x0(dateList);
        ArrayList arrayList = new ArrayList();
        for (HasVideoTime hasVideoTime : dateList) {
            if (!arrayList.contains(Long.valueOf(hasVideoTime.getUtcTime()))) {
                arrayList.add(Long.valueOf(hasVideoTime.getUtcTime()));
            }
        }
        this.v.c(str, j, this.x, arrayList);
        b.d.w.c.a.c("CloudVideoListFragment", "updateHasVideoDate  deviceId:" + str + "|searchTimeStamp:" + j + "|mTimeZoneStr:" + this.x);
        this.h.postValue(dateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0(Throwable th) throws Exception {
        this.h.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CloudVideo cloudVideo = (CloudVideo) it.next();
            if (cloudVideo.getVideoThumbnails() != null && !cloudVideo.getVideoThumbnails().isEmpty()) {
                arrayList.add(cloudVideo);
            }
        }
        this.f9911c.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void i0(Throwable th) throws Exception {
        this.f9911c.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ List k0(String str, long j, List list, Boolean bool) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (W(str, this.u)) {
            arrayList.add(new CloudVideoItem(new CloudVideo(), 0));
        }
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CloudVideo cloudVideo = (CloudVideo) it.next();
                if (cloudVideo.getVideoThumbnails() != null && cloudVideo.getVideoThumbnails().size() > 0) {
                    CloudVideoItem cloudVideoItem = new CloudVideoItem(cloudVideo, 1);
                    cloudVideoItem.setDisplayTime(q0.b(cloudVideo.getEventLocalTime()));
                    cloudVideoItem.setHasVideo();
                    arrayList.add(cloudVideoItem);
                }
            }
        }
        if (list == null || list.isEmpty()) {
            v0(str, j);
        } else {
            this.v.e(str, j);
            E0(str);
        }
        this.p.clear();
        this.p.addAll(arrayList);
        this.f9912d.postValue(new com.tplink.iot.model.cloudvideo.a(false));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m0(Throwable th) throws Exception {
        this.p.clear();
        this.f9912d.postValue(new com.tplink.iot.model.cloudvideo.a(false));
    }

    private void m(HasVideoTime hasVideoTime) {
        b.d.w.c.a.c("CloudVideoListFragment", "cal device timezone HasVideoTime: UtcTime=" + hasVideoTime.getUtcTime() + "|DeviceLocalTime=" + hasVideoTime.getDeviceLocalTime());
        long utcTime = hasVideoTime.getUtcTime();
        long s = o0.s(hasVideoTime.getDeviceLocalTime(), "GMT+00:00");
        b.d.w.c.a.c("CloudVideoListFragment", "cal device timezone : maxDeviceLocalTime=" + s);
        int i = (int) ((s - utcTime) / 3600000);
        if (i >= 0) {
            this.x = "GMT+" + Math.abs(i) + ":00";
        } else {
            this.x = "GMT-" + Math.abs(i) + ":00";
        }
        b.d.w.c.a.c("CloudVideoListFragment", "cal device timezone = " + this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CloudVideo cloudVideo = (CloudVideo) it.next();
                if (cloudVideo.getVideoThumbnails() != null && cloudVideo.getVideoThumbnails().size() > 0) {
                    CloudVideoItem cloudVideoItem = new CloudVideoItem(cloudVideo, 1);
                    cloudVideoItem.setDisplayTime(q0.b(cloudVideo.getEventLocalTime()));
                    cloudVideoItem.setHasVideo();
                    arrayList.add(cloudVideoItem);
                }
            }
        }
        this.p.addAll(arrayList);
        this.f9912d.postValue(new com.tplink.iot.model.cloudvideo.a(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0(List list) {
        if (!com.tplink.iot.Utils.v0.d.a()) {
            this.j.postValue(Boolean.FALSE);
        } else if (!TextUtils.isEmpty(this.t)) {
            if (o.h0().C(this.t)) {
                this.j.postValue(Boolean.TRUE);
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (this.a.k0((DeviceCloudProduct) it.next())) {
                    this.j.postValue(Boolean.TRUE);
                    o.h0().E0(this.t, true);
                    return;
                }
            }
            s();
        }
    }

    private void r() {
        io.reactivex.e0.c cVar = this.r;
        if (cVar != null && !cVar.isDisposed()) {
            this.r.dispose();
        }
        io.reactivex.e0.c cVar2 = this.s;
        if (cVar2 != null && !cVar2.isDisposed()) {
            this.s.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int r0(OrderInfo orderInfo, OrderInfo orderInfo2) {
        return (int) (orderInfo.getEndTime() - orderInfo2.getEndTime());
    }

    private void s() {
        this.a.T(0, 1).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.a0((CloudVideoDevicesResult) obj);
            }
        }).C(l.f9942c).F0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int s0(HasVideoTime hasVideoTime, HasVideoTime hasVideoTime2) {
        return (int) (hasVideoTime2.getUtcTime() - hasVideoTime.getUtcTime());
    }

    private void w0(List<OrderInfo> list) {
        Collections.sort(list, a.f9928c);
    }

    private q<Boolean> x(String str) {
        long j = this.u;
        if (j == 0) {
            return z(str).g0(new c()).q0(Boolean.TRUE);
        }
        if (j == -1) {
            return q.f0(Boolean.TRUE);
        }
        return q.f0(Boolean.TRUE);
    }

    private void x0(List<HasVideoTime> list) {
        Collections.sort(list, k.f9941c);
    }

    private com.tplink.iot.view.ipcamera.widget.calendar.d y0(Long l, String str) {
        if (l == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone(str));
        instance.setTimeInMillis(l.longValue());
        return new com.tplink.iot.view.ipcamera.widget.calendar.d(instance.get(1), instance.get(2) + 1, instance.get(5));
    }

    private q<DeviceCloudProduct> z(String str) {
        return this.a.M(str).E(new g(str)).C(new f()).l0(io.reactivex.d0.b.a.a());
    }

    public LiveData<Boolean> A() {
        return this.j;
    }

    public void A0() {
        o.h0().H0(System.currentTimeMillis());
    }

    public List<CloudVideoItem> B() {
        return this.p;
    }

    public void B0() {
        o.h0().I0(System.currentTimeMillis());
    }

    public LiveData<List<CloudVideo>> C() {
        return this.f9911c;
    }

    public void C0() {
        o.h0().Z0(System.currentTimeMillis());
    }

    public SingleLiveEvent<com.tplink.iot.model.cloudvideo.a> D() {
        return this.f9912d;
    }

    public void D0(String str) {
        if (this.u > 0) {
            long currentTimeMillis = this.u - System.currentTimeMillis();
            int i = (currentTimeMillis > 259200000L ? 1 : (currentTimeMillis == 259200000L ? 0 : -1));
            if (i <= 0 || currentTimeMillis >= 604800000) {
                int i2 = (currentTimeMillis > 86400000L ? 1 : (currentTimeMillis == 86400000L ? 0 : -1));
                if (i2 > 0 && i < 0) {
                    o.h0().f1(str, true);
                } else if (i2 < 0) {
                    o.h0().d1(str, true);
                }
            } else {
                o.h0().e1(str, true);
            }
        }
    }

    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> E() {
        return this.m;
    }

    public SingleLiveEvent<Boolean> F() {
        return this.f9914f;
    }

    public String G(String str) {
        TPCameraDeviceContext K1;
        ALCameraDevice cameraDevice;
        if (str == null || (K1 = TPIoTClientManager.K1(str)) == null || (cameraDevice = K1.getCameraDevice()) == null || cameraDevice.getBasicInfo() == null) {
            return null;
        }
        return cameraDevice.getBasicInfo().getDeviceId();
    }

    public boolean H(List<OrderInfo> list, String str) {
        if (!(list == null || str == null)) {
            for (OrderInfo orderInfo : list) {
                if (orderInfo != null && orderInfo.getTrial() == 0 && "active".equals(orderInfo.getStatus())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void I(final String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            this.h.postValue(null);
            return;
        }
        Long b2 = this.v.b(str);
        if (this.v.g(str) != null) {
            this.x = this.v.g(str);
            b.d.w.c.a.c("CloudVideoListFragment", "getCachedDeviceTimeZone  deviceId:" + str + "|mTimeZoneStr:" + this.x);
        }
        this.w.setTimeZone(TimeZone.getTimeZone(this.x));
        b.d.w.c.a.c("CloudVideoListFragment", "simpleDateFormat TimeZone  deviceId:" + str + "|mTimeZoneStr:" + this.x);
        List<Long> f2 = this.v.f(str);
        final ArrayList arrayList = new ArrayList();
        if (f2 != null) {
            for (Long l : f2) {
                if (l != null) {
                    HasVideoTime hasVideoTime = new HasVideoTime();
                    hasVideoTime.setUtcTime(l.longValue());
                    hasVideoTime.setDeviceLocalTime(this.w.format(new Date(l.longValue())));
                    arrayList.add(hasVideoTime);
                }
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (b2 != null) {
            str3 = this.w.format(new Date(b2.longValue()));
            str2 = this.w.format(new Date(currentTimeMillis));
        } else {
            str2 = null;
        }
        b.d.w.c.a.c("CloudVideoListFragment", "getHasVideoDateList  deviceId:" + str + "|mTimeZoneStr:" + this.x + "|startDate:" + str3 + "|endDate:" + str2);
        this.a.Y(str, str3, str2).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.c0(str, currentTimeMillis, arrayList, (DeviceVideoDateResult) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.e0((Throwable) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).F0();
    }

    public SingleLiveEvent<List<HasVideoTime>> J() {
        return this.h;
    }

    public MutableLiveData<Boolean> K() {
        return this.l;
    }

    public LiveData<List<HasVideoTime>> L() {
        return this.i;
    }

    public MutableLiveData<Boolean> M() {
        return this.o;
    }

    public LiveData<List<OrderInfo>> N() {
        return this.g;
    }

    public void O() {
        this.a.d0().l0(io.reactivex.d0.b.a.a()).F0();
    }

    public void P(String str) {
        this.a.R(str, 10, null, null).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.g
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.g0((List) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.b
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.i0((Throwable) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).F0();
    }

    public OrderInfo Q(List<OrderInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (OrderInfo orderInfo : list) {
            if (orderInfo != null && orderInfo.getTrial() == 0 && "active".equals(orderInfo.getStatus()) && !orderInfo.isAutoRenew()) {
                arrayList.add(orderInfo);
            }
        }
        if (arrayList.size() > 1) {
            w0(arrayList);
        }
        if (arrayList.size() >= 1) {
            return arrayList.get(0);
        }
        return null;
    }

    public int R(DeviceCloudProduct deviceCloudProduct, boolean z) {
        return this.a.g0(deviceCloudProduct, z);
    }

    public String S() {
        return this.x;
    }

    public MutableLiveData<Boolean> T() {
        return this.k;
    }

    public void U(final String str, String str2, String str3, final long j) {
        r();
        io.reactivex.e0.c F0 = q.f1(this.a.R(str, 20, str2, str3), x(str), new io.reactivex.g0.c() { // from class: com.tplink.iot.viewmodel.cloudvideo.h
            @Override // io.reactivex.g0.c
            public final Object apply(Object obj, Object obj2) {
                return CloudVideoViewModel.this.k0(str, j, (List) obj, (Boolean) obj2);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.viewmodel.cloudvideo.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CloudVideoViewModel.this.m0((Throwable) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).F0();
        this.r = F0;
        this.q.b(F0);
    }

    public boolean X(DeviceCloudProduct deviceCloudProduct) {
        return this.a.k0(deviceCloudProduct);
    }

    public boolean Y(String str) {
        TPCameraDeviceContext K1;
        ALCameraDevice cameraDevice;
        if (str == null || (K1 = TPIoTClientManager.K1(str)) == null || (cameraDevice = K1.getCameraDevice()) == null) {
            return true;
        }
        return cameraDevice.isUserRoleTypeDevice();
    }

    public boolean n() {
        return System.currentTimeMillis() - o.h0().F() > 2592000000L;
    }

    public boolean o() {
        return System.currentTimeMillis() - o.h0().G() > 2592000000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.q.d();
    }

    public boolean p() {
        return System.currentTimeMillis() - o.h0().U() > 2592000000L;
    }

    public boolean t(DeviceCloudProduct deviceCloudProduct) {
        return this.a.C(deviceCloudProduct);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x002c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t0(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r3.r()
            java.util.List<com.tplink.iot.model.cloudvideo.CloudVideoItem> r0 = r3.p
            if (r0 == 0) goto L_0x002a
            int r0 = r0.size()
            r1 = 1
            if (r0 < r1) goto L_0x002a
            java.util.List<com.tplink.iot.model.cloudvideo.CloudVideoItem> r2 = r3.p
            int r0 = r0 - r1
            java.lang.Object r0 = r2.get(r0)
            com.tplink.iot.model.cloudvideo.CloudVideoItem r0 = (com.tplink.iot.model.cloudvideo.CloudVideoItem) r0
            if (r0 == 0) goto L_0x002a
            com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo r0 = r0.getCloudVideo()
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.getEventLocalTime()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            java.lang.String r0 = ""
        L_0x002c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r6 = r0
        L_0x0034:
            com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository r0 = r3.a
            r1 = 20
            io.reactivex.q r4 = r0.R(r4, r1, r5, r6)
            com.tplink.iot.viewmodel.cloudvideo.e r5 = new com.tplink.iot.viewmodel.cloudvideo.e
            r5.<init>()
            io.reactivex.q r4 = r4.E(r5)
            com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel$b r5 = new com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel$b
            r5.<init>()
            io.reactivex.q r4 = r4.C(r5)
            io.reactivex.w r5 = io.reactivex.d0.b.a.a()
            io.reactivex.q r4 = r4.l0(r5)
            io.reactivex.e0.c r4 = r4.F0()
            r3.s = r4
            io.reactivex.e0.b r5 = r3.q
            r5.b(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel.t0(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public boolean u(DeviceCloudProduct deviceCloudProduct) {
        return this.a.D(deviceCloudProduct);
    }

    public void u0(List<CloudVideoItem> list) {
        try {
            this.p.removeAll(list);
        } catch (Exception unused) {
            b.d.w.c.a.d("removeAll Exception");
        }
    }

    public void v(String str, List<CloudVideoItem> list) {
        if (str == null || list == null) {
            this.f9914f.postValue(Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CloudVideoItem cloudVideoItem : list) {
            arrayList.add(cloudVideoItem.getCloudVideo().getUuid());
        }
        w.x(b.d.w.h.a.g(str));
        this.a.F(str, arrayList).i(new e()).j(new d()).r(io.reactivex.d0.b.a.a()).y();
    }

    public void v0(String str, long j) {
        this.v.a(str, j);
        E0(str);
    }

    public void w(String str) {
        z(str).F0();
    }

    public LiveData<DeviceCloudProduct> y() {
        return this.f9913e;
    }

    public List<com.tplink.iot.view.ipcamera.widget.calendar.d> z0(List<HasVideoTime> list, String str) {
        com.tplink.iot.view.ipcamera.widget.calendar.d y0;
        ArrayList arrayList = new ArrayList();
        for (HasVideoTime hasVideoTime : list) {
            if (hasVideoTime != null) {
                long s = o0.s(hasVideoTime.getDeviceLocalTime(), str);
                if (!(s == -1 || (y0 = y0(Long.valueOf(s), str)) == null)) {
                    arrayList.add(y0);
                }
            }
        }
        return arrayList;
    }
}
