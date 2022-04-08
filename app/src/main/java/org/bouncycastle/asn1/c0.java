package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes4.dex */
public class c0 extends n {

    /* renamed from: d  reason: collision with root package name */
    private final int f16702d;

    /* renamed from: f  reason: collision with root package name */
    private final n[] f16703f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Enumeration {
        int a = 0;

        a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a < c0.this.f16703f.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            n[] nVarArr = c0.this.f16703f;
            int i = this.a;
            this.a = i + 1;
            return nVarArr[i];
        }
    }

    public c0(byte[] bArr) {
        this(bArr, 1000);
    }

    public c0(byte[] bArr, int i) {
        this(bArr, null, i);
    }

    private c0(byte[] bArr, n[] nVarArr, int i) {
        super(bArr);
        this.f16703f = nVarArr;
        this.f16702d = i;
    }

    public c0(n[] nVarArr) {
        this(nVarArr, 1000);
    }

    public c0(n[] nVarArr, int i) {
        this(t(nVarArr), nVarArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 q(r rVar) {
        n[] nVarArr = new n[rVar.size()];
        Enumeration q = rVar.q();
        int i = 0;
        while (q.hasMoreElements()) {
            i++;
            nVarArr[i] = (n) q.nextElement();
        }
        return new c0(nVarArr);
    }

    private Vector r() {
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.f16811c;
            if (i >= bArr.length) {
                return vector;
            }
            int i2 = this.f16702d;
            int length = (i + i2 > bArr.length ? bArr.length : i2 + i) - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i, bArr2, 0, length);
            vector.addElement(new x0(bArr2));
            i += this.f16702d;
        }
    }

    private static byte[] t(n[] nVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != nVarArr.length; i++) {
            try {
                byteArrayOutputStream.write(((x0) nVarArr[i]).o());
            } catch (IOException e2) {
                throw new IllegalArgumentException("exception converting octets " + e2.toString());
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(nVarArr[i].getClass().getName() + " found in input should only contain DEROctetString");
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.c(36);
        pVar.c(128);
        Enumeration s = s();
        while (s.hasMoreElements()) {
            pVar.j((e) s.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        Enumeration s = s();
        int i = 0;
        while (s.hasMoreElements()) {
            i += ((e) s.nextElement()).c().h();
        }
        return i + 2 + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return true;
    }

    @Override // org.bouncycastle.asn1.n
    public byte[] o() {
        return this.f16811c;
    }

    public Enumeration s() {
        return this.f16703f == null ? r().elements() : new a();
    }
}
