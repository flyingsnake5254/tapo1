package com.hannesdorfmann.mosby3.mvi;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.k.b;
import io.reactivex.g0.g;
import io.reactivex.m0.h;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: MviBasePresenter.java */
/* loaded from: classes2.dex */
public abstract class c<V extends com.hannesdorfmann.mosby3.k.b, VS> implements d<V, VS> {

    /* renamed from: d  reason: collision with root package name */
    private io.reactivex.e0.b f5076d;

    /* renamed from: e  reason: collision with root package name */
    private io.reactivex.e0.c f5077e;

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.e0.c f5078f;
    private d<V, VS> h;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5074b = false;

    /* renamed from: c  reason: collision with root package name */
    private List<c<V, VS>.b<?>> f5075c = new ArrayList(4);
    private boolean g = true;
    private final io.reactivex.m0.b<VS> a = io.reactivex.m0.b.n1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MviBasePresenter.java */
    /* loaded from: classes2.dex */
    public class a implements g<VS> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.hannesdorfmann.mosby3.k.b f5079c;

        a(com.hannesdorfmann.mosby3.k.b bVar) {
            this.f5079c = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.g0.g
        public void accept(VS vs) throws Exception {
            c.this.h.a(this.f5079c, vs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MviBasePresenter.java */
    /* loaded from: classes2.dex */
    public class b<I> {
        private final io.reactivex.m0.g<I> a;

        /* renamed from: b  reason: collision with root package name */
        private final AbstractC0183c<V, I> f5081b;

        public b(io.reactivex.m0.g<I> gVar, AbstractC0183c<V, I> cVar) {
            this.a = gVar;
            this.f5081b = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MviBasePresenter.java */
    /* renamed from: com.hannesdorfmann.mosby3.mvi.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0183c<V extends com.hannesdorfmann.mosby3.k.b, I> {
        @NonNull
        q<I> a(@NonNull V v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MviBasePresenter.java */
    /* loaded from: classes2.dex */
    public interface d<V extends com.hannesdorfmann.mosby3.k.b, VS> {
        void a(@NonNull V v, @NonNull VS vs);
    }

    public c() {
        h();
    }

    @MainThread
    private <I> q<I> d(@NonNull V v, @NonNull c<V, VS>.b<?> bVar) {
        Objects.requireNonNull(v, "View is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
        Objects.requireNonNull(bVar, "IntentRelayBinderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
        io.reactivex.m0.g gVar = ((b) bVar).a;
        Objects.requireNonNull(gVar, "IntentRelay from binderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
        AbstractC0183c cVar = ((b) bVar).f5081b;
        if (cVar != null) {
            q<I> a2 = cVar.a(v);
            if (a2 != null) {
                if (this.f5076d == null) {
                    this.f5076d = new io.reactivex.e0.b();
                }
                this.f5076d.b((io.reactivex.e0.c) a2.M0(new a(gVar)));
                return gVar;
            }
            throw new NullPointerException("Intent Observable returned from Binder " + cVar + " is null");
        }
        throw new NullPointerException(AbstractC0183c.class.getSimpleName() + " is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    }

    private void h() {
        this.g = true;
        this.f5075c.clear();
        this.f5074b = false;
    }

    @MainThread
    private void j(@NonNull V v) {
        Objects.requireNonNull(v, "View is null");
        if (this.h != null) {
            this.f5077e = this.a.G0(new a(v));
            return;
        }
        throw new NullPointerException(d.class.getSimpleName() + " is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    }

    @Override // com.hannesdorfmann.mosby3.k.a
    @CallSuper
    public void a(@NonNull V v) {
        if (this.g) {
            e();
        }
        if (this.h != null) {
            j(v);
        }
        int size = this.f5075c.size();
        for (int i = 0; i < size; i++) {
            d(v, this.f5075c.get(i));
        }
        this.g = false;
    }

    @Override // com.hannesdorfmann.mosby3.k.a
    @CallSuper
    public void b() {
        f(true);
        io.reactivex.e0.c cVar = this.f5077e;
        if (cVar != null) {
            cVar.dispose();
            this.f5077e = null;
        }
        io.reactivex.e0.b bVar = this.f5076d;
        if (bVar != null) {
            bVar.dispose();
            this.f5076d = null;
        }
    }

    @Override // com.hannesdorfmann.mosby3.k.a
    @CallSuper
    public void destroy() {
        f(false);
        io.reactivex.e0.c cVar = this.f5078f;
        if (cVar != null) {
            cVar.dispose();
        }
        k();
        h();
    }

    @MainThread
    protected abstract void e();

    @CallSuper
    @Deprecated
    public void f(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public <I> q<I> g(AbstractC0183c<V, I> cVar) {
        h m1 = h.m1();
        this.f5075c.add(new b<>(m1, cVar));
        return m1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void i(@NonNull q<VS> qVar, @NonNull d<V, VS> dVar) {
        if (!this.f5074b) {
            this.f5074b = true;
            Objects.requireNonNull(qVar, "ViewState Observable is null");
            Objects.requireNonNull(dVar, "ViewStateBinder is null");
            this.h = dVar;
            this.f5078f = (io.reactivex.e0.c) qVar.M0(new b(this.a));
            return;
        }
        throw new IllegalStateException("subscribeViewState() method is only allowed to be called once");
    }

    protected void k() {
    }
}
