package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.u0.b;
import com.google.android.exoplayer2.source.u0.d;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.List;

/* compiled from: BaseTrackSelection.java */
/* loaded from: classes.dex */
public abstract class e implements g {
    protected final TrackGroup a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f3636b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f3637c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3638d;

    /* renamed from: e  reason: collision with root package name */
    private final Format[] f3639e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f3640f;
    private int g;

    public e(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int v(Format format, Format format2) {
        return format2.p0 - format.p0;
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final Format a(int i) {
        return this.f3639e[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public void b() {
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public void c() {
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public boolean e(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean f2 = f(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.f3636b && !f2) {
            f2 = i2 != i && !f(i2, elapsedRealtime);
            i2++;
        }
        if (!f2) {
            return false;
        }
        long[] jArr = this.f3640f;
        jArr[i] = Math.max(jArr[i], o0.a(elapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && Arrays.equals(this.f3637c, eVar.f3637c);
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public boolean f(int i, long j) {
        return this.f3640f[i] > j;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public /* synthetic */ boolean g(long j, b bVar, List list) {
        return f.d(this, j, bVar, list);
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final int h(int i) {
        return this.f3637c[i];
    }

    public int hashCode() {
        if (this.g == 0) {
            this.g = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.f3637c);
        }
        return this.g;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public void i(float f2) {
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public /* synthetic */ void k() {
        f.a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final int l(int i) {
        for (int i2 = 0; i2 < this.f3636b; i2++) {
            if (this.f3637c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final int length() {
        return this.f3637c.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final TrackGroup m() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public /* synthetic */ void n(boolean z) {
        f.b(this, z);
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public int o(long j, List<? extends d> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.j
    public final int p(Format format) {
        for (int i = 0; i < this.f3636b; i++) {
            if (this.f3639e[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public final int r() {
        return this.f3637c[d()];
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public final Format s() {
        return this.f3639e[d()];
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public /* synthetic */ void u() {
        f.c(this);
    }

    public e(TrackGroup trackGroup, int[] iArr, int i) {
        int i2 = 0;
        g.g(iArr.length > 0);
        this.f3638d = i;
        this.a = (TrackGroup) g.e(trackGroup);
        int length = iArr.length;
        this.f3636b = length;
        this.f3639e = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f3639e[i3] = trackGroup.a(iArr[i3]);
        }
        Arrays.sort(this.f3639e, a.f3627c);
        this.f3637c = new int[this.f3636b];
        while (true) {
            int i4 = this.f3636b;
            if (i2 < i4) {
                this.f3637c[i2] = trackGroup.b(this.f3639e[i2]);
                i2++;
            } else {
                this.f3640f = new long[i4];
                return;
            }
        }
    }
}
