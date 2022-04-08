package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class ArrayListMultimap<K, V> extends r<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap<>();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int h = r2.h(objectInputStream);
        setMap(x.h());
        r2.e(this, objectInputStream, h);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        r2.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean containsKey(@NullableDecl Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.h
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ List get(@NullableDecl Object obj) {
        return super.get((ArrayListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ u1 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(r1 r1Var) {
        return super.putAll(r1Var);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ List removeAll(@NullableDecl Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ List replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return super.replaceValues((ArrayListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> it = backingMap().values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private ArrayListMultimap(int i, int i2) {
        super(c2.c(i));
        v.b(i2, "expectedValuesPerKey");
        this.expectedValuesPerKey = i2;
    }

    public static <K, V> ArrayListMultimap<K, V> create(int i, int i2) {
        return new ArrayListMultimap<>(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d, com.google.common.collect.e
    public List<V> createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> ArrayListMultimap<K, V> create(r1<? extends K, ? extends V> r1Var) {
        return new ArrayListMultimap<>(r1Var);
    }

    private ArrayListMultimap(r1<? extends K, ? extends V> r1Var) {
        this(r1Var.keySet().size(), r1Var instanceof ArrayListMultimap ? ((ArrayListMultimap) r1Var).expectedValuesPerKey : 3);
        putAll(r1Var);
    }
}
