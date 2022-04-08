package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: SortedLists.java */
/* loaded from: classes2.dex */
final class z2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: SortedLists.java */
    /* loaded from: classes2.dex */
    public static abstract class b extends Enum<b> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f4667c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f4668d;

        /* renamed from: f  reason: collision with root package name */
        public static final b f4669f;
        private static final /* synthetic */ b[] q;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class a extends b {
            a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.b
            int a(int i) {
                return i - 1;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* renamed from: com.google.common.collect.z2$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0166b extends b {
            C0166b(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.b
            public int a(int i) {
                return i;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class c extends b {
            c(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.b
            public int a(int i) {
                return ~i;
            }
        }

        static {
            a aVar = new a("NEXT_LOWER", 0);
            f4667c = aVar;
            C0166b bVar = new C0166b("NEXT_HIGHER", 1);
            f4668d = bVar;
            c cVar = new c("INVERTED_INSERTION_INDEX", 2);
            f4669f = cVar;
            q = new b[]{aVar, bVar, cVar};
        }

        private b(String str, int i) {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) q.clone();
        }

        abstract int a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: SortedLists.java */
    /* loaded from: classes2.dex */
    public static abstract class c extends Enum<c> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f4670c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f4671d;

        /* renamed from: f  reason: collision with root package name */
        public static final c f4672f;
        public static final c q;
        public static final c x;
        private static final /* synthetic */ c[] y;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class a extends c {
            a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.c
            <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return i;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class b extends c {
            b(String str, int i) {
                super(str, i);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.z2.c
            <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare((Object) list.get(i2), e2) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* renamed from: com.google.common.collect.z2$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0167c extends c {
            C0167c(String str, int i) {
                super(str, i);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.z2.c
            <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare((Object) list.get(i3), e2) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class d extends c {
            d(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.c
            public <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return c.f4671d.a(comparator, e2, list, i) + 1;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes2.dex */
        static class e extends c {
            e(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.z2.c
            public <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return c.f4672f.a(comparator, e2, list, i) - 1;
            }
        }

        static {
            a aVar = new a("ANY_PRESENT", 0);
            f4670c = aVar;
            b bVar = new b("LAST_PRESENT", 1);
            f4671d = bVar;
            C0167c cVar = new C0167c("FIRST_PRESENT", 2);
            f4672f = cVar;
            d dVar = new d("FIRST_AFTER", 3);
            q = dVar;
            e eVar = new e("LAST_BEFORE", 4);
            x = eVar;
            y = new c[]{aVar, bVar, cVar, dVar, eVar};
        }

        private c(String str, int i) {
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) y.clone();
        }

        abstract <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i);
    }

    public static <E, K extends Comparable> int a(List<E> list, h<? super E, K> hVar, @NullableDecl K k, c cVar, b bVar) {
        return b(list, hVar, k, a2.g(), cVar, bVar);
    }

    public static <E, K> int b(List<E> list, h<? super E, K> hVar, @NullableDecl K k, Comparator<? super K> comparator, c cVar, b bVar) {
        return c(n1.m(list, hVar), k, comparator, cVar, bVar);
    }

    public static <E> int c(List<? extends E> list, @NullableDecl E e2, Comparator<? super E> comparator, c cVar, b bVar) {
        n.o(comparator);
        n.o(list);
        n.o(cVar);
        n.o(bVar);
        if (!(list instanceof RandomAccess)) {
            list = n1.i(list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e2, (Object) list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return i + cVar.a(comparator, e2, list.subList(i, size + 1), i2 - i);
            } else {
                i = i2 + 1;
            }
        }
        return bVar.a(i);
    }
}
