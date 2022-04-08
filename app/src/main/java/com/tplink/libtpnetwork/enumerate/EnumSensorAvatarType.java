package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.f;
import kotlin.v.g;

/* compiled from: EnumSensorAvatarType.kt */
/* loaded from: classes3.dex */
public enum EnumSensorAvatarType {
    SENSOR("sensor"),
    OUTDOOR("outdoor"),
    HALLWAY("hallway"),
    WINDOW("window"),
    BEDROOM("bedroom"),
    LIVING_ROOM("living_room");
    
    public static final a Companion = new a(null);
    private static final Map<String, EnumSensorAvatarType> mTypeMap;
    private final String value;

    /* compiled from: EnumSensorAvatarType.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final EnumSensorAvatarType a(String str) {
            return (EnumSensorAvatarType) EnumSensorAvatarType.mTypeMap.get(str);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int a2;
        int b2;
        EnumSensorAvatarType[] values = values();
        a2 = d0.a(values.length);
        b2 = g.b(a2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (EnumSensorAvatarType enumSensorAvatarType : values) {
            linkedHashMap.put(enumSensorAvatarType.value, enumSensorAvatarType);
        }
        mTypeMap = linkedHashMap;
    }

    EnumSensorAvatarType(String str) {
        this.value = str;
    }

    public static final EnumSensorAvatarType fromString(String str) {
        return Companion.a(str);
    }

    public final String getValue() {
        return this.value;
    }
}
