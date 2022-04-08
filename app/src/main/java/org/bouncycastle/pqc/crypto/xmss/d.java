package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.l;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
final class d extends l {

    /* renamed from: e  reason: collision with root package name */
    private final int f17452e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17453f;
    private final int g;

    /* loaded from: classes4.dex */
    protected static class b extends l.a<b> {

        /* renamed from: e  reason: collision with root package name */
        private int f17454e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f17455f = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            super(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public l k() {
            return new d(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: l */
        public b e() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b m(int i) {
            this.f17454e = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b n(int i) {
            this.f17455f = i;
            return this;
        }
    }

    private d(b bVar) {
        super(bVar);
        this.f17452e = 0;
        this.f17453f = bVar.f17454e;
        this.g = bVar.f17455f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.bouncycastle.pqc.crypto.xmss.l
    public byte[] d() {
        byte[] d2 = super.d();
        f.d(this.f17452e, d2, 16);
        f.d(this.f17453f, d2, 20);
        f.d(this.g, d2, 24);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        return this.f17453f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return this.g;
    }
}
