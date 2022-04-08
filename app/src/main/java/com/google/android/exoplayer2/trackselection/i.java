package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.util.Arrays;

/* compiled from: MappingTrackSelector.java */
/* loaded from: classes.dex */
public abstract class i extends m {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private a f3643c;

    /* compiled from: MappingTrackSelector.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f3644b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f3645c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroupArray[] f3646d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f3647e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f3648f;
        private final TrackGroupArray g;

        a(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f3644b = strArr;
            this.f3645c = iArr;
            this.f3646d = trackGroupArrayArr;
            this.f3648f = iArr3;
            this.f3647e = iArr2;
            this.g = trackGroupArray;
            this.a = iArr.length;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.f3646d[i].a(i2).f3157c;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int f2 = f(i, i2, i5);
                if (f2 == 4 || (z && f2 == 3)) {
                    i4++;
                    iArr[i4] = i5;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int b(int i, int i2, int[] iArr) {
            String str = null;
            boolean z = false;
            int i3 = 0;
            int i4 = 16;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                String str2 = this.f3646d[i].a(i2).a(iArr[i5]).H3;
                i3++;
                if (i3 == 0) {
                    str = str2;
                } else {
                    z |= !o0.b(str, str2);
                }
                i4 = Math.min(i4, c2.c(this.f3648f[i][i2][i5]));
            }
            return z ? Math.min(i4, this.f3647e[i]) : i4;
        }

        public int c() {
            return this.a;
        }

        public int d(int i) {
            return this.f3645c[i];
        }

        public TrackGroupArray e(int i) {
            return this.f3646d[i];
        }

        public int f(int i, int i2, int i3) {
            return c2.d(this.f3648f[i][i2][i3]);
        }
    }

    private static int f(d2[] d2VarArr, TrackGroup trackGroup, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = d2VarArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < d2VarArr.length; i2++) {
            d2 d2Var = d2VarArr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < trackGroup.f3157c; i4++) {
                i3 = Math.max(i3, c2.d(d2Var.a(trackGroup.a(i4))));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }

    private static int[] h(d2 d2Var, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f3157c];
        for (int i = 0; i < trackGroup.f3157c; i++) {
            iArr[i] = d2Var.a(trackGroup.a(i));
        }
        return iArr;
    }

    private static int[] i(d2[] d2VarArr) throws ExoPlaybackException {
        int length = d2VarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = d2VarArr[i].s();
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.trackselection.m
    public final void d(@Nullable Object obj) {
        this.f3643c = (a) obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.m
    public final n e(d2[] d2VarArr, TrackGroupArray trackGroupArray, e0.a aVar, j2 j2Var) throws ExoPlaybackException {
        int[] iArr;
        int[] iArr2 = new int[d2VarArr.length + 1];
        int length = d2VarArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length];
        int[][][] iArr3 = new int[d2VarArr.length + 1][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroupArray.f3161d;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr3[i] = new int[i2];
        }
        int[] i3 = i(d2VarArr);
        for (int i4 = 0; i4 < trackGroupArray.f3161d; i4++) {
            TrackGroup a2 = trackGroupArray.a(i4);
            int f2 = f(d2VarArr, a2, iArr2, y.k(a2.a(0).H3) == 5);
            if (f2 == d2VarArr.length) {
                iArr = new int[a2.f3157c];
            } else {
                iArr = h(d2VarArr[f2], a2);
            }
            int i5 = iArr2[f2];
            trackGroupArr[f2][i5] = a2;
            iArr3[f2][i5] = iArr;
            iArr2[f2] = iArr2[f2] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[d2VarArr.length];
        String[] strArr = new String[d2VarArr.length];
        int[] iArr4 = new int[d2VarArr.length];
        for (int i6 = 0; i6 < d2VarArr.length; i6++) {
            int i7 = iArr2[i6];
            trackGroupArrayArr[i6] = new TrackGroupArray((TrackGroup[]) o0.w0(trackGroupArr[i6], i7));
            iArr3[i6] = (int[][]) o0.w0(iArr3[i6], i7);
            strArr[i6] = d2VarArr[i6].getName();
            iArr4[i6] = d2VarArr[i6].f();
        }
        a aVar2 = new a(strArr, iArr4, trackGroupArrayArr, i3, iArr3, new TrackGroupArray((TrackGroup[]) o0.w0(trackGroupArr[d2VarArr.length], iArr2[d2VarArr.length])));
        Pair<e2[], g[]> j = j(aVar2, iArr3, i3, aVar, j2Var);
        return new n((e2[]) j.first, (g[]) j.second, aVar2);
    }

    @Nullable
    public final a g() {
        return this.f3643c;
    }

    protected abstract Pair<e2[], g[]> j(a aVar, int[][][] iArr, int[] iArr2, e0.a aVar2, j2 j2Var) throws ExoPlaybackException;
}
