package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

/* loaded from: classes2.dex */
public class BulbNickNameInputActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBundle p0;
    private CharSequence p1;
    private BulbQuickSetupViewModel p2;
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
                editable.delete(BulbNickNameInputActivity.this.p1.length() - 1, BulbNickNameInputActivity.this.p1.length());
                BulbNickNameInputActivity.this.y.setText(editable);
                BulbNickNameInputActivity.this.y.setSelection(editable.length());
            }
            BulbNickNameInputActivity.this.z.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            BulbNickNameInputActivity.this.p1 = charSequence;
        }
    }

    private void i1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p0 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    private void j1() {
        String obj = this.y.getText().toString();
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean();
        quickSetupDeviceInfoBean.setNickname(obj);
        List<RoomInfo> R = this.p2.R();
        if (R == null || R.isEmpty()) {
            com.tplink.iot.view.quicksetup.bulb.utils.a.b(this, BulbLocationCustomActivity.class, this.p0, quickSetupDeviceInfoBean);
        } else {
            com.tplink.iot.view.quicksetup.bulb.utils.a.b(this, BulbLocationSelectActivity.class, this.p0, quickSetupDeviceInfoBean);
        }
        r.k(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5(), obj);
    }

    private void k1() {
        this.y.f(new a());
    }

    private void l1() {
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.z = button;
        button.setText(getString(R.string.common_next));
        this.z.setEnabled(true);
        this.z.setOnClickListener(this);
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.draw_edit_name);
        this.y = drawableEditText;
        drawableEditText.setText(b.j(this.p0.getDeviceModel()));
        k1();
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
    }

    public static void m1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, BulbNickNameInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
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
            setContentView(R.layout.activity_qs_bulb_name_input);
            QuickSetupInfoBundle quickSetupInfoBundle = this.p0;
            BulbQuickSetupViewModel bulbQuickSetupViewModel = (BulbQuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBundle == null ? "" : quickSetupInfoBundle.getDeviceIdMD5())).get(BulbQuickSetupViewModel.class);
            this.p2 = bulbQuickSetupViewModel;
            bulbQuickSetupViewModel.B0(this.p0.getDeviceModel());
            l1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
    }
}
