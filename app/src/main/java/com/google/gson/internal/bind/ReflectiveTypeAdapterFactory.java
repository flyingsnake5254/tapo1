package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.internal.h;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements p {

    /* renamed from: c  reason: collision with root package name */
    private final c f4870c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.c f4871d;

    /* renamed from: f  reason: collision with root package name */
    private final Excluder f4872f;
    private final JsonAdapterAnnotationTypeAdapterFactory q;
    private final com.google.gson.internal.k.b x = com.google.gson.internal.k.b.a();

    /* loaded from: classes2.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final f<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f4873b;

        Adapter(f<T> fVar, Map<String, b> map) {
            this.a = fVar;
            this.f4873b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.G() == JsonToken.NULL) {
                aVar.C();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.c();
                while (aVar.s()) {
                    b bVar = this.f4873b.get(aVar.A());
                    if (bVar != null && bVar.f4878c) {
                        bVar.a(aVar, a);
                    }
                    aVar.Q();
                }
                aVar.k();
                return a;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.w();
                return;
            }
            bVar.g();
            try {
                for (b bVar2 : this.f4873b.values()) {
                    if (bVar2.c(t)) {
                        bVar.u(bVar2.a);
                        bVar2.b(bVar, t);
                    }
                }
                bVar.k();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f4874d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f4875e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f4876f;
        final /* synthetic */ Gson g;
        final /* synthetic */ com.google.gson.r.a h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, com.google.gson.r.a aVar, boolean z4) {
            super(str, z, z2);
            this.f4874d = field;
            this.f4875e = z3;
            this.f4876f = typeAdapter;
            this.g = gson;
            this.h = aVar;
            this.i = z4;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object read = this.f4876f.read(aVar);
            if (read != null || !this.i) {
                this.f4874d.set(obj, read);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException {
            (this.f4875e ? this.f4876f : new TypeAdapterRuntimeTypeWrapper(this.g, this.f4876f, this.h.getType())).write(bVar, this.f4874d.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.f4877b && this.f4874d.get(obj) != obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f4877b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f4878c;

        protected b(String str, boolean z, boolean z2) {
            this.a = str;
            this.f4877b = z;
            this.f4878c = z2;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(c cVar, com.google.gson.c cVar2, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f4870c = cVar;
        this.f4871d = cVar2;
        this.f4872f = excluder;
        this.q = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private b b(Gson gson, Field field, String str, com.google.gson.r.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = h.a(aVar.getRawType());
        com.google.gson.q.b bVar = (com.google.gson.q.b) field.getAnnotation(com.google.gson.q.b.class);
        TypeAdapter<?> b2 = bVar != null ? this.q.b(this.f4870c, gson, aVar, bVar) : null;
        boolean z3 = b2 != null;
        if (b2 == null) {
            b2 = gson.n(aVar);
        }
        return new a(str, z, z2, field, z3, b2, gson, aVar, a2);
    }

    static boolean d(Field field, boolean z, Excluder excluder) {
        return !excluder.c(field.getType(), z) && !excluder.f(field, z);
    }

    private Map<String, b> e(Gson gson, com.google.gson.r.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.r.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean c2 = c(field, true);
                boolean c3 = c(field, z);
                if (c2 || c3) {
                    this.x.b(field);
                    Type p = com.google.gson.internal.b.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> f2 = f(field);
                    b bVar = null;
                    int size = f2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        String str = f2.get(i2);
                        if (i2 != 0) {
                            c2 = false;
                        }
                        bVar = (b) linkedHashMap.put(str, b(gson, field, str, com.google.gson.r.a.get(p), c2, c3));
                        if (bVar != null) {
                            bVar = bVar;
                        }
                        i2++;
                        c2 = c2;
                        f2 = f2;
                        size = size;
                        field = field;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.a);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = com.google.gson.r.a.get(com.google.gson.internal.b.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        com.google.gson.q.c cVar = (com.google.gson.q.c) field.getAnnotation(com.google.gson.q.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f4871d.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.p
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.r.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.f4870c.a(aVar), e(gson, aVar, rawType));
    }

    public boolean c(Field field, boolean z) {
        return d(field, z, this.f4872f);
    }
}
