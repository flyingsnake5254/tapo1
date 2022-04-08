package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class h {
    private static final Object a = new Object();
    @GuardedBy("lock")

    /* renamed from: b  reason: collision with root package name */
    private static h f4947b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f4948c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes2.dex */
    public enum a implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            h.a().f4948c.post(runnable);
        }
    }

    private h(Looper looper) {
        this.f4948c = new zzb(looper);
    }

    @KeepForSdk
    public static h a() {
        h hVar;
        synchronized (a) {
            if (f4947b == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                f4947b = new h(handlerThread.getLooper());
            }
            hVar = f4947b;
        }
        return hVar;
    }

    @KeepForSdk
    public static Executor d() {
        return a.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void f(Callable callable, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(callable.call());
        } catch (MlKitException e2) {
            taskCompletionSource.setException(e2);
        } catch (Exception e3) {
            taskCompletionSource.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e3));
        }
    }

    @KeepForSdk
    public <ResultT> Task<ResultT> b(final Callable<ResultT> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        c(new Runnable(callable, taskCompletionSource) { // from class: com.google.mlkit.common.sdkinternal.s

            /* renamed from: c  reason: collision with root package name */
            private final Callable f4971c;

            /* renamed from: d  reason: collision with root package name */
            private final TaskCompletionSource f4972d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4971c = callable;
                this.f4972d = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.f(this.f4971c, this.f4972d);
            }
        });
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public void c(Runnable runnable) {
        d().execute(runnable);
    }
}
