package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.f;
import kotlin.v.g;

/* compiled from: EnumSensorAvatarType.kt */
/* loaded from: classes3.dex */
public enum EnumButtonAvatarType {
    BUTTON("button"),
    DOORBELL("doorbell"),
    BULB("bulb"),
    WINDOW("window");
    
    public static final a Companion = new a(null);
    private static final Map<String, EnumButtonAvatarType> mTypeMap;
    private final String value;

    /* compiled from: EnumSensorAvatarType.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final EnumButtonAvatarType a(String str) {
            return (EnumButtonAvatarType) EnumButtonAvatarType.mTypeMap.get(str);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int a2;
        int b2;
        EnumButtonAvatarType[] values = values();
        a2 = d0.a(values.length);
        b2 = g.b(a2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (EnumButtonAvatarType enumButtonAvatarType : values) {
            linkedHashMap.put(enumButtonAvatarType.value, enumButtonAvatarType);
        }
        mTypeMap = linkedHashMap;
    }

    EnumButtonAvatarType(String str) {
        this.value = str;
    }

    public static final EnumButtonAvatarType fromString(String str) {
        return Companion.a(str);
    }

    public final String getValue() {
        return this.value;
    }
}
