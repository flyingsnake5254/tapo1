package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoListResult;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoResult;
import com.tplink.cloud.bean.webservice.result.DeviceAvatarResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelStreamStatus;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.Utils.z;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraBasicInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraDeviceFeatureCache;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.business.model.CameraErrorCode;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.model.AESEncryptKey;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BindStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentBean;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.HomePageDeviceInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LastAlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CommonCameraRepository extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c {

    /* renamed from: e  reason: collision with root package name */
    private TCDeviceRepository f14197e;
    private com.tplink.cloud.context.b j;
    private TPIoTClientManager k;

    /* renamed from: d  reason: collision with root package name */
    private com.tplink.libtpnetwork.Utils.o f14196d = com.tplink.libtpnetwork.Utils.o.h0();

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.e0.b f14198f = new io.reactivex.e0.b();
    private volatile boolean g = false;
    private io.reactivex.m0.g<com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult>> i = io.reactivex.m0.b.n1().l1();
    private long h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.l<Response<BindStatus>> {
        a() {
        }

        /* renamed from: a */
        public boolean test(Response<BindStatus> response) throws Exception {
            return Method.CHANGE_ADMIN_PASSWORD.getValue().equals(response.getMethod());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14200c;

        b(ALCameraDevice aLCameraDevice) {
            this.f14200c = aLCameraDevice;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            CommonCameraRepository.this.c0(this.f14200c).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.g<Throwable> {
            a() {
            }

            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                String deviceMac = ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice() != null ? ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice().getDeviceMac() : "";
                b.d.w.c.a.c("cameraTest", ChannelStreamStatus.PlaybackStreamStatus.OFFLINE + deviceMac + th.getMessage());
                th.printStackTrace();
                CommonCameraRepository.this.T0();
                ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).f13334b.L3();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements io.reactivex.g0.g<Boolean> {
            b() {
            }

            /* renamed from: a */
            public void accept(Boolean bool) throws Exception {
                b.d.w.c.a.c("cameraTest", "online222222222222");
                CommonCameraRepository.this.U0();
                ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).f13334b.L3();
                ALCameraDevice ioTDevice = ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getIoTDevice();
                if (ioTDevice != null) {
                    CommonCameraRepository.this.X(ioTDevice.getSoftwareVersion());
                }
                if (CommonCameraRepository.this.l0()) {
                    CommonCameraRepository.this.f0(ioTDevice).F0();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0275c implements io.reactivex.g0.g<Boolean> {
            C0275c() {
            }

            /* renamed from: a */
            public void accept(Boolean bool) throws Exception {
                ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).f13334b.L3();
            }
        }

        c() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return CommonCameraRepository.this.e0().E(new b()).C(new a());
            }
            return CommonCameraRepository.this.j().E(new C0275c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.g<CameraComponent> {
        d() {
        }

        /* renamed from: a */
        public void accept(CameraComponent cameraComponent) throws Exception {
            ALCameraDevice cameraDevice = ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice();
            if (cameraDevice != null) {
                cameraDevice.setCameraComponent(cameraComponent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            th.getLocalizedMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {
        f() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            return CommonCameraRepository.this.L0().q0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14209c;

        g(ALCameraDevice aLCameraDevice) {
            this.f14209c = aLCameraDevice;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            if (this.f14209c.getBasicInfo() == null || !this.f14209c.getBasicInfo().isFfs()) {
                return io.reactivex.q.f0(Boolean.TRUE);
            }
            return CommonCameraRepository.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements io.reactivex.g0.j<Response<AlarmMultiInfo>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14211c;

        h(ALCameraDevice aLCameraDevice) {
            this.f14211c = aLCameraDevice;
        }

        /* renamed from: a */
        public Boolean apply(Response<AlarmMultiInfo> response) throws Exception {
            AlarmMultiInfo result = response.getResult();
            BasicInfo deviceInfo = result.getDeviceInfo();
            LastAlarmInfo lastAlarmInfo = result.getLastAlarmInfo();
            if (deviceInfo != null) {
                this.f14211c.setBasicInfo(deviceInfo);
            }
            if (lastAlarmInfo != null) {
                this.f14211c.setLastAlarmInfo(lastAlarmInfo);
            }
            ALCameraDevice aLCameraDevice = this.f14211c;
            if (!(aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null || !this.f14211c.getCameraComponent().isSupportUpnp())) {
                this.f14211c.setUpnpInfo(result.getUpnpInfo());
                this.f14211c.setUpnpCommStatus(result.getUpnpCommStatus());
                this.f14211c.setUpnpStatus(result.getUpnpStatus());
                this.f14211c.setPubIp(result.getPubIp());
                this.f14211c.setUpnpPsk(result.getUpnpPsk());
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements io.reactivex.g0.j<DeviceConfigInfoResult, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14213c;

        i(ALCameraDevice aLCameraDevice) {
            this.f14213c = aLCameraDevice;
        }

        /* renamed from: a */
        public Boolean apply(DeviceConfigInfoResult deviceConfigInfoResult) throws Exception {
            return Boolean.valueOf(CommonCameraRepository.this.k0(this.f14213c, deviceConfigInfoResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.j<DeviceConfigInfoListResult, io.reactivex.t<DeviceConfigInfoResult>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14215c;

        j(ALCameraDevice aLCameraDevice) {
            this.f14215c = aLCameraDevice;
        }

        /* renamed from: a */
        public io.reactivex.t<DeviceConfigInfoResult> apply(DeviceConfigInfoListResult deviceConfigInfoListResult) throws Exception {
            List<DeviceConfigInfoResult> deviceConfigInfo = deviceConfigInfoListResult.getDeviceConfigInfo();
            if (deviceConfigInfo.isEmpty()) {
                return io.reactivex.q.J(new Exception("DeviceConfigInfo is Empty"));
            }
            DeviceConfigInfoResult deviceConfigInfoResult = deviceConfigInfo.get(0);
            if (deviceConfigInfoResult.getDeviceId().equals(this.f14215c.getDeviceId())) {
                return io.reactivex.q.f0(deviceConfigInfoResult);
            }
            return io.reactivex.q.J(new Exception("DeviceConfigInfo Not fit"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements io.reactivex.g0.g<Throwable> {
        k() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String deviceMac = ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice() != null ? ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice().getDeviceMac() : "";
            b.d.w.c.a.c("cameraTest", "offline--" + deviceMac + th.getMessage());
            th.printStackTrace();
            CommonCameraRepository.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l implements io.reactivex.g0.j<ALCameraDevice, io.reactivex.t<DeviceConfigInfoListResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.j<com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult>, io.reactivex.t<DeviceConfigInfoListResult>> {
            a() {
            }

            /* renamed from: a */
            public io.reactivex.t<DeviceConfigInfoListResult> apply(com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult> aVar) throws Exception {
                if (aVar.a() != null) {
                    return io.reactivex.q.f0(aVar.a());
                }
                return io.reactivex.q.J(aVar.b());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements io.reactivex.g0.g<Throwable> {
            b() {
            }

            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                CommonCameraRepository.this.i.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a(th));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class c implements io.reactivex.g0.g<DeviceConfigInfoListResult> {
            c() {
            }

            /* renamed from: a */
            public void accept(DeviceConfigInfoListResult deviceConfigInfoListResult) throws Exception {
                CommonCameraRepository.this.i.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a(deviceConfigInfoListResult));
            }
        }

        l() {
        }

        /* renamed from: a */
        public io.reactivex.t<DeviceConfigInfoListResult> apply(ALCameraDevice aLCameraDevice) throws Exception {
            if (CommonCameraRepository.this.h > 0 && System.currentTimeMillis() - CommonCameraRepository.this.h < 30000) {
                return CommonCameraRepository.this.i.Q0(1L).N(new a()).T0(15L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
            }
            CommonCameraRepository.this.h = System.currentTimeMillis();
            return CommonCameraRepository.this.f14197e.z(Collections.singletonList(aLCameraDevice.getDeviceId())).E(new c()).C(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m implements io.reactivex.g0.l<ALCameraDevice> {
        m() {
        }

        /* renamed from: a */
        public boolean test(ALCameraDevice aLCameraDevice) throws Exception {
            return aLCameraDevice.isRemoteOnline() && !aLCameraDevice.isLocalOnly();
        }
    }

    /* loaded from: classes3.dex */
    class n implements io.reactivex.g0.g<Boolean> {
        n() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            if (((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getIoTDevice() != null && ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getIoTDevice().getThingDevice() != null) {
                return;
            }
            if (((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice() == null || ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice().isFirmwareSupportIoTCloud() || ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getCameraDevice().getCloudCameraDevice() == null) {
                CommonCameraRepository.this.l().h2().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).F0();
                CommonCameraRepository.this.l().e3().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).F0();
                return;
            }
            CommonCameraRepository.this.l().h2().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o implements io.reactivex.g0.g<CameraComponent> {
        o() {
        }

        /* renamed from: a */
        public void accept(CameraComponent cameraComponent) throws Exception {
            CameraBasicInfo localIoTDevice;
            ALCameraDevice ioTDevice = ((TPCameraDeviceContext) ((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) CommonCameraRepository.this).a).getIoTDevice();
            if (ioTDevice != null && (localIoTDevice = ioTDevice.getLocalIoTDevice()) != null) {
                CommonCameraRepository.this.V0(localIoTDevice.getSoftwareVer(), cameraComponent.getComponentList());
            }
        }
    }

    /* loaded from: classes3.dex */
    class p implements io.reactivex.g0.l<Throwable> {
        p() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return th instanceof CameraException;
        }
    }

    /* loaded from: classes3.dex */
    class q implements io.reactivex.g0.j<Response<HomePageDeviceInfo>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14226c;

        q(ALCameraDevice aLCameraDevice) {
            this.f14226c = aLCameraDevice;
        }

        /* renamed from: a */
        public Boolean apply(Response<HomePageDeviceInfo> response) throws Exception {
            HomePageDeviceInfo result = response.getResult();
            BasicInfo deviceInfo = result.getDeviceInfo();
            LastAlarmInfo lastAlarmInfo = result.getLastAlarmInfo();
            CameraComponent componentInfo = result.getComponentInfo();
            if (deviceInfo != null) {
                this.f14226c.setBasicInfo(deviceInfo);
            }
            if (lastAlarmInfo != null) {
                this.f14226c.setLastAlarmInfo(lastAlarmInfo);
            }
            if (componentInfo != null) {
                this.f14226c.setCameraComponent(componentInfo);
            }
            if (componentInfo != null) {
                CommonCameraRepository.this.V0(this.f14226c.getSoftwareVersion(), componentInfo.getComponentList());
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14228c;

        r(ALCameraDevice aLCameraDevice) {
            this.f14228c = aLCameraDevice;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            b.d.w.c.a.c("cameraTest", "online11111111");
            if (this.f14228c.getDeviceState() != EnumIoTDeviceState.ONLINE || CommonCameraRepository.this.l0()) {
                CommonCameraRepository.this.f0(this.f14228c).L0(io.reactivex.l0.a.c()).F0();
            }
            CommonCameraRepository.this.U0();
            CommonCameraRepository.this.c0(this.f14228c).L0(io.reactivex.l0.a.c()).F0();
            b.d.w.c.a.c("cameraTest", "online");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class s implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {
        s() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            return CommonCameraRepository.this.M0().q0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class t implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {
        t() {
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            return CommonCameraRepository.this.L0().q0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class u implements io.reactivex.g0.j<Boolean, io.reactivex.t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14232c;

        u(ALCameraDevice aLCameraDevice) {
            this.f14232c = aLCameraDevice;
        }

        /* renamed from: a */
        public io.reactivex.t<Boolean> apply(Boolean bool) throws Exception {
            if (this.f14232c.getBasicInfo() == null || !this.f14232c.getBasicInfo().isFfs()) {
                return io.reactivex.q.f0(Boolean.TRUE);
            }
            return CommonCameraRepository.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class v implements io.reactivex.g0.l<Throwable> {
        v() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return th instanceof CameraException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class w implements io.reactivex.g0.j<Response<HomePageDeviceInfo>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ALCameraDevice f14235c;

        w(ALCameraDevice aLCameraDevice) {
            this.f14235c = aLCameraDevice;
        }

        /* renamed from: a */
        public Boolean apply(Response<HomePageDeviceInfo> response) throws Exception {
            HomePageDeviceInfo result = response.getResult();
            BasicInfo deviceInfo = result.getDeviceInfo();
            LastAlarmInfo lastAlarmInfo = result.getLastAlarmInfo();
            CameraComponent componentInfo = result.getComponentInfo();
            if (deviceInfo != null) {
                this.f14235c.setBasicInfo(deviceInfo);
            }
            if (lastAlarmInfo != null) {
                this.f14235c.setLastAlarmInfo(lastAlarmInfo);
            }
            if (componentInfo != null) {
                this.f14235c.setCameraComponent(componentInfo);
            }
            if (componentInfo != null) {
                CommonCameraRepository.this.V0(this.f14235c.getSoftwareVersion(), componentInfo.getComponentList());
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class x implements io.reactivex.g0.l<Throwable> {
        x() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class y implements io.reactivex.g0.j<Response<BindStatus>, Boolean> {
        y() {
        }

        /* renamed from: a */
        public Boolean apply(Response<BindStatus> response) throws Exception {
            return Boolean.valueOf(response.isSuccess());
        }
    }

    public CommonCameraRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        com.tplink.cloud.context.b tcAccountContext = tPCameraDeviceContext.getTcAccountContext();
        this.j = tcAccountContext;
        this.k = (TPIoTClientManager) b.d.b.f.b.a(tcAccountContext, TPIoTClientManager.class);
        this.f14197e = (TCDeviceRepository) b.d.b.f.b.c(tPCameraDeviceContext.getTcAccountContext()).a(TCDeviceRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ io.reactivex.t E0(ALCameraDevice aLCameraDevice, byte[] bArr) throws Exception {
        return this.f14197e.W(aLCameraDevice.getDeviceId(), "image/png", bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(ALCameraDevice aLCameraDevice, String str, String str2, DeviceAvatarResult deviceAvatarResult) throws Exception {
        a1(aLCameraDevice, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ byte[] I0(String str) throws Exception {
        return W(BitmapFactory.decodeStream(new FileInputStream(str)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void J0(ALCameraDevice aLCameraDevice, boolean z, String str, String str2) throws Exception {
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
        if (cameraAvatarInfo == null) {
            cameraAvatarInfo = new CameraAvatarInfo();
            aLCameraDevice.setCameraAvatarInfo(cameraAvatarInfo);
        }
        cameraAvatarInfo.setAvatarDefault(Boolean.valueOf(z));
        cameraAvatarInfo.setAvatarRemoteUrl(str);
        cameraAvatarInfo.setAvatarName(str2);
        cameraAvatarInfo.setAvatarNameModified(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> L0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        CameraComponent cameraComponent = cameraDevice.getCameraComponent();
        if (!cameraDevice.isUserRoleTypeDevice() || cameraDevice.getP2PSharePwd() != null) {
            return io.reactivex.q.f0(Boolean.TRUE);
        }
        if (cameraComponent == null || !cameraComponent.hasComponent(ComponentType.DEVICE_SHARE)) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return h0().g0(h1.f14451c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> M0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        CameraComponent cameraComponent = cameraDevice.getCameraComponent();
        if (cameraComponent == null || !cameraComponent.isSupportUpnp()) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return i0().g0(u1.f14605c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> P0() {
        if (!((TPCameraDeviceContext) this.a).isOwner()) {
            return io.reactivex.q.J(new Exception("user cannot setup for FFS"));
        }
        TCAccountBean c2 = ((TPCameraDeviceContext) this.a).getAccountContext().c();
        Account account = new Account(c2.getCloudUserName(), c2.getPassword(), false);
        String formatRecordSchedules = ScheduleParser.formatRecordSchedules(Collections.singletonList(new Schedule(0, 0, 24, 0, 2)));
        RecordPlanInfo recordPlanInfo = new RecordPlanInfo(OptionSwitch.ON.toString(), formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules, formatRecordSchedules);
        return l().c3(account, ((TPCameraDeviceContext) this.a).getAccountContext().c().getCloudUserName() + "_" + z.b(((TPCameraDeviceContext) this.a).getIoTDevice().getDeviceMac()), com.tplink.libtpnetwork.cameranetwork.util.c.f15001b, com.tplink.libtpnetwork.cameranetwork.util.c.f15002c, recordPlanInfo).L(new a()).g0(new y()).v0(2L, new x());
    }

    private io.reactivex.q<CameraComponent> Q0() {
        return l().E().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).E(new d());
    }

    private io.reactivex.q<Boolean> S0(ALCameraDevice aLCameraDevice) {
        return l().V(aLCameraDevice != null ? aLCameraDevice.getCameraComponent() : null).g0(new h(aLCameraDevice)).N(new g(aLCameraDevice)).N(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setDeviceState(EnumIoTDeviceState.ONLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(String str, List<ComponentBean> list) {
        this.f14196d.X0(((TPCameraDeviceContext) this.a).getDeviceIdMD5(), com.tplink.libtpnetwork.Utils.i.h(new CameraDeviceFeatureCache(str, list)));
    }

    private byte[] W(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            b.d.w.c.a.d(e2.toString());
            return null;
        }
    }

    private void W0(ALCameraDevice aLCameraDevice, CameraAvatarInfo cameraAvatarInfo, DeviceFeatureInfo deviceFeatureInfo, String str) {
        deviceFeatureInfo.setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
        DeviceAvatarFeatureInfo deviceAvatarFeatureInfo = deviceFeatureInfo.getDeviceAvatarFeatureInfo();
        if (deviceAvatarFeatureInfo != null) {
            if (cameraAvatarInfo == null) {
                cameraAvatarInfo = new CameraAvatarInfo();
            }
            cameraAvatarInfo.setAvatarDefault(deviceAvatarFeatureInfo.isDefaultAvatarName());
            cameraAvatarInfo.setAvatarName(deviceAvatarFeatureInfo.getAvatarName());
            cameraAvatarInfo.setAvatarRemoteUrl(str);
            cameraAvatarInfo.setAvatarNameModified(Boolean.FALSE);
            aLCameraDevice.setCameraAvatarInfo(cameraAvatarInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void X(String str) {
        CameraDeviceFeatureCache cameraDeviceFeatureCache = (CameraDeviceFeatureCache) com.tplink.libtpnetwork.Utils.i.b(this.f14196d.S(((TPCameraDeviceContext) this.a).getDeviceIdMD5()), CameraDeviceFeatureCache.class);
        if (str == null) {
            return;
        }
        if (cameraDeviceFeatureCache == null || !str.equals(cameraDeviceFeatureCache.getFirmwareVersion())) {
            Q0().G0(new o());
        }
    }

    private io.reactivex.q<Boolean> Y() {
        return Z(null).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CommonCameraRepository.this.o0((Boolean) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.n1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CommonCameraRepository.this.q0((Throwable) obj);
            }
        });
    }

    private void Y0(ALCameraDevice aLCameraDevice, String str, String str2) {
        if (aLCameraDevice.isRemoteOnline()) {
            X0(aLCameraDevice, str, str2);
        }
    }

    private io.reactivex.q<Boolean> Z(Account account) {
        ALCameraDevice cameraDevice = b().getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        if (cameraDevice.isRemoteOnly()) {
            return io.reactivex.q.f0(Boolean.TRUE);
        }
        if (this.g) {
            return io.reactivex.q.f0(Boolean.TRUE);
        }
        return l().d2(account).g0(o1.f14541c);
    }

    private void Z0(ALCameraDevice aLCameraDevice, String str) {
        if (aLCameraDevice.isRemoteOnline()) {
            a1(aLCameraDevice, str, null, true);
        }
    }

    private void a1(final ALCameraDevice aLCameraDevice, final String str, final String str2, final boolean z) {
        String deviceId = aLCameraDevice.getDeviceId();
        String cloudUserName = b().getTcAccountContext().c().getCloudUserName();
        String token = b().getTcAccountContext().c().getToken();
        DeviceFeatureInfo deviceFeatureInfo = new DeviceFeatureInfo();
        deviceFeatureInfo.setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
        deviceFeatureInfo.setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(z), str));
        this.f14198f.b(this.f14197e.X(cloudUserName, deviceId, JsonUtils.g(deviceFeatureInfo), token).C(io.reactivex.l0.a.c()).A(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l1
            @Override // io.reactivex.g0.a
            public final void run() {
                CommonCameraRepository.J0(ALCameraDevice.this, z, str2, str);
            }
        }, f7.f14400c));
    }

    private void b1(ALCameraDevice aLCameraDevice) {
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
        if (cameraAvatarInfo != null && org.apache.commons.lang.b.b(cameraAvatarInfo.getAvatarNameModified())) {
            if (org.apache.commons.lang.b.b(cameraAvatarInfo.getAvatarDefault())) {
                Z0(aLCameraDevice, cameraAvatarInfo.getAvatarName());
            } else {
                Y0(aLCameraDevice, cameraAvatarInfo.getAvatarName(), cameraAvatarInfo.getAvatarRemoteUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> c0(ALCameraDevice aLCameraDevice) {
        if (aLCameraDevice.isFirmwareSupportIoTCloud()) {
            return io.reactivex.q.f0(Boolean.TRUE);
        }
        return d0(aLCameraDevice);
    }

    private io.reactivex.q<Boolean> d0(ALCameraDevice aLCameraDevice) {
        return io.reactivex.q.f0(aLCameraDevice).L(new m()).N(new l()).N(new j(aLCameraDevice)).g0(new i(aLCameraDevice)).q0(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> f0(ALCameraDevice aLCameraDevice) {
        if (!(aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null || !aLCameraDevice.getCameraComponent().isSupportFirmware())) {
            ((FirmwareManager) b.d.b.f.b.a(((TPCameraDeviceContext) this.a).getAccountContext(), FirmwareManager.class)).f(aLCameraDevice.getDeviceIdMD5());
        }
        return io.reactivex.q.f0(Boolean.TRUE);
    }

    private byte[] g0(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        String[] strArr = new String[16];
        int i2 = 0;
        while (i2 < 32) {
            int i3 = i2 + 2;
            strArr[i2 / 2] = str.substring(i2, i3);
            i2 = i3;
        }
        byte[] bArr = new byte[16];
        for (int i4 = 0; i4 < 16; i4++) {
            bArr[i4] = (byte) Integer.valueOf(strArr[i4], 16).intValue();
        }
        return bArr;
    }

    private io.reactivex.q<P2PSharePwd> h0() {
        return l().g0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.p1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CommonCameraRepository.this.v0((P2PSharePwd) obj);
            }
        });
    }

    private io.reactivex.q<UpnpMultiInfo> i0() {
        return l().x0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.t1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CommonCameraRepository.this.x0((UpnpMultiInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0(ALCameraDevice aLCameraDevice, DeviceConfigInfoResult deviceConfigInfoResult) {
        DeviceFeatureInfo deviceFeatureInfo = (DeviceFeatureInfo) new Gson().l(deviceConfigInfoResult.getFeatureInfo(), DeviceFeatureInfo.class);
        if (deviceFeatureInfo == null) {
            b1(aLCameraDevice);
            return true;
        }
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice.getCameraAvatarInfo();
        DeviceAvatarFeatureInfo deviceAvatarFeatureInfo = deviceFeatureInfo.getDeviceAvatarFeatureInfo();
        if (deviceAvatarFeatureInfo != null && cameraAvatarInfo != null && m0(deviceAvatarFeatureInfo, new DeviceAvatarFeatureInfo(cameraAvatarInfo.getAvatarDefault(), cameraAvatarInfo.getAvatarName()))) {
            W0(aLCameraDevice, cameraAvatarInfo, deviceFeatureInfo, deviceConfigInfoResult.getAvatarUrl());
        } else if (cameraAvatarInfo == null || !org.apache.commons.lang.b.b(cameraAvatarInfo.getAvatarNameModified())) {
            if (cameraAvatarInfo != null && org.apache.commons.lang.b.a(cameraAvatarInfo.getAvatarNameModified())) {
                W0(aLCameraDevice, cameraAvatarInfo, deviceFeatureInfo, deviceConfigInfoResult.getAvatarUrl());
            } else if (cameraAvatarInfo == null || TextUtils.isEmpty(cameraAvatarInfo.getAvatarRemoteUrl()) || TextUtils.isEmpty(cameraAvatarInfo.getAvatarName())) {
                W0(aLCameraDevice, cameraAvatarInfo, deviceFeatureInfo, deviceConfigInfoResult.getAvatarUrl());
            }
        } else if (org.apache.commons.lang.b.b(cameraAvatarInfo.getAvatarDefault())) {
            Z0(aLCameraDevice, cameraAvatarInfo.getAvatarName());
        } else {
            Y0(aLCameraDevice, cameraAvatarInfo.getAvatarName(), cameraAvatarInfo.getAvatarRemoteUrl());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0() {
        return ((TPCameraDeviceContext) this.a).getDeviceIdMD5() == null || ((FirmwareManager) b.d.b.f.b.a(((TPCameraDeviceContext) this.a).getAccountContext(), FirmwareManager.class)).g(((TPCameraDeviceContext) this.a).getDeviceIdMD5()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(Boolean bool) throws Exception {
        this.g = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0(Throwable th) throws Exception {
        if (th instanceof CameraException) {
            if (CameraErrorCode.SESSION_EXPIRED.isEqual(((CameraException) th).getErrorCode())) {
                this.g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ Pair t0(AESEncryptKey aESEncryptKey) throws Exception {
        byte[] g0 = g0(aESEncryptKey.getAes_key());
        byte[] g02 = g0(aESEncryptKey.getAes_iv());
        if (g0 != null && g02 != null) {
            return new Pair(g0, g02);
        }
        throw new Exception("error on constructAES, key:" + aESEncryptKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(P2PSharePwd p2PSharePwd) throws Exception {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setP2PSharePwd(p2PSharePwd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(UpnpMultiInfo upnpMultiInfo) throws Exception {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setUpnpInfo(upnpMultiInfo.getUpnpInfo());
            cameraDevice.setUpnpCommStatus(upnpMultiInfo.getUpnpCommStatus());
            cameraDevice.setUpnpStatus(upnpMultiInfo.getUpnpStatus());
            cameraDevice.setPubIp(upnpMultiInfo.getPubIp());
            cameraDevice.setUpnpPsk(upnpMultiInfo.getUpnpPsk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(UpnpPsk upnpPsk) throws Exception {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setUpnpPsk(upnpPsk);
        }
    }

    public io.reactivex.q<CameraComponent> K0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice == null || cameraDevice.getCameraComponent() == null) {
            return Q0();
        }
        return io.reactivex.q.f0(cameraDevice.getCameraComponent());
    }

    public boolean N0(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public io.reactivex.q<Boolean> O0(UpnpCommStatus upnpCommStatus) {
        ALCameraDevice cameraDevice = b().getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setUpnpCommStatus(upnpCommStatus);
        }
        return l().Z2(upnpCommStatus).g0(j1.f14472c);
    }

    public io.reactivex.q<Boolean> R0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return l().Q().g0(new q(cameraDevice)).v0(1L, new p()).q0(Boolean.FALSE);
    }

    public void X0(final ALCameraDevice aLCameraDevice, final String str, final String str2) {
        if (this.f14197e.K()) {
            this.f14198f.b(io.reactivex.q.f0(str2).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.s1
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return CommonCameraRepository.this.I0((String) obj);
                }
            }).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k1
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return CommonCameraRepository.this.E0(aLCameraDevice, (byte[]) obj);
                }
            }).L0(io.reactivex.l0.a.c()).H0(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.q1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CommonCameraRepository.this.G0(aLCameraDevice, str, str2, (DeviceAvatarResult) obj);
                }
            }, f7.f14400c));
        }
    }

    public void a0() {
        ALCameraDevice cameraDevice = ((TPCameraDeviceContext) this.a).getCameraDevice();
        if (cameraDevice != null) {
            cameraDevice.setP2PSharePwd(null);
            CameraComponent cameraComponent = cameraDevice.getCameraComponent();
            if (cameraDevice.isUserRoleTypeDevice() && cameraComponent != null && cameraComponent.hasComponent(ComponentType.DEVICE_SHARE)) {
                h0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F0();
            }
        }
    }

    public io.reactivex.q<Pair<byte[], byte[]>> b0() {
        return l().w().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.i1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CommonCameraRepository.this.t0((AESEncryptKey) obj);
            }
        });
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.q<Boolean> d() {
        return Y();
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void e() {
        super.e();
        this.f14198f.dispose();
    }

    public io.reactivex.q<Boolean> e0() {
        ALCameraDevice cameraDevice = b().getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return S0(cameraDevice).E(new b(cameraDevice));
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.q<Boolean> f() {
        return io.reactivex.q.f0(Boolean.valueOf(((TPCameraDeviceContext) this.a).getIoTDevice() != null && ((TPCameraDeviceContext) this.a).getIoTDevice().isOnline())).N(new c()).q0(Boolean.FALSE);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.q<Boolean> g() {
        return f();
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.q<Boolean> h() {
        return io.reactivex.q.f0(Boolean.TRUE).E(new n());
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.q<Boolean> j() {
        ALCameraDevice cameraDevice = b().getCameraDevice();
        if (cameraDevice == null) {
            return io.reactivex.q.f0(Boolean.FALSE);
        }
        return l().Q().g0(new w(cameraDevice)).v0(1L, new v()).N(new u(cameraDevice)).N(new t()).N(new s()).E(new r(cameraDevice)).C(new k()).q0(Boolean.FALSE);
    }

    public io.reactivex.q<UpnpPsk> j0() {
        return l().y0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CommonCameraRepository.this.z0((UpnpPsk) obj);
            }
        }).C(new e());
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.a k() {
        l().e2();
        return io.reactivex.a.e();
    }

    public boolean m0(DeviceAvatarFeatureInfo deviceAvatarFeatureInfo, DeviceAvatarFeatureInfo deviceAvatarFeatureInfo2) {
        if (deviceAvatarFeatureInfo == null && deviceAvatarFeatureInfo2 == null) {
            return true;
        }
        return deviceAvatarFeatureInfo != null && deviceAvatarFeatureInfo2 != null && N0(deviceAvatarFeatureInfo.getAvatarName(), deviceAvatarFeatureInfo2.getAvatarName()) && N0(deviceAvatarFeatureInfo.isDefaultAvatarName(), deviceAvatarFeatureInfo2.isDefaultAvatarName());
    }
}
