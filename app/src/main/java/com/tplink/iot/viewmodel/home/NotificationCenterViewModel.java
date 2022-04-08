package com.tplink.iot.viewmodel.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.iot.model.notification.NotificationCenterManager;
import io.reactivex.g0.g;
import java.util.List;

/* loaded from: classes2.dex */
public class NotificationCenterViewModel extends AndroidViewModel {
    private NotificationCenterManager a;

    /* renamed from: b  reason: collision with root package name */
    private MediatorLiveData<List<NotificationMsgBean>> f10087b = new MediatorLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<Boolean> f10088c = new MutableLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<List<NotificationMsgBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<NotificationMsgBean> list) {
            NotificationCenterViewModel.this.f10087b.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            NotificationCenterViewModel.this.f10088c.postValue(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterViewModel.this.f10088c.postValue(Boolean.TRUE);
        }
    }

    public NotificationCenterViewModel(@NonNull Application application) {
        super(application);
        NotificationCenterManager notificationCenterManager = (NotificationCenterManager) b.d.b.f.b.a(b.d.s.a.a.f(), NotificationCenterManager.class);
        this.a = notificationCenterManager;
        this.f10087b.addSource(notificationCenterManager.w(), new a());
    }

    public boolean h(List<NotificationMsgBean> list) {
        if (list != null && !list.isEmpty()) {
            for (NotificationMsgBean notificationMsgBean : list) {
                if (!notificationMsgBean.isReadFlag()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void i(List<NotificationMsgBean> list) {
        this.a.r(list).i(new c()).j(new b()).y();
    }

    public LiveData<Boolean> j() {
        return this.f10088c;
    }

    public void k() {
        this.a.t().F0();
    }

    public LiveData<List<NotificationMsgBean>> l() {
        return this.f10087b;
    }

    public LiveData<Boolean> m() {
        return this.a.y();
    }

    public void n(List<NotificationMsgBean> list) {
        this.a.M(list).y();
    }

    public void o(boolean z) {
        this.a.R(z);
    }
}
