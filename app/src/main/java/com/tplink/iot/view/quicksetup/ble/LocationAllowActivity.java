package com.tplink.iot.view.quicksetup.ble;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class LocationAllowActivity extends BaseActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private TPMaterialDialogV2 p0;
    private TPMaterialDialogV2 p1;
    private String y;
    private TPMaterialDialogV2 z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.tplink.iot.view.quicksetup.base.a {
        a() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            LocationAllowActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.z != null) {
                LocationAllowActivity.this.z.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.z != null) {
                LocationAllowActivity.this.z.dismiss();
            }
            LocationAllowActivity.this.q1();
        }
    }

    /* loaded from: classes2.dex */
    class d implements com.tplink.iot.view.quicksetup.base.ble.a {
        d() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.ble.a
        public void a() {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(LocationAllowActivity.this, "android.permission.ACCESS_COARSE_LOCATION") || !ActivityCompat.shouldShowRequestPermissionRationale(LocationAllowActivity.this, "android.permission.ACCESS_FINE_LOCATION")) {
                LocationAllowActivity.this.t1();
            }
        }

        @Override // com.tplink.iot.view.quicksetup.base.ble.a
        public void b() {
            LocationAllowActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.p0 != null) {
                LocationAllowActivity.this.p0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.p0 != null) {
                LocationAllowActivity.this.p0.dismiss();
            }
            LocationAllowActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.p1 != null) {
                LocationAllowActivity.this.p1.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationAllowActivity.this.p1 != null) {
                LocationAllowActivity.this.p1.dismiss();
            }
            LocationAllowActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    private void k1() {
        if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        if (!com.tplink.iot.view.quicksetup.base.ble.d.d(this)) {
            r1();
        } else if (!com.tplink.iot.view.quicksetup.base.ble.d.f(this)) {
            com.tplink.iot.view.quicksetup.base.ble.b.c(this);
        } else if (!com.tplink.iot.view.quicksetup.base.ble.d.c(this)) {
            s1();
        } else {
            n1();
        }
    }

    private void m1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = extras.getString("device");
        }
    }

    private void n1() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + getPackageName())));
    }

    private void p1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        com.tplink.iot.view.quicksetup.base.ble.d.g(this);
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
        if (o.a() != 0) {
            setContentView(R.layout.activity_location_allow_ble);
            m1();
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (o.a() != 0) {
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
        com.tplink.iot.view.quicksetup.base.ble.b.a(i, strArr, iArr, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        k1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }

    void r1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.z;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_on, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new b());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new c());
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

    void s1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p1;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_location_access, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new g());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new h());
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
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p0;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_location_permission, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new e());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new f());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.p0 = a2;
            a2.show();
        }
    }
}
