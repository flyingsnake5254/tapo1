package b.d.u;

import b.d.v.b.c;
import com.tplink.libtpmux.tsmux.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DoubleTalkClient.java */
/* loaded from: classes3.dex */
public class m implements c {
    protected int g;
    protected int h;
    protected int i;
    protected String k;
    protected c l;
    protected ExecutorService n;
    protected n p;
    protected String q;
    protected e t;
    protected AtomicBoolean m = new AtomicBoolean(false);
    protected AtomicBoolean o = new AtomicBoolean(false);
    protected long u = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f755d = 1;
    protected int a = 8000;

    /* renamed from: b  reason: collision with root package name */
    protected int f753b = 16;

    /* renamed from: c  reason: collision with root package name */
    protected int f754c = 2;
    protected int j = 10;

    /* renamed from: e  reason: collision with root package name */
    protected int f756e = 1;

    /* renamed from: f  reason: collision with root package name */
    protected int f757f = 16;
    protected AtomicBoolean r = new AtomicBoolean(false);
    protected AtomicBoolean s = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str, String str2) {
        this.k = str;
        this.q = str2;
        e eVar = new e();
        this.t = eVar;
        eVar.p(true);
    }

    public void a() {
    }

    public void b(long j, byte[] bArr) {
    }

    public void c() {
    }

    public void d() {
        this.r.set(false);
        com.tplink.libtpstreamclientmanager.m.V().J0(this.k);
    }

    public void e(boolean z) {
        this.s.set(z);
        if (z) {
            com.tplink.libtpstreamclientmanager.m.V().J0(this.k);
        } else {
            com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
        }
    }

    public void f(c cVar) {
        this.l = cVar;
    }

    public void g(int i) {
    }

    public void h(n nVar) {
        this.p = nVar;
    }

    public void i(int i) {
    }

    public void j() {
        this.r.set(true);
        com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkClose(String str) {
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkCreateFailure(String str, int i) {
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkCreateSuccess(String str) {
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkSendDataFailure(String str, int i, Exception exc) {
    }
}
