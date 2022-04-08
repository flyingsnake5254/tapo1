package org.bouncycastle.crypto.w;

/* loaded from: classes4.dex */
public class t extends b {

    /* renamed from: d  reason: collision with root package name */
    private u f17363d;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(boolean z, u uVar) {
        super(z);
        this.f17363d = uVar;
    }

    public u b() {
        return this.f17363d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        u uVar = this.f17363d;
        u b2 = ((t) obj).b();
        return uVar == null ? b2 == null : uVar.equals(b2);
    }

    public int hashCode() {
        u uVar = this.f17363d;
        if (uVar != null) {
            return uVar.hashCode();
        }
        return 0;
    }
}
