package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class g<Transcode> {
    private final List<n.a<?>> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f1434b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e f1435c;

    /* renamed from: d  reason: collision with root package name */
    private Object f1436d;

    /* renamed from: e  reason: collision with root package name */
    private int f1437e;

    /* renamed from: f  reason: collision with root package name */
    private int f1438f;
    private Class<?> g;
    private h.e h;
    private f i;
    private Map<Class<?>, i<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private c n;
    private Priority o;
    private j p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f1435c = null;
        this.f1436d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.f1434b.clear();
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f1435c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<c> c() {
        if (!this.m) {
            this.m = true;
            this.f1434b.clear();
            List<n.a<?>> g = g();
            int size = g.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVar = g.get(i);
                if (!this.f1434b.contains(aVar.a)) {
                    this.f1434b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.f1574b.size(); i2++) {
                    if (!this.f1434b.contains(aVar.f1574b.get(i2))) {
                        this.f1434b.add(aVar.f1574b.get(i2));
                    }
                }
            }
        }
        return this.f1434b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a d() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1438f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List i = this.f1435c.i().i(this.f1436d);
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> b2 = ((n) i.get(i2)).b(this.f1436d, this.f1437e, this.f1438f, this.i);
                if (b2 != null) {
                    this.a.add(b2);
                }
            }
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f1435c.i().h(cls, this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f1436d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f1435c.i().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f k() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f1435c.i().j(this.f1436d.getClass(), this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.h<Z> n(u<Z> uVar) {
        return this.f1435c.i().k(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c o() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f1435c.i().m(x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> i<Z> r(Class<Z> cls) {
        i<Z> iVar = (i<Z>) this.j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, i<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (i<Z>) next.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.k.c.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f1437e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(e eVar, Object obj, c cVar, int i, int i2, j jVar, Class<?> cls, Class<R> cls2, Priority priority, f fVar, Map<Class<?>, i<?>> map, boolean z, boolean z2, h.e eVar2) {
        this.f1435c = eVar;
        this.f1436d = obj;
        this.n = cVar;
        this.f1437e = i;
        this.f1438f = i2;
        this.p = jVar;
        this.g = cls;
        this.h = eVar2;
        this.k = cls2;
        this.o = priority;
        this.i = fVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(u<?> uVar) {
        return this.f1435c.i().n(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(c cVar) {
        List<n.a<?>> g = g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            if (g.get(i).a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
