package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class StartUpdateFirmwareInfo {
    @c("wait_time")
    private final Integer waitTime;

    public StartUpdateFirmwareInfo(Integer num) {
        this.waitTime = num;
    }

    public static /* synthetic */ StartUpdateFirmwareInfo copy$default(StartUpdateFirmwareInfo startUpdateFirmwareInfo, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = startUpdateFirmwareInfo.waitTime;
        }
        return startUpdateFirmwareInfo.copy(num);
    }

    public final Integer component1() {
        return this.waitTime;
    }

    public final StartUpdateFirmwareInfo copy(Integer num) {
        return new StartUpdateFirmwareInfo(num);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StartUpdateFirmwareInfo) && j.a(this.waitTime, ((StartUpdateFirmwareInfo) obj).waitTime);
        }
        return true;
    }

    public final Integer getWaitTime() {
        return this.waitTime;
    }

    public int hashCode() {
        Integer num = this.waitTime;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "StartUpdateFirmwareInfo(waitTime=" + this.waitTime + ")";
    }
}
