package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class DetectionSetting {
    public static final Companion Companion = new Companion(null);
    private AlarmInfo alarmInfo;
    private BabyCryingDetectionInfo babyCryDetectionInfo;
    private HumanRecognitionInfo humanRecognitionInfo;
    private MsgPushInfo msgPushInfo;
    private TargetTrackInfo targetTrackInfo;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<DetectionSetting> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public DetectionSetting fromMultipleResponse(MultipleResponse response) {
            j.e(response, "response");
            DetectionSetting detectionSetting = new DetectionSetting(null, null, null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_ALERT_CONFIG.getValue())) {
                        detectionSetting.setAlarmInfo((AlarmInfo) Model.typeCast(result, Module.MSG_ALARM, Section.MSG_ALARM_INFO));
                    } else if (j.a(method, Method.GET_MSG_PUSH_CONFIG.getValue())) {
                        detectionSetting.setMsgPushInfo((MsgPushInfo) Model.typeCast(result, Module.MSG_PUSH, Section.MSG_PUSH_INFO));
                    } else if (j.a(method, Method.GET_PERSON_DETECTION_CONFIG.getValue())) {
                        detectionSetting.setHumanRecognitionInfo((HumanRecognitionInfo) Model.typeCast(result, Module.PEOPLE_DETECTION, Section.DETECTION));
                    } else if (j.a(method, Method.GET_BCD_CONFIG.getValue())) {
                        detectionSetting.setBabyCryDetectionInfo((BabyCryingDetectionInfo) Model.typeCast(result, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION));
                    } else if (j.a(method, Method.GET_TARGET_TRACK_CONFIG.getValue())) {
                        detectionSetting.setTargetTrackInfo((TargetTrackInfo) Model.typeCast(result, Module.TARGET_TRACK, Section.TARGET_TRACK_INFO));
                    }
                }
            }
            return detectionSetting;
        }
    }

    public DetectionSetting(AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo) {
        this.alarmInfo = alarmInfo;
        this.msgPushInfo = msgPushInfo;
        this.humanRecognitionInfo = humanRecognitionInfo;
        this.babyCryDetectionInfo = babyCryingDetectionInfo;
        this.targetTrackInfo = targetTrackInfo;
    }

    public static /* synthetic */ DetectionSetting copy$default(DetectionSetting detectionSetting, AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            alarmInfo = detectionSetting.alarmInfo;
        }
        if ((i & 2) != 0) {
            msgPushInfo = detectionSetting.msgPushInfo;
        }
        if ((i & 4) != 0) {
            humanRecognitionInfo = detectionSetting.humanRecognitionInfo;
        }
        if ((i & 8) != 0) {
            babyCryingDetectionInfo = detectionSetting.babyCryDetectionInfo;
        }
        if ((i & 16) != 0) {
            targetTrackInfo = detectionSetting.targetTrackInfo;
        }
        return detectionSetting.copy(alarmInfo, msgPushInfo, humanRecognitionInfo, babyCryingDetectionInfo, targetTrackInfo);
    }

    public final AlarmInfo component1() {
        return this.alarmInfo;
    }

    public final MsgPushInfo component2() {
        return this.msgPushInfo;
    }

    public final HumanRecognitionInfo component3() {
        return this.humanRecognitionInfo;
    }

    public final BabyCryingDetectionInfo component4() {
        return this.babyCryDetectionInfo;
    }

    public final TargetTrackInfo component5() {
        return this.targetTrackInfo;
    }

    public final DetectionSetting copy(AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo) {
        return new DetectionSetting(alarmInfo, msgPushInfo, humanRecognitionInfo, babyCryingDetectionInfo, targetTrackInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetectionSetting)) {
            return false;
        }
        DetectionSetting detectionSetting = (DetectionSetting) obj;
        return j.a(this.alarmInfo, detectionSetting.alarmInfo) && j.a(this.msgPushInfo, detectionSetting.msgPushInfo) && j.a(this.humanRecognitionInfo, detectionSetting.humanRecognitionInfo) && j.a(this.babyCryDetectionInfo, detectionSetting.babyCryDetectionInfo) && j.a(this.targetTrackInfo, detectionSetting.targetTrackInfo);
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

    public final MsgPushInfo getMsgPushInfo() {
        return this.msgPushInfo;
    }

    public final TargetTrackInfo getTargetTrackInfo() {
        return this.targetTrackInfo;
    }

    public int hashCode() {
        AlarmInfo alarmInfo = this.alarmInfo;
        int i = 0;
        int hashCode = (alarmInfo != null ? alarmInfo.hashCode() : 0) * 31;
        MsgPushInfo msgPushInfo = this.msgPushInfo;
        int hashCode2 = (hashCode + (msgPushInfo != null ? msgPushInfo.hashCode() : 0)) * 31;
        HumanRecognitionInfo humanRecognitionInfo = this.humanRecognitionInfo;
        int hashCode3 = (hashCode2 + (humanRecognitionInfo != null ? humanRecognitionInfo.hashCode() : 0)) * 31;
        BabyCryingDetectionInfo babyCryingDetectionInfo = this.babyCryDetectionInfo;
        int hashCode4 = (hashCode3 + (babyCryingDetectionInfo != null ? babyCryingDetectionInfo.hashCode() : 0)) * 31;
        TargetTrackInfo targetTrackInfo = this.targetTrackInfo;
        if (targetTrackInfo != null) {
            i = targetTrackInfo.hashCode();
        }
        return hashCode4 + i;
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

    public final void setMsgPushInfo(MsgPushInfo msgPushInfo) {
        this.msgPushInfo = msgPushInfo;
    }

    public final void setTargetTrackInfo(TargetTrackInfo targetTrackInfo) {
        this.targetTrackInfo = targetTrackInfo;
    }

    public String toString() {
        return "DetectionSetting(alarmInfo=" + this.alarmInfo + ", msgPushInfo=" + this.msgPushInfo + ", humanRecognitionInfo=" + this.humanRecognitionInfo + ", babyCryDetectionInfo=" + this.babyCryDetectionInfo + ", targetTrackInfo=" + this.targetTrackInfo + ")";
    }
}
