package com.tplink.ata.params;

import com.tplink.ata.common.ATAMethodType;

/* loaded from: classes2.dex */
public class ATABaseParams {
    private ATAMethodType method;
    private String token;

    public ATABaseParams() {
    }

    public ATAMethodType getMethod() {
        return this.method;
    }

    public String getToken() {
        return this.token;
    }

    public void setMethod(ATAMethodType aTAMethodType) {
        this.method = aTAMethodType;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public ATABaseParams(String str, ATAMethodType aTAMethodType) {
        this.token = str;
        this.method = aTAMethodType;
    }
}
