package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.b;

/* loaded from: classes4.dex */
class r1 extends w1 {

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f16880f = new byte[0];
    private final int q;
    private int x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this.q = i;
            this.x = i;
            if (i == 0) {
                c(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.w1
    public int a() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] e() throws IOException {
        int i = this.x;
        if (i == 0) {
            return f16880f;
        }
        byte[] bArr = new byte[i];
        int c2 = i - b.c(this.f16961c, bArr);
        this.x = c2;
        if (c2 == 0) {
            c(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.q + " object truncated by " + this.x);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.x == 0) {
            return -1;
        }
        int read = this.f16961c.read();
        if (read >= 0) {
            int i = this.x - 1;
            this.x = i;
            if (i == 0) {
                c(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.q + " object truncated by " + this.x);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.x;
        if (i3 == 0) {
            return -1;
        }
        int read = this.f16961c.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this.x - read;
            this.x = i4;
            if (i4 == 0) {
                c(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.q + " object truncated by " + this.x);
    }
}
