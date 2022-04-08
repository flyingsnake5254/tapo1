package com.tplink.libtpnetwork.IoTNetwork.bean.common;

/* loaded from: classes3.dex */
public class IoTDataWrapper<T> {
    private T data;
    private Throwable throwable;

    public IoTDataWrapper() {
    }

    public T getData() {
        return this.data;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public IoTDataWrapper(T t) {
        this.data = t;
    }

    public IoTDataWrapper(Throwable th) {
        this.throwable = th;
    }

    public IoTDataWrapper(T t, Throwable th) {
        this.data = t;
        this.throwable = th;
    }
}
