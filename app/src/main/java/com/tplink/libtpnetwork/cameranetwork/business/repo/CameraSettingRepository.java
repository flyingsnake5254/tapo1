package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.p;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskLoop;
import com.tplink.libtpnetwork.cameranetwork.model.Light;
import com.tplink.libtpnetwork.cameranetwork.model.LightFrequencyMode;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.OsdInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardFormatProgress;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import com.tplink.libtpnetwork.cameranetwork.model.Wan;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CameraSettingRepository extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c {

    /* renamed from: d  reason: collision with root package name */
    private final SettingsData f14184d = new SettingsData();

    /* renamed from: e  reason: collision with root package name */
    private o f14185e = new o();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CameraException>> f14186f = new MutableLiveData<>();
    private TPCameraDeviceContext g;

    /* loaded from: classes3.dex */
    class a implements g<RebootInfo> {
        a() {
        }

        /* renamed from: a */
        public void accept(RebootInfo rebootInfo) throws Exception {
            if (rebootInfo != null) {
                CameraSettingRepository.this.f14184d.setRebootConfig(new RebootInfoCache(OptionSwitch.fromString(rebootInfo.getEnabled()), rebootInfo.getTime()));
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements j<Response<SettingComposite>, HardDiskInfo> {
        b() {
        }

        /* renamed from: a */
        public HardDiskInfo apply(Response<SettingComposite> response) throws Exception {
            if (response.getResult() != null && response.getResult().getHardDiskInfo() != null) {
                return response.getResult().getHardDiskInfo();
            }
            throw new Exception("hardDiskInfo is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements g<ServiceList> {
        c() {
        }

        /* renamed from: a */
        public void accept(ServiceList serviceList) throws Exception {
            if (serviceList != null) {
                com.tplink.libtpnetwork.Utils.o.h0().A0(CameraSettingRepository.this.g.getDeviceIdMD5(), serviceList.toString());
                CameraSettingRepository.this.f14184d.setTapoCareNeedPayFunctionList(serviceList);
            }
        }
    }

    public CameraSettingRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        this.g = tPCameraDeviceContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ t E0(boolean z, f4 f4Var) throws Exception {
        RecordPlanInfo w = w(this.f14185e.a());
        w.setEnabled(z ? "on" : "off");
        return f4Var.T2(w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(boolean z, Throwable th) throws Exception {
        this.f14185e.d(!z);
        m1(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(Map map, Response response) throws Exception {
        J1(map);
    }

    private void J1(Map<DayOfWeek, List<Schedule>> map) {
        DayOfWeek[] values;
        o oVar = this.f14185e;
        if (oVar != null) {
            oVar.d(true);
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                this.f14185e.e(dayOfWeek, map.get(dayOfWeek));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public /* synthetic */ void N0(String str, Response response) throws Exception {
        ALCameraDevice cameraDevice;
        if (response.isSuccess() && (cameraDevice = this.g.getCameraDevice()) != null && cameraDevice.getCameraBasicInfo() != null) {
            cameraDevice.getBasicInfo().setAvatar(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String N(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository.N(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void m1(Throwable th) {
        if (th instanceof CameraException) {
            this.f14186f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>((CameraException) th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public void w0(CameraComponent cameraComponent, SettingCompositeV2 settingCompositeV2) {
        if (!(settingCompositeV2.getMotionDetectionInfo() == null || settingCompositeV2.getMotionDetectionInfo().getConfig() == null)) {
            ((MotionDetectionRepository) e.b(this.g, MotionDetectionRepository.class)).d0(settingCompositeV2.getMotionDetectionInfo().getConfig());
        }
        if (cameraComponent.isSupportLineCrossingDetection() && settingCompositeV2.getLineCrossingDetectionInfo() != null) {
            ((LineCrossingDetectionRepository) e.b(this.g, LineCrossingDetectionRepository.class)).G(settingCompositeV2.getLineCrossingDetectionInfo());
        }
        if (cameraComponent.isSupportIntrusionDetection() && settingCompositeV2.getIntrusionDetectionInfo() != null) {
            ((AreaIntrusionRepository) e.b(this.g, AreaIntrusionRepository.class)).F(settingCompositeV2.getIntrusionDetectionInfo());
        }
        if (cameraComponent.isSupportTamperDetection() && settingCompositeV2.getTamperDetectConfig() != null) {
            ((TamperDetectionRepository) e.b(this.g, TamperDetectionRepository.class)).x(settingCompositeV2.getTamperDetectConfig());
        }
        if (cameraComponent.isSupportBabyCry() && settingCompositeV2.getBabyCryDetectionInfo() != null) {
            ((AIDetectionRepository) e.b(this.g, AIDetectionRepository.class)).z(settingCompositeV2.getBabyCryDetectionInfo());
        }
        if (cameraComponent.isSupportPersonDetection() && settingCompositeV2.getHumanRecognitionInfo() != null) {
            ((AIDetectionRepository) e.b(this.g, AIDetectionRepository.class)).A(settingCompositeV2.getHumanRecognitionInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(String str, Response response) throws Exception {
        if (response.isSuccess() && this.f14184d.getCameraInfo() != null) {
            this.f14184d.getCameraInfo().setName(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(boolean z, Boolean bool) throws Exception {
        this.f14184d.setImageFlipEnable(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public /* synthetic */ void V(String str, Boolean bool) throws Exception {
        if (this.f14184d.getAccountInfo() != null) {
            this.f14184d.getAccountInfo().setUsername(str);
        } else {
            this.f14184d.setAccountInfo(new AccountInfoCache(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(boolean z, Throwable th) throws Exception {
        this.f14184d.setImageFlipEnable(!z);
        m1(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public /* synthetic */ void Y0(boolean z, Boolean bool) throws Exception {
        this.f14184d.setLedEnable(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0(CameraInfo cameraInfo) throws Exception {
        BasicInfo basicInfo = cameraInfo.getBasicInfo();
        if (basicInfo != null) {
            this.f14184d.setCameraInfo(new CameraInfoCache(basicInfo.getDeviceAlias(), basicInfo.getHardwareVer(), basicInfo.getSoftwareVer(), basicInfo.getModel(), basicInfo.getMac()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0 */
    public /* synthetic */ void a1(boolean z, Throwable th) throws Exception {
        this.f14184d.setLedEnable(!z);
        m1(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(Response response) throws Exception {
        if (response != null && response.getResult() != null) {
            this.f14184d.setIpAddress(((Wan) response.getResult()).getIpAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1 */
    public /* synthetic */ void e1(boolean z, Boolean bool) throws Exception {
        this.f14184d.getSdCardInfoCache().setLoopEnable(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0(Light light) throws Exception {
        this.f14184d.setLightFrequencyMode(light.getMode() == null ? LightFrequencyMode.AUTO : LightFrequencyMode.fromString(light.getMode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(boolean z, Throwable th) throws Exception {
        this.f14184d.getSdCardInfoCache().setLoopEnable(!z);
        m1(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Response response) throws Exception {
        this.f14184d.setNetworkInfo(new NetworkInfoCache(((NetworkInfo) response.getResult()).getSsid(), ((NetworkInfo) response.getResult()).getLinkType(), ((NetworkInfo) response.getResult()).getRssi(), ((NetworkInfo) response.getResult()).getRssiValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(RebootInfo rebootInfo, Boolean bool) throws Exception {
        this.f14184d.setRebootConfig(new RebootInfoCache(OptionSwitch.fromString(rebootInfo.getEnabled()), rebootInfo.getTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(OsdConfig osdConfig) throws Exception {
        OptionSwitch optionSwitch;
        String str;
        OptionSwitch optionSwitch2 = OptionSwitch.OFF;
        OptionSwitch fromString = osdConfig.getDate() != null ? OptionSwitch.fromString(osdConfig.getDate().getEnabled()) : optionSwitch2;
        if (osdConfig.getLabels() == null || osdConfig.getLabels().isEmpty()) {
            str = "";
            optionSwitch = optionSwitch2;
        } else {
            str = osdConfig.getLabels().get(0).getText();
            optionSwitch = OptionSwitch.fromString(osdConfig.getLabels().get(0).getEnabled());
        }
        OptionSwitch optionSwitch3 = null;
        if (osdConfig.getLogo() != null) {
            optionSwitch3 = OptionSwitch.fromString(osdConfig.getLogo().getEnabled());
        }
        this.f14184d.setOsdConfig(new OsdInfoCache(fromString, str, optionSwitch, optionSwitch3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ SdCardStatus s0(Response response) throws Exception {
        SettingComposite settingComposite = (SettingComposite) response.getResult();
        HardDiskInfo hardDiskInfo = settingComposite.getHardDiskInfo();
        HardDiskLoop hardDiskLoop = settingComposite.getHardDiskLoop();
        boolean z = hardDiskLoop != null && "on".equals(hardDiskLoop.getLoop());
        if (hardDiskInfo != null) {
            SdCardInfoCache sdCardInfoCache = new SdCardInfoCache(SdCardStatus.fromString(hardDiskInfo.getStatus()), hardDiskInfo.getDetectStatus(), hardDiskInfo.getTotalVideoSpace(), N(hardDiskInfo.getTotalVideoSpace(), hardDiskInfo.getFreeVideoSpace()), hardDiskInfo.getFreeVideoSpace(), z, hardDiskInfo.getTotalSpace());
            this.f14184d.setSdCardInfoCache(sdCardInfoCache);
            String realTotalSpace = sdCardInfoCache.getRealTotalSpace();
            if (realTotalSpace != null && p.b(realTotalSpace, "2GB") <= 0 && p.b(realTotalSpace, "0B") > 0) {
                sdCardInfoCache.setStatus(SdCardStatus.ABNORMAL);
            }
            return sdCardInfoCache.getStatus();
        }
        throw new Exception("hardDiskInfo is null");
    }

    private float s1(String str) {
        float parseFloat;
        try {
            if (str.contains("GB")) {
                parseFloat = Float.parseFloat(str.replace("GB", "")) * 1000.0f;
            } else if (str.contains("MB")) {
                parseFloat = Float.parseFloat(str.replace("MB", ""));
            } else if (!str.contains("KB")) {
                return 0.0f;
            } else {
                parseFloat = Float.parseFloat(str.replace("KB", "")) / 1000.0f;
            }
            return parseFloat;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ Boolean u0(CameraComponent cameraComponent, SettingComposite settingComposite) throws Exception {
        BasicInfo basicInfo;
        if (cameraComponent.hasComponent(ComponentType.LED) && settingComposite.getLedStatus() != null) {
            this.f14184d.setLedEnable(settingComposite.getLedStatus().getEnabled());
        }
        if (cameraComponent.hasComponent(ComponentType.TIME_ZONE) && settingComposite.getTimezone() != null) {
            this.f14184d.setTimezone(settingComposite.getTimezone().getTimezone(), settingComposite.getTimezone().getZoneId());
        }
        if (cameraComponent.hasComponent(ComponentType.SYSTEM)) {
            if (!(settingComposite.getCameraInfo() == null || (basicInfo = settingComposite.getCameraInfo().getBasicInfo()) == null)) {
                this.f14184d.setCameraInfo(new CameraInfoCache(basicInfo.getDeviceAlias(), basicInfo.getHardwareVer(), basicInfo.getSoftwareVer(), basicInfo.getModel(), basicInfo.getMac()));
            }
            if (settingComposite.getRebootInfo() != null) {
                this.f14184d.setRebootConfig(new RebootInfoCache(OptionSwitch.fromString(settingComposite.getRebootInfo().getEnabled()), settingComposite.getRebootInfo().getTime()));
            }
            if (settingComposite.getImageFlip() != null) {
                this.f14184d.setImageFlipEnable(settingComposite.getImageFlip().getFlipType());
                this.f14184d.setImageFlip(settingComposite.getImageFlip());
            }
        }
        if (cameraComponent.isSupportNightVision() && settingComposite.getImageFlip() != null) {
            this.f14184d.setImageFlipEnable(settingComposite.getImageFlip().getFlipType());
            this.f14184d.setImageFlip(settingComposite.getImageFlip());
        }
        if (cameraComponent.hasComponent(ComponentType.SD_CARD)) {
            HardDiskInfo hardDiskInfo = settingComposite.getHardDiskInfo();
            HardDiskLoop hardDiskLoop = settingComposite.getHardDiskLoop();
            boolean z = hardDiskLoop != null && "on".equals(hardDiskLoop.getLoop());
            if (hardDiskInfo != null) {
                this.f14184d.setSdCardInfoCache(new SdCardInfoCache(SdCardStatus.fromString(hardDiskInfo.getStatus()), hardDiskInfo.getDetectStatus(), hardDiskInfo.getTotalVideoSpace(), N(hardDiskInfo.getTotalVideoSpace(), hardDiskInfo.getFreeVideoSpace()), hardDiskInfo.getFreeVideoSpace(), z, hardDiskInfo.getTotalSpace()));
                String realTotalSpace = this.f14184d.getSdCardInfoCache().getRealTotalSpace();
                if (realTotalSpace != null && p.b(realTotalSpace, "2GB") <= 0 && p.b(realTotalSpace, "0B") > 0) {
                    this.f14184d.getSdCardInfoCache().setStatus(SdCardStatus.ABNORMAL);
                }
            }
        }
        ComponentType componentType = ComponentType.VIDEO;
        ServiceList serviceList = null;
        if (cameraComponent.hasComponent(componentType) && cameraComponent.getComponent(componentType) >= 2) {
            this.f14184d.setResolutionType(settingComposite.getVideoQuality() != null ? settingComposite.getVideoQuality().getResolutionType() : null);
            if (!(settingComposite.getVideoCapability() == null || settingComposite.getVideoCapability().getResolutions() == null)) {
                ArrayList arrayList = new ArrayList();
                for (String str : settingComposite.getVideoCapability().getResolutions()) {
                    ResolutionType fromString = ResolutionType.fromString(str);
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
                this.f14184d.setResolutionTypes(arrayList);
            }
        }
        if (cameraComponent.isSupportSubscriptionService()) {
            com.tplink.libtpnetwork.Utils.o.h0().A0(this.g.getDeviceIdMD5(), settingComposite.getNeedPayServiceList() != null ? settingComposite.getNeedPayServiceList().toString() : null);
            SettingsData settingsData = this.f14184d;
            if (settingComposite.getNeedPayServiceList() != null) {
                serviceList = settingComposite.getNeedPayServiceList();
            }
            settingsData.setTapoCareNeedPayFunctionList(serviceList);
        }
        return Boolean.TRUE;
    }

    private static o t1(RecordPlanInfo recordPlanInfo) {
        o oVar = new o();
        oVar.d(OptionSwitch.fromString(recordPlanInfo.getEnabled()) == OptionSwitch.ON);
        oVar.e(DayOfWeek.SUNDAY, ScheduleParser.parseSchedules(recordPlanInfo.getSunday()));
        oVar.e(DayOfWeek.MONDAY, ScheduleParser.parseSchedules(recordPlanInfo.getMonday()));
        oVar.e(DayOfWeek.TUESDAY, ScheduleParser.parseSchedules(recordPlanInfo.getTuesday()));
        oVar.e(DayOfWeek.WEDNESDAY, ScheduleParser.parseSchedules(recordPlanInfo.getWednesday()));
        oVar.e(DayOfWeek.THURSDAY, ScheduleParser.parseSchedules(recordPlanInfo.getThursday()));
        oVar.e(DayOfWeek.FRIDAY, ScheduleParser.parseSchedules(recordPlanInfo.getFriday()));
        oVar.e(DayOfWeek.SATURDAY, ScheduleParser.parseSchedules(recordPlanInfo.getSaturday()));
        return oVar;
    }

    public static RecordPlanInfo w(Map<DayOfWeek, List<Schedule>> map) {
        return new RecordPlanInfo(OptionSwitch.fromBoolean(!map.isEmpty()).getRaw(), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.MONDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.TUESDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.THURSDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.FRIDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.SATURDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.SUNDAY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(Response response) throws Exception {
        if (response != null && response.getResult() != null) {
            this.f14184d.setAccountInfo(new AccountInfoCache(((AccountInfo) response.getResult()).getUsername()));
        }
    }

    public q<Boolean> A() {
        return l().X().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.b1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.g0((Light) obj);
            }
        }).C(new t0(this)).g0(k0.f14483c);
    }

    public q<Boolean> A1(final boolean z) {
        return l().D2((z ? OptionSwitch.ON : OptionSwitch.OFF).toString()).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.e1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.Y0(z, (Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.w
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.a1(z, (Throwable) obj);
            }
        }).g0(v.f14614c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> B() {
        return l().e0().E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.v0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.j0((Response) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.l0((Throwable) obj);
            }
        }).g0(x0.f14637c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> B1(String str) {
        return l().G2(str).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(z0.f14656c);
    }

    public q<Boolean> C(boolean z) {
        return l().f0(z).i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.j0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.o0((OsdConfig) obj);
            }
        }).C(new t0(this)).g0(s0.f14585c);
    }

    public q<Boolean> C1(final boolean z) {
        return l().J2(z).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.g1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.e1(z, (Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.w0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.g1(z, (Throwable) obj);
            }
        }).g0(f0.f14392c);
    }

    public int D(String str, String str2) {
        return (int) ((s1(str) * 100.0d) / s1(str2));
    }

    public q<Boolean> D1(boolean z, boolean z2, String str, boolean z3) {
        return l().P2(z, z2, str, z3).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(q0.f14560c);
    }

    public q<Boolean> E() {
        return l().h0().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new a()).g0(n.f14528c);
    }

    public q<Boolean> E1(boolean z) {
        return l().Q2(z).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(p.f14549c);
    }

    public q<HardDiskInfo> F() {
        return l().k0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new b());
    }

    public q<Boolean> F1(final RebootInfo rebootInfo) {
        return l().R2(rebootInfo).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.s
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.l1(rebootInfo, (Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.i
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.n1((Throwable) obj);
            }
        }).g0(c1.f14356c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<SdCardFormatProgress> G() {
        return l().l0().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public void G1(RecordPlanInfo recordPlanInfo) {
        this.f14185e = t1(recordPlanInfo);
    }

    public q<SdCardStatus> H() {
        return l().m0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.j
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CameraSettingRepository.this.s0((Response) obj);
            }
        });
    }

    public q<Boolean> H1(String str, String str2) {
        return l().Y2(str, str2).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(q.f14559c);
    }

    public Map<DayOfWeek, List<Schedule>> I(int i) {
        if (i != 1 && i != 2) {
            return null;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Schedule(0, 0, 24, 0, i));
        hashMap.put(DayOfWeek.MONDAY, arrayList);
        hashMap.put(DayOfWeek.TUESDAY, arrayList);
        hashMap.put(DayOfWeek.WEDNESDAY, arrayList);
        hashMap.put(DayOfWeek.THURSDAY, arrayList);
        hashMap.put(DayOfWeek.FRIDAY, arrayList);
        hashMap.put(DayOfWeek.SATURDAY, arrayList);
        hashMap.put(DayOfWeek.SUNDAY, arrayList);
        return hashMap;
    }

    public q<Boolean> I1() {
        return l().e3().i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(z.f14655c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<ServiceList> J() {
        return l().n0().i(m.a()).L0(io.reactivex.l0.a.c()).E(new c());
    }

    public q<Boolean> K(final CameraComponent cameraComponent) {
        return l().o0(cameraComponent).u0(1L).g0(c7.f14367c).g0(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CameraSettingRepository.this.u0(cameraComponent, (SettingComposite) obj);
            }
        }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> K1(String str, String str2) {
        return l().k3(str, str2).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(y0.f14645c);
    }

    public q<SettingCompositeV2> L(final CameraComponent cameraComponent) {
        return l().p0(cameraComponent).L0(io.reactivex.l0.a.c()).C(a0.f14332c).g0(g7.f14448c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.u0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.x0(cameraComponent, (SettingCompositeV2) obj);
            }
        });
    }

    public q<Boolean> M() {
        return l().t0().E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.a1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.z0((Response) obj);
            }
        }).g0(t.f14592c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public boolean Q() {
        for (List<Schedule> list : this.f14185e.a().values()) {
            for (Schedule schedule : list) {
                if (schedule.getType() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean R() {
        MotionDetectionRepository motionDetectionRepository = (MotionDetectionRepository) e.b(this.g, MotionDetectionRepository.class);
        LineCrossingDetectionRepository lineCrossingDetectionRepository = (LineCrossingDetectionRepository) e.b(this.g, LineCrossingDetectionRepository.class);
        AreaIntrusionRepository areaIntrusionRepository = (AreaIntrusionRepository) e.b(this.g, AreaIntrusionRepository.class);
        TamperDetectionRepository tamperDetectionRepository = (TamperDetectionRepository) e.b(this.g, TamperDetectionRepository.class);
        AIDetectionRepository aIDetectionRepository = (AIDetectionRepository) e.b(this.g, AIDetectionRepository.class);
        if (motionDetectionRepository.y() != null && motionDetectionRepository.y().e()) {
            return true;
        }
        return lineCrossingDetectionRepository.A().c() || areaIntrusionRepository.z().c() || tamperDetectionRepository.t().c() || (motionDetectionRepository.y() != null && org.apache.commons.lang.b.b(motionDetectionRepository.y().b())) || com.tplink.libtpnetwork.Utils.j.h(aIDetectionRepository.t()) || com.tplink.libtpnetwork.Utils.j.h(aIDetectionRepository.v());
    }

    public boolean S() {
        for (List<Schedule> list : this.f14185e.a().values()) {
            for (Schedule schedule : list) {
                if (schedule.getType() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean T() {
        o oVar = this.f14185e;
        if (oVar != null) {
            return oVar.c();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> h() {
        return l().h2().i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(o.f14538c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> u(final String str, String str2) {
        return l().k(str, str2).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.x
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.V(str, (Boolean) obj);
            }
        }).C(new t0(this)).g0(c0.f14355c);
    }

    public q<Boolean> u1() {
        return l().f2().i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(d1.f14370c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> v() {
        return l().v().C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(r0.f14573c);
    }

    public q<Boolean> v1(final Map<DayOfWeek, List<Schedule>> map) {
        return l().T2(w(map)).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.b0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.I0(map, (Response) obj);
            }
        }).g0(g0.f14436c).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.e0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.L0((Throwable) obj);
            }
        }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> w1(final boolean z) {
        return q.f0(l()).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return CameraSettingRepository.this.E0(z, (f4) obj);
            }
        }).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.G0(z, (Throwable) obj);
            }
        }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public SettingsData x() {
        return this.f14184d;
    }

    public q<Boolean> x1(final String str) {
        return l().u2(str).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.p0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.N0(str, (Response) obj);
            }
        }).C(new t0(this)).g0(u.f14602c);
    }

    public q<Boolean> y() {
        return l().K().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.a0((CameraInfo) obj);
            }
        }).C(new t0(this)).g0(y.f14644c);
    }

    public q<Boolean> y1(final String str) {
        return l().s2(str).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.i0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.Q0(str, (Response) obj);
            }
        }).C(new t0(this)).g0(d0.f14369c);
    }

    public q<Boolean> z() {
        return l().T().E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.h0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.d0((Response) obj);
            }
        }).g0(f1.f14393c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> z1(final boolean z) {
        return l().y2(z).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.T0(z, (Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingRepository.this.V0(z, (Throwable) obj);
            }
        }).g0(n0.f14529c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }
}
