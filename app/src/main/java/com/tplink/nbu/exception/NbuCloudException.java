package com.tplink.nbu.exception;

import androidx.core.app.NotificationCompat;
import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class NbuCloudException extends Exception {
    @c(alternate = {"code"}, value = "errorCode")
    private int errorCode;
    @c(alternate = {"message"}, value = NotificationCompat.CATEGORY_MESSAGE)
    private String msg;
    private int status;
    private long timestamp;

    public NbuCloudException(String str) {
        this.msg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public NbuCloudException(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
