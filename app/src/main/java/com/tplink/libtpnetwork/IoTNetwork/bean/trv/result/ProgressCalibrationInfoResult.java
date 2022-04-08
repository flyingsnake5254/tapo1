package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

import kotlin.jvm.internal.f;

/* compiled from: ProgressCalibrationInfoResult.kt */
/* loaded from: classes3.dex */
public final class ProgressCalibrationInfoResult {
    public static final Companion Companion = new Companion(null);
    public static final int STATUS_CALIBRATION = 1;
    public static final int STATUS_DEVICE_ERROR = -1;
    public static final int STATUS_IDLE = 0;
    private int status;

    /* compiled from: ProgressCalibrationInfoResult.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public ProgressCalibrationInfoResult(int i) {
        this.status = i;
    }

    public static /* synthetic */ ProgressCalibrationInfoResult copy$default(ProgressCalibrationInfoResult progressCalibrationInfoResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = progressCalibrationInfoResult.status;
        }
        return progressCalibrationInfoResult.copy(i);
    }

    public final int component1() {
        return this.status;
    }

    public final ProgressCalibrationInfoResult copy(int i) {
        return new ProgressCalibrationInfoResult(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ProgressCalibrationInfoResult) && this.status == ((ProgressCalibrationInfoResult) obj).status;
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
        return "ProgressCalibrationInfoResult(status=" + this.status + ")";
    }
}
