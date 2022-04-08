package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Base.kt */
/* loaded from: classes3.dex */
public final class PassThroughRequestData<T> {
    private final String deviceId;
    private final T requestData;

    public PassThroughRequestData(T t, String str) {
        this.requestData = t;
        this.deviceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PassThroughRequestData copy$default(PassThroughRequestData passThroughRequestData, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = passThroughRequestData.requestData;
        }
        if ((i & 2) != 0) {
            str = passThroughRequestData.deviceId;
        }
        return passThroughRequestData.copy(obj, str);
    }

    public final T component1() {
        return this.requestData;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final PassThroughRequestData<T> copy(T t, String str) {
        return new PassThroughRequestData<>(t, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassThroughRequestData)) {
            return false;
        }
        PassThroughRequestData passThroughRequestData = (PassThroughRequestData) obj;
        return j.a(this.requestData, passThroughRequestData.requestData) && j.a(this.deviceId, passThroughRequestData.deviceId);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final T getRequestData() {
        return this.requestData;
    }

    public int hashCode() {
        T t = this.requestData;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        String str = this.deviceId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PassThroughRequestData(requestData=" + this.requestData + ", deviceId=" + this.deviceId + ")";
    }
}
