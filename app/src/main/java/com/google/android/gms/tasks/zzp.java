package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzp implements Runnable {
    private final /* synthetic */ Task zzg;
    private final /* synthetic */ zzo zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzo zzoVar, Task task) {
        this.zzs = zzoVar;
        this.zzg = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.zzs.zzr;
            Task then = successContinuation.then(this.zzg.getResult());
            if (then == null) {
                this.zzs.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zzw;
            then.addOnSuccessListener(executor, this.zzs);
            then.addOnFailureListener(executor, this.zzs);
            then.addOnCanceledListener(executor, this.zzs);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzs.onFailure((Exception) e2.getCause());
            } else {
                this.zzs.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.zzs.onCanceled();
        } catch (Exception e3) {
            this.zzs.onFailure(e3);
        }
    }
}
