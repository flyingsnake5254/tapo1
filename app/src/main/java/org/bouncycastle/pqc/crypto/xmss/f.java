package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.l;

/* loaded from: classes4.dex */
final class f extends l {

    /* renamed from: e  reason: collision with root package name */
    private final int f17457e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17458f;
    private final int g;

    /* loaded from: classes4.dex */
    protected static class b extends l.a<b> {

        /* renamed from: e  reason: collision with root package name */
        private int f17459e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f17460f = 0;
        private int g = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public l l() {
            return new f(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m */
        public b e() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b n(int i) {
            this.f17459e = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b o(int i) {
            this.f17460f = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b p(int i) {
            this.g = i;
            return this;
        }
    }

    private f(b bVar) {
        super(bVar);
        this.f17457e = bVar.f17459e;
        this.f17458f = bVar.f17460f;
        this.g = bVar.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.bouncycastle.pqc.crypto.xmss.l
    public byte[] d() {
        byte[] d2 = super.d();
        org.bouncycastle.util.f.d(this.f17457e, d2, 16);
        org.bouncycastle.util.f.d(this.f17458f, d2, 20);
        org.bouncycastle.util.f.d(this.g, d2, 24);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        return this.f17457e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return this.f17458f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g() {
        return this.g;
    }
}
