package com.tplink.iot.cloud.bean.thing.common;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class ThingShadow {
    private ThingShadowState state;
    private long version;

    public ThingShadow() {
    }

    public Object getDesiredValue(@NonNull ThingProperty thingProperty) {
        ThingShadowState thingShadowState = this.state;
        if (thingShadowState != null) {
            return thingShadowState.getDesiredValue(thingProperty);
        }
        return null;
    }

    public Object getReportedValue(@NonNull ThingProperty thingProperty) {
        ThingShadowState thingShadowState = this.state;
        if (thingShadowState != null) {
            return thingShadowState.getReportedValue(thingProperty);
        }
        return null;
    }

    public ThingShadowState getState() {
        return this.state;
    }

    public long getVersion() {
        return this.version;
    }

    public void setState(ThingShadowState thingShadowState) {
        this.state = thingShadowState;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public ThingShadow(long j, ThingShadowState thingShadowState) {
        this.version = j;
        this.state = thingShadowState;
    }
}
