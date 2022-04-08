package com.tplink.libtpmediamanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.a0.b.d;
import b.d.b0.a.t;
import b.d.j.a.b;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpstreamconnectionsocket.EncryptException;
import com.tplink.libtpstreamconnectionsocket.UserEncryptException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: PlaybackDisplayManager.java */
/* loaded from: classes3.dex */
public class e implements d {
    private static volatile e a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<t> f12570b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f12571c = Executors.newCachedThreadPool(new a());

    /* compiled from: PlaybackDisplayManager.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f12572c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VodDisplay-" + this.f12572c.incrementAndGet());
            return thread;
        }
    }

    private e() {
    }

    public static e k() {
        if (a == null) {
            synchronized (e.class) {
                a = new e();
            }
        }
        return a;
    }

    private void q(String str, Context context) {
        t tVar = this.f12570b.get();
        if (tVar == null) {
            tVar = new t(str);
            tVar.a0(context);
        } else {
            tVar.a0(context);
        }
        if (tVar.D()) {
            tVar.w();
        } else {
            tVar.W(true);
            this.f12571c.submit(tVar);
            this.f12570b.set(tVar);
        }
        tVar.T();
    }

    @Override // b.d.a0.b.d
    public void a(String str, int i) {
        if (str != null) {
            t tVar = this.f12570b.get();
            b.d.p.d.a("PlaybackDisplayManager", "ConnectType: " + i);
            if (tVar != null) {
                if (tVar.B() < i) {
                    tVar.X(i);
                }
                tVar.F().set(true);
            }
            ConnectionTypeManager.INSTANCE.set(str, i);
            RelayTimerManager relayTimerManager = RelayTimerManager.INSTANCE;
            relayTimerManager.refreshRelayTimer();
            relayTimerManager.subscribePlayStatus(str);
        }
    }

    @Override // b.d.a0.b.d
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
            t tVar = this.f12570b.get();
            if (tVar != null) {
                b.d.p.d.a("PlaybackDisplayManager", "设备： " + str + " 视频播放发生严重异常！");
                tVar.g0(exc);
            }
        }
    }

    @Override // b.d.a0.b.d
    public void c(String str, byte[] bArr) {
        t tVar = this.f12570b.get();
        if (tVar != null) {
            tVar.M(bArr);
        }
    }

    @Override // b.d.a0.b.d
    public void d(String str, boolean z) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null) {
            tVar.w();
            tVar.z();
            tVar.T();
            tVar.k0(z);
        }
    }

    @Override // b.d.a0.b.d
    public void e(String str, boolean z, float f2) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null) {
            tVar.w();
            tVar.z();
            tVar.T();
            tVar.i0(z, f2);
        }
    }

    @Override // b.d.a0.b.d
    public void f(String str, long j) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null) {
            tVar.w();
            tVar.z();
            tVar.T();
            tVar.j0(j);
        }
    }

    @Override // b.d.a0.b.d
    public void g(String str) {
        t tVar = this.f12570b.get();
        if (tVar != null) {
            tVar.N();
        }
    }

    public void h(String str, String str2) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null) {
            String[] split = str2.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            float f2 = 1.0f;
            if (split.length == 2) {
                try {
                    f2 = Float.parseFloat(split[0]) / Float.parseFloat(split[1]);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            tVar.Z(f2);
        }
    }

    public void i(String str, String str2, long j) {
        if (str != null) {
            t tVar = this.f12570b.get();
            if (tVar != null) {
                tVar.w();
                tVar.d0();
            }
            b.a().f(str, 1);
            m.V().G0(str, str2, j, 0L, this);
        }
    }

    public void j(String str) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null && tVar.D()) {
            tVar.w();
        }
    }

    public t l(String str) {
        t tVar = this.f12570b.get();
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(str);
        this.f12570b.set(tVar2);
        return tVar2;
    }

    @Nullable
    public t m() {
        return this.f12570b.get();
    }

    public void n(String str) {
        t tVar;
        if (str != null && (tVar = this.f12570b.get()) != null) {
            tVar.S();
        }
    }

    public void o(String str, int i, long j, String str2) {
        t tVar = this.f12570b.get();
        if (tVar != null) {
            tVar.w();
            tVar.d0();
            b.a().f(str, 1);
            m.V().E0(str, i, str2, j, 0L, this);
        }
    }

    public void p(String str, StreamNotificationCallback streamNotificationCallback) {
        if (str != null) {
            m.V().a0(str).G(streamNotificationCallback);
        }
    }

    public void r(String str, Context context, long j, int i, int[] iArr, String str2) {
        if (str != null) {
            q(str, context);
            n(str);
            t tVar = this.f12570b.get();
            if (tVar == null) {
                tVar = new t(str);
                this.f12570b.set(tVar);
            }
            tVar.T();
            h(str, str2);
            m.V().A0(str);
            tVar.z();
            b.a().f(str, 1);
            m.V().T(str, i, str2, iArr, j, 0L, this);
        }
    }

    public void s(String str) {
        if (str != null) {
            t andSet = this.f12570b.getAndSet(null);
            if (andSet != null) {
                b.d.p.d.a("PlaybackDisplayManager", "设备： " + str + " 视频播放客户端被销毁！");
                andSet.y();
                andSet.b0(null);
                andSet.x();
            }
            m.V().C0(str);
        }
    }
}
