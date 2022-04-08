package com.tplink.iot.view.ipcamera.setting.firmware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;

/* loaded from: classes2.dex */
public class FirmwareUpdateNewIpcActivity extends BaseActivity {
    private boolean p0;
    private String y;
    private boolean z = false;

    public static void g1(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, FirmwareUpdateNewIpcActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("upgrade", z);
        activity.startActivity(intent);
    }

    public String e1() {
        return this.y;
    }

    public boolean f1() {
        return this.p0;
    }

    public void h1(boolean z) {
        this.z = z;
    }

    public void i1(int i) {
        Fragment fragment;
        if (i == 0) {
            fragment = new FirmwareCheckFragment();
        } else {
            fragment = i == 1 ? new FirmwareUpgradeFragment() : null;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, "f1").commit();
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.z) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_blank);
        if (getIntent() == null) {
            finish();
        }
        this.y = getIntent().getStringExtra("device_id_md5");
        int i = 0;
        this.p0 = getIntent().getBooleanExtra("upgrade", false);
        u g = ((FirmwareManager) b.a(a.f(), FirmwareManager.class)).g(this.y);
        if (g != null && g.e()) {
            i = 1;
        }
        i1(i);
    }
}
