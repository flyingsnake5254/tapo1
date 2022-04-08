package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class DiagnoseStatus {
    private final String status;

    public DiagnoseStatus(String status) {
        j.e(status, "status");
        this.status = status;
    }

    public static /* synthetic */ DiagnoseStatus copy$default(DiagnoseStatus diagnoseStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diagnoseStatus.status;
        }
        return diagnoseStatus.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final DiagnoseStatus copy(String status) {
        j.e(status, "status");
        return new DiagnoseStatus(status);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DiagnoseStatus) && j.a(this.status, ((DiagnoseStatus) obj).status);
        }
        return true;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.status;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DiagnoseStatus(status=" + this.status + ")";
    }
}
