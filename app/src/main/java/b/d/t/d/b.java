package b.d.t.d;

import b.d.t.c.a;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.concurrent.Callable;

/* compiled from: CreationImpl.java */
/* loaded from: classes3.dex */
public abstract class b implements a, Callable<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    BaseConnection f724c;

    /* renamed from: d  reason: collision with root package name */
    NatBean f725d;

    /* renamed from: f  reason: collision with root package name */
    protected a f726f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseConnection baseConnection, a aVar) {
        this.f724c = baseConnection;
        this.f726f = aVar;
    }

    /* renamed from: b */
    public Boolean call() throws Exception {
        NatBean natBean = new NatBean();
        this.f725d = natBean;
        natBean.setDeviceIdMD5(this.f724c.getDeviceIdMD5());
        this.f725d.setIp(a());
        int port = getPort();
        this.f725d.setPort(port);
        this.f725d.setDeviceModel(this.f724c.getDeviceModel());
        boolean z = port > 0;
        this.f724c.setIp(this.f725d.getIp());
        this.f724c.setPort(this.f725d.getPort());
        this.f724c.setPortId(this.f725d.getPortId());
        this.f724c.setStatistics(this.f725d.getStatistics());
        a aVar = this.f726f;
        if (aVar == null) {
            if (this.f725d.getPortId() >= 0) {
                b.d.t.b.a(this.f725d.getPortId(), this.f725d.getDeviceModel());
            }
        } else if (z) {
            aVar.a(this.f725d);
        } else {
            aVar.b(this.f725d);
        }
        return Boolean.valueOf(z);
    }
}
