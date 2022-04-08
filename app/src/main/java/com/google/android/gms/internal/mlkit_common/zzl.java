package com.google.android.gms.internal.mlkit_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public abstract class zzl<E> extends zzm<E> implements List<E>, RandomAccess {
    private static final zzs<Object> zza = new zzo(zzq.zza, 0);

    @SafeVarargs
    public static <E> zzl<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        if (eArr.length <= 2147483635) {
            int length = eArr.length + 12;
            Object[] objArr = new Object[length];
            objArr[0] = e2;
            objArr[1] = e3;
            objArr[2] = e4;
            objArr[3] = e5;
            objArr[4] = e6;
            objArr[5] = e7;
            objArr[6] = e8;
            objArr[7] = e9;
            objArr[8] = e10;
            objArr[9] = e11;
            objArr[10] = e12;
            objArr[11] = e13;
            System.arraycopy(eArr, 0, objArr, 12, eArr.length);
            for (int i = 0; i < length; i++) {
                if (objArr[i] == null) {
                    StringBuilder sb = new StringBuilder(20);
                    sb.append("at index ");
                    sb.append(i);
                    throw new NullPointerException(sb.toString());
                }
            }
            if (length == 0) {
                return (zzl<E>) zzq.zza;
            }
            return new zzq(objArr, length);
        }
        throw new IllegalArgumentException("the total number of elements must fit in an int");
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzi.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzc.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i2);
                        i2++;
                        if (!zzc.zza(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzi.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzo(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzs) listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    public final zzp<E> zza() {
        return (zzs) listIterator();
    }

    /* renamed from: zza */
    public zzl<E> subList(int i, int i2) {
        zzi.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (zzl<E>) zzq.zza;
        }
        return new zzn(this, i, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }
}
