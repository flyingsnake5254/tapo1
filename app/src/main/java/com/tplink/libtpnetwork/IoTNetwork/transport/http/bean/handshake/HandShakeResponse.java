package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake;

import androidx.annotation.Keep;
import com.google.gson.q.c;

@Keep
/* loaded from: classes3.dex */
public class HandShakeResponse {
    private String errMsg;
    @c("error_code")
    private int errorCode;
    private ResultBean result;

    /* loaded from: classes3.dex */
    public static class ResultBean {
        private String key;

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ResultBean getResult() {
        return this.result;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setResult(ResultBean resultBean) {
        this.result = resultBean;
    }
}
