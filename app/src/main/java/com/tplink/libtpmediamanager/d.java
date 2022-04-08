package com.tplink.libtpmediamanager;

import b.d.u.l;
import b.d.u.m;
import b.d.u.n;
import b.d.u.o;
import b.d.v.b.c;
import com.tplink.libtpstreampreconnect.bean.TalkMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DoubleTalkClientManager.java */
/* loaded from: classes3.dex */
public class d implements c, n {
    private Map<String, m> a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f12567b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<c>> f12568c;

    /* renamed from: d  reason: collision with root package name */
    private final b.d.d.g.a f12569d;

    /* compiled from: DoubleTalkClientManager.java */
    /* loaded from: classes3.dex */
    class a implements b.d.d.g.a {
        a() {
        }

        @Override // b.d.d.g.a
        public void a(String str, byte[] bArr, int i) {
            d.this.i(str, bArr, i);
        }
    }

    /* compiled from: DoubleTalkClientManager.java */
    /* loaded from: classes3.dex */
    private static class b {
        private static final d a = new d(null);
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    public static d h() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, byte[] bArr, int i) {
        Long l;
        if (str != null && (l = this.f12567b.get(str)) != null && l.longValue() != 0) {
            m mVar = this.a.get(str);
            if (mVar != null) {
                mVar.b(l.longValue(), bArr);
            }
            this.f12567b.put(str, Long.valueOf(l.longValue() + i));
        }
    }

    @Override // b.d.u.n
    public void a(String str, long j) {
        this.f12567b.put(str, Long.valueOf(j));
    }

    @Override // b.d.u.n
    public void b(String str, long j) {
        Long l = this.f12567b.get(str);
        if (l == null || l.longValue() == 0) {
            this.f12567b.put(str, Long.valueOf(j));
        }
    }

    public void d(String str, c cVar) {
        if (str != null) {
            List<c> list = null;
            if (this.f12568c.containsKey(str)) {
                list = this.f12568c.get(str);
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.contains(cVar)) {
                list.add(cVar);
                this.f12568c.put(str, list);
            }
        }
    }

    public void e() {
        for (Map.Entry<String, m> entry : this.a.entrySet()) {
            entry.getValue().a();
        }
        this.a.clear();
        for (Map.Entry<String, List<c>> entry2 : this.f12568c.entrySet()) {
            for (c cVar : entry2.getValue()) {
                cVar.onDoubleTalkClose(entry2.getKey());
            }
        }
        this.f12568c.clear();
        this.f12567b.clear();
    }

    public void f(String str) {
        if (str != null) {
            m remove = this.a.remove(str);
            if (remove != null) {
                remove.a();
            }
            this.f12568c.remove(str);
            this.f12567b.remove(str);
        }
    }

    public m g(String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void j(String str, String str2) {
        m mVar;
        if (str != null && !this.a.containsKey(str)) {
            if (TalkMode.AEC.equals(str2)) {
                mVar = new l(str, str2);
                mVar.h(this);
            } else {
                mVar = new o(str, str2);
            }
            this.a.put(str, mVar);
            mVar.f(this);
            mVar.c();
        }
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkClose(String str) {
        if (str != null) {
            b.d.p.d.a("TTTT", "Manager onDoubleTalkClose");
            List<c> list = this.f12568c.get(str);
            if (list != null && list.size() > 0) {
                for (c cVar : list) {
                    cVar.onDoubleTalkClose(str);
                    b.d.p.d.a("TTTT", "callback onDoubleTalkClose");
                }
            }
            m remove = this.a.remove(str);
            if (remove != null) {
                remove.a();
            }
            this.f12568c.remove(str);
            this.f12567b.remove(str);
        }
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkCreateFailure(String str, int i) {
        if (str != null) {
            b.d.p.d.a("TTTT", "Manager onDoubleTalkCreateFailure");
            List<c> list = this.f12568c.get(str);
            if (list != null && list.size() > 0) {
                for (c cVar : list) {
                    cVar.onDoubleTalkCreateFailure(str, i);
                    b.d.p.d.a("TTTT", "callback onDoubleTalkCreateFailure");
                }
            }
            m remove = this.a.remove(str);
            if (remove != null) {
                remove.a();
            }
            this.f12568c.remove(str);
            this.f12567b.remove(str);
        }
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkCreateSuccess(String str) {
        List<c> list;
        if (!(str == null || (list = this.f12568c.get(str)) == null || list.size() <= 0)) {
            for (c cVar : list) {
                cVar.onDoubleTalkCreateSuccess(str);
            }
        }
    }

    @Override // b.d.v.b.c
    public void onDoubleTalkSendDataFailure(String str, int i, Exception exc) {
        if (str != null) {
            b.d.p.d.a("TTTT", "Manager onDoubleTalkCreateFailure");
            List<c> list = this.f12568c.get(str);
            if (list != null && list.size() > 0) {
                for (c cVar : list) {
                    cVar.onDoubleTalkSendDataFailure(str, i, exc);
                    b.d.p.d.a("TTTT", "callback onDoubleTalkCreateFailure");
                }
            }
            m remove = this.a.remove(str);
            if (remove != null) {
                remove.a();
            }
            this.f12568c.remove(str);
            this.f12567b.remove(str);
        }
    }

    private d() {
        a aVar = new a();
        this.f12569d = aVar;
        this.a = new ConcurrentHashMap();
        this.f12567b = new ConcurrentHashMap();
        this.f12568c = new HashMap(1);
        b.d.d.m.b.a().c(aVar);
    }
}
