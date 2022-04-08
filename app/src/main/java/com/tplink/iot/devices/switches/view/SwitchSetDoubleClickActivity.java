package com.tplink.iot.devices.switches.view;

import android.view.MenuItem;
import android.widget.CompoundButton;
import androidx.annotation.LayoutRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivitySwitchSetDoubleClickBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDoubleClickViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import kotlin.i;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SwitchSetDoubleClickActivity.kt */
/* loaded from: classes2.dex */
public final class SwitchSetDoubleClickActivity extends IoTMVVMBaseActivity<ActivitySwitchSetDoubleClickBinding> {
    private final kotlin.f p0;
    private DoubleClickInfoBean p1;
    private boolean p2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements kotlin.jvm.b.a<p> {
        a() {
            super(0);
        }

        public final void a() {
            SwitchSetDoubleClickActivity.this.finish();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ p invoke() {
            a();
            return p.a;
        }
    }

    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements TPSwitchCompat.a {
        b() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                SwitchSetDoubleClickActivity.this.w1().k().set(z);
                SwitchSetDoubleClickActivity.this.z1();
            }
        }
    }

    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<SwitchSetDoubleClickViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final SwitchSetDoubleClickViewModel invoke() {
            SwitchSetDoubleClickActivity switchSetDoubleClickActivity = SwitchSetDoubleClickActivity.this;
            ViewModel viewModel = new ViewModelProvider(switchSetDoubleClickActivity, new IoTViewModelFactory(switchSetDoubleClickActivity, switchSetDoubleClickActivity.g1())).get(SwitchSetDoubleClickViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (SwitchSetDoubleClickViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements l<com.tplink.iot.Utils.extension.f, p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SwitchSetDoubleClickActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.a<p> {
            a() {
                super(0);
            }

            public final void a() {
                SwitchSetDoubleClickActivity.this.w1().k().set(true);
            }

            @Override // kotlin.jvm.b.a
            public /* bridge */ /* synthetic */ p invoke() {
                a();
                return p.a;
            }
        }

        d() {
            super(1);
        }

        public final void a(com.tplink.iot.Utils.extension.f receiver) {
            j.e(receiver, "$receiver");
            receiver.h(R.string.switch_double_click_disable_remind);
            receiver.d(R.string.common_cancel, receiver.a(), new a());
            com.tplink.iot.Utils.extension.f.g(receiver, R.string.turn_off_anyway, receiver.c(), null, 4, null);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(com.tplink.iot.Utils.extension.f fVar) {
            a(fVar);
            return p.a;
        }
    }

    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<DoubleClickInfoBean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(DoubleClickInfoBean doubleClickInfoBean) {
            if (!SwitchSetDoubleClickActivity.this.p2) {
                SwitchSetDoubleClickActivity.this.p2 = true;
                SwitchSetDoubleClickActivity.this.p1 = doubleClickInfoBean;
                if (doubleClickInfoBean != null) {
                    SwitchSetDoubleClickActivity.this.A1(doubleClickInfoBean);
                }
            }
        }
    }

    /* compiled from: SwitchSetDoubleClickActivity.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            SwitchSetDoubleClickActivity.this.x1(aVar);
        }
    }

    public SwitchSetDoubleClickActivity() {
        kotlin.f b2;
        b2 = i.b(new c());
        this.p0 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(DoubleClickInfoBean doubleClickInfoBean) {
        w1().k().set(doubleClickInfoBean.getEnable());
        if (doubleClickInfoBean.getEnable()) {
            w1().i().set(doubleClickInfoBean.getInterval() - 100);
        }
    }

    private final DoubleClickInfoBean v1() {
        return new DoubleClickInfoBean(w1().k().get(), w1().k().get() ? w1().i().get() + 100 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwitchSetDoubleClickViewModel w1() {
        return (SwitchSetDoubleClickViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
        Boolean success;
        com.tplink.iot.Utils.extension.e.a();
        if (aVar != null && (success = aVar.a()) != null) {
            j.d(success, "success");
            if (success.booleanValue()) {
                finish();
            } else {
                com.tplink.iot.Utils.extension.e.d(this, new a());
            }
        }
    }

    private final void y1() {
        DoubleClickInfoBean v1 = v1();
        if (!(!j.a(v1, this.p1))) {
            v1 = null;
        }
        if (v1 != null) {
            com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
            w1().l(v1);
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        if (!w1().k().get()) {
            com.tplink.iot.Utils.extension.e.r(this, new d());
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    @LayoutRes
    public int e1() {
        return R.layout.activity_switch_set_double_click;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.smart_trigger_double_tap);
        f1().f6718d.setOnSwitchCheckedChangeListener(new b());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        f1().h(w1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        w1().g().observe(this, new e());
        w1().h().observe(this, new f());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        y1();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
