package com.tplink.iot.viewmodel.authflip;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.b;
import com.tplink.libtpgoogleassistant.repository.OAuthCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.libwss.GoogleAssistantRepository;
import com.tplink.libtpnetwork.libwss.bean.result.GoogleAssistantLinkInfoResult;
import com.tplink.nbu.bean.iam.AppType;
import io.reactivex.e0.c;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class GoogleAssistantViewModel extends AndroidViewModel {
    private OAuthCloudRepository a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleAssistantRepository f9840b;

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<Boolean> f9841c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<Integer> f9842d = new SingleLiveEvent<>();

    /* loaded from: classes2.dex */
    class a implements g<c> {
        a() {
        }

        /* renamed from: a */
        public void accept(c cVar) throws Exception {
            GoogleAssistantViewModel.this.f9842d.postValue(-100);
        }
    }

    public GoogleAssistantViewModel(@NonNull Application application) {
        super(application);
        b f2 = b.d.s.a.a.f();
        this.a = (OAuthCloudRepository) b.d.b.f.b.c(f2).a(OAuthCloudRepository.class);
        this.f9840b = (GoogleAssistantRepository) b.d.b.f.b.c(f2).a(GoogleAssistantRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(GoogleAssistantLinkInfoResult googleAssistantLinkInfoResult) throws Exception {
        this.f9841c.postValue(googleAssistantLinkInfoResult.getLinked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(Throwable th) throws Exception {
        this.f9842d.postValue(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o() throws Exception {
        this.f9841c.postValue(Boolean.FALSE);
        this.f9842d.postValue(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(Throwable th) throws Exception {
        this.f9842d.postValue(-1);
    }

    public void g() {
        this.f9840b.h(AppType.TAPO).E(new g() { // from class: com.tplink.iot.viewmodel.authflip.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                GoogleAssistantViewModel.this.k((GoogleAssistantLinkInfoResult) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.viewmodel.authflip.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                GoogleAssistantViewModel.this.m((Throwable) obj);
            }
        }).F0();
    }

    public LiveData<Boolean> h() {
        return this.f9841c;
    }

    public SingleLiveEvent<Integer> i() {
        return this.f9842d;
    }

    public void s() {
        this.f9840b.i(AppType.TAPO).l(new a()).i(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.authflip.c
            @Override // io.reactivex.g0.a
            public final void run() {
                GoogleAssistantViewModel.this.o();
            }
        }).j(new g() { // from class: com.tplink.iot.viewmodel.authflip.b
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                GoogleAssistantViewModel.this.r((Throwable) obj);
            }
        }).y();
    }
}
