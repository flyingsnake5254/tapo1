package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class u extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private volatile byte[] f1655c;

    /* renamed from: d  reason: collision with root package name */
    private int f1656d;

    /* renamed from: f  reason: collision with root package name */
    private int f1657f;
    private int q;
    private int x;
    private final b y;

    /* compiled from: RecyclableBufferedInputStream.java */
    /* loaded from: classes.dex */
    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public u(@NonNull InputStream inputStream, @NonNull b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.q;
        if (i != -1) {
            int i2 = this.x - i;
            int i3 = this.f1657f;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f1656d == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.y.c(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f1655c = bArr2;
                    this.y.e(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.x - this.q;
                this.x = i4;
                this.q = 0;
                this.f1656d = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.x;
                if (read > 0) {
                    i5 += read;
                }
                this.f1656d = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.q = -1;
            this.x = 0;
            this.f1656d = read2;
        }
        return read2;
    }

    private static IOException g() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f1655c == null || inputStream == null) {
            throw g();
        }
        return (this.f1656d - this.x) + inputStream.available();
    }

    public synchronized void c() {
        this.f1657f = this.f1655c.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1655c != null) {
            this.y.e(this.f1655c);
            this.f1655c = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void e() {
        if (this.f1655c != null) {
            this.y.e(this.f1655c);
            this.f1655c = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f1657f = Math.max(this.f1657f, i);
        this.q = this.x;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f1655c;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw g();
        } else if (this.x >= this.f1656d && a(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr != this.f1655c && (bArr = this.f1655c) == null) {
                throw g();
            }
            int i = this.f1656d;
            int i2 = this.x;
            if (i - i2 <= 0) {
                return -1;
            }
            this.x = i2 + 1;
            return bArr[i2] & 255;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f1655c != null) {
            int i = this.q;
            if (-1 != i) {
                this.x = i;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.x + " markLimit: " + this.f1657f);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f1655c;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i = this.f1656d;
                int i2 = this.x;
                if (i - i2 >= j) {
                    this.x = (int) (i2 + j);
                    return j;
                }
                long j2 = i - i2;
                this.x = i;
                if (this.q == -1 || j > this.f1657f) {
                    long skip = inputStream.skip(j - j2);
                    if (skip > 0) {
                        this.q = -1;
                    }
                    return j2 + skip;
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    int i3 = this.f1656d;
                    int i4 = this.x;
                    if (i3 - i4 >= j - j2) {
                        this.x = (int) ((i4 + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + i3) - i4;
                    this.x = i3;
                    return j3;
                }
            } else {
                throw g();
            }
        } else {
            throw g();
        }
    }

    @VisibleForTesting
    u(@NonNull InputStream inputStream, @NonNull b bVar, int i) {
        super(inputStream);
        this.q = -1;
        this.y = bVar;
        this.f1655c = (byte[]) bVar.c(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f1655c;
        if (bArr2 == null) {
            throw g();
        } else if (i2 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i5 = this.x;
                int i6 = this.f1656d;
                if (i5 < i6) {
                    int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
                    System.arraycopy(bArr2, i5, bArr, i, i7);
                    this.x += i7;
                    if (i7 == i2 || inputStream.available() == 0) {
                        return i7;
                    }
                    i += i7;
                    i3 = i2 - i7;
                } else {
                    i3 = i2;
                }
                while (true) {
                    int i8 = -1;
                    if (this.q == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            if (i3 != i2) {
                                i8 = i2 - i3;
                            }
                            return i8;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        if (i3 != i2) {
                            i8 = i2 - i3;
                        }
                        return i8;
                    } else {
                        if (bArr2 != this.f1655c && (bArr2 = this.f1655c) == null) {
                            throw g();
                        }
                        int i9 = this.f1656d;
                        int i10 = this.x;
                        i4 = i9 - i10 >= i3 ? i3 : i9 - i10;
                        System.arraycopy(bArr2, i10, bArr, i, i4);
                        this.x += i4;
                    }
                    i3 -= i4;
                    if (i3 == 0) {
                        return i2;
                    }
                    if (inputStream.available() == 0) {
                        return i2 - i3;
                    }
                    i += i4;
                }
            } else {
                throw g();
            }
        }
    }
}
