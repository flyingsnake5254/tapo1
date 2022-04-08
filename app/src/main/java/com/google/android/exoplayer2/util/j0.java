package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemHandlerWrapper.java */
/* loaded from: classes.dex */
public final class j0 implements r {
    @GuardedBy("messagePool")
    private static final List<b> a = new ArrayList(50);

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3921b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SystemHandlerWrapper.java */
    /* loaded from: classes.dex */
    public static final class b implements r.a {
        @Nullable
        private Message a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private j0 f3922b;

        private b() {
        }

        private void b() {
            this.a = null;
            this.f3922b = null;
            j0.n(this);
        }

        @Override // com.google.android.exoplayer2.util.r.a
        public void a() {
            ((Message) g.e(this.a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) g.e(this.a));
            b();
            return sendMessageAtFrontOfQueue;
        }

        public b d(Message message, j0 j0Var) {
            this.a = message;
            this.f3922b = j0Var;
            return this;
        }
    }

    public j0(Handler handler) {
        this.f3921b = handler;
    }

    private static b m() {
        b bVar;
        List<b> list = a;
        synchronized (list) {
            if (list.isEmpty()) {
                bVar = new b();
            } else {
                bVar = list.remove(list.size() - 1);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(b bVar) {
        List<b> list = a;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(bVar);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.r
    public r.a a(int i) {
        return m().d(this.f3921b.obtainMessage(i), this);
    }

    @Override // com.google.android.exoplayer2.util.r
    public boolean b(r.a aVar) {
        return ((b) aVar).c(this.f3921b);
    }

    @Override // com.google.android.exoplayer2.util.r
    public boolean c(int i) {
        return this.f3921b.hasMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.r
    public r.a d(int i, int i2, int i3, @Nullable Object obj) {
        return m().d(this.f3921b.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.r
    public r.a e(int i, @Nullable Object obj) {
        return m().d(this.f3921b.obtainMessage(i, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.r
    public void f(@Nullable Object obj) {
        this.f3921b.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.r
    public r.a g(int i, int i2, int i3) {
        return m().d(this.f3921b.obtainMessage(i, i2, i3), this);
    }

    @Override // com.google.android.exoplayer2.util.r
    public boolean h(Runnable runnable) {
        return this.f3921b.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.r
    public boolean i(int i) {
        return this.f3921b.sendEmptyMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.r
    public boolean j(int i, long j) {
        return this.f3921b.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.google.android.exoplayer2.util.r
    public void k(int i) {
        this.f3921b.removeMessages(i);
    }
}
