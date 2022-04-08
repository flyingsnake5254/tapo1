package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingTemperatureRecords;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TRVTemperatureRecordsResult.kt */
/* loaded from: classes3.dex */
public final class TRVTemperatureRecordsResult {
    public static final Companion Companion = new Companion(null);
    public static final int INVALID_VAL = -200;
    public static final int STATUS_HEATING = 2;
    public static final int STATUS_OFF = 0;
    public static final int STATUS_WORKING = 1;
    @c(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP)
    private final float currentTemp;
    @c("local_time")
    private final long localTime;
    private final List<Integer> today;
    @c("today_status")
    private final List<Integer> todayStatus;
    private final List<Integer> yesterday;
    @c("yesterday_status")
    private final List<Integer> yesterdayStatus;

    /* compiled from: TRVTemperatureRecordsResult.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public TRVTemperatureRecordsResult(long j, float f2, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        this.localTime = j;
        this.currentTemp = f2;
        this.today = list;
        this.todayStatus = list2;
        this.yesterday = list3;
        this.yesterdayStatus = list4;
    }

    public final long component1() {
        return this.localTime;
    }

    public final float component2() {
        return this.currentTemp;
    }

    public final List<Integer> component3() {
        return this.today;
    }

    public final List<Integer> component4() {
        return this.todayStatus;
    }

    public final List<Integer> component5() {
        return this.yesterday;
    }

    public final List<Integer> component6() {
        return this.yesterdayStatus;
    }

    public final TRVTemperatureRecordsResult copy(long j, float f2, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        return new TRVTemperatureRecordsResult(j, f2, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TRVTemperatureRecordsResult)) {
            return false;
        }
        TRVTemperatureRecordsResult tRVTemperatureRecordsResult = (TRVTemperatureRecordsResult) obj;
        return this.localTime == tRVTemperatureRecordsResult.localTime && Float.compare(this.currentTemp, tRVTemperatureRecordsResult.currentTemp) == 0 && j.a(this.today, tRVTemperatureRecordsResult.today) && j.a(this.todayStatus, tRVTemperatureRecordsResult.todayStatus) && j.a(this.yesterday, tRVTemperatureRecordsResult.yesterday) && j.a(this.yesterdayStatus, tRVTemperatureRecordsResult.yesterdayStatus);
    }

    public final float getCurrentTemp() {
        return this.currentTemp;
    }

    public final long getLocalTime() {
        return this.localTime;
    }

    public final List<Integer> getToday() {
        return this.today;
    }

    public final List<Integer> getTodayStatus() {
        return this.todayStatus;
    }

    public final List<Integer> getYesterday() {
        return this.yesterday;
    }

    public final List<Integer> getYesterdayStatus() {
        return this.yesterdayStatus;
    }

    public int hashCode() {
        long j = this.localTime;
        int floatToIntBits = ((((int) (j ^ (j >>> 32))) * 31) + Float.floatToIntBits(this.currentTemp)) * 31;
        List<Integer> list = this.today;
        int i = 0;
        int hashCode = (floatToIntBits + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.todayStatus;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Integer> list3 = this.yesterday;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Integer> list4 = this.yesterdayStatus;
        if (list4 != null) {
            i = list4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "TRVTemperatureRecordsResult(localTime=" + this.localTime + ", currentTemp=" + this.currentTemp + ", today=" + this.today + ", todayStatus=" + this.todayStatus + ", yesterday=" + this.yesterday + ", yesterdayStatus=" + this.yesterdayStatus + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRVTemperatureRecordsResult(ThingTemperatureRecords temperatureRecords) {
        this(temperatureRecords.getLocalTime(), temperatureRecords.getCurrentTemp(), temperatureRecords.getToday(), temperatureRecords.getTodayStatus(), temperatureRecords.getYesterday(), temperatureRecords.getYesterdayStatus());
        j.e(temperatureRecords, "temperatureRecords");
    }
}
