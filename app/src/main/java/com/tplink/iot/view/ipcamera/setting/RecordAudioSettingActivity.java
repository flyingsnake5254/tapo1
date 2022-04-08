package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityRecordAudioSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordAudioSettingViewModel;

/* loaded from: classes2.dex */
public class RecordAudioSettingActivity extends BaseActivity {
    private RecordAudioSettingViewModel y;
    private ActivityRecordAudioSettingBinding z;

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
                    s0.p(RecordAudioSettingActivity.this, a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPLongMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            RecordAudioSettingActivity.this.y.o(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPLongMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            RecordAudioSettingActivity.this.y.a.set(true);
        }
    }

    private void f1() {
        b1(R.string.camera_record_audio);
        this.z.f6660c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordAudioSettingActivity.this.h1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(View view) {
        if (this.y.a.get()) {
            this.y.a.set(false);
            j1();
            return;
        }
        this.y.o(true);
    }

    private void i1() {
        this.y.f10821d.observe(this, new a());
    }

    private void j1() {
        new TPLongMaterialDialogV2.Builder(this).f(R.string.record_audio_close_tips, R.color.common_iot_dark_black).l(R.string.record_audio_close_keep, R.color.common_iot_main_blue, new c()).i(R.string.record_audio_close_cancel, R.color.common_iot_light_black, new b()).setCancelable(false).c(false).d(8, 8).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = (RecordAudioSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(RecordAudioSettingViewModel.class);
        ActivityRecordAudioSettingBinding activityRecordAudioSettingBinding = (ActivityRecordAudioSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_record_audio_setting);
        this.z = activityRecordAudioSettingBinding;
        activityRecordAudioSettingBinding.h(this.y);
        f1();
        i1();
    }
}
