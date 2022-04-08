package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DummyTrackOutput.java */
/* loaded from: classes.dex */
public final class i implements b0 {
    private final byte[] a = new byte[4096];

    @Override // com.google.android.exoplayer2.o2.b0
    public int a(com.google.android.exoplayer2.upstream.i iVar, int i, boolean z, int i2) throws IOException {
        int read = iVar.read(this.a, 0, Math.min(this.a.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.o2.b0
    public /* synthetic */ int b(com.google.android.exoplayer2.upstream.i iVar, int i, boolean z) {
        return a0.a(this, iVar, i, z);
    }

    @Override // com.google.android.exoplayer2.o2.b0
    public /* synthetic */ void c(d0 d0Var, int i) {
        a0.b(this, d0Var, i);
    }

    @Override // com.google.android.exoplayer2.o2.b0
    public void d(Format format) {
    }

    @Override // com.google.android.exoplayer2.o2.b0
    public void e(long j, int i, int i2, int i3, @Nullable b0.a aVar) {
    }

    @Override // com.google.android.exoplayer2.o2.b0
    public void f(d0 d0Var, int i, int i2) {
        d0Var.Q(i);
    }
}
