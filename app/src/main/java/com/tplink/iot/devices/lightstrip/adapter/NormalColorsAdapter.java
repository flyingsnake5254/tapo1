package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.b.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* compiled from: NormalColorsAdapter.kt */
/* loaded from: classes2.dex */
public final class NormalColorsAdapter extends LightStripEffectsBaseAdapter<c> {
    private boolean l;
    public static final a k = new a(null);
    private static final Pair<LightStateBean, Integer>[] h = {new Pair<>(new LightStateBean(5, 80, 0, 100), Integer.valueOf((int) 4294524722L)), new Pair<>(new LightStateBean(348, 50, 0, 100), Integer.valueOf((int) 4294934425L)), new Pair<>(new LightStateBean(39, 100, 0, 100), Integer.valueOf((int) 4294944000L)), new Pair<>(new LightStateBean(53, 65, 0, 100), Integer.valueOf((int) 4294435927L)), new Pair<>(new LightStateBean(90, 68, 0, 100), Integer.valueOf((int) 4289000526L)), new Pair<>(new LightStateBean(331, 92, 0, 100), Integer.valueOf((int) 4294907269L)), new Pair<>(new LightStateBean(277, 86, 0, 100), Integer.valueOf((int) 4289406207L)), new Pair<>(new LightStateBean(238, 68, 0, 100), Integer.valueOf((int) 4283455743L)), new Pair<>(new LightStateBean(194, 50, 0, 100), Integer.valueOf((int) 4286505470L)), new Pair<>(new LightStateBean(134, 67, 0, 100), Integer.valueOf((int) 4283760508L))};
    private static final Pair<LightStateBean, Integer>[] i = {new Pair<>(new LightStateBean(0, 0, 2500, 100), Integer.valueOf((int) 4294891683L)), new Pair<>(new LightStateBean(0, 0, PathInterpolatorCompat.MAX_NUM_POINTS, 100), Integer.valueOf((int) 4294959543L)), new Pair<>(new LightStateBean(0, 0, 4000, 100), Integer.valueOf((int) 4294898396L)), new Pair<>(new LightStateBean(0, 0, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, 100), Integer.valueOf((int) 4294900981L)), new Pair<>(new LightStateBean(0, 0, 5500, 100), Integer.valueOf((int) 4294835964L))};
    private static final Pair<LightStateBean, Integer> j = new Pair<>(new LightStateBean(0, 0, 0, 100), Integer.valueOf((int) 4294967295L));

    /* compiled from: NormalColorsAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final Pair<LightStateBean, Integer>[] a() {
            return NormalColorsAdapter.h;
        }

        public final Pair<LightStateBean, Integer>[] b() {
            return NormalColorsAdapter.i;
        }

        public final Pair<LightStateBean, Integer> c() {
            return NormalColorsAdapter.j;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalColorsAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f7495d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7496f;

        b(c cVar, int i) {
            this.f7495d = cVar;
            this.f7496f = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.g.b.a.a<c> E = NormalColorsAdapter.this.E();
            if (E != null) {
                E.a(this.f7495d, this.f7496f);
            }
        }
    }

    public /* synthetic */ NormalColorsAdapter(Context context, List list, int i2, int i3, f fVar) {
        this(context, list, (i3 & 4) != 0 ? -1 : i2);
    }

    /* renamed from: X */
    public void m(GeneralAdapter.GeneralVH holder, c data, int i2) {
        j.e(holder, "holder");
        j.e(data, "data");
        SelectableColorPointView H = H(holder);
        if (H != null) {
            H.setEnabled(this.l);
            H.setColor(data.d());
            if (data.a() != H.isSelected()) {
                H.j(data.a(), O());
            }
            H.j(data.a(), true);
            H.setOnClickListener(new b(data, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y */
    public void A(c data, boolean z) {
        j.e(data, "data");
        data.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z */
    public String K(c data) {
        j.e(data, "data");
        return null;
    }

    public final void a0(boolean z) {
        if (this.l != z) {
            D();
            this.l = z;
            notifyDataSetChanged();
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    /* renamed from: w */
    public GeneralAdapter.GeneralVH onCreateViewHolder(ViewGroup parent, int i2) {
        j.e(parent, "parent");
        GeneralAdapter.GeneralVH w = super.onCreateViewHolder(parent, i2);
        SelectableColorPointView H = H(w);
        if (H != null) {
            ViewKt.setVisible(H, true);
        }
        TextView N = N(w);
        if (N != null) {
            ViewKt.setVisible(N, false);
        }
        return w;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NormalColorsAdapter(android.content.Context r2, java.util.List<com.tplink.iot.g.b.b.c> r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r1.<init>(r2, r3, r4)
            r2 = 1
            r1.l = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.adapter.NormalColorsAdapter.<init>(android.content.Context, java.util.List, int):void");
    }
}
