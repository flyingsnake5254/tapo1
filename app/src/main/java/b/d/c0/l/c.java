package b.d.c0.l;

import b.d.c0.m.a;
import com.tplink.tdp.bean.BaseTDPDevice;

/* compiled from: TLVPayloadParser.java */
/* loaded from: classes3.dex */
public class c<T extends BaseTDPDevice> implements b<T> {
    private static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private Class<T> f174b;

    public c(Class<T> cls) {
        this.f174b = cls;
    }

    @Override // b.d.c0.l.b
    public T a(byte[] bArr) {
        return (T) ((BaseTDPDevice) a.a(bArr, this.f174b));
    }
}
