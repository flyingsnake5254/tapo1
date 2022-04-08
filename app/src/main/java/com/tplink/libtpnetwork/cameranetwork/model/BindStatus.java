package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class BindStatus {
    @c("err_code")
    private final String errorCode;
    private final String owner;
    @c("action_status")
    private final String status;

    public BindStatus(String str, String str2, String str3) {
        this.errorCode = str;
        this.status = str2;
        this.owner = str3;
    }

    public static /* synthetic */ BindStatus copy$default(BindStatus bindStatus, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindStatus.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = bindStatus.status;
        }
        if ((i & 4) != 0) {
            str3 = bindStatus.owner;
        }
        return bindStatus.copy(str, str2, str3);
    }

    public final String component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.owner;
    }

    public final BindStatus copy(String str, String str2, String str3) {
        return new BindStatus(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BindStatus)) {
            return false;
        }
        BindStatus bindStatus = (BindStatus) obj;
        return j.a(this.errorCode, bindStatus.errorCode) && j.a(this.status, bindStatus.status) && j.a(this.owner, bindStatus.owner);
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.errorCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.owner;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BindStatus(errorCode=" + this.errorCode + ", status=" + this.status + ", owner=" + this.owner + ")";
    }
}
