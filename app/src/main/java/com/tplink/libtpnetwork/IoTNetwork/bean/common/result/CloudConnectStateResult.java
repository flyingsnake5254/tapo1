package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class CloudConnectStateResult implements Serializable {
    public static final int STATE_CONNECTED = 0;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTED = 1;
    public static final int STATE_DISCONNECTING = 3;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
