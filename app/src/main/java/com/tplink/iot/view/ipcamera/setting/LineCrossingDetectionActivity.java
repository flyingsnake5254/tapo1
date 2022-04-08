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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;
import com.tplink.iot.widget.FlexibleLine;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: LineCrossingDetectionActivity.kt */
/* loaded from: classes2.dex */
public final class LineCrossingDetectionActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private int H3;
    private HashMap J3;
    private String p0;
    private boolean p1;
    private int p3;
    private LineCrossingViewModel z;
    private final ArrayList<FlexibleLine> p2 = new ArrayList<>();
    private int I3 = 3;

    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, LineCrossingDetectionActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            CheckBox line_crossing_switch = (CheckBox) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.line_crossing_switch);
            kotlin.jvm.internal.j.d(line_crossing_switch, "line_crossing_switch");
            kotlin.jvm.internal.j.d(it, "it");
            line_crossing_switch.setChecked(it.booleanValue());
            LinearLayout ll_line_crossing_content = (LinearLayout) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.ll_line_crossing_content);
            kotlin.jvm.internal.j.d(ll_line_crossing_content, "ll_line_crossing_content");
            ll_line_crossing_content.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(LineCrossingDetectionActivity.this);
            } else {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            kotlin.jvm.internal.j.d(it, "it");
            if (it.booleanValue()) {
                LineCrossingDetectionActivity lineCrossingDetectionActivity = LineCrossingDetectionActivity.this;
                TSnackbar.y(lineCrossingDetectionActivity, lineCrossingDetectionActivity.getString(R.string.general_failed), PathInterpolatorCompat.MAX_NUM_POINTS).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LineCrossingDetectionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LineCrossingViewModel g1 = LineCrossingDetectionActivity.g1(LineCrossingDetectionActivity.this);
            CheckBox line_crossing_switch = (CheckBox) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.line_crossing_switch);
            kotlin.jvm.internal.j.d(line_crossing_switch, "line_crossing_switch");
            g1.W(line_crossing_switch.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c> {
        g() {
        }

        /* renamed from: b */
        public final void a(com.tplink.libtpmediaother.database.model.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.i())) {
                LineCrossingDetectionActivity.this.p1 = false;
                TextView no_preview_note = (TextView) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.no_preview_note);
                kotlin.jvm.internal.j.d(no_preview_note, "no_preview_note");
                no_preview_note.setVisibility(0);
                return;
            }
            LineCrossingDetectionActivity.this.p1 = true;
            String i = cVar.i();
            TextView no_preview_note2 = (TextView) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.no_preview_note);
            kotlin.jvm.internal.j.d(no_preview_note2, "no_preview_note");
            no_preview_note2.setVisibility(4);
            com.bumptech.glide.c.u(LineCrossingDetectionActivity.this.getApplication()).s(i).x0((ImageView) LineCrossingDetectionActivity.this.e1(com.tplink.iot.a.setting_cover_iv));
            LineCrossingDetectionActivity.this.w1();
        }
    }

    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LineCrossingDetectionActivity.this.t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements UniversalDialog.c {
        i() {
        }

        @Override // com.tplink.iot.widget.UniversalDialog.c
        public final void a() {
            LineCrossingDetectionActivity.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineCrossingDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j<T> implements Observer<List<? extends LineCrossingDetectionRegion>> {
        j() {
        }

        /* renamed from: a */
        public final void onChanged(List<LineCrossingDetectionRegion> list) {
            if (list != null && LineCrossingDetectionActivity.this.p1) {
                LineCrossingDetectionActivity.this.u1();
                LineCrossingDetectionActivity.this.q1(list);
            }
        }
    }

    public static final /* synthetic */ LineCrossingViewModel g1(LineCrossingDetectionActivity lineCrossingDetectionActivity) {
        LineCrossingViewModel lineCrossingViewModel = lineCrossingDetectionActivity.z;
        if (lineCrossingViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        return lineCrossingViewModel;
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

    private final void p1() {
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
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(LineCrossingViewModel.class);
        kotlin.jvm.internal.j.d(viewModel, "ViewModelProviders.of(th…ingViewModel::class.java)");
        LineCrossingViewModel lineCrossingViewModel = (LineCrossingViewModel) viewModel;
        this.z = lineCrossingViewModel;
        if (lineCrossingViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel.n(this.I3);
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(List<LineCrossingDetectionRegion> list) {
        int i2;
        if (list != null) {
            this.p2.clear();
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                LineCrossingDetectionRegion lineCrossingDetectionRegion = list.get(i3);
                FlexibleLine flexibleLine = new FlexibleLine(this);
                flexibleLine.n(Integer.parseInt(lineCrossingDetectionRegion.getPoint1X()), Integer.parseInt(lineCrossingDetectionRegion.getPoint1Y()), Integer.parseInt(lineCrossingDetectionRegion.getPoint2X()), Integer.parseInt(lineCrossingDetectionRegion.getPoint2Y()), this.p3, this.H3);
                flexibleLine.setEditable(false);
                String direction = lineCrossingDetectionRegion.getDirection();
                int hashCode = direction.hashCode();
                if (hashCode == 2051398) {
                    direction.equals("AtoB");
                } else if (hashCode != 2081188) {
                    if (hashCode == 3029889 && direction.equals("both")) {
                        i2 = 2;
                        flexibleLine.setArrowDirection(i2);
                        this.p2.add(flexibleLine);
                        i3++;
                        ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).addView(flexibleLine, i3);
                    }
                } else if (direction.equals("BtoA")) {
                    i2 = 1;
                    flexibleLine.setArrowDirection(i2);
                    this.p2.add(flexibleLine);
                    i3++;
                    ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).addView(flexibleLine, i3);
                }
                i2 = 0;
                flexibleLine.setArrowDirection(i2);
                this.p2.add(flexibleLine);
                i3++;
                ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).addView(flexibleLine, i3);
            }
        }
    }

    private final void r1() {
        LineCrossingViewModel lineCrossingViewModel = this.z;
        if (lineCrossingViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel.k().observe(this, new b());
        LineCrossingViewModel lineCrossingViewModel2 = this.z;
        if (lineCrossingViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel2.l().observe(this, new c());
        LineCrossingViewModel lineCrossingViewModel3 = this.z;
        if (lineCrossingViewModel3 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel3.i().observe(this, new d());
    }

    private final void s1() {
        setContentView(R.layout.activity_line_crossing_detection);
        int i2 = com.tplink.iot.a.mtb;
        setSupportActionBar((Toolbar) e1(i2));
        o1();
        ((Toolbar) e1(i2)).setNavigationOnClickListener(new e());
        ((CheckBox) e1(com.tplink.iot.a.line_crossing_switch)).setOnClickListener(new f());
        ((LinearLayout) e1(com.tplink.iot.a.ll_region_edit)).setOnClickListener(this);
        ((ImageView) e1(com.tplink.iot.a.setting_cover_iv)).setOnClickListener(this);
        ((LinearLayout) e1(com.tplink.iot.a.ll_schedule)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        String str = this.p0;
        if (str == null) {
            kotlin.jvm.internal.j.t("deviceIdMD5");
        }
        l.e(str, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        Iterator<FlexibleLine> it = this.p2.iterator();
        while (it.hasNext()) {
            ((FrameLayout) e1(com.tplink.iot.a.setting_area_container)).removeView(it.next());
        }
    }

    private final void v1() {
        new UniversalDialog.a().q(getString(R.string.no_preview_image_alert)).s(getString(R.string.action_no)).u(getString(R.string.go_to_live_action)).t(new i()).l().show(getSupportFragmentManager(), "SETTING");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        LineCrossingViewModel lineCrossingViewModel = this.z;
        if (lineCrossingViewModel == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel.m().observe(this, new j());
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
                LineCrossingScheduleSettingActivity.Y0(this, str, this.I3);
            }
        } else if (this.p1) {
            String str2 = this.p0;
            if (str2 == null) {
                kotlin.jvm.internal.j.t("deviceIdMD5");
            }
            LineCrossingRegionSettingActivity.I1(this, str2, this.I3);
        } else {
            v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s1();
        p1();
        r1();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.p1) {
            this.f6070c.postDelayed(new h(), 1500L);
        }
        if (this.I3 == 3) {
            LineCrossingViewModel lineCrossingViewModel = this.z;
            if (lineCrossingViewModel == null) {
                kotlin.jvm.internal.j.t("viewModel");
            }
            lineCrossingViewModel.S();
            return;
        }
        LineCrossingViewModel lineCrossingViewModel2 = this.z;
        if (lineCrossingViewModel2 == null) {
            kotlin.jvm.internal.j.t("viewModel");
        }
        lineCrossingViewModel2.R();
    }
}
