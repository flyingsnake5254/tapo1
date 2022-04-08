package com.tplink.iot.view.iotcommon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTDeviceInfoViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

@Deprecated
/* loaded from: classes2.dex */
public class IoTDeviceInfoActivity extends BaseActivity {
    private ItemSettingLayout H3;
    private TextView I3;
    private IoTDeviceInfoViewModel J3;
    private LocalIoTBaseDevice K3;
    private boolean L3 = false;
    private String M3;
    private ItemSettingLayout p0;
    private ItemSettingLayout p1;
    private ItemSettingLayout p2;
    private ItemSettingLayout p3;
    private ItemSettingLayout y;
    private ItemSettingLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<DeviceTimeInfo> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable DeviceTimeInfo deviceTimeInfo) {
            if (IoTDeviceInfoActivity.this.J3.a.get() != 1) {
                return;
            }
            if (deviceTimeInfo == null) {
                IoTDeviceInfoActivity.this.y.setVisibility(8);
            } else if (TextUtils.isEmpty(deviceTimeInfo.getRegion())) {
                IoTDeviceInfoActivity.this.y.setVisibility(8);
            } else {
                IoTDeviceInfoActivity.this.y.setVisibility(0);
                IoTDeviceInfoActivity.this.y.setItemInfo(deviceTimeInfo.getRegion());
            }
        }
    }

    private void g1() {
        c1(getString(R.string.device_info));
        ItemSettingLayout itemSettingLayout = (ItemSettingLayout) findViewById(R.id.item_timezone);
        this.y = itemSettingLayout;
        itemSettingLayout.setVisibility(8);
        this.z = (ItemSettingLayout) findViewById(R.id.item_wifi_network);
        this.p0 = (ItemSettingLayout) findViewById(R.id.item_model);
        this.p1 = (ItemSettingLayout) findViewById(R.id.item_ip_address);
        this.p2 = (ItemSettingLayout) findViewById(R.id.item_mac_address);
        this.p3 = (ItemSettingLayout) findViewById(R.id.item_hardware);
        this.H3 = (ItemSettingLayout) findViewById(R.id.item_fw_version);
        TextView itemRightTextView = this.z.getItemRightTextView();
        this.I3 = itemRightTextView;
        itemRightTextView.setVisibility(0);
        this.I3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.iotcommon.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IoTDeviceInfoActivity.this.i1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(View view) {
        this.L3 = !this.L3;
        LocalIoTBaseDevice localIoTBaseDevice = this.K3;
        if (localIoTBaseDevice != null) {
            l.q(this, this.I3, localIoTBaseDevice.getSignalLevel(), this.K3.getRssi(), this.L3);
        }
    }

    private void l1() {
        this.J3.i().observe(this, new Observer() { // from class: com.tplink.iot.view.iotcommon.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IoTDeviceInfoActivity.this.k1((BaseALIoTDevice) obj);
            }
        });
        this.J3.j().observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public void j1(BaseALIoTDevice baseALIoTDevice) {
        if ((baseALIoTDevice instanceof ALIoTDevice) && baseALIoTDevice.getLocalIoTDevice() != null) {
            LocalIoTBaseDevice localIoTBaseDevice = (LocalIoTBaseDevice) baseALIoTDevice.getLocalIoTDevice();
            this.K3 = localIoTBaseDevice;
            if (this.J3.a.get() >= 2) {
                if (TextUtils.isEmpty(localIoTBaseDevice.getRegion())) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setVisibility(0);
                    this.y.setItemInfo(localIoTBaseDevice.getRegion());
                }
            }
            this.z.setItemInfo(localIoTBaseDevice.getSsid());
            l.q(this, this.I3, localIoTBaseDevice.getSignalLevel(), localIoTBaseDevice.getRssi(), this.L3);
            ItemSettingLayout itemSettingLayout = this.p0;
            itemSettingLayout.setItemInfo(getString(R.string.app_name) + SSLClient.WHITE_SPACE + localIoTBaseDevice.getModel());
            this.p1.setItemInfo(localIoTBaseDevice.getIp());
            this.p2.setItemInfo(l.a(localIoTBaseDevice.getMac()));
            this.p3.setItemInfo(localIoTBaseDevice.getHwVer());
            this.H3.setItemInfo(localIoTBaseDevice.getFwVer());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_iot_device_info);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.J3 = (IoTDeviceInfoViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(IoTDeviceInfoViewModel.class);
        this.M3 = stringExtra;
        g1();
        l1();
        this.J3.k();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
