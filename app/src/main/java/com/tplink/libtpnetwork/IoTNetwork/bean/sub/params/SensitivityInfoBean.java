package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

import com.google.gson.q.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.j;

/* compiled from: SensitivityInfoBean.kt */
/* loaded from: classes3.dex */
public final class SensitivityInfoBean {
    @c("report_interval")
    private Integer reportInterval;
    private String sensitivity;

    /* compiled from: SensitivityInfoBean.kt */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SensorSensitivity {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String HIGH = "high";
        public static final String LOW = "low";
        public static final String NORMAL = "normal";

        /* compiled from: SensitivityInfoBean.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String HIGH = "high";
            public static final String LOW = "low";
            public static final String NORMAL = "normal";

            private Companion() {
            }
        }
    }

    public SensitivityInfoBean(String str, Integer num) {
        this.sensitivity = str;
        this.reportInterval = num;
    }

    public static /* synthetic */ SensitivityInfoBean copy$default(SensitivityInfoBean sensitivityInfoBean, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sensitivityInfoBean.sensitivity;
        }
        if ((i & 2) != 0) {
            num = sensitivityInfoBean.reportInterval;
        }
        return sensitivityInfoBean.copy(str, num);
    }

    public final String component1() {
        return this.sensitivity;
    }

    public final Integer component2() {
        return this.reportInterval;
    }

    public final SensitivityInfoBean copy(String str, Integer num) {
        return new SensitivityInfoBean(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SensitivityInfoBean)) {
            return false;
        }
        SensitivityInfoBean sensitivityInfoBean = (SensitivityInfoBean) obj;
        return j.a(this.sensitivity, sensitivityInfoBean.sensitivity) && j.a(this.reportInterval, sensitivityInfoBean.reportInterval);
    }

    public final Integer getReportInterval() {
        return this.reportInterval;
    }

    public final String getSensitivity() {
        return this.sensitivity;
    }

    public int hashCode() {
        String str = this.sensitivity;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.reportInterval;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public final void setReportInterval(Integer num) {
        this.reportInterval = num;
    }

    public final void setSensitivity(String str) {
        this.sensitivity = str;
    }

    public String toString() {
        return "SensitivityInfoBean(sensitivity=" + this.sensitivity + ", reportInterval=" + this.reportInterval + ")";
    }
}
