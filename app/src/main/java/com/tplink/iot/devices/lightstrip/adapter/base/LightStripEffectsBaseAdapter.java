package com.tplink.iot.devices.lightstrip.adapter.base;

import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.DashCircleAddView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.a.a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: LightStripEffectsBaseAdapter.kt */
/* loaded from: classes2.dex */
public abstract class LightStripEffectsBaseAdapter<T> extends GeneralAdapter<T> {

    /* renamed from: d  reason: collision with root package name */
    private a<T> f7500d;

    /* renamed from: e  reason: collision with root package name */
    private int f7501e;

    /* renamed from: f  reason: collision with root package name */
    private String f7502f;
    private int g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LightStripEffectsBaseAdapter(android.content.Context r2, java.util.List<? extends T> r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "dataList"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r1.<init>(r2, r3)
            java.util.List r2 = r1.s()
            int r2 = r2.size()
            if (r4 >= 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            if (r2 <= r4) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r4 = -1
        L_0x0020:
            r1.f7501e = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter.<init>(android.content.Context, java.util.List, int):void");
    }

    private final void B(int i, boolean z) {
        P();
        A(s().get(i), z);
        notifyItemChanged(i);
    }

    protected abstract void A(T t, boolean z);

    public final void C() {
        int size = s().size();
        int i = this.f7501e;
        if (i >= 0 && size > i) {
            B(i, false);
            this.f7501e = -1;
            this.f7502f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D() {
        this.g = 0;
    }

    public final a<T> E() {
        return this.f7500d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DashCircleAddView F(GeneralAdapter.GeneralVH addView) {
        j.e(addView, "$this$addView");
        return (DashCircleAddView) addView.c(R.id.dash_circle_add);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ColorEffectPlateView G(GeneralAdapter.GeneralVH colorPlate) {
        j.e(colorPlate, "$this$colorPlate");
        return (ColorEffectPlateView) colorPlate.c(R.id.color_effect_plate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SelectableColorPointView H(GeneralAdapter.GeneralVH colorPoint) {
        j.e(colorPoint, "$this$colorPoint");
        return (SelectableColorPointView) colorPoint.c(R.id.selectable_color_point);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ColorPaintingRingView I(GeneralAdapter.GeneralVH colorRing) {
        j.e(colorRing, "$this$colorRing");
        return (ColorPaintingRingView) colorRing.c(R.id.color_painting_ring);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CircleEffectImageView J(GeneralAdapter.GeneralVH effectImage) {
        j.e(effectImage, "$this$effectImage");
        return (CircleEffectImageView) effectImage.c(R.id.circle_effect_image);
    }

    protected abstract String K(T t);

    public final T L() {
        int size = s().size();
        int i = this.f7501e;
        if (i >= 0 && size > i) {
            return s().get(this.f7501e);
        }
        return null;
    }

    public final int M() {
        return this.f7501e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView N(GeneralAdapter.GeneralVH tvTitle) {
        j.e(tvTitle, "$this$tvTitle");
        return (TextView) tvTitle.c(R.id.tv_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean O() {
        return false;
    }

    protected final void P() {
        this.g++;
    }

    public final void Q(int i) {
        if (i != this.f7501e) {
            int size = s().size();
            if (i >= 0 && size > i) {
                C();
                B(i, true);
                this.f7501e = i;
                this.f7502f = K(s().get(i));
            }
        }
    }

    public final void R(String str) {
        if (str != null) {
            int i = 0;
            Iterator<T> it = s().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (j.a(K(it.next()), str)) {
                    break;
                } else {
                    i++;
                }
            }
            Q(i);
        }
    }

    public final void S(a<T> aVar) {
        this.f7500d = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(List<? extends T> newData) {
        j.e(newData, "newData");
        super.y(newData);
        int i = -1;
        if (this.f7501e != -1 && this.f7502f != null) {
            int i2 = 0;
            Iterator<? extends T> it = newData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (j.a(K(it.next()), this.f7502f)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            C();
            Q(i);
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public int p(int i) {
        return R.layout.item_light_strip_effects_holder;
    }
}
