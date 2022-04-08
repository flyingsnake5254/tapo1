package com.tplink.iot.view.quicksetup.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.view.feedback.DeviceTypeListActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: QuickSetupUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* compiled from: QuickSetupUtils.java */
    /* loaded from: classes2.dex */
    static class a implements d0.g {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            t0.f(this.a, "XP2ePdLatwg");
        }
    }

    /* compiled from: QuickSetupUtils.java */
    /* loaded from: classes2.dex */
    static class b implements d0.f {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9523b;

        b(Activity activity, String str) {
            this.a = activity;
            this.f9523b = str;
        }

        @Override // com.tplink.iot.Utils.d0.f
        public void a() {
            d.F(this.a, this.f9523b);
        }
    }

    /* compiled from: QuickSetupUtils.java */
    /* loaded from: classes2.dex */
    static class c implements d0.g {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9524b;

        c(Activity activity, String str) {
            this.a = activity;
            this.f9524b = str;
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            d.F(this.a, this.f9524b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickSetupUtils.java */
    /* renamed from: com.tplink.iot.view.quicksetup.base.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0233d implements d0.g {
        final /* synthetic */ DeviceModel a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f9525b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TDPCameraDevice f9526c;

        C0233d(DeviceModel deviceModel, Activity activity, TDPCameraDevice tDPCameraDevice) {
            this.a = deviceModel;
            this.f9525b = activity;
            this.f9526c = tDPCameraDevice;
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            DeviceModel deviceModel = this.a;
            t0.f(this.f9525b, (deviceModel == DeviceModel.CAMERA_C310 || deviceModel == DeviceModel.CAMERA_C320WS || deviceModel == DeviceModel.CAMERA_TC65) ? d.l() : d.k(deviceModel));
            com.tplink.iot.Utils.x0.f.o(this.f9526c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickSetupUtils.java */
    /* loaded from: classes2.dex */
    public static class e implements d0.f {
        final /* synthetic */ Activity a;

        e(Activity activity) {
            this.a = activity;
        }

        @Override // com.tplink.iot.Utils.d0.f
        public void a() {
            d.G(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickSetupUtils.java */
    /* loaded from: classes2.dex */
    public static class f implements TPMaterialDialogV2.d {
        final /* synthetic */ TPMaterialDialogV2.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f9527b;

        f(TPMaterialDialogV2.d dVar, FragmentActivity fragmentActivity) {
            this.a = dVar;
            this.f9527b = fragmentActivity;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            TPMaterialDialogV2.d dVar = this.a;
            if (dVar != null) {
                dVar.onClick(view);
            }
            d.H(this.f9527b);
        }
    }

    public static int A(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int B(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "sunrise_sunset");
    }

    public static void C(Activity activity, Class cls, QuickSetupInfoBean quickSetupInfoBean, QuickSetupDeviceInfoBean quickSetupDeviceInfoBean) {
        if (activity != null && cls != null) {
            Intent intent = new Intent(activity, cls);
            Bundle bundle = new Bundle();
            bundle.putSerializable("device_info_bean", quickSetupInfoBean);
            if (quickSetupDeviceInfoBean != null) {
                bundle.putSerializable("device_info", quickSetupDeviceInfoBean);
            }
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }

    public static void D(Activity activity, Class cls, QuickSetupInfoBean quickSetupInfoBean, WirelessInfoParams wirelessInfoParams) {
        if (activity != null && cls != null) {
            Intent intent = new Intent(activity, cls);
            Bundle bundle = new Bundle();
            bundle.putSerializable("device_info_bean", quickSetupInfoBean);
            if (wirelessInfoParams != null) {
                bundle.putSerializable("ap_ssid", wirelessInfoParams);
            }
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }

    public static void E(Activity activity, Class cls, QuickSetupInfoBean quickSetupInfoBean, WirelessInfoParams wirelessInfoParams, int i) {
        if (activity != null && cls != null) {
            Intent intent = new Intent(activity, cls);
            Bundle bundle = new Bundle();
            bundle.putSerializable("device_info_bean", quickSetupInfoBean);
            if (wirelessInfoParams != null) {
                bundle.putSerializable("ap_ssid", wirelessInfoParams);
            }
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void F(android.app.Activity r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.quicksetup.base.d.F(android.app.Activity, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Activity activity) {
        activity.startActivity(new Intent(activity, DeviceTypeListActivity.class));
    }

    public static void H(FragmentActivity fragmentActivity) {
        Intent intent = new Intent(fragmentActivity, MainActivity.class);
        intent.addFlags(67108864);
        fragmentActivity.startActivity(intent);
        fragmentActivity.finish();
    }

    public static void I(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && inputMethodManager.isActive() && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void J(Activity activity, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (i >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
            } else {
                activity.getWindow().addFlags(67108864);
            }
            view.getLayoutParams().height += A(activity);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + A(activity), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void K(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (i >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
                return;
            }
            activity.getWindow().addFlags(67108864);
        }
    }

    public static boolean L(QuickSetupInfoBean quickSetupInfoBean) {
        return quickSetupInfoBean != null && i(quickSetupInfoBean.getComponentResult()) > 0;
    }

    public static boolean M(String str) {
        return !TextUtils.isEmpty(str) && str.matches("Tapo_Bulb_[A-Fa-f0-9]{4}");
    }

    public static boolean N(String str) {
        return str != null && str.equals(p());
    }

    public static boolean O(String str, String str2) {
        return R(str, str2);
    }

    public static boolean P(Integer num, Integer num2) {
        if (num == null || num2 == null) {
            return false;
        }
        return (num.intValue() == 0 && num2.intValue() == 0) ? false : true;
    }

    private static boolean Q(String str, EnumDeviceType enumDeviceType, String str2) {
        String str3 = "Bulb";
        if (EnumDeviceType.PLUG == enumDeviceType) {
            str3 = "Plug";
        } else if (EnumDeviceType.BULB == enumDeviceType) {
            if (com.tplink.iot.g.b.c.c.i(str2)) {
                str3 = "Light Strip";
            }
        } else if (EnumDeviceType.HUB == enumDeviceType) {
            str3 = "Hub";
        }
        return !TextUtils.isEmpty(str) && str.matches(String.format("Tapo_%s_[A-Fa-f0-9]{4}", str3));
    }

    public static boolean R(String str, String str2) {
        return Q(str, com.tplink.iot.view.quicksetup.bulb.utils.b.l(str2), str2);
    }

    private static boolean S(Activity activity) {
        Display defaultDisplay = activity.getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        View decorView = activity.getWindow().getDecorView();
        if (2 == activity.getResources().getConfiguration().orientation) {
            if (point.x != decorView.findViewById(16908290).getWidth()) {
                return true;
            }
        } else {
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            if (rect.bottom != point.y) {
                return true;
            }
        }
        return false;
    }

    public static boolean T(String str) {
        return !TextUtils.isEmpty(str) && str.matches("Tapo_Plug_[A-Fa-f0-9]{4}");
    }

    public static boolean U(Context context) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        if (Build.VERSION.SDK_INT < 21 || powerManager == null) {
            return false;
        }
        return powerManager.isPowerSaveMode();
    }

    public static boolean V(String str, String str2) {
        if (str2 != null) {
            if (str2.equals(SSLClient.DOUBLE_QUOTATION + str + SSLClient.DOUBLE_QUOTATION)) {
                return true;
            }
        }
        return false;
    }

    public static boolean W(QuickSetupInfoBean quickSetupInfoBean) {
        return quickSetupInfoBean != null && w(quickSetupInfoBean.getComponentResult()) > 0;
    }

    public static boolean X(CommonQuickSetupBean commonQuickSetupBean) {
        return commonQuickSetupBean != null && w(commonQuickSetupBean.getComponentResult()) > 0;
    }

    public static boolean Y(QuickSetupInfoBean quickSetupInfoBean) {
        return quickSetupInfoBean != null && B(quickSetupInfoBean.getComponentResult()) > 0;
    }

    public static void Z(QuickSetupInfoBean quickSetupInfoBean, String str) {
        if (quickSetupInfoBean != null) {
            r.g(quickSetupInfoBean.getDeviceType(), quickSetupInfoBean.getDeviceModel(), str);
        }
    }

    public static void a0(Activity activity, TextView textView, DeviceModel deviceModel, TDPCameraDevice tDPCameraDevice) {
        d0(activity, textView, deviceModel, tDPCameraDevice);
    }

    public static void b0(Activity activity, int i) {
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(activity.getResources().getColor(i));
                return;
            }
            StatusBarUtils.n(activity, ContextCompat.getColor(activity, i));
        }
    }

    public static void c0(Activity activity, TextView textView, String str) {
        if (activity != null && textView != null) {
            if (!x.b() || !"P100".equals(str)) {
                String upperCase = activity.getString(R.string.quicksetup_common_contact_us_end).toUpperCase();
                d0.c(textView, activity.getString(R.string.quicksetup_common_contact_us_problem, new Object[]{upperCase}), upperCase, ContextCompat.getColor(activity, R.color.common_iot_purple), new c(activity, str));
                return;
            }
            d0.f(activity, textView, R.string.onboarding_fail_faq_tips, activity.getString(R.string.onboarding_video_guide), activity.getString(R.string.quicksetup_common_contact_us_end), ContextCompat.getColor(activity, R.color.common_iot_purple), ContextCompat.getColor(activity, R.color.common_iot_purple), new a(activity), new b(activity, str));
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        }
    }

    private static void d0(Activity activity, TextView textView, DeviceModel deviceModel, TDPCameraDevice tDPCameraDevice) {
        if (activity != null && textView != null) {
            d0.f(activity, textView, R.string.onboarding_fail_faq_tips, activity.getString(R.string.onboarding_video_guide), activity.getString(R.string.quicksetup_common_contact_us_end), ContextCompat.getColor(activity, R.color.common_iot_purple), ContextCompat.getColor(activity, R.color.common_iot_purple), new C0233d(deviceModel, activity, tDPCameraDevice), new e(activity));
        }
    }

    public static void e(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = A(activity);
            view.setLayoutParams(layoutParams);
        }
    }

    public static void e0(FragmentActivity fragmentActivity, TPMaterialDialogV2.d dVar) {
        f0(fragmentActivity, dVar);
    }

    private static boolean f(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    private static TPMaterialDialogV2 f0(FragmentActivity fragmentActivity, TPMaterialDialogV2.d dVar) {
        if (fragmentActivity == null || fragmentActivity.isDestroyed() || fragmentActivity.isFinishing()) {
            return null;
        }
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(fragmentActivity).j(fragmentActivity.getString(R.string.quicksetup_quit_message_exit)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.quicksetup_plug_exit, R.color.common_iot_main_blue, new f(dVar, fragmentActivity)).g(8, 8).setCancelable(false).c(false).create();
        a2.show();
        return a2;
    }

    public static boolean g(String str, String str2) {
        if (!b.d.w.e.b.c(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        if (str2.length() >= 8 && str2.length() <= 64) {
            return b.d.w.e.b.b(str2);
        }
        return false;
    }

    public static TPMaterialDialogV2 g0(FragmentActivity fragmentActivity) {
        return h0(fragmentActivity, null);
    }

    public static void h(QuickSetupInfoBean quickSetupInfoBean) {
        if (quickSetupInfoBean != null && quickSetupInfoBean.getDeviceIdMD5() != null) {
            ((QuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(quickSetupInfoBean.getDeviceIdMD5(), QuickSetupRepository.class)).h5();
        }
    }

    public static TPMaterialDialogV2 h0(FragmentActivity fragmentActivity, TPMaterialDialogV2.d dVar) {
        return f0(fragmentActivity, dVar);
    }

    public static int i(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "ble_whole_setup");
    }

    public static void i0(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && inputMethodManager.isActive() && activity.getCurrentFocus() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    public static int j(Activity activity) {
        Resources resources = activity.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        boolean z = true;
        if (1 != activity.getResources().getConfiguration().orientation) {
            z = false;
        }
        if (identifier <= 0 || !z || !f(activity) || !S(activity)) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(DeviceModel deviceModel) {
        return x.b() ? (deviceModel == DeviceModel.CAMERA_C100 || deviceModel == DeviceModel.CAMERA_C110 || deviceModel == DeviceModel.CAMERA_C200 || deviceModel == DeviceModel.CAMERA_C210 || deviceModel == DeviceModel.CAMERA_TC70) ? "OCI_HUkCINs" : "lNIPpRBnt4s" : "lNIPpRBnt4s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l() {
        return x.b() ? "Ib7m7fBpewE" : "jff3lyZkGis";
    }

    private static int m(QuickSetupComponentResult quickSetupComponentResult, String str) {
        List<QuickSetupComponentBean> componentList;
        if (quickSetupComponentResult == null || (componentList = quickSetupComponentResult.getComponentList()) == null || componentList.isEmpty()) {
            return 0;
        }
        return n(o(componentList), str);
    }

    private static int n(HashMap<String, Integer> hashMap, String str) {
        Integer num;
        if (hashMap == null || TextUtils.isEmpty(str) || !hashMap.containsKey(str) || (num = hashMap.get(str)) == null) {
            return 0;
        }
        return Math.max(num.intValue(), 0);
    }

    private static HashMap<String, Integer> o(List<QuickSetupComponentBean> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (QuickSetupComponentBean quickSetupComponentBean : list) {
                hashMap.put(quickSetupComponentBean.getId(), Integer.valueOf(quickSetupComponentBean.getVerCode()));
            }
        }
        return hashMap;
    }

    public static String p() {
        int i;
        String l = com.tplink.libtpwifi.b.k().l();
        if (l == null || l.isEmpty()) {
            return "";
        }
        if ("<unknown ssid>".equals(l)) {
            return "<unknown ssid>";
        }
        int length = l.length();
        return (length > 2 && l.indexOf(SSLClient.DOUBLE_QUOTATION) == 0 && l.lastIndexOf(SSLClient.DOUBLE_QUOTATION) == (i = length - 1)) ? l.substring(1, i) : l;
    }

    public static String q(QuickSetupInfoBean quickSetupInfoBean) {
        QuickSetupComponentResult componentResult;
        QuickSetupComponentExtraInfoBean extraInfo;
        if (quickSetupInfoBean == null || (componentResult = quickSetupInfoBean.getComponentResult()) == null || (extraInfo = componentResult.getExtraInfo()) == null) {
            return null;
        }
        return extraInfo.getDeviceModel();
    }

    public static String r(CommonQuickSetupBean commonQuickSetupBean) {
        QuickSetupComponentResult componentResult;
        QuickSetupComponentExtraInfoBean extraInfo;
        if (commonQuickSetupBean == null || (componentResult = commonQuickSetupBean.getComponentResult()) == null || (extraInfo = componentResult.getExtraInfo()) == null) {
            return null;
        }
        return extraInfo.getDeviceModel();
    }

    public static EnumDeviceType s(CommonQuickSetupBean commonQuickSetupBean) {
        QuickSetupComponentResult componentResult;
        QuickSetupComponentExtraInfoBean extraInfo;
        if (commonQuickSetupBean == null || (componentResult = commonQuickSetupBean.getComponentResult()) == null || (extraInfo = componentResult.getExtraInfo()) == null) {
            return null;
        }
        return EnumDeviceType.fromType(extraInfo.getDeviceType());
    }

    public static String t(String str) {
        if (b.e().contains(str)) {
            return EnumDeviceType.PLUG.getDeviceType();
        }
        if (b.a().contains(str)) {
            return EnumDeviceType.BULB.getDeviceType();
        }
        return EnumDeviceType.PLUG.getDeviceType();
    }

    public static int u(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "firmware");
    }

    public static int v(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "inherit");
    }

    public static int w(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "iot_cloud");
    }

    public static int x(QuickSetupComponentResult quickSetupComponentResult) {
        return m(quickSetupComponentResult, "quick_setup");
    }

    public static List<ScanResult> y(List<ScanResult> list, EnumDeviceType enumDeviceType, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ScanResult scanResult = list.get(i);
                if (scanResult != null && Q(scanResult.SSID, enumDeviceType, str)) {
                    arrayList.add(scanResult);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!arrayList3.contains(((ScanResult) arrayList.get(i2)).SSID)) {
                    arrayList3.add(((ScanResult) arrayList.get(i2)).SSID);
                    arrayList2.add(arrayList.get(i2));
                }
            }
        }
        return arrayList2;
    }

    public static List<ScanResult> z(List<ScanResult> list, String str) {
        return y(list, com.tplink.iot.view.quicksetup.bulb.utils.b.l(str), str);
    }
}
