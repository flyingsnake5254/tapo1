package androidx.collection;

import kotlin.Pair;
import kotlin.jvm.internal.j;

/* compiled from: ArrayMap.kt */
/* loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairs) {
        j.f(pairs, "pairs");
        ArrayMap<K, V> arrayMap = (ArrayMap<K, V>) new ArrayMap(pairs.length);
        for (Pair<? extends K, ? extends V> pair : pairs) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
