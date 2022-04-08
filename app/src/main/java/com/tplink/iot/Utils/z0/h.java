package com.tplink.iot.Utils.z0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import b.d.q.b.o;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.google.gson.k;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.y0.f;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.Utils.t;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import io.reactivex.q;

/* compiled from: CameraUtils.java */
/* loaded from: classes2.dex */
public class h {

    /* compiled from: CameraUtils.java */
    /* loaded from: classes2.dex */
    static class a implements TPLongMaterialDialogV2.d {
        final /* synthetic */ TPLongMaterialDialogV2 a;

        a(TPLongMaterialDialogV2 tPLongMaterialDialogV2) {
            this.a = tPLongMaterialDialogV2;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraUtils.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SdCardStatus.values().length];
            a = iArr;
            try {
                iArr[SdCardStatus.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SdCardStatus.INSUFFICIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SdCardStatus.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SdCardStatus.FORMATTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[SdCardStatus.UNFORMATTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static void A(Context context, ALCameraDevice aLCameraDevice, ImageView imageView, int i) {
        if (imageView != null) {
            int i2 = R.mipmap.iot_house_48;
            if (aLCameraDevice == null || context == null) {
                if (i == 1) {
                    i2 = R.mipmap.iot_house_36;
                } else if (i != 2) {
                    i2 = R.mipmap.iot_house_70;
                }
                imageView.setImageResource(i2);
            } else if (aLCameraDevice.isDefaultLocation()) {
                imageView.setImageResource(z4.a(context, aLCameraDevice.getDeviceLocation()));
            } else {
                String customLocationUrl = aLCameraDevice.getCustomLocationUrl();
                if (!TextUtils.isEmpty(customLocationUrl)) {
                    c.u(context).s(customLocationUrl).a(new g().f(j.a).f0(new f(i == 1 ? 18 : i == 2 ? 24 : 35))).x0(imageView);
                    return;
                }
                if (i == 1) {
                    i2 = R.mipmap.iot_house_36;
                } else if (i != 2) {
                    i2 = R.mipmap.iot_house_70;
                }
                imageView.setImageResource(i2);
            }
        }
    }

    public static boolean B(String str, DeviceModel deviceModel) {
        ALCameraDevice cameraDevice;
        TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
        if (K1 == null || (cameraDevice = K1.getCameraDevice()) == null || !cameraDevice.isUserRoleTypeDevice()) {
            return (com.tplink.iot.view.ipcamera.base.c.t(deviceModel) || com.tplink.iot.view.ipcamera.base.c.u(deviceModel) || com.tplink.iot.view.ipcamera.base.c.v(deviceModel)) && u.d(str) && !t.b(str) && t.a();
        }
        return false;
    }

    public static boolean C(String str) {
        ALCameraDevice cameraDevice;
        if (u.g(str)) {
            return false;
        }
        TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
        if (K1 != null && (cameraDevice = K1.getCameraDevice()) != null && cameraDevice.isUserRoleTypeDevice()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long c2 = u.c(str);
        if (c2 == -1 || currentTimeMillis - c2 < 604800000) {
            return false;
        }
        u.o(str, true);
        return (!u.a(str).booleanValue() || !u.e(str) || !u.f(str)) && d.e(str);
    }

    public static boolean D(String str) {
        ALCameraDevice cameraDevice;
        boolean z = !TextUtils.isEmpty(str) && d.c(str);
        TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
        return z && !((K1 == null || (cameraDevice = K1.getCameraDevice()) == null) ? false : cameraDevice.isUserRoleTypeDevice());
    }

    public static void E(Activity activity, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        ALCameraDevice aLCameraDevice = (ALCameraDevice) TPIoTClientManager.I1(str);
        if (aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null) {
            z3 = false;
            z2 = false;
            z = false;
        } else {
            z2 = aLCameraDevice.getCameraComponent().isSupportBabyCry();
            z = aLCameraDevice.getCameraComponent().hasComponent(ComponentType.TARGET_TRACK);
            z3 = aLCameraDevice.getCameraComponent().hasComponent(ComponentType.BLOCK_ZONE);
        }
        String string = activity.getString(R.string.ai_detection_baby_crying_detection);
        String string2 = activity.getString(R.string.target_track_title);
        String string3 = activity.getString(R.string.setting_privacy_mask);
        boolean z4 = z2 && !u.a(str).booleanValue();
        boolean z5 = z && !u.e(str);
        boolean z6 = z3 && !u.f(str);
        if (z4) {
            if (z5) {
                if (z6) {
                    Context applicationContext = activity.getApplicationContext();
                    str2 = applicationContext.getString(R.string.tapo_care_advanced_feature_alarm_hint_over_one, string + SSLClient.COMMA + string2, string3);
                } else {
                    str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_over_one, string, string2);
                }
            } else if (z6) {
                str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_over_one, string, string3);
            } else {
                str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_only_one, string);
            }
        } else if (z5) {
            if (z6) {
                str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_over_one, string2, string3);
            } else {
                str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_only_one, string2);
            }
        } else if (z6) {
            str2 = activity.getApplicationContext().getString(R.string.tapo_care_advanced_feature_alarm_hint_only_one, string3);
        } else {
            return;
        }
        TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
        TPLongMaterialDialogV2 a2 = builder.create();
        builder.g(str2).l(R.string.share_device_share_device_got_it, R.color.common_iot_main_blue, new a(a2)).d(8, 0).setCancelable(false).c(false).create();
        if (!a2.isShowing()) {
            a2.show();
            u.o(str, true);
        }
    }

    public static q<Integer> a(String str, boolean z, ComponentType componentType, com.tplink.libtpnetwork.Utils.f0.b<Boolean> bVar) {
        if (b(componentType, str)) {
            return q.f0(2);
        }
        return o(str, z, bVar);
    }

    public static boolean b(ComponentType componentType, String str) {
        return com.tplink.libtpnetwork.Utils.d.a(componentType, str);
    }

    public static q<Boolean> c(String str, com.tplink.libtpnetwork.Utils.f0.b<Boolean> bVar) {
        return d(str, true, bVar);
    }

    public static q<Boolean> d(String str, boolean z, final com.tplink.libtpnetwork.Utils.f0.b<Boolean> bVar) {
        String j = j(str);
        if (j == null) {
            return q.J(new Throwable("device id is null"));
        }
        final CloudVideoRepository cloudVideoRepository = (CloudVideoRepository) b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
        DeviceCloudProduct Z = cloudVideoRepository.Z(j);
        if (Z == null || !z) {
            return cloudVideoRepository.M(j).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.Utils.z0.e
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    h.t(b.this, (io.reactivex.e0.c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.Utils.z0.c
                @Override // io.reactivex.g0.a
                public final void run() {
                    h.u(b.this);
                }
            }).g0(new io.reactivex.g0.j() { // from class: com.tplink.iot.Utils.z0.f
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return Boolean.valueOf(CloudVideoRepository.this.k0((DeviceCloudProduct) obj));
                }
            }).q0(Boolean.valueOf(cloudVideoRepository.k0(cloudVideoRepository.K(j))));
        }
        return q.f0(Boolean.valueOf(cloudVideoRepository.k0(Z)));
    }

    public static k e(@Nullable BaseALIoTDevice baseALIoTDevice) {
        k kVar = new k();
        kVar.m("type", "SMART.IPCAMERA");
        if (baseALIoTDevice != null) {
            String deviceModel = baseALIoTDevice.getDeviceModel();
            kVar.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, baseALIoTDevice.getDeviceIdMD5());
            if (deviceModel != null) {
                kVar.m("model", deviceModel);
            }
        }
        return kVar;
    }

    public static k f(@Nullable TDPCameraDevice tDPCameraDevice) {
        return e(tDPCameraDevice == null ? null : new ALCameraDevice(tDPCameraDevice));
    }

    public static k g(@Nullable String str) {
        return e(str == null ? null : TPIoTClientManager.I1(str));
    }

    public static String h(Context context, ALCameraDevice aLCameraDevice) {
        if (context == null) {
            return "";
        }
        if (aLCameraDevice == null || TextUtils.isEmpty(aLCameraDevice.getDeviceLocation())) {
            return context.getString(R.string.onBoarding_set_location_home);
        }
        return z4.c(context, aLCameraDevice.getDeviceLocation(), aLCameraDevice.isDefaultLocation());
    }

    public static q<DeviceCloudProduct> i(String str, boolean z) {
        String j = j(str);
        if (j == null) {
            return q.J(new Throwable("device id is null"));
        }
        CloudVideoRepository cloudVideoRepository = (CloudVideoRepository) b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
        DeviceCloudProduct Z = cloudVideoRepository.Z(j);
        if (Z != null && z) {
            return q.f0(Z);
        }
        if (cloudVideoRepository.K(j) == null) {
            return cloudVideoRepository.M(j).L0(io.reactivex.l0.a.c());
        }
        return cloudVideoRepository.M(j).L0(io.reactivex.l0.a.c()).q0(cloudVideoRepository.K(j));
    }

    @Nullable
    public static String j(String str) {
        ALCameraDevice cameraDevice = TPIoTClientManager.K1(str).getCameraDevice();
        if (cameraDevice == null) {
            return null;
        }
        return cameraDevice.getDeviceId();
    }

    public static String k(String str) {
        TPCameraDeviceContext K1;
        ALCameraDevice cameraDevice;
        if (str == null || (K1 = TPIoTClientManager.K1(str)) == null || (cameraDevice = K1.getCameraDevice()) == null || cameraDevice.getBasicInfo() == null) {
            return null;
        }
        return cameraDevice.getBasicInfo().getDeviceId();
    }

    public static String l(String str) {
        return AppContext.f6185c.getString(R.string.setting_model) + ": " + str;
    }

    public static void m(String str) {
        com.tplink.libtpnetwork.Utils.d.b(str).F0();
    }

    public static ServiceList n(String str) {
        return com.tplink.libtpnetwork.Utils.d.c(str);
    }

    public static q<Integer> o(String str, boolean z, final com.tplink.libtpnetwork.Utils.f0.b<Boolean> bVar) {
        String j = j(str);
        if (j == null) {
            return q.J(new Throwable("device id is null"));
        }
        final CloudVideoRepository cloudVideoRepository = (CloudVideoRepository) b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
        DeviceCloudProduct Z = cloudVideoRepository.Z(j);
        final boolean s = s(str);
        if (Z == null || !z) {
            return cloudVideoRepository.M(j).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F(new io.reactivex.g0.g() { // from class: com.tplink.iot.Utils.z0.b
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    h.v(com.tplink.libtpnetwork.Utils.f0.b.this, (io.reactivex.e0.c) obj);
                }
            }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.Utils.z0.a
                @Override // io.reactivex.g0.a
                public final void run() {
                    h.w(b.this);
                }
            }).g0(new io.reactivex.g0.j() { // from class: com.tplink.iot.Utils.z0.d
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(CloudVideoRepository.this.g0((DeviceCloudProduct) obj, s));
                    return valueOf;
                }
            }).q0(Integer.valueOf(cloudVideoRepository.g0(cloudVideoRepository.K(j), s)));
        }
        return q.f0(Integer.valueOf(cloudVideoRepository.g0(Z, s)));
    }

    public static int p(Activity activity) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int a2 = o.a(activity, 200.0f);
        int i = (int) (displayMetrics.widthPixels / 1.7777778f);
        return a2 >= i ? a2 : i;
    }

    public static void q(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, VideoPlayActivity.class);
            intent.putExtra("device_id_md5", str);
            activity.startActivity(intent);
        }
    }

    public static boolean r(SdCardStatus sdCardStatus) {
        if (sdCardStatus == null) {
            return false;
        }
        int i = b.a[sdCardStatus.ordinal()];
        return false;
    }

    public static boolean s(String str) {
        SdCardInfoCache sdCardInfoCache;
        CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) e.c(str, CameraSettingRepository.class);
        ALCameraDevice cameraDevice = ((CommonCameraRepository) e.c(str, CommonCameraRepository.class)).b().getCameraDevice();
        if (cameraDevice == null || cameraDevice.getCameraComponent() == null || !cameraDevice.getCameraComponent().hasComponent(ComponentType.SD_CARD) || (sdCardInfoCache = cameraSettingRepository.x().getSdCardInfoCache()) == null) {
            return false;
        }
        return r(sdCardInfoCache.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(com.tplink.libtpnetwork.Utils.f0.b bVar, io.reactivex.e0.c cVar) throws Exception {
        if (bVar != null) {
            bVar.a(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(com.tplink.libtpnetwork.Utils.f0.b bVar) throws Exception {
        if (bVar != null) {
            bVar.a(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(com.tplink.libtpnetwork.Utils.f0.b bVar, io.reactivex.e0.c cVar) throws Exception {
        if (bVar != null) {
            bVar.a(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(com.tplink.libtpnetwork.Utils.f0.b bVar) throws Exception {
        if (bVar != null) {
            bVar.a(Boolean.FALSE);
        }
    }

    public static void y(Context context, ALCameraDevice aLCameraDevice, ImageView imageView) {
        A(context, aLCameraDevice, imageView, 1);
    }

    public static void z(Context context, ALCameraDevice aLCameraDevice, ImageView imageView) {
        A(context, aLCameraDevice, imageView, 2);
    }
}
