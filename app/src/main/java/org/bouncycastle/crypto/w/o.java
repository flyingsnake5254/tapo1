package org.bouncycastle.crypto.w;

import java.security.SecureRandom;
import org.bouncycastle.crypto.i;

/* loaded from: classes4.dex */
public class o extends i {

    /* renamed from: c  reason: collision with root package name */
    private n f17359c;

    public o(n nVar, SecureRandom secureRandom) {
        super(secureRandom, nVar.e().bitLength());
        this.f17359c = nVar;
    }

    public n b() {
        return this.f17359c;
    }
}
