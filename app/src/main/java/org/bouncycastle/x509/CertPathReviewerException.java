package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.LocalizedException;
import org.bouncycastle.i18n.a;

/* loaded from: classes4.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;
    private int index;

    public CertPathReviewerException(a aVar) {
        super(aVar);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(a aVar, Throwable th) {
        super(aVar, th);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(a aVar, Throwable th, CertPath certPath, int i) {
        super(aVar, th);
        this.index = -1;
        this.certPath = null;
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath;
            this.index = i;
        }
    }

    public CertPathReviewerException(a aVar, CertPath certPath, int i) {
        super(aVar);
        this.index = -1;
        this.certPath = null;
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath;
            this.index = i;
        }
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
