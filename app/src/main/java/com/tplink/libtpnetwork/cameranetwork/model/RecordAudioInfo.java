package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class RecordAudioInfo {
    private String enabled;

    public RecordAudioInfo(String enabled) {
        j.e(enabled, "enabled");
        this.enabled = enabled;
    }

    public static /* synthetic */ RecordAudioInfo copy$default(RecordAudioInfo recordAudioInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordAudioInfo.enabled;
        }
        return recordAudioInfo.copy(str);
    }

    public final String component1() {
        return this.enabled;
    }

    public final RecordAudioInfo copy(String enabled) {
        j.e(enabled, "enabled");
        return new RecordAudioInfo(enabled);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RecordAudioInfo) && j.a(this.enabled, ((RecordAudioInfo) obj).enabled);
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

    public final void setEnabled(String str) {
        j.e(str, "<set-?>");
        this.enabled = str;
    }

    public String toString() {
        return "RecordAudioInfo(enabled=" + this.enabled + ")";
    }
}