package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceCruiseInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceId;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveStepInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfig;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackUtcFilter;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DiskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskLoop;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LedStatus;
import com.tplink.libtpnetwork.cameranetwork.model.LensMaskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Light;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MediaEncrypt;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Module;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdElement;
import com.tplink.libtpnetwork.cameranetwork.model.OsdFont;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Resolution;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.Section;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: RequestGenerator.java */
/* loaded from: classes3.dex */
public class l4 {
    private final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private <T> Request<Wrappers> E(Method method, Module module, Section section, T t) {
        return new Request<>(method, F(new Wrapper<>(module, section, t)));
    }

    private <T> Wrappers F(Wrapper<T> wrapper) {
        return new Wrappers(Collections.singletonList(wrapper));
    }

    private Request<MultipleRequest> O0(Request<Wrapper> request) {
        return P0(new Request<>(request.getMethod(), new Wrappers(Collections.singletonList(request.getParams()))));
    }

    private Request<MultipleRequest> P0(Request<Wrappers> request) {
        return Q0(Collections.singletonList(request));
    }

    private Request<Wrappers> a(List<MotionDetectRegion> list) {
        return new Request<>(Method.ADD_DETECTION_REGION, F(Model.wrapper(list, Module.MOTION_DETECTION, Section.MOTION_DETECTION_ADD_REGION, "region_info")));
    }

    private Request<Wrappers> a1(CoverConfig coverConfig) {
        return E(Method.SET_COVER_CONFIG, Module.COVER, Section.COVER, coverConfig);
    }

    private Request<Wrappers> b() {
        return E(Method.GET_BCD_CONFIG, Module.SOUND_DETECTION, Section.NAME, Section.BABY_CRYING_DETECTION.getValue());
    }

    private Request<Wrappers> d() {
        return E(Method.GET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.NAME, Section.DETECTION.getValue());
    }

    private Request<Wrappers> f(AlarmInfo alarmInfo) {
        return E(Method.SET_ALERT_CONFIG, Module.MSG_ALARM, Section.ALERT_INFO, alarmInfo);
    }

    private Request<Wrappers> g(AlarmPlanInfo alarmPlanInfo) {
        return E(Method.SET_ALERT_PLAN, Module.MSG_ALARM_PLAN, Section.MSG_ALARM_PLAN, alarmPlanInfo);
    }

    private Request<Wrappers> h(boolean z, String str) {
        return E(Method.SET_BCD_CONFIG, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION, new BabyCryingDetectionInfo(z, str));
    }

    private Request<Wrappers> i(boolean z) {
        return E(Method.SET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.DETECTION, new HumanRecognitionInfo(z));
    }

    private Request<Wrappers> j(MotionDetectConfig motionDetectConfig) {
        return E(Method.SET_DETECTION_CONFIG, Module.MOTION_DETECTION, Section.MOTION_DET, motionDetectConfig);
    }

    private Request<Wrappers> k(List<CoverConfigRegion> list) {
        return new Request<>(Method.ADD_COVER_REGION, F(Model.wrapper(list, Module.COVER, Section.COVER_CONFIG_ADD_REGION, Section.REGION_INFO.getValue())));
    }

    @SafeVarargs
    private final Request<MultipleRequest> u(Request<Wrappers>... requestArr) {
        return Q0(Arrays.asList(requestArr));
    }

    public Request<MultipleRequest> A(int i) {
        return O0(new Request<>(Method.MOTOR_MOVE_TO_PRESET, new Wrapper(Module.PRESET, Section.GOTO_PRESET, new CloudTerraceId(String.valueOf(i)))));
    }

    public Request<MultipleRequest> A0(CameraComponent cameraComponent) {
        ArrayList arrayList = new ArrayList();
        if (cameraComponent.hasComponent(ComponentType.SD_CARD)) {
            Module module = Module.HARD_DISK_MANAGE;
            Wrapper wrapper = new Wrapper(module, Section.NAME, Collections.singletonList(Section.HARD_DISK_LOOP.getValue()));
            Wrapper wrapper2 = new Wrapper(module, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()));
            arrayList.add(new Request<>(Method.GET_CIRCULAR_RECORDING_CONFIG, F(wrapper)));
            arrayList.add(new Request<>(Method.GET_SD_CARD_STATUS, F(wrapper2)));
        }
        if (cameraComponent.hasComponent(ComponentType.LED)) {
            arrayList.add(new Request<>(Method.GET_LED_STATUS, F(new Wrapper(Module.LED, Section.NAME, Collections.singletonList(Section.CONFIG.getValue())))));
        }
        if (cameraComponent.hasComponent(ComponentType.TIME_ZONE)) {
            arrayList.add(new Request<>(Method.GET_TIMEZONE, F(new Wrapper(Module.SYSTEM, Section.NAME, Collections.singletonList(Section.BASIC.getValue())))));
        }
        ComponentType componentType = ComponentType.SYSTEM;
        if (cameraComponent.hasComponent(componentType) || cameraComponent.isSupportNightVision()) {
            arrayList.add(new Request<>(Method.GET_ROTATION_STATUS, F(new Wrapper(Module.IMAGE, Section.NAME, Collections.singletonList(Section.IMAGE_SWITCH.getValue())))));
        }
        if (cameraComponent.hasComponent(componentType)) {
            Module module2 = Module.TIMING_REBOOT;
            Section section = Section.NAME;
            Wrapper wrapper3 = new Wrapper(module2, section, Collections.singletonList(Section.REBOOT.getValue()));
            Wrapper wrapper4 = new Wrapper(Module.DEVICE_INFO, section, Collections.singletonList(Section.BASIC_INFO.getValue()));
            arrayList.add(new Request<>(Method.GET_REBOOT, F(wrapper3)));
            arrayList.add(new Request<>(Method.GET_DEVICE_INFO, F(wrapper4)));
        }
        ComponentType componentType2 = ComponentType.VIDEO;
        if (cameraComponent.hasComponent(componentType2) && cameraComponent.getComponent(componentType2) >= 2) {
            Module module3 = Module.VIDEO;
            Section section2 = Section.NAME;
            Section section3 = Section.VIDEO_MAIN;
            arrayList.add(new Request<>(Method.GET_VIDEO_QUALITIES, F(new Wrapper(module3, section2, Collections.singletonList(section3.getValue())))));
            arrayList.add(new Request<>(Method.GET_VIDEO_CAPABILITY, F(new Wrapper(Module.VIDEO_CAPABILITY, section2, Collections.singletonList(section3.getValue())))));
        }
        if (cameraComponent.isSupportSubscriptionService()) {
            arrayList.add(new Request<>(Method.GET_TAPO_CARE_SERVICE_LIST, F(new Wrapper(Module.TAPO_CARE, Section.NAME, Collections.singletonList(Section.SERVICE_LIST.getValue())))));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> A1(boolean z) {
        return P0(new Request<>(Method.SET_OSD, new Wrappers(Collections.singletonList(new Wrapper(Module.OSD, Section.OSD_LOGO, new OsdElement("0", "9150", null, z ? "on" : "off"))))));
    }

    public Request<MultipleRequest> B() {
        return O0(new Request<>(Method.MANUAL_CALIBRATE, new Wrapper(Module.MOTOR, Section.MANUAL_CALI, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> B0(CameraComponent cameraComponent) {
        ArrayList arrayList = new ArrayList();
        Module module = Module.LENS_MASK;
        Section section = Section.NAME;
        arrayList.add(new Request<>(Method.GET_LENS_MASK_CONFIG, F(new Wrapper(module, section, Collections.singletonList(Section.LENS_MASK_INFO.getValue())))));
        Module module2 = Module.MOTION_DETECTION;
        arrayList.add(new Request<>(Method.GET_DETECTION_CONFIG, new Wrappers(Arrays.asList(new Wrapper(module2, section, Collections.singletonList(Section.MOTION_DET.getValue())), new Wrapper(module2, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()))))));
        arrayList.add(new Request<>(Method.GET_ALERT_CONFIG, F(new Wrapper(Module.MSG_ALARM, section, Collections.singletonList(Section.MSG_ALARM_INFO.getValue())))));
        if (cameraComponent.isSupportLineCrossingDetection()) {
            arrayList.add(new Request<>(Method.GET_LINE_CROSSING_DETECTION_CONFIG, F(new Wrapper(Module.LINE_CROSSING_DETECTION, section, Arrays.asList(Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue())))));
        }
        if (cameraComponent.isSupportIntrusionDetection()) {
            arrayList.add(new Request<>(Method.GET_INTRUSION_DETECTION_CONFIG, F(new Wrapper(Module.INTRUSION_DETECTION, section, Arrays.asList(Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue())))));
        }
        if (cameraComponent.isSupportTamperDetection()) {
            arrayList.add(new Request<>(Method.GET_TAMPER_DETECTION_CONFIG, F(new Wrapper(Module.TAMPER_DETECTION, section, Collections.singletonList(Section.TAMPER_DET.getValue())))));
        }
        if (cameraComponent.isSupportNightVision()) {
            arrayList.add(new Request<>(Method.GET_NIGHT_VISION_CAPABILITY, F(new Wrapper(Module.IMAGE_CAPABILITY, section, Collections.singletonList(Section.SUPPLEMENT_LAMP.getValue())))));
        }
        arrayList.add(new Request<>(Method.GET_RECORD_PLAN, F(new Wrapper(Module.RECORD_PLAN, section, Collections.singletonList(Section.CHN1_CHANNEL.getValue())))));
        if (cameraComponent.isSupportBabyCry()) {
            arrayList.add(b());
        }
        if (cameraComponent.isSupportPersonDetection()) {
            arrayList.add(d());
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> B1(RebootInfo rebootInfo) {
        return O0(new Request<>(Method.SET_REBOOT, new Wrapper(Module.TIMING_REBOOT, Section.REBOOT, rebootInfo)));
    }

    public Request<MultipleRequest> C(CloudTerraceResetInfo cloudTerraceResetInfo) {
        return O0(new Request<>(Method.DELETE_PRESET, new Wrapper(Module.PRESET, Section.REMOVE_PRESET, cloudTerraceResetInfo)));
    }

    public Request<MultipleRequest> C0(long j, long j2, int i, int i2) {
        return O0(new Request<>(Method.SEARCH_SEARCH_SNAPSHOT, new Wrapper(Module.PLAYBACK, Section.PLAYBACK_SNAPSHOT_LIST, new SnapshotPlaybackFilter(j, j2, i, i2))));
    }

    public Request<MultipleRequest> C1(boolean z) {
        return O0(new Request<>(Method.SET_RECORD_AUDIO, new Wrapper(Module.AUDIO_CONFIG, Section.RECORD_AUDIO, new RecordAudioInfo(z ? "on" : "off"))));
    }

    public Request<MultipleRequest> D() {
        return O0(new Request<>(Method.FORMAT_SD_CARD, new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_FORMAT, "1")));
    }

    public Request<MultipleRequest> D0() {
        return O0(new Request<>(Method.GET_TAMPER_DETECTION_CONFIG, new Wrapper(Module.TAMPER_DETECTION, Section.NAME, Collections.singletonList(Section.TAMPER_DET.getValue()))));
    }

    public Request<MultipleRequest> D1(RecordPlanInfo recordPlanInfo) {
        return O0(new Request<>(Method.SET_RECORD_PLAN, new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, recordPlanInfo)));
    }

    public Request<MultipleRequest> E0() {
        return O0(new Request<>(Method.GET_TARGET_TRACK_CONFIG, new Wrapper(Module.TARGET_TRACK, Section.NAME, Section.TARGET_TRACK_INFO.getValue())));
    }

    public Request<MultipleRequest> E1(ResolutionType resolutionType) {
        return O0(new Request<>(Method.SET_RESOLUTION, new Wrapper(Module.VIDEO, Section.SET_RESOLUTION, new Resolution(resolutionType))));
    }

    public Request<MultipleRequest> F0() {
        return O0(new Request<>(Method.GET_THIRD_ACCOUNT, new Wrapper(Module.USER_MANAGEMENT, Section.NAME, Collections.singletonList(Section.THIRD_ACCOUNT.getValue()))));
    }

    public Request<MultipleRequest> F1(SpeakerInfo speakerInfo) {
        return O0(new Request<>(Method.SET_SPEAKER_VOLUME, new Wrapper(Module.AUDIO_CONFIG, Section.SPEAKER, speakerInfo)));
    }

    public Request<MultipleRequest> G() {
        return O0(new Request<>(Method.GET_AES_ENCRYPT_KEY, new Wrapper(Module.CERT, Section.GET_AES_KEY, Collections.emptyMap())));
    }

    public Request<MultipleRequest> G0() {
        return O0(new Request<>(Method.GET_TIMEZONE, new Wrapper(Module.SYSTEM, Section.NAME, Collections.singletonList(Section.BASIC.getValue()))));
    }

    public Request<MultipleRequest> G1(TamperDetectConfig tamperDetectConfig) {
        return O0(new Request<>(Method.SET_TAMPER_DETECTION_CONFIG, new Wrapper(Module.TAMPER_DETECTION, Section.TAMPER_DET, tamperDetectConfig)));
    }

    public Request<MultipleRequest> H() {
        return O0(new Request<>(Method.GET_ALERT_PLAN, new Wrapper(Module.MSG_ALARM_PLAN, Section.NAME, Collections.singletonList(Section.MSG_ALARM_PLAN.getValue()))));
    }

    public Request<MultipleRequest> H0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(E(Method.GET_UPNP_INFO, Module.UPNPC, Section.NAME, Section.UPNPC_INFO.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> H1(boolean z) {
        return O0(new Request<>(Method.SET_TARGET_TRACK_CONFIG, new Wrapper(Module.TARGET_TRACK, Section.TARGET_TRACK_INFO, new TargetTrackInfo(z))));
    }

    public Request<MultipleRequest> I() {
        return O0(new Request<>(Method.GET_ALERT_CONFIG, new Wrapper(Module.MSG_ALARM, Section.NAME, Collections.singletonList(Section.MSG_ALARM_INFO.getValue()))));
    }

    public Request<MultipleRequest> I0() {
        Module module = Module.UPNPC;
        Section section = Section.NAME;
        Wrapper wrapper = new Wrapper(module, section, Collections.singletonList(Section.UPNPC_INFO.getValue()));
        Wrapper wrapper2 = new Wrapper(module, Section.TABLE, Collections.singletonList(Section.UPNP_STATUS.getValue()));
        Wrapper wrapper3 = new Wrapper(module, section, Collections.singletonList(Section.PUB_IP.getValue()));
        Wrapper wrapper4 = new Wrapper(module, section, Collections.singletonList(Section.COMMUNICATE.getValue()));
        Wrapper wrapper5 = new Wrapper(Module.CERT, Section.GET_HTTPS_PSK, Collections.singletonList(Section.EMPTY.getValue()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Request<>(Method.GET_UPNP_INFO, F(wrapper)));
        arrayList.add(new Request<>(Method.GET_UPNP_STATUS, F(wrapper2)));
        arrayList.add(new Request<>(Method.GET_PUB_IP, F(wrapper3)));
        arrayList.add(new Request<>(Method.GET_UPNP_COMM_STATUS, F(wrapper4)));
        arrayList.add(new Request<>(Method.GET_UPNP_PSK, F(wrapper5)));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> I1(String str, String str2) {
        return O0(new Request<>(Method.SET_TIMEZONE, new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(str, str2))));
    }

    public Request<MultipleRequest> J() {
        return O0(new Request<>(Method.GET_AUDIO_CONFIG, new Wrapper(Module.AUDIO_CONFIG, Section.NAME, new String[]{Section.SPEAKER.getValue(), Section.MICROPHONE.getValue()})));
    }

    public Request<MultipleRequest> J0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(E(Method.GET_UPNP_PSK, Module.CERT, Section.GET_HTTPS_PSK, Section.EMPTY.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> J1(UpnpCommStatus upnpCommStatus) {
        return O0(new Request<>(Method.SET_UPNP_COMM_STATUS, new Wrapper(Module.UPNPC, Section.COMMUNICATE, upnpCommStatus)));
    }

    public Request<MultipleRequest> K() {
        return O0(new Request<>(Method.GET_FIRMWARE_AUTO_UPGRADE_CONFIG, new Wrapper(Module.AUTO_UPDATE, Section.NAME, Collections.singletonList(Section.COMMON.getValue()))));
    }

    public Request<MultipleRequest> K0() {
        return O0(new Request<>(Method.GET_USER_ID, new Wrapper(Module.SYSTEM, Section.USER_ID, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> K1(UpnpInfo upnpInfo) {
        return O0(new Request<>(Method.SET_UPNP_INFO, new Wrapper(Module.UPNPC, Section.UPNPC_INFO, upnpInfo)));
    }

    public Request<MultipleRequest> L() {
        ArrayList arrayList = new ArrayList();
        Method method = Method.GET_CLOCK_STATUS;
        Module module = Module.SYSTEM;
        Section section = Section.NAME;
        arrayList.add(E(method, module, section, Section.CLOCK_STATUS.getValue()));
        arrayList.add(E(Method.GET_TIMEZONE, module, section, Section.BASIC.getValue()));
        arrayList.add(E(Method.GET_DST_RULE, module, section, Section.DST.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> L0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(E(Method.GET_WHITE_LAMP_CONFIG, Module.IMAGE, Section.NAME, Section.SWITCH.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> L1(WhiteLampConfig whiteLampConfig) {
        return O0(new Request<>(Method.SET_WHITE_LAMP_CONFIG, new Wrapper(Module.IMAGE, Section.SWITCH, whiteLampConfig)));
    }

    public Request<MultipleRequest> M() {
        ArrayList arrayList = new ArrayList();
        Method method = Method.GET_CLOCK_STATUS;
        Module module = Module.SYSTEM;
        Section section = Section.NAME;
        arrayList.add(E(method, module, section, Section.CLOCK_STATUS.getValue()));
        arrayList.add(E(Method.GET_TIMEZONE, module, section, Section.BASIC.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> M0(Date date, Date date2) {
        return O0(new Request<>(Method.SEARCH_DATE_WITH_VIDEO, new Wrapper(Module.PLAYBACK, Section.PLAYBACK_DATE_FILTER, new YearlyPlaybackFilter(this.a.format(date), this.a.format(date2)))));
    }

    public Request<MultipleRequest> M1(Account account, String str, String str2, String str3, RecordPlanInfo recordPlanInfo) {
        return Q0(Arrays.asList(new Request(Method.CHANGE_ADMIN_PASSWORD, F(new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, new AccountInfo(new Account("admin", j.a(str), false), account.copy(account.getUsername(), account.getPassword(), false).getPassword())))), new Request(Method.SET_OSD, F(new Wrapper(Module.CERT, Section.CERT_MEDIA_ENCRYPT, new MediaEncrypt("on")))), new Request(Method.SET_TIMEZONE, F(new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(str2, str3)))), new Request(Method.SET_RECORD_PLAN, F(new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, recordPlanInfo)))));
    }

    public Request<MultipleRequest> N() {
        return O0(new Request<>(Method.GET_PRESET_CONFIG, new Wrapper(Module.PRESET, Section.NAME, new String[]{Section.PRESET.getValue()})));
    }

    public Request<Account> N0(Account account) {
        if (!account.getHashed()) {
            account = Model.passwordDigest(account);
        }
        return new Request<>(Method.LOGIN, account);
    }

    public Request<MultipleRequest> N1(Account account, String str, String str2, RecordPlanInfo recordPlanInfo) {
        Account copy = account.copy(account.getUsername(), account.getPassword(), false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Request<>(Method.BIND_TO_CLOUD, new Wrappers(Collections.singletonList(new Wrapper(Module.CLOUD_CONFIG, Section.CLOUD_BIND, copy)))));
        arrayList.add(new Request<>(Method.CHANGE_ADMIN_PASSWORD, F(new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, new AccountInfo(new Account("admin", "admin", false), copy.getPassword())))));
        arrayList.add(new Request<>(Method.SET_OSD, F(new Wrapper(Module.CERT, Section.CERT_MEDIA_ENCRYPT, new MediaEncrypt("on")))));
        if (!(str == null || str2 == null)) {
            arrayList.add(new Request<>(Method.SET_TIMEZONE, F(new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(str, str2)))));
        }
        if (recordPlanInfo != null) {
            arrayList.add(new Request<>(Method.SET_RECORD_PLAN, F(new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, recordPlanInfo))));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> O() {
        return O0(new Request<>(Method.GET_APP_COMPONENT_LIST, new Wrapper(Module.APP_COMPONENT, Section.NAME, Section.APP_COMPONENT_LIST.getValue())));
    }

    public Request<MultipleRequest> O1() {
        return O0(new Request<>(Method.SOFT_RESET, new Wrapper(Module.SYSTEM, Section.SOFT_RESET, Collections.emptyMap())));
    }

    public Request<Wrapper> P() {
        return new Request<>(Method.GET_CONNECT_STATUS, new Wrapper(Module.ON_BOARDING, Section.GET_CONNECT_STATUS, Collections.emptyMap()));
    }

    public Request<MultipleRequest> P1() {
        return O0(new Request<>(Method.START_FIRMWARE_UPGRADE, new Wrapper(Module.CLOUD_CONFIG, Section.FIRMWARE_DOWNLOAD, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> Q() {
        Module module = Module.COVER;
        return P0(new Request<>(Method.GET_COVER_CONFIG, new Wrappers(Arrays.asList(new Wrapper(module, Section.NAME, Collections.singletonList(Section.COVER.getValue())), new Wrapper(module, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()))))));
    }

    public Request<MultipleRequest> Q0(List<Request<Wrappers>> list) {
        return new Request<>(Method.MULTIPLE_REQUEST, new MultipleRequest(list));
    }

    public Request<MultipleRequest> Q1() {
        return O0(new Request<>(Method.CRUISE_STOP, new Wrapper(Module.MOTOR, Section.CRUISE_STOP, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> R(int i, String str, int i2, int i3) {
        return O0(new Request<>(Method.SEARCH_VIDEO_OF_DAY, new Wrapper(Module.PLAYBACK, Section.PLAYBACK_TIME_FILTER, new DailyPlaybackFilter(i, str, i2, i3))));
    }

    public Request<MultipleRequest> R0() {
        return O0(new Request<>(Method.REBOOT_DEVICE, new Wrapper(Module.SYSTEM, Section.REBOOT, Collections.emptyMap())));
    }

    public Request<MultipleRequest> R1() {
        return O0(new Request<>(Method.STOP_MOVE, new Wrapper(Module.MOTOR, Section.STOP, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> S(int i, long j, long j2, int i2, int i3) {
        return O0(new Request<>(Method.SEARCH_VIDEO_WITH_UTC, new Wrapper(Module.PLAYBACK, Section.PLAYBACK_TIME_FILTER_UTC, new DailyPlaybackUtcFilter(i, j, j2, i2, i3))));
    }

    public Request<MultipleRequest> S0() {
        return O0(new Request<>(Method.RESET, new Wrapper(Module.SYSTEM, Section.RESET, Collections.emptyMap())));
    }

    public Request<MultipleRequest> S1(String str, String str2) {
        return O0(new Request<>(Method.VERIFY_THIRD_ACCOUNT, new Wrapper(Module.USER_MANAGEMENT, Section.VERIFY_THIRD_ACCOUNT, new AccountInfo(str, str2))));
    }

    public Request<MultipleRequest> T(CameraComponent cameraComponent) {
        ArrayList arrayList = new ArrayList();
        Module module = Module.MSG_ALARM;
        Section section = Section.NAME;
        arrayList.add(new Request<>(Method.GET_ALERT_CONFIG, F(new Wrapper(module, section, Collections.singletonList(Section.MSG_ALARM_INFO.getValue())))));
        if (cameraComponent.isSupportMsgPush()) {
            arrayList.add(new Request<>(Method.GET_MSG_PUSH_CONFIG, F(new Wrapper(Module.MSG_PUSH, section, Collections.singletonList(Section.MSG_PUSH_INFO.getValue())))));
        }
        if (cameraComponent.isSupportPersonDetection()) {
            arrayList.add(d());
        }
        if (cameraComponent.isSupportBabyCry()) {
            arrayList.add(b());
        }
        if (cameraComponent.hasComponent(ComponentType.TARGET_TRACK)) {
            arrayList.add(new Request<>(Method.GET_TARGET_TRACK_CONFIG, F(new Wrapper(Module.TARGET_TRACK, section, Collections.singletonList(Section.TARGET_TRACK_INFO.getValue())))));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> T0() {
        return O0(new Request<>(Method.RESET_CONFIG_ONLY, new Wrapper(Module.SYSTEM, Section.RESET_CONFIG_ONLY, Collections.emptyMap())));
    }

    public Request<MultipleRequest> U() {
        return O0(new Request<>(Method.GET_DEVICE_INFO, new Wrapper(Module.DEVICE_INFO, Section.NAME, Collections.singletonList(Section.BASIC_INFO.getValue()))));
    }

    public Request<Wrapper> U0() {
        return new Request<>(Method.SCAN_WIFI_LIST, new Wrapper(Module.ON_BOARDING, Section.SCAN, Collections.emptyMap()));
    }

    public Request<MultipleRequest> V() {
        return O0(new Request<>(Method.GET_DIAGNOSE_MODE, new Wrapper(Module.SYSTEM, Section.NAME, Section.SYS.getValue())));
    }

    public Request<MultipleRequest> V0(AlarmInfo alarmInfo) {
        return O0(new Request<>(Method.SET_ALERT_CONFIG, new Wrapper(Module.MSG_ALARM, Section.ALERT_INFO, alarmInfo)));
    }

    public Request<MultipleRequest> W() {
        return u(e(), c());
    }

    public Request<MultipleRequest> W0(AlarmPlanInfo alarmPlanInfo) {
        return O0(new Request<>(Method.SET_ALERT_PLAN, new Wrapper(Module.MSG_ALARM_PLAN, Section.MSG_ALARM_PLAN, alarmPlanInfo)));
    }

    public Request<MultipleRequest> X() {
        return O0(new Request<>(Method.GET_FIRMWARE_UPDATE_STATUS, new Wrapper(Module.CLOUD_CONFIG, Section.NAME, Section.UPGRADE_STATUS.getValue())));
    }

    public Request<MultipleRequest> X0(AutoUpdateInfo autoUpdateInfo) {
        return O0(new Request<>(Method.SET_FIRMWARE_AUTO_UPGRADE_CONFIG, new Wrapper(Module.AUTO_UPDATE, Section.COMMON, autoUpdateInfo)));
    }

    public Request<MultipleRequest> Y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(E(Method.GET_FORCE_WHITELAMP_STATE, Module.IMAGE, Section.NAME, Section.SWITCH.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> Y0(boolean z, String str) {
        return u(h(z, str));
    }

    public Request<MultipleRequest> Z() {
        Module module = Module.DEVICE_INFO;
        Section section = Section.NAME;
        Wrapper wrapper = new Wrapper(module, section, Collections.singletonList(Section.BASIC_INFO.getValue()));
        Wrapper wrapper2 = new Wrapper(Module.SYSTEM, section, Collections.singletonList(Section.LAST_ALARM_INFO.getValue()));
        Wrapper wrapper3 = new Wrapper(Module.APP_COMPONENT, section, Collections.singletonList(Section.APP_COMPONENT_LIST.getValue()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Request<>(Method.GET_DEVICE_INFO, F(wrapper)));
        arrayList.add(new Request<>(Method.GET_LAST_ALARM_INFO, F(wrapper2)));
        arrayList.add(new Request<>(Method.GET_APP_COMPONENT_LIST, F(wrapper3)));
        return Q0(arrayList);
    }

    public Request<Wrapper> Z0(String str) {
        return new Request<>(Method.SET_CLOUD_SERVER_TYPE, new Wrapper(Module.SERVER_TYPE, Section.EMPTY, str));
    }

    public Request<MultipleRequest> a0() {
        return O0(new Request<>(Method.GET_INTRUSION_DETECTION_CONFIG, new Wrapper(Module.INTRUSION_DETECTION, Section.NAME, Arrays.asList(Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue()))));
    }

    public Request<MultipleRequest> b0() {
        return O0(new Request<>(Method.GET_INTRUSION_DETECTION_REGION, new Wrapper(Module.INTRUSION_DETECTION, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()))));
    }

    public Request<MultipleRequest> b1(boolean z) {
        return u(a1(new CoverConfig(z)));
    }

    public Request<Wrappers> c() {
        return E(Method.GET_CLOUD_CONFIG, Module.CLOUD_CONFIG, Section.NAME, Collections.singletonList(Section.UPGRADE_INFO.getValue()));
    }

    public Request<MultipleRequest> c0() {
        return O0(new Request<>(Method.GET_DEVICE_IP_ADDRESS, new Wrapper(Module.NETWORK, Section.NAME, Collections.singletonList(Section.WAN.getValue()))));
    }

    public Request<MultipleRequest> c1(String str) {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setAlias(str);
        return O0(new Request<>(Method.SET_DEVICE_ALIAS, new Wrapper(Module.SYSTEM, Section.SYS, systemInfo)));
    }

    public Request<MultipleRequest> d0(CameraComponent cameraComponent) {
        Module module = Module.DEVICE_INFO;
        Section section = Section.NAME;
        Wrapper wrapper = new Wrapper(module, section, Collections.singletonList(Section.BASIC_INFO.getValue()));
        Wrapper wrapper2 = new Wrapper(Module.SYSTEM, section, Collections.singletonList(Section.LAST_ALARM_INFO.getValue()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Request<>(Method.GET_DEVICE_INFO, F(wrapper)));
        arrayList.add(new Request<>(Method.GET_LAST_ALARM_INFO, F(wrapper2)));
        if (cameraComponent != null && cameraComponent.isSupportUpnp()) {
            Module module2 = Module.UPNPC;
            Wrapper wrapper3 = new Wrapper(module2, section, Collections.singletonList(Section.UPNPC_INFO.getValue()));
            Wrapper wrapper4 = new Wrapper(module2, Section.TABLE, Collections.singletonList(Section.UPNP_STATUS.getValue()));
            Wrapper wrapper5 = new Wrapper(module2, section, Collections.singletonList(Section.PUB_IP.getValue()));
            Wrapper wrapper6 = new Wrapper(module2, section, Collections.singletonList(Section.COMMUNICATE.getValue()));
            Wrapper wrapper7 = new Wrapper(Module.CERT, Section.GET_HTTPS_PSK, Collections.singletonList(Section.EMPTY.getValue()));
            arrayList.add(new Request<>(Method.GET_UPNP_INFO, F(wrapper3)));
            arrayList.add(new Request<>(Method.GET_UPNP_STATUS, F(wrapper4)));
            arrayList.add(new Request<>(Method.GET_PUB_IP, F(wrapper5)));
            arrayList.add(new Request<>(Method.GET_UPNP_COMM_STATUS, F(wrapper6)));
            arrayList.add(new Request<>(Method.GET_UPNP_PSK, F(wrapper7)));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> d1(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            SystemInfo systemInfo = new SystemInfo();
            systemInfo.setAlias(str);
            arrayList.add(E(Method.SET_DEVICE_ALIAS, Module.SYSTEM, Section.SYS, systemInfo));
        }
        if (str2 != null) {
            SystemInfo systemInfo2 = new SystemInfo();
            systemInfo2.setAvatar(str2);
            arrayList.add(E(Method.SET_DEVICE_AVATAR, Module.SYSTEM, Section.SYS, systemInfo2));
        }
        return Q0(arrayList);
    }

    public Request<Wrappers> e() {
        return E(Method.CHECK_FIRMWARE_VERSION_BY_CLOUD, Module.CLOUD_CONFIG, Section.FIRMWARE_NOTIFY, Section.EMPTY.getValue());
    }

    public Request<MultipleRequest> e0() {
        return O0(new Request<>(Method.GET_LDC, new Wrapper(Module.IMAGE, Section.NAME, Section.SWITCH.getValue())));
    }

    public Request<MultipleRequest> e1(String str) {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setAvatar(str);
        return O0(new Request<>(Method.SET_DEVICE_AVATAR, new Wrapper(Module.SYSTEM, Section.SYS, systemInfo)));
    }

    public Request<MultipleRequest> f0() {
        return O0(new Request<>(Method.GET_LENS_MASK_CONFIG, new Wrapper(Module.LENS_MASK, Section.NAME, Collections.singletonList(Section.LENS_MASK_INFO.getValue()))));
    }

    public Request<MultipleRequest> f1(boolean z) {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setDiagnoseMode(z ? "on" : "off");
        return O0(new Request<>(Method.SET_DIAGNOSE_MODE, new Wrapper(Module.SYSTEM, Section.SYS, systemInfo)));
    }

    public Request<MultipleRequest> g0() {
        return O0(new Request<>(Method.GET_LIGHT_FREQUENCY_INFO, new Wrapper(Module.IMAGE, Section.NAME, Section.COMMON.getValue())));
    }

    public Request<MultipleRequest> g1(WhitelampState whitelampState) {
        return O0(new Request<>(Method.SET_FORCE_WHITELAMP_STATE, new Wrapper(Module.IMAGE, Section.SWITCH, whitelampState)));
    }

    public Request<MultipleRequest> h0() {
        return O0(new Request<>(Method.GET_LINE_CROSSING_DETECTION_CONFIG, new Wrapper(Module.LINE_CROSSING_DETECTION, Section.NAME, Arrays.asList(Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue()))));
    }

    public Request<MultipleRequest> h1(boolean z) {
        return u(i(z));
    }

    public Request<MultipleRequest> i0() {
        return O0(new Request<>(Method.GET_LINE_CROSSING_DETECTION_REGION, new Wrapper(Module.LINE_CROSSING_DETECTION, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()))));
    }

    public Request<MultipleRequest> i1(boolean z) {
        return O0(new Request<>(Method.SET_ROTATION_STATUS, new Wrapper(Module.IMAGE, Section.IMAGE_SWITCH, new ImageFlip(z))));
    }

    public Request<MultipleRequest> j0() {
        return O0(new Request<>(Method.GET_VIDEO_QUALITIES, new Wrapper(Module.VIDEO, Section.NAME, Collections.singletonList(Section.VIDEO_MAIN.getValue()))));
    }

    public Request<MultipleRequest> j1(DetectionInfo detectionInfo) {
        return O0(new Request<>(Method.SET_INTRUSION_DETECTION_CONFIG, new Wrapper(Module.INTRUSION_DETECTION, Section.DETECTION, detectionInfo)));
    }

    public Request<MultipleRequest> k0() {
        Module module = Module.MOTION_DETECTION;
        return P0(new Request<>(Method.GET_DETECTION_CONFIG, new Wrappers(Arrays.asList(new Wrapper(module, Section.NAME, Collections.singletonList(Section.MOTION_DET.getValue())), new Wrapper(module, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()))))));
    }

    public Request<MultipleRequest> k1(ArmScheduleInfo armScheduleInfo) {
        return O0(new Request<>(Method.SET_INTRUSION_DETECTION_SCHEDULE, new Wrapper(Module.INTRUSION_DETECTION, Section.ARMING_SCHEDULE, armScheduleInfo)));
    }

    public Request<MultipleRequest> l(List<CoverConfigRegion> list) {
        return u(k(list));
    }

    public Request<MultipleRequest> l0() {
        return O0(new Request<>(Method.GET_MSG_PUSH_CONFIG, new Wrapper(Module.MSG_PUSH, Section.NAME, Collections.singletonList(Section.MSG_PUSH_INFO.getValue()))));
    }

    public Request<Wrapper> l1(String str) {
        return new Request<>(Method.SET_LANGUAGE, new Wrapper(Module.LANGUAGE, Section.EMPTY, str));
    }

    public Request<MultipleRequest> m(Map<String, List<IntrusionDetectionRegion>> map) {
        return O0(new Request<>(Method.ADD_INTRUSION_DETECTION_REGION, new Wrapper(Module.INTRUSION_DETECTION, Section.ADD_REGIONS, map)));
    }

    public Request<MultipleRequest> m0() {
        return O0(new Request<>(Method.GET_MSG_PUSH_PLAN, new Wrapper(Module.MSG_PUSH_PLAN, Section.NAME, Collections.singletonList(Section.MSG_PUSH_PLAN.getValue()))));
    }

    public Request<MultipleRequest> m1(boolean z) {
        return O0(new Request<>(Method.SET_LDC, new Wrapper(Module.IMAGE, Section.SWITCH, new ImageFlip(z ? "on" : "off"))));
    }

    public Request<MultipleRequest> n(Map<String, List<LineCrossingDetectionRegion>> map) {
        return O0(new Request<>(Method.ADD_LINE_CROSSING_DETECTION_REGION, new Wrapper(Module.LINE_CROSSING_DETECTION, Section.ADD_REGIONS, map)));
    }

    public Request<MultipleRequest> n0() {
        return O0(new Request<>(Method.GET_CONNECTION_TYPE, new Wrapper(Module.NETWORK, Section.GET_NETWORK_INFO, Section.EMPTY.getValue())));
    }

    public Request<MultipleRequest> n1(String str) {
        return O0(new Request<>(Method.SET_LED_STATUS, new Wrapper(Module.LED, Section.CONFIG, new LedStatus(str))));
    }

    public Request<MultipleRequest> o(List<MotionDetectRegion> list) {
        return O0(new Request<>(Method.ADD_DETECTION_REGION, Model.wrapper(list, Module.MOTION_DETECTION, Section.MOTION_DETECTION_ADD_REGION, Section.REGION_INFO.getValue())));
    }

    public Request<MultipleRequest> o0(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(Section.OSD_LOGO.getValue());
        }
        arrayList.add(Section.OSD_DATE.getValue());
        arrayList.add(Section.OSD_WEEK.getValue());
        arrayList.add(Section.OSD_FONT.getValue());
        List singletonList = Collections.singletonList(Section.OSD_LABEL_INFO.getValue());
        Module module = Module.OSD;
        return P0(new Request<>(Method.GET_OSD, new Wrappers(Arrays.asList(new Wrapper(module, Section.NAME, arrayList), new Wrapper(module, Section.TABLE, singletonList)))));
    }

    public Request<MultipleRequest> o1(LensMaskInfo lensMaskInfo) {
        return Q0(Collections.singletonList(new Request(Method.SET_LENS_MASK_CONFIG, F(new Wrapper(Module.LENS_MASK, Section.LENS_MASK_INFO, lensMaskInfo)))));
    }

    public Request<MultipleRequest> p(String str, String str2) {
        return O0(new Request<>(Method.CHANGE_ADMIN_PASSWORD, new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, new AccountInfo(new Account("admin", j.a(str), false), str2))));
    }

    public Request<MultipleRequest> p0() {
        return O0(new Request<>(Method.GET_P2P_SHARE_PWD, new Wrapper(Module.USER_MANAGEMENT, Section.GET_P2P_SHARE_PWD, Collections.emptyMap())));
    }

    public Request<MultipleRequest> p1(LensMaskInfo lensMaskInfo) {
        Request request = new Request(Method.SET_LENS_MASK_CONFIG, F(new Wrapper(Module.LENS_MASK, Section.LENS_MASK_INFO, lensMaskInfo)));
        Module module = Module.LED;
        Section section = Section.CONFIG;
        String str = "on";
        if (lensMaskInfo.getEnabled().equals(str)) {
            str = "off";
        }
        return Q0(Arrays.asList(request, new Request(Method.SET_LED_STATUS, F(new Wrapper(module, section, new LedStatus(str))))));
    }

    public Request<MultipleRequest> q(MotionDetectConfig motionDetectConfig) {
        return u(j(motionDetectConfig));
    }

    public Request<MultipleRequest> q0() {
        return O0(new Request<>(Method.GET_REBOOT, new Wrapper(Module.TIMING_REBOOT, Section.NAME, Collections.singletonList(Section.REBOOT.getValue()))));
    }

    public Request<MultipleRequest> q1(String str) {
        return O0(new Request<>(Method.SET_LIGHT_FREQUENCY_INFO, new Wrapper(Module.IMAGE, Section.COMMON, new Light(str, null))));
    }

    public Request<MultipleRequest> r(String str, String str2) {
        return O0(new Request<>(Method.CHANGE_THIRD_ACCOUNT, new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_THIRD_ACCOUNT, new AccountInfo(str, str2))));
    }

    public Request<MultipleRequest> r0() {
        return O0(new Request<>(Method.GET_AUDIO_CONFIG, new Wrapper(Module.AUDIO_CONFIG, Section.NAME, new String[]{Section.RECORD_AUDIO.getValue()})));
    }

    public Request<MultipleRequest> r1(DetectionInfo detectionInfo) {
        return O0(new Request<>(Method.SET_LINE_CROSSING_DETECTION_CONFIG, new Wrapper(Module.LINE_CROSSING_DETECTION, Section.DETECTION, detectionInfo)));
    }

    public Request<MultipleRequest> s() {
        return O0(new Request<>(Method.CHECK_DIAGNOSE_STATUS, new Wrapper(Module.SYSTEM, Section.CHECK_DIAGNOSE_STATUS, "")));
    }

    public Request<MultipleRequest> s0() {
        return O0(new Request<>(Method.GET_RECORD_PLAN, new Wrapper(Module.RECORD_PLAN, Section.NAME, Collections.singletonList(Section.CHN1_CHANNEL.getValue()))));
    }

    public Request<MultipleRequest> s1(ArmScheduleInfo armScheduleInfo) {
        return O0(new Request<>(Method.SET_LINE_CROSSING_DETECTION_SCHEDULE, new Wrapper(Module.LINE_CROSSING_DETECTION, Section.ARMING_SCHEDULE, armScheduleInfo)));
    }

    public Request<MultipleRequest> t() {
        return O0(new Request<>(Method.CHECK_RESET_WIFI, new Wrapper(Module.SYSTEM, Section.RESET_WIFI_SUPPORTED, Collections.emptyMap())));
    }

    public List<Request<Wrappers>> t0(MotionDetectConfig motionDetectConfig, AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, DetectionInfo detectionInfo, DetectionInfo detectionInfo2, TamperDetectConfig tamperDetectConfig, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo) {
        ArrayList arrayList = new ArrayList();
        if (motionDetectConfig != null) {
            arrayList.add(j(motionDetectConfig));
        }
        if (alarmInfo != null) {
            arrayList.add(f(alarmInfo));
        }
        if (msgPushInfo != null) {
            arrayList.add(E(Method.SET_MSG_PUSH_CONFIG, Module.MSG_PUSH, Section.MSG_PUSH_INFO, msgPushInfo));
        }
        if (detectionInfo != null) {
            arrayList.add(E(Method.SET_INTRUSION_DETECTION_CONFIG, Module.INTRUSION_DETECTION, Section.DETECTION, detectionInfo));
        }
        if (detectionInfo2 != null) {
            arrayList.add(E(Method.SET_LINE_CROSSING_DETECTION_CONFIG, Module.LINE_CROSSING_DETECTION, Section.DETECTION, detectionInfo2));
        }
        if (tamperDetectConfig != null) {
            arrayList.add(E(Method.SET_TAMPER_DETECTION_CONFIG, Module.TAMPER_DETECTION, Section.TAMPER_DET, tamperDetectConfig));
        }
        if (humanRecognitionInfo != null) {
            arrayList.add(E(Method.SET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.DETECTION, humanRecognitionInfo));
        }
        if (babyCryingDetectionInfo != null) {
            arrayList.add(E(Method.SET_BCD_CONFIG, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION, babyCryingDetectionInfo));
        }
        if (targetTrackInfo != null) {
            arrayList.add(E(Method.SET_TARGET_TRACK_CONFIG, Module.TARGET_TRACK, Section.TARGET_TRACK_INFO, targetTrackInfo));
        }
        return arrayList;
    }

    public Request<MultipleRequest> t1(boolean z) {
        return O0(new Request<>(Method.SET_CIRCULAR_RECORDING_CONFIG, new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_LOOP, new HardDiskLoop(z ? "on" : "off"))));
    }

    public Request<MultipleRequest> u0(AlarmPlanInfo alarmPlanInfo, MsgPushPlanInfo msgPushPlanInfo, ArmScheduleInfo armScheduleInfo, ArmScheduleInfo armScheduleInfo2) {
        ArrayList arrayList = new ArrayList();
        if (alarmPlanInfo != null) {
            arrayList.add(g(alarmPlanInfo));
        }
        if (msgPushPlanInfo != null) {
            arrayList.add(E(Method.SET_MSG_PUSH_PLAN, Module.MSG_PUSH_PLAN, Section.MSG_PUSH_PLAN, msgPushPlanInfo));
        }
        if (armScheduleInfo != null) {
            arrayList.add(E(Method.SET_INTRUSION_DETECTION_SCHEDULE, Module.INTRUSION_DETECTION, Section.ARMING_SCHEDULE, armScheduleInfo));
        }
        if (armScheduleInfo2 != null) {
            arrayList.add(E(Method.SET_LINE_CROSSING_DETECTION_SCHEDULE, Module.LINE_CROSSING_DETECTION, Section.ARMING_SCHEDULE, armScheduleInfo2));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> u1(MicroPhoneInfo microPhoneInfo) {
        return O0(new Request<>(Method.SET_MICROPHONE_VOLUME, new Wrapper(Module.AUDIO_CONFIG, Section.MICROPHONE, microPhoneInfo)));
    }

    public Request<Wrapper<Wifi>> v(Wifi wifi) {
        return new Request<>(Method.CONNECT_AP, new Wrapper(Module.ON_BOARDING, Section.CONNECT, wifi));
    }

    public Request<MultipleRequest> v0(List<MotionDetectRegion> list, Map<String, List<IntrusionDetectionRegion>> map, HashMap<String, List<LineCrossingDetectionRegion>> hashMap) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.add(a(list));
        }
        if (map != null) {
            arrayList.add(E(Method.ADD_INTRUSION_DETECTION_REGION, Module.INTRUSION_DETECTION, Section.ADD_REGIONS, map));
        }
        if (hashMap != null) {
            arrayList.add(E(Method.ADD_LINE_CROSSING_DETECTION_REGION, Module.LINE_CROSSING_DETECTION, Section.ADD_REGIONS, hashMap));
        }
        return Q0(arrayList);
    }

    public Request<MultipleRequest> v1(MsgPushInfo msgPushInfo) {
        return O0(new Request<>(Method.SET_MSG_PUSH_CONFIG, new Wrapper(Module.MSG_PUSH, Section.MSG_PUSH_INFO, msgPushInfo)));
    }

    public Request<MultipleRequest> w(CloudTerracePoint cloudTerracePoint) {
        return O0(new Request<>(Method.ADD_MOTOR_POSITION, new Wrapper(Module.PRESET, Section.SET_PRESET, cloudTerracePoint)));
    }

    public Request<MultipleRequest> w0() {
        return P0(new Request<>(Method.GET_SD_CARD_STATUS, new Wrappers(Arrays.asList(new Wrapper(Module.HARD_DISK_MANAGE, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()))))));
    }

    public Request<MultipleRequest> w1(MsgPushPlanInfo msgPushPlanInfo) {
        return O0(new Request<>(Method.SET_MSG_PUSH_PLAN, new Wrapper(Module.MSG_PUSH_PLAN, Section.MSG_PUSH_PLAN, msgPushPlanInfo)));
    }

    public Request<MultipleRequest> x(boolean z) {
        return O0(new Request<>(Method.CRUISE_MOVE, new Wrapper(Module.MOTOR, Section.CRUISE, new CloudTerraceCruiseInfo(z ? "y" : "x"))));
    }

    public Request<MultipleRequest> x0() {
        return O0(new Request<>(Method.GET_SD_CARD_FORMAT_STATUS, new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_FORMAT_STATUS, DiskInfo.getSingletonDisk())));
    }

    public Request<MultipleRequest> x1(NightMode nightMode) {
        return O0(new Request<>(Method.SET_DAY_NIGHT_MODE_CONFIG, new Wrapper(Module.IMAGE, Section.COMMON, new Light(null, nightMode.getRaw()))));
    }

    public Request<MultipleRequest> y(CloudTerraceMoveInfo cloudTerraceMoveInfo) {
        return O0(new Request<>(Method.MOTOR_MOVE, new Wrapper(Module.MOTOR, Section.MOVE, cloudTerraceMoveInfo)));
    }

    public Request<MultipleRequest> y0() {
        ArrayList arrayList = new ArrayList();
        Module module = Module.HARD_DISK_MANAGE;
        Wrapper wrapper = new Wrapper(module, Section.NAME, Collections.singletonList(Section.HARD_DISK_LOOP.getValue()));
        Wrapper wrapper2 = new Wrapper(module, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()));
        arrayList.add(new Request<>(Method.GET_CIRCULAR_RECORDING_CONFIG, F(wrapper)));
        arrayList.add(new Request<>(Method.GET_SD_CARD_STATUS, F(wrapper2)));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> y1(NightVisionMode nightVisionMode) {
        return O0(new Request<>(Method.SET_NIGHT_VISION_MODE_CONFIG, new Wrapper(Module.IMAGE, Section.SWITCH, nightVisionMode)));
    }

    public Request<MultipleRequest> z(String str) {
        return O0(new Request<>(Method.SIGNAL_MOVE, new Wrapper(Module.MOTOR, Section.MOVE_STEP, new CloudTerraceMoveStepInfo(str))));
    }

    public Request<MultipleRequest> z0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(E(Method.GET_TAPO_CARE_SERVICE_LIST, Module.TAPO_CARE, Section.NAME, Section.SERVICE_LIST.getValue()));
        return Q0(arrayList);
    }

    public Request<MultipleRequest> z1(boolean z, boolean z2, String str, boolean z3) {
        String str2 = "on";
        String str3 = z ? str2 : "off";
        if (!z2) {
            str2 = "off";
        }
        OsdElement osdElement = new OsdElement("0", "0", null, str3);
        OsdElement osdElement2 = new OsdElement("0", "0", null, "off");
        OsdElement osdElement3 = new OsdElement("0", (!z3 || z) ? "500" : "0", str, str2);
        OsdFont osdFont = new OsdFont();
        Module module = Module.OSD;
        return P0(new Request<>(Method.SET_OSD, new Wrappers(Arrays.asList(new Wrapper(module, Section.OSD_DATE, osdElement), new Wrapper(module, Section.OSD_WEEK, osdElement2), new Wrapper(module, Section.OSD_FONT, osdFont), new Wrapper(module, Section.OSD_LABEL_INFO_FIRST, osdElement3)))));
    }
}
