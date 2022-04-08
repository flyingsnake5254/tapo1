package com.tplink.libtpnetwork.cameranetwork.model;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class Schedule {
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
    private final int type;

    public Schedule(int i, int i2, int i3, int i4, int i5) {
        this.startHour = i;
        this.startMinute = i2;
        this.endHour = i3;
        this.endMinute = i4;
        this.type = i5;
        boolean z = true;
        this.isScheduleAllDay = i == 0 && i3 == 24 && i2 == 0 && i4 == 0;
        this.isScheduleDayTime = i == 8 && i3 == 20 && i2 == 0 && i4 == 0;
        this.isScheduleMidnight = i == 20 && i3 == 24 && i2 == 0 && i4 == 0;
        this.isScheduleBeforeDawn = i == 0 && i3 == 8 && i2 == 0 && i4 == 0;
        this.isCrossTwoDays = (i * 60) + i2 > (i3 * 60) + i4;
        this.isEmpty = (i == i3 && i2 == i4) ? z : false;
    }

    public static /* synthetic */ Schedule copy$default(Schedule schedule, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = schedule.startHour;
        }
        if ((i6 & 2) != 0) {
            i2 = schedule.startMinute;
        }
        if ((i6 & 4) != 0) {
            i3 = schedule.endHour;
        }
        if ((i6 & 8) != 0) {
            i4 = schedule.endMinute;
        }
        if ((i6 & 16) != 0) {
            i5 = schedule.type;
        }
        return schedule.copy(i, i2, i3, i4, i5);
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

    public final int component5() {
        return this.type;
    }

    public final Schedule copy(int i, int i2, int i3, int i4, int i5) {
        return new Schedule(i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) obj;
        return this.startHour == schedule.startHour && this.startMinute == schedule.startMinute && this.endHour == schedule.endHour && this.endMinute == schedule.endMinute && this.type == schedule.type;
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

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.startHour * 31) + this.startMinute) * 31) + this.endHour) * 31) + this.endMinute) * 31) + this.type;
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
        return "Schedule(startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", endHour=" + this.endHour + ", endMinute=" + this.endMinute + ", type=" + this.type + ")";
    }
}
