package com.tplink.iot.view.ipcamera.setting.targrttrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.databinding.ActivityTargetTrackBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: TargetTrackActivity.kt */
/* loaded from: classes2.dex */
public final class TargetTrackActivity extends BaseActivity {
    public static final a y = new a(null);
    public TargetTrackViewModel p0;
    public CloudVideoViewModel p1;
    private final io.reactivex.e0.b p2 = new io.reactivex.e0.b();
    private int p3 = 3;
    public String z;

    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            j.e(context, "context");
            j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, TargetTrackActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            w.I(TargetTrackActivity.this.i1(), j.a(TargetTrackActivity.this.j1().r().getValue(), Boolean.FALSE));
            TargetTrackActivity targetTrackActivity = TargetTrackActivity.this;
            targetTrackActivity.g1(targetTrackActivity.j1().r().getValue());
        }
    }

    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        public static final c a = new c();

        c() {
        }

        /* renamed from: b */
        public final void a(Boolean bool) {
        }
    }

    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements io.reactivex.g0.g<Integer> {

        /* renamed from: c  reason: collision with root package name */
        public static final d f9294c = new d();

        d() {
        }

        /* renamed from: a */
        public final void accept(Integer num) {
        }
    }

    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f9295c = new e();

        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("CameraSettingsActivity", Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements com.tplink.libtpnetwork.Utils.f0.b<String> {
        f() {
        }

        /* renamed from: b */
        public final void a(String str) {
            TSnackbar.y(TargetTrackActivity.this, str, -1).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        g() {
        }

        /* renamed from: b */
        public final void a(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                TargetTrackActivity.this.m1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TargetTrackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        h() {
        }

        /* renamed from: b */
        public final void a(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                TargetTrackActivity targetTrackActivity = TargetTrackActivity.this;
                TrialDialogActivity.f1(targetTrackActivity, com.tplink.iot.Utils.v0.e.o(com.tplink.iot.Utils.z0.h.j(targetTrackActivity.i1())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(Boolean bool) {
        if (j.a(bool, Boolean.TRUE)) {
            TargetTrackViewModel targetTrackViewModel = this.p0;
            if (targetTrackViewModel == null) {
                j.t("mViewModel");
            }
            targetTrackViewModel.z(false);
            return;
        }
        TargetTrackViewModel targetTrackViewModel2 = this.p0;
        if (targetTrackViewModel2 == null) {
            j.t("mViewModel");
        }
        targetTrackViewModel2.i();
    }

    private final void k1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.z = stringExtra;
        this.p3 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.z;
        if (str == null) {
            j.t("mDeviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(TargetTrackViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ackViewModel::class.java)");
        this.p0 = (TargetTrackViewModel) viewModel;
        ViewModel viewModel2 = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
        j.d(viewModel2, "ViewModelProviders.of(th…deoViewModel::class.java)");
        this.p1 = (CloudVideoViewModel) viewModel2;
        TargetTrackViewModel targetTrackViewModel = this.p0;
        if (targetTrackViewModel == null) {
            j.t("mViewModel");
        }
        targetTrackViewModel.v(this.p3);
        TargetTrackViewModel targetTrackViewModel2 = this.p0;
        if (targetTrackViewModel2 == null) {
            j.t("mViewModel");
        }
        targetTrackViewModel2.y(this);
    }

    private final void l1() {
        ActivityTargetTrackBinding activityTargetTrackBinding = (ActivityTargetTrackBinding) DataBindingUtil.setContentView(this, R.layout.activity_target_track);
        j.d(activityTargetTrackBinding, "this");
        activityTargetTrackBinding.setLifecycleOwner(this);
        TargetTrackViewModel targetTrackViewModel = this.p0;
        if (targetTrackViewModel == null) {
            j.t("mViewModel");
        }
        activityTargetTrackBinding.h(targetTrackViewModel);
        activityTargetTrackBinding.q.setOnClickListener(new b());
        setTitle(R.string.target_track_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        CloudVideoViewModel cloudVideoViewModel = this.p1;
        if (cloudVideoViewModel == null) {
            j.t("mCloudVideoViewModel");
        }
        cloudVideoViewModel.N().observe(this, new Observer<List<? extends OrderInfo>>() { // from class: com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity$observeOrders$1
            /* renamed from: a */
            public void onChanged(List<? extends OrderInfo> list) {
                TargetTrackActivity.this.h1().N().removeObserver(this);
                if (TargetTrackActivity.this.h1().H(list, "")) {
                    BillingDialogActivity.f1(TargetTrackActivity.this, e.x());
                    return;
                }
                TargetTrackActivity targetTrackActivity = TargetTrackActivity.this;
                BillingDialogActivity.f1(targetTrackActivity, e.n(h.j(targetTrackActivity.i1())));
            }
        });
    }

    private final void n1() {
        TargetTrackViewModel targetTrackViewModel = this.p0;
        if (targetTrackViewModel == null) {
            j.t("mViewModel");
        }
        com.tplink.libtpnetwork.Utils.j.c(targetTrackViewModel.s(), this, new f());
        TargetTrackViewModel targetTrackViewModel2 = this.p0;
        if (targetTrackViewModel2 == null) {
            j.t("mViewModel");
        }
        com.tplink.libtpnetwork.Utils.j.c(targetTrackViewModel2.o(), this, new g());
        TargetTrackViewModel targetTrackViewModel3 = this.p0;
        if (targetTrackViewModel3 == null) {
            j.t("mViewModel");
        }
        com.tplink.libtpnetwork.Utils.j.c(targetTrackViewModel3.p(), this, new h());
    }

    public final CloudVideoViewModel h1() {
        CloudVideoViewModel cloudVideoViewModel = this.p1;
        if (cloudVideoViewModel == null) {
            j.t("mCloudVideoViewModel");
        }
        return cloudVideoViewModel;
    }

    public final String i1() {
        String str = this.z;
        if (str == null) {
            j.t("mDeviceIdMD5");
        }
        return str;
    }

    public final TargetTrackViewModel j1() {
        TargetTrackViewModel targetTrackViewModel = this.p0;
        if (targetTrackViewModel == null) {
            j.t("mViewModel");
        }
        return targetTrackViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1345) {
            String str = this.z;
            if (str == null) {
                j.t("mDeviceIdMD5");
            }
            this.p2.b(com.tplink.iot.Utils.z0.h.o(str, false, c.a).H0(d.f9294c, e.f9295c));
            com.tplink.iot.Utils.v0.b.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k1();
        l1();
        n1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.p2.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        TargetTrackViewModel targetTrackViewModel = this.p0;
        if (targetTrackViewModel == null) {
            j.t("mViewModel");
        }
        targetTrackViewModel.k();
    }
}
