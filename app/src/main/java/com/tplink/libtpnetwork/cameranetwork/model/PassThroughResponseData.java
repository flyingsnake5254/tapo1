package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Base.kt */
/* loaded from: classes3.dex */
public final class PassThroughResponseData<T> {
    private final T responseData;

    public PassThroughResponseData(T t) {
        this.responseData = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PassThroughResponseData copy$default(PassThroughResponseData passThroughResponseData, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = passThroughResponseData.responseData;
        }
        return passThroughResponseData.copy(obj);
    }

    public final T component1() {
        return this.responseData;
    }

    public final PassThroughResponseData<T> copy(T t) {
        return new PassThroughResponseData<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PassThroughResponseData) && j.a(this.responseData, ((PassThroughResponseData) obj).responseData);
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
        return "PassThroughResponseData(responseData=" + this.responseData + ")";
    }
}
