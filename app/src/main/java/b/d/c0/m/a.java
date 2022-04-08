package b.d.c0.m;

import com.tplink.tdp.tlv.adapter.CollectionAdapterFactory;
import com.tplink.tdp.tlv.adapter.TLVAdapters;
import com.tplink.tdp.tlv.adapter.TLVStructureAdapterFactory;
import com.tplink.tdp.tlv.adapter.c;
import com.tplink.tdp.tlv.adapter.d;
import com.tplink.tdp.tlv.adapter.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TLV.java */
/* loaded from: classes3.dex */
public class a {
    private final Map<e<?>, c<?>> a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private List<d> f175b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private short[] f176c;

    public a() {
        com.tplink.tdp.tlv.adapter.a aVar = new com.tplink.tdp.tlv.adapter.a();
        this.f175b.add(TLVAdapters.f15222b);
        this.f175b.add(TLVAdapters.f15224d);
        this.f175b.add(TLVAdapters.n);
        this.f175b.add(TLVAdapters.p);
        this.f175b.add(TLVAdapters.j);
        this.f175b.add(TLVAdapters.l);
        this.f175b.add(TLVAdapters.f15226f);
        this.f175b.add(TLVAdapters.h);
        this.f175b.add(TLVAdapters.r);
        this.f175b.add(TLVAdapters.t);
        this.f175b.add(new CollectionAdapterFactory(aVar));
        this.f175b.add(new TLVStructureAdapterFactory(aVar));
    }

    public <T> T a(byte[] bArr, Class<T> cls) {
        if (!(bArr == null || bArr.length == 0)) {
            b.d.c0.m.e.a aVar = new b.d.c0.m.e.a(bArr);
            c<T> b2 = b(new e<>(cls));
            if (b2 != null) {
                return b2.a(aVar);
            }
        }
        return null;
    }

    public <T> c<T> b(e<T> eVar) {
        c<T> cVar = (c<T>) this.a.get(eVar);
        if (cVar != null) {
            return cVar;
        }
        for (d dVar : this.f175b) {
            c<T> a = dVar.a(this, eVar);
            if (a != null) {
                this.a.put(eVar, a);
                return a;
            }
        }
        return null;
    }

    public short[] c() {
        return this.f176c;
    }
}
