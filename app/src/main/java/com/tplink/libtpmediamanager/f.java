package com.tplink.libtpmediamanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.o.b.c;
import b.d.p.d;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtplivemedia.a.t;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpstreamconnectionsocket.EncryptException;
import com.tplink.libtpstreamconnectionsocket.UserEncryptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StreamDisplayManager.java */
/* loaded from: classes3.dex */
public class f implements c {
    private static volatile f a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12574b = "StreamDisplayManager";

    /* renamed from: e  reason: collision with root package name */
    private boolean f12577e = false;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f12575c = Executors.newCachedThreadPool(new a());

    /* renamed from: d  reason: collision with root package name */
    private b<t> f12576d = new b<>(null);

    /* compiled from: StreamDisplayManager.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f12578c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("StreamDisplay-" + this.f12578c.incrementAndGet());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StreamDisplayManager.java */
    /* loaded from: classes3.dex */
    public static class b<V> extends ConcurrentHashMap<String, V> {
        private b() {
        }

        @Nullable
        /* renamed from: a */
        public V put(String str, V v) {
            if (str == null) {
                return null;
            }
            return (V) super.put(str, v);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (V) super.get(obj);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private f() {
    }

    public static f j() {
        if (a == null) {
            synchronized (f.class) {
                a = new f();
            }
        }
        return a;
    }

    private void r(String str, Context context) {
        t tVar = this.f12576d.get(str);
        if (tVar == null) {
            tVar = new t(str);
            tVar.h0(context);
        } else {
            tVar.h0(context);
        }
        if (tVar.I()) {
            tVar.y();
        } else {
            tVar.e0(true);
            this.f12575c.submit(tVar);
            this.f12576d.put(str, tVar);
        }
        tVar.a0();
    }

    @Override // b.d.o.b.c
    public void a(String str, int i) {
        if (str != null) {
            t tVar = this.f12576d.get(str);
            d.a("StreamDisplayManager", "ConnectType: " + i);
            if (tVar != null) {
                if (tVar.D() < i) {
                    tVar.f0(i);
                }
                tVar.J().set(true);
            }
            ConnectionTypeManager.INSTANCE.set(str, i);
            RelayTimerManager relayTimerManager = RelayTimerManager.INSTANCE;
            relayTimerManager.refreshRelayTimer();
            relayTimerManager.subscribePlayStatus(str);
        }
    }

    @Override // b.d.o.b.c
    public void b(String str, Exception exc) {
        if (str != null) {
            if (exc != null) {
                "401".equals(exc.getMessage());
            }
            if (exc instanceof EncryptException) {
                b.d.d.i.a.b(str);
            }
            if (exc instanceof UserEncryptException) {
                b.d.d.i.a.a(str);
            }
            t tVar = this.f12576d.get(str);
            if (tVar != null) {
                d.a("StreamDisplayManager", "设备： " + str + " 视频播放发生严重异常！");
                tVar.p0(exc);
            }
        }
    }

    @Override // b.d.o.b.c
    public void c(String str, byte[] bArr) {
        t tVar = this.f12576d.get(str);
        if (tVar != null) {
            tVar.S(bArr);
        }
    }

    @Override // b.d.o.b.c
    public void d(String str, BitStreamType bitStreamType) {
        t tVar;
        if (str != null && (tVar = this.f12576d.get(str)) != null) {
            tVar.c0(bitStreamType);
        }
    }

    @Override // b.d.o.b.c
    public void e(String str, boolean z) {
        t tVar;
        if (str != null && (tVar = this.f12576d.get(str)) != null) {
            tVar.Q(z);
        }
    }

    @Override // b.d.o.b.c
    public void f(String str, BitStreamType bitStreamType, boolean z, int i) {
        t tVar;
        if (str != null && (tVar = this.f12576d.get(str)) != null) {
            if (z && tVar.I()) {
                tVar.y();
                tVar.B();
            }
            tVar.w(bitStreamType, z, i);
        }
    }

    public void g() {
        for (t tVar : this.f12576d.values()) {
            tVar.X();
        }
    }

    public void h(String str, BitStreamType bitStreamType, String str2) {
        t tVar = this.f12576d.get(str);
        if (tVar != null) {
            tVar.l0();
        }
        m.V().A(str, this, bitStreamType, str2);
    }

    public List<String> i() {
        d.a("StreamDisplayManager", "销毁全部播放客户端");
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.f12576d.values()) {
            arrayList.add(tVar.E());
            tVar.A();
            tVar.i0(null);
            tVar.z();
        }
        this.f12576d.clear();
        m.V().r0();
        RelayTimerManager.INSTANCE.switchRelayTimer(false);
        return arrayList;
    }

    public List<String> k() {
        return new ArrayList(this.f12576d.keySet());
    }

    @Nullable
    public t l(@Nullable String str) {
        if (str == null) {
            return null;
        }
        t tVar = this.f12576d.get(str);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(str);
        this.f12576d.put(str, tVar2);
        return tVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<String, t>> m() {
        return this.f12576d.entrySet();
    }

    public boolean n() {
        if (this.f12577e) {
            return false;
        }
        this.f12577e = true;
        d.a("StreamDisplayManager", "lockLiveStreamAudio,强制静音");
        return true;
    }

    public void o(String str, boolean z) {
        if (str != null) {
            if (!this.f12577e || z) {
                t tVar = this.f12576d.get(str);
                if (tVar != null) {
                    d.a("StreamDisplayManager", "设备:" + str + ",静音:" + z);
                    tVar.g0(z);
                    return;
                }
                return;
            }
            d.a("StreamDisplayManager", "Live stream audio is locked.解除静音失败");
        }
    }

    public void p(String str, boolean z) {
        t tVar = this.f12576d.get(str);
        if (tVar != null) {
            d.a("StreamDisplayManager", "设备:" + str + ",静音:" + z);
            tVar.P(z);
        }
    }

    public void q(String str, StreamNotificationCallback streamNotificationCallback) {
        if (str != null) {
            m.V().W(str).G(streamNotificationCallback);
        }
    }

    public void s(String str, Context context, BitStreamType bitStreamType) {
        if (str != null) {
            r(str, context);
            t tVar = this.f12576d.get(str);
            if (tVar == null) {
                tVar = new t(str);
                this.f12576d.put(str, tVar);
            }
            m.V().A0(str);
            tVar.B();
            b.d.j.a.b.a().f(str, 0);
            m.V().R(str, this, bitStreamType);
        }
    }

    public void t(String str) {
        if (str != null) {
            t remove = this.f12576d.remove(str);
            if (remove != null) {
                d.a("StreamDisplayManager", "设备： " + str + " 视频播放客户端被销毁！");
                remove.A();
                remove.i0(null);
                remove.z();
            }
            m.V().y0(str);
        }
    }

    public boolean u() {
        if (!this.f12577e) {
            return false;
        }
        this.f12577e = false;
        d.a("StreamDisplayManager", "unlockLiveStreamAudio,解除强制静音");
        return true;
    }
}
