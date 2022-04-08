package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> contains, long j) {
        j.f(contains, "$this$contains");
        return contains.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> containsKey, long j) {
        j.f(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> containsValue, T t) {
        j.f(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> forEach, p<? super Long, ? super T, kotlin.p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Long.valueOf(forEach.keyAt(i)), forEach.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> getOrDefault, long j, T t) {
        j.f(getOrDefault, "$this$getOrDefault");
        T t2 = getOrDefault.get(j);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> getOrElse, long j, a<? extends T> defaultValue) {
        j.f(getOrElse, "$this$getOrElse");
        j.f(defaultValue, "defaultValue");
        T t = getOrElse.get(j);
        return t != null ? t : (T) defaultValue.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> size) {
        j.f(size, "$this$size");
        return size.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> a0 keyIterator(final LongSparseArray<T> keyIterator) {
        j.f(keyIterator, "$this$keyIterator");
        return new a0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.a0
            public long nextLong() {
                LongSparseArray longSparseArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> plus, LongSparseArray<T> other) {
        j.f(plus, "$this$plus");
        j.f(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(plus.size() + other.size());
        putAll(longSparseArray, plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> putAll, LongSparseArray<T> other) {
        j.f(putAll, "$this$putAll");
        j.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> remove, long j, T t) {
        j.f(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(j);
        if (indexOfKey < 0 || !j.a(t, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> set, long j, T t) {
        j.f(set, "$this$set");
        set.put(j, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> valueIterator) {
        j.f(valueIterator, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(valueIterator);
    }
}
