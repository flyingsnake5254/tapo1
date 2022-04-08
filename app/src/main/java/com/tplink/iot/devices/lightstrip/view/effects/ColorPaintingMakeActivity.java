package com.tplink.iot.devices.lightstrip.view.effects;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityColorPaintingMakeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.lightingeffect.ColorPaintingSegment;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import com.tplink.iot.devices.lightstrip.view.effects.ColorPickerDialogFragment;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.ColorPaintingMakeViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.o;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;

/* compiled from: ColorPaintingMakeActivity.kt */
/* loaded from: classes2.dex */
public final class ColorPaintingMakeActivity extends IoTMVVMBaseActivity<ActivityColorPaintingMakeBinding> implements View.OnClickListener, ColorPickerDialogFragment.b {
    private int H3;
    private MenuItem I3;
    private final List<ColorPaintingSegment> J3 = new ArrayList();
    private KasaLightState K3;
    private final kotlin.f L3;
    private String M3;
    private final kotlin.f N3;
    public static final a p3 = new a(null);
    private static final int p0 = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(40, 100, 100).f();
    private static final KasaLightState p1 = KasaLightState.builder().q(40).s(100).n(100).r(1).o();
    private static final KasaLightState p2 = KasaLightState.builder().q(0).s(0).n(0).o();

    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final Intent a(Context context, String deviceIdMD5, int i, String str) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, ColorPaintingMakeActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("ModeExtra", i);
            intent.putExtra("EffectIdExtra", str);
            return intent;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements p<Integer, Integer, kotlin.p> {
        b() {
            super(2);
        }

        public final void a(int i, int i2) {
            ColorPaintingMakeActivity.this.M1(i, i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, Integer num2) {
            a(num.intValue(), num2.intValue());
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T1, T2, R> implements io.reactivex.g0.c<Integer, CustomizedEffect, Pair<? extends Integer, ? extends CustomizedEffect>> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f7570c = new c();

        c() {
        }

        /* renamed from: a */
        public final Pair<Integer, CustomizedEffect> apply(Integer len, CustomizedEffect effect) {
            kotlin.jvm.internal.j.e(len, "len");
            kotlin.jvm.internal.j.e(effect, "effect");
            return new Pair<>(len, effect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        d() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(ColorPaintingMakeActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements io.reactivex.g0.g<Pair<? extends Integer, ? extends CustomizedEffect>> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Pair<Integer, ? extends CustomizedEffect> pair) {
            int intValue = pair.component1().intValue();
            com.tplink.iot.Utils.extension.e.a();
            ColorPaintingMakeActivity.this.H1(intValue, com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.x((CustomizedEffect) pair.component2()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(ColorPaintingMakeActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        g() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(ColorPaintingMakeActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements io.reactivex.g0.g<Integer> {
        h() {
        }

        /* renamed from: a */
        public final void accept(Integer it) {
            com.tplink.iot.Utils.extension.e.a();
            ColorPaintingMakeActivity colorPaintingMakeActivity = ColorPaintingMakeActivity.this;
            kotlin.jvm.internal.j.d(it, "it");
            colorPaintingMakeActivity.G1(it.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements io.reactivex.g0.g<Throwable> {
        i() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(ColorPaintingMakeActivity.this, null, 1, null);
        }
    }

    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    static final class j extends Lambda implements kotlin.jvm.b.a<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e> {

        /* renamed from: c  reason: collision with root package name */
        public static final j f7577c = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e invoke() {
            return new com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e();
        }
    }

    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    static final class k extends Lambda implements kotlin.jvm.b.a<ColorPaintingMakeViewModel> {
        k() {
            super(0);
        }

        /* renamed from: a */
        public final ColorPaintingMakeViewModel invoke() {
            ColorPaintingMakeActivity colorPaintingMakeActivity = ColorPaintingMakeActivity.this;
            ViewModel viewModel = new ViewModelProvider(colorPaintingMakeActivity, new IoTViewModelFactory(colorPaintingMakeActivity, colorPaintingMakeActivity.g1())).get(ColorPaintingMakeViewModel.class);
            kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (ColorPaintingMakeViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: ColorPaintingMakeActivity.kt */
    /* loaded from: classes2.dex */
    static final class l<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        l() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            Integer code;
            if (aVar != null && (code = aVar.a()) != null) {
                ColorPaintingMakeActivity colorPaintingMakeActivity = ColorPaintingMakeActivity.this;
                kotlin.jvm.internal.j.d(code, "code");
                colorPaintingMakeActivity.J1(code.intValue());
            }
        }
    }

    public ColorPaintingMakeActivity() {
        kotlin.f b2;
        kotlin.f b3;
        KasaLightState DEFAULT_VALUE = p1;
        kotlin.jvm.internal.j.d(DEFAULT_VALUE, "DEFAULT_VALUE");
        this.K3 = DEFAULT_VALUE;
        b2 = kotlin.i.b(new k());
        this.L3 = b2;
        b3 = kotlin.i.b(j.f7577c);
        this.N3 = b3;
    }

    private final List<KasaLightState> A1(int i2, LightStripLightingEffect lightStripLightingEffect) {
        ArrayList arrayList = new ArrayList();
        if (lightStripLightingEffect != null) {
            if (i2 > lightStripLightingEffect.getSegments().size()) {
                y1(i2, lightStripLightingEffect);
            }
            com.tplink.iot.devices.lightstrip.lightingeffect.common.a lightStateGroup = B1().t(lightStripLightingEffect);
            kotlin.jvm.internal.j.d(lightStateGroup, "lightStateGroup");
            List<KasaLightState> b2 = lightStateGroup.b();
            kotlin.jvm.internal.j.d(b2, "lightStateGroup.lightStates");
            return b2;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            KasaLightState ls = KasaLightState.builder().q(40).s(100).n(100).r(1).o();
            kotlin.jvm.internal.j.d(ls, "ls");
            arrayList.add(ls);
        }
        return arrayList;
    }

    private final com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e B1() {
        return (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e) this.N3.getValue();
    }

    private final boolean C1() {
        return this.H3 == 1;
    }

    private final ColorPaintingMakeViewModel D1() {
        return (ColorPaintingMakeViewModel) this.L3.getValue();
    }

    private final void E1() {
        startActivityForResult(EditEffectNameActivity.p0.a(this, D1().m()), 1);
    }

    private final void F1() {
        if (C1()) {
            String str = this.M3;
            if (str != null) {
                q.f1(D1().o(), D1().k(str), c.f7570c).F(new d()).l0(io.reactivex.d0.b.a.a()).E(new e()).C(new f()).F0();
                return;
            }
            return;
        }
        D1().o().F(new g()).l0(io.reactivex.d0.b.a.a()).E(new h()).C(new i()).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(int i2) {
        b.d.w.c.a.n("LightStrip", "loadEffectForCreation stripLen: " + i2);
        List w1 = w1(this, i2, null, 2, null);
        this.J3.clear();
        this.J3.addAll(w1);
        ColorPaintingMakeViewModel D1 = D1();
        D1.u(getString(R.string.light_strip_color_painting) + ' ' + D1().t());
        P1(p0);
        N1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(int i2, AbstractLightingEffect abstractLightingEffect) {
        String str;
        b.d.w.c.a.n("LightStrip", "loadEffectForEdit stripLen: " + i2);
        List<ColorPaintingSegment> u1 = u1(i2, com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.y(abstractLightingEffect));
        int z1 = z1(u1, this.K3);
        LightingEffectMeta meta = abstractLightingEffect.getMeta();
        if (meta == null || (str = meta.getAlias()) == null) {
            str = "";
        }
        this.J3.clear();
        this.J3.addAll(u1);
        D1().u(str);
        P1(p0);
        f1().f6527c.e(z1);
        N1(i2);
    }

    private final void I1() {
        if (C1()) {
            L1();
        } else {
            s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(int i2) {
        if (i2 == 100) {
            com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
        } else if (i2 == 200) {
            com.tplink.iot.Utils.extension.e.a();
            finish();
        } else if (i2 == 300) {
            com.tplink.iot.Utils.extension.e.e(this, null, 1, null);
        } else if (i2 == 400) {
            com.tplink.iot.Utils.extension.e.j(this, R.string.same_name_home_exist, null, 2, null);
        } else if (i2 == 500) {
            com.tplink.iot.Utils.extension.e.k(this, getString(R.string.smart_action_add_limit_tip, new Object[]{16}), null, 2, null);
        }
    }

    private final void K1() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("ColorPickerFragment");
        if (!(findFragmentByTag instanceof ColorPickerDialogFragment)) {
            findFragmentByTag = null;
        }
        ColorPickerDialogFragment colorPickerDialogFragment = (ColorPickerDialogFragment) findFragmentByTag;
        if (colorPickerDialogFragment == null) {
            colorPickerDialogFragment = ColorPickerDialogFragment.p1.a(D1().r());
            colorPickerDialogFragment.i1(this);
        }
        colorPickerDialogFragment.show(getSupportFragmentManager(), "ColorPickerFragment");
    }

    private final void L1() {
        String str = this.M3;
        if (str != null) {
            for (ColorPaintingSegment colorPaintingSegment : this.J3) {
                KasaLightState e2 = colorPaintingSegment.e();
                BrightnessSeekBar brightnessSeekBar = f1().f6527c;
                kotlin.jvm.internal.j.d(brightnessSeekBar, "mBinding.brightnessSeekBar");
                e2.setBrightness(Integer.valueOf(brightnessSeekBar.getProgress()));
            }
            CustomizedEffect w = D1().w(str);
            if (w != null) {
                D1().x(com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.i(D1().m(), w, this.J3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(int i2, int i3) {
        int size = this.J3.size();
        if (i2 >= 0 && size > i2) {
            ColorPaintingSegment b2 = ColorPaintingSegment.b(this.J3.get(i2), null, 0, false, 7, null);
            KasaLightState o = KasaLightState.builder().o();
            o.merge(this.K3);
            if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.b.a(b2.e(), o)) {
                this.J3.get(i2).e().merge(o);
            }
        }
    }

    private final void N1(int i2) {
        int l2;
        List<ColorPaintingSegment> list = this.J3;
        l2 = o.l(list, 10);
        ArrayList arrayList = new ArrayList(l2);
        for (ColorPaintingSegment colorPaintingSegment : list) {
            KasaLightState e2 = colorPaintingSegment.e();
            Integer hue = e2.getHue();
            int intValue = hue != null ? hue.intValue() : 40;
            Integer saturation = e2.getSaturation();
            arrayList.add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(intValue, saturation != null ? saturation.intValue() : 100, 100).f()));
        }
        if (i2 <= 10) {
            f1().q.d(i2);
        }
        f1().q.i(arrayList);
    }

    private final void O1(String str) {
        D1().u(str);
    }

    private final void P1(int i2) {
        D1().v(i2);
        f1().q.setPaintingColor(i2);
    }

    private final void s1() {
        for (ColorPaintingSegment colorPaintingSegment : this.J3) {
            KasaLightState e2 = colorPaintingSegment.e();
            BrightnessSeekBar brightnessSeekBar = f1().f6527c;
            kotlin.jvm.internal.j.d(brightnessSeekBar, "mBinding.brightnessSeekBar");
            e2.setBrightness(Integer.valueOf(brightnessSeekBar.getProgress()));
        }
        D1().g(com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.d(D1().m(), this.J3));
    }

    private final List<ColorPaintingSegment> t1(int i2, int i3, List<? extends KasaLightState> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        while (i2 < i3) {
            KasaLightState kasaLightState = (KasaLightState) list.get(i2);
            kasaLightState.setStartIndex(Integer.valueOf(i2));
            kasaLightState.setEndIndex(Integer.valueOf(i2));
            arrayList.add(new ColorPaintingSegment(kasaLightState, i2, z));
            i2++;
        }
        return arrayList;
    }

    private final List<ColorPaintingSegment> u1(int i2, LightStripLightingEffect lightStripLightingEffect) {
        List<Segment> segments;
        int size = (lightStripLightingEffect == null || (segments = lightStripLightingEffect.getSegments()) == null) ? 0 : segments.size();
        List<KasaLightState> A1 = A1(Math.max(i2, size), lightStripLightingEffect);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(v1(this, 0, i2, A1, false, 8, null));
        if (i2 < size) {
            arrayList.addAll(t1(i2, size, A1, false));
        }
        return arrayList;
    }

    static /* synthetic */ List v1(ColorPaintingMakeActivity colorPaintingMakeActivity, int i2, int i3, List list, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        return colorPaintingMakeActivity.t1(i2, i3, list, z);
    }

    static /* synthetic */ List w1(ColorPaintingMakeActivity colorPaintingMakeActivity, int i2, LightStripLightingEffect lightStripLightingEffect, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            lightStripLightingEffect = null;
        }
        return colorPaintingMakeActivity.u1(i2, lightStripLightingEffect);
    }

    private final void x1() {
        String str = this.M3;
        if (str != null) {
            D1().h(str);
        }
    }

    private final LightStripLightingEffect y1(int i2, LightStripLightingEffect lightStripLightingEffect) {
        return com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.y(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.h(lightStripLightingEffect, i2, ExpansionStrategy.REPEAT));
    }

    private final int z1(List<ColorPaintingSegment> list, KasaLightState kasaLightState) {
        Integer num;
        Object obj;
        KasaLightState e2;
        Iterator<T> it = list.iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((ColorPaintingSegment) obj).f()) {
                break;
            }
        }
        ColorPaintingSegment colorPaintingSegment = (ColorPaintingSegment) obj;
        if (!(colorPaintingSegment == null || (e2 = colorPaintingSegment.e()) == null)) {
            num = e2.getBrightness();
        }
        if (num != null) {
            return num.intValue();
        }
        Integer brightness = kasaLightState.getBrightness();
        kotlin.jvm.internal.j.d(brightness, "paintToolValue.brightness");
        return brightness.intValue();
    }

    @Override // com.tplink.iot.devices.lightstrip.view.effects.ColorPickerDialogFragment.b
    public void Q(@ColorInt int i2, int i3, int i4) {
        P1(i2);
        this.K3.merge(KasaLightState.builder().q(Integer.valueOf(i3)).s(Integer.valueOf(i4)).o());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_color_painting_make;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void h1() {
        super.h1();
        Intent intent = getIntent();
        int i2 = 0;
        if (intent != null) {
            i2 = intent.getIntExtra("ModeExtra", 0);
        }
        this.H3 = i2;
        Intent intent2 = getIntent();
        this.M3 = intent2 != null ? intent2.getStringExtra("EffectIdExtra") : null;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        if (C1()) {
            b1(R.string.light_strip_edit_effect);
        } else {
            b1(R.string.light_strip_create_new_effect);
        }
        Button button = f1().f6529f;
        kotlin.jvm.internal.j.d(button, "mBinding.btnSave");
        int i2 = 0;
        button.setVisibility(C1() ^ true ? 0 : 8);
        Button button2 = f1().f6528d;
        kotlin.jvm.internal.j.d(button2, "mBinding.btnDelete");
        if (!C1()) {
            i2 = 8;
        }
        button2.setVisibility(i2);
        f1().q.setPaintingColor(D1().r());
        f1().q.setOnColorUpdateListener(new b());
        f1().f6527c.e(100);
        F1();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        f1().h(this);
        f1().i(D1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        D1().j().observe(this, new l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1 && intent != null && (stringExtra = intent.getStringExtra("EffectName")) != null) {
            O1(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.item_effect_name) {
            E1();
        } else if (valueOf != null && valueOf.intValue() == R.id.cv_color_chip) {
            K1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_save) {
            I1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_delete) {
            x1();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!C1()) {
            return super.onCreateOptionsMenu(menu);
        }
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.I3 = menu != null ? menu.findItem(R.id.common_save) : null;
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.j.e(item, "item");
        if (item.getItemId() == R.id.common_save) {
            I1();
            return true;
        } else if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        } else {
            finish();
            return true;
        }
    }
}
