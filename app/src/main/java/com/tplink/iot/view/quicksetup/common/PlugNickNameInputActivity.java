package com.tplink.iot.view.quicksetup.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.PlugIoTLocationCustomActivity;
import com.tplink.iot.view.quicksetup.ble.PlugIoTLocationSelectActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugNickNameInputActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBean p0;
    private CharSequence p1;
    private QuickSetupViewModel p2;
    private DrawableEditText y;
    private Button z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().getBytes().length > 64) {
                editable.delete(PlugNickNameInputActivity.this.p1.length() - 1, PlugNickNameInputActivity.this.p1.length());
                PlugNickNameInputActivity.this.y.setText(editable);
                PlugNickNameInputActivity.this.y.setSelection(editable.length());
            }
            PlugNickNameInputActivity.this.z.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PlugNickNameInputActivity.this.p1 = charSequence;
        }
    }

    private void i1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p0 = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
        }
    }

    private void j1() {
        String obj = this.y.getText().toString();
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean();
        quickSetupDeviceInfoBean.setNickname(obj);
        if (d.W(this.p0)) {
            k1(quickSetupDeviceInfoBean);
        } else {
            l1(quickSetupDeviceInfoBean);
        }
        o1(obj);
    }

    private void k1(QuickSetupDeviceInfoBean quickSetupDeviceInfoBean) {
        List<RoomInfo> Z = this.p2.Z();
        if (Z == null || Z.isEmpty()) {
            d.C(this, PlugIoTLocationCustomActivity.class, this.p0, quickSetupDeviceInfoBean);
        } else {
            d.C(this, PlugIoTLocationSelectActivity.class, this.p0, quickSetupDeviceInfoBean);
        }
    }

    private void l1(QuickSetupDeviceInfoBean quickSetupDeviceInfoBean) {
        d.C(this, PlugLocationSelectActivity.class, this.p0, quickSetupDeviceInfoBean);
    }

    private void m1() {
        this.y.f(new a());
    }

    private void n1() {
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.z = button;
        button.setText(getString(R.string.common_next));
        this.z.setEnabled(true);
        this.z.setOnClickListener(this);
        this.y = (DrawableEditText) findViewById(R.id.draw_edit_name);
        m1();
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
    }

    private void o1(String str) {
        QuickSetupInfoBean quickSetupInfoBean = this.p0;
        if (quickSetupInfoBean != null) {
            r.k(quickSetupInfoBean.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5(), str);
        }
    }

    public static void p1(Context context, QuickSetupInfoBean quickSetupInfoBean) {
        Intent intent = new Intent(context, PlugNickNameInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("device_info_bean", quickSetupInfoBean);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            i1();
            if (d.L(this.p0)) {
                QuickSetupInfoBean quickSetupInfoBean = this.p0;
                this.p2 = (QuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBean == null ? "" : quickSetupInfoBean.getDeviceIdMD5())).get(QuickSetupViewModel.class);
            }
            setContentView(R.layout.activity_qs_plug_name_input);
            n1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
    }
}
