package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.BulbPresetsView;
import java.util.List;

/* loaded from: classes3.dex */
public class BulbBrightnessView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private BrightnessSeekBar f11482c;

    /* renamed from: d  reason: collision with root package name */
    private BulbPresetsView f11483d;

    /* renamed from: f  reason: collision with root package name */
    private c f11484f;

    /* loaded from: classes3.dex */
    class a implements BulbPresetsView.c {
        a() {
        }

        @Override // com.tplink.iot.widget.BulbPresetsView.c
        public void a(int i) {
            BulbBrightnessView.this.f11482c.c(i);
        }
    }

    /* loaded from: classes3.dex */
    class b implements BrightnessSeekBar.b {
        b() {
        }

        @Override // com.tplink.iot.widget.BrightnessSeekBar.b
        public void a(boolean z) {
            if (BulbBrightnessView.this.f11484f != null) {
                BulbBrightnessView.this.f11484f.onChange();
            }
            if (z) {
                BulbBrightnessView.this.f11483d.d();
            }
        }

        @Override // com.tplink.iot.widget.BrightnessSeekBar.b
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tplink.iot.widget.BrightnessSeekBar.b
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onChange();
    }

    public BulbBrightnessView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(int i) {
        this.f11482c.c(i);
    }

    public void f(final int i) {
        this.f11482c.post(new Runnable() { // from class: com.tplink.iot.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                BulbBrightnessView.this.e(i);
            }
        });
    }

    public int getBrightness() {
        return this.f11482c.getProgress();
    }

    public void setBrightness(int i) {
        this.f11482c.c(i);
    }

    public void setOnProgressBarChangeListener(c cVar) {
        this.f11484f = cVar;
    }

    public void setPresets(List<Integer> list) {
        this.f11483d.setPresets(list);
    }

    public BulbBrightnessView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BulbBrightnessView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.view_bulb_brightness_setting, (ViewGroup) this, true);
        this.f11482c = (BrightnessSeekBar) findViewById(R.id.brightness_seekbar);
        BulbPresetsView bulbPresetsView = (BulbPresetsView) findViewById(R.id.preset_view);
        this.f11483d = bulbPresetsView;
        bulbPresetsView.setOnPresetItemCheckListener(new a());
        this.f11482c.setOnSeekbarChangeListener(new b());
    }
}
