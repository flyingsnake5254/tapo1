package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class WirelessScanInfoBean implements Serializable {
    @c("key_type")
    private String keyType;
    @c("signal_level")
    private int signalLevel;
    @b(Base64TypeAdapter.class)
    private String ssid;

    public String getKeyType() {
        return this.keyType;
    }

    public int getSignalLevel() {
        return this.signalLevel;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public void setSignalLevel(int i) {
        this.signalLevel = i;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }
}
