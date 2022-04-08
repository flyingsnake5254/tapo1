package com.bumptech.glide.k;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f1322c;

    /* renamed from: d  reason: collision with root package name */
    private final Charset f1323d;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f1324f;
    private int q;
    private int x;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.f1323d.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f1322c;
        byte[] bArr = this.f1324f;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.q = 0;
            this.x = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f1322c) {
            if (this.f1324f != null) {
                this.f1324f = null;
                this.f1322c.close();
            }
        }
    }

    public boolean e() {
        return this.x == -1;
    }

    public String g() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f1322c) {
            if (this.f1324f != null) {
                if (this.q >= this.x) {
                    c();
                }
                for (int i3 = this.q; i3 != this.x; i3++) {
                    byte[] bArr2 = this.f1324f;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.q) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.f1324f;
                                int i4 = this.q;
                                String str = new String(bArr3, i4, i2 - i4, this.f1323d.name());
                                this.q = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr32 = this.f1324f;
                        int i42 = this.q;
                        String str2 = new String(bArr32, i42, i2 - i42, this.f1323d.name());
                        this.q = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.x - this.q) + 80);
                loop1: while (true) {
                    byte[] bArr4 = this.f1324f;
                    int i5 = this.q;
                    aVar.write(bArr4, i5, this.x - i5);
                    this.x = -1;
                    c();
                    i = this.q;
                    while (i != this.x) {
                        bArr = this.f1324f;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.q;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.q = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.a)) {
            this.f1322c = inputStream;
            this.f1323d = charset;
            this.f1324f = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
