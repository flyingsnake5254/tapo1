package org.bouncycastle.util;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import org.bouncycastle.crypto.p.j;

/* loaded from: classes4.dex */
public class c {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f17516b;

    public c(byte[] bArr) {
        this.f17516b = a(bArr);
    }

    public static byte[] a(byte[] bArr) {
        j jVar = new j(160);
        jVar.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[jVar.e()];
        jVar.doFinal(bArr2, 0);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return a.c(((c) obj).f17516b, this.f17516b);
        }
        return false;
    }

    public int hashCode() {
        return a.w(this.f17516b);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != this.f17516b.length; i++) {
            if (i > 0) {
                stringBuffer.append(SSLClient.COLON);
            }
            stringBuffer.append(a[(this.f17516b[i] >>> 4) & 15]);
            stringBuffer.append(a[this.f17516b[i] & BinaryMemcacheOpcodes.PREPEND]);
        }
        return stringBuffer.toString();
    }
}
