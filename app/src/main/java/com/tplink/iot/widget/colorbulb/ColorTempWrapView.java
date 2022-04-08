package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.widget.colorbulb.ColorTemperatureView;
import com.tplink.iot.widget.colorbulb.c.b;
import com.tplink.iot.widget.colorbulb.c.c;

/* loaded from: classes3.dex */
public class ColorTempWrapView extends LinearLayout implements ColorTemperatureView.b {

    /* renamed from: c  reason: collision with root package name */
    private final String f11756c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11757d;

    /* renamed from: f  reason: collision with root package name */
    private ColorTemperatureView f11758f;
    private c q;
    private b x;

    public ColorTempWrapView(Context context) {
        this(context, null);
    }

    private void setColorTempValueText(int i) {
        if (this.f11758f.h()) {
            this.f11757d.setText(String.format("%sK", Integer.valueOf(i)));
        } else {
            this.f11757d.setText("");
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.ColorTemperatureView.b
    public void a(int i) {
        setColorTempValueText(i);
    }

    @Override // com.tplink.iot.widget.colorbulb.ColorTemperatureView.b
    public void b(int i) {
        c cVar = this.q;
        if (cVar != null) {
            cVar.b(i, 0, 0);
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.ColorTemperatureView.b
    public void c() {
        b bVar = this.x;
        if (bVar != null) {
            bVar.S(0, true);
        }
    }

    public void d(int i, int i2) {
        this.f11758f.l(i, i2);
    }

    public int getColorTemp() {
        return this.f11758f.getColorTemp();
    }

    public void setColorTemp(int i) {
        this.f11758f.setColorTemp(i);
        setColorTempValueText(i);
    }

    public void setOnLightTypeSelectListener(b bVar) {
        this.x = bVar;
    }

    public void setOnSampleLightStateCallback(c cVar) {
        this.q = cVar;
    }

    public void setSelectedStatus(boolean z) {
        this.f11758f.setSelectedStatus(z);
        if (!z) {
            setColorTempValueText(0);
        }
    }

    public ColorTempWrapView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorTempWrapView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11756c = "%sK";
        LayoutInflater.from(context).inflate(R.layout.view_color_temperature_wrap, (ViewGroup) this, true);
        this.f11757d = (TextView) findViewById(R.id.tv_color_temp);
        ColorTemperatureView colorTemperatureView = (ColorTemperatureView) findViewById(R.id.color_temperature_view);
        this.f11758f = colorTemperatureView;
        colorTemperatureView.setOnColorTemperatureListener(this);
        setColorTempValueText(this.f11758f.getColorTemp());
    }
}
