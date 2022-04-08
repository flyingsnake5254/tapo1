package com.google.android.exoplayer2.mediacodec;

import androidx.annotation.IntRange;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

/* compiled from: BatchBuffer.java */
/* loaded from: classes.dex */
final class o extends DecoderInputBuffer {
    private long p1;
    private int p2;
    private int p3 = 32;

    public o() {
        super(2);
    }

    private boolean u(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!y()) {
            return true;
        }
        if (this.p2 >= this.p3 || decoderInputBuffer.j() != j()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f2153f;
        return byteBuffer2 == null || (byteBuffer = this.f2153f) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.a
    public void f() {
        super.f();
        this.p2 = 0;
    }

    public boolean t(DecoderInputBuffer decoderInputBuffer) {
        g.a(!decoderInputBuffer.q());
        g.a(!decoderInputBuffer.i());
        g.a(!decoderInputBuffer.k());
        if (!u(decoderInputBuffer)) {
            return false;
        }
        int i = this.p2;
        this.p2 = i + 1;
        if (i == 0) {
            this.x = decoderInputBuffer.x;
            if (decoderInputBuffer.l()) {
                m(1);
            }
        }
        if (decoderInputBuffer.j()) {
            m(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f2153f;
        if (byteBuffer != null) {
            o(byteBuffer.remaining());
            this.f2153f.put(byteBuffer);
        }
        this.p1 = decoderInputBuffer.x;
        return true;
    }

    public long v() {
        return this.x;
    }

    public long w() {
        return this.p1;
    }

    public int x() {
        return this.p2;
    }

    public boolean y() {
        return this.p2 > 0;
    }

    public void z(@IntRange(from = 1) int i) {
        g.a(i > 0);
        this.p3 = i;
    }
}
