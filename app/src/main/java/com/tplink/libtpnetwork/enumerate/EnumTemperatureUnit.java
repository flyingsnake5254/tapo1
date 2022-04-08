package com.tplink.libtpnetwork.enumerate;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: EnumTemperatureUnit.kt */
/* loaded from: classes3.dex */
public enum EnumTemperatureUnit {
    CELSIUS { // from class: com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.a
        @Override // com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit
        public String getUnitText() {
            return "℃";
        }
    },
    FAHRENHEIT { // from class: com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.c
        @Override // com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit
        public String getUnitText() {
            return "℉";
        }
    };
    
    public static final b Companion = new b(null);
    private final String value;

    /* compiled from: EnumTemperatureUnit.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final EnumTemperatureUnit a(String str) {
            EnumTemperatureUnit enumTemperatureUnit = EnumTemperatureUnit.FAHRENHEIT;
            return j.a(str, enumTemperatureUnit.getValue()) ? enumTemperatureUnit : EnumTemperatureUnit.CELSIUS;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    EnumTemperatureUnit(String str) {
        this.value = str;
    }

    public static final EnumTemperatureUnit fromString(String str) {
        return Companion.a(str);
    }

    public abstract String getUnitText();

    public final String getValue() {
        return this.value;
    }

    /* synthetic */ EnumTemperatureUnit(String str, f fVar) {
        this(str);
    }
}
