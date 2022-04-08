package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* loaded from: classes4.dex */
public interface GOST3410PrivateKey extends PrivateKey {
    /* synthetic */ a getParameters();

    BigInteger getX();
}
