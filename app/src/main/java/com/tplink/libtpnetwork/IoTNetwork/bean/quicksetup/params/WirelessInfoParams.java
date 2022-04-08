package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class WirelessInfoParams implements Serializable {
    @c("key_type")
    private String keyType;
    @b(Base64TypeAdapter.class)
    private String password;
    @b(Base64TypeAdapter.class)
    private String ssid;

    public WirelessInfoParams() {
    }

    public String getKeyType() {
        return this.keyType;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public WirelessInfoParams(String str, String str2) {
        this.ssid = str;
        this.keyType = str2;
    }

    public WirelessInfoParams(String str, String str2, String str3) {
        this.ssid = str;
        this.password = str2;
        this.keyType = str3;
    }
}
