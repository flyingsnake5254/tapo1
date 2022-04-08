package com.tplink.iot.view.iotcommon;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTSettingNameViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class IoTSettingNameActivity extends BaseActivity implements TextWatcher {
    private MenuItem p0;
    private IoTSettingNameViewModel p1;
    private String p2;
    private CharSequence p3;
    private String y;
    private DrawableEditText z;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z = true;
        if (this.p3.toString().getBytes().length > 64) {
            editable.delete(this.p3.length() - 1, this.p3.length());
            this.z.setText(editable);
            this.z.setSelection(editable.length());
        }
        if (this.p0 != null) {
            if (TextUtils.isEmpty(editable.toString())) {
                z = false;
            } else if (!TextUtils.isEmpty(this.p2)) {
                z = true ^ this.p2.equals(editable.toString());
            }
            this.p0.setEnabled(z);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_iot_setting_name);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = stringExtra;
        this.p1 = (IoTSettingNameViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(IoTSettingNameViewModel.class);
        b1(R.string.setting_device_name);
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.edit_device_name);
        this.z = drawableEditText;
        drawableEditText.m();
        this.z.f(this);
        String j = this.p1.j();
        this.p2 = j;
        if (!TextUtils.isEmpty(j)) {
            this.z.setText(this.p2);
            this.z.setSelection(this.p2.length());
            return;
        }
        l.m(this.z, this.p1.g(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.p0 = menu.findItem(R.id.common_save);
        this.p0.setEnabled(this.z != null && ((TextUtils.isEmpty(this.p2) && !TextUtils.isEmpty(this.z.getText())) || !TextUtils.equals(this.p2, this.z.getText().toString())));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.common_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        String obj = this.z.getText().toString();
        this.p1.k(obj);
        i.h(this.y, obj);
        finish();
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.p3 = charSequence;
    }
}
