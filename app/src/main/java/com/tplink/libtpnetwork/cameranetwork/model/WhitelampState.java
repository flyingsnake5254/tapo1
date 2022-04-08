package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class WhitelampState {
    @c("force_wtl_state")
    private final String forceWtlState;

    public WhitelampState(String str) {
        this.forceWtlState = str;
    }

    public static /* synthetic */ WhitelampState copy$default(WhitelampState whitelampState, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = whitelampState.forceWtlState;
        }
        return whitelampState.copy(str);
    }

    public final String component1() {
        return this.forceWtlState;
    }

    public final WhitelampState copy(String str) {
        return new WhitelampState(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof WhitelampState) && j.a(this.forceWtlState, ((WhitelampState) obj).forceWtlState);
        }
        return true;
    }

    public final String getForceWtlState() {
        return this.forceWtlState;
    }

    public int hashCode() {
        String str = this.forceWtlState;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "WhitelampState(forceWtlState=" + this.forceWtlState + ")";
    }

    public WhitelampState(boolean z) {
        this(z ? "on" : "off");
    }
}
