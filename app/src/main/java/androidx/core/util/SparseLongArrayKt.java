package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.collections.a0;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: SparseLongArray.kt */
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(SparseLongArray contains, int i) {
        j.f(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray containsKey, int i) {
        j.f(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray containsValue, long j) {
        j.f(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray forEach, p<? super Integer, ? super Long, kotlin.p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i)), Long.valueOf(forEach.valueAt(i)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray getOrDefault, int i, long j) {
        j.f(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray getOrElse, int i, a<Long> defaultValue) {
        j.f(getOrElse, "$this$getOrElse");
        j.f(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray size) {
        j.f(size, "$this$size");
        return size.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(18)
    public static final z keyIterator(final SparseLongArray keyIterator) {
        j.f(keyIterator, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
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
                SparseLongArray sparseLongArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray plus, SparseLongArray other) {
        j.f(plus, "$this$plus");
        j.f(other, "other");
        SparseLongArray sparseLongArray = new SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray putAll, SparseLongArray other) {
        j.f(putAll, "$this$putAll");
        j.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray remove, int i, long j) {
        j.f(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || j != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray set, int i, long j) {
        j.f(set, "$this$set");
        set.put(i, j);
    }

    @RequiresApi(18)
    public static final a0 valueIterator(final SparseLongArray valueIterator) {
        j.f(valueIterator, "$this$valueIterator");
        return new a0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.a0
            public long nextLong() {
                SparseLongArray sparseLongArray = valueIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
