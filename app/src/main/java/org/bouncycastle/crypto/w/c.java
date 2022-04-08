package org.bouncycastle.crypto.w;

import java.security.SecureRandom;
import org.bouncycastle.crypto.i;

/* loaded from: classes4.dex */
public class c extends i {

    /* renamed from: c  reason: collision with root package name */
    private e f17340c;

    public c(SecureRandom secureRandom, e eVar) {
        super(secureRandom, c(eVar));
        this.f17340c = eVar;
    }

    static int c(e eVar) {
        return eVar.d() != 0 ? eVar.d() : eVar.f().bitLength();
    }

    public e b() {
        return this.f17340c;
    }
}
