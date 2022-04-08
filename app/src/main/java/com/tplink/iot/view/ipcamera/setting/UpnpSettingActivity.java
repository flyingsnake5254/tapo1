package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityUpnpSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.UpnpSettingViewModel;

/* loaded from: classes2.dex */
public class UpnpSettingActivity extends BaseActivity {
    private UpnpSettingViewModel y;
    private ActivityUpnpSettingBinding z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String> aVar) {
            if (aVar != null && !aVar.b()) {
                String a = aVar.a();
                if (!TextUtils.isEmpty(a)) {
                    s0.p(UpnpSettingActivity.this, a);
                }
            }
        }
    }

    private void e1() {
        b1(R.string.upnp);
        this.z.f6759c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.w4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpnpSettingActivity.this.g1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(View view) {
        if (this.y.a.get()) {
            this.y.o(false);
        } else {
            this.y.o(true);
        }
    }

    private void h1() {
        this.y.f10842d.observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = (UpnpSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(UpnpSettingViewModel.class);
        ActivityUpnpSettingBinding activityUpnpSettingBinding = (ActivityUpnpSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_upnp_setting);
        this.z = activityUpnpSettingBinding;
        activityUpnpSettingBinding.h(this.y);
        e1();
        h1();
    }
}
