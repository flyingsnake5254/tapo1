package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface Headers<K, V, T extends Headers<K, V, T>> extends Iterable<Map.Entry<K, V>> {
    T add(Headers<? extends K, ? extends V, ?> headers);

    T add(K k, Iterable<? extends V> iterable);

    T add(K k, V v);

    T add(K k, V... vArr);

    T addBoolean(K k, boolean z);

    T addByte(K k, byte b2);

    T addChar(K k, char c2);

    T addDouble(K k, double d2);

    T addFloat(K k, float f2);

    T addInt(K k, int i);

    T addLong(K k, long j);

    T addObject(K k, Iterable<?> iterable);

    T addObject(K k, Object obj);

    T addObject(K k, Object... objArr);

    T addShort(K k, short s);

    T addTimeMillis(K k, long j);

    T clear();

    boolean contains(K k);

    boolean contains(K k, V v);

    boolean containsBoolean(K k, boolean z);

    boolean containsByte(K k, byte b2);

    boolean containsChar(K k, char c2);

    boolean containsDouble(K k, double d2);

    boolean containsFloat(K k, float f2);

    boolean containsInt(K k, int i);

    boolean containsLong(K k, long j);

    boolean containsObject(K k, Object obj);

    boolean containsShort(K k, short s);

    boolean containsTimeMillis(K k, long j);

    V get(K k);

    V get(K k, V v);

    List<V> getAll(K k);

    List<V> getAllAndRemove(K k);

    V getAndRemove(K k);

    V getAndRemove(K k, V v);

    Boolean getBoolean(K k);

    boolean getBoolean(K k, boolean z);

    Boolean getBooleanAndRemove(K k);

    boolean getBooleanAndRemove(K k, boolean z);

    byte getByte(K k, byte b2);

    Byte getByte(K k);

    byte getByteAndRemove(K k, byte b2);

    Byte getByteAndRemove(K k);

    char getChar(K k, char c2);

    Character getChar(K k);

    char getCharAndRemove(K k, char c2);

    Character getCharAndRemove(K k);

    double getDouble(K k, double d2);

    Double getDouble(K k);

    double getDoubleAndRemove(K k, double d2);

    Double getDoubleAndRemove(K k);

    float getFloat(K k, float f2);

    Float getFloat(K k);

    float getFloatAndRemove(K k, float f2);

    Float getFloatAndRemove(K k);

    int getInt(K k, int i);

    Integer getInt(K k);

    int getIntAndRemove(K k, int i);

    Integer getIntAndRemove(K k);

    long getLong(K k, long j);

    Long getLong(K k);

    long getLongAndRemove(K k, long j);

    Long getLongAndRemove(K k);

    Short getShort(K k);

    short getShort(K k, short s);

    Short getShortAndRemove(K k);

    short getShortAndRemove(K k, short s);

    long getTimeMillis(K k, long j);

    Long getTimeMillis(K k);

    long getTimeMillisAndRemove(K k, long j);

    Long getTimeMillisAndRemove(K k);

    boolean isEmpty();

    @Override // java.lang.Iterable
    Iterator<Map.Entry<K, V>> iterator();

    Set<K> names();

    boolean remove(K k);

    T set(Headers<? extends K, ? extends V, ?> headers);

    T set(K k, Iterable<? extends V> iterable);

    T set(K k, V v);

    T set(K k, V... vArr);

    T setAll(Headers<? extends K, ? extends V, ?> headers);

    T setBoolean(K k, boolean z);

    T setByte(K k, byte b2);

    T setChar(K k, char c2);

    T setDouble(K k, double d2);

    T setFloat(K k, float f2);

    T setInt(K k, int i);

    T setLong(K k, long j);

    T setObject(K k, Iterable<?> iterable);

    T setObject(K k, Object obj);

    T setObject(K k, Object... objArr);

    T setShort(K k, short s);

    T setTimeMillis(K k, long j);

    int size();
}
