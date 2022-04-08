package com.tplink.iot.viewmodel.quicksetup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.u;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.g0.g;

/* loaded from: classes3.dex */
public class QuickSetupVerifyPwdViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<Boolean> f11196c = new MutableLiveData<>();
    private TCAccountRepository a = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);

    /* renamed from: b  reason: collision with root package name */
    private TPIoTClientManager f11195b = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g<CheckPasswordV1Result> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11197c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11198d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f11199f;

        a(String str, String str2, String str3) {
            this.f11197c = str;
            this.f11198d = str2;
            this.f11199f = str3;
        }

        /* renamed from: a */
        public void accept(CheckPasswordV1Result checkPasswordV1Result) throws Exception {
            if (checkPasswordV1Result.getErrorCode() == 0) {
                b.d.w.c.a.a("checkAccountPassword success");
                u.j(0, this.f11197c, this.f11198d, this.f11199f);
                return;
            }
            throw new CloudException(checkPasswordV1Result.getErrorCode(), checkPasswordV1Result.getErrorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11200c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11201d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f11202f;

        b(String str, String str2, String str3) {
            this.f11200c = str;
            this.f11201d = str2;
            this.f11202f = str3;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                int errCode = ((CloudException) th).getErrCode();
                if (errCode == -20601) {
                    b.d.w.c.a.a("checkAccountPassword cloud incorrect logout");
                    QuickSetupVerifyPwdViewModel.this.j();
                    u.e(errCode, this.f11200c, this.f11201d, this.f11202f);
                    return;
                }
                b.d.w.c.a.a("checkAccountPassword cloud other error");
                u.f(errCode, this.f11200c, this.f11201d, this.f11202f);
                return;
            }
            b.d.w.c.a.a("checkAccountPassword network other error");
            u.f(11, this.f11200c, this.f11201d, this.f11202f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            QuickSetupVerifyPwdViewModel.this.f11196c.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            QuickSetupVerifyPwdViewModel.this.f11196c.postValue(null);
        }
    }

    public QuickSetupVerifyPwdViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint({"CheckResult"})
    private void h(String str, String str2, String str3) {
        this.a.p(str2, str3).L0(io.reactivex.l0.a.c()).H0(new a(str, str2, str3), new b(str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f11195b.d3().C(io.reactivex.l0.a.c()).l(new d()).h(new c()).y();
    }

    public MutableLiveData<Boolean> i() {
        return this.f11196c;
    }

    public void k() {
        String str;
        String str2;
        String str3;
        b.d.w.c.a.a("verify cloud");
        String str4 = "";
        if (b.d.s.a.a.f() == null || b.d.s.a.a.f().c() == null) {
            str3 = str4;
            str2 = str3;
            str = str2;
        } else {
            TCAccountBean c2 = b.d.s.a.a.f().c();
            if (c2 == null || c2.getCloudUserName() == null) {
                str2 = str4;
            } else {
                str2 = c2.getCloudUserName();
                b.d.w.c.a.a("username=" + str2);
            }
            if (!(c2 == null || c2.getEmail() == null)) {
                String email = c2.getEmail();
                b.d.w.c.a.a("email=" + email);
            }
            if (c2 == null || c2.getAccountId() == null) {
                str = str4;
            } else {
                str = c2.getAccountId();
                b.d.w.c.a.a("accountId=" + str);
            }
            if (c2 == null || c2.getPassword() == null) {
                str3 = str4;
            } else {
                str3 = c2.getPassword();
                b.d.w.c.a.a("password=" + str3);
            }
        }
        b.d.w.c.a.a("verify cloud info");
        if (str2 == null) {
            str2 = str4;
        }
        if (str == null) {
            str = str4;
        }
        if (str3 != null) {
            str4 = str3;
        }
        boolean w2 = this.f11195b.w2();
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            if (w2) {
                u.i(0, str, str2, str4);
            } else {
                u.h(0, str, str2, str4);
            }
        } else if (w2) {
            h(str, str2, str4);
        }
    }
}
