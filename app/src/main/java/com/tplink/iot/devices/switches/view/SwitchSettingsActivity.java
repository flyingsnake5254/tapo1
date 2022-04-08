package com.tplink.iot.devices.switches.view;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.databinding.LayoutSwitchSettingsFeatureExtBinding;
import com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;
import kotlin.text.v;

/* compiled from: SwitchSettingsActivity.kt */
/* loaded from: classes2.dex */
public final class SwitchSettingsActivity extends IoTSettingsBaseActivity<SwitchSettingsViewModel> {
    private LayoutSwitchSettingsFeatureExtBinding p3;

    /* compiled from: SwitchSettingsActivity.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<DelayActionInfoBean> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(DelayActionInfoBean delayActionInfoBean) {
            if (delayActionInfoBean != null) {
                SwitchSettingsActivity.this.G1(delayActionInfoBean);
            }
        }
    }

    public SwitchSettingsActivity() {
        super(SwitchSettingsViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(DelayActionInfoBean delayActionInfoBean) {
        if (delayActionInfoBean.getEnabled()) {
            LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding = this.p3;
            if (layoutSwitchSettingsFeatureExtBinding == null) {
                j.t("mFeatureExtBinding");
            }
            layoutSwitchSettingsFeatureExtBinding.f7301c.setItemInfo(getString(R.string.time_seconds, new Object[]{Integer.valueOf(delayActionInfoBean.getTime())}));
            return;
        }
        LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding2 = this.p3;
        if (layoutSwitchSettingsFeatureExtBinding2 == null) {
            j.t("mFeatureExtBinding");
        }
        layoutSwitchSettingsFeatureExtBinding2.f7301c.setItemInfo(getString(R.string.item_disabled));
    }

    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity
    public void D1() {
        super.D1();
        n1().B().observe(this, new a());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity
    public void i1(FrameLayout flFeatureExt) {
        j.e(flFeatureExt, "flFeatureExt");
        ViewDataBinding inflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_switch_settings_feature_ext, flFeatureExt, true);
        j.d(inflate, "DataBindingUtil.inflate(…_ext, flFeatureExt, true)");
        LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding = (LayoutSwitchSettingsFeatureExtBinding) inflate;
        this.p3 = layoutSwitchSettingsFeatureExtBinding;
        if (layoutSwitchSettingsFeatureExtBinding == null) {
            j.t("mFeatureExtBinding");
        }
        z1(layoutSwitchSettingsFeatureExtBinding);
        x1(true);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity
    public String o1() {
        String deviceModel;
        boolean A;
        BaseALIoTDevice<?> k1 = k1();
        if (!(k1 == null || (deviceModel = k1.getDeviceModel()) == null)) {
            A = v.A(deviceModel, "S220", false, 2, null);
            if (A) {
                String string = getString(R.string.switch_remove_button_no_longer_tip);
                j.d(string, "getString(R.string.switc…ove_button_no_longer_tip)");
                return string;
            }
        }
        return super.o1();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.item_delay_off) {
            X0(SwitchSetDelayOffActivity.class, m1());
        } else if (valueOf != null && valueOf.intValue() == R.id.item_double_click) {
            X0(SwitchSetDoubleClickActivity.class, m1());
        } else {
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (n1().F()) {
            n1().A();
        }
        if (n1().G()) {
            n1().C();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity
    public void u1() {
        super.u1();
        LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding = this.p3;
        if (layoutSwitchSettingsFeatureExtBinding == null) {
            j.t("mFeatureExtBinding");
        }
        ItemSettingLayout itemSettingLayout = layoutSwitchSettingsFeatureExtBinding.f7301c;
        j.d(itemSettingLayout, "mFeatureExtBinding.itemDelayOff");
        int i = 8;
        itemSettingLayout.setVisibility(n1().F() ? 0 : 8);
        LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding2 = this.p3;
        if (layoutSwitchSettingsFeatureExtBinding2 == null) {
            j.t("mFeatureExtBinding");
        }
        ItemSettingLayout itemSettingLayout2 = layoutSwitchSettingsFeatureExtBinding2.f7302d;
        j.d(itemSettingLayout2, "mFeatureExtBinding.itemDoubleClick");
        itemSettingLayout2.setVisibility(n1().G() ? 0 : 8);
        View view = l1().f6510d;
        j.d(view, "mBinding.featureExtDivider");
        LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding3 = this.p3;
        if (layoutSwitchSettingsFeatureExtBinding3 == null) {
            j.t("mFeatureExtBinding");
        }
        ItemSettingLayout itemSettingLayout3 = layoutSwitchSettingsFeatureExtBinding3.f7301c;
        j.d(itemSettingLayout3, "mFeatureExtBinding.itemDelayOff");
        int visibility = itemSettingLayout3.getVisibility();
        boolean z = true;
        if (!(visibility == 0)) {
            LayoutSwitchSettingsFeatureExtBinding layoutSwitchSettingsFeatureExtBinding4 = this.p3;
            if (layoutSwitchSettingsFeatureExtBinding4 == null) {
                j.t("mFeatureExtBinding");
            }
            ItemSettingLayout itemSettingLayout4 = layoutSwitchSettingsFeatureExtBinding4.f7302d;
            j.d(itemSettingLayout4, "mFeatureExtBinding.itemDoubleClick");
            if (!(itemSettingLayout4.getVisibility() == 0)) {
                z = false;
            }
        }
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
    }
}
