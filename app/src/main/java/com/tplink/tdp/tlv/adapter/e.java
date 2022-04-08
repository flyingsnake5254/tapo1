package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Type;

/* compiled from: TypeToken.java */
/* loaded from: classes3.dex */
public class e<T> {
    private final Class<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15236b;

    /* renamed from: c  reason: collision with root package name */
    private final Type[] f15237c;

    public e(Class cls, Type type) {
        this.a = cls;
        this.f15237c = f.d(type);
        this.f15236b = cls.hashCode();
    }

    public Class<? super T> a() {
        return this.a;
    }

    public Type[] b() {
        return this.f15237c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && f.a(this, (e) obj);
    }

    public int hashCode() {
        return this.f15236b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeToken");
        sb.append("\n");
        sb.append("rawType:");
        sb.append(this.a.toString());
        sb.append("\n");
        Type[] typeArr = this.f15237c;
        if (typeArr != null) {
            for (Type type : typeArr) {
                sb.append("typeArgs:");
                sb.append(type.toString());
                sb.append("\t");
            }
        }
        return sb.toString();
    }

    public e(Type type) {
        this.a = (Class<? super T>) f.b(type);
        this.f15237c = f.d(type);
        this.f15236b = type.hashCode();
    }
}
