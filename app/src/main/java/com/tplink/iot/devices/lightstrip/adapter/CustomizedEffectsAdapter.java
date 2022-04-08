package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.DashCircleAddView;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: CustomizedEffectsAdapter.kt */
/* loaded from: classes2.dex */
public final class CustomizedEffectsAdapter extends LightStripEffectsBaseAdapter<com.tplink.iot.g.b.b.b> {
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomizedEffectsAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.g.b.b.b f7485d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7486f;

        a(com.tplink.iot.g.b.b.b bVar, int i) {
            this.f7485d = bVar;
            this.f7486f = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.b> E = CustomizedEffectsAdapter.this.E();
            if (E != null) {
                E.a(this.f7485d, this.f7486f);
            }
        }
    }

    /* compiled from: CustomizedEffectsAdapter.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.b> E = CustomizedEffectsAdapter.this.E();
            if (E != null) {
                E.b();
            }
        }
    }

    public /* synthetic */ CustomizedEffectsAdapter(Context context, List list, int i, int i2, f fVar) {
        this(context, list, (i2 & 4) != 0 ? -1 : i);
    }

    /* renamed from: U */
    public void m(GeneralAdapter.GeneralVH holder, com.tplink.iot.g.b.b.b data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        DashCircleAddView F = F(holder);
        if (F != null) {
            ViewKt.setVisible(F, false);
        }
        ColorEffectPlateView G = G(holder);
        if (G != null) {
            G.setVisibility(0);
            G.i(this.h, false);
            G.k(data.c());
            if (data.a() != G.isSelected()) {
                G.j(data.a(), O());
            }
            G.setOnClickListener(new a(data, i));
        }
        TextView N = N(holder);
        if (N != null) {
            N.setText(data.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V */
    public void A(com.tplink.iot.g.b.b.b data, boolean z) {
        j.e(data, "data");
        data.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: W */
    public String K(com.tplink.iot.g.b.b.b data) {
        j.e(data, "data");
        return data.e();
    }

    public final void X(boolean z) {
        if (this.h != z) {
            D();
            this.h = z;
            notifyDataSetChanged();
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s().size() >= 16 ? s().size() : s().size() + 1;
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public void n(GeneralAdapter.GeneralVH holder, int i) {
        j.e(holder, "holder");
        ColorEffectPlateView G = G(holder);
        if (G != null) {
            ViewKt.setVisible(G, false);
        }
        DashCircleAddView F = F(holder);
        if (F != null) {
            F.setVisibility(0);
            F.setOnClickListener(new b());
        }
        TextView N = N(holder);
        if (N != null) {
            N.setText(R.string.create_new);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CustomizedEffectsAdapter(android.content.Context r2, java.util.List<com.tplink.iot.g.b.b.b> r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "items"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.adapter.CustomizedEffectsAdapter.<init>(android.content.Context, java.util.List, int):void");
    }
}
