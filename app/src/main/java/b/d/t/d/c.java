package b.d.t.d;

import b.d.t.c.a;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

/* compiled from: LocalCreationImpl.java */
/* loaded from: classes3.dex */
public class c extends b {
    public c(BaseConnection baseConnection, a aVar) {
        super(baseConnection, aVar);
    }

    @Override // b.d.t.d.a
    public String a() {
        return b.d.d.d.c.b(this.f724c.getDeviceIdMD5());
    }

    @Override // b.d.t.d.a
    public int getPort() {
        this.f724c.getDeviceModel();
        this.f724c.setPortId(-1);
        int mediaType = this.f724c.getMediaType();
        if (mediaType != 0 && 1 == mediaType) {
        }
        return 8800;
    }
}
