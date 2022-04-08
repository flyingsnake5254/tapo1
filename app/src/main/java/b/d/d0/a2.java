package b.d.d0;

import b.d.d0.a2;
import b.d.d0.i2.a;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPAppV2PacketType;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.CRC32;

/* compiled from: TMPAppV2BusinessLayer.java */
/* loaded from: classes3.dex */
public class a2 extends x1 {
    private int i = 3;
    private e j = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TMPAppV2BusinessLayer.java */
    /* loaded from: classes3.dex */
    public static class b {
        private short a;

        /* renamed from: b  reason: collision with root package name */
        private short f219b;

        /* renamed from: c  reason: collision with root package name */
        private LinkedBlockingQueue<b.d.d0.g2.d> f220c;

        /* renamed from: d  reason: collision with root package name */
        private LinkedBlockingQueue<b.d.d0.g2.d> f221d;

        /* renamed from: e  reason: collision with root package name */
        private final List<f<b.d.d0.g2.d, b.d.d0.g2.d>> f222e;

        /* renamed from: f  reason: collision with root package name */
        private List<b.d.d0.g2.d> f223f;
        private boolean g;
        private c h;
        private boolean i;

        /* JADX INFO: Access modifiers changed from: private */
        public b.d.d0.g2.d f() {
            b.d.d0.g2.d poll;
            if (!this.f220c.isEmpty()) {
                poll = this.f220c.poll();
                if (poll != null) {
                    this.f223f.add(poll);
                    this.f222e.add(new f<>(poll, null));
                }
            } else {
                LinkedBlockingQueue<b.d.d0.g2.d> linkedBlockingQueue = this.f221d;
                if (linkedBlockingQueue == null || linkedBlockingQueue.isEmpty()) {
                    return null;
                }
                poll = this.f221d.poll();
                if (poll != null) {
                    this.f222e.add(new f<>(poll, null));
                }
            }
            return poll;
        }

        private c g(byte[] bArr, int i) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (i != ((int) crc32.getValue())) {
                return new c(this.a, -1100);
            }
            return new c(this.a, bArr);
        }

        private boolean h(b.d.d0.g2.d dVar) {
            b.d.d0.g2.b bVar = (b.d.d0.g2.b) dVar.a();
            int h = bVar.h() / 8156;
            int i = 0;
            if (h == 0) {
                byte[] b2 = dVar.b();
                if (b2 != null) {
                    i = b2.length;
                }
                if (i != bVar.h()) {
                    this.h = new c(this.a, -1215);
                    this.g = true;
                    return true;
                }
                this.h = g(b2, bVar.d());
                this.g = true;
                return true;
            }
            int i2 = 0;
            while (i2 < h) {
                i2++;
                this.f221d.offer(new b.d.d0.g2.d(new b.d.d0.g2.b((byte) 1, (byte) 2, this.f219b, (byte) 4, (byte) 0, this.a, 0, 0, i2 * 8156), null));
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(b.d.d0.i2.b bVar, b.d.d0.g2.d dVar, b.d.d0.g2.d dVar2) {
            boolean z;
            synchronized (this) {
                if (bVar.a() != 0) {
                    this.h = new c(this.a, bVar.a(), bVar.b());
                    this.g = true;
                    return;
                }
                b.d.d0.g2.b bVar2 = (b.d.d0.g2.b) dVar2.a();
                if (EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK == bVar2.g() && this.f223f.size() == 1 && (bVar2.h() == 0 || (dVar2.b() != null && dVar2.b().length == bVar2.h()))) {
                    this.h = g(dVar2.b(), bVar2.d());
                    this.g = true;
                    return;
                }
                Iterator<f<b.d.d0.g2.d, b.d.d0.g2.d>> it = this.f222e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f<b.d.d0.g2.d, b.d.d0.g2.d> next = it.next();
                    if (dVar == ((f) next).a) {
                        ((f) next).f229b = dVar2;
                        break;
                    }
                }
                boolean z2 = false;
                if (EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK == bVar2.g()) {
                    if (this.f221d == null) {
                        this.f221d = new LinkedBlockingQueue<>();
                        h(dVar2);
                    } else if (!this.i || !h(dVar2)) {
                        if (!j()) {
                            Iterator<f<b.d.d0.g2.d, b.d.d0.g2.d>> it2 = this.f222e.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = true;
                                    break;
                                }
                                f<b.d.d0.g2.d, b.d.d0.g2.d> next2 = it2.next();
                                if (EnumTMPAppV2PacketType.TYPE_DATA_PULL == ((b.d.d0.g2.b) ((b.d.d0.g2.d) ((f) next2).a).a()).g() && ((f) next2).f229b == null) {
                                    z = false;
                                    break;
                                }
                            }
                            if (z) {
                                int h = bVar2.h();
                                byte[] bArr = new byte[h];
                                int i = 0;
                                for (f<b.d.d0.g2.d, b.d.d0.g2.d> fVar : this.f222e) {
                                    b.d.d0.g2.d dVar3 = (b.d.d0.g2.d) ((f) fVar).a;
                                    b.d.d0.g2.d dVar4 = (b.d.d0.g2.d) ((f) fVar).f229b;
                                    if (!(dVar4 == null || dVar3 == null)) {
                                        b.d.d0.g2.b bVar3 = (b.d.d0.g2.b) dVar4.a();
                                        if (EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK != bVar3.g()) {
                                            continue;
                                        } else {
                                            byte[] b2 = dVar4.b();
                                            int length = (b2 == null ? 0 : b2.length) + i;
                                            b.d.d0.g2.b bVar4 = (b.d.d0.g2.b) dVar3.a();
                                            if (length <= h && (EnumTMPAppV2PacketType.TYPE_DATA_PULL != bVar4.g() || bVar4.i() == bVar3.i())) {
                                                if (b2 != null) {
                                                    System.arraycopy(b2, 0, bArr, i, b2.length);
                                                }
                                                i = length;
                                            }
                                            this.h = new c(this.a, -1215);
                                            this.g = true;
                                            return;
                                        }
                                    }
                                }
                                this.h = new c(this.a, bArr);
                                this.g = true;
                            }
                        }
                    }
                } else if (!j()) {
                    Iterator<f<b.d.d0.g2.d, b.d.d0.g2.d>> it3 = this.f222e.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = true;
                            break;
                        }
                        f<b.d.d0.g2.d, b.d.d0.g2.d> next3 = it3.next();
                        if (EnumTMPAppV2PacketType.TYPE_DATA_PUSH == ((b.d.d0.g2.b) ((b.d.d0.g2.d) ((f) next3).a).a()).g() && ((f) next3).f229b == null) {
                            break;
                        }
                    }
                    if (z2 && this.f221d == null) {
                        b.d.d0.g2.d dVar5 = new b.d.d0.g2.d(new b.d.d0.g2.b((byte) 1, (byte) 2, this.f219b, (byte) 4, (byte) 0, this.a, 0, 0, 0), null);
                        LinkedBlockingQueue<b.d.d0.g2.d> linkedBlockingQueue = new LinkedBlockingQueue<>();
                        this.f221d = linkedBlockingQueue;
                        linkedBlockingQueue.offer(dVar5);
                        this.i = true;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j() {
            LinkedBlockingQueue<b.d.d0.g2.d> linkedBlockingQueue;
            return !this.f220c.isEmpty() || ((linkedBlockingQueue = this.f221d) != null && !linkedBlockingQueue.isEmpty());
        }

        public c e() {
            return this.h;
        }

        private b(short s, short s2, byte[] bArr) {
            this.f221d = null;
            this.f222e = new ArrayList();
            this.f223f = new ArrayList();
            int i = 0;
            this.g = false;
            this.h = null;
            this.i = false;
            this.f219b = s;
            this.a = s2;
            this.f220c = new LinkedBlockingQueue<>();
            if (bArr == null || bArr.length <= 0) {
                this.f220c.offer(new b.d.d0.g2.d(new b.d.d0.g2.b((byte) 1, (byte) 2, this.f219b, (byte) 2, (byte) 0, this.a, 0, 0, 0), null));
                return;
            }
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            int value = (int) crc32.getValue();
            int i2 = 8156;
            int length = (bArr.length / 8156) + 1;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 * 8156;
                byte[] bArr2 = i3 == length + (-1) ? new byte[bArr.length - i4] : new byte[i2];
                System.arraycopy(bArr, i4, bArr2, i, bArr2.length);
                this.f220c.offer(new b.d.d0.g2.d(new b.d.d0.g2.b((byte) 1, (byte) 2, this.f219b, (byte) 2, (byte) 0, this.a, value, bArr.length, i4), bArr2));
                i3++;
                i = 0;
                i2 = 8156;
            }
        }
    }

    /* compiled from: TMPAppV2BusinessLayer.java */
    /* loaded from: classes3.dex */
    private static class d implements e {

        /* renamed from: c  reason: collision with root package name */
        a2 f227c;
        private g<c> a = io.reactivex.m0.b.n1().l1();

        /* renamed from: b  reason: collision with root package name */
        private ExecutorService f226b = Executors.newSingleThreadExecutor();

        /* renamed from: d  reason: collision with root package name */
        private int f228d = 0;

        d(a2 a2Var) {
            this.f227c = a2Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ c c(final b bVar) throws Exception {
            while (!bVar.g) {
                if (bVar.j()) {
                    synchronized (this) {
                        if (this.f228d < 20) {
                            final b.d.d0.g2.d f2 = bVar.f();
                            if (f2 != null) {
                                this.f228d++;
                                this.f227c.q(f2).G0(new io.reactivex.g0.g() { // from class: b.d.d0.u
                                    @Override // io.reactivex.g0.g
                                    public final void accept(Object obj) {
                                        a2.d.this.e(bVar, f2, (a) obj);
                                    }
                                });
                            }
                        } else {
                            notifyAll();
                            wait();
                        }
                    }
                } else {
                    synchronized (bVar) {
                        bVar.wait();
                    }
                }
            }
            return bVar.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(b bVar, b.d.d0.g2.d dVar, b.d.d0.i2.a aVar) throws Exception {
            synchronized (this) {
                this.f228d--;
                notifyAll();
            }
            bVar.i(aVar, dVar, (b.d.d0.g2.d) aVar.e());
            synchronized (bVar) {
                bVar.notifyAll();
            }
        }

        @Override // b.d.d0.a2.e
        public q<c> a(b bVar) {
            return q.f0(bVar).g0(new j() { // from class: b.d.d0.v
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return a2.d.this.c((a2.b) obj);
                }
            });
        }

        @Override // b.d.d0.a2.e
        public void clear() {
            this.a.onError(new TPGeneralNetworkException(-1));
            this.f226b.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TMPAppV2BusinessLayer.java */
    /* loaded from: classes3.dex */
    public interface e {
        q<c> a(b bVar);

        void clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TMPAppV2BusinessLayer.java */
    /* loaded from: classes3.dex */
    public static class f<F, S> {
        private F a;

        /* renamed from: b  reason: collision with root package name */
        private S f229b;

        f(F f2, S s) {
            this.a = f2;
            this.f229b = s;
        }
    }

    public a2(e2 e2Var) {
        super((byte) 1, (byte) 2, e2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ t C(b bVar, Boolean bool) throws Exception {
        return this.j.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.f2.e D(c cVar) throws Exception {
        return new b.d.d0.f2.e(cVar.a(), cVar.b(), cVar.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.a E(b.d.d0.i2.a aVar) throws Exception {
        if (aVar.a() != 0) {
            return new b.d.d0.i2.a(aVar.a());
        }
        b.d.d0.g2.d dVar = (b.d.d0.g2.d) aVar.e();
        b.d.d0.i2.a aVar2 = new b.d.d0.i2.a(aVar.a(), aVar.b());
        if (dVar.b() == null || dVar.b().length < 18) {
            aVar2.c(-1217);
            aVar2.d(b.d.d0.f2.c.g.get(-1217));
            return aVar2;
        }
        b.d.d0.g2.b bVar = new b.d.d0.g2.b(dVar.a(), dVar.b());
        b.d.d0.i2.b a2 = b.d.d0.f2.b.a(bVar.e());
        if (a2.a() != 0) {
            return new b.d.d0.i2.a(a2.a());
        }
        b.d.d0.g2.d dVar2 = new b.d.d0.g2.d(bVar, null);
        if (dVar.b().length > 18) {
            int length = dVar.b().length - 18;
            byte[] bArr = new byte[length];
            System.arraycopy(dVar.b(), 18, bArr, 0, length);
            dVar2.e(bArr);
        }
        aVar2.f(dVar2);
        return aVar2;
    }

    private short r() {
        synchronized (this) {
            int i = this.i;
            if (65535 == i) {
                this.i = 0;
                return (short) -1;
            }
            this.i = i + 1;
            return (short) i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(io.reactivex.e0.c cVar) throws Exception {
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.b u(c cVar) throws Exception {
        return new b.d.d0.i2.b(cVar.a(), cVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            k();
        } else {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(Throwable th) throws Exception {
        if (th instanceof TPGeneralNetworkException) {
            TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
            m(new b.d.d0.i2.b(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg()));
            return;
        }
        m(new b.d.d0.i2.b(-1, th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ t A(Boolean bool) throws Exception {
        return this.f369f.Q0(1L);
    }

    @Override // b.d.d0.x1
    public void a() {
        super.a();
        e eVar = this.j;
        if (eVar != null) {
            eVar.clear();
            this.j = null;
        }
    }

    @Override // b.d.d0.x1
    public q<b.d.d0.i2.b> b() {
        if (this.f367d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return this.j.a(new b((short) 1, r(), null)).F(new io.reactivex.g0.g() { // from class: b.d.d0.d0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    a2.this.t((c) obj);
                }
            }).g0(c0.f235c).E(new io.reactivex.g0.g() { // from class: b.d.d0.a0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    a2.this.w((b) obj);
                }
            }).C(new io.reactivex.g0.g() { // from class: b.d.d0.x
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    a2.this.y((Throwable) obj);
                }
            });
        }
        throw new RuntimeException("BusinessLayer can't be recycled!");
    }

    @Override // b.d.d0.x1
    public q<b.d.d0.f2.e> n(b.d.d0.f2.d dVar) {
        if (this.f367d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new b.d.d0.f2.e(this.g.a(), this.g.b()));
        }
        if (this.j == null) {
            return q.f0(new b.d.d0.f2.e(-1216));
        }
        final b bVar = new b(dVar.a(), r(), dVar.b());
        return this.f368e.Q0(1L).N(new j() { // from class: b.d.d0.w
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return a2.this.A((Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.b0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return a2.this.C(bVar, (Boolean) obj);
            }
        }).g0(z.f377c).L0(io.reactivex.l0.a.c());
    }

    @Override // b.d.d0.x1
    public q<b.d.d0.i2.a<b.d.d0.g2.d>> q(b.d.d0.g2.d dVar) {
        return super.q(dVar).g0(y.f370c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TMPAppV2BusinessLayer.java */
    /* loaded from: classes3.dex */
    public static class c extends b.d.d0.i2.b {

        /* renamed from: c  reason: collision with root package name */
        private byte[] f224c;

        /* renamed from: d  reason: collision with root package name */
        private short f225d;

        public byte[] e() {
            return this.f224c;
        }

        private c(short s, int i, String str) {
            super(i, str);
            this.f225d = s;
        }

        private c(short s, byte[] bArr) {
            this.f225d = s;
            this.f224c = bArr;
        }

        private c(short s, int i) {
            super(i);
            this.f225d = s;
        }
    }
}
