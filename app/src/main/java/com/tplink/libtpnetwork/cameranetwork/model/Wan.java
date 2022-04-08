package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class Wan {
    @c("ipaddr")
    private String ipAddress;

    public Wan(String ipAddress) {
        j.e(ipAddress, "ipAddress");
        this.ipAddress = ipAddress;
    }

    public static /* synthetic */ Wan copy$default(Wan wan, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wan.ipAddress;
        }
        return wan.copy(str);
    }

    public final String component1() {
        return this.ipAddress;
    }

    public final Wan copy(String ipAddress) {
        j.e(ipAddress, "ipAddress");
        return new Wan(ipAddress);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Wan) && j.a(this.ipAddress, ((Wan) obj).ipAddress);
        }
        return true;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public int hashCode() {
        String str = this.ipAddress;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setIpAddress(String str) {
        j.e(str, "<set-?>");
        this.ipAddress = str;
    }

    public String toString() {
        return "Wan(ipAddress=" + this.ipAddress + ")";
    }
}
