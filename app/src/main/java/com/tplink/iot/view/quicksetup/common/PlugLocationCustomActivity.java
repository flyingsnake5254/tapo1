package com.tplink.iot.view.quicksetup.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;

/* loaded from: classes2.dex */
public class PlugLocationCustomActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupDeviceInfoBean p0;
    private CharSequence p1;
    private DrawableEditText y;
    private QuickSetupInfoBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Button f9647c;

        a(Button button) {
            this.f9647c = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().getBytes().length > 64) {
                editable.delete(PlugLocationCustomActivity.this.p1.length() - 1, PlugLocationCustomActivity.this.p1.length());
                PlugLocationCustomActivity.this.y.setText(editable);
                PlugLocationCustomActivity.this.y.setSelection(editable.length());
            }
            this.f9647c.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PlugLocationCustomActivity.this.p1 = charSequence;
        }
    }

    private void h1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.z = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            this.p0 = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    private void i1() {
        this.p0.setLocation(b.d.w.h.a.b(this.y.getText().toString()));
        d.C(this, PlugIconSelectActivity.class, this.z, this.p0);
    }

    private void j1() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            i1();
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_plug_location_custom);
            h1();
            j1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
    }
}
