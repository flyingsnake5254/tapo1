package b.d.n.h;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DownloadExecutor.java */
/* loaded from: classes3.dex */
public class b implements Executor {

    /* renamed from: c  reason: collision with root package name */
    private static Executor f603c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f604d = Executors.newFixedThreadPool(2);

    public static Executor a() {
        if (f603c == null) {
            synchronized (b.class) {
                if (f603c == null) {
                    f603c = new b();
                }
            }
        }
        return f603c;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f604d.execute(runnable);
    }
}
