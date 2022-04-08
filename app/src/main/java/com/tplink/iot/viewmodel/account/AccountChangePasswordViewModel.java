package com.tplink.iot.viewmodel.account;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.core.n;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class AccountChangePasswordViewModel extends AndroidViewModel {
    private TCAccountRepository a;

    /* renamed from: b  reason: collision with root package name */
    private String f9804b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f9805c = null;

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<Integer> f9806d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private io.reactivex.e0.c f9807e = null;

    /* loaded from: classes2.dex */
    class a implements Observer<TCAccountBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            if (tCAccountBean != null) {
                AccountChangePasswordViewModel.this.f9804b = tCAccountBean.getCloudUserName();
                AccountChangePasswordViewModel.this.f9805c = tCAccountBean.getPassword();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* loaded from: classes2.dex */
        class a implements io.reactivex.g0.a {
            a() {
            }

            @Override // io.reactivex.g0.a
            public void run() throws Exception {
                AccountChangePasswordViewModel.this.n();
            }
        }

        b(String str) {
            this.a = str;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            AccountChangePasswordViewModel.this.f9806d.postValue(0);
            AccountChangePasswordViewModel.this.a.E(AccountChangePasswordViewModel.this.f9804b, this.a, "TP-Link_Tapo_Android", n.a, n.f6222b, n.f6223c, false).L0(io.reactivex.l0.a.c()).z(new a()).F0();
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AccountChangePasswordViewModel.this.f9806d.postValue(-1);
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            AccountChangePasswordViewModel.this.f9806d.setValue(null);
        }
    }

    public AccountChangePasswordViewModel(@NonNull Application application) {
        super(application);
        TCAccountRepository tCAccountRepository = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
        this.a = tCAccountRepository;
        this.f9806d.addSource(tCAccountRepository.r(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ((TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).e4();
    }

    public LiveData<Integer> l() {
        return this.f9806d;
    }

    public void m(String str) {
        this.f9807e = this.a.K(this.f9804b, this.f9805c, str).C(io.reactivex.l0.a.c()).l(new d()).A(new b(str), new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        io.reactivex.e0.c cVar = this.f9807e;
        if (cVar != null) {
            cVar.dispose();
        }
        super.onCleared();
    }
}
