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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class BulbApPasswordInputActivity extends BaseActivity implements View.OnClickListener {
    private e H3;
    private CheckBox p0;
    private QuickSetupInfoBundle p1;
    private WirelessInfoParams p2 = null;
    private TPMaterialDialogV2 p3;
    private DrawableEditText y;
    private Button z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BulbApPasswordInputActivity.this.z.setEnabled(BulbApPasswordInputActivity.this.i1(editable.toString()));
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
            BulbApPasswordInputActivity.this.h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        if (this.p1.inNeedDisplayInherit()) {
            k1();
        } else {
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i1(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 8 || str.length() > 64) {
            return false;
        }
        return b.d.w.e.b.b(str);
    }

    private void j1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p1 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
            this.p2 = (WirelessInfoParams) extras.getSerializable("ap_ssid");
        }
    }

    private void k1() {
        r1();
        BulbInheritBeforeSetQsInfoActivity.h1(this, this.p1, this.p2);
    }

    private void l1() {
        r1();
        SoftAPBulbConnectAPActivity.y1(this, this.p1, this.p2);
        r.t(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
        finish();
    }

    private void m1() {
        this.y.f(new a());
        String V = o.h0().V(this.p2.getSsid());
        b.d.w.c.a.e("wireless", "wirelessPwd=" + V);
        if (!TextUtils.isEmpty(V)) {
            this.y.setText(V);
            this.y.setSelection(V.length());
            this.p0.setChecked(true);
        }
    }

    private void n1() {
        this.H3 = new e(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_name)).setText(this.p2.getSsid());
        ((TextView) findViewById(R.id.tv_select)).setOnClickListener(this);
        this.p0 = (CheckBox) findViewById(R.id.cb_save_password);
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.z = button;
        button.setText(getString(R.string.common_next));
        this.z.setEnabled(false);
        this.z.setOnClickListener(this);
        this.y = (DrawableEditText) findViewById(R.id.edit_password);
        m1();
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
    }

    public static void o1(Context context, QuickSetupInfoBundle quickSetupInfoBundle, WirelessInfoParams wirelessInfoParams) {
        Intent intent = new Intent(context, BulbApPasswordInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        if (wirelessInfoParams != null) {
            bundle.putSerializable("ap_ssid", wirelessInfoParams);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void p1() {
        if (com.tplink.iot.view.quicksetup.bulb.utils.a.f(this, this.p1)) {
            l1();
        } else {
            this.H3.d(this.p1.getBulbSSID());
        }
    }

    private void q1() {
        String ssid = this.p2.getSsid();
        String obj = this.y.getText().toString();
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_name_password, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_ssid)).setText(ssid);
        ((TextView) inflate.findViewById(R.id.tv_password)).setText(obj);
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(this).setView(inflate).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_next, R.color.common_iot_main_blue, new b()).g(8, 8).create();
        this.p3 = a2;
        a2.show();
    }

    private void r1() {
        this.p2.setPassword(this.y.getText().toString());
        com.tplink.iot.view.quicksetup.bulb.utils.a.g(this.p0.isChecked(), this.p2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            d.I(this);
            q1();
        } else if (id == R.id.img_back || id == R.id.tv_select) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_softap_bulb_input_ap_pwd);
            j1();
            n1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
        e eVar = this.H3;
        if (eVar != null) {
            eVar.b();
        }
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p3;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.p3 = null;
        }
    }
}
