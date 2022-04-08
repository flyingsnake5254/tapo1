package com.tplink.iot.view.quicksetup.bulb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class WifiLocationAllowActivity extends BaseActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private TPMaterialDialogV2 p0;
    private TPMaterialDialogV2 p1;
    private QuickSetupInfoBundle y;
    private TPMaterialDialogV2 z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.tplink.iot.view.quicksetup.base.a {
        a() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            WifiLocationAllowActivity.this.k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends com.tplink.iot.view.quicksetup.base.a {
        b() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            WifiLocationAllowActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiLocationAllowActivity.this.z != null) {
                WifiLocationAllowActivity.this.z.dismiss();
            }
            WifiLocationAllowActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiLocationAllowActivity.this.z != null) {
                WifiLocationAllowActivity.this.z.dismiss();
            }
            WifiLocationAllowActivity.this.q1();
        }
    }

    /* loaded from: classes2.dex */
    class e implements com.tplink.iot.view.quicksetup.base.wifi.a {
        e() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void a() {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(WifiLocationAllowActivity.this, "android.permission.ACCESS_COARSE_LOCATION") || !ActivityCompat.shouldShowRequestPermissionRationale(WifiLocationAllowActivity.this, "android.permission.ACCESS_FINE_LOCATION")) {
                WifiLocationAllowActivity.this.l1();
            }
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void b() {
            WifiLocationAllowActivity.this.k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiLocationAllowActivity.this.p1 != null) {
                WifiLocationAllowActivity.this.p1.dismiss();
            }
            WifiLocationAllowActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiLocationAllowActivity.this.p1 != null) {
                WifiLocationAllowActivity.this.p1.dismiss();
            }
            WifiLocationAllowActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    private void j1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.c(this)) {
            com.tplink.iot.view.quicksetup.base.wifi.b.c(this);
        } else if (!com.tplink.iot.view.quicksetup.base.wifi.d.d(this)) {
            s1();
        } else if (!com.tplink.iot.view.quicksetup.base.wifi.d.e(this)) {
            t1();
        } else {
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        r1();
        SoftAPBulbSSIDEmptyActivity.n1(this, this.y);
        finish();
    }

    private void m1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    private void n1() {
        setResult(-1);
        finish();
    }

    private void o1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(new a());
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(new b());
    }

    public static void p1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, WifiLocationAllowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        com.tplink.iot.view.quicksetup.base.wifi.d.f(this);
    }

    private void r1() {
        o.h0().h("has_refused_location_permission", true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_location_allow_wifi);
            m1();
            o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (com.tplink.iot.core.o.a() != 0) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.z;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
                this.z = null;
            }
            TPMaterialDialogV2 tPMaterialDialogV22 = this.p0;
            if (tPMaterialDialogV22 != null) {
                tPMaterialDialogV22.dismiss();
                this.p0 = null;
            }
            TPMaterialDialogV2 tPMaterialDialogV23 = this.p1;
            if (tPMaterialDialogV23 != null) {
                tPMaterialDialogV23.dismiss();
                this.p1 = null;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.tplink.iot.view.quicksetup.base.wifi.b.a(i, strArr, iArr, new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }

    void s1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p1;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_location_access, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new f());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new g());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.p1 = a2;
            a2.show();
        }
    }

    void t1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.z;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_wifi_location_on, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new c());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new d());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.z = a2;
            a2.show();
        }
    }
}
