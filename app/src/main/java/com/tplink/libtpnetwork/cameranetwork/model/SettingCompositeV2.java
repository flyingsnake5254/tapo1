package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class SettingCompositeV2 {
    public static final Companion Companion = new Companion(null);
    private AlarmInfo alarmInfo;
    private BabyCryingDetectionInfo babyCryDetectionInfo;
    private HumanRecognitionInfo humanRecognitionInfo;
    private IntrusionDetectionInfo intrusionDetectionInfo;
    private LensMaskInfo lensMaskInfo;
    private LineCrossingDetectionInfo lineCrossingDetectionInfo;
    private MotionDetectionInfo motionDetectionInfo;
    private NightVisionCapability nightVisionCapability;
    private RecordPlanInfo recordPlanInfo;
    private TamperDetectConfig tamperDetectConfig;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<SettingCompositeV2> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public SettingCompositeV2 fromMultipleResponse(MultipleResponse response) {
            j.e(response, "response");
            SettingCompositeV2 settingCompositeV2 = new SettingCompositeV2(null, null, null, null, null, null, null, null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_LENS_MASK_CONFIG.getValue())) {
                        settingCompositeV2.setLensMaskInfo((LensMaskInfo) Model.typeCast(result, Module.LENS_MASK, Section.LENS_MASK_INFO));
                    } else if (j.a(method, Method.GET_DETECTION_CONFIG.getValue())) {
                        settingCompositeV2.setMotionDetectionInfo(new MotionDetectionInfo(result));
                    } else if (j.a(method, Method.GET_ALERT_CONFIG.getValue())) {
                        settingCompositeV2.setAlarmInfo((AlarmInfo) Model.typeCast(result, Module.MSG_ALARM, Section.MSG_ALARM_INFO));
                    } else if (j.a(method, Method.GET_LINE_CROSSING_DETECTION_CONFIG.getValue())) {
                        settingCompositeV2.setLineCrossingDetectionInfo(new LineCrossingDetectionInfo(result));
                    } else if (j.a(method, Method.GET_INTRUSION_DETECTION_CONFIG.getValue())) {
                        settingCompositeV2.setIntrusionDetectionInfo(new IntrusionDetectionInfo(result));
                    } else if (j.a(method, Method.GET_TAMPER_DETECTION_CONFIG.getValue())) {
                        settingCompositeV2.setTamperDetectConfig((TamperDetectConfig) Model.typeCast(result, Module.TAMPER_DETECTION, Section.TAMPER_DET));
                    } else if (j.a(method, Method.GET_RECORD_PLAN.getValue())) {
                        settingCompositeV2.setRecordPlanInfo((RecordPlanInfo) Model.typeCast(result, Module.RECORD_PLAN, Section.CHN1_CHANNEL));
                    } else if (j.a(method, Method.GET_NIGHT_VISION_CAPABILITY.getValue())) {
                        settingCompositeV2.setNightVisionCapability((NightVisionCapability) Model.typeCast(result, Module.IMAGE_CAPABILITY, Section.SUPPLEMENT_LAMP));
                    } else if (j.a(method, Method.GET_BCD_CONFIG.getValue())) {
                        settingCompositeV2.setBabyCryDetectionInfo((BabyCryingDetectionInfo) Model.typeCast(result, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION));
                    } else if (j.a(method, Method.GET_PERSON_DETECTION_CONFIG.getValue())) {
                        settingCompositeV2.setHumanRecognitionInfo((HumanRecognitionInfo) Model.typeCast(result, Module.PEOPLE_DETECTION, Section.DETECTION));
                    }
                }
            }
            return settingCompositeV2;
        }
    }

    public SettingCompositeV2(LensMaskInfo lensMaskInfo, MotionDetectionInfo motionDetectionInfo, AlarmInfo alarmInfo, LineCrossingDetectionInfo lineCrossingDetectionInfo, IntrusionDetectionInfo intrusionDetectionInfo, TamperDetectConfig tamperDetectConfig, RecordPlanInfo recordPlanInfo, NightVisionCapability nightVisionCapability, BabyCryingDetectionInfo babyCryingDetectionInfo, HumanRecognitionInfo humanRecognitionInfo) {
        this.lensMaskInfo = lensMaskInfo;
        this.motionDetectionInfo = motionDetectionInfo;
        this.alarmInfo = alarmInfo;
        this.lineCrossingDetectionInfo = lineCrossingDetectionInfo;
        this.intrusionDetectionInfo = intrusionDetectionInfo;
        this.tamperDetectConfig = tamperDetectConfig;
        this.recordPlanInfo = recordPlanInfo;
        this.nightVisionCapability = nightVisionCapability;
        this.babyCryDetectionInfo = babyCryingDetectionInfo;
        this.humanRecognitionInfo = humanRecognitionInfo;
    }

    public final LensMaskInfo component1() {
        return this.lensMaskInfo;
    }

    public final HumanRecognitionInfo component10() {
        return this.humanRecognitionInfo;
    }

    public final MotionDetectionInfo component2() {
        return this.motionDetectionInfo;
    }

    public final AlarmInfo component3() {
        return this.alarmInfo;
    }

    public final LineCrossingDetectionInfo component4() {
        return this.lineCrossingDetectionInfo;
    }

    public final IntrusionDetectionInfo component5() {
        return this.intrusionDetectionInfo;
    }

    public final TamperDetectConfig component6() {
        return this.tamperDetectConfig;
    }

    public final RecordPlanInfo component7() {
        return this.recordPlanInfo;
    }

    public final NightVisionCapability component8() {
        return this.nightVisionCapability;
    }

    public final BabyCryingDetectionInfo component9() {
        return this.babyCryDetectionInfo;
    }

    public final SettingCompositeV2 copy(LensMaskInfo lensMaskInfo, MotionDetectionInfo motionDetectionInfo, AlarmInfo alarmInfo, LineCrossingDetectionInfo lineCrossingDetectionInfo, IntrusionDetectionInfo intrusionDetectionInfo, TamperDetectConfig tamperDetectConfig, RecordPlanInfo recordPlanInfo, NightVisionCapability nightVisionCapability, BabyCryingDetectionInfo babyCryingDetectionInfo, HumanRecognitionInfo humanRecognitionInfo) {
        return new SettingCompositeV2(lensMaskInfo, motionDetectionInfo, alarmInfo, lineCrossingDetectionInfo, intrusionDetectionInfo, tamperDetectConfig, recordPlanInfo, nightVisionCapability, babyCryingDetectionInfo, humanRecognitionInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingCompositeV2)) {
            return false;
        }
        SettingCompositeV2 settingCompositeV2 = (SettingCompositeV2) obj;
        return j.a(this.lensMaskInfo, settingCompositeV2.lensMaskInfo) && j.a(this.motionDetectionInfo, settingCompositeV2.motionDetectionInfo) && j.a(this.alarmInfo, settingCompositeV2.alarmInfo) && j.a(this.lineCrossingDetectionInfo, settingCompositeV2.lineCrossingDetectionInfo) && j.a(this.intrusionDetectionInfo, settingCompositeV2.intrusionDetectionInfo) && j.a(this.tamperDetectConfig, settingCompositeV2.tamperDetectConfig) && j.a(this.recordPlanInfo, settingCompositeV2.recordPlanInfo) && j.a(this.nightVisionCapability, settingCompositeV2.nightVisionCapability) && j.a(this.babyCryDetectionInfo, settingCompositeV2.babyCryDetectionInfo) && j.a(this.humanRecognitionInfo, settingCompositeV2.humanRecognitionInfo);
    }

    public final AlarmInfo getAlarmInfo() {
        return this.alarmInfo;
    }

    public final BabyCryingDetectionInfo getBabyCryDetectionInfo() {
        return this.babyCryDetectionInfo;
    }

    public final HumanRecognitionInfo getHumanRecognitionInfo() {
        return this.humanRecognitionInfo;
    }

    public final IntrusionDetectionInfo getIntrusionDetectionInfo() {
        return this.intrusionDetectionInfo;
    }

    public final LensMaskInfo getLensMaskInfo() {
        return this.lensMaskInfo;
    }

    public final LineCrossingDetectionInfo getLineCrossingDetectionInfo() {
        return this.lineCrossingDetectionInfo;
    }

    public final MotionDetectionInfo getMotionDetectionInfo() {
        return this.motionDetectionInfo;
    }

    public final NightVisionCapability getNightVisionCapability() {
        return this.nightVisionCapability;
    }

    public final RecordPlanInfo getRecordPlanInfo() {
        return this.recordPlanInfo;
    }

    public final TamperDetectConfig getTamperDetectConfig() {
        return this.tamperDetectConfig;
    }

    public int hashCode() {
        LensMaskInfo lensMaskInfo = this.lensMaskInfo;
        int i = 0;
        int hashCode = (lensMaskInfo != null ? lensMaskInfo.hashCode() : 0) * 31;
        MotionDetectionInfo motionDetectionInfo = this.motionDetectionInfo;
        int hashCode2 = (hashCode + (motionDetectionInfo != null ? motionDetectionInfo.hashCode() : 0)) * 31;
        AlarmInfo alarmInfo = this.alarmInfo;
        int hashCode3 = (hashCode2 + (alarmInfo != null ? alarmInfo.hashCode() : 0)) * 31;
        LineCrossingDetectionInfo lineCrossingDetectionInfo = this.lineCrossingDetectionInfo;
        int hashCode4 = (hashCode3 + (lineCrossingDetectionInfo != null ? lineCrossingDetectionInfo.hashCode() : 0)) * 31;
        IntrusionDetectionInfo intrusionDetectionInfo = this.intrusionDetectionInfo;
        int hashCode5 = (hashCode4 + (intrusionDetectionInfo != null ? intrusionDetectionInfo.hashCode() : 0)) * 31;
        TamperDetectConfig tamperDetectConfig = this.tamperDetectConfig;
        int hashCode6 = (hashCode5 + (tamperDetectConfig != null ? tamperDetectConfig.hashCode() : 0)) * 31;
        RecordPlanInfo recordPlanInfo = this.recordPlanInfo;
        int hashCode7 = (hashCode6 + (recordPlanInfo != null ? recordPlanInfo.hashCode() : 0)) * 31;
        NightVisionCapability nightVisionCapability = this.nightVisionCapability;
        int hashCode8 = (hashCode7 + (nightVisionCapability != null ? nightVisionCapability.hashCode() : 0)) * 31;
        BabyCryingDetectionInfo babyCryingDetectionInfo = this.babyCryDetectionInfo;
        int hashCode9 = (hashCode8 + (babyCryingDetectionInfo != null ? babyCryingDetectionInfo.hashCode() : 0)) * 31;
        HumanRecognitionInfo humanRecognitionInfo = this.humanRecognitionInfo;
        if (humanRecognitionInfo != null) {
            i = humanRecognitionInfo.hashCode();
        }
        return hashCode9 + i;
    }

    public final void setAlarmInfo(AlarmInfo alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public final void setBabyCryDetectionInfo(BabyCryingDetectionInfo babyCryingDetectionInfo) {
        this.babyCryDetectionInfo = babyCryingDetectionInfo;
    }

    public final void setHumanRecognitionInfo(HumanRecognitionInfo humanRecognitionInfo) {
        this.humanRecognitionInfo = humanRecognitionInfo;
    }

    public final void setIntrusionDetectionInfo(IntrusionDetectionInfo intrusionDetectionInfo) {
        this.intrusionDetectionInfo = intrusionDetectionInfo;
    }

    public final void setLensMaskInfo(LensMaskInfo lensMaskInfo) {
        this.lensMaskInfo = lensMaskInfo;
    }

    public final void setLineCrossingDetectionInfo(LineCrossingDetectionInfo lineCrossingDetectionInfo) {
        this.lineCrossingDetectionInfo = lineCrossingDetectionInfo;
    }

    public final void setMotionDetectionInfo(MotionDetectionInfo motionDetectionInfo) {
        this.motionDetectionInfo = motionDetectionInfo;
    }

    public final void setNightVisionCapability(NightVisionCapability nightVisionCapability) {
        this.nightVisionCapability = nightVisionCapability;
    }

    public final void setRecordPlanInfo(RecordPlanInfo recordPlanInfo) {
        this.recordPlanInfo = recordPlanInfo;
    }

    public final void setTamperDetectConfig(TamperDetectConfig tamperDetectConfig) {
        this.tamperDetectConfig = tamperDetectConfig;
    }

    public String toString() {
        return "SettingCompositeV2(lensMaskInfo=" + this.lensMaskInfo + ", motionDetectionInfo=" + this.motionDetectionInfo + ", alarmInfo=" + this.alarmInfo + ", lineCrossingDetectionInfo=" + this.lineCrossingDetectionInfo + ", intrusionDetectionInfo=" + this.intrusionDetectionInfo + ", tamperDetectConfig=" + this.tamperDetectConfig + ", recordPlanInfo=" + this.recordPlanInfo + ", nightVisionCapability=" + this.nightVisionCapability + ", babyCryDetectionInfo=" + this.babyCryDetectionInfo + ", humanRecognitionInfo=" + this.humanRecognitionInfo + ")";
    }
}
