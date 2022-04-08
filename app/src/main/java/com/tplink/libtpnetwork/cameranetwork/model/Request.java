package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Base.kt */
/* loaded from: classes3.dex */
public final class Request<T> {
    private final String method;
    private final T params;

    public Request(String method, T t) {
        j.e(method, "method");
        this.method = method;
        this.params = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Request copy$default(Request request, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = request.method;
        }
        if ((i & 2) != 0) {
            obj = request.params;
        }
        return request.copy(str, obj);
    }

    public final String component1() {
        return this.method;
    }

    public final T component2() {
        return this.params;
    }

    public final Request<T> copy(String method, T t) {
        j.e(method, "method");
        return new Request<>(method, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return j.a(this.method, request.method) && j.a(this.params, request.params);
    }

    public final String getMethod() {
        return this.method;
    }

    public final T getParams() {
        return this.params;
    }

    public int hashCode() {
        String str = this.method;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t = this.params;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Request(method=" + this.method + ", params=" + this.params + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(Method method, T t) {
        this(method.getValue(), t);
        j.e(method, "method");
    }
}
