package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: AreaIntrusionActivity.kt */
/* loaded from: classes2.dex */
public final class AreaIntrusionActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private int H3;
    private HashMap J3;
    private String p0;
    private boolean p1;
    private int p3;
    private AreaIntrusionViewModel z;
    private final ArrayList<ChangeableAreaView> p2 = new ArrayList<>();
    private int I3 = 3;

    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, AreaIntrusionActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            CheckBox video_intrusion_switch = (CheckBox) AreaIntrusionActivity.this.e1(com.tplink.iot.a.video_intrusion_switch);
            kotlin.jvm.internal.j.d(video_intrusion_switch, "video_intrusion_switch");
            kotlin.jvm.internal.j.d(it, "it");
            video_intrusion_switch.setChecked(it.booleanValue());
            ConstraintLayout layout_area_intrusion = (ConstraintLayout) AreaIntrusionActivity.this.e1(com.tplink.iot.a.layout_area_intrusion);
            kotlin.jvm.internal.j.d(layout_area_intrusion, "layout_area_intrusion");
            layout_area_intrusion.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(AreaIntrusionActivity.this);
            } else {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                AreaIntrusionActivity areaIntrusionActivity = AreaIntrusionActivity.this;
                TSnackbar.y(areaIntrusionActivity, areaIntrusionActivity.getString(R.string.general_failed), PathInterpolatorCompat.MAX_NUM_POINTS).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AreaIntrusionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AreaIntrusionViewModel g1 = AreaIntrusionActivity.g1(AreaIntrusionActivity.this);
            CheckBox video_intrusion_switch = (CheckBox) AreaIntrusionActivity.this.e1(com.tplink.iot.a.video_intrusion_switch);
            kotlin.jvm.internal.j.d(video_intrusion_switch, "video_intrusion_switch");
            g1.a0(video_intrusion_switch.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> {
        g() {
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.i())) {
                AreaIntrusionActivity.this.p1 = false;
                TextView no_preview_note = (TextView) AreaIntrusionActivity.this.e1(com.tplink.iot.a.no_preview_note);
                kotlin.jvm.internal.j.d(no_preview_note, "no_preview_note");
                no_preview_note.setVisibility(0);
                return;
            }
            AreaIntrusionActivity.this.p1 = true;
            String i = cVar.i();
            TextView no_preview_note2 = (TextView) AreaIntrusionActivity.this.e1(com.tplink.iot.a.no_preview_note);
            kotlin.jvm.internal.j.d(no_preview_note2, "no_preview_note");
            no_preview_note2.setVisibility(4);
            com.bumptech.glide.c.u(AreaIntrusionActivity.this.getApplication()).s(i).x0((ImageView) AreaIntrusionActivity.this.e1(com.tplink.iot.a.setting_cover_iv));
            AreaIntrusionActivity.this.x1();
        }
    }

    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    static final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AreaIntrusionActivity.this.u1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements UniversalDialog.c {
        i() {
        }

        @Override // com.tplink.iot.widget.UniversalDialog.c
        public final void a() {
            AreaIntrusionActivity.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AreaIntrusionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j<T> implements Observer<List<? extends c.a>> {
        j() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends c.a> list) {
            if (list != null && AreaIntrusionActivity.this.p1) {
                AreaIntrusionActivity.this.v1();
                AreaIntrusionActivity.this.q1(list);
            }
        }
    }

    public static final /* synthetic */ AreaIntrusionViewModel g1(AreaIntrusionActivity areaIntrusionActivity) {
        AreaIntrusionViewModel areaIntrusionViewModel = areaIntrusionActivity.z;
        if (areaIntrusionViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        return areaIntrusionViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        Intent intent = new Intent();
        intent.setClass(this, VideoPlayActivity.class);
        String str = this.p0;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        intent.putExtra("device_id_md5", str);
        startActivity(intent);
    }

    private final void o1() {
        int a2;
        int i2 = com.tplink.iot.a.setting_area_container;
        FrameLayout setting_area_container = (FrameLayout) e1(i2);
        kotlin.jvm.internal.j.d(setting_area_container, "setting_area_container");
        ViewGroup.LayoutParams layoutParams = setting_area_container.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int i3 = com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0];
        this.p3 = i3;
        a2 = kotlin.s.c.a((i3 * 9.0d) / 16);
        this.H3 = a2;
        layoutParams2.width = this.p3;
        layoutParams2.height = a2;
        FrameLayout setting_area_container2 = (FrameLayout) e1(i2);
        kotlin.jvm.internal.j.d(setting_area_container2, "setting_area_container");
        setting_area_container2.setLayoutParams(layoutParams2);
    }

    private final void p1(ChangeableAreaView changeableAreaView, c.a aVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        double d2 = 10000;
        a2 = kotlin.s.c.a(((aVar.c() * 1.0d) / d2) * this.p3);
        layoutParams.leftMargin = a2;
        a3 = kotlin.s.c.a(((aVar.d() * 1.0d) / d2) * this.H3);
        layoutParams.topMargin = a3;
        a4 = kotlin.s.c.a(((aVar.b() * 1.0d) / d2) * this.p3);
        layoutParams.width = a4;
        a5 = kotlin.s.c.a(((aVar.a() * 1.0d) / d2) * this.H3);
        layoutParams.height = a5;
        changeableAreaView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(List<? extends c.a> list) {
        if (list != null) {
            this.p2.clear();
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                ChangeableAreaView changeableAreaView = new ChangeableAreaView(this);
                p1(changeableAreaView, (c.a) list.get(i2));
                changeableAreaView.i(false);
                changeableAreaView.setCanBeEdit(false);
                this.p2.add(changeableAreaView);
                i2++;
                ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).addView(changeableAreaView, i2);
            }
        }
    }

    private final void r1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p0 = stringExtra;
        this.I3 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.p0;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(AreaIntrusionViewModel.class);
        kotlin.jvm.internal.j.d(viewModel, "ViewModelProviders.of(th…ionViewModel::class.java)");
        AreaIntrusionViewModel areaIntrusionViewModel = (AreaIntrusionViewModel) viewModel;
        this.z = areaIntrusionViewModel;
        if (areaIntrusionViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel.o(this.I3);
        u1();
    }

    private final void s1() {
        AreaIntrusionViewModel areaIntrusionViewModel = this.z;
        if (areaIntrusionViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel.l().observe(this, new b());
        AreaIntrusionViewModel areaIntrusionViewModel2 = this.z;
        if (areaIntrusionViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel2.m().observe(this, new c());
        AreaIntrusionViewModel areaIntrusionViewModel3 = this.z;
        if (areaIntrusionViewModel3 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel3.j().observe(this, new d());
    }

    private final void t1() {
        setContentView(R.layout.activity_area_intrusion);
        int i2 = com.tplink.iot.a.mtb;
        setSupportActionBar((Toolbar) e1(i2));
        o1();
        ((Toolbar) e1(i2)).setNavigationOnClickListener(new e());
        ((CheckBox) e1(com.tplink.iot.a.video_intrusion_switch)).setOnClickListener(new f());
        ((LinearLayout) e1(com.tplink.iot.a.ll_region_edit)).setOnClickListener(this);
        ((ImageView) e1(com.tplink.iot.a.setting_cover_iv)).setOnClickListener(this);
        ((LinearLayout) e1(com.tplink.iot.a.ll_schedule)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        String str = this.p0;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        l.e(str, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        Iterator<ChangeableAreaView> it = this.p2.iterator();
        while (it.hasNext()) {
            ChangeableAreaView next = it.next();
            if (next != null) {
                ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).removeView(next);
            }
        }
    }

    private final void w1() {
        new UniversalDialog.a().q(getString(R.string.no_preview_image_alert)).s(getString(R.string.action_no)).u(getString(R.string.go_to_live_action)).t(new i()).l().show(getSupportFragmentManager(), "SETTING");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        AreaIntrusionViewModel areaIntrusionViewModel = this.z;
        if (areaIntrusionViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel.n().observe(this, new j());
    }

    public View e1(int i2) {
        if (this.J3 == null) {
            this.J3 = new HashMap();
        }
        View view = (View) this.J3.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.J3.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        kotlin.jvm.internal.j.e(v, "v");
        if (!kotlin.jvm.internal.j.a(v, (ImageView) e1(com.tplink.iot.a.setting_cover_iv)) && !kotlin.jvm.internal.j.a(v, (LinearLayout) e1(com.tplink.iot.a.ll_region_edit))) {
            if (kotlin.jvm.internal.j.a(v, (LinearLayout) e1(com.tplink.iot.a.ll_schedule))) {
                String str = this.p0;
                if (str == null) {
                    kotlin.jvm.internal.j.t("deviceIdMD5");
                }
                IntrusionScheduleSettingActivity.Y0(this, str, this.I3);
            }
        } else if (this.p1) {
            String str2 = this.p0;
            if (str2 == null) {
                kotlin.jvm.internal.j.t("deviceIdMD5");
            }
            AreaIntrusionRegionSettingActivity.M1(this, str2, this.I3);
        } else {
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t1();
        r1();
        s1();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.p1) {
            this.f6070c.postDelayed(new h(), 1500L);
        }
        if (this.I3 == 3) {
            AreaIntrusionViewModel areaIntrusionViewModel = this.z;
            if (areaIntrusionViewModel == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            areaIntrusionViewModel.V();
            return;
        }
        AreaIntrusionViewModel areaIntrusionViewModel2 = this.z;
        if (areaIntrusionViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        areaIntrusionViewModel2.W();
    }
}
