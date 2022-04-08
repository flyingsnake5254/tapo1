package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.NightVisionModeViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: NightVisionModeActivity.kt */
/* loaded from: classes2.dex */
public final class NightVisionModeActivity extends BaseActivity implements View.OnClickListener {
    private HashMap p0;
    private NightVisionModeViewModel y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                ((CameraLoadingView) NightVisionModeActivity.this.e1(com.tplink.iot.a.live_loading_view)).b();
            } else {
                ((CameraLoadingView) NightVisionModeActivity.this.e1(com.tplink.iot.a.live_loading_view)).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<NightVisionModeType> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(NightVisionModeType nightVisionModeType) {
            if (nightVisionModeType != null) {
                int i = a5.a[nightVisionModeType.ordinal()];
                if (i == 1) {
                    ImageView iv_full_color = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_full_color);
                    j.d(iv_full_color, "iv_full_color");
                    iv_full_color.setVisibility(0);
                    ImageView iv_infrared = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_infrared);
                    j.d(iv_infrared, "iv_infrared");
                    iv_infrared.setVisibility(4);
                    ImageView iv_smart = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_smart);
                    j.d(iv_smart, "iv_smart");
                    iv_smart.setVisibility(4);
                    ((ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_night_vision)).setBackgroundResource(R.mipmap.full_color_night_vision);
                } else if (i == 2) {
                    ImageView iv_full_color2 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_full_color);
                    j.d(iv_full_color2, "iv_full_color");
                    iv_full_color2.setVisibility(4);
                    ImageView iv_infrared2 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_infrared);
                    j.d(iv_infrared2, "iv_infrared");
                    iv_infrared2.setVisibility(4);
                    ImageView iv_smart2 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_smart);
                    j.d(iv_smart2, "iv_smart");
                    iv_smart2.setVisibility(0);
                    ((ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_night_vision)).setBackgroundResource(R.mipmap.smart_night_vision);
                } else if (i == 3) {
                    ImageView iv_full_color3 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_full_color);
                    j.d(iv_full_color3, "iv_full_color");
                    iv_full_color3.setVisibility(4);
                    ImageView iv_infrared3 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_infrared);
                    j.d(iv_infrared3, "iv_infrared");
                    iv_infrared3.setVisibility(0);
                    ImageView iv_smart3 = (ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_smart);
                    j.d(iv_smart3, "iv_smart");
                    iv_smart3.setVisibility(4);
                    ((ImageView) NightVisionModeActivity.this.e1(com.tplink.iot.a.iv_night_vision)).setBackgroundResource(R.mipmap.infrared_night_vision);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<List<? extends NightVisionModeType>> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends NightVisionModeType> list) {
            if (list != null) {
                if (list.contains(NightVisionModeType.INFRARED)) {
                    LinearLayout ll_infrared = (LinearLayout) NightVisionModeActivity.this.e1(com.tplink.iot.a.ll_infrared);
                    j.d(ll_infrared, "ll_infrared");
                    ll_infrared.setVisibility(0);
                }
                if (list.contains(NightVisionModeType.SMART)) {
                    LinearLayout ll_smart = (LinearLayout) NightVisionModeActivity.this.e1(com.tplink.iot.a.ll_smart);
                    j.d(ll_smart, "ll_smart");
                    ll_smart.setVisibility(0);
                }
                if (list.contains(NightVisionModeType.FULL_COLOR)) {
                    LinearLayout ll_full_color = (LinearLayout) NightVisionModeActivity.this.e1(com.tplink.iot.a.ll_full_color);
                    j.d(ll_full_color, "ll_full_color");
                    ll_full_color.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (!it.booleanValue()) {
                return;
            }
            if (t0.g(NightVisionModeActivity.this)) {
                TSnackbar.x(NightVisionModeActivity.this, R.string.general_failed, 0).N();
            } else {
                TSnackbar.x(NightVisionModeActivity.this, R.string.no_internet_connection_tip, 0).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NightVisionModeActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NightVisionModeActivity.f1(NightVisionModeActivity.this).p(NightVisionModeType.FULL_COLOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NightVisionModeActivity.f1(NightVisionModeActivity.this).p(NightVisionModeType.INFRARED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NightVisionModeActivity.f1(NightVisionModeActivity.this).p(NightVisionModeType.SMART);
        }
    }

    public static final /* synthetic */ NightVisionModeViewModel f1(NightVisionModeActivity nightVisionModeActivity) {
        NightVisionModeViewModel nightVisionModeViewModel = nightVisionModeActivity.y;
        if (nightVisionModeViewModel == null) {
            j.t("mViewModel");
        }
        return nightVisionModeViewModel;
    }

    private final void g1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.z = stringExtra;
        if (stringExtra == null) {
            j.t("mDeviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(NightVisionModeViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…odeViewModel::class.java)");
        NightVisionModeViewModel nightVisionModeViewModel = (NightVisionModeViewModel) viewModel;
        this.y = nightVisionModeViewModel;
        if (nightVisionModeViewModel == null) {
            j.t("mViewModel");
        }
        nightVisionModeViewModel.m();
    }

    private final void h1() {
        NightVisionModeViewModel nightVisionModeViewModel = this.y;
        if (nightVisionModeViewModel == null) {
            j.t("mViewModel");
        }
        nightVisionModeViewModel.n().observe(this, new a());
        NightVisionModeViewModel nightVisionModeViewModel2 = this.y;
        if (nightVisionModeViewModel2 == null) {
            j.t("mViewModel");
        }
        nightVisionModeViewModel2.j().observe(this, new b());
        NightVisionModeViewModel nightVisionModeViewModel3 = this.y;
        if (nightVisionModeViewModel3 == null) {
            j.t("mViewModel");
        }
        nightVisionModeViewModel3.i().observe(this, new c());
        NightVisionModeViewModel nightVisionModeViewModel4 = this.y;
        if (nightVisionModeViewModel4 == null) {
            j.t("mViewModel");
        }
        nightVisionModeViewModel4.h().observe(this, new d());
    }

    private final void i1() {
        setContentView(R.layout.activity_night_vision_mode);
        setTitle(R.string.camera_setting_night_vision_mode);
        View findViewById = findViewById(R.id.toolbar);
        j.d(findViewById, "findViewById(R.id.toolbar)");
        ((Toolbar) findViewById).setNavigationOnClickListener(new e());
        ((LinearLayout) e1(com.tplink.iot.a.ll_full_color)).setOnClickListener(new f());
        ((LinearLayout) e1(com.tplink.iot.a.ll_infrared)).setOnClickListener(new g());
        ((LinearLayout) e1(com.tplink.iot.a.ll_smart)).setOnClickListener(new h());
    }

    public View e1(int i) {
        if (this.p0 == null) {
            this.p0 = new HashMap();
        }
        View view = (View) this.p0.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.p0.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g1();
        i1();
        h1();
    }
}
