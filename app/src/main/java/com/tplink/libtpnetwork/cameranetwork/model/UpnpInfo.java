package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class UpnpInfo {
    private String enabled;
    private String mode;

    public UpnpInfo(String str, String str2) {
        this.enabled = str;
        this.mode = str2;
    }

    public static /* synthetic */ UpnpInfo copy$default(UpnpInfo upnpInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upnpInfo.enabled;
        }
        if ((i & 2) != 0) {
            str2 = upnpInfo.mode;
        }
        return upnpInfo.copy(str, str2);
    }

    public final String component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.mode;
    }

    public final UpnpInfo copy(String str, String str2) {
        return new UpnpInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpnpInfo)) {
            return false;
        }
        UpnpInfo upnpInfo = (UpnpInfo) obj;
        return j.a(this.enabled, upnpInfo.enabled) && j.a(this.mode, upnpInfo.mode);
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public final String getMode() {
        return this.mode;
    }

    public int hashCode() {
        String str = this.enabled;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setEnabled(String str) {
        this.enabled = str;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public String toString() {
        return "UpnpInfo(enabled=" + this.enabled + ", mode=" + this.mode + ")";
    }
}
