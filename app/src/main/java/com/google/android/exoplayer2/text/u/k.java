package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: WebvttSubtitle.java */
/* loaded from: classes.dex */
final class k implements f {

    /* renamed from: c  reason: collision with root package name */
    private final List<g> f3599c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f3600d;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f3601f;

    public k(List<g> list) {
        this.f3599c = Collections.unmodifiableList(new ArrayList(list));
        this.f3600d = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            g gVar = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.f3600d;
            jArr[i2] = gVar.f3582b;
            jArr[i2 + 1] = gVar.f3583c;
        }
        long[] jArr2 = this.f3600d;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f3601f = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        int d2 = o0.d(this.f3601f, j, false, false);
        if (d2 < this.f3601f.length) {
            return d2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f3599c.size(); i++) {
            long[] jArr = this.f3600d;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                g gVar = this.f3599c.get(i);
                c cVar = gVar.a;
                if (cVar.g == -3.4028235E38f) {
                    arrayList2.add(gVar);
                } else {
                    arrayList.add(cVar);
                }
            }
        }
        Collections.sort(arrayList2, b.f3572c);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((g) arrayList2.get(i3)).a.a().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        boolean z = true;
        g.a(i >= 0);
        if (i >= this.f3601f.length) {
            z = false;
        }
        g.a(z);
        return this.f3601f[i];
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return this.f3601f.length;
    }
}
