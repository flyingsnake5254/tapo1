package com.tplink.iot.Utils;

import android.text.TextUtils;
import b.d.n.i.b;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.libtpinappmessaging.model.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IACMsgFilter.java */
/* loaded from: classes2.dex */
public class p {
    private static final List<String> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static final b f5360b = new a();

    /* compiled from: IACMsgFilter.java */
    /* loaded from: classes2.dex */
    static class a implements b {
        a() {
        }

        @Override // b.d.n.i.b
        public boolean a(c cVar) {
            return cVar != null && p.a.contains(cVar.a());
        }
    }

    public static void b(List<String> list) {
        List<String> list2 = a;
        list2.clear();
        if (!s.b(list)) {
            list2.addAll(list);
        }
        g(list);
    }

    public static void c() {
        a.clear();
        b.d.n.f.b.l().c();
        g(null);
    }

    private static List<String> d() {
        String f2 = o.h0().f("sp_iac_last_account_filters", null);
        if (!TextUtils.isEmpty(f2)) {
            try {
                return i.e(f2, String.class);
            } catch (Exception unused) {
            }
        }
        return new ArrayList();
    }

    public static void e() {
        b.d.n.f.b.l().c();
        b.d.n.f.b.l().g(f5360b);
        b(d());
    }

    public static void f() {
        boolean c0 = o.h0().c0();
        ArrayList arrayList = new ArrayList();
        if (!c0) {
            arrayList.add("marketPromotion");
        }
        b(arrayList);
        UnsubscribeMsgParams unsubscribeMsgParams = new UnsubscribeMsgParams();
        unsubscribeMsgParams.setMsgTypes(arrayList);
        ((TCMessagePushRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCMessagePushRepository.class)).T(unsubscribeMsgParams).F0();
    }

    private static void g(List<String> list) {
        o.h0().k("sp_iac_last_account_filters", list == null ? null : i.h(list));
    }
}
