package com.tplink.iot.cloud.bean.thing.result;

/* loaded from: classes2.dex */
public class ThingBatchUnbindResult {
    private int errorCode;
    private String thingName;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getThingName() {
        return this.thingName;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }
}
