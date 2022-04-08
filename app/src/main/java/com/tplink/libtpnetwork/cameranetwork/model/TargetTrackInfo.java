package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class TargetTrackInfo {
    private final String enabled;

    public TargetTrackInfo(String enabled) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
    }

    public static /* synthetic */ TargetTrackInfo copy$default(TargetTrackInfo targetTrackInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = targetTrackInfo.enabled;
        }
        return targetTrackInfo.copy(str);
    }

    public final String component1() {
        return this.enabled;
    }

    public final TargetTrackInfo copy(String enabled) {
        j.e(enabled, "enabled");
        return new TargetTrackInfo(enabled);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TargetTrackInfo) && j.a(this.enabled, ((TargetTrackInfo) obj).enabled);
        }
        return true;
    }

    public final String getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        String str = this.enabled;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TargetTrackInfo(enabled=" + this.enabled + ")";
    }

    public TargetTrackInfo(boolean z) {
        this(z ? "on" : "off");
    }
}
