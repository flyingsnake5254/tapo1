package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Aes128DataSource.java */
/* loaded from: classes.dex */
class d implements l {

    /* renamed from: b  reason: collision with root package name */
    private final l f3245b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3246c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f3247d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private CipherInputStream f3248e;

    public d(l lVar, byte[] bArr, byte[] bArr2) {
        this.f3245b = lVar;
        this.f3246c = bArr;
        this.f3247d = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final void b(a0 a0Var) {
        g.e(a0Var);
        this.f3245b.b(a0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() throws IOException {
        if (this.f3248e != null) {
            this.f3248e = null;
            this.f3245b.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final Map<String, List<String>> d() {
        return this.f3245b.d();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public final Uri getUri() {
        return this.f3245b.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final long j(n nVar) throws IOException {
        try {
            Cipher o = o();
            try {
                o.init(2, new SecretKeySpec(this.f3246c, "AES"), new IvParameterSpec(this.f3247d));
                m mVar = new m(this.f3245b, nVar);
                this.f3248e = new CipherInputStream(mVar, o);
                mVar.c();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    protected Cipher o() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        g.e(this.f3248e);
        int read = this.f3248e.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
