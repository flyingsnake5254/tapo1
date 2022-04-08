package org.bouncycastle.i18n;

import java.util.Locale;

/* loaded from: classes4.dex */
public class LocalizedException extends Exception {
    private Throwable cause;
    protected a message;

    public LocalizedException(a aVar) {
        Locale.getDefault();
        throw null;
    }

    public LocalizedException(a aVar, Throwable th) {
        Locale.getDefault();
        throw null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public a getErrorMessage() {
        return this.message;
    }
}
