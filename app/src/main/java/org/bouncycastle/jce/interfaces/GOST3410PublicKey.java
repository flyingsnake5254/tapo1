package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* loaded from: classes4.dex */
public interface GOST3410PublicKey extends PublicKey {
    /* synthetic */ a getParameters();

    BigInteger getY();
}
