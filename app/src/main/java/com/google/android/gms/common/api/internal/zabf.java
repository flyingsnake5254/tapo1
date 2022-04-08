package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class zabf {
    private final zabd zahu;

    /* JADX INFO: Access modifiers changed from: protected */
    public zabf(zabd zabdVar) {
        this.zahu = zabdVar;
    }

    protected abstract void zaan();

    public final void zac(zabe zabeVar) {
        Lock lock;
        Lock lock2;
        zabd zabdVar;
        lock = zabeVar.zaeo;
        lock.lock();
        try {
            zabdVar = zabeVar.zahq;
            if (zabdVar == this.zahu) {
                zaan();
            }
        } finally {
            lock2 = zabeVar.zaeo;
            lock2.unlock();
        }
    }
}
