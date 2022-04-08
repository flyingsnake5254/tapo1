package com.tplink.iot.devices.trv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.ActivityTrvSetRemoveScaleBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.RemoveScaleInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.RemoveScaleStatusResult;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetRemoveScaleActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetRemoveScaleActivity extends IoTMVVMBaseActivity<ActivityTrvSetRemoveScaleBinding> {
    private final kotlin.f p0;
    private boolean p1;

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetRemoveScaleActivity tRVSetRemoveScaleActivity = TRVSetRemoveScaleActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetRemoveScaleActivity, new IoTViewModelFactory(tRVSetRemoveScaleActivity, tRVSetRemoveScaleActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements TPSwitchCompat.a {
        b() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                TPSwitchCompat tPSwitchCompat = TRVSetRemoveScaleActivity.p1(TRVSetRemoveScaleActivity.this).y;
                j.d(tPSwitchCompat, "mBinding.switchButton");
                i.b(tPSwitchCompat, 0L, 1, null);
                TRVSetRemoveScaleActivity.this.v1().m0(z);
            }
        }
    }

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVSetRemoveScaleActivity.this.w1();
        }
    }

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements Observer<RemoveScaleInfoBean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(RemoveScaleInfoBean removeScaleInfoBean) {
            if (removeScaleInfoBean != null) {
                TPSwitchCompat tPSwitchCompat = TRVSetRemoveScaleActivity.p1(TRVSetRemoveScaleActivity.this).y;
                j.d(tPSwitchCompat, "mBinding.switchButton");
                tPSwitchCompat.setChecked(removeScaleInfoBean.getAuto());
            }
        }
    }

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<RemoveScaleStatusResult> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(RemoveScaleStatusResult removeScaleStatusResult) {
            if (removeScaleStatusResult == null) {
                return;
            }
            if (removeScaleStatusResult.getStatus() != 1) {
                TRVSetRemoveScaleActivity.this.u1();
            } else {
                TRVSetRemoveScaleActivity.this.t1();
            }
        }
    }

    /* compiled from: TRVSetRemoveScaleActivity.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            Boolean a;
            if (aVar != null && (a = aVar.a()) != null && !a.booleanValue()) {
                com.tplink.iot.Utils.extension.e.e(TRVSetRemoveScaleActivity.this, null, 1, null);
            }
        }
    }

    public TRVSetRemoveScaleActivity() {
        kotlin.f b2;
        b2 = kotlin.i.b(new a());
        this.p0 = b2;
    }

    public static final /* synthetic */ ActivityTrvSetRemoveScaleBinding p1(TRVSetRemoveScaleActivity tRVSetRemoveScaleActivity) {
        return tRVSetRemoveScaleActivity.f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        if (!this.p1) {
            this.p1 = true;
            ActivityTrvSetRemoveScaleBinding f1 = f1();
            RelativeLayout rlSwitch = f1.x;
            j.d(rlSwitch, "rlSwitch");
            rlSwitch.setAlpha(0.5f);
            TPSwitchCompat switchButton = f1.y;
            j.d(switchButton, "switchButton");
            switchButton.setEnabled(false);
            TextView tvRemoveScale = f1.z;
            j.d(tvRemoveScale, "tvRemoveScale");
            tvRemoveScale.setAlpha(0.5f);
            TextView tvRemoveScale2 = f1.z;
            j.d(tvRemoveScale2, "tvRemoveScale");
            tvRemoveScale2.setEnabled(false);
            TPCircleProgressBar circleProgressBar = f1.f6741c;
            j.d(circleProgressBar, "circleProgressBar");
            circleProgressBar.setVisibility(0);
            f1.f6741c.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        if (this.p1) {
            this.p1 = false;
            ActivityTrvSetRemoveScaleBinding f1 = f1();
            RelativeLayout rlSwitch = f1.x;
            j.d(rlSwitch, "rlSwitch");
            rlSwitch.setAlpha(1.0f);
            TPSwitchCompat switchButton = f1.y;
            j.d(switchButton, "switchButton");
            switchButton.setEnabled(true);
            TextView tvRemoveScale = f1.z;
            j.d(tvRemoveScale, "tvRemoveScale");
            tvRemoveScale.setAlpha(1.0f);
            TextView tvRemoveScale2 = f1.z;
            j.d(tvRemoveScale2, "tvRemoveScale");
            tvRemoveScale2.setEnabled(true);
            TPCircleProgressBar circleProgressBar = f1.f6741c;
            j.d(circleProgressBar, "circleProgressBar");
            circleProgressBar.setVisibility(8);
            f1.f6741c.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TRVSettingsViewModel v1() {
        return (TRVSettingsViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        t1();
        v1().l0();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_remove_scale;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.trv_remove_scale_title);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        ActivityTrvSetRemoveScaleBinding f1 = f1();
        f1.f6741c.setProgressBarColor(getResources().getColor(R.color.common_iot_main_blue));
        f1.y.setOnSwitchCheckedChangeListener(new b());
        f1.z.setOnClickListener(new c());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        v1().T().observe(this, new d());
        v1().U().observe(this, new e());
        v1().S().observe(this, new f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity, com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v1().F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        v1().D();
        super.onDestroy();
    }
}
