package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements t<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    @RetainedWith
    @MonotonicNonNullDecl
    private transient t<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    @NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends g<K, V> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        final K f4179c;

        /* renamed from: d  reason: collision with root package name */
        int f4180d;

        a(int i) {
            this.f4179c = HashBiMap.this.keys[i];
            this.f4180d = i;
        }

        void g() {
            int i = this.f4180d;
            if (i != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i <= hashBiMap.size && k.a(hashBiMap.keys[i], this.f4179c)) {
                    return;
                }
            }
            this.f4180d = HashBiMap.this.findEntryByKey(this.f4179c);
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K getKey() {
            return this.f4179c;
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            g();
            int i = this.f4180d;
            if (i == -1) {
                return null;
            }
            return HashBiMap.this.values[i];
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V setValue(V v) {
            g();
            int i = this.f4180d;
            if (i == -1) {
                return (V) HashBiMap.this.put(this.f4179c, v);
            }
            V v2 = HashBiMap.this.values[i];
            if (k.a(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.f4180d, v, false);
            return v2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<K, V> extends g<V, K> {

        /* renamed from: c  reason: collision with root package name */
        final HashBiMap<K, V> f4182c;

        /* renamed from: d  reason: collision with root package name */
        final V f4183d;

        /* renamed from: f  reason: collision with root package name */
        int f4184f;

        b(HashBiMap<K, V> hashBiMap, int i) {
            this.f4182c = hashBiMap;
            this.f4183d = hashBiMap.values[i];
            this.f4184f = i;
        }

        private void g() {
            int i = this.f4184f;
            if (i != -1) {
                HashBiMap<K, V> hashBiMap = this.f4182c;
                if (i <= hashBiMap.size && k.a(this.f4183d, hashBiMap.values[i])) {
                    return;
                }
            }
            this.f4184f = this.f4182c.findEntryByValue(this.f4183d);
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V getKey() {
            return this.f4183d;
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K getValue() {
            g();
            int i = this.f4184f;
            if (i == -1) {
                return null;
            }
            return this.f4182c.keys[i];
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K setValue(K k) {
            g();
            int i = this.f4184f;
            if (i == -1) {
                return this.f4182c.putInverse(this.f4183d, k, false);
            }
            K k2 = this.f4182c.keys[i];
            if (k.a(k2, k)) {
                return k;
            }
            this.f4182c.replaceKeyInEntry(this.f4184f, k, false);
            return k2;
        }
    }

    /* loaded from: classes2.dex */
    final class c extends h<K, V, Map.Entry<K, V>> {
        c() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(int i) {
            return new a(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && k.a(value, HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d2 = y0.d(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, d2);
            if (findEntryByKey == -1 || !k.a(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d2);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    static class d<K, V> extends AbstractMap<V, K> implements t<V, K>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final HashBiMap<K, V> f4186c;

        /* renamed from: d  reason: collision with root package name */
        private transient Set<Map.Entry<V, K>> f4187d;

        d(HashBiMap<K, V> hashBiMap) {
            this.f4186c = hashBiMap;
        }

        /* renamed from: a */
        public Set<K> values() {
            return this.f4186c.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f4186c.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.f4186c.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.f4186c.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f4187d;
            if (set != null) {
                return set;
            }
            e eVar = new e(this.f4186c);
            this.f4187d = eVar;
            return eVar;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.f4186c.getInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.f4186c.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.f4186c.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            return this.f4186c.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4186c.size;
        }
    }

    /* loaded from: classes2.dex */
    static class e<K, V> extends h<K, V, Map.Entry<V, K>> {
        e(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<V, K> a(int i) {
            return new b(this.f4190c, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.f4190c.findEntryByValue(key);
            return findEntryByValue != -1 && k.a(this.f4190c.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d2 = y0.d(key);
            int findEntryByValue = this.f4190c.findEntryByValue(key, d2);
            if (findEntryByValue == -1 || !k.a(this.f4190c.keys[findEntryByValue], value)) {
                return false;
            }
            this.f4190c.removeEntryValueHashKnown(findEntryByValue, d2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class f extends h<K, V, K> {
        f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.h
        K a(int i) {
            return HashBiMap.this.keys[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int d2 = y0.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d2);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class g extends h<K, V, V> {
        g() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.h
        V a(int i) {
            return HashBiMap.this.values[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int d2 = y0.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d2);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class h<K, V, T> extends AbstractSet<T> {

        /* renamed from: c  reason: collision with root package name */
        final HashBiMap<K, V> f4190c;

        /* loaded from: classes2.dex */
        class a implements Iterator<T> {

            /* renamed from: c  reason: collision with root package name */
            private int f4191c;

            /* renamed from: d  reason: collision with root package name */
            private int f4192d = -1;

            /* renamed from: f  reason: collision with root package name */
            private int f4193f;
            private int q;

            a() {
                this.f4191c = ((HashBiMap) h.this.f4190c).firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = h.this.f4190c;
                this.f4193f = hashBiMap.modCount;
                this.q = hashBiMap.size;
            }

            private void a() {
                if (h.this.f4190c.modCount != this.f4193f) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f4191c != -2 && this.q > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t = (T) h.this.a(this.f4191c);
                    this.f4192d = this.f4191c;
                    this.f4191c = ((HashBiMap) h.this.f4190c).nextInInsertionOrder[this.f4191c];
                    this.q--;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                v.e(this.f4192d != -1);
                h.this.f4190c.removeEntry(this.f4192d);
                int i = this.f4191c;
                HashBiMap<K, V> hashBiMap = h.this.f4190c;
                if (i == hashBiMap.size) {
                    this.f4191c = this.f4192d;
                }
                this.f4192d = -1;
                this.f4193f = hashBiMap.modCount;
            }
        }

        h(HashBiMap<K, V> hashBiMap) {
            this.f4190c = hashBiMap;
        }

        abstract T a(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4190c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4190c.size;
        }
    }

    private HashBiMap(int i) {
        init(i);
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i, int i2) {
        n.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        i3 = this.nextInBucketKToV[i3];
        while (i3 != -1) {
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i3] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i3 = this.nextInBucketKToV[i3];
        }
        throw new AssertionError("Expected to find entry with key " + this.keys[i]);
    }

    private void deleteFromTableVToK(int i, int i2) {
        n.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        i3 = this.nextInBucketVToK[i3];
        while (i3 != -1) {
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i3] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i3 = this.nextInBucketVToK[i3];
        }
        throw new AssertionError("Expected to find entry with value " + this.values[i]);
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int e2 = ImmutableCollection.b.e(iArr.length, i);
            this.keys = (K[]) Arrays.copyOf(this.keys, e2);
            this.values = (V[]) Arrays.copyOf(this.values, e2);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, e2);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, e2);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, e2);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, e2);
        }
        if (this.hashTableKToV.length < i) {
            int a2 = y0.a(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            for (int i2 = 0; i2 < this.size; i2++) {
                int bucket = bucket(y0.d(this.keys[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(y0.d(this.values[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i, int i2) {
        n.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        n.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void moveEntryToIndex(int i, int i2) {
        if (i != i2) {
            int i3 = this.prevInInsertionOrder[i];
            int i4 = this.nextInInsertionOrder[i];
            setSucceeds(i3, i2);
            setSucceeds(i2, i4);
            K[] kArr = this.keys;
            K k = kArr[i];
            V[] vArr = this.values;
            V v = vArr[i];
            kArr[i2] = k;
            vArr[i2] = v;
            int bucket = bucket(y0.d(k));
            int[] iArr = this.hashTableKToV;
            if (iArr[bucket] == i) {
                iArr[bucket] = i2;
            } else {
                int i5 = iArr[bucket];
                i5 = this.nextInBucketKToV[i5];
                while (i5 != i) {
                    i5 = this.nextInBucketKToV[i5];
                }
                this.nextInBucketKToV[i5] = i2;
            }
            int[] iArr2 = this.nextInBucketKToV;
            iArr2[i2] = iArr2[i];
            iArr2[i] = -1;
            int bucket2 = bucket(y0.d(v));
            int[] iArr3 = this.hashTableVToK;
            if (iArr3[bucket2] == i) {
                iArr3[bucket2] = i2;
            } else {
                int i6 = iArr3[bucket2];
                i6 = this.nextInBucketVToK[i6];
                while (i6 != i) {
                    i6 = this.nextInBucketVToK[i6];
                }
                this.nextInBucketVToK[i6] = i2;
            }
            int[] iArr4 = this.nextInBucketVToK;
            iArr4[i2] = iArr4[i];
            iArr4[i] = -1;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h2 = r2.h(objectInputStream);
        init(16);
        r2.c(this, objectInputStream, h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, @NullableDecl K k, boolean z) {
        n.d(i != -1);
        int d2 = y0.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        int i2 = this.lastInInsertionOrder;
        int i3 = -2;
        if (findEntryByKey != -1) {
            if (z) {
                i2 = this.prevInInsertionOrder[findEntryByKey];
                i3 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, d2);
                if (i == this.size) {
                    i = findEntryByKey;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
        }
        if (i2 == i) {
            i2 = this.prevInInsertionOrder[i];
        } else if (i2 == this.size) {
            i2 = findEntryByKey;
        }
        if (i3 == i) {
            findEntryByKey = this.nextInInsertionOrder[i];
        } else if (i3 != this.size) {
            findEntryByKey = i3;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, y0.d(this.keys[i]));
        this.keys[i] = k;
        insertIntoTableKToV(i, y0.d(k));
        setSucceeds(i2, i);
        setSucceeds(i, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, @NullableDecl V v, boolean z) {
        n.d(i != -1);
        int d2 = y0.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            if (z) {
                removeEntryValueHashKnown(findEntryByValue, d2);
                if (i == this.size) {
                    i = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        deleteFromTableVToK(i, y0.d(this.values[i]));
        this.values[i] = v;
        insertIntoTableVToK(i, d2);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        r2.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    int findEntry(@NullableDecl Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (k.a(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    int findEntryByKey(@NullableDecl Object obj) {
        return findEntryByKey(obj, y0.d(obj));
    }

    int findEntryByValue(@NullableDecl Object obj) {
        return findEntryByValue(obj, y0.d(obj));
    }

    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @NullableDecl
    K getInverse(@NullableDecl Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    void init(int i) {
        v.b(i, "expectedSize");
        int a2 = y0.a(i, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i];
        this.values = (V[]) new Object[i];
        this.hashTableKToV = createFilledWithAbsent(a2);
        this.hashTableVToK = createFilledWithAbsent(a2);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    public t<V, K> inverse() {
        t<V, K> tVar = this.inverse;
        if (tVar != null) {
            return tVar;
        }
        d dVar = new d(this);
        this.inverse = dVar;
        return dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.keySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, false);
    }

    @NullableDecl
    K putInverse(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int d2 = y0.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (k.a(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int d3 = y0.d(k);
        int findEntryByKey = findEntryByKey(k, d3);
        if (!z) {
            n.j(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, d3);
        insertIntoTableVToK(this.size, d2);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.size);
        setSucceeds(this.size, i3);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int d2 = y0.d(obj);
        int findEntryByKey = findEntryByKey(obj, d2);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d2);
        return v;
    }

    void removeEntry(int i) {
        removeEntryKeyHashKnown(i, y0.d(this.keys[i]));
    }

    void removeEntryKeyHashKnown(int i, int i2) {
        removeEntry(i, i2, y0.d(this.values[i]));
    }

    void removeEntryValueHashKnown(int i, int i2) {
        removeEntry(i, y0.d(this.keys[i]), i2);
    }

    @NullableDecl
    K removeInverse(@NullableDecl Object obj) {
        int d2 = y0.d(obj);
        int findEntryByValue = findEntryByValue(obj, d2);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d2);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    private void removeEntry(int i, int i2, int i3) {
        n.d(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.size - 1, i);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4 - 1] = null;
        this.values[i4 - 1] = null;
        this.size = i4 - 1;
        this.modCount++;
    }

    int findEntryByKey(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int d2 = y0.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (k.a(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int d3 = y0.d(v);
        int findEntryByValue = findEntryByValue(v, d3);
        if (!z) {
            n.j(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i = this.size;
        kArr[i] = k;
        this.values[i] = v;
        insertIntoTableKToV(i, d2);
        insertIntoTableVToK(this.size, d3);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.valueSet = gVar;
        return gVar;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
