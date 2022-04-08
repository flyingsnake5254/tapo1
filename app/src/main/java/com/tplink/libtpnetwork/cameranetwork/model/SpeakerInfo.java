package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class SpeakerInfo {
    private String volume;

    public SpeakerInfo(String volume) {
        j.e(volume, "volume");
        this.volume = volume;
    }

    public static /* synthetic */ SpeakerInfo copy$default(SpeakerInfo speakerInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = speakerInfo.volume;
        }
        return speakerInfo.copy(str);
    }

    public final String component1() {
        return this.volume;
    }

    public final SpeakerInfo copy(String volume) {
        j.e(volume, "volume");
        return new SpeakerInfo(volume);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SpeakerInfo) && j.a(this.volume, ((SpeakerInfo) obj).volume);
        }
        return true;
    }

    public final String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String str = this.volume;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setVolume(String str) {
        j.e(str, "<set-?>");
        this.volume = str;
    }

    public String toString() {
        return "SpeakerInfo(volume=" + this.volume + ")";
    }
}
