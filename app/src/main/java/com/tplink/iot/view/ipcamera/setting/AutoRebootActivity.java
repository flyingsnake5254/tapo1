package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAutoRebootBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoRebootSettingViewModel;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfoCache;

/* loaded from: classes2.dex */
public class AutoRebootActivity extends BaseActivity {
    private ActivityAutoRebootBinding p0;
    private MenuItem p1;
    private AutoRebootSettingViewModel z;
    private final String[] y = h.g();
    private int p2 = 180;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<RebootInfoCache> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(RebootInfoCache rebootInfoCache) {
            if (rebootInfoCache != null) {
                AutoRebootActivity autoRebootActivity = AutoRebootActivity.this;
                autoRebootActivity.p2 = (autoRebootActivity.z.h(rebootInfoCache.getTime()) / 30) * 30;
                int i = 0;
                boolean z = rebootInfoCache.getEnable() == OptionSwitch.ON;
                AutoRebootActivity.this.p0.f6497c.setChecked(z);
                NumberPickerView numberPickerView = AutoRebootActivity.this.p0.y;
                AutoRebootActivity autoRebootActivity2 = AutoRebootActivity.this;
                numberPickerView.setValue(autoRebootActivity2.k1(autoRebootActivity2.p2));
                TextView textView = AutoRebootActivity.this.p0.x;
                String[] strArr = AutoRebootActivity.this.y;
                AutoRebootActivity autoRebootActivity3 = AutoRebootActivity.this;
                textView.setText(strArr[autoRebootActivity3.k1(autoRebootActivity3.p2)]);
                LinearLayout linearLayout = AutoRebootActivity.this.p0.f6499f;
                if (!z) {
                    i = 8;
                }
                linearLayout.setVisibility(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            if (num.intValue() == 0) {
                AutoRebootActivity.this.finish();
            } else if (num.intValue() == -1) {
                AutoRebootActivity autoRebootActivity = AutoRebootActivity.this;
                s0.p(autoRebootActivity, autoRebootActivity.getString(R.string.common_operation_failed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k1(int i) {
        return (i / 30) % 48;
    }

    private void l1() {
        b1(R.string.setting_auto_restart);
        this.p0.y.S(this.y);
        this.p0.y.setValue(k1(this.p2));
        this.p0.x.setText(this.y[k1(this.p2)]);
        this.p0.y.setOnValueChangedListener(new NumberPickerView.d() { // from class: com.tplink.iot.view.ipcamera.setting.u
            @Override // com.tplink.iot.widget.NumberPickerView.d
            public final void a(NumberPickerView numberPickerView, int i, int i2) {
                AutoRebootActivity.this.o1(numberPickerView, i, i2);
            }
        });
        this.p0.f6497c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tplink.iot.view.ipcamera.setting.t
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoRebootActivity.this.q1(compoundButton, z);
            }
        });
        this.p0.f6498d.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoRebootActivity.this.s1(view);
            }
        });
    }

    private boolean m1() {
        AutoRebootSettingViewModel autoRebootSettingViewModel = this.z;
        RebootInfoCache rebootInfoCache = autoRebootSettingViewModel.f10711f;
        if (rebootInfoCache == null) {
            return true;
        }
        return (this.p0.f6497c.isChecked() == (this.z.f10711f.getEnable() == OptionSwitch.ON) && this.p2 == (autoRebootSettingViewModel.h(rebootInfoCache.getTime()) / 30) * 30) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(NumberPickerView numberPickerView, int i, int i2) {
        this.p2 = i2 * 30;
        ActivityAutoRebootBinding activityAutoRebootBinding = this.p0;
        activityAutoRebootBinding.x.setText(activityAutoRebootBinding.y.getContentByCurrValue());
        this.p1.setEnabled(m1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.p0.f6499f.setVisibility(z ? 0 : 8);
            this.p1.setEnabled(m1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(View view) {
        int i = 0;
        boolean z = this.p0.y.getVisibility() == 0;
        NumberPickerView numberPickerView = this.p0.y;
        if (z) {
            i = 4;
        }
        numberPickerView.setVisibility(i);
    }

    public static void t1(Activity activity, String str) {
        Intent intent = new Intent(activity, AutoRebootActivity.class);
        intent.putExtra("device_id_md5", str);
        activity.startActivity(intent);
    }

    private void u1() {
        this.z.f().observe(this, new a());
        this.z.g().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p0 = (ActivityAutoRebootBinding) DataBindingUtil.setContentView(this, R.layout.activity_auto_reboot);
        AutoRebootSettingViewModel autoRebootSettingViewModel = (AutoRebootSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(AutoRebootSettingViewModel.class);
        this.z = autoRebootSettingViewModel;
        this.p0.h(autoRebootSettingViewModel);
        l1();
        this.z.u();
        u1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.p1 = findItem;
        findItem.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_save) {
            this.z.w(this.p0.f6497c.isChecked(), this.p2);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
