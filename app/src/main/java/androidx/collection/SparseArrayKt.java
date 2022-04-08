package androidx.collection;

import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> receiver$0, int i) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> receiver$0, p<? super Integer, ? super T, kotlin.p> action) {
        j.f(receiver$0, "receiver$0");
        j.f(action, "action");
        int size = receiver$0.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(receiver$0.keyAt(i)), receiver$0.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> receiver$0, int i, T t) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.get(i, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> receiver$0, int i, a<? extends T> defaultValue) {
        j.f(receiver$0, "receiver$0");
        j.f(defaultValue, "defaultValue");
        T t = receiver$0.get(i);
        return t != null ? t : (T) defaultValue.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> z keyIterator(final SparseArrayCompat<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return new z() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.z
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i = this.index;
                this.index = i + 1;
                return sparseArrayCompat.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> receiver$0, SparseArrayCompat<T> other) {
        j.f(receiver$0, "receiver$0");
        j.f(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(receiver$0.size() + other.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    public static final <T> boolean remove(SparseArrayCompat<T> receiver$0, int i, T t) {
        j.f(receiver$0, "receiver$0");
        return receiver$0.remove(i, t);
    }

    public static final <T> void set(SparseArrayCompat<T> receiver$0, int i, T t) {
        j.f(receiver$0, "receiver$0");
        receiver$0.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> receiver$0) {
        j.f(receiver$0, "receiver$0");
        return new SparseArrayKt$valueIterator$1(receiver$0);
    }
}
