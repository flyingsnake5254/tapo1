package com.tplink.iot.viewmodel.account;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class AccountChangeNameViewModel extends AndroidViewModel {
    private TCAccountRepository a;

    /* renamed from: b  reason: collision with root package name */
    private String f9799b = null;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<String> f9800c = new MediatorLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<Integer> f9801d = new MutableLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<TCAccountBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            if (tCAccountBean != null) {
                AccountChangeNameViewModel.this.f9799b = tCAccountBean.getCloudUserName();
                AccountChangeNameViewModel.this.f9800c.setValue(tCAccountBean.getNickName());
                return;
            }
            AccountChangeNameViewModel.this.f9800c.setValue("");
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            AccountChangeNameViewModel.this.f9801d.postValue(0);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AccountChangeNameViewModel.this.f9801d.postValue(1);
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            AccountChangeNameViewModel.this.f9801d.setValue(-1);
        }
    }

    public AccountChangeNameViewModel(@NonNull Application application) {
        super(application);
        TCAccountRepository tCAccountRepository = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
        this.a = tCAccountRepository;
        this.f9800c.addSource(tCAccountRepository.r(), new a());
    }

    public void i(String str) {
        if (TextUtils.isEmpty(this.f9799b)) {
            this.f9801d.setValue(1);
        } else {
            this.a.R(this.f9799b, str).C(io.reactivex.l0.a.c()).l(new d()).A(new b(), new c());
        }
    }

    public LiveData<String> j() {
        return this.f9800c;
    }

    public LiveData<Integer> k() {
        return this.f9801d;
    }
}
