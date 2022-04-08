package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.widget.colorbulb.TitleSelectorView;
import com.tplink.iot.widget.colorbulb.c.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ColorPresetEditWrapView extends LinearLayout implements TitleSelectorView.a, c, SeekBar.OnSeekBarChangeListener, com.tplink.iot.widget.colorbulb.c.b {
    private int H3;
    private boolean I3;

    /* renamed from: c  reason: collision with root package name */
    private TitleSelectorView f11749c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11750d;

    /* renamed from: f  reason: collision with root package name */
    private AppCompatSeekBar f11751f;
    private boolean p0;
    private int p1;
    private b p2;
    private io.reactivex.e0.c p3;
    private ColorTempWrapView q;
    private ColorPlateWrapView x;
    private View y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g<Long> {
        a() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            int progress = ColorPresetEditWrapView.this.f11751f.getProgress();
            if (progress != ColorPresetEditWrapView.this.H3) {
                ColorPresetEditWrapView.this.j(progress);
            }
            ColorPresetEditWrapView.this.H3 = progress;
            if (ColorPresetEditWrapView.this.I3 && ColorPresetEditWrapView.this.p3 != null) {
                ColorPresetEditWrapView.this.p3.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(LightStateBean lightStateBean);
    }

    public ColorPresetEditWrapView(Context context) {
        this(context, null);
    }

    private void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_color_brightness_preset_layout, (ViewGroup) this, true);
        this.f11749c = (TitleSelectorView) findViewById(R.id.title_selector_view);
        this.y = findViewById(R.id.ll_brightness);
        this.f11750d = (TextView) findViewById(R.id.tv_brightness);
        this.f11751f = (AppCompatSeekBar) findViewById(R.id.seek_bar);
        this.y.setVisibility(this.p0 ? 0 : 8);
        ColorTempWrapView colorTempWrapView = (ColorTempWrapView) findViewById(R.id.color_temperature_wrap_view);
        this.q = colorTempWrapView;
        colorTempWrapView.setOnSampleLightStateCallback(this);
        this.q.setOnLightTypeSelectListener(this);
        ColorPlateWrapView colorPlateWrapView = (ColorPlateWrapView) findViewById(R.id.color_plate_wrap_view);
        this.x = colorPlateWrapView;
        colorPlateWrapView.setOnSampleLightStateCallback(this);
        this.x.setOnLightTypeSelectListener(this);
        this.q.setColorTemp(2700);
        this.f11751f.setProgress(100);
        this.f11750d.setText("100%");
        this.f11751f.setOnSeekBarChangeListener(this);
        this.f11749c.setOnSelectedTitleListener(this);
        setColorMode(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        if (this.p2 != null) {
            LightStateBean lightState = getLightState();
            lightState.setBrightness(i);
            this.p2.a(lightState);
        }
    }

    private void k() {
        io.reactivex.e0.c cVar = this.p3;
        if (cVar != null) {
            cVar.dispose();
        }
        this.I3 = false;
        this.H3 = this.f11751f.getProgress();
        this.p3 = q.a0(500L, 500L, TimeUnit.MILLISECONDS).L0(io.reactivex.l0.a.c()).G0(new a());
    }

    @Override // com.tplink.iot.widget.colorbulb.c.b
    public void S(int i, boolean z) {
        if (i == 0) {
            this.p1 = 0;
            this.x.setSelectedStatus(false);
        } else if (i == 1) {
            this.p1 = 1;
            this.q.setSelectedStatus(false);
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.TitleSelectorView.a
    public void a(int i) {
        if (i == 0) {
            this.q.setVisibility(0);
            this.x.setVisibility(4);
            return;
        }
        this.q.setVisibility(4);
        this.x.setVisibility(0);
    }

    @Override // com.tplink.iot.widget.colorbulb.c.c
    public void b(int i, int i2, int i3) {
        if (this.p2 != null) {
            this.p2.a(new LightStateBean(i2, i3, i, this.f11751f.getProgress()));
        }
    }

    public LightStateBean getLightState() {
        LightStateBean lightStateBean = new LightStateBean(true);
        if (this.p1 == 0) {
            lightStateBean.setColorTemp(this.q.getColorTemp());
        } else {
            lightStateBean.setColorTemp(0);
            lightStateBean.setHue(this.x.getHue());
            lightStateBean.setSaturation(this.x.getSat());
        }
        lightStateBean.setBrightness(this.f11751f.getProgress());
        return lightStateBean;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (i < 1) {
            seekBar.setProgress(1);
            i = 1;
        }
        TextView textView = this.f11750d;
        textView.setText(i + "%");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.I3 = false;
        k();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.I3 = true;
    }

    public void setColorMode(int i) {
        this.z = i;
        if (i == 1) {
            this.f11749c.setBackgroundResource(R.drawable.bg_title_select);
        } else {
            this.f11749c.setBackgroundResource(R.drawable.bg_title_select_dark_mode);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void setLightStates(LightStateBean lightStateBean) {
        if (lightStateBean != null) {
            if (lightStateBean.getColorTemp() == 0) {
                setSelectedItem(1);
                this.x.b(i.a(lightStateBean.getHue(), lightStateBean.getSaturation()), lightStateBean.getHue(), lightStateBean.getSaturation());
            } else {
                setSelectedItem(0);
                this.q.setColorTemp(lightStateBean.getColorTemp());
            }
            this.f11751f.setProgress(lightStateBean.getBrightness());
            TextView textView = this.f11750d;
            textView.setText(lightStateBean.getBrightness() + "%");
        }
    }

    public void setOnSampleLightStateChangeCallback(b bVar) {
        this.p2 = bVar;
    }

    public void setSelectedItem(int i) {
        this.f11749c.setSelectedTitleIndex(i);
    }

    public ColorPresetEditWrapView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPresetEditWrapView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = 1;
        this.p0 = true;
        this.p1 = 0;
        this.I3 = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.ColorPresetEditWrapView, i, 0);
        if (obtainStyledAttributes != null) {
            this.z = obtainStyledAttributes.getInt(1, 1);
            this.p0 = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        i(context);
    }
}
