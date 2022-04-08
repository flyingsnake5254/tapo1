package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> contains, int i) {
        j.f(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> containsKey, int i) {
        j.f(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> containsValue, T t) {
        j.f(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> forEach, p<? super Integer, ? super T, kotlin.p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i)), forEach.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> getOrDefault, int i, T t) {
        j.f(getOrDefault, "$this$getOrDefault");
        T t2 = getOrDefault.get(i);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(SparseArray<T> getOrElse, int i, a<? extends T> defaultValue) {
        j.f(getOrElse, "$this$getOrElse");
        j.f(defaultValue, "defaultValue");
        T t = getOrElse.get(i);
        return t != null ? t : (T) defaultValue.invoke();
    }

    public static final <T> int getSize(SparseArray<T> size) {
        j.f(size, "$this$size");
        return size.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    public static final <T> z keyIterator(final SparseArray<T> keyIterator) {
        j.f(keyIterator, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.z
            public int nextInt() {
                SparseArray sparseArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> plus, SparseArray<T> other) {
        j.f(plus, "$this$plus");
        j.f(other, "other");
        SparseArray<T> sparseArray = new SparseArray<>(plus.size() + other.size());
        putAll(sparseArray, plus);
        putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> void putAll(SparseArray<T> putAll, SparseArray<T> other) {
        j.f(putAll, "$this$putAll");
        j.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final <T> boolean remove(SparseArray<T> remove, int i, T t) {
        j.f(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || !j.a(t, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> set, int i, T t) {
        j.f(set, "$this$set");
        set.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> valueIterator) {
        j.f(valueIterator, "$this$valueIterator");
        return new SparseArrayKt$valueIterator$1(valueIterator);
    }
}
