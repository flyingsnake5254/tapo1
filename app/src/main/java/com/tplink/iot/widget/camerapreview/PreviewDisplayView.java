package com.tplink.iot.widget.camerapreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.q.b.l;
import com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout;
import com.tplink.iot.R;
import com.tplink.iot.Utils.m;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.ViewPreviewDisplayBinding;
import com.tplink.iot.view.ipcamera.play.CameraUpdatingDialogFragment;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import io.reactivex.q;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* compiled from: PreviewDisplayView.kt */
/* loaded from: classes3.dex */
public final class PreviewDisplayView extends MviFrameLayout<d, b> implements LifecycleObserver, d {
    private final MutableLiveData<String> I3;
    private final MutableLiveData<Boolean> J3;
    private final io.reactivex.m0.d<Boolean> K3;
    private final io.reactivex.m0.d<Boolean> L3;
    private ForcedUpdateFwDialog M3;
    private boolean O3;
    private long P3;
    private long Q3;

    /* renamed from: f  reason: collision with root package name */
    private String f11684f;
    private final b p0;
    private final LifecycleOwner p1;
    private final ViewPreviewDisplayBinding p2;
    private final MutableLiveData<e> p3;
    private final FirmwareManager q;
    private String x;
    private CameraPreviewInfo y;
    private final io.reactivex.m0.b<CameraPreviewInfo> z;
    private e H3 = e.a.e();
    private MutableLiveData<Boolean> N3 = new MutableLiveData<>(Boolean.FALSE);
    private int R3 = -1;

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPreviewDisplayBinding f11685c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PreviewDisplayView f11686d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f11687f;

        a(ViewPreviewDisplayBinding viewPreviewDisplayBinding, PreviewDisplayView previewDisplayView, Context context) {
            this.f11685c = viewPreviewDisplayBinding;
            this.f11686d = previewDisplayView;
            this.f11687f = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Boolean bool = Boolean.TRUE;
            if (j.a((Boolean) this.f11686d.N3.getValue(), bool)) {
                Context context = this.f11687f;
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                u.f((Activity) context, this.f11686d.f11684f);
                return;
            }
            e eVar = (e) this.f11686d.p3.getValue();
            Boolean bool2 = null;
            if (j.a(eVar != null ? eVar.t() : null, bool)) {
                Context context2 = this.f11687f;
                Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
                s0.s((Activity) context2, R.string.tip_device_loading);
                return;
            }
            e eVar2 = (e) this.f11686d.p3.getValue();
            if (j.a(eVar2 != null ? eVar2.v() : null, bool)) {
                PreviewDisplayView previewDisplayView = this.f11686d;
                previewDisplayView.x(previewDisplayView.getDeviceIdMD5());
                return;
            }
            System.out.println((Object) (this.f11686d.getLogPrefix() + "->cameraPlayBtn clicked"));
            e eVar3 = (e) this.f11686d.p3.getValue();
            if (eVar3 != null) {
                bool2 = eVar3.x();
            }
            boolean z = !j.a(bool2, bool);
            this.f11686d.K3.onNext(Boolean.valueOf(z));
            ImageView soundStatus = this.f11685c.H3;
            j.d(soundStatus, "soundStatus");
            if (soundStatus.getTag() == null) {
                LiveMediaAPI.muteAudio(this.f11686d.getDeviceIdMD5(), true);
                ImageView soundStatus2 = this.f11685c.H3;
                j.d(soundStatus2, "soundStatus");
                soundStatus2.setTag(Boolean.FALSE);
            } else {
                ImageView soundStatus3 = this.f11685c.H3;
                j.d(soundStatus3, "soundStatus");
                if (soundStatus3.getTag() instanceof Boolean) {
                    String deviceIdMD5 = this.f11686d.getDeviceIdMD5();
                    ImageView soundStatus4 = this.f11685c.H3;
                    j.d(soundStatus4, "soundStatus");
                    Object tag = soundStatus4.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Boolean");
                    LiveMediaAPI.muteAudio(deviceIdMD5, true ^ ((Boolean) tag).booleanValue());
                }
            }
            if (z) {
                this.f11686d.u();
            }
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f11689d;

        b(Context context) {
            this.f11689d = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e eVar = (e) PreviewDisplayView.this.p3.getValue();
            Boolean bool = null;
            Boolean z = eVar != null ? eVar.z() : null;
            Boolean bool2 = Boolean.TRUE;
            if (j.a(z, bool2)) {
                Context context = this.f11689d;
                Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                new CameraUpdatingDialogFragment().show(((FragmentActivity) context).getSupportFragmentManager(), "UpdatingDialog");
                return;
            }
            e eVar2 = (e) PreviewDisplayView.this.p3.getValue();
            if (eVar2 != null) {
                bool = eVar2.x();
            }
            if (j.a(bool, bool2)) {
                System.out.println((Object) (PreviewDisplayView.this.getLogPrefix() + "->previewCover clicked"));
                io.reactivex.m0.d dVar = PreviewDisplayView.this.L3;
                ImageView imageView = PreviewDisplayView.this.p2.f7359f;
                j.d(imageView, "binding.cameraPlayBtn");
                dVar.onNext(Boolean.valueOf(imageView.getVisibility() != 0));
            }
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f11691d;

        c(Context context) {
            this.f11691d = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PreviewDisplayView.this.t();
            e eVar = (e) PreviewDisplayView.this.p3.getValue();
            Boolean bool = null;
            Boolean t = eVar != null ? eVar.t() : null;
            Boolean bool2 = Boolean.TRUE;
            if (j.a(t, bool2)) {
                Context context = this.f11691d;
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                s0.s((Activity) context, R.string.tip_device_loading);
                return;
            }
            e eVar2 = (e) PreviewDisplayView.this.p3.getValue();
            if (eVar2 != null) {
                bool = eVar2.v();
            }
            if (j.a(bool, bool2)) {
                PreviewDisplayView previewDisplayView = PreviewDisplayView.this;
                previewDisplayView.x(previewDisplayView.getDeviceIdMD5());
                return;
            }
            LiveMediaAPI.allDisplayScreenshotPreview();
            LiveMediaAPI.destroyAllDisplayAndStream();
            this.f11691d.startActivity(new Intent(this.f11691d, VideoPlayActivity.class).putExtra("device_id_md5", PreviewDisplayView.this.getDeviceIdMD5()));
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class d implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPreviewDisplayBinding f11692c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PreviewDisplayView f11693d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f11694f;

        d(ViewPreviewDisplayBinding viewPreviewDisplayBinding, PreviewDisplayView previewDisplayView, Context context) {
            this.f11692c = viewPreviewDisplayBinding;
            this.f11693d = previewDisplayView;
            this.f11694f = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x005f, code lost:
            if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x0063;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                java.lang.String r0 = "soundStatus"
                kotlin.jvm.internal.j.d(r6, r0)
                java.lang.Object r6 = r6.getTag()
                r1 = 2131231625(0x7f080389, float:1.8079336E38)
                r2 = 1
                r3 = 0
                if (r6 != 0) goto L_0x003a
                com.tplink.iot.widget.camerapreview.PreviewDisplayView r6 = r5.f11693d
                java.lang.String r6 = r6.getDeviceIdMD5()
                com.tplink.libmediaapi.live.LiveMediaAPI.muteAudio(r6, r3)
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                kotlin.jvm.internal.j.d(r6, r0)
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                r6.setTag(r0)
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                r6.setImageResource(r1)
                com.tplink.iot.widget.camerapreview.PreviewDisplayView r6 = r5.f11693d
                java.lang.String r6 = r6.getDeviceIdMD5()
                com.tplink.iot.Utils.x0.e.y(r6, r2)
                goto L_0x0092
            L_0x003a:
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                kotlin.jvm.internal.j.d(r6, r0)
                java.lang.Object r6 = r6.getTag()
                boolean r6 = r6 instanceof java.lang.Boolean
                if (r6 == 0) goto L_0x0062
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                kotlin.jvm.internal.j.d(r6, r0)
                java.lang.Object r6 = r6.getTag()
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.Boolean"
                java.util.Objects.requireNonNull(r6, r4)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L_0x0062
                goto L_0x0063
            L_0x0062:
                r2 = 0
            L_0x0063:
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                kotlin.jvm.internal.j.d(r6, r0)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                r6.setTag(r0)
                com.tplink.iot.widget.camerapreview.PreviewDisplayView r6 = r5.f11693d
                java.lang.String r6 = r6.getDeviceIdMD5()
                r0 = r2 ^ 1
                com.tplink.libmediaapi.live.LiveMediaAPI.muteAudio(r6, r0)
                com.tplink.iot.databinding.ViewPreviewDisplayBinding r6 = r5.f11692c
                android.widget.ImageView r6 = r6.H3
                if (r2 == 0) goto L_0x0083
                goto L_0x0086
            L_0x0083:
                r1 = 2131231626(0x7f08038a, float:1.8079338E38)
            L_0x0086:
                r6.setImageResource(r1)
                com.tplink.iot.widget.camerapreview.PreviewDisplayView r6 = r5.f11693d
                java.lang.String r6 = r6.getDeviceIdMD5()
                com.tplink.iot.Utils.x0.e.y(r6, r2)
            L_0x0092:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.camerapreview.PreviewDisplayView.d.onClick(android.view.View):void");
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class e implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f11696d;

        e(Context context) {
            this.f11696d = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (j.a((Boolean) PreviewDisplayView.this.N3.getValue(), Boolean.TRUE)) {
                Context context = this.f11696d;
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                u.f((Activity) context, PreviewDisplayView.this.f11684f);
            }
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class f<T> implements Observer<e> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(e eVar) {
            if (eVar != null) {
                e eVar2 = (e) PreviewDisplayView.this.p3.getValue();
                Boolean bool = null;
                Boolean x = eVar2 != null ? eVar2.x() : null;
                Boolean bool2 = Boolean.TRUE;
                if (j.a(x, bool2) && (!j.a(PreviewDisplayView.this.H3.x(), bool2))) {
                    System.out.println((Object) (PreviewDisplayView.this.getLogPrefix() + "->hide func btn when play"));
                    io.reactivex.m0.d dVar = PreviewDisplayView.this.L3;
                    Boolean bool3 = Boolean.FALSE;
                    dVar.onNext(bool3);
                    PreviewDisplayView.this.J3.setValue(bool3);
                }
                e eVar3 = (e) PreviewDisplayView.this.p3.getValue();
                if (j.a(eVar3 != null ? eVar3.q() : null, bool2)) {
                    PreviewDisplayView.this.J3.setValue(bool2);
                }
                PreviewDisplayView.this.H3 = eVar;
                e eVar4 = (e) PreviewDisplayView.this.p3.getValue();
                if (eVar4 != null) {
                    bool = eVar4.v();
                }
                if (j.a(bool, bool2) && (!j.a(PreviewDisplayView.this.H3.v(), bool2))) {
                    PreviewDisplayView.this.K3.onNext(Boolean.FALSE);
                    PreviewDisplayView.this.J3.setValue(bool2);
                }
                PreviewDisplayView.this.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    public static final class g<T> implements Observer<b.d.d.m.f<String>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PreviewDisplayView.kt */
        /* loaded from: classes3.dex */
        public static final class a<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> {
            a() {
            }

            /* renamed from: b */
            public final void a(com.tplink.libtpmediaother.database.model.c deviceInfo) {
                MutableLiveData mutableLiveData = PreviewDisplayView.this.I3;
                j.d(deviceInfo, "deviceInfo");
                mutableLiveData.setValue(deviceInfo.i());
            }
        }

        g() {
        }

        /* renamed from: a */
        public final void onChanged(b.d.d.m.f<String> event) {
            j.d(event, "event");
            String a2 = event.a();
            if (a2 != null) {
                l.e(a2, new a());
            }
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    static final class h<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> {
        h() {
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.c deviceInfo) {
            MutableLiveData mutableLiveData = PreviewDisplayView.this.I3;
            j.d(deviceInfo, "deviceInfo");
            mutableLiveData.setValue(deviceInfo.i());
        }
    }

    /* compiled from: PreviewDisplayView.kt */
    /* loaded from: classes3.dex */
    public static final class i implements ForcedUpdateFwDialog.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11697b;

        i(String str) {
            this.f11697b = str;
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void a() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void b() {
            PreviewDisplayView.this.w(this.f11697b, false);
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void c() {
            PreviewDisplayView.this.w(this.f11697b, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        j.e(context, "context");
        j.e(attrs, "attrs");
        io.reactivex.m0.b<CameraPreviewInfo> n1 = io.reactivex.m0.b.n1();
        j.d(n1, "BehaviorSubject.create()");
        this.z = n1;
        b bVar = new b();
        this.p0 = bVar;
        MutableLiveData<e> mutableLiveData = new MutableLiveData<>();
        this.p3 = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.I3 = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.J3 = mutableLiveData3;
        io.reactivex.m0.d<Boolean> n12 = io.reactivex.m0.d.n1();
        j.d(n12, "PublishSubject.create()");
        this.K3 = n12;
        io.reactivex.m0.d<Boolean> n13 = io.reactivex.m0.d.n1();
        j.d(n13, "PublishSubject.create()");
        this.L3 = n13;
        b.d.b.f.a a2 = b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class);
        j.d(a2, "CloudRepositoryProviders…mwareManager::class.java)");
        this.q = (FirmwareManager) a2;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
        this.p1 = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_preview_display, this, true);
        j.d(inflate, "DataBindingUtil.inflate(…view_display, this, true)");
        ViewPreviewDisplayBinding viewPreviewDisplayBinding = (ViewPreviewDisplayBinding) inflate;
        this.p2 = viewPreviewDisplayBinding;
        viewPreviewDisplayBinding.setLifecycleOwner(lifecycleOwner);
        viewPreviewDisplayBinding.n(mutableLiveData);
        viewPreviewDisplayBinding.i(mutableLiveData2);
        viewPreviewDisplayBinding.l(mutableLiveData3);
        viewPreviewDisplayBinding.h(Boolean.valueOf(o.h0().c("LIVE_ICON_VISIBLE", false)));
        viewPreviewDisplayBinding.m(Boolean.valueOf(o.h0().c("SPEED_ICON_VISIBLE", false)));
        viewPreviewDisplayBinding.f7359f.setOnClickListener(new a(viewPreviewDisplayBinding, this, context));
        viewPreviewDisplayBinding.p3.setOnClickListener(new b(context));
        viewPreviewDisplayBinding.p1.setOnClickListener(new c(context));
        viewPreviewDisplayBinding.H3.setOnClickListener(new d(viewPreviewDisplayBinding, this, context));
        viewPreviewDisplayBinding.x.setOnClickListener(new e(context));
        mutableLiveData.observe(lifecycleOwner, new f());
        bVar.p().observe(lifecycleOwner, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogPrefix() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        com.tplink.iot.Utils.x0.e.n(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        com.tplink.iot.Utils.x0.e.p(this.x);
    }

    private final void v() {
        long j = this.P3;
        if (j != 0) {
            double d2 = (this.Q3 - j) / 1000.0d;
            int connectType = LiveMediaAPI.getConnectType(this.x);
            if (connectType == -1) {
                connectType = this.R3;
            }
            com.tplink.iot.Utils.x0.e.s(this.x, d2, m.a(connectType));
            this.P3 = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str, boolean z) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        FirmwareUpdateNewIpcActivity.g1((Activity) context, str, z);
        LiveMediaAPI.destroyAllDisplayAndStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String str) {
        if (this.M3 == null) {
            this.M3 = new ForcedUpdateFwDialog();
        }
        ForcedUpdateFwDialog forcedUpdateFwDialog = this.M3;
        if (forcedUpdateFwDialog == null || !forcedUpdateFwDialog.isAdded()) {
            com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u g2 = this.q.g(str);
            ForcedUpdateFwDialog forcedUpdateFwDialog2 = this.M3;
            j.c(forcedUpdateFwDialog2);
            forcedUpdateFwDialog2.A0(g2 != null ? g2.a() : "");
            ForcedUpdateFwDialog forcedUpdateFwDialog3 = this.M3;
            j.c(forcedUpdateFwDialog3);
            forcedUpdateFwDialog3.B0(new i(str));
            ForcedUpdateFwDialog forcedUpdateFwDialog4 = this.M3;
            j.c(forcedUpdateFwDialog4);
            Context context = getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            forcedUpdateFwDialog4.show(((FragmentActivity) context).getSupportFragmentManager(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f6, code lost:
        if (kotlin.jvm.internal.j.a(r0 != null ? r0.s() : null, r4) != false) goto L_0x01f8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x024d, code lost:
        if (kotlin.jvm.internal.j.a(r5 != null ? r5.t() : null, r4) != false) goto L_0x024f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x027a, code lost:
        if (kotlin.jvm.internal.j.a(r5 != null ? r5.s() : null, r4) == false) goto L_0x027c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x027c, code lost:
        r5 = r9.p3.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0284, code lost:
        if (r5 == null) goto L_0x028b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0286, code lost:
        r5 = r5.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x028b, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0290, code lost:
        if (kotlin.jvm.internal.j.a(r5, r4) == false) goto L_0x0293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0293, code lost:
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0334, code lost:
        if ((!kotlin.jvm.internal.j.a(r3, r4)) != false) goto L_0x0336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0125, code lost:
        if (kotlin.jvm.internal.j.a(r6 != null ? r6.t() : null, r4) != false) goto L_0x0127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0169, code lost:
        if (kotlin.jvm.internal.j.a(r6 != null ? r6.s() : null, r4) != false) goto L_0x016f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b2, code lost:
        if (kotlin.jvm.internal.j.a(r0 != null ? r0.t() : null, r4) != false) goto L_0x01b4;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y() {
        /*
            Method dump skipped, instructions count: 847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.camerapreview.PreviewDisplayView.y():void");
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public q<CameraPreviewInfo> K() {
        return this.z;
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public q<Boolean> P() {
        return this.L3;
    }

    public final int getConnectType() {
        return this.R3;
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public Context getContextForView() {
        Context context = getContext();
        j.d(context, "context");
        return context;
    }

    public final String getDeviceIdMD5() {
        return this.x;
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public q<Boolean> getFirmwareIntent() {
        q<Boolean> f0 = q.f0(Boolean.TRUE);
        j.d(f0, "Observable.just(true)");
        return f0;
    }

    public final FirmwareManager getFirmwareManager() {
        return this.q;
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public ViewGroup getParentView() {
        FrameLayout frameLayout = this.p2.p0;
        j.d(frameLayout, "binding.liveSurfaceView");
        return frameLayout;
    }

    public final long getPlayEndTimestamp() {
        return this.Q3;
    }

    public final long getPlayStartTimestamp() {
        return this.P3;
    }

    public final CameraPreviewInfo getPreviewInfo() {
        return this.y;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onActivityResume() {
        String str = this.x;
        if (str != null) {
            l.e(str, new h());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onActivityStop() {
        this.K3.onNext(Boolean.FALSE);
        this.J3.setValue(Boolean.TRUE);
        this.Q3 = System.currentTimeMillis();
        v();
    }

    @Override // com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K3.onNext(Boolean.FALSE);
        FrameLayout frameLayout = this.p2.p0;
        j.d(frameLayout, "binding.liveSurfaceView");
        frameLayout.setVisibility(4);
        LiveMediaAPI.stopDisplay(this.x);
        String str = this.x;
        if (str != null) {
            j.c(str);
            TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
            j.d(K1, "TPIoTClientManager.getCameraContext(deviceIdMD5!!)");
            K1.getCameraDevice();
        }
    }

    /* renamed from: s */
    public b D() {
        return this.p0;
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public void s0(e viewState) {
        Boolean x;
        j.e(viewState, "viewState");
        e value = this.p3.getValue();
        boolean z = false;
        boolean booleanValue = (value == null || (x = value.x()) == null) ? false : x.booleanValue();
        Boolean x2 = viewState.x();
        if (x2 != null) {
            z = x2.booleanValue();
        }
        if (booleanValue != z) {
            e value2 = this.p3.getValue();
            if (j.a(value2 != null ? value2.x() : null, Boolean.TRUE)) {
                this.P3 = System.currentTimeMillis();
                this.R3 = LiveMediaAPI.getConnectType(this.x);
            } else {
                this.Q3 = System.currentTimeMillis();
                v();
            }
        }
        this.p3.setValue(viewState);
        System.out.println((Object) (getLogPrefix() + ' ' + viewState));
    }

    public final void setConnectType(int i2) {
        this.R3 = i2;
    }

    public final void setDeviceIdMD5(String str) {
        if (!j.a(this.x, str)) {
            this.x = str;
            this.p0.q(str);
            y();
        }
    }

    public final void setPlayEndTimestamp(long j) {
        this.Q3 = j;
    }

    public final void setPlayStartTimestamp(long j) {
        this.P3 = j;
    }

    public final void setPreviewInfo(CameraPreviewInfo cameraPreviewInfo) {
        if (!j.a(this.y, cameraPreviewInfo)) {
            this.y = cameraPreviewInfo;
            if (cameraPreviewInfo != null) {
                if (!cameraPreviewInfo.m()) {
                    this.K3.onNext(Boolean.FALSE);
                }
                this.z.onNext(cameraPreviewInfo);
            }
        }
    }

    @Override // com.tplink.iot.widget.camerapreview.d
    public q<Boolean> x0() {
        return this.K3;
    }
}
