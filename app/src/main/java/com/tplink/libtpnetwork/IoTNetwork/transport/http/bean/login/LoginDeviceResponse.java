package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.login;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class LoginDeviceResponse {
    @c("error_code")
    private int errorCode;
    private ResultBean result;

    /* loaded from: classes3.dex */
    public static class ResultBean {
        private String token;

        public String getToken() {
            return this.token;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ResultBean getResult() {
        return this.result;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setResult(ResultBean resultBean) {
        this.result = resultBean;
    }
}
