package com.tplink.iot.view.colorbulb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

/* loaded from: classes2.dex */
public class EditColorBulbPresetDialog extends BaseBottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private View f8414c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f8415d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f8416f;
    private int p0;
    private LightStateBean p1;
    private ColorPresetEditWrapView q;
    private b x;
    private boolean y = false;
    private String z;

    /* loaded from: classes2.dex */
    class a implements ColorPresetEditWrapView.b {
        a() {
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView.b
        public void a(LightStateBean lightStateBean) {
            if (EditColorBulbPresetDialog.this.x != null) {
                EditColorBulbPresetDialog.this.x.U(lightStateBean);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void U(LightStateBean lightStateBean);

        void g(int i, LightStateBean lightStateBean);

        void h(LightStateBean lightStateBean);
    }

    public static EditColorBulbPresetDialog H0(LightStateBean lightStateBean, String str) {
        EditColorBulbPresetDialog editColorBulbPresetDialog = new EditColorBulbPresetDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tag_edit_preset_info", lightStateBean);
        bundle.putString("tag_dialog_title", str);
        editColorBulbPresetDialog.setArguments(bundle);
        return editColorBulbPresetDialog;
    }

    public static EditColorBulbPresetDialog I0(boolean z, int i, LightStateBean lightStateBean) {
        EditColorBulbPresetDialog editColorBulbPresetDialog = new EditColorBulbPresetDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("tag_is_edit_mode", z);
        bundle.putInt("tag_edit_preset_index", i);
        bundle.putSerializable("tag_edit_preset_info", lightStateBean);
        editColorBulbPresetDialog.setArguments(bundle);
        return editColorBulbPresetDialog;
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected int A0() {
        return R.layout.dialog_edit_color_bulb_preset;
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected void B0(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.y = arguments.getBoolean("tag_is_edit_mode", false);
            this.p1 = (LightStateBean) arguments.getSerializable("tag_edit_preset_info");
            this.z = arguments.getString("tag_dialog_title");
            if (this.y) {
                this.p0 = arguments.getInt("tag_edit_preset_index", 0);
            }
        }
        this.f8414c = view.findViewById(R.id.ll_layout);
        this.q = (ColorPresetEditWrapView) view.findViewById(R.id.color_preset_view);
        this.f8415d = (ImageView) view.findViewById(R.id.iv_close);
        this.f8416f = (ImageView) view.findViewById(R.id.iv_save);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_title);
        if (!TextUtils.isEmpty(this.z)) {
            textView.setText(this.z);
        }
        this.f8415d.setOnClickListener(this);
        this.f8416f.setOnClickListener(this);
        this.q.setOnSampleLightStateChangeCallback(new a());
        LightStateBean lightStateBean = this.p1;
        if (lightStateBean != null) {
            this.q.setLightStates(lightStateBean);
        }
    }

    public void J0(b bVar) {
        this.x = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            dismiss();
        } else if (id == R.id.iv_save) {
            if (this.x != null) {
                LightStateBean lightState = this.q.getLightState();
                if (this.y) {
                    this.x.g(this.p0, lightState);
                } else {
                    this.x.h(lightState);
                }
            }
            dismiss();
        }
    }
}
