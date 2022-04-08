package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: GuardModeParams.kt */
/* loaded from: classes3.dex */
public final class GuardModeParams {
    private boolean enable;
    @c("guard_mode")
    private String guardMode;

    public GuardModeParams(boolean z, String guardMode) {
        j.e(guardMode, "guardMode");
        this.enable = z;
        this.guardMode = guardMode;
    }

    public static /* synthetic */ GuardModeParams copy$default(GuardModeParams guardModeParams, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = guardModeParams.enable;
        }
        if ((i & 2) != 0) {
            str = guardModeParams.guardMode;
        }
        return guardModeParams.copy(z, str);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.guardMode;
    }

    public final GuardModeParams copy(boolean z, String guardMode) {
        j.e(guardMode, "guardMode");
        return new GuardModeParams(z, guardMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuardModeParams)) {
            return false;
        }
        GuardModeParams guardModeParams = (GuardModeParams) obj;
        return this.enable == guardModeParams.enable && j.a(this.guardMode, guardModeParams.guardMode);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getGuardMode() {
        return this.guardMode;
    }

    public int hashCode() {
        boolean z = this.enable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.guardMode;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setGuardMode(String str) {
        j.e(str, "<set-?>");
        this.guardMode = str;
    }

    public String toString() {
        return "GuardModeParams(enable=" + this.enable + ", guardMode=" + this.guardMode + ")";
    }
}
