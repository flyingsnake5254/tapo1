package com.tplink.iot.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.s;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.viewmodel.home.r;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.List;

/* loaded from: classes.dex */
public class MeViewModel extends AndroidViewModel {
    private TCAccountRepository a;

    /* renamed from: b  reason: collision with root package name */
    private TPIoTClientManager f9795b;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<Boolean> f9796c = new MediatorLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<Boolean> f9797d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<Boolean> f9798e = new MediatorLiveData<>();

    /* loaded from: classes.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            MeViewModel.this.f9796c.postValue(bool);
        }
    }

    /* loaded from: classes.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            MeViewModel.this.f9797d.postValue(bool);
        }
    }

    /* loaded from: classes.dex */
    class c implements Observer<List<ALCameraDevice>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ALCameraDevice> list) {
            if (list == null || list.isEmpty()) {
                MeViewModel.this.f9798e.postValue(Boolean.FALSE);
            } else {
                MeViewModel.this.f9798e.postValue(Boolean.TRUE);
            }
        }
    }

    public MeViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.a = (TCAccountRepository) b.d.b.f.b.a(f2, TCAccountRepository.class);
        this.f9795b = (TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class);
        this.f9796c.addSource(((TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class)).o2(), new a());
        this.f9797d.addSource(r.g().e(), new b());
        this.f9798e.addSource(this.f9795b.M1(), new c());
    }

    public void i() {
        this.f9795b.D1();
    }

    public MediatorLiveData<Boolean> j() {
        return this.f9797d;
    }

    public MediatorLiveData<Boolean> k() {
        return this.f9798e;
    }

    public LiveData<TCAccountBean> l() {
        return this.a.r();
    }

    public MediatorLiveData<Boolean> m() {
        return this.f9796c;
    }

    public boolean n() {
        return s.b(this.f9795b.C1().getValue());
    }

    public void o(boolean z) {
        com.tplink.cloud.context.b f2;
        if (z && (f2 = b.d.s.a.a.f()) != null && f2.c() != null) {
            String accountId = f2.c().getAccountId();
            if (!TextUtils.isEmpty(accountId) && !o.h0().o0(accountId)) {
                o.h0().l1(accountId);
                w.G();
            }
        }
    }
}
