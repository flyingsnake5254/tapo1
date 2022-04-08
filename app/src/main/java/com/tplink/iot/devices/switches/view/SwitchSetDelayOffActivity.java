package com.tplink.iot.devices.switches.view;

import android.view.MenuItem;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivitySwitchSetDelayOffBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.switches.adapter.SwitchDelayOffTimeAdapter;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionStateBean;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SwitchSetDelayOffActivity.kt */
/* loaded from: classes2.dex */
public final class SwitchSetDelayOffActivity extends IoTMVVMBaseActivity<ActivitySwitchSetDelayOffBinding> {
    private final f p0;
    private final f p1;
    private DelayActionInfoBean p2;
    private boolean p3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSetDelayOffActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements kotlin.jvm.b.a<p> {
        a() {
            super(0);
        }

        public final void a() {
            SwitchSetDelayOffActivity.this.finish();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ p invoke() {
            a();
            return p.a;
        }
    }

    /* compiled from: SwitchSetDelayOffActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<SwitchDelayOffTimeAdapter> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final SwitchDelayOffTimeAdapter invoke() {
            return new SwitchDelayOffTimeAdapter(SwitchSetDelayOffActivity.this);
        }
    }

    /* compiled from: SwitchSetDelayOffActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<SwitchSetDelayOffViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final SwitchSetDelayOffViewModel invoke() {
            SwitchSetDelayOffActivity switchSetDelayOffActivity = SwitchSetDelayOffActivity.this;
            ViewModel viewModel = new ViewModelProvider(switchSetDelayOffActivity, new IoTViewModelFactory(switchSetDelayOffActivity, switchSetDelayOffActivity.g1())).get(SwitchSetDelayOffViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (SwitchSetDelayOffViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: SwitchSetDelayOffActivity.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            SwitchSetDelayOffActivity.this.w1(aVar);
        }
    }

    /* compiled from: SwitchSetDelayOffActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<DelayActionInfoBean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(DelayActionInfoBean delayActionInfoBean) {
            if (!SwitchSetDelayOffActivity.this.p3) {
                SwitchSetDelayOffActivity.this.p3 = true;
                SwitchSetDelayOffActivity.this.p2 = delayActionInfoBean;
                if (delayActionInfoBean != null) {
                    SwitchSetDelayOffActivity.this.z1(delayActionInfoBean);
                }
            }
        }
    }

    public SwitchSetDelayOffActivity() {
        f b2;
        f b3;
        b2 = i.b(new c());
        this.p0 = b2;
        b3 = i.b(new b());
        this.p1 = b3;
    }

    private final DelayActionInfoBean t1() {
        boolean z = v1().j().get();
        return new DelayActionInfoBean(new DelayActionStateBean(false), z, z ? u1().t().intValue() : 0);
    }

    private final SwitchDelayOffTimeAdapter u1() {
        return (SwitchDelayOffTimeAdapter) this.p1.getValue();
    }

    private final SwitchSetDelayOffViewModel v1() {
        return (SwitchSetDelayOffViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
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

    private final boolean x1(DelayActionInfoBean delayActionInfoBean) {
        DelayActionInfoBean delayActionInfoBean2 = this.p2;
        if (delayActionInfoBean2 != null) {
            return (!delayActionInfoBean2.getEnabled() && !delayActionInfoBean.getEnabled()) || (delayActionInfoBean2.getEnabled() == delayActionInfoBean.getEnabled() && delayActionInfoBean2.getTime() == delayActionInfoBean.getTime());
        }
        return false;
    }

    private final void y1() {
        DelayActionInfoBean t1 = t1();
        if (x1(t1)) {
            t1 = null;
        }
        if (t1 != null) {
            com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
            v1().k(t1);
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(DelayActionInfoBean delayActionInfoBean) {
        v1().j().set(delayActionInfoBean.getEnabled());
        if (delayActionInfoBean.getEnabled()) {
            u1().B(delayActionInfoBean.getTime());
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_switch_set_delay_off;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.switch_delay_off_title);
        RecyclerView recyclerView = f1().f6715d;
        j.d(recyclerView, "mBinding.rvDelayTime");
        recyclerView.setAdapter(u1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        f1().h(v1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        v1().g().observe(this, new d());
        v1().h().observe(this, new e());
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
