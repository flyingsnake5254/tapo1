package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.b;
import com.google.gson.p;
import com.google.gson.r.a;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final p a = new p() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.p
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type g = b.g(type);
            return new ArrayTypeAdapter(gson, gson.n(a.get(g)), b.k(g));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f4858b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeAdapter<E> f4859c;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f4859c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f4858b = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.G() == JsonToken.NULL) {
            aVar.C();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.s()) {
            arrayList.add(this.f4859c.read(aVar));
        }
        aVar.j();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f4858b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.w();
            return;
        }
        bVar.e();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f4859c.write(bVar, Array.get(obj, i));
        }
        bVar.j();
    }
}
