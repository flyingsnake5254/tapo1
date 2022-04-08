package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

import kotlin.jvm.internal.f;

/* compiled from: RemoveScaleStatusResult.kt */
/* loaded from: classes3.dex */
public final class RemoveScaleStatusResult {
    public static final Companion Companion = new Companion(null);
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_REMOVING = 1;
    private int status;

    /* compiled from: RemoveScaleStatusResult.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public RemoveScaleStatusResult(int i) {
        this.status = i;
    }

    public static /* synthetic */ RemoveScaleStatusResult copy$default(RemoveScaleStatusResult removeScaleStatusResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = removeScaleStatusResult.status;
        }
        return removeScaleStatusResult.copy(i);
    }

    public final int component1() {
        return this.status;
    }

    public final RemoveScaleStatusResult copy(int i) {
        return new RemoveScaleStatusResult(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RemoveScaleStatusResult) && this.status == ((RemoveScaleStatusResult) obj).status;
        }
        return true;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "RemoveScaleStatusResult(status=" + this.status + ")";
    }
}
