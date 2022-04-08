package com.tplink.libtpnetwork.IoTNetwork;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.firebase.messaging.ServiceStarter;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleParams;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libmediaapi.device.MediaDeviceAPI;
import com.tplink.libmediaapi.device.apibean.MediaDevice;
import com.tplink.libmediaapi.device.apicallback.MediaDeviceListCallBack;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickDiscoveryRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.CloudAndTDPBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.LoginAndTDPBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraDeviceCache;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumLoginResult;
import io.reactivex.e0.c;
import io.reactivex.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TPIoTClientManager extends AbstractIoTCloudRepository {
    private io.reactivex.m0.g<Map<String, ? extends TDPIoTDevice>> I;
    private io.reactivex.m0.g<Boolean> J;
    private io.reactivex.e0.c O;
    private EnumLoginResult i;
    private TCAccountRepository n;
    private TCDeviceRepository o;
    private DeviceShareRepository p;
    private ThingCloudRepository q;
    private SmartRepository r;
    private FamilyManagerRepository s;
    private GroupRepository t;
    private TCMessagePushRepository u;
    private CloudVideoRepository v;
    private QuickDiscoveryRepository z;
    private String h = TPIoTClientManager.class.getSimpleName();
    private final Map<String, TPBaseDeviceContext> j = new ConcurrentHashMap();
    private final Map<String, BaseALIoTDevice> k = new ConcurrentHashMap();
    private final Map<String, x> l = new ConcurrentHashMap();
    private final Map<String, f4> m = new ConcurrentHashMap();
    private com.tplink.libtpnetwork.Utils.o w = com.tplink.libtpnetwork.Utils.o.h0();
    private com.tplink.libtpnetwork.TDPNetwork.a x = com.tplink.libtpnetwork.TDPNetwork.a.q();
    private com.tplink.tpble.w y = com.tplink.tpble.w.a();
    private MediatorLiveData<List<BaseALIoTDevice>> A = new MediatorLiveData<>();
    private MediatorLiveData<List<ALCameraDevice>> B = new MediatorLiveData<>();
    private MediatorLiveData<Map<String, List<BaseALIoTDevice>>> C = new MediatorLiveData<>();
    private Map<String, ThingFirmware> D = new HashMap();
    private MutableLiveData<Boolean> E = new MutableLiveData<>();
    private MutableLiveData<EnumHomeState> F = new MutableLiveData<>();
    private MutableLiveData<Boolean> G = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> H = new MutableLiveData<>();
    private String K = null;
    private boolean L = false;
    private List<String> M = new ArrayList();
    private List<String> N = new ArrayList();

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            for (TPBaseDeviceContext tPBaseDeviceContext : TPIoTClientManager.this.j.values()) {
                com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.e(tPBaseDeviceContext);
            }
            TPIoTClientManager.this.l.clear();
            TPIoTClientManager.this.m.clear();
            TPIoTClientManager.this.j.clear();
            TPIoTClientManager.this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a0 implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<Boolean>> {
        a0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<BaseALIoTDevice> list) throws Exception {
            return TPIoTClientManager.this.n3(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a1 implements io.reactivex.g0.a {
        a1() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I.onComplete();
        }
    }

    /* loaded from: classes3.dex */
    class a2 implements io.reactivex.g0.j<String, io.reactivex.e> {
        a2() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(String str) throws Exception {
            BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) TPIoTClientManager.this.k.get(str);
            if (baseALIoTDevice instanceof ALCameraDevice) {
                ((ALCameraDevice) baseALIoTDevice).setDeviceRemoteOffline();
            }
            MediatorLiveData mediatorLiveData = TPIoTClientManager.this.B;
            TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
            mediatorLiveData.postValue(tPIoTClientManager.L1(tPIoTClientManager.k.values()));
            return io.reactivex.a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
            TPIoTClientManager.this.p.C().F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b0 implements io.reactivex.g0.c<IoTResult<List<TCDeviceBean>>, Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {
        b0() {
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(IoTResult<List<TCDeviceBean>> ioTResult, Map<String, ? extends TDPIoTDevice> map) throws Exception {
            List<TCDeviceBean> list;
            if (ioTResult.getErrCode() == 0) {
                TPIoTClientManager.this.F.postValue(EnumHomeState.ONLINE);
                list = ioTResult.getResult();
            } else {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                list = new ArrayList<>();
            }
            return TPIoTClientManager.this.g1(list, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b1 implements io.reactivex.g0.g<Map<String, ? extends TDPIoTDevice>> {
        b1() {
        }

        /* renamed from: a */
        public void accept(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            TPIoTClientManager.this.I.onNext(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b2 implements io.reactivex.g0.j<String, io.reactivex.t<?>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f12728c;

        b2(Map map) {
            this.f12728c = map;
        }

        /* renamed from: a */
        public io.reactivex.t<?> apply(String str) throws Exception {
            return TPIoTClientManager.this.q.K(str, (List) this.f12728c.get(str)).q0(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.g<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TPIoTClientManager.this.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c0 implements io.reactivex.g0.a {
        c0() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c1 implements io.reactivex.g0.j<Throwable, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f12731c;

        c1(boolean z) {
            this.f12731c = z;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Throwable th) throws Exception {
            if (!TPIoTClientManager.this.u2(th)) {
                return this.f12731c ? TPIoTClientManager.this.j2() : io.reactivex.q.f0(Boolean.FALSE);
            }
            TPIoTClientManager.this.i = EnumLoginResult.FAIL;
            return io.reactivex.q.J(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c2 implements io.reactivex.g0.a {
        c2() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
            TPIoTClientManager.this.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<Boolean>> {
        d() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<BaseALIoTDevice> list) throws Exception {
            return TPIoTClientManager.this.g2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d0 implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<Boolean>> {
        d0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<BaseALIoTDevice> list) throws Exception {
            return TPIoTClientManager.this.n3(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d1 implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f12735c;

        d1(List list) {
            this.f12735c = list;
        }

        /* renamed from: a */
        public Map<String, ? extends TDPIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            TPIoTClientManager.this.z.H(map);
            return TPIoTClientManager.this.t1(map, this.f12735c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d2 implements io.reactivex.g0.g<String> {
        d2() {
        }

        /* renamed from: a */
        public void accept(String str) throws Exception {
            TPIoTClientManager.this.x3(b.d.w.h.a.g(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.y3();
            TPIoTClientManager.this.G.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e0 implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {
        e0() {
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return TPIoTClientManager.this.g1(new ArrayList(), map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e1 implements io.reactivex.g0.a {
        e1() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            if (TPIoTClientManager.this.J != null && !TPIoTClientManager.this.J.j1()) {
                TPIoTClientManager.this.J.onNext(Boolean.FALSE);
                TPIoTClientManager.this.J.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e2 implements io.reactivex.g0.j<List<String>, List<String>> {
        e2() {
        }

        /* renamed from: a */
        public List<String> apply(List<String> list) throws Exception {
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.c<IoTResult<Map<String, BaseALIoTDevice>>, Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f12740c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f12741d;

        f(Map map, List list) {
            this.f12740c = map;
            this.f12741d = list;
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(IoTResult<Map<String, BaseALIoTDevice>> ioTResult, Map<String, ? extends TDPIoTDevice> map) throws Exception {
            Map<String, BaseALIoTDevice> map2;
            if (ioTResult.getErrCode() == 0) {
                TPIoTClientManager.this.F.postValue(EnumHomeState.ONLINE);
                map2 = ioTResult.getResult();
            } else {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                map2 = new HashMap<>();
            }
            if (!map2.isEmpty()) {
                this.f12740c.putAll(map2);
            }
            return TPIoTClientManager.this.j1(this.f12740c, map2, map, this.f12741d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f0 implements io.reactivex.g0.j<List<TCDeviceBean>, io.reactivex.t<IoTResult<List<TCDeviceBean>>>> {
        f0() {
        }

        /* renamed from: a */
        public io.reactivex.t<IoTResult<List<TCDeviceBean>>> apply(List<TCDeviceBean> list) throws Exception {
            return io.reactivex.q.f0(new IoTResult(0, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f1 implements io.reactivex.g0.g<Boolean> {
        f1() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            if (bool.booleanValue() && TPIoTClientManager.this.J != null && !TPIoTClientManager.this.J.j1()) {
                TPIoTClientManager.this.J.onNext(Boolean.TRUE);
                TPIoTClientManager.this.J.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f2 implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        f2(List list) {
            this.a = list;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.t.M(this.a);
            TPIoTClientManager.this.s.Q0(this.a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f12746c;

        g(Map map) {
            this.f12746c = map;
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return TPIoTClientManager.this.i4(this.f12746c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g0 implements io.reactivex.g0.j<Throwable, io.reactivex.t<Boolean>> {
        g0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Throwable th) throws Exception {
            if (TPIoTClientManager.this.u2(th)) {
                return io.reactivex.q.J(th);
            }
            return io.reactivex.q.f0(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g1 implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {
        g1() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return TPIoTClientManager.this.i3();
            }
            return io.reactivex.q.f0(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g2 implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        g2(List list) {
            this.a = list;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.D3(this.a);
            TPIoTClientManager.this.t.M(this.a);
            TPIoTClientManager.this.s.Q0(this.a, null);
        }
    }

    /* loaded from: classes3.dex */
    class h implements io.reactivex.g0.a {
        h() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h0 implements io.reactivex.g0.l<Throwable> {
        h0() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return th instanceof CloudException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h1 implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        h1() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.d().T0(30L, TimeUnit.SECONDS).q0(Boolean.FALSE);
        }
    }

    /* loaded from: classes3.dex */
    class h2 implements io.reactivex.g0.a {
        h2() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.L3();
            TPIoTClientManager.this.K3();
        }
    }

    /* loaded from: classes3.dex */
    class i implements io.reactivex.g0.g<Boolean> {
        i() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TPIoTClientManager.this.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i0 implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        i0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i1 implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c>> {
        i1() {
        }

        /* renamed from: a */
        public io.reactivex.t<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> apply(List<BaseALIoTDevice> list) throws Exception {
            return TPIoTClientManager.this.l2(list);
        }
    }

    /* loaded from: classes3.dex */
    class i2 implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12756c;

        i2(String str) {
            this.f12756c = str;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TPIoTClientManager.this.B3(this.f12756c);
        }
    }

    /* loaded from: classes3.dex */
    class j implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<Boolean>> {
        j() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<BaseALIoTDevice> list) throws Exception {
            return TPIoTClientManager.this.g2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j0 implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        j0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j1 implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {
        j1() {
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return TPIoTClientManager.this.h4(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j2 implements io.reactivex.g0.g<Boolean> {
        j2() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TPIoTClientManager.this.i = bool.booleanValue() ? EnumLoginResult.LOCAL_SUCCESS : EnumLoginResult.FAIL;
        }
    }

    /* loaded from: classes3.dex */
    class k implements Observer<List<TCDeviceBean>> {
        k() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<TCDeviceBean> list) {
            TPIoTClientManager.this.q4(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k0 implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        k0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k1 implements io.reactivex.g0.j<Boolean, io.reactivex.t<Map<String, ? extends TDPIoTDevice>>> {
        k1() {
        }

        /* renamed from: a */
        public io.reactivex.t<Map<String, ? extends TDPIoTDevice>> apply(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return TPIoTClientManager.this.h3();
            }
            return io.reactivex.q.f0(new HashMap());
        }
    }

    /* loaded from: classes3.dex */
    class k2 implements io.reactivex.g0.j<String, io.reactivex.t<Boolean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<String, Boolean> {
            a() {
            }

            /* renamed from: a */
            public Boolean apply(String str) throws Exception {
                return Boolean.TRUE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements io.reactivex.g0.g<io.reactivex.e0.c> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CameraSettingRepository f12766c;

            b(CameraSettingRepository cameraSettingRepository) {
                this.f12766c = cameraSettingRepository;
            }

            /* renamed from: a */
            public void accept(io.reactivex.e0.c cVar) throws Exception {
                this.f12766c.I1().F0();
            }
        }

        k2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void c(ThingDevice thingDevice, BaseALIoTDevice baseALIoTDevice, final io.reactivex.r rVar) throws Exception {
            io.reactivex.a i = TPIoTClientManager.this.q.j1(thingDevice.getThingUrl(), baseALIoTDevice.getDeviceId()).i(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.d
                @Override // io.reactivex.g0.a
                public final void run() {
                    TPIoTClientManager.k2.d(r.this);
                }
            });
            rVar.getClass();
            i.j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.s
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    r.this.onError((Throwable) obj);
                }
            }).y();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void d(io.reactivex.r rVar) throws Exception {
            rVar.onNext(Boolean.TRUE);
            rVar.onComplete();
        }

        @SuppressLint({"CheckResult"})
        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(String str) throws Exception {
            final BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) TPIoTClientManager.this.k.get(str);
            if (baseALIoTDevice != null) {
                CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.this.V3(baseALIoTDevice), CameraSettingRepository.class);
                if (baseALIoTDevice.getThingDevice() == null && baseALIoTDevice.getCloudIoTDevice() == null) {
                    return cameraSettingRepository.h().F(new b(cameraSettingRepository));
                }
                if (baseALIoTDevice.getThingDevice() != null) {
                    final ThingDevice thingDevice = baseALIoTDevice.getThingDevice();
                    if (TextUtils.isEmpty(thingDevice.getThingUrl()) || TextUtils.isEmpty(thingDevice.getThingName())) {
                        return io.reactivex.q.f0(Boolean.FALSE);
                    }
                    return io.reactivex.q.m(new io.reactivex.s() { // from class: com.tplink.libtpnetwork.IoTNetwork.e
                        @Override // io.reactivex.s
                        public final void subscribe(r rVar) {
                            TPIoTClientManager.k2.this.c(thingDevice, baseALIoTDevice, rVar);
                        }
                    });
                }
                cameraSettingRepository.h().F0();
                if (baseALIoTDevice.isFirmwareSupportIoTCloud()) {
                    cameraSettingRepository.I1().F0();
                }
                return TPIoTClientManager.this.o.R(baseALIoTDevice.getAppServerUrl(), baseALIoTDevice.getDeviceId(), ((b.d.b.f.a) TPIoTClientManager.this).f100b.c().getCloudUserName()).g0(new a());
            }
            throw new Exception("AlCameraDevice is not Exist");
        }
    }

    /* loaded from: classes3.dex */
    class l implements io.reactivex.g0.g<Throwable> {
        l() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            TPIoTClientManager.this.f3();
            TPIoTClientManager.this.G.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l0 implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        l0() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l1 implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>> {
        l1() {
        }

        /* renamed from: a */
        public Map<String, ? extends TDPIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            TPIoTClientManager.this.z.H(map);
            return TPIoTClientManager.this.s1(map);
        }
    }

    /* loaded from: classes3.dex */
    class l2 implements io.reactivex.g0.g<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> {
        l2() {
        }

        /* renamed from: a */
        public void accept(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            cVar.k().C(io.reactivex.l0.a.c()).y();
        }
    }

    /* loaded from: classes3.dex */
    class m implements io.reactivex.g0.a {
        m() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.y3();
            TPIoTClientManager.this.G.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m0 implements io.reactivex.g0.j<List<TCDeviceBean>, io.reactivex.t<IoTResult<List<TCDeviceBean>>>> {
        m0() {
        }

        /* renamed from: a */
        public io.reactivex.t<IoTResult<List<TCDeviceBean>>> apply(List<TCDeviceBean> list) throws Exception {
            return io.reactivex.q.f0(new IoTResult(0, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m1 implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>> {
        m1() {
        }

        /* renamed from: a */
        public Map<String, ? extends TDPIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return TPIoTClientManager.this.s1(map);
        }
    }

    /* loaded from: classes3.dex */
    class m2 implements io.reactivex.g0.g<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> {
        m2() {
        }

        /* renamed from: a */
        public void accept(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            if (cVar instanceof AbstractThingRepository) {
                ((AbstractThingRepository) cVar).v1().Z().C(io.reactivex.l0.a.c()).y();
            }
        }
    }

    /* loaded from: classes3.dex */
    class n implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f12775c;

        n(List list) {
            this.f12775c = list;
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return TPIoTClientManager.this.j4(map, this.f12775c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n0 implements io.reactivex.g0.l<Throwable> {
        n0() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return th instanceof CloudException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n1 implements io.reactivex.g0.j<Boolean, Boolean> {
        n1() {
        }

        /* renamed from: a */
        public Boolean apply(Boolean bool) throws Exception {
            TPIoTClientManager.this.i = bool.booleanValue() ? EnumLoginResult.CLOUD_SUCCESS : EnumLoginResult.FAIL;
            return bool;
        }
    }

    /* loaded from: classes3.dex */
    class n2 implements io.reactivex.g0.j<List<TCDeviceBean>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12779c;

        n2(String str) {
            this.f12779c = str;
        }

        /* renamed from: a */
        public Boolean apply(List<TCDeviceBean> list) throws Exception {
            for (TCDeviceBean tCDeviceBean : list) {
                if (this.f12779c.equals(b.d.w.h.a.g(tCDeviceBean.getDeviceId()))) {
                    TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
                    tPIoTClientManager.a4(tPIoTClientManager.m2(new ALIoTDevice(tCDeviceBean), true));
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o implements io.reactivex.g0.j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, io.reactivex.t<Boolean>> {
        o() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar) throws Exception {
            return cVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o0 implements io.reactivex.g0.j<List<ThingDevice>, io.reactivex.t<IoTResult<List<ThingDevice>>>> {
        o0() {
        }

        /* renamed from: a */
        public io.reactivex.t<IoTResult<List<ThingDevice>>> apply(List<ThingDevice> list) throws Exception {
            return io.reactivex.q.f0(new IoTResult(0, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o1 implements io.reactivex.g0.a {
        o1() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.L3();
            TPIoTClientManager.this.I3();
        }
    }

    /* loaded from: classes3.dex */
    class o2 implements io.reactivex.g0.j<List<TCDeviceBean>, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12783c;

        o2(String str) {
            this.f12783c = str;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<TCDeviceBean> list) throws Exception {
            TCDeviceBean tCDeviceBean = null;
            for (TCDeviceBean tCDeviceBean2 : list) {
                if (this.f12783c.equals(b.d.w.h.a.g(tCDeviceBean2.getDeviceId()))) {
                    tCDeviceBean = tCDeviceBean2;
                }
            }
            if (tCDeviceBean != null) {
                return TPIoTClientManager.this.w1(this.f12783c, tCDeviceBean);
            }
            return io.reactivex.q.f0(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p implements io.reactivex.g0.c<List<TCDeviceBean>, List<ThingDevice>, IoTResult<Map<String, BaseALIoTDevice>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.s.a.b.a f12785c;

        p(b.d.s.a.b.a aVar) {
            this.f12785c = aVar;
        }

        /* renamed from: a */
        public IoTResult<Map<String, BaseALIoTDevice>> apply(List<TCDeviceBean> list, List<ThingDevice> list2) throws Exception {
            TPIoTClientManager.this.S3(this.f12785c, list, list2);
            return new IoTResult<>(0, TPIoTClientManager.this.h1(list, list2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p0 implements io.reactivex.g0.l<Throwable> {
        p0() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return th instanceof IoTCloudException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p1 implements io.reactivex.g0.j<Boolean, Boolean> {
        p1() {
        }

        /* renamed from: a */
        public Boolean apply(Boolean bool) throws Exception {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p2 implements io.reactivex.g0.j<List<ThingDevice>, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12789c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TCDeviceBean f12790d;

        p2(String str, TCDeviceBean tCDeviceBean) {
            this.f12789c = str;
            this.f12790d = tCDeviceBean;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<ThingDevice> list) throws Exception {
            ThingDevice thingDevice = null;
            for (ThingDevice thingDevice2 : list) {
                if (this.f12789c.equals(b.d.w.h.a.g(thingDevice2.getThingName()))) {
                    thingDevice = thingDevice2;
                }
            }
            if (thingDevice == null) {
                return io.reactivex.q.f0(Boolean.FALSE);
            }
            ALIoTDevice aLIoTDevice = new ALIoTDevice(this.f12790d);
            aLIoTDevice.setThingDevice(thingDevice);
            return TPIoTClientManager.this.d2(aLIoTDevice);
        }
    }

    /* loaded from: classes3.dex */
    class q implements io.reactivex.g0.j<List<BaseALIoTDevice>, io.reactivex.t<Boolean>> {
        q() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(List<BaseALIoTDevice> list) throws Exception {
            return io.reactivex.q.f0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q0 implements io.reactivex.g0.j<b.d.s.a.b.a, io.reactivex.e> {
        q0() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(b.d.s.a.b.a aVar) throws Exception {
            String e2 = aVar.e();
            if (e2 == null || e2.isEmpty() || e2.equals(TPIoTClientManager.this.K)) {
                return io.reactivex.a.e();
            }
            TPIoTClientManager.this.K = e2;
            TPIoTClientManager.this.L = true;
            return TPIoTClientManager.this.u.N("ANDROID", aVar.d(), aVar.a(), e2, aVar.b(), Locale.getDefault().toString(), aVar.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q1 implements io.reactivex.g0.j<CommonCameraRepository, io.reactivex.t<Boolean>> {
        q1() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(CommonCameraRepository commonCameraRepository) throws Exception {
            return commonCameraRepository.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q2 implements io.reactivex.g0.g<Throwable> {
        q2() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: classes3.dex */
    class r implements io.reactivex.g0.g<List<BaseALIoTDevice>> {
        r() {
        }

        /* renamed from: a */
        public void accept(List<BaseALIoTDevice> list) throws Exception {
            TPIoTClientManager.this.q2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r0 implements io.reactivex.g0.a {
        final /* synthetic */ boolean a;

        r0(boolean z) {
            this.a = z;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            if (this.a) {
                TPIoTClientManager.this.G3();
                TPIoTClientManager.this.s.T0();
                TPIoTClientManager.this.s.S0();
                TPIoTClientManager.this.s.R0();
                TPIoTClientManager.this.v.z1();
                TPIoTClientManager.this.q.d1();
                TPIoTClientManager.this.t.l0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r1 implements io.reactivex.g0.j<ALCameraDevice, CommonCameraRepository> {
        r1() {
        }

        /* renamed from: a */
        public CommonCameraRepository apply(ALCameraDevice aLCameraDevice) throws Exception {
            ALCameraDevice aLCameraDevice2;
            TDPCameraDevice tdpCameraDevice = aLCameraDevice.getTdpCameraDevice();
            CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
            String g = b.d.w.h.a.g(((b.d.b.f.a) TPIoTClientManager.this).f100b.c().getCloudUserName());
            if (tdpCameraDevice == null || TextUtils.isEmpty(tdpCameraDevice.getOwner()) || !g.equalsIgnoreCase(tdpCameraDevice.getOwner())) {
                throw new Exception("tdpCameraDevice Owner is invalid");
            }
            String g2 = b.d.w.h.a.g(tdpCameraDevice.getDeviceId());
            BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) TPIoTClientManager.this.k.get(g2);
            if (baseALIoTDevice != null) {
                ALCameraDevice aLCameraDevice3 = (ALCameraDevice) baseALIoTDevice;
                aLCameraDevice3.setTDPIoTDevice(tdpCameraDevice);
                aLCameraDevice3.setCameraAvatarInfo(cameraAvatarInfo);
                aLCameraDevice2 = baseALIoTDevice;
            } else {
                ALCameraDevice aLCameraDevice4 = new ALCameraDevice(tdpCameraDevice);
                aLCameraDevice4.setCameraAvatarInfo(cameraAvatarInfo);
                TPIoTClientManager.this.k.put(g2, aLCameraDevice4);
                aLCameraDevice2 = aLCameraDevice4;
            }
            return (CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.this.V3(aLCameraDevice2), CommonCameraRepository.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r2 implements io.reactivex.g0.g<Boolean> {
        r2() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
        }
    }

    /* loaded from: classes3.dex */
    class s implements io.reactivex.g0.j<CloudAndTDPBean, List<BaseALIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.s.a.b.a f12800c;

        s(b.d.s.a.b.a aVar) {
            this.f12800c = aVar;
        }

        /* renamed from: a */
        public List<BaseALIoTDevice> apply(CloudAndTDPBean cloudAndTDPBean) throws Exception {
            IoTResult<List<TCDeviceBean>> tCDeviceListResult = cloudAndTDPBean.getTCDeviceListResult();
            IoTResult<List<ThingDevice>> thingDeviceListResult = cloudAndTDPBean.getThingDeviceListResult();
            Map<String, ? extends TDPIoTDevice> tDPIoTDeviceMap = cloudAndTDPBean.getTDPIoTDeviceMap();
            if (tCDeviceListResult.getErrCode() == 0) {
                TPIoTClientManager.this.F.postValue(EnumHomeState.ONLINE);
                TPIoTClientManager.this.S3(this.f12800c, tCDeviceListResult.getResult(), thingDeviceListResult.getResult());
                TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
                return tPIoTClientManager.R1(tPIoTClientManager.i1(tCDeviceListResult.getResult(), tDPIoTDeviceMap, TPIoTClientManager.this.k4(thingDeviceListResult.getResult())));
            } else if (tDPIoTDeviceMap.isEmpty()) {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                return TPIoTClientManager.this.i1(new ArrayList(), new HashMap(), new HashMap());
            } else {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                return TPIoTClientManager.this.i1(new ArrayList(), tDPIoTDeviceMap, new HashMap());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class s0 implements io.reactivex.g0.j<Boolean, io.reactivex.e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f12802c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f12803d;

        s0(List list, List list2) {
            this.f12802c = list;
            this.f12803d = list2;
        }

        /* renamed from: a */
        public io.reactivex.e apply(Boolean bool) throws Exception {
            if (TPIoTClientManager.this.t2(this.f12802c)) {
                TPIoTClientManager.this.N.clear();
                TPIoTClientManager.this.N.addAll(this.f12802c);
                TPIoTClientManager.this.v.e0().F0();
            }
            if (!TextUtils.isEmpty(TPIoTClientManager.this.K) && !TPIoTClientManager.this.L && !TPIoTClientManager.this.y2(this.f12803d)) {
                return io.reactivex.a.e();
            }
            TPIoTClientManager.this.M.clear();
            TPIoTClientManager.this.M.addAll(this.f12803d);
            return TPIoTClientManager.this.u.Q(this.f12803d);
        }
    }

    /* loaded from: classes3.dex */
    class s1 implements io.reactivex.g0.j<String, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12805c;

        s1(String str) {
            this.f12805c = str;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(String str) throws Exception {
            return TPIoTClientManager.this.Q3(str, this.f12805c);
        }
    }

    /* loaded from: classes3.dex */
    class s2 implements io.reactivex.g0.g<Long> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12807c;

        s2(String str) {
            this.f12807c = str;
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            TPIoTClientManager.this.r2(this.f12807c);
        }
    }

    /* loaded from: classes3.dex */
    class t implements io.reactivex.g0.h<IoTResult<List<TCDeviceBean>>, IoTResult<List<ThingDevice>>, Map<String, ? extends TDPIoTDevice>, CloudAndTDPBean> {
        t() {
        }

        /* renamed from: b */
        public CloudAndTDPBean a(IoTResult<List<TCDeviceBean>> ioTResult, IoTResult<List<ThingDevice>> ioTResult2, Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return new CloudAndTDPBean(ioTResult, ioTResult2, map);
        }
    }

    /* loaded from: classes3.dex */
    class t0 implements io.reactivex.g0.g<u> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Application f12809c;

        t0(Application application) {
            this.f12809c = application;
        }

        /* renamed from: a */
        public void accept(u uVar) throws Exception {
            if (uVar.d() && uVar.c() != null) {
                TPIoTClientManager.this.r1(uVar.a());
                com.tplink.libtpnetwork.Utils.e0.b(this.f12809c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            }
        }
    }

    /* loaded from: classes3.dex */
    class t1 implements io.reactivex.g0.j<String, io.reactivex.t<String>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12811c;

        t1(String str) {
            this.f12811c = str;
        }

        /* renamed from: a */
        public io.reactivex.t<String> apply(String str) throws Exception {
            BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) TPIoTClientManager.this.k.get(str);
            if (baseALIoTDevice == null || baseALIoTDevice.getCloudIoTDevice() == null) {
                return io.reactivex.q.f0(str);
            }
            return TPIoTClientManager.this.o.P(baseALIoTDevice.getAppServerUrl(), baseALIoTDevice.getDeviceId(), this.f12811c).q0(str);
        }
    }

    /* loaded from: classes3.dex */
    class t2 implements io.reactivex.g0.a {
        t2() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.w.q();
            if (TPIoTClientManager.this.D != null) {
                TPIoTClientManager.this.D.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class u implements io.reactivex.g0.a {
        u() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
            TPIoTClientManager.this.K3();
        }
    }

    /* loaded from: classes3.dex */
    class u0 implements io.reactivex.g0.g<u> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Application f12813c;

        u0(Application application) {
            this.f12813c = application;
        }

        /* renamed from: a */
        public void accept(u uVar) throws Exception {
            if (uVar.d() && uVar.c() != null) {
                TPIoTClientManager.this.r1(uVar.a());
                com.tplink.libtpnetwork.Utils.e0.b(this.f12813c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class u1 implements io.reactivex.g0.a {
        final /* synthetic */ ALCameraDevice a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12815b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12816c;

        u1(ALCameraDevice aLCameraDevice, String str, String str2) {
            this.a = aLCameraDevice;
            this.f12815b = str;
            this.f12816c = str2;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            this.a.setDeviceAlias(this.f12815b);
            TPIoTClientManager.this.V3(this.a);
            TPIoTClientManager.this.k.put(this.f12816c, this.a);
            TPIoTClientManager.this.L3();
            TPIoTClientManager.this.I3();
        }
    }

    /* loaded from: classes3.dex */
    class v implements Observer<List<ThingDevice>> {
        v() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ThingDevice> list) {
            TPIoTClientManager.this.t4(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class v0 implements io.reactivex.g0.j<TDPIoTDevice, u> {
        v0() {
        }

        /* renamed from: a */
        public u apply(TDPIoTDevice tDPIoTDevice) throws Exception {
            TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
            return new u(true, tPIoTClientManager.a4(tPIoTClientManager.m2(new ALIoTDevice(tDPIoTDevice), true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class v1 implements io.reactivex.g0.j<CameraSettingRepository, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12819c;

        v1(String str) {
            this.f12819c = str;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(CameraSettingRepository cameraSettingRepository) throws Exception {
            return cameraSettingRepository.y1(this.f12819c);
        }
    }

    /* loaded from: classes3.dex */
    class w implements io.reactivex.g0.j<LoginAndTDPBean, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.s.a.b.a f12821c;

        w(b.d.s.a.b.a aVar) {
            this.f12821c = aVar;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(LoginAndTDPBean loginAndTDPBean) throws Exception {
            Boolean loginResult = loginAndTDPBean.getLoginResult();
            Map<String, ? extends TDPIoTDevice> tDPIoTDeviceMap = loginAndTDPBean.getTDPIoTDeviceMap();
            if (loginResult != null && loginResult.booleanValue()) {
                if (TPIoTClientManager.this.I == null || TPIoTClientManager.this.I.j1()) {
                    TPIoTClientManager.this.I = io.reactivex.m0.e.n1().l1();
                }
                TPIoTClientManager.this.I.onNext(tDPIoTDeviceMap);
                TPIoTClientManager.this.I.onComplete();
                return TPIoTClientManager.this.c2(this.f12821c);
            } else if (tDPIoTDeviceMap.isEmpty()) {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
                tPIoTClientManager.q2(tPIoTClientManager.i1(new ArrayList(), new HashMap(), new HashMap()));
                return io.reactivex.q.f0(Boolean.TRUE);
            } else {
                TPIoTClientManager.this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
                TPIoTClientManager tPIoTClientManager2 = TPIoTClientManager.this;
                tPIoTClientManager2.q2(tPIoTClientManager2.i1(new ArrayList(), tDPIoTDeviceMap, new HashMap()));
                return io.reactivex.q.f0(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes3.dex */
    class w0 implements io.reactivex.g0.j<String, io.reactivex.t<u>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.d0.h2.a.b f12823c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<Boolean, u> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ThingContext f12825c;

            a(ThingContext thingContext) {
                this.f12825c = thingContext;
            }

            /* renamed from: a */
            public u apply(Boolean bool) throws Exception {
                return new u(bool.booleanValue(), bool.booleanValue() ? this.f12825c : null);
            }
        }

        w0(b.d.d0.h2.a.b bVar) {
            this.f12823c = bVar;
        }

        /* renamed from: a */
        public io.reactivex.t<u> apply(String str) throws Exception {
            if (b.d.w.h.b.d(str)) {
                return io.reactivex.q.f0(new u(-1500, (ThingContext) null));
            }
            TPIoTClientManager.this.y.g();
            this.f12823c.q(str);
            ThingContext a2 = TPIoTClientManager.this.a2(str);
            return ((QuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a2, QuickSetupRepository.class)).w5(this.f12823c).g0(new a(a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class w1 implements io.reactivex.g0.j<TPCameraDeviceContext, CameraSettingRepository> {
        w1() {
        }

        /* renamed from: a */
        public CameraSettingRepository apply(TPCameraDeviceContext tPCameraDeviceContext) throws Exception {
            return (CameraSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(tPCameraDeviceContext, CameraSettingRepository.class);
        }
    }

    /* loaded from: classes3.dex */
    class x implements io.reactivex.g0.c<Boolean, Map<String, ? extends TDPIoTDevice>, LoginAndTDPBean> {
        x() {
        }

        /* renamed from: a */
        public LoginAndTDPBean apply(Boolean bool, Map<String, ? extends TDPIoTDevice> map) throws Exception {
            return new LoginAndTDPBean(bool, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class x0 implements MediaDeviceListCallBack {
        x0() {
        }

        @Override // com.tplink.libmediaapi.device.apicallback.MediaDeviceListCallBack
        public void onError(Exception exc) {
        }

        @Override // com.tplink.libmediaapi.device.apicallback.MediaDeviceListCallBack
        public void onResult(Boolean bool) {
        }
    }

    /* loaded from: classes3.dex */
    class x1 implements io.reactivex.g0.a {
        x1() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.L3();
            TPIoTClientManager.this.I3();
        }
    }

    /* loaded from: classes3.dex */
    class y implements io.reactivex.g0.j<Map<String, ? extends TDPIoTDevice>, io.reactivex.t<Boolean>> {
        y() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Map<String, ? extends TDPIoTDevice> map) throws Exception {
            if (map.isEmpty()) {
                TPIoTClientManager tPIoTClientManager = TPIoTClientManager.this;
                return tPIoTClientManager.v3(tPIoTClientManager.k1(new HashMap()));
            }
            TPIoTClientManager tPIoTClientManager2 = TPIoTClientManager.this;
            return tPIoTClientManager2.v3(tPIoTClientManager2.k1(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class y0 implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.s.a.b.a f12830c;

        y0(b.d.s.a.b.a aVar) {
            this.f12830c = aVar;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            return TPIoTClientManager.this.f1(this.f12830c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class y1 implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TCAccountBean f12832c;

        y1(TCAccountBean tCAccountBean) {
            this.f12832c = tCAccountBean;
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            TPIoTClientManager.this.n.O(this.f12832c);
            TPIoTClientManager.this.w.t0(this.f12832c);
            TPIoTClientManager.this.n.Z();
            TPIoTClientManager.this.u.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class z implements io.reactivex.g0.a {
        z() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TPIoTClientManager.this.I3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class z0 implements Callable<Boolean> {
        z0() {
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            if (TPIoTClientManager.this.n.A()) {
                return Boolean.TRUE;
            }
            throw new CloudException(-20202, "");
        }
    }

    /* loaded from: classes3.dex */
    class z1 implements io.reactivex.g0.j<String, io.reactivex.e> {
        z1() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(String str) throws Exception {
            return io.reactivex.a.e();
        }
    }

    public TPIoTClientManager(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        b.d.b.d.b.b c3 = b.d.b.f.b.c(aVar);
        this.n = (TCAccountRepository) c3.a(TCAccountRepository.class);
        this.o = (TCDeviceRepository) c3.a(TCDeviceRepository.class);
        this.q = (ThingCloudRepository) c3.a(ThingCloudRepository.class);
        this.r = (SmartRepository) c3.a(SmartRepository.class);
        this.s = (FamilyManagerRepository) c3.a(FamilyManagerRepository.class);
        this.t = (GroupRepository) c3.a(GroupRepository.class);
        this.u = (TCMessagePushRepository) c3.a(TCMessagePushRepository.class);
        this.v = (CloudVideoRepository) c3.a(CloudVideoRepository.class);
        this.p = (DeviceShareRepository) c3.a(DeviceShareRepository.class);
        this.z = (QuickDiscoveryRepository) c3.a(QuickDiscoveryRepository.class);
        this.A.addSource(this.o.E(), new k());
        this.A.addSource(this.q.g0(), new v());
    }

    private io.reactivex.q<List<TCDeviceBean>> A1() {
        return this.o.t().L0(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2 */
    public /* synthetic */ void B2(List list) throws Exception {
        this.s.Q0(new ArrayList(list), null);
    }

    private io.reactivex.q<List<TCDeviceBean>> B1() {
        return this.o.t().L0(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3(String str) {
        this.k.remove(str);
        TPBaseDeviceContext remove = this.j.remove(str);
        if (remove != null) {
            com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.e(remove);
        }
        this.l.remove(str);
        this.m.remove(str);
        C3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2 */
    public /* synthetic */ void D2(List list) throws Exception {
        this.s.Q0(new ArrayList(list), null);
    }

    private void C3(String str) {
        this.D.remove(str);
        K3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(List<String> list) {
        for (String str : list) {
            B3(b.d.w.h.a.g(str));
        }
        I3();
        L3();
    }

    private io.reactivex.q<IoTResult<List<ThingDevice>>> E1() {
        return this.q.U().v0(1L, new p0()).L0(io.reactivex.l0.a.c()).N(new o0()).q0(new IoTResult(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E2 */
    public /* synthetic */ void F2(String str) throws Exception {
        this.s.Q0(Collections.singletonList(str), null);
    }

    private void E3(List<String> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList<BaseALIoTDevice> arrayList = new ArrayList(this.k.values());
            ArrayList<String> arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : arrayList) {
                if (baseALIoTDevice.isSubDevice() && list.contains(baseALIoTDevice.getParentDeviceIDMD5())) {
                    arrayList2.add(baseALIoTDevice.getDeviceIdMD5());
                    arrayList3.add(baseALIoTDevice.getDeviceId());
                }
            }
            for (String str : arrayList2) {
                B3(str);
            }
            L3();
            this.s.Q0(arrayList3, null);
        }
    }

    private io.reactivex.q<List<ThingDevice>> F1() {
        return this.q.U().L0(io.reactivex.l0.a.c()).q0(new ArrayList());
    }

    private void F3(List<String> list) {
        io.reactivex.q.f0(list).T(new e2()).E(new d2()).z(new c2()).F0();
    }

    private io.reactivex.q<List<ThingDevice>> G1() {
        return this.q.U().L0(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G2 */
    public /* synthetic */ void H2() throws Exception {
        this.s.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3() {
        List<IoTDeviceCache> list;
        List<CameraDeviceCache> list2;
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        try {
            list = b.d.w.d.a.c(g3, "iot_device_list_not_camera", "iot_device_list_not_camera", IoTDeviceCache.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        try {
            list2 = b.d.w.d.a.c(g3, "only_camera_device_list", "only_camera_device_list", CameraDeviceCache.class);
        } catch (Exception unused2) {
            list2 = new ArrayList();
        }
        this.k.clear();
        if (list != null && !list.isEmpty()) {
            for (IoTDeviceCache ioTDeviceCache : list) {
                if (!EnumDeviceType.CAMERA.getDeviceType().equals(ioTDeviceCache.getDeviceType())) {
                    ALIoTDevice aLIoTDevice = new ALIoTDevice(ioTDeviceCache);
                    String deviceIdMD5 = aLIoTDevice.getDeviceIdMD5();
                    if (!TextUtils.isEmpty(deviceIdMD5)) {
                        this.k.put(deviceIdMD5, aLIoTDevice);
                    }
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (CameraDeviceCache cameraDeviceCache : list2) {
                ALCameraDevice aLCameraDevice = new ALCameraDevice(cameraDeviceCache);
                String deviceIdMD52 = aLCameraDevice.getDeviceIdMD5();
                if (!TextUtils.isEmpty(deviceIdMD52)) {
                    this.k.put(deviceIdMD52, aLCameraDevice);
                }
            }
        }
        L3();
    }

    private BaseALIoTDevice H1(TDPIoTDevice tDPIoTDevice) {
        if (tDPIoTDevice instanceof TDPCameraDevice) {
            return new ALCameraDevice((TDPCameraDevice) tDPIoTDevice);
        }
        return new ALIoTDevice(tDPIoTDevice);
    }

    public static BaseALIoTDevice I1(@NonNull String str) {
        return ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).Z1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : this.k.values()) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                arrayList2.add(new CameraDeviceCache((ALCameraDevice) baseALIoTDevice));
            } else if (baseALIoTDevice instanceof ALIoTDevice) {
                arrayList.add(new IoTDeviceCache((ALIoTDevice) baseALIoTDevice));
            }
        }
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        b.d.w.d.a.l(g3, arrayList, "iot_device_list_not_camera", "iot_device_list_not_camera");
        b.d.w.d.a.l(g3, arrayList2, "only_camera_device_list", "only_camera_device_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J2 */
    public /* synthetic */ io.reactivex.t K2(List list, Integer num) throws Exception {
        if (num.intValue() < 30) {
            return l2(list);
        }
        return l2(list).i1(io.reactivex.q.c0(100L, TimeUnit.MILLISECONDS), n.f12849c);
    }

    public static TPCameraDeviceContext K1(@NonNull String str) {
        return ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).X3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        this.E.postValue(Boolean.valueOf(d1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ALCameraDevice> L1(Collection<BaseALIoTDevice> collection) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : collection) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                arrayList.add((ALCameraDevice) baseALIoTDevice);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L2 */
    public /* synthetic */ void M2(io.reactivex.e0.c cVar) throws Exception {
        this.z.F();
    }

    private io.reactivex.q<u> M3(Application application, String str, int i3, String str2, String str3) {
        return w.f(application, str, i3, str2, str3).g0(new v0()).n(new u());
    }

    private void N1(@NonNull BaseALIoTDevice baseALIoTDevice) {
        AbstractSubThingRepository abstractSubThingRepository;
        if (baseALIoTDevice.isSwitch()) {
            abstractSubThingRepository = (AbstractSubThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class);
        } else {
            abstractSubThingRepository = baseALIoTDevice.isSensor() ? (AbstractSubThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SensorRepository.class) : null;
        }
        if (abstractSubThingRepository != null) {
            abstractSubThingRepository.j1();
            abstractSubThingRepository.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N2 */
    public /* synthetic */ void O2() throws Exception {
        this.z.w();
    }

    private io.reactivex.q<IoTResult<Map<String, BaseALIoTDevice>>> O1(b.d.s.a.b.a aVar) {
        return io.reactivex.q.f1(A1(), F1(), new p(aVar)).q0(new IoTResult(1)).E0(new IoTResult(0, new HashMap()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.tplink.libtpnetwork.IoTNetwork.repository.kb.c P2(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar, Long l3) throws Exception {
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.tplink.libtpnetwork.IoTNetwork.repository.kb.c Q2(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar, Long l3) throws Exception {
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> Q3(String str, String str2) {
        BaseALIoTDevice baseALIoTDevice = this.k.get(str);
        if (!(baseALIoTDevice instanceof ALCameraDevice)) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        ALCameraDevice aLCameraDevice = (ALCameraDevice) baseALIoTDevice;
        return io.reactivex.q.f0(V3(aLCameraDevice)).g0(new w1()).N(new v1(str2)).z(new u1(aLCameraDevice, str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> R1(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice != null && v2(baseALIoTDevice.isUserRoleTypeDevice(), baseALIoTDevice.isSupportIoTCloud(), baseALIoTDevice.getFamilyId())) {
                arrayList.add(baseALIoTDevice);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R2 */
    public /* synthetic */ void S2(io.reactivex.e0.c cVar) throws Exception {
        this.z.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3(b.d.s.a.b.a aVar, List<TCDeviceBean> list, List<ThingDevice> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TCDeviceBean tCDeviceBean : list) {
            if (!(tCDeviceBean == null || tCDeviceBean.getDeviceId() == null)) {
                arrayList.add(tCDeviceBean.getDeviceId());
                if (tCDeviceBean.isCamera()) {
                    arrayList2.add(tCDeviceBean.getDeviceId());
                }
            }
        }
        for (ThingDevice thingDevice : list2) {
            if (!(thingDevice == null || thingDevice.getThingName() == null || arrayList.contains(thingDevice.getThingName()))) {
                arrayList.add(thingDevice.getThingName());
            }
        }
        if (aVar == null) {
            aVar = new b.d.s.a.b.a();
        }
        this.L = false;
        io.reactivex.q.f0(aVar).R(new q0()).c(x2(arrayList, arrayList2)).C(io.reactivex.l0.a.c()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T2 */
    public /* synthetic */ void U2() throws Exception {
        this.z.w();
    }

    private io.reactivex.q<Boolean> U0(final List<String> list) {
        Map<String, List<String>> n22 = n2(list);
        F3(list);
        if (!n22.isEmpty()) {
            io.reactivex.q.Y(n22.keySet()).N(new b2(n22)).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.l
                @Override // io.reactivex.g0.a
                public final void run() {
                    TPIoTClientManager.this.B2(list);
                }
            }).F0();
        }
        l1(list);
        return io.reactivex.q.f0(Boolean.TRUE);
    }

    private TPBaseDeviceContext U3(BaseALIoTDevice baseALIoTDevice) {
        TPBaseDeviceContext tPBaseDeviceContext;
        TPBaseDeviceContext tPBaseDeviceContext2 = this.j.get(baseALIoTDevice.getDeviceIdMD5());
        if (tPBaseDeviceContext2 == null) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                tPBaseDeviceContext = new TPCameraDeviceContext(this.f100b, baseALIoTDevice);
            } else if (baseALIoTDevice instanceof ALIoTDevice) {
                tPBaseDeviceContext = new ThingContext(this.f100b, baseALIoTDevice);
            } else {
                tPBaseDeviceContext = new ThingContext(baseALIoTDevice.getDeviceIdMD5(), this.f100b);
            }
            this.j.put(tPBaseDeviceContext.getDeviceIdMD5(), tPBaseDeviceContext);
        } else {
            tPBaseDeviceContext = c1(baseALIoTDevice, tPBaseDeviceContext2);
            tPBaseDeviceContext.setIoTDevice(baseALIoTDevice);
        }
        if (tPBaseDeviceContext instanceof TPCameraDeviceContext) {
            o4((TPCameraDeviceContext) tPBaseDeviceContext);
        } else {
            r4((ThingContext) tPBaseDeviceContext);
        }
        return tPBaseDeviceContext;
    }

    private io.reactivex.q<Boolean> V0(final List<String> list) {
        F3(list);
        l1(list);
        return this.o.Q(list).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.i
            @Override // io.reactivex.g0.a
            public final void run() {
                TPIoTClientManager.this.D2(list);
            }
        }).q0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V2 */
    public /* synthetic */ io.reactivex.t W2(List list, Integer num) throws Exception {
        if (num.intValue() < 30) {
            return l2(list);
        }
        return l2(list).i1(io.reactivex.q.c0(100L, TimeUnit.MILLISECONDS), j.f12846c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPCameraDeviceContext V3(BaseALIoTDevice baseALIoTDevice) {
        return W3(baseALIoTDevice, this.f100b);
    }

    private io.reactivex.q<Boolean> W0(List<String> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : list) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(str);
            if (baseALIoTDevice != null && baseALIoTDevice.isSwitch()) {
                hashSet.add(baseALIoTDevice.getDeviceId());
                if (!TextUtils.isEmpty(baseALIoTDevice.getOriginalDeviceId())) {
                    hashSet2.add(baseALIoTDevice.getOriginalDeviceId());
                }
            }
        }
        for (BaseALIoTDevice baseALIoTDevice2 : new ArrayList(this.k.values())) {
            if (baseALIoTDevice2.isSwitch() && !TextUtils.isEmpty(baseALIoTDevice2.getOriginalDeviceId()) && hashSet2.contains(baseALIoTDevice2.getOriginalDeviceId())) {
                hashSet.add(baseALIoTDevice2.getDeviceId());
            }
        }
        b.d.w.c.a.n("deleteSwitch", "switchIdSet: " + com.tplink.libtpnetwork.Utils.i.j(hashSet));
        b.d.w.c.a.n("deleteSwitch", "originDeviceIdSet: " + com.tplink.libtpnetwork.Utils.i.j(hashSet2));
        return U0(new ArrayList(hashSet));
    }

    private TPCameraDeviceContext W3(BaseALIoTDevice baseALIoTDevice, com.tplink.cloud.context.b bVar) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(baseALIoTDevice.getDeviceIdMD5());
        if (tPBaseDeviceContext instanceof TPCameraDeviceContext) {
            tPBaseDeviceContext.setIoTDevice(baseALIoTDevice);
        } else {
            tPBaseDeviceContext = new TPCameraDeviceContext(bVar, baseALIoTDevice);
            this.j.put(tPBaseDeviceContext.getDeviceIdMD5(), tPBaseDeviceContext);
        }
        TPCameraDeviceContext tPCameraDeviceContext = (TPCameraDeviceContext) tPBaseDeviceContext;
        o4(tPCameraDeviceContext);
        return tPCameraDeviceContext;
    }

    private io.reactivex.a X0(List<DeviceUserRoleParams> list) {
        ArrayList arrayList = new ArrayList();
        for (DeviceUserRoleParams deviceUserRoleParams : list) {
            arrayList.add(deviceUserRoleParams.getThingName());
        }
        D3(arrayList);
        return this.p.w(list).C(io.reactivex.l0.a.c()).i(new f2(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X2 */
    public /* synthetic */ io.reactivex.t Y2(boolean z2, Boolean bool) throws Exception {
        if (z2) {
            return g3();
        }
        return io.reactivex.q.f0(new HashMap());
    }

    private TPCameraDeviceContext X3(String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(str);
        if (tPBaseDeviceContext instanceof TPCameraDeviceContext) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(str);
            if (baseALIoTDevice instanceof ALCameraDevice) {
                ((TPCameraDeviceContext) tPBaseDeviceContext).setIoTDevice((ALCameraDevice) baseALIoTDevice);
            }
        } else {
            BaseALIoTDevice baseALIoTDevice2 = this.k.get(str);
            if (baseALIoTDevice2 instanceof ALCameraDevice) {
                tPBaseDeviceContext = new TPCameraDeviceContext(this.f100b, baseALIoTDevice2);
            } else {
                tPBaseDeviceContext = new TPCameraDeviceContext(str, this.f100b);
            }
            this.j.put(str, tPBaseDeviceContext);
        }
        return (TPCameraDeviceContext) tPBaseDeviceContext;
    }

    private io.reactivex.q<Boolean> Z0(b.d.s.a.b.a aVar) {
        return b1().N(new y0(aVar)).L0(io.reactivex.l0.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z2 */
    public /* synthetic */ void a3(Boolean bool) throws Exception {
        L3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThingContext a2(String str) {
        this.l.remove(str);
        this.j.remove(str);
        x xVar = new x();
        xVar.q(new com.tplink.libtpnetwork.IoTNetwork.y.c.c(str));
        this.l.put(str, xVar);
        return d4(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThingContext a4(BaseALIoTDevice baseALIoTDevice) {
        return b4(baseALIoTDevice, this.f100b);
    }

    private io.reactivex.q<Boolean> b1() {
        return io.reactivex.q.X(new z0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b3 */
    public /* synthetic */ void c3() throws Exception {
        this.G.postValue(Boolean.TRUE);
        I3();
    }

    private ThingContext b4(BaseALIoTDevice baseALIoTDevice, com.tplink.cloud.context.b bVar) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(baseALIoTDevice.getDeviceIdMD5());
        if (tPBaseDeviceContext instanceof ThingContext) {
            tPBaseDeviceContext.setIoTDevice(baseALIoTDevice);
        } else {
            tPBaseDeviceContext = new ThingContext(bVar, baseALIoTDevice);
            this.j.put(tPBaseDeviceContext.getDeviceIdMD5(), tPBaseDeviceContext);
        }
        ThingContext thingContext = (ThingContext) tPBaseDeviceContext;
        r4(thingContext);
        return thingContext;
    }

    private TPBaseDeviceContext c1(BaseALIoTDevice baseALIoTDevice, TPBaseDeviceContext tPBaseDeviceContext) {
        boolean z2 = tPBaseDeviceContext instanceof TPCameraDeviceContext;
        if (!(baseALIoTDevice instanceof ALCameraDevice) || z2) {
            boolean z3 = tPBaseDeviceContext instanceof ThingContext;
            if (!(baseALIoTDevice instanceof ALIoTDevice) || z3) {
                return tPBaseDeviceContext;
            }
            ThingContext thingContext = new ThingContext(this.f100b, baseALIoTDevice);
            this.j.put(baseALIoTDevice.getDeviceIdMD5(), thingContext);
            return thingContext;
        }
        TPCameraDeviceContext tPCameraDeviceContext = new TPCameraDeviceContext(this.f100b, baseALIoTDevice);
        this.j.put(baseALIoTDevice.getDeviceIdMD5(), tPCameraDeviceContext);
        return tPCameraDeviceContext;
    }

    private ThingContext c4(String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(str);
        if (tPBaseDeviceContext instanceof ThingContext) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(str);
            if (baseALIoTDevice instanceof ALIoTDevice) {
                ((ThingContext) tPBaseDeviceContext).setIoTDevice((ALIoTDevice) baseALIoTDevice);
            }
        } else {
            BaseALIoTDevice baseALIoTDevice2 = this.k.get(str);
            if (baseALIoTDevice2 instanceof ALIoTDevice) {
                tPBaseDeviceContext = new ThingContext(this.f100b, baseALIoTDevice2);
            } else {
                tPBaseDeviceContext = new ThingContext(str, this.f100b);
            }
            this.j.put(str, tPBaseDeviceContext);
        }
        return (ThingContext) tPBaseDeviceContext;
    }

    private boolean d1() {
        ThingFirmware thingFirmware;
        Map<String, ThingFirmware> map = this.D;
        if (map != null && !map.isEmpty()) {
            for (String str : this.D.keySet()) {
                BaseALIoTDevice baseALIoTDevice = this.k.get(str);
                if (!(baseALIoTDevice == null || baseALIoTDevice.getDeviceState() == EnumIoTDeviceState.OFFLINE || (thingFirmware = this.D.get(str)) == null || !thingFirmware.isNeedToUpgrade())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.t<Boolean> d2(ALIoTDevice aLIoTDevice) {
        ThingContext a4 = a4(m2(aLIoTDevice, true));
        String thingUrl = a4.getThingUrl();
        String thingName = a4.getThingName();
        if (TextUtils.isEmpty(thingUrl) || TextUtils.isEmpty(thingName)) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return this.q.p0(a4.getThingUrl(), a4.getThingName()).g0(a.f12836c).E(new r2()).C(new q2()).q0(Boolean.FALSE);
    }

    private ThingContext d4(String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(str);
        if (!(tPBaseDeviceContext instanceof ThingContext)) {
            tPBaseDeviceContext = new ThingContext(str, this.f100b);
            this.j.put(tPBaseDeviceContext.getDeviceIdMD5(), tPBaseDeviceContext);
        }
        return (ThingContext) tPBaseDeviceContext;
    }

    private void e1() {
        if (this.I == null) {
            io.reactivex.m0.g l12 = io.reactivex.m0.e.n1().l1();
            this.I = l12;
            l12.onNext(new HashMap());
            this.I.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> f1(b.d.s.a.b.a aVar) {
        return this.n.C(x1(), aVar.b(), aVar.g(), aVar.f(), aVar.c(), false);
    }

    private List<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> f2(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(V3(baseALIoTDevice), CommonCameraRepository.class));
            } else {
                ThingContext a4 = a4(baseALIoTDevice);
                if (baseALIoTDevice.isBulb()) {
                    if (baseALIoTDevice.isLightStrip()) {
                        arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, LightStripRepository.class));
                    } else {
                        arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, BulbRepository.class));
                    }
                } else if (baseALIoTDevice.isHub()) {
                    arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, HubRepository.class));
                } else if (baseALIoTDevice.isSensor()) {
                    arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, SensorRepository.class));
                } else if (baseALIoTDevice.isSwitch()) {
                    arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, SwitchRepository.class));
                } else if (baseALIoTDevice.isEnergy()) {
                    arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, TRVRepository.class));
                } else {
                    arrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(a4, PlugRepository.class));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        for (BaseALIoTDevice baseALIoTDevice : this.k.values()) {
            baseALIoTDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
        }
        L3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> g1(List<TCDeviceBean> list, Map<String, ? extends TDPIoTDevice> map) {
        Set<String> hashSet = new HashSet<>();
        for (Map.Entry<String, BaseALIoTDevice> entry : this.k.entrySet()) {
            if (entry.getValue() instanceof ALCameraDevice) {
                hashSet.add(entry.getKey());
            }
        }
        p2(list, map, new HashMap<>(), hashSet);
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : this.k.values()) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                arrayList.add(baseALIoTDevice);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> g2(final List<BaseALIoTDevice> list) {
        return io.reactivex.q.f0(Integer.valueOf(list.size())).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.q
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return TPIoTClientManager.this.K2(list, (Integer) obj);
            }
        }).N(new o());
    }

    private io.reactivex.t<Map<String, ? extends TDPIoTDevice>> g3() {
        return this.x.w(2, ServiceStarter.ERROR_UNKNOWN, 1200).g0(new m1());
    }

    private io.reactivex.q<Boolean> g4(boolean z2) {
        return io.reactivex.q.f0(Boolean.valueOf(z2)).N(new g1()).E(new f1()).y(new e1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, BaseALIoTDevice> h1(List<TCDeviceBean> list, List<ThingDevice> list2) {
        Object obj;
        BaseALIoTDevice baseALIoTDevice;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (TCDeviceBean tCDeviceBean : list) {
                if (tCDeviceBean.isCamera()) {
                    baseALIoTDevice = new ALCameraDevice(tCDeviceBean);
                } else {
                    baseALIoTDevice = new ALIoTDevice(tCDeviceBean);
                }
                hashMap.put(baseALIoTDevice.getDeviceIdMD5(), baseALIoTDevice);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (ThingDevice thingDevice : list2) {
                String g3 = b.d.w.h.a.g(thingDevice.getThingName());
                BaseALIoTDevice baseALIoTDevice2 = (BaseALIoTDevice) hashMap.get(g3);
                if (baseALIoTDevice2 != null) {
                    baseALIoTDevice2.setThingDevice(thingDevice);
                } else {
                    if (thingDevice.isCamera()) {
                        obj = new ALCameraDevice(thingDevice);
                    } else {
                        obj = new ALIoTDevice(thingDevice);
                    }
                    hashMap.put(g3, obj);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Map<String, ? extends TDPIoTDevice>> h3() {
        return this.x.t(8, 300, 1800).F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.r
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TPIoTClientManager.this.S2((c) obj);
            }
        }).g0(new l1()).y(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.b
            @Override // io.reactivex.g0.a
            public final void run() {
                TPIoTClientManager.this.U2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> h4(Map<String, ? extends TDPIoTDevice> map) {
        ArrayList arrayList = new ArrayList();
        for (TDPIoTDevice tDPIoTDevice : map.values()) {
            arrayList.add(m2(H1(tDPIoTDevice), false));
        }
        L3();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> i1(List<TCDeviceBean> list, Map<String, ? extends TDPIoTDevice> map, Map<String, ThingDevice> map2) {
        p2(list, map, map2, new HashSet(this.k.keySet()));
        return new ArrayList(this.k.values());
    }

    @SuppressLint({"CheckResult"})
    private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> i2() {
        return this.x.u().F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TPIoTClientManager.this.M2((io.reactivex.e0.c) obj);
            }
        }).g0(new d1(new ArrayList())).E(new b1()).z(new a1()).y(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.h
            @Override // io.reactivex.g0.a
            public final void run() {
                TPIoTClientManager.this.O2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> i3() {
        io.reactivex.m0.g<Map<String, ? extends TDPIoTDevice>> gVar = this.I;
        if (gVar == null || gVar.j1()) {
            this.I = io.reactivex.m0.e.n1().l1();
            i2().L0(io.reactivex.l0.a.c()).F0();
        }
        return this.I.g0(new j1()).N(new i1()).N(new h1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> i4(Map<String, BaseALIoTDevice> map) {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : map.values()) {
            BaseALIoTDevice m22 = m2(baseALIoTDevice, true);
            if (!m22.isSubDevice() || map.get(m22.getParentDeviceIDMD5()) == null) {
                arrayList.add(m22);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> j1(Map<String, BaseALIoTDevice> map, Map<String, BaseALIoTDevice> map2, Map<String, ? extends TDPIoTDevice> map3, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        for (TDPIoTDevice tDPIoTDevice : map3.values()) {
            if (z2(tDPIoTDevice, g3)) {
                String deviceIdMd5 = tDPIoTDevice.getDeviceIdMd5();
                if (!list.contains(deviceIdMd5)) {
                    BaseALIoTDevice m22 = m2(H1(tDPIoTDevice), true);
                    BaseALIoTDevice remove = map.remove(deviceIdMd5);
                    map2.remove(deviceIdMd5);
                    if (remove != null) {
                        m22.setCloudIoTDevice(remove.getCloudIoTDevice());
                        m22.setThingDevice(remove.getThingDevice());
                    }
                    list.add(deviceIdMd5);
                    arrayList.add(m22);
                } else {
                    BaseALIoTDevice remove2 = map.remove(deviceIdMd5);
                    map2.remove(deviceIdMd5);
                    if (remove2 != null) {
                        m2(remove2, false);
                    }
                }
            }
        }
        Iterator<Map.Entry<String, BaseALIoTDevice>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, BaseALIoTDevice> next = it.next();
            String key = next.getKey();
            BaseALIoTDevice value = next.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !TextUtils.isEmpty(key) && list.contains(key)) {
                m2(value, false);
                it.remove();
                map2.remove(key);
            }
        }
        if (!arrayList.isEmpty()) {
            L3();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> j2() {
        io.reactivex.m0.g<Boolean> gVar = this.J;
        if (gVar != null && !gVar.k1()) {
            return this.J.n(Boolean.FALSE).E(new j2());
        }
        this.i = EnumLoginResult.FAIL;
        return io.reactivex.q.f0(Boolean.FALSE);
    }

    private io.reactivex.q<Boolean> j3(final List<BaseALIoTDevice> list) {
        return io.reactivex.q.f0(Integer.valueOf(list.size())).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.f
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return TPIoTClientManager.this.W2(list, (Integer) obj);
            }
        }).N(new i0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> j4(Map<String, ? extends TDPIoTDevice> map, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        for (TDPIoTDevice tDPIoTDevice : map.values()) {
            if (z2(tDPIoTDevice, g3)) {
                boolean z2 = !list.contains(tDPIoTDevice.getDeviceIdMd5());
                BaseALIoTDevice m22 = m2(H1(tDPIoTDevice), z2);
                if (z2) {
                    list.add(tDPIoTDevice.getDeviceIdMd5());
                    arrayList.add(m22);
                }
            }
        }
        L3();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseALIoTDevice> k1(Map<String, ? extends TDPIoTDevice> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : new HashSet(this.k.keySet())) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(str);
            if (baseALIoTDevice instanceof ALIoTDevice) {
                ALIoTDevice aLIoTDevice = (ALIoTDevice) baseALIoTDevice;
                if (aLIoTDevice.getTDPIoTDevice() != null) {
                    TDPIoTDevice tDPIoTDevice = (TDPIoTDevice) map.get(str);
                    if (!(tDPIoTDevice instanceof TDPCameraDevice)) {
                        aLIoTDevice.setTDPIoTDevice(tDPIoTDevice);
                        aLIoTDevice.setBackupFromCache(false);
                    }
                    if (tDPIoTDevice == null) {
                        arrayList.add(baseALIoTDevice);
                    }
                }
            }
        }
        return arrayList;
    }

    public static ThingContext k2(@NonNull String str) {
        return ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).c4(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, ThingDevice> k4(List<ThingDevice> list) {
        if (list == null || list.isEmpty()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (ThingDevice thingDevice : list) {
            if (!TextUtils.isEmpty(thingDevice.getThingName())) {
                hashMap.put(b.d.w.h.a.g(thingDevice.getThingName()), thingDevice);
            }
        }
        return hashMap;
    }

    private void l1(List<String> list) {
        this.v.G(list).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> l2(List<BaseALIoTDevice> list) {
        return io.reactivex.q.Y(f2(list));
    }

    private io.reactivex.q<Boolean> l3(boolean z2) {
        return s3(z2).g0(new e0()).N(new d0()).z(new c0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseALIoTDevice m2(BaseALIoTDevice baseALIoTDevice, boolean z2) {
        BaseALIoTDevice baseALIoTDevice2 = this.k.get(baseALIoTDevice.getDeviceIdMD5());
        if (baseALIoTDevice2 == null) {
            this.k.put(baseALIoTDevice.getDeviceIdMD5(), baseALIoTDevice);
            return baseALIoTDevice;
        }
        if (baseALIoTDevice.getLocalIoTDevice() != null) {
            baseALIoTDevice2.setLocalIoTDevice(baseALIoTDevice.getLocalIoTDevice());
        }
        if (baseALIoTDevice.getTDPIoTDevice() != null) {
            baseALIoTDevice2.setTDPIoTDevice(baseALIoTDevice.getTDPIoTDevice());
        }
        if (baseALIoTDevice.getCloudIoTDevice() != null) {
            baseALIoTDevice2.setCloudIoTDevice(baseALIoTDevice.getCloudIoTDevice());
        }
        if (baseALIoTDevice.getThingDevice() != null) {
            baseALIoTDevice2.setThingDevice(baseALIoTDevice.getThingDevice());
        }
        if (z2) {
            baseALIoTDevice2.setDeviceState(baseALIoTDevice.getDeviceState());
            baseALIoTDevice2.setDataFromThing(baseALIoTDevice.isDataFromThing());
        }
        baseALIoTDevice2.setBackupFromCache(baseALIoTDevice.isBackupFromCache());
        return baseALIoTDevice2;
    }

    private io.reactivex.q<Boolean> m3(boolean z2) {
        return io.reactivex.q.f1(y1(), s3(z2), new b0()).N(new a0()).z(new z());
    }

    private io.reactivex.q<Boolean> m4(TCAccountBean tCAccountBean, b.d.s.a.b.a aVar, boolean z2) {
        return Z0(aVar).F(new y1(tCAccountBean)).g0(new n1()).o0(new c1(z2)).z(new r0(z2));
    }

    private Map<String, List<String>> n2(List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            TPBaseDeviceContext tPBaseDeviceContext = this.j.get(b.d.w.h.a.g(str));
            String thingUrl = tPBaseDeviceContext != null ? tPBaseDeviceContext.getThingUrl() : null;
            if (!TextUtils.isEmpty(thingUrl)) {
                List list2 = (List) hashMap.get(thingUrl);
                if (list2 != null) {
                    list2.add(str);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    hashMap.put(thingUrl, arrayList);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> n3(List<BaseALIoTDevice> list) {
        return l2(list).N(new j0());
    }

    private io.reactivex.q<Boolean> n4(TCAccountBean tCAccountBean, b.d.s.a.b.a aVar) {
        return m4(tCAccountBean, aVar, false).T0(5L, TimeUnit.SECONDS).o0(new g0());
    }

    private io.reactivex.q<Boolean> o1(final String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(b.d.w.h.a.g(str));
        String thingUrl = tPBaseDeviceContext instanceof ThingContext ? ((ThingContext) tPBaseDeviceContext).getThingUrl() : null;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        F3(arrayList);
        l1(arrayList);
        if (!TextUtils.isEmpty(thingUrl)) {
            return this.q.K(thingUrl, arrayList).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.o
                @Override // io.reactivex.g0.a
                public final void run() {
                    TPIoTClientManager.this.F2(str);
                }
            }).q0(Boolean.FALSE);
        }
        return io.reactivex.q.f0(Boolean.TRUE);
    }

    private void o4(TPCameraDeviceContext tPCameraDeviceContext) {
        f4 f4Var = this.m.get(tPCameraDeviceContext.getDeviceIdMD5());
        if (f4Var == null) {
            this.m.put(tPCameraDeviceContext.getDeviceIdMD5(), new f4(tPCameraDeviceContext));
            return;
        }
        f4Var.i3(tPCameraDeviceContext);
    }

    private io.reactivex.q<Boolean> p1(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return V0(arrayList);
    }

    private void p2(List<TCDeviceBean> list, Map<String, ? extends TDPIoTDevice> map, Map<String, ThingDevice> map2, Set<String> set) {
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        if (list != null && !list.isEmpty()) {
            for (TCDeviceBean tCDeviceBean : list) {
                String g4 = b.d.w.h.a.g(tCDeviceBean.getDeviceId());
                BaseALIoTDevice baseALIoTDevice = this.k.get(g4);
                if (baseALIoTDevice != null) {
                    baseALIoTDevice.setCloudIoTDevice(tCDeviceBean);
                    baseALIoTDevice.setBackupFromCache(false);
                } else {
                    if (tCDeviceBean.isCamera()) {
                        baseALIoTDevice = new ALCameraDevice(tCDeviceBean);
                    } else {
                        baseALIoTDevice = new ALIoTDevice(tCDeviceBean);
                    }
                    this.k.put(g4, baseALIoTDevice);
                }
                ThingDevice remove = map2.remove(g4);
                if (remove != null) {
                    baseALIoTDevice.setThingDevice(remove);
                } else {
                    baseALIoTDevice.setThingDevice(null);
                }
                TDPIoTDevice tDPIoTDevice = (TDPIoTDevice) map.remove(g4);
                if (z2(tDPIoTDevice, g3)) {
                    baseALIoTDevice.setTDPIoTDevice(tDPIoTDevice);
                } else {
                    baseALIoTDevice.setTDPIoTDevice(null);
                }
                set.remove(g4);
            }
        }
        if (map != null && !map.isEmpty()) {
            for (TDPIoTDevice tDPIoTDevice2 : map.values()) {
                if (z2(tDPIoTDevice2, g3)) {
                    String deviceIdMd5 = tDPIoTDevice2.getDeviceIdMd5();
                    BaseALIoTDevice baseALIoTDevice2 = this.k.get(deviceIdMd5);
                    if (baseALIoTDevice2 != null) {
                        baseALIoTDevice2.setTDPIoTDevice(tDPIoTDevice2);
                        baseALIoTDevice2.setBackupFromCache(false);
                    } else {
                        this.k.put(deviceIdMd5, H1(tDPIoTDevice2));
                    }
                    set.remove(deviceIdMd5);
                }
            }
        }
        for (ThingDevice thingDevice : map2.values()) {
            if (thingDevice.isSubThing()) {
                String g5 = b.d.w.h.a.g(thingDevice.getThingName());
                BaseALIoTDevice baseALIoTDevice3 = this.k.get(g5);
                if (baseALIoTDevice3 == null) {
                    this.k.put(g5, new ALIoTDevice(thingDevice));
                } else {
                    baseALIoTDevice3.setThingDevice(thingDevice);
                }
                set.remove(g5);
            }
        }
        for (String str : set) {
            BaseALIoTDevice baseALIoTDevice4 = this.k.get(str);
            if (baseALIoTDevice4 == null || !baseALIoTDevice4.isSubDevice() || baseALIoTDevice4.getThingDevice() != null || this.k.get(baseALIoTDevice4.getParentDeviceIDMD5()) == null) {
                B3(str);
            }
        }
        L3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(List<BaseALIoTDevice> list) {
        this.G.postValue(Boolean.TRUE);
        j3(list).z(new u()).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q4(List<TCDeviceBean> list) {
        if (!(list == null || list.isEmpty())) {
            for (TCDeviceBean tCDeviceBean : list) {
                String g3 = b.d.w.h.a.g(tCDeviceBean.getDeviceId());
                BaseALIoTDevice baseALIoTDevice = this.k.get(g3);
                if (baseALIoTDevice != null) {
                    baseALIoTDevice.setCloudIoTDevice(tCDeviceBean);
                    baseALIoTDevice.setBackupFromCache(false);
                } else {
                    if (tCDeviceBean.isCamera()) {
                        baseALIoTDevice = new ALCameraDevice(tCDeviceBean);
                    } else {
                        baseALIoTDevice = new ALIoTDevice(tCDeviceBean);
                    }
                    this.k.put(g3, baseALIoTDevice);
                }
                U3(baseALIoTDevice);
            }
            L3();
            I3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void r2(String str) {
        ((QuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, QuickSetupRepository.class)).F1().y();
    }

    private io.reactivex.q<Boolean> r3(List<BaseALIoTDevice> list) {
        return l2(list).N(new k0());
    }

    private void r4(ThingContext thingContext) {
        x xVar = this.l.get(thingContext.getDeviceIdMD5());
        if (xVar == null) {
            this.l.put(thingContext.getDeviceIdMD5(), new x(thingContext));
            return;
        }
        xVar.E(thingContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, ? extends TDPIoTDevice> s1(Map<String, ? extends TDPIoTDevice> map) {
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        Iterator<Map.Entry<String, ? extends TDPIoTDevice>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!z2((TDPIoTDevice) it.next().getValue(), g3)) {
                it.remove();
            }
        }
        return map;
    }

    private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> s3(final boolean z2) {
        return io.reactivex.q.f0(Boolean.valueOf(z2)).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.p
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return TPIoTClientManager.this.Y2(z2, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, ? extends TDPIoTDevice> t1(Map<String, ? extends TDPIoTDevice> map, List<String> list) {
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        Iterator<Map.Entry<String, ? extends TDPIoTDevice>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            TDPIoTDevice tDPIoTDevice = (TDPIoTDevice) it.next().getValue();
            if (!z2(tDPIoTDevice, g3) || list.contains(tDPIoTDevice.getDeviceIdMd5())) {
                it.remove();
            } else {
                list.add(tDPIoTDevice.getDeviceIdMd5());
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t2(List<String> list) {
        if (list == null) {
            return false;
        }
        return list.size() != this.N.size() || !list.containsAll(this.N) || !this.N.containsAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t4(List<ThingDevice> list) {
        if (!(list == null || list.isEmpty())) {
            for (ThingDevice thingDevice : list) {
                String g3 = b.d.w.h.a.g(thingDevice.getThingName());
                if (!TextUtils.isEmpty(g3)) {
                    BaseALIoTDevice baseALIoTDevice = this.k.get(g3);
                    if (baseALIoTDevice != null) {
                        baseALIoTDevice.setThingDevice(thingDevice);
                        baseALIoTDevice.setBackupFromCache(false);
                    } else {
                        if (thingDevice.isCamera()) {
                            baseALIoTDevice = new ALCameraDevice(thingDevice);
                        } else {
                            baseALIoTDevice = new ALIoTDevice(thingDevice);
                        }
                        this.k.put(g3, baseALIoTDevice);
                    }
                    U3(baseALIoTDevice);
                }
            }
            L3();
            I3();
        }
    }

    private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> u3(boolean z2) {
        return io.reactivex.q.f0(Boolean.valueOf(z2)).N(new k1());
    }

    private boolean v2(boolean z2, boolean z3, String str) {
        return this.s.j0(z2, z3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> v3(List<BaseALIoTDevice> list) {
        return l2(list).N(new l0());
    }

    private TCAccountBean x1() {
        return this.n.u();
    }

    private io.reactivex.a x2(List<String> list, List<String> list2) {
        return io.reactivex.q.f0(Boolean.TRUE).R(new s0(list2, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3(String str) {
        if (this.k.get(str) != null) {
            h2(str).h().L0(io.reactivex.l0.a.c()).F0();
        }
        B3(str);
    }

    private io.reactivex.q<IoTResult<List<TCDeviceBean>>> y1() {
        return this.o.y().v0(1L, new h0()).L0(io.reactivex.l0.a.c()).N(new f0()).q0(new IoTResult(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y2(List<String> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        return list.size() != this.M.size() || !list.containsAll(this.M) || !this.M.containsAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3() {
        Iterator<Map.Entry<String, BaseALIoTDevice>> it = this.k.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            BaseALIoTDevice value = it.next().getValue();
            if (value.isBackupFromCache()) {
                z2 = true;
                C3(value.getDeviceIdMD5());
                it.remove();
            }
        }
        if (z2) {
            L3();
        }
    }

    private io.reactivex.q<IoTResult<List<TCDeviceBean>>> z1() {
        return this.o.t().v0(1L, new n0()).L0(io.reactivex.l0.a.c()).N(new m0()).q0(new IoTResult(1));
    }

    private boolean z2(TDPIoTDevice tDPIoTDevice, String str) {
        return str != null && tDPIoTDevice != null && !tDPIoTDevice.isFactoryDefault() && str.equalsIgnoreCase(tDPIoTDevice.getOwner());
    }

    public void A3() {
        for (Map.Entry<String, BaseALIoTDevice> entry : this.k.entrySet()) {
            BaseALIoTDevice value = entry.getValue();
            entry.getKey();
            if (value instanceof ALCameraDevice) {
                value.setTDPIoTDevice(null);
            }
        }
        L3();
    }

    public MutableLiveData<List<BaseALIoTDevice>> C1() {
        return this.A;
    }

    public void D1() {
        ArrayList<BaseALIoTDevice> arrayList;
        try {
            arrayList = new ArrayList(this.k.values());
        } catch (Exception unused) {
            arrayList = new ArrayList();
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : arrayList) {
                if (baseALIoTDevice.getDeviceState() == EnumIoTDeviceState.ONLINE && (baseALIoTDevice instanceof ALIoTDevice)) {
                    arrayList2.add(baseALIoTDevice);
                }
            }
            if (!arrayList2.isEmpty()) {
                l2(arrayList2).E(new m2()).F0();
            }
        }
    }

    public io.reactivex.a H3(String str) {
        return io.reactivex.q.f0(str).L0(io.reactivex.l0.a.c()).R(new z1()).i(new x1());
    }

    public f4 J1(String str) {
        if (str == null) {
            return new f4();
        }
        f4 f4Var = this.m.get(str);
        if (f4Var != null || TextUtils.isEmpty(str)) {
            return f4Var;
        }
        f4 f4Var2 = new f4();
        this.m.put(str, f4Var2);
        return f4Var2;
    }

    public void J3(@Nullable BaseALIoTDevice baseALIoTDevice) {
        this.H.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(baseALIoTDevice));
    }

    public void L3() {
        ArrayList<BaseALIoTDevice> arrayList = new ArrayList(this.k.values());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : arrayList) {
            if (baseALIoTDevice instanceof ALCameraDevice) {
                arrayList2.add((ALCameraDevice) baseALIoTDevice);
                MediaDevice mediaDevice = new MediaDevice();
                mediaDevice.setDeviceId(baseALIoTDevice.getDeviceId());
                mediaDevice.setDeviceLocal(com.tplink.libtpnetwork.Utils.f.d(baseALIoTDevice));
                mediaDevice.setDeviceRemoteOnline(com.tplink.libtpnetwork.Utils.f.i(baseALIoTDevice));
                mediaDevice.setLocalIp(com.tplink.libtpnetwork.Utils.f.a(baseALIoTDevice));
                mediaDevice.setDeviceMac(baseALIoTDevice.getDeviceMac());
                mediaDevice.setUserSharePassword(com.tplink.libtpnetwork.Utils.f.b(baseALIoTDevice));
                mediaDevice.setUserShareUsername(com.tplink.libtpnetwork.Utils.f.c(baseALIoTDevice));
                mediaDevice.setP2PAvailable(com.tplink.libtpnetwork.Utils.f.k(baseALIoTDevice));
                mediaDevice.setModel(baseALIoTDevice.getDeviceModel());
                mediaDevice.setUserRoleTypeDevice(baseALIoTDevice.isUserRoleTypeDevice());
                ALCameraDevice aLCameraDevice = (ALCameraDevice) baseALIoTDevice;
                if (aLCameraDevice.getCameraComponent() != null) {
                    CameraComponent cameraComponent = aLCameraDevice.getCameraComponent();
                    ComponentType componentType = ComponentType.VIDEO;
                    mediaDevice.setForceMainStream(cameraComponent.hasComponent(componentType) && aLCameraDevice.getCameraComponent().getComponent(componentType) >= 2);
                }
                mediaDevice.setAppServerUrl(baseALIoTDevice.getAppServerUrl());
                mediaDevice.setSupportIoTCloud(baseALIoTDevice.isSupportIoTCloud());
                mediaDevice.setIotThingUrl(aLCameraDevice.getThingUrl());
                arrayList3.add(mediaDevice);
            }
        }
        this.B.postValue(arrayList2);
        this.A.postValue(arrayList);
        MediaDeviceAPI.refreshDeviceList(arrayList3, new x0());
    }

    public MediatorLiveData<List<ALCameraDevice>> M1() {
        return this.B;
    }

    public io.reactivex.q<u> N3(Application application, int i3, String str) {
        return M3(application, null, i3, null, str).E(new u0(application));
    }

    public io.reactivex.q<u> O3(Application application, String str, int i3, String str2) {
        return M3(application, str, i3, null, str2).E(new t0(application));
    }

    public io.reactivex.q<FirmwareListResult> P1(FirmwareInfoParams firmwareInfoParams) {
        return this.o.D(firmwareInfoParams);
    }

    public io.reactivex.q<u> P3(Application application, int i3, String str) {
        return M3(application, null, i3, str, null);
    }

    public FamilyInfo Q1() {
        return this.s.X();
    }

    public io.reactivex.q<Boolean> R3(String str, String str2) {
        return io.reactivex.q.f0(str).N(new t1(str2)).N(new s1(str2));
    }

    public String S1(String str) {
        BaseALIoTDevice Z1;
        return (!TextUtils.isEmpty(str) && (Z1 = Z1(str)) != null) ? Z1.getDeviceLocation() : "";
    }

    public void T0(String str, ThingFirmware thingFirmware) {
        this.D.put(str, thingFirmware);
        K3();
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> T1() {
        return this.H;
    }

    public void T3() {
        io.reactivex.e0.c cVar = this.O;
        if (cVar != null && !cVar.isDisposed()) {
            this.O.dispose();
        }
    }

    public String U1(String str) {
        BaseALIoTDevice Z1;
        return (!TextUtils.isEmpty(str) && (Z1 = Z1(str)) != null) ? Z1.getDeviceModel() : "";
    }

    public String V1(String str) {
        BaseALIoTDevice Z1;
        return (!TextUtils.isEmpty(str) && (Z1 = Z1(str)) != null) ? Z1.getDeviceType() : "";
    }

    public EnumLoginResult W1() {
        return this.i;
    }

    public MutableLiveData<EnumHomeState> X1() {
        return this.F;
    }

    public io.reactivex.q<u> Y0(Application application, com.tplink.tpble.v vVar, b.d.d0.h2.a.b bVar) {
        return this.y.e(application, vVar).l0(io.reactivex.d0.b.a.a()).N(new w0(bVar));
    }

    public x Y1(String str) {
        x xVar = this.l.get(str);
        if (xVar != null || b.d.w.h.b.d(str)) {
            return xVar;
        }
        x xVar2 = new x();
        this.l.put(str, xVar2);
        return xVar2;
    }

    public void Y3(ALCameraDevice aLCameraDevice) {
        this.k.put(aLCameraDevice.getDeviceIdMD5(), aLCameraDevice);
        V3(aLCameraDevice);
        L3();
    }

    public BaseALIoTDevice Z1(String str) {
        return this.k.get(str);
    }

    public void Z3(TDPIoTDevice tDPIoTDevice) {
        a4(m2(new ALIoTDevice(tDPIoTDevice), true));
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(tDPIoTDevice.getDeviceIdMd5());
        BaseALIoTDevice ioTDevice = tPBaseDeviceContext != null ? tPBaseDeviceContext.getIoTDevice() : null;
        if (ioTDevice != null && ioTDevice.getTDPIoTDevice() != null) {
            Y1(tDPIoTDevice.getDeviceIdMd5()).q(com.tplink.libtpnetwork.Utils.z.a(b.d.s.a.a.g().c(), ioTDevice.getTDPIoTDevice()));
        }
    }

    public void a1() {
        this.H.postValue(null);
    }

    public io.reactivex.q<Boolean> b2() {
        this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
        ArrayList arrayList = new ArrayList();
        this.D.clear();
        e1();
        return this.I.g0(new n(arrayList)).z(new m()).C(new l()).N(new j()).E(new i()).z(new h());
    }

    public io.reactivex.q<Boolean> c2(b.d.s.a.b.a aVar) {
        this.s.U().z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.k
            @Override // io.reactivex.g0.a
            public final void run() {
                TPIoTClientManager.this.H2();
            }
        }).F0();
        this.v.f0().F0();
        this.t.P().F0();
        this.r.S().F0();
        this.o.r().y();
        this.v.I().F0();
        this.v.d0().F0();
        this.v.e0().F0();
        this.v.W().F0();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        this.D.clear();
        e1();
        return io.reactivex.q.f(O1(aVar), this.I, new f(hashMap, arrayList)).l(this.I.R0(1).g0(new g(hashMap))).z(new e()).N(new d()).E(new c()).z(new b());
    }

    public io.reactivex.a d3() {
        return this.n.J().l(new a()).i(new t2());
    }

    public MutableLiveData<Boolean> e2() {
        return this.G;
    }

    public io.reactivex.a e3(String str) {
        return io.reactivex.q.f0(str).R(new a2());
    }

    public void e4() {
        l2(new ArrayList(this.k.values())).E(new l2()).F0();
    }

    public void f4(String str) {
        for (BaseALIoTDevice baseALIoTDevice : new ArrayList(this.k.values())) {
            if (baseALIoTDevice.isSubDevice() && TextUtils.equals(baseALIoTDevice.getParentDeviceIDMD5(), str)) {
                baseALIoTDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
            }
        }
    }

    public com.tplink.libtpnetwork.IoTNetwork.repository.kb.c h2(String str) {
        BaseALIoTDevice baseALIoTDevice = this.k.get(str);
        if (baseALIoTDevice instanceof ALCameraDevice) {
            return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, CommonCameraRepository.class);
        }
        if (baseALIoTDevice == null || !baseALIoTDevice.isBulb()) {
            if (baseALIoTDevice != null && baseALIoTDevice.isHub()) {
                return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, HubRepository.class);
            }
            if (baseALIoTDevice != null && baseALIoTDevice.isSensor()) {
                return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, SensorRepository.class);
            }
            if (baseALIoTDevice != null && baseALIoTDevice.isSwitch()) {
                return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, SwitchRepository.class);
            }
            if (baseALIoTDevice == null || !baseALIoTDevice.isEnergy()) {
                return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, PlugRepository.class);
            }
            return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, TRVRepository.class);
        } else if (baseALIoTDevice.isLightStrip()) {
            return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, LightStripRepository.class);
        } else {
            return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, BulbRepository.class);
        }
    }

    public io.reactivex.q<Boolean> k3(boolean z2) {
        if (w2()) {
            return m3(z2);
        }
        return l3(z2);
    }

    public io.reactivex.q<Boolean> l4(TCAccountBean tCAccountBean, b.d.s.a.b.a aVar, boolean z2) {
        io.reactivex.m0.g<Boolean> gVar = this.J;
        if (gVar == null || gVar.j1()) {
            this.J = io.reactivex.m0.e.n1().l1();
            g4(z2).L0(io.reactivex.l0.a.c()).F0();
        }
        return m4(tCAccountBean, aVar, true);
    }

    public void m1(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice.isUserRoleTypeDevice()) {
                arrayList3.add(new DeviceUserRoleParams(baseALIoTDevice.getDeviceId(), baseALIoTDevice.isSubDevice()));
            } else {
                if (!baseALIoTDevice.isSupportIoTCloud()) {
                    arrayList.add(baseALIoTDevice.getDeviceId());
                } else if (baseALIoTDevice.isSwitch()) {
                    arrayList5.add(baseALIoTDevice.getDeviceIdMD5());
                } else {
                    arrayList2.add(baseALIoTDevice.getDeviceId());
                }
                if (baseALIoTDevice.isHub()) {
                    arrayList4.add(baseALIoTDevice.getDeviceIdMD5());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            V0(arrayList).F0();
        }
        if (!arrayList2.isEmpty()) {
            U0(arrayList2).F0();
        }
        if (!arrayList3.isEmpty()) {
            X0(arrayList3).y();
        }
        if (!arrayList4.isEmpty()) {
            E3(arrayList4);
        }
        if (!arrayList5.isEmpty()) {
            W0(arrayList5);
        }
    }

    public io.reactivex.q<Boolean> n1(String str) {
        BaseALIoTDevice baseALIoTDevice = this.k.get(str);
        if (baseALIoTDevice == null || TextUtils.isEmpty(baseALIoTDevice.getDeviceId())) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        String deviceId = baseALIoTDevice.getDeviceId();
        if (baseALIoTDevice.isHub()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseALIoTDevice.getDeviceIdMD5());
            E3(arrayList);
        }
        if (baseALIoTDevice.isSwitch() && !TextUtils.isEmpty(baseALIoTDevice.getOriginalDeviceId())) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(baseALIoTDevice.getDeviceIdMD5());
            return W0(arrayList2);
        } else if (baseALIoTDevice.isSupportIoTCloud()) {
            return o1(deviceId);
        } else {
            return p1(deviceId);
        }
    }

    public MutableLiveData<Boolean> o2() {
        return this.E;
    }

    public io.reactivex.q<Boolean> o3(b.d.s.a.b.a aVar, boolean z2) {
        return io.reactivex.q.f1(n4(this.n.u(), aVar), u3(z2), new x()).N(new w(aVar));
    }

    public io.reactivex.q<Boolean> p3(b.d.s.a.b.a aVar, boolean z2) {
        return io.reactivex.q.e1(z1(), E1(), u3(z2), new t()).g0(new s(aVar)).E(new r()).N(new q());
    }

    public void p4(String str, List<BaseALIoTDevice> list, boolean z2) {
        BaseALIoTDevice baseALIoTDevice = this.k.get(str);
        HashMap hashMap = new HashMap();
        for (BaseALIoTDevice baseALIoTDevice2 : new ArrayList(this.k.values())) {
            if (baseALIoTDevice2.isSubDevice() && TextUtils.equals(str, baseALIoTDevice2.getParentDeviceIDMD5())) {
                hashMap.put(baseALIoTDevice2.getDeviceIdMD5(), baseALIoTDevice2);
            }
        }
        if (z2) {
            if (!(baseALIoTDevice == null || list == null)) {
                for (BaseALIoTDevice baseALIoTDevice3 : list) {
                    BaseALIoTDevice baseALIoTDevice4 = (BaseALIoTDevice) hashMap.get(baseALIoTDevice3.getDeviceIdMD5());
                    if (baseALIoTDevice4 == null || baseALIoTDevice3.getBindCount() >= baseALIoTDevice4.getBindCount()) {
                        if (baseALIoTDevice4 == null && this.k.containsKey(baseALIoTDevice3.getDeviceIdMD5())) {
                            b.d.w.c.a.e("ChildDevice", "updateChildDevice removeDeviceClientContext");
                            B3(baseALIoTDevice3.getDeviceIdMD5());
                        }
                        BaseALIoTDevice m22 = m2(baseALIoTDevice3, true);
                        c4(baseALIoTDevice3.getDeviceIdMD5());
                        N1(baseALIoTDevice3);
                        if (m22.getLocalIoTDevice() instanceof IoTSubDevice) {
                            IoTSubDevice ioTSubDevice = (IoTSubDevice) m22.getLocalIoTDevice();
                            if (ioTSubDevice.getComponents() == null) {
                                m22.setDeviceState(EnumIoTDeviceState.OFFLINE);
                            } else {
                                m22.setDeviceState("online".equals(ioTSubDevice.getStatus()) ? EnumIoTDeviceState.ONLINE : EnumIoTDeviceState.OFFLINE);
                            }
                        } else {
                            m22.setDeviceState(baseALIoTDevice.getDeviceState());
                        }
                    }
                    hashMap.remove(baseALIoTDevice3.getDeviceIdMD5());
                }
            }
            for (String str2 : hashMap.keySet()) {
                B3(str2);
            }
            L3();
            I3();
            this.G.postValue(Boolean.TRUE);
            return;
        }
        g2(new ArrayList(hashMap.values())).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.m
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TPIoTClientManager.this.a3((Boolean) obj);
            }
        }).z(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.IoTNetwork.g
            @Override // io.reactivex.g0.a
            public final void run() {
                TPIoTClientManager.this.c3();
            }
        }).F0();
    }

    public void q1(String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(str);
        BaseALIoTDevice ioTDevice = tPBaseDeviceContext != null ? tPBaseDeviceContext.getIoTDevice() : null;
        String g3 = b.d.w.h.a.g(this.f100b.c().getCloudUserName());
        if (ioTDevice != null && ioTDevice.getTDPIoTDevice() != null && !ioTDevice.getTDPIoTDevice().isFactoryDefault()) {
            x Y1 = Y1(str);
            TDPIoTDevice tDPIoTDevice = ioTDevice.getTDPIoTDevice();
            if (g3.equalsIgnoreCase(tDPIoTDevice.getOwner())) {
                Y1.q(com.tplink.libtpnetwork.Utils.z.a(this.f100b.c(), tDPIoTDevice));
            }
        }
    }

    public io.reactivex.q<Boolean> q3() {
        ArrayList<BaseALIoTDevice> arrayList = new ArrayList(this.k.values());
        List<BaseALIoTDevice> arrayList2 = new ArrayList<>();
        for (BaseALIoTDevice baseALIoTDevice : arrayList) {
            if (baseALIoTDevice instanceof ALIoTDevice) {
                arrayList2.add(baseALIoTDevice);
            }
        }
        if (w2()) {
            arrayList2 = R1(arrayList2);
        }
        if (arrayList2.isEmpty()) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return r3(arrayList2);
    }

    public void r1(String str) {
        TPBaseDeviceContext tPBaseDeviceContext = this.j.get(str);
        BaseALIoTDevice ioTDevice = tPBaseDeviceContext != null ? tPBaseDeviceContext.getIoTDevice() : null;
        if (ioTDevice != null && ioTDevice.getTDPIoTDevice() != null && ioTDevice.getTDPIoTDevice().isFactoryDefault()) {
            Y1(str).q(com.tplink.libtpnetwork.Utils.z.a(b.d.s.a.a.g().c(), ioTDevice.getTDPIoTDevice()));
        }
    }

    @SuppressLint({"CheckResult"})
    public void s2(String str) {
        T3();
        this.O = io.reactivex.q.a0(3L, 20L, TimeUnit.SECONDS).G0(new s2(str));
    }

    public io.reactivex.q<Boolean> s4(ALCameraDevice aLCameraDevice) {
        return io.reactivex.q.f0(aLCameraDevice).g0(new r1()).N(new q1()).g0(new p1()).L0(io.reactivex.l0.a.c()).z(new o1());
    }

    public io.reactivex.q<Boolean> t3(boolean z2) {
        return u3(z2).N(new y());
    }

    public io.reactivex.q<Boolean> u1(String str) {
        return B1().N(new o2(str));
    }

    public boolean u2(Throwable th) {
        if (!(th instanceof CloudAccountV1Exception)) {
            return false;
        }
        CloudAccountV1Exception cloudAccountV1Exception = (CloudAccountV1Exception) th;
        if (cloudAccountV1Exception.getLoginV1Result() == null) {
            return false;
        }
        int errorCode = cloudAccountV1Exception.getLoginV1Result().getErrorCode();
        if (errorCode == -23003 || errorCode == -20661 || errorCode == -20615 || errorCode == -20202 || errorCode == -20200) {
            return true;
        }
        switch (errorCode) {
            case -20602:
            case -20601:
            case -20600:
                return true;
            default:
                return false;
        }
    }

    public io.reactivex.q<Boolean> v1(String str) {
        return B1().g0(new n2(str));
    }

    public io.reactivex.a w(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(str);
            if (baseALIoTDevice != null && !TextUtils.isEmpty(baseALIoTDevice.getDeviceId())) {
                arrayList.add(baseALIoTDevice.getDeviceId());
            }
        }
        if (arrayList.isEmpty()) {
            return io.reactivex.a.e();
        }
        return x(arrayList);
    }

    public io.reactivex.q<Boolean> w1(String str, TCDeviceBean tCDeviceBean) {
        return G1().N(new p2(str, tCDeviceBean));
    }

    public boolean w2() {
        return this.F.getValue() == EnumHomeState.ONLINE;
    }

    public void w3(int i3, String str, String str2, String str3, String str4) {
        if (this.u.H()) {
            this.K = str2;
            this.u.M("ANDROID", i3, str, str2, str3, Locale.getDefault().toString(), str4);
        }
    }

    public io.reactivex.a x(List<String> list) {
        DeviceUserRoleListParams deviceUserRoleListParams = new DeviceUserRoleListParams();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            BaseALIoTDevice baseALIoTDevice = this.k.get(b.d.w.h.a.g(str));
            if (baseALIoTDevice != null && !TextUtils.isEmpty(baseALIoTDevice.getDeviceId())) {
                arrayList.add(new DeviceUserRoleParams(str, baseALIoTDevice.isSubDevice()));
            }
        }
        deviceUserRoleListParams.setThings(arrayList);
        deviceUserRoleListParams.setUserAccount(this.f100b.c().getEmail());
        return this.p.B(deviceUserRoleListParams).C(io.reactivex.l0.a.c()).i(new g2(list));
    }

    public io.reactivex.q<Boolean> z3(String str) {
        return io.reactivex.q.f0(str).N(new k2()).E(new i2(str)).z(new h2()).L0(io.reactivex.l0.a.c());
    }
}
