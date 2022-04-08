package b.d.d0.g2;

import b.d.d0.f2.a;
import com.tplink.tmp.enumerate.EnumTMPAppV2PacketType;

/* compiled from: AppV2Header.java */
/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    private short f275c;

    /* renamed from: d  reason: collision with root package name */
    private byte f276d;

    /* renamed from: e  reason: collision with root package name */
    private byte f277e;

    /* renamed from: f  reason: collision with root package name */
    private short f278f;
    private int g;
    private int h;
    private int i;

    public b(byte b2, byte b3, short s, byte b4, byte b5, short s2, int i, int i2, int i3) {
        super(b2, b3);
        this.f275c = s;
        this.f276d = b4;
        this.f277e = b5;
        this.f278f = s2;
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    @Override // b.d.d0.g2.c
    public byte[] c() {
        byte[] bArr = new byte[20];
        System.arraycopy(super.c(), 0, bArr, 0, 2);
        System.arraycopy(a.b(this.f275c), 0, bArr, 2, 2);
        bArr[4] = this.f276d;
        bArr[5] = this.f277e;
        System.arraycopy(a.b(this.f278f), 0, bArr, 6, 2);
        System.arraycopy(a.a(this.g), 0, bArr, 8, 4);
        System.arraycopy(a.a(this.h), 0, bArr, 12, 4);
        System.arraycopy(a.a(this.i), 0, bArr, 16, 4);
        return bArr;
    }

    public int d() {
        return this.g;
    }

    public byte e() {
        return this.f277e;
    }

    public byte f() {
        return this.f276d;
    }

    public EnumTMPAppV2PacketType g() {
        byte f2 = f();
        if (f2 == 2) {
            return EnumTMPAppV2PacketType.TYPE_DATA_PUSH;
        }
        if (f2 == 3) {
            return EnumTMPAppV2PacketType.TYPE_DATA_PUSH_ACK;
        }
        if (f2 == 4) {
            return EnumTMPAppV2PacketType.TYPE_DATA_PULL;
        }
        if (f2 != 5) {
            return EnumTMPAppV2PacketType.TYPE_UNKNOWN;
        }
        return EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public b(c cVar, byte[] bArr) {
        super(cVar.a(), cVar.b());
        this.f275c = a.d(bArr, 0);
        this.f276d = bArr[2];
        this.f277e = bArr[3];
        this.f278f = a.d(bArr, 4);
        this.g = a.c(bArr, 6);
        this.h = a.c(bArr, 10);
        this.i = a.c(bArr, 14);
    }
}
