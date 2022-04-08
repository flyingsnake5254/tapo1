package com.tplink.iot.viewmodel.billing;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.s.a.a;
import com.android.billingclient.api.Purchase;
import com.google.gson.Gson;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iab.beans.PurchaseParams;
import com.tplink.iab.beans.SubscriptionState;
import com.tplink.iab.beans.WebsiteData;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import com.tplink.iot.model.billing.BillingManager;
import com.tplink.iot.model.billing.g0;
import com.tplink.iot.model.billing.h0;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class BillingViewModel extends AndroidViewModel {
    private static final String a = "BillingViewModel";

    /* renamed from: d  reason: collision with root package name */
    private BillingManager f9849d;
    private Purchase h;
    private String i;
    private boolean j;
    private String k;

    /* renamed from: b  reason: collision with root package name */
    private final Gson f9847b = new Gson();

    /* renamed from: c  reason: collision with root package name */
    private b f9848c = new b();

    /* renamed from: e  reason: collision with root package name */
    private final MediatorLiveData<String> f9850e = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f9851f = new MutableLiveData<>();
    private final MutableLiveData<Integer> g = new MutableLiveData<>();

    public BillingViewModel(@NonNull Application application) {
        super(application);
        v(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ t B(Purchase purchase, Integer num) throws Exception {
        if (num.intValue() == 0) {
            return p0(purchase, null);
        }
        return q.f0(num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean C(Purchase purchase) throws Exception {
        return !purchase.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer F(Integer num, Integer num2) throws Exception {
        return num.intValue() >= num2.intValue() ? num : num2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(boolean z, c cVar) throws Exception {
        this.f9848c.b(cVar);
        if (!z) {
            this.f9851f.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(boolean z) throws Exception {
        if (!z) {
            this.f9851f.postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(boolean z, Integer num) throws Exception {
        if (num.intValue() != -300) {
            this.f9849d.y0();
        }
        if (!z) {
            this.g.postValue(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ t N(final h0 h0Var) throws Exception {
        return this.f9849d.I0(h0Var.f8044b, h0Var.f8045c, h0Var.f8046d, h0Var.a).E(new g() { // from class: com.tplink.iot.viewmodel.billing.t
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VerifyReceiptResult verifyReceiptResult = (VerifyReceiptResult) obj;
                g0.c(h0.this);
            }
        }).g0(y.f9880c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(List list) {
        if (list == null) {
            this.f9850e.postValue(null);
            return;
        }
        WebsiteData websiteData = new WebsiteData();
        websiteData.setProductList(list);
        this.f9850e.postValue(String.format("javascript:appApi.getProductList('%s')", this.f9847b.u(websiteData)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void S(h0 h0Var, VerifyReceiptResult verifyReceiptResult) throws Exception {
        g0.c(h0Var);
        if (verifyReceiptResult.getStatus() == 0) {
            this.k = verifyReceiptResult.getOrderId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public /* synthetic */ void V(c cVar) throws Exception {
        this.j = true;
        this.f9851f.postValue(Boolean.TRUE);
        this.f9848c.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X() throws Exception {
        this.j = false;
        this.f9851f.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z(c cVar) throws Exception {
        this.j = true;
        this.f9851f.postValue(Boolean.TRUE);
        this.f9848c.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0() throws Exception {
        this.j = false;
        this.f9851f.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t c0(Integer num) throws Exception {
        if (num.intValue() == 0) {
            return q.f0(100);
        }
        return q.f0(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ h0 e0(Purchase purchase) throws Exception {
        this.i = purchase.a();
        TCAccountBean c2 = a.f().c();
        h0 h0Var = new h0(purchase.d(), c2.getAccountId(), purchase.c(), purchase.f());
        g0.f(h0Var);
        return h0Var;
    }

    private q<Integer> f(final Purchase purchase) {
        return this.f9849d.f(purchase).F(new g() { // from class: com.tplink.iot.viewmodel.billing.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.x(purchase, (c) obj);
            }
        }).g0(e.f9856c).q0(Integer.valueOf((int) SubscriptionState.ACKNOWLEDGEMENT_ERROR)).E(k.f9862c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ t g0(final h0 h0Var) throws Exception {
        return this.f9849d.I0(h0Var.f8044b, h0Var.f8045c, h0Var.f8046d, h0Var.a).E(new g() { // from class: com.tplink.iot.viewmodel.billing.u
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.S(h0Var, (VerifyReceiptResult) obj);
            }
        }).g0(y.f9880c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public q<Integer> D(final Purchase purchase, boolean z) {
        return f(purchase).N(new j() { // from class: com.tplink.iot.viewmodel.billing.w
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.B(purchase, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ Integer i0(Integer num) throws Exception {
        w.F(num.toString());
        if (num.intValue() == 0) {
            this.i = null;
            return 0;
        }
        this.k = null;
        return -200;
    }

    private void i(List<Purchase> list, final boolean z) {
        q.Y(list).L(s.f9871c).N(new j() { // from class: com.tplink.iot.viewmodel.billing.p
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.E(z, (Purchase) obj);
            }
        }).r0(h.f9859c).f(new g() { // from class: com.tplink.iot.viewmodel.billing.n
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.H(z, (c) obj);
            }
        }).d(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.billing.r
            @Override // io.reactivex.g0.a
            public final void run() {
                BillingViewModel.this.J(z);
            }
        }).g(new g() { // from class: com.tplink.iot.viewmodel.billing.x
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.L(z, (Integer) obj);
            }
        }).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ Integer k0(Throwable th) throws Exception {
        this.k = null;
        return -200;
    }

    private void l() {
        b.d.w.c.a.c(a, "verifyDBReceipts");
        q.Y(g0.h()).N(new j() { // from class: com.tplink.iot.viewmodel.billing.g
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.N((h0) obj);
            }
        }).z(b.a).C(z.f9881c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.l0.a.c()).F0();
    }

    private q<Integer> o0(final Purchase purchase) {
        return q.X(new Callable() { // from class: com.tplink.iot.viewmodel.billing.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BillingViewModel.this.e0(purchase);
            }
        }).N(new j() { // from class: com.tplink.iot.viewmodel.billing.f
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.g0((h0) obj);
            }
        }).g0(new j() { // from class: com.tplink.iot.viewmodel.billing.c
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.i0((Integer) obj);
            }
        }).p0(new j() { // from class: com.tplink.iot.viewmodel.billing.i
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingViewModel.this.k0((Throwable) obj);
            }
        });
    }

    private q<Integer> p0(Purchase purchase, String str) {
        return o0(purchase).N(j.f9861c);
    }

    private void v(@NonNull Application application) {
        BillingManager billingManager = new BillingManager(application, (com.tplink.iot.c.c.a) a.f());
        this.f9849d = billingManager;
        this.f9850e.addSource(billingManager.i(), new Observer() { // from class: com.tplink.iot.viewmodel.billing.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingViewModel.this.Q((List) obj);
            }
        });
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(Purchase purchase, c cVar) throws Exception {
        this.h = purchase;
    }

    public void h(List<Purchase> list) {
        i(list, false);
    }

    public void j(List<Purchase> list) {
        i(list, true);
    }

    public void k(@NonNull Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f9849d.e(activity, ((PurchaseParams) this.f9847b.l(str, PurchaseParams.class)).getProductId());
        }
    }

    @UiThread
    public void l0() {
        this.f9849d.E0();
    }

    public LifecycleObserver m() {
        return this.f9849d;
    }

    public q<Integer> m0() {
        q<Integer> y = D(this.h, false).F(new g() { // from class: com.tplink.iot.viewmodel.billing.v
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.V((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.billing.d
            @Override // io.reactivex.g0.a
            public final void run() {
                BillingViewModel.this.X();
            }
        });
        MutableLiveData<Integer> mutableLiveData = this.g;
        mutableLiveData.getClass();
        return y.E(new a0(mutableLiveData));
    }

    public LiveData<Boolean> n() {
        return this.f9851f;
    }

    public q<Integer> n0() {
        q<Integer> y = p0(this.h, null).F(new g() { // from class: com.tplink.iot.viewmodel.billing.m
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingViewModel.this.Z((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.billing.l
            @Override // io.reactivex.g0.a
            public final void run() {
                BillingViewModel.this.b0();
            }
        });
        MutableLiveData<Integer> mutableLiveData = this.g;
        mutableLiveData.getClass();
        return y.E(new a0(mutableLiveData));
    }

    public String o() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = "";
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        if (!this.f9848c.isDisposed()) {
            this.f9848c.d();
        }
    }

    public LiveData<Integer> p() {
        return this.f9849d.k();
    }

    public LiveData<List<Purchase>> r() {
        return this.f9849d.l();
    }

    public LiveData<List<Purchase>> s() {
        return this.f9849d.m();
    }

    public LiveData<Integer> t() {
        return this.g;
    }

    public LiveData<String> u() {
        return this.f9850e;
    }
}
