package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfq extends Thread {
    final /* synthetic */ zzfr zza;
    private final BlockingQueue<zzfp<?>> zzc;
    @GuardedBy("threadLifeCycleLock")
    private boolean zzd = false;
    private final Object zzb = new Object();

    public zzfq(zzfr zzfrVar, String str, BlockingQueue<zzfp<?>> blockingQueue) {
        this.zza = zzfrVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzfq zzfqVar;
        zzfq zzfqVar2;
        obj = this.zza.zzg;
        synchronized (obj) {
            if (!this.zzd) {
                semaphore = this.zza.zzh;
                semaphore.release();
                obj2 = this.zza.zzg;
                obj2.notifyAll();
                zzfqVar = this.zza.zza;
                if (this == zzfqVar) {
                    this.zza.zza = null;
                } else {
                    zzfqVar2 = this.zza.zzb;
                    if (this == zzfqVar2) {
                        this.zza.zzb = null;
                    } else {
                        this.zza.zzs.zzau().zzb().zza("Current scheduler thread is neither worker nor network");
                    }
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzs.zzau().zze().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z = false;
        while (!z) {
            try {
                semaphore = this.zza.zzh;
                semaphore.acquire();
                z = true;
            } catch (InterruptedException e2) {
                zzc(e2);
            }
        }
        try {
            int i = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfp<?> poll = this.zzc.poll();
                if (poll == null) {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            boolean unused = this.zza.zzi;
                            try {
                                this.zzb.wait(30000L);
                            } catch (InterruptedException e3) {
                                zzc(e3);
                            }
                        }
                    }
                    obj = this.zza.zzg;
                    synchronized (obj) {
                        if (this.zzc.peek() == null) {
                            break;
                        }
                    }
                } else {
                    if (true != poll.zza) {
                        i = 10;
                    }
                    Process.setThreadPriority(i);
                    poll.run();
                }
            }
            if (this.zza.zzs.zzc().zzn(null, zzea.zzao)) {
                zzb();
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
