package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.LayoutLightingEffectPresetBinding;
import com.tplink.iot.devices.lightstrip.adapter.LightingEffectPresetAdapter;
import com.tplink.iot.g.b.a.a;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: LightingEffectPresetLayout.kt */
/* loaded from: classes2.dex */
public final class LightingEffectPresetLayout extends FrameLayout implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.e.a> {

    /* renamed from: c  reason: collision with root package name */
    private final LayoutLightingEffectPresetBinding f7810c;

    /* renamed from: d  reason: collision with root package name */
    private LightingEffectPresetAdapter f7811d;

    /* renamed from: f  reason: collision with root package name */
    private b f7812f;
    private boolean q;
    private boolean x;

    /* compiled from: LightingEffectPresetLayout.kt */
    /* loaded from: classes2.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AutoLightFeaturePointView autoLightFeaturePointView = LightingEffectPresetLayout.this.f7810c.f7265c;
            j.d(autoLightFeaturePointView, "mBinding.autoView");
            if (autoLightFeaturePointView.isSelected()) {
                b bVar = LightingEffectPresetLayout.this.f7812f;
                if (bVar != null) {
                    bVar.V();
                    return;
                }
                return;
            }
            b bVar2 = LightingEffectPresetLayout.this.f7812f;
            if (bVar2 != null) {
                bVar2.q();
            }
        }
    }

    /* compiled from: LightingEffectPresetLayout.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void V();

        void l0(com.tplink.iot.g.b.b.e.a aVar, int i);

        void q();
    }

    public LightingEffectPresetLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public LightingEffectPresetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LightingEffectPresetLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void f() {
        AutoLightFeaturePointView autoLightFeaturePointView = this.f7810c.f7265c;
        j.d(autoLightFeaturePointView, "mBinding.autoView");
        autoLightFeaturePointView.setSelected(false);
    }

    private final void m() {
        AutoLightFeaturePointView autoLightFeaturePointView = this.f7810c.f7265c;
        j.d(autoLightFeaturePointView, "mBinding.autoView");
        autoLightFeaturePointView.setSelected(true);
    }

    private final void n(List<? extends com.tplink.iot.g.b.b.e.a> list) {
        RelativeLayout relativeLayout = this.f7810c.f7266d;
        j.d(relativeLayout, "mBinding.rlContent");
        relativeLayout.setVisibility(list.isEmpty() ^ true ? 0 : 8);
        if (!list.isEmpty()) {
            LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
            if (lightingEffectPresetAdapter == null) {
                Context context = getContext();
                j.d(context, "context");
                LightingEffectPresetAdapter lightingEffectPresetAdapter2 = new LightingEffectPresetAdapter(context, list);
                lightingEffectPresetAdapter2.S(this);
                lightingEffectPresetAdapter2.Y(this.q);
                p pVar = p.a;
                this.f7811d = lightingEffectPresetAdapter2;
                RecyclerView recyclerView = this.f7810c.f7267f;
                recyclerView.setAdapter(lightingEffectPresetAdapter2);
                i.g(recyclerView);
            } else if (lightingEffectPresetAdapter != null) {
                lightingEffectPresetAdapter.T(list);
            }
        }
    }

    @Override // com.tplink.iot.g.b.a.a
    public void b() {
        a.C0210a.a(this);
    }

    public final void e(int i) {
        com.tplink.iot.g.b.b.e.a o;
        b bVar;
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null && (o = lightingEffectPresetAdapter.o(i)) != null && (bVar = this.f7812f) != null) {
            bVar.l0(o, i);
        }
    }

    public final void g() {
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            lightingEffectPresetAdapter.C();
        }
        f();
    }

    public final int getSelectedPresetEffectPos() {
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            return lightingEffectPresetAdapter.M();
        }
        return -1;
    }

    public final com.tplink.iot.g.b.b.e.a h(int i) {
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            return lightingEffectPresetAdapter.o(i);
        }
        return null;
    }

    /* renamed from: i */
    public void a(com.tplink.iot.g.b.b.e.a data, int i) {
        j.e(data, "data");
        b bVar = this.f7812f;
        if (bVar != null) {
            bVar.l0(data, i);
        }
    }

    public final void j() {
        m();
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            lightingEffectPresetAdapter.C();
        }
    }

    public final void k(int i) {
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            lightingEffectPresetAdapter.Q(i);
        }
        f();
    }

    public final void l(String str) {
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            lightingEffectPresetAdapter.R(str);
        }
        f();
    }

    public final void o(List<? extends com.tplink.iot.g.b.b.e.a> data) {
        j.e(data, "data");
        n(data);
    }

    public final void setAutoLightViewVisible(boolean z) {
        this.x = z;
        AutoLightFeaturePointView autoLightFeaturePointView = this.f7810c.f7265c;
        j.d(autoLightFeaturePointView, "mBinding.autoView");
        autoLightFeaturePointView.setVisibility(z ? 0 : 8);
    }

    public final void setPresetCallback(b callback) {
        j.e(callback, "callback");
        this.f7812f = callback;
    }

    public final void setShowItemCenterEditIcon(boolean z) {
        this.q = z;
        LightingEffectPresetAdapter lightingEffectPresetAdapter = this.f7811d;
        if (lightingEffectPresetAdapter != null) {
            lightingEffectPresetAdapter.Y(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightingEffectPresetLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_lighting_effect_preset, this, true);
        j.d(inflate, "DataBindingUtil.inflate(…ffect_preset, this, true)");
        LayoutLightingEffectPresetBinding layoutLightingEffectPresetBinding = (LayoutLightingEffectPresetBinding) inflate;
        this.f7810c = layoutLightingEffectPresetBinding;
        this.q = true;
        layoutLightingEffectPresetBinding.f7265c.setOnClickListener(new a());
        RecyclerView recyclerView = layoutLightingEffectPresetBinding.f7267f;
        j.d(recyclerView, "mBinding.rvPresets");
        recyclerView.setNestedScrollingEnabled(false);
    }
}
