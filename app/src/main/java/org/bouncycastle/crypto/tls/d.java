package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Vector;

/* loaded from: classes4.dex */
public abstract class d implements x0 {
    protected int a;

    /* renamed from: b  reason: collision with root package name */
    protected Vector f17216b;

    /* renamed from: c  reason: collision with root package name */
    protected p0 f17217c;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(int i, Vector vector) {
        this.a = i;
        this.f17216b = vector;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.bouncycastle.crypto.tls.x0
    public void a(p0 p0Var) {
        Vector vector;
        this.f17217c = p0Var;
        x a = p0Var.a();
        if (m1.L(a)) {
            if (this.f17216b == null) {
                int i = this.a;
                if (i != 1) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 7) {
                                if (i != 9) {
                                    switch (i) {
                                        case 13:
                                        case 14:
                                            return;
                                        case 15:
                                        case 18:
                                        case 19:
                                            break;
                                        case 16:
                                        case 17:
                                            vector = m1.x();
                                            break;
                                        default:
                                            switch (i) {
                                                case 21:
                                                case 24:
                                                    return;
                                                case 22:
                                                    break;
                                                case 23:
                                                    break;
                                                default:
                                                    throw new IllegalStateException("unsupported key exchange algorithm");
                                            }
                                    }
                                    this.f17216b = vector;
                                }
                            }
                        }
                    }
                    vector = m1.w();
                    this.f17216b = vector;
                }
                vector = m1.y();
                this.f17216b = vector;
            }
        } else if (this.f17216b != null) {
            throw new IllegalStateException("supported_signature_algorithms not allowed for " + a);
        }
    }

    @Override // org.bouncycastle.crypto.tls.x0
    public void d() throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.x0
    public void f() throws IOException {
        if (k()) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.x0
    public void g(h hVar) throws IOException {
    }

    public abstract boolean k();
}
