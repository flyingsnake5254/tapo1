package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class zaau implements Runnable {
    private final /* synthetic */ zaak zagj;

    private zaau(zaak zaakVar) {
        this.zagj = zaakVar;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        Lock lock;
        zabe zabeVar;
        Lock lock2;
        lock = this.zagj.zaeo;
        lock.lock();
        try {
            if (!Thread.interrupted()) {
                zaan();
            }
        } catch (RuntimeException e2) {
            zabeVar = this.zagj.zaft;
            zabeVar.zab(e2);
        } finally {
            lock2 = this.zagj.zaeo;
            lock2.unlock();
        }
    }

    @WorkerThread
    protected abstract void zaan();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaau(zaak zaakVar, zaal zaalVar) {
        this(zaakVar);
    }
}
