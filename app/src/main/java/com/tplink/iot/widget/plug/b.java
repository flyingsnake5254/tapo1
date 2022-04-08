package com.tplink.iot.widget.plug;

import android.graphics.drawable.TransitionDrawable;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

/* compiled from: InfiniteTransitionDrawable.kt */
/* loaded from: classes3.dex */
public final class b {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private final TransitionDrawable f11825b;

    /* renamed from: c  reason: collision with root package name */
    private long f11826c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InfiniteTransitionDrawable.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements g<Long> {
        a() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            b.this.f11825b.reverseTransition((int) b.this.c());
        }
    }

    public b(TransitionDrawable transDrawable, long j) {
        j.e(transDrawable, "transDrawable");
        this.f11825b = transDrawable;
        this.f11826c = j;
        transDrawable.setCrossFadeEnabled(true);
    }

    public final void b() {
        this.f11825b.resetTransition();
        c cVar = this.a;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final long c() {
        return this.f11826c;
    }

    public final void d() {
        this.f11825b.startTransition((int) this.f11826c);
        this.a = q.c0(this.f11826c + 50, TimeUnit.MILLISECONDS).l0(io.reactivex.d0.b.a.a()).G0(new a());
    }
}
