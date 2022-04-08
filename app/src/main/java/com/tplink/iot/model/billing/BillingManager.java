package com.tplink.iot.model.billing;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.c;
import com.android.billingclient.api.e;
import com.android.billingclient.api.f;
import com.android.billingclient.api.h;
import com.android.billingclient.api.i;
import com.android.billingclient.api.k;
import com.android.billingclient.api.m;
import com.tplink.cloud.bean.account.result.CloudUserResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iab.SingleLiveEvent;
import com.tplink.iab.beans.BillingResponse;
import com.tplink.iab.beans.ProductDetails;
import com.tplink.iab.exception.BillingException;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.bean.billing.common.Product;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.NBUBillingRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.e0.b;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class BillingManager implements LifecycleObserver, k {

    /* renamed from: c  reason: collision with root package name */
    private final Context f8025c;

    /* renamed from: d  reason: collision with root package name */
    private c f8026d;

    /* renamed from: f  reason: collision with root package name */
    private NBUBillingRepository f8027f;
    private TCAccountRepository q;
    private long x;
    private final b y = new b();
    private final AtomicInteger z = new AtomicInteger();
    private final g<BillingResponse> p0 = io.reactivex.m0.b.n1().l1();
    private final SingleLiveEvent<Integer> p1 = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<Purchase>> p2 = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<Purchase>> p3 = new SingleLiveEvent<>();
    private final MutableLiveData<List<ProductDetails>> H3 = new MutableLiveData<>();
    private final ArrayList<Purchase> I3 = new ArrayList<>();
    private final ArrayList<String> J3 = new ArrayList<>();
    private final ArrayList<String> K3 = new ArrayList<>();
    private final HashMap<String, SkuDetails> L3 = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements e {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // com.android.billingclient.api.e
        public void a(com.android.billingclient.api.g gVar) {
            BillingResponse billingResponse = new BillingResponse(this.a);
            if (gVar == null) {
                billingResponse.setResponseCode(6);
            } else {
                billingResponse.setResponseCode(gVar.a());
            }
            BillingManager.this.p0.onNext(billingResponse);
        }

        @Override // com.android.billingclient.api.e
        public void b() {
        }
    }

    public BillingManager(@NonNull Context context, @NonNull com.tplink.iot.c.c.a aVar) {
        io.reactivex.h0.a.b.e(context, "Context can't be null");
        io.reactivex.h0.a.b.e(aVar, "NBUCloudContext can't be null");
        this.f8025c = context.getApplicationContext();
        this.f8027f = (NBUBillingRepository) b.d.b.f.b.c(aVar).a(NBUBillingRepository.class);
        this.q = (TCAccountRepository) b.d.b.f.b.a(aVar, TCAccountRepository.class);
    }

    private List<Purchase> A0(String str) {
        Purchase.a h = this.f8026d.h(str);
        if (h == null || h.c() != 0) {
            return null;
        }
        return h.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Throwable th) throws Exception {
        this.p1.postValue(1001);
    }

    private q<List<ProductDetails>> B0() throws BillingException {
        ArrayList arrayList = new ArrayList();
        if (!this.J3.isEmpty()) {
            arrayList.add(C0("inapp", this.J3));
        }
        if (!this.K3.isEmpty() && d()) {
            arrayList.add(C0("subs", this.K3));
        }
        if (!arrayList.isEmpty()) {
            return q.g1(arrayList, new j() { // from class: com.tplink.iot.model.billing.v
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return BillingManager.this.m0((Object[]) obj);
                }
            }).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.m
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    BillingManager.this.o0((io.reactivex.e0.c) obj);
                }
            });
        }
        throw new BillingException("Sku list can't be empty");
    }

    private q<List<SkuDetails>> C0(final String str, final List<String> list) {
        return G0().N(new j() { // from class: com.tplink.iot.model.billing.g
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.q0(str, list, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ t E(Purchase purchase, Boolean bool) throws Exception {
        final int incrementAndGet = this.z.incrementAndGet();
        this.f8026d.b(h.b().b(purchase.d()).a(), new i() { // from class: com.tplink.iot.model.billing.p
            @Override // com.android.billingclient.api.i
            public final void a(com.android.billingclient.api.g gVar, String str) {
                BillingManager.this.a0(incrementAndGet, gVar, str);
            }
        });
        return h(incrementAndGet).g0(r.f8060c).q0(Boolean.FALSE);
    }

    private void D0(Activity activity, SkuDetails skuDetails) {
        String l = skuDetails.l();
        if ("inapp".equals(l)) {
            p(activity, skuDetails);
        } else if ("subs".equals(l)) {
            Purchase n = n();
            if (n == null) {
                p(activity, skuDetails);
            } else {
                v(n, activity, skuDetails);
            }
        } else {
            this.p1.postValue(1004);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean F(int i, BillingResponse billingResponse) throws Exception {
        return billingResponse.getSn() == i;
    }

    @UiThread
    private q<Boolean> F0() {
        int incrementAndGet = this.z.incrementAndGet();
        this.f8026d.j(new a(incrementAndGet));
        return h(incrementAndGet).g0(b.f8031c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G(BillingResponse billingResponse) throws Exception {
        int responseCode = billingResponse.getResponseCode();
        if (responseCode != 0) {
            throw new BillingException("Post async request fail!", responseCode);
        }
    }

    @UiThread
    private q<Boolean> G0() {
        if (this.f8026d.e()) {
            return q.f0(Boolean.TRUE).L0(io.reactivex.d0.b.a.a());
        }
        return F0().L0(io.reactivex.d0.b.a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(io.reactivex.e0.c cVar) throws Exception {
        this.K3.clear();
        this.J3.clear();
    }

    private int H0(int i) {
        if (i == -2) {
            return 1002;
        }
        if (i == 4) {
            return 1004;
        }
        if (i == 7) {
            return 1005;
        }
        if (i != 0) {
            return i != 1 ? 1001 : 1003;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ t K(List list) throws Exception {
        return z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ t M(Boolean bool) throws Exception {
        return B0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void N(Throwable th) throws Exception {
        if (th instanceof BillingException) {
            w.z("-2");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void O() throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(SkuDetails skuDetails, String str, String str2, Activity activity, Boolean bool) throws Exception {
        f.a c2 = f.e().c(skuDetails);
        if (!(str == null || str2 == null)) {
            c2.b(str, str2);
        }
        this.f8026d.f(activity, c2.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void S(Activity activity, SkuDetails skuDetails, Purchase purchase, Integer num) throws Exception {
        int intValue = num.intValue();
        if (intValue == -10107) {
            p(activity, skuDetails);
        } else if (intValue == -10102) {
            this.p1.postValue(Integer.valueOf((int) PointerIconCompat.TYPE_CELL));
        } else if (intValue != 0) {
            this.p1.postValue(Integer.valueOf((int) PointerIconCompat.TYPE_CROSSHAIR));
        } else if (!skuDetails.i().equals(purchase.f())) {
            r(activity, skuDetails, purchase.f(), purchase.d());
        } else if (purchase.h()) {
            this.p1.postValue(1005);
        } else {
            p(activity, skuDetails);
        }
        w.E(num.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(Throwable th) throws Exception {
        this.p1.postValue(1001);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int V(SkuDetails skuDetails, SkuDetails skuDetails2) {
        if (skuDetails.g() == skuDetails2.g()) {
            return 0;
        }
        return skuDetails.g() < skuDetails2.g() ? -1 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(int i, String str, com.android.billingclient.api.g gVar, List list) {
        BillingResponse billingResponse = new BillingResponse(i);
        if (gVar == null || gVar.a() != 0 || list == null) {
            billingResponse.setResponseCode(6);
        } else {
            billingResponse.setResponseCode(0);
            billingResponse.setResult(list);
        }
        this.p0.onNext(billingResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List Y(BillingResponse billingResponse) throws Exception {
        return (List) billingResponse.getResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0(int i, com.android.billingclient.api.g gVar, String str) {
        BillingResponse billingResponse = new BillingResponse(i);
        if (gVar == null) {
            billingResponse.setResponseCode(6);
        } else {
            billingResponse.setResponseCode(gVar.a());
        }
        this.p0.onNext(billingResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(int i, com.android.billingclient.api.g gVar) {
        BillingResponse billingResponse = new BillingResponse(i);
        if (gVar == null) {
            billingResponse.setResponseCode(6);
        } else {
            billingResponse.setResponseCode(gVar.a());
        }
        this.p0.onNext(billingResponse);
    }

    @UiThread
    private boolean d() {
        return s("subscriptions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ t g0(Boolean bool) throws Exception {
        return o();
    }

    private q<BillingResponse> h(final int i) {
        return this.p0.L(new l() { // from class: com.tplink.iot.model.billing.j
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return BillingManager.F(i, (BillingResponse) obj);
            }
        }).Q0(1L).E(s.f8061c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void i0(Throwable th) throws Exception {
        this.H3.postValue(null);
    }

    private q<List<Product>> j() {
        return this.f8027f.x().F(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.t
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.I((io.reactivex.e0.c) obj);
            }
        }).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.w0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void k0(Boolean bool) throws Exception {
        this.I3.clear();
        List<Purchase> A0 = A0("inapp");
        if (A0 != null) {
            ArrayList arrayList = new ArrayList(A0);
            if (d()) {
                List<Purchase> A02 = A0("subs");
                if (A02 != null) {
                    this.I3.addAll(A02);
                    arrayList.addAll(A02);
                } else {
                    throw new BillingException("Query purchase fail");
                }
            }
            this.p3.postValue(arrayList);
            return;
        }
        throw new BillingException("Query purchase fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ List m0(Object[] objArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            List<SkuDetails> list = (List) obj;
            Collections.sort(list, f.f8038c);
            for (SkuDetails skuDetails : list) {
                if (!(skuDetails == null || skuDetails.i() == null)) {
                    this.L3.put(skuDetails.i(), skuDetails);
                    arrayList.add(new ProductDetails(skuDetails));
                }
            }
        }
        this.H3.postValue(arrayList);
        return arrayList;
    }

    private Purchase n() {
        ArrayList<Purchase> arrayList = this.I3;
        if (arrayList.isEmpty()) {
            return null;
        }
        for (Purchase purchase : arrayList) {
            if (purchase != null) {
                return purchase;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(io.reactivex.e0.c cVar) throws Exception {
        this.L3.clear();
    }

    private q<List<ProductDetails>> o() {
        this.x = System.currentTimeMillis();
        return j().N(new j() { // from class: com.tplink.iot.model.billing.f0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.K((List) obj);
            }
        }).N(new j() { // from class: com.tplink.iot.model.billing.l
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.M((Boolean) obj);
            }
        }).C(o.f8057c).z(c.a);
    }

    private void p(Activity activity, SkuDetails skuDetails) {
        r(activity, skuDetails, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ t q0(final String str, List list, Boolean bool) throws Exception {
        final int incrementAndGet = this.z.incrementAndGet();
        this.f8026d.i(com.android.billingclient.api.l.c().c(str).b(list).a(), new m() { // from class: com.tplink.iot.model.billing.z
            @Override // com.android.billingclient.api.m
            public final void a(com.android.billingclient.api.g gVar, List list2) {
                BillingManager.this.X(incrementAndGet, str, gVar, list2);
            }
        });
        return h(incrementAndGet).g0(b0.f8032c);
    }

    private void r(final Activity activity, final SkuDetails skuDetails, final String str, final String str2) {
        if (str == null || t()) {
            G0().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.x
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    BillingManager.this.Q(skuDetails, str, str2, activity, (Boolean) obj);
                }
            }).F0();
        } else {
            this.p1.postValue(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ t s0(Boolean bool) throws Exception {
        return o();
    }

    @UiThread
    private boolean s(String str) {
        com.android.billingclient.api.g d2 = this.f8026d.d(str);
        return d2 != null && d2.a() == 0;
    }

    @UiThread
    private boolean t() {
        return s("subscriptionsUpdate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(Throwable th) throws Exception {
        this.H3.postValue(null);
    }

    private boolean u(List<Purchase> list) {
        return false;
    }

    private void v(final Purchase purchase, final Activity activity, final SkuDetails skuDetails) {
        this.f8027f.y(purchase.c(), purchase.f(), purchase.d()).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.k
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.S(activity, skuDetails, purchase, (Integer) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.U((Throwable) obj);
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(List<Product> list) {
        for (Product product : list) {
            String productId = product.getProductId();
            if (productId != null) {
                int productType = product.getProductType();
                if (productType == 1 || productType == 2) {
                    this.J3.add(productId);
                } else if (productType == 3 || productType == 4) {
                    this.K3.add(productId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ t y(Purchase purchase, Boolean bool) throws Exception {
        final int incrementAndGet = this.z.incrementAndGet();
        this.f8026d.a(com.android.billingclient.api.a.b().b(purchase.d()).a(), new com.android.billingclient.api.b() { // from class: com.tplink.iot.model.billing.u
            @Override // com.android.billingclient.api.b
            public final void a(com.android.billingclient.api.g gVar) {
                BillingManager.this.d0(incrementAndGet, gVar);
            }
        });
        return h(incrementAndGet).g0(w.f8065c).q0(Boolean.FALSE);
    }

    private void x0(List<Purchase> list) {
        if (u(list)) {
            this.p1.postValue(1001);
        } else {
            this.p2.postValue(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(Activity activity, SkuDetails skuDetails, CloudUserResult cloudUserResult) throws Exception {
        if (!TextUtils.isEmpty(cloudUserResult.getAccountId())) {
            D0(activity, skuDetails);
        } else {
            this.p1.postValue(1001);
        }
    }

    private q<Boolean> z0() {
        return G0().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.d0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.k0((Boolean) obj);
            }
        });
    }

    public void E0() {
        q<R> N = G0().N(new j() { // from class: com.tplink.iot.model.billing.c0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.s0((Boolean) obj);
            }
        });
        MutableLiveData<List<ProductDetails>> mutableLiveData = this.H3;
        mutableLiveData.getClass();
        N.E(new a(mutableLiveData)).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.u0((Throwable) obj);
            }
        }).F0();
    }

    public q<VerifyReceiptResult> I0(String str, String str2, String str3, String str4) {
        return this.f8027f.J(str, str2, str3, str4);
    }

    @Override // com.android.billingclient.api.k
    public void a(com.android.billingclient.api.g gVar, @Nullable List<Purchase> list) {
        if (gVar == null) {
            this.p1.postValue(1001);
            return;
        }
        int a2 = gVar.a();
        if (a2 != 0) {
            this.p1.postValue(Integer.valueOf(H0(a2)));
        } else if (list == null) {
            this.p1.postValue(1001);
        } else {
            x0(list);
        }
    }

    public q<Boolean> c(@NonNull final Purchase purchase) {
        return G0().N(new j() { // from class: com.tplink.iot.model.billing.i
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.y(purchase, (Boolean) obj);
            }
        });
    }

    public void e(@NonNull final Activity activity, String str) {
        if (str == null) {
            this.p1.postValue(1004);
            return;
        }
        final SkuDetails skuDetails = this.L3.get(str);
        if (skuDetails == null) {
            this.p1.postValue(1004);
            return;
        }
        TCAccountBean c2 = b.d.s.a.a.f().c();
        if (c2 == null) {
            this.p1.postValue(1001);
        } else if (TextUtils.isEmpty(c2.getAccountId())) {
            TCAccountRepository tCAccountRepository = this.q;
            tCAccountRepository.s(tCAccountRepository.u().getCloudUserName()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.y
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    BillingManager.this.A(activity, skuDetails, (CloudUserResult) obj);
                }
            }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.e0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    BillingManager.this.C((Throwable) obj);
                }
            }).F0();
        } else {
            D0(activity, skuDetails);
        }
    }

    public q<Boolean> f(@NonNull Purchase purchase) {
        String f2 = purchase.f();
        if (this.J3.contains(f2)) {
            return g(purchase);
        }
        if (this.K3.contains(f2)) {
            return c(purchase);
        }
        return q.f0(Boolean.FALSE);
    }

    public q<Boolean> g(@NonNull final Purchase purchase) {
        return G0().N(new j() { // from class: com.tplink.iot.model.billing.n
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.E(purchase, (Boolean) obj);
            }
        });
    }

    public LiveData<List<ProductDetails>> i() {
        return this.H3;
    }

    public LiveData<Integer> k() {
        return this.p1;
    }

    public LiveData<List<Purchase>> l() {
        return this.p3;
    }

    public LiveData<List<Purchase>> m() {
        return this.p2;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        if (this.f8026d == null) {
            this.f8026d = c.g(this.f8025c).b().c(this).a();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if (this.f8026d.e()) {
            this.f8026d.c();
        }
        if (!this.p0.j1() && !this.p0.k1()) {
            this.p0.onComplete();
        }
        if (!this.y.isDisposed()) {
            this.y.d();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (this.f8026d.e()) {
            y0();
            return;
        }
        q<R> N = F0().N(new j() { // from class: com.tplink.iot.model.billing.a0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BillingManager.this.g0((Boolean) obj);
            }
        });
        MutableLiveData<List<ProductDetails>> mutableLiveData = this.H3;
        mutableLiveData.getClass();
        N.E(new a(mutableLiveData)).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.billing.q
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BillingManager.this.i0((Throwable) obj);
            }
        }).F0();
    }

    public void y0() {
        z0().F0();
    }
}
