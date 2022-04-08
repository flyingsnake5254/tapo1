package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class SettingComposite {
    public static final Companion Companion = new Companion(null);
    private AccountInfo accountInfo;
    private CameraInfo cameraInfo;
    private HardDiskInfo hardDiskInfo;
    private HardDiskLoop hardDiskLoop;
    private ImageFlip imageFlip;
    private LedStatus ledStatus;
    private ServiceList needPayServiceList;
    private RebootInfo rebootInfo;
    private Timezone timezone;
    private VideoCapability videoCapability;
    private VideoQuality videoQuality;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<SettingComposite> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public SettingComposite fromMultipleResponse(MultipleResponse response) {
            HardDiskInfo hardDiskInfo;
            int l;
            j.e(response, "response");
            SettingComposite settingComposite = new SettingComposite(null, null, null, null, null, null, null, null, null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_CIRCULAR_RECORDING_CONFIG.getValue())) {
                        settingComposite.setHardDiskLoop((HardDiskLoop) Model.typeCast(result, Module.HARD_DISK_MANAGE, Section.HARD_DISK_LOOP));
                    } else if (j.a(method, Method.GET_SD_CARD_STATUS.getValue())) {
                        List<Map> list = (List) Model.typeCast(result, Module.HARD_DISK_MANAGE, Section.HARD_DISK_INFO);
                        if (list != null) {
                            l = o.l(list, 10);
                            ArrayList arrayList = new ArrayList(l);
                            for (Map map : list) {
                                arrayList.add((HardDiskInfo) l.w(map.values()));
                            }
                            hardDiskInfo = (HardDiskInfo) l.x(arrayList);
                        } else {
                            hardDiskInfo = null;
                        }
                        settingComposite.setHardDiskInfo(hardDiskInfo);
                    } else if (j.a(method, Method.GET_TIMEZONE.getValue())) {
                        settingComposite.setTimezone((Timezone) Model.typeCast(result, Module.SYSTEM, Section.BASIC));
                    } else if (j.a(method, Method.GET_LED_STATUS.getValue())) {
                        settingComposite.setLedStatus((LedStatus) Model.typeCast(result, Module.LED, Section.CONFIG));
                    } else if (j.a(method, Method.GET_ROTATION_STATUS.getValue())) {
                        settingComposite.setImageFlip((ImageFlip) Model.typeCast(result, Module.IMAGE, Section.IMAGE_SWITCH));
                    } else if (j.a(method, Method.GET_REBOOT.getValue())) {
                        settingComposite.setRebootInfo((RebootInfo) Model.typeCast(result, Module.TIMING_REBOOT, Section.REBOOT));
                    } else if (j.a(method, Method.GET_DEVICE_INFO.getValue())) {
                        settingComposite.setCameraInfo(new CameraInfo(result));
                    } else if (j.a(method, Method.GET_VIDEO_QUALITIES.getValue())) {
                        settingComposite.setVideoQuality((VideoQuality) Model.typeCast(result, Module.VIDEO, Section.VIDEO_MAIN));
                    } else if (j.a(method, Method.GET_VIDEO_CAPABILITY.getValue())) {
                        settingComposite.setVideoCapability((VideoCapability) Model.typeCast(result, Module.VIDEO_CAPABILITY, Section.VIDEO_MAIN));
                    } else if (j.a(method, Method.GET_TAPO_CARE_SERVICE_LIST.getValue())) {
                        settingComposite.setNeedPayServiceList((ServiceList) Model.typeCast(result, Module.TAPO_CARE, Section.SERVICE_LIST));
                    }
                }
            }
            return settingComposite;
        }
    }

    public SettingComposite(HardDiskLoop hardDiskLoop, HardDiskInfo hardDiskInfo, Timezone timezone, AccountInfo accountInfo, LedStatus ledStatus, ImageFlip imageFlip, RebootInfo rebootInfo, CameraInfo cameraInfo, VideoQuality videoQuality, VideoCapability videoCapability, ServiceList serviceList) {
        this.hardDiskLoop = hardDiskLoop;
        this.hardDiskInfo = hardDiskInfo;
        this.timezone = timezone;
        this.accountInfo = accountInfo;
        this.ledStatus = ledStatus;
        this.imageFlip = imageFlip;
        this.rebootInfo = rebootInfo;
        this.cameraInfo = cameraInfo;
        this.videoQuality = videoQuality;
        this.videoCapability = videoCapability;
        this.needPayServiceList = serviceList;
    }

    public final HardDiskLoop component1() {
        return this.hardDiskLoop;
    }

    public final VideoCapability component10() {
        return this.videoCapability;
    }

    public final ServiceList component11() {
        return this.needPayServiceList;
    }

    public final HardDiskInfo component2() {
        return this.hardDiskInfo;
    }

    public final Timezone component3() {
        return this.timezone;
    }

    public final AccountInfo component4() {
        return this.accountInfo;
    }

    public final LedStatus component5() {
        return this.ledStatus;
    }

    public final ImageFlip component6() {
        return this.imageFlip;
    }

    public final RebootInfo component7() {
        return this.rebootInfo;
    }

    public final CameraInfo component8() {
        return this.cameraInfo;
    }

    public final VideoQuality component9() {
        return this.videoQuality;
    }

    public final SettingComposite copy(HardDiskLoop hardDiskLoop, HardDiskInfo hardDiskInfo, Timezone timezone, AccountInfo accountInfo, LedStatus ledStatus, ImageFlip imageFlip, RebootInfo rebootInfo, CameraInfo cameraInfo, VideoQuality videoQuality, VideoCapability videoCapability, ServiceList serviceList) {
        return new SettingComposite(hardDiskLoop, hardDiskInfo, timezone, accountInfo, ledStatus, imageFlip, rebootInfo, cameraInfo, videoQuality, videoCapability, serviceList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingComposite)) {
            return false;
        }
        SettingComposite settingComposite = (SettingComposite) obj;
        return j.a(this.hardDiskLoop, settingComposite.hardDiskLoop) && j.a(this.hardDiskInfo, settingComposite.hardDiskInfo) && j.a(this.timezone, settingComposite.timezone) && j.a(this.accountInfo, settingComposite.accountInfo) && j.a(this.ledStatus, settingComposite.ledStatus) && j.a(this.imageFlip, settingComposite.imageFlip) && j.a(this.rebootInfo, settingComposite.rebootInfo) && j.a(this.cameraInfo, settingComposite.cameraInfo) && j.a(this.videoQuality, settingComposite.videoQuality) && j.a(this.videoCapability, settingComposite.videoCapability) && j.a(this.needPayServiceList, settingComposite.needPayServiceList);
    }

    public final AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public final CameraInfo getCameraInfo() {
        return this.cameraInfo;
    }

    public final HardDiskInfo getHardDiskInfo() {
        return this.hardDiskInfo;
    }

    public final HardDiskLoop getHardDiskLoop() {
        return this.hardDiskLoop;
    }

    public final ImageFlip getImageFlip() {
        return this.imageFlip;
    }

    public final LedStatus getLedStatus() {
        return this.ledStatus;
    }

    public final ServiceList getNeedPayServiceList() {
        return this.needPayServiceList;
    }

    public final RebootInfo getRebootInfo() {
        return this.rebootInfo;
    }

    public final Timezone getTimezone() {
        return this.timezone;
    }

    public final VideoCapability getVideoCapability() {
        return this.videoCapability;
    }

    public final VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public int hashCode() {
        HardDiskLoop hardDiskLoop = this.hardDiskLoop;
        int i = 0;
        int hashCode = (hardDiskLoop != null ? hardDiskLoop.hashCode() : 0) * 31;
        HardDiskInfo hardDiskInfo = this.hardDiskInfo;
        int hashCode2 = (hashCode + (hardDiskInfo != null ? hardDiskInfo.hashCode() : 0)) * 31;
        Timezone timezone = this.timezone;
        int hashCode3 = (hashCode2 + (timezone != null ? timezone.hashCode() : 0)) * 31;
        AccountInfo accountInfo = this.accountInfo;
        int hashCode4 = (hashCode3 + (accountInfo != null ? accountInfo.hashCode() : 0)) * 31;
        LedStatus ledStatus = this.ledStatus;
        int hashCode5 = (hashCode4 + (ledStatus != null ? ledStatus.hashCode() : 0)) * 31;
        ImageFlip imageFlip = this.imageFlip;
        int hashCode6 = (hashCode5 + (imageFlip != null ? imageFlip.hashCode() : 0)) * 31;
        RebootInfo rebootInfo = this.rebootInfo;
        int hashCode7 = (hashCode6 + (rebootInfo != null ? rebootInfo.hashCode() : 0)) * 31;
        CameraInfo cameraInfo = this.cameraInfo;
        int hashCode8 = (hashCode7 + (cameraInfo != null ? cameraInfo.hashCode() : 0)) * 31;
        VideoQuality videoQuality = this.videoQuality;
        int hashCode9 = (hashCode8 + (videoQuality != null ? videoQuality.hashCode() : 0)) * 31;
        VideoCapability videoCapability = this.videoCapability;
        int hashCode10 = (hashCode9 + (videoCapability != null ? videoCapability.hashCode() : 0)) * 31;
        ServiceList serviceList = this.needPayServiceList;
        if (serviceList != null) {
            i = serviceList.hashCode();
        }
        return hashCode10 + i;
    }

    public final void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public final void setCameraInfo(CameraInfo cameraInfo) {
        this.cameraInfo = cameraInfo;
    }

    public final void setHardDiskInfo(HardDiskInfo hardDiskInfo) {
        this.hardDiskInfo = hardDiskInfo;
    }

    public final void setHardDiskLoop(HardDiskLoop hardDiskLoop) {
        this.hardDiskLoop = hardDiskLoop;
    }

    public final void setImageFlip(ImageFlip imageFlip) {
        this.imageFlip = imageFlip;
    }

    public final void setLedStatus(LedStatus ledStatus) {
        this.ledStatus = ledStatus;
    }

    public final void setNeedPayServiceList(ServiceList serviceList) {
        this.needPayServiceList = serviceList;
    }

    public final void setRebootInfo(RebootInfo rebootInfo) {
        this.rebootInfo = rebootInfo;
    }

    public final void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public final void setVideoCapability(VideoCapability videoCapability) {
        this.videoCapability = videoCapability;
    }

    public final void setVideoQuality(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    public String toString() {
        return "SettingComposite(hardDiskLoop=" + this.hardDiskLoop + ", hardDiskInfo=" + this.hardDiskInfo + ", timezone=" + this.timezone + ", accountInfo=" + this.accountInfo + ", ledStatus=" + this.ledStatus + ", imageFlip=" + this.imageFlip + ", rebootInfo=" + this.rebootInfo + ", cameraInfo=" + this.cameraInfo + ", videoQuality=" + this.videoQuality + ", videoCapability=" + this.videoCapability + ", needPayServiceList=" + this.needPayServiceList + ")";
    }
}
