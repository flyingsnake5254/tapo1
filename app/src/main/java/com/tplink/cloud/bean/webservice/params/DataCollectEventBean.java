package com.tplink.cloud.bean.webservice.params;

import com.google.gson.k;
import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class DataCollectEventBean {
    @c("ct")
    private long currentTime;
    @c("eid")
    private String eventId;
    @c("ep")
    private k eventParams;
    @c("pvi")
    private String pageViewId;
    @c("usi")
    private String userId;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public String getEventId() {
        return this.eventId;
    }

    public k getEventParams() {
        return this.eventParams;
    }

    public String getPageViewId() {
        return this.pageViewId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventParams(k kVar) {
        this.eventParams = kVar;
    }

    public void setPageViewId(String str) {
        this.pageViewId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
