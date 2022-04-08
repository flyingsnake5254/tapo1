package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubGHubFirmwareUpdateBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGHubFirmwareUpdateViewModel;

/* loaded from: classes2.dex */
public class SubGHubFirmwareUpdateFragment extends SubGBaseFragment<FragmentSubGHubFirmwareUpdateBinding, SubGHubFirmwareUpdateViewModel> {
    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_sub_g_hub_firmware_update;
    }

    /* renamed from: G0 */
    public SubGHubFirmwareUpdateViewModel C0() {
        return null;
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
