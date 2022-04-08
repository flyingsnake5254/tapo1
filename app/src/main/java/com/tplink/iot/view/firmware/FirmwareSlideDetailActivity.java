package com.tplink.iot.view.firmware;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.model.firmware.s;
import com.tplink.iot.viewmodel.firmware.FirmwareSlideDetailViewModel;
import com.tplink.iot.viewmodel.firmware.factory.IotFirmwareViewModelFactory;
import com.tplink.iot.widget.FirmwareDetailLayout;
import com.tplink.iot.widget.ProgressBarButton;

/* loaded from: classes2.dex */
public class FirmwareSlideDetailActivity extends BaseActivity implements View.OnClickListener {
    private TextView H3;
    private FirmwareDetailLayout I3;
    private FirmwareDetailLayout J3;
    private FirmwareDetailLayout K3;
    private FirmwareDetailLayout L3;
    private ProgressBarButton M3;
    private IotSeriesBean N3;
    private FirmwareSlideDetailViewModel O3;
    private int P3;
    private int Q3;
    private TextView p0;
    private TextView p1;
    private View p2;
    private TextView p3;
    private String y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumIoTSeriesState.values().length];
            a = iArr;
            try {
                iArr[EnumIoTSeriesState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumIoTSeriesState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumIoTSeriesState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumIoTSeriesState.INSTALLING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void e1() {
        b1(R.string.firmware_slide_update_title);
        this.z = (ImageView) findViewById(R.id.iv_iot_series_avatar);
        this.p0 = (TextView) findViewById(R.id.tv_iot_series_name);
        this.p1 = (TextView) findViewById(R.id.tv_iot_series_update_instr);
        this.p2 = findViewById(R.id.ll_new_version_info);
        this.p3 = (TextView) findViewById(R.id.tv_new_version);
        this.H3 = (TextView) findViewById(R.id.tv_what_new);
        this.I3 = (FirmwareDetailLayout) findViewById(R.id.fdl_success);
        this.J3 = (FirmwareDetailLayout) findViewById(R.id.fdl_failed);
        this.K3 = (FirmwareDetailLayout) findViewById(R.id.fdl_battery_disallow);
        this.L3 = (FirmwareDetailLayout) findViewById(R.id.fdl_transfer_failed);
        this.I3.setMode(1);
        this.J3.setMode(2);
        this.K3.setMode(3);
        this.L3.setMode(4);
        ProgressBarButton progressBarButton = (ProgressBarButton) findViewById(R.id.btn_bottom_update);
        this.M3 = progressBarButton;
        progressBarButton.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(IotSeriesBean iotSeriesBean) {
        this.N3 = iotSeriesBean;
        j1(iotSeriesBean);
    }

    private void h1(IotSeriesBean iotSeriesBean) {
        int i = a.a[iotSeriesBean.getCurrentState().ordinal()];
        if (i == 1) {
            this.M3.d(0, getString(R.string.fw_update_now));
        } else if (i == 2) {
            ProgressBarButton progressBarButton = this.M3;
            int progress = iotSeriesBean.getProgress();
            String string = getString(R.string.fw_downloading_prefix);
            progressBarButton.f(progress, String.format(string, iotSeriesBean.getProgress() + "%"));
        } else if (i == 3) {
            if (this.Q3 != this.P3) {
                this.M3.d(0, getString(R.string.try_again));
            } else if (iotSeriesBean.isInstallFollowDownloaded()) {
                this.M3.d(0, getString(R.string.common_done));
            } else {
                this.M3.d(4, getString(R.string.common_waiting));
            }
            m.b(iotSeriesBean);
        } else if (i == 4) {
            this.M3.d(2, getString(R.string.fw_installing));
        }
    }

    private void i1() {
        this.O3.i().observe(this, new Observer() { // from class: com.tplink.iot.view.firmware.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareSlideDetailActivity.this.g1((IotSeriesBean) obj);
            }
        });
    }

    private void j1(IotSeriesBean iotSeriesBean) {
        String str;
        if (iotSeriesBean != null) {
            this.P3 = iotSeriesBean.getIoTDeviceStateList().size();
            this.Q3 = iotSeriesBean.getSuccessCount();
            String a2 = s.a(this, iotSeriesBean, true);
            String a3 = s.a(this, iotSeriesBean, false);
            this.z.setImageResource(l.f(iotSeriesBean.getCountrySpecs(), iotSeriesBean.getModel(), s.b(iotSeriesBean)));
            this.p0.setText(iotSeriesBean.getModel());
            this.H3.setText(iotSeriesBean.getReleaseNote());
            this.p3.setText(String.format(getString(R.string.fw_new_firmware_version_with_version), l.r(iotSeriesBean.getNewVersion())));
            View view = this.p2;
            EnumIoTSeriesState currentState = iotSeriesBean.getCurrentState();
            EnumIoTSeriesState enumIoTSeriesState = EnumIoTSeriesState.SUCCESS;
            view.setVisibility(currentState == enumIoTSeriesState ? 8 : 0);
            this.p1.setVisibility(0);
            if (iotSeriesBean.getCurrentState() != enumIoTSeriesState) {
                this.p1.setTextColor(ContextCompat.getColor(this, R.color.common_iot_dark_black));
                TextView textView = this.p1;
                if (this.P3 == 1) {
                    str = String.format(getString(R.string.firmware_series_update_text_format_2), a2);
                } else {
                    str = String.format(getString(R.string.firmware_series_update_text_format), Integer.valueOf(this.P3), a3);
                }
                textView.setText(str);
            } else {
                int i = this.Q3;
                if (i == this.P3) {
                    this.p1.setTextColor(ContextCompat.getColor(this, R.color.common_iot_green));
                    this.p1.setText(R.string.firmware_update_complete);
                } else if (i == 0) {
                    this.p1.setTextColor(ContextCompat.getColor(this, R.color.common_iot_red));
                    this.p1.setText(R.string.firmware_update_failed);
                } else {
                    this.p1.setVisibility(8);
                }
            }
            this.I3.setIotSeriesBean(iotSeriesBean);
            this.J3.setIotSeriesBean(iotSeriesBean);
            this.K3.setIotSeriesBean(iotSeriesBean);
            this.L3.setIotSeriesBean(iotSeriesBean);
            h1(iotSeriesBean);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom_update) {
            IotSeriesBean iotSeriesBean = this.N3;
            if (iotSeriesBean != null && iotSeriesBean.getCurrentState() == EnumIoTSeriesState.SUCCESS && this.Q3 == this.P3) {
                onBackPressed();
                return;
            }
            this.O3.j();
            m.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_firmware_slide_detail);
        String stringExtra = getIntent().getStringExtra("series_key");
        this.y = stringExtra;
        this.O3 = (FirmwareSlideDetailViewModel) ViewModelProviders.of(this, new IotFirmwareViewModelFactory(this, stringExtra)).get(FirmwareSlideDetailViewModel.class);
        e1();
        i1();
    }
}
