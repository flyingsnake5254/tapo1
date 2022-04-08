package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.DiagnoseStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class LdcDianoseSettingRepository extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c {

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<Boolean> f14245d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<Boolean> f14246e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<Boolean> f14247f = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f14248c;

        a(boolean z) {
            this.f14248c = z;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            if (this.f14248c && bool != null && !bool.booleanValue()) {
                LdcDianoseSettingRepository.this.f14247f.postValue(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.c<Boolean, DiagnoseStatus, Boolean> {
        b() {
        }

        /* renamed from: a */
        public Boolean apply(Boolean bool, DiagnoseStatus diagnoseStatus) throws Exception {
            return Boolean.valueOf(bool != null && bool.booleanValue() && diagnoseStatus != null && TextUtils.equals(diagnoseStatus.getStatus(), "running"));
        }
    }

    /* loaded from: classes3.dex */
    class c implements j<Boolean, t<Boolean>> {
        c() {
        }

        /* renamed from: a */
        public t<Boolean> apply(Boolean bool) throws Exception {
            return LdcDianoseSettingRepository.this.S(true).r(1L, TimeUnit.SECONDS);
        }
    }

    /* loaded from: classes3.dex */
    class d implements j<SystemInfo, t<Boolean>> {
        d() {
        }

        /* renamed from: a */
        public t<Boolean> apply(SystemInfo systemInfo) throws Exception {
            return LdcDianoseSettingRepository.this.V(TextUtils.equals(systemInfo.getDiagnoseMode(), "on"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements j<Boolean, t<Boolean>> {
        e() {
        }

        /* renamed from: a */
        public t<Boolean> apply(Boolean bool) throws Exception {
            return ((com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c) LdcDianoseSettingRepository.this).f14514c.v2(true).i(m.g()).L0(io.reactivex.l0.a.c()).C(f7.f14400c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements j<Boolean, t<String>> {
        f() {
        }

        /* renamed from: a */
        public t<String> apply(Boolean bool) throws Exception {
            if (bool == null || !bool.booleanValue()) {
                return q.f0("");
            }
            return LdcDianoseSettingRepository.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements j<ResponseBody, t<String>> {
        g() {
        }

        /* renamed from: a */
        public t<String> apply(ResponseBody responseBody) throws Exception {
            InputStream byteStream = responseBody.byteStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return q.f0(byteArrayOutputStream2);
                }
            }
        }
    }

    public LdcDianoseSettingRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        boolean z = th instanceof CameraException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Boolean bool) throws Exception {
        this.f14246e.postValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(Boolean bool) throws Exception {
        this.f14245d.postValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(Boolean bool) throws Exception {
        this.f14246e.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(Throwable th) throws Exception {
        this.f14246e.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(boolean z, Boolean bool) throws Exception {
        this.f14245d.postValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(boolean z, Throwable th) throws Exception {
        this.f14245d.postValue(Boolean.valueOf(!z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<Boolean> V(boolean z) {
        if (z) {
            return this.f14514c.v2(false).i(m.g()).L0(io.reactivex.l0.a.c()).N(new e()).C(f7.f14400c);
        }
        return this.f14514c.v2(true).i(m.g()).L0(io.reactivex.l0.a.c()).C(f7.f14400c);
    }

    public q<Boolean> S(boolean z) {
        q g0 = this.f14514c.L().i(m.a()).L0(io.reactivex.l0.a.c()).g0(t2.f14595c);
        f7 f7Var = f7.f14400c;
        return q.f(g0.C(f7Var), this.f14514c.M().i(m.a()).L0(io.reactivex.l0.a.c()), new b()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcDianoseSettingRepository.this.E((Boolean) obj);
            }
        }).E(new a(z)).C(f7Var);
    }

    public q<Boolean> T() {
        return this.f14514c.U().i(m.a()).L0(io.reactivex.l0.a.c()).g0(u2.f14606c).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.p2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcDianoseSettingRepository.this.H((Boolean) obj);
            }
        }).C(f7.f14400c);
    }

    public q<Boolean> U(boolean z) {
        if (!z) {
            return this.f14514c.v2(false).C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.s2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    LdcDianoseSettingRepository.this.J((Boolean) obj);
                }
            }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    LdcDianoseSettingRepository.this.A((Throwable) obj);
                }
            }).g0(r2.f14575c);
        }
        return this.f14514c.L().i(m.a()).L0(io.reactivex.l0.a.c()).N(new d()).N(new c()).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.q2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcDianoseSettingRepository.this.M((Throwable) obj);
            }
        });
    }

    public q<Boolean> W(final boolean z) {
        return this.f14514c.B2(z).C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.v2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcDianoseSettingRepository.this.O(z, (Boolean) obj);
            }
        }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LdcDianoseSettingRepository.this.Q(z, (Throwable) obj);
            }
        }).g0(n2.f14531c);
    }

    public q<String> v() {
        return this.f14514c.t().L0(io.reactivex.l0.a.c()).N(new g()).C(f7.f14400c);
    }

    public q<String> w() {
        return S(false).L0(io.reactivex.l0.a.c()).N(new f()).C(f7.f14400c);
    }

    public MutableLiveData<Boolean> x() {
        return this.f14246e;
    }

    public MutableLiveData<Boolean> y() {
        return this.f14245d;
    }

    public MutableLiveData<Boolean> z() {
        return this.f14247f;
    }
}
