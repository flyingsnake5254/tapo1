package com.tplink.libtpstreamclientmanager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.a0.b.e;
import b.d.a0.b.g;
import b.d.d.e.a;
import b.d.i.a.b.c.o;
import b.d.m.b.b;
import b.d.o.a.f;
import b.d.o.b.c;
import b.d.v.b.d;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpappcommonmedia.exception.CameraException;
import com.tplink.libtpcommonstream.stream.control.common.ClientType;
import com.tplink.libtpcommonstream.stream.control.response.DoPlayResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import com.tplink.libtpstreampreconnect.bean.NatStatistics;
import com.tplink.libtpstreampreconnect.bean.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: StreamManager.java */
/* loaded from: classes3.dex */
public class m implements b.d.o.a.e, b.d.o.b.f, b.d.a0.a.e, g, b.d.v.a.b, b.d.v.b.e, b.d.m.a.b, b.d.m.b.d {
    private static volatile m a;

    /* renamed from: c  reason: collision with root package name */
    private final b.d.v.a.c f15093c;

    /* renamed from: d  reason: collision with root package name */
    private final b.d.m.a.c f15094d;
    private String j;

    /* renamed from: b  reason: collision with root package name */
    private String f15092b = "StreamManager";

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, b.d.o.b.e> f15095e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, b.d.a0.b.f> f15096f = new ConcurrentHashMap();
    private final Map<String, b.d.v.b.b> g = new ConcurrentHashMap(1);
    private final Map<String, b.d.m.b.c> h = new ConcurrentHashMap(1);
    private final Map<String, o> i = new ConcurrentHashMap();
    private Handler l = new Handler(Looper.getMainLooper());
    private ExecutorService k = Executors.newCachedThreadPool(new a());

    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f15097c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-StreamManager.executorService-" + this.f15097c.incrementAndGet());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    public class b implements d.a {
        final /* synthetic */ b.d.v.b.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.d.v.a.a f15099b;

        b(b.d.v.b.c cVar, b.d.v.a.a aVar) {
            this.a = cVar;
            this.f15099b = aVar;
        }

        @Override // b.d.v.b.d.a
        public void a() {
            this.a.onDoubleTalkCreateSuccess(this.f15099b.getDeviceIdMD5());
        }

        @Override // b.d.v.b.d.a
        public void b(int i) {
            if (i == -52411) {
                this.a.onDoubleTalkCreateFailure(this.f15099b.getDeviceIdMD5(), 1);
                m.this.f15093c.n(this.f15099b.getDeviceIdMD5());
                NatStatistics natStatistics = new NatStatistics();
                natStatistics.setPenetrationTime(0L);
                natStatistics.setFailureReason(-1);
                this.f15099b.getStatistics().add(natStatistics);
                return;
            }
            this.a.onDoubleTalkCreateFailure(this.f15099b.getDeviceIdMD5(), 2);
            m.this.f15093c.n(this.f15099b.getDeviceIdMD5());
            NatStatistics natStatistics2 = new NatStatistics();
            natStatistics2.setPenetrationTime(0L);
            natStatistics2.setFailureReason(-1);
            this.f15099b.getStatistics().add(natStatistics2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    public class c implements b.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.d.m.b.b f15101b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.m.b.a f15102c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b.d.m.b.c f15103d;

        c(String str, b.d.m.b.b bVar, b.d.m.b.a aVar, b.d.m.b.c cVar) {
            this.a = str;
            this.f15101b = bVar;
            this.f15102c = aVar;
            this.f15103d = cVar;
        }

        @Override // b.d.m.b.b.a
        public void a() {
        }

        @Override // b.d.m.b.b.a
        public void b(int i) {
            m.this.h.remove(this.a);
            this.f15101b.p();
            m.this.f15094d.p(this.a);
            b.d.m.b.a aVar = this.f15102c;
            String str = this.a;
            String g = this.f15103d.g();
            int f2 = this.f15103d.f();
            aVar.b(str, g, f2, new Exception("error " + i));
        }
    }

    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    class d implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f15105b;

        d(List list, String str) {
            this.a = list;
            this.f15105b = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            List list = this.a;
            if ((list == null || list.size() == 0) && m.this.l != null) {
                Handler handler = m.this.l;
                final String str = this.f15105b;
                handler.postDelayed(new Runnable() { // from class: com.tplink.libtpstreamclientmanager.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(r0, new b.d.p.e.b() { // from class: com.tplink.libtpstreamclientmanager.a
                            @Override // b.d.p.e.b
                            public final void a(Object obj) {
                                f.m().k(r1, (BitStreamType) obj);
                            }
                        });
                    }
                }, 3000L);
            }
        }
    }

    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    class e implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f15107b;

        e(List list, String str) {
            this.a = list;
            this.f15107b = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            List list = this.a;
            if ((list == null || list.size() == 0) && ((b.d.a0.b.f) m.this.f15096f.get(this.f15107b)) != null) {
                String str = m.this.f15092b;
                b.d.p.d.a(str, "设备： " + this.f15107b + "VOD 重连！");
                b.d.a0.a.f.c().a(this.f15107b);
            }
        }
    }

    /* compiled from: StreamManager.java */
    /* loaded from: classes3.dex */
    class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f15109c;

        f(String str) {
            this.f15109c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((b.d.a0.b.f) m.this.f15096f.get(this.f15109c)) != null) {
                String str = m.this.f15092b;
                b.d.p.d.a(str, "设备： " + this.f15109c + "VOD 重连！");
                b.d.a0.a.f.c().a(this.f15109c);
            }
        }
    }

    private m() {
        b.d.o.a.f.m().v(this);
        b.d.a0.a.f.c().i(this);
        b.d.v.a.c k = b.d.v.a.c.k();
        this.f15093c = k;
        k.o(this);
        b.d.m.a.c m = b.d.m.a.c.m();
        this.f15094d = m;
        m.q(this);
    }

    private void F(b.d.o.b.d dVar, String str) {
        b.d.v.b.c a2;
        b.d.v.b.b bVar = this.g.get(str);
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.onDoubleTalkClose(str);
        }
    }

    private void F0(String str, byte[] bArr) {
        b.d.v.b.b bVar = this.g.get(str);
        if (bVar != null) {
            b.d.v.b.d b2 = bVar.b();
            b.d.v.b.c a2 = bVar.a();
            if (b2 == null && a2 != null) {
                a2.onDoubleTalkSendDataFailure(str, -1, new Exception("null == connection"));
            } else if (b2 != null) {
                b2.t(bArr);
            }
        }
    }

    private void G(String str, b.d.v.b.c cVar, String str2) {
        b.d.v.b.b bVar = new b.d.v.b.b();
        bVar.c(cVar);
        this.g.put(str, bVar);
        this.f15093c.j(str, str2);
    }

    private void H(b.d.v.a.a aVar, b.d.v.b.b bVar, String str) {
        b.d.v.b.c a2 = bVar.a();
        b.d.v.b.d dVar = new b.d.v.b.d(b.d.i.a.b.a.d(str, aVar.getTalkMode(), W(str).b()));
        dVar.h(str);
        dVar.i(aVar.getIp());
        dVar.j(aVar.getPort());
        dVar.v(a2);
        dVar.w(this);
        dVar.z(W(str));
        dVar.x(this.k.submit(dVar));
        dVar.g(aVar.getConnectionType());
        dVar.A(aVar.getTalkMode());
        dVar.u(new b(a2, aVar));
        bVar.d(dVar);
    }

    private void I(b.d.m.a.a aVar, b.d.m.b.c cVar, String str) {
        b.d.m.b.a d2 = cVar.d();
        b.d.m.b.b bVar = new b.d.m.b.b(b.d.i.a.b.a.a(cVar.c(), cVar.f(), cVar.g(), U(str).b()));
        bVar.h(str);
        bVar.i(aVar.getIp());
        bVar.j(aVar.getPort());
        bVar.t(d2);
        bVar.v(this);
        bVar.r(U(str));
        bVar.w(this.k.submit(bVar));
        bVar.g(aVar.getConnectionType());
        bVar.y(cVar.g());
        bVar.u(cVar.f());
        bVar.s(new c(str, bVar, d2, cVar));
        cVar.j(bVar);
    }

    private void J(String str, int i, int i2, String str2, b.d.m.b.a aVar) {
        b.d.m.b.c cVar = new b.d.m.b.c();
        cVar.h(i);
        cVar.k(i2);
        cVar.l(str2);
        cVar.i(aVar);
        this.h.put(str, cVar);
        this.f15094d.l(str);
    }

    private void K(b.d.o.a.d dVar, b.d.o.b.e eVar, String str) {
        b.d.o.b.c f2 = eVar.f();
        if (f2 != null) {
            b.d.o.b.d dVar2 = new b.d.o.b.d(b.d.i.a.b.a.c(str, dVar.getBitStreamType(), null, W(str).b()), b.d.i.a.b.a.c(str, BitStreamType.MINOR_VGA, null, W(str).b()));
            dVar2.s(f2);
            dVar2.h(dVar.getDeviceIdMD5());
            dVar2.t(this);
            dVar2.k(dVar.getStreamType());
            dVar2.i(dVar.getIp());
            dVar2.j(dVar.getPort());
            dVar2.g(dVar.getConnectionType());
            dVar2.u(W(str));
            dVar2.v(this.k.submit(dVar2));
            eVar.a(dVar2);
        }
    }

    private void L(b.d.o.a.d dVar, b.d.o.b.e eVar, String str) {
        b.d.o.b.c f2 = eVar.f();
        if (f2 != null) {
            b.d.o.b.g gVar = new b.d.o.b.g(b.d.i.a.b.a.c(str, dVar.getBitStreamType(), null, W(str).b()), b.d.i.a.b.a.c(str, BitStreamType.MINOR_VGA, null, W(str).b()));
            gVar.C(b.d.d.d.c.g(str));
            gVar.B(b.d.d.d.c.f(str));
            gVar.s(f2);
            gVar.h(dVar.getDeviceIdMD5());
            gVar.t(this);
            gVar.k(dVar.getStreamType());
            gVar.i(dVar.getIp());
            gVar.j(dVar.getPort());
            gVar.g(dVar.getConnectionType());
            gVar.u(W(str));
            gVar.v(this.k.submit(gVar));
            eVar.a(gVar);
        }
    }

    private void M(b.d.a0.a.d dVar, b.d.a0.b.f fVar, String str) {
        b.d.a0.b.d g = fVar.g();
        o a0 = a0(str);
        String b2 = b.d.i.a.b.a.b(fVar.b(), fVar.e(), fVar.d(), fVar.f(), fVar.c(), a0.b());
        if (b2 == null) {
            g.b(str, new Exception("start time invalid " + fVar.f()));
            return;
        }
        b.d.a0.b.c cVar = new b.d.a0.b.c(b2);
        cVar.A(g);
        cVar.C(a0);
        cVar.B(this);
        cVar.L(b.d.d.d.c.g(str));
        cVar.K(b.d.d.d.c.f(str));
        cVar.h(dVar.getDeviceIdMD5());
        cVar.k(dVar.getStreamType());
        cVar.i(dVar.getIp());
        cVar.j(dVar.getPort());
        cVar.F(dVar.getUrl());
        cVar.g(dVar.getConnectionType());
        cVar.D(this.k.submit(cVar));
        fVar.a(cVar);
        String str2 = this.f15092b;
        b.d.p.d.a(str2, "设备：" + str + " onVodConnectionSuccess()");
    }

    private void N(b.d.a0.a.d dVar, b.d.a0.b.f fVar, String str) {
        b.d.a0.b.d g = fVar.g();
        o a0 = a0(str);
        String b2 = b.d.i.a.b.a.b(fVar.b(), fVar.e(), fVar.d(), fVar.f(), fVar.c(), a0.b());
        if (b2 == null) {
            g.b(str, new Exception("start time invalid " + fVar.f()));
            return;
        }
        b.d.a0.b.e eVar = new b.d.a0.b.e(b2);
        eVar.A(g);
        eVar.C(a0);
        eVar.h(dVar.getDeviceIdMD5());
        eVar.B(this);
        eVar.k(dVar.getStreamType());
        eVar.i(dVar.getIp());
        eVar.j(dVar.getPort());
        eVar.F(dVar.getUrl());
        eVar.g(dVar.getConnectionType());
        eVar.D(this.k.submit(eVar));
        fVar.a(eVar);
        String str2 = this.f15092b;
        b.d.p.d.a(str2, "设备：" + str + " onVodConnectionSuccess()");
    }

    public static m V() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    private o X(String str, String str2) {
        String Y = Y(str, str2);
        o oVar = this.i.get(Y);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o();
        this.i.put(Y, oVar2);
        return oVar2;
    }

    private String Y(String str, String str2) {
        return str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0(b.d.o.b.c cVar, String str, BitStreamType bitStreamType, Response response) throws Exception {
        if (response.getErrorCode() == 0) {
            cVar.f(str, bitStreamType, true, response.getErrorCode());
        } else if (response.getErrorCode() == -52405) {
            x0(str);
            cVar.b(str, new CameraException(-52405, "need too try use vga"));
        } else {
            cVar.f(str, bitStreamType, false, response.getErrorCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(b.d.m.b.b bVar, String str, int i, String str2, b.d.m.b.a aVar, GetDownloadResponse getDownloadResponse) throws Exception {
        if (getDownloadResponse.getErrorCode() != 0 || TextUtils.isEmpty(getDownloadResponse.getSessionId())) {
            this.h.remove(str2);
            bVar.p();
            this.f15094d.p(str2);
            aVar.b(str2, str, i, new Exception("error " + getDownloadResponse.getErrorCode()));
            return;
        }
        bVar.z(getDownloadResponse.getSessionId());
        bVar.y(str);
        bVar.u(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(String str, b.d.m.b.b bVar, b.d.m.b.a aVar, b.d.m.b.c cVar, Throwable th) throws Exception {
        this.h.remove(str);
        bVar.p();
        this.f15094d.p(str);
        aVar.b(str, cVar.g(), cVar.f(), new Exception(th));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m0(b.d.a0.b.e eVar, b.d.a0.b.d dVar, String str, DoPlayResponse doPlayResponse) throws Exception {
        eVar.z();
        dVar.d(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o0(b.d.a0.b.e eVar, String str, b.d.a0.b.d dVar, String str2, DoPlayResponse doPlayResponse) throws Exception {
        eVar.z();
        String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        float f2 = 1.0f;
        if (split.length == 2) {
            try {
                f2 = Float.parseFloat(split[0]) / Float.parseFloat(split[1]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dVar.e(str2, true, f2);
    }

    private void s0(String str) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, o> entry : this.i.entrySet()) {
            if (entry.getKey() != null && entry.getKey().contains(str)) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str2 : arrayList) {
            this.i.remove(str2);
        }
    }

    public synchronized void A(final String str, final b.d.o.b.c cVar, final BitStreamType bitStreamType, String str2) {
        b.d.o.b.e eVar = this.f15095e.get(str);
        if (eVar == null) {
            cVar.f(str, bitStreamType, false, -1);
            return;
        }
        o W = W(str);
        List<b.d.o.b.d> e2 = eVar.e();
        if (e2 != null) {
            for (b.d.o.b.d dVar : e2) {
                if (dVar != null) {
                    eVar.b(str, dVar.a(), W.e(dVar, str, bitStreamType, str2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.k
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            m.this.e0(cVar, str, bitStreamType, (Response) obj);
                        }
                    }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.j
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            Throwable th = (Throwable) obj;
                            c.this.f(str, bitStreamType, false, -1);
                        }
                    }).F0());
                }
            }
        } else {
            b.d.p.d.a("resolution", "no connection");
        }
    }

    public synchronized void A0(String str) {
        if (!TextUtils.isEmpty(str)) {
            x0(str);
            B0(str);
            u0(str);
            C(str);
            w0(str);
            E(str);
            String str2 = this.f15092b;
            b.d.p.d.a(str2, "设备：" + str + " vod、Live talk 流被销毁！");
        }
    }

    public void B() {
        this.f15093c.f();
    }

    public synchronized void B0(String str) {
        b.d.a0.b.f remove = this.f15096f.remove(str);
        if (remove != null) {
            List<b.d.a0.b.e> h = remove.h();
            if (h != null) {
                for (b.d.a0.b.e eVar : h) {
                    if (eVar != null) {
                        eVar.s();
                    }
                }
                h.clear();
            }
            remove.j();
            remove.r(null);
        }
        b.d.a0.a.f.c().f(str);
    }

    public void C(String str) {
        this.f15093c.g(str);
    }

    public void C0(String str) {
        o remove = this.i.remove(Y(ClientType.VOD, str));
        if (remove != null) {
            remove.E();
        }
    }

    public void D() {
        this.f15094d.h();
    }

    public synchronized void D0() {
        b.d.p.d.a(this.f15092b, "整个APP的VOD被销毁");
        for (Map.Entry<String, b.d.a0.b.f> entry : this.f15096f.entrySet()) {
            List<b.d.a0.b.e> h = entry.getValue().h();
            if (h != null) {
                for (b.d.a0.b.e eVar : h) {
                    if (eVar != null) {
                        eVar.s();
                    }
                }
                h.clear();
            }
            entry.getValue().j();
            b.d.a0.a.f.c().f(entry.getKey());
        }
        this.f15096f.clear();
    }

    public void E(String str) {
        this.f15094d.i(str);
    }

    public synchronized void E0(final String str, int i, String str2, long j, long j2, final b.d.a0.b.d dVar) {
        b.d.a0.b.f fVar = this.f15096f.get(str);
        boolean z = false;
        if (fVar == null || fVar.d() == null) {
            dVar.d(str, false);
        } else {
            fVar.p(j);
            fVar.l(j2);
            fVar.k(i);
            fVar.o(str2);
            o a0 = a0(str);
            if (fVar.h() != null) {
                Iterator<b.d.a0.b.e> it = fVar.h().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b.d.a0.b.e next = it.next();
                    if (next != null && next.m()) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                for (final b.d.a0.b.e eVar : fVar.h()) {
                    if (eVar != null) {
                        eVar.x();
                        a0.d(eVar, str, str2, j, j2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.l
                            @Override // io.reactivex.g0.g
                            public final void accept(Object obj) {
                                m.m0(e.this, dVar, str, (DoPlayResponse) obj);
                            }
                        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.e
                            @Override // io.reactivex.g0.g
                            public final void accept(Object obj) {
                                Throwable th = (Throwable) obj;
                                b.d.a0.b.d.this.d(str, false);
                            }
                        }).F0();
                    }
                }
            } else {
                B0(str);
                T(str, i, str2, fVar.d(), j, j2, dVar);
                dVar.f(str, j);
            }
        }
    }

    public synchronized void G0(final String str, final String str2, long j, long j2, final b.d.a0.b.d dVar) {
        boolean z;
        b.d.a0.b.f fVar = this.f15096f.get(str);
        if (fVar != null) {
            if (fVar.h() != null) {
                for (b.d.a0.b.e eVar : fVar.h()) {
                    if (eVar != null && eVar.m()) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            o a0 = a0(str);
            if (z) {
                fVar.o(str2);
                for (final b.d.a0.b.e eVar2 : fVar.h()) {
                    if (eVar2 != null) {
                        eVar2.u();
                        a0.d(eVar2, str, str2, j, j2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.d
                            @Override // io.reactivex.g0.g
                            public final void accept(Object obj) {
                                m.o0(e.this, str2, dVar, str, (DoPlayResponse) obj);
                            }
                        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.g
                            @Override // io.reactivex.g0.g
                            public final void accept(Object obj) {
                                Throwable th = (Throwable) obj;
                                b.d.a0.b.d.this.e(str, false, 1.0f);
                            }
                        }).F0();
                    }
                }
            } else {
                dVar.e(str, false, 1.0f);
            }
        }
    }

    public void H0(String str) {
        b.d.v.b.d b2;
        b.d.v.b.b bVar = this.g.get(str);
        if (bVar != null && (b2 = bVar.b()) != null) {
            b2.B();
        }
    }

    public void I0(String str) {
        if (str != null && str.equals(this.j) && this.g.get(str) != null) {
            this.j = null;
        }
    }

    public void J0(String str) {
        b.d.v.b.d b2;
        b.d.v.b.b bVar = this.g.get(str);
        if (bVar != null && (b2 = bVar.b()) != null) {
            b2.C();
        }
    }

    public void O() {
        b.d.p.d.a(this.f15092b, "destroy");
        z0();
        D0();
        t0();
        B();
        v0();
        D();
        a = null;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }

    public void P(String str, b.d.v.b.c cVar, String str2) {
        b.d.v.b.b bVar = this.g.get(str);
        if (bVar == null) {
            G(str, cVar, str2);
        } else if (bVar.b() == null) {
            bVar.c(null);
            this.g.remove(str);
            G(str, cVar, str2);
        }
    }

    public void Q(final String str, int i, final int i2, final String str2, final b.d.m.b.a aVar) {
        final b.d.m.b.c cVar = this.h.get(str);
        if (cVar == null) {
            J(str, i, i2, str2, aVar);
            return;
        }
        cVar.l(str2);
        cVar.k(i2);
        cVar.h(i);
        o U = U(str);
        final b.d.m.b.b e2 = cVar.e();
        if (e2 != null && U != null) {
            cVar.a(str, e2.a(), U.F(e2, str, i, i2, str2).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.f
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    m.this.h0(e2, str2, i2, str, aVar, (GetDownloadResponse) obj);
                }
            }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpstreamclientmanager.h
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    m.this.j0(str, e2, aVar, cVar, (Throwable) obj);
                }
            }).F0());
        } else if (aVar != null) {
            aVar.b(str, str2, i2, new Exception("no available connection"));
        }
    }

    public synchronized void R(String str, b.d.o.b.c cVar, BitStreamType bitStreamType) {
        if (this.f15095e.get(str) == null) {
            W(str).E();
            b.d.o.b.e eVar = new b.d.o.b.e();
            eVar.j(cVar);
            this.f15095e.put(str, eVar);
            b.d.o.a.f.m().k(str, bitStreamType);
            b.d.p.d.a(this.f15092b, "调用Connection层，尝试获取端口号，建立直播视频连接");
        }
    }

    public void S(String str, byte[] bArr) {
        F0(str, bArr);
    }

    public synchronized void T(String str, int i, String str2, int[] iArr, long j, long j2, b.d.a0.b.d dVar) {
        if (j > 0) {
            if (this.f15096f.get(str) == null) {
                a0(str).E();
                b.d.a0.b.f fVar = new b.d.a0.b.f();
                fVar.r(dVar);
                fVar.p(j);
                fVar.k(i);
                fVar.o(str2);
                fVar.m(iArr);
                fVar.q(j);
                fVar.l(j2);
                this.f15096f.put(str, fVar);
                b.d.a0.a.f.c().b(str, j, j2);
            }
        }
    }

    public o U(String str) {
        return X(ClientType.DOWNLOAD, str);
    }

    public o W(String str) {
        return X(ClientType.LIVE, str);
    }

    public List<b.d.a0.b.e> Z(String str) {
        b.d.a0.b.f fVar = this.f15096f.get(str);
        if (fVar != null) {
            return fVar.h();
        }
        return null;
    }

    @Override // b.d.o.b.f
    public synchronized void a(String str, int i, int i2) {
        StatisticsStreamType statisticsStreamType;
        try {
            if (i == 1) {
                statisticsStreamType = StatisticsStreamType.MIXED;
            } else if (i == 3) {
                statisticsStreamType = StatisticsStreamType.VIDEO;
            } else {
                statisticsStreamType = StatisticsStreamType.AUDIO;
            }
            if (16 == i2) {
                b.d.o.a.f.m().w(str, true);
            }
            b.d.o.b.e eVar = this.f15095e.get(str);
            if (eVar != null) {
                eVar.h();
                List<b.d.o.b.d> e2 = eVar.e();
                if (e2 != null) {
                    boolean z = false;
                    Iterator<b.d.o.b.d> it = e2.iterator();
                    while (it.hasNext()) {
                        b.d.o.b.d next = it.next();
                        if (next.a() < i2) {
                            next.p();
                            eVar.d(str, next.a());
                            it.remove();
                            b.d.o.a.f.m().j(str, next.a());
                            OnceConnectionVO onceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next.b(), statisticsStreamType, next.a()));
                            if (onceConnectionVO != null && i2 == 16 && next.a() == 0) {
                                onceConnectionVO.setStopReason(StopReason.RELAY_TO_P2P.value());
                            }
                        } else if (next.a() > i2 && next.d()) {
                            z = true;
                        }
                    }
                    if (z) {
                        Iterator<b.d.o.b.d> it2 = e2.iterator();
                        while (it2.hasNext()) {
                            b.d.o.b.d next2 = it2.next();
                            if (next2.a() == i2) {
                                next2.p();
                                eVar.d(str, next2.a());
                                it2.remove();
                                b.d.o.a.f.m().j(str, i2);
                                OnceConnectionVO onceConnectionVO2 = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next2.b(), statisticsStreamType, i2));
                                if (onceConnectionVO2 != null && i2 == 0) {
                                    onceConnectionVO2.setStopReason(StopReason.RELAY_TO_P2P.value());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public o a0(String str) {
        return X(ClientType.VOD, str);
    }

    @Override // b.d.m.a.b
    public void b(b.d.m.a.a aVar) {
        String deviceIdMD5;
        b.d.m.b.c cVar;
        if (aVar != null && (cVar = this.h.get((deviceIdMD5 = aVar.getDeviceIdMD5()))) != null) {
            b.d.m.b.a d2 = cVar.d();
            b.d.m.b.b e2 = cVar.e();
            if (e2 != null) {
                e2.p();
            }
            cVar.b();
            if (d2 != null) {
                I(aVar, cVar, deviceIdMD5);
            } else {
                this.f15094d.p(deviceIdMD5);
            }
        }
    }

    public synchronized boolean b0(String str) {
        return this.f15096f.get(str) != null;
    }

    @Override // b.d.m.b.d
    public void c(String str, int i, Exception exc) {
        if (i == 17) {
            b.d.t.e.e.l(str, Status.unknown);
        }
        if (16 == i) {
            this.f15094d.g(str);
        }
        b.d.m.b.c remove = this.h.remove(str);
        if (remove != null) {
            b.d.m.b.b e2 = remove.e();
            if (e2 != null) {
                e2.p();
            }
            remove.b();
            remove.j(null);
        }
    }

    public void c0(String str) {
        if (str != null && this.g.get(str) != null) {
            this.j = str;
        }
    }

    @Override // b.d.o.a.e
    public void d(List<b.d.o.a.d> list) {
        StatisticsStreamType statisticsStreamType;
        if (list != null) {
            for (b.d.o.a.d dVar : list) {
                int connectionType = dVar.getConnectionType();
                if (dVar.getStreamType() == 1) {
                    statisticsStreamType = StatisticsStreamType.MIXED;
                } else if (dVar.getStreamType() == 3) {
                    statisticsStreamType = StatisticsStreamType.VIDEO;
                } else {
                    statisticsStreamType = StatisticsStreamType.AUDIO;
                }
                String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(dVar.getDeviceIdMD5(), statisticsStreamType);
                ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
                if (connectionInfoVO == null) {
                    connectionInfoVO = new ConnectionInfoVO();
                    StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
                }
                List<NatStatistics> statistics = dVar.getStatistics();
                if (statistics != null) {
                    for (NatStatistics natStatistics : statistics) {
                        OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                        onceConnectionVO.setSuccess(natStatistics.getFailureReason());
                        onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                        onceConnectionVO.setStopReason(-1);
                        if (connectionType == 16) {
                            connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                        } else if (connectionType == 0) {
                            connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                        }
                    }
                }
            }
        }
    }

    @Override // b.d.m.a.b
    public void e(b.d.m.a.a aVar) {
    }

    @Override // b.d.o.a.e
    public void f(String str) {
        String str2 = this.f15092b;
        b.d.p.d.a(str2, "设备：" + str + " onLiveConnectionFailure()");
        b.d.o.b.e eVar = this.f15095e.get(str);
        if (eVar != null) {
            eVar.f().b(str, new Exception("Live Connection Failure!"));
        }
    }

    @Override // b.d.v.b.e
    public void g(String str, int i, Exception exc) {
        if (i == 17) {
            b.d.t.e.e.l(str, Status.unknown);
        }
        if (16 == i) {
            this.f15093c.e(str);
        }
        b.d.v.b.b remove = this.g.remove(str);
        if (remove != null) {
            b.d.v.b.d b2 = remove.b();
            if (b2 != null) {
                b2.p();
            }
            remove.c(null);
        }
    }

    @Override // b.d.v.a.b
    public void h(b.d.v.a.a aVar) {
        String deviceIdMD5;
        b.d.v.b.b bVar;
        if (aVar != null && (bVar = this.g.get((deviceIdMD5 = aVar.getDeviceIdMD5()))) != null) {
            b.d.v.b.c a2 = bVar.a();
            b.d.v.b.d b2 = bVar.b();
            if (b2 != null) {
                b2.p();
            }
            if (a2 != null) {
                H(aVar, bVar, deviceIdMD5);
                StatisticsManager instance = StatisticsManager.getInstance();
                String deviceIdMD52 = aVar.getDeviceIdMD5();
                StatisticsStreamType statisticsStreamType = StatisticsStreamType.DOUBLE_TALK;
                String connectionInfoCacheKey = instance.getConnectionInfoCacheKey(deviceIdMD52, statisticsStreamType);
                ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
                if (connectionInfoVO == null) {
                    connectionInfoVO = new ConnectionInfoVO();
                    StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
                }
                List<NatStatistics> statistics = aVar.getStatistics();
                if (statistics != null) {
                    for (NatStatistics natStatistics : statistics) {
                        OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                        int failureReason = natStatistics.getFailureReason();
                        onceConnectionVO.setSuccess(failureReason);
                        onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                        if (failureReason != 0) {
                            onceConnectionVO.setStopReason(-1);
                            if (aVar.getConnectionType() == 16) {
                                connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                            } else if (aVar.getConnectionType() == 0) {
                                connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                            }
                        } else {
                            StatisticsManager.getInstance().insertOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(aVar.getDeviceIdMD5(), StatisticsStreamType.DOUBLE_TALK, aVar.getConnectionType()), onceConnectionVO);
                        }
                    }
                } else if (aVar.getConnectionType() == 256) {
                    OnceConnectionVO onceConnectionVO2 = new OnceConnectionVO();
                    onceConnectionVO2.setSuccess(0);
                    onceConnectionVO2.setTraverseTime(0);
                    StatisticsManager.getInstance().insertOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(aVar.getDeviceIdMD5(), statisticsStreamType, aVar.getConnectionType()), onceConnectionVO2);
                }
            } else {
                this.f15093c.n(deviceIdMD5);
            }
        }
    }

    @Override // b.d.a0.b.g
    public synchronized void i(String str, int i) {
        if (16 == i) {
            b.d.a0.a.f.c().j(str, true);
        }
        b.d.a0.b.f fVar = this.f15096f.get(str);
        if (fVar != null) {
            fVar.j();
            List<b.d.a0.b.e> h = fVar.h();
            if (h != null) {
                boolean z = false;
                Iterator<b.d.a0.b.e> it = h.iterator();
                while (it.hasNext()) {
                    b.d.a0.b.e next = it.next();
                    if (next.a() < i) {
                        next.s();
                        it.remove();
                        b.d.a0.a.f.c().g(str, next.a());
                        OnceConnectionVO onceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next.b(), StatisticsStreamType.SD_VOD, next.a()));
                        if (onceConnectionVO != null && i == 16 && next.a() == 0) {
                            onceConnectionVO.setStopReason(StopReason.RELAY_TO_P2P.value());
                        }
                    } else if (next.a() > i && next.d()) {
                        z = true;
                    }
                }
                if (z) {
                    Iterator<b.d.a0.b.e> it2 = h.iterator();
                    while (it2.hasNext()) {
                        b.d.a0.b.e next2 = it2.next();
                        if (next2.a() == i) {
                            next2.s();
                            it2.remove();
                            b.d.a0.a.f.c().g(str, i);
                            OnceConnectionVO onceConnectionVO2 = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next2.b(), StatisticsStreamType.SD_VOD, i));
                            if (onceConnectionVO2 != null && i == 0) {
                                onceConnectionVO2.setStopReason(StopReason.RELAY_TO_P2P.value());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // b.d.a0.a.e
    public void j(String str) {
        String str2 = this.f15092b;
        b.d.p.d.a(str2, "设备：" + str + " onVodConnectionFailure()");
        String str3 = this.f15092b;
        b.d.p.d.c(str3, "onVodVideoConnectionFailure " + str);
        b.d.a0.b.f fVar = this.f15096f.get(str);
        if (fVar != null) {
            fVar.g().b(str, new Exception("VOD Connection Failure!"));
        }
    }

    @Override // b.d.o.a.e
    public void k(List<b.d.o.a.d> list) {
        String deviceIdMD5;
        b.d.o.b.e eVar;
        StatisticsStreamType statisticsStreamType;
        b.d.p.d.a(this.f15092b, "Connection层直播穿透成功！");
        if (!(list == null || list.size() <= 0 || (eVar = this.f15095e.get((deviceIdMD5 = list.get(0).getDeviceIdMD5()))) == null)) {
            b.d.o.b.c f2 = eVar.f();
            for (b.d.o.a.d dVar : list) {
                int connectionType = dVar.getConnectionType();
                String str = this.f15092b;
                b.d.p.d.a(str, "设备：" + deviceIdMD5 + " connectionType " + connectionType);
                if (dVar.getStreamType() == 1) {
                    statisticsStreamType = StatisticsStreamType.MIXED;
                } else if (dVar.getStreamType() == 3) {
                    statisticsStreamType = StatisticsStreamType.VIDEO;
                } else {
                    statisticsStreamType = StatisticsStreamType.AUDIO;
                }
                String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(dVar.getDeviceIdMD5(), statisticsStreamType);
                ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
                if (connectionInfoVO == null) {
                    connectionInfoVO = new ConnectionInfoVO();
                    StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
                }
                List<NatStatistics> statistics = dVar.getStatistics();
                if (statistics != null) {
                    for (NatStatistics natStatistics : statistics) {
                        OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                        int failureReason = natStatistics.getFailureReason();
                        onceConnectionVO.setSuccess(failureReason);
                        onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                        if (failureReason != 0) {
                            onceConnectionVO.setStopReason(-1);
                            if (connectionType == 16) {
                                connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                            } else if (connectionType == 0) {
                                connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                            }
                        } else {
                            StatisticsManager.getInstance().insertOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(dVar.getDeviceIdMD5(), statisticsStreamType, connectionType), onceConnectionVO);
                        }
                    }
                }
                if (f2 != null) {
                    if (16 != dVar.getConnectionType() || !b.d.d.d.c.m(deviceIdMD5)) {
                        K(dVar, eVar, deviceIdMD5);
                    } else {
                        L(dVar, eVar, deviceIdMD5);
                    }
                }
            }
            String str2 = this.f15092b;
            b.d.p.d.a(str2, "设备：" + deviceIdMD5 + " onLiveConnectionSuccess()");
        }
    }

    @Override // b.d.a0.a.e
    public void l(b.d.a0.a.d dVar) {
        if (dVar != null) {
            int connectionType = dVar.getConnectionType();
            String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(dVar.getDeviceIdMD5(), StatisticsStreamType.SD_VOD);
            ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
            if (connectionInfoVO == null) {
                connectionInfoVO = new ConnectionInfoVO();
                StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
            }
            List<NatStatistics> statistics = dVar.getStatistics();
            if (statistics != null) {
                for (NatStatistics natStatistics : statistics) {
                    OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                    onceConnectionVO.setSuccess(natStatistics.getFailureReason());
                    onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                    onceConnectionVO.setStopReason(-1);
                    if (connectionType == 16) {
                        connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                    } else if (connectionType == 0) {
                        connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                    }
                }
            }
        }
    }

    @Override // b.d.a0.b.g
    public synchronized void m(String str, int i, boolean z, Exception exc) {
        Handler handler;
        if (i == 17) {
            try {
                b.d.t.e.e.l(str, Status.unknown);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (16 == i) {
            b.d.a0.a.f.c().j(str, false);
        }
        b.d.a0.b.f fVar = this.f15096f.get(str);
        if (fVar != null) {
            List<b.d.a0.b.e> h = fVar.h();
            if (h != null) {
                Iterator<b.d.a0.b.e> it = h.iterator();
                while (it.hasNext()) {
                    b.d.a0.b.e next = it.next();
                    if (next.a() == i) {
                        next.s();
                        it.remove();
                        b.d.a0.a.f.c().g(str, i);
                        OnceConnectionVO onceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next.b(), StatisticsStreamType.SD_VOD, next.a()));
                        if (onceConnectionVO != null) {
                            onceConnectionVO.setStopReason(StopReason.NETWORK_ERROR.value());
                        }
                    }
                }
            }
            if (z || 17 == i) {
                if (!fVar.i()) {
                    b.d.a0.b.d g = fVar.g();
                    if (g != null) {
                        g.b(str, new Exception("vod stream create failed"));
                    }
                    return;
                }
                fVar.n(false);
                if (exc.getMessage() != null && exc.getMessage().contains("unknown_psk_identity")) {
                    b.d.t.e.e.k(str).L0(io.reactivex.l0.a.c()).z(new e(h, str)).F0();
                } else if ((h == null || h.size() == 0) && (handler = this.l) != null) {
                    handler.postDelayed(new f(str), 3000L);
                }
            }
        }
    }

    @Override // b.d.m.a.b
    public void n(List<b.d.m.a.a> list) {
        b.d.m.b.a d2;
        b.d.m.a.a aVar = list.get(0);
        b.d.m.b.c cVar = this.h.get(aVar.getDeviceIdMD5());
        if (cVar != null && (d2 = cVar.d()) != null) {
            d2.b(aVar.getDeviceIdMD5(), cVar.g(), cVar.f(), new Exception("ConnectionFailure"));
        }
    }

    @Override // b.d.v.b.e
    public void o(String str, int i) {
        if (16 == i) {
            this.f15093c.g(str);
        }
    }

    @Override // b.d.v.a.b
    public void p(b.d.v.a.a aVar) {
        int connectionType = aVar.getConnectionType();
        String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(aVar.getDeviceIdMD5(), StatisticsStreamType.DOUBLE_TALK);
        ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
        if (connectionInfoVO == null) {
            connectionInfoVO = new ConnectionInfoVO();
            StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
        }
        List<NatStatistics> statistics = aVar.getStatistics();
        if (statistics != null) {
            for (NatStatistics natStatistics : statistics) {
                OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                onceConnectionVO.setSuccess(natStatistics.getFailureReason());
                onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                if (aVar.b() == 2) {
                    onceConnectionVO.setStopReason(-1);
                } else {
                    onceConnectionVO.setStopReason(0);
                }
                if (connectionType == 16) {
                    connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                } else if (connectionType == 0) {
                    connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                } else if (connectionType == 256) {
                    connectionInfoVO.getLocalConnectionVO().addData(onceConnectionVO);
                }
            }
        }
    }

    @Override // b.d.a0.a.e
    public void q(b.d.a0.a.d dVar) {
        b.d.p.d.a(this.f15092b, "Connection层VOD穿透成功！");
        if (dVar != null) {
            String str = this.f15092b;
            b.d.p.d.c(str, "onVodVideoConnectionSuccess" + dVar.toString());
            String deviceIdMD5 = dVar.getDeviceIdMD5();
            b.d.a0.b.f fVar = this.f15096f.get(deviceIdMD5);
            if (fVar != null) {
                if (16 != dVar.getConnectionType() || !b.d.d.d.c.m(deviceIdMD5)) {
                    N(dVar, fVar, deviceIdMD5);
                } else {
                    M(dVar, fVar, deviceIdMD5);
                }
                int connectionType = dVar.getConnectionType();
                String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(dVar.getDeviceIdMD5(), StatisticsStreamType.SD_VOD);
                ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
                if (connectionInfoVO == null) {
                    connectionInfoVO = new ConnectionInfoVO();
                    StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
                }
                List<NatStatistics> statistics = dVar.getStatistics();
                if (statistics != null) {
                    for (NatStatistics natStatistics : statistics) {
                        OnceConnectionVO onceConnectionVO = new OnceConnectionVO();
                        int failureReason = natStatistics.getFailureReason();
                        onceConnectionVO.setSuccess(failureReason);
                        onceConnectionVO.setTraverseTime(Math.round(((float) natStatistics.getPenetrationTime()) / 1000.0f));
                        if (failureReason != 0) {
                            onceConnectionVO.setStopReason(-1);
                            if (connectionType == 16) {
                                connectionInfoVO.getP2pConnectionVO().addData(onceConnectionVO);
                            } else if (connectionType == 0) {
                                connectionInfoVO.getRelayConnectionVO().addData(onceConnectionVO);
                            }
                        } else {
                            StatisticsManager.getInstance().insertOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(dVar.getDeviceIdMD5(), StatisticsStreamType.SD_VOD, connectionType), onceConnectionVO);
                        }
                    }
                }
            }
        }
    }

    public void q0() {
        s0(ClientType.DOWNLOAD);
    }

    @Override // b.d.m.b.d
    public void r(String str, int i) {
        if (16 == i) {
            this.f15094d.i(str);
        }
    }

    public void r0() {
        s0(ClientType.LIVE);
    }

    @Override // b.d.v.a.b
    public void s(List<b.d.v.a.a> list) {
        b.d.v.b.c a2;
        b.d.v.a.a aVar = list.get(0);
        b.d.v.b.b bVar = this.g.get(aVar.getDeviceIdMD5());
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.onDoubleTalkCreateFailure(aVar.getDeviceIdMD5(), aVar.b());
        }
    }

    @Override // b.d.o.b.f
    public synchronized void t(final String str, int i, boolean z, Exception exc) {
        Handler handler;
        StatisticsStreamType statisticsStreamType;
        if (i == 17) {
            try {
                b.d.t.e.e.l(str, Status.unknown);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (16 == i) {
            b.d.o.a.f.m().w(str, false);
        }
        b.d.o.b.e eVar = this.f15095e.get(str);
        if (eVar != null) {
            List<b.d.o.b.d> e2 = eVar.e();
            if (e2 != null) {
                Iterator<b.d.o.b.d> it = e2.iterator();
                while (it.hasNext()) {
                    b.d.o.b.d next = it.next();
                    if (next.a() == i) {
                        next.p();
                        eVar.d(str, next.a());
                        it.remove();
                        F(next, str);
                        b.d.o.a.f.m().j(str, i);
                        if (next.c() == 1) {
                            statisticsStreamType = StatisticsStreamType.MIXED;
                        } else if (next.c() == 3) {
                            statisticsStreamType = StatisticsStreamType.VIDEO;
                        } else {
                            statisticsStreamType = StatisticsStreamType.AUDIO;
                        }
                        OnceConnectionVO onceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(next.b(), statisticsStreamType, next.a()));
                        if (onceConnectionVO != null) {
                            onceConnectionVO.setStopReason(StopReason.NETWORK_ERROR.value());
                        }
                    }
                }
            }
            if (z || 17 == i) {
                if (!eVar.g()) {
                    b.d.o.b.c f2 = eVar.f();
                    if (f2 != null) {
                        f2.b(str, new Exception("Create Live Stream Connection Failed"));
                    }
                    return;
                }
                eVar.i(false);
                if (exc.getMessage() != null && exc.getMessage().contains("unknown_psk_identity")) {
                    b.d.t.e.e.k(str).L0(io.reactivex.l0.a.c()).z(new d(e2, str)).F0();
                } else if ((e2 == null || e2.size() == 0) && (handler = this.l) != null) {
                    handler.postDelayed(new Runnable() { // from class: com.tplink.libtpstreamclientmanager.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.a(r0, new b.d.p.e.b() { // from class: com.tplink.libtpstreamclientmanager.c
                                @Override // b.d.p.e.b
                                public final void a(Object obj) {
                                    f.m().k(r1, (BitStreamType) obj);
                                }
                            });
                        }
                    }, 3000L);
                }
            }
        }
    }

    public void t0() {
        this.f15093c.m();
        for (Map.Entry<String, b.d.v.b.b> entry : this.g.entrySet()) {
            b.d.v.b.b value = entry.getValue();
            b.d.v.b.d b2 = value.b();
            if (b2 != null) {
                b2.p();
            }
            value.c(null);
            value.d(null);
        }
        this.g.clear();
    }

    public void u0(String str) {
        if (str != null && !TextUtils.equals(str, this.j)) {
            b.d.v.b.b remove = this.g.remove(str);
            if (remove != null) {
                b.d.v.b.d b2 = remove.b();
                if (b2 != null) {
                    b2.p();
                }
                remove.c(null);
            }
            this.f15093c.n(str);
        }
    }

    public void v0() {
        for (Map.Entry<String, b.d.m.b.c> entry : this.h.entrySet()) {
            b.d.m.b.c value = entry.getValue();
            b.d.m.b.b e2 = value.e();
            if (e2 != null) {
                e2.p();
            }
            value.b();
            value.i(null);
            value.j(null);
        }
        this.f15094d.o();
        this.h.clear();
    }

    public void w0(String str) {
        if (str != null) {
            b.d.m.b.c remove = this.h.remove(str);
            if (remove != null) {
                b.d.m.b.b e2 = remove.e();
                if (e2 != null) {
                    e2.p();
                }
                remove.b();
                remove.j(null);
            }
            this.f15094d.p(str);
        }
    }

    public synchronized void x0(String str) {
        b.d.o.b.e remove = this.f15095e.remove(str);
        if (remove != null) {
            List<b.d.o.b.d> e2 = remove.e();
            if (e2 != null) {
                for (b.d.o.b.d dVar : e2) {
                    if (dVar != null) {
                        dVar.p();
                    }
                    if (!str.equals(this.j)) {
                        F(dVar, str);
                    }
                }
            }
            remove.c();
            remove.h();
            remove.j(null);
        }
        b.d.o.a.f.m().i(str);
    }

    public void y0(String str) {
        o remove = this.i.remove(Y(ClientType.LIVE, str));
        if (remove != null) {
            remove.E();
        }
    }

    public synchronized void z0() {
        b.d.p.d.a(this.f15092b, "整个APP的Live Stream被销毁");
        for (Map.Entry<String, b.d.o.b.e> entry : this.f15095e.entrySet()) {
            List<b.d.o.b.d> e2 = entry.getValue().e();
            if (e2 != null) {
                for (b.d.o.b.d dVar : e2) {
                    if (dVar != null) {
                        dVar.p();
                    }
                    F(dVar, entry.getKey());
                }
                e2.clear();
                b.d.o.a.f.m().i(entry.getKey());
            }
            entry.getValue().c();
            entry.getValue().h();
        }
        this.f15095e.clear();
    }
}
