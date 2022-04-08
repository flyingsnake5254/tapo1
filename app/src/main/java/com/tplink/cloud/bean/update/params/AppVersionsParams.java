package com.tplink.cloud.bean.update.params;

/* loaded from: classes2.dex */
public class AppVersionsParams extends AppVersionParams {
    private int versionCode;

    public AppVersionsParams() {
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public AppVersionsParams(String str, String str2, String str3, int i) {
        super(str, str2, str3);
        this.versionCode = i;
    }
}
