package com.tplink.iot.widget.trv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tplink.iot.databinding.LayoutTemperatureSeekbarBinding;
import com.tplink.iot.widget.trv.TemperaturePresetsView;
import com.tplink.iot.widget.trv.TemperatureSeekBar;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.n;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TemperatureSeekBarLayout.kt */
/* loaded from: classes3.dex */
public final class TemperatureSeekBarLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final List<Integer> f11852c;

    /* renamed from: d  reason: collision with root package name */
    private static final List<Integer> f11853d;

    /* renamed from: f  reason: collision with root package name */
    public static final c f11854f = new c(null);
    private d p0;
    private boolean p1;
    private final LayoutTemperatureSeekbarBinding q;
    private final kotlin.f x;
    private final kotlin.f y;
    private EnumTemperatureUnit z;

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    public static final class a implements TemperaturePresetsView.b {
        a() {
        }

        @Override // com.tplink.iot.widget.trv.TemperaturePresetsView.b
        public void a(int i) {
            TemperatureSeekBarLayout.this.setTemperature(i);
        }
    }

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    public static final class b implements TemperatureSeekBar.b {
        b() {
        }

        @Override // com.tplink.iot.widget.trv.TemperatureSeekBar.b
        public void a(SeekBar seekBar, int i, EnumTemperatureUnit tempUnit, boolean z) {
            j.e(tempUnit, "tempUnit");
            d dVar = TemperatureSeekBarLayout.this.p0;
            if (dVar != null) {
                dVar.onChange();
            }
            if (z) {
                TemperatureSeekBarLayout.this.getMPresetView().d();
            }
        }

        @Override // com.tplink.iot.widget.trv.TemperatureSeekBar.b
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tplink.iot.widget.trv.TemperatureSeekBar.b
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    public interface d {
        void onChange();
    }

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<TemperaturePresetsView> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final TemperaturePresetsView invoke() {
            TemperaturePresetsView temperaturePresetsView = TemperatureSeekBarLayout.this.q.f7304c;
            j.d(temperaturePresetsView, "mBinding.presetView");
            return temperaturePresetsView;
        }
    }

    /* compiled from: TemperatureSeekBarLayout.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<TemperatureSeekBar> {
        f() {
            super(0);
        }

        /* renamed from: a */
        public final TemperatureSeekBar invoke() {
            TemperatureSeekBar temperatureSeekBar = TemperatureSeekBarLayout.this.q.f7305d;
            j.d(temperatureSeekBar, "mBinding.tempSeekBar");
            return temperatureSeekBar;
        }
    }

    static {
        List<Integer> g;
        List<Integer> g2;
        g = n.g(5, 15, 20, 25, 30);
        f11852c = g;
        g2 = n.g(41, 59, 68, 77, 86);
        f11853d = g2;
    }

    public TemperatureSeekBarLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public TemperatureSeekBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TemperatureSeekBarLayout(Context context, AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void d() {
        int i;
        int i2 = a.f11864b[this.z.ordinal()];
        if (i2 == 1) {
            i = 22;
        } else if (i2 == 2) {
            i = 72;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        getMTempSeekBar().h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TemperaturePresetsView getMPresetView() {
        return (TemperaturePresetsView) this.y.getValue();
    }

    private final TemperatureSeekBar getMTempSeekBar() {
        return (TemperatureSeekBar) this.x.getValue();
    }

    public final void e(int i, int i2, EnumTemperatureUnit tempUnit) {
        j.e(tempUnit, "tempUnit");
        this.z = tempUnit;
        setPresets(tempUnit);
        getMTempSeekBar().i(i, i2, tempUnit);
        if (this.p1) {
            d();
        }
    }

    public final TextView getHeaderTextView() {
        TextView textView = this.q.f7306f;
        j.d(textView, "mBinding.tvHeader");
        return textView;
    }

    public final int getMaxTemperature() {
        return getMTempSeekBar().getMaxTemperature();
    }

    public final int getMinTemperature() {
        return getMTempSeekBar().getMinTemperature();
    }

    public final int getTemperature() {
        return getMTempSeekBar().getTemperature();
    }

    public final EnumTemperatureUnit getTemperatureUnit() {
        return this.z;
    }

    public final void setHeaderTextViewVisible(boolean z) {
        TextView textView = this.q.f7306f;
        j.d(textView, "mBinding.tvHeader");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void setOnProgressBarChangeListener(d dVar) {
        this.p0 = dVar;
    }

    public final void setPresets(EnumTemperatureUnit tempUnit) {
        List<Integer> list;
        j.e(tempUnit, "tempUnit");
        int i = a.a[tempUnit.ordinal()];
        if (i == 1) {
            list = f11852c;
        } else if (i == 2) {
            list = f11853d;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        getMPresetView().e(list, tempUnit);
    }

    public final void setTemperature(int i) {
        this.p1 = false;
        getMTempSeekBar().h(i);
    }

    public final void setTemperatureUnit(EnumTemperatureUnit enumTemperatureUnit) {
        if (enumTemperatureUnit == null) {
            enumTemperatureUnit = EnumTemperatureUnit.CELSIUS;
        }
        this.z = enumTemperatureUnit;
        getMTempSeekBar().setTemperatureUnit(this.z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureSeekBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.f b2;
        kotlin.f b3;
        j.e(context, "context");
        LayoutTemperatureSeekbarBinding h = LayoutTemperatureSeekbarBinding.h(LayoutInflater.from(context), this, true);
        j.d(h, "LayoutTemperatureSeekbar…rom(context), this, true)");
        this.q = h;
        b2 = i.b(new f());
        this.x = b2;
        b3 = i.b(new e());
        this.y = b3;
        this.z = EnumTemperatureUnit.CELSIUS;
        this.p1 = true;
        getMPresetView().setOnPresetItemCheckListener(new a());
        getMTempSeekBar().setOnSeekBarChangeListener(new b());
        d();
    }
}
