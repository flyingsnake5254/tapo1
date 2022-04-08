package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.k;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: SparseBooleanArray.kt */
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray contains, int i) {
        j.f(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray containsKey, int i) {
        j.f(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray containsValue, boolean z) {
        j.f(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray forEach, p<? super Integer, ? super Boolean, kotlin.p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i)), Boolean.valueOf(forEach.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray getOrDefault, int i, boolean z) {
        j.f(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, z);
    }

    public static final boolean getOrElse(SparseBooleanArray getOrElse, int i, a<Boolean> defaultValue) {
        j.f(getOrElse, "$this$getOrElse");
        j.f(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray size) {
        j.f(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(SparseBooleanArray isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    public static final z keyIterator(final SparseBooleanArray keyIterator) {
        j.f(keyIterator, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
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
                SparseBooleanArray sparseBooleanArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray plus, SparseBooleanArray other) {
        j.f(plus, "$this$plus");
        j.f(other, "other");
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(plus.size() + other.size());
        putAll(sparseBooleanArray, plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(SparseBooleanArray putAll, SparseBooleanArray other) {
        j.f(putAll, "$this$putAll");
        j.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final boolean remove(SparseBooleanArray remove, int i, boolean z) {
        j.f(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || z != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.delete(i);
        return true;
    }

    public static final void set(SparseBooleanArray set, int i, boolean z) {
        j.f(set, "$this$set");
        set.put(i, z);
    }

    public static final k valueIterator(final SparseBooleanArray valueIterator) {
        j.f(valueIterator, "$this$valueIterator");
        return new k() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.k
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray = valueIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
