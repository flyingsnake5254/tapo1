package com.tplink.libtpnetwork.enumerate;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: EnumTRVState.kt */
/* loaded from: classes3.dex */
public enum EnumTRVState {
    HEATING(TRV_HEATING),
    FROST_PROTECTION(TRV_FROST_PROTECTION),
    PROGRESS_CALIBRATION(TRV_PROGRESS_CALIBRATION),
    REMOVING_SCALE(TRV_REMOVING_SCALE),
    SHUTDOWN(TRV_SHUTDOWN),
    DEVICE_ERROR(TRV_DEVICE_ERROR),
    WINDOW_OPEN(TRV_WINDOW_OPEN),
    LOW_BATTERY(TRV_LOW_BATTERY);
    
    public static final a Companion = new a(null);
    public static final String TRV_DEVICE_ERROR = "device_error";
    public static final String TRV_FROST_PROTECTION = "frost_protection";
    public static final String TRV_HEATING = "heating";
    public static final String TRV_LOW_BATTERY = "low_battery";
    public static final String TRV_PROGRESS_CALIBRATION = "progress_calibration";
    public static final String TRV_REMOVING_SCALE = "removing_scale";
    public static final String TRV_SHUTDOWN = "shutdown";
    public static final String TRV_WINDOW_OPEN = "window_open";
    private final String value;

    /* compiled from: EnumTRVState.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final EnumTRVState a(String str) {
            EnumTRVState[] values;
            if (str == null) {
                return null;
            }
            for (EnumTRVState enumTRVState : EnumTRVState.values()) {
                if (j.a(enumTRVState.getValue(), str)) {
                    return enumTRVState;
                }
            }
            return null;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    EnumTRVState(String str) {
        this.value = str;
    }

    public static final EnumTRVState fromString(String str) {
        return Companion.a(str);
    }

    public final String getValue() {
        return this.value;
    }
}
