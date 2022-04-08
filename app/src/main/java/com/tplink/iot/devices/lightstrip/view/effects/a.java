package com.tplink.iot.devices.lightstrip.view.effects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.widget.DashCircleAddView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.jvm.internal.j;
import kotlin.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LightingEffectDebugActivity.kt */
/* loaded from: classes2.dex */
public final class a extends GeneralAdapter<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> {

    /* renamed from: d  reason: collision with root package name */
    private kotlin.jvm.b.a<p> f7686d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.jvm.b.a<p> f7687e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.p<? super Integer, ? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, p> f7688f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* renamed from: com.tplink.iot.devices.lightstrip.view.effects.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC0205a implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c f7690d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7691f;

        View$OnClickListenerC0205a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar, int i) {
            this.f7690d = cVar;
            this.f7691f = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            kotlin.jvm.b.p pVar = a.this.f7688f;
            if (pVar != null) {
                p pVar2 = (p) pVar.invoke(Integer.valueOf(this.f7691f), this.f7690d);
            }
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            kotlin.jvm.b.a aVar = a.this.f7686d;
            if (aVar != null) {
                p pVar = (p) aVar.invoke();
            }
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            kotlin.jvm.b.a aVar = a.this.f7687e;
            if (aVar == null) {
                return true;
            }
            p pVar = (p) aVar.invoke();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, null, 2, null);
        j.e(context, "context");
    }

    private final DashCircleAddView F(GeneralAdapter.GeneralVH generalVH) {
        return (DashCircleAddView) generalVH.c(R.id.dash_circle_add);
    }

    private final SelectableColorPointView G(GeneralAdapter.GeneralVH generalVH) {
        return (SelectableColorPointView) generalVH.c(R.id.selectable_color_point);
    }

    private final TextView I(GeneralAdapter.GeneralVH generalVH) {
        return (TextView) generalVH.c(R.id.tv_title);
    }

    private final void J(GeneralAdapter.GeneralVH generalVH) {
        SelectableColorPointView G = G(generalVH);
        if (G != null) {
            ViewKt.setVisible(G, false);
        }
        DashCircleAddView F = F(generalVH);
        if (F != null) {
            ViewKt.setVisible(F, false);
        }
    }

    public final void D(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c hsb) {
        j.e(hsb, "hsb");
        GeneralAdapter.u(this, hsb, 0, 2, null);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: E */
    public void m(GeneralAdapter.GeneralVH holder, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        J(holder);
        SelectableColorPointView G = G(holder);
        if (G != null) {
            G.setVisibility(0);
            G.setColor(data.g());
            G.setOnClickListener(new View$OnClickListenerC0205a(data, i));
        }
        TextView I = I(holder);
        if (I != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(data.a());
            sb.append('%');
            I.setText(sb.toString());
        }
    }

    public final List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> H() {
        return s();
    }

    public final void K() {
        int f2;
        if (!s().isEmpty()) {
            f2 = n.f(s());
            l.r(s());
            notifyItemRemoved(f2);
        }
    }

    public final void L(kotlin.jvm.b.a<p> aVar, kotlin.jvm.b.a<p> aVar2, kotlin.jvm.b.p<? super Integer, ? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, p> pVar) {
        this.f7686d = aVar;
        this.f7687e = aVar2;
        this.f7688f = pVar;
    }

    public final void M(int i, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c newHSB) {
        j.e(newHSB, "newHSB");
        z(i, newHSB);
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s().size() + 1;
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public void n(GeneralAdapter.GeneralVH holder, int i) {
        j.e(holder, "holder");
        J(holder);
        DashCircleAddView F = F(holder);
        if (F != null) {
            F.getLayoutParams().height = -2;
            F.setVisibility(0);
            F.setOnClickListener(new b());
            F.setOnLongClickListener(new c());
        }
        TextView I = I(holder);
        if (I != null) {
            I.setText(R.string.common_add);
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public int p(int i) {
        return R.layout.item_light_strip_effects_holder;
    }
}
