package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final o<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final h<T> f4881b;

    /* renamed from: c  reason: collision with root package name */
    final Gson f4882c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.r.a<T> f4883d;

    /* renamed from: e  reason: collision with root package name */
    private final p f4884e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeTypeAdapter<T>.b f4885f = new b();
    private TypeAdapter<T> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SingleTypeFactory implements p {

        /* renamed from: c  reason: collision with root package name */
        private final com.google.gson.r.a<?> f4886c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f4887d;

        /* renamed from: f  reason: collision with root package name */
        private final Class<?> f4888f;
        private final o<?> q;
        private final h<?> x;

        SingleTypeFactory(Object obj, com.google.gson.r.a<?> aVar, boolean z, Class<?> cls) {
            h<?> hVar = null;
            o<?> oVar = obj instanceof o ? (o) obj : null;
            this.q = oVar;
            hVar = obj instanceof h ? (h) obj : hVar;
            this.x = hVar;
            com.google.gson.internal.a.a((oVar == null && hVar == null) ? false : true);
            this.f4886c = aVar;
            this.f4887d = z;
            this.f4888f = cls;
        }

        @Override // com.google.gson.p
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.r.a<T> aVar) {
            boolean z;
            com.google.gson.r.a<?> aVar2 = this.f4886c;
            if (aVar2 != null) {
                z = aVar2.equals(aVar) || (this.f4887d && this.f4886c.getType() == aVar.getRawType());
            } else {
                z = this.f4888f.isAssignableFrom(aVar.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.q, this.x, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private final class b implements n, g {
        private b() {
        }

        @Override // com.google.gson.n
        public i a(Object obj, Type type) {
            return TreeTypeAdapter.this.f4882c.B(obj, type);
        }

        @Override // com.google.gson.g
        public <R> R b(i iVar, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f4882c.h(iVar, type);
        }

        @Override // com.google.gson.n
        public i c(Object obj) {
            return TreeTypeAdapter.this.f4882c.A(obj);
        }
    }

    public TreeTypeAdapter(o<T> oVar, h<T> hVar, Gson gson, com.google.gson.r.a<T> aVar, p pVar) {
        this.a = oVar;
        this.f4881b = hVar;
        this.f4882c = gson;
        this.f4883d = aVar;
        this.f4884e = pVar;
    }

    private TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> p = this.f4882c.p(this.f4884e, this.f4883d);
        this.g = p;
        return p;
    }

    public static p b(com.google.gson.r.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.f4881b == null) {
            return a().read(aVar);
        }
        i a2 = com.google.gson.internal.i.a(aVar);
        if (a2.g()) {
            return null;
        }
        return this.f4881b.deserialize(a2, this.f4883d.getType(), this.f4885f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        o<T> oVar = this.a;
        if (oVar == null) {
            a().write(bVar, t);
        } else if (t == null) {
            bVar.w();
        } else {
            com.google.gson.internal.i.b(oVar.serialize(t, this.f4883d.getType(), this.f4885f), bVar);
        }
    }
}
