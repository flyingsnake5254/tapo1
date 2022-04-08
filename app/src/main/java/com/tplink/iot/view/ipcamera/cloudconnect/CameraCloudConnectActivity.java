package com.tplink.iot.view.ipcamera.cloudconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.databinding.ActivityCameraCloudConnectBinding;
import com.tplink.iot.viewmodel.cloudconnect.CameraCloudConnectViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class CameraCloudConnectActivity extends BaseActivity implements View.OnClickListener {
    private CameraCloudConnectViewModel p0;
    private TPRefreshableButton y;
    private String z;

    private void e1() {
        this.y.setText(getString(R.string.common_check));
        this.y.h();
    }

    private void f1() {
        W0(CameraCloudConnectSuccessActivity.class);
        finish();
    }

    private void g1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.z = intent.getStringExtra("device_id_md5");
        }
    }

    private void h1() {
        TPRefreshableButton tPRefreshableButton = (TPRefreshableButton) findViewById(R.id.btn_cloud_connect);
        this.y = tPRefreshableButton;
        tPRefreshableButton.setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(a aVar) {
        Boolean bool;
        if (aVar != null && (bool = (Boolean) aVar.a()) != null) {
            if (bool.booleanValue()) {
                f1();
            } else {
                e1();
            }
        }
    }

    public static void k1(Context context, String str) {
        Intent intent = new Intent(context, CameraCloudConnectActivity.class);
        intent.putExtra("device_id_md5", str);
        context.startActivity(intent);
    }

    private void l1() {
        this.p0.g().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.cloudconnect.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraCloudConnectActivity.this.j1((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cloud_connect) {
            this.p0.i();
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            ActivityCameraCloudConnectBinding activityCameraCloudConnectBinding = (ActivityCameraCloudConnectBinding) DataBindingUtil.setContentView(this, R.layout.activity_camera_cloud_connect);
            activityCameraCloudConnectBinding.setLifecycleOwner(this);
            g1();
            CameraCloudConnectViewModel cameraCloudConnectViewModel = (CameraCloudConnectViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, this.z)).get(CameraCloudConnectViewModel.class);
            this.p0 = cameraCloudConnectViewModel;
            activityCameraCloudConnectBinding.h(cameraCloudConnectViewModel.h());
            h1();
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TPRefreshableButton tPRefreshableButton = this.y;
        if (tPRefreshableButton != null) {
            tPRefreshableButton.h();
        }
        CameraCloudConnectViewModel cameraCloudConnectViewModel = this.p0;
        if (cameraCloudConnectViewModel != null) {
            cameraCloudConnectViewModel.j();
        }
    }
}
