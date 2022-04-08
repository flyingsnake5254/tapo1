package com.tplink.iot.devices.lightstrip.adapter;

import android.view.View;
import androidx.core.view.ViewKt;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.b.b;
import com.tplink.iot.g.b.b.c;
import com.tplink.iot.g.b.b.d;
import kotlin.jvm.internal.j;

/* compiled from: LightingEffectPresetAdapter.kt */
/* loaded from: classes2.dex */
public final class LightingEffectPresetAdapter extends LightStripEffectsBaseAdapter<com.tplink.iot.g.b.b.e.a> {
    private boolean h = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectPresetAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.g.b.b.e.a f7492d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7493f;

        a(com.tplink.iot.g.b.b.e.a aVar, int i) {
            this.f7492d = aVar;
            this.f7493f = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.e.a> E = LightingEffectPresetAdapter.this.E();
            if (E != null) {
                E.a(this.f7492d, this.f7493f);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LightingEffectPresetAdapter(android.content.Context r2, java.util.List<? extends com.tplink.iot.g.b.b.e.a> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "effects"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r0 = -1
            r1.<init>(r2, r3, r0)
            r2 = 1
            r1.h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.adapter.LightingEffectPresetAdapter.<init>(android.content.Context, java.util.List):void");
    }

    private final void X(GeneralAdapter.GeneralVH generalVH) {
        SelectableColorPointView H = H(generalVH);
        if (H != null) {
            ViewKt.setVisible(H, false);
        }
        ColorPaintingRingView I = I(generalVH);
        if (I != null) {
            ViewKt.setVisible(I, false);
        }
        ColorEffectPlateView G = G(generalVH);
        if (G != null) {
            ViewKt.setVisible(G, false);
        }
        CircleEffectImageView J = J(generalVH);
        if (J != null) {
            ViewKt.setVisible(J, false);
        }
    }

    /* renamed from: U */
    public void m(GeneralAdapter.GeneralVH holder, com.tplink.iot.g.b.b.e.a data, int i) {
        CircleEffectImageView J;
        j.e(holder, "holder");
        j.e(data, "data");
        X(holder);
        boolean z = true;
        if (data instanceof c) {
            SelectableColorPointView H = H(holder);
            if (H != null) {
                H.setVisibility(0);
                H.setColor(((c) data).d());
                H.j(data.a(), O());
                if (!data.a() || !this.h) {
                    z = false;
                }
                H.d(z);
            }
        } else if (data instanceof com.tplink.iot.g.b.b.a) {
            ColorPaintingRingView I = I(holder);
            if (I != null) {
                I.setVisibility(0);
                com.tplink.iot.g.b.b.a aVar = (com.tplink.iot.g.b.b.a) data;
                I.k(aVar.c(), aVar.f());
                I.j(data.a(), O());
                if (!data.a() || !this.h) {
                    z = false;
                }
                I.d(z);
            }
        } else if (data instanceof b) {
            ColorEffectPlateView G = G(holder);
            if (G != null) {
                G.setVisibility(0);
                G.k(((b) data).c());
                G.j(data.a(), O());
                if (!data.a() || !this.h) {
                    z = false;
                }
                G.d(z);
            }
        } else if ((data instanceof d) && (J = J(holder)) != null) {
            J.setVisibility(0);
            J.setImageResource(((d) data).d());
            J.j(data.a(), O());
            if (!data.a() || !this.h) {
                z = false;
            }
            J.d(z);
        }
        holder.itemView.setOnClickListener(new a(data, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V */
    public void A(com.tplink.iot.g.b.b.e.a data, boolean z) {
        j.e(data, "data");
        data.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: W */
    public String K(com.tplink.iot.g.b.b.e.a data) {
        j.e(data, "data");
        return com.tplink.iot.g.b.b.e.b.a(data);
    }

    public final void Y(boolean z) {
        this.h = z;
    }

    @Override // com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter, com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public int p(int i) {
        return R.layout.item_light_strip_detail_effects_holder;
    }
}
