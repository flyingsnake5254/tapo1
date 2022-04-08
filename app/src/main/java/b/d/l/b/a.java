package b.d.l.b;

import android.text.TextUtils;
import b.d.p.d;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpstreamclientmanager.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ImageDownloadClient.java */
/* loaded from: classes3.dex */
public class a implements b.d.m.b.a, Callable<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f524c = "a";

    /* renamed from: d  reason: collision with root package name */
    private final String f525d;

    /* renamed from: f  reason: collision with root package name */
    private Future<Boolean> f526f;
    private final Object y = new Object();
    private final Object z = new Object();
    private final AtomicInteger p0 = new AtomicInteger(0);
    private boolean q = true;
    private final List<b> x = new ArrayList();

    public a(String str) {
        this.f525d = str;
    }

    @Override // b.d.m.b.a
    public void a(String str, String str2, int i, byte[] bArr) {
        this.p0.decrementAndGet();
        String str3 = f524c;
        d.a(str3, "image：" + str2 + " download success");
        Iterator<b> it = this.x.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            g d2 = next.d();
            if (d2.b().equals(str) && d2.c().equals(str2) && d2.d() == i) {
                f b2 = next.b();
                if (b2 != null) {
                    b2.c(bArr);
                }
                it.remove();
            }
        }
        synchronized (this.z) {
            this.z.notifyAll();
        }
    }

    @Override // b.d.m.b.a
    public void b(String str, String str2, int i, Exception exc) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            this.p0.decrementAndGet();
            String str3 = f524c;
            d.a(str3, "image：" + str2 + " download failed " + exc.toString());
            Iterator<b> it = this.x.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                g d2 = next.d();
                if (d2.b().equals(str) && d2.c().equals(str2) && d2.d() == i) {
                    next.a();
                    break;
                }
            }
            synchronized (this.z) {
                this.z.notifyAll();
            }
        }
    }

    /* renamed from: c */
    public Boolean call() throws Exception {
        d.a(f524c, "down client start");
        while (this.q) {
            if (this.x.size() == 0) {
                synchronized (this.y) {
                    this.y.wait();
                }
            }
            b bVar = this.x.get(0);
            if (bVar.c() >= 3) {
                f b2 = bVar.b();
                if (b2 != null) {
                    b2.c(null);
                }
                this.x.remove(0);
                String str = f524c;
                d.a(str, "image：" + bVar.d().c() + " download failed over 3 times，remove download queue");
            } else {
                String str2 = f524c;
                d.a(str2, "image：" + bVar.d().c() + " start download");
                this.p0.set(0);
                this.p0.incrementAndGet();
                m.V().Q(this.f525d, bVar.d().a(), bVar.d().d(), bVar.d().c(), this);
                if (this.p0.get() > 0) {
                    synchronized (this.z) {
                        this.z.wait();
                    }
                } else {
                    continue;
                }
            }
        }
        d.a(f524c, "down client terminal");
        return Boolean.TRUE;
    }

    public void d(g gVar) {
        if (this.q) {
            this.x.remove(new b(gVar, null));
            String str = f524c;
            d.a(str, "image: " + gVar.c() + " remove from download queue");
        }
    }

    public void e() {
        this.q = false;
        m.V().w0(this.f525d);
        synchronized (this.y) {
            this.y.notifyAll();
        }
        synchronized (this.z) {
            this.z.notifyAll();
        }
        Future<Boolean> future = this.f526f;
        if (future != null) {
            future.cancel(true);
        }
    }

    public void f(Future<Boolean> future) {
        this.f526f = future;
    }

    public void g(g gVar, f fVar) {
        if (this.q) {
            b bVar = new b(gVar, fVar);
            if (!this.x.contains(bVar)) {
                this.x.add(bVar);
                synchronized (this.y) {
                    this.y.notifyAll();
                }
                String str = f524c;
                d.a(str, "image: " + gVar.c() + " has submit download task");
            }
        }
    }
}
