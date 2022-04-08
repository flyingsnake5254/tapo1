package com.tplink.iot.devices.lightstrip.view.effects;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentLightStripLightEffectsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.lightstrip.adapter.ColorPaintingAdapter;
import com.tplink.iot.devices.lightstrip.adapter.CustomizedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.NormalColorsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.view.effects.ColorPaintingMakeActivity;
import com.tplink.iot.devices.lightstrip.view.effects.CustomizedEffectsMakeActivity;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.LightStripLightingEffectViewModel;
import com.tplink.iot.g.b.a.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: LightStripLightingEffectFragment.kt */
/* loaded from: classes2.dex */
public final class LightStripLightingEffectFragment extends IoTMVVMBaseFragment<FragmentLightStripLightEffectsBinding> {
    public static final a p1 = new a(null);
    private ColorPaintingAdapter H3;
    private CustomizedEffectsAdapter I3;
    private PredefinedEffectsAdapter J3;
    private int L3;
    private boolean M3;
    private com.tplink.iot.g.b.a.b N3;
    private com.tplink.iot.widget.colorbulb.c.b O3;
    private com.tplink.iot.g.b.b.e.a P3;
    private final kotlin.f Q3;
    private LightStateBean R3;
    private boolean S3;
    private boolean T3;
    private boolean U3;
    private HashMap V3;
    private NormalColorsAdapter p3;
    private final List<Runnable> p2 = new ArrayList();
    private List<com.tplink.iot.g.b.b.d> K3 = new ArrayList();

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final LightStripLightingEffectFragment a(String deviceIdMD5, int i) {
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            LightStripLightingEffectFragment lightStripLightingEffectFragment = new LightStripLightingEffectFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("ArgPage", i);
            bundle.putString("device_id_md5", deviceIdMD5);
            p pVar = p.a;
            lightStripLightingEffectFragment.setArguments(bundle);
            return lightStripLightingEffectFragment;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LightStripLightingEffectFragment.f1(LightStripLightingEffectFragment.this, false, false, false, false, 15, null);
            LightStripLightingEffectFragment.this.P3 = null;
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<LightStripLightingEffectViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripLightingEffectViewModel invoke() {
            LightStripLightingEffectFragment lightStripLightingEffectFragment = LightStripLightingEffectFragment.this;
            ViewModel viewModel = new ViewModelProvider(lightStripLightingEffectFragment, new IoTViewModelFactory(lightStripLightingEffectFragment, lightStripLightingEffectFragment.K0())).get(LightStripLightingEffectViewModel.class);
            kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (LightStripLightingEffectViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStateBean f7627d;

        public d(LightStateBean lightStateBean) {
            this.f7627d = lightStateBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LightStripLightingEffectFragment.this.r1(this.f7627d);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ColorPaintingAdapter f7628c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStripLightingEffectFragment f7629d;

        e(ColorPaintingAdapter colorPaintingAdapter, LightStripLightingEffectFragment lightStripLightingEffectFragment) {
            this.f7628c = colorPaintingAdapter;
            this.f7629d = lightStripLightingEffectFragment;
        }

        @Override // com.tplink.iot.g.b.a.a
        public void b() {
            this.f7629d.m1(null, true);
        }

        /* renamed from: c */
        public void a(com.tplink.iot.g.b.b.a data, int i) {
            kotlin.jvm.internal.j.e(data, "data");
            if (this.f7629d.M3) {
                this.f7629d.m1(data, false);
                return;
            }
            LightStripLightingEffectFragment.f1(this.f7629d, false, false, false, false, 13, null);
            this.f7629d.h1(data);
            this.f7628c.Q(i);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.b> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CustomizedEffectsAdapter f7630c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStripLightingEffectFragment f7631d;

        f(CustomizedEffectsAdapter customizedEffectsAdapter, LightStripLightingEffectFragment lightStripLightingEffectFragment) {
            this.f7630c = customizedEffectsAdapter;
            this.f7631d = lightStripLightingEffectFragment;
        }

        @Override // com.tplink.iot.g.b.a.a
        public void b() {
            this.f7631d.n1(null, true);
        }

        /* renamed from: c */
        public void a(com.tplink.iot.g.b.b.b data, int i) {
            kotlin.jvm.internal.j.e(data, "data");
            if (this.f7631d.M3) {
                this.f7631d.n1(data, false);
                return;
            }
            LightStripLightingEffectFragment.f1(this.f7631d, false, false, false, false, 11, null);
            this.f7631d.h1(data);
            this.f7630c.Q(i);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.d> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PredefinedEffectsAdapter f7632c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStripLightingEffectFragment f7633d;

        g(PredefinedEffectsAdapter predefinedEffectsAdapter, LightStripLightingEffectFragment lightStripLightingEffectFragment) {
            this.f7632c = predefinedEffectsAdapter;
            this.f7633d = lightStripLightingEffectFragment;
        }

        @Override // com.tplink.iot.g.b.a.a
        public void b() {
            a.C0210a.a(this);
        }

        /* renamed from: c */
        public void a(com.tplink.iot.g.b.b.d data, int i) {
            kotlin.jvm.internal.j.e(data, "data");
            LightStripLightingEffectFragment.f1(this.f7633d, false, false, false, false, 7, null);
            this.f7633d.h1(data);
            this.f7632c.Q(i);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.c> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NormalColorsAdapter f7634c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStripLightingEffectFragment f7635d;

        h(NormalColorsAdapter normalColorsAdapter, LightStripLightingEffectFragment lightStripLightingEffectFragment) {
            this.f7634c = normalColorsAdapter;
            this.f7635d = lightStripLightingEffectFragment;
        }

        @Override // com.tplink.iot.g.b.a.a
        public void b() {
            a.C0210a.a(this);
        }

        /* renamed from: c */
        public void a(com.tplink.iot.g.b.b.c data, int i) {
            kotlin.jvm.internal.j.e(data, "data");
            LightStripLightingEffectFragment.f1(this.f7635d, false, false, false, false, 14, null);
            this.f7635d.h1(data);
            this.f7634c.Q(i);
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    static final class i<T> implements Observer<List<? extends CustomizedEffect>> {
        i() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends CustomizedEffect> list) {
            if (list != null) {
                LightStripLightingEffectFragment.this.A1(list);
            }
        }
    }

    /* compiled from: LightStripLightingEffectFragment.kt */
    /* loaded from: classes2.dex */
    static final class j<T> implements Observer<List<? extends PredefinedEffect>> {
        j() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends PredefinedEffect> list) {
            if (list != null) {
                LightStripLightingEffectFragment.this.B1(list);
            }
        }
    }

    public LightStripLightingEffectFragment() {
        kotlin.f b2;
        b2 = kotlin.i.b(new c());
        this.Q3 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(List<? extends CustomizedEffect> list) {
        List U;
        List U2;
        List U3;
        this.S3 = true;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean k = l1().k();
        for (CustomizedEffect customizedEffect : list) {
            List<Integer> o = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.o(customizedEffect);
            if (customizedEffect.getType() != Type.PULSE || k) {
                if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.q(customizedEffect)) {
                    Pair<List<Integer>, List<Integer>> g2 = com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.g(o);
                    String p12 = p1(customizedEffect);
                    U = v.U(g2.component1());
                    U2 = v.U(g2.component2());
                    arrayList.add(new com.tplink.iot.g.b.b.a(p12, U, U2, customizedEffect));
                } else {
                    String p13 = p1(customizedEffect);
                    U3 = v.U(o);
                    arrayList2.add(new com.tplink.iot.g.b.b.b(p13, U3, customizedEffect));
                }
            }
        }
        ColorPaintingAdapter colorPaintingAdapter = this.H3;
        if (colorPaintingAdapter != null) {
            colorPaintingAdapter.T(arrayList);
        }
        CustomizedEffectsAdapter customizedEffectsAdapter = this.I3;
        if (customizedEffectsAdapter != null) {
            customizedEffectsAdapter.T(arrayList2);
        }
        d1();
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(List<? extends PredefinedEffect> list) {
        String alias;
        this.T3 = true;
        ArrayList arrayList = new ArrayList();
        boolean k = l1().k();
        for (PredefinedEffect predefinedEffect : list) {
            LightingEffectMeta meta = predefinedEffect.getMeta();
            if (!(meta == null || (alias = meta.getAlias()) == null || (predefinedEffect.getType() == Type.PULSE && !k))) {
                com.tplink.iot.g.b.b.d b2 = PredefinedEffectsAdapter.h.b(alias);
                if (b2 != null) {
                    b2.l(predefinedEffect);
                    arrayList.add(b2);
                }
            }
        }
        arrayList.addAll(0, this.K3);
        PredefinedEffectsAdapter predefinedEffectsAdapter = this.J3;
        if (predefinedEffectsAdapter != null) {
            predefinedEffectsAdapter.T(arrayList);
        }
        d1();
        q1();
    }

    private final void d1() {
        com.tplink.iot.g.b.b.d L;
        com.tplink.iot.g.b.b.b L2;
        com.tplink.iot.g.b.b.a L3;
        NormalColorsAdapter normalColorsAdapter;
        com.tplink.iot.g.b.b.c L4;
        if (!(!o1() || (normalColorsAdapter = this.p3) == null || (L4 = normalColorsAdapter.L()) == null)) {
            this.P3 = L4;
        }
        ColorPaintingAdapter colorPaintingAdapter = this.H3;
        if (!(colorPaintingAdapter == null || (L3 = colorPaintingAdapter.L()) == null)) {
            this.P3 = L3;
        }
        CustomizedEffectsAdapter customizedEffectsAdapter = this.I3;
        if (!(customizedEffectsAdapter == null || (L2 = customizedEffectsAdapter.L()) == null)) {
            this.P3 = L2;
        }
        PredefinedEffectsAdapter predefinedEffectsAdapter = this.J3;
        if (predefinedEffectsAdapter != null && (L = predefinedEffectsAdapter.L()) != null) {
            this.P3 = L;
        }
    }

    private final void e1(boolean z, boolean z2, boolean z3, boolean z4) {
        PredefinedEffectsAdapter predefinedEffectsAdapter;
        CustomizedEffectsAdapter customizedEffectsAdapter;
        ColorPaintingAdapter colorPaintingAdapter;
        NormalColorsAdapter normalColorsAdapter;
        if (z && (normalColorsAdapter = this.p3) != null) {
            normalColorsAdapter.C();
        }
        if (z2 && (colorPaintingAdapter = this.H3) != null) {
            colorPaintingAdapter.C();
        }
        if (z3 && (customizedEffectsAdapter = this.I3) != null) {
            customizedEffectsAdapter.C();
        }
        if (z4 && (predefinedEffectsAdapter = this.J3) != null) {
            predefinedEffectsAdapter.C();
        }
    }

    static /* synthetic */ void f1(LightStripLightingEffectFragment lightStripLightingEffectFragment, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            z3 = true;
        }
        if ((i2 & 8) != 0) {
            z4 = true;
        }
        lightStripLightingEffectFragment.e1(z, z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(com.tplink.iot.g.b.b.e.a aVar) {
        com.tplink.iot.g.b.a.b bVar;
        com.tplink.iot.widget.colorbulb.c.b bVar2 = this.O3;
        if (bVar2 != null) {
            bVar2.S(2, true);
        }
        this.P3 = aVar;
        if (aVar instanceof com.tplink.iot.g.b.b.c) {
            com.tplink.iot.g.b.a.b bVar3 = this.N3;
            if (bVar3 != null) {
                bVar3.m0((com.tplink.iot.g.b.b.c) aVar);
            }
        } else if (aVar instanceof com.tplink.iot.g.b.b.a) {
            com.tplink.iot.g.b.a.b bVar4 = this.N3;
            if (bVar4 != null) {
                bVar4.C((com.tplink.iot.g.b.b.a) aVar);
            }
        } else if (aVar instanceof com.tplink.iot.g.b.b.b) {
            com.tplink.iot.g.b.a.b bVar5 = this.N3;
            if (bVar5 != null) {
                bVar5.t0((com.tplink.iot.g.b.b.b) aVar);
            }
        } else if ((aVar instanceof com.tplink.iot.g.b.b.d) && (bVar = this.N3) != null) {
            bVar.p0((com.tplink.iot.g.b.b.d) aVar);
        }
    }

    private final void i1() {
        b.d.w.c.a.n("LightingEffectF", "executeViewRunQueue");
        if (!this.p2.isEmpty()) {
            for (Runnable runnable : this.p2) {
                runnable.run();
            }
        }
        this.p2.clear();
    }

    private final LightStripLightingEffectViewModel l1() {
        return (LightStripLightingEffectViewModel) this.Q3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(com.tplink.iot.g.b.b.a aVar, boolean z) {
        int i2 = !z ? 1 : 0;
        ColorPaintingMakeActivity.a aVar2 = ColorPaintingMakeActivity.p3;
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        startActivity(aVar2.a(requireContext, K0(), i2, aVar != null ? aVar.e() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(com.tplink.iot.g.b.b.b bVar, boolean z) {
        int i2 = !z ? 1 : 0;
        CustomizedEffectsMakeActivity.a aVar = CustomizedEffectsMakeActivity.p0;
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        startActivity(aVar.a(requireContext, K0(), i2, bVar != null ? bVar.e() : null));
    }

    private final boolean o1() {
        return this.L3 == 0;
    }

    private final String p1(CustomizedEffect customizedEffect) {
        String alias;
        LightingEffectMeta meta = customizedEffect.getMeta();
        return (meta == null || (alias = meta.getAlias()) == null) ? "" : alias;
    }

    private final void q1() {
        if (this.S3 && this.T3) {
            r1(this.R3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(LightStateBean lightStateBean) {
        PredefinedEffectsAdapter predefinedEffectsAdapter;
        if (lightStateBean != null) {
            LightingEffectData lightingEffectData = lightStateBean.getLightingEffectData();
            if (lightingEffectData != null) {
                String str = lightingEffectData.id;
                ColorPaintingAdapter colorPaintingAdapter = this.H3;
                if (colorPaintingAdapter != null) {
                    colorPaintingAdapter.R(str);
                }
                CustomizedEffectsAdapter customizedEffectsAdapter = this.I3;
                if (customizedEffectsAdapter != null) {
                    customizedEffectsAdapter.R(str);
                }
                PredefinedEffectsAdapter predefinedEffectsAdapter2 = this.J3;
                if (predefinedEffectsAdapter2 != null) {
                    predefinedEffectsAdapter2.R(str);
                }
            } else if (!(!this.U3 || lightStateBean.getColorTemp() == 0 || (predefinedEffectsAdapter = this.J3) == null)) {
                predefinedEffectsAdapter.R("PredefinedEffect_Daylight");
            }
            d1();
        }
    }

    private final void w1() {
        List d2;
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        d2 = n.d();
        ColorPaintingAdapter colorPaintingAdapter = new ColorPaintingAdapter(requireContext, d2, 0, 4, null);
        colorPaintingAdapter.S(new e(colorPaintingAdapter, this));
        p pVar = p.a;
        this.H3 = colorPaintingAdapter;
        RecyclerView recyclerView = J0().f7020c;
        recyclerView.setAdapter(this.H3);
        com.tplink.iot.Utils.extension.i.g(recyclerView);
    }

    private final void x1() {
        List d2;
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        d2 = n.d();
        CustomizedEffectsAdapter customizedEffectsAdapter = new CustomizedEffectsAdapter(requireContext, d2, 0, 4, null);
        customizedEffectsAdapter.S(new f(customizedEffectsAdapter, this));
        p pVar = p.a;
        this.I3 = customizedEffectsAdapter;
        RecyclerView recyclerView = J0().f7022f;
        recyclerView.setAdapter(this.I3);
        com.tplink.iot.Utils.extension.i.g(recyclerView);
    }

    private final void y1() {
        int[] n = com.tplink.iot.g.b.c.c.n(l1().f());
        boolean l = com.tplink.iot.g.b.c.c.l(l1().f(), l1().j());
        this.U3 = l;
        if (l) {
            this.K3.add(PredefinedEffectsAdapter.h.a(n[0]));
        }
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        PredefinedEffectsAdapter predefinedEffectsAdapter = new PredefinedEffectsAdapter(requireContext, this.K3, 0, 4, null);
        predefinedEffectsAdapter.S(new g(predefinedEffectsAdapter, this));
        p pVar = p.a;
        this.J3 = predefinedEffectsAdapter;
        RecyclerView recyclerView = J0().q;
        recyclerView.setAdapter(this.J3);
        com.tplink.iot.Utils.extension.i.g(recyclerView);
    }

    private final void z1() {
        Pair<LightStateBean, Integer>[] a2;
        Pair<LightStateBean, Integer>[] b2;
        ArrayList arrayList = new ArrayList();
        for (Pair<LightStateBean, Integer> pair : NormalColorsAdapter.k.a()) {
            arrayList.add(new com.tplink.iot.g.b.b.c(pair.getSecond().intValue(), pair.getFirst()));
        }
        if (l1().j()) {
            if (com.tplink.iot.g.b.c.c.k(l1().f(), l1().j())) {
                for (Pair<LightStateBean, Integer> pair2 : NormalColorsAdapter.k.b()) {
                    arrayList.add(new com.tplink.iot.g.b.b.c(pair2.getSecond().intValue(), pair2.getFirst()));
                }
            } else {
                Pair<LightStateBean, Integer> c2 = NormalColorsAdapter.k.c();
                arrayList.add(new com.tplink.iot.g.b.b.c(c2.getSecond().intValue(), c2.getFirst()));
            }
        }
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.d(requireContext, "requireContext()");
        NormalColorsAdapter normalColorsAdapter = new NormalColorsAdapter(requireContext, arrayList, 0, 4, null);
        normalColorsAdapter.S(new h(normalColorsAdapter, this));
        p pVar = p.a;
        this.p3 = normalColorsAdapter;
        RecyclerView recyclerView = J0().f7021d;
        recyclerView.setAdapter(this.p3);
        com.tplink.iot.Utils.extension.i.g(recyclerView);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.V3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    @LayoutRes
    public int I0() {
        return R.layout.fragment_light_strip_light_effects;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        super.N0();
        TextView textView = J0().y;
        kotlin.jvm.internal.j.d(textView, "mBinding.tvColors");
        int i2 = 0;
        textView.setVisibility(o1() ? 0 : 8);
        RecyclerView recyclerView = J0().f7021d;
        kotlin.jvm.internal.j.d(recyclerView, "mBinding.rvColorPresets");
        recyclerView.setVisibility(o1() ? 0 : 8);
        TextView textView2 = J0().x;
        kotlin.jvm.internal.j.d(textView2, "mBinding.tvColorPainting");
        textView2.setVisibility(l1().l() ? 0 : 8);
        RecyclerView recyclerView2 = J0().f7020c;
        kotlin.jvm.internal.j.d(recyclerView2, "mBinding.rvColorPainting");
        if (!l1().l()) {
            i2 = 8;
        }
        recyclerView2.setVisibility(i2);
        if (o1()) {
            z1();
        }
        if (l1().l()) {
            w1();
        }
        x1();
        y1();
        i1();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void O0() {
        l1().m();
        l1().n();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void R0() {
        l1().g().observe(getViewLifecycleOwner(), new i());
        l1().i().observe(getViewLifecycleOwner(), new j());
    }

    public final void g1() {
        if (L0()) {
            b.d.w.c.a.n("LightingEffectF", "executeOrPostViewRunnable directly");
            f1(this, false, false, false, false, 15, null);
            this.P3 = null;
            return;
        }
        this.p2.add(new b());
    }

    public final boolean j1() {
        return this.M3;
    }

    public final LightStateBean k1() {
        com.tplink.iot.g.b.b.e.a aVar = this.P3;
        if (aVar != null) {
            return com.tplink.iot.g.b.b.e.b.b(aVar, l1().l());
        }
        return null;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        int i2 = 0;
        if (arguments != null) {
            i2 = arguments.getInt("ArgPage", 0);
        }
        this.L3 = i2;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    public final void s1(boolean z) {
        if (this.M3 != z) {
            this.M3 = z;
            NormalColorsAdapter normalColorsAdapter = this.p3;
            if (normalColorsAdapter != null) {
                normalColorsAdapter.a0(!z);
            }
            ColorPaintingAdapter colorPaintingAdapter = this.H3;
            if (colorPaintingAdapter != null) {
                colorPaintingAdapter.X(this.M3);
            }
            CustomizedEffectsAdapter customizedEffectsAdapter = this.I3;
            if (customizedEffectsAdapter != null) {
                customizedEffectsAdapter.X(this.M3);
            }
            PredefinedEffectsAdapter predefinedEffectsAdapter = this.J3;
            if (predefinedEffectsAdapter != null) {
                predefinedEffectsAdapter.X(!this.M3);
            }
        }
    }

    public final void t1(LightStateBean lightStateBean) {
        this.R3 = lightStateBean;
        if (L0()) {
            b.d.w.c.a.n("LightingEffectF", "executeOrPostViewRunnable directly");
            r1(lightStateBean);
            return;
        }
        this.p2.add(new d(lightStateBean));
    }

    public final void u1(com.tplink.iot.widget.colorbulb.c.b listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.O3 = listener;
    }

    public final void v1(com.tplink.iot.g.b.a.b listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.N3 = listener;
    }
}
