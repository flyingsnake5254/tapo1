package b.a.a.a.a.a.e.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import io.reactivex.e0.d;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.w;

/* compiled from: PreLollipopNetworkObservingStrategy.java */
/* loaded from: classes.dex */
public class c implements b.a.a.a.a.a.e.a.a {

    /* compiled from: PreLollipopNetworkObservingStrategy.java */
    /* loaded from: classes.dex */
    class a implements s<b.a.a.a.a.a.a> {
        final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IntentFilter f22b;

        /* compiled from: PreLollipopNetworkObservingStrategy.java */
        /* renamed from: b.a.a.a.a.a.e.a.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0010a extends BroadcastReceiver {
            final /* synthetic */ r a;

            C0010a(r rVar) {
                this.a = rVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                this.a.onNext(b.a.a.a.a.a.a.d(context));
            }
        }

        /* compiled from: PreLollipopNetworkObservingStrategy.java */
        /* loaded from: classes.dex */
        class b implements io.reactivex.g0.a {
            final /* synthetic */ BroadcastReceiver a;

            b(BroadcastReceiver broadcastReceiver) {
                this.a = broadcastReceiver;
            }

            @Override // io.reactivex.g0.a
            public void run() {
                a aVar = a.this;
                c.this.e(aVar.a, this.a);
            }
        }

        a(Context context, IntentFilter intentFilter) {
            this.a = context;
            this.f22b = intentFilter;
        }

        @Override // io.reactivex.s
        public void subscribe(r<b.a.a.a.a.a.a> rVar) throws Exception {
            C0010a aVar = new C0010a(rVar);
            this.a.registerReceiver(aVar, this.f22b);
            rVar.a(c.this.c(new b(aVar)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreLollipopNetworkObservingStrategy.java */
    /* loaded from: classes.dex */
    public class b implements io.reactivex.g0.a {
        final /* synthetic */ io.reactivex.g0.a a;

        /* compiled from: PreLollipopNetworkObservingStrategy.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ w.c f27c;

            a(w.c cVar) {
                this.f27c = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a.run();
                } catch (Exception e2) {
                    c.this.d("Could not unregister receiver in UI Thread", e2);
                }
                this.f27c.dispose();
            }
        }

        b(io.reactivex.g0.a aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.a.run();
                return;
            }
            w.c b2 = io.reactivex.d0.b.a.a().b();
            b2.b(new a(b2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.e0.c c(io.reactivex.g0.a aVar) {
        return d.c(new b(aVar));
    }

    @Override // b.a.a.a.a.a.e.a.a
    public q<b.a.a.a.a.a.a> a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        return q.m(new a(context, intentFilter)).n(b.a.a.a.a.a.a.c());
    }

    public void d(String str, Exception exc) {
        Log.e("ReactiveNetwork", str, exc);
    }

    protected void e(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e2) {
            d("receiver was already unregistered", e2);
        }
    }
}
