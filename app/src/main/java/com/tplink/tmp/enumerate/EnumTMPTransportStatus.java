package com.tplink.tmp.enumerate;

/* loaded from: classes3.dex */
public enum EnumTMPTransportStatus {
    TMP_TRANSPORT_STATUS_IDLE(0, "TMP_TRANSPORT_STATUS_IDLE"),
    TMP_TRANSPORT_STATUS_CONNECTING(1, "TMP_TRANSPORT_STATUS_CONNECTING"),
    TMP_TRANSPORT_STATUS_CONNECTED(2, "TMP_TRANSPORT_STATUS_CONNECTED"),
    TMP_TRANSPORT_STATUS_DISCONNECTED(3, "TMP_TRANSPORT_STATUS_DISCONNECTED");
    
    private String name;
    private int value;

    EnumTMPTransportStatus(int i, String str) {
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
