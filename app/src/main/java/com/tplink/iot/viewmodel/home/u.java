package com.tplink.iot.viewmodel.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.view.cloudvideo.CloudVideoListActivity;
import com.tplink.iot.view.home.DeviceOfflineTroubleshootingActivity;
import com.tplink.iot.view.ipcamera.play.CameraUpdatingDialogFragment;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.widget.ListContentDialog;
import com.tplink.iot.widget.ListContentLongDialog;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareUpdateLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeDialogUtils.java */
/* loaded from: classes2.dex */
public class u {
    private static WeakReference<CameraUpdatingDialogFragment> a;

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<ForcedUpdateFwDialog> f10133b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeDialogUtils.java */
    /* loaded from: classes2.dex */
    public static class a implements ForcedUpdateFwDialog.a {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10134b;

        a(Activity activity, String str) {
            this.a = activity;
            this.f10134b = str;
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void a() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void b() {
            FirmwareUpdateNewIpcActivity.g1(this.a, this.f10134b, false);
        }

        @Override // com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a
        public void c() {
            FirmwareUpdateNewIpcActivity.g1(this.a, this.f10134b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeDialogUtils.java */
    /* loaded from: classes2.dex */
    public static class b implements TPMaterialDialogV2.d {
        final /* synthetic */ TPMaterialDialogV2 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10135b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10136c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10137d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f10138e;

        b(TPMaterialDialogV2 tPMaterialDialogV2, Activity activity, String str, String str2, String str3) {
            this.a = tPMaterialDialogV2;
            this.f10135b = activity;
            this.f10136c = str;
            this.f10137d = str2;
            this.f10138e = str3;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.a;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
            }
            DeviceOfflineTroubleshootingActivity.p1(this.f10135b, this.f10136c, this.f10137d, this.f10138e);
        }
    }

    /* compiled from: HomeDialogUtils.java */
    /* loaded from: classes2.dex */
    static class c implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPMaterialDialogV2 f10139c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f10140d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f10141f;
        final /* synthetic */ String q;
        final /* synthetic */ String x;

        c(TPMaterialDialogV2 tPMaterialDialogV2, Activity activity, String str, String str2, String str3) {
            this.f10139c = tPMaterialDialogV2;
            this.f10140d = activity;
            this.f10141f = str;
            this.q = str2;
            this.x = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.f10139c;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
            }
            DeviceOfflineTroubleshootingActivity.p1(this.f10140d, this.f10141f, this.q, this.x);
        }
    }

    /* compiled from: HomeDialogUtils.java */
    /* loaded from: classes2.dex */
    static class d implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPMaterialDialogV2 f10142c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f10143d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f10144f;

        d(TPMaterialDialogV2 tPMaterialDialogV2, Activity activity, String str) {
            this.f10142c = tPMaterialDialogV2;
            this.f10143d = activity;
            this.f10144f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.f10142c;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
            }
            u.b(this.f10143d, this.f10144f);
        }
    }

    /* compiled from: HomeDialogUtils.java */
    /* loaded from: classes2.dex */
    static class e implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPMaterialDialogV2 f10145c;

        e(TPMaterialDialogV2 tPMaterialDialogV2) {
            this.f10145c = tPMaterialDialogV2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.f10145c;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
            }
        }
    }

    public static void A(Activity activity, String str) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            builder.j(str);
            builder.c(false);
            builder.setCancelable(false);
            builder.o(R.string.share_device_share_device_got_it, R.color.common_iot_main_blue, null);
            builder.g(8, 8);
            builder.create().show();
        }
    }

    public static void B(Activity activity, String str, TPLongMaterialDialogV2.d dVar) {
        y(activity, str, R.string.share_device_share_device_unable_share, dVar);
    }

    public static void C(Activity activity, String str, String str2) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            builder.t(str);
            builder.j(str2);
            builder.c(false);
            builder.setCancelable(false);
            builder.o(R.string.share_device_share_device_got_it, R.color.common_iot_light_black, null);
            builder.g(8, 8);
            builder.create().show();
        }
    }

    public static void D(Activity activity, String str, String str2, TPMaterialDialogV2.d dVar) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            builder.t(str);
            builder.j(str2);
            builder.c(false);
            builder.setCancelable(false);
            builder.o(R.string.share_device_share_device_need_help, R.color.common_iot_main_blue, dVar);
            builder.l(R.string.share_device_share_device_got_it, R.color.common_iot_light_black, null);
            builder.g(8, 8);
            builder.create().show();
        }
    }

    public static boolean E(Activity activity, String str, FragmentManager fragmentManager) {
        com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u g = ((FirmwareManager) b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class)).g(str);
        if (g == null) {
            return false;
        }
        if (!g.f()) {
            s(fragmentManager);
            return true;
        } else if (g.b() != FirmwareUpdateLevel.LEVEL4) {
            return false;
        } else {
            q(activity, str, fragmentManager);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, String str) {
        Intent intent = new Intent(activity, CloudVideoListActivity.class);
        intent.putExtra("cloud_video_device_id", str);
        activity.startActivity(intent);
    }

    private static void c(Activity activity, boolean z, boolean z2) {
        if (activity != null) {
            String string = activity.getString(R.string.device_home_unfavorite_in_all);
            if (z2 && z) {
                string = activity.getString(R.string.device_home_unfavorite_in_all_groups_device);
            } else if (z) {
                string = activity.getString(R.string.device_home_unfavorite_in_all_groups);
            }
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            builder.t(activity.getString(R.string.favorite_cancel));
            builder.j(string);
            builder.c(false);
            builder.setCancelable(false);
            builder.o(R.string.share_device_share_device_got_it, R.color.common_iot_main_blue, null);
            builder.g(8, 8);
            builder.create().show();
        }
    }

    public static void d(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            TPMaterialDialogV2 a2 = builder.create();
            View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_camera_offline_dialog, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_details).setOnClickListener(new c(a2, activity, str, str2, str3));
            inflate.findViewById(R.id.tv_cloud_video).setOnClickListener(new d(a2, activity, str4));
            inflate.findViewById(R.id.tv_cancel).setOnClickListener(new e(a2));
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            a2.show();
        }
    }

    public static void e(Activity activity, List<BaseALIoTDevice> list, String str, String str2) {
        i(activity, list, str, str2);
    }

    public static void f(Activity activity, String str) {
        g(activity, str, null);
    }

    public static void g(Activity activity, String str, TPMaterialDialogV2.d dVar) {
        String str2;
        if (activity != null) {
            if (TextUtils.isEmpty(str)) {
                str2 = activity.getString(R.string.act_locked_tip_content);
            } else {
                str2 = String.format(activity.getString(R.string.act_locked_tip_content2), b.d.w.h.a.a(str));
            }
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            TPMaterialDialogV2 a2 = builder.create();
            builder.t(activity.getString(R.string.act_locked_tip_title));
            builder.j(str2);
            builder.c(false);
            builder.setCancelable(false);
            builder.q(activity.getString(R.string.act_locked_tip_confirm), R.color.common_iot_main_blue, dVar);
            builder.g(8, 8);
            a2.show();
        }
    }

    public static void h(Activity activity, TPMaterialDialogV2.d dVar) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            builder.setMessage(R.string.camera_share_tip_permission_restricted);
            builder.c(false);
            builder.setCancelable(false);
            builder.o(R.string.share_device_share_device_got_it, R.color.common_iot_main_blue, dVar);
            builder.g(8, 8);
            builder.create().show();
        }
    }

    public static void i(Activity activity, List<BaseALIoTDevice> list, String str, String str2) {
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : list) {
                arrayList.add(l.e(activity, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            }
            ListContentDialog a2 = new ListContentDialog.Builder(activity).setTitle(str).b(str2).g(activity.getString(R.string.share_device_share_device_got_it)).d(arrayList).create();
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void j(Activity activity, String str, String str2, String str3) {
        k(activity, str, str2, str3, null);
    }

    public static void k(Activity activity, String str, String str2, String str3, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        if (activity != null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            TPMaterialDialogV2 a2 = builder.create();
            builder.setTitle(R.string.device_unreachable);
            builder.setMessage(R.string.device_offline_desc);
            builder.c(false);
            builder.setCancelable(false);
            builder.l(R.string.common_cancel, R.color.common_iot_light_black, null);
            builder.o(R.string.common_details, R.color.common_iot_main_blue, new b(a2, activity, str, str2, str3));
            builder.g(8, 8);
            a2.setOnDismissListener(onDismissListener);
            a2.show();
        }
    }

    public static void l(Activity activity, int i, long j, List<String> list, TPMaterialDialogV2.d dVar) {
        m(activity, true, i, j, list, dVar);
    }

    private static void m(Activity activity, boolean z, int i, long j, List<String> list, TPMaterialDialogV2.d dVar) {
        String str;
        String str2;
        if (activity != null) {
            if (z) {
                if (list != null && list.size() == 1) {
                    ALCameraDevice cameraDevice = TPIoTClientManager.K1(b.d.w.h.a.g(list.get(0))).getCameraDevice();
                    str2 = String.format(activity.getString(R.string.tapo_care_downgrade_handled_tip2), Integer.valueOf(i), b.d.w.a.a.a(j), cameraDevice != null ? cameraDevice.getDeviceName() : "");
                } else if (list != null) {
                    str2 = String.format(activity.getString(R.string.tapo_care_downgrade_handled_tip), Integer.valueOf(i), b.d.w.a.a.a(j), Integer.valueOf(list.size()));
                } else {
                    str2 = String.format(activity.getString(R.string.tapo_care_downgrade_handled_tip), Integer.valueOf(i), b.d.w.a.a.a(j), 0);
                }
                str = activity.getString(R.string.share_device_share_device_got_it);
            } else {
                str2 = String.format(activity.getString(R.string.tapo_care_downgrade_to_handle_tip), Integer.valueOf(i));
                str = activity.getString(R.string.select_camera);
            }
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
            TPMaterialDialogV2 a2 = builder.create();
            builder.j(str2);
            builder.c(false);
            builder.setCancelable(false);
            builder.q(str, R.color.common_iot_main_blue, dVar);
            builder.g(8, 8);
            a2.show();
        }
    }

    public static void n(Activity activity, int i, TPMaterialDialogV2.d dVar) {
        m(activity, false, i, -1L, null, dVar);
    }

    public static void o(Activity activity, String str, boolean z, boolean z2) {
        if (!o.h0().g0(str)) {
            o.h0().k1(str, true);
            c(activity, z, z2);
        }
    }

    public static void p(Activity activity, String str) {
        o(activity, str, false, true);
    }

    private static void q(Activity activity, String str, FragmentManager fragmentManager) {
        WeakReference<ForcedUpdateFwDialog> weakReference = f10133b;
        ForcedUpdateFwDialog forcedUpdateFwDialog = weakReference == null ? null : weakReference.get();
        if (forcedUpdateFwDialog == null) {
            forcedUpdateFwDialog = new ForcedUpdateFwDialog();
            f10133b = new WeakReference<>(forcedUpdateFwDialog);
        }
        if (!forcedUpdateFwDialog.isAdded()) {
            com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u g = ((FirmwareManager) b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class)).g(str);
            forcedUpdateFwDialog.A0(g != null ? g.a() : "");
            forcedUpdateFwDialog.B0(new a(activity, str));
            forcedUpdateFwDialog.show(fragmentManager, "ForcedUpdateFwDialog");
        }
    }

    public static void r(Activity activity, List<BaseALIoTDevice> list, ListContentLongDialog.e eVar) {
        if (activity != null) {
            x(activity, list, activity.getString(R.string.share_device_share_device_unable_share), eVar);
        }
    }

    private static void s(FragmentManager fragmentManager) {
        WeakReference<CameraUpdatingDialogFragment> weakReference = a;
        CameraUpdatingDialogFragment cameraUpdatingDialogFragment = weakReference == null ? null : weakReference.get();
        if (cameraUpdatingDialogFragment == null) {
            cameraUpdatingDialogFragment = new CameraUpdatingDialogFragment();
            a = new WeakReference<>(cameraUpdatingDialogFragment);
        }
        if (!cameraUpdatingDialogFragment.isAdded()) {
            cameraUpdatingDialogFragment.show(fragmentManager, "UpdatingDialog");
        }
    }

    public static void t(Activity activity, List<BaseALIoTDevice> list, String str, String str2) {
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : list) {
                arrayList.add(l.e(activity, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            }
            ListContentDialog a2 = new ListContentDialog.Builder(activity).setTitle(str).b(str2).g(activity.getString(R.string.share_device_share_device_got_it)).d(arrayList).create();
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void u(Activity activity, List<BaseALIoTDevice> list, String str, String str2, ListContentDialog.e eVar) {
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : list) {
                arrayList.add(l.e(activity, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            }
            ListContentDialog a2 = new ListContentDialog.Builder(activity).setTitle(str).b(str2).e(activity.getString(R.string.share_device_share_device_got_it)).g(activity.getString(R.string.share_device_share_device_need_help)).d(arrayList).f(eVar).create();
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void v(Activity activity, List<BaseALIoTDevice> list, ListContentLongDialog.e eVar) {
        if (activity != null) {
            x(activity, list, activity.getString(R.string.share_device_share_device_share_fail), eVar);
        }
    }

    public static void w(Activity activity, String str, TPLongMaterialDialogV2.d dVar) {
        y(activity, str, R.string.share_device_share_device_share_fail, dVar);
    }

    private static void x(Activity activity, List<BaseALIoTDevice> list, String str, ListContentLongDialog.e eVar) {
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : list) {
                arrayList.add(l.e(activity, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            }
            new ListContentLongDialog.Builder(activity).setTitle(str).b(com.tplink.iot.view.deviceshare.a.b(activity, list)).e(activity.getString(R.string.common_cancel)).g(activity.getString(R.string.share_device_share_device_manage_share)).d(arrayList).f(eVar).create().show();
        }
    }

    private static void y(Activity activity, String str, int i, TPLongMaterialDialogV2.d dVar) {
        if (activity != null) {
            String a2 = com.tplink.iot.view.deviceshare.a.a(activity, str);
            TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
            builder.setTitle(i);
            builder.g(a2);
            builder.c(false);
            builder.setCancelable(false);
            builder.l(R.string.share_device_share_device_manage_share, R.color.common_iot_main_blue, dVar);
            builder.i(R.string.common_cancel, R.color.common_iot_light_black, null);
            builder.d(8, 8);
            builder.create().show();
        }
    }

    public static void z(Activity activity, String str) {
        A(activity, str);
    }
}
