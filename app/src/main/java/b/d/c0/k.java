package b.d.c0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tplink.tdp.bean.BaseTDPDevice;
import com.tplink.tdp.common.b;
import io.reactivex.g0.j;
import io.reactivex.m0.c;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

/* compiled from: TDPClient.java */
/* loaded from: classes3.dex */
public final class k {
    private DatagramChannel a;

    /* renamed from: b  reason: collision with root package name */
    private Selector f168b;

    /* renamed from: c  reason: collision with root package name */
    private InetSocketAddress f169c;

    /* renamed from: d  reason: collision with root package name */
    private b f170d;

    /* renamed from: e  reason: collision with root package name */
    private g<BaseTDPDevice> f171e;

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.e0.b f172f;
    private ConnectivityManager g;
    private boolean h;
    private Network i;
    private a j;
    private c k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPClient.java */
    @RequiresApi(api = 21)
    /* loaded from: classes3.dex */
    public static class a extends ConnectivityManager.NetworkCallback {
        private final k a;

        a(k kVar) {
            this.a = kVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            b.d.w.c.a.c("TDP", "TDPNetworkCallback." + network.toString());
            this.a.i = network;
            this.a.k.onComplete();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            super.onLosing(network, i);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
        }
    }

    public k(Context context, boolean z) {
        this(context, z, null);
    }

    private void A(long j) {
        this.f172f.b(q.W0(j, TimeUnit.MILLISECONDS).G0(new io.reactivex.g0.g() { // from class: b.d.c0.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                k.this.n((Long) obj);
            }
        }));
    }

    private <T extends BaseTDPDevice> void B(b.d.c0.l.b<T> bVar) {
        this.f172f.b(q.f0(bVar).L0(io.reactivex.l0.a.c()).y(new io.reactivex.g0.a() { // from class: b.d.c0.g
            @Override // io.reactivex.g0.a
            public final void run() {
                k.this.c();
            }
        }).H0(new io.reactivex.g0.g() { // from class: b.d.c0.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                k.this.g((b.d.c0.l.b) obj);
            }
        }, new a(this)));
    }

    private <T extends BaseTDPDevice> void C(final com.tplink.tdp.common.c<T> cVar, final boolean z) {
        io.reactivex.e0.b bVar = this.f172f;
        c cVar2 = this.k;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bVar.b(cVar2.D(300L, timeUnit).s().d(q.d0(0L, cVar.a(), 0L, cVar.c(), timeUnit).F(new io.reactivex.g0.g() { // from class: b.d.c0.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                k.this.p(cVar, z, (io.reactivex.e0.c) obj);
            }
        })).I0(new io.reactivex.g0.g() { // from class: b.d.c0.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                k.this.r((Long) obj);
            }
        }, new a(this), new io.reactivex.g0.a() { // from class: b.d.c0.b
            @Override // io.reactivex.g0.a
            public final void run() {
                k.this.t(cVar);
            }
        }));
    }

    private void E() {
        ConnectivityManager connectivityManager;
        a aVar;
        if (Build.VERSION.SDK_INT >= 22 && (connectivityManager = this.g) != null && (aVar = this.j) != null) {
            connectivityManager.unregisterNetworkCallback(aVar);
            this.j = null;
        }
    }

    private boolean F(b bVar, byte[] bArr, int i) {
        if (bVar.f() <= 0) {
            return false;
        }
        int d2 = bVar.d();
        System.arraycopy(b.d.w.e.a.c(1516993677), 0, bArr, 12, 4);
        int f2 = bVar.f() + 16;
        byte[] bArr2 = new byte[f2];
        if (bArr.length < f2) {
            return false;
        }
        System.arraycopy(bArr, i, bArr2, 0, f2);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr2);
        return d2 == ((int) crc32.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws IOException {
        b.d.w.c.a.c("TDP", "mDatagramChannel.close");
        Selector selector = this.f168b;
        if (selector != null && selector.isOpen()) {
            this.f168b.close();
        }
        if (this.a.isOpen()) {
            this.a.close();
        }
        if (!this.f171e.j1() && !this.f171e.k1()) {
            this.f171e.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b.d.w.c.a.c("TDP", "handleTDPComplete");
        E();
        if (!this.f171e.j1() && !this.f171e.k1()) {
            this.f171e.onComplete();
        }
        io.reactivex.e0.b bVar = this.f172f;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        b.d.w.c.a.c("TDP", "handleTDPException" + th.toString());
        E();
        if (!this.f171e.j1() && !this.f171e.k1()) {
            this.f171e.onError(th);
        }
        io.reactivex.e0.b bVar = this.f172f;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends BaseTDPDevice> void g(b.d.c0.l.b<T> bVar) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        this.a.register(this.f168b, 1);
        while (this.f168b.select() > 0) {
            Iterator<SelectionKey> it = this.f168b.selectedKeys().iterator();
            while (it.hasNext()) {
                if (it.next().isReadable()) {
                    b.d.w.c.a.c("TDP", "mDatagramChannel.receive");
                    this.a.receive(allocate);
                    z(allocate, bVar);
                }
                it.remove();
            }
        }
    }

    private void h() throws IOException {
        b.d.w.c.a.c("TDP", "mDatagramChannel.send");
        this.a.send(ByteBuffer.wrap(this.f170d.e()), this.f169c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(Long l) throws Exception {
        b.d.w.c.a.n("TDP", "scheduleTDPCompleteTask");
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(com.tplink.tdp.common.c cVar, boolean z, io.reactivex.e0.c cVar2) throws Exception {
        y(cVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(Long l) throws Exception {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(com.tplink.tdp.common.c cVar) throws Exception {
        A(cVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ t v(com.tplink.tdp.common.c cVar) throws Exception {
        C(cVar, true);
        return this.f171e.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends BaseTDPDevice> List<T> x(List<T> list, T t) {
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getMac() != null && next.getMac().equals(t.getMac())) {
                list.remove(next);
                break;
            }
        }
        list.add(t);
        return list;
    }

    private <T extends BaseTDPDevice> void y(com.tplink.tdp.common.c<T> cVar, boolean z) throws IOException {
        b.d.c0.l.b<T> bVar;
        Network network;
        b.d.w.c.a.c("TDP", "DatagramChannel.open");
        DatagramChannel open = DatagramChannel.open();
        this.a = open;
        open.socket().setReuseAddress(true);
        this.a.socket().setSoTimeout(8000);
        this.a.configureBlocking(false);
        if (Build.VERSION.SDK_INT >= 22 && this.h && (network = this.i) != null) {
            try {
                network.bindSocket(this.a.socket());
            } catch (IOException | SecurityException e2) {
                b.d.w.c.a.f("TDP", e2, "bindSocket", new Object[0]);
            }
        }
        this.f169c = new InetSocketAddress(cVar.g(), cVar.h());
        int i = 32;
        if (z) {
            i = 16;
            this.a.socket().setBroadcast(true);
        }
        byte i2 = cVar.i();
        if (i2 == 1) {
            bVar = new b.d.c0.l.c<>(cVar.f());
        } else {
            bVar = new b.d.c0.l.a<>(cVar.f());
        }
        this.f170d = new b(i2, cVar.d(), (byte) (i | 1), cVar.e());
        this.f168b = Selector.open();
        B(bVar);
    }

    private <T extends BaseTDPDevice> void z(ByteBuffer byteBuffer, b.d.c0.l.b<T> bVar) {
        byte[] array = byteBuffer.array();
        byteBuffer.flip();
        int i = 0;
        while (i < array.length) {
            if (byteBuffer.remaining() < 16) {
                byteBuffer.compact();
                return;
            }
            b bVar2 = new b(byteBuffer);
            if (!F(bVar2, array, i)) {
                byteBuffer.clear();
                return;
            }
            int i2 = i + 16;
            byte g = bVar2.g();
            if (bVar2.h() == this.f170d.h() && bVar2.i() == this.f170d.i() && (g == 0 || g == 1)) {
                byte[] bArr = new byte[bVar2.f()];
                byteBuffer.get(bArr);
                T a2 = bVar.a(bArr);
                if (a2 != null) {
                    b.d.w.c.a.k("parseTdpPkt", a2.toString());
                    if (!this.f171e.j1() && !this.f171e.k1()) {
                        this.f171e.onNext(a2);
                    }
                }
            }
            i = i2 + bVar2.f();
        }
        byteBuffer.compact();
    }

    public <T extends BaseTDPDevice> q<List<T>> D(@NonNull com.tplink.tdp.common.c<T> cVar) {
        return q.f0(cVar).N(new j() { // from class: b.d.c0.f
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return k.this.v((com.tplink.tdp.common.c) obj);
            }
        }).e(cVar.f()).z0(new ArrayList(), new io.reactivex.g0.c() { // from class: b.d.c0.i
            @Override // io.reactivex.g0.c
            public final Object apply(Object obj, Object obj2) {
                List x;
                x = k.this.x((List) obj, (BaseTDPDevice) obj2);
                return x;
            }
        }).y(new io.reactivex.g0.a() { // from class: b.d.c0.j
            @Override // io.reactivex.g0.a
            public final void run() {
                k.this.e();
            }
        });
    }

    public Network d() {
        return this.i;
    }

    public k(Context context, boolean z, Network network) {
        this.k = c.M();
        this.f171e = d.n1();
        this.f172f = new io.reactivex.e0.b();
        this.h = z;
        this.i = network;
        if (Build.VERSION.SDK_INT < 22) {
            this.k.onComplete();
        } else if (z && network != null) {
            this.k.onComplete();
        } else if (!z || context == null || context.checkPermission("android.permission.CHANGE_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            this.k.onComplete();
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.g = connectivityManager;
            if (connectivityManager != null) {
                NetworkRequest build = new NetworkRequest.Builder().addCapability(13).addTransportType(1).build();
                a aVar = new a(this);
                this.j = aVar;
                try {
                    this.g.requestNetwork(build, aVar);
                } catch (SecurityException unused) {
                    this.k.onComplete();
                }
            } else {
                this.k.onComplete();
            }
        }
    }
}
