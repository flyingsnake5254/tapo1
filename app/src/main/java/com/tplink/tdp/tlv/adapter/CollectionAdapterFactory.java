package com.tplink.tdp.tlv.adapter;

import b.d.c0.m.d.b;
import b.d.c0.m.e.a;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes3.dex */
public class CollectionAdapterFactory implements d {
    private a a;

    /* loaded from: classes3.dex */
    static final class Adapter<E> extends c<Collection<E>> {
        private final b<? extends Collection> a;

        /* renamed from: b  reason: collision with root package name */
        private final c<E> f15220b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15221c;

        Adapter(b<? extends Collection> bVar, c<E> cVar, boolean z) {
            this.a = bVar;
            this.f15220b = cVar;
            this.f15221c = z;
        }

        /* renamed from: b */
        public Collection<E> a(a aVar) {
            Collection<E> collection = (Collection) this.a.a();
            do {
                if (this.f15221c) {
                    collection.add(this.f15220b.a(new a(aVar.o())));
                } else {
                    collection.add(this.f15220b.a(aVar));
                }
                if (!aVar.b()) {
                    break;
                }
            } while (aVar.a() == aVar.c());
            return collection;
        }
    }

    public CollectionAdapterFactory(a aVar) {
        this.a = aVar;
    }

    @Override // com.tplink.tdp.tlv.adapter.d
    public <T> c<T> a(b.d.c0.m.a aVar, e<T> eVar) {
        Type[] b2;
        if (!Collection.class.isAssignableFrom(eVar.a()) || (b2 = eVar.b()) == null || b2.length < 1) {
            return null;
        }
        Type type = b2[0];
        if (!(type instanceof Class)) {
            return null;
        }
        return new Adapter(this.a.a(eVar), aVar.b(new e<>(type)), ((Class) type).isAnnotationPresent(b.class));
    }
}
