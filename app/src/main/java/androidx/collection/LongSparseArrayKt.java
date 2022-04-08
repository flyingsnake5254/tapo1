package androidx.collection;

import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> receiver$0, long j) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> receiver$0, p<? super Long, ? super T, kotlin.p> action) {
        j.f(receiver$0, "receiver$0");
        j.f(action, "action");
        int size = receiver$0.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Long.valueOf(receiver$0.keyAt(i)), receiver$0.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> receiver$0, long j, T t) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.get(j, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> receiver$0, long j, a<? extends T> defaultValue) {
        j.f(receiver$0, "receiver$0");
        j.f(defaultValue, "defaultValue");
        T t = receiver$0.get(j);
        return t != null ? t : (T) defaultValue.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> a0 keyIterator(final LongSparseArray<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return new a0() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.a0
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> receiver$0, LongSparseArray<T> other) {
        j.f(receiver$0, "receiver$0");
        j.f(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    public static final <T> boolean remove(LongSparseArray<T> receiver$0, long j, T t) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.remove(j, t);
    }

    public static final <T> void set(LongSparseArray<T> receiver$0, long j, T t) {
        j.f(receiver$0, "receiver$0");
        receiver$0.put(j, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
