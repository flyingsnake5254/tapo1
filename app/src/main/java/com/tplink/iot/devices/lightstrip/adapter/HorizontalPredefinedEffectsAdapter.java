package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.g.b.b.d;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: HorizontalPredefinedEffectsAdapter.kt */
/* loaded from: classes2.dex */
public final class HorizontalPredefinedEffectsAdapter extends LightStripEffectsBaseAdapter<d> {
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HorizontalPredefinedEffectsAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f7489d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7490f;

        a(d dVar, int i) {
            this.f7489d = dVar;
            this.f7490f = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.g.b.a.a<d> E = HorizontalPredefinedEffectsAdapter.this.E();
            if (E != null) {
                E.a(this.f7489d, this.f7490f);
            }
        }
    }

    public /* synthetic */ HorizontalPredefinedEffectsAdapter(Context context, List list, int i, int i2, f fVar) {
        this(context, list, (i2 & 4) != 0 ? -1 : i);
    }

    /* renamed from: U */
    public void m(GeneralAdapter.GeneralVH holder, d data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        CircleEffectImageView J = J(holder);
        if (J != null) {
            J.setEnabled(this.h);
            J.setImageResource(data.d());
            if (data.a() != J.isSelected()) {
                J.j(data.a(), O());
            }
            J.setOnClickListener(new a(data, i));
        }
        TextView N = N(holder);
        if (N != null) {
            N.setText(data.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V */
    public void A(d data, boolean z) {
        j.e(data, "data");
        data.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: W */
    public String K(d data) {
        j.e(data, "data");
        return data.f();
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    /* renamed from: w */
    public GeneralAdapter.GeneralVH onCreateViewHolder(ViewGroup parent, int i) {
        j.e(parent, "parent");
        View inflate = q().inflate(R.layout.item_predefined_effects_holder, parent, false);
        j.d(inflate, "layoutInflater.inflate(R…ts_holder, parent, false)");
        return new GeneralAdapter.GeneralVH(inflate);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HorizontalPredefinedEffectsAdapter(android.content.Context r2, java.util.List<com.tplink.iot.g.b.b.d> r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "items"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r1.<init>(r2, r3, r4)
            r2 = 1
            r1.h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.adapter.HorizontalPredefinedEffectsAdapter.<init>(android.content.Context, java.util.List, int):void");
    }
}
