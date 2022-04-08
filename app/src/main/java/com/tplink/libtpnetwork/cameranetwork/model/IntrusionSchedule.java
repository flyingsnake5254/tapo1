package com.tplink.libtpnetwork.cameranetwork.model;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class IntrusionSchedule {
    private final int endHour;
    private final int endMinute;
    private final boolean isCrossTwoDays;
    private final boolean isEmpty;
    private final boolean isScheduleAllDay;
    private final boolean isScheduleBeforeDawn;
    private final boolean isScheduleDayTime;
    private final boolean isScheduleMidnight;
    private final int startHour;
    private final int startMinute;

    public IntrusionSchedule(int i, int i2, int i3, int i4) {
        this.startHour = i;
        this.startMinute = i2;
        this.endHour = i3;
        this.endMinute = i4;
        boolean z = true;
        this.isScheduleAllDay = i == 0 && i3 == 24 && i2 == 0 && i4 == 0;
        this.isScheduleDayTime = i == 8 && i3 == 20 && i2 == 0 && i4 == 0;
        this.isScheduleMidnight = i == 20 && i3 == 24 && i2 == 0 && i4 == 0;
        this.isScheduleBeforeDawn = i == 0 && i3 == 8 && i2 == 0 && i4 == 0;
        this.isCrossTwoDays = (i * 60) + i2 > (i3 * 60) + i4;
        this.isEmpty = (i == i3 && i2 == i4) ? z : false;
    }

    public static /* synthetic */ IntrusionSchedule copy$default(IntrusionSchedule intrusionSchedule, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = intrusionSchedule.startHour;
        }
        if ((i5 & 2) != 0) {
            i2 = intrusionSchedule.startMinute;
        }
        if ((i5 & 4) != 0) {
            i3 = intrusionSchedule.endHour;
        }
        if ((i5 & 8) != 0) {
            i4 = intrusionSchedule.endMinute;
        }
        return intrusionSchedule.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.startHour;
    }

    public final int component2() {
        return this.startMinute;
    }

    public final int component3() {
        return this.endHour;
    }

    public final int component4() {
        return this.endMinute;
    }

    public final IntrusionSchedule copy(int i, int i2, int i3, int i4) {
        return new IntrusionSchedule(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntrusionSchedule)) {
            return false;
        }
        IntrusionSchedule intrusionSchedule = (IntrusionSchedule) obj;
        return this.startHour == intrusionSchedule.startHour && this.startMinute == intrusionSchedule.startMinute && this.endHour == intrusionSchedule.endHour && this.endMinute == intrusionSchedule.endMinute;
    }

    public final int getEndHour() {
        return this.endHour;
    }

    public final int getEndMinute() {
        return this.endMinute;
    }

    public final int getStartHour() {
        return this.startHour;
    }

    public final int getStartMinute() {
        return this.startMinute;
    }

    public int hashCode() {
        return (((((this.startHour * 31) + this.startMinute) * 31) + this.endHour) * 31) + this.endMinute;
    }

    public final boolean isCrossTwoDays() {
        return this.isCrossTwoDays;
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public final boolean isScheduleAllDay() {
        return this.isScheduleAllDay;
    }

    public final boolean isScheduleBeforeDawn() {
        return this.isScheduleBeforeDawn;
    }

    public final boolean isScheduleDayTime() {
        return this.isScheduleDayTime;
    }

    public final boolean isScheduleMidnight() {
        return this.isScheduleMidnight;
    }

    public String toString() {
        return "IntrusionSchedule(startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", endHour=" + this.endHour + ", endMinute=" + this.endMinute + ")";
    }
}
