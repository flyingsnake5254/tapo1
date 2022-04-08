package com.tplink.iot.devices.lightstrip.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding;
import com.tplink.iot.view.quicksetup.lightstrip.LightStripUserGuideActivity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: LightStripPlacementGuideActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripPlacementGuideActivity extends BaseActivity {
    public static final a y = new a(null);
    private String p0;
    private boolean p1;
    private boolean p2;
    private ActivityLightStripPlacementGuideBinding z;

    /* compiled from: LightStripPlacementGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceModel, boolean z) {
            j.e(context, "context");
            j.e(deviceModel, "deviceModel");
            b(context, deviceModel, z, false);
        }

        public final void b(Context context, String deviceModel, boolean z, boolean z2) {
            j.e(context, "context");
            j.e(deviceModel, "deviceModel");
            Intent intent = new Intent(context, LightStripPlacementGuideActivity.class);
            intent.putExtra("device_model", deviceModel);
            intent.putExtra("ExtraIsOnboarding", z);
            intent.putExtra("ExtraIsFromDiscovery", z2);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripPlacementGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LightStripPlacementGuideActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripPlacementGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LightStripPlacementGuideActivity lightStripPlacementGuideActivity = LightStripPlacementGuideActivity.this;
            LightStripUserGuideActivity.g1(lightStripPlacementGuideActivity, lightStripPlacementGuideActivity.p2);
        }
    }

    private final void f1() {
        Intent intent = getIntent();
        this.p0 = intent != null ? intent.getStringExtra("device_model") : null;
        Intent intent2 = getIntent();
        boolean z = false;
        this.p1 = intent2 != null ? intent2.getBooleanExtra("ExtraIsOnboarding", false) : false;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            z = intent3.getBooleanExtra("ExtraIsFromDiscovery", false);
        }
        this.p2 = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g1() {
        /*
            r6 = this;
            java.lang.String r0 = r6.p0
            r1 = 0
            java.lang.String r2 = "mBinding"
            if (r0 == 0) goto L_0x0021
            r3 = 2
            r4 = 0
            java.lang.String r5 = "L930"
            boolean r0 = kotlin.text.m.A(r0, r5, r1, r3, r4)
            if (r0 != 0) goto L_0x0021
            com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding r0 = r6.z
            if (r0 != 0) goto L_0x0018
            kotlin.jvm.internal.j.t(r2)
        L_0x0018:
            android.widget.TextView r0 = r0.q
            r3 = 2131952971(0x7f13054b, float:1.95424E38)
            r0.setText(r3)
            goto L_0x0030
        L_0x0021:
            com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding r0 = r6.z
            if (r0 != 0) goto L_0x0028
            kotlin.jvm.internal.j.t(r2)
        L_0x0028:
            android.widget.TextView r0 = r0.q
            r3 = 2131952969(0x7f130549, float:1.9542396E38)
            r0.setText(r3)
        L_0x0030:
            com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding r0 = r6.z
            if (r0 != 0) goto L_0x0037
            kotlin.jvm.internal.j.t(r2)
        L_0x0037:
            android.widget.ImageView r0 = r0.f6591d
            com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity$b r3 = new com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity$b
            r3.<init>()
            r0.setOnClickListener(r3)
            boolean r0 = r6.p1
            if (r0 == 0) goto L_0x0067
            com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding r0 = r6.z
            if (r0 != 0) goto L_0x004c
            kotlin.jvm.internal.j.t(r2)
        L_0x004c:
            android.widget.Button r0 = r0.f6590c
            java.lang.String r3 = "mBinding.btnDone"
            kotlin.jvm.internal.j.d(r0, r3)
            r0.setVisibility(r1)
            com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding r0 = r6.z
            if (r0 != 0) goto L_0x005d
            kotlin.jvm.internal.j.t(r2)
        L_0x005d:
            android.widget.Button r0 = r0.f6590c
            com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity$c r1 = new com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity$c
            r1.<init>()
            r0.setOnClickListener(r1)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity.g1():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_light_strip_placement_guide);
        j.d(contentView, "DataBindingUtil.setConte…ht_strip_placement_guide)");
        this.z = (ActivityLightStripPlacementGuideBinding) contentView;
        f1();
        g1();
    }
}
