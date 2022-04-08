package b.d.c0.l;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.tplink.tdp.bean.BaseTDPDevice;
import com.tplink.tdp.common.TDPResult;

/* compiled from: JsonPayloadParser.java */
/* loaded from: classes3.dex */
public class a<T extends BaseTDPDevice> implements b<T> {
    private static final Gson a = new d().c().b();

    /* renamed from: b  reason: collision with root package name */
    private Class<T> f173b;

    public a(Class<T> cls) {
        this.f173b = cls;
    }

    @Override // b.d.c0.l.b
    public T a(byte[] bArr) {
        try {
            TDPResult tDPResult = (TDPResult) a.m(new String(bArr), new com.tplink.tdp.common.a(TDPResult.class, new Class[]{this.f173b}, null));
            if (tDPResult.getErrorCode() == 0) {
                return (T) ((BaseTDPDevice) tDPResult.getResult());
            }
        } catch (JsonSyntaxException unused) {
        }
        return null;
    }
}
