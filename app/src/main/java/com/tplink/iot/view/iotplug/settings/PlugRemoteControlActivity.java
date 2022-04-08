package com.tplink.iot.view.iotplug.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.PlugSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* loaded from: classes2.dex */
public class PlugRemoteControlActivity extends BaseActivity {
    private String p0;
    private TPSwitchCompat p1;
    private PlugSettingViewModel y;
    private BaseALIoTDevice z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPSwitchCompat.a {
        a() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2 && !z) {
                PlugRemoteControlActivity.this.p1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            if (this.a) {
                PlugRemoteControlActivity.this.e1();
            } else {
                PlugRemoteControlActivity.this.r1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            PlugRemoteControlActivity.this.p1.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<BaseALIoTDevice> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable BaseALIoTDevice baseALIoTDevice) {
            if (baseALIoTDevice != null) {
                PlugRemoteControlActivity.this.z = baseALIoTDevice;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<i<CloudResult<Void>>> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<CloudResult<Void>> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                PlugRemoteControlActivity.this.o1();
            } else {
                PlugRemoteControlActivity.this.Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Observer<i<Void>> {
        f() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<Void> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                PlugRemoteControlActivity.this.o1();
            } else {
                PlugRemoteControlActivity.this.Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        s0.l(this);
        this.y.f(this.p0);
    }

    private int l1() {
        BaseALIoTDevice baseALIoTDevice = this.z;
        if (baseALIoTDevice == null || baseALIoTDevice.getDeviceManagerInfo() == null || this.z.getDeviceManagerInfo().getUserInfo() == null) {
            return 0;
        }
        return this.z.getDeviceManagerInfo().getUserInfo().size() - 1;
    }

    private void m1() {
        c1(getString(R.string.pse_remote_control));
        TextView textView = (TextView) findViewById(R.id.item_info);
        if (n1()) {
            textView.setText(getString(R.string.pse_remote_control_disable_user_tips));
        } else {
            textView.setText(getString(R.string.pse_disable_remote_control_disable));
        }
        TPSwitchCompat tPSwitchCompat = (TPSwitchCompat) findViewById(R.id.switch_remote_control);
        this.p1 = tPSwitchCompat;
        tPSwitchCompat.setChecked(true);
        this.p1.setOnSwitchCheckedChangeListener(new a());
    }

    private boolean n1() {
        BaseALIoTDevice baseALIoTDevice = this.z;
        return baseALIoTDevice != null && baseALIoTDevice.isUserRoleTypeDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        this.p1.setChecked(true);
        s0.p(this, getString(R.string.common_operation_failed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        String str;
        boolean n1 = n1();
        if (n1) {
            str = getString(R.string.pse_disable_remote_control_warn_dialog_content);
        } else {
            int l1 = l1();
            if (l1 <= 0) {
                str = getString(R.string.pse_disable_remote_control_dialog_no_user_disable);
            } else if (l1 == 1) {
                str = getString(R.string.pse_disable_remote_control_dialog_disable, new Object[]{l1 + ""});
            } else {
                str = getString(R.string.pse_disable_remote_control_dialog_users_disable, new Object[]{l1 + ""});
            }
        }
        new TPMaterialDialogV2.Builder(this).j(str).l(R.string.pse_cancel, R.color.common_iot_light_black, new c()).o(R.string.pse_disable, R.color.common_iot_main_blue, new b(n1)).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void q1() {
        this.y.n().observe(this, new d());
        this.y.m().observe(this, new e());
        this.y.w().observe(this, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        s0.l(this);
        this.y.x(this.p0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_plug_remote_control);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.p0 = stringExtra;
        this.y = (PlugSettingViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(PlugSettingViewModel.class);
        m1();
        q1();
    }
}
