package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: MultiColorPaletteView.kt */
/* loaded from: classes2.dex */
public final class MultiColorPaletteView extends MultiColorSpectrumPickerView {
    private List<c> Y3;
    private boolean Z3;

    /* compiled from: MultiColorPaletteView.kt */
    /* loaded from: classes2.dex */
    static final class a implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f7823d;

        a(List list) {
            this.f7823d = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiColorPaletteView.this.setCursors(this.f7823d);
            MultiColorPaletteView.this.invalidate();
        }
    }

    public MultiColorPaletteView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MultiColorPaletteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MultiColorPaletteView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void K(boolean z) {
        this.Z3 = z;
        b.d.w.c.a.n("LightStrip", "MultiColorPaletteView#markHasChangedOrigin: " + this.Z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorSpectrumPickerView
    public void B(a aVar, boolean z) {
        super.B(aVar, z);
        if (z) {
            K(true);
        }
    }

    public final void H(c hsb) {
        j.e(hsb, "hsb");
        K(true);
        a(hsb.d());
        invalidate();
    }

    public final void I() {
        K(true);
        H(c.f7829b.a());
    }

    public final void J(int i) {
        if (i > 0) {
            K(true);
            for (int i2 = 0; i2 < i; i2++) {
                I();
            }
        }
    }

    public final void L() {
        K(true);
        C();
        invalidate();
    }

    public final List<Integer> getColors() {
        ArrayList arrayList;
        int l;
        int l2;
        if (this.Z3) {
            List<float[]> selectedValues = getSelectedValues();
            j.d(selectedValues, "selectedValues");
            l2 = o.l(selectedValues, 10);
            arrayList = new ArrayList(l2);
            for (float[] it : selectedValues) {
                j.d(it, "it");
                arrayList.add(Integer.valueOf(new c(it).g()));
            }
        } else {
            List<c> list = this.Y3;
            l = o.l(list, 10);
            arrayList = new ArrayList(l);
            for (c cVar : list) {
                arrayList.add(Integer.valueOf(cVar.g()));
            }
        }
        return arrayList;
    }

    public final List<c> getHSBColors() {
        int l;
        if (!this.Z3) {
            return this.Y3;
        }
        List<float[]> selectedValues = getSelectedValues();
        j.d(selectedValues, "selectedValues");
        l = o.l(selectedValues, 10);
        ArrayList arrayList = new ArrayList(l);
        for (float[] it : selectedValues) {
            j.d(it, "it");
            arrayList.add(new c(it));
        }
        return arrayList;
    }

    public final List<d> getRGBColors() {
        ArrayList arrayList;
        int l;
        int l2;
        if (this.Z3) {
            List<float[]> selectedValues = getSelectedValues();
            j.d(selectedValues, "selectedValues");
            l2 = o.l(selectedValues, 10);
            arrayList = new ArrayList(l2);
            for (float[] it : selectedValues) {
                j.d(it, "it");
                arrayList.add(new c(it).i());
            }
        } else {
            List<c> list = this.Y3;
            l = o.l(list, 10);
            arrayList = new ArrayList(l);
            for (c cVar : list) {
                arrayList.add(cVar.i());
            }
        }
        return arrayList;
    }

    public final void setColors(List<Integer> colors) {
        int l;
        j.e(colors, "colors");
        K(true);
        l = o.l(colors, 10);
        ArrayList arrayList = new ArrayList(l);
        for (Number number : colors) {
            c c2 = d.a.a(number.intValue()).c();
            Log.e("TAG", "setColors: " + c2);
            arrayList.add(c2);
        }
        setCursors(arrayList);
        invalidate();
    }

    public final void setHSBColors(List<c> colors) {
        j.e(colors, "colors");
        K(true);
        setCursors(colors);
        invalidate();
    }

    public final void setOriginHSBColors(List<c> colors) {
        j.e(colors, "colors");
        K(false);
        this.Y3.clear();
        this.Y3.addAll(colors);
        post(new a(colors));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiColorPaletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.Y3 = new ArrayList();
    }
}
