package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public abstract class l {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17475b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17476c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17477d;

    /* loaded from: classes4.dex */
    protected static abstract class a<T extends a> {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private int f17478b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f17479c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f17480d = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(int i) {
            this.a = i;
        }

        protected abstract T e();

        /* JADX INFO: Access modifiers changed from: protected */
        public T f(int i) {
            this.f17480d = i;
            return e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public T g(int i) {
            this.f17478b = i;
            return e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public T h(long j) {
            this.f17479c = j;
            return e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(a aVar) {
        this.a = aVar.f17478b;
        this.f17475b = aVar.f17479c;
        this.f17476c = aVar.a;
        this.f17477d = aVar.f17480d;
    }

    public final int a() {
        return this.f17477d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long c() {
        return this.f17475b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] d() {
        byte[] bArr = new byte[32];
        f.d(this.a, bArr, 0);
        f.l(this.f17475b, bArr, 4);
        f.d(this.f17476c, bArr, 12);
        f.d(this.f17477d, bArr, 28);
        return bArr;
    }
}
