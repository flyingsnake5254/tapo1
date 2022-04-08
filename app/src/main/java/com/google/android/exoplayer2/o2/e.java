package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* compiled from: ChunkIndex.java */
/* loaded from: classes.dex */
public final class e implements y {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f2667b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f2668c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f2669d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f2670e;

    /* renamed from: f  reason: collision with root package name */
    private final long f2671f;

    public e(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f2667b = iArr;
        this.f2668c = jArr;
        this.f2669d = jArr2;
        this.f2670e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f2671f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f2671f = 0L;
        }
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        int b2 = b(j);
        z zVar = new z(this.f2670e[b2], this.f2668c[b2]);
        if (zVar.f3078b >= j || b2 == this.a - 1) {
            return new y.a(zVar);
        }
        int i = b2 + 1;
        return new y.a(zVar, new z(this.f2670e[i], this.f2668c[i]));
    }

    public int b(long j) {
        return o0.h(this.f2670e, j, true, true);
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.f2671f;
    }

    public String toString() {
        int i = this.a;
        String arrays = Arrays.toString(this.f2667b);
        String arrays2 = Arrays.toString(this.f2668c);
        String arrays3 = Arrays.toString(this.f2670e);
        String arrays4 = Arrays.toString(this.f2669d);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 71 + String.valueOf(arrays2).length() + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        sb.append(arrays4);
        sb.append(")");
        return sb.toString();
    }
}
