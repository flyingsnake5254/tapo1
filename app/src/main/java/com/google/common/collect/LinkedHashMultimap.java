package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.collect.u2;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends l1<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient b<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        b<K, V> f4280c;
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        b<K, V> f4281d;

        a() {
            this.f4280c = LinkedHashMultimap.this.multimapHeaderEntry.p0;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                b<K, V> bVar = this.f4280c;
                this.f4281d = bVar;
                this.f4280c = bVar.p0;
                return bVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4280c != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            v.e(this.f4281d != null);
            LinkedHashMultimap.this.remove(this.f4281d.getKey(), this.f4281d.getValue());
            this.f4281d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<K, V> extends a1<K, V> implements d<K, V> {

        /* renamed from: f  reason: collision with root package name */
        final int f4283f;
        @NullableDecl
        b<K, V> p0;
        @NullableDecl
        b<K, V> q;
        @NullableDecl
        d<K, V> x;
        @NullableDecl
        d<K, V> y;
        @NullableDecl
        b<K, V> z;

        b(@NullableDecl K k, @NullableDecl V v, int i, @NullableDecl b<K, V> bVar) {
            super(k, v);
            this.f4283f = i;
            this.q = bVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> a() {
            return this.x;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            return this.y;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.y = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void f(d<K, V> dVar) {
            this.x = dVar;
        }

        public b<K, V> g() {
            return this.z;
        }

        public b<K, V> h() {
            return this.p0;
        }

        boolean i(@NullableDecl Object obj, int i) {
            return this.f4283f == i && k.a(getValue(), obj);
        }

        public void j(b<K, V> bVar) {
            this.z = bVar;
        }

        public void k(b<K, V> bVar) {
            this.p0 = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends u2.b<V> implements d<K, V> {

        /* renamed from: c  reason: collision with root package name */
        private final K f4284c;

        /* renamed from: d  reason: collision with root package name */
        b<K, V>[] f4285d;

        /* renamed from: f  reason: collision with root package name */
        private int f4286f = 0;
        private int q = 0;
        private d<K, V> x = this;
        private d<K, V> y = this;

        /* loaded from: classes2.dex */
        class a implements Iterator<V> {

            /* renamed from: c  reason: collision with root package name */
            d<K, V> f4287c;
            @NullableDecl

            /* renamed from: d  reason: collision with root package name */
            b<K, V> f4288d;

            /* renamed from: f  reason: collision with root package name */
            int f4289f;

            a() {
                this.f4287c = c.this.x;
                this.f4289f = c.this.q;
            }

            private void a() {
                if (c.this.q != this.f4289f) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f4287c != c.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    b<K, V> bVar = (b) this.f4287c;
                    V value = bVar.getValue();
                    this.f4288d = bVar;
                    this.f4287c = bVar.b();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                v.e(this.f4288d != null);
                c.this.remove(this.f4288d.getValue());
                this.f4289f = c.this.q;
                this.f4288d = null;
            }
        }

        c(K k, int i) {
            this.f4284c = k;
            this.f4285d = new b[y0.a(i, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        private int g() {
            return this.f4285d.length - 1;
        }

        private void h() {
            if (y0.b(this.f4286f, this.f4285d.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)) {
                int length = this.f4285d.length * 2;
                b<K, V>[] bVarArr = new b[length];
                this.f4285d = bVarArr;
                int i = length - 1;
                for (d<K, V> dVar = this.x; dVar != this; dVar = dVar.b()) {
                    b<K, V> bVar = (b) dVar;
                    int i2 = bVar.f4283f & i;
                    bVar.q = bVarArr[i2];
                    bVarArr[i2] = bVar;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> a() {
            return this.y;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@NullableDecl V v) {
            int d2 = y0.d(v);
            int g = g() & d2;
            b<K, V> bVar = this.f4285d[g];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.q) {
                if (bVar2.i(v, d2)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.f4284c, v, d2, bVar);
            LinkedHashMultimap.succeedsInValueSet(this.y, bVar3);
            LinkedHashMultimap.succeedsInValueSet(bVar3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.g(), bVar3);
            LinkedHashMultimap.succeedsInMultimap(bVar3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f4285d[g] = bVar3;
            this.f4286f++;
            this.q++;
            h();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            return this.x;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f4285d, (Object) null);
            this.f4286f = 0;
            for (d<K, V> dVar = this.x; dVar != this; dVar = dVar.b()) {
                LinkedHashMultimap.deleteFromMultimap((b) dVar);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.q++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            int d2 = y0.d(obj);
            for (b<K, V> bVar = this.f4285d[g() & d2]; bVar != null; bVar = bVar.q) {
                if (bVar.i(obj, d2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.x = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void f(d<K, V> dVar) {
            this.y = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            int d2 = y0.d(obj);
            int g = g() & d2;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.f4285d[g]; bVar2 != null; bVar2 = bVar2.q) {
                if (bVar2.i(obj, d2)) {
                    if (bVar == null) {
                        this.f4285d[g] = bVar2.q;
                    } else {
                        bVar.q = bVar2.q;
                    }
                    LinkedHashMultimap.deleteFromValueSet(bVar2);
                    LinkedHashMultimap.deleteFromMultimap(bVar2);
                    this.f4286f--;
                    this.q++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4286f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d<K, V> {
        d<K, V> a();

        d<K, V> b();

        void d(d<K, V> dVar);

        void f(d<K, V> dVar);
    }

    private LinkedHashMultimap(int i, int i2) {
        super(c2.e(i));
        this.valueSetCapacity = 2;
        v.b(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.multimapHeaderEntry = bVar;
        succeedsInMultimap(bVar, bVar);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(b<K, V> bVar) {
        succeedsInMultimap(bVar.g(), bVar.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(d<K, V> dVar) {
        succeedsInValueSet(dVar.a(), dVar.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.multimapHeaderEntry = bVar;
        succeedsInMultimap(bVar, bVar);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        Map e2 = c2.e(12);
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            e2.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) e2.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(b<K, V> bVar, b<K, V> bVar2) {
        bVar.k(bVar2);
        bVar2.j(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(d<K, V> dVar, d<K, V> dVar2) {
        dVar.d(dVar2);
        dVar2.f(dVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (K k : keySet()) {
            objectOutputStream.writeObject(k);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.m, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public void clear() {
        super.clear();
        b<K, V> bVar = this.multimapHeaderEntry;
        succeedsInMultimap(bVar, bVar);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean containsKey(@NullableDecl Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.h
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Set get(@NullableDecl Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ u1 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(r1 r1Var) {
        return super.putAll(r1Var);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@NullableDecl Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h
    Iterator<V> valueIterator() {
        return q1.D(entryIterator());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(q1.d(i), q1.d(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.m, com.google.common.collect.e
    public Set<V> createCollection() {
        return c2.f(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.e
    public Collection<V> createCollection(K k) {
        return new c(k, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(r1<? extends K, ? extends V> r1Var) {
        LinkedHashMultimap<K, V> create = create(r1Var.keySet().size(), 2);
        create.putAll(r1Var);
        return create;
    }
}
