package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class DoPlayParams {
    @c("end_time")
    private String endTime;
    @c("scale")
    private String scale;
    @c("start_time")
    private String startTime;

    public String getEndTime() {
        return this.endTime;
    }

    public String getScale() {
        return this.scale;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setScale(String str) {
        this.scale = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
