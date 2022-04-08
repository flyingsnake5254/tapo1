package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class WifiList {
    @c("ap_list")
    private final List<Wifi> wifiList;
    @c("wpa3_supported")
    private final boolean wpa3Supported;

    public WifiList(boolean z, List<Wifi> wifiList) {
        j.e(wifiList, "wifiList");
        this.wpa3Supported = z;
        this.wifiList = wifiList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WifiList copy$default(WifiList wifiList, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = wifiList.wpa3Supported;
        }
        if ((i & 2) != 0) {
            list = wifiList.wifiList;
        }
        return wifiList.copy(z, list);
    }

    public final boolean component1() {
        return this.wpa3Supported;
    }

    public final List<Wifi> component2() {
        return this.wifiList;
    }

    public final WifiList copy(boolean z, List<Wifi> wifiList) {
        j.e(wifiList, "wifiList");
        return new WifiList(z, wifiList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiList)) {
            return false;
        }
        WifiList wifiList = (WifiList) obj;
        return this.wpa3Supported == wifiList.wpa3Supported && j.a(this.wifiList, wifiList.wifiList);
    }

    public final List<Wifi> getWifiList() {
        return this.wifiList;
    }

    public final boolean getWpa3Supported() {
        return this.wpa3Supported;
    }

    public int hashCode() {
        boolean z = this.wpa3Supported;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        List<Wifi> list = this.wifiList;
        return i4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "WifiList(wpa3Supported=" + this.wpa3Supported + ", wifiList=" + this.wifiList + ")";
    }
}
