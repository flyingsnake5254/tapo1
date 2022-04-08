package com.tplink.iot.view.quicksetup.bulb.quicksetup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class BulbLocationCustomActivity extends BaseActivity implements View.OnClickListener, FlowTagLayout.c {
    private QuickSetupDeviceInfoBean p0;
    private CharSequence p1;
    private DrawableEditText y;
    private QuickSetupInfoBundle z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Button f9636c;

        a(Button button) {
            this.f9636c = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().getBytes().length > 64) {
                editable.delete(BulbLocationCustomActivity.this.p1.length() - 1, BulbLocationCustomActivity.this.p1.length());
                BulbLocationCustomActivity.this.y.setText(editable);
                BulbLocationCustomActivity.this.y.setSelection(editable.length());
            }
            this.f9636c.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            BulbLocationCustomActivity.this.p1 = charSequence;
        }
    }

    private void h1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.z = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
            this.p0 = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    private ArrayList<String> i1() {
        EnumDeviceNicknameType[] values;
        ArrayList<String> arrayList = new ArrayList<>();
        for (EnumDeviceNicknameType enumDeviceNicknameType : EnumDeviceNicknameType.values()) {
            if (enumDeviceNicknameType != EnumDeviceNicknameType.CUSTOM) {
                arrayList.add(EnumDeviceNicknameType.fromType(enumDeviceNicknameType));
            }
        }
        return arrayList;
    }

    private void j1() {
        String obj = this.y.getText().toString();
        this.p0.setLocation(obj);
        com.tplink.iot.view.quicksetup.bulb.utils.a.b(this, BulbIconSelectActivity.class, this.z, this.p0);
        r.j(this.z.getDeviceType(), this.z.getDeviceModel(), this.z.getDeviceIdMD5(), obj, true);
    }

    private void k1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        Button button = (Button) findViewById(R.id.btn_bottom);
        button.setText(getString(R.string.common_next));
        button.setOnClickListener(this);
        button.setEnabled(false);
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.draw_edit_text);
        this.y = drawableEditText;
        drawableEditText.f(new a(button));
        this.y.getEditText().requestFocus();
        this.y.getEditText().setFocusable(true);
        this.y.getEditText().setFocusableInTouchMode(true);
        ((FlowTagLayout) findViewById(R.id.flow_tag_layout)).c(i1(), this);
    }

    @Override // com.tplink.iot.widget.FlowTagLayout.c
    public void G(String str) {
        l.m(this.y, str);
        d.I(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            j1();
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_bulb_location_custom);
            h1();
            k1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
    }
}
