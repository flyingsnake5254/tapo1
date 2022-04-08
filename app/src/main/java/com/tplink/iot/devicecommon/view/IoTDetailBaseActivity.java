package com.tplink.iot.devicecommon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.k;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBottomBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: IoTDetailBaseActivity.kt */
/* loaded from: classes2.dex */
public abstract class IoTDetailBaseActivity<ContentExtVDB extends ViewDataBinding, BottomExtVDB extends ViewDataBinding, VM extends IoTDetailBaseViewModel> extends BaseActivity implements View.OnClickListener {
    private BaseALIoTDevice<?> H3;
    private final kotlin.f I3;
    private final kotlin.f J3;
    protected ActivityBaseIotDeviceDetailBinding p0;
    private final kotlin.f p1;
    private String p2 = "";
    private final kotlin.f p3;
    protected ContentExtVDB y;
    protected BottomExtVDB z;

    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<ImageView> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final ImageView invoke() {
            return IoTDetailBaseActivity.this.q1().q.z;
        }
    }

    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<ActivityBaseIotDeviceDetailBottomBinding> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final ActivityBaseIotDeviceDetailBottomBinding invoke() {
            ActivityBaseIotDeviceDetailBottomBinding activityBaseIotDeviceDetailBottomBinding = IoTDetailBaseActivity.this.q1().q;
            j.d(activityBaseIotDeviceDetailBottomBinding, "mBinding.detailBottom");
            return activityBaseIotDeviceDetailBottomBinding;
        }
    }

    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<VM> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f7395d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Class cls) {
            super(0);
            this.f7395d = cls;
        }

        /* renamed from: a */
        public final VM invoke() {
            IoTDetailBaseActivity ioTDetailBaseActivity = IoTDetailBaseActivity.this;
            ViewModel viewModel = new ViewModelProvider(ioTDetailBaseActivity, new IoTViewModelFactory(ioTDetailBaseActivity, ioTDetailBaseActivity.u1())).get(this.f7395d);
            j.d(viewModel, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
            return (VM) ((IoTDetailBaseViewModel) viewModel);
        }
    }

    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<ScrollLayout> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final ScrollLayout invoke() {
            return IoTDetailBaseActivity.this.q1().K3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements TPSwitchCompat.a {
        e() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                IoTDetailBaseActivity.this.v1().g(z);
                com.tplink.iot.Utils.x0.i.x(IoTDetailBaseActivity.this.u1(), z);
                if (!z) {
                    IoTDetailBaseActivity.this.G1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScrollLayout f7397c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IoTDetailBaseActivity f7398d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7399f;

        f(ScrollLayout scrollLayout, IoTDetailBaseActivity ioTDetailBaseActivity, int i) {
            this.f7397c = scrollLayout;
            this.f7398d = ioTDetailBaseActivity;
            this.f7399f = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View root = this.f7398d.q1().getRoot();
            j.d(root, "mBinding.root");
            int measuredHeight = root.getMeasuredHeight();
            ScrollLayout scrollDownLayout = this.f7398d.w1();
            j.d(scrollDownLayout, "scrollDownLayout");
            int screenHeight = measuredHeight - scrollDownLayout.getScreenHeight();
            ImageView ivPullUpDown = this.f7398d.o1();
            j.d(ivPullUpDown, "ivPullUpDown");
            int measuredHeight2 = ivPullUpDown.getMeasuredHeight();
            int i1 = this.f7398d.i1();
            if (measuredHeight2 > 0 && i1 > 0) {
                this.f7397c.setMaxOffset((measuredHeight2 + i1) - screenHeight);
                this.f7397c.r();
            }
            int i = measuredHeight2 + i1;
            ScrollView scrollView = this.f7398d.q1().f6502f;
            j.d(scrollView, "mBinding.contentScrollView");
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin < i) {
                ScrollView scrollView2 = this.f7398d.q1().f6502f;
                j.d(scrollView2, "mBinding.contentScrollView");
                ViewGroup.LayoutParams layoutParams2 = scrollView2.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i;
                this.f7398d.q1().f6502f.requestLayout();
            }
        }
    }

    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements ScrollLayout.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7400b;

        g(int i) {
            this.f7400b = i;
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void a(ScrollLayout.Status currentStatus) {
            j.e(currentStatus, "currentStatus");
            if (currentStatus == ScrollLayout.Status.OPENED) {
                IoTDetailBaseActivity.this.o1().setImageResource(R.mipmap.ic_pull_up);
            } else if (currentStatus == ScrollLayout.Status.CLOSED) {
                IoTDetailBaseActivity.this.o1().setImageResource(R.mipmap.ic_pull_down);
            }
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void b(float f2) {
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void c(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements Observer<BaseALIoTDevice<?>> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(BaseALIoTDevice<?> baseALIoTDevice) {
            IoTDetailBaseActivity.this.D1(baseALIoTDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTDetailBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> {
        i() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
            IoTDetailBaseActivity.this.C1(iVar);
        }
    }

    public IoTDetailBaseActivity(Class<VM> vmClz) {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        j.e(vmClz, "vmClz");
        b2 = kotlin.i.b(new b());
        this.p1 = b2;
        b3 = kotlin.i.b(new c(vmClz));
        this.p3 = b3;
        b4 = kotlin.i.b(new a());
        this.I3 = b4;
        b5 = kotlin.i.b(new d());
        this.J3 = b5;
    }

    private final void E1() {
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
        if (activityBaseIotDeviceDetailBinding == null) {
            j.t("mBinding");
        }
        activityBaseIotDeviceDetailBinding.q.f6505f.setOnSwitchCheckedChangeListener(new e());
    }

    private final void F1() {
        int a2 = k.a(this, 50.0f) + com.tplink.iot.view.quicksetup.base.d.A(this);
        View view = r1().p3;
        j.d(view, "mBottomBinding.viewWhiteStub");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = a2;
        view.setLayoutParams(layoutParams);
        ScrollLayout w1 = w1();
        w1.setMinOffset(a2);
        o1().post(new f(w1, this, a2));
        w1.setOnScrollChangedListener(new g(a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1() {
        String str;
        TCAccountBean c2;
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        if (f2 == null || (c2 = f2.c()) == null || (str = c2.getCloudUserName()) == null) {
            str = "";
        }
        u.p(this, str);
    }

    private final void H1() {
        if (v1().D()) {
            ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
            if (activityBaseIotDeviceDetailBinding == null) {
                j.t("mBinding");
            }
            CardView cardView = activityBaseIotDeviceDetailBinding.f6501d;
            j.d(cardView, "mBinding.cardUserDevice");
            cardView.setVisibility(0);
        } else {
            ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding2 = this.p0;
            if (activityBaseIotDeviceDetailBinding2 == null) {
                j.t("mBinding");
            }
            CardView cardView2 = activityBaseIotDeviceDetailBinding2.f6501d;
            j.d(cardView2, "mBinding.cardUserDevice");
            cardView2.setVisibility(8);
            I1();
        }
        b.d.w.c.a.a("IoTDetail showLocalOnlyOrUserDeviceTips isUserRoleTypeDevice: " + v1().D());
    }

    private final void I1() {
        if (!v1().B() || !v1().y()) {
            ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
            if (activityBaseIotDeviceDetailBinding == null) {
                j.t("mBinding");
            }
            CardView cardView = activityBaseIotDeviceDetailBinding.f6500c;
            j.d(cardView, "mBinding.cardLocalOnly");
            cardView.setVisibility(8);
        } else {
            v1().h();
        }
        b.d.w.c.a.a("IoTDetail showLocalView isNoCloud: " + v1().y());
    }

    private final void K1() {
        ScrollLayout w1 = w1();
        if (w1.getCurrentStatus() == ScrollLayout.Status.OPENED) {
            w1.m();
        } else if (w1.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
            w1.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView o1() {
        return (ImageView) this.I3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScrollLayout w1() {
        return (ScrollLayout) this.J3.getValue();
    }

    private final void x1() {
        BaseALIoTDevice<?> baseALIoTDevice = this.H3;
        if (baseALIoTDevice != null) {
            HelpAndFeedbackActivity.k1(this, "https://www.tapo.com/app/#/faqList2?categoryType=" + l1() + com.tplink.iot.model.about.d.a(), m1(), baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceModel(), n1(baseALIoTDevice));
        }
    }

    private final void z1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_base_iot_device_detail);
        j.d(contentView, "DataBindingUtil.setConte…y_base_iot_device_detail)");
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = (ActivityBaseIotDeviceDetailBinding) contentView;
        this.p0 = activityBaseIotDeviceDetailBinding;
        if (activityBaseIotDeviceDetailBinding == null) {
            j.t("mBinding");
        }
        activityBaseIotDeviceDetailBinding.h(v1());
        activityBaseIotDeviceDetailBinding.i(this);
        activityBaseIotDeviceDetailBinding.setLifecycleOwner(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        int j1 = j1();
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding2 = this.p0;
        if (activityBaseIotDeviceDetailBinding2 == null) {
            j.t("mBinding");
        }
        ContentExtVDB contentextvdb = (ContentExtVDB) DataBindingUtil.inflate(layoutInflater, j1, activityBaseIotDeviceDetailBinding2.x, true);
        j.d(contentextvdb, "DataBindingUtil.inflate(…nding.flContentExt, true)");
        this.y = contentextvdb;
        if (contentextvdb == null) {
            j.t("mContentExtBinding");
        }
        contentextvdb.setVariable(15, v1());
        contentextvdb.setVariable(69, this);
        contentextvdb.setLifecycleOwner(this);
        BottomExtVDB bottomextvdb = (BottomExtVDB) DataBindingUtil.inflate(getLayoutInflater(), h1(), r1().q, true);
        j.d(bottomextvdb, "DataBindingUtil.inflate(…inding.flBottomExt, true)");
        this.z = bottomextvdb;
        if (bottomextvdb == null) {
            j.t("mBottomExtBinding");
        }
        bottomextvdb.setVariable(15, v1());
        bottomextvdb.setVariable(69, this);
        bottomextvdb.setLifecycleOwner(this);
    }

    @CallSuper
    public void A1() {
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
        if (activityBaseIotDeviceDetailBinding == null) {
            j.t("mBinding");
        }
        com.tplink.iot.view.quicksetup.base.d.J(this, activityBaseIotDeviceDetailBinding.J3);
        F1();
        E1();
        H1();
    }

    public void B1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
        CloudConnectStateResult a2;
        int i2 = 8;
        if (iVar == null || (a2 = iVar.a()) == null || a2.getStatus() != 0) {
            ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
            if (activityBaseIotDeviceDetailBinding == null) {
                j.t("mBinding");
            }
            CardView cardView = activityBaseIotDeviceDetailBinding.f6500c;
            j.d(cardView, "mBinding.cardLocalOnly");
            if (v1().y()) {
                i2 = 0;
            }
            cardView.setVisibility(i2);
            return;
        }
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding2 = this.p0;
        if (activityBaseIotDeviceDetailBinding2 == null) {
            j.t("mBinding");
        }
        CardView cardView2 = activityBaseIotDeviceDetailBinding2.f6500c;
        j.d(cardView2, "mBinding.cardLocalOnly");
        cardView2.setVisibility(8);
    }

    protected final void D1(BaseALIoTDevice<?> baseALIoTDevice) {
        this.H3 = baseALIoTDevice;
    }

    @CallSuper
    public void J1() {
        v1().i().observe(this, new h());
        v1().k().observe(this, new i());
    }

    @LayoutRes
    public abstract int h1();

    public abstract int i1();

    @LayoutRes
    public abstract int j1();

    public abstract Class<? extends AppCompatActivity> k1();

    public abstract String l1();

    public abstract String m1();

    public abstract EnumFeedbackCategory n1(BaseALIoTDevice<?> baseALIoTDevice);

    @Override // android.view.View.OnClickListener
    @CallSuper
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.iv_pull_up_down) {
            K1();
        } else if (valueOf != null && valueOf.intValue() == R.id.iv_back) {
            onBackPressed();
        } else if (valueOf != null && valueOf.intValue() == R.id.fl_setting) {
            X0(k1(), this.p2);
        } else if (valueOf != null && valueOf.intValue() == R.id.card_local_only) {
            if (v1().B()) {
                CloudConnectGetStateActivity.j1(this, this.p2);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.item_device_share) {
            ShareDeviceUserListActivity.v1(this, this.p2);
            com.tplink.iot.Utils.x0.i.C();
        } else if (valueOf != null && valueOf.intValue() == R.id.item_faq_feedback) {
            x1();
            com.tplink.iot.Utils.x0.i.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y1();
        z1();
        A1();
        J1();
        B1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        v1().H();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        v1().G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseALIoTDevice<?> p1() {
        return this.H3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ActivityBaseIotDeviceDetailBinding q1() {
        ActivityBaseIotDeviceDetailBinding activityBaseIotDeviceDetailBinding = this.p0;
        if (activityBaseIotDeviceDetailBinding == null) {
            j.t("mBinding");
        }
        return activityBaseIotDeviceDetailBinding;
    }

    protected final ActivityBaseIotDeviceDetailBottomBinding r1() {
        return (ActivityBaseIotDeviceDetailBottomBinding) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BottomExtVDB s1() {
        BottomExtVDB bottomextvdb = this.z;
        if (bottomextvdb == null) {
            j.t("mBottomExtBinding");
        }
        return bottomextvdb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ContentExtVDB t1() {
        ContentExtVDB contentextvdb = this.y;
        if (contentextvdb == null) {
            j.t("mContentExtBinding");
        }
        return contentextvdb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String u1() {
        return this.p2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VM v1() {
        return (VM) ((IoTDetailBaseViewModel) this.p3.getValue());
    }

    @CallSuper
    public void y1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.p2 = str;
    }
}
