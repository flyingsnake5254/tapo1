package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: IoTSubBase.kt */
/* loaded from: classes3.dex */
public final class ChildResponseData<T> {
    @c("responseData")
    private final T responseData;

    public ChildResponseData(T t) {
        this.responseData = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildResponseData copy$default(ChildResponseData childResponseData, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = childResponseData.responseData;
        }
        return childResponseData.copy(obj);
    }

    public final T component1() {
        return this.responseData;
    }

    public final ChildResponseData<T> copy(T t) {
        return new ChildResponseData<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChildResponseData) && j.a(this.responseData, ((ChildResponseData) obj).responseData);
        }
        return true;
    }

    public final T getResponseData() {
        return this.responseData;
    }

    public int hashCode() {
        T t = this.responseData;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ChildResponseData(responseData=" + this.responseData + ")";
    }
}
