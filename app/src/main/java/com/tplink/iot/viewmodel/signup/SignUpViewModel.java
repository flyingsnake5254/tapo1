package com.tplink.iot.viewmodel.signup;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.define.CloudException;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import com.tplink.libtpnetwork.Utils.x;
import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SignUpViewModel extends AndroidViewModel {
    private TCAccountRepository a;

    /* renamed from: b  reason: collision with root package name */
    private TCProtocolRepository f11385b;

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<Boolean> f11386c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<CloudException> f11387d = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            SignUpViewModel.this.f11387d.postValue(new CloudException(0, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                SignUpViewModel.this.f11387d.postValue((CloudException) th);
            } else {
                SignUpViewModel.this.f11387d.postValue(new CloudException(-1, ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements g<io.reactivex.e0.c> {
        c() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            SignUpViewModel.this.f11387d.setValue(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements j<Integer, e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f11390c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11391d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f11392f;
        final /* synthetic */ String q;

        d(boolean z, String str, String str2, String str3) {
            this.f11390c = z;
            this.f11391d = str;
            this.f11392f = str2;
            this.q = str3;
        }

        /* renamed from: a */
        public e apply(Integer num) throws Exception {
            if (num.intValue() == EnumAccountStatus.ACCOUNT_STATUS_NORMAL.getValue()) {
                return io.reactivex.a.m(new CloudException(16, "ERR_ACCOUNT_REGISTERED"));
            }
            if (num.intValue() == EnumAccountStatus.ACCOUNT_STATUS_LOCKED.getValue()) {
                return io.reactivex.a.m(new CloudException(17, "ERR_ACCOUNT_LOCKED"));
            }
            if (num.intValue() == EnumAccountStatus.ACCOUNT_STATUS_UNACTIVATED.getValue()) {
                return io.reactivex.a.m(new CloudException(19, "MSG_ERR_ACCOUNT_UNACTIVATED"));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("GlobalMarketing", Boolean.valueOf(this.f11390c));
            TCAccountRepository tCAccountRepository = SignUpViewModel.this.a;
            String str = this.f11391d;
            return tCAccountRepository.M(str, b.d.w.h.b.b(str), this.f11392f, x.d(Locale.getDefault()), this.q, "NBU", hashMap);
        }
    }

    public SignUpViewModel(@NonNull Application application) {
        super(application);
        b.d.b.d.b.b c2 = b.d.b.f.b.c(b.d.s.a.a.f());
        this.a = (TCAccountRepository) c2.a(TCAccountRepository.class);
        this.f11385b = (TCProtocolRepository) c2.a(TCProtocolRepository.class);
    }

    public LiveData<Boolean> h() {
        return this.f11386c;
    }

    public LiveData<CloudException> i() {
        return this.f11387d;
    }

    @SuppressLint({"CheckResult"})
    public void j(String str, String str2, String str3, boolean z) {
        this.a.t(str).R(new d(z, str, str2, str3)).C(io.reactivex.l0.a.c()).l(new c()).A(new a(), new b());
    }

    public void k() {
        boolean f2 = this.f11385b.f();
        if (!f2) {
            this.f11385b.e().L0(io.reactivex.l0.a.c()).F0();
        }
        this.f11386c.setValue(Boolean.valueOf(f2));
    }
}
