package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class P2PSharePwd {
    private final String sharepwd;
    private final String username;

    public P2PSharePwd(String str, String sharepwd) {
        j.e(sharepwd, "sharepwd");
        this.username = str;
        this.sharepwd = sharepwd;
    }

    public static /* synthetic */ P2PSharePwd copy$default(P2PSharePwd p2PSharePwd, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = p2PSharePwd.username;
        }
        if ((i & 2) != 0) {
            str2 = p2PSharePwd.sharepwd;
        }
        return p2PSharePwd.copy(str, str2);
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.sharepwd;
    }

    public final P2PSharePwd copy(String str, String sharepwd) {
        j.e(sharepwd, "sharepwd");
        return new P2PSharePwd(str, sharepwd);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P2PSharePwd)) {
            return false;
        }
        P2PSharePwd p2PSharePwd = (P2PSharePwd) obj;
        return j.a(this.username, p2PSharePwd.username) && j.a(this.sharepwd, p2PSharePwd.sharepwd);
    }

    public final String getSharepwd() {
        return this.sharepwd;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sharepwd;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "P2PSharePwd(username=" + this.username + ", sharepwd=" + this.sharepwd + ")";
    }
}
