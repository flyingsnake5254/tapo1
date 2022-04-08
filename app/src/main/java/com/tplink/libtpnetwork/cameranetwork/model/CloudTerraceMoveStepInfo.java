package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CloudTerraceMoveStepInfo {
    private final String direction;

    public CloudTerraceMoveStepInfo(String direction) {
        j.e(direction, "direction");
        this.direction = direction;
    }

    public static /* synthetic */ CloudTerraceMoveStepInfo copy$default(CloudTerraceMoveStepInfo cloudTerraceMoveStepInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudTerraceMoveStepInfo.direction;
        }
        return cloudTerraceMoveStepInfo.copy(str);
    }

    public final String component1() {
        return this.direction;
    }

    public final CloudTerraceMoveStepInfo copy(String direction) {
        j.e(direction, "direction");
        return new CloudTerraceMoveStepInfo(direction);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CloudTerraceMoveStepInfo) && j.a(this.direction, ((CloudTerraceMoveStepInfo) obj).direction);
        }
        return true;
    }

    public final String getDirection() {
        return this.direction;
    }

    public int hashCode() {
        String str = this.direction;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CloudTerraceMoveStepInfo(direction=" + this.direction + ")";
    }
}
