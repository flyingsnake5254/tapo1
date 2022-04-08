package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: IcyDataSource.java */
/* loaded from: classes.dex */
final class w implements l {

    /* renamed from: b  reason: collision with root package name */
    private final l f3419b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3420c;

    /* renamed from: d  reason: collision with root package name */
    private final a f3421d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f3422e;

    /* renamed from: f  reason: collision with root package name */
    private int f3423f;

    /* compiled from: IcyDataSource.java */
    /* loaded from: classes.dex */
    public interface a {
        void b(d0 d0Var);
    }

    public w(l lVar, int i, a aVar) {
        g.a(i > 0);
        this.f3419b = lVar;
        this.f3420c = i;
        this.f3421d = aVar;
        this.f3422e = new byte[1];
        this.f3423f = i;
    }

    private boolean o() throws IOException {
        if (this.f3419b.read(this.f3422e, 0, 1) == -1) {
            return false;
        }
        int i = (this.f3422e[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int read = this.f3419b.read(bArr, i3, i2);
            if (read == -1) {
                return false;
            }
            i3 += read;
            i2 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.f3421d.b(new d0(bArr, i));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void b(a0 a0Var) {
        g.e(a0Var);
        this.f3419b.b(a0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Map<String, List<String>> d() {
        return this.f3419b.d();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public Uri getUri() {
        return this.f3419b.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long j(n nVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3423f == 0) {
            if (!o()) {
                return -1;
            }
            this.f3423f = this.f3420c;
        }
        int read = this.f3419b.read(bArr, i, Math.min(this.f3423f, i2));
        if (read != -1) {
            this.f3423f -= read;
        }
        return read;
    }
}
