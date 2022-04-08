package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum BitwiseWeekDay {
    SUN(1),
    MON(2),
    TUE(4),
    WED(8),
    THU(16),
    FRI(32),
    SAT(64);
    
    public static final Companion Companion;
    private static final int everyday;
    private static final int weekend;
    private static final int workday;
    private final int raw;

    /* compiled from: TypeWrapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void getEveryday$annotations() {
        }

        public static /* synthetic */ void getWeekend$annotations() {
        }

        public static /* synthetic */ void getWorkday$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int or(int i, BitwiseWeekDay bitwiseWeekDay) {
            return i | bitwiseWeekDay.raw;
        }

        public final int getEveryday() {
            return BitwiseWeekDay.everyday;
        }

        public final int getWeekend() {
            return BitwiseWeekDay.weekend;
        }

        public final int getWorkday() {
            return BitwiseWeekDay.workday;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        BitwiseWeekDay bitwiseWeekDay = SUN;
        BitwiseWeekDay bitwiseWeekDay2 = MON;
        BitwiseWeekDay bitwiseWeekDay3 = TUE;
        BitwiseWeekDay bitwiseWeekDay4 = WED;
        BitwiseWeekDay bitwiseWeekDay5 = THU;
        BitwiseWeekDay bitwiseWeekDay6 = FRI;
        BitwiseWeekDay bitwiseWeekDay7 = SAT;
        Companion companion = new Companion(null);
        Companion = companion;
        int or = bitwiseWeekDay.or(bitwiseWeekDay7);
        weekend = or;
        int or2 = companion.or(companion.or(companion.or(bitwiseWeekDay2.or(bitwiseWeekDay3), bitwiseWeekDay4), bitwiseWeekDay5), bitwiseWeekDay6);
        workday = or2;
        everyday = or2 | or;
    }

    BitwiseWeekDay(int i) {
        this.raw = i;
    }

    public static final int getEveryday() {
        return everyday;
    }

    public static final int getWeekend() {
        return weekend;
    }

    public static final int getWorkday() {
        return workday;
    }

    public final int and(BitwiseWeekDay day) {
        j.e(day, "day");
        return day.raw & this.raw;
    }

    public final boolean isIn(int i) {
        return and(i) != 0;
    }

    public final int or(BitwiseWeekDay day) {
        j.e(day, "day");
        return day.raw | this.raw;
    }

    public final int and(int i) {
        return i & this.raw;
    }

    public final int or(int i) {
        return i | this.raw;
    }
}
