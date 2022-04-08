package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class ConnectResult {
    @c("connect_time")
    private final Integer connectTime;
    private final String mac;
    @c("support_ap")
    private final String supportAp;

    public ConnectResult(Integer num, String str, String str2) {
        this.connectTime = num;
        this.mac = str;
        this.supportAp = str2;
    }

    public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = connectResult.connectTime;
        }
        if ((i & 2) != 0) {
            str = connectResult.mac;
        }
        if ((i & 4) != 0) {
            str2 = connectResult.supportAp;
        }
        return connectResult.copy(num, str, str2);
    }

    public final Integer component1() {
        return this.connectTime;
    }

    public final String component2() {
        return this.mac;
    }

    public final String component3() {
        return this.supportAp;
    }

    public final ConnectResult copy(Integer num, String str, String str2) {
        return new ConnectResult(num, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectResult)) {
            return false;
        }
        ConnectResult connectResult = (ConnectResult) obj;
        return j.a(this.connectTime, connectResult.connectTime) && j.a(this.mac, connectResult.mac) && j.a(this.supportAp, connectResult.supportAp);
    }

    public final Integer getConnectTime() {
        return this.connectTime;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getSupportAp() {
        return this.supportAp;
    }

    public int hashCode() {
        Integer num = this.connectTime;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.mac;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.supportAp;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ConnectResult(connectTime=" + this.connectTime + ", mac=" + this.mac + ", supportAp=" + this.supportAp + ")";
    }
}
