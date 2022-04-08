package com.tplink.iot.cloud.bean.thing.common;

/* loaded from: classes2.dex */
public class ThingShadowMessage extends ThingShadow {
    private ThingShadowMetadata metadata;
    private int timestamp;

    public ThingShadowMetadata getMetadata() {
        return this.metadata;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public void setMetadata(ThingShadowMetadata thingShadowMetadata) {
        this.metadata = thingShadowMetadata;
    }

    public void setTimestamp(int i) {
        this.timestamp = i;
    }
}
