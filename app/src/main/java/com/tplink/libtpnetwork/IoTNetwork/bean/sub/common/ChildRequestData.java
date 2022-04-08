package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: IoTSubBase.kt */
/* loaded from: classes3.dex */
public final class ChildRequestData<T> {
    private final String device_id;
    @c("requestData")
    private final T requestData;

    public ChildRequestData(T t, String device_id) {
        j.e(device_id, "device_id");
        this.requestData = t;
        this.device_id = device_id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildRequestData copy$default(ChildRequestData childRequestData, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = childRequestData.requestData;
        }
        if ((i & 2) != 0) {
            str = childRequestData.device_id;
        }
        return childRequestData.copy(obj, str);
    }

    public final T component1() {
        return this.requestData;
    }

    public final String component2() {
        return this.device_id;
    }

    public final ChildRequestData<T> copy(T t, String device_id) {
        j.e(device_id, "device_id");
        return new ChildRequestData<>(t, device_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChildRequestData)) {
            return false;
        }
        ChildRequestData childRequestData = (ChildRequestData) obj;
        return j.a(this.requestData, childRequestData.requestData) && j.a(this.device_id, childRequestData.device_id);
    }

    public final String getDevice_id() {
        return this.device_id;
    }

    public final T getRequestData() {
        return this.requestData;
    }

    public int hashCode() {
        T t = this.requestData;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        String str = this.device_id;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChildRequestData(requestData=" + this.requestData + ", device_id=" + this.device_id + ")";
    }
}
