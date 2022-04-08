package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.p;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nonnull;

/* compiled from: ListenerSet.java */
/* loaded from: classes.dex */
public final class t<T> {
    private final h a;

    /* renamed from: b  reason: collision with root package name */
    private final r f3943b;

    /* renamed from: c  reason: collision with root package name */
    private final b<T> f3944c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<c<T>> f3945d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<Runnable> f3946e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Runnable> f3947f;
    private boolean g;

    /* compiled from: ListenerSet.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void invoke(T t);
    }

    /* compiled from: ListenerSet.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(T t, p pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListenerSet.java */
    /* loaded from: classes.dex */
    public static final class c<T> {
        @Nonnull
        public final T a;

        /* renamed from: b  reason: collision with root package name */
        private p.b f3948b = new p.b();

        /* renamed from: c  reason: collision with root package name */
        private boolean f3949c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3950d;

        public c(@Nonnull T t) {
            this.a = t;
        }

        public void a(int i, a<T> aVar) {
            if (!this.f3950d) {
                if (i != -1) {
                    this.f3948b.a(i);
                }
                this.f3949c = true;
                aVar.invoke(this.a);
            }
        }

        public void b(b<T> bVar) {
            if (!this.f3950d && this.f3949c) {
                p e2 = this.f3948b.e();
                this.f3948b = new p.b();
                this.f3949c = false;
                bVar.a(this.a, e2);
            }
        }

        public void c(b<T> bVar) {
            this.f3950d = true;
            if (this.f3949c) {
                bVar.a(this.a, this.f3948b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public t(Looper looper, h hVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, hVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(Message message) {
        Iterator<c<T>> it = this.f3945d.iterator();
        while (it.hasNext()) {
            it.next().b(this.f3944c);
            if (this.f3943b.c(0)) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i, aVar);
        }
    }

    public void a(T t) {
        if (!this.g) {
            g.e(t);
            this.f3945d.add(new c<>(t));
        }
    }

    @CheckResult
    public t<T> b(Looper looper, b<T> bVar) {
        return new t<>(this.f3945d, looper, this.a, bVar);
    }

    public void c() {
        if (!this.f3947f.isEmpty()) {
            if (!this.f3943b.c(0)) {
                r rVar = this.f3943b;
                rVar.b(rVar.a(0));
            }
            boolean z = !this.f3946e.isEmpty();
            this.f3946e.addAll(this.f3947f);
            this.f3947f.clear();
            if (!z) {
                while (!this.f3946e.isEmpty()) {
                    this.f3946e.peekFirst().run();
                    this.f3946e.removeFirst();
                }
            }
        }
    }

    public void g(final int i, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f3945d);
        this.f3947f.add(new Runnable() { // from class: com.google.android.exoplayer2.util.a
            @Override // java.lang.Runnable
            public final void run() {
                t.f(copyOnWriteArraySet, i, aVar);
            }
        });
    }

    public void h() {
        Iterator<c<T>> it = this.f3945d.iterator();
        while (it.hasNext()) {
            it.next().c(this.f3944c);
        }
        this.f3945d.clear();
        this.g = true;
    }

    public void i(T t) {
        Iterator<c<T>> it = this.f3945d.iterator();
        while (it.hasNext()) {
            c<T> next = it.next();
            if (next.a.equals(t)) {
                next.c(this.f3944c);
                this.f3945d.remove(next);
            }
        }
    }

    public void j(int i, a<T> aVar) {
        g(i, aVar);
        c();
    }

    private t(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, h hVar, b<T> bVar) {
        this.a = hVar;
        this.f3945d = copyOnWriteArraySet;
        this.f3944c = bVar;
        this.f3946e = new ArrayDeque<>();
        this.f3947f = new ArrayDeque<>();
        this.f3943b = hVar.b(looper, new Handler.Callback() { // from class: com.google.android.exoplayer2.util.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean d2;
                d2 = t.this.d(message);
                return d2;
            }
        });
    }
}
