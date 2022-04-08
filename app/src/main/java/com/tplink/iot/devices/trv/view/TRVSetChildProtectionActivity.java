package com.tplink.iot.devices.trv.view;

import android.widget.CompoundButton;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.ActivityTrvSetChildProtectionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import kotlin.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetChildProtectionActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetChildProtectionActivity extends IoTMVVMBaseActivity<ActivityTrvSetChildProtectionBinding> {
    private final f p0;

    /* compiled from: TRVSetChildProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetChildProtectionActivity tRVSetChildProtectionActivity = TRVSetChildProtectionActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetChildProtectionActivity, new IoTViewModelFactory(tRVSetChildProtectionActivity, tRVSetChildProtectionActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: TRVSetChildProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements TPSwitchCompat.a {
        b() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                TPSwitchCompat tPSwitchCompat = TRVSetChildProtectionActivity.n1(TRVSetChildProtectionActivity.this).f6733d;
                j.d(tPSwitchCompat, "mBinding.switchButton");
                i.b(tPSwitchCompat, 0L, 1, null);
                TRVSetChildProtectionActivity.this.q1().n0(z);
            }
        }
    }

    /* compiled from: TRVSetChildProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<ChildProtectionBean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(ChildProtectionBean childProtectionBean) {
            TPSwitchCompat tPSwitchCompat = TRVSetChildProtectionActivity.n1(TRVSetChildProtectionActivity.this).f6733d;
            j.d(tPSwitchCompat, "mBinding.switchButton");
            tPSwitchCompat.setChecked(childProtectionBean != null ? childProtectionBean.getEnable() : false);
        }
    }

    public TRVSetChildProtectionActivity() {
        f b2;
        b2 = kotlin.i.b(new a());
        this.p0 = b2;
    }

    public static final /* synthetic */ ActivityTrvSetChildProtectionBinding n1(TRVSetChildProtectionActivity tRVSetChildProtectionActivity) {
        return tRVSetChildProtectionActivity.f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TRVSettingsViewModel q1() {
        return (TRVSettingsViewModel) this.p0.getValue();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_child_protection;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.trv_child_protection_title);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        f1().f6733d.setOnSwitchCheckedChangeListener(new b());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        q1().H().observe(this, new c());
    }
}
