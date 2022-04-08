package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataSourceInputStream.java */
/* loaded from: classes.dex */
public final class m extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private final l f3824c;

    /* renamed from: d  reason: collision with root package name */
    private final n f3825d;
    private long y;
    private boolean q = false;
    private boolean x = false;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f3826f = new byte[1];

    public m(l lVar, n nVar) {
        this.f3824c = lVar;
        this.f3825d = nVar;
    }

    private void a() throws IOException {
        if (!this.q) {
            this.f3824c.j(this.f3825d);
            this.q = true;
        }
    }

    public void c() throws IOException {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.x) {
            this.f3824c.close();
            this.x = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f3826f) == -1) {
            return -1;
        }
        return this.f3826f[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        g.g(!this.x);
        a();
        int read = this.f3824c.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.y += read;
        return read;
    }
}
