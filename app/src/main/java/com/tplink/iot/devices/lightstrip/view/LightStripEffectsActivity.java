package com.tplink.iot.devices.lightstrip.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityLightStripEffectsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.view.effects.LightStripLightingEffectFragment;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripEffectsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import io.reactivex.g0.j;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;

/* compiled from: LightStripEffectsActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripEffectsActivity extends IoTMVVMBaseActivity<ActivityLightStripEffectsBinding> implements com.tplink.iot.g.b.a.b {
    private final f p0;
    private final f p1;
    private MenuItem p2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripEffectsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements j<CustomizedEffect, io.reactivex.e> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightStripEffectsActivity.kt */
        /* renamed from: com.tplink.iot.devices.lightstrip.view.LightStripEffectsActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final /* synthetic */ class C0203a extends FunctionReferenceImpl implements l<String, PredefinedEffect> {
            C0203a(LightStripEffectsViewModel lightStripEffectsViewModel) {
                super(1, lightStripEffectsViewModel, LightStripEffectsViewModel.class, "getPredefinedEffectFromMap", "getPredefinedEffectFromMap(Ljava/lang/String;)Lcom/tplink/libtpnetwork/IoTNetwork/bean/lightstrip/lightingeffect/model/PredefinedEffect;", 0);
            }

            /* renamed from: a */
            public final PredefinedEffect invoke(String p1) {
                kotlin.jvm.internal.j.e(p1, "p1");
                return ((LightStripEffectsViewModel) this.receiver).m(p1);
            }
        }

        a() {
        }

        /* renamed from: a */
        public final io.reactivex.e apply(CustomizedEffect it) {
            kotlin.jvm.internal.j.e(it, "it");
            return LightStripEffectsActivity.this.t1().p(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.b(it, LightStripEffectsActivity.this.t1().n(), new C0203a(LightStripEffectsActivity.this.t1()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripEffectsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements j<PredefinedEffect, io.reactivex.e> {
        b() {
        }

        /* renamed from: a */
        public final io.reactivex.e apply(PredefinedEffect it) {
            kotlin.jvm.internal.j.e(it, "it");
            return LightStripEffectsActivity.this.t1().p(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.c(it, LightStripEffectsActivity.this.t1().n())));
        }
    }

    /* compiled from: LightStripEffectsActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<LightStripLightingEffectFragment> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripLightingEffectFragment invoke() {
            return LightStripLightingEffectFragment.p1.a(LightStripEffectsActivity.this.g1(), 0);
        }
    }

    /* compiled from: LightStripEffectsActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<LightStripEffectsViewModel> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripEffectsViewModel invoke() {
            LightStripEffectsActivity lightStripEffectsActivity = LightStripEffectsActivity.this;
            ViewModel viewModel = new ViewModelProvider(lightStripEffectsActivity, new IoTViewModelFactory(lightStripEffectsActivity, lightStripEffectsActivity.g1())).get(LightStripEffectsViewModel.class);
            kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (LightStripEffectsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: LightStripEffectsActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            Integer a;
            if (aVar != null && (a = aVar.a()) != null) {
                LightStripEffectsActivity.this.u1(a.intValue());
            }
        }
    }

    public LightStripEffectsActivity() {
        f b2;
        f b3;
        b2 = i.b(new c());
        this.p0 = b2;
        b3 = i.b(new d());
        this.p1 = b3;
    }

    private final void q1(String str) {
        t1().i(str).R(new a()).y();
    }

    private final void r1(String str) {
        t1().l(str).R(new b()).y();
    }

    private final LightStripLightingEffectFragment s1() {
        return (LightStripLightingEffectFragment) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LightStripEffectsViewModel t1() {
        return (LightStripEffectsViewModel) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(int i) {
        if (i == 100) {
            com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
        } else if (i == 200) {
            com.tplink.iot.Utils.extension.e.g(this, null, 1, null);
        } else if (i == 300) {
            com.tplink.iot.Utils.extension.e.e(this, null, 1, null);
        }
    }

    @Override // com.tplink.iot.g.b.a.b
    public void C(com.tplink.iot.g.b.b.a data) {
        kotlin.jvm.internal.j.e(data, "data");
        String e2 = data.e();
        if (e2 != null) {
            q1(e2);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_light_strip_effects;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.light_strip_effects);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, s1(), (String) null).commit();
        s1().v1(this);
    }

    @Override // com.tplink.iot.g.b.a.b
    public void m0(com.tplink.iot.g.b.b.c data) {
        kotlin.jvm.internal.j.e(data, "data");
        t1().o(data.e());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        t1().h().observe(this, new e());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification_edit, menu);
        this.p2 = menu != null ? menu.findItem(R.id.action_edit_done) : null;
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.j.e(item, "item");
        if (item.getItemId() != R.id.action_edit_done) {
            return super.onOptionsItemSelected(item);
        }
        boolean z = !s1().j1();
        MenuItem menuItem = this.p2;
        if (menuItem != null) {
            menuItem.setTitle(z ? R.string.common_done : R.string.common_edit);
        }
        s1().s1(z);
        return true;
    }

    @Override // com.tplink.iot.g.b.a.b
    public void p0(com.tplink.iot.g.b.b.d data) {
        kotlin.jvm.internal.j.e(data, "data");
        if (data.i()) {
            LightStateBean c2 = data.c();
            if (c2 != null) {
                t1().o(c2);
                return;
            }
            return;
        }
        String f2 = data.f();
        if (f2 != null) {
            r1(f2);
        }
    }

    @Override // com.tplink.iot.g.b.a.b
    public void t0(com.tplink.iot.g.b.b.b data) {
        kotlin.jvm.internal.j.e(data, "data");
        String e2 = data.e();
        if (e2 != null) {
            q1(e2);
        }
    }
}
