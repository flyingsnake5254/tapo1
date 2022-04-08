package b.d.c0.m.e;

import b.d.c0.m.b;
import com.github.mikephil.charting.utils.Utils;
import java.io.UnsupportedEncodingException;

/* compiled from: TLVReader.java */
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    private short f177d;

    /* renamed from: e  reason: collision with root package name */
    private int f178e;

    public a(byte[] bArr) {
        this.f178e = -1;
        this.a = bArr;
        this.f178e = bArr.length - 1;
    }

    private short j() {
        byte[] bArr = new byte[2];
        System.arraycopy(this.a, this.f179b, bArr, 0, 2);
        this.f179b += 2;
        return w(bArr);
    }

    private boolean p(byte[] bArr) {
        return q(bArr) == 1;
    }

    private byte q(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return (byte) 0;
        }
        return bArr[0];
    }

    private char r(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return (char) 0;
        }
        return b.b(bArr);
    }

    private double s(byte[] bArr) {
        return (bArr == null || bArr.length < 8) ? Utils.DOUBLE_EPSILON : b.c(bArr);
    }

    private float t(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0.0f;
        }
        return b.d(bArr);
    }

    private int u(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return b.e(bArr);
    }

    private long v(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            return 0L;
        }
        return b.f(bArr);
    }

    private short w(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return (short) 0;
        }
        return b.g(bArr);
    }

    private String x(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void y(short s) {
        this.f179b += 4 - (s & 3);
    }

    public short a() {
        byte[] bArr = new byte[2];
        System.arraycopy(this.a, this.f179b, bArr, 0, 2);
        return w(bArr);
    }

    public boolean b() {
        if (this.f180c == 1) {
            o();
        }
        return this.f179b < this.f178e;
    }

    public short c() {
        return this.f177d;
    }

    public Boolean d() {
        return Boolean.valueOf(p(o()));
    }

    public Byte e() {
        return Byte.valueOf(q(o()));
    }

    public Character f() {
        return Character.valueOf(r(o()));
    }

    public Double g() {
        return Double.valueOf(s(o()));
    }

    public Float h() {
        return Float.valueOf(t(o()));
    }

    public Integer i() {
        return Integer.valueOf(u(o()));
    }

    public Long k() {
        return Long.valueOf(v(o()));
    }

    public Short l() {
        return Short.valueOf(w(o()));
    }

    public String m() {
        return x(o());
    }

    public short n() {
        if (this.f180c == 1) {
            o();
        }
        byte[] bArr = new byte[2];
        System.arraycopy(this.a, this.f179b, bArr, 0, 2);
        this.f179b += 2;
        this.f180c = (byte) 1;
        short w = w(bArr);
        this.f177d = w;
        return w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] o() {
        if (this.f180c == 0) {
            n();
        }
        int j = j();
        byte[] bArr = new byte[j];
        if (j != 0) {
            System.arraycopy(this.a, this.f179b, bArr, 0, j);
            this.f179b += j;
        }
        y(j);
        this.f180c = (byte) 0;
        return bArr;
    }
}
