package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.messaging.ServiceStarter;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.ble.d;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class BleNoFindActivity extends BaseActivity implements View.OnClickListener {
    private TPMaterialDialogV2 y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            r.g(EnumDeviceType.PLUG.getDeviceType(), BleNoFindActivity.this.z, "NotFindDevicePage");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BleNoFindActivity.this.y != null) {
                BleNoFindActivity.this.y.dismiss();
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
            if (BleNoFindActivity.this.y != null) {
                BleNoFindActivity.this.y.dismiss();
            }
            BleNoFindActivity.this.m1();
        }
    }

    private void h1() {
        if (!d.d(this)) {
            o1();
        } else if (d.b(this)) {
            j1();
        } else {
            startActivityForResult(new Intent(this, LocationAllowActivity.class), ServiceStarter.ERROR_UNKNOWN);
        }
    }

    private void i1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.z = extras.getString("device_model");
        }
    }

    private void j1() {
        setResult(-1);
        finish();
    }

    private void k1() {
        com.tplink.iot.view.quicksetup.base.d.c0(this, (TextView) findViewById(R.id.tv_contact_us), this.z);
        Button button = (Button) findViewById(R.id.btn_bottom);
        button.setText(getString(R.string.try_again));
        button.setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
    }

    public static void l1(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, BleNoFindActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_model", str);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        d.g(this);
    }

    private void n1() {
        com.tplink.iot.view.quicksetup.base.d.e0(this, new a());
    }

    void o1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.y;
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
            this.y = a2;
            a2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 500 && i2 == -1) {
            j1();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        n1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            h1();
        } else if (id == R.id.img_close) {
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_ble_no_find);
            i1();
            k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TPMaterialDialogV2 tPMaterialDialogV2 = this.y;
        if (tPMaterialDialogV2 != null && tPMaterialDialogV2.isShowing()) {
            this.y.dismiss();
        }
    }
}
