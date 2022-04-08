package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.l;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
final class g extends l {

    /* renamed from: e  reason: collision with root package name */
    private final int f17461e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17462f;
    private final int g;

    /* loaded from: classes4.dex */
    protected static class b extends l.a<b> {

        /* renamed from: e  reason: collision with root package name */
        private int f17463e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f17464f = 0;
        private int g = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public l l() {
            return new g(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m */
        public b e() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b n(int i) {
            this.f17464f = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b o(int i) {
            this.g = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b p(int i) {
            this.f17463e = i;
            return this;
        }
    }

    private g(b bVar) {
        super(bVar);
        this.f17461e = bVar.f17463e;
        this.f17462f = bVar.f17464f;
        this.g = bVar.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.bouncycastle.pqc.crypto.xmss.l
    public byte[] d() {
        byte[] d2 = super.d();
        f.d(this.f17461e, d2, 16);
        f.d(this.f17462f, d2, 20);
        f.d(this.g, d2, 24);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        return this.f17462f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g() {
        return this.f17461e;
    }
}
