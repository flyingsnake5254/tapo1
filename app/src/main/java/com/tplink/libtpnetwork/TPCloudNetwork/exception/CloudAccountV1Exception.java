package com.tplink.libtpnetwork.TPCloudNetwork.exception;

import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.define.CloudException;

/* loaded from: classes3.dex */
public class CloudAccountV1Exception extends CloudException {
    private LoginV1Result loginV1Result;

    public CloudAccountV1Exception(LoginV1Result loginV1Result) {
        setErrCode(0);
        this.loginV1Result = loginV1Result;
    }

    public LoginV1Result getLoginV1Result() {
        return this.loginV1Result;
    }

    public void setLoginV1Result(LoginV1Result loginV1Result) {
        this.loginV1Result = loginV1Result;
    }
}
