package com.tplink.iot.view.ipcamera.onboardingv2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.iot.view.ipcamera.onboardingv2.RxAutoRefreshTimer;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RxAutoRefreshTimer implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    private io.reactivex.e0.b f8812c;

    /* renamed from: d  reason: collision with root package name */
    private List<b> f8813d = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void h();
    }

    /* loaded from: classes2.dex */
    public class b {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private long f8814b;

        /* renamed from: c  reason: collision with root package name */
        private a f8815c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Long l) throws Exception {
        b.d.w.c.a.c("wcwj", "schedule" + bVar.toString());
        bVar.f8815c.h();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void cancel() {
        io.reactivex.e0.b bVar = this.f8812c;
        if (bVar != null) {
            bVar.dispose();
            this.f8812c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void schedule() {
        this.f8812c = new io.reactivex.e0.b();
        for (final b bVar : this.f8813d) {
            this.f8812c.b(q.a0(bVar.a, bVar.f8814b, TimeUnit.MILLISECONDS).G0(new g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.y1
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RxAutoRefreshTimer.a(RxAutoRefreshTimer.b.this, (Long) obj);
                }
            }));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void tearDown() {
        cancel();
        List<b> list = this.f8813d;
        if (list != null) {
            list.clear();
            this.f8813d = null;
        }
        this.f8812c = null;
    }
}
