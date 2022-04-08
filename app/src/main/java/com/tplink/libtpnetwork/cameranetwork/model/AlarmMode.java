package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum AlarmMode {
    SOUND { // from class: com.tplink.libtpnetwork.cameranetwork.model.AlarmMode.SOUND
        @Override // java.lang.Enum
        public String toString() {
            return getRaw();
        }
    },
    LIGHT { // from class: com.tplink.libtpnetwork.cameranetwork.model.AlarmMode.LIGHT
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

        public final AlarmMode fromString(String raw) {
            AlarmMode[] values;
            j.e(raw, "raw");
            for (AlarmMode alarmMode : AlarmMode.values()) {
                if (j.a(alarmMode.getRaw(), raw)) {
                    return alarmMode;
                }
            }
            return null;
        }

        public final List<AlarmMode> fromStringList(List<String> rawList) {
            int l;
            j.e(rawList, "rawList");
            l = o.l(rawList, 10);
            ArrayList arrayList = new ArrayList(l);
            for (String str : rawList) {
                arrayList.add(AlarmMode.Companion.fromString(str));
            }
            return arrayList;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    AlarmMode(String str) {
        this.raw = str;
    }

    public static final AlarmMode fromString(String str) {
        return Companion.fromString(str);
    }

    public static final List<AlarmMode> fromStringList(List<String> list) {
        return Companion.fromStringList(list);
    }

    public final String getRaw() {
        return this.raw;
    }

    /* synthetic */ AlarmMode(String str, f fVar) {
        this(str);
    }
}
