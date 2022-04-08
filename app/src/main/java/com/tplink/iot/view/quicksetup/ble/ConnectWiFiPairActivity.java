package com.tplink.iot.view.quicksetup.ble;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;

/* loaded from: classes2.dex */
public class ConnectWiFiPairActivity extends BaseActivity implements View.OnClickListener {
    private String H3;
    private TextView I3;
    private Animation J3;
    private ImageView K3;
    private TPMaterialDialogV2 L3;
    private long M3 = 0;
    private QuickSetupViewModel p0;
    private boolean p1;
    private boolean p2;
    private boolean p3;
    private QuickSetupInfoBean y;
    private QuickSetupDeviceInfoBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            ConnectWiFiPairActivity.this.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                ConnectWiFiPairActivity.this.m1();
            } else {
                ConnectWiFiPairActivity.this.n1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            if (ConnectWiFiPairActivity.this.p1) {
                ConnectWiFiPairActivity.this.p3 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        this.K3.setVisibility(0);
        this.K3.startAnimation(this.J3);
        this.I3.setText(getString(R.string.quicksetup_pairing_device));
        this.I3.setTextColor(getResources().getColor(R.color.common_gray_black_color_transparent_80));
        k1();
    }

    private void k1() {
        this.M3 = System.currentTimeMillis();
        this.p0.P(this.y.getResultDeviceIdMD5(), this.p1, this.p2);
    }

    private void l1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            this.z = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        FindDeviceFailedActivity.m1(this, this.y, this.z);
        p1();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        if (this.p1) {
            this.p3 = true;
        }
        s1();
    }

    private void o1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_ssid);
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        String ssid = quickSetupInfoBean != null ? quickSetupInfoBean.getSsid() : null;
        if (ssid == null) {
            ssid = "";
        }
        d0.a(textView, getString(R.string.quicksetup_settings_and_connect, new Object[]{ssid}), ssid, ContextCompat.getColor(this, R.color.common_iot_purple));
        this.K3 = (ImageView) findViewById(R.id.iv_device_loading);
        TextView textView2 = (TextView) findViewById(R.id.tv_bottom_tip);
        this.I3 = textView2;
        d0.h(textView2, getString(R.string.quicksetup_already_connected), ContextCompat.getColor(this, R.color.common_iot_purple), new a());
    }

    private void p1() {
        if (this.y != null) {
            r.v(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.M3) / 1000));
        }
    }

    private void q1() {
        if (this.y != null) {
            r.u(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.M3) / 1000));
        }
    }

    public static void r1(Context context, QuickSetupInfoBean quickSetupInfoBean, QuickSetupDeviceInfoBean quickSetupDeviceInfoBean) {
        Intent intent = new Intent(context, ConnectWiFiPairActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("device_info_bean", quickSetupInfoBean);
        bundle.putSerializable("device_info", quickSetupDeviceInfoBean);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void s1() {
        CommonQuickSetupBean commonQuickSetupBean;
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            if (this.p1) {
                quickSetupInfoBean.setDeviceIdMD5(quickSetupInfoBean.getResultDeviceIdMD5());
            }
            commonQuickSetupBean = new CommonQuickSetupBean(this.y.getDeviceIdMD5(), this.y.getComponentResult());
        } else {
            commonQuickSetupBean = null;
        }
        SetupSuccessActivity.p1(this, commonQuickSetupBean, this.z, 0L);
        q1();
        finish();
    }

    private void t1() {
        this.p0.b0().observe(this, new b());
    }

    private void u1() {
        this.L3 = d.h0(this, new c());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        u1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            u1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_connect_wifi_pair);
            this.J3 = AnimationUtils.loadAnimation(this, R.anim.anim_common_roate);
            l1();
            QuickSetupInfoBean quickSetupInfoBean = this.y;
            if (quickSetupInfoBean != null) {
                this.H3 = quickSetupInfoBean.getDeviceIdMD5();
            }
            this.p1 = d.L(this.y);
            this.p2 = d.W(this.y);
            if (this.p1) {
                QuickSetupInfoBean quickSetupInfoBean2 = this.y;
                this.p0 = (QuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBean2 == null ? "" : quickSetupInfoBean2.getDeviceIdMD5())).get(QuickSetupViewModel.class);
            } else {
                this.p0 = (QuickSetupViewModel) ViewModelProviders.of(this).get(QuickSetupViewModel.class);
            }
            o1();
            t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (o.a() != 0) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.L3;
            if (tPMaterialDialogV2 != null && tPMaterialDialogV2.isShowing()) {
                this.L3.dismiss();
            }
            this.p0.F();
            if (this.p3) {
                this.p0.F0(this.H3);
            }
            ImageView imageView = this.K3;
            if (imageView != null) {
                imageView.clearAnimation();
            }
        }
    }
}
