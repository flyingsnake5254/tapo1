package com.tplink.cloud.bean.account.params;

import java.util.Map;

/* loaded from: classes2.dex */
public class RegisterParams {
    private String cloudPassword;
    private String countryCode;
    private String email;
    private String locale;
    private String nickname;
    private String productLine;
    private Map<String, Boolean> topicSubscription;
    @Deprecated
    private String username;

    public RegisterParams() {
    }

    public String getCloudPassword() {
        return this.cloudPassword;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public Map<String, Boolean> getTopicSubscription() {
        return this.topicSubscription;
    }

    @Deprecated
    public String getUsername() {
        return this.username;
    }

    public void setCloudPassword(String str) {
        this.cloudPassword = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setProductLine(String str) {
        this.productLine = str;
    }

    public void setTopicSubscription(Map<String, Boolean> map) {
        this.topicSubscription = map;
    }

    @Deprecated
    public void setUsername(String str) {
        this.username = str;
    }

    public RegisterParams(String str, String str2, String str3, String str4) {
        this.email = str;
        this.nickname = str2;
        this.cloudPassword = str3;
        this.locale = str4;
    }

    public RegisterParams(String str, String str2, String str3, String str4, String str5, String str6, Map<String, Boolean> map) {
        this.email = str;
        this.nickname = str2;
        this.cloudPassword = str3;
        this.locale = str4;
        this.countryCode = str5;
        this.productLine = str6;
        this.topicSubscription = map;
    }
}
