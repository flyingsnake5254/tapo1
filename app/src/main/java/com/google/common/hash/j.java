package com.google.common.hash;

import com.google.common.base.t;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LongAddables.java */
/* loaded from: classes2.dex */
final class j {
    private static final t<i> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LongAddables.java */
    /* loaded from: classes2.dex */
    public static class a implements t<i> {
        a() {
        }

        /* renamed from: a */
        public i get() {
            return new k();
        }
    }

    /* compiled from: LongAddables.java */
    /* loaded from: classes2.dex */
    static class b implements t<i> {
        b() {
        }

        /* renamed from: a */
        public i get() {
            return new c(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LongAddables.java */
    /* loaded from: classes2.dex */
    public static final class c extends AtomicLong implements i {
        private c() {
        }

        @Override // com.google.common.hash.i
        public long a() {
            return get();
        }

        @Override // com.google.common.hash.i
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.hash.i
        public void increment() {
            getAndIncrement();
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        t<i> tVar;
        try {
            new k();
            tVar = new a();
        } catch (Throwable unused) {
            tVar = new b();
        }
        a = tVar;
    }

    public static i a() {
        return a.get();
    }
}
