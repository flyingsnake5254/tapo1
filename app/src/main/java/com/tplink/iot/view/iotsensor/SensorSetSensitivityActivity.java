package com.tplink.iot.view.iotsensor;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.ActivitySensorSetSensitivityBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSetSensitivityViewModel;
import kotlin.jvm.internal.j;

/* compiled from: SensorSetSensitivityActivity.kt */
/* loaded from: classes2.dex */
public final class SensorSetSensitivityActivity extends SensorBaseActivity<SensorSetSensitivityViewModel> {
    private ActivitySensorSetSensitivityBinding p0;

    /* compiled from: SensorSetSensitivityActivity.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<String> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(String it) {
            j.d(it, "it");
            SensorSetSensitivityActivity.this.f1().n(it);
        }
    }

    /* compiled from: SensorSetSensitivityActivity.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            SensorSetSensitivityActivity.this.l1();
        }
    }

    /* compiled from: SensorSetSensitivityActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<Integer> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            s0.g();
            if (num != null && num.intValue() == -1) {
                SensorSetSensitivityActivity sensorSetSensitivityActivity = SensorSetSensitivityActivity.this;
                s0.p(sensorSetSensitivityActivity, sensorSetSensitivityActivity.getString(R.string.common_operation_failed));
            } else if (num != null && num.intValue() == 0) {
                s0.B(SensorSetSensitivityActivity.this, null);
            }
        }
    }

    public SensorSetSensitivityActivity() {
        super(SensorSetSensitivityViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        s0.l(this);
        f1().o();
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void h1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_sensor_set_sensitivity);
        j.d(contentView, "DataBindingUtil.setConte…y_sensor_set_sensitivity)");
        ActivitySensorSetSensitivityBinding activitySensorSetSensitivityBinding = (ActivitySensorSetSensitivityBinding) contentView;
        this.p0 = activitySensorSetSensitivityBinding;
        if (activitySensorSetSensitivityBinding == null) {
            j.t("mBinding");
        }
        activitySensorSetSensitivityBinding.h(f1());
        activitySensorSetSensitivityBinding.setLifecycleOwner(this);
        b1(R.string.sensor_motion_sensitivity_title);
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void j1() {
        f1().j().observe(this, new a());
        f1().i().observe(this, new b());
        f1().l().observe(this, new c());
    }
}
