package com.tplink.cloud.bean.account.params;

/* loaded from: classes2.dex */
public class TopicSubscriptionParams {
    private String email;
    private String productLine;

    public TopicSubscriptionParams() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setProductLine(String str) {
        this.productLine = str;
    }

    public TopicSubscriptionParams(String str, String str2) {
        this.email = str;
        this.productLine = str2;
    }
}
