package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class PubIp {
    private String ip;

    public PubIp(String str) {
        this.ip = str;
    }

    public static /* synthetic */ PubIp copy$default(PubIp pubIp, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pubIp.ip;
        }
        return pubIp.copy(str);
    }

    public final String component1() {
        return this.ip;
    }

    public final PubIp copy(String str) {
        return new PubIp(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PubIp) && j.a(this.ip, ((PubIp) obj).ip);
        }
        return true;
    }

    public final String getIp() {
        return this.ip;
    }

    public int hashCode() {
        String str = this.ip;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setIp(String str) {
        this.ip = str;
    }

    public String toString() {
        return "PubIp(ip=" + this.ip + ")";
    }
}
