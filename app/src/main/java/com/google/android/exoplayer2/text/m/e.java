package com.google.android.exoplayer2.text.m;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.text.m.e;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* compiled from: CeaDecoder.java */
/* loaded from: classes.dex */
abstract class e implements g {
    private final ArrayDeque<b> a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<j> f3468b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<b> f3469c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private b f3470d;

    /* renamed from: e  reason: collision with root package name */
    private long f3471e;

    /* renamed from: f  reason: collision with root package name */
    private long f3472f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CeaDecoder.java */
    /* loaded from: classes.dex */
    public static final class b extends i implements Comparable<b> {
        private long p2;

        private b() {
        }

        /* renamed from: u */
        public int compareTo(b bVar) {
            if (k() != bVar.k()) {
                return k() ? 1 : -1;
            }
            long j = this.x - bVar.x;
            if (j == 0) {
                j = this.p2 - bVar.p2;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CeaDecoder.java */
    /* loaded from: classes.dex */
    public static final class c extends j {
        private f.a<c> y;

        public c(f.a<c> aVar) {
            this.y = aVar;
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public final void n() {
            this.y.a(this);
        }
    }

    public e() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b());
        }
        this.f3468b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f3468b.add(new c(new f.a() { // from class: com.google.android.exoplayer2.text.m.b
                @Override // com.google.android.exoplayer2.decoder.f.a
                public final void a(f fVar) {
                    e.this.n((e.c) fVar);
                }
            }));
        }
        this.f3469c = new PriorityQueue<>();
    }

    private void m(b bVar) {
        bVar.f();
        this.a.add(bVar);
    }

    @Override // com.google.android.exoplayer2.text.g
    public void a(long j) {
        this.f3471e = j;
    }

    protected abstract com.google.android.exoplayer2.text.f e();

    protected abstract void f(i iVar);

    @Override // com.google.android.exoplayer2.decoder.c
    public void flush() {
        this.f3472f = 0L;
        this.f3471e = 0L;
        while (!this.f3469c.isEmpty()) {
            m((b) o0.i(this.f3469c.poll()));
        }
        b bVar = this.f3470d;
        if (bVar != null) {
            m(bVar);
            this.f3470d = null;
        }
    }

    @Nullable
    /* renamed from: g */
    public i d() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.g.g(this.f3470d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b pollFirst = this.a.pollFirst();
        this.f3470d = pollFirst;
        return pollFirst;
    }

    @Nullable
    /* renamed from: h */
    public j b() throws SubtitleDecoderException {
        if (this.f3468b.isEmpty()) {
            return null;
        }
        while (!this.f3469c.isEmpty() && ((b) o0.i(this.f3469c.peek())).x <= this.f3471e) {
            b bVar = (b) o0.i(this.f3469c.poll());
            if (bVar.k()) {
                j jVar = (j) o0.i(this.f3468b.pollFirst());
                jVar.e(4);
                m(bVar);
                return jVar;
            }
            f(bVar);
            if (k()) {
                com.google.android.exoplayer2.text.f e2 = e();
                j jVar2 = (j) o0.i(this.f3468b.pollFirst());
                jVar2.o(bVar.x, e2, Long.MAX_VALUE);
                m(bVar);
                return jVar2;
            }
            m(bVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final j i() {
        return this.f3468b.pollFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long j() {
        return this.f3471e;
    }

    protected abstract boolean k();

    /* renamed from: l */
    public void c(i iVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.g.a(iVar == this.f3470d);
        b bVar = (b) iVar;
        if (bVar.j()) {
            m(bVar);
        } else {
            long j = this.f3472f;
            this.f3472f = 1 + j;
            bVar.p2 = j;
            this.f3469c.add(bVar);
        }
        this.f3470d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(j jVar) {
        jVar.f();
        this.f3468b.add(jVar);
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public void release() {
    }
}
