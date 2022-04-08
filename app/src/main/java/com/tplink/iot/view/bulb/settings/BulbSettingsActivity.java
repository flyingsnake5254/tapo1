package com.tplink.iot.view.bulb.settings;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.view.group.device.DeviceShowGroupListActivity;
import com.tplink.iot.view.iotcommon.IoTDeviceInfoActivity;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

/* loaded from: classes2.dex */
public class BulbSettingsActivity extends BaseActivity implements View.OnClickListener {
    private ItemSettingLayout H3;
    private ItemSettingLayout I3;
    private View J3;
    private String K3;
    private BulbSettingViewModel L3;
    private BaseALIoTDevice M3;
    private boolean N3 = true;
    private View p0;
    private View p1;
    private ItemSettingLayout p2;
    private ItemSettingLayout p3;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<IoTBulbDevice> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable IoTBulbDevice ioTBulbDevice) {
            BulbSettingsActivity.this.E1(ioTBulbDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<BaseALIoTDevice> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable BaseALIoTDevice baseALIoTDevice) {
            BulbSettingsActivity.this.M3 = baseALIoTDevice;
            if (BulbSettingsActivity.this.M3 != null) {
                BulbSettingsActivity.this.p3.setItemInfo(l.h(BulbSettingsActivity.this.M3));
                if (!BulbSettingsActivity.this.M3.isSupportIoTCloud() || BulbSettingsActivity.this.M3.getCloudIoTDevice() == null || BulbSettingsActivity.this.M3.isUserRoleTypeDevice()) {
                    BulbSettingsActivity.this.p0.setEnabled(false);
                    BulbSettingsActivity.this.p2.setEnabled(false);
                    BulbSettingsActivity.this.p3.setEnabled(false);
                    BulbSettingsActivity.this.J3.setEnabled(false);
                    BulbSettingsActivity.this.H3.setEnabled(false);
                    BulbSettingsActivity.this.p1.setEnabled(false);
                    BulbSettingsActivity.this.p0.setAlpha(0.5f);
                    BulbSettingsActivity.this.p2.setAlpha(0.5f);
                    BulbSettingsActivity.this.p3.setAlpha(0.5f);
                    BulbSettingsActivity.this.J3.setAlpha(0.5f);
                    BulbSettingsActivity.this.H3.setAlpha(0.5f);
                    BulbSettingsActivity.this.p1.setAlpha(0.5f);
                } else {
                    BulbSettingsActivity.this.p0.setEnabled(true);
                    BulbSettingsActivity.this.p2.setEnabled(true);
                    BulbSettingsActivity.this.p3.setEnabled(true);
                    BulbSettingsActivity.this.J3.setEnabled(true);
                    BulbSettingsActivity.this.H3.setEnabled(true);
                    BulbSettingsActivity.this.p1.setEnabled(true);
                    BulbSettingsActivity.this.p0.setAlpha(1.0f);
                    BulbSettingsActivity.this.p2.setAlpha(1.0f);
                    BulbSettingsActivity.this.p3.setAlpha(1.0f);
                    BulbSettingsActivity.this.J3.setAlpha(1.0f);
                    BulbSettingsActivity.this.H3.setAlpha(1.0f);
                    BulbSettingsActivity.this.p1.setAlpha(1.0f);
                }
                if (!BulbSettingsActivity.this.M3.isSupportIoTCloud() || BulbSettingsActivity.this.M3.getCloudIoTDevice() == null) {
                    BulbSettingsActivity.this.I3.setEnabled(false);
                    BulbSettingsActivity.this.I3.setAlpha(0.5f);
                    return;
                }
                BulbSettingsActivity.this.I3.setEnabled(true);
                BulbSettingsActivity.this.I3.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<List<Integer>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<Integer> list) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                BulbSettingsActivity.this.z1();
            } else {
                BulbSettingsActivity.this.Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<com.tplink.iot.viewmodel.quicksetup.i<Void>> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<Void> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                BulbSettingsActivity.this.z1();
            } else {
                BulbSettingsActivity.this.Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Observer<ThingFirmware> {
        f() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingFirmware thingFirmware) {
            BulbSettingsActivity.this.z.setVisibility((thingFirmware == null || !thingFirmware.isNeedToUpgrade()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Observer<List<GroupInfo>> {
        g() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            ItemSettingLayout itemSettingLayout = BulbSettingsActivity.this.I3;
            itemSettingLayout.setItemInfo(BulbSettingsActivity.this.L3.s(list, BulbSettingsActivity.this.K3) + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements TPMaterialDialogV2.d {
        h() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            BulbSettingsActivity.this.D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements TPMaterialDialogV2.d {
        i() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            BulbSettingsActivity.this.e1();
        }
    }

    private void A1() {
        String str;
        int v1 = v1();
        if (v1 <= 0) {
            str = getString(R.string.share_device_share_device_no_longer);
        } else if (v1 == 1) {
            str = getString(R.string.share_device_share_device_title_user, new Object[]{v1 + ""});
        } else {
            str = getString(R.string.share_device_share_device_title_deletes, new Object[]{v1 + ""});
        }
        new TPMaterialDialogV2.Builder(this).j(str).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_remove, R.color.common_iot_red, new h()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void B1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.share_device_share_device_no_longer)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_remove, R.color.common_iot_red, new i()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void C1() {
        this.L3.r().observe(this, new a());
        this.L3.o().observe(this, new b());
        this.L3.p().observe(this, new c());
        this.L3.n().observe(this, new d());
        this.L3.B().observe(this, new e());
        this.L3.w().observe(this, new f());
        this.L3.x().observe(this, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        s0.l(this);
        this.L3.F(this.K3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(IoTBulbDevice ioTBulbDevice) {
        if (ioTBulbDevice != null) {
            this.y.setImageResource(com.tplink.iot.Utils.z0.g.d(EnumBulbAvatarType.fromString(ioTBulbDevice.getAvatar())));
            this.p2.setItemInfo(l.d(this, EnumDeviceType.BULB.getDeviceType(), this.L3.t()));
            if (ioTBulbDevice.getDefaultStates() != null && ioTBulbDevice.getDefaultStates().getBrightness() != null) {
                if (TextUtils.equals(ioTBulbDevice.getDefaultStates().getBrightness().getType(), DefaultStatesBean.TYPE_CUSTOM)) {
                    this.H3.setItemInfo(String.format("%s%%", String.valueOf(ioTBulbDevice.getDefaultStates().getBrightness().getValue())));
                } else {
                    this.H3.setItemInfo(getString(R.string.last_on_state));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        s0.l(this);
        this.L3.f(this.K3);
    }

    private int v1() {
        BaseALIoTDevice baseALIoTDevice = this.M3;
        if (baseALIoTDevice == null || baseALIoTDevice.getDeviceManagerInfo() == null || this.M3.getDeviceManagerInfo().getUserInfo() == null) {
            return 0;
        }
        return this.M3.getDeviceManagerInfo().getUserInfo().size() - 1;
    }

    private void w1() {
        BaseALIoTDevice baseALIoTDevice = this.M3;
        if (baseALIoTDevice != null) {
            String deviceId = baseALIoTDevice.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                DeviceShowGroupListActivity.t1(this, deviceId);
            }
        }
    }

    private void x1() {
        b1(R.string.common_device_settings);
        this.y = (ImageView) findViewById(R.id.plug_avatar);
        this.p0 = findViewById(R.id.item_avatar);
        this.p2 = (ItemSettingLayout) findViewById(R.id.item_name);
        this.p3 = (ItemSettingLayout) findViewById(R.id.item_location);
        this.I3 = (ItemSettingLayout) findViewById(R.id.item_group);
        this.J3 = findViewById(R.id.item_brightness_preset);
        this.H3 = (ItemSettingLayout) findViewById(R.id.item_default_state);
        this.p1 = findViewById(R.id.item_firmware);
        this.z = (ImageView) findViewById(R.id.iv_fw_red_point);
        findViewById(R.id.item_avatar).setOnClickListener(this);
        this.p2.setOnClickListener(this);
        this.p3.setOnClickListener(this);
        this.I3.setOnClickListener(this);
        this.J3.setOnClickListener(this);
        this.H3.setOnClickListener(this);
        findViewById(R.id.item_device_info).setOnClickListener(this);
        this.p1.setOnClickListener(this);
        ((Button) findViewById(R.id.btn_remove)).setOnClickListener(this);
    }

    private boolean y1() {
        BaseALIoTDevice baseALIoTDevice = this.M3;
        return baseALIoTDevice != null && baseALIoTDevice.isUserRoleTypeDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_remove /* 2131362097 */:
                if (y1()) {
                    B1();
                    return;
                } else {
                    A1();
                    return;
                }
            case R.id.item_avatar /* 2131362888 */:
                X0(IoTSettingAvatarActivity.class, this.K3);
                return;
            case R.id.item_brightness_preset /* 2131362891 */:
                X0(BulbBrightnessPresetActivity.class, this.K3);
                return;
            case R.id.item_default_state /* 2131362901 */:
                X0(BulbDefaultStateActivity.class, this.K3);
                return;
            case R.id.item_device_info /* 2131362906 */:
                X0(IoTDeviceInfoActivity.class, this.K3);
                return;
            case R.id.item_firmware /* 2131362915 */:
                X0(IoTFirmwareUpdateActivity.class, this.K3);
                return;
            case R.id.item_group /* 2131362918 */:
                w1();
                return;
            case R.id.item_location /* 2131362930 */:
                BaseALIoTDevice baseALIoTDevice = this.M3;
                if (baseALIoTDevice != null && baseALIoTDevice.getLocalIoTDevice() != null) {
                    IoTSettingLocationSelectActivity.o1(this, this.M3.getDeviceId());
                    return;
                }
                return;
            case R.id.item_name /* 2131362936 */:
                X0(IoTSettingNameActivity.class, this.K3);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bulb_settings);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.K3 = stringExtra;
        this.L3 = (BulbSettingViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(BulbSettingViewModel.class);
        x1();
        C1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.L3.u();
        this.L3.A();
        if (this.N3) {
            this.L3.v();
            this.N3 = false;
        }
    }
}
