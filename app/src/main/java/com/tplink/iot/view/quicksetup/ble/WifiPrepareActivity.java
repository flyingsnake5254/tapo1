package com.tplink.iot.view.quicksetup.ble;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.broadcast.wifi.WifiStateReceiver;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

/* loaded from: classes2.dex */
public class WifiPrepareActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout H3;
    private RelativeLayout I3;
    private TPMaterialDialogV2 J3;
    private boolean K3;
    private Handler L3;
    private boolean M3 = true;
    private WifiStateReceiver N3;
    private ImageView p0;
    private ImageView p1;
    private ViewGroup p2;
    private LinearLayout p3;
    private ImageView y;
    private TPCircleProgressBar z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiPrepareActivity.this.J3 != null) {
                WifiPrepareActivity.this.J3.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WifiPrepareActivity.this.J3 != null) {
                WifiPrepareActivity.this.J3.dismiss();
            }
            WifiPrepareActivity.this.q1();
        }
    }

    /* loaded from: classes2.dex */
    class c implements com.tplink.iot.view.quicksetup.base.wifi.a {
        c() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void a() {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(WifiPrepareActivity.this, "android.permission.ACCESS_COARSE_LOCATION") || !ActivityCompat.shouldShowRequestPermissionRationale(WifiPrepareActivity.this, "android.permission.ACCESS_FINE_LOCATION")) {
                WifiPrepareActivity.this.z1();
            }
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void b() {
            WifiPrepareActivity.this.u1();
            WifiPrepareActivity.this.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements com.tplink.iot.view.quicksetup.base.broadcast.wifi.a {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!WifiPrepareActivity.this.isDestroyed() && !WifiPrepareActivity.this.isFinishing()) {
                    WifiPrepareActivity.this.m1();
                }
            }
        }

        d() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.broadcast.wifi.a
        public void a() {
            WifiPrepareActivity.this.v1(false);
        }

        @Override // com.tplink.iot.view.quicksetup.base.broadcast.wifi.a
        public void b() {
            WifiPrepareActivity.this.v1(true);
            WifiPrepareActivity.this.L3.postDelayed(new a(), 200L);
        }

        @Override // com.tplink.iot.view.quicksetup.base.broadcast.wifi.a
        public void c() {
            WifiPrepareActivity.this.y.setVisibility(8);
            WifiPrepareActivity.this.z.setVisibility(0);
            WifiPrepareActivity.this.z.h();
        }
    }

    private void A1() {
        WifiStateReceiver wifiStateReceiver = this.N3;
        if (wifiStateReceiver != null) {
            unregisterReceiver(wifiStateReceiver);
            this.N3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            finish();
        }
    }

    private void n1() {
        p1();
        if (this.K3) {
            o1();
        }
    }

    private void o1() {
        boolean d2 = com.tplink.iot.view.quicksetup.base.wifi.d.d(this);
        boolean c2 = com.tplink.iot.view.quicksetup.base.wifi.d.c(this);
        if (!d2 || !c2) {
            this.p3.setVisibility(0);
        } else {
            this.p3.setVisibility(8);
        }
        if (d2) {
            this.H3.setVisibility(8);
        } else {
            this.H3.setVisibility(0);
            this.p0.setEnabled(true);
            this.p0.setImageResource(R.mipmap.switch_off);
        }
        if (c2) {
            this.I3.setVisibility(8);
            return;
        }
        this.I3.setVisibility(0);
        this.p1.setEnabled(true);
        this.p1.setImageResource(R.mipmap.switch_off);
    }

    private void p1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.e(this)) {
            this.p2.setVisibility(8);
            return;
        }
        this.y.setEnabled(true);
        this.y.setImageResource(R.mipmap.switch_off);
        this.p2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + getPackageName())));
    }

    private void r1() {
        this.L3 = new Handler();
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_android_6);
        this.p3 = linearLayout;
        int i = 0;
        boolean z = Build.VERSION.SDK_INT >= 23;
        this.K3 = z;
        if (!z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.y = (ImageView) findViewById(R.id.img_wifi_state);
        TPCircleProgressBar tPCircleProgressBar = (TPCircleProgressBar) findViewById(R.id.progress);
        this.z = tPCircleProgressBar;
        tPCircleProgressBar.setProgressBarColor(ContextCompat.getColor(this, R.color.common_iot_main_blue));
        this.p0 = (ImageView) findViewById(R.id.img_location_state);
        this.p1 = (ImageView) findViewById(R.id.img_permission_state);
        this.H3 = (RelativeLayout) findViewById(R.id.rl_location_access);
        this.I3 = (RelativeLayout) findViewById(R.id.location_permission);
        this.p0.setOnClickListener(this);
        this.p1.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.p2 = (ViewGroup) findViewById(R.id.ll_wifi);
    }

    private void s1() {
        if (this.N3 == null) {
            WifiStateReceiver wifiStateReceiver = new WifiStateReceiver();
            this.N3 = wifiStateReceiver;
            wifiStateReceiver.b(new d());
            registerReceiver(this.N3, WifiStateReceiver.a());
        }
    }

    private void t1() {
        com.tplink.iot.view.quicksetup.base.wifi.d.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        y1();
        if (this.K3) {
            w1();
            x1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(boolean z) {
        if (this.z.e()) {
            this.z.i();
            this.z.setVisibility(4);
            this.y.setVisibility(0);
        }
        if (z) {
            this.y.setEnabled(false);
            this.y.setImageResource(R.mipmap.permission_ok);
            return;
        }
        this.y.setEnabled(true);
        this.y.setImageResource(R.mipmap.switch_off);
    }

    private void w1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.d(this)) {
            this.p0.setEnabled(false);
            this.p0.setImageResource(R.mipmap.permission_ok);
            return;
        }
        this.p0.setEnabled(true);
        this.p0.setImageResource(R.mipmap.switch_off);
    }

    private void x1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.c(this)) {
            this.p1.setEnabled(false);
            this.p1.setImageResource(R.mipmap.permission_ok);
            return;
        }
        this.p1.setEnabled(true);
        this.p1.setImageResource(R.mipmap.switch_off);
    }

    private void y1() {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.e(this)) {
            this.y.setEnabled(false);
            this.y.setImageResource(R.mipmap.permission_ok);
        } else if (!this.z.e()) {
            this.y.setEnabled(true);
            this.y.setImageResource(R.mipmap.switch_off);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131362826 */:
                finish();
                return;
            case R.id.img_location_state /* 2131362841 */:
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            case R.id.img_permission_state /* 2131362845 */:
                com.tplink.iot.view.quicksetup.base.wifi.b.c(this);
                return;
            case R.id.img_wifi_state /* 2131362851 */:
                t1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_wifi_prepare);
            r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.L3;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        TPMaterialDialogV2 tPMaterialDialogV2 = this.J3;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.J3 = null;
        }
        A1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.K3) {
            com.tplink.iot.view.quicksetup.base.wifi.b.a(i, strArr, iArr, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.M3) {
            this.M3 = false;
            n1();
            s1();
            return;
        }
        u1();
        m1();
    }

    void z1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.J3;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_location_permission, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new a());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new b());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.J3 = a2;
            a2.show();
        }
    }
}
