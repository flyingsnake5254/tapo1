package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.databinding.ActivityMsgPushBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.EventObserver;
import java.util.HashMap;
import java.util.List;

/* compiled from: MsgPushActivity.kt */
/* loaded from: classes2.dex */
public final class MsgPushActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private HashMap I3;
    private ActivityMsgPushBinding p0;
    private MsgPushViewModel p1;
    private CloudVideoViewModel p2;
    private String p3;
    private final int z = 111;
    private int H3 = 3;

    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, MsgPushActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(MsgPushActivity.this);
            } else {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                MsgPushActivity msgPushActivity = MsgPushActivity.this;
                TSnackbar.y(msgPushActivity, msgPushActivity.getString(R.string.general_failed), PathInterpolatorCompat.MAX_NUM_POINTS).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (org.apache.commons.lang.b.b(bool)) {
                MsgPushActivity.this.p1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (org.apache.commons.lang.b.b(bool)) {
                MsgPushActivity.this.n1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f<T> implements Observer<Boolean> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (org.apache.commons.lang.b.b(bool)) {
                MsgPushActivity msgPushActivity = MsgPushActivity.this;
                TrialDialogActivity.f1(msgPushActivity, com.tplink.iot.Utils.v0.e.v(com.tplink.iot.Utils.z0.h.j(MsgPushActivity.f1(msgPushActivity))));
            }
        }
    }

    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        g() {
        }

        /* renamed from: b */
        public final void a(Boolean bool) {
            MsgPushActivity.h1(MsgPushActivity.this).a.postValue(bool);
        }
    }

    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements io.reactivex.g0.g<Integer> {

        /* renamed from: c  reason: collision with root package name */
        public static final h f9125c = new h();

        h() {
        }

        /* renamed from: a */
        public final void accept(Integer num) {
        }
    }

    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    static final class i<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final i f9126c = new i();

        i() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements TPMaterialDialogV2.d {
        j() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
            MsgPushActivity.h1(MsgPushActivity.this).f10780f.set(true);
            MsgPushActivity.h1(MsgPushActivity.this).r0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MsgPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements TPMaterialDialogV2.d {
        k() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
            MsgPushActivity.h1(MsgPushActivity.this).f10780f.set(true);
            MsgPushActivity.h1(MsgPushActivity.this).q0(true);
        }
    }

    public static final /* synthetic */ String f1(MsgPushActivity msgPushActivity) {
        String str = msgPushActivity.p3;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        return str;
    }

    public static final /* synthetic */ CloudVideoViewModel g1(MsgPushActivity msgPushActivity) {
        CloudVideoViewModel cloudVideoViewModel = msgPushActivity.p2;
        if (cloudVideoViewModel == null) {
            kotlin.jvm.internal.j.t("mCloudVideoViewModel");
        }
        return cloudVideoViewModel;
    }

    public static final /* synthetic */ MsgPushViewModel h1(MsgPushActivity msgPushActivity) {
        MsgPushViewModel msgPushViewModel = msgPushActivity.p1;
        if (msgPushViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        return msgPushViewModel;
    }

    private final void k1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p3 = stringExtra;
        this.H3 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.p3;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(MsgPushViewModel.class);
        kotlin.jvm.internal.j.d(viewModel, "ViewModelProviders.of(th…ushViewModel::class.java)");
        this.p1 = (MsgPushViewModel) viewModel;
        ViewModel viewModel2 = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
        kotlin.jvm.internal.j.d(viewModel2, "ViewModelProviders.of(th…deoViewModel::class.java]");
        this.p2 = (CloudVideoViewModel) viewModel2;
        ActivityMsgPushBinding activityMsgPushBinding = this.p0;
        if (activityMsgPushBinding == null) {
            kotlin.jvm.internal.j.t("binding");
        }
        MsgPushViewModel msgPushViewModel = this.p1;
        if (msgPushViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        activityMsgPushBinding.i(msgPushViewModel);
        ActivityMsgPushBinding activityMsgPushBinding2 = this.p0;
        if (activityMsgPushBinding2 == null) {
            kotlin.jvm.internal.j.t("binding");
        }
        activityMsgPushBinding2.h(this);
        MsgPushViewModel msgPushViewModel2 = this.p1;
        if (msgPushViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel2.m(this.H3);
    }

    private final void l1() {
        MsgPushViewModel msgPushViewModel = this.p1;
        if (msgPushViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel.a.observe(this, new b());
        MsgPushViewModel msgPushViewModel2 = this.p1;
        if (msgPushViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel2.f10776b.observe(this, new c());
        MsgPushViewModel msgPushViewModel3 = this.p1;
        if (msgPushViewModel3 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel3.o.observe(this, new EventObserver(new d()));
        MsgPushViewModel msgPushViewModel4 = this.p1;
        if (msgPushViewModel4 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel4.p.observe(this, new EventObserver(new e()));
        MsgPushViewModel msgPushViewModel5 = this.p1;
        if (msgPushViewModel5 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        msgPushViewModel5.q.observe(this, new EventObserver(new f()));
    }

    private final void m1() {
        b1(R.string.activity_notifications);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        CloudVideoViewModel cloudVideoViewModel = this.p2;
        if (cloudVideoViewModel == null) {
            kotlin.jvm.internal.j.t("mCloudVideoViewModel");
        }
        cloudVideoViewModel.N().observe(this, new Observer<List<? extends OrderInfo>>() { // from class: com.tplink.iot.view.ipcamera.setting.MsgPushActivity$observeOrders$1
            /* renamed from: a */
            public void onChanged(List<? extends OrderInfo> list) {
                MsgPushActivity.g1(MsgPushActivity.this).N().removeObserver(this);
                if (MsgPushActivity.g1(MsgPushActivity.this).H(list, "")) {
                    BillingDialogActivity.f1(MsgPushActivity.this, e.x());
                    return;
                }
                MsgPushActivity msgPushActivity = MsgPushActivity.this;
                BillingDialogActivity.f1(msgPushActivity, e.u(h.j(MsgPushActivity.f1(msgPushActivity))));
            }
        });
    }

    private final void o1() {
        Intent intent = new Intent(this, MsgPushCustomTimeActivity.class);
        String str = this.p3;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        intent.putExtra("device_id_md5", str);
        MsgPushViewModel msgPushViewModel = this.p1;
        if (msgPushViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        intent.putExtra("startTime", msgPushViewModel.h.get());
        MsgPushViewModel msgPushViewModel2 = this.p1;
        if (msgPushViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        intent.putExtra("endTime", msgPushViewModel2.i.get());
        MsgPushViewModel msgPushViewModel3 = this.p1;
        if (msgPushViewModel3 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        intent.putExtra("weekday", msgPushViewModel3.j.get());
        startActivityForResult(intent, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        new TPMaterialDialogV2.Builder(this).i(R.string.rich_notifications_enable_tips_v3, R.color.common_gray_black_color_transparent_50).o(R.string.smart_action_enable, R.color.common_iot_main_blue, new j()).l(R.string.common_cancel, R.color.common_iot_light_black, new k()).setCancelable(false).c(false).g(8, 8).show();
    }

    public View e1(int i2) {
        if (this.I3 == null) {
            this.I3 = new HashMap();
        }
        View view = (View) this.I3.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.I3.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.z && i3 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("startTime", 540);
            int intExtra2 = intent.getIntExtra("endTime", PointerIconCompat.TYPE_GRAB);
            int intExtra3 = intent.getIntExtra("weekday", 127);
            MsgPushViewModel msgPushViewModel = this.p1;
            if (msgPushViewModel == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            msgPushViewModel.s0(intExtra, intExtra2, intExtra3);
            MsgPushViewModel msgPushViewModel2 = this.p1;
            if (msgPushViewModel2 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            MsgPushViewModel msgPushViewModel3 = this.p1;
            if (msgPushViewModel3 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            msgPushViewModel2.p0(true, msgPushViewModel3.f(intExtra, intExtra2, intExtra3));
        } else if (i2 == 1345) {
            String str = this.p3;
            if (str == null) {
                kotlin.jvm.internal.j.t("deviceIdMD5");
            }
            com.tplink.iot.Utils.z0.h.o(str, false, new g()).H0(h.f9125c, i.f9126c);
            com.tplink.iot.Utils.v0.b.a().b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2 = com.tplink.iot.a.notification_switch;
        if (kotlin.jvm.internal.j.a(view, (CheckBox) e1(i2))) {
            MsgPushViewModel msgPushViewModel = this.p1;
            if (msgPushViewModel == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            CheckBox notification_switch = (CheckBox) e1(i2);
            kotlin.jvm.internal.j.d(notification_switch, "notification_switch");
            msgPushViewModel.m0(notification_switch.isChecked());
        } else if (kotlin.jvm.internal.j.a(view, (NoninteractiveCheckBox) e1(com.tplink.iot.a.rich_notification_switch))) {
            MsgPushViewModel msgPushViewModel2 = this.p1;
            if (msgPushViewModel2 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            MsgPushViewModel msgPushViewModel3 = this.p1;
            if (msgPushViewModel3 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            msgPushViewModel2.h(msgPushViewModel3.f10780f);
        } else if (kotlin.jvm.internal.j.a(view, (RadioButton) e1(com.tplink.iot.a.always_item))) {
            MsgPushViewModel msgPushViewModel4 = this.p1;
            if (msgPushViewModel4 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            msgPushViewModel4.o0(false);
        } else if (kotlin.jvm.internal.j.a(view, (RadioButton) e1(com.tplink.iot.a.custom_item))) {
            MsgPushViewModel msgPushViewModel5 = this.p1;
            if (msgPushViewModel5 == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            msgPushViewModel5.o0(true);
        } else if (kotlin.jvm.internal.j.a(view, (RelativeLayout) e1(com.tplink.iot.a.item_custom_time_more))) {
            o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_msg_push);
        kotlin.jvm.internal.j.d(contentView, "DataBindingUtil.setConte…layout.activity_msg_push)");
        this.p0 = (ActivityMsgPushBinding) contentView;
        m1();
        k1();
        l1();
    }
}
