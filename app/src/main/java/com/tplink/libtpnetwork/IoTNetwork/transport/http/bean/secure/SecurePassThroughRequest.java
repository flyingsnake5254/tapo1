package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure;

/* loaded from: classes3.dex */
public class SecurePassThroughRequest {
    private String method = "securePassthrough";
    private ParamsBean params;

    /* loaded from: classes3.dex */
    public static class ParamsBean {
        private String request;

        public ParamsBean(String str) {
            this.request = str;
        }

        public String getRequest() {
            return this.request;
        }

        public void setRequest(String str) {
            this.request = str;
        }
    }

    public SecurePassThroughRequest(ParamsBean paramsBean) {
        this.params = paramsBean;
    }

    public String getMethod() {
        return this.method;
    }

    public ParamsBean getParams() {
        return this.params;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(ParamsBean paramsBean) {
        this.params = paramsBean;
    }
}
