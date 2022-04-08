package com.tplink.iot.view.ipcamera.setting.privacymask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import b.d.q.b.o;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityPrivacyMaskZonesBinding;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.privacymask.PrivacyMaskZonesViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: PrivacyMaskZonesActivity.kt */
/* loaded from: classes2.dex */
public final class PrivacyMaskZonesActivity extends BaseActivity implements ChangeableAreaView.a {
    private int H3;
    private int I3;
    private String J3;
    private ActivityPrivacyMaskZonesBinding K3;
    private PrivacyMaskZonesViewModel L3;
    private int p1;
    private ChangeableAreaView p2;
    public static final a z = new a(null);
    private static final String y = PrivacyMaskZonesActivity.class.getSimpleName();
    private final int p0 = com.tplink.libtpnetwork.cameranetwork.util.e.a(32, AppContext.f6185c);
    private final List<ChangeableAreaView> p3 = new ArrayList();

    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String str) {
            j.e(context, "context");
            Intent intent = new Intent(context, PrivacyMaskZonesActivity.class);
            intent.putExtra("device_id_md5", str);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements com.tplink.libtpnetwork.Utils.f0.b<String> {
        b() {
        }

        /* renamed from: b */
        public final void a(String str) {
            TSnackbar.y(PrivacyMaskZonesActivity.this, str, -1).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            j.e(v, "v");
            PrivacyMaskZonesActivity.this.onClick(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PrivacyMaskZonesActivity privacyMaskZonesActivity = PrivacyMaskZonesActivity.this;
            FrameLayout frameLayout = PrivacyMaskZonesActivity.e1(privacyMaskZonesActivity).N3;
            j.d(frameLayout, "binding.settingAreaContainer");
            privacyMaskZonesActivity.H3 = frameLayout.getWidth();
            PrivacyMaskZonesActivity privacyMaskZonesActivity2 = PrivacyMaskZonesActivity.this;
            FrameLayout frameLayout2 = PrivacyMaskZonesActivity.e1(privacyMaskZonesActivity2).N3;
            j.d(frameLayout2, "binding.settingAreaContainer");
            privacyMaskZonesActivity2.I3 = frameLayout2.getHeight();
            PrivacyMaskZonesActivity.this.y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> {
        e() {
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.c cVar) {
            if (cVar != null && !TextUtils.isEmpty(cVar.i())) {
                com.bumptech.glide.c.u(PrivacyMaskZonesActivity.this.getApplication()).s(cVar.i()).x0(PrivacyMaskZonesActivity.e1(PrivacyMaskZonesActivity.this).P3);
                PrivacyMaskZonesActivity.this.y1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements kotlin.jvm.b.a<p> {
        f() {
            super(0);
        }

        public final void a() {
            PrivacyMaskZonesActivity.this.finish();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ p invoke() {
            a();
            return p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrivacyMaskZonesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrivacyMaskZonesActivity.this.onBackPressed();
        }
    }

    private final void A1() {
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        Toolbar toolbar = activityPrivacyMaskZonesBinding.S3;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new g());
        }
    }

    private final void B1() {
        int a2;
        if (!v1()) {
            Window window = getWindow();
            j.d(window, "window");
            View decorView = window.getDecorView();
            j.d(decorView, "window.decorView");
            decorView.setSystemUiVisibility(0);
            Window window2 = getWindow();
            j.d(window2, "window");
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags &= -1025;
            Window window3 = getWindow();
            j.d(window3, "window");
            window3.setAttributes(attributes);
            getWindow().clearFlags(512);
            ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
            if (activityPrivacyMaskZonesBinding == null) {
                j.t("binding");
            }
            FrameLayout frameLayout = activityPrivacyMaskZonesBinding.N3;
            j.d(frameLayout, "binding.settingAreaContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = getWindowManager();
            j.d(windowManager, "windowManager");
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            marginLayoutParams.width = displayMetrics.widthPixels;
            int a3 = o.a(this, 216.0f);
            int a4 = ((int) ((displayMetrics.widthPixels - a2) / 1.7777778f)) + o.a(this, 30.0f);
            if (a3 < a4) {
                a3 = a4;
            }
            marginLayoutParams.height = a3;
        }
    }

    private final void C1() {
        int i = this.p1;
        if (i >= 0 && 4 > i) {
            PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
            if (privacyMaskZonesViewModel == null) {
                j.t("viewModel");
            }
            privacyMaskZonesViewModel.a.set(true);
            return;
        }
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel2 = this.L3;
        if (privacyMaskZonesViewModel2 == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel2.a.set(false);
    }

    private final void D1(ChangeableAreaView changeableAreaView) {
        ChangeableAreaView changeableAreaView2 = this.p2;
        if (changeableAreaView2 != null) {
            j.c(changeableAreaView2);
            changeableAreaView2.i(false);
        }
        this.p2 = changeableAreaView;
        j.c(changeableAreaView);
        changeableAreaView.i(true);
    }

    public static final /* synthetic */ ActivityPrivacyMaskZonesBinding e1(PrivacyMaskZonesActivity privacyMaskZonesActivity) {
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = privacyMaskZonesActivity.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        return activityPrivacyMaskZonesBinding;
    }

    private final void j1() {
        int i = this.p1;
        if (i >= 4) {
            C1();
            return;
        }
        this.p1 = i + 1;
        ChangeableAreaView changeableAreaView = new ChangeableAreaView(this);
        changeableAreaView.setAreaViewListener(this);
        int i2 = this.H3;
        int i3 = this.I3;
        p1(changeableAreaView, new com.tplink.libtpnetwork.cameranetwork.business.model.d(2500, (int) ((i2 * 2500.0d) / i3), 3750, (10000 - ((int) ((i2 * 2500.0d) / i3))) / 2));
        this.p3.add(changeableAreaView);
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding.N3.addView(changeableAreaView);
        D1(changeableAreaView);
        C1();
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel.f10377b.set(true);
    }

    private final void k1(ChangeableAreaView changeableAreaView) {
        com.tplink.libtpnetwork.cameranetwork.business.model.d m1 = m1(changeableAreaView);
        this.p3.remove(changeableAreaView);
        this.p3.add(changeableAreaView);
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding.N3.removeView(changeableAreaView);
        p1(changeableAreaView, m1);
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding2 = this.K3;
        if (activityPrivacyMaskZonesBinding2 == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding2.N3.addView(changeableAreaView, this.p3.size());
    }

    private final void l1() {
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel.a.set(true);
        for (ChangeableAreaView changeableAreaView : this.p3) {
            if (changeableAreaView != null) {
                ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
                if (activityPrivacyMaskZonesBinding == null) {
                    j.t("binding");
                }
                activityPrivacyMaskZonesBinding.N3.removeView(changeableAreaView);
            }
        }
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel2 = this.L3;
        if (privacyMaskZonesViewModel2 == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel2.f10377b.set(false);
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel3 = this.L3;
        if (privacyMaskZonesViewModel3 == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel3.f10378c.set(false);
        this.p3.clear();
        this.p1 = 0;
    }

    private final com.tplink.libtpnetwork.cameranetwork.business.model.d m1(ChangeableAreaView changeableAreaView) {
        com.tplink.libtpnetwork.cameranetwork.business.model.d dVar = new com.tplink.libtpnetwork.cameranetwork.business.model.d();
        dVar.g((int) (((changeableAreaView.getLeft() * 10000) * 1.0d) / (this.H3 - this.p0)));
        dVar.h((int) (((changeableAreaView.getTop() * 10000) * 1.0d) / (this.I3 - this.p0)));
        int width = changeableAreaView.getWidth();
        int i = this.p0;
        dVar.f((int) ((((width - i) * 10000) * 1.0d) / (this.H3 - i)));
        int height = changeableAreaView.getHeight();
        int i2 = this.p0;
        dVar.e((int) ((((height - i2) * 10000) * 1.0d) / (this.I3 - i2)));
        return dVar;
    }

    private final List<com.tplink.libtpnetwork.cameranetwork.business.model.d> n1() {
        ArrayList arrayList = new ArrayList();
        for (ChangeableAreaView changeableAreaView : this.p3) {
            if (changeableAreaView != null) {
                arrayList.add(m1(changeableAreaView));
            }
        }
        String str = y;
        b.d.w.c.a.c(str, "stash region size" + arrayList.size());
        return arrayList;
    }

    private final void o1(boolean z2) {
        if (z2) {
            z1(this, false);
            Window window = getWindow();
            j.d(window, "window");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            Window window2 = getWindow();
            j.d(window2, "window");
            window2.setAttributes(attributes);
            return;
        }
        z1(this, true);
        Window window3 = getWindow();
        j.d(window3, "window");
        WindowManager.LayoutParams attributes2 = window3.getAttributes();
        attributes2.flags &= -1025;
        Window window4 = getWindow();
        j.d(window4, "window");
        window4.setAttributes(attributes2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_region /* 2131361939 */:
            case R.id.add_region_lan /* 2131361940 */:
                j1();
                return;
            case R.id.change_orientation /* 2131362222 */:
                PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
                if (privacyMaskZonesViewModel == null) {
                    j.t("viewModel");
                }
                privacyMaskZonesViewModel.o(n1());
                setRequestedOrientation(0);
                return;
            case R.id.change_orientation_lan /* 2131362223 */:
                PrivacyMaskZonesViewModel privacyMaskZonesViewModel2 = this.L3;
                if (privacyMaskZonesViewModel2 == null) {
                    j.t("viewModel");
                }
                privacyMaskZonesViewModel2.o(n1());
                setRequestedOrientation(1);
                return;
            case R.id.close_lan /* 2131362256 */:
                onBackPressed();
                return;
            case R.id.delete_region /* 2131362389 */:
            case R.id.delete_region_lan /* 2131362390 */:
                l1();
                return;
            case R.id.done_lan /* 2131362489 */:
                x1();
                return;
            case R.id.ok_btn /* 2131363582 */:
                x1();
                return;
            default:
                return;
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private final void p1(ChangeableAreaView changeableAreaView, com.tplink.libtpnetwork.cameranetwork.business.model.d dVar) {
        int i;
        int i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        double d2 = 10000;
        layoutParams.leftMargin = (int) (((dVar.c() * 1.0d) / d2) * (this.H3 - this.p0));
        layoutParams.topMargin = (int) (((dVar.d() * 1.0d) / d2) * (this.I3 - this.p0));
        int i3 = this.H3;
        layoutParams.width = (int) ((((dVar.b() * 1.0d) / d2) * (i3 - i)) + this.p0);
        int i4 = this.I3;
        layoutParams.height = (int) ((((dVar.a() * 1.0d) / d2) * (i4 - i2)) + this.p0);
        p pVar = p.a;
        changeableAreaView.setLayoutParams(layoutParams);
    }

    private final void q1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.J3 = stringExtra;
        if (stringExtra == null) {
            j.t("mDeviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(PrivacyMaskZonesViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…nesViewModel::class.java)");
        this.L3 = (PrivacyMaskZonesViewModel) viewModel;
    }

    private final void r1() {
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        com.tplink.libtpnetwork.Utils.j.c(privacyMaskZonesViewModel.k(), this, new b());
    }

    private final void s1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_privacy_mask_zones);
        j.d(contentView, "DataBindingUtil.setConte…ivity_privacy_mask_zones)");
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = (ActivityPrivacyMaskZonesBinding) contentView;
        this.K3 = activityPrivacyMaskZonesBinding;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        activityPrivacyMaskZonesBinding.i(privacyMaskZonesViewModel);
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding2 = this.K3;
        if (activityPrivacyMaskZonesBinding2 == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding2.h(new c());
        o1(v1());
        B1();
        A1();
        u1();
        w1();
    }

    private final void t1(List<? extends com.tplink.libtpnetwork.cameranetwork.business.model.d> list) {
        this.p3.clear();
        this.p1 = list.size();
        C1();
        String str = y;
        b.d.w.c.a.c(str, "load region size = " + list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            ChangeableAreaView changeableAreaView = new ChangeableAreaView(this);
            if (Build.VERSION.SDK_INT >= 23) {
                changeableAreaView.setAreaInnerColor(getResources().getColor(R.color.black_60, getTheme()));
            } else {
                changeableAreaView.setAreaInnerColor(getResources().getColor(R.color.black_60));
            }
            this.p3.add(changeableAreaView);
            changeableAreaView.setAreaViewListener(this);
            p1(changeableAreaView, (com.tplink.libtpnetwork.cameranetwork.business.model.d) list.get(i));
            ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
            if (activityPrivacyMaskZonesBinding == null) {
                j.t("binding");
            }
            int i2 = i + 1;
            activityPrivacyMaskZonesBinding.N3.addView(changeableAreaView, i2);
            if (i == list.size() - 1) {
                D1(changeableAreaView);
            }
            com.tplink.libtpnetwork.cameranetwork.business.model.d dVar = (com.tplink.libtpnetwork.cameranetwork.business.model.d) list.get(i);
            if (dVar.c() == 0 && dVar.d() == 0 && dVar.a() == 10000 && dVar.b() == 10000) {
                PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
                if (privacyMaskZonesViewModel == null) {
                    j.t("viewModel");
                }
                privacyMaskZonesViewModel.f10378c.set(true);
            }
            i = i2;
        }
    }

    private final void u1() {
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding.getRoot().post(new d());
    }

    private final boolean v1() {
        Resources resources = getResources();
        j.d(resources, "resources");
        return resources.getConfiguration().orientation == 2;
    }

    private final void w1() {
        String str = this.J3;
        if (str == null) {
            j.t("mDeviceIdMD5");
        }
        l.e(str, new e());
    }

    private final void x1() {
        List<com.tplink.libtpnetwork.cameranetwork.business.model.d> n1 = n1();
        int size = n1.size();
        String str = this.J3;
        if (str == null) {
            j.t("mDeviceIdMD5");
        }
        w.b(str, size > 0, size);
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel.m(n1, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1() {
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        List<com.tplink.libtpnetwork.cameranetwork.business.model.d> value = privacyMaskZonesViewModel.j().getValue();
        if (value != null) {
            l1();
            j.d(value, "this");
            t1(value);
            PrivacyMaskZonesViewModel privacyMaskZonesViewModel2 = this.L3;
            if (privacyMaskZonesViewModel2 == null) {
                j.t("viewModel");
            }
            privacyMaskZonesViewModel2.f10377b.set(!value.isEmpty());
        }
    }

    private final void z1(Activity activity, boolean z2) {
        ViewGroup parent = (ViewGroup) activity.findViewById(16908290);
        j.d(parent, "parent");
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(z2);
                ((ViewGroup) childAt).setClipToPadding(z2);
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void H(ChangeableAreaView view) {
        j.e(view, "view");
        if (this.p2 != view) {
            k1(view);
        }
        D1(view);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void O(ChangeableAreaView changeableAreaView) {
        this.p3.remove(changeableAreaView);
        ActivityPrivacyMaskZonesBinding activityPrivacyMaskZonesBinding = this.K3;
        if (activityPrivacyMaskZonesBinding == null) {
            j.t("binding");
        }
        activityPrivacyMaskZonesBinding.N3.removeView(changeableAreaView);
        boolean z2 = true;
        if (!this.p3.isEmpty()) {
            ChangeableAreaView changeableAreaView2 = (ChangeableAreaView) kotlin.collections.l.F(this.p3);
            this.p2 = changeableAreaView2;
            j.c(changeableAreaView2);
            changeableAreaView2.i(true);
        }
        this.p1--;
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel.a.set(true);
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel2 = this.L3;
        if (privacyMaskZonesViewModel2 == null) {
            j.t("viewModel");
        }
        ObservableBoolean observableBoolean = privacyMaskZonesViewModel2.f10377b;
        if (this.p1 == 0) {
            z2 = false;
        }
        observableBoolean.set(z2);
        if (changeableAreaView != null) {
            com.tplink.libtpnetwork.cameranetwork.business.model.d m1 = m1(changeableAreaView);
            if (m1.c() == 0 && m1.d() == 0 && m1.a() == 10000 && m1.b() == 10000) {
                PrivacyMaskZonesViewModel privacyMaskZonesViewModel3 = this.L3;
                if (privacyMaskZonesViewModel3 == null) {
                    j.t("viewModel");
                }
                privacyMaskZonesViewModel3.f10378c.set(false);
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void h0(ChangeableAreaView changeableAreaView) {
        PrivacyMaskZonesViewModel privacyMaskZonesViewModel = this.L3;
        if (privacyMaskZonesViewModel == null) {
            j.t("viewModel");
        }
        privacyMaskZonesViewModel.h(n1());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (v1()) {
            setRequestedOrientation(1);
        } else {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        List<com.tplink.libtpnetwork.cameranetwork.business.model.d> n1 = n1();
        setContentView(R.layout.activity_motion_region_setting);
        u1();
        o1(v1());
        l1();
        t1(n1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q1();
        s1();
        r1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.action_edit_done) {
            x1();
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        C1();
    }
}
