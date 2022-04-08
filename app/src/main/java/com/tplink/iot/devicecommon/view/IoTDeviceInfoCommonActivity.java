package com.tplink.iot.devicecommon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceInfoBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDeviceInfoCommonViewModel;
import com.tplink.iot.view.iotcommon.DebugFwUpdateActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.v;

/* compiled from: IoTDeviceInfoCommonActivity.kt */
/* loaded from: classes2.dex */
public final class IoTDeviceInfoCommonActivity extends BaseActivity {
    private final f p0;
    private BaseALIoTDevice<?> p1;
    private final f p2;
    private boolean p3;
    private ActivityBaseIotDeviceInfoBinding y;
    private String z = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDeviceInfoCommonActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            IoTDeviceInfoCommonActivity ioTDeviceInfoCommonActivity = IoTDeviceInfoCommonActivity.this;
            ioTDeviceInfoCommonActivity.p3 = !ioTDeviceInfoCommonActivity.p3;
            BaseALIoTDevice baseALIoTDevice = IoTDeviceInfoCommonActivity.this.p1;
            LocalIoTBaseDevice localIoTBaseDevice = null;
            Object localIoTDevice = baseALIoTDevice != null ? baseALIoTDevice.getLocalIoTDevice() : null;
            if (localIoTDevice instanceof LocalIoTBaseDevice) {
                localIoTBaseDevice = localIoTDevice;
            }
            LocalIoTBaseDevice localIoTBaseDevice2 = localIoTBaseDevice;
            if (localIoTBaseDevice2 != null) {
                IoTDeviceInfoCommonActivity.this.u1(localIoTBaseDevice2);
            }
        }
    }

    /* compiled from: IoTDeviceInfoCommonActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<TextView> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final TextView invoke() {
            ItemSettingLayout itemSettingLayout = IoTDeviceInfoCommonActivity.f1(IoTDeviceInfoCommonActivity.this).p1;
            j.d(itemSettingLayout, "mBinding.itemWifiNetwork");
            return itemSettingLayout.getItemRightTextView();
        }
    }

    /* compiled from: IoTDeviceInfoCommonActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<IoTDeviceInfoCommonViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final IoTDeviceInfoCommonViewModel invoke() {
            IoTDeviceInfoCommonActivity ioTDeviceInfoCommonActivity = IoTDeviceInfoCommonActivity.this;
            ViewModel viewModel = new ViewModelProvider(ioTDeviceInfoCommonActivity, new IoTViewModelFactory(ioTDeviceInfoCommonActivity, ioTDeviceInfoCommonActivity.z)).get(IoTDeviceInfoCommonViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (IoTDeviceInfoCommonViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDeviceInfoCommonActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<BaseALIoTDevice<?>> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(BaseALIoTDevice<?> baseALIoTDevice) {
            IoTDeviceInfoCommonActivity.this.p1 = baseALIoTDevice;
            IoTDeviceInfoCommonActivity.this.x1(baseALIoTDevice);
        }
    }

    public IoTDeviceInfoCommonActivity() {
        f b2;
        f b3;
        b2 = i.b(new c());
        this.p0 = b2;
        b3 = i.b(new b());
        this.p2 = b3;
    }

    public static final /* synthetic */ ActivityBaseIotDeviceInfoBinding f1(IoTDeviceInfoCommonActivity ioTDeviceInfoCommonActivity) {
        ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding = ioTDeviceInfoCommonActivity.y;
        if (activityBaseIotDeviceInfoBinding == null) {
            j.t("mBinding");
        }
        return activityBaseIotDeviceInfoBinding;
    }

    private final TextView m1() {
        return (TextView) this.p2.getValue();
    }

    private final IoTDeviceInfoCommonViewModel n1() {
        return (IoTDeviceInfoCommonViewModel) this.p0.getValue();
    }

    private final void o1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.z = str;
        b.d.w.c.a.m("IoTDeviceInfo mDeviceIdMD5: " + this.z);
    }

    private final void p1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_base_iot_device_info);
        j.d(contentView, "DataBindingUtil.setConte…ity_base_iot_device_info)");
        this.y = (ActivityBaseIotDeviceInfoBinding) contentView;
    }

    private final void q1() {
        c1(getString(R.string.device_info));
        m1().setVisibility(0);
        m1().setOnClickListener(new a());
    }

    private final boolean r1() {
        return j.a("playstore", "trial");
    }

    private final void s1(ItemSettingLayout itemSettingLayout, String str) {
        if (str == null || str.length() == 0) {
            itemSettingLayout.setVisibility(8);
            itemSettingLayout.setItemInfo("");
            return;
        }
        itemSettingLayout.setVisibility(0);
        itemSettingLayout.setItemInfo(str);
    }

    private final void t1(String str) {
        boolean A;
        ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding = this.y;
        if (activityBaseIotDeviceInfoBinding == null) {
            j.t("mBinding");
        }
        ItemSettingLayout itemSettingLayout = activityBaseIotDeviceInfoBinding.y;
        if (str == null || str.length() == 0) {
            itemSettingLayout.setVisibility(8);
            itemSettingLayout.setItemInfo("");
            return;
        }
        itemSettingLayout.setVisibility(0);
        A = v.A(str, "E100", false, 2, null);
        if (A) {
            itemSettingLayout.setItemInfo(String.valueOf(str));
            return;
        }
        itemSettingLayout.setItemInfo(getString(R.string.app_name) + ' ' + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(LocalIoTBaseDevice localIoTBaseDevice) {
        l.q(this, m1(), localIoTBaseDevice.getSignalLevel(), localIoTBaseDevice.getRssi(), this.p3);
    }

    private final void v1(LocalIoTBaseDevice localIoTBaseDevice) {
        if (localIoTBaseDevice instanceof IoTSubDevice) {
            IoTSubDevice ioTSubDevice = (IoTSubDevice) localIoTBaseDevice;
            if (ioTSubDevice.getSlotNumber() > 0 && ioTSubDevice.getSlotNumber() == 2) {
                ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding = this.y;
                if (activityBaseIotDeviceInfoBinding == null) {
                    j.t("mBinding");
                }
                ImageView imageView = activityBaseIotDeviceInfoBinding.z;
                j.d(imageView, "mBinding.itemSwitchButton");
                imageView.setVisibility(0);
                if (ioTSubDevice.getPosition() == 1) {
                    ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding2 = this.y;
                    if (activityBaseIotDeviceInfoBinding2 == null) {
                        j.t("mBinding");
                    }
                    activityBaseIotDeviceInfoBinding2.z.setImageResource(R.mipmap.iot_switch_left_button);
                    return;
                }
                ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding3 = this.y;
                if (activityBaseIotDeviceInfoBinding3 == null) {
                    j.t("mBinding");
                }
                activityBaseIotDeviceInfoBinding3.z.setImageResource(R.mipmap.iot_switch_right_button);
            }
        }
    }

    private final void w1() {
        n1().f().observe(this, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(BaseALIoTDevice<?> baseALIoTDevice) {
        String str = null;
        Object localIoTDevice = baseALIoTDevice != null ? baseALIoTDevice.getLocalIoTDevice() : null;
        if (!(localIoTDevice instanceof LocalIoTBaseDevice)) {
            localIoTDevice = null;
        }
        LocalIoTBaseDevice localIoTBaseDevice = (LocalIoTBaseDevice) localIoTDevice;
        if (localIoTBaseDevice != null) {
            ActivityBaseIotDeviceInfoBinding activityBaseIotDeviceInfoBinding = this.y;
            if (activityBaseIotDeviceInfoBinding == null) {
                j.t("mBinding");
            }
            ItemSettingLayout itemTimezone = activityBaseIotDeviceInfoBinding.p0;
            j.d(itemTimezone, "itemTimezone");
            s1(itemTimezone, localIoTBaseDevice.getRegion());
            ItemSettingLayout itemWifiNetwork = activityBaseIotDeviceInfoBinding.p1;
            j.d(itemWifiNetwork, "itemWifiNetwork");
            s1(itemWifiNetwork, localIoTBaseDevice.getSsid());
            t1(localIoTBaseDevice.getModel());
            ItemSettingLayout itemIpAddress = activityBaseIotDeviceInfoBinding.q;
            j.d(itemIpAddress, "itemIpAddress");
            s1(itemIpAddress, localIoTBaseDevice.getIp());
            ItemSettingLayout itemMacAddress = activityBaseIotDeviceInfoBinding.x;
            j.d(itemMacAddress, "itemMacAddress");
            s1(itemMacAddress, l.a(localIoTBaseDevice.getMac()));
            ItemSettingLayout itemHardware = activityBaseIotDeviceInfoBinding.f6508f;
            j.d(itemHardware, "itemHardware");
            s1(itemHardware, localIoTBaseDevice.getHwVer());
            ItemSettingLayout itemFwVersion = activityBaseIotDeviceInfoBinding.f6507d;
            j.d(itemFwVersion, "itemFwVersion");
            if (localIoTBaseDevice.isSupportFirmware()) {
                str = localIoTBaseDevice.getFwVer();
            }
            s1(itemFwVersion, str);
            String ssid = localIoTBaseDevice.getSsid();
            if (!(ssid == null || ssid.length() == 0)) {
                u1(localIoTBaseDevice);
            }
            v1(localIoTBaseDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o1();
        p1();
        q1();
        w1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!r1()) {
            return super.onCreateOptionsMenu(menu);
        }
        getMenuInflater().inflate(R.menu.menu_developer, menu);
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (!r1() || item.getItemId() != R.id.item_develop) {
            return super.onOptionsItemSelected(item);
        }
        X0(DebugFwUpdateActivity.class, this.z);
        return true;
    }
}
