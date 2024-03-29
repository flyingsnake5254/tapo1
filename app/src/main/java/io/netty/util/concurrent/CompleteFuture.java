package io.netty.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class CompleteFuture<V> extends AbstractFuture<V> {
    private final EventExecutor executor;

    /* JADX INFO: Access modifiers changed from: protected */
    public CompleteFuture(EventExecutor eventExecutor) {
        this.executor = eventExecutor;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        DefaultPromise.notifyListener(executor(), this, (GenericFutureListener) ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        GenericFutureListener[] genericFutureListenerArr2;
        for (GenericFutureListener genericFutureListener : (GenericFutureListener[]) ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners")) {
            if (genericFutureListener == null) {
                break;
            }
            DefaultPromise.notifyListener(executor(), this, genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> await() throws InterruptedException {
        if (!Thread.interrupted()) {
            return this;
        }
        throw new InterruptedException();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> awaitUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j) {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        return true;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> sync() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }
}
