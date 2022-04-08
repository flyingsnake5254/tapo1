package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<T> f4889b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f4890c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.a = gson;
        this.f4889b = typeAdapter;
        this.f4890c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(a aVar) throws IOException {
        return this.f4889b.read(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f4889b;
        Type a = a(this.f4890c, t);
        if (a != this.f4890c) {
            typeAdapter = this.a.n(com.google.gson.r.a.get(a));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.f4889b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(bVar, t);
    }
}
