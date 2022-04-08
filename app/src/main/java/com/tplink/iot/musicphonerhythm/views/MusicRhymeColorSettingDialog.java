package com.tplink.iot.musicphonerhythm.views;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.widget.colorbulb.TPCircleColorView;

/* loaded from: classes2.dex */
public class MusicRhymeColorSettingDialog extends MusicRhymeBaseSheetDialog implements View.OnClickListener, TPCircleColorView.b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f8262c = MusicRhymeColorSettingDialog.class.getName();

    /* renamed from: d  reason: collision with root package name */
    private TextView f8263d;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f8264f;
    private FrameLayout p0;
    private boolean p1 = false;
    private int p2 = 0;
    private int p3 = 0;
    private TPCircleColorView q;
    private b x;
    private int y;
    private int z;

    /* loaded from: classes2.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            MusicRhymeColorSettingDialog.this.f8263d.setClickable(true);
            MusicRhymeColorSettingDialog.this.f8263d.setTextColor(MusicRhymeColorSettingDialog.this.getResources().getColor(R.color.common_iot_main_blue));
            if (z) {
                MusicRhymeColorSettingDialog.this.q.setVisibility(0);
                MusicRhymeColorSettingDialog.this.p0.setVisibility(8);
                MusicRhymeColorSettingDialog.this.p1 = true;
                return;
            }
            MusicRhymeColorSettingDialog.this.q.setVisibility(8);
            MusicRhymeColorSettingDialog.this.p0.setVisibility(0);
            MusicRhymeColorSettingDialog.this.p1 = false;
            MusicRhymeColorSettingDialog.this.y = 0;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void N(int i);
    }

    public static MusicRhymeColorSettingDialog L0(MusicRhythmGlobalConfigBean musicRhythmGlobalConfigBean) {
        MusicRhymeColorSettingDialog musicRhymeColorSettingDialog = new MusicRhymeColorSettingDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("single_color_mode", musicRhythmGlobalConfigBean.isSingleColorEnable());
        bundle.putInt("single_color_user_hue", musicRhythmGlobalConfigBean.getHue());
        bundle.putInt("single_color_user_sat", musicRhythmGlobalConfigBean.getSaturation());
        musicRhymeColorSettingDialog.setArguments(bundle);
        return musicRhymeColorSettingDialog;
    }

    @Override // com.tplink.iot.musicphonerhythm.views.MusicRhymeBaseSheetDialog
    protected int A0() {
        return R.layout.dialog_music_rhythm_color_picker_sheet;
    }

    @Override // com.tplink.iot.musicphonerhythm.views.MusicRhymeBaseSheetDialog
    protected void B0(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p1 = arguments.getBoolean("single_color_mode");
            this.p2 = arguments.getInt("single_color_user_hue");
            this.p3 = arguments.getInt("single_color_user_sat");
        }
        setCancelable(false);
        view.findViewById(R.id.tv_close).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.tv_save);
        this.f8263d = textView;
        textView.setOnClickListener(this);
        this.f8263d.setClickable(false);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.iv_selector);
        this.f8264f = checkBox;
        checkBox.setChecked(this.p1);
        TPCircleColorView tPCircleColorView = (TPCircleColorView) view.findViewById(R.id.color_picker_view);
        this.q = tPCircleColorView;
        tPCircleColorView.setOnColorListener(this);
        this.p0 = (FrameLayout) view.findViewById(R.id.color_picker_view_disable);
        this.q.setSelectedStatus(true);
        int a2 = i.a(this.p2, this.p3);
        this.q.setColor(16777215 & a2);
        if (this.p1) {
            this.q.setVisibility(0);
            this.p0.setVisibility(8);
        } else {
            this.q.setVisibility(8);
            this.p0.setVisibility(0);
        }
        this.z = a2;
        this.f8264f.setOnCheckedChangeListener(new a());
    }

    @Override // com.tplink.iot.widget.colorbulb.TPCircleColorView.b
    public void J() {
    }

    public void N0(b bVar) {
        this.x = bVar;
    }

    @Override // com.tplink.iot.widget.colorbulb.TPCircleColorView.b
    public void g(int i, boolean z) {
        String str = f8262c;
        b.d.w.c.a.c(str, "updateColor color=" + i);
        if (z) {
            int i2 = i | ViewCompat.MEASURED_STATE_MASK;
            this.f8263d.setClickable(true);
            this.f8263d.setTextColor(getResources().getColor(R.color.common_iot_main_blue));
            this.z = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_close) {
            C0();
        } else if (id == R.id.tv_save) {
            if (this.p1) {
                this.y = this.z;
            } else {
                this.y = 0;
            }
            this.x.N(this.y);
            C0();
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.TPCircleColorView.b
    public void w(int i) {
    }
}
