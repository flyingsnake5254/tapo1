package org.bouncycastle.jce.provider;

/* loaded from: classes4.dex */
public class AnnotatedException extends Exception {
    private Throwable _underlyingException;

    public AnnotatedException(String str) {
        this(str, null);
    }

    public AnnotatedException(String str, Throwable th) {
        super(str);
        this._underlyingException = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._underlyingException;
    }

    Throwable getUnderlyingException() {
        return this._underlyingException;
    }
}
