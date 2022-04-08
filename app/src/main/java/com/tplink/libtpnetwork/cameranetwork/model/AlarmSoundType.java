package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum AlarmSoundType {
    ALARM { // from class: com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType.ALARM
        @Override // java.lang.Enum
        public String toString() {
            return getRaw();
        }
    },
    NOTICE { // from class: com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType.NOTICE
        @Override // java.lang.Enum
        public String toString() {
            return getRaw();
        }
    };
    
    public static final Companion Companion = new Companion(null);
    private final String raw;

    /* compiled from: TypeWrapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final AlarmSoundType fromString(String raw) {
            AlarmSoundType[] values;
            j.e(raw, "raw");
            for (AlarmSoundType alarmSoundType : AlarmSoundType.values()) {
                if (j.a(alarmSoundType.getRaw(), raw)) {
                    return alarmSoundType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    AlarmSoundType(String str) {
        this.raw = str;
    }

    public static final AlarmSoundType fromString(String str) {
        return Companion.fromString(str);
    }

    public final String getRaw() {
        return this.raw;
    }

    /* synthetic */ AlarmSoundType(String str, f fVar) {
        this(str);
    }
}
