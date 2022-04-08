package com.tplink.iot.view.quicksetup.discovery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDiscoveryDevicePairingFailedBinding;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: DiscoveryDevicePairingFailedActivity.kt */
/* loaded from: classes2.dex */
public final class DiscoveryDevicePairingFailedActivity extends BaseActivity {
    public static final a y = new a(null);
    private String p0 = "";
    private ActivityDiscoveryDevicePairingFailedBinding z;

    /* compiled from: DiscoveryDevicePairingFailedActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Activity activity, String str, int i) {
            j.e(activity, "activity");
            Intent intent = new Intent(activity, DiscoveryDevicePairingFailedActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("device_model", str);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiscoveryDevicePairingFailedActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DiscoveryDevicePairingFailedActivity.this.setResult(-1);
            DiscoveryDevicePairingFailedActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiscoveryDevicePairingFailedActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DiscoveryDevicePairingFailedActivity.this.i1();
        }
    }

    private final void f1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_model")) == null) {
            str = "";
        }
        this.p0 = str;
    }

    private final void g1() {
        ActivityDiscoveryDevicePairingFailedBinding activityDiscoveryDevicePairingFailedBinding = this.z;
        if (activityDiscoveryDevicePairingFailedBinding == null) {
            j.t("mBinding");
        }
        activityDiscoveryDevicePairingFailedBinding.f6557c.setOnClickListener(new b());
        ActivityDiscoveryDevicePairingFailedBinding activityDiscoveryDevicePairingFailedBinding2 = this.z;
        if (activityDiscoveryDevicePairingFailedBinding2 == null) {
            j.t("mBinding");
        }
        activityDiscoveryDevicePairingFailedBinding2.f6558d.setOnClickListener(new c());
    }

    public static final void h1(Activity activity, String str, int i) {
        y.a(activity, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        EnumDeviceType l = com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.p0);
        j.d(l, "SoftApOnboardingUtils.ge…TypeByModel(mDeviceModel)");
        com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, l.getDeviceType(), this.p0, "PairingFailedPage");
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        i1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_discovery_device_pairing_failed);
        j.d(contentView, "DataBindingUtil.setConte…ry_device_pairing_failed)");
        this.z = (ActivityDiscoveryDevicePairingFailedBinding) contentView;
        f1();
        g1();
    }
}
