package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import b.d.b.f.b;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.FragmentCameraV2NameBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraSetNameFragment extends OnBoardingFragment<FragmentCameraV2NameBinding, CameraSetNameViewModel> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            V v = CameraSetNameFragment.this.f8810d;
            ((CameraSetNameViewModel) v).a.set(((CameraSetNameViewModel) v).f(charSequence.toString()));
        }
    }

    private void H0() {
        if (this.q.g0()) {
            TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
            List<RoomInfo> rooms = tPIoTClientManager.Q1() != null ? tPIoTClientManager.Q1().getRooms() : null;
            if (rooms == null || rooms.isEmpty()) {
                this.f8811f.e0("CameraRoomCustomFragment.TAG", null);
            } else {
                this.f8811f.e0("CameraRoomSelectFragment.TAG", null);
            }
        } else {
            this.f8811f.e0("CameraSetLocationFragment.TAG", null);
        }
    }

    private void I0() {
        ((FragmentCameraV2NameBinding) this.f8809c).f6916d.getEditText().addTextChangedListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(View view) {
        this.q.o2(20001);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_name;
    }

    /* renamed from: G0 */
    public CameraSetNameViewModel B0() {
        return (CameraSetNameViewModel) ViewModelProviders.of(this).get(CameraSetNameViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            H0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        ((FragmentCameraV2NameBinding) this.f8809c).q.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraSetNameFragment.this.K0(view2);
            }
        });
        this.q.R1();
        I0();
    }
}
