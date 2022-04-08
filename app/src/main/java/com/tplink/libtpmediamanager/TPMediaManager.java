package com.tplink.libtpmediamanager;

import b.d.d.b.a;
import b.d.d.b.c;
import b.d.d.b.e;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.g.d;
import com.tplink.libtpstreamclientmanager.TPStreamConnectionManager;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class TPMediaManager extends a {
    private final Map<String, ?> a = new ConcurrentHashMap();

    public TPMediaManager(c cVar) {
        super(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TPMediaDeviceContext tPMediaDeviceContext = (TPMediaDeviceContext) it.next();
            d.c(tPMediaDeviceContext);
            this.a.remove(tPMediaDeviceContext.getDeviceIdMd5());
        }
    }

    public q<Boolean> refreshDeviceList(List<TPMediaDevice> list) {
        return ((TPStreamConnectionManager) e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).refreshDeviceList(list).E(new g() { // from class: com.tplink.libtpmediamanager.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TPMediaManager.this.b((List) obj);
            }
        }).g0(b.f12565c);
    }
}
