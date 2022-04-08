package org.bouncycastle.cms;

/* loaded from: classes4.dex */
public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e  reason: collision with root package name */
    Exception f17065e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f17065e = exc;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f17065e;
    }

    public Exception getUnderlyingException() {
        return this.f17065e;
    }
}
