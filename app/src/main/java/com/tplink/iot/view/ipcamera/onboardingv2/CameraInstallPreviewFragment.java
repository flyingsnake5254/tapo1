package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.FragmentCameraV2InstallPreviewBinding;
import com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class CameraInstallPreviewFragment extends OnBoardingFragment<FragmentCameraV2InstallPreviewBinding, CameraInstallPreviewViewModel> {
    RelayLimitDialogFragment y;
    protected final io.reactivex.m0.d<Integer> x = io.reactivex.m0.d.n1();
    private boolean z = false;
    io.reactivex.e0.b p0 = new io.reactivex.e0.b();
    private String p1 = null;

    /* loaded from: classes2.dex */
    class a implements g<String> {
        a() {
        }

        /* renamed from: a */
        public void accept(String str) throws Exception {
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).i(str);
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).p0.b0();
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).i("");
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).p0.b0();
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            s0.g();
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).p0.e0();
            ((FragmentCameraV2InstallPreviewBinding) CameraInstallPreviewFragment.this.f8809c).p0.b0();
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            s0.p(CameraInstallPreviewFragment.this.getActivity(), CameraInstallPreviewFragment.this.getContext().getString(R.string.common_operation_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements RelayLimitDialogFragment.a {
        e() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment.a
        public void a() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment.a
        public void b() {
            CameraInstallPreviewFragment.this.x.onNext(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(Integer num) throws Exception {
        if (num.intValue() == LiveMediaAPI.getMultiDeviceTimeoutSeconds()) {
            O0(getString(R.string.live_page_relay_timeout_minutes_without_operation, Integer.valueOf(LiveMediaAPI.getMultiDeviceTimeoutSeconds() / 60)));
        } else if (num.intValue() == LiveMediaAPI.getSingleDeviceTimeoutSeconds()) {
            O0(getString(R.string.live_page_relay_timeout_minutes_without_operation, Integer.valueOf(LiveMediaAPI.getSingleDeviceTimeoutSeconds() / 60)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(DialogInterface dialogInterface) {
        this.z = false;
    }

    private void O0(String str) {
        if (!this.z) {
            this.z = true;
            RelayLimitDialogFragment relayLimitDialogFragment = new RelayLimitDialogFragment();
            this.y = relayLimitDialogFragment;
            relayLimitDialogFragment.L0(new e());
            this.y.K0(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.g0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CameraInstallPreviewFragment.this.N0(dialogInterface);
                }
            });
            this.y.J0(str);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.y.show(activity.getSupportFragmentManager(), "main.RelayLimitDialogFragment");
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_install_preview;
    }

    /* renamed from: G0 */
    public CameraInstallPreviewViewModel B0() {
        if (this.q.B() != null) {
            return (CameraInstallPreviewViewModel) new ViewModelProvider(this, new IoTViewModelFactory(this, this.q.B().getDeviceIdMd5())).get(CameraInstallPreviewViewModel.class);
        }
        return null;
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_other_helpful_items) {
            this.f8811f.e0("CameraInstallHelpfulItemsFragment.TAG", null);
        } else if (id == R.id.install_guide_reverse_preview) {
            s0.m(getActivity(), getString(R.string.common_waiting));
            ((CameraInstallPreviewViewModel) this.f8810d).m().H0(new c(), new d());
        } else if (id == R.id.quit) {
            this.f8811f.e0("CameraCompleteFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.p0.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"CheckResult"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.q.B() != null) {
            this.p1 = this.q.B().getDeviceIdMd5();
        }
        ((FragmentCameraV2InstallPreviewBinding) this.f8809c).x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraInstallPreviewFragment.this.I0(view2);
            }
        });
        ((FragmentCameraV2InstallPreviewBinding) this.f8809c).f6895d.getPaint().setFlags(8);
        ((FragmentCameraV2InstallPreviewBinding) this.f8809c).f6894c.getPaint().setFlags(8);
        String str = this.p1;
        if (str != null) {
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setDeviceIdMD5(str);
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setFullScreen(false);
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setIsHQ(true);
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setIsFocused(true);
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setFullScreen(false);
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).p0.setMultiScreen(false);
            this.p0.b(this.x.G0(new g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.h0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraInstallPreviewFragment.this.K0((Integer) obj);
                }
            }));
            ((FragmentCameraV2InstallPreviewBinding) this.f8809c).h(this.x);
            ((CameraInstallPreviewViewModel) this.f8810d).f().H0(new a(), new b());
        }
    }
}
