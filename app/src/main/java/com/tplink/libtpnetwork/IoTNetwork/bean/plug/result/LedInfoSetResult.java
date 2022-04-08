package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class LedInfoSetResult {
    @c("led_status")
    private boolean ledStatus;
    @c("night_mode")
    private LedNightModeBean nightMode;

    public LedNightModeBean getNightMode() {
        return this.nightMode;
    }

    public boolean isLedStatus() {
        return this.ledStatus;
    }

    public void setLedStatus(boolean z) {
        this.ledStatus = z;
    }

    public void setNightMode(LedNightModeBean ledNightModeBean) {
        this.nightMode = ledNightModeBean;
    }
}
