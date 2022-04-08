package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.f;
import kotlin.v.g;

/* compiled from: EnumLightStripAvatarType.kt */
/* loaded from: classes3.dex */
public enum EnumLightStripAvatarType {
    LIGHT_STRIP("light_strip"),
    AQUARIUM("aquarium"),
    BEHIND_MIRROR("behind_mirror"),
    BEHIND_SOFA("behind_sofa"),
    BEHIND_TV("behind_tv"),
    CEILING_COVE("ceiling_cove"),
    STAIR_RAIL("stair_rail"),
    UNDER_CABINET("under_cabinet"),
    UNDER_COUNTER("under_counter"),
    STAIR_TREAD("stair_tread");
    
    public static final a Companion = new a(null);
    private static final Map<String, EnumLightStripAvatarType> mTypeMap;
    private final String value;

    /* compiled from: EnumLightStripAvatarType.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final EnumLightStripAvatarType a(String str) {
            return (EnumLightStripAvatarType) EnumLightStripAvatarType.mTypeMap.get(str);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int a2;
        int b2;
        EnumLightStripAvatarType[] values = values();
        a2 = d0.a(values.length);
        b2 = g.b(a2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (EnumLightStripAvatarType enumLightStripAvatarType : values) {
            linkedHashMap.put(enumLightStripAvatarType.value, enumLightStripAvatarType);
        }
        mTypeMap = linkedHashMap;
    }

    EnumLightStripAvatarType(String str) {
        this.value = str;
    }

    public static final EnumLightStripAvatarType fromString(String str) {
        return Companion.a(str);
    }

    public final String getValue() {
        return this.value;
    }
}
