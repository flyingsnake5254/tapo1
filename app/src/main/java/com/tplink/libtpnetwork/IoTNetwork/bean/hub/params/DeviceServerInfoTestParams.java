package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class DeviceServerInfoTestParams {
    @c("server_type")
    private String serverType;

    public DeviceServerInfoTestParams() {
    }

    public String getServerType() {
        return this.serverType;
    }

    public void setServerType(String str) {
        this.serverType = str;
    }

    public DeviceServerInfoTestParams(String str) {
        this.serverType = str;
    }
}
