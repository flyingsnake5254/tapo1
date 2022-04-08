package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.k.g.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {
    private final Class<DataType> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends g<DataType, ResourceType>> f1455b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f1456c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f1457d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1458e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodePath.java */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        @NonNull
        u<ResourceType> a(@NonNull u<ResourceType> uVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends g<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.f1455b = list;
        this.f1456c = eVar;
        this.f1457d = pool;
        this.f1458e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private u<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, @NonNull f fVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.util.i.d(this.f1457d.acquire());
        try {
            return c(eVar, i, i2, fVar, list);
        } finally {
            this.f1457d.release(list);
        }
    }

    @NonNull
    private u<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, @NonNull f fVar, List<Throwable> list) throws GlideException {
        int size = this.f1455b.size();
        u<ResourceType> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1455b.get(i3);
            try {
                if (gVar.a(eVar.a(), fVar)) {
                    uVar = gVar.b(eVar.a(), i, i2, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + gVar, e2);
                }
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f1458e, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, @NonNull f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f1456c.a(aVar.a(b(eVar, i, i2, fVar)), fVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.f1455b + ", transcoder=" + this.f1456c + '}';
    }
}
