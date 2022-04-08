package com.tplink.cloud.context;

import androidx.annotation.NonNull;
import b.d.b.d.b.b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TCAccountContext.java */
/* loaded from: classes2.dex */
public class b extends b.c {

    /* renamed from: b  reason: collision with root package name */
    private TCAccountBean f5243b;

    /* renamed from: c  reason: collision with root package name */
    private final a f5244c;

    /* renamed from: d  reason: collision with root package name */
    private final b.d.b.b f5245d;

    /* renamed from: e  reason: collision with root package name */
    private final List<a> f5246e = new ArrayList();

    /* compiled from: TCAccountContext.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public b(TCAccountBean tCAccountBean, a aVar) {
        super(new b.d.b.b(new com.tplink.cloud.define.a(aVar)));
        this.f5243b = tCAccountBean;
        this.f5244c = aVar;
        b.d.b.b bVar = (b.d.b.b) this.a;
        this.f5245d = bVar;
        bVar.V1(tCAccountBean.getToken());
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f5246e.add(aVar);
        }
    }

    public void b() {
        Iterator it = new ArrayList(this.f5246e).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
        this.f5246e.clear();
        b.d.b.b bVar = this.f5245d;
        if (bVar != null) {
            bVar.Q1();
        }
    }

    public TCAccountBean c() {
        return this.f5243b;
    }

    @Override // b.d.b.d.b.b.c, b.d.b.d.b.b.C0014b, b.d.b.d.b.b.a
    @NonNull
    public <T extends b.d.b.d.b.a> T create(@NonNull Class<T> cls) {
        if (!b.d.b.f.a.class.isAssignableFrom(cls)) {
            return (T) super.create(cls);
        }
        try {
            return cls.getConstructor(b.class).newInstance(this);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        }
    }

    public b.d.b.b d() {
        return this.f5245d;
    }

    public a e() {
        return this.f5244c;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof b) && this.f5243b != null) {
            b bVar = (b) obj;
            if (bVar.c() != null) {
                if (this == obj) {
                    return true;
                }
                if (!b.d.w.h.b.d(this.f5243b.getCloudUserName()) && !b.d.w.h.b.d(bVar.c().getCloudUserName())) {
                    return this.f5243b.getCloudUserName().equals(bVar.c().getCloudUserName());
                }
            }
        }
        return false;
    }

    public void f(a aVar) {
        if (aVar != null) {
            this.f5246e.remove(aVar);
        }
    }

    public void g(TCAccountBean tCAccountBean) {
        this.f5243b = tCAccountBean;
        if (tCAccountBean != null) {
            this.f5245d.V1(tCAccountBean.getToken());
        }
    }
}
