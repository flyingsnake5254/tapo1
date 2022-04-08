package com.tplink.iot.view.iotsensor;

import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.viewmodel.iotsensor.SensorFirmwareUpdateViewModel;

/* compiled from: SensorFirmwareUpdateActivity.kt */
/* loaded from: classes2.dex */
public final class SensorFirmwareUpdateActivity extends SensorBaseActivity<SensorFirmwareUpdateViewModel> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensorFirmwareUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements TPMaterialDialogV2.d {
        public static final a a = new a();

        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
        }
    }

    public SensorFirmwareUpdateActivity() {
        super(SensorFirmwareUpdateViewModel.class);
    }

    private final void k1() {
        new TPMaterialDialogV2.Builder(this).setMessage(R.string.sensor_update_low_hub_version).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.sensor_go_to_update_hub, R.color.common_iot_main_blue, a.a).setCancelable(false).c(false).show();
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void h1() {
        setContentView(R.layout.activity_sensor_firmware_update);
        b1(R.string.firmware_slide_update_title);
        k1();
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void j1() {
    }
}
