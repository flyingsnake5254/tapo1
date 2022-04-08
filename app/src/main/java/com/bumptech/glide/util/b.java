package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private final long f1765c;

    /* renamed from: d  reason: collision with root package name */
    private int f1766d;

    private b(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f1765c = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f1766d += i;
        } else if (this.f1765c - this.f1766d > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f1765c + ", but read: " + this.f1766d);
        }
        return i;
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f1765c - this.f1766d, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }
}
