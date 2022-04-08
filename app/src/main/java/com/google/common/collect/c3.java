package com.google.common.collect;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.f3;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SparseImmutableTable.java */
@Immutable(containerOf = {"R", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
/* loaded from: classes2.dex */
final class c3<R, C, V> extends o2<R, C, V> {

    /* renamed from: c  reason: collision with root package name */
    static final ImmutableTable<Object, Object, Object> f4383c = new c3(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableMap<R, ImmutableMap<C, V>> f4384d;

    /* renamed from: f  reason: collision with root package name */
    private final ImmutableMap<C, ImmutableMap<R, V>> f4385f;
    private final int[] q;
    private final int[] x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c3(ImmutableList<f3.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap j = q1.j(immutableSet);
        LinkedHashMap r = q1.r();
        j3<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            r.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap r2 = q1.r();
        j3<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            r2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            f3.a<R, C, V> aVar = immutableList.get(i);
            R a = aVar.a();
            C b2 = aVar.b();
            V value = aVar.getValue();
            iArr[i] = ((Integer) j.get(a)).intValue();
            Map map = (Map) r.get(a);
            iArr2[i] = map.size();
            a(a, b2, map.put(b2, value), value);
            ((Map) r2.get(b2)).put(a, value);
        }
        this.q = iArr;
        this.x = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(r.size());
        for (Map.Entry entry : r.entrySet()) {
            bVar.c(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.f4384d = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(r2.size());
        for (Map.Entry entry2 : r2.entrySet()) {
            bVar2.c(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.f4385f = bVar2.a();
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.b createSerializedForm() {
        ImmutableMap j = q1.j(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        j3<f3.a<R, C, V>> it = cellSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            iArr[i] = ((Integer) j.get(it.next().b())).intValue();
        }
        return ImmutableTable.b.a(this, this.q, iArr);
    }

    @Override // com.google.common.collect.o2
    f3.a<R, C, V> getCell(int i) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.f4384d.entrySet().asList().get(this.q[i]);
        Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.x[i]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.o2
    V getValue(int i) {
        int i2 = this.q[i];
        return this.f4384d.values().asList().get(i2).values().asList().get(this.x[i]);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public int size() {
        return this.q.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.f4385f);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.f4384d);
    }
}
