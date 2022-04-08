package org.bouncycastle.crypto.t;

import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.h;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.d;
import org.bouncycastle.util.e;

/* loaded from: classes4.dex */
public class b implements j {
    private static Hashtable a;

    /* renamed from: b  reason: collision with root package name */
    private g f17179b;

    /* renamed from: c  reason: collision with root package name */
    private int f17180c;

    /* renamed from: d  reason: collision with root package name */
    private int f17181d;

    /* renamed from: e  reason: collision with root package name */
    private e f17182e;

    /* renamed from: f  reason: collision with root package name */
    private e f17183f;
    private byte[] g;
    private byte[] h;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("GOST3411", d.b(32));
        a.put("MD2", d.b(16));
        a.put("MD4", d.b(64));
        a.put("MD5", d.b(64));
        a.put("RIPEMD128", d.b(64));
        a.put("RIPEMD160", d.b(64));
        a.put("SHA-1", d.b(64));
        a.put("SHA-224", d.b(64));
        a.put("SHA-256", d.b(64));
        a.put("SHA-384", d.b(128));
        a.put("SHA-512", d.b(128));
        a.put("Tiger", d.b(64));
        a.put("Whirlpool", d.b(64));
    }

    public b(g gVar) {
        this(gVar, e(gVar));
    }

    private b(g gVar, int i) {
        this.f17179b = gVar;
        int e2 = gVar.e();
        this.f17180c = e2;
        this.f17181d = i;
        this.g = new byte[i];
        this.h = new byte[i + e2];
    }

    private static int e(g gVar) {
        if (gVar instanceof h) {
            return ((h) gVar).k();
        }
        Integer num = (Integer) a.get(gVar.b());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + gVar.b());
    }

    private static void f(byte[] bArr, int i, byte b2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b2);
        }
    }

    @Override // org.bouncycastle.crypto.j
    public int a() {
        return this.f17180c;
    }

    @Override // org.bouncycastle.crypto.j
    public String b() {
        return this.f17179b.b() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.j
    public void c(byte b2) {
        this.f17179b.c(b2);
    }

    @Override // org.bouncycastle.crypto.j
    public void d(org.bouncycastle.crypto.e eVar) {
        byte[] bArr;
        this.f17179b.reset();
        byte[] a2 = ((a0) eVar).a();
        int length = a2.length;
        if (length > this.f17181d) {
            this.f17179b.update(a2, 0, length);
            this.f17179b.doFinal(this.g, 0);
            length = this.f17180c;
        } else {
            System.arraycopy(a2, 0, this.g, 0, length);
        }
        while (true) {
            bArr = this.g;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.h, 0, this.f17181d);
        f(this.g, this.f17181d, (byte) 54);
        f(this.h, this.f17181d, (byte) 92);
        g gVar = this.f17179b;
        if (gVar instanceof e) {
            e copy = ((e) gVar).copy();
            this.f17183f = copy;
            ((g) copy).update(this.h, 0, this.f17181d);
        }
        g gVar2 = this.f17179b;
        byte[] bArr2 = this.g;
        gVar2.update(bArr2, 0, bArr2.length);
        g gVar3 = this.f17179b;
        if (gVar3 instanceof e) {
            this.f17182e = ((e) gVar3).copy();
        }
    }

    @Override // org.bouncycastle.crypto.j
    public int doFinal(byte[] bArr, int i) {
        this.f17179b.doFinal(this.h, this.f17181d);
        e eVar = this.f17183f;
        if (eVar != null) {
            ((e) this.f17179b).m(eVar);
            g gVar = this.f17179b;
            gVar.update(this.h, this.f17181d, gVar.e());
        } else {
            g gVar2 = this.f17179b;
            byte[] bArr2 = this.h;
            gVar2.update(bArr2, 0, bArr2.length);
        }
        int doFinal = this.f17179b.doFinal(bArr, i);
        int i2 = this.f17181d;
        while (true) {
            byte[] bArr3 = this.h;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        e eVar2 = this.f17182e;
        if (eVar2 != null) {
            ((e) this.f17179b).m(eVar2);
        } else {
            g gVar3 = this.f17179b;
            byte[] bArr4 = this.g;
            gVar3.update(bArr4, 0, bArr4.length);
        }
        return doFinal;
    }

    @Override // org.bouncycastle.crypto.j
    public void reset() {
        this.f17179b.reset();
        g gVar = this.f17179b;
        byte[] bArr = this.g;
        gVar.update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.j
    public void update(byte[] bArr, int i, int i2) {
        this.f17179b.update(bArr, i, i2);
    }
}
