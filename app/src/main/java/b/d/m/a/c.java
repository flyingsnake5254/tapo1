package b.d.m.a;

import b.d.t.e.e;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DownloadConnectionManager.java */
/* loaded from: classes3.dex */
public class c {
    private static final String a = "c";

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, NatBean> f529b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, NatBean> f530c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f531d;

    /* renamed from: e  reason: collision with root package name */
    private b f532e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<String> f533f;
    private final Map<String, Integer> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadConnectionManager.java */
    /* loaded from: classes3.dex */
    public class a implements b.d.t.c.a {
        final /* synthetic */ a a;

        a(a aVar) {
            this.a = aVar;
        }

        @Override // b.d.t.c.a
        public void a(NatBean natBean) {
            if (c.this.f532e != null) {
                c.this.f532e.b(this.a);
            }
        }

        @Override // b.d.t.c.a
        public void b(NatBean natBean) {
            if (c.this.f532e != null) {
                c.this.f532e.n(Collections.singletonList(this.a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadConnectionManager.java */
    /* loaded from: classes3.dex */
    public class b implements b.d.t.c.a {
        final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f535b;

        b(a aVar, String str) {
            this.a = aVar;
            this.f535b = str;
        }

        @Override // b.d.t.c.a
        public void a(NatBean natBean) {
            String str = c.a;
            b.d.p.d.c(str, "Download P2P creates successfully " + natBean.toString());
            if (c.this.f533f.contains(natBean.getDeviceIdMD5())) {
                String str2 = c.a;
                b.d.p.d.c(str2, "Download P2P needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
                if (c.this.f532e != null) {
                    c.this.f532e.e(this.a);
                }
            } else if (c.this.f531d.get() == 1) {
                String str3 = c.a;
                b.d.p.d.c(str3, "Download P2P needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
                if (c.this.f532e != null) {
                    c.this.f532e.e(this.a);
                }
            } else {
                c.this.f531d.set(1);
                c.this.f529b.put(this.f535b, natBean);
                if (c.this.f532e != null) {
                    c.this.f532e.b(this.a);
                    return;
                }
                String str4 = c.a;
                b.d.p.d.c(str4, "Download P2P needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
            }
        }

        @Override // b.d.t.c.a
        public void b(NatBean natBean) {
            String str = c.a;
            b.d.p.d.c(str, "Download P2P creates failed " + natBean.toString());
            if (c.this.f531d.get() == 2) {
                if (c.this.f532e != null) {
                    c.this.f532e.n(Collections.singletonList(this.a));
                }
            } else if (c.this.f531d.get() == 0) {
                c.this.f531d.set(2);
            }
            if (c.this.f532e != null) {
                c.this.f532e.e(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadConnectionManager.java */
    /* renamed from: b.d.m.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0023c implements b.d.t.c.a {
        final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f537b;

        C0023c(a aVar, String str) {
            this.a = aVar;
            this.f537b = str;
        }

        @Override // b.d.t.c.a
        public void a(NatBean natBean) {
            String str = c.a;
            b.d.p.d.c(str, "Download Relay creates successfully " + natBean.toString());
            if (c.this.f533f.contains(natBean.getDeviceIdMD5())) {
                String str2 = c.a;
                b.d.p.d.c(str2, "Download Relay needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
                if (c.this.f532e != null) {
                    c.this.f532e.e(this.a);
                }
            } else if (c.this.f531d.get() == 1) {
                String str3 = c.a;
                b.d.p.d.c(str3, "Download Relay needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
                if (c.this.f532e != null) {
                    c.this.f532e.e(this.a);
                }
            } else {
                c.this.f531d.set(1);
                c.this.f530c.put(this.f537b, natBean);
                if (c.this.f532e != null) {
                    c.this.f532e.b(this.a);
                    return;
                }
                String str4 = c.a;
                b.d.p.d.c(str4, "Download Relay needs destroy " + natBean.toString());
                b.d.t.a.c().b(natBean.getPortId(), natBean.getDeviceModel());
            }
        }

        @Override // b.d.t.c.a
        public void b(NatBean natBean) {
            String str = c.a;
            b.d.p.d.c(str, "Download Relay creates failed " + natBean.toString());
            if (c.this.f531d.get() == 2) {
                if (c.this.f532e != null) {
                    c.this.f532e.n(Collections.singletonList(this.a));
                }
            } else if (c.this.f531d.get() == 0) {
                c.this.f531d.set(2);
            }
            if (c.this.f532e != null) {
                c.this.f532e.e(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DownloadConnectionManager.java */
    /* loaded from: classes3.dex */
    public static class d {
        public static final c a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private void j(TPMediaDevice tPMediaDevice, int i) {
        a aVar = new a(tPMediaDevice.getDeviceIdMd5(), DeviceModel.fromValue(tPMediaDevice.getModel()));
        aVar.setConnectionType(i);
        b.d.t.a.c().a(aVar, new a(aVar));
    }

    private void k(TPMediaDevice tPMediaDevice) {
        this.f531d.set(0);
        String deviceIdMd5 = tPMediaDevice.getDeviceIdMd5();
        DeviceModel fromValue = DeviceModel.fromValue(tPMediaDevice.getModel());
        if (b.d.d.a.a.h() && !n(deviceIdMd5)) {
            a aVar = new a(deviceIdMd5, fromValue);
            aVar.setConnectionType(16);
            b.d.t.a.c().a(aVar, new b(aVar, deviceIdMd5));
        }
        if (b.d.d.a.a.i()) {
            a aVar2 = new a(deviceIdMd5, fromValue);
            aVar2.setConnectionType(0);
            b.d.t.a.c().a(aVar2, new C0023c(aVar2, deviceIdMd5));
        }
    }

    public static c m() {
        return d.a;
    }

    private boolean n(String str) {
        Integer num = this.g.get(str);
        if (num == null || num.intValue() < 2) {
            return false;
        }
        String str2 = a;
        b.d.p.d.c(str2, "deviceIdMD5 " + str + " expCount " + num + " skip P2P");
        return true;
    }

    public void g(String str) {
        int i;
        Integer num = this.g.get(str);
        if (num == null) {
            i = 1;
        } else {
            i = Integer.valueOf(num.intValue() + 1);
        }
        this.g.put(str, i);
    }

    public void h() {
        this.g.clear();
    }

    public void i(String str) {
        this.g.remove(str);
    }

    public void l(String str) {
        p(str);
        this.f533f.remove(str);
        TPMediaDevice c2 = b.d.d.d.c.c(str);
        if (c2 == null) {
            a aVar = new a(str, DeviceModel.CAMERA_OTHER);
            b bVar = this.f532e;
            if (bVar != null) {
                bVar.n(Collections.singletonList(aVar));
            }
        } else if (b.d.d.d.c.i(str)) {
            j(c2, 256);
        } else if (!e.g(str) || !e.h(str)) {
            k(c2);
        } else {
            j(c2, 17);
        }
    }

    public void o() {
        for (Map.Entry<String, NatBean> entry : this.f529b.entrySet()) {
            NatBean value = entry.getValue();
            String str = a;
            b.d.p.d.c(str, "DoubleTalk P2P needs destroy " + value.toString());
            b.d.t.a.c().b(value.getPortId(), value.getDeviceModel());
        }
        this.f529b.clear();
        for (Map.Entry<String, NatBean> entry2 : this.f530c.entrySet()) {
            NatBean value2 = entry2.getValue();
            String str2 = a;
            b.d.p.d.c(str2, "DoubleTalk Relay needs destroy " + value2.toString());
            b.d.t.a.c().b(value2.getPortId(), value2.getDeviceModel());
        }
        this.f530c.clear();
        this.f532e = null;
    }

    public void p(String str) {
        String str2 = a;
        b.d.p.d.c(str2, "release " + str);
        this.f533f.add(str);
        NatBean remove = this.f529b.remove(str);
        if (remove != null) {
            b.d.p.d.c(str2, "DoubleTalk P2P needs destroy " + remove.toString());
            b.d.t.a.c().b(remove.getPortId(), remove.getDeviceModel());
        }
        NatBean remove2 = this.f530c.remove(str);
        if (remove2 != null) {
            b.d.p.d.c(str2, "DoubleTalk Relay needs destroy " + remove2.toString());
            b.d.t.a.c().b(remove2.getPortId(), remove2.getDeviceModel());
        }
    }

    public void q(b bVar) {
        this.f532e = bVar;
    }

    private c() {
        this.f529b = new HashMap(2);
        this.f530c = new HashMap(2);
        this.f531d = new AtomicInteger(0);
        this.f533f = new HashSet();
        this.g = new HashMap();
    }
}
