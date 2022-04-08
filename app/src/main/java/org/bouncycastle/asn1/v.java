package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class v {
    private final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16955b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[][] f16956c;

    public v(InputStream inputStream) {
        this(inputStream, y1.c(inputStream));
    }

    public v(InputStream inputStream, int i) {
        this.a = inputStream;
        this.f16955b = i;
        this.f16956c = new byte[11];
    }

    private void e(boolean z) {
        InputStream inputStream = this.a;
        if (inputStream instanceof t1) {
            ((t1) inputStream).g(z);
        }
    }

    e a(int i) throws IOException {
        if (i == 4) {
            return new d0(this);
        }
        if (i == 8) {
            return new p0(this);
        }
        if (i == 16) {
            return new f0(this);
        }
        if (i == 17) {
            return new h0(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i));
    }

    public e b() throws IOException {
        int read = this.a.read();
        if (read == -1) {
            return null;
        }
        boolean z = false;
        e(false);
        int u = i.u(this.a, read);
        if ((read & 32) != 0) {
            z = true;
        }
        int s = i.s(this.a, this.f16955b);
        if (s >= 0) {
            r1 r1Var = new r1(this.a, s);
            if ((read & 64) != 0) {
                return new l0(z, u, r1Var.e());
            }
            if ((read & 128) != 0) {
                return new j0(z, u, new v(r1Var));
            }
            if (z) {
                if (u == 4) {
                    return new d0(new v(r1Var));
                }
                if (u == 8) {
                    return new p0(new v(r1Var));
                }
                if (u == 16) {
                    return new c1(new v(r1Var));
                }
                if (u == 17) {
                    return new e1(new v(r1Var));
                }
                throw new IOException("unknown tag " + u + " encountered");
            } else if (u == 4) {
                return new y0(r1Var);
            } else {
                try {
                    return i.g(u, r1Var, this.f16956c);
                } catch (IllegalArgumentException e2) {
                    throw new ASN1Exception("corrupted stream detected", e2);
                }
            }
        } else if (z) {
            v vVar = new v(new t1(this.a, this.f16955b), this.f16955b);
            return (read & 64) != 0 ? new a0(u, vVar) : (read & 128) != 0 ? new j0(true, u, vVar) : vVar.a(u);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q c(boolean z, int i) throws IOException {
        if (!z) {
            return new g1(false, i, new x0(((r1) this.a).e()));
        }
        f d2 = d();
        return this.a instanceof t1 ? d2.c() == 1 ? new i0(true, i, d2.b(0)) : new i0(false, i, b0.a(d2)) : d2.c() == 1 ? new g1(true, i, d2.b(0)) : new g1(false, i, q0.a(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d() throws IOException {
        f fVar = new f();
        while (true) {
            e b2 = b();
            if (b2 == null) {
                return fVar;
            }
            fVar.a(b2 instanceof s1 ? ((s1) b2).b() : b2.c());
        }
    }
}
