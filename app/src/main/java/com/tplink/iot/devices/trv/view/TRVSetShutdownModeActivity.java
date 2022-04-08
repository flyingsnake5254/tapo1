package com.tplink.iot.devices.trv.view;

import android.content.Context;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.ActivityTrvSetShutdownModeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.EnumShutdownMode;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ShutdownInfoBean;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetShutdownModeActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetShutdownModeActivity extends IoTMVVMBaseActivity<ActivityTrvSetShutdownModeBinding> implements TPRadioButton.a {
    public static final a p0 = new a(null);
    private final kotlin.f p1;
    private ShutdownInfoBean p2;
    private boolean p3;

    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIDMD5, boolean z) {
            j.e(context, "context");
            j.e(deviceIDMD5, "deviceIDMD5");
            Intent intent = new Intent(context, TRVSetShutdownModeActivity.class);
            intent.putExtra("device_id_md5", deviceIDMD5);
            intent.putExtra("FromDetailPageExtra", z);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetShutdownModeActivity tRVSetShutdownModeActivity = TRVSetShutdownModeActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetShutdownModeActivity, new IoTViewModelFactory(tRVSetShutdownModeActivity, tRVSetShutdownModeActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        c() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(TRVSetShutdownModeActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements io.reactivex.g0.a {
        d() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.g(TRVSetShutdownModeActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements io.reactivex.g0.g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(TRVSetShutdownModeActivity.this, null, 1, null);
        }
    }

    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class f implements TPSwitchCompat.a {
        f() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                TPSwitchCompat tPSwitchCompat = TRVSetShutdownModeActivity.n1(TRVSetShutdownModeActivity.this).x;
                j.d(tPSwitchCompat, "mBinding.switchButton");
                i.b(tPSwitchCompat, 0L, 1, null);
                TRVSetShutdownModeActivity.this.t1(z);
            }
        }
    }

    /* compiled from: TRVSetShutdownModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements Observer<ShutdownInfoBean> {
        g() {
        }

        /* renamed from: a */
        public final void onChanged(ShutdownInfoBean shutdownInfoBean) {
            TRVSetShutdownModeActivity.this.p2 = shutdownInfoBean;
            if (shutdownInfoBean != null) {
                TRVSetShutdownModeActivity.this.v1(shutdownInfoBean);
            }
        }
    }

    public TRVSetShutdownModeActivity() {
        kotlin.f b2;
        b2 = kotlin.i.b(new b());
        this.p1 = b2;
    }

    public static final /* synthetic */ ActivityTrvSetShutdownModeBinding n1(TRVSetShutdownModeActivity tRVSetShutdownModeActivity) {
        return tRVSetShutdownModeActivity.f1();
    }

    private final TRVSettingsViewModel s1() {
        return (TRVSettingsViewModel) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(boolean z) {
        EnumShutdownMode enumShutdownMode;
        RadioGroup radioGroup = f1().f6746f;
        j.d(radioGroup, "mBinding.rgShutdownMode");
        radioGroup.setVisibility(z ? 0 : 8);
        ShutdownInfoBean shutdownInfoBean = this.p2;
        if (shutdownInfoBean == null || (enumShutdownMode = shutdownInfoBean.getEnumMode()) == null) {
            enumShutdownMode = EnumShutdownMode.FULL_CLOSED;
        }
        if (!z) {
            u1(false, enumShutdownMode);
        } else {
            u1(true, enumShutdownMode);
        }
    }

    private final void u1(boolean z, EnumShutdownMode enumShutdownMode) {
        s1().q0(z, enumShutdownMode).r(io.reactivex.d0.b.a.a()).l(new c()).i(new d()).j(new e()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(ShutdownInfoBean shutdownInfoBean) {
        TPSwitchCompat tPSwitchCompat = f1().x;
        j.d(tPSwitchCompat, "mBinding.switchButton");
        tPSwitchCompat.setChecked(shutdownInfoBean.getEnable());
        RadioGroup radioGroup = f1().f6746f;
        j.d(radioGroup, "mBinding.rgShutdownMode");
        radioGroup.setVisibility(shutdownInfoBean.getEnable() ? 0 : 8);
        String mode = shutdownInfoBean.getMode();
        if (j.a(mode, EnumShutdownMode.FULL_CLOSED.getValue())) {
            f1().f6746f.check(R.id.rb_full_closed);
        } else if (j.a(mode, EnumShutdownMode.FULL_OPEN.getValue())) {
            f1().f6746f.check(R.id.rb_full_open);
        }
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a
    public void c(CompoundButton compoundButton, boolean z, boolean z2) {
        if (compoundButton != null && compoundButton.getId() == R.id.rb_full_closed && z && z2) {
            u1(true, EnumShutdownMode.FULL_CLOSED);
        } else if (compoundButton != null && compoundButton.getId() == R.id.rb_full_open && z && z2) {
            u1(true, EnumShutdownMode.FULL_OPEN);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_shutdown_mode;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void h1() {
        super.h1();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra("FromDetailPageExtra", false);
        }
        this.p3 = z;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.trv_shutdown_mode_title);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void k1() {
        if (this.p3 || s1().W().getValue() == null) {
            s1().V();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        f1().x.setOnSwitchCheckedChangeListener(new f());
        f1().f6744c.setOnCheckedChangeListener(this);
        f1().f6745d.setOnCheckedChangeListener(this);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        s1().W().observe(this, new g());
    }
}
