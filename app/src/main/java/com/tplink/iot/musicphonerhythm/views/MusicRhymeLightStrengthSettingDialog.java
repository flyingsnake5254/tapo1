package com.tplink.iot.musicphonerhythm.views;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class MusicRhymeLightStrengthSettingDialog extends MusicRhymeBaseSheetDialog implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String f8271c = MusicRhymeLightStrengthSettingDialog.class.getName();

    /* renamed from: d  reason: collision with root package name */
    private TextView f8272d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8273f;
    private SeekBar q;
    private a x;
    private int y;

    /* loaded from: classes2.dex */
    public interface a {
        void y(int i);
    }

    public static MusicRhymeLightStrengthSettingDialog G0(int i) {
        MusicRhymeLightStrengthSettingDialog musicRhymeLightStrengthSettingDialog = new MusicRhymeLightStrengthSettingDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("light_percent", i);
        musicRhymeLightStrengthSettingDialog.setArguments(bundle);
        return musicRhymeLightStrengthSettingDialog;
    }

    @Override // com.tplink.iot.musicphonerhythm.views.MusicRhymeBaseSheetDialog
    protected int A0() {
        return R.layout.dialog_music_rhythm_light_strength_sheet;
    }

    @Override // com.tplink.iot.musicphonerhythm.views.MusicRhymeBaseSheetDialog
    protected void B0(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.y = arguments.getInt("light_percent");
        }
        setCancelable(false);
        view.findViewById(R.id.tv_close).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.tv_save);
        this.f8272d = textView;
        textView.setOnClickListener(this);
        this.f8272d.setClickable(false);
        this.f8273f = (TextView) view.findViewById(R.id.tv_color_temp_value);
        this.f8273f.setText(this.y + "%");
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.music_rhythm_light_percent_bar);
        this.q = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.q.setProgress(this.y);
    }

    public void H0(a aVar) {
        this.x = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_close) {
            C0();
        } else if (id == R.id.tv_save) {
            this.x.y(this.y);
            C0();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        b.d.w.c.a.c(f8271c, "onBrightnessChange: " + i);
        if (i < 1) {
            this.q.setProgress(1);
            i = 1;
        }
        if (i > 100) {
            i = 100;
        }
        this.y = i;
        String str = this.y + "%";
        if (z) {
            this.f8273f.setText(str);
            this.f8272d.setClickable(true);
            this.f8272d.setTextColor(getResources().getColor(R.color.common_iot_main_blue));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
