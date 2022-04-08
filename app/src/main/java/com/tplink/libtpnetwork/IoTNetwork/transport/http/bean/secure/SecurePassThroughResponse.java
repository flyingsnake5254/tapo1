package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class SecurePassThroughResponse {
    private String errMsg;
    @c("error_code")
    private int errorCode;
    private ResultBean result;

    /* loaded from: classes3.dex */
    public static class ResultBean {
        private String response;

        public String getResponse() {
            return this.response;
        }

        public void setResponse(String str) {
            this.response = str;
        }
    }

    public SecurePassThroughResponse() {
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

    public SecurePassThroughResponse(int i) {
        this.errorCode = i;
    }
}
