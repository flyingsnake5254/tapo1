package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class ThingUsageDetail {
    @c("past30")
    private int past30;
    @c("past7")
    private int past7;
    @c("today")
    private int today;

    public int getPast30() {
        return this.past30;
    }

    public int getPast7() {
        return this.past7;
    }

    public int getToday() {
        return this.today;
    }

    public void setPast30(int i) {
        this.past30 = i;
    }

    public void setPast7(int i) {
        this.past7 = i;
    }

    public void setToday(int i) {
        this.today = i;
    }
}
