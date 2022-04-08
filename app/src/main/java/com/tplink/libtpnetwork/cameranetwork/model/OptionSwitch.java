package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum OptionSwitch {
    ON { // from class: com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.ON
        @Override // java.lang.Enum
        public String toString() {
            return getRaw();
        }
    },
    OFF { // from class: com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.OFF
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

        public final OptionSwitch fromBoolean(boolean z) {
            return z ? OptionSwitch.ON : OptionSwitch.OFF;
        }

        public final OptionSwitch fromString(String raw) {
            OptionSwitch[] values;
            j.e(raw, "raw");
            for (OptionSwitch optionSwitch : OptionSwitch.values()) {
                if (j.a(optionSwitch.getRaw(), raw)) {
                    return optionSwitch;
                }
            }
            return null;
        }

        public final boolean isOff(String raw) {
            j.e(raw, "raw");
            return fromString(raw) == OptionSwitch.OFF;
        }

        public final boolean isOn(String raw) {
            j.e(raw, "raw");
            return fromString(raw) == OptionSwitch.ON;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    OptionSwitch(String str) {
        this.raw = str;
    }

    public static final OptionSwitch fromBoolean(boolean z) {
        return Companion.fromBoolean(z);
    }

    public static final OptionSwitch fromString(String str) {
        return Companion.fromString(str);
    }

    public static final boolean isOff(String str) {
        return Companion.isOff(str);
    }

    public static final boolean isOn(String str) {
        return Companion.isOn(str);
    }

    public final String getRaw() {
        return this.raw;
    }

    /* synthetic */ OptionSwitch(String str, f fVar) {
        this(str);
    }
}
