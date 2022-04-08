package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.a;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder.java */
/* loaded from: classes2.dex */
public final class d {
    private String h;
    private Excluder a = Excluder.f4825c;

    /* renamed from: b  reason: collision with root package name */
    private LongSerializationPolicy f4819b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private c f4820c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, e<?>> f4821d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<p> f4822e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<p> f4823f = new ArrayList();
    private boolean g = false;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String str, int i, int i2, List<p> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        if (str != null && !"".equals(str.trim())) {
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Date.class, str);
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(Timestamp.class, str);
            defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
        } else if (i != 2 && i2 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter4 = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter5 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter6 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            defaultDateTypeAdapter2 = defaultDateTypeAdapter4;
            defaultDateTypeAdapter = defaultDateTypeAdapter5;
            defaultDateTypeAdapter3 = defaultDateTypeAdapter6;
        } else {
            return;
        }
        list.add(TypeAdapters.b(Date.class, defaultDateTypeAdapter2));
        list.add(TypeAdapters.b(Timestamp.class, defaultDateTypeAdapter));
        list.add(TypeAdapters.b(java.sql.Date.class, defaultDateTypeAdapter3));
    }

    public Gson b() {
        List<p> arrayList = new ArrayList<>(this.f4822e.size() + this.f4823f.size() + 3);
        arrayList.addAll(this.f4822e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f4823f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new Gson(this.a, this.f4820c, this.f4821d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.f4819b, this.h, this.i, this.j, this.f4822e, this.f4823f, arrayList);
    }

    public d c() {
        this.m = false;
        return this;
    }

    public d d(Type type, Object obj) {
        boolean z = obj instanceof o;
        a.a(z || (obj instanceof h) || (obj instanceof e) || (obj instanceof TypeAdapter));
        if (obj instanceof e) {
            this.f4821d.put(type, (e) obj);
        }
        if (z || (obj instanceof h)) {
            this.f4822e.add(TreeTypeAdapter.b(com.google.gson.r.a.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f4822e.add(TypeAdapters.a(com.google.gson.r.a.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public d e(String str) {
        this.h = str;
        return this;
    }

    public d f() {
        this.n = true;
        return this;
    }
}
