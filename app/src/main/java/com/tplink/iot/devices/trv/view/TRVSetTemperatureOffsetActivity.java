package com.tplink.iot.devices.trv.view;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.LayoutTrvOneSelectSettingsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: TRVSetTemperatureOffsetActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetTemperatureOffsetActivity extends IoTMVVMBaseActivity<LayoutTrvOneSelectSettingsBinding> {
    private static final List<Integer> p0;
    private static final List<Integer> p1;
    public static final a p2 = new a(null);
    private EnumTemperatureUnit H3 = EnumTemperatureUnit.CELSIUS;
    private int I3;
    private BottomScrollPickerFragment J3;
    private final kotlin.f p3;

    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVSetTemperatureOffsetActivity.this.z1();
        }
    }

    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetTemperatureOffsetActivity tRVSetTemperatureOffsetActivity = TRVSetTemperatureOffsetActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetTemperatureOffsetActivity, new IoTViewModelFactory(tRVSetTemperatureOffsetActivity, tRVSetTemperatureOffsetActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(TRVSetTemperatureOffsetActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7891b;

        e(int i) {
            this.f7891b = i;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.a();
            BottomScrollPickerFragment bottomScrollPickerFragment = TRVSetTemperatureOffsetActivity.this.J3;
            if (bottomScrollPickerFragment != null) {
                bottomScrollPickerFragment.dismissAllowingStateLoss();
            }
            TRVSetTemperatureOffsetActivity.this.I3 = this.f7891b;
            TRVSetTemperatureOffsetActivity.this.A1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(TRVSetTemperatureOffsetActivity.this, null, 1, null);
        }
    }

    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g extends BottomScrollPickerFragment.b {
        g() {
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b, com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public boolean b() {
            return false;
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public String e() {
            return TRVSetTemperatureOffsetActivity.this.H3.getUnitText();
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.b, com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public String f() {
            String string = TRVSetTemperatureOffsetActivity.this.getString(R.string.common_save);
            j.d(string, "getString(R.string.common_save)");
            return string;
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public int g() {
            return 0;
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public List<Integer> h() {
            return TRVSetTemperatureOffsetActivity.this.w1();
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public void j(int i) {
            TRVSetTemperatureOffsetActivity.this.y1(i);
        }
    }

    /* compiled from: TRVSetTemperatureOffsetActivity.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements Observer<IoTSubDevice> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(IoTSubDevice ioTSubDevice) {
            if (ioTSubDevice != null) {
                TRVSetTemperatureOffsetActivity.this.I3 = ioTSubDevice.getTempOffset();
                TRVSetTemperatureOffsetActivity tRVSetTemperatureOffsetActivity = TRVSetTemperatureOffsetActivity.this;
                EnumTemperatureUnit enumTempUnit = ioTSubDevice.getEnumTempUnit();
                j.d(enumTempUnit, "enumTempUnit");
                tRVSetTemperatureOffsetActivity.H3 = enumTempUnit;
                TRVSetTemperatureOffsetActivity.this.A1();
            }
        }
    }

    static {
        List<Integer> S;
        List<Integer> S2;
        S = v.S(new kotlin.v.d(-8, 8));
        p0 = S;
        S2 = v.S(new kotlin.v.d(-14, 14));
        p1 = S2;
    }

    public TRVSetTemperatureOffsetActivity() {
        kotlin.f b2;
        b2 = i.b(new c());
        this.p3 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        String d2 = com.tplink.iot.g.d.a.b.d(this.I3, this.H3);
        if (this.I3 > 0) {
            d2 = '+' + d2;
        }
        f1().f7313c.setItemInfo(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> w1() {
        int i = b.a[this.H3.ordinal()];
        if (i == 1) {
            return p0;
        }
        if (i == 2) {
            return p1;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final TRVSettingsViewModel x1() {
        return (TRVSettingsViewModel) this.p3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(int i) {
        x1().r0(i, this.H3).r(io.reactivex.d0.b.a.a()).l(new d()).i(new e(i)).j(new f()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        BottomScrollPickerFragment a2 = BottomScrollPickerFragment.f11870c.a(new g(), Integer.valueOf(this.I3));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        a2.O0(supportFragmentManager);
        p pVar = p.a;
        this.J3 = a2;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.layout_trv_one_select_settings;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.temperature_offset);
        TextView textView = f1().f7314d;
        j.d(textView, "mBinding.tvTip");
        textView.setText(getString(R.string.trv_temperature_offset_hint));
        f1().f7313c.setItemTitleHint(getString(R.string.temperature_offset));
        f1().f7313c.setOnClickListener(new b());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        x1().b0().observe(this, new h());
    }
}
