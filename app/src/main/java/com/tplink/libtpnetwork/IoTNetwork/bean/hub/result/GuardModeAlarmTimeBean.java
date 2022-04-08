package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: GuardModeConfigBean.kt */
/* loaded from: classes3.dex */
public final class GuardModeAlarmTimeBean {
    public static final Companion Companion = new Companion(null);
    private static final GuardModeAlarmTimeBean DEFAULT = new GuardModeAlarmTimeBean(EnumGuardModeAlarmTimeType.CUSTOM_TIME.getValue(), 300);
    public static final int DEFAULT_ALARM_TIME_IN_SEC = 300;
    private int time;
    private String type;

    /* compiled from: GuardModeConfigBean.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public final GuardModeAlarmTimeBean getDefault() {
            return new GuardModeAlarmTimeBean(GuardModeAlarmTimeBean.DEFAULT.getType(), GuardModeAlarmTimeBean.DEFAULT.getTime());
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public GuardModeAlarmTimeBean(String type, int i) {
        j.e(type, "type");
        this.type = type;
        this.time = i;
    }

    public static /* synthetic */ GuardModeAlarmTimeBean copy$default(GuardModeAlarmTimeBean guardModeAlarmTimeBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = guardModeAlarmTimeBean.type;
        }
        if ((i2 & 2) != 0) {
            i = guardModeAlarmTimeBean.time;
        }
        return guardModeAlarmTimeBean.copy(str, i);
    }

    public static final GuardModeAlarmTimeBean getDefault() {
        return Companion.getDefault();
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.time;
    }

    public final GuardModeAlarmTimeBean copy(String type, int i) {
        j.e(type, "type");
        return new GuardModeAlarmTimeBean(type, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuardModeAlarmTimeBean)) {
            return false;
        }
        GuardModeAlarmTimeBean guardModeAlarmTimeBean = (GuardModeAlarmTimeBean) obj;
        return j.a(this.type, guardModeAlarmTimeBean.type) && this.time == guardModeAlarmTimeBean.time;
    }

    public final EnumGuardModeAlarmTimeType getEnumType() {
        String str = this.type;
        EnumGuardModeAlarmTimeType enumGuardModeAlarmTimeType = EnumGuardModeAlarmTimeType.ALWAYS;
        if (j.a(str, enumGuardModeAlarmTimeType.getValue())) {
            return enumGuardModeAlarmTimeType;
        }
        EnumGuardModeAlarmTimeType enumGuardModeAlarmTimeType2 = EnumGuardModeAlarmTimeType.CUSTOM_TIME;
        return j.a(str, enumGuardModeAlarmTimeType2.getValue()) ? enumGuardModeAlarmTimeType2 : enumGuardModeAlarmTimeType;
    }

    public final int getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        return ((str != null ? str.hashCode() : 0) * 31) + this.time;
    }

    public final void setTime(int i) {
        this.time = i;
    }

    public final void setType(String str) {
        j.e(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "GuardModeAlarmTimeBean(type=" + this.type + ", time=" + this.time + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GuardModeAlarmTimeBean() {
        /*
            r2 = this;
            com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean r0 = com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean.DEFAULT
            java.lang.String r1 = r0.type
            int r0 = r0.time
            r2.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean.<init>():void");
    }
}
