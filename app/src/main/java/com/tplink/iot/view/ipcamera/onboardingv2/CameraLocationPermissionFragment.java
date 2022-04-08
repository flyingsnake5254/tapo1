package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.databinding.FragmentCameraV2LocationPermissionBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationPermissionViewModel;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class CameraLocationPermissionFragment extends OnBoardingFragment<FragmentCameraV2LocationPermissionBinding, CameraLocationPermissionViewModel> {
    private com.tplink.iot.view.quicksetup.base.e p0;
    private TPMaterialDialogV2 p1;
    private Activity x;
    private TPMaterialDialogV2 y;
    private TPMaterialDialogV2 z;

    /* loaded from: classes2.dex */
    class a implements com.tplink.iot.view.quicksetup.base.wifi.a {
        a() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void a() {
            CameraLocationPermissionFragment.this.O0();
        }

        @Override // com.tplink.iot.view.quicksetup.base.wifi.a
        public void b() {
            CameraLocationPermissionFragment.this.L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraLocationPermissionFragment.this.z != null) {
                CameraLocationPermissionFragment.this.z.dismiss();
                CameraLocationPermissionFragment.this.O0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraLocationPermissionFragment.this.z != null) {
                CameraLocationPermissionFragment.this.z.dismiss();
            }
            ((CameraLocationPermissionViewModel) CameraLocationPermissionFragment.this.f8810d).g(true);
            CameraLocationPermissionFragment.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraLocationPermissionFragment.this.p1 != null) {
                CameraLocationPermissionFragment.this.p1.dismiss();
            }
            CameraLocationPermissionFragment.this.O0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tplink.iot.view.quicksetup.base.wifi.d.f(CameraLocationPermissionFragment.this.x);
            if (CameraLocationPermissionFragment.this.p1 != null) {
                CameraLocationPermissionFragment.this.p1.dismiss();
            }
            CameraLocationPermissionFragment.this.q.i2(true);
            CameraLocationPermissionFragment.this.f8811f.e0("CameraCheckStatusFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.c(this.x)) {
            com.tplink.iot.view.quicksetup.base.wifi.b.d(this);
        } else if (!com.tplink.iot.view.quicksetup.base.wifi.d.d(this.x)) {
            P0();
        } else if (!com.tplink.iot.view.quicksetup.base.wifi.d.e(this.x)) {
            Q0();
        } else {
            this.q.i2(true);
            this.f8811f.e0("CameraCheckStatusFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        this.q.i2(false);
        o.h0().h("has_refused_location_permission", true);
        this.f8811f.e0("CameraInstructionFragment.TAG", null);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_location_permission;
    }

    /* renamed from: N0 */
    public CameraLocationPermissionViewModel B0() {
        return (CameraLocationPermissionViewModel) ViewModelProviders.of(this).get(CameraLocationPermissionViewModel.class);
    }

    void P0() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.z;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this.x).inflate(R.layout.layout_ble_location_access, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new b());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new c());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this.x);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.z = a2;
            a2.show();
        }
    }

    void Q0() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p1;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this.x).inflate(R.layout.layout_wifi_on_new, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new d());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new e());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this.x);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.p1 = a2;
            a2.show();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.x = (Activity) context;
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            L0();
        } else if (id == R.id.img_back) {
            this.q.o2(20002);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TPMaterialDialogV2 tPMaterialDialogV2 = this.y;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.y = null;
        }
        TPMaterialDialogV2 tPMaterialDialogV22 = this.z;
        if (tPMaterialDialogV22 != null) {
            tPMaterialDialogV22.dismiss();
            this.z = null;
        }
        this.p0.b();
    }

    @Override // androidx.fragment.app.Fragment, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.tplink.iot.view.quicksetup.base.wifi.b.a(i, strArr, iArr, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (((CameraLocationPermissionViewModel) this.f8810d).f()) {
            if (!com.tplink.iot.view.quicksetup.base.wifi.d.d(this.x)) {
                O0();
            } else {
                L0();
            }
        }
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this.x)) {
            this.q.i2(true);
            this.f8811f.e0("CameraCheckStatusFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p0 = new com.tplink.iot.view.quicksetup.base.e(this.x);
    }
}
