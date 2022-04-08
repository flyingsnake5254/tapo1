package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class LedInfoBean implements Serializable {
    @c("led_rule")
    private String ledRule;
    @c("led_status")
    private Boolean ledStatus;
    @c("night_mode")
    private LedNightModeBean nightMode;

    public String getLedRule() {
        return this.ledRule;
    }

    public Boolean getLedStatus() {
        return this.ledStatus;
    }

    public boolean getLocalLedStatus() {
        Boolean bool = this.ledStatus;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public LedNightModeBean getNightMode() {
        return this.nightMode;
    }

    public void setLedRule(String str) {
        this.ledRule = str;
    }

    public void setLedStatus(Boolean bool) {
        this.ledStatus = bool;
    }

    public void setNightMode(LedNightModeBean ledNightModeBean) {
        this.nightMode = ledNightModeBean;
    }

    public void updateLedInfoParams(LedInfoBean ledInfoBean) {
        if (ledInfoBean != null) {
            setLedStatus(ledInfoBean.getLedStatus());
            setLedRule(ledInfoBean.getLedRule());
            setNightMode(ledInfoBean.getNightMode());
        }
    }
}
