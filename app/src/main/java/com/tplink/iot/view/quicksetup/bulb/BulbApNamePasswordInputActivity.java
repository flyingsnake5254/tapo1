package com.tplink.iot.view.quicksetup.bulb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

/* loaded from: classes2.dex */
public class BulbApNamePasswordInputActivity extends BaseActivity implements View.OnClickListener {
    private TPMaterialDialogV2 H3;
    private Button p0;
    private QuickSetupInfoBundle p1;
    private e p2;
    private TPMaterialDialogV2 p3;
    private DrawableEditText y;
    private DrawableEditText z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BulbApNamePasswordInputActivity.this.p0.setEnabled(BulbApNamePasswordInputActivity.this.i1());
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
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BulbApNamePasswordInputActivity.this.p0.setEnabled(BulbApNamePasswordInputActivity.this.i1());
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
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            BulbApNamePasswordInputActivity.this.h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TPMaterialDialogV2.d {
        d() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            BulbApNamePasswordInputActivity.this.h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        if (this.p1.inNeedDisplayInherit()) {
            l1();
        } else {
            r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i1() {
        return com.tplink.iot.view.quicksetup.base.d.g(this.y.getText().toString(), this.z.getText().toString());
    }

    private void j1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p1 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    private WirelessInfoParams k1() {
        String obj = this.y.getText().toString();
        String obj2 = this.z.getText().toString();
        WirelessInfoParams wirelessInfoParams = new WirelessInfoParams();
        wirelessInfoParams.setSsid(obj);
        if (TextUtils.isEmpty(obj2)) {
            wirelessInfoParams.setKeyType("none");
        } else {
            wirelessInfoParams.setPassword(obj2);
            wirelessInfoParams.setKeyType("wpa2_psk");
        }
        return wirelessInfoParams;
    }

    private void l1() {
        BulbInheritBeforeSetQsInfoActivity.h1(this, this.p1, k1());
    }

    private void m1() {
        SoftAPBulbConnectAPActivity.y1(this, this.p1, k1());
        r.t(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
        finish();
    }

    private void n1() {
        this.y.f(new a());
    }

    private void o1() {
        this.z.f(new b());
    }

    private void p1() {
        this.p2 = new e(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        this.y = (DrawableEditText) findViewById(R.id.edit_name);
        this.z = (DrawableEditText) findViewById(R.id.edit_password);
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.p0 = button;
        button.setText(getString(R.string.common_next));
        this.p0.setEnabled(false);
        this.p0.setOnClickListener(this);
        n1();
        o1();
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
    }

    public static void q1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, BulbApNamePasswordInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void r1() {
        if (com.tplink.iot.view.quicksetup.bulb.utils.a.f(this, this.p1)) {
            m1();
        } else {
            this.p2.d(this.p1.getBulbSSID());
        }
    }

    private void s1() {
        String obj = this.y.getText().toString();
        String obj2 = this.z.getText().toString();
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_name_password, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_ssid)).setText(obj);
        ((TextView) inflate.findViewById(R.id.tv_password)).setText(obj2);
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(this).setView(inflate).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_next, R.color.common_iot_main_blue, new d()).g(8, 8).create();
        this.H3 = a2;
        a2.show();
    }

    private void t1() {
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(this).setMessage(R.string.quicksetup_ap_password_key_none).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.quicksetup_ap_password_key_none_continue, R.color.common_iot_main_blue, new c()).g(8, 8).create();
        this.p3 = a2;
        a2.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            com.tplink.iot.view.quicksetup.base.d.I(this);
            if (TextUtils.isEmpty(this.z.getText().toString())) {
                t1();
            } else {
                s1();
            }
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_softap_bulb_input_ap_name_pwd);
            j1();
            p1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tplink.iot.view.quicksetup.base.d.I(this);
        e eVar = this.p2;
        if (eVar != null) {
            eVar.b();
        }
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p3;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.p3 = null;
        }
        TPMaterialDialogV2 tPMaterialDialogV22 = this.H3;
        if (tPMaterialDialogV22 != null) {
            tPMaterialDialogV22.dismiss();
            this.H3 = null;
        }
    }
}
