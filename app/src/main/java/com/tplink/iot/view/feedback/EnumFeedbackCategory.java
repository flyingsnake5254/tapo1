package com.tplink.iot.view.feedback;

import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* JADX WARN: Init of enum BULB can be incorrect */
/* JADX WARN: Init of enum BUTTON can be incorrect */
/* JADX WARN: Init of enum CONTACT_SENSOR can be incorrect */
/* JADX WARN: Init of enum LIGHT_STRIP can be incorrect */
/* JADX WARN: Init of enum MOTION_SENSOR can be incorrect */
/* compiled from: EnumFeedbackCategory.kt */
/* loaded from: classes2.dex */
public enum EnumFeedbackCategory {
    CAMERA(EnumDeviceType.CAMERA, null, 2, null),
    PLUG(EnumDeviceType.PLUG, null, 2, null),
    BULB(r2, null, 2, null),
    LIGHT_STRIP(r2, "FEEDBACK.LIGHT_STRIP"),
    HUB(EnumDeviceType.HUB, null, 2, null),
    MOTION_SENSOR(r2, "FEEDBACK.MOTION_SENSOR"),
    CONTACT_SENSOR(r2, "FEEDBACK.CONTACT_SENSOR"),
    BUTTON(r2, "FEEDBACK.BUTTON"),
    SWITCH(EnumDeviceType.SWITCH, null, 2, null),
    TRV(EnumDeviceType.ENERGY, "FEEDBACK.TRV"),
    OTHER(EnumDeviceType.UNKNOWN, null, 2, null);
    
    public static final a Companion = new a(null);
    private final EnumDeviceType deviceType;
    private final String value;

    /* compiled from: EnumFeedbackCategory.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final EnumFeedbackCategory a(String str) {
            EnumFeedbackCategory[] values;
            for (EnumFeedbackCategory enumFeedbackCategory : EnumFeedbackCategory.values()) {
                if (j.a(enumFeedbackCategory.getValue(), str)) {
                    return enumFeedbackCategory;
                }
            }
            return EnumFeedbackCategory.OTHER;
        }

        public final EnumFeedbackCategory b(String str) {
            EnumFeedbackCategory[] values;
            EnumDeviceType fromType = EnumDeviceType.fromType(str);
            for (EnumFeedbackCategory enumFeedbackCategory : EnumFeedbackCategory.values()) {
                if (enumFeedbackCategory.getDeviceType() == fromType) {
                    return enumFeedbackCategory;
                }
            }
            return EnumFeedbackCategory.OTHER;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        EnumDeviceType enumDeviceType = EnumDeviceType.BULB;
        EnumDeviceType enumDeviceType2 = EnumDeviceType.SENSOR;
    }

    EnumFeedbackCategory(EnumDeviceType enumDeviceType, String str) {
        this.deviceType = enumDeviceType;
        this.value = str;
    }

    public static final EnumFeedbackCategory fromCategory(String str) {
        return Companion.a(str);
    }

    public static final EnumFeedbackCategory fromDeviceType(String str) {
        return Companion.b(str);
    }

    public final EnumDeviceType getDeviceType() {
        return this.deviceType;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /* synthetic */ EnumFeedbackCategory(com.tplink.libtpnetwork.enumerate.EnumDeviceType r3, java.lang.String r4, int r5, kotlin.jvm.internal.f r6) {
        /*
            r0 = this;
            r5 = r5 & 2
            if (r5 == 0) goto L_0x000d
            java.lang.String r4 = r3.getDeviceType()
            java.lang.String r5 = "deviceType.deviceType"
            kotlin.jvm.internal.j.d(r4, r5)
        L_0x000d:
            r0.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.feedback.EnumFeedbackCategory.<init>(java.lang.String, int, com.tplink.libtpnetwork.enumerate.EnumDeviceType, java.lang.String, int, kotlin.jvm.internal.f):void");
    }
}
