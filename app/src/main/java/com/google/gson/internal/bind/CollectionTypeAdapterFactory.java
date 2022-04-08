package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements p {

    /* renamed from: c  reason: collision with root package name */
    private final c f4860c;

    /* loaded from: classes2.dex */
    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> a;

        /* renamed from: b  reason: collision with root package name */
        private final f<? extends Collection<E>> f4861b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, f<? extends Collection<E>> fVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f4861b = fVar;
        }

        /* renamed from: a */
        public Collection<E> read(a aVar) throws IOException {
            if (aVar.G() == JsonToken.NULL) {
                aVar.C();
                return null;
            }
            Collection<E> collection = (Collection) this.f4861b.a();
            aVar.a();
            while (aVar.s()) {
                collection.add(this.a.read(aVar));
            }
            aVar.j();
            return collection;
        }

        /* renamed from: b */
        public void write(b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.w();
                return;
            }
            bVar.e();
            for (E e2 : collection) {
                this.a.write(bVar, e2);
            }
            bVar.j();
        }
    }

    public CollectionTypeAdapterFactory(c cVar) {
        this.f4860c = cVar;
    }

    @Override // com.google.gson.p
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.r.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type h = com.google.gson.internal.b.h(type, rawType);
        return new Adapter(gson, h, gson.n(com.google.gson.r.a.get(h)), this.f4860c.a(aVar));
    }
}
