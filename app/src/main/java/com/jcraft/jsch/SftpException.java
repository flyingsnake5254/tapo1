package com.jcraft.jsch;

/* loaded from: classes2.dex */
public class SftpException extends Exception {
    private Throwable cause;
    public int id;

    public SftpException(int i, String str) {
        super(str);
        this.cause = null;
        this.id = i;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.id + ": " + getMessage();
    }

    public SftpException(int i, String str, Throwable th) {
        super(str);
        this.cause = null;
        this.id = i;
        this.cause = th;
    }
}
