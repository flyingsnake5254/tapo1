package org.bouncycastle.tsp.cms;

import org.bouncycastle.tsp.a;

/* loaded from: classes4.dex */
public class ImprintDigestInvalidException extends Exception {
    private a token;

    public ImprintDigestInvalidException(String str, a aVar) {
        super(str);
    }

    public a getTimeStampToken() {
        return this.token;
    }
}
