package com.tplink.iot.widget.trv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: TemperatureSeekBar.kt */
/* loaded from: classes3.dex */
public final class TemperatureSeekBar extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private b f11846c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f11847d;

    /* renamed from: f  reason: collision with root package name */
    private final SeekBar f11848f;
    private int p0;
    private boolean q;
    private EnumTemperatureUnit x;
    private int y;
    private int z;

    /* compiled from: TemperatureSeekBar.kt */
    /* loaded from: classes3.dex */
    public static final class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                TemperatureSeekBar temperatureSeekBar = TemperatureSeekBar.this;
                temperatureSeekBar.p0 = i + temperatureSeekBar.y;
                TemperatureSeekBar temperatureSeekBar2 = TemperatureSeekBar.this;
                temperatureSeekBar2.j(temperatureSeekBar2.p0);
                b bVar = TemperatureSeekBar.this.f11846c;
                if (bVar != null) {
                    bVar.a(seekBar, TemperatureSeekBar.this.p0, TemperatureSeekBar.this.x, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b bVar = TemperatureSeekBar.this.f11846c;
            if (bVar != null) {
                bVar.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            b bVar = TemperatureSeekBar.this.f11846c;
            if (bVar != null) {
                bVar.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* compiled from: TemperatureSeekBar.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a(SeekBar seekBar, int i, EnumTemperatureUnit enumTemperatureUnit, boolean z);

        void onStartTrackingTouch(SeekBar seekBar);

        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemperatureSeekBar.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11851d;

        c(int i) {
            this.f11851d = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TemperatureSeekBar.this.setTemperatureInternal(this.f11851d);
        }
    }

    public TemperatureSeekBar(Context context) {
        this(context, null, 0, 6, null);
    }

    public TemperatureSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TemperatureSeekBar(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void j(int i) {
        this.f11847d.setText(com.tplink.iot.g.d.a.b.d(i, this.x));
        this.f11847d.measure(0, 0);
        int max = Math.max(Math.min(Math.max(0, (int) (((((this.f11848f.getWidth() - this.f11848f.getPaddingLeft()) - this.f11848f.getPaddingRight()) * (this.f11848f.getProgress() / this.f11848f.getMax())) + this.f11848f.getPaddingLeft()) - (this.f11847d.getMeasuredWidth() / 2.0f))), this.f11848f.getWidth() - this.f11847d.getMeasuredWidth()), 0);
        TextView textView = this.f11847d;
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(max);
        textView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTemperatureInternal(int i) {
        int i2 = this.y;
        int i3 = this.z;
        if (i2 <= i && i3 >= i) {
            this.p0 = i;
            int i4 = i - i2;
            if (Build.VERSION.SDK_INT >= 24) {
                this.f11848f.setProgress(i4, true);
            } else {
                this.f11848f.setProgress(i4);
            }
            j(this.p0);
            b bVar = this.f11846c;
            if (bVar != null) {
                bVar.a(this.f11848f, this.p0, this.x, false);
            }
        }
    }

    public final int getMaxTemperature() {
        return this.z;
    }

    public final int getMinTemperature() {
        return this.y;
    }

    public final int getTemperature() {
        return this.p0;
    }

    public final void h(int i) {
        this.f11848f.post(new c(i));
    }

    public final void i(int i, int i2, EnumTemperatureUnit tempUnit) {
        j.e(tempUnit, "tempUnit");
        this.x = tempUnit;
        this.y = i;
        this.z = i2;
        this.f11848f.setMax(i2 - i);
        h(this.p0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.q) {
            this.q = true;
            j(this.p0);
        }
    }

    public final void setOnSeekBarChangeListener(b listener) {
        j.e(listener, "listener");
        listener.a(this.f11848f, getTemperature(), this.x, false);
        p pVar = p.a;
        this.f11846c = listener;
    }

    public final void setTemperature(int i) {
        setTemperatureInternal(i);
    }

    public final void setTemperatureUnit(EnumTemperatureUnit tempUnit) {
        j.e(tempUnit, "tempUnit");
        this.x = tempUnit;
        j(this.p0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.x = EnumTemperatureUnit.CELSIUS;
        this.z = 100;
        this.p0 = this.y;
        LayoutInflater.from(context).inflate(R.layout.view_temperature_seekbar, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.tv_text);
        j.d(findViewById, "findViewById(R.id.tv_text)");
        this.f11847d = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.seekBar);
        j.d(findViewById2, "findViewById(R.id.seekBar)");
        SeekBar seekBar = (SeekBar) findViewById2;
        this.f11848f = seekBar;
        seekBar.setOnSeekBarChangeListener(new a());
        i(this.y, this.z, this.x);
    }
}
