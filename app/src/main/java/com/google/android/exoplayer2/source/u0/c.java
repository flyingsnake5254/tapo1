package com.google.android.exoplayer2.source.u0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DataChunk.java */
/* loaded from: classes.dex */
public abstract class c extends b {
    private byte[] j;
    private volatile boolean k;

    public c(l lVar, n nVar, int i, Format format, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        super(lVar, nVar, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        c cVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = o0.f3937f;
            cVar = this;
        } else {
            cVar = this;
            bArr2 = bArr;
        }
        cVar.j = bArr2;
    }

    private void i(int i) {
        byte[] bArr = this.j;
        if (bArr.length < i + 16384) {
            this.j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() throws IOException {
        try {
            this.i.j(this.f3413b);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.k) {
                i(i2);
                i = this.i.read(this.j, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.k) {
                g(this.j, i2);
            }
        } finally {
            o0.l(this.i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
        this.k = true;
    }

    protected abstract void g(byte[] bArr, int i) throws IOException;

    public byte[] h() {
        return this.j;
    }
}
