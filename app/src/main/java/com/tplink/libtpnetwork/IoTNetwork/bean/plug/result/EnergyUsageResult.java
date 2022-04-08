package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import android.annotation.SuppressLint;
import b.d.w.c.a;
import com.google.gson.q.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.j;

/* compiled from: EnergyUsageResult.kt */
/* loaded from: classes3.dex */
public final class EnergyUsageResult {
    @c("current_power")
    private int currentPower;
    @c("local_time")
    private String localTime;
    @c("month_energy")
    private int monthEnergy;
    @c("month_runtime")
    private int monthRuntime;
    private List<Integer> past1y;
    private List<Integer> past24h;
    private List<Integer> past30d;
    private List<? extends List<Integer>> past7d;
    @c("today_energy")
    private int todayEnergy;
    @c("today_runtime")
    private int todayRuntime;

    public EnergyUsageResult(String localTime, int i, int i2, int i3, int i4, int i5, List<Integer> past24h, List<? extends List<Integer>> past7d, List<Integer> past30d, List<Integer> past1y) {
        j.e(localTime, "localTime");
        j.e(past24h, "past24h");
        j.e(past7d, "past7d");
        j.e(past30d, "past30d");
        j.e(past1y, "past1y");
        this.localTime = localTime;
        this.todayRuntime = i;
        this.monthRuntime = i2;
        this.todayEnergy = i3;
        this.monthEnergy = i4;
        this.currentPower = i5;
        this.past24h = past24h;
        this.past7d = past7d;
        this.past30d = past30d;
        this.past1y = past1y;
    }

    @SuppressLint({"SimpleDateFormat"})
    private final long parseLocalTime() {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.localTime);
            if (date == null) {
                date = new Date();
            }
        } catch (Exception e2) {
            a.d("Parse local time failed: " + e2);
            date = new Date();
        }
        return date.getTime();
    }

    public final String component1() {
        return this.localTime;
    }

    public final List<Integer> component10() {
        return this.past1y;
    }

    public final int component2() {
        return this.todayRuntime;
    }

    public final int component3() {
        return this.monthRuntime;
    }

    public final int component4() {
        return this.todayEnergy;
    }

    public final int component5() {
        return this.monthEnergy;
    }

    public final int component6() {
        return this.currentPower;
    }

    public final List<Integer> component7() {
        return this.past24h;
    }

    public final List<List<Integer>> component8() {
        return this.past7d;
    }

    public final List<Integer> component9() {
        return this.past30d;
    }

    public final EnergyUsageResult copy(String localTime, int i, int i2, int i3, int i4, int i5, List<Integer> past24h, List<? extends List<Integer>> past7d, List<Integer> past30d, List<Integer> past1y) {
        j.e(localTime, "localTime");
        j.e(past24h, "past24h");
        j.e(past7d, "past7d");
        j.e(past30d, "past30d");
        j.e(past1y, "past1y");
        return new EnergyUsageResult(localTime, i, i2, i3, i4, i5, past24h, past7d, past30d, past1y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnergyUsageResult)) {
            return false;
        }
        EnergyUsageResult energyUsageResult = (EnergyUsageResult) obj;
        return j.a(this.localTime, energyUsageResult.localTime) && this.todayRuntime == energyUsageResult.todayRuntime && this.monthRuntime == energyUsageResult.monthRuntime && this.todayEnergy == energyUsageResult.todayEnergy && this.monthEnergy == energyUsageResult.monthEnergy && this.currentPower == energyUsageResult.currentPower && j.a(this.past24h, energyUsageResult.past24h) && j.a(this.past7d, energyUsageResult.past7d) && j.a(this.past30d, energyUsageResult.past30d) && j.a(this.past1y, energyUsageResult.past1y);
    }

    public final int getCurrentPower() {
        return this.currentPower;
    }

    public final String getLocalTime() {
        return this.localTime;
    }

    public final long getLocalTimeInMS() {
        return parseLocalTime();
    }

    public final int getMonthEnergy() {
        return this.monthEnergy;
    }

    public final int getMonthRuntime() {
        return this.monthRuntime;
    }

    public final List<Integer> getPast1y() {
        return this.past1y;
    }

    public final List<Integer> getPast24h() {
        return this.past24h;
    }

    public final List<Integer> getPast30d() {
        return this.past30d;
    }

    public final List<List<Integer>> getPast7d() {
        return this.past7d;
    }

    public final int getPast7dCount() {
        List m;
        m = o.m(this.past7d);
        return m.size();
    }

    public final int getTodayEnergy() {
        return this.todayEnergy;
    }

    public final int getTodayRuntime() {
        return this.todayRuntime;
    }

    public int hashCode() {
        String str = this.localTime;
        int i = 0;
        int hashCode = (((((((((((str != null ? str.hashCode() : 0) * 31) + this.todayRuntime) * 31) + this.monthRuntime) * 31) + this.todayEnergy) * 31) + this.monthEnergy) * 31) + this.currentPower) * 31;
        List<Integer> list = this.past24h;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<? extends List<Integer>> list2 = this.past7d;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Integer> list3 = this.past30d;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Integer> list4 = this.past1y;
        if (list4 != null) {
            i = list4.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setCurrentPower(int i) {
        this.currentPower = i;
    }

    public final void setLocalTime(String str) {
        j.e(str, "<set-?>");
        this.localTime = str;
    }

    public final void setMonthEnergy(int i) {
        this.monthEnergy = i;
    }

    public final void setMonthRuntime(int i) {
        this.monthRuntime = i;
    }

    public final void setPast1y(List<Integer> list) {
        j.e(list, "<set-?>");
        this.past1y = list;
    }

    public final void setPast24h(List<Integer> list) {
        j.e(list, "<set-?>");
        this.past24h = list;
    }

    public final void setPast30d(List<Integer> list) {
        j.e(list, "<set-?>");
        this.past30d = list;
    }

    public final void setPast7d(List<? extends List<Integer>> list) {
        j.e(list, "<set-?>");
        this.past7d = list;
    }

    public final void setTodayEnergy(int i) {
        this.todayEnergy = i;
    }

    public final void setTodayRuntime(int i) {
        this.todayRuntime = i;
    }

    public String toString() {
        return "EnergyUsageResult(localTime=" + this.localTime + ", todayRuntime=" + this.todayRuntime + ", monthRuntime=" + this.monthRuntime + ", todayEnergy=" + this.todayEnergy + ", monthEnergy=" + this.monthEnergy + ", currentPower=" + this.currentPower + ", past24h=" + this.past24h + ", past7d=" + this.past7d + ", past30d=" + this.past30d + ", past1y=" + this.past1y + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EnergyUsageResult(com.tplink.iot.cloud.bean.thing.common.ThingEnergyUsage r12) {
        /*
            r11 = this;
            java.util.List r7 = kotlin.collections.l.d()
            java.util.List r8 = kotlin.collections.l.d()
            java.util.List r9 = kotlin.collections.l.d()
            java.util.List r10 = kotlin.collections.l.d()
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L_0x0072
            java.lang.String r0 = r12.getLocalTime()
            java.lang.String r1 = "it.localTime"
            kotlin.jvm.internal.j.d(r0, r1)
            r11.localTime = r0
            int r0 = r12.getTodayRuntime()
            r11.todayRuntime = r0
            int r0 = r12.getMonthRuntime()
            r11.monthRuntime = r0
            int r0 = r12.getTodayEnergy()
            r11.todayEnergy = r0
            int r0 = r12.getMonthEnergy()
            r11.monthEnergy = r0
            java.util.List r0 = r12.getPast24h()
            java.lang.String r1 = "it.past24h"
            kotlin.jvm.internal.j.d(r0, r1)
            r11.past24h = r0
            java.util.List r0 = r12.getPast7d()
            java.lang.String r1 = "it.past7d"
            kotlin.jvm.internal.j.d(r0, r1)
            r11.past7d = r0
            java.util.List r0 = r12.getPast30d()
            java.lang.String r1 = "it.past30d"
            kotlin.jvm.internal.j.d(r0, r1)
            r11.past30d = r0
            java.util.List r0 = r12.getPast1y()
            java.lang.String r1 = "it.past1y"
            kotlin.jvm.internal.j.d(r0, r1)
            r11.past1y = r0
            int r12 = r12.getCurrentPower()
            r11.currentPower = r12
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult.<init>(com.tplink.iot.cloud.bean.thing.common.ThingEnergyUsage):void");
    }
}
