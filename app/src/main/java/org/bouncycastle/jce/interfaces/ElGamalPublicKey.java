package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPublicKey;
import org.bouncycastle.jce.spec.h;

/* loaded from: classes4.dex */
public interface ElGamalPublicKey extends DHKey, DHPublicKey {
    /* synthetic */ h getParameters();

    BigInteger getY();
}
