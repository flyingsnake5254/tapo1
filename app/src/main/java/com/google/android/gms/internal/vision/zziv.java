package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zziv<E> extends zzfc<E> implements RandomAccess {
    private static final zziv<Object> zzaaf;
    private int size;
    private E[] zzmh;

    static {
        zziv<Object> zzivVar = new zziv<>(new Object[0], 0);
        zzaaf = zzivVar;
        zzivVar.zzdq();
    }

    zziv() {
        this(new Object[10], 0);
    }

    private final void zzaf(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
    }

    private final String zzag(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public static <E> zziv<E> zzhs() {
        return (zziv<E>) zzaaf;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzdr();
        int i = this.size;
        E[] eArr = this.zzmh;
        if (i == eArr.length) {
            this.zzmh = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzmh;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzaf(i);
        return this.zzmh[i];
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        int i2;
        zzdr();
        zzaf(i);
        E[] eArr = this.zzmh;
        E e2 = eArr[i];
        if (i < this.size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzdr();
        zzaf(i);
        E[] eArr = this.zzmh;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe zzah(int i) {
        if (i >= this.size) {
            return new zziv(Arrays.copyOf(this.zzmh, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zziv(E[] eArr, int i) {
        this.zzmh = eArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        int i2;
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        E[] eArr = this.zzmh;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzmh, i, eArr2, i + 1, this.size - i);
            this.zzmh = eArr2;
        }
        this.zzmh[i] = e2;
        this.size++;
        ((AbstractList) this).modCount++;
    }
}
