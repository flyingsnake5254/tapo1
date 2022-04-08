package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.f;
import kotlin.v.g;

/* compiled from: EnumThermostatAvatarType.kt */
/* loaded from: classes3.dex */
public enum EnumTRVAvatarType {
    TRV("trv"),
    LIVING_ROOM("living_room"),
    BED("bed"),
    KITCHEN("kitchen"),
    DINING_ROOM("dining_room"),
    BATHROOM("bathroom"),
    OFFICE("office"),
    STUDY("study"),
    BABY_ROOM("baby_room");
    
    public static final a Companion = new a(null);
    private static final Map<String, EnumTRVAvatarType> mTypeMap;
    private final String value;

    /* compiled from: EnumThermostatAvatarType.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final EnumTRVAvatarType a(String str) {
            return (EnumTRVAvatarType) EnumTRVAvatarType.mTypeMap.get(str);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int a2;
        int b2;
        EnumTRVAvatarType[] values = values();
        a2 = d0.a(values.length);
        b2 = g.b(a2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (EnumTRVAvatarType enumTRVAvatarType : values) {
            linkedHashMap.put(enumTRVAvatarType.value, enumTRVAvatarType);
        }
        mTypeMap = linkedHashMap;
    }

    EnumTRVAvatarType(String str) {
        this.value = str;
    }

    public static final EnumTRVAvatarType fromString(String str) {
        return Companion.a(str);
    }

    public final String getValue() {
        return this.value;
    }
}
