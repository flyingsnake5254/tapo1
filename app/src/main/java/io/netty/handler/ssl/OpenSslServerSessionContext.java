package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        super(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionCacheSize() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return (int) SSLContext.getSessionCacheSize(this.context.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionTimeout() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return (int) SSLContext.getSessionCacheTimeout(this.context.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public boolean isSessionCacheEnabled() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return SSLContext.getSessionCacheMode(this.context.ctx) == SSL.SSL_SESS_CACHE_SERVER;
        } finally {
            readLock.unlock();
        }
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public void setSessionCacheEnabled(boolean z) {
        long j = z ? SSL.SSL_SESS_CACHE_SERVER : SSL.SSL_SESS_CACHE_OFF;
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheMode(this.context.ctx, j);
        } finally {
            writeLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionCacheSize(int i) {
        if (i >= 0) {
            Lock writeLock = this.context.ctxLock.writeLock();
            writeLock.lock();
            try {
                SSLContext.setSessionCacheSize(this.context.ctx, i);
            } finally {
                writeLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean setSessionIdContext(byte[] bArr) {
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, bArr);
        } finally {
            writeLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int i) {
        if (i >= 0) {
            Lock writeLock = this.context.ctxLock.writeLock();
            writeLock.lock();
            try {
                SSLContext.setSessionCacheTimeout(this.context.ctx, i);
            } finally {
                writeLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
