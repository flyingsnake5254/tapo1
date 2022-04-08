package b.d.l;

import androidx.annotation.NonNull;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpstreamclientmanager.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ImageDownloadManager.java */
/* loaded from: classes3.dex */
public class a {
    private final Map<String, b.d.l.b.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f521b;

    /* compiled from: ImageDownloadManager.java */
    /* renamed from: b.d.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class ThreadFactoryC0022a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f522c = new AtomicInteger(0);

        ThreadFactoryC0022a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-ImageDownloadManager-" + this.f522c.incrementAndGet());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageDownloadManager.java */
    /* loaded from: classes3.dex */
    public static class b {
        public static final a a = new a(null);
    }

    /* synthetic */ a(ThreadFactoryC0022a aVar) {
        this();
    }

    public static a b() {
        return b.a;
    }

    public void a(g gVar) {
        b.d.l.b.a aVar = this.a.get(gVar.b());
        if (aVar != null) {
            aVar.d(gVar);
        }
    }

    public void c() {
        for (b.d.l.b.a aVar : this.a.values()) {
            aVar.e();
        }
        this.a.clear();
        m.V().q0();
    }

    public void d(g gVar, f fVar) {
        String b2 = gVar.b();
        b.d.l.b.a aVar = this.a.get(b2);
        if (aVar == null) {
            synchronized (this) {
                aVar = new b.d.l.b.a(b2);
                aVar.f(this.f521b.submit(aVar));
                this.a.put(b2, aVar);
            }
        }
        aVar.g(gVar, fVar);
    }

    private a() {
        this.a = new ConcurrentHashMap();
        this.f521b = Executors.newCachedThreadPool(new ThreadFactoryC0022a());
    }
}
