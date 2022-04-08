package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* loaded from: classes2.dex */
public class DeviceResetFragment extends BaseFragment {
    public DeviceModel q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        getActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.q = ((PasswordSettingActivity) context).e1().i();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_device_reset, viewGroup, false);
        ((Toolbar) inflate.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceResetFragment.this.I0(view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.image)).setImageResource(c.m(this.q));
        ((TextView) inflate.findViewById(R.id.text)).setText(c.p(this.q));
        return inflate;
    }
}
