package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: PlaylistTimeline.java */
/* loaded from: classes.dex */
final class y1 extends q0 {

    /* renamed from: f  reason: collision with root package name */
    private final int f4094f;
    private final int g;
    private final int[] h;
    private final int[] i;
    private final j2[] j;
    private final Object[] k;
    private final HashMap<Object, Integer> l = new HashMap<>();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(Collection<? extends q1> collection, p0 p0Var) {
        super(false, p0Var);
        int i = 0;
        int size = collection.size();
        this.h = new int[size];
        this.i = new int[size];
        this.j = new j2[size];
        this.k = new Object[size];
        int i2 = 0;
        int i3 = 0;
        for (q1 q1Var : collection) {
            this.j[i3] = q1Var.a();
            this.i[i3] = i;
            this.h[i3] = i2;
            i += this.j[i3].p();
            i2 += this.j[i3].i();
            this.k[i3] = q1Var.getUid();
            HashMap<Object, Integer> hashMap = this.l;
            Object obj = this.k[i3];
            i3++;
            hashMap.put(obj, Integer.valueOf(i3));
        }
        this.f4094f = i;
        this.g = i2;
    }

    @Override // com.google.android.exoplayer2.q0
    protected int A(int i) {
        return this.i[i];
    }

    @Override // com.google.android.exoplayer2.q0
    protected j2 D(int i) {
        return this.j[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<j2> E() {
        return Arrays.asList(this.j);
    }

    @Override // com.google.android.exoplayer2.j2
    public int i() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.j2
    public int p() {
        return this.f4094f;
    }

    @Override // com.google.android.exoplayer2.q0
    protected int s(Object obj) {
        Integer num = this.l.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.q0
    protected int t(int i) {
        return o0.g(this.h, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.q0
    protected int u(int i) {
        return o0.g(this.i, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.q0
    protected Object x(int i) {
        return this.k[i];
    }

    @Override // com.google.android.exoplayer2.q0
    protected int z(int i) {
        return this.h[i];
    }
}
