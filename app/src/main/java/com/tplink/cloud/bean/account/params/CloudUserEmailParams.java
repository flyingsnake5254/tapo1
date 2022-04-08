package com.tplink.cloud.bean.account.params;

/* loaded from: classes2.dex */
public class CloudUserEmailParams {
    private String email;
    private String locale;

    public CloudUserEmailParams() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public CloudUserEmailParams(String str, String str2) {
        this.email = str;
        this.locale = str2;
    }
}
