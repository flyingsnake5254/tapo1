package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.i0.f;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

/* compiled from: BundledExtractorsAdapter.java */
/* loaded from: classes.dex */
public final class n implements i0 {
    private final o a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private j f3372b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private k f3373c;

    public n(o oVar) {
        this.a = oVar;
    }

    @Override // com.google.android.exoplayer2.source.i0
    public int a(x xVar) throws IOException {
        return ((j) g.e(this.f3372b)).e((k) g.e(this.f3373c), xVar);
    }

    @Override // com.google.android.exoplayer2.source.i0
    public void b() {
        j jVar = this.f3372b;
        if (jVar instanceof f) {
            ((f) jVar).h();
        }
    }

    @Override // com.google.android.exoplayer2.source.i0
    public void c(long j, long j2) {
        ((j) g.e(this.f3372b)).c(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r6.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r6.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        r1 = false;
     */
    @Override // com.google.android.exoplayer2.source.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.google.android.exoplayer2.upstream.i r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.exoplayer2.o2.l r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.exoplayer2.o2.g r6 = new com.google.android.exoplayer2.o2.g
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f3373c = r6
            com.google.android.exoplayer2.o2.j r8 = r7.f3372b
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.exoplayer2.o2.o r8 = r7.a
            com.google.android.exoplayer2.o2.j[] r8 = r8.a(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.f3372b = r8
            goto L_0x0075
        L_0x0020:
            int r10 = r8.length
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x0071
            r1 = r8[r0]
            boolean r2 = r1.d(r6)     // Catch: all -> 0x0042, EOFException -> 0x0057
            if (r2 == 0) goto L_0x0035
            r7.f3372b = r1     // Catch: all -> 0x0042, EOFException -> 0x0057
            com.google.android.exoplayer2.util.g.g(r14)
            r6.e()
            goto L_0x0071
        L_0x0035:
            com.google.android.exoplayer2.o2.j r1 = r7.f3372b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0042:
            r8 = move-exception
            com.google.android.exoplayer2.o2.j r9 = r7.f3372b
            if (r9 != 0) goto L_0x004f
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0050
        L_0x004f:
            r13 = 1
        L_0x0050:
            com.google.android.exoplayer2.util.g.g(r13)
            r6.e()
            throw r8
        L_0x0057:
            com.google.android.exoplayer2.o2.j r1 = r7.f3372b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = 0
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            com.google.android.exoplayer2.util.g.g(r1)
            r6.e()
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0071:
            com.google.android.exoplayer2.o2.j r10 = r7.f3372b
            if (r10 == 0) goto L_0x007b
        L_0x0075:
            com.google.android.exoplayer2.o2.j r8 = r7.f3372b
            r8.b(r15)
            return
        L_0x007b:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.String r8 = com.google.android.exoplayer2.util.o0.H(r8)
            java.lang.String r11 = java.lang.String.valueOf(r8)
            int r11 = r11.length()
            int r11 = r11 + 58
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "None of the available extractors ("
            r12.append(r11)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.g.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.d(com.google.android.exoplayer2.upstream.i, android.net.Uri, java.util.Map, long, long, com.google.android.exoplayer2.o2.l):void");
    }

    @Override // com.google.android.exoplayer2.source.i0
    public long e() {
        k kVar = this.f3373c;
        if (kVar != null) {
            return kVar.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.i0
    public void release() {
        j jVar = this.f3372b;
        if (jVar != null) {
            jVar.release();
            this.f3372b = null;
        }
        this.f3373c = null;
    }
}
