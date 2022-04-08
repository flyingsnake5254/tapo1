package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class QuickSetupInfoParams {
    private LoginAccountParams account;
    @c("extra_info")
    private QuickSetupExtraInfoParams extraInfo;
    private DeviceTimeParams time;
    private WirelessInfoParams wireless;

    public LoginAccountParams getAccount() {
        return this.account;
    }

    public QuickSetupExtraInfoParams getExtraInfo() {
        return this.extraInfo;
    }

    public DeviceTimeParams getTime() {
        return this.time;
    }

    public WirelessInfoParams getWireless() {
        return this.wireless;
    }

    public void setAccount(LoginAccountParams loginAccountParams) {
        this.account = loginAccountParams;
    }

    public void setExtraInfo(QuickSetupExtraInfoParams quickSetupExtraInfoParams) {
        this.extraInfo = quickSetupExtraInfoParams;
    }

    public void setTime(DeviceTimeParams deviceTimeParams) {
        this.time = deviceTimeParams;
    }

    public void setWireless(WirelessInfoParams wirelessInfoParams) {
        this.wireless = wirelessInfoParams;
    }
}
