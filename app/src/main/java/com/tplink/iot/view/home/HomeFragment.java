package com.tplink.iot.view.home;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.HomeFamilySelectBean;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.HomeShortcutAdapter;
import com.tplink.iot.adapter.home.HomeShortcutItemDecoration;
import com.tplink.iot.adapter.home.ItemTouchHelperCallback;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.model.home.d;
import com.tplink.iot.view.about.CommonWebActivity;
import com.tplink.iot.view.authflip.GoogleAssistantActivity;
import com.tplink.iot.view.cloudvideo.CloudVideoListActivity;
import com.tplink.iot.view.familymanager.FamilyDetailActivity;
import com.tplink.iot.view.familymanager.FamilyListActivity;
import com.tplink.iot.view.feedback.FeedBackWebActivity;
import com.tplink.iot.view.home.alldevice.HomeAllDevicesActivity;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.view.home.message.NotificationCenterActivity;
import com.tplink.iot.view.home.nextevent.NextEventListActivity;
import com.tplink.iot.view.iothub.HubDetailActivity;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.view.ipcamera.play.PlaybackAndMemoriesActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewActivity;
import com.tplink.iot.view.ipcamera.setting.CameraSettingsActivity;
import com.tplink.iot.view.ipcamera.setting.StoreManageActivity;
import com.tplink.iot.view.login.CloudRegionChooseActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.common.SelectCategoryNewActivity;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDeviceListActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.view.wss.WssAlexaActivity;
import com.tplink.iot.viewmodel.home.HomeMainViewModel;
import com.tplink.iot.viewmodel.home.y;
import com.tplink.iot.widget.colorbulb.NextEventBulbTintView;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareUpdateLevel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HomeFragment extends HomeBaseFragment implements com.tplink.iot.adapter.home.h, View.OnClickListener {
    private long A4;
    private String B4;
    private String C4;
    private io.reactivex.e0.c D4;
    private Dialog E4;
    private AlertDialog F4;
    private AlertDialog G4;
    private TextView H3;
    private AlertDialog H4;
    private CardView I3;
    private com.tplink.iot.devicecommon.feature.a I4;
    private NextEventBulbTintView J3;
    private TPLongMaterialDialogV2 J4;
    private ImageView K3;
    private Runnable K4;
    private TextView L3;
    private Handler L4;
    private TextView M3;
    private String M4;
    private View N3;
    private String N4;
    private View O3;
    private View P3;
    private TextView Q3;
    private HomeMainViewModel R3;
    private boolean S3;
    private PullToRefreshContainer T3;
    private View U3;
    private View V3;
    private TextView W3;
    private TextView Y3;
    private TextView Z3;
    private TextView a4;
    private TextView b4;
    private View c4;
    private View d4;
    private View e4;
    private MenuItem f4;
    private MenuItem g4;
    private View h4;
    private TextView i4;
    private ImageView j4;
    private int k4;
    private int l4;
    private ItemTouchHelperCallback m4;
    private com.tplink.iot.viewmodel.home.y n4;
    private String o4;
    private HomeMainAdapter p0;
    private HomeShortcutAdapter p1;
    private RecyclerView p2;
    private CardView p3;
    private String p4;
    private String q4;
    private b.a.a.a.a.a.a r4;
    private String x4;
    private View y;
    private long y4;
    private RecyclerView z;
    private String z4;
    private String x = HomeFragment.class.getSimpleName();
    private int X3 = -1;
    private long s4 = 0;
    private AlertDialog t4 = null;
    private WebView u4 = null;
    private AlertDialog v4 = null;
    private AlertDialog w4 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<ThingNextEvent> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingNextEvent thingNextEvent) {
            BaseALIoTDevice I1;
            String deviceRegion = (thingNextEvent == null || TextUtils.isEmpty(thingNextEvent.getThingName()) || (I1 = TPIoTClientManager.I1(b.d.w.h.a.g(thingNextEvent.getThingName()))) == null) ? null : I1.getDeviceRegion();
            if (com.tplink.iot.Utils.t.i(thingNextEvent, deviceRegion)) {
                if (com.tplink.iot.Utils.t.g(thingNextEvent.getNextEvent())) {
                    HomeFragment.this.J3.setVisibility(8);
                    HomeFragment.this.K3.setVisibility(0);
                } else {
                    HomeFragment.this.K3.setVisibility(8);
                    HomeFragment.this.J3.setVisibility(0);
                    HomeFragment.this.J3.setTintColor(com.tplink.iot.Utils.t.c(thingNextEvent.getNextEvent()));
                }
                HomeFragment.this.L3.setText(String.format("%s %s", thingNextEvent.getNickname(), com.tplink.iot.Utils.t.d(HomeFragment.this.getContext(), thingNextEvent.getNextEvent(), deviceRegion)));
                HomeFragment.this.W4();
                return;
            }
            HomeFragment.this.p3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a0 implements DialogInterface.OnDismissListener {
        a0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            HomeFragment.this.X2();
            HomeFragment.this.g5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.T3.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b0 implements TPLongMaterialDialogV2.d {
        b0() {
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            HomeFragment.this.R3.J1();
            HomeFragment.this.C0(DiscoveryDeviceListActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null) {
                s0.l(HomeFragment.this.getActivity());
            } else {
                HomeFragment.this.m3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c0 implements TPLongMaterialDialogV2.d {
        c0() {
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            HomeFragment.this.R3.J1();
            HomeFragment.this.g5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<RunShortCutResultBean> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable RunShortCutResultBean runShortCutResultBean) {
            if (runShortCutResultBean != null && runShortCutResultBean.getSmartId() != null) {
                if (runShortCutResultBean.getCode() == 404) {
                    s0.n(HomeFragment.this.getActivity(), R.string.smart_action_condition_fail_toast);
                    HomeFragment.this.R3.S1();
                    return;
                }
                if (runShortCutResultBean.isSuccess()) {
                    List<String> failedDeviceNames = runShortCutResultBean.getFailedDeviceNames();
                    if (failedDeviceNames != null && !failedDeviceNames.isEmpty()) {
                        com.tplink.iot.view.smart.a.g.e(HomeFragment.this.getContext(), failedDeviceNames, HomeFragment.this.getString(R.string.smart_action_execute_fail_title), HomeFragment.this.getString(R.string.smart_action_execute_fail_summary));
                    }
                } else {
                    s0.n(HomeFragment.this.getActivity(), R.string.operation_failed_try_again);
                }
                HomeFragment.this.p1.u(runShortCutResultBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d0 {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8495b;

        static {
            int[] iArr = new int[EnumMsgSubscribeType.values().length];
            f8495b = iArr;
            try {
                iArr[EnumMsgSubscribeType.TAPO_DAILY_SUMMARY_CAN_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8495b[EnumMsgSubscribeType.TAPO_DAILY_SUMMARY_CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8495b[EnumMsgSubscribeType.CAMERA_SD_INSUFFICIENT_STORAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8495b[EnumMsgSubscribeType.CAMERA_SD_NEED_INITIALIZATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumHomeState.values().length];
            a = iArr2;
            try {
                iArr2[EnumHomeState.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumHomeState.LOCAL_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null) {
                HomeFragment.this.R2(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e0 implements Observer<Boolean> {
        e0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.Z4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.q5(bool != null && bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f0 implements Observer<Boolean> {
        f0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.U2(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g0 implements Observer<TCAccountBean> {
        g0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            if (tCAccountBean != null) {
                b.d.c.a.e.l().d(b.d.s.a.a.e());
                b.d.c.a.e.l().a(b.d.s.a.a.d());
                b.d.n.f.b.l().a(b.d.s.a.a.d());
                HomeFragment.this.z3(tCAccountBean.getEmail());
                com.tplink.iot.Utils.x0.o.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Observer<Boolean> {
        h() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.T3.A();
            HomeFragment.this.s3();
            HomeFragment.this.R3.K1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h0 implements Observer<TCAccountBean> {
        h0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            if (tCAccountBean != null) {
                HomeFragment.this.o4 = tCAccountBean.getCloudUserName();
                HomeFragment.this.p4 = tCAccountBean.getEmail();
                HomeFragment.this.q4 = tCAccountBean.getNickName();
                if (TextUtils.isEmpty(tCAccountBean.getCountryCode())) {
                    String t = com.tplink.libtpnetwork.Utils.o.h0().t(HomeFragment.this.o4);
                    if (t != null) {
                        HomeFragment.this.R3.l2(HomeFragment.this.o4, HomeFragment.this.q4, t);
                        return;
                    }
                    Intent intent = new Intent(HomeFragment.this.getActivity(), CloudRegionChooseActivity.class);
                    intent.putExtra("REGION_CODE", com.tplink.iot.Utils.login.a.b(HomeFragment.this.getActivity()));
                    intent.putExtra("args_is_from_dashboard", true);
                    HomeFragment.this.startActivityForResult(intent, 1001);
                } else if (!TextUtils.isEmpty(HomeFragment.this.o4) && !TextUtils.isEmpty(HomeFragment.this.p4)) {
                    HomeFragment.this.m5(tCAccountBean);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements Observer<Boolean> {
        i() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            HomeFragment.this.r5(bool != null && bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i0 implements Observer<List<com.tplink.iot.model.home.e>> {
        i0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<com.tplink.iot.model.home.e> list) {
            HomeFragment.this.p0.t(list);
            HomeFragment.this.Q2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements Observer<Boolean> {
        j() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j0 implements Observer<List<com.tplink.iot.model.home.e>> {
        j0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<com.tplink.iot.model.home.e> list) {
            if (!HomeFragment.this.B3()) {
                HomeFragment.this.Q4();
                HomeFragment.this.p0.s(list);
                HomeFragment.this.Q2(list);
                HomeFragment.this.T4(list);
                HomeFragment.this.U4(list);
                HomeFragment.this.J4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements Observer<EnumHomeState> {
        k() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable EnumHomeState enumHomeState) {
            HomeFragment.this.Z2(enumHomeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k0 implements Observer<List<SmartInfo>> {
        k0() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<SmartInfo> list) {
            if (list == null || list.isEmpty()) {
                HomeFragment.this.p1.t(new ArrayList());
                HomeFragment.this.p2.setVisibility(8);
                return;
            }
            HomeShortcutAdapter homeShortcutAdapter = HomeFragment.this.p1;
            HomeFragment homeFragment = HomeFragment.this;
            homeShortcutAdapter.t(homeFragment.V2(list, homeFragment.p1.o()));
            HomeFragment.this.Y4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements Observer<Integer> {
        l() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            if (num.intValue() == 1 || num.intValue() == 2) {
                HomeFragment.this.k5(num.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class l0 extends WebViewClient {
        private String a;

        l0(String str) {
            this.a = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            b.d.w.c.a.c(HomeFragment.this.x, str);
            b.d.w.c.a.a("onPageFinished");
            super.onPageFinished(webView, str);
            if (HomeFragment.this.R3 != null) {
                HomeFragment.this.R3.Y1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            b.d.w.c.a.c(HomeFragment.this.x, str);
            b.d.w.c.a.a("onPageStarted");
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            b.d.w.c.a.c(HomeFragment.this.x, str);
            if (TextUtils.equals(str, this.a)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            b.d.w.f.a.i(HomeFragment.this.getContext(), str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements AppBarLayout.OnOffsetChangedListener {
        m() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (HomeFragment.this.X3 != i) {
                HomeFragment.this.X3 = i;
                float abs = (float) ((Math.abs(i) * 1.0d) / appBarLayout.getTotalScrollRange());
                if (HomeFragment.this.T3 != null) {
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) HomeFragment.this.T3.getLayoutParams();
                    layoutParams.setMargins(0, -((int) ((1.0f - abs) * HomeFragment.this.k4)), 0, 0);
                    HomeFragment.this.T3.setLayoutParams(layoutParams);
                }
                if (HomeFragment.this.h4 != null) {
                    HomeFragment.this.i4.setTextSize(2, 24.0f - (4.0f * abs));
                    int i2 = (int) ((1.0f - abs) * HomeFragment.this.l4);
                    CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) HomeFragment.this.h4.getLayoutParams();
                    layoutParams2.setMargins(((FrameLayout.LayoutParams) layoutParams2).leftMargin, ((FrameLayout.LayoutParams) layoutParams2).topMargin, ((FrameLayout.LayoutParams) layoutParams2).rightMargin, i2);
                    HomeFragment.this.h4.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements PullToRefreshContainer.e {
        n() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void onRefresh() {
            HomeFragment.this.R3.R1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements HomeShortcutAdapter.c {
        o() {
        }

        @Override // com.tplink.iot.adapter.home.HomeShortcutAdapter.c
        public void a(View view, int i, String str) {
            if (!HomeFragment.this.B3()) {
                HomeFragment.this.R3.W1(str);
                com.tplink.iot.Utils.x0.o.x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HomeFragment.this.O0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HomeFragment.this.L4();
        }
    }

    /* loaded from: classes2.dex */
    class r implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8499c;

        r(int i) {
            this.f8499c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeFragment.this.W3.setText(HomeFragment.this.getResources().getString(R.string.home_toolbar_selected_with_number, Integer.valueOf(this.f8499c)));
            HomeFragment.this.T2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class s implements y.c {
        final /* synthetic */ List a;

        s(List list) {
            this.a = list;
        }

        @Override // com.tplink.iot.viewmodel.home.y.c
        public void a(View view, int i) {
            if (i >= 0 && i < this.a.size()) {
                HomeFragment.this.P2((HomeFamilySelectBean) this.a.get(i));
            }
        }

        @Override // com.tplink.iot.viewmodel.home.y.c
        public void b(View view) {
            if (this.a.size() == 1) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), FamilyDetailActivity.class);
                intent.putExtra("args_key_need_add_home", true);
                HomeFragment.this.startActivity(intent);
            } else {
                HomeFragment.this.C0(FamilyListActivity.class);
            }
            com.tplink.iot.Utils.x0.o.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class t implements PopupWindow.OnDismissListener {
        t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ObjectAnimator.ofFloat(HomeFragment.this.j4, View.ROTATION.getName(), -180.0f, 0.0f).start();
        }
    }

    /* loaded from: classes2.dex */
    class u implements Runnable {
        u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeFragment.this.p0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class v implements Observer<FamilyInfo> {
        v() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable FamilyInfo familyInfo) {
            HomeFragment.this.Z4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class w implements io.reactivex.g0.g<b.a.a.a.a.a.a> {
        w() {
        }

        /* renamed from: a */
        public void accept(b.a.a.a.a.a.a aVar) throws Exception {
            if (aVar != null) {
                if (HomeFragment.this.r4 == null || (HomeFragment.this.r4.i() == 0 && aVar.i() == 0)) {
                    HomeFragment.this.r4 = aVar;
                    return;
                }
                HomeFragment.this.r4 = aVar;
                if (HomeFragment.this.R3 != null) {
                    if (HomeFragment.this.R3.l1()) {
                        HomeFragment.this.R3.P1();
                        LiveMediaAPI.onNetworkChanged();
                        LiveMediaAPI.destroyAllDoubleTalkClient();
                    } else if (HomeFragment.this.R3.g1() && aVar.i() == 0) {
                        HomeFragment.this.R3.T1();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class x implements TPMaterialDialogV2.c {

        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8505c;

            a(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8505c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeFragment.this.R3.u2(HomeFragment.this.p4, true);
                TPMaterialDialogV2 tPMaterialDialogV2 = this.f8505c;
                if (tPMaterialDialogV2 != null) {
                    tPMaterialDialogV2.dismiss();
                }
            }
        }

        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8507c;

            b(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8507c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TPMaterialDialogV2 tPMaterialDialogV2 = this.f8507c;
                if (tPMaterialDialogV2 != null) {
                    tPMaterialDialogV2.dismiss();
                }
            }
        }

        x() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            ((TextView) view.findViewById(R.id.tv_subscribe_info)).setText(R.string.cloud_account_register_receive_email_tips_new);
            ((TextView) view.getRootView().findViewById(R.id.tv_accept_email)).setOnClickListener(new a(tPMaterialDialogV2));
            ((TextView) view.findViewById(R.id.tv_not_accept_email)).setOnClickListener(new b(tPMaterialDialogV2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class y implements io.reactivex.g0.g<CloudVideo> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8509c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f8510d;

        y(String str, String str2) {
            this.f8509c = str;
            this.f8510d = str2;
        }

        /* renamed from: a */
        public void accept(CloudVideo cloudVideo) throws Exception {
            if (cloudVideo == null) {
                HomeFragment.this.l3(b.d.w.h.a.g(this.f8509c), this.f8510d);
                return;
            }
            s0.g();
            HomeFragment.this.n3(cloudVideo, this.f8509c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.d.w.c.a.a("dismissAppMarketingPage close");
            HomeFragment.this.X2();
        }
    }

    private void A3() {
        this.k4 = com.tplink.iot.Utils.k.a(this.y.getContext(), 70.0f);
        Toolbar toolbar = (Toolbar) this.y.findViewById(R.id.main_toolbar);
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
        }
        this.I4 = new com.tplink.iot.devicecommon.feature.a();
        this.N3 = this.y.findViewById(R.id.view_no_internet);
        this.O3 = this.y.findViewById(R.id.view_data);
        this.P3 = this.y.findViewById(R.id.device_list_title);
        CardView cardView = (CardView) this.y.findViewById(R.id.cl_home_empty_view);
        this.I3 = cardView;
        cardView.setVisibility(8);
        this.I3.setOnClickListener(this);
        TextView textView = (TextView) this.y.findViewById(R.id.tv_no_common_device);
        this.M3 = textView;
        textView.setVisibility(8);
        x3();
        v3();
        w3();
        ((AppBarLayout) this.y.findViewById(R.id.abl_home_bar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new m());
        this.U3 = this.y.findViewById(R.id.view_bottom_operation);
        this.W3 = (TextView) this.y.findViewById(R.id.tv_top_operation_title);
        this.V3 = this.y.findViewById(R.id.rl_top_operation);
        t3();
        y3();
        TextView textView2 = (TextView) this.y.findViewById(R.id.tv_all_device);
        this.Q3 = textView2;
        textView2.setOnClickListener(this);
        CardView cardView2 = (CardView) this.y.findViewById(R.id.card_next_event);
        this.p3 = cardView2;
        cardView2.setOnClickListener(this);
        this.p3.setVisibility(8);
        this.L3 = (TextView) this.y.findViewById(R.id.tv_next_event);
        this.J3 = (NextEventBulbTintView) this.y.findViewById(R.id.next_event_bulb_tint_view);
        this.K3 = (ImageView) this.y.findViewById(R.id.iv_lighting_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B3() {
        HomeMainAdapter homeMainAdapter = this.p0;
        return homeMainAdapter != null && homeMainAdapter.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4 */
    public /* synthetic */ void C4(Boolean bool) {
        if (org.apache.commons.lang.b.b(bool)) {
            b.d.w.c.a.a("getAppMarketingEvent true");
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing() && this.t4 != null) {
                b.d.w.c.a.a("mMarketingDialog show");
                this.t4.show();
                com.tplink.libtpnetwork.Utils.o.h0().y0(b.d.s.a.a.f().c().getAccountId(), System.currentTimeMillis());
                return;
            }
            return;
        }
        b.d.w.c.a.a("getAppMarketingEvent dismissAppMarketingPage");
        X2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4 */
    public /* synthetic */ void E4(Boolean bool) {
        if (org.apache.commons.lang.b.b(bool)) {
            i5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E3 */
    public /* synthetic */ void F3(String str, String str2, Throwable th) throws Exception {
        l3(b.d.w.h.a.g(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4 */
    public /* synthetic */ void G4(Boolean bool) {
        if (org.apache.commons.lang.b.b(bool)) {
            e5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G3 */
    public /* synthetic */ void H3(Throwable th) throws Exception {
        th.printStackTrace();
        n5();
        s0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H4 */
    public /* synthetic */ void I4(final com.tplink.iot.model.home.d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.f()) {
            com.tplink.iot.viewmodel.home.u.l(getActivity(), dVar.c(), dVar.b(), dVar.d(), new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.home.a0
                @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
                public final void onClick(View view) {
                    HomeFragment.this.M3(view);
                }
            });
            return;
        }
        int I = com.tplink.libtpnetwork.Utils.o.h0().I();
        if (I < 3) {
            com.tplink.libtpnetwork.Utils.o.h0().K0(I + 1);
            com.tplink.iot.viewmodel.home.u.n(getActivity(), dVar.c(), new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.home.v
                @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
                public final void onClick(View view) {
                    HomeFragment.this.O3(dVar, view);
                }
            });
            return;
        }
        g5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I3 */
    public /* synthetic */ void J3(String str, CameraSettingRepository cameraSettingRepository, String str2, Boolean bool) throws Exception {
        com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u j02 = this.R3.j0(str);
        if (j02 == null || (j02.f() && j02.b() != FirmwareUpdateLevel.LEVEL4)) {
            SdCardInfoCache sdCardInfoCache = cameraSettingRepository.x().getSdCardInfoCache();
            SdCardStatus sdCardStatus = null;
            if (sdCardInfoCache != null) {
                sdCardStatus = sdCardInfoCache.getStatus();
            }
            EnumMsgSubscribeType fromString = EnumMsgSubscribeType.fromString(str2);
            if (fromString == EnumMsgSubscribeType.CAMERA_SD_NEED_INITIALIZATION) {
                p3(str);
            } else if (fromString == EnumMsgSubscribeType.CAMERA_SD_INSUFFICIENT_STORAGE) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    if (SdCardStatus.NORMAL.equals(sdCardStatus) || SdCardStatus.UNFORMATTED.equals(sdCardStatus) || SdCardStatus.INSUFFICIENT.equals(sdCardStatus) || SdCardStatus.FULL.equals(sdCardStatus)) {
                        Intent intent = new Intent(activity, StoreManageActivity.class);
                        intent.putExtra("device_id_md5", str);
                        activity.startActivity(intent);
                    } else {
                        CameraSettingsActivity.j2(activity, str, true);
                    }
                }
            } else if ((SdCardStatus.NORMAL.equals(sdCardStatus) || SdCardStatus.FULL.equals(sdCardStatus)) && this.A4 > 0 && (System.currentTimeMillis() / 1000) - this.A4 > 60) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    PlaybackAndMemoriesActivity.e1(activity2, str, this.A4);
                }
            } else {
                p3(str);
            }
            s0.g();
            return;
        }
        s0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J4() {
        com.tplink.iot.Utils.x0.o.d(!this.p0.o(), this.x4);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.y4 > 86400000) {
            com.tplink.iot.Utils.x0.o.z(this.p0.m());
            this.y4 = currentTimeMillis;
        }
    }

    private void K4() {
        this.S3 = false;
        com.tplink.iot.Utils.x.b(this.V3);
        this.W3.setText(R.string.home_toolbar_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L3 */
    public /* synthetic */ void M3(View view) {
        g5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L4() {
        this.S3 = true;
        this.R3.U1(this.p0.m());
        O0();
        this.R3.q2(this.p0.m());
    }

    private void M4() {
        this.R3.a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N3 */
    public /* synthetic */ void O3(com.tplink.iot.model.home.d dVar, View view) {
        TrialDialogActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.w(dVar.e(), dVar.c()));
        g5();
    }

    private void N4(boolean z2) {
        O4(this.Y3, z2);
        O4(this.Z3, z2);
        O4(this.a4, z2);
        O4(this.b4, z2);
    }

    private void O2() {
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null) {
            homeMainViewModel.X();
        }
    }

    private void O4(TextView textView, boolean z2) {
        if (z2) {
            textView.setAlpha(1.0f);
            textView.setClickable(true);
            return;
        }
        textView.setAlpha(0.6f);
        textView.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(HomeFamilySelectBean homeFamilySelectBean) {
        s0.l(getActivity());
        this.R3.Y(homeFamilySelectBean.getFamilyId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P3 */
    public /* synthetic */ void Q3(Activity activity) {
        if (this.E4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.E4.dismiss();
            g5();
        }
    }

    private void P4() {
        if (this.H3 != null) {
            if (this.R3.j1() || this.R3.a1()) {
                this.H3.setVisibility(8);
                return;
            }
            int g02 = this.R3.g0();
            if (g02 == 1) {
                TextView textView = this.H3;
                textView.setText(getString(R.string.home_one_camera, g02 + ""));
            } else {
                TextView textView2 = this.H3;
                textView2.setText(getString(R.string.home_all_camera, g02 + ""));
            }
            this.H3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(List<? extends com.tplink.iot.model.home.e> list) {
        if (!com.tplink.iot.Utils.s.b(list)) {
            this.z.setPadding(com.tplink.iot.Utils.j.a(getActivity(), 11.0f), com.tplink.iot.Utils.j.a(getActivity(), 10.0f), com.tplink.iot.Utils.j.a(getActivity(), 11.0f), com.tplink.iot.Utils.j.a(getActivity(), 80.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q4() {
        P4();
        S4();
        X4();
        R4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R3 */
    public /* synthetic */ void S3(Activity activity, View view) {
        String c2 = com.tplink.iot.model.about.d.c(activity, null, null);
        Intent intent = new Intent(activity, FeedBackWebActivity.class);
        intent.putExtra("feed_back_faq_params", c2);
        startActivity(intent);
        if (this.H4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.H4.dismiss();
        }
        this.H4 = null;
    }

    private void R4() {
        if (this.R3.Y0()) {
            this.I3.setVisibility(0);
        } else {
            this.I3.setVisibility(8);
        }
    }

    private void S2() {
        if (!com.tplink.libtpnetwork.Utils.o.h0().c("rate_us_has_show", false) && !isHidden()) {
            long e2 = com.tplink.libtpnetwork.Utils.o.h0().e("rate_us_time_stamp", 0L);
            if (e2 != 0 && System.currentTimeMillis() - e2 > 259200000) {
                this.R3.b2();
            }
        }
    }

    private void S4() {
        if (!this.R3.k1() || this.R3.Y0()) {
            this.P3.setVisibility(8);
        } else {
            this.P3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        List<com.tplink.iot.model.home.e> n2 = this.p0.n();
        if (n2.isEmpty()) {
            this.U3.setAlpha(0.8f);
            N4(false);
            return;
        }
        this.U3.setAlpha(1.0f);
        N4(true);
        boolean z2 = false;
        boolean z3 = false;
        for (com.tplink.iot.model.home.e eVar : n2) {
            if (eVar instanceof com.tplink.iot.model.home.g) {
                z3 = true;
            } else if ((eVar instanceof com.tplink.iot.model.home.k) && ((com.tplink.iot.model.home.k) eVar).w()) {
                z2 = true;
            }
        }
        if (z2) {
            O4(this.a4, false);
        }
        if (z2 || z3) {
            O4(this.b4, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T3 */
    public /* synthetic */ void U3(Activity activity, View view) {
        if (this.H4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.H4.dismiss();
        }
        this.H4 = null;
        g5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T4(List<? extends com.tplink.iot.model.home.e> list) {
        if (!com.tplink.iot.Utils.s.b(list) && list.size() >= 3 && com.tplink.libtpnetwork.Utils.o.h0().O()) {
            b.d.w.c.a.e("dialog", "show  HomeLongPressTips");
            this.R3.Z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(Boolean bool) {
        if (bool != null) {
            if (!bool.booleanValue()) {
                com.tplink.libtpnetwork.Utils.o.h0().W0(this.o4, System.currentTimeMillis());
                com.tplink.libtpnetwork.Utils.o.h0().M0(this.o4, com.tplink.libtpnetwork.Utils.o.h0().K(this.o4) + 1);
                c5();
                return;
            }
            com.tplink.libtpnetwork.Utils.o.h0().L0(this.o4, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U4(List<? extends com.tplink.iot.model.home.e> list) {
        int i2;
        boolean z2;
        Boolean i1 = this.R3.i1();
        if (i1 != null && !i1.booleanValue() && !com.tplink.iot.Utils.s.b(list) && !com.tplink.libtpnetwork.Utils.o.h0().n0()) {
            Iterator<? extends com.tplink.iot.model.home.e> it = list.iterator();
            while (true) {
                i2 = 1;
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                com.tplink.iot.model.home.e eVar = (com.tplink.iot.model.home.e) it.next();
                if ((eVar instanceof com.tplink.iot.model.home.k) && !((com.tplink.iot.model.home.k) eVar).p()) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                i2 = 2;
            }
            b.d.w.c.a.a("setHomeVoiceControlGuide");
            this.R3.c2(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tplink.iot.model.home.i> V2(List<SmartInfo> list, List<com.tplink.iot.model.home.i> list2) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(list.size(), 5);
        for (int i2 = 0; i2 < min; i2++) {
            SmartInfo smartInfo = list.get(i2);
            com.tplink.iot.model.home.i k3 = k3(smartInfo.getId(), list2);
            if (k3 != null) {
                k3.f(smartInfo);
                k3.d(this.R3.n1(smartInfo.getId()));
                arrayList.add(k3);
            } else {
                arrayList.add(new com.tplink.iot.model.home.i(0, smartInfo, this.R3.n1(smartInfo.getId())));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V3 */
    public /* synthetic */ void W3() {
        HomeMainViewModel homeMainViewModel;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && !isHidden() && (homeMainViewModel = this.R3) != null) {
            homeMainViewModel.a2();
        }
    }

    private void V4(boolean z2) {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).s1(z2);
        }
    }

    private void W2() {
        AlertDialog alertDialog = this.v4;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.v4.dismiss();
            g5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W4() {
        if (!this.R3.k1() || this.R3.Y0()) {
            this.p3.setVisibility(8);
        } else {
            this.p3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X2() {
        b.d.w.c.a.a("dismissAppMarketingPage");
        WebView webView = this.u4;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.u4.clearHistory();
            ((ViewGroup) this.u4.getParent()).removeView(this.u4);
            this.u4.destroy();
            this.u4 = null;
        }
        if (this.t4 != null) {
            if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
                this.t4.dismiss();
            }
            this.t4 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X3 */
    public /* synthetic */ void Y3(Activity activity, View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + activity.getPackageName())));
        } catch (Exception unused) {
            b.d.w.c.a.c(this.x, "go to market details failed");
        }
        if (this.G4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.G4.dismiss();
        }
        this.G4 = null;
    }

    private void X4() {
        if (!this.R3.k1() || this.R3.Y0() || !this.R3.f1()) {
            this.M3.setVisibility(8);
        } else {
            this.M3.setVisibility(0);
        }
    }

    private void Y2() {
        com.tplink.iot.viewmodel.home.y yVar = this.n4;
        if (yVar != null && yVar.isShowing()) {
            this.n4.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y4() {
        if (this.R3.k1()) {
            this.p2.setVisibility(0);
        } else {
            this.p2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(EnumHomeState enumHomeState) {
        if (enumHomeState == null) {
            a3();
            return;
        }
        int i2 = d0.a[enumHomeState.ordinal()];
        if (i2 == 1) {
            c3();
        } else if (i2 != 2) {
            a3();
        } else {
            b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z3 */
    public /* synthetic */ void a4(Activity activity, View view) {
        if (this.G4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.G4.dismiss();
        }
        this.G4 = null;
        g5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z4() {
        if (this.R3.j1()) {
            this.h4.setVisibility(8);
        } else if (B3()) {
            this.h4.setVisibility(4);
        } else if (!this.R3.k1()) {
            Drawable drawable = getResources().getDrawable(R.mipmap.no_internet_small);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.i4.setText(R.string.home_network_unstable);
            this.i4.setCompoundDrawables(drawable, null, null, null);
            this.j4.setVisibility(8);
            this.h4.setVisibility(0);
        } else {
            FamilyInfo g2 = this.R3.g();
            if (this.R3.h1() || g2 == null) {
                this.i4.setCompoundDrawables(null, null, null, null);
                this.i4.setText(R.string.home_default_family);
                this.j4.setVisibility(8);
                this.h4.setVisibility(0);
                return;
            }
            String name = g2.getName();
            if (TextUtils.isEmpty(name)) {
                name = getString(R.string.home_default_family);
            }
            this.i4.setCompoundDrawables(null, null, null, null);
            this.i4.setText(name);
            this.j4.setVisibility(0);
            this.h4.setVisibility(0);
        }
    }

    private void a3() {
        Z4();
        this.O3.setVisibility(8);
        this.N3.setVisibility(0);
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a5(String str) {
        b.d.w.c.a.a("showAppMarketingPage advertUrl");
        if (this.t4 == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.layout_app_marketing, (ViewGroup) null);
            inflate.findViewById(R.id.marketing_close_iv).setOnClickListener(new z());
            WebView webView = (WebView) inflate.findViewById(R.id.marketing_web_view);
            this.u4 = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.u4.setWebViewClient(new l0(str));
            this.u4.loadUrl(str);
            this.t4 = builder.setView(inflate).setOnDismissListener(new a0()).create();
        }
    }

    private void b3() {
        Z4();
        W4();
        Y4();
        Q4();
        this.O3.setVisibility(0);
        this.N3.setVisibility(8);
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b4 */
    public /* synthetic */ void c4(Activity activity, View view) {
        com.tplink.iot.Utils.n.b().e(ThingRuleGuardMode.GuardMode.HOME, "rating_enjoy_tapo");
        h5();
        if (this.F4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.F4.dismiss();
        }
        this.F4 = null;
    }

    private void b5(int i2) {
        TPLongMaterialDialogV2 tPLongMaterialDialogV2 = this.J4;
        if (tPLongMaterialDialogV2 != null) {
            tPLongMaterialDialogV2.dismiss();
            this.J4 = null;
        }
        this.J4 = new TPLongMaterialDialogV2.Builder(getContext()).setTitle(R.string.discovery_discovered_device_title).g(getString(R.string.discovery_discovered_device_dialog_hint, Integer.valueOf(i2))).j(R.string.tapo_care_trial_cancel_not_now, new c0()).m(R.string.view_all, new b0()).setCancelable(false).c(false).show();
    }

    private void c3() {
        Z4();
        Q4();
        this.O3.setVisibility(0);
        this.N3.setVisibility(8);
    }

    private void c5() {
        new TPMaterialDialogV2.Builder(getActivity()).d(R.layout.layout_subscribe_remind).f(new x()).show();
    }

    private void d3() {
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null) {
            homeMainViewModel.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d4 */
    public /* synthetic */ void e4(Activity activity, View view) {
        com.tplink.iot.Utils.n.b().e(ThingRuleGuardMode.GuardMode.HOME, "rating_not_enjoy_tapo");
        f5();
        if (this.F4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.F4.dismiss();
        }
        this.F4 = null;
    }

    private void d5(View view) {
        com.tplink.iot.viewmodel.home.y yVar = this.n4;
        if (yVar == null || !yVar.isShowing()) {
            ArrayList arrayList = new ArrayList();
            for (FamilyInfo familyInfo : this.R3.c0()) {
                HomeFamilySelectBean homeFamilySelectBean = new HomeFamilySelectBean();
                homeFamilySelectBean.setFamilyId(familyInfo.getId());
                if (!familyInfo.isDefault() || familyInfo.getName() == null || !familyInfo.getName().isEmpty()) {
                    homeFamilySelectBean.setFamilyName(familyInfo.getName());
                } else {
                    homeFamilySelectBean.setFamilyName(getString(R.string.home_default_family));
                }
                homeFamilySelectBean.setSelected(this.R3.b1(familyInfo));
                arrayList.add(homeFamilySelectBean);
            }
            com.tplink.iot.viewmodel.home.y yVar2 = new com.tplink.iot.viewmodel.home.y(getActivity(), arrayList);
            this.n4 = yVar2;
            yVar2.setAnimationStyle(R.style.home_popupAnim);
            this.n4.f(new s(arrayList));
            this.n4.g(view);
            ObjectAnimator.ofFloat(this.j4, View.ROTATION.getName(), 180.0f).start();
            this.n4.setOnDismissListener(new t());
        }
    }

    @SuppressLint({"CheckResult"})
    private void e3(final String str, final String str2) {
        String str3 = this.B4;
        if (str3 == null) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str3) || !com.tplink.iot.Utils.a0.a(str3)) {
            l3(b.d.w.h.a.g(str), str2);
        } else {
            this.R3.i0(str, str3).l0(io.reactivex.d0.b.a.a()).H0(new y(str, str2), new io.reactivex.g0.g() { // from class: com.tplink.iot.view.home.q
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    HomeFragment.this.F3(str, str2, (Throwable) obj);
                }
            });
        }
    }

    private void e5() {
        final FragmentActivity activity = getActivity();
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            com.tplink.libtpnetwork.Utils.o.h0().U0(false);
            Dialog dialog = new Dialog(activity, R.style.TPLoadingDialog);
            this.E4 = dialog;
            dialog.setContentView(R.layout.layout_home_long_press_tip);
            this.E4.setCancelable(false);
            this.E4.show();
            new Handler().postDelayed(new Runnable() { // from class: com.tplink.iot.view.home.j
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.this.Q3(activity);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f4 */
    public /* synthetic */ void g4(Activity activity, View view) {
        if (this.F4 != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.F4.dismiss();
        }
        this.F4 = null;
        g5();
    }

    private void f5() {
        final FragmentActivity activity;
        if (this.H4 == null && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.layout_negative_rate_dialog, (ViewGroup) null);
            inflate.findViewById(R.id.positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.S3(activity, view);
                }
            });
            inflate.findViewById(R.id.negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.U3(activity, view);
                }
            });
            AlertDialog create = builder.setView(inflate).create();
            this.H4 = create;
            create.setCancelable(false);
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                this.H4.show();
            }
            Window window = this.H4.getWindow();
            if (window != null) {
                window.setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, activity), -2);
            }
        }
    }

    private String g3(MainActivity mainActivity) {
        if (mainActivity == null) {
            return null;
        }
        return mainActivity.h1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g5() {
        if (this.K4 == null) {
            this.K4 = new Runnable() { // from class: com.tplink.iot.view.home.n
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.this.W3();
                }
            };
        }
        if (this.L4 == null) {
            this.L4 = new Handler();
        }
        this.L4.postDelayed(this.K4, 1000L);
    }

    private long h3(MainActivity mainActivity) {
        if (mainActivity == null || mainActivity.j1() == null) {
            return 0L;
        }
        try {
            return Long.parseLong(mainActivity.j1());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h4 */
    public /* synthetic */ void i4(View view) {
        AlertDialog alertDialog = this.w4;
        if (alertDialog != null) {
            alertDialog.dismiss();
            g5();
        }
    }

    private void h5() {
        final FragmentActivity activity;
        if (this.G4 == null && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.layout_positive_rate_dialog, (ViewGroup) null);
            inflate.findViewById(R.id.positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.Y3(activity, view);
                }
            });
            inflate.findViewById(R.id.negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.a4(activity, view);
                }
            });
            AlertDialog create = builder.setView(inflate).create();
            this.G4 = create;
            create.setCancelable(false);
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                this.G4.show();
            }
            Window window = this.G4.getWindow();
            if (window != null) {
                window.setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, activity), -2);
            }
        }
    }

    private String i3(MainActivity mainActivity) {
        if (mainActivity == null) {
            return null;
        }
        return mainActivity.k1();
    }

    private void i5() {
        final FragmentActivity activity;
        if (this.F4 == null && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.layout_rate_dialog, (ViewGroup) null);
            inflate.findViewById(R.id.positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.c4(activity, view);
                }
            });
            inflate.findViewById(R.id.negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.e4(activity, view);
                }
            });
            inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.g4(activity, view);
                }
            });
            AlertDialog create = builder.setView(inflate).create();
            this.F4 = create;
            create.setCancelable(false);
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                this.F4.show();
                com.tplink.libtpnetwork.Utils.o.h0().h("rate_us_has_show", true);
            }
            Window window = this.F4.getWindow();
            if (window != null) {
                window.setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, activity), -2);
            }
        }
    }

    private String j3(MainActivity mainActivity) {
        if (mainActivity == null) {
            return null;
        }
        return mainActivity.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j4 */
    public /* synthetic */ void k4(View view) {
        AlertDialog alertDialog = this.w4;
        if (alertDialog != null) {
            alertDialog.dismiss();
            g5();
        }
    }

    private void j5() {
        if (this.w4 == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.dialog_third_voice_control_got_it_layout, (ViewGroup) null);
            inflate.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.i4(view);
                }
            });
            inflate.findViewById(R.id.btn_bottom).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.k4(view);
                }
            });
            AlertDialog create = builder.setView(inflate).create();
            this.w4 = create;
            create.setCancelable(false);
            Window window = this.w4.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.getDecorView().setPadding(0, net.lucode.hackware.magicindicator.g.b.a(getActivity(), 60.0d), 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.horizontalMargin = 0.0f;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.AnimationBottomStyle);
            }
            this.w4.show();
        }
    }

    private com.tplink.iot.model.home.i k3(String str, List<com.tplink.iot.model.home.i> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (com.tplink.iot.model.home.i iVar : list) {
                if (!(iVar == null || iVar.b() == null || !str.equals(iVar.b().getId()))) {
                    return iVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k5(int i2) {
        if (this.v4 == null) {
            com.tplink.libtpnetwork.Utils.o.h0().P0();
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.TPDialog);
            View inflate = getLayoutInflater().inflate(R.layout.dialog_third_voice_control_layout, (ViewGroup) null);
            inflate.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.m4(view);
                }
            });
            inflate.findViewById(R.id.tv_google).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.o4(view);
                }
            });
            inflate.findViewById(R.id.tv_amazon).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.q4(view);
                }
            });
            inflate.findViewById(R.id.tv_smart_things).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.s4(view);
                }
            });
            View findViewById = inflate.findViewById(R.id.ll_alice);
            View findViewById2 = inflate.findViewById(R.id.ll_mail_ru);
            int i3 = 8;
            if (i2 == 2) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
            } else {
                findViewById.setVisibility(com.tplink.libtpnetwork.Utils.x.a() ? 0 : 8);
                inflate.findViewById(R.id.tv_alice).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeFragment.this.u4(view);
                    }
                });
                if (com.tplink.libtpnetwork.Utils.x.a()) {
                    i3 = 0;
                }
                findViewById2.setVisibility(i3);
                inflate.findViewById(R.id.tv_mail_ru).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeFragment.this.w4(view);
                    }
                });
            }
            inflate.findViewById(R.id.tv_later).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.home.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.this.y4(view);
                }
            });
            AlertDialog create = builder.setView(inflate).create();
            this.v4 = create;
            create.setCancelable(false);
            Window window = this.v4.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.getDecorView().setPadding(0, net.lucode.hackware.magicindicator.g.b.a(getActivity(), 60.0d), 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.horizontalMargin = 0.0f;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.AnimationBottomStyle);
            }
            this.v4.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(final String str, final String str2) {
        final CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, CameraSettingRepository.class);
        this.D4 = this.R3.D0(str).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.home.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HomeFragment.this.J3(str, cameraSettingRepository, str2, (Boolean) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.view.home.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HomeFragment.this.H3((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l4 */
    public /* synthetic */ void m4(View view) {
        W2();
    }

    private void l5() {
        this.R3.t0().observe(getViewLifecycleOwner(), new k());
        this.R3.r0().observe(getViewLifecycleOwner(), new v());
        this.R3.q0().observe(getViewLifecycleOwner(), new e0());
        this.R3.h0().observe(getViewLifecycleOwner(), new f0());
        this.R3.P0().observe(getViewLifecycleOwner(), new g0());
        this.R3.L0().observe(getViewLifecycleOwner(), new h0());
        this.R3.m0().observe(getViewLifecycleOwner(), new i0());
        this.R3.s0().observe(getViewLifecycleOwner(), new j0());
        this.R3.E0().observe(getViewLifecycleOwner(), new k0());
        this.R3.R0().observe(getViewLifecycleOwner(), new a());
        this.R3.k0().observe(getViewLifecycleOwner(), new b());
        this.R3.y0().observe(getViewLifecycleOwner(), new c());
        this.R3.C0().observe(getViewLifecycleOwner(), new d());
        this.R3.I0().observe(getViewLifecycleOwner(), new e());
        this.R3.z0().observe(getViewLifecycleOwner(), new f());
        this.R3.S0().observe(getViewLifecycleOwner(), new g());
        this.R3.u0().observe(getViewLifecycleOwner(), new h());
        this.R3.l0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.A4((a) obj);
            }
        });
        this.R3.B0().observe(getViewLifecycleOwner(), new i());
        this.R3.Q0().observe(getViewLifecycleOwner(), new j());
        com.tplink.libtpnetwork.Utils.j.c(this.R3.x0(), this, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.home.h
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                HomeFragment.this.a5((String) obj);
            }
        });
        this.R3.d0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.d0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.C4((Boolean) obj);
            }
        });
        this.R3.J0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.e0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.E4((Boolean) obj);
            }
        });
        this.R3.G0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.G4((Boolean) obj);
            }
        });
        this.R3.K0().observe(getViewLifecycleOwner(), new l());
        this.R3.F0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.I4((d) obj);
            }
        });
        this.R3.H0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.r3((List) obj);
            }
        });
        this.R3.n0().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.o5((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3() {
        s0.g();
        this.z4 = null;
        this.A4 = 0L;
        this.C4 = null;
        this.B4 = null;
        com.tplink.iot.Utils.login.a.g(getActivity());
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m5(TCAccountBean tCAccountBean) {
        if (tCAccountBean != null) {
            String cloudUserName = tCAccountBean.getCloudUserName();
            String email = tCAccountBean.getEmail();
            if (!com.tplink.libtpnetwork.Utils.o.h0().J(cloudUserName)) {
                int K = com.tplink.libtpnetwork.Utils.o.h0().K(cloudUserName);
                long R = com.tplink.libtpnetwork.Utils.o.h0().R(cloudUserName);
                long currentTimeMillis = System.currentTimeMillis();
                if (K == 0) {
                    com.tplink.libtpnetwork.Utils.o.h0().W0(cloudUserName, currentTimeMillis);
                    com.tplink.libtpnetwork.Utils.o.h0().M0(cloudUserName, 1);
                } else if (K == 1 && currentTimeMillis - R > 172800000) {
                    this.R3.p0(email);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(CloudVideo cloudVideo, String str) {
        if (cloudVideo == null) {
            return;
        }
        if (cloudVideo.getPartCloudVideos() == null || cloudVideo.getPartCloudVideos().size() <= 0) {
            s0.p(getActivity(), getString(R.string.video_can_not_play_remind));
            return;
        }
        PartCloudVideo partCloudVideo = cloudVideo.getPartCloudVideos().get(0);
        if (partCloudVideo != null && partCloudVideo.getUri() != null) {
            o3(str, partCloudVideo.getM3u8(), partCloudVideo.getUri(), partCloudVideo.getDuration(), partCloudVideo.getStartTimestamp(), cloudVideo.getUuid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n4 */
    public /* synthetic */ void o4(View view) {
        W2();
        C0(GoogleAssistantActivity.class);
        com.tplink.iot.Utils.x0.q.k();
    }

    private void n5() {
        Runnable runnable;
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null && homeMainViewModel.o1()) {
            Handler handler = this.L4;
            if (!(handler == null || (runnable = this.K4) == null)) {
                handler.removeCallbacks(runnable);
            }
            this.R3.k2();
        }
    }

    private void o3(String str, String str2, String str3, long j2, long j3, String str4) {
        Intent intent = new Intent(getActivity(), CloudVideoListActivity.class);
        intent.putExtra("cloud_video_device_id", str);
        if (!(str2 == null || str3 == null)) {
            intent.putExtra("cloud_video_m3u8", str2);
            intent.putExtra("cloud_video_uri", str3);
            intent.putExtra("cloud_video_duration", j2);
            intent.putExtra("cloud_video_timestamp", j3);
            intent.putExtra("cloud_video_uuid", str4);
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o5(Boolean bool) {
        boolean z2 = bool != null && bool.booleanValue();
        MenuItem menuItem = this.g4;
        if (menuItem != null) {
            menuItem.setIcon(z2 ? R.mipmap.home_menu_add_redpoint : R.mipmap.home_menu_add);
        }
    }

    private void p3(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, VideoPlayActivity.class);
            intent.putExtra("device_id_md5", str);
            intent.putExtra("online", true);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p4 */
    public /* synthetic */ void q4(View view) {
        W2();
        C0(WssAlexaActivity.class);
        com.tplink.iot.Utils.x0.q.c();
    }

    private void q3(BaseALIoTDevice baseALIoTDevice, String str) {
        int i2 = d0.f8495b[EnumMsgSubscribeType.fromString(str).ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                l3(baseALIoTDevice.getDeviceIdMD5(), str);
            } else {
                e3(baseALIoTDevice.getDeviceId(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q5(boolean z2) {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).r1(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(List<TDPIoTDevice> list) {
        if (list == null || list.isEmpty()) {
            TPLongMaterialDialogV2 tPLongMaterialDialogV2 = this.J4;
            if (tPLongMaterialDialogV2 != null) {
                tPLongMaterialDialogV2.dismiss();
                this.J4 = null;
            }
            g5();
            return;
        }
        b5(list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r4 */
    public /* synthetic */ void s4(View view) {
        W2();
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.samsung_smart_things);
        CommonWebActivity.s1(activity, string, "https://www.tapo.com/app/#/guidance/smartThings?locale=" + com.tplink.iot.model.about.d.f());
        com.tplink.iot.Utils.x0.q.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r5(boolean z2) {
        MenuItem menuItem = this.f4;
        if (menuItem != null) {
            menuItem.setIcon(z2 ? R.drawable.home_menu_message_redpoint_new : R.mipmap.home_menu_message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        HomeMainViewModel homeMainViewModel;
        String str = this.z4;
        if (str != null && (homeMainViewModel = this.R3) != null) {
            String str2 = this.C4;
            BaseALIoTDevice f02 = homeMainViewModel.f0(str);
            if (f02 != null && f02.getDeviceState() == EnumIoTDeviceState.LOADING) {
                return;
            }
            if (!EnumMsgSubscribeType.TAPO_HUB_TRIGGERED.getName().equals(this.C4) || f02 == null || !f02.isHub()) {
                if ((EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.getName().equals(this.C4) || EnumNotificationMsgType.TAPO_MOTION_SENSOR_TRIGGERED.getName().equals(this.C4) || EnumNotificationMsgType.TAPO_CONTACT_SENSOR_TRIGGERED.getName().equals(this.C4) || EnumNotificationMsgType.TAPO_SMART_BUTTON_TRIGGERED.getName().equals(this.C4)) && f02 != null && f02.isSensor()) {
                    s0.g();
                    FragmentActivity activity = getActivity();
                    if (f02.isDeviceOffLine()) {
                        if (activity != null) {
                            s0.s(activity, R.string.tip_device_offline);
                        }
                        n5();
                    } else if (f02.isOnline() && activity != null) {
                        SensorDetailActivity.E1(activity, f02.getDeviceIdMD5(), this.C4);
                    }
                    this.z4 = null;
                    this.C4 = null;
                } else if (!(f02 instanceof ALCameraDevice)) {
                    this.z4 = null;
                    n5();
                    s0.g();
                } else {
                    ALCameraDevice aLCameraDevice = (ALCameraDevice) f02;
                    if (aLCameraDevice.isCameraLocked()) {
                        this.z4 = null;
                        s0.g();
                        FragmentActivity activity2 = getActivity();
                        if (activity2 != null) {
                            com.tplink.iot.viewmodel.home.u.f(activity2, aLCameraDevice.getLockMessage());
                        }
                    } else if (f02.isDeviceOffLine()) {
                        this.z4 = null;
                        s0.g();
                        FragmentActivity activity3 = getActivity();
                        if (activity3 != null) {
                            s0.s(activity3, R.string.tip_device_offline);
                        }
                        n5();
                    } else {
                        this.z4 = null;
                        this.C4 = null;
                        q3(f02, str2);
                    }
                }
            } else {
                this.z4 = null;
                this.C4 = null;
                s0.g();
                FragmentActivity activity4 = getActivity();
                if (f02.isDeviceOffLine()) {
                    if (activity4 != null) {
                        s0.s(activity4, R.string.tip_device_offline);
                    }
                    n5();
                } else if (f02.isOnline() && activity4 != null) {
                    HubDetailActivity.K1(activity4, f02.getDeviceIdMD5());
                }
            }
        }
    }

    private void t3() {
        this.c4 = this.y.findViewById(R.id.view_line_remove_favorite);
        this.d4 = this.y.findViewById(R.id.view_line_move);
        this.e4 = this.y.findViewById(R.id.view_line_share);
        TextView textView = (TextView) this.y.findViewById(R.id.iv_delete_item);
        this.Y3 = textView;
        textView.setAlpha(1.0f);
        this.Y3.setClickable(true);
        this.Y3.setOnClickListener(this);
        TextView textView2 = (TextView) this.y.findViewById(R.id.tv_device_share);
        this.b4 = textView2;
        textView2.setAlpha(1.0f);
        this.b4.setClickable(true);
        this.b4.setOnClickListener(this);
        TextView textView3 = (TextView) this.y.findViewById(R.id.tv_move_location);
        this.a4 = textView3;
        textView3.setAlpha(1.0f);
        this.a4.setClickable(true);
        this.a4.setOnClickListener(this);
        TextView textView4 = (TextView) this.y.findViewById(R.id.tv_remove_favorite);
        this.Z3 = textView4;
        textView4.setAlpha(1.0f);
        this.Z3.setClickable(true);
        this.Z3.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t4 */
    public /* synthetic */ void u4(View view) {
        W2();
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.yandex_alice);
        CommonWebActivity.s1(activity, string, "https://www.tapo.com/app/#/guidance/alice?locale=" + com.tplink.iot.model.about.d.f());
        com.tplink.iot.Utils.x0.q.b();
    }

    @SuppressLint({"CheckResult"})
    private void u3() {
        if (getActivity() != null) {
            b.a.a.a.a.a.d.a(AppContext.f6185c).L0(io.reactivex.l0.a.c()).L(b.a.a.a.a.a.b.b(NetworkInfo.State.CONNECTED)).L(b.a.a.a.a.a.b.c(0, 1)).l0(io.reactivex.d0.b.a.a()).G0(new w());
        }
    }

    private void v3() {
        this.z = (RecyclerView) this.y.findViewById(R.id.rv_main_list);
        HomeMainAdapter homeMainAdapter = new HomeMainAdapter(getActivity());
        this.p0 = homeMainAdapter;
        homeMainAdapter.u(this);
        this.p0.setHasStableIds(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        if (Build.VERSION.SDK_INT < 21) {
            gridLayoutManager.setSmoothScrollbarEnabled(true);
            gridLayoutManager.setAutoMeasureEnabled(true);
            this.z.setHasFixedSize(true);
            this.z.setNestedScrollingEnabled(false);
        }
        this.z.setLayoutManager(gridLayoutManager);
        this.z.setAdapter(this.p0);
        PullToRefreshContainer pullToRefreshContainer = (PullToRefreshContainer) this.y.findViewById(R.id.srv_home_list);
        this.T3 = pullToRefreshContainer;
        pullToRefreshContainer.setHeader(new com.tplink.iot.widget.g());
        this.T3.setEnableFooter(false);
        this.T3.setListener(new n());
        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback(this.p0);
        this.m4 = itemTouchHelperCallback;
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4 */
    public /* synthetic */ void w4(View view) {
        W2();
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.mail_ru);
        CommonWebActivity.s1(activity, string, "https://www.tapo.com/app/#/guidance/mailRu?locale=" + com.tplink.iot.model.about.d.f());
        com.tplink.iot.Utils.x0.q.l();
    }

    private void w3() {
        this.p1 = new HomeShortcutAdapter(getActivity());
        this.p2 = (RecyclerView) this.y.findViewById(R.id.recycle_view_shortcut);
        this.p2.addItemDecoration(new HomeShortcutItemDecoration(getActivity()));
        this.p2.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.p2.setItemAnimator(new DefaultItemAnimator());
        this.p2.setAdapter(this.p1);
        this.p2.setVisibility(8);
        this.p1.q(new o());
    }

    private void x3() {
        if (getContext() != null) {
            this.l4 = com.tplink.iot.Utils.k.a(getContext(), 100.0f);
        }
        this.h4 = this.y.findViewById(R.id.ll_title);
        this.i4 = (TextView) this.y.findViewById(R.id.title_scale_scroll_view);
        this.i4.setMaxWidth((getResources().getDisplayMetrics().widthPixels * 3) / 5);
        ImageView imageView = (ImageView) this.y.findViewById(R.id.title_arrow);
        this.j4 = imageView;
        imageView.setVisibility(8);
        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) this.h4.getLayoutParams();
        layoutParams.setMargins(((FrameLayout.LayoutParams) layoutParams).leftMargin, ((FrameLayout.LayoutParams) layoutParams).topMargin, ((FrameLayout.LayoutParams) layoutParams).rightMargin, this.l4);
        this.h4.setLayoutParams(layoutParams);
        this.h4.setOnClickListener(this);
        TextView textView = (TextView) this.y.findViewById(R.id.camera_preview_count);
        this.H3 = textView;
        textView.setVisibility(8);
        this.H3.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4 */
    public /* synthetic */ void y4(View view) {
        AlertDialog alertDialog = this.v4;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.v4.dismiss();
        }
        j5();
    }

    private void y3() {
        this.y.findViewById(R.id.iv_top_operation_close).setOnClickListener(new p());
        View findViewById = this.y.findViewById(R.id.tv_top_operation_save);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new q());
        View findViewById2 = this.y.findViewById(R.id.view_status_bar_cover);
        if (getActivity() != null) {
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = com.tplink.iot.Utils.j.b(getActivity());
            findViewById2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z3(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.x4 = b.d.w.h.a.g(str);
        } else {
            this.x4 = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4 */
    public /* synthetic */ void A4(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        BaseALIoTDevice<?> baseALIoTDevice;
        if (aVar != null && (baseALIoTDevice = (BaseALIoTDevice) aVar.a()) != null) {
            this.I4.b(getActivity(), baseALIoTDevice);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void J0(List<com.tplink.iot.model.home.e> list) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void O0() {
        View view = this.V3;
        if (view != null) {
            com.tplink.iot.Utils.x.c(view);
            this.p0.c(false);
            this.U3.setAlpha(1.0f);
            this.U3.setVisibility(8);
            V4(true);
            if (!this.S3) {
                this.R3.V1();
            }
            this.T3.setEnableHeader(true);
            this.h4.setVisibility(0);
            this.p2.setAlpha(1.0f);
            this.p1.p(false);
            this.p3.setAlpha(1.0f);
            this.H3.setAlpha(1.0f);
            this.Q3.setAlpha(1.0f);
        }
        n5();
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public FamilyInfo P0() {
        return this.R3.g();
    }

    @Override // com.tplink.iot.adapter.home.h
    public void b(int i2) {
        this.f6075c.post(new r(i2));
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        if (!B3()) {
            return super.d();
        }
        O0();
        return true;
    }

    @Override // com.tplink.iot.adapter.home.h
    public void f(int i2, int i3) {
        this.R3.T0(i3, this.p0.m());
        com.tplink.iot.Utils.x0.o.i();
    }

    public void f3() {
        this.R3.o0();
    }

    @Override // com.tplink.iot.adapter.home.h
    public void i(com.tplink.iot.model.home.e eVar) {
        if (eVar instanceof com.tplink.iot.model.home.k) {
            U0((com.tplink.iot.model.home.k) eVar);
        } else if (eVar instanceof com.tplink.iot.model.home.g) {
            V0((com.tplink.iot.model.home.g) eVar);
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void j(com.tplink.iot.model.home.e eVar) {
        this.R3.u();
        this.m4.a(this.R3.k1());
        if (this.R3.k1()) {
            this.Z3.setVisibility(0);
            this.b4.setVisibility(0);
            this.a4.setVisibility(0);
            this.d4.setVisibility(0);
            this.e4.setVisibility(0);
            this.c4.setVisibility(0);
        } else {
            this.Z3.setVisibility(8);
            this.b4.setVisibility(8);
            this.a4.setVisibility(8);
            this.d4.setVisibility(8);
            this.e4.setVisibility(8);
            this.c4.setVisibility(8);
        }
        V4(false);
        com.tplink.iot.Utils.x.a(this.U3);
        this.U3.setAlpha(0.8f);
        K4();
        this.T3.setEnableHeader(false);
        this.h4.setVisibility(4);
        this.p2.setAlpha(0.6f);
        this.p1.p(true);
        this.p3.setAlpha(0.6f);
        this.H3.setAlpha(0.6f);
        this.Q3.setAlpha(0.6f);
        O2();
        com.tplink.iot.Utils.x0.o.h();
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void k1(String str) {
        com.tplink.iot.Utils.x0.o.p(str);
    }

    @Override // com.tplink.iot.adapter.home.h
    public void l(int i2, com.tplink.iot.model.home.e eVar, boolean z2) {
        if (eVar instanceof com.tplink.iot.model.home.g) {
            Y0((com.tplink.iot.model.home.g) eVar, z2);
        } else if (eVar instanceof com.tplink.iot.model.home.k) {
            X0((com.tplink.iot.model.home.k) eVar, z2);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void l1(BaseALIoTDevice baseALIoTDevice, boolean z2) {
        String deviceIdMD5 = baseALIoTDevice.getDeviceIdMD5();
        if (baseALIoTDevice.isPlug()) {
            com.tplink.iot.Utils.x0.o.q(deviceIdMD5, z2);
        } else if (baseALIoTDevice.isBulb()) {
            com.tplink.iot.Utils.x0.o.g(deviceIdMD5, z2);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void o1() {
        this.f6075c.post(new u());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle == null) {
            this.R3.e0(false);
        } else {
            this.R3.e0(bundle.getBoolean("app_marketing_source", false));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1001) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("REGION_CODE");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.o4)) {
                    com.tplink.libtpnetwork.Utils.o.h0().v0(this.o4, stringExtra);
                    this.R3.l2(this.o4, this.q4, stringExtra);
                }
            } else if (i3 == 101) {
                this.R3.I1();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.camera_preview_count /* 2131362179 */:
                if (!B3()) {
                    Intent intent = new Intent(getContext(), CameraPreviewActivity.class);
                    intent.putExtra(CameraPreviewActivity.z.a(), this.o4);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    com.tplink.iot.Utils.x0.o.r();
                    return;
                }
                return;
            case R.id.card_next_event /* 2131362193 */:
                if (!B3() && this.R3.g() != null && this.R3.g().getId() != null) {
                    NextEventListActivity.g1(getActivity(), this.R3.g().getId());
                    com.tplink.iot.Utils.x0.o.n();
                    return;
                }
                return;
            case R.id.cl_home_empty_view /* 2131362245 */:
                C0(SelectCategoryNewActivity.class);
                return;
            case R.id.iv_delete_item /* 2131363025 */:
                A1(this.p0.n());
                com.tplink.iot.Utils.x0.o.t(this.p0.n());
                return;
            case R.id.ll_title /* 2131363350 */:
                if (!B3() && this.R3.k1() && !this.R3.h1()) {
                    d5(view);
                    return;
                }
                return;
            case R.id.tv_all_device /* 2131364340 */:
                if (!B3()) {
                    d3();
                    C0(HomeAllDevicesActivity.class);
                    com.tplink.iot.Utils.x0.o.f();
                    return;
                }
                return;
            case R.id.tv_device_share /* 2131364414 */:
                u1(this.p0.n());
                com.tplink.iot.Utils.x0.o.w(this.p0.n());
                return;
            case R.id.tv_move_location /* 2131364532 */:
                L0(this.p0.n());
                com.tplink.iot.Utils.x0.o.s(this.p0.n());
                return;
            case R.id.tv_remove_favorite /* 2131364599 */:
                N0(this.p0.n());
                com.tplink.iot.Utils.x0.o.y(this.p0.n());
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_home_toolbar, menu);
        this.f4 = menu.findItem(R.id.action_message);
        this.g4 = menu.findItem(R.id.action_add_more);
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null) {
            Boolean value = homeMainViewModel.B0().getValue();
            r5(value != null && value.booleanValue());
            o5(this.R3.n0().getValue());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.y = layoutInflater.inflate(R.layout.app_bar_home, viewGroup, false);
        com.tplink.iot.view.quicksetup.base.d.J(getActivity(), this.y.findViewById(R.id.main_toolbar));
        setHasOptionsMenu(true);
        this.R3 = (HomeMainViewModel) ViewModelProviders.of(this).get(HomeMainViewModel.class);
        A3();
        p5(getContext());
        l5();
        M4();
        u3();
        b.d.n.f.b.l().f("tapo_pageid_home");
        return this.y;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null) {
            homeMainViewModel.i2();
        }
        X2();
        io.reactivex.e0.c cVar = this.D4;
        if (cVar != null) {
            cVar.dispose();
        }
        Dialog dialog = this.E4;
        if (dialog != null) {
            dialog.dismiss();
            this.E4 = null;
        }
        AlertDialog alertDialog = this.F4;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.F4 = null;
        }
        AlertDialog alertDialog2 = this.G4;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.G4 = null;
        }
        AlertDialog alertDialog3 = this.H4;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
            this.H4 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        if (!z2) {
            HomeMainViewModel homeMainViewModel = this.R3;
            if (homeMainViewModel != null) {
                homeMainViewModel.M1();
            }
            n5();
            return;
        }
        HomeMainViewModel homeMainViewModel2 = this.R3;
        if (homeMainViewModel2 != null) {
            homeMainViewModel2.L1();
        }
        O2();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (B3()) {
            return super.onOptionsItemSelected(menuItem);
        }
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_add_more) {
            C0(SelectCategoryNewActivity.class);
            com.tplink.iot.Utils.x0.o.e();
        } else if (itemId == R.id.action_message) {
            C0(NotificationCenterActivity.class);
            com.tplink.iot.Utils.x0.o.o();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HomeMainViewModel homeMainViewModel = this.R3;
        if (homeMainViewModel != null) {
            homeMainViewModel.L1();
        }
        O2();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isHidden()) {
            HomeMainViewModel homeMainViewModel = this.R3;
            if (homeMainViewModel != null) {
                homeMainViewModel.M1();
            }
            n5();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        S2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.tplink.iot.view.quicksetup.base.d.e(getActivity(), this.y.findViewById(R.id.view_status_bar_cover));
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void p1() {
        d3();
        if (com.tplink.libtpnetwork.Utils.o.h0().e("rate_us_time_stamp", 0L) == 0) {
            com.tplink.libtpnetwork.Utils.o.h0().j("rate_us_time_stamp", System.currentTimeMillis());
        }
    }

    public void p5(Context context) {
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            String g3 = g3(mainActivity);
            if (!(g3 == null || this.R3 == null)) {
                io.reactivex.e0.c cVar = this.D4;
                if (cVar != null) {
                    cVar.dispose();
                }
                O2();
                s0.l(getActivity());
                this.A4 = h3(mainActivity);
                this.C4 = j3(mainActivity);
                this.z4 = g3;
                this.B4 = i3(mainActivity);
            }
            this.M4 = mainActivity.g1();
            this.N4 = mainActivity.i1();
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void q1(List<com.tplink.iot.model.home.e> list) {
        boolean z2;
        this.R3.m(list);
        this.S3 = true;
        this.R3.U1(this.p0.m());
        O0();
        boolean z3 = false;
        if (list == null || list.isEmpty()) {
            z2 = false;
        } else {
            boolean z4 = false;
            for (com.tplink.iot.model.home.e eVar : list) {
                if (eVar instanceof com.tplink.iot.model.home.k) {
                    z3 = true;
                } else if (eVar instanceof com.tplink.iot.model.home.g) {
                    z4 = true;
                }
            }
            z2 = z3;
            z3 = z4;
        }
        com.tplink.iot.viewmodel.home.u.o(getActivity(), this.o4, z3, z2);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void r1(List<com.tplink.iot.model.home.e> list) {
        this.S3 = true;
        this.R3.o(list);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void s1(boolean z2, String str) {
        this.R3.p(false, str);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void t1(String str, boolean z2) {
        this.R3.s(str, z2);
    }
}
