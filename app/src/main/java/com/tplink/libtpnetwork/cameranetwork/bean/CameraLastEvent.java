package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.cameranetwork.model.LastAlarmInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class CameraLastEvent implements Serializable {
    @c("alarm_time")
    private long alarmTime;
    @c("alarm_type")
    private String alarmType;

    public CameraLastEvent(LastAlarmInfo lastAlarmInfo) {
        this.alarmType = lastAlarmInfo.getAlarmType();
        this.alarmTime = getLongValue(lastAlarmInfo.getAlarmTime());
    }

    private long getLongValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getAlarmTime() {
        return this.alarmTime;
    }

    public String getAlarmType() {
        return this.alarmType;
    }

    public void setAlarmTime(long j) {
        this.alarmTime = j;
    }

    public void setAlarmType(String str) {
        this.alarmType = str;
    }

    public CameraLastEvent clone() {
        CameraLastEvent cameraLastEvent = new CameraLastEvent();
        cameraLastEvent.alarmType = this.alarmType;
        cameraLastEvent.alarmTime = this.alarmTime;
        return cameraLastEvent;
    }

    public CameraLastEvent() {
    }
}
