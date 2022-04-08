package com.tplink.libtpgoogleassistant.bean.result;

/* loaded from: classes3.dex */
public class AuthValidClientBean {
    private String clientIdInternal;
    private long createdAt;
    private String scope;

    public String getClientIdInternal() {
        return this.clientIdInternal;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getScope() {
        return this.scope;
    }

    public void setClientIdInternal(String str) {
        this.clientIdInternal = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setScope(String str) {
        this.scope = str;
    }
}
