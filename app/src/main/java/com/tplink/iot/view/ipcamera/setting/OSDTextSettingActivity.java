package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.MenuSaveBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.OSDTextSettingViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: OSDTextSettingActivity.kt */
/* loaded from: classes2.dex */
public final class OSDTextSettingActivity extends BaseActivity implements TextWatcher {
    public static final a y = new a(null);
    private OSDTextSettingViewModel p0;
    private final MutableLiveData<Boolean> p1 = new MutableLiveData<>(Boolean.FALSE);
    private HashMap p2;
    private MenuItem z;

    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(String deviceIdMD5, Activity context) {
            j.e(deviceIdMD5, "deviceIdMD5");
            j.e(context, "context");
            Intent intent = new Intent(context, OSDTextSettingActivity.class);
            intent.putExtra("deviceIdMD5", deviceIdMD5);
            p pVar = p.a;
            context.startActivityForResult(intent, 100);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<String> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(String str) {
            ((DrawableEditText) OSDTextSettingActivity.this.e1(com.tplink.iot.a.osd_info_customize_et)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            OSDTextSettingActivity.this.setResult(100);
            OSDTextSettingActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            OSDTextSettingActivity oSDTextSettingActivity = OSDTextSettingActivity.this;
            TSnackbar.y(oSDTextSettingActivity, oSDTextSettingActivity.getString(R.string.general_failed), -1).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                ((CameraLoadingView) OSDTextSettingActivity.this.e1(com.tplink.iot.a.live_loading_view)).b();
            } else {
                ((CameraLoadingView) OSDTextSettingActivity.this.e1(com.tplink.iot.a.live_loading_view)).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OSDTextSettingActivity.this.onBackPressed();
        }
    }

    /* compiled from: OSDTextSettingActivity.kt */
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object obj;
            OSDTextSettingViewModel f1 = OSDTextSettingActivity.f1(OSDTextSettingActivity.this);
            OSDTextSettingActivity oSDTextSettingActivity = OSDTextSettingActivity.this;
            int i = com.tplink.iot.a.osd_info_customize_et;
            DrawableEditText osd_info_customize_et = (DrawableEditText) oSDTextSettingActivity.e1(i);
            j.d(osd_info_customize_et, "osd_info_customize_et");
            if (f1.g(osd_info_customize_et.getText().toString())) {
                OSDTextSettingActivity.this.h1();
                DrawableEditText osd_info_customize_et2 = (DrawableEditText) OSDTextSettingActivity.this.e1(i);
                j.d(osd_info_customize_et2, "osd_info_customize_et");
                Editable text = osd_info_customize_et2.getText();
                j.d(text, "osd_info_customize_et.text");
                if (text.length() == 0) {
                    obj = SSLClient.WHITE_SPACE;
                } else {
                    DrawableEditText osd_info_customize_et3 = (DrawableEditText) OSDTextSettingActivity.this.e1(i);
                    j.d(osd_info_customize_et3, "osd_info_customize_et");
                    obj = osd_info_customize_et3.getText();
                }
                OSDTextSettingActivity.f1(OSDTextSettingActivity.this).m(obj.toString());
                return;
            }
            OSDTextSettingActivity oSDTextSettingActivity2 = OSDTextSettingActivity.this;
            TSnackbar.y(oSDTextSettingActivity2, oSDTextSettingActivity2.getString(R.string.osd_customized_info_character_error), -1).N();
        }
    }

    public static final /* synthetic */ OSDTextSettingViewModel f1(OSDTextSettingActivity oSDTextSettingActivity) {
        OSDTextSettingViewModel oSDTextSettingViewModel = oSDTextSettingActivity.p0;
        if (oSDTextSettingViewModel == null) {
            j.t("viewModel");
        }
        return oSDTextSettingViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        DrawableEditText osd_info_customize_et = (DrawableEditText) e1(com.tplink.iot.a.osd_info_customize_et);
        j.d(osd_info_customize_et, "osd_info_customize_et");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(osd_info_customize_et.getWindowToken(), 0);
    }

    private final void i1() {
        String stringExtra = getIntent().getStringExtra("deviceIdMD5");
        ViewModel viewModel = ViewModelProviders.of(this).get(OSDTextSettingViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ingViewModel::class.java)");
        OSDTextSettingViewModel oSDTextSettingViewModel = (OSDTextSettingViewModel) viewModel;
        this.p0 = oSDTextSettingViewModel;
        if (oSDTextSettingViewModel == null) {
            j.t("viewModel");
        }
        oSDTextSettingViewModel.l(stringExtra);
    }

    private final void j1() {
        OSDTextSettingViewModel oSDTextSettingViewModel = this.p0;
        if (oSDTextSettingViewModel == null) {
            j.t("viewModel");
        }
        oSDTextSettingViewModel.k().observe(this, new b());
        OSDTextSettingViewModel oSDTextSettingViewModel2 = this.p0;
        if (oSDTextSettingViewModel2 == null) {
            j.t("viewModel");
        }
        oSDTextSettingViewModel2.i().observe(this, new c());
        OSDTextSettingViewModel oSDTextSettingViewModel3 = this.p0;
        if (oSDTextSettingViewModel3 == null) {
            j.t("viewModel");
        }
        oSDTextSettingViewModel3.h().observe(this, new d());
        OSDTextSettingViewModel oSDTextSettingViewModel4 = this.p0;
        if (oSDTextSettingViewModel4 == null) {
            j.t("viewModel");
        }
        oSDTextSettingViewModel4.j().observe(this, new e());
    }

    private final void k1() {
        setTitle(R.string.osd_customized_info);
        View findViewById = findViewById(R.id.toolbar);
        j.d(findViewById, "findViewById(R.id.toolbar)");
        ((Toolbar) findViewById).setNavigationOnClickListener(new f());
        ((DrawableEditText) e1(com.tplink.iot.a.osd_info_customize_et)).f(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        j.e(s, "s");
        this.p1.postValue(Boolean.valueOf(s.length() > 0));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
        j.e(s, "s");
    }

    public View e1(int i) {
        if (this.p2 == null) {
            this.p2 = new HashMap();
        }
        View view = (View) this.p2.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.p2.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_osd_text_setting_activity);
        i1();
        k1();
        j1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        j.d(findItem, "menu.findItem(R.id.common_save)");
        this.z = findItem;
        if (findItem == null) {
            j.t("mSaveMenu");
        }
        findItem.setActionView(R.layout.menu_save);
        MenuItem menuItem = this.z;
        if (menuItem == null) {
            j.t("mSaveMenu");
        }
        MenuSaveBinding menuSaveBinding = (MenuSaveBinding) DataBindingUtil.bind(menuItem.getActionView());
        if (menuSaveBinding != null) {
            menuSaveBinding.setLifecycleOwner(this);
            menuSaveBinding.h(this.p1);
            menuSaveBinding.f7325c.setOnClickListener(new g());
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int i, int i2, int i3) {
        j.e(s, "s");
    }
}
