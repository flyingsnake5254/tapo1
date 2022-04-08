package com.samskivert.mustache;

import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: FunctionExpressionParser.kt */
/* loaded from: classes2.dex */
public final class d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f5137b;

    public d(String functionName, List<? extends Object> params) {
        j.e(functionName, "functionName");
        j.e(params, "params");
        this.a = functionName;
        this.f5137b = params;
    }

    public final String a() {
        return this.a;
    }

    public final List<Object> b() {
        return this.f5137b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.a, dVar.a) && j.a(this.f5137b, dVar.f5137b);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Object> list = this.f5137b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FunctionExpression(functionName=" + this.a + ", params=" + this.f5137b + ")";
    }
}
