package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class CloudConnectStatus implements Serializable {
    public static final int ERROR_CODE_CLOUD_SEND_CONNECT_FAIL = 1;
    public static final String ERROR_MSG_CLOUD_SEND_CONNECT_FAIL = "send_connect_fail";
    private int errorCode;
    private String errorMsg;

    public CloudConnectStatus(int i, String str) {
        this.errorCode = i;
        this.errorMsg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
