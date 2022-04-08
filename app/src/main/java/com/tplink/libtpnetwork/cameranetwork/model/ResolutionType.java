package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum ResolutionType {
    HD_4M { // from class: com.tplink.libtpnetwork.cameranetwork.model.ResolutionType.HD_4M
        @Override // java.lang.Enum
        public String toString() {
            return getValue();
        }
    },
    HD_3M { // from class: com.tplink.libtpnetwork.cameranetwork.model.ResolutionType.HD_3M
        @Override // java.lang.Enum
        public String toString() {
            return getValue();
        }
    },
    HD_1080P { // from class: com.tplink.libtpnetwork.cameranetwork.model.ResolutionType.HD_1080P
        @Override // java.lang.Enum
        public String toString() {
            return getValue();
        }
    },
    HD_720P { // from class: com.tplink.libtpnetwork.cameranetwork.model.ResolutionType.HD_720P
        @Override // java.lang.Enum
        public String toString() {
            return getValue();
        }
    },
    VGA_360P { // from class: com.tplink.libtpnetwork.cameranetwork.model.ResolutionType.VGA_360P
        @Override // java.lang.Enum
        public String toString() {
            return getValue();
        }
    };
    
    public static final Companion Companion = new Companion(null);
    private final String value;

    /* compiled from: TypeWrapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final ResolutionType fromString(String value) {
            ResolutionType[] values;
            j.e(value, "value");
            for (ResolutionType resolutionType : ResolutionType.values()) {
                if (j.a(resolutionType.getValue(), value)) {
                    return resolutionType;
                }
            }
            return null;
        }

        public final List<ResolutionType> fromStringList(List<String> valueList) {
            int l;
            j.e(valueList, "valueList");
            l = o.l(valueList, 10);
            ArrayList arrayList = new ArrayList(l);
            for (String str : valueList) {
                arrayList.add(ResolutionType.Companion.fromString(str));
            }
            return arrayList;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    ResolutionType(String str) {
        this.value = str;
    }

    public static final ResolutionType fromString(String str) {
        return Companion.fromString(str);
    }

    public static final List<ResolutionType> fromStringList(List<String> list) {
        return Companion.fromStringList(list);
    }

    public final String getValue() {
        return this.value;
    }

    /* synthetic */ ResolutionType(String str, f fVar) {
        this(str);
    }
}
