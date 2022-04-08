package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.d;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class PBKDF2Key implements PBKDFKey {
    private final d converter;
    private final char[] password;

    public PBKDF2Key(char[] cArr, d dVar) {
        this.password = a.h(cArr);
        this.converter = dVar;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.converter.convert(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.converter.getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
