package com.tplink.cloud.bean.account.params;

/* loaded from: classes2.dex */
public class UpdateAccountInfoParams {
    private String cloudUserName;
    private String countryCode;
    private String nickname;

    public UpdateAccountInfoParams() {
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public UpdateAccountInfoParams(String str, String str2) {
        this.cloudUserName = str;
        this.nickname = str2;
    }

    public UpdateAccountInfoParams(String str, String str2, String str3) {
        this.cloudUserName = str;
        this.nickname = str2;
        this.countryCode = str3;
    }
}
