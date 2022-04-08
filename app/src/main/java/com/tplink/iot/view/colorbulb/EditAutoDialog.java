package com.tplink.iot.view.colorbulb;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;

/* loaded from: classes2.dex */
public class EditAutoDialog extends BaseBottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private String f8411c = AutoLightBean.MODE_LIGHT_COMPENSATE;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f8412d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f8413f;
    private View q;
    private View x;
    private a y;

    /* loaded from: classes2.dex */
    public interface a {
        void J0(String str);
    }

    public static EditAutoDialog G0(String str) {
        EditAutoDialog editAutoDialog = new EditAutoDialog();
        Bundle bundle = new Bundle();
        bundle.putString("light_mode", str);
        editAutoDialog.setArguments(bundle);
        return editAutoDialog;
    }

    private void H0() {
        a aVar = this.y;
        if (aVar != null) {
            aVar.J0(this.f8411c);
        }
        C0();
    }

    private void J0() {
        if (AutoLightBean.MODE_LIGHT_COMPENSATE.equals(this.f8411c)) {
            this.q.setBackground(getResources().getDrawable(R.drawable.bg_item_light_auto_selected));
            this.f8412d.setImageResource(R.mipmap.light_compensate);
            this.x.setBackground(getResources().getDrawable(R.drawable.bg_item_light_auto));
            this.f8413f.setImageResource(R.mipmap.light_track_selected);
            return;
        }
        this.q.setBackground(getResources().getDrawable(R.drawable.bg_item_light_auto));
        this.f8412d.setImageResource(R.mipmap.light_compensate_selected);
        this.x.setBackground(getResources().getDrawable(R.drawable.bg_item_light_auto_selected));
        this.f8413f.setImageResource(R.mipmap.light_track);
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected int A0() {
        return R.layout.dialog_edit_bulb_auto;
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected void B0(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f8411c = arguments.getString("light_mode", AutoLightBean.MODE_LIGHT_COMPENSATE);
        }
        this.q = view.findViewById(R.id.ll_light_compensate);
        this.x = view.findViewById(R.id.ll_light_track);
        this.f8412d = (ImageView) view.findViewById(R.id.iv_light_compensate);
        this.f8413f = (ImageView) view.findViewById(R.id.iv_light_track);
        this.q.setOnClickListener(this);
        this.x.setOnClickListener(this);
        view.findViewById(R.id.iv_close).setOnClickListener(this);
        J0();
    }

    public void I0(a aVar) {
        this.y = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close /* 2131363013 */:
                C0();
                return;
            case R.id.ll_light_compensate /* 2131363302 */:
                this.f8411c = AutoLightBean.MODE_LIGHT_COMPENSATE;
                J0();
                H0();
                return;
            case R.id.ll_light_track /* 2131363303 */:
                this.f8411c = AutoLightBean.MODE_LIGHT_TRACK;
                J0();
                H0();
                return;
            default:
                return;
        }
    }
}
