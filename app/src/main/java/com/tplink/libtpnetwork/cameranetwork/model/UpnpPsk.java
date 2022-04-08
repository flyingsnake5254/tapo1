package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class UpnpPsk {
    private String psk;
    @c("psk_identity")
    private String pskIdentity;

    public UpnpPsk(String str, String str2) {
        this.psk = str;
        this.pskIdentity = str2;
    }

    public static /* synthetic */ UpnpPsk copy$default(UpnpPsk upnpPsk, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upnpPsk.psk;
        }
        if ((i & 2) != 0) {
            str2 = upnpPsk.pskIdentity;
        }
        return upnpPsk.copy(str, str2);
    }

    public final String component1() {
        return this.psk;
    }

    public final String component2() {
        return this.pskIdentity;
    }

    public final UpnpPsk copy(String str, String str2) {
        return new UpnpPsk(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpnpPsk)) {
            return false;
        }
        UpnpPsk upnpPsk = (UpnpPsk) obj;
        return j.a(this.psk, upnpPsk.psk) && j.a(this.pskIdentity, upnpPsk.pskIdentity);
    }

    public final String getPsk() {
        return this.psk;
    }

    public final String getPskIdentity() {
        return this.pskIdentity;
    }

    public int hashCode() {
        String str = this.psk;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pskIdentity;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setPsk(String str) {
        this.psk = str;
    }

    public final void setPskIdentity(String str) {
        this.pskIdentity = str;
    }

    public String toString() {
        return "UpnpPsk(psk=" + this.psk + ", pskIdentity=" + this.pskIdentity + ")";
    }
}
