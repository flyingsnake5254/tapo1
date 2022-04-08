package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: SampleDataQueue.java */
/* loaded from: classes.dex */
class l0 {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3350b;

    /* renamed from: c  reason: collision with root package name */
    private final d0 f3351c = new d0(32);

    /* renamed from: d  reason: collision with root package name */
    private a f3352d;

    /* renamed from: e  reason: collision with root package name */
    private a f3353e;

    /* renamed from: f  reason: collision with root package name */
    private a f3354f;
    private long g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SampleDataQueue.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3355b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3356c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public d f3357d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f3358e;

        public a(long j, int i) {
            this.a = j;
            this.f3355b = j + i;
        }

        public a a() {
            this.f3357d = null;
            a aVar = this.f3358e;
            this.f3358e = null;
            return aVar;
        }

        public void b(d dVar, a aVar) {
            this.f3357d = dVar;
            this.f3358e = aVar;
            this.f3356c = true;
        }

        public int c(long j) {
            return ((int) (j - this.a)) + this.f3357d.f3816b;
        }
    }

    public l0(e eVar) {
        this.a = eVar;
        int e2 = eVar.e();
        this.f3350b = e2;
        a aVar = new a(0L, e2);
        this.f3352d = aVar;
        this.f3353e = aVar;
        this.f3354f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f3356c) {
            a aVar2 = this.f3354f;
            int i = (aVar2.f3356c ? 1 : 0) + (((int) (aVar2.a - aVar.a)) / this.f3350b);
            d[] dVarArr = new d[i];
            for (int i2 = 0; i2 < i; i2++) {
                dVarArr[i2] = aVar.f3357d;
                aVar = aVar.a();
            }
            this.a.b(dVarArr);
        }
    }

    private static a d(a aVar, long j) {
        while (j >= aVar.f3355b) {
            aVar = aVar.f3358e;
        }
        return aVar;
    }

    private void g(int i) {
        long j = this.g + i;
        this.g = j;
        a aVar = this.f3354f;
        if (j == aVar.f3355b) {
            this.f3354f = aVar.f3358e;
        }
    }

    private int h(int i) {
        a aVar = this.f3354f;
        if (!aVar.f3356c) {
            aVar.b(this.a.a(), new a(this.f3354f.f3355b, this.f3350b));
        }
        return Math.min(i, (int) (this.f3354f.f3355b - this.g));
    }

    private static a i(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a d2 = d(aVar, j);
        while (i > 0) {
            int min = Math.min(i, (int) (d2.f3355b - j));
            byteBuffer.put(d2.f3357d.a, d2.c(j), min);
            i -= min;
            j += min;
            if (j == d2.f3355b) {
                d2 = d2.f3358e;
            }
        }
        return d2;
    }

    private static a j(a aVar, long j, byte[] bArr, int i) {
        a d2 = d(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (d2.f3355b - j));
            System.arraycopy(d2.f3357d.a, d2.c(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == d2.f3355b) {
                d2 = d2.f3358e;
            }
        }
        return d2;
    }

    private static a k(a aVar, DecoderInputBuffer decoderInputBuffer, m0.b bVar, d0 d0Var) {
        int i;
        long j = bVar.f3369b;
        d0Var.L(1);
        a j2 = j(aVar, j, d0Var.d(), 1);
        long j3 = j + 1;
        byte b2 = d0Var.d()[0];
        boolean z = (b2 & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        b bVar2 = decoderInputBuffer.f2152d;
        byte[] bArr = bVar2.a;
        if (bArr == null) {
            bVar2.a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a j4 = j(j2, j3, bVar2.a, i2);
        long j5 = j3 + i2;
        if (z) {
            d0Var.L(2);
            j4 = j(j4, j5, d0Var.d(), 2);
            j5 += 2;
            i = d0Var.J();
        } else {
            i = 1;
        }
        int[] iArr = bVar2.f2157d;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = bVar2.f2158e;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            d0Var.L(i3);
            j4 = j(j4, j5, d0Var.d(), i3);
            j5 += i3;
            d0Var.P(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = d0Var.J();
                iArr2[i4] = d0Var.H();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = bVar.a - ((int) (j5 - bVar.f3369b));
        }
        b0.a aVar2 = (b0.a) o0.i(bVar.f3370c);
        bVar2.c(i, iArr, iArr2, aVar2.f2647b, bVar2.a, aVar2.a, aVar2.f2648c, aVar2.f2649d);
        long j6 = bVar.f3369b;
        int i5 = (int) (j5 - j6);
        bVar.f3369b = j6 + i5;
        bVar.a -= i5;
        return j4;
    }

    private static a l(a aVar, DecoderInputBuffer decoderInputBuffer, m0.b bVar, d0 d0Var) {
        if (decoderInputBuffer.q()) {
            aVar = k(aVar, decoderInputBuffer, bVar, d0Var);
        }
        if (decoderInputBuffer.i()) {
            d0Var.L(4);
            a j = j(aVar, bVar.f3369b, d0Var.d(), 4);
            int H = d0Var.H();
            bVar.f3369b += 4;
            bVar.a -= 4;
            decoderInputBuffer.o(H);
            a i = i(j, bVar.f3369b, decoderInputBuffer.f2153f, H);
            bVar.f3369b += H;
            int i2 = bVar.a - H;
            bVar.a = i2;
            decoderInputBuffer.s(i2);
            return i(i, bVar.f3369b, decoderInputBuffer.y, bVar.a);
        }
        decoderInputBuffer.o(bVar.a);
        return i(aVar, bVar.f3369b, decoderInputBuffer.f2153f, bVar.a);
    }

    public void b(long j) {
        a aVar;
        if (j != -1) {
            while (true) {
                aVar = this.f3352d;
                if (j < aVar.f3355b) {
                    break;
                }
                this.a.c(aVar.f3357d);
                this.f3352d = this.f3352d.a();
            }
            if (this.f3353e.a < aVar.a) {
                this.f3353e = aVar;
            }
        }
    }

    public void c(long j) {
        this.g = j;
        if (j != 0) {
            a aVar = this.f3352d;
            if (j != aVar.a) {
                while (this.g > aVar.f3355b) {
                    aVar = aVar.f3358e;
                }
                a aVar2 = aVar.f3358e;
                a(aVar2);
                a aVar3 = new a(aVar.f3355b, this.f3350b);
                aVar.f3358e = aVar3;
                if (this.g == aVar.f3355b) {
                    aVar = aVar3;
                }
                this.f3354f = aVar;
                if (this.f3353e == aVar2) {
                    this.f3353e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f3352d);
        a aVar4 = new a(this.g, this.f3350b);
        this.f3352d = aVar4;
        this.f3353e = aVar4;
        this.f3354f = aVar4;
    }

    public long e() {
        return this.g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, m0.b bVar) {
        l(this.f3353e, decoderInputBuffer, bVar, this.f3351c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, m0.b bVar) {
        this.f3353e = l(this.f3353e, decoderInputBuffer, bVar, this.f3351c);
    }

    public void n() {
        a(this.f3352d);
        a aVar = new a(0L, this.f3350b);
        this.f3352d = aVar;
        this.f3353e = aVar;
        this.f3354f = aVar;
        this.g = 0L;
        this.a.d();
    }

    public void o() {
        this.f3353e = this.f3352d;
    }

    public int p(i iVar, int i, boolean z) throws IOException {
        int h = h(i);
        a aVar = this.f3354f;
        int read = iVar.read(aVar.f3357d.a, aVar.c(this.g), h);
        if (read != -1) {
            g(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void q(d0 d0Var, int i) {
        while (i > 0) {
            int h = h(i);
            a aVar = this.f3354f;
            d0Var.j(aVar.f3357d.a, aVar.c(this.g), h);
            i -= h;
            g(h);
        }
    }
}
