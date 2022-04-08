package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.p;
import com.bumptech.glide.n.a;
import com.bumptech.glide.n.b;
import com.bumptech.glide.n.c;
import com.bumptech.glide.n.d;
import com.bumptech.glide.n.e;
import com.bumptech.glide.n.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {
    private final p a;
    private final Pools.Pool<List<Throwable>> j;
    private final d h = new d();
    private final c i = new c();

    /* renamed from: b  reason: collision with root package name */
    private final a f1277b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final e f1278c = new e();

    /* renamed from: d  reason: collision with root package name */
    private final f f1279d = new f();

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f1280e = new com.bumptech.glide.load.data.f();

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.k.g.f f1281f = new com.bumptech.glide.load.k.g.f();
    private final b g = new b();

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> e2 = com.bumptech.glide.util.k.a.e();
        this.j = e2;
        this.a = new p(e2);
        s(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f1278c.d(cls, cls2)) {
            for (Class cls5 : this.f1281f.b(cls4, cls3)) {
                arrayList.add(new i(cls, cls4, cls5, this.f1278c.b(cls, cls4), this.f1281f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f1277b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull h<TResource> hVar) {
        this.f1279d.a(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull g<Data, TResource> gVar) {
        e("legacy_append", cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull g<Data, TResource> gVar) {
        this.f1278c.a(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b2 = this.g.b();
        if (!b2.isEmpty()) {
            return b2;
        }
        throw new NoImageHeaderParserException();
    }

    @Nullable
    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        s<Data, TResource, Transcode> a = this.i.a(cls, cls2, cls3);
        if (this.i.c(a)) {
            return null;
        }
        if (a == null) {
            List<i<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            a = f2.isEmpty() ? null : new s<>(cls, cls2, cls3, f2, this.j);
            this.i.d(cls, cls2, cls3, a);
        }
        return a;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        return this.a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a = this.h.a(cls, cls2, cls3);
        if (a == null) {
            a = new ArrayList<>();
            for (Class<?> cls4 : this.a.c(cls)) {
                for (Class<?> cls5 : this.f1278c.d(cls4, cls2)) {
                    if (!this.f1281f.b(cls5, cls3).isEmpty() && !a.contains(cls5)) {
                        a.add(cls5);
                    }
                }
            }
            this.h.b(cls, cls2, cls3, Collections.unmodifiableList(a));
        }
        return a;
    }

    @NonNull
    public <X> h<X> k(@NonNull u<X> uVar) throws NoResultEncoderAvailableException {
        h<X> b2 = this.f1279d.b(uVar.e());
        if (b2 != null) {
            return b2;
        }
        throw new NoResultEncoderAvailableException(uVar.e());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X x) {
        return this.f1280e.a(x);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> m(@NonNull X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> b2 = this.f1277b.b(x.getClass());
        if (b2 != null) {
            return b2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(@NonNull u<?> uVar) {
        return this.f1279d.b(uVar.e()) != null;
    }

    @NonNull
    public Registry o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry p(@NonNull e.a<?> aVar) {
        this.f1280e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry q(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.k.g.e<TResource, Transcode> eVar) {
        this.f1281f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.f(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final Registry s(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        for (String str : list) {
            arrayList.add(str);
        }
        arrayList.add("legacy_append");
        this.f1278c.e(arrayList);
        return this;
    }
}
