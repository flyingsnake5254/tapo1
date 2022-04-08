package com.tplink.iot.viewmodel.authflip;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.core.n;
import com.tplink.iot.thirdpartlink.ThirdPartLinkNetworkType;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpgoogleassistant.bean.result.AuthCodeResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthResult;
import com.tplink.libtpgoogleassistant.repository.OAuthCloudRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.x;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AppFlipAuthViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private OAuthCloudRepository f9828b;
    private String g;
    private String h;
    private ThirdPartLinkNetworkType i;

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<String> f9829c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<i<LoginV1Result>>> f9830d = new SingleLiveEvent<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f9831e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f9832f = new MutableLiveData<>();
    private TCAccountRepository a = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);

    /* loaded from: classes2.dex */
    class a implements io.reactivex.g0.g<AuthResult<AuthCodeResult>> {
        a() {
        }

        /* renamed from: a */
        public void accept(AuthResult<AuthCodeResult> authResult) throws Exception {
            b.d.w.c.a.e("getAuthCode", "result=" + com.tplink.libtpnetwork.Utils.i.f(authResult));
            if (authResult == null) {
                AppFlipAuthViewModel.this.f9829c.postValue(null);
            } else if (authResult.getErrorCode() == 0) {
                AuthCodeResult result = authResult.getResult();
                if (result != null) {
                    AppFlipAuthViewModel.this.f9829c.postValue(result.getAuthCode());
                } else {
                    AppFlipAuthViewModel.this.f9829c.postValue(null);
                }
            } else {
                AppFlipAuthViewModel.this.f9829c.postValue(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            th.printStackTrace();
            b.d.w.c.a.e("getAuthCode", "result=error");
            AppFlipAuthViewModel.this.f9829c.postValue(null);
        }
    }

    /* loaded from: classes2.dex */
    class c implements io.reactivex.g0.g<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            i iVar;
            if (bool.booleanValue()) {
                iVar = new i(0, new LoginV1Result());
            } else {
                AppFlipAuthViewModel.this.l();
                iVar = new i(1, null);
            }
            AppFlipAuthViewModel.this.f9830d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(iVar));
        }
    }

    /* loaded from: classes2.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            i iVar;
            AppFlipAuthViewModel.this.l();
            if (th instanceof CloudAccountV1Exception) {
                iVar = new i(0, ((CloudAccountV1Exception) th).getLoginV1Result());
            } else {
                iVar = new i(1, null);
            }
            AppFlipAuthViewModel.this.f9830d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(iVar));
        }
    }

    /* loaded from: classes2.dex */
    class e implements io.reactivex.g0.g<Integer> {
        e() {
        }

        /* renamed from: a */
        public void accept(Integer num) throws Exception {
            int intValue = num.intValue();
            int i = 16;
            if (intValue == 0) {
                i = 18;
            } else if (intValue != 1) {
                if (intValue == 2) {
                    i = 17;
                } else if (intValue == 3) {
                    i = 19;
                }
            }
            AppFlipAuthViewModel.this.f9831e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(i)));
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                AppFlipAuthViewModel.this.f9831e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(((CloudException) th).getErrCode())));
            } else {
                AppFlipAuthViewModel.this.f9831e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(-1));
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            AppFlipAuthViewModel.this.f9832f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(0));
        }
    }

    /* loaded from: classes2.dex */
    class h implements io.reactivex.g0.g<Throwable> {
        h() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                AppFlipAuthViewModel.this.f9832f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(((CloudException) th).getErrCode())));
            } else {
                AppFlipAuthViewModel.this.f9832f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(-1));
            }
        }
    }

    public AppFlipAuthViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.f9828b = (OAuthCloudRepository) b.d.b.f.b.c(f2).a(OAuthCloudRepository.class);
        A(r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.a.q();
    }

    public void A(String str) {
        this.h = str;
    }

    public void B(String str) {
        this.g = str;
    }

    @SuppressLint({"CheckResult"})
    public void k(String str) {
        if (!this.a.y()) {
            this.f9831e.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(-99));
        } else {
            this.a.t(str).L0(io.reactivex.l0.a.c()).H0(new e(), new f());
        }
    }

    public String m() {
        TCAccountBean c2;
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        if (f2 == null || (c2 = f2.c()) == null) {
            return null;
        }
        return c2.getToken();
    }

    @SuppressLint({"CheckResult"})
    public void n(AuthCodeParams authCodeParams) {
        this.f9828b.d(authCodeParams).H0(new a(), new b());
    }

    public MutableLiveData<String> o() {
        return this.f9829c;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> p() {
        return this.f9831e;
    }

    public String r() {
        TCAccountBean c2;
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        if (f2 == null || (c2 = f2.c()) == null) {
            return null;
        }
        return c2.getCloudUserName();
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<i<LoginV1Result>>> s() {
        return this.f9830d;
    }

    public ThirdPartLinkNetworkType t() {
        return this.i;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> u() {
        return this.f9832f;
    }

    public String v() {
        return !TextUtils.isEmpty(this.h) ? this.h : "";
    }

    public String w() {
        return this.g;
    }

    @SuppressLint({"CheckResult"})
    public void x(String str, String str2) {
        TCAccountBean tCAccountBean = new TCAccountBean(str, str2);
        b.d.s.a.b.a a2 = n.a();
        this.a.C(tCAccountBean, a2.b(), a2.g(), a2.f(), a2.c(), false).L0(io.reactivex.l0.a.c()).H0(new c(), new d());
    }

    @SuppressLint({"CheckResult"})
    public void y(String str) {
        this.a.v(str, x.d(Locale.getDefault())).C(io.reactivex.l0.a.c()).A(new g(), new h());
    }

    public void z(ThirdPartLinkNetworkType thirdPartLinkNetworkType) {
        this.i = thirdPartLinkNetworkType;
    }
}
