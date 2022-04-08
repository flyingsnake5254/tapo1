package com.google.common.collect;

import com.google.common.base.n;
import java.util.AbstractMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableMap.java */
/* loaded from: classes2.dex */
public final class j2<K, V> extends ImmutableMap<K, V> {

    /* renamed from: c  reason: collision with root package name */
    static final ImmutableMap<Object, Object> f4494c = new j2(null, new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    private final transient int[] f4495d;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f4496f;
    private final transient int q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes2.dex */
    public static class a<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableMap<K, V> f4497c;

        /* renamed from: d  reason: collision with root package name */
        private final transient Object[] f4498d;

        /* renamed from: f  reason: collision with root package name */
        private final transient int f4499f;
        private final transient int q;

        /* compiled from: RegularImmutableMap.java */
        /* renamed from: com.google.common.collect.j2$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0160a extends ImmutableList<Map.Entry<K, V>> {
            C0160a() {
            }

            /* renamed from: a */
            public Map.Entry<K, V> get(int i) {
                n.m(i, a.this.q);
                int i2 = i * 2;
                return new AbstractMap.SimpleImmutableEntry(a.this.f4498d[a.this.f4499f + i2], a.this.f4498d[i2 + (a.this.f4499f ^ 1)]);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.q;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.f4497c = immutableMap;
            this.f4498d = objArr;
            this.f4499f = i;
            this.q = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f4497c.get(key));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new C0160a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.q;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public j3<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes2.dex */
    static final class b<K> extends ImmutableSet<K> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableMap<K, ?> f4501c;

        /* renamed from: d  reason: collision with root package name */
        private final transient ImmutableList<K> f4502d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f4501c = immutableMap;
            this.f4502d = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f4502d;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f4501c.get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4501c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public j3<K> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes2.dex */
    static final class c extends ImmutableList<Object> {

        /* renamed from: c  reason: collision with root package name */
        private final transient Object[] f4503c;

        /* renamed from: d  reason: collision with root package name */
        private final transient int f4504d;

        /* renamed from: f  reason: collision with root package name */
        private final transient int f4505f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Object[] objArr, int i, int i2) {
            this.f4503c = objArr;
            this.f4504d = i;
            this.f4505f = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            n.m(i, this.f4505f);
            return this.f4503c[(i * 2) + this.f4504d];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4505f;
        }
    }

    private j2(int[] iArr, Object[] objArr, int i) {
        this.f4495d = iArr;
        this.f4496f = objArr;
        this.q = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> j2<K, V> a(int i, Object[] objArr) {
        if (i == 0) {
            return (j2) f4494c;
        }
        if (i == 1) {
            v.a(objArr[0], objArr[1]);
            return new j2<>(null, objArr, 1);
        }
        n.r(i, objArr.length >> 1);
        return new j2<>(b(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] b(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            r0 = 1
            if (r11 != r0) goto L_0x000e
            r11 = r10[r13]
            r12 = r13 ^ 1
            r10 = r10[r12]
            com.google.common.collect.v.a(r11, r10)
            r10 = 0
            return r10
        L_0x000e:
            int r1 = r12 + (-1)
            int[] r12 = new int[r12]
            r2 = -1
            java.util.Arrays.fill(r12, r2)
            r3 = 0
        L_0x0017:
            if (r3 >= r11) goto L_0x0077
            int r4 = r3 * 2
            int r5 = r4 + r13
            r6 = r10[r5]
            r7 = r13 ^ 1
            int r4 = r4 + r7
            r4 = r10[r4]
            com.google.common.collect.v.a(r6, r4)
            int r7 = r6.hashCode()
            int r7 = com.google.common.collect.y0.c(r7)
        L_0x002f:
            r7 = r7 & r1
            r8 = r12[r7]
            if (r8 != r2) goto L_0x0039
            r12[r7] = r5
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0039:
            r9 = r10[r8]
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x0044
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0044:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Multiple entries with same key: "
            r12.append(r13)
            r12.append(r6)
            java.lang.String r13 = "="
            r12.append(r13)
            r12.append(r4)
            java.lang.String r1 = " and "
            r12.append(r1)
            r1 = r10[r8]
            r12.append(r1)
            r12.append(r13)
            r13 = r8 ^ 1
            r10 = r10[r13]
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x0077:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.j2.b(java.lang.Object[], int, int, int):int[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i, int i2, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int c2 = y0.c(obj.hashCode());
            while (true) {
                int i3 = c2 & length;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    return null;
                }
                if (objArr[i4].equals(obj)) {
                    return objArr[i4 ^ 1];
                }
                c2 = i3 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new a(this, this.f4496f, 0, this.q);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new b(this, new c(this.f4496f, 0, this.q));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new c(this.f4496f, 1, this.q);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) d(this.f4495d, this.f4496f, this.q, 0, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.q;
    }
}
