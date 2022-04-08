package com.tplink.iot.view.colorbulb.effect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class LightEffectNameEditActivity extends BaseActivity implements TextWatcher {
    private String p0;
    private CharSequence p1;
    private MenuItem y;
    private DrawableEditText z;

    public static void e1(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, LightEffectNameEditActivity.class);
        intent.putExtra("effect_old_name", str);
        activity.startActivityForResult(intent, i);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z = true;
        if (this.p1.toString().getBytes().length > 64) {
            editable.delete(this.p1.length() - 1, this.p1.length());
            this.z.setText(editable);
            this.z.setSelection(editable.length());
        }
        if (this.y != null) {
            if (TextUtils.isEmpty(editable.toString())) {
                z = false;
            } else if (!TextUtils.isEmpty(this.p0)) {
                z = true ^ this.p0.equals(editable.toString());
            }
            this.y.setEnabled(z);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_light_effect_name_edit);
        b1(R.string.scene_name_edit_title);
        this.p0 = getIntent().getStringExtra("effect_old_name");
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.edit_name);
        this.z = drawableEditText;
        drawableEditText.m();
        this.z.f(this);
        if (!TextUtils.isEmpty(this.p0)) {
            this.z.setText(this.p0);
            this.z.setSelection(this.p0.length());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        this.y = menu.findItem(R.id.action_done);
        this.y.setEnabled(this.z != null && ((TextUtils.isEmpty(this.p0) && !TextUtils.isEmpty(this.z.getText())) || !TextUtils.equals(this.p0, this.z.getText().toString())));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_done) {
            String obj = this.z.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, obj);
            setResult(-1, intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.p1 = charSequence;
    }
}
