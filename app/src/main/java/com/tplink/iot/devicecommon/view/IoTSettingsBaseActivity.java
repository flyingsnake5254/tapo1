package com.tplink.iot.devicecommon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.databinding.ActivityBaseIotDeviceSettingsBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: IoTSettingsBaseActivity.kt */
/* loaded from: classes2.dex */
public abstract class IoTSettingsBaseActivity<VM extends IoTSettingsBaseViewModel> extends BaseActivity implements View.OnClickListener {
    private final kotlin.f p0;
    private BaseALIoTDevice<?> p1;
    protected ActivityBaseIotDeviceSettingsBinding y;
    private String z = "";
    private boolean p2 = true;

    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<VM> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f7405d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls) {
            super(0);
            this.f7405d = cls;
        }

        /* renamed from: a */
        public final VM invoke() {
            IoTSettingsBaseActivity ioTSettingsBaseActivity = IoTSettingsBaseActivity.this;
            ViewModel viewModel = new ViewModelProvider(ioTSettingsBaseActivity, new IoTViewModelFactory(ioTSettingsBaseActivity, ioTSettingsBaseActivity.m1())).get(this.f7405d);
            j.d(viewModel, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
            return (VM) ((IoTSettingsBaseViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements TPMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
            IoTSettingsBaseActivity.this.E1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
            IoTSettingsBaseActivity.this.e1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<BaseALIoTDevice<?>> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(BaseALIoTDevice<?> baseALIoTDevice) {
            IoTSettingsBaseActivity.this.y1(baseALIoTDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Observer<ThingFirmware> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(ThingFirmware thingFirmware) {
            ItemSettingLayout itemSettingLayout = IoTSettingsBaseActivity.this.l1().z;
            boolean z = true;
            if (thingFirmware == null || !thingFirmware.isNeedToUpgrade()) {
                z = false;
            }
            itemSettingLayout.setNotificationVisible(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements Observer<i<CloudResult<Void>>> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(i<CloudResult<Void>> iVar) {
            IoTSettingsBaseActivity.this.r1(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTSettingsBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements Observer<i<p>> {
        g() {
        }

        /* renamed from: a */
        public final void onChanged(i<p> iVar) {
            IoTSettingsBaseActivity.this.r1(iVar);
        }
    }

    public IoTSettingsBaseActivity(Class<VM> vmClz) {
        kotlin.f b2;
        j.e(vmClz, "vmClz");
        b2 = kotlin.i.b(new a(vmClz));
        this.p0 = b2;
    }

    private final void A1() {
        if (n1().w()) {
            C1();
        } else {
            B1();
        }
    }

    private final void B1() {
        String str;
        int n = n1().n();
        if (n <= 0) {
            str = o1();
        } else if (n == 1) {
            str = getString(R.string.share_device_share_device_title_user, new Object[]{String.valueOf(n)});
            j.d(str, "getString(R.string.share…e_user, count.toString())");
        } else {
            str = getString(R.string.share_device_share_device_title_deletes, new Object[]{String.valueOf(n)});
            j.d(str, "getString(R.string.share…eletes, count.toString())");
        }
        new TPMaterialDialogV2.Builder(this).j(str).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_remove, R.color.common_iot_red, new b()).g(8, 8).setCancelable(false).c(false).show();
    }

    private final void C1() {
        new TPMaterialDialogV2.Builder(this).j(p1()).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_remove, R.color.common_iot_red, new c()).g(8, 8).setCancelable(false).c(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1() {
        s0.l(this);
        n1().z(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        s0.l(this);
        n1().f(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(i<?> iVar) {
        s0.g();
        if (iVar == null || iVar.b() != 0) {
            w1();
        } else {
            Y0();
        }
    }

    private final void t1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_base_iot_device_settings);
        j.d(contentView, "DataBindingUtil.setConte…base_iot_device_settings)");
        ActivityBaseIotDeviceSettingsBinding activityBaseIotDeviceSettingsBinding = (ActivityBaseIotDeviceSettingsBinding) contentView;
        this.y = activityBaseIotDeviceSettingsBinding;
        if (activityBaseIotDeviceSettingsBinding == null) {
            j.t("mBinding");
        }
        activityBaseIotDeviceSettingsBinding.i(n1());
        activityBaseIotDeviceSettingsBinding.h(this);
        activityBaseIotDeviceSettingsBinding.setLifecycleOwner(this);
    }

    private final void w1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    @CallSuper
    public void D1() {
        n1().j().observe(this, new d());
        n1().p().observe(this, new e());
        n1().i().observe(this, new f());
        n1().v().observe(this, new g());
    }

    public void i1(FrameLayout flFeatureExt) {
        j.e(flFeatureExt, "flFeatureExt");
    }

    public void j1(FrameLayout flOtherExt) {
        j.e(flOtherExt, "flOtherExt");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseALIoTDevice<?> k1() {
        return this.p1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ActivityBaseIotDeviceSettingsBinding l1() {
        ActivityBaseIotDeviceSettingsBinding activityBaseIotDeviceSettingsBinding = this.y;
        if (activityBaseIotDeviceSettingsBinding == null) {
            j.t("mBinding");
        }
        return activityBaseIotDeviceSettingsBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String m1() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VM n1() {
        return (VM) ((IoTSettingsBaseViewModel) this.p0.getValue());
    }

    public String o1() {
        String string = getString(R.string.share_device_share_device_no_longer);
        j.d(string, "getString(R.string.share…e_share_device_no_longer)");
        return string;
    }

    @Override // android.view.View.OnClickListener
    @CallSuper
    public void onClick(View view) {
        String deviceId;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.item_avatar) {
            X0(IoTSettingAvatarActivity.class, this.z);
        } else if (valueOf != null && valueOf.intValue() == R.id.item_name) {
            X0(IoTSettingNameActivity.class, this.z);
        } else if (valueOf != null && valueOf.intValue() == R.id.item_location) {
            BaseALIoTDevice<?> baseALIoTDevice = this.p1;
            if (baseALIoTDevice != null && (deviceId = baseALIoTDevice.getDeviceId()) != null) {
                IoTSettingLocationSelectActivity.o1(this, deviceId);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.item_device_info) {
            X0(IoTDeviceInfoCommonActivity.class, this.z);
        } else if (valueOf != null && valueOf.intValue() == R.id.item_fw_version) {
            q1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_remove) {
            A1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s1();
        t1();
        u1();
        D1();
        v1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        n1().m();
        if (this.p2) {
            this.p2 = false;
            n1().o();
        }
    }

    public String p1() {
        String string = getString(R.string.share_device_share_device_no_longer);
        j.d(string, "getString(R.string.share…e_share_device_no_longer)");
        return string;
    }

    public void q1() {
        X0(IoTFirmwareUpdateActivity.class, this.z);
    }

    @CallSuper
    public void s1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.z = str;
    }

    @CallSuper
    public void u1() {
        b1(R.string.common_device_settings);
        ActivityBaseIotDeviceSettingsBinding activityBaseIotDeviceSettingsBinding = this.y;
        if (activityBaseIotDeviceSettingsBinding == null) {
            j.t("mBinding");
        }
        FrameLayout frameLayout = activityBaseIotDeviceSettingsBinding.f6511f;
        j.d(frameLayout, "mBinding.flFeatureExt");
        i1(frameLayout);
        ActivityBaseIotDeviceSettingsBinding activityBaseIotDeviceSettingsBinding2 = this.y;
        if (activityBaseIotDeviceSettingsBinding2 == null) {
            j.t("mBinding");
        }
        FrameLayout frameLayout2 = activityBaseIotDeviceSettingsBinding2.q;
        j.d(frameLayout2, "mBinding.flOtherExt");
        j1(frameLayout2);
    }

    public void v1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x1(boolean z) {
        ActivityBaseIotDeviceSettingsBinding activityBaseIotDeviceSettingsBinding = this.y;
        if (activityBaseIotDeviceSettingsBinding == null) {
            j.t("mBinding");
        }
        View view = activityBaseIotDeviceSettingsBinding.f6510d;
        j.d(view, "mBinding.featureExtDivider");
        view.setVisibility(z ? 0 : 8);
    }

    protected final void y1(BaseALIoTDevice<?> baseALIoTDevice) {
        this.p1 = baseALIoTDevice;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z1(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.setVariable(89, n1());
            viewDataBinding.setVariable(69, this);
            viewDataBinding.setLifecycleOwner(this);
        }
    }
}
