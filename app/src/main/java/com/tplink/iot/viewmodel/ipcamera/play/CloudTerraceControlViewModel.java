package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.view.ipcamera.play.CloudTerraceSensitivityDialogFragment;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CloudTerraceMoveRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;

/* loaded from: classes3.dex */
public class CloudTerraceControlViewModel extends AndroidViewModel implements LifecycleObserver, CloudTerraceSensitivityDialogFragment.a {
    private CloudTerraceMoveRepository J3;

    /* renamed from: d  reason: collision with root package name */
    private String f10501d;
    private String q;

    /* renamed from: c  reason: collision with root package name */
    private final String f10500c = CloudTerraceControlViewModel.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private o f10502f = o.h0();
    private final int x = 5;
    private final int y = 10;
    private final int z = 15;
    private final int p0 = 0;
    private final int p1 = 50;
    private final int p2 = 100;
    private int[] p3 = new int[4];
    private int H3 = 0;
    private b I3 = new b();
    public final MutableLiveData<Boolean> K3 = new MutableLiveData<>();
    public final MutableLiveData<Integer> L3 = new MutableLiveData<>();
    public final MutableLiveData<Boolean> M3 = new MutableLiveData<>();
    public final MutableLiveData<Boolean> N3 = new MutableLiveData<>();
    public final MutableLiveData<Boolean> O3 = new MutableLiveData<>();
    public final MutableLiveData<Boolean> P3 = new MutableLiveData<>();
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> Q3 = new MutableLiveData<>();
    private boolean R3 = true;
    private Handler S3 = new a(Looper.getMainLooper());
    private Runnable T3 = new Runnable() { // from class: com.tplink.iot.viewmodel.ipcamera.play.m
        @Override // java.lang.Runnable
        public final void run() {
            CloudTerraceControlViewModel.this.b0();
        }
    };

    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 3) {
                b.d.w.c.a.c(CloudTerraceControlViewModel.this.f10500c, "Handler handle CLOUD_TERRACE_CLICK_MERGE_MSG");
                CloudTerraceControlViewModel.this.k0(-1, false);
            }
        }
    }

    public CloudTerraceControlViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void D(com.tplink.libtpmediaother.database.model.c r11) {
        /*
            r10 = this;
            java.lang.Long r0 = r11.h()
            r1 = 0
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = com.tplink.libtpnetwork.Utils.d0.b(r0, r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            java.lang.Long r0 = r11.f()
            java.lang.Object r0 = com.tplink.libtpnetwork.Utils.d0.b(r0, r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            java.lang.Long r11 = r11.g()
            java.lang.Object r11 = com.tplink.libtpnetwork.Utils.d0.b(r11, r3)
            java.lang.Long r11 = (java.lang.Long) r11
            long r8 = r11.longValue()
            r11 = 2
            r0 = 1
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0039
            r4 = r6
            r3 = 1
            goto L_0x003a
        L_0x0039:
            r3 = 2
        L_0x003a:
            r6 = 0
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r8 = r4
        L_0x0042:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r8
            if (r3 == 0) goto L_0x0056
            if (r3 == r0) goto L_0x0052
            if (r3 == r11) goto L_0x004f
            r7 = r1
            goto L_0x0059
        L_0x004f:
            r7 = 25000(0x61a8, double:1.23516E-319)
            goto L_0x0058
        L_0x0052:
            r7 = 57000(0xdea8, double:2.81617E-319)
            goto L_0x0058
        L_0x0056:
            r7 = 11000(0x2af8, double:5.4347E-320)
        L_0x0058:
            long r7 = r7 - r4
        L_0x0059:
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a5
            if (r3 == r11) goto L_0x0074
            boolean r1 = r10.R3
            if (r1 == 0) goto L_0x0074
            androidx.lifecycle.MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<java.lang.String>> r1 = r10.Q3
            com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a r2 = new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a
            r4 = 2131952346(0x7f1302da, float:1.9541132E38)
            java.lang.String r4 = r10.r(r4)
            r2.<init>(r4)
            r1.postValue(r2)
        L_0x0074:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r1 = r10.M3
            if (r3 != r11) goto L_0x007a
            r11 = 1
            goto L_0x007b
        L_0x007a:
            r11 = 0
        L_0x007b:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r1.postValue(r11)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r11 = r10.O3
            if (r3 != r0) goto L_0x0088
            r1 = 1
            goto L_0x0089
        L_0x0088:
            r1 = 0
        L_0x0089:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r11.postValue(r1)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r11 = r10.N3
            if (r3 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r0 = 0
        L_0x0096:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r11.postValue(r0)
            android.os.Handler r11 = r10.S3
            java.lang.Runnable r0 = r10.T3
            r11.postDelayed(r0, r7)
            goto L_0x00aa
        L_0x00a5:
            java.lang.Runnable r11 = r10.T3
            r11.run()
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel.D(com.tplink.libtpmediaother.database.model.c):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(c cVar) throws Exception {
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(Boolean bool) throws Exception {
        this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(R.string.cloud_terrace_control_resetting)));
        this.M3.postValue(Boolean.TRUE);
        this.S3.postDelayed(this.T3, 25000L);
        l.r(this.f10501d, t.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(Throwable th) throws Exception {
        u(th, Integer.valueOf((int) R.string.cloud_terrace_correct_fail));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(c cVar) throws Exception {
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void N(final boolean z, Boolean bool) throws Exception {
        this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(R.string.cloud_terrace_control_cruising)));
        if (z) {
            this.N3.postValue(Boolean.TRUE);
        } else {
            this.O3.postValue(Boolean.TRUE);
        }
        this.S3.postDelayed(this.T3, z ? 11000L : 57000L);
        l.r(this.f10501d, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.j
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CloudTerraceControlViewModel.e0(z, (com.tplink.libtpmediaother.database.model.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void P(boolean z, c cVar) throws Exception {
        if (z) {
            p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(Runnable runnable, Boolean bool) throws Exception {
        l.r(this.f10501d, o.a);
        this.T3.run();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void T(Runnable runnable, Throwable th) throws Exception {
        if (runnable == null) {
            u(th, Integer.valueOf((int) R.string.cloud_terrace_cruise_stop_fail));
        } else {
            t(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void W(Throwable th) throws Exception {
        u(th, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void X(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z(Throwable th) throws Exception {
        u(th, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0() {
        if (j.h(this.M3)) {
            this.M3.postValue(Boolean.FALSE);
        }
        if (j.h(this.O3)) {
            this.O3.postValue(Boolean.FALSE);
        }
        if (j.h(this.N3)) {
            this.N3.postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c0(com.tplink.libtpmediaother.database.model.c cVar) {
        cVar.q(0L);
        cVar.r(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e0(boolean z, com.tplink.libtpmediaother.database.model.c cVar) {
        if (z) {
            cVar.r(Long.valueOf(System.currentTimeMillis()));
        } else {
            cVar.q(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                if (this.f10502f.d(this.q, 10) != 5) {
                    this.f10502f.i(this.q, 5);
                }
                h(5);
            } else if (intValue == 50) {
                if (this.f10502f.d(this.q, 10) != 10) {
                    this.f10502f.i(this.q, 10);
                }
                h(10);
            } else if (intValue == 100) {
                if (this.f10502f.d(this.q, 10) != 15) {
                    this.f10502f.i(this.q, 15);
                }
                h(15);
            }
        }
    }

    private void h(int i) {
        this.H3 = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h0(Boolean bool) throws Exception {
    }

    private void i() {
        l.e(this.f10501d, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.u
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CloudTerraceControlViewModel.this.D((com.tplink.libtpmediaother.database.model.c) obj);
            }
        });
    }

    private void i0(String str) {
        String str2 = str + "_" + b.d.s.a.a.f().c().getEmail() + "_cloud_terrace_sensitivity";
        this.q = str2;
        int d2 = this.f10502f.d(str2, 10);
        if (d2 == 10) {
            this.L3.setValue(50);
        } else if (d2 != 15) {
            this.L3.setValue(0);
        } else {
            this.L3.setValue(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (j.h(this.P3)) {
            this.P3.postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i, boolean z) {
        if (!s() && !v()) {
            if (z) {
                int[] iArr = this.p3;
                iArr[i] = iArr[i] + 1;
                if (this.S3.hasMessages(3)) {
                    b.d.w.c.a.c(this.f10500c, "Already has CLOUD_TERRACE_CLICK_MERGE_MSG, record click and return.");
                    return;
                } else {
                    this.S3.sendEmptyMessageDelayed(3, 500L);
                    b.d.w.c.a.c(this.f10500c, "Send CLOUD_TERRACE_CLICK_MERGE_MSG after 500 MILLISECOND");
                }
            }
            if (w()) {
                this.I3.b(this.J3.x(p()).H0(q.f10643c, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.d
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        CloudTerraceControlViewModel.this.W((Throwable) obj);
                    }
                }));
                e.l(this.f10501d);
                return;
            }
            b.d.w.c.a.c(this.f10500c, "Has unavailable move info()");
        }
    }

    private String o(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "0" : "90" : "180" : "270";
    }

    private CloudTerraceMoveInfo p() {
        int[] iArr = this.p3;
        iArr[3] = iArr[3] - iArr[1];
        iArr[0] = iArr[0] - iArr[2];
        int i = iArr[3];
        int i2 = this.H3;
        iArr[3] = 0;
        iArr[2] = 0;
        iArr[1] = 0;
        iArr[0] = 0;
        CloudTerraceMoveInfo cloudTerraceMoveInfo = new CloudTerraceMoveInfo(String.valueOf(iArr[0] * i2), String.valueOf(i * i2));
        b.d.w.c.a.c(this.f10500c, cloudTerraceMoveInfo.toString());
        return cloudTerraceMoveInfo;
    }

    private void p0() {
        if (j.g(this.P3)) {
            this.P3.postValue(Boolean.TRUE);
        }
    }

    private String r(@StringRes int i) {
        return getApplication().getString(i);
    }

    private boolean s() {
        if (!y()) {
            return false;
        }
        this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(R.string.cloud_terrace_correcting_hint)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Throwable th) {
        u(th, Integer.valueOf((int) R.string.general_failed));
    }

    private void u(Throwable th, @StringRes Integer num) {
        b.d.w.c.a.e(this.f10500c, Log.getStackTraceString(th));
        if (th instanceof CameraException) {
            switch (((CameraException) th).getErrorCode()) {
                case -64305:
                case -64303:
                    this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(R.string.cloud_terrace_motor_busy_hint_v2)));
                    return;
                case -64304:
                    this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(R.string.video_live_ptz_ready_boundary)));
                    return;
            }
        }
        if (num != null) {
            this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(r(num.intValue())));
        }
    }

    private boolean v() {
        if (this.J3 != null) {
            return false;
        }
        t(new RuntimeException("cloudTerraceMoveRepository is null"));
        return true;
    }

    private boolean w() {
        int[] iArr = this.p3;
        return ((iArr[3] - iArr[1]) + iArr[0]) - iArr[2] != 0;
    }

    private void x(@NonNull TPCameraDeviceContext tPCameraDeviceContext) {
        this.J3 = (CloudTerraceMoveRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(tPCameraDeviceContext, CloudTerraceMoveRepository.class);
    }

    @Override // com.tplink.iot.view.ipcamera.play.CloudTerraceSensitivityDialogFragment.a
    public int c() {
        if (this.L3.getValue() == null) {
            return 50;
        }
        return this.L3.getValue().intValue();
    }

    @Override // com.tplink.iot.view.ipcamera.play.CloudTerraceSensitivityDialogFragment.a
    public void d(int i) {
        this.L3.setValue(Integer.valueOf(i));
    }

    public void j0(int i) {
        k0(i, true);
    }

    public void k() {
        if (!v()) {
            this.I3.b(this.J3.t().F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.r
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.F((c) obj);
                }
            }).y(new a(this)).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.n
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.H((Boolean) obj);
                }
            }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.h
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.J((Throwable) obj);
                }
            }));
        }
    }

    public void l(final boolean z) {
        if (!s() && !v()) {
            this.I3.b(this.J3.u(z).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.p
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.L((c) obj);
                }
            }).y(new a(this)).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.k
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.N(z, (Boolean) obj);
                }
            }, new f(this)));
        }
    }

    public void l0(int i) {
        if (!s() && !v()) {
            this.I3.b(this.J3.y(o(i)).H0(e.f10600c, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.s
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CloudTerraceControlViewModel.this.Z((Throwable) obj);
                }
            }));
        }
    }

    public void m() {
        n(true, null);
    }

    public void m0(String str) {
        if (!d0.a(this.f10501d, str)) {
            this.f10501d = str;
            this.J3 = null;
            if (str != null) {
                x(TPIoTClientManager.K1(str));
                i0(str);
                i();
            }
        }
    }

    public void n(final boolean z, final Runnable runnable) {
        if (!s() && !v()) {
            if (j.h(this.N3) || j.h(this.O3)) {
                this.I3.b(this.J3.v().l0(io.reactivex.d0.b.a.a()).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.l
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        CloudTerraceControlViewModel.this.P(z, (c) obj);
                    }
                }).y(new a(this)).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.i
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        CloudTerraceControlViewModel.this.R(runnable, (Boolean) obj);
                    }
                }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.g
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        CloudTerraceControlViewModel.this.T(runnable, (Throwable) obj);
                    }
                }));
            } else if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void n0(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
        this.L3.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CloudTerraceControlViewModel.this.g0((Integer) obj);
            }
        });
    }

    public void o0(boolean z) {
        this.R3 = z;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroyed() {
        this.S3.removeCallbacks(this.T3);
        this.I3.d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onActivityStarted() {
        i();
    }

    public void q0() {
        if (!j.h(this.M3) && !v()) {
            this.I3.b(this.J3.z().H0(b.f10591c, new f(this)));
        }
    }

    public boolean y() {
        return j.h(this.M3);
    }

    public boolean z() {
        return j.h(this.O3) || j.h(this.N3);
    }
}
