package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import com.tplink.libtpmediastatistics.SSLClient;
import kotlin.jvm.internal.j;

/* compiled from: Base.kt */
/* loaded from: classes3.dex */
public final class Response<T> {
    @c("error_code")
    private final int errorCode;
    private final String method;
    private final T result;

    public Response(int i, String str, T t) {
        this.errorCode = i;
        this.method = str;
        this.result = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, int i, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = response.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = response.method;
        }
        if ((i2 & 4) != 0) {
            obj = response.result;
        }
        return response.copy(i, str, obj);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.method;
    }

    public final T component3() {
        return this.result;
    }

    public final Response<T> copy(int i, String str, T t) {
        return new Response<>(i, str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return this.errorCode == response.errorCode && j.a(this.method, response.method) && j.a(this.result, response.result);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMethod() {
        return this.method;
    }

    public final T getResult() {
        return this.result;
    }

    public int hashCode() {
        int i = this.errorCode * 31;
        String str = this.method;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        T t = this.result;
        if (t != null) {
            i2 = t.hashCode();
        }
        return hashCode + i2;
    }

    public final boolean isSuccess() {
        return this.errorCode == 0;
    }

    public final <R> Response<R> repack(R r) {
        return new Response<>(this.errorCode, this.method, r);
    }

    public String toString() {
        return "#########" + this.method + "#########\r\nerrorCode:" + this.errorCode + "\r\nresult:" + this.result + SSLClient.NEW_LINE;
    }
}
