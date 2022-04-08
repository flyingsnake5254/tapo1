package com.tplink.iot.devices.trv.view;

import android.widget.CompoundButton;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityTrvSetTemperatureUnitBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.g0.g;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetTemperatureUnitActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetTemperatureUnitActivity extends IoTMVVMBaseActivity<ActivityTrvSetTemperatureUnitBinding> implements TPRadioButton.a {
    private final f p0;

    /* compiled from: TRVSetTemperatureUnitActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetTemperatureUnitActivity tRVSetTemperatureUnitActivity = TRVSetTemperatureUnitActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetTemperatureUnitActivity, new IoTViewModelFactory(tRVSetTemperatureUnitActivity, tRVSetTemperatureUnitActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureUnitActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements g<io.reactivex.e0.c> {
        b() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(TRVSetTemperatureUnitActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureUnitActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.a();
            TRVSetTemperatureUnitActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureUnitActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(TRVSetTemperatureUnitActivity.this, null, 1, null);
        }
    }

    /* compiled from: TRVSetTemperatureUnitActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<IoTSubDevice> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(IoTSubDevice ioTSubDevice) {
            EnumTemperatureUnit enumTempUnit = ioTSubDevice != null ? ioTSubDevice.getEnumTempUnit() : null;
            if (enumTempUnit != null) {
                int i = d.a[enumTempUnit.ordinal()];
                if (i == 1) {
                    TRVSetTemperatureUnitActivity.n1(TRVSetTemperatureUnitActivity.this).f6752f.check(R.id.rb_celsius);
                } else if (i == 2) {
                    TRVSetTemperatureUnitActivity.n1(TRVSetTemperatureUnitActivity.this).f6752f.check(R.id.rb_fahrenheit);
                }
            }
        }
    }

    public TRVSetTemperatureUnitActivity() {
        f b2;
        b2 = i.b(new a());
        this.p0 = b2;
    }

    public static final /* synthetic */ ActivityTrvSetTemperatureUnitBinding n1(TRVSetTemperatureUnitActivity tRVSetTemperatureUnitActivity) {
        return tRVSetTemperatureUnitActivity.f1();
    }

    private final TRVSettingsViewModel p1() {
        return (TRVSettingsViewModel) this.p0.getValue();
    }

    private final void q1(EnumTemperatureUnit enumTemperatureUnit) {
        p1().t0(enumTemperatureUnit).r(io.reactivex.d0.b.a.a()).l(new b()).i(new c()).j(new d()).y();
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a
    public void c(CompoundButton compoundButton, boolean z, boolean z2) {
        if (compoundButton != null && compoundButton.getId() == R.id.rb_celsius && z && z2) {
            q1(EnumTemperatureUnit.CELSIUS);
        } else if (compoundButton != null && compoundButton.getId() == R.id.rb_fahrenheit && z && z2) {
            q1(EnumTemperatureUnit.FAHRENHEIT);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_temperature_unit;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.temperature_unit);
        f1().f6750c.setOnCheckedChangeListener(this);
        f1().f6751d.setOnCheckedChangeListener(this);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        p1().b0().observe(this, new e());
    }
}
