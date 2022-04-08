package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.e;
import com.google.firebase.messaging.Constants;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: DataSchemeDataSource.java */
/* loaded from: classes.dex */
public final class j extends h {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private n f3823f;
    @Nullable
    private byte[] g;
    private int h;
    private int i;

    public j() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        if (this.g != null) {
            this.g = null;
            p();
        }
        this.f3823f = null;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public Uri getUri() {
        n nVar = this.f3823f;
        if (nVar != null) {
            return nVar.a;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long j(n nVar) throws IOException {
        q(nVar);
        this.f3823f = nVar;
        Uri uri = nVar.a;
        String scheme = uri.getScheme();
        boolean equals = Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(scheme);
        String valueOf = String.valueOf(scheme);
        g.b(equals, valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        String[] E0 = o0.E0(uri.getSchemeSpecificPart(), SSLClient.COMMA);
        if (E0.length == 2) {
            String str = E0[1];
            if (E0[0].contains(";base64")) {
                try {
                    this.g = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    String valueOf2 = String.valueOf(str);
                    throw ParserException.createForMalformedDataOfUnknownType(valueOf2.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf2) : new String("Error while parsing Base64 encoded string: "), e2);
                }
            } else {
                this.g = o0.e0(URLDecoder.decode(str, e.a.name()));
            }
            long j = nVar.g;
            byte[] bArr = this.g;
            if (j <= bArr.length) {
                int i = (int) j;
                this.h = i;
                int length = bArr.length - i;
                this.i = length;
                long j2 = nVar.h;
                if (j2 != -1) {
                    this.i = (int) Math.min(length, j2);
                }
                r(nVar);
                long j3 = nVar.h;
                return j3 != -1 ? j3 : this.i;
            }
            this.g = null;
            throw new DataSourceException(2008);
        }
        String valueOf3 = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(valueOf3.length() + 23);
        sb.append("Unexpected URI format: ");
        sb.append(valueOf3);
        throw ParserException.createForMalformedDataOfUnknownType(sb.toString(), null);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.i;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(o0.i(this.g), this.h, bArr, i, min);
        this.h += min;
        this.i -= min;
        o(min);
        return min;
    }
}
