package io.netty.util.collection;

import java.util.Map;

/* loaded from: classes3.dex */
public interface CharObjectMap<V> extends Map<Character, V> {

    /* loaded from: classes3.dex */
    public interface PrimitiveEntry<V> {
        char key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(char c2);

    Iterable<PrimitiveEntry<V>> entries();

    V get(char c2);

    V put(char c2, V v);

    V remove(char c2);
}
