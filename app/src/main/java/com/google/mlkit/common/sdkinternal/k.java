package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.util.Deque;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class k extends zzu {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Deque<Runnable>> f4952c = new u();

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f4953d = new ThreadPoolExecutor(0, Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.google.mlkit.common.sdkinternal.t

        /* renamed from: c  reason: collision with root package name */
        private final k f4973c;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f4973c = this;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return this.f4973c.b(runnable);
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private final ThreadFactory f4954f = Executors.defaultThreadFactory();
    @GuardedBy("threadPoolThreads")
    private final WeakHashMap<Thread, Void> q = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public final Thread b(Runnable runnable) {
        Thread newThread = this.f4954f.newThread(runnable);
        synchronized (this.q) {
            this.q.put(newThread, null);
        }
        return newThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Runnable runnable) {
        Deque<Runnable> deque = f4952c.get();
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzu, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        boolean containsKey;
        synchronized (this.q) {
            containsKey = this.q.containsKey(Thread.currentThread());
        }
        if (containsKey) {
            d(runnable);
        } else {
            this.f4953d.execute(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.v

                /* renamed from: c  reason: collision with root package name */
                private final Runnable f4974c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4974c = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    k.d(this.f4974c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzu, com.google.android.gms.internal.mlkit_common.zzj
    protected final /* synthetic */ Object zza() {
        return zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_common.zzu
    public final ExecutorService zzb() {
        return this.f4953d;
    }
}
