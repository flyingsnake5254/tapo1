package com.tplink.libtpnetwork.IoTNetwork;

/* loaded from: classes3.dex */
public class TPIoTRequest<T> {
    private String method;
    private T params;
    private transient long requestID;
    private long requestTimeMils;
    private String terminalUUID;

    public String getMethod() {
        return this.method;
    }

    public T getParams() {
        return this.params;
    }

    public long getRequestID() {
        return this.requestID;
    }

    public long getRequestTimeMils() {
        return this.requestTimeMils;
    }

    public String getTerminalUUID() {
        return this.terminalUUID;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(T t) {
        this.params = t;
    }

    public void setRequestID(long j) {
        this.requestID = j;
    }

    public void setRequestTimeMils(long j) {
        this.requestTimeMils = j;
    }

    public void setTerminalUUID(String str) {
        this.terminalUUID = str;
    }
}
