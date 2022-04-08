package com.tplink.iot.view.ipcamera.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBinding;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.Utils.f0.b;

/* loaded from: classes2.dex */
public class DeviceDetailInfoActivity extends BaseActivity implements View.OnClickListener {
    private ActivityDeviceDetailInfoNewIpcBinding y;
    private DeviceDetailInfoViewModel z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.i())) {
            this.z.m.set(false);
            this.y.q.setImageResource(R.drawable.preload);
            return;
        }
        this.z.m.set(true);
        com.bumptech.glide.c.u(getApplication()).s(cVar.i()).x0(this.y.q);
    }

    private void i1() {
        l.e(this.z.j(), new b() { // from class: com.tplink.iot.view.ipcamera.setting.b1
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                DeviceDetailInfoActivity.this.h1((c) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (!this.z.s.get() || !(id == R.id.camera_icon || id == R.id.camera_name || id == R.id.firmware_update)) {
            switch (id) {
                case R.id.camera_icon /* 2131362171 */:
                    if (this.z.o.get()) {
                        LocationSettingActivity.j1(this, this.z.j(), this.z.p.get());
                        return;
                    }
                    return;
                case R.id.camera_name /* 2131362175 */:
                    if (this.z.o.get()) {
                        Intent intent = new Intent(this, DeviceNameEditorActivity.class);
                        intent.putExtra("device_id_md5", this.z.j());
                        startActivity(intent);
                        return;
                    }
                    return;
                case R.id.firmware_update /* 2131362645 */:
                    if (this.z.o.get()) {
                        Intent intent2 = new Intent(this, FirmwareUpdateNewIpcActivity.class);
                        intent2.putExtra("device_id_md5", this.z.j());
                        startActivity(intent2);
                        return;
                    }
                    return;
                case R.id.signal_info /* 2131364043 */:
                    this.z.f();
                    return;
                default:
                    return;
            }
        } else {
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityDeviceDetailInfoNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_device_detail_info_new_ipc);
        DeviceDetailInfoViewModel deviceDetailInfoViewModel = (DeviceDetailInfoViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(DeviceDetailInfoViewModel.class);
        this.z = deviceDetailInfoViewModel;
        this.y.i(deviceDetailInfoViewModel);
        this.y.h(this);
        this.y.V3.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceDetailInfoActivity.this.f1(view);
            }
        });
        this.z.o.set(getIntent().getBooleanExtra("online", false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.z.i();
        i1();
        if (this.z.p.get()) {
            h.y(this, this.z.h(), this.y.J3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
