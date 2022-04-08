package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.s;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.model.home.HomeCacheBean;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.f;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeCacheManager.java */
/* loaded from: classes2.dex */
public class r {
    private static String a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile r f10122b;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<f> f10123c = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<Boolean> f10125e = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private b f10124d = new b(b.d.s.a.a.f().c().getEmail());

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: HomeCacheManager.java */
    /* loaded from: classes2.dex */
    public static class b {
        private List<HomeCacheBean> a;

        /* renamed from: b  reason: collision with root package name */
        private List<HomeCacheBean> f10126b;

        /* renamed from: c  reason: collision with root package name */
        private List<HomeCacheBean> f10127c;

        /* renamed from: d  reason: collision with root package name */
        private List<HomeCacheBean> f10128d;

        /* renamed from: e  reason: collision with root package name */
        private List<HomeCacheBean> f10129e;

        /* renamed from: f  reason: collision with root package name */
        private List<HomeCacheBean> f10130f;
        private boolean g;
        private o h;

        /* JADX INFO: Access modifiers changed from: private */
        public f f(boolean z) {
            return new f(this.f10127c, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b j() {
            this.a.clear();
            this.f10126b.clear();
            if (s.b(this.f10127c)) {
                return this;
            }
            for (HomeCacheBean homeCacheBean : this.f10127c) {
                if (homeCacheBean.isFavorite()) {
                    this.a.add(homeCacheBean);
                } else {
                    this.f10126b.add(homeCacheBean);
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b k() {
            if (s.b(this.f10127c)) {
                this.h.k(r.a, "");
                return this;
            }
            this.h.k(r.a, i.h(this.f10127c));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b l(List<k> list) {
            if (s.b(list)) {
                this.h.k(r.a, "");
                return this;
            }
            this.f10127c.clear();
            for (k kVar : list) {
                if (kVar.k() != null) {
                    this.f10127c.add(kVar.k());
                }
            }
            this.h.k(r.a, i.h(this.f10127c));
            return this;
        }

        public b e() {
            this.g = true;
            this.f10128d = s.a(this.a);
            this.f10129e = s.a(this.f10126b);
            this.f10130f = s.a(this.f10127c);
            return this;
        }

        public b g(List<e> list) {
            if (s.b(list)) {
                return this;
            }
            if (s.b(this.f10127c)) {
                this.f10127c = new ArrayList();
            }
            this.f10127c.clear();
            for (int i = 0; i < list.size(); i++) {
                e eVar = list.get(i);
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    kVar.C(i);
                    if (kVar.k() != null) {
                        this.f10127c.add(kVar.k());
                    }
                }
            }
            return this;
        }

        public b h() {
            if (this.g) {
                this.g = false;
                this.a.clear();
                this.a.addAll(this.f10128d);
                this.f10126b.clear();
                this.f10126b.addAll(this.f10129e);
                this.f10127c.clear();
                this.f10127c.addAll(this.f10130f);
            }
            return this;
        }

        public b i(boolean z, String str) {
            for (HomeCacheBean homeCacheBean : this.f10127c) {
                if (TextUtils.equals(homeCacheBean.getDeviceIdMD5(), str)) {
                    homeCacheBean.setNewDevice(z);
                }
            }
            return this;
        }

        private b(String str) {
            this.a = new ArrayList();
            this.f10126b = new ArrayList();
            this.f10127c = new ArrayList();
            this.f10128d = new ArrayList();
            this.f10129e = new ArrayList();
            this.f10130f = new ArrayList();
            this.h = o.h0();
            String unused = r.a = "HOME_LIST" + str;
            this.f10127c = i.e(o.h0().f(r.a, ""), HomeCacheBean.class);
            j();
            b.d.w.c.a.d("get cache list-->" + o.h0().f(r.a, ""));
        }
    }

    private r() {
    }

    public static r g() {
        if (f10122b == null) {
            synchronized (r.class) {
                if (f10122b == null) {
                    f10122b = new r();
                }
            }
        }
        return f10122b;
    }

    public void c() {
        f10122b = null;
    }

    public MediatorLiveData<f> d() {
        return this.f10123c;
    }

    public MutableLiveData<Boolean> e() {
        return this.f10125e;
    }

    public void f() {
        this.f10123c.postValue(this.f10124d.f(false));
    }

    public void h() {
        this.f10123c.postValue(this.f10124d.f(true));
    }

    public void i(List<e> list, boolean z) {
        this.f10123c.postValue(this.f10124d.g(list).j().k().f(z));
    }

    public void j() {
        this.f10123c.postValue(this.f10124d.h().f(true));
    }

    public void k() {
        this.f10124d.e();
    }

    public void l(boolean z, String str) {
        this.f10124d.i(z, str).j().k();
        h();
    }

    public void m(boolean z, String str) {
        this.f10124d.i(z, str).j().k();
    }

    public void n(List<k> list) {
        this.f10124d.l(list).j();
    }

    public void o(List<k> list, boolean z) {
        this.f10123c.postValue(this.f10124d.l(list).j().f(z));
    }

    public void p(List<ShareDeviceResult> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            for (ShareDeviceResult shareDeviceResult : list) {
                if (!(shareDeviceResult.getExpired() == null || shareDeviceResult.getExpired().booleanValue())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        this.f10125e.postValue(Boolean.valueOf(z));
    }
}
