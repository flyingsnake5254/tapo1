package com.tplink.libmediakit.media.audioprocess;

import androidx.core.app.NotificationCompat;
import com.tplink.libmediakit.media.audioprocess.b;
import com.tplink.libmediakit.media.audioprocess.d;
import java.nio.ByteBuffer;
import java.util.Queue;

/* compiled from: AudioProcessor.java */
/* loaded from: classes3.dex */
public abstract class f<T extends d> {
    protected final String a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    protected final c f11942b;

    /* renamed from: c  reason: collision with root package name */
    protected int f11943c;

    /* renamed from: d  reason: collision with root package name */
    protected int f11944d;

    /* renamed from: e  reason: collision with root package name */
    protected long f11945e;

    /* renamed from: f  reason: collision with root package name */
    protected long f11946f;
    protected Queue<T> g;
    protected Queue<T> h;
    protected T i;
    protected boolean j;
    protected b.AbstractC0246b k;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(c cVar, int i) {
        this.f11942b = cVar;
        this.f11943c = i;
    }

    public void a() {
        this.i = null;
        Queue<T> queue = this.g;
        if (queue != null) {
            queue.clear();
        }
        Queue<T> queue2 = this.h;
        if (queue2 != null) {
            queue2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Queue<T> queue, ByteBuffer byteBuffer) {
        T peek = queue.peek();
        if (peek != null) {
            ByteBuffer f2 = peek.f();
            while (byteBuffer.remaining() >= f2.remaining()) {
                byteBuffer.put(f2.array(), f2.position(), f2.remaining());
                queue.remove();
                peek = queue.peek();
                if (peek == null) {
                    break;
                }
                f2 = peek.f();
            }
            if (byteBuffer.hasRemaining() && peek != null && byteBuffer.remaining() <= f2.remaining()) {
                f2.get(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                if (!f2.hasRemaining()) {
                    queue.remove();
                }
            }
        }
    }

    public Queue<T> c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long d(d dVar) {
        return dVar.e() + (((dVar.f().position() * 1000) / (dVar.c() / 8)) / (dVar.d() / 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long e(d dVar) {
        return dVar.j() + ((dVar.f().position() / (dVar.c() / 8)) / (dVar.d() / 1000));
    }

    public boolean f() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str) {
        e.a(this.a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, String str2) {
        e.b(this.a, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i, T t, T t2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k() {
        if (!j()) {
            h(NotificationCompat.CATEGORY_STATUS, "proceed() skip due to preProcess() failed");
        } else if (p()) {
            this.j = true;
        } else {
            h(NotificationCompat.CATEGORY_STATUS, "proceed()");
            T peek = this.g.peek();
            if (peek == null) {
                this.j = true;
                return;
            }
            if (this.i == null) {
                this.i = (T) peek.i();
                this.i.g(ByteBuffer.wrap(new byte[(this.f11944d * peek.c()) / 8]));
                this.i.h(e(peek));
                long d2 = d(peek);
                this.f11946f = d2;
                this.i.b(d2);
            }
            b(this.g, this.i.f());
            if (!this.i.f().hasRemaining()) {
                this.f11945e = this.i.j();
                this.i.f().flip();
                d i = this.i.i();
                i.g(ByteBuffer.wrap(new byte[this.i.f().capacity()]));
                int l = l(this.i.f().array(), i.f().array());
                this.h.add(i);
                i(l, this.i, i);
                this.i = null;
                this.j = false;
                return;
            }
            this.j = true;
        }
    }

    protected abstract int l(byte[] bArr, byte[] bArr2);

    public void m(Queue<T> queue) {
        this.g = queue;
        g("setInputQueue:" + queue);
    }

    public void n(Queue<T> queue) {
        this.h = queue;
        g("setOutputQueue:" + queue);
    }

    public void o(b.AbstractC0246b bVar) {
        this.k = bVar;
    }

    protected abstract boolean p();
}
