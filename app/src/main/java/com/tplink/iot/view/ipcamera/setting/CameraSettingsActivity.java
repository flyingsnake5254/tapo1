package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.b;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBinding;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.ipcamera.setting.CameraSettingsActivity;
import com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog;
import com.tplink.iot.view.ipcamera.setting.detection.DetectionSettingActivity;
import com.tplink.iot.view.ipcamera.setting.privacymask.PrivacyMaskActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceSettingNewViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.g0.g;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraSettingsActivity extends BaseActivity implements View.OnClickListener, b.a {
    private Boolean H3;
    private DeviceSettingNewViewModel p0;
    private CloudVideoViewModel p1;
    private Activity p2;
    private io.reactivex.e0.b p3 = new io.reactivex.e0.b();
    private ActivityDeviceSettingNewIpcBinding y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DetectionCloseDialog.a {
        final /* synthetic */ DetectionCloseDialog a;

        a(DetectionCloseDialog detectionCloseDialog) {
            this.a = detectionCloseDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(Boolean bool) throws Exception {
            CameraSettingsActivity.this.p0.c0.set(false);
            CameraSettingsActivity.this.p0.l.set(false);
        }

        @Override // com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog.a
        public void a() {
            CameraSettingsActivity.this.p0.c0.set(true);
            CameraSettingsActivity.this.p0.g().G0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.v
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraSettingsActivity.a.this.d((Boolean) obj);
                }
            });
            this.a.dismiss();
        }

        @Override // com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog.a
        public void b() {
            this.a.dismiss();
            CameraSettingsActivity cameraSettingsActivity = CameraSettingsActivity.this;
            DetectionSettingActivity.s1(cameraSettingsActivity, cameraSettingsActivity.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<OrderInfo>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(List<OrderInfo> list) {
            CameraSettingsActivity cameraSettingsActivity = CameraSettingsActivity.this;
            cameraSettingsActivity.H3 = Boolean.valueOf(cameraSettingsActivity.p1.H(list, ""));
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<DeviceCloudProduct> {
        c() {
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            if (CameraSettingsActivity.this.p1.u(deviceCloudProduct)) {
                CameraSettingsActivity cameraSettingsActivity = CameraSettingsActivity.this;
                BillingDialogActivity.f1(cameraSettingsActivity, e.g(h.k(cameraSettingsActivity.z)));
            } else if (CameraSettingsActivity.this.H3.booleanValue()) {
                BillingDialogActivity.f1(CameraSettingsActivity.this, e.x());
            } else {
                CameraSettingsActivity cameraSettingsActivity2 = CameraSettingsActivity.this;
                BillingDialogActivity.f1(cameraSettingsActivity2, e.g(h.k(cameraSettingsActivity2.z)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<List<OrderInfo>> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(List<OrderInfo> list) {
            CameraSettingsActivity.this.p1.N().removeObserver(this);
            if (CameraSettingsActivity.this.p1.H(list, "")) {
                BillingDialogActivity.f1(CameraSettingsActivity.this.p2, e.x());
            } else {
                BillingDialogActivity.f1(CameraSettingsActivity.this.p2, e.r(CameraSettingsActivity.this.p0.i()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1 */
    public /* synthetic */ void B1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        if (aVar != null) {
            String str = (String) aVar.a();
            if ("empty".equals(str)) {
                b.d.w.c.a.e("CameraSettingsActivity", "record schedule is empty!!!");
                this.p0.l1();
            } else if ("both".equals(str) && !this.p0.s()) {
                b.d.w.c.a.e("CameraSettingsActivity", "record schedule has both detect and record!!!");
                new UniversalDialog.a().q(getString(R.string.device_setting_detetion_close_msg_v2)).u(getString(R.string.video_control_detection_enable)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.g0
                    @Override // com.tplink.iot.widget.UniversalDialog.c
                    public final void a() {
                        CameraSettingsActivity.this.F1();
                    }
                }).l().show(getSupportFragmentManager(), "");
            } else if ("detect".equals(str) && !this.p0.s()) {
                b.d.w.c.a.e("CameraSettingsActivity", "record schedule has detect only!!!");
                DetectionCloseDialog detectionCloseDialog = new DetectionCloseDialog();
                detectionCloseDialog.H0(new a(detectionCloseDialog));
                detectionCloseDialog.show(getSupportFragmentManager(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1 */
    public /* synthetic */ void D1(Boolean bool) {
        if (bool.booleanValue()) {
            TrialDialogActivity.f1(this, e.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E1 */
    public /* synthetic */ void F1() {
        DetectionSettingActivity.s1(this, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1 */
    public /* synthetic */ void H1(Boolean bool) {
        this.p0.c0.set(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I1 */
    public /* synthetic */ void J1(Integer num) throws Exception {
        this.p0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1 */
    public /* synthetic */ void M1(Boolean bool) {
        this.p0.c0.set(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N1 */
    public /* synthetic */ void O1(Integer num) throws Exception {
        this.p0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q1 */
    public /* synthetic */ void R1(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S1 */
    public /* synthetic */ void T1(Boolean bool) {
        this.p0.c0.set(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1 */
    public /* synthetic */ void V1(Integer num) throws Exception {
        int intValue = num.intValue();
        if (intValue == 1) {
            TrialDialogActivity.f1(this, e.s(this.p0.i()));
            w.i(b.d.w.h.a.g(this.p0.i()));
        } else if (intValue == 2) {
            Intent intent = new Intent(this, PrivacyMaskActivity.class);
            intent.putExtra("device_id_md5", this.z);
            startActivity(intent);
        } else if (intValue != 3) {
            BillingDialogActivity.f1(this, e.r(this.p0.i()));
        } else {
            l2();
            w.h(b.d.w.h.a.g(this.p0.i()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(Throwable th) throws Exception {
        if (th instanceof IoTCloudException) {
            BillingDialogActivity.f1(this, e.r(this.p0.i()));
        } else {
            TSnackbar.x(this, R.string.common_operation_failed, -1).N();
        }
        b.d.w.c.a.e("CameraSettingsActivity", Log.getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y1 */
    public /* synthetic */ void Z1(Boolean bool) {
        this.p0.c0.set(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public /* synthetic */ void b2(Integer num) throws Exception {
        this.p0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void e2(com.tplink.libtpmediaother.database.model.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.i())) {
            this.p0.J.set(false);
            this.y.z.setImageResource(R.drawable.preload);
            return;
        }
        this.p0.J.set(true);
        com.bumptech.glide.c.u(getApplication()).s(cVar.i()).x0(this.y.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ void g2() {
        this.p0.h1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2 */
    public /* synthetic */ void i2(boolean z) {
        if (z) {
            this.p0.f(this.z);
        } else {
            this.p0.j1();
        }
    }

    public static void j2(Context context, String str, boolean z) {
        Intent intent = new Intent(context, CameraSettingsActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("online", z);
        context.startActivity(intent);
    }

    private void k1() {
        this.y.K3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingsActivity.this.o1(view);
            }
        });
        this.y.c4.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingsActivity.this.q1(view);
            }
        });
        this.y.f4.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingsActivity.this.s1(view);
            }
        });
        this.y.p4.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingsActivity.this.u1(view);
            }
        });
    }

    public static void k2(Context context, String str, boolean z, boolean z2) {
        Intent intent = new Intent(context, CameraSettingsActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("online", z2);
        intent.putExtra("video_play", z);
        context.startActivity(intent);
    }

    private int l1(ALCameraDevice aLCameraDevice) {
        int size = (aLCameraDevice == null || aLCameraDevice.getDeviceManagerInfo() == null || aLCameraDevice.getDeviceManagerInfo().getUserInfo() == null) ? 0 : aLCameraDevice.getDeviceManagerInfo().getUserInfo().size() - 1;
        if (size == -1) {
            return 0;
        }
        return size;
    }

    private void m1() {
        this.p0.G.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.f0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSettingsActivity.this.B1((a) obj);
            }
        });
        this.p0.H.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.j0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSettingsActivity.this.D1((Boolean) obj);
            }
        });
        this.p1.N().observe(this, new b());
        j.c(this.p0.E, this, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.y
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CameraSettingsActivity.this.x1((String) obj);
            }
        });
        this.p0.o1(this);
        this.p0.F.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSettingsActivity.this.z1((Boolean) obj);
            }
        });
    }

    private void m2() {
        this.p3.b(h.a(this.z, true, ComponentType.BLOCK_ZONE, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.k0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CameraSettingsActivity.this.T1((Boolean) obj);
            }
        }).H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.a0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingsActivity.this.V1((Integer) obj);
            }
        }, new g() { // from class: com.tplink.iot.view.ipcamera.setting.x
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingsActivity.this.X1((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(View view) {
        if (this.p0.z.get()) {
            ObservableBoolean observableBoolean = this.p0.k;
            observableBoolean.set(!observableBoolean.get());
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
            return;
        }
        this.p0.b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        l.e(this.z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.w
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CameraSettingsActivity.this.e2((c) obj);
            }
        });
    }

    private void o2() {
        if (this.p0.I.get()) {
            this.p0.t();
            return;
        }
        this.p0.c0.set(false);
        this.p0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(View view) {
        if (this.p0.z.get()) {
            ObservableBoolean observableBoolean = this.p0.l;
            observableBoolean.set(!observableBoolean.get());
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
            return;
        }
        this.p0.c1();
    }

    private void p2() {
        new UniversalDialog.a().q(getString(R.string.device_setting_reboot_tips)).s(getString(R.string.common_cancel)).u(getString(R.string.device_setting_reboot)).m(true).v(getResources().getColor(R.color.common_iot_red)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.e0
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                CameraSettingsActivity.this.g2();
            }
        }).l().show(getSupportFragmentManager(), "");
    }

    private void q2() {
        String str;
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(this.z).getCameraDevice();
        final boolean z = cameraDevice == null || cameraDevice.isUserRoleTypeDevice();
        int l1 = l1(cameraDevice);
        if (z) {
            str = getString(R.string.share_device_share_device_no_longer);
        } else if (l1 == 0) {
            str = getString(R.string.share_device_share_device_no_longer);
        } else {
            str = l1 == 1 ? getString(R.string.share_device_share_device_title_user, new Object[]{String.valueOf(l1)}) : getString(R.string.share_device_share_device_title_deletes, new Object[]{String.valueOf(l1)});
        }
        new UniversalDialog.a().q(str).s(getString(R.string.common_cancel)).u(getString(R.string.setting_remove_camera)).m(true).v(getResources().getColor(R.color.common_iot_red)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.z
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                CameraSettingsActivity.this.i2(z);
            }
        }).l().show(getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(View view) {
        if (this.p0.z.get()) {
            ObservableBoolean observableBoolean = this.p0.j;
            observableBoolean.set(!observableBoolean.get());
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
            return;
        }
        this.p0.a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1(View view) {
        if (this.p0.z.get()) {
            ObservableBoolean observableBoolean = this.p0.i;
            observableBoolean.set(!observableBoolean.get());
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
            return;
        }
        if (!this.p0.i.get()) {
            this.p0.o(this, this.z);
        } else {
            this.p0.p(this, this.z);
        }
        this.p0.i.set(this.y.r4.isChecked());
        w.t(this.z, !this.p0.i.get(), (int) this.p0.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ void x1(String str) {
        TSnackbar.y(this, str, PathInterpolatorCompat.MAX_NUM_POINTS).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y1 */
    public /* synthetic */ void z1(Boolean bool) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override // com.tplink.iot.Utils.v0.b.a
    public void D0() {
        this.p3.b(h.o(this.z, false, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.p0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                CameraSettingsActivity.this.Z1((Boolean) obj);
            }
        }).H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.n0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSettingsActivity.this.b2((Integer) obj);
            }
        }, h0.f9242c));
    }

    public void l2() {
        this.p1.N().observe(this, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1345) {
            this.p3.b(h.o(this.z, false, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.t0
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    CameraSettingsActivity.this.H1((Boolean) obj);
                }
            }).H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.u0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraSettingsActivity.this.J1((Integer) obj);
                }
            }, b0.f9192c));
            com.tplink.iot.Utils.v0.b.a().b();
        } else if (i == 1346) {
            this.p3.b(h.o(this.z, false, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.q0
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    CameraSettingsActivity.this.M1((Boolean) obj);
                }
            }).H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.l0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    CameraSettingsActivity.this.O1((Integer) obj);
                }
            }, r0.f9285c));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (!this.p0.z.get() || id == R.id.main_info || id == R.id.unbind) {
            switch (view.getId()) {
                case R.id.advanced_item /* 2131361944 */:
                    Intent intent = new Intent(this, AdvancedSettingActivity.class);
                    intent.putExtra("device_id_md5", this.z);
                    startActivity(intent);
                    return;
                case R.id.auto_reboot /* 2131361988 */:
                    AutoRebootActivity.t1(this, this.z);
                    return;
                case R.id.cloud_item /* 2131362257 */:
                    w.l(this.z);
                    h.i(this.z, true).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new c()).F0();
                    return;
                case R.id.detection /* 2131362401 */:
                    DetectionSettingActivity.s1(this, this.z);
                    return;
                case R.id.location_offline /* 2131363375 */:
                case R.id.location_online /* 2131363376 */:
                    if (this.p0.I.get()) {
                        ALCameraDevice aLCameraDevice = this.p0.h0;
                        if (aLCameraDevice == null || !aLCameraDevice.isFirmwareSupportIoTCloud()) {
                            LocationSettingActivity.j1(this, this.z, this.p0.f10728b.get());
                            return;
                        } else if (this.p0.f10729c.get()) {
                            IoTSettingLocationSelectActivity.o1(this, this.p0.i());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case R.id.main_info /* 2131363399 */:
                    Intent intent2 = new Intent(this, DeviceDetailInfoActivity.class);
                    intent2.putExtra("device_id_md5", this.z);
                    intent2.putExtra("online", this.p0.I.get());
                    startActivity(intent2);
                    return;
                case R.id.night_vision /* 2131363544 */:
                    b5.a(this, this.z);
                    return;
                case R.id.nv_white_lamp_config /* 2131363568 */:
                    X0(WhiteLampConfigActivity.class, this.z);
                    return;
                case R.id.offline_unbind /* 2131363579 */:
                case R.id.unbind /* 2131364738 */:
                    q2();
                    return;
                case R.id.privacy_mask_item /* 2131363696 */:
                    m2();
                    return;
                case R.id.recording_schedule /* 2131363797 */:
                    ScheduleSettingActivity.j1(this, this.z);
                    return;
                case R.id.restart /* 2131363844 */:
                    p2();
                    return;
                case R.id.sdcard /* 2131363979 */:
                    if (!TextUtils.isEmpty(this.p0.x.get())) {
                        Intent intent3 = new Intent(this, StoreManageActivity.class);
                        intent3.putExtra("device_id_md5", this.z);
                        startActivity(intent3);
                        return;
                    }
                    return;
                case R.id.share_item /* 2131364037 */:
                    ShareDeviceUserListActivity.v1(this, this.z);
                    return;
                case R.id.timezone /* 2131364242 */:
                    if (this.p0.x()) {
                        Intent intent4 = new Intent(this, TimezoneActivity.class);
                        intent4.putExtra("device_id_md5", this.z);
                        startActivity(intent4);
                        return;
                    }
                    return;
                case R.id.video_quality /* 2131364773 */:
                    com.tplink.iot.view.ipcamera.setting.video.a.a(this, this.z);
                    return;
                default:
                    return;
            }
        } else {
            Toast.makeText(this, (int) R.string.camera_share_tip_no_permission, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p2 = this;
        this.z = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityDeviceSettingNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_device_setting_new_ipc);
        this.p0 = (DeviceSettingNewViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, this.z)).get(DeviceSettingNewViewModel.class);
        this.p1 = (CloudVideoViewModel) ViewModelProviders.of(this).get(CloudVideoViewModel.class);
        this.y.i(this.p0);
        this.y.h(this);
        setSupportActionBar(this.y.o4);
        this.y.o4.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingsActivity.this.R1(view);
            }
        });
        this.p0.I.set(getIntent().getBooleanExtra("online", false));
        this.p0.e0.set(getIntent().getBooleanExtra("video_play", false));
        this.p0.c0.set(true);
        new Handler().postDelayed(new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.o0
            @Override // java.lang.Runnable
            public final void run() {
                CameraSettingsActivity.this.n2();
            }
        }, 1000L);
        m1();
        this.p0.w();
        k1();
        com.tplink.iot.Utils.v0.b.a().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tplink.iot.Utils.v0.b.a().d(this);
        io.reactivex.e0.b bVar = this.p3;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return false;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.p0.k();
        this.p0.i1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        o2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        io.reactivex.e0.c cVar = this.p0.d0;
        if (cVar != null) {
            cVar.dispose();
        }
    }
}
