package com.tplink.iot.view.ipcamera.setting.firmware;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareUpdateViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import org.apache.commons.lang.b;

/* loaded from: classes2.dex */
public class FirmwareUpgradeFragment extends BaseFragment implements View.OnClickListener, g {
    private FirmwareUpdateViewModel q;
    private FirmwareUpdateNewIpcActivity x;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0() throws Exception {
        this.x.i1(0);
        this.x.h1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(a aVar) {
        if (aVar == null || !b.b((Boolean) aVar.a())) {
            TSnackbar.z(TSnackbar.s(this), R.string.firmware_update_fail, -1).N();
        } else {
            this.q.I().y(new io.reactivex.g0.a() { // from class: com.tplink.iot.view.ipcamera.setting.firmware.d
                @Override // io.reactivex.g0.a
                public final void run() {
                    FirmwareUpgradeFragment.this.I0();
                }
            }).F0();
        }
    }

    public void L0() {
        b.d.w.c.a.c("FirmwareUpgradeFragment", "startUpgrade");
        this.q.f10744b.set(true);
        this.x.h1(true);
        this.q.G();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.x = (FirmwareUpdateNewIpcActivity) context;
    }

    @Override // android.view.View.OnClickListener, com.tplink.iot.view.ipcamera.base.g
    public void onClick(View view) {
        if (view.getId() == R.id.btn_firmware_update) {
            L0();
            this.q.D();
        } else if (view.getId() == R.id.img_back) {
            this.x.onBackPressed();
        } else if (view.getId() == R.id.item_auto_update) {
            FirmwareUpdateNewIpcActivity firmwareUpdateNewIpcActivity = this.x;
            firmwareUpdateNewIpcActivity.X0(AutoUpdateSettingActivity.class, firmwareUpdateNewIpcActivity.e1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FirmwareUpdateViewModel firmwareUpdateViewModel = (FirmwareUpdateViewModel) ViewModelProviders.of(this.x).get(FirmwareUpdateViewModel.class);
        this.q = firmwareUpdateViewModel;
        firmwareUpdateViewModel.h(this.x.e1());
        FragmentFirmwareUpdateNewIpcBinding fragmentFirmwareUpdateNewIpcBinding = (FragmentFirmwareUpdateNewIpcBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_firmware_update_new_ipc, viewGroup, false);
        fragmentFirmwareUpdateNewIpcBinding.i(this.q);
        fragmentFirmwareUpdateNewIpcBinding.h(this);
        this.q.j.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.firmware.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareUpgradeFragment.this.K0((a) obj);
            }
        });
        if (this.x.f1()) {
            L0();
        }
        return fragmentFirmwareUpdateNewIpcBinding.getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.q.k.dispose();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FirmwareUpdateViewModel firmwareUpdateViewModel = this.q;
        if (firmwareUpdateViewModel != null) {
            firmwareUpdateViewModel.H();
        }
    }
}
