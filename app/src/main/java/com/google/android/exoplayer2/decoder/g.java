package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.f;
import java.util.ArrayDeque;

/* compiled from: SimpleDecoder.java */
/* loaded from: classes.dex */
public abstract class g<I extends DecoderInputBuffer, O extends f, E extends DecoderException> implements c<I, O, E> {
    private final Thread a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f2172b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f2173c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f2174d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f2175e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f2176f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    /* compiled from: SimpleDecoder.java */
    /* loaded from: classes.dex */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            g.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.f2175e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            this.f2175e[i] = g();
        }
        this.f2176f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f2176f[i2] = h();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    private boolean f() {
        return !this.f2173c.isEmpty() && this.h > 0;
    }

    private boolean k() throws InterruptedException {
        E e2;
        synchronized (this.f2172b) {
            while (!this.l && !f()) {
                this.f2172b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.f2173c.removeFirst();
            O[] oArr = this.f2176f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (removeFirst.k()) {
                o.e(4);
            } else {
                if (removeFirst.j()) {
                    o.e(Integer.MIN_VALUE);
                }
                try {
                    e2 = j(removeFirst, o, z);
                } catch (OutOfMemoryError e3) {
                    e2 = i(e3);
                } catch (RuntimeException e4) {
                    e2 = i(e4);
                }
                if (e2 != null) {
                    synchronized (this.f2172b) {
                        this.j = e2;
                    }
                    return false;
                }
            }
            synchronized (this.f2172b) {
                if (this.k) {
                    o.n();
                } else if (o.j()) {
                    this.m++;
                    o.n();
                } else {
                    o.f2171f = this.m;
                    this.m = 0;
                    this.f2174d.addLast(o);
                }
                q(removeFirst);
            }
            return true;
        }
    }

    private void n() {
        if (f()) {
            this.f2172b.notify();
        }
    }

    private void o() throws DecoderException {
        E e2 = this.j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void q(I i) {
        i.f();
        I[] iArr = this.f2175e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    private void s(O o) {
        o.f();
        O[] oArr = this.f2176f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (k());
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public final void flush() {
        synchronized (this.f2172b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                q(i);
                this.i = null;
            }
            while (!this.f2173c.isEmpty()) {
                q(this.f2173c.removeFirst());
            }
            while (!this.f2174d.isEmpty()) {
                this.f2174d.removeFirst().n();
            }
        }
    }

    protected abstract I g();

    protected abstract O h();

    protected abstract E i(Throwable th);

    @Nullable
    protected abstract E j(I i, O o, boolean z);

    @Nullable
    /* renamed from: l */
    public final I d() throws DecoderException {
        I i;
        synchronized (this.f2172b) {
            o();
            com.google.android.exoplayer2.util.g.g(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.f2175e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Nullable
    /* renamed from: m */
    public final O b() throws DecoderException {
        synchronized (this.f2172b) {
            o();
            if (this.f2174d.isEmpty()) {
                return null;
            }
            return this.f2174d.removeFirst();
        }
    }

    /* renamed from: p */
    public final void c(I i) throws DecoderException {
        synchronized (this.f2172b) {
            o();
            com.google.android.exoplayer2.util.g.a(i == this.i);
            this.f2173c.addLast(i);
            n();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void r(O o) {
        synchronized (this.f2172b) {
            s(o);
            n();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.c
    @CallSuper
    public void release() {
        synchronized (this.f2172b) {
            this.l = true;
            this.f2172b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(int i) {
        com.google.android.exoplayer2.util.g.g(this.g == this.f2175e.length);
        for (I i2 : this.f2175e) {
            i2.o(i);
        }
    }
}
