package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b1 extends OutputStream {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f17199c = new byte[1];

    /* renamed from: d  reason: collision with root package name */
    private g1 f17200d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(g1 g1Var) {
        this.f17200d = g1Var;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17200d.g();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f17200d.m();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f17199c;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f17200d.V(bArr, i, i2);
    }
}
