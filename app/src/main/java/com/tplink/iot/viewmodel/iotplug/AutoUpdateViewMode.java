package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.IoTNetwork.util.c;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.e0.b;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import io.reactivex.q;

/* loaded from: classes2.dex */
public class AutoUpdateViewMode extends AndroidViewModel {
    private AbstractThingRepository a;

    /* renamed from: b  reason: collision with root package name */
    private AbstractSubThingRepository f10298b;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<AutoUpdateBean> f10299c = new MediatorLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private SingleLiveEvent<Integer> f10300d = new SingleLiveEvent<>();

    /* renamed from: e  reason: collision with root package name */
    private SingleLiveEvent<Boolean> f10301e = new SingleLiveEvent<>();

    /* renamed from: f  reason: collision with root package name */
    private b f10302f = new b();
    public AutoUpdateBean g;

    public AutoUpdateViewMode(@NonNull Application application, ThingContext thingContext) {
        super(application);
        ThingBaseRepository a = c.a(thingContext);
        if (a instanceof AbstractThingRepository) {
            this.a = (AbstractThingRepository) a;
        } else if (a instanceof AbstractSubThingRepository) {
            this.f10298b = (AbstractSubThingRepository) a;
        } else {
            this.a = (AbstractThingRepository) e.a(thingContext, PlugRepository.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(io.reactivex.e0.c cVar) throws Exception {
        this.f10301e.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m() throws Exception {
        this.f10301e.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(AutoUpdateBean autoUpdateBean) throws Exception {
        this.g = autoUpdateBean;
        this.f10299c.postValue(autoUpdateBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(io.reactivex.e0.c cVar) throws Exception {
        this.f10301e.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u() throws Exception {
        this.f10301e.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() throws Exception {
        this.f10300d.postValue(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(Throwable th) throws Exception {
        this.f10300d.postValue(-1);
    }

    public void f() {
        q<AutoUpdateBean> qVar;
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            qVar = abstractThingRepository.E1();
        } else {
            AbstractSubThingRepository abstractSubThingRepository = this.f10298b;
            if (abstractSubThingRepository != null) {
                qVar = abstractSubThingRepository.o1();
            } else {
                qVar = q.I();
            }
        }
        this.f10302f.b(qVar.F(new g() { // from class: com.tplink.iot.viewmodel.iotplug.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AutoUpdateViewMode.this.k((io.reactivex.e0.c) obj);
            }
        }).y(new a() { // from class: com.tplink.iot.viewmodel.iotplug.b
            @Override // io.reactivex.g0.a
            public final void run() {
                AutoUpdateViewMode.this.m();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.iotplug.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AutoUpdateViewMode.this.o((AutoUpdateBean) obj);
            }
        }, g.f10344c));
    }

    public LiveData<AutoUpdateBean> g() {
        return this.f10299c;
    }

    public SingleLiveEvent<Boolean> h() {
        return this.f10301e;
    }

    public SingleLiveEvent<Integer> i() {
        return this.f10300d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f10302f.dispose();
    }

    public void z(boolean z, int i) {
        io.reactivex.a aVar;
        AutoUpdateBean autoUpdateBean = new AutoUpdateBean(z, i, 120);
        AbstractThingRepository abstractThingRepository = this.a;
        if (abstractThingRepository != null) {
            aVar = abstractThingRepository.S4(autoUpdateBean);
        } else {
            AbstractSubThingRepository abstractSubThingRepository = this.f10298b;
            if (abstractSubThingRepository != null) {
                aVar = abstractSubThingRepository.b4(autoUpdateBean);
            } else {
                aVar = io.reactivex.a.e();
            }
        }
        this.f10302f.b(aVar.r(io.reactivex.d0.b.a.a()).l(new g() { // from class: com.tplink.iot.viewmodel.iotplug.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AutoUpdateViewMode.this.s((io.reactivex.e0.c) obj);
            }
        }).h(new a() { // from class: com.tplink.iot.viewmodel.iotplug.e
            @Override // io.reactivex.g0.a
            public final void run() {
                AutoUpdateViewMode.this.u();
            }
        }).A(new a() { // from class: com.tplink.iot.viewmodel.iotplug.f
            @Override // io.reactivex.g0.a
            public final void run() {
                AutoUpdateViewMode.this.w();
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.iotplug.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AutoUpdateViewMode.this.y((Throwable) obj);
            }
        }));
    }
}
