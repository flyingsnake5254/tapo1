package org.apache.commons.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.commons.lang.exception.NestableDelegate;
import org.apache.commons.lang.exception.b;

/* loaded from: classes4.dex */
public class NotImplementedException extends UnsupportedOperationException implements b {
    private static final String DEFAULT_MESSAGE = "Code is not implemented";
    private static final long serialVersionUID = -6894122266938754088L;
    private Throwable cause;
    private NestableDelegate delegate;

    public NotImplementedException() {
        super(DEFAULT_MESSAGE);
        this.delegate = new NestableDelegate(this);
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.b
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        Throwable th = this.cause;
        if (th != null) {
            return th.toString();
        }
        return null;
    }

    public String[] getMessages() {
        return this.delegate.getMessages();
    }

    public Throwable getThrowable(int i) {
        return this.delegate.getThrowable(i);
    }

    public int getThrowableCount() {
        return this.delegate.getThrowableCount();
    }

    public Throwable[] getThrowables() {
        return this.delegate.getThrowables();
    }

    public int indexOfThrowable(Class cls) {
        return this.delegate.indexOfThrowable(cls, 0);
    }

    @Override // org.apache.commons.lang.exception.b
    public final void printPartialStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        this.delegate.printStackTrace();
    }

    public int indexOfThrowable(Class cls, int i) {
        return this.delegate.indexOfThrowable(cls, i);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        this.delegate.printStackTrace(printStream);
    }

    public NotImplementedException(String str) {
        super(str == null ? DEFAULT_MESSAGE : str);
        this.delegate = new NestableDelegate(this);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        this.delegate.printStackTrace(printWriter);
    }

    public NotImplementedException(Throwable th) {
        super(DEFAULT_MESSAGE);
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    @Override // org.apache.commons.lang.exception.b
    public String getMessage(int i) {
        if (i == 0) {
            return super.getMessage();
        }
        return this.delegate.getMessage(i);
    }

    public NotImplementedException(String str, Throwable th) {
        super(str == null ? DEFAULT_MESSAGE : str);
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NotImplementedException(java.lang.Class r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0005
            java.lang.String r3 = "Code is not implemented"
            goto L_0x0016
        L_0x0005:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Code is not implemented in "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x0016:
            r2.<init>(r3)
            org.apache.commons.lang.exception.NestableDelegate r3 = new org.apache.commons.lang.exception.NestableDelegate
            r3.<init>(r2)
            r2.delegate = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.NotImplementedException.<init>(java.lang.Class):void");
    }
}
