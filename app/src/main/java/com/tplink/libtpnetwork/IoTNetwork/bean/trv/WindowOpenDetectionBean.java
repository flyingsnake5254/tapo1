package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: WindowOpenDetectionBean.kt */
/* loaded from: classes3.dex */
public final class WindowOpenDetectionBean {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_DOWN_TEMP_CELSIUS = 3;
    public static final int DEFAULT_DOWN_TEMP_FAHRENHEIT = 5;
    public static final int DEFAULT_OPEN_TIME = 15;
    public static final int DEFAULT_SHUTOFF_DURATION = 30;
    @c("down_temp")
    private int downTemp;
    private boolean enable;
    @c("open_time")
    private int openTime;
    @c("shutoff_duration")
    private int shutoffDuration;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    /* compiled from: WindowOpenDetectionBean.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumTemperatureUnit.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EnumTemperatureUnit.CELSIUS.ordinal()] = 1;
            iArr[EnumTemperatureUnit.FAHRENHEIT.ordinal()] = 2;
        }
    }

    public WindowOpenDetectionBean(int i, int i2, String str, boolean z, int i3) {
        this.openTime = i;
        this.downTemp = i2;
        this.tempUnit = str;
        this.enable = z;
        this.shutoffDuration = i3;
    }

    public static /* synthetic */ WindowOpenDetectionBean copy$default(WindowOpenDetectionBean windowOpenDetectionBean, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = windowOpenDetectionBean.openTime;
        }
        if ((i4 & 2) != 0) {
            i2 = windowOpenDetectionBean.downTemp;
        }
        if ((i4 & 4) != 0) {
            str = windowOpenDetectionBean.tempUnit;
        }
        if ((i4 & 8) != 0) {
            z = windowOpenDetectionBean.enable;
        }
        if ((i4 & 16) != 0) {
            i3 = windowOpenDetectionBean.shutoffDuration;
        }
        return windowOpenDetectionBean.copy(i, i2, str, z, i3);
    }

    public final int component1() {
        return this.openTime;
    }

    public final int component2() {
        return this.downTemp;
    }

    public final String component3() {
        return this.tempUnit;
    }

    public final boolean component4() {
        return this.enable;
    }

    public final int component5() {
        return this.shutoffDuration;
    }

    public final WindowOpenDetectionBean copy(int i, int i2, String str, boolean z, int i3) {
        return new WindowOpenDetectionBean(i, i2, str, z, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowOpenDetectionBean)) {
            return false;
        }
        WindowOpenDetectionBean windowOpenDetectionBean = (WindowOpenDetectionBean) obj;
        return this.openTime == windowOpenDetectionBean.openTime && this.downTemp == windowOpenDetectionBean.downTemp && j.a(this.tempUnit, windowOpenDetectionBean.tempUnit) && this.enable == windowOpenDetectionBean.enable && this.shutoffDuration == windowOpenDetectionBean.shutoffDuration;
    }

    public final int getDownTemp() {
        return this.downTemp;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getOpenTime() {
        return this.openTime;
    }

    public final int getShutoffDuration() {
        return this.shutoffDuration;
    }

    public final String getTempUnit() {
        return this.tempUnit;
    }

    public int hashCode() {
        int i = ((this.openTime * 31) + this.downTemp) * 31;
        String str = this.tempUnit;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.enable;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        return ((hashCode + i2) * 31) + this.shutoffDuration;
    }

    public final void setDownTemp(int i) {
        this.downTemp = i;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setOpenTime(int i) {
        this.openTime = i;
    }

    public final void setShutoffDuration(int i) {
        this.shutoffDuration = i;
    }

    public final void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public String toString() {
        return "WindowOpenDetectionBean(openTime=" + this.openTime + ", downTemp=" + this.downTemp + ", tempUnit=" + this.tempUnit + ", enable=" + this.enable + ", shutoffDuration=" + this.shutoffDuration + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WindowOpenDetectionBean(boolean r8, com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit r9, int r10) {
        /*
            r7 = this;
            java.lang.String r0 = "enumTempUnit"
            kotlin.jvm.internal.j.e(r9, r0)
            int[] r0 = com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean.WhenMappings.$EnumSwitchMapping$0
            int r1 = r9.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 2
            if (r0 != r1) goto L_0x0016
            r0 = 5
            r3 = 5
            goto L_0x001e
        L_0x0016:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x001c:
            r0 = 3
            r3 = 3
        L_0x001e:
            java.lang.String r4 = r9.getValue()
            r2 = 15
            r1 = r7
            r5 = r8
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean.<init>(boolean, com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit, int):void");
    }
}
