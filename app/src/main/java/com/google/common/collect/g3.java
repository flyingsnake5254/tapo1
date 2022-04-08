package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.collect.f3;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Tables.java */
/* loaded from: classes2.dex */
public final class g3 {
    private static final h<? extends Map<?, ?>, ? extends Map<?, ?>> a = new a();

    /* compiled from: Tables.java */
    /* loaded from: classes2.dex */
    static class a implements h<Map<Object, Object>, Map<Object, Object>> {
        a() {
        }

        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* compiled from: Tables.java */
    /* loaded from: classes2.dex */
    static abstract class b<R, C, V> implements f3.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f3.a)) {
                return false;
            }
            f3.a aVar = (f3.a) obj;
            return k.a(a(), aVar.a()) && k.a(b(), aVar.b()) && k.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return k.b(a(), b(), getValue());
        }

        public String toString() {
            return "(" + a() + SSLClient.COMMA + b() + ")=" + getValue();
        }
    }

    /* compiled from: Tables.java */
    /* loaded from: classes2.dex */
    static final class c<R, C, V> extends b<R, C, V> implements Serializable {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        private final R f4461c;
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        private final C f4462d;
        @NullableDecl

        /* renamed from: f  reason: collision with root package name */
        private final V f4463f;

        c(@NullableDecl R r, @NullableDecl C c2, @NullableDecl V v) {
            this.f4461c = r;
            this.f4462d = c2;
            this.f4463f = v;
        }

        @Override // com.google.common.collect.f3.a
        public R a() {
            return this.f4461c;
        }

        @Override // com.google.common.collect.f3.a
        public C b() {
            return this.f4462d;
        }

        @Override // com.google.common.collect.f3.a
        public V getValue() {
            return this.f4463f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(f3<?, ?, ?> f3Var, @NullableDecl Object obj) {
        if (obj == f3Var) {
            return true;
        }
        if (obj instanceof f3) {
            return f3Var.cellSet().equals(((f3) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> f3.a<R, C, V> b(@NullableDecl R r, @NullableDecl C c2, @NullableDecl V v) {
        return new c(r, c2, v);
    }
}
