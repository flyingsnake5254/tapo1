package com.tplink.iot.devices.trv.view;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityTrvSetFrostProtectionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.l;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TRVSetFrostProtectionActivity.kt */
/* loaded from: classes2.dex */
public final class TRVSetFrostProtectionActivity extends IoTMVVMBaseActivity<ActivityTrvSetFrostProtectionBinding> {
    private static final List<Integer> p0;
    private static final List<Integer> p1;
    public static final a p2 = new a(null);
    private MenuItem H3;
    private FrostProtectionBean I3;
    private EnumTemperatureUnit J3 = EnumTemperatureUnit.CELSIUS;
    private int K3 = ((Number) l.x(v1())).intValue();
    private final kotlin.f p3;

    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVSetFrostProtectionActivity.this.z1();
        }
    }

    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<TRVSettingsViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final TRVSettingsViewModel invoke() {
            TRVSetFrostProtectionActivity tRVSetFrostProtectionActivity = TRVSetFrostProtectionActivity.this;
            ViewModel viewModel = new ViewModelProvider(tRVSetFrostProtectionActivity, new IoTViewModelFactory(tRVSetFrostProtectionActivity, tRVSetFrostProtectionActivity.g1())).get(TRVSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TRVSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(TRVSetFrostProtectionActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.a();
            TRVSetFrostProtectionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(TRVSetFrostProtectionActivity.this, null, 1, null);
        }
    }

    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g extends BottomScrollPickerFragment.b {
        g() {
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public String e() {
            return TRVSetFrostProtectionActivity.this.J3.getUnitText();
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public int g() {
            return ((Number) l.x(TRVSetFrostProtectionActivity.this.v1())).intValue();
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public List<Integer> h() {
            return TRVSetFrostProtectionActivity.this.v1();
        }

        @Override // com.tplink.iot.widget.viewgroup.BottomScrollPickerFragment.c
        public void j(int i) {
            TRVSetFrostProtectionActivity.this.K3 = i;
            TRVSetFrostProtectionActivity.this.A1();
        }
    }

    /* compiled from: TRVSetFrostProtectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements Observer<FrostProtectionBean> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(FrostProtectionBean frostProtectionBean) {
            TRVSetFrostProtectionActivity.this.I3 = frostProtectionBean;
            if (frostProtectionBean != null) {
                TRVSetFrostProtectionActivity.this.K3 = frostProtectionBean.getMinTemp();
                TRVSetFrostProtectionActivity.this.J3 = EnumTemperatureUnit.Companion.a(frostProtectionBean.getTempUnit());
                TRVSetFrostProtectionActivity.this.A1();
            }
        }
    }

    static {
        List<Integer> S;
        List<Integer> S2;
        S = v.S(new kotlin.v.d(5, 15));
        p0 = S;
        S2 = v.S(new kotlin.v.d(41, 59));
        p1 = S2;
    }

    public TRVSetFrostProtectionActivity() {
        kotlin.f b2;
        b2 = i.b(new c());
        this.p3 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        x1();
        f1().f6735c.setItemInfo(com.tplink.iot.g.d.a.b.d(this.K3, this.J3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> v1() {
        int i = a.a[this.J3.ordinal()];
        if (i == 1) {
            return p0;
        }
        if (i == 2) {
            return p1;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final TRVSettingsViewModel w1() {
        return (TRVSettingsViewModel) this.p3.getValue();
    }

    private final void x1() {
        FrostProtectionBean frostProtectionBean = this.I3;
        MenuItem menuItem = this.H3;
        if (menuItem != null) {
            menuItem.setEnabled(frostProtectionBean == null || frostProtectionBean.getMinTemp() != this.K3);
        }
    }

    private final void y1() {
        w1().p0(this.K3, this.J3).r(io.reactivex.d0.b.a.a()).l(new d()).i(new e()).j(new f()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        BottomScrollPickerFragment a2 = BottomScrollPickerFragment.f11870c.a(new g(), Integer.valueOf(this.K3));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        a2.O0(supportFragmentManager);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_trv_set_frost_protection;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.trv_frost_protection);
        f1().f6735c.setItemTitleHint(getString(R.string.trv_frost_protection_item_title));
        f1().f6735c.setOnClickListener(new b());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        w1().M().observe(this, new h());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.H3 = menu != null ? menu.findItem(R.id.common_save) : null;
        x1();
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != R.id.common_save) {
            return super.onOptionsItemSelected(item);
        }
        y1();
        return true;
    }
}
