package com.tplink.tmp.enumerate;

/* loaded from: classes3.dex */
public enum EnumTMPClientStatus {
    TMPCLIENT_STATUS_IDLE(0, "TMPCLIENT_STATUS_IDLE"),
    TMPCLIENT_STATUS_CONNECTING(1, "TMPCLIENT_STATUS_CONNECTING"),
    TMPCLIENT_STATUS_CONNECTED(2, "TMPCLIENT_STATUS_CONNECTED"),
    TMPCLIENT_STATUS_DISCONNECTED(3, "TMPCLIENT_STATUS_DISCONNECTED");
    
    private String name;
    private int value;

    EnumTMPClientStatus(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
