package com.tplink.iot.view.quicksetup.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.x0.u;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.firmware.QuickSetupFirmwareActivity;
import com.tplink.iot.view.quicksetup.firmware.QuickSetupFirmwareSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QsFirmwareViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class SetupSuccessActivity extends BaseActivity implements View.OnClickListener {
    private EnumDeviceType H3;
    private String I3;
    private long J3 = 0;
    private TextView p0;
    private CommonQuickSetupBean p1;
    private QuickSetupDeviceInfoBean p2;
    private QsFirmwareViewModel p3;
    private TPRefreshableButton y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<ThingFirmware>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<ThingFirmware> iVar) {
            if (iVar == null || iVar.b() != 0) {
                SetupSuccessActivity.this.k1();
                return;
            }
            if (iVar.a().isNeedToUpgrade()) {
                SetupSuccessActivity.this.j1();
            } else {
                SetupSuccessActivity.this.k1();
            }
            SetupSuccessActivity.this.m1(iVar.a().getFwVer(), iVar.a().isNeedToUpgrade());
        }
    }

    private void h1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p1 = (CommonQuickSetupBean) extras.getSerializable("common_quick_setup_bean");
            this.p2 = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
            this.J3 = extras.getLong("obStartTimeExtra");
        }
    }

    private QuickSetupDeviceInfoBean i1() {
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = this.p2;
        if (quickSetupDeviceInfoBean == null) {
            return null;
        }
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean2 = new QuickSetupDeviceInfoBean(quickSetupDeviceInfoBean.getNickname(), this.p2.getAvatar());
        if (d.X(this.p1)) {
            return quickSetupDeviceInfoBean2;
        }
        quickSetupDeviceInfoBean2.setLocation(this.p2.getLocation());
        return quickSetupDeviceInfoBean2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        QuickSetupFirmwareActivity.i1(this, this.p1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        QuickSetupFirmwareSuccessActivity.l1(this, this.p1);
        finish();
    }

    private void l1() {
        TPRefreshableButton tPRefreshableButton = (TPRefreshableButton) findViewById(R.id.quicksetup_done);
        this.y = tPRefreshableButton;
        tPRefreshableButton.setOnClickListener(this);
        this.z = (ImageView) findViewById(R.id.image_device);
        this.H3 = d.s(this.p1);
        String r = d.r(this.p1);
        this.I3 = r;
        this.z.setImageResource(c.i0(this.H3, r));
        TextView textView = (TextView) findViewById(R.id.tv_tip_check);
        this.p0 = textView;
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(String str, boolean z) {
        CommonQuickSetupBean commonQuickSetupBean = this.p1;
        String deviceIdMD5 = commonQuickSetupBean == null ? "" : commonQuickSetupBean.getDeviceIdMD5();
        EnumDeviceType enumDeviceType = this.H3;
        r.i(enumDeviceType != null ? enumDeviceType.getDeviceType() : null, this.I3, deviceIdMD5, str, z);
    }

    private void n1() {
        String str;
        String str2;
        String str3;
        CommonQuickSetupBean commonQuickSetupBean = this.p1;
        String deviceIdMD5 = commonQuickSetupBean == null ? "" : commonQuickSetupBean.getDeviceIdMD5();
        if (this.p1 != null) {
            str3 = this.p3.r(deviceIdMD5);
            str2 = this.p3.p(deviceIdMD5);
            str = this.p3.o(deviceIdMD5);
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
        }
        u.c(deviceIdMD5, "", str3, str2, str);
    }

    private void o1() {
        CommonQuickSetupBean commonQuickSetupBean = this.p1;
        String deviceIdMD5 = commonQuickSetupBean == null ? "" : commonQuickSetupBean.getDeviceIdMD5();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.J3) / 1000);
        EnumDeviceType enumDeviceType = this.H3;
        r.h(enumDeviceType != null ? enumDeviceType.getDeviceType() : null, this.I3, deviceIdMD5, currentTimeMillis);
    }

    public static void p1(Context context, CommonQuickSetupBean commonQuickSetupBean, QuickSetupDeviceInfoBean quickSetupDeviceInfoBean, long j) {
        Intent intent = new Intent(context, SetupSuccessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("common_quick_setup_bean", commonQuickSetupBean);
        bundle.putSerializable("device_info", quickSetupDeviceInfoBean);
        bundle.putLong("obStartTimeExtra", j);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void q1() {
        this.p3.u().observe(this, new a());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.quicksetup_done) {
            this.p0.setVisibility(0);
            this.z.setImageResource(c.X(this.H3, this.I3));
            CommonQuickSetupBean commonQuickSetupBean = this.p1;
            this.p3.s(i1(), commonQuickSetupBean != null ? d.x(commonQuickSetupBean.getComponentResult()) : 1);
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_setup_success);
            h1();
            CommonQuickSetupBean commonQuickSetupBean = this.p1;
            this.p3 = (QsFirmwareViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, commonQuickSetupBean == null ? "" : commonQuickSetupBean.getDeviceIdMD5())).get(QsFirmwareViewModel.class);
            l1();
            q1();
            o1();
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
    }
}
