package com.bumptech.glide.load.engine.z;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.z.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {
    private final a<K, V> a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f1520b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f1521b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f1522c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f1523d;

        a() {
            this(null);
        }

        public void a(V v) {
            if (this.f1521b == null) {
                this.f1521b = new ArrayList();
            }
            this.f1521b.add(v);
        }

        @Nullable
        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.f1521b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f1521b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k) {
            this.f1523d = this;
            this.f1522c = this;
            this.a = k;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f1523d = aVar2;
        aVar.f1522c = aVar2.f1522c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f1523d = aVar2.f1523d;
        aVar.f1522c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f1523d;
        aVar2.f1522c = aVar.f1522c;
        aVar.f1522c.f1523d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f1522c.f1523d = aVar;
        aVar.f1523d.f1522c = aVar;
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f1520b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f1520b.put(k, aVar);
        } else {
            k.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k, V v) {
        a<K, V> aVar = this.f1520b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            c(aVar);
            this.f1520b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    @Nullable
    public V f() {
        for (a aVar = this.a.f1523d; !aVar.equals(this.a); aVar = aVar.f1523d) {
            V v = (V) aVar.b();
            if (v != null) {
                return v;
            }
            e(aVar);
            this.f1520b.remove(aVar.a);
            ((m) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.f1522c; !aVar.equals(this.a); aVar = aVar.f1522c) {
            z = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
