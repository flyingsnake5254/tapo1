package com.tplink.iot.viewmodel.welcome;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.core.FragmentStateReceiver;
import com.tplink.iot.core.n;
import com.tplink.iot.core.p;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes3.dex */
public class StartupViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private TCProtocolRepository f11456b;

    /* renamed from: c  reason: collision with root package name */
    private TCAccountRepository f11457c;

    /* renamed from: d  reason: collision with root package name */
    private TPIoTClientManager f11458d;
    private long g;

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<Boolean> f11459e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<Integer> f11460f = new MutableLiveData<>();
    private boolean h = false;
    private boolean i = false;
    private o a = o.h0();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.g<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            p.i();
            FragmentStateReceiver.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.g<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            StartupViewModel.this.w(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.g<io.reactivex.e0.c> {
        c() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            StartupViewModel.this.g = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements io.reactivex.g0.g<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                StartupViewModel.this.f11460f.postValue(0);
                return;
            }
            StartupViewModel.this.l();
            StartupViewModel.this.f11460f.postValue(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudAccountV1Exception) {
                StartupViewModel.this.l();
                StartupViewModel.this.f11460f.postValue(1);
                return;
            }
            StartupViewModel.this.u();
            StartupViewModel.this.f11460f.setValue(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            StartupViewModel.this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.g<io.reactivex.e0.c> {
        g() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            StartupViewModel.this.f11460f.setValue(null);
        }
    }

    public StartupViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.f11456b = (TCProtocolRepository) b.d.b.f.b.a(f2, TCProtocolRepository.class);
        this.f11457c = (TCAccountRepository) b.d.b.f.b.a(f2, TCAccountRepository.class);
        this.f11458d = (TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f11457c.q();
    }

    private boolean o() {
        return com.tplink.iot.model.about.c.e();
    }

    private boolean r() {
        TCAccountBean u = this.f11457c.u();
        if (u == null || TextUtils.isEmpty(u.getCloudUserName())) {
            return false;
        }
        TCAccountBean P = this.a.P();
        return (!TextUtils.isEmpty(u.getPassword()) && P != null && !TextUtils.isEmpty(P.getPassword())) || !TextUtils.isEmpty(u.getToken());
    }

    private boolean s() {
        return b.d.w.f.b.j(getApplication()) && b.d.w.f.b.i(getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.f11457c.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Boolean bool) {
        this.g = System.currentTimeMillis() - this.g;
    }

    public LiveData<Integer> m() {
        return this.f11460f;
    }

    public LiveData<Boolean> n() {
        return this.f11459e;
    }

    @SuppressLint({"CheckResult"})
    public void p() {
        this.f11456b.e().F(new c()).E(new b()).L0(io.reactivex.l0.a.c()).G0(new a());
    }

    @SuppressLint({"CheckResult"})
    public void t(boolean z) {
        this.i = true;
        this.h = true;
        boolean o = o();
        boolean z2 = z ? this.f11457c.z() : this.f11457c.A();
        if (!b.d.w.f.b.h(getApplication())) {
            u();
            this.h = false;
            this.f11460f.setValue(2);
        } else if (!o || !z2) {
            l();
            this.h = false;
            this.f11460f.setValue(1);
        } else {
            this.f11458d.l4(this.f11457c.u(), n.a(), s()).L0(io.reactivex.l0.a.c()).F(new g()).y(new f()).H0(new d(), new e());
        }
    }

    public void v() {
        if (!this.h) {
            this.f11459e.setValue(Boolean.valueOf(r() && o()));
        } else if (!this.i) {
            this.f11459e.setValue(Boolean.FALSE);
        }
    }
}
