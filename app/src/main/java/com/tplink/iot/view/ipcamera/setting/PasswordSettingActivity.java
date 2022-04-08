package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;

/* loaded from: classes2.dex */
public class PasswordSettingActivity extends BaseActivity {
    private PasswordSettingViewModel y;

    public PasswordSettingViewModel e1() {
        return this.y;
    }

    public void f1(int i) {
        Fragment fragment;
        if (i == 0) {
            fragment = new DevicePasswordSettingFragment();
        } else if (i == 1) {
            fragment = new DevicePasswordCheckFragment();
        } else if (i != 2) {
            fragment = i != 3 ? null : new DeviceResetFragment();
        } else {
            fragment = new CloudPasswordCheckFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, "f1").commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        setContentView(R.layout.activity_blank);
        PasswordSettingViewModel passwordSettingViewModel = (PasswordSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(PasswordSettingViewModel.class);
        this.y = passwordSettingViewModel;
        passwordSettingViewModel.k();
        f1(this.y.l() ? 1 : 0);
    }
}
