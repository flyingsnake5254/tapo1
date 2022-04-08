package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;

/* compiled from: ExtractorInput.java */
/* loaded from: classes.dex */
public interface k extends i {
    long a();

    boolean c(byte[] bArr, int i, int i2, boolean z) throws IOException;

    void e();

    boolean f(byte[] bArr, int i, int i2, boolean z) throws IOException;

    long g();

    long getPosition();

    void h(int i) throws IOException;

    int i(int i) throws IOException;

    int k(byte[] bArr, int i, int i2) throws IOException;

    void l(int i) throws IOException;

    boolean m(int i, boolean z) throws IOException;

    void n(byte[] bArr, int i, int i2) throws IOException;

    @Override // com.google.android.exoplayer2.upstream.i
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;
}
