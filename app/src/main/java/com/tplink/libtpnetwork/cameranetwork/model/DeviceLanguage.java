package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class DeviceLanguage {
    private final String language;

    public DeviceLanguage(String language) {
        j.e(language, "language");
        this.language = language;
    }

    public static /* synthetic */ DeviceLanguage copy$default(DeviceLanguage deviceLanguage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceLanguage.language;
        }
        return deviceLanguage.copy(str);
    }

    public final String component1() {
        return this.language;
    }

    public final DeviceLanguage copy(String language) {
        j.e(language, "language");
        return new DeviceLanguage(language);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DeviceLanguage) && j.a(this.language, ((DeviceLanguage) obj).language);
        }
        return true;
    }

    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        String str = this.language;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DeviceLanguage(language=" + this.language + ")";
    }
}
