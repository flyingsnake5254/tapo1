package com.tplink.iot.view.quicksetup.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.BlePlugConnectAPActivity;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class ApPasswordInputActivity extends BaseActivity implements View.OnClickListener {
    private CheckBox p0;
    private TPMaterialDialogV2 p1;
    private QuickSetupInfoBean p2;
    private WirelessInfoParams p3 = null;
    private DrawableEditText y;
    private Button z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ApPasswordInputActivity.this.z.setEnabled(ApPasswordInputActivity.this.h1(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            ApPasswordInputActivity.this.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h1(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 8 || str.length() > 64) {
            return false;
        }
        return b.d.w.e.b.b(str);
    }

    private void i1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p2 = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            this.p3 = (WirelessInfoParams) extras.getSerializable("ap_ssid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        this.p3.setPassword(this.y.getText().toString());
        com.tplink.iot.view.quicksetup.bulb.utils.a.g(this.p0.isChecked(), this.p3);
        d.E(this, BlePlugConnectAPActivity.class, this.p2, this.p3, 160);
        m1();
    }

    private void k1() {
        this.y.f(new a());
        String V = o.h0().V(this.p3.getSsid());
        if (!TextUtils.isEmpty(V)) {
            this.y.setText(V);
            this.y.setSelection(V.length());
            this.p0.setChecked(true);
        }
    }

    private void l1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_name)).setText(this.p3.getSsid());
        ((TextView) findViewById(R.id.tv_select)).setOnClickListener(this);
        this.p0 = (CheckBox) findViewById(R.id.cb_save_password);
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.z = button;
        button.setText(getString(R.string.common_next));
        this.z.setEnabled(false);
        this.z.setOnClickListener(this);
        this.y = (DrawableEditText) findViewById(R.id.edit_password);
        k1();
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
    }

    private void m1() {
        QuickSetupInfoBean quickSetupInfoBean = this.p2;
        if (quickSetupInfoBean != null) {
            r.t(quickSetupInfoBean.getDeviceType(), this.p2.getDeviceModel(), this.p2.getDeviceIdMD5());
        }
    }

    private void n1() {
        String ssid = this.p3.getSsid();
        String obj = this.y.getText().toString();
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_name_password, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_ssid)).setText(ssid);
        ((TextView) inflate.findViewById(R.id.tv_password)).setText(obj);
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(this).setView(inflate).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_next, R.color.common_iot_main_blue, new b()).g(8, 8).create();
        this.p1 = a2;
        a2.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 160) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        switch (i2) {
            case -1705:
                s0.r(this, getString(R.string.quicksetup_encryption_not_supported), 5000L);
                return;
            case -1704:
                s0.r(this, getString(R.string.quicksetup_can_not_find), 5000L);
                return;
            case -1703:
                s0.r(this, getString(R.string.quicksetup_double_check), 5000L);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            d.I(this);
            n1();
        } else if (id == R.id.img_back) {
            finish();
        } else if (id == R.id.tv_select) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_qs_plug_network_input);
            i1();
            l1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p1;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.p1 = null;
        }
        s0.g();
    }
}
