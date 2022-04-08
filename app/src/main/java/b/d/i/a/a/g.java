package b.d.i.a.a;

import b.d.d.d.c;
import b.d.p.d;
import b.d.t.e.e;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpstreampreconnect.bean.Status;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: UpnpHelper.java */
/* loaded from: classes3.dex */
public class g {
    private final AtomicBoolean a = new AtomicBoolean(false);

    private boolean b(String str) {
        return str != null && (System.currentTimeMillis() / 1000) - ((long) e.f(str)) > 86400;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(List list, Integer num) throws Exception {
        d.a("UpnpHelper", "do upnp pre connection");
        for (TPMediaDevice tPMediaDevice : new ArrayList(list)) {
            String deviceIdMd5 = tPMediaDevice.getDeviceIdMd5();
            if (!c.i(deviceIdMd5) && e.g(deviceIdMd5) && (e.i(deviceIdMd5) || b(deviceIdMd5))) {
                Status a = e.a(deviceIdMd5);
                d.a("UpnpHelper", "got device " + tPMediaDevice.getDeviceIdMd5() + " upnp pre status " + a);
                if (a != Status.unknown) {
                    e.l(deviceIdMd5, a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(io.reactivex.e0.c cVar) throws Exception {
        this.a.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h() throws Exception {
        this.a.set(false);
    }

    public void a(final List<TPMediaDevice> list) {
        if (list != null && !this.a.get()) {
            q.f0(1).E(new io.reactivex.g0.g() { // from class: b.d.i.a.a.a
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    g.this.d(list, (Integer) obj);
                }
            }).L0(a.c()).F(new io.reactivex.g0.g() { // from class: b.d.i.a.a.b
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    g.this.f((io.reactivex.e0.c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: b.d.i.a.a.c
                @Override // io.reactivex.g0.a
                public final void run() {
                    g.this.h();
                }
            }).C(d.f461c).F0();
        }
    }
}
