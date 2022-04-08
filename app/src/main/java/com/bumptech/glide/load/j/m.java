package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.j;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class m<A, B> {
    private final f<b<A>, B> a;

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    class a extends f<b<A>, B> {
        a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public void j(@NonNull b<A> bVar, @Nullable B b2) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b<A> {
        private static final Queue<b<?>> a = j.f(0);

        /* renamed from: b  reason: collision with root package name */
        private int f1571b;

        /* renamed from: c  reason: collision with root package name */
        private int f1572c;

        /* renamed from: d  reason: collision with root package name */
        private A f1573d;

        private b() {
        }

        static <A> b<A> a(A a2, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = a;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i, i2);
            return bVar;
        }

        private void b(A a2, int i, int i2) {
            this.f1573d = a2;
            this.f1572c = i;
            this.f1571b = i2;
        }

        public void c() {
            Queue<b<?>> queue = a;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1572c == bVar.f1572c && this.f1571b == bVar.f1571b && this.f1573d.equals(bVar.f1573d);
        }

        public int hashCode() {
            return (((this.f1571b * 31) + this.f1572c) * 31) + this.f1573d.hashCode();
        }
    }

    public m(long j) {
        this.a = new a(j);
    }

    @Nullable
    public B a(A a2, int i, int i2) {
        b<A> a3 = b.a(a2, i, i2);
        B g = this.a.g(a3);
        a3.c();
        return g;
    }

    public void b(A a2, int i, int i2, B b2) {
        this.a.k(b.a(a2, i, i2), b2);
    }
}
