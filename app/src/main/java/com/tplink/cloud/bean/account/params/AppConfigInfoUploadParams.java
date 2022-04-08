package com.tplink.cloud.bean.account.params;

/* loaded from: classes2.dex */
public class AppConfigInfoUploadParams extends AppConfigInfoParams {
    private String featureInfo;
    private String token;

    public AppConfigInfoUploadParams() {
    }

    public String getFeatureInfo() {
        return this.featureInfo;
    }

    public String getToken() {
        return this.token;
    }

    public void setFeatureInfo(String str) {
        this.featureInfo = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public AppConfigInfoUploadParams(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.featureInfo = str3;
        this.token = str4;
    }
}
