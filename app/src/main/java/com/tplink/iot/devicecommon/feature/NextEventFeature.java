package com.tplink.iot.devicecommon.feature;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

/* compiled from: NextEventFeature.kt */
/* loaded from: classes2.dex */
public final class NextEventFeature implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    public static final a f7386c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private io.reactivex.e0.c f7387d;

    /* renamed from: f  reason: collision with root package name */
    private b f7388f;
    private final LifecycleOwner q;
    private final ThingNextEventView x;

    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final NextEventFeature a(LifecycleOwner owner, ThingNextEventView thingNextEventView) {
            j.e(owner, "owner");
            return new NextEventFeature(owner, thingNextEventView, null);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        LiveData<NextEvent> b();

        void c();

        String d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<Long> {
        c() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            b bVar = NextEventFeature.this.f7388f;
            if (bVar != null) {
                bVar.c();
            }
            b bVar2 = NextEventFeature.this.f7388f;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    static final class d implements ThingNextEventView.d {
        d() {
        }

        @Override // com.tplink.iot.widget.businessview.ThingNextEventView.d
        public final void a() {
            NextEventFeature.this.e();
        }
    }

    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<NextEvent> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(NextEvent nextEvent) {
            ThingNextEventView thingNextEventView = NextEventFeature.this.x;
            if (thingNextEventView != null) {
                b bVar = NextEventFeature.this.f7388f;
                thingNextEventView.r(nextEvent, bVar != null ? bVar.d() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NextEventFeature.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements g<Long> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            b bVar = NextEventFeature.this.f7388f;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    private NextEventFeature(LifecycleOwner lifecycleOwner, ThingNextEventView thingNextEventView) {
        this.q = lifecycleOwner;
        this.x = thingNextEventView;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    private final void d(String str) {
        b.d.w.c.a.n("NextEventFeature", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        d("nextEventEndTaskRefreshStrategy");
        q.e0(1L, 3L, 0L, 2L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).E(new c()).F0();
    }

    private final void g() {
        h();
        this.f7387d = q.e0(1L, 2L, 0L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f());
        d("startNextEventRefreshTimer");
    }

    private final void h() {
        d("stopNextEventRefreshTimer");
        io.reactivex.e0.c cVar = this.f7387d;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final void f(b helper) {
        j.e(helper, "helper");
        this.f7388f = helper;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        LiveData<NextEvent> b2;
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate: ");
        Lifecycle lifecycle = this.q.getLifecycle();
        j.d(lifecycle, "owner.lifecycle");
        sb.append(lifecycle.getCurrentState());
        d(sb.toString());
        ThingNextEventView thingNextEventView = this.x;
        if (thingNextEventView != null) {
            thingNextEventView.setOnNextEventCallback(new d());
        }
        b bVar = this.f7388f;
        if (bVar != null && (b2 = bVar.b()) != null) {
            b2.observe(this.q, new e());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        d("onDestroy");
        ThingNextEventView thingNextEventView = this.x;
        if (thingNextEventView != null) {
            thingNextEventView.e();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        d("onPause");
        h();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        d("onResume");
        g();
    }

    public /* synthetic */ NextEventFeature(LifecycleOwner lifecycleOwner, ThingNextEventView thingNextEventView, kotlin.jvm.internal.f fVar) {
        this(lifecycleOwner, thingNextEventView);
    }
}
