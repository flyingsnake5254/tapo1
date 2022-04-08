package com.tplink.iot.viewmodel.account;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class AccountPasswordVerifyViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private MutableLiveData<i<CheckPasswordV1Result>> f9824b = new MutableLiveData<>();
    private TCAccountRepository a = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);

    /* loaded from: classes2.dex */
    class a implements g<CheckPasswordV1Result> {
        a() {
        }

        /* renamed from: a */
        public void accept(CheckPasswordV1Result checkPasswordV1Result) throws Exception {
            AccountPasswordVerifyViewModel.this.f9824b.postValue(new i(0, checkPasswordV1Result));
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AccountPasswordVerifyViewModel.this.f9824b.postValue(new i(1, null));
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<io.reactivex.e0.c> {
        c() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            AccountPasswordVerifyViewModel.this.f9824b.setValue(null);
        }
    }

    public AccountPasswordVerifyViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint({"CheckResult"})
    public void g(String str) {
        TCAccountRepository tCAccountRepository = this.a;
        tCAccountRepository.p(tCAccountRepository.u().getCloudUserName(), str).L0(io.reactivex.l0.a.c()).F(new c()).H0(new a(), new b());
    }

    public String h() {
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        String email = (f2 == null || f2.c() == null) ? "" : f2.c().getEmail();
        return b.d.w.h.b.c(email) ? email : "";
    }

    public LiveData<i<CheckPasswordV1Result>> i() {
        return this.f9824b;
    }
}
