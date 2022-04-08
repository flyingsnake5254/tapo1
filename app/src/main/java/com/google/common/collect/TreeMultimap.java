package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public class TreeMultimap<K, V> extends n<K, V> {
    private static final long serialVersionUID = 0;
    private transient Comparator<? super K> keyComparator;
    private transient Comparator<? super V> valueComparator;

    TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap<>(a2.g(), a2.g());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyComparator = (Comparator) n.o((Comparator) objectInputStream.readObject());
        this.valueComparator = (Comparator) n.o((Comparator) objectInputStream.readObject());
        setMap(new TreeMap(this.keyComparator));
        r2.d(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(keyComparator());
        objectOutputStream.writeObject(valueComparator());
        r2.j(this, objectOutputStream);
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

    @Override // com.google.common.collect.e, com.google.common.collect.h
    Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.h
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.keyComparator;
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ u1 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
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

    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet removeAll(@NullableDecl Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return super.replaceValues((TreeMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) n.o(comparator), (Comparator) n.o(comparator2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(r1<? extends K, ? extends V> r1Var) {
        return new TreeMultimap<>(a2.g(), a2.g(), r1Var);
    }

    @Override // com.google.common.collect.n, com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.h, com.google.common.collect.r1
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.e
    public SortedSet<V> createCollection() {
        return new TreeSet(this.valueComparator);
    }

    @Override // com.google.common.collect.n, com.google.common.collect.h, com.google.common.collect.r1
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    private TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, r1<? extends K, ? extends V> r1Var) {
        this(comparator, comparator2);
        putAll(r1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.e
    public Collection<V> createCollection(@NullableDecl K k) {
        if (k == 0) {
            keyComparator().compare(k, k);
        }
        return super.createCollection(k);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    public NavigableSet<V> get(@NullableDecl K k) {
        return (NavigableSet) super.get((TreeMultimap<K, V>) k);
    }
}
