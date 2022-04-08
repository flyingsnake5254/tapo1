package com.tplink.iot.dailysummary.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity;
import com.tplink.iot.dailysummary.view.adapter.SummaryHomeAdapter;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.dailysummary.widget.SummarySettingDialogFragment;
import com.tplink.iot.databinding.ActivityDailySummaryBinding;
import com.tplink.iot.databinding.LayoutDailySummarySettingsBinding;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* compiled from: DailySummaryActivity.kt */
/* loaded from: classes2.dex */
public final class DailySummaryActivity extends BaseActivity {
    public static final a y = new a(null);
    private View H3;
    private View I3;
    private View J3;
    private View K3;
    private View L3;
    private RecyclerView M3;
    private View N3;
    private View O3;
    private View P3;
    private View Q3;
    private View R3;
    private View S3;
    private View T3;
    private SwitchCompat U3;
    private SwitchCompat V3;
    private TPSmartRefreshLayout W3;
    private boolean p0;
    private String p1;
    private DailySummaryViewModel p2;
    private ActivityDailySummaryBinding p3;
    private SummaryHomeAdapter z;

    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceId) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceId, "deviceId");
            Intent intent = new Intent(context, DailySummaryActivity.class);
            intent.putExtra("deviceId", deviceId);
            context.startActivity(intent);
            com.tplink.iot.e.a.c.k.l();
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements com.scwang.smart.refresh.layout.c.g {
        b() {
        }

        @Override // com.scwang.smart.refresh.layout.c.g
        public final void m(com.scwang.smart.refresh.layout.a.f it) {
            kotlin.jvm.internal.j.e(it, "it");
            DailySummaryActivity.this.n1();
        }
    }

    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements SummarySettingDialogFragment.b {
        final /* synthetic */ SummarySettingDialogFragment a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DailySummaryActivity f6272b;

        c(SummarySettingDialogFragment summarySettingDialogFragment, DailySummaryActivity dailySummaryActivity) {
            this.a = summarySettingDialogFragment;
            this.f6272b = dailySummaryActivity;
        }

        @Override // com.tplink.iot.dailysummary.widget.SummarySettingDialogFragment.b
        public void a() {
            this.a.dismiss();
            s0.l(this.f6272b);
            DailySummaryActivity.f1(this.f6272b).n0();
        }

        @Override // com.tplink.iot.dailysummary.widget.SummarySettingDialogFragment.b
        public void b() {
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DailySummaryActivity.f1(DailySummaryActivity.this).Q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).R(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).R(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).p0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).p0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.dailysummary.model.b value = DailySummaryActivity.f1(DailySummaryActivity.this).h0().getValue();
            if (value != null) {
                SummaryPlayActivity.y.a(DailySummaryActivity.this, value.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).k(0, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DailySummaryActivity.f1(DailySummaryActivity.this).k(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class o implements CompoundButton.OnCheckedChangeListener {
        o() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DailySummaryActivity.f1(DailySummaryActivity.this).P(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class p<T> implements Observer<Boolean> {
        p() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            DailySummaryActivity.e1(DailySummaryActivity.this).q();
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(DailySummaryActivity.this);
            } else if (s0.j()) {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class q<T> implements Observer<Boolean> {
        q() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (!bool.booleanValue()) {
                DailySummaryActivity dailySummaryActivity = DailySummaryActivity.this;
                s0.p(dailySummaryActivity, dailySummaryActivity.getString(R.string.home_network_unstable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class r<T> implements Observer<Boolean> {
        r() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            DailySummaryActivity dailySummaryActivity = DailySummaryActivity.this;
            kotlin.jvm.internal.j.d(it, "it");
            dailySummaryActivity.p0 = it.booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class s<T> implements Observer<Boolean> {
        s() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (!bool.booleanValue()) {
                DailySummaryActivity dailySummaryActivity = DailySummaryActivity.this;
                s0.p(dailySummaryActivity, dailySummaryActivity.getString(R.string.home_network_unstable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class t<T> implements Observer<Boolean> {
        t() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (!bool.booleanValue()) {
                DailySummaryActivity dailySummaryActivity = DailySummaryActivity.this;
                s0.p(dailySummaryActivity, dailySummaryActivity.getString(R.string.home_network_unstable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailySummaryActivity.kt */
    /* loaded from: classes2.dex */
    public static final class u<T> implements Observer<Boolean> {
        u() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                DailySummaryActivity dailySummaryActivity = DailySummaryActivity.this;
                String string = dailySummaryActivity.getString(R.string.daily_summary_create_successfully_hint);
                kotlin.jvm.internal.j.d(string, "getString(R.string.daily…create_successfully_hint)");
                com.tplink.iot.e.a.a.c(dailySummaryActivity, string, true);
                return;
            }
            DailySummaryActivity dailySummaryActivity2 = DailySummaryActivity.this;
            s0.p(dailySummaryActivity2, dailySummaryActivity2.getString(R.string.home_network_unstable));
        }
    }

    public static final /* synthetic */ TPSmartRefreshLayout e1(DailySummaryActivity dailySummaryActivity) {
        TPSmartRefreshLayout tPSmartRefreshLayout = dailySummaryActivity.W3;
        if (tPSmartRefreshLayout == null) {
            kotlin.jvm.internal.j.t("mRefreshLayout");
        }
        return tPSmartRefreshLayout;
    }

    public static final /* synthetic */ DailySummaryViewModel f1(DailySummaryActivity dailySummaryActivity) {
        DailySummaryViewModel dailySummaryViewModel = dailySummaryActivity.p2;
        if (dailySummaryViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        return dailySummaryViewModel;
    }

    private final void k1() {
        String it;
        if (getIntent().getBooleanExtra("playSummary", false) && (it = getIntent().getStringExtra("summaryDate")) != null) {
            SummaryPlayActivity.a aVar = SummaryPlayActivity.y;
            kotlin.jvm.internal.j.d(it, "it");
            aVar.a(this, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        startActivity(new Intent(this, SummaryHistoryActivity.class));
    }

    private final void m1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_daily_summary);
        ActivityDailySummaryBinding activityDailySummaryBinding = (ActivityDailySummaryBinding) contentView;
        DailySummaryViewModel dailySummaryViewModel = this.p2;
        if (dailySummaryViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        activityDailySummaryBinding.h(dailySummaryViewModel);
        activityDailySummaryBinding.setLifecycleOwner(this);
        ConstraintLayout toolbarDailySummary = activityDailySummaryBinding.L3;
        kotlin.jvm.internal.j.d(toolbarDailySummary, "toolbarDailySummary");
        this.H3 = toolbarDailySummary;
        ImageView btnDailySummaryBack = activityDailySummaryBinding.f6535f;
        kotlin.jvm.internal.j.d(btnDailySummaryBack, "btnDailySummaryBack");
        this.I3 = btnDailySummaryBack;
        ImageView btnSummarySettting = activityDailySummaryBinding.y;
        kotlin.jvm.internal.j.d(btnSummarySettting, "btnSummarySettting");
        this.J3 = btnSummarySettting;
        TextView btnSummaryListViewAll = activityDailySummaryBinding.x;
        kotlin.jvm.internal.j.d(btnSummaryListViewAll, "btnSummaryListViewAll");
        this.K3 = btnSummaryListViewAll;
        ImageView btnPlaySummary = activityDailySummaryBinding.q;
        kotlin.jvm.internal.j.d(btnPlaySummary, "btnPlaySummary");
        this.L3 = btnPlaySummary;
        RecyclerView recyclerSummaryHomeList = activityDailySummaryBinding.J3;
        kotlin.jvm.internal.j.d(recyclerSummaryHomeList, "recyclerSummaryHomeList");
        this.M3 = recyclerSummaryHomeList;
        TextView btnCreateYesterdaySummary = activityDailySummaryBinding.f6534d;
        kotlin.jvm.internal.j.d(btnCreateYesterdaySummary, "btnCreateYesterdaySummary");
        this.N3 = btnCreateYesterdaySummary;
        TextView btnCancelYesterdaySummary = activityDailySummaryBinding.f6533c;
        kotlin.jvm.internal.j.d(btnCancelYesterdaySummary, "btnCancelYesterdaySummary");
        this.O3 = btnCancelYesterdaySummary;
        TPSmartRefreshLayout refreshLayoutSummaryHome = activityDailySummaryBinding.K3;
        kotlin.jvm.internal.j.d(refreshLayoutSummaryHome, "refreshLayoutSummaryHome");
        this.W3 = refreshLayoutSummaryHome;
        LayoutDailySummarySettingsBinding layoutDailySummarySettingsBinding = activityDailySummaryBinding.p1;
        ConstraintLayout layoutSummarySettings = layoutDailySummarySettingsBinding.L3;
        kotlin.jvm.internal.j.d(layoutSummarySettings, "layoutSummarySettings");
        this.P3 = layoutSummarySettings;
        ImageView btnSummarySettingBack = layoutDailySummarySettingsBinding.f7227d;
        kotlin.jvm.internal.j.d(btnSummarySettingBack, "btnSummarySettingBack");
        this.Q3 = btnSummarySettingBack;
        TextView btnSaveSetting = layoutDailySummarySettingsBinding.f7226c;
        kotlin.jvm.internal.j.d(btnSaveSetting, "btnSaveSetting");
        this.R3 = btnSaveSetting;
        SwitchCompat switchAutoRotation = layoutDailySummarySettingsBinding.M3;
        kotlin.jvm.internal.j.d(switchAutoRotation, "switchAutoRotation");
        this.U3 = switchAutoRotation;
        SwitchCompat switchNotify = layoutDailySummarySettingsBinding.N3;
        kotlin.jvm.internal.j.d(switchNotify, "switchNotify");
        this.V3 = switchNotify;
        View btnVideoCombinationRecommended = layoutDailySummarySettingsBinding.q;
        kotlin.jvm.internal.j.d(btnVideoCombinationRecommended, "btnVideoCombinationRecommended");
        this.S3 = btnVideoCombinationRecommended;
        View btnVideoCombinationAll = layoutDailySummarySettingsBinding.f7228f;
        kotlin.jvm.internal.j.d(btnVideoCombinationAll, "btnVideoCombinationAll");
        this.T3 = btnVideoCombinationAll;
        kotlin.p pVar = kotlin.p.a;
        kotlin.jvm.internal.j.d(contentView, "DataBindingUtil.setConte…l\n            }\n        }");
        this.p3 = activityDailySummaryBinding;
        View view = this.H3;
        if (view == null) {
            kotlin.jvm.internal.j.t("mToolbar");
        }
        com.tplink.iot.view.quicksetup.base.d.J(this, view);
        DailySummaryViewModel dailySummaryViewModel2 = this.p2;
        if (dailySummaryViewModel2 == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        this.z = new SummaryHomeAdapter(this, dailySummaryViewModel2);
        RecyclerView recyclerView = this.M3;
        if (recyclerView == null) {
            kotlin.jvm.internal.j.t("mRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SummaryHomeAdapter summaryHomeAdapter = this.z;
        if (summaryHomeAdapter == null) {
            kotlin.jvm.internal.j.t("mAdapter");
        }
        recyclerView.setAdapter(summaryHomeAdapter);
        TPSmartRefreshLayout tPSmartRefreshLayout = this.W3;
        if (tPSmartRefreshLayout == null) {
            kotlin.jvm.internal.j.t("mRefreshLayout");
        }
        tPSmartRefreshLayout.Q(new SmartRefreshHeader(this));
        tPSmartRefreshLayout.G(true);
        tPSmartRefreshLayout.N(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        DailySummaryViewModel dailySummaryViewModel = this.p2;
        if (dailySummaryViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        dailySummaryViewModel.j0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        SummarySettingDialogFragment summarySettingDialogFragment = new SummarySettingDialogFragment();
        summarySettingDialogFragment.B0(new c(summarySettingDialogFragment, this));
        summarySettingDialogFragment.show(getSupportFragmentManager(), "SummarySettingDialogFragment");
    }

    private final void p1() {
        View view = this.I3;
        if (view == null) {
            kotlin.jvm.internal.j.t("mBackBtn");
        }
        view.setOnClickListener(new g());
        View view2 = this.J3;
        if (view2 == null) {
            kotlin.jvm.internal.j.t("mSettingBtn");
        }
        view2.setOnClickListener(new h());
        View view3 = this.Q3;
        if (view3 == null) {
            kotlin.jvm.internal.j.t("mSettingBackBtn");
        }
        view3.setOnClickListener(new i());
        View view4 = this.K3;
        if (view4 == null) {
            kotlin.jvm.internal.j.t("mViewAllBtn");
        }
        view4.setOnClickListener(new j());
        View view5 = this.R3;
        if (view5 == null) {
            kotlin.jvm.internal.j.t("mSettingSaveBtn");
        }
        view5.setOnClickListener(new k());
        View view6 = this.L3;
        if (view6 == null) {
            kotlin.jvm.internal.j.t("mPlayBtn");
        }
        view6.setOnClickListener(new l());
        View view7 = this.N3;
        if (view7 == null) {
            kotlin.jvm.internal.j.t("mYesterdayCreateBtn");
        }
        view7.setOnClickListener(new m());
        View view8 = this.O3;
        if (view8 == null) {
            kotlin.jvm.internal.j.t("mYesterdayCancelBtn");
        }
        view8.setOnClickListener(new n());
        SwitchCompat switchCompat = this.U3;
        if (switchCompat == null) {
            kotlin.jvm.internal.j.t("mSettingAutoRotationSwitch");
        }
        switchCompat.setOnCheckedChangeListener(new o());
        SwitchCompat switchCompat2 = this.V3;
        if (switchCompat2 == null) {
            kotlin.jvm.internal.j.t("mSettingNotifySwitch");
        }
        switchCompat2.setOnCheckedChangeListener(new d());
        View view9 = this.S3;
        if (view9 == null) {
            kotlin.jvm.internal.j.t("mSettingCombinationRecommendedBtn");
        }
        view9.setOnClickListener(new e());
        View view10 = this.T3;
        if (view10 == null) {
            kotlin.jvm.internal.j.t("mSettingCombinationAllBtn");
        }
        view10.setOnClickListener(new f());
    }

    private final void q1() {
        DailySummaryViewModel dailySummaryViewModel = this.p2;
        if (dailySummaryViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
        }
        dailySummaryViewModel.p().observe(this, new p());
        dailySummaryViewModel.o().observe(this, new q());
        dailySummaryViewModel.b0().observe(this, new r());
        dailySummaryViewModel.V().observe(this, new s());
        dailySummaryViewModel.a0().observe(this, new t());
        dailySummaryViewModel.m().observe(this, new u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("deviceId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p1 = stringExtra;
        com.tplink.iot.e.a.c cVar = com.tplink.iot.e.a.c.k;
        if (stringExtra == null) {
            kotlin.jvm.internal.j.t("mCurrentDeviceId");
        }
        cVar.m(stringExtra);
        ViewModel viewModel = new ViewModelProvider(this).get(DailySummaryViewModel.class);
        kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this).…aryViewModel::class.java)");
        DailySummaryViewModel dailySummaryViewModel = (DailySummaryViewModel) viewModel;
        dailySummaryViewModel.k0();
        dailySummaryViewModel.j0(true);
        kotlin.p pVar = kotlin.p.a;
        this.p2 = dailySummaryViewModel;
        m1();
        p1();
        q1();
        k1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (s0.j()) {
            s0.g();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.p0) {
                DailySummaryViewModel dailySummaryViewModel = this.p2;
                if (dailySummaryViewModel == null) {
                    kotlin.jvm.internal.j.t("mViewModel");
                }
                dailySummaryViewModel.p0(false);
            } else {
                finish();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (com.tplink.iot.e.a.c.k.d()) {
            DailySummaryViewModel dailySummaryViewModel = this.p2;
            if (dailySummaryViewModel == null) {
                kotlin.jvm.internal.j.t("mViewModel");
            }
            dailySummaryViewModel.j0(true);
        }
    }
}
