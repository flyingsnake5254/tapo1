package com.tplink.iot.view.iotcommon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.view.iotplug.update.AutoUpdateActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTFirmwareUpdateViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ProgressBarButton;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.RealTimeBatteryInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class IoTFirmwareUpdateActivity extends BaseActivity implements View.OnClickListener {
    private static String y = "FromSubGSetupExtra";
    private TextView H3;
    private Button I3;
    private TextView J3;
    private TPCircleProgressBar K3;
    private ProgressBarButton L3;
    private TextView M3;
    private TextView N3;
    private View O3;
    private View P3;
    private TextView Q3;
    private View R3;
    private IoTFirmwareUpdateViewModel T3;
    private String U3;
    private ViewGroup p0;
    private View p1;
    private TextView p2;
    private ImageView p3;
    private ViewGroup z;
    private int S3 = 1;
    private boolean V3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<ThingFirmware> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingFirmware thingFirmware) {
            if (thingFirmware != null) {
                IoTFirmwareUpdateActivity.this.D1(thingFirmware);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                IoTFirmwareUpdateActivity.this.T3.w();
            } else {
                IoTFirmwareUpdateActivity.this.x1(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<FirmwareDownloadState> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable FirmwareDownloadState firmwareDownloadState) {
            IoTFirmwareUpdateActivity.this.C1(firmwareDownloadState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<Integer> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            if (num != null) {
                IoTFirmwareUpdateActivity.this.x1(num.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (bool != null) {
                IoTFirmwareUpdateActivity.this.Q3.setText(bool.booleanValue() ? R.string.common_on : R.string.common_off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IoTFirmwareUpdateActivity.this.T3.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IoTFirmwareUpdateActivity.this.x1(7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements TPMaterialDialogV3.d {
        h() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public void onClick(View view) {
            IoTFirmwareUpdateActivity.this.w1();
        }
    }

    private void A1() {
        this.T3.T();
        x1(3);
        this.L3.f(0, String.format(getString(R.string.fw_downloading_prefix), "0%"));
        m.e();
    }

    private void B1() {
        this.T3.y().observe(this, new a());
        this.T3.E().observe(this, new b());
        this.T3.v().observe(this, new c());
        this.T3.z().observe(this, new d());
        this.T3.o().observe(this, new e());
        this.T3.D().observe(this, new Observer() { // from class: com.tplink.iot.view.iotcommon.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IoTFirmwareUpdateActivity.this.m1((i) obj);
            }
        });
        this.T3.B().observe(this, new Observer() { // from class: com.tplink.iot.view.iotcommon.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IoTFirmwareUpdateActivity.this.l1((a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(FirmwareDownloadState firmwareDownloadState) {
        if (firmwareDownloadState != null) {
            int status = firmwareDownloadState.getStatus();
            if (status != 0) {
                if (status == 1 || status == 2) {
                    ProgressBarButton progressBarButton = this.L3;
                    int downloadProgress = firmwareDownloadState.getDownloadProgress();
                    String string = getString(R.string.fw_downloading_prefix);
                    progressBarButton.f(downloadProgress, String.format(string, firmwareDownloadState.getDownloadProgress() + "%"));
                    this.f6070c.postDelayed(new f(), 1000L);
                } else if (status == 3) {
                    this.L3.d(2, getString(R.string.fw_installing));
                    int upgradeTime = firmwareDownloadState.getUpgradeTime() + firmwareDownloadState.getRebootTime();
                    x1(5);
                    this.f6070c.postDelayed(new g(), upgradeTime * 1000);
                }
            } else if (this.S3 == 3) {
                x1(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(ThingFirmware thingFirmware) {
        if (thingFirmware != null) {
            this.M3.setText(thingFirmware.getFwVer());
            this.p2.setText(thingFirmware.getReleaseNote());
        }
    }

    private void E1(boolean z) {
        this.R3.setVisibility(z ? 0 : 8);
    }

    private void k1() {
        s0.l(this);
        this.T3.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
        Integer a2;
        s0.g();
        if (aVar != null && (a2 = aVar.a()) != null) {
            if (a2.intValue() == 2) {
                s0.n(this, R.string.common_operation_failed);
            } else if (a2.intValue() == 0) {
                IoTFirmwareUpdateViewModel ioTFirmwareUpdateViewModel = this.T3;
                if (ioTFirmwareUpdateViewModel.j) {
                    ioTFirmwareUpdateViewModel.l();
                } else {
                    A1();
                }
            } else if (a2.intValue() == 1) {
                z1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(i<RealTimeBatteryInfoResult> iVar) {
        b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult");
        if (iVar != null) {
            int b2 = iVar.b();
            if (b2 == 10) {
                b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult detecting");
                s0.l(this);
            } else if (b2 == 20) {
                if (iVar.a() != null) {
                    b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult finish rtBatteryInfo: " + com.tplink.libtpnetwork.Utils.i.j(iVar.a()));
                    s0.g();
                    if (iVar.a().getAllowUpgrade()) {
                        b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult startDownload");
                        A1();
                        return;
                    }
                    y1();
                    return;
                }
                b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult null result");
                s0.n(this, R.string.common_operation_failed);
            } else if (b2 == 30) {
                b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult fail");
                s0.n(this, R.string.common_operation_failed);
            }
        }
    }

    private void n1() {
        b1(R.string.quicksetup_plug_firmware_title);
        this.z = (ViewGroup) findViewById(R.id.ll_update_loading);
        this.p0 = (ViewGroup) findViewById(R.id.ll_update_multi_update_status);
        this.p1 = findViewById(R.id.ll_update_device_info);
        this.p2 = (TextView) findViewById(R.id.tv_what_new);
        this.R3 = findViewById(R.id.ll_subg_update_hub);
        this.p3 = (ImageView) findViewById(R.id.iv_multi_top_img);
        this.H3 = (TextView) findViewById(R.id.tv_multi_title);
        TextView textView = (TextView) findViewById(R.id.tv_location);
        this.M3 = (TextView) findViewById(R.id.tv_latest_fw_version);
        this.N3 = (TextView) findViewById(R.id.tv_not_power_off_hint);
        TPCircleProgressBar tPCircleProgressBar = (TPCircleProgressBar) findViewById(R.id.circle_progress_bar);
        this.K3 = tPCircleProgressBar;
        tPCircleProgressBar.setProgressBarColor(ContextCompat.getColor(this, R.color.common_iot_light_gray));
        this.I3 = (Button) findViewById(R.id.btn_multi_button);
        this.L3 = (ProgressBarButton) findViewById(R.id.progress_button);
        this.J3 = (TextView) findViewById(R.id.tv_sub_device_hint);
        this.I3.setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_plug_name)).setText(this.T3.t(this));
        int i = 0;
        if (!TextUtils.isEmpty(this.T3.C(this))) {
            findViewById(R.id.ll_location).setVisibility(0);
            textView.setText(this.T3.C(this));
        } else {
            findViewById(R.id.ll_location).setVisibility(8);
        }
        this.O3 = findViewById(R.id.ll_auto_update);
        this.Q3 = (TextView) findViewById(R.id.auto_update_status);
        this.P3 = findViewById(R.id.item_auto_update);
        findViewById(R.id.item_auto_update).setOnClickListener(this);
        View view = this.O3;
        if (!this.T3.g.get()) {
            i = 8;
        }
        view.setVisibility(i);
        E1(this.V3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1(View view) {
        s1(this, this.T3.p() != null ? this.T3.p().getParentDeviceIDMD5() : "");
    }

    public static void s1(Context context, String str) {
        Intent intent = new Intent(context, IoTFirmwareUpdateActivity.class);
        intent.putExtra("device_id_md5", str);
        context.startActivity(intent);
    }

    public static void t1(Context context, String str, boolean z) {
        Intent intent = new Intent(context, IoTFirmwareUpdateActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra(y, z);
        context.startActivity(intent);
    }

    private void u1() {
        if (this.T3.i) {
            k1();
        } else {
            A1();
        }
    }

    private void v1(int i) {
        boolean z = (i == 3 || i == 5) ? false : true;
        this.P3.setEnabled(z);
        this.P3.setAlpha(z ? 1.0f : 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        BaseALIoTDevice p = this.T3.p();
        if (p == null) {
            s0.n(this, R.string.common_unknown_device);
        } else if (p.isSwitch()) {
            com.tplink.iot.g.c.a.b.e(getSupportFragmentManager(), p);
        } else if (p.isSensor()) {
            r.n(getSupportFragmentManager(), p);
        } else if (com.tplink.iot.g.d.a.b.k(p)) {
            com.tplink.iot.g.d.a.b.o(getSupportFragmentManager(), p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(int i) {
        this.z.setVisibility(8);
        this.p0.setVisibility(8);
        this.p3.setImageResource(R.mipmap.info_yellow);
        this.K3.i();
        this.p1.setVisibility(8);
        this.I3.setVisibility(8);
        this.J3.setVisibility(8);
        this.L3.setVisibility(8);
        this.S3 = i;
        switch (i) {
            case 1:
                this.z.setVisibility(0);
                this.K3.g();
                this.T3.m();
                break;
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                this.p0.setVisibility(0);
                this.p1.setVisibility(0);
                this.p3.setImageResource(R.mipmap.info_yellow);
                this.H3.setText(R.string.fw_check_success_title);
                if (2 != i) {
                    if (6 != i) {
                        if (7 != i) {
                            if (8 != i) {
                                if (9 != i) {
                                    this.L3.setVisibility(0);
                                    if (5 == i) {
                                        this.T3.S();
                                        this.L3.d(2, getResources().getString(R.string.fw_installing));
                                        break;
                                    }
                                } else {
                                    this.J3.setVisibility(0);
                                    this.J3.setText(R.string.firmware_update_downloaded_but_not_transferred_desc);
                                    break;
                                }
                            } else {
                                this.J3.setVisibility(0);
                                this.J3.setText(R.string.firmware_update_downloaded_but_not_transferred_desc);
                                break;
                            }
                        } else {
                            this.N3.setVisibility(4);
                            this.T3.x();
                            this.T3.u();
                            this.p3.setImageResource(R.mipmap.info_success);
                            this.H3.setText(R.string.fw_install_success_title);
                            this.p1.setVisibility(8);
                            E1(false);
                            m.f(this.U3, true);
                            break;
                        }
                    } else {
                        this.H3.setText(R.string.fw_install_fail_title);
                        this.I3.setVisibility(0);
                        this.I3.setText(R.string.iot_philips_hue_bridge_try_again);
                        s0.n(this, R.string.account_login_common_failed_tip);
                        m.f(this.U3, false);
                        break;
                    }
                } else {
                    this.I3.setVisibility(0);
                    this.I3.setText(R.string.fw_update_now);
                    break;
                }
                break;
            case 4:
                this.p0.setVisibility(0);
                this.p3.setImageResource(R.mipmap.info_failed);
                this.H3.setText(R.string.download_failed);
                this.I3.setVisibility(0);
                this.I3.setText(R.string.iot_philips_hue_bridge_try_again);
                s0.n(this, R.string.fw_download_fail_toast_tips);
                break;
        }
        v1(i);
    }

    private void y1() {
        new TPMaterialDialogV3.Builder(this).setMessage(R.string.fw_at_low_battery_message).h(R.string.common_ok, R.color.common_iot_light_black, null).k(R.string.trv_how_to_replace_battery, new h()).show();
    }

    private void z1() {
        new TPMaterialDialogV2.Builder(this).setMessage(R.string.sensor_update_low_hub_version).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.sensor_go_to_update_hub, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.iotcommon.d
            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public final void onClick(View view) {
                IoTFirmwareUpdateActivity.this.r1(view);
            }
        }).setCancelable(false).c(false).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_multi_button) {
            u1();
        } else if (id == R.id.item_auto_update) {
            X0(AutoUpdateActivity.class, this.U3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_iot_firmware_update);
        this.U3 = getIntent().getStringExtra("device_id_md5");
        this.V3 = getIntent().getBooleanExtra(y, false);
        this.T3 = (IoTFirmwareUpdateViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, this.U3)).get(IoTFirmwareUpdateViewModel.class);
        n1();
        B1();
        x1(1);
        m.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.tplink.iot.base.b bVar = this.f6070c;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
