package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class ImageFlip {
    @c("flip_type")
    private final String flipType;
    @c("force_wtl_state")
    private final String forceWtlState;
    @c("ldc")
    private final String ldc;
    @c("night_vision_mode")
    private final String nightVisionMode;
    @c("rotate_type")
    private final String rotateType;
    @c("schedule_end_time")
    private final Integer scheduleEndTime;
    @c("schedule_start_time")
    private final Integer scheduleStartTime;
    @c("switch_mode")
    private final String switchMode;
    @c("wtl_intensity_level")
    private final String wtlIntensityLevel;

    public ImageFlip(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.switchMode = str;
        this.scheduleStartTime = num;
        this.scheduleEndTime = num2;
        this.flipType = str2;
        this.rotateType = str3;
        this.ldc = str4;
        this.nightVisionMode = str5;
        this.wtlIntensityLevel = str6;
        this.forceWtlState = str7;
    }

    public final String component1() {
        return this.switchMode;
    }

    public final Integer component2() {
        return this.scheduleStartTime;
    }

    public final Integer component3() {
        return this.scheduleEndTime;
    }

    public final String component4() {
        return this.flipType;
    }

    public final String component5() {
        return this.rotateType;
    }

    public final String component6() {
        return this.ldc;
    }

    public final String component7() {
        return this.nightVisionMode;
    }

    public final String component8() {
        return this.wtlIntensityLevel;
    }

    public final String component9() {
        return this.forceWtlState;
    }

    public final ImageFlip copy(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new ImageFlip(str, num, num2, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFlip)) {
            return false;
        }
        ImageFlip imageFlip = (ImageFlip) obj;
        return j.a(this.switchMode, imageFlip.switchMode) && j.a(this.scheduleStartTime, imageFlip.scheduleStartTime) && j.a(this.scheduleEndTime, imageFlip.scheduleEndTime) && j.a(this.flipType, imageFlip.flipType) && j.a(this.rotateType, imageFlip.rotateType) && j.a(this.ldc, imageFlip.ldc) && j.a(this.nightVisionMode, imageFlip.nightVisionMode) && j.a(this.wtlIntensityLevel, imageFlip.wtlIntensityLevel) && j.a(this.forceWtlState, imageFlip.forceWtlState);
    }

    public final String getFlipType() {
        return this.flipType;
    }

    public final String getForceWtlState() {
        return this.forceWtlState;
    }

    public final String getLdc() {
        return this.ldc;
    }

    public final String getNightVisionMode() {
        return this.nightVisionMode;
    }

    public final NightVisionModeType getNightVisionModeType() {
        return NightVisionModeType.Companion.fromString(this.nightVisionMode);
    }

    public final String getRotateType() {
        return this.rotateType;
    }

    public final Integer getScheduleEndTime() {
        return this.scheduleEndTime;
    }

    public final Integer getScheduleStartTime() {
        return this.scheduleStartTime;
    }

    public final String getSwitchMode() {
        return this.switchMode;
    }

    public final String getWtlIntensityLevel() {
        return this.wtlIntensityLevel;
    }

    public int hashCode() {
        String str = this.switchMode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.scheduleStartTime;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.scheduleEndTime;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.flipType;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rotateType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ldc;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nightVisionMode;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.wtlIntensityLevel;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.forceWtlState;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode8 + i;
    }

    public final boolean isWhiteLampOn() {
        return j.a(this.forceWtlState, "on");
    }

    public String toString() {
        return "ImageFlip(switchMode=" + this.switchMode + ", scheduleStartTime=" + this.scheduleStartTime + ", scheduleEndTime=" + this.scheduleEndTime + ", flipType=" + this.flipType + ", rotateType=" + this.rotateType + ", ldc=" + this.ldc + ", nightVisionMode=" + this.nightVisionMode + ", wtlIntensityLevel=" + this.wtlIntensityLevel + ", forceWtlState=" + this.forceWtlState + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageFlip(String ldc) {
        this(null, null, null, null, null, ldc, null, null, null);
        j.e(ldc, "ldc");
    }

    public ImageFlip(boolean z) {
        this(null, null, null, z ? "center" : "off", null, null, null, null, null);
    }

    public ImageFlip(int i) {
        this(null, null, null, null, null, null, null, String.valueOf(i), null);
    }
}
