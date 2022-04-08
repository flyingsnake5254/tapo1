package com.tplink.iot.devices.trv.view;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.databinding.ActivityTrvSetProgressCalibrationBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.ProgressCalibrationInfoResult;
import java.util.List;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.w;

/* compiled from: TRVSetProgressCalibrationActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetProgressCalibrationActivity extends IoTMVVMBaseActivity<ActivityTrvSetProgressCalibrationBinding> {
    private final f p0;
    private boolean p1;

    /* compiled from: TRVSetProgressCalibrationActivity.kt */
    /* loaded from: classes2.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVSetProgressCalibrationActivity.this.w1();
        }
    }

    /* compiled from: TRVSetProgressCalibrationActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetProgressCalibrationActivity tRVSetProgressCalibrationActivity = TRVSetProgressCalibrationActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetProgressCalibrationActivity, new IoTViewModelFactory(tRVSetProgressCalibrationActivity, tRVSetProgressCalibrationActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: TRVSetProgressCalibrationActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<ProgressCalibrationInfoResult> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(ProgressCalibrationInfoResult progressCalibrationInfoResult) {
            if (progressCalibrationInfoResult == null) {
                return;
            }
            if (progressCalibrationInfoResult.getStatus() != 1) {
                TRVSetProgressCalibrationActivity.this.t1();
                TRVSetProgressCalibrationActivity.this.v1(progressCalibrationInfoResult.getStatus());
                return;
            }
            TRVSetProgressCalibrationActivity.this.s1();
        }
    }

    /* compiled from: TRVSetProgressCalibrationActivity.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            Boolean a;
            if (aVar != null && (a = aVar.a()) != null && !a.booleanValue()) {
                e.e(TRVSetProgressCalibrationActivity.this, null, 1, null);
                TRVSetProgressCalibrationActivity.this.t1();
            }
        }
    }

    public TRVSetProgressCalibrationActivity() {
        f b2;
        b2 = i.b(new b());
        this.p0 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        this.p1 = true;
        TPRefreshableButton tPRefreshableButton = f1().f6738c;
        j.d(tPRefreshableButton, "mBinding.btnBottom");
        if (!tPRefreshableButton.b()) {
            f1().f6738c.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        f1().f6738c.h();
        f1().f6738c.setText(getString(R.string.trv_calibrate));
    }

    private final TRVSettingsViewModel u1() {
        return (TRVSettingsViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(int i) {
        if (this.p1) {
            this.p1 = false;
            if (i == -1) {
                f1().f6739d.setMessage(R.string.trv_device_error_tip);
            } else {
                f1().f6739d.setMessage(R.string.trv_finish_progress_calibration);
            }
            f1().f6739d.d(PathInterpolatorCompat.MAX_NUM_POINTS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        s1();
        u1().v0();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_progress_calibration;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        List f0;
        b1(R.string.trv_progress_calibration_title);
        String string = getString(R.string.trv_calibration_introduce);
        j.d(string, "getString(R.string.trv_calibration_introduce)");
        f0 = w.f0(string, new String[]{"\n"}, false, 0, 6, null);
        if (f0.size() >= 2) {
            f1().q.setContent((String) f0.get(0));
            f1().x.setContent((String) f0.get(1));
        } else {
            f1().q.setContent(getString(R.string.trv_calibration_introduce));
            PointTextView pointTextView = f1().x;
            j.d(pointTextView, "mBinding.tvTip2");
            pointTextView.setVisibility(8);
        }
        f1().f6738c.setOnClickListener(new a());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        u1().R().observe(this, new c());
        u1().P().observe(this, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity, com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u1().E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        u1().C();
        super.onDestroy();
    }
}
