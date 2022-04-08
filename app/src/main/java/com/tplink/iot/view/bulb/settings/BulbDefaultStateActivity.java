package com.tplink.iot.view.bulb.settings;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BulbBrightnessView;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import java.util.List;

/* loaded from: classes2.dex */
public class BulbDefaultStateActivity extends BaseActivity {
    private BulbBrightnessView p0;
    private BulbSettingViewModel p1;
    private boolean p2 = false;
    private String y;
    private RadioGroup z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<IoTBulbDevice> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable IoTBulbDevice ioTBulbDevice) {
            if (ioTBulbDevice != null && ioTBulbDevice.getDefaultStates() != null && ioTBulbDevice.getDefaultStates().getBrightness() != null) {
                DefaultStatesBean.BrightnessBean brightness = ioTBulbDevice.getDefaultStates().getBrightness();
                if (!BulbDefaultStateActivity.this.p2) {
                    BulbDefaultStateActivity.this.p2 = true;
                    if (TextUtils.equals(brightness.getType(), DefaultStatesBean.TYPE_CUSTOM)) {
                        BulbDefaultStateActivity.this.z.check(R.id.rb_state_custom);
                        BulbDefaultStateActivity.this.p0.setBrightness(brightness.getValue());
                        return;
                    }
                    BulbDefaultStateActivity.this.z.check(R.id.rb_state_last);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<Integer>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<Integer> list) {
            BulbDefaultStateActivity.this.p0.setPresets(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements RadioGroup.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.rb_state_custom) {
                BulbDefaultStateActivity.this.p0.setVisibility(0);
            } else {
                BulbDefaultStateActivity.this.p0.setVisibility(8);
            }
        }
    }

    private DefaultStatesBean i1() {
        DefaultStatesBean defaultStatesBean = new DefaultStatesBean();
        DefaultStatesBean.BrightnessBean brightnessBean = new DefaultStatesBean.BrightnessBean();
        brightnessBean.setType(this.z.getCheckedRadioButtonId() == R.id.rb_state_last ? DefaultStatesBean.TYPE_LAST_STATES : DefaultStatesBean.TYPE_CUSTOM);
        brightnessBean.setValue(this.z.getCheckedRadioButtonId() == R.id.rb_state_last ? null : Integer.valueOf(this.p0.getBrightness()));
        defaultStatesBean.setBrightness(brightnessBean);
        return defaultStatesBean;
    }

    private void j1() {
        b1(R.string.bulb_settings_default_state);
        this.z = (RadioGroup) findViewById(R.id.rg_state);
        this.p0 = (BulbBrightnessView) findViewById(R.id.brightness_setting_view);
        this.z.check(R.id.rb_state_last);
        this.p0.setVisibility(8);
        this.z.setOnCheckedChangeListener(new c());
    }

    private void k1() {
        this.p1.r().observe(this, new a());
        this.p1.p().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bulb_default_state);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = stringExtra;
        this.p1 = (BulbSettingViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(BulbSettingViewModel.class);
        j1();
        k1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_save) {
            DefaultStatesBean i1 = i1();
            this.p1.D(i1());
            com.tplink.iot.Utils.x0.c.b(this.y, i1);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
