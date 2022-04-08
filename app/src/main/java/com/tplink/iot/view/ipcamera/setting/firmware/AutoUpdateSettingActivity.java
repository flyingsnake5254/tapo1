package com.tplink.iot.view.ipcamera.setting.firmware;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoUpdateSettingViewMode;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import java.util.HashMap;
import kotlin.jvm.internal.j;

/* compiled from: AutoUpdateSettingActivity.kt */
/* loaded from: classes2.dex */
public final class AutoUpdateSettingActivity extends BaseActivity implements AutoUpdateTimePickerDialog.a {
    private HashMap H3;
    private AutoUpdateTimePickerDialog p1;
    private MenuItem p3;
    private String y;
    private AutoUpdateSettingViewMode z;
    private final String[] p0 = h.d();
    private int p2 = 180;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j.d(compoundButton, "compoundButton");
            if (compoundButton.isPressed()) {
                AutoUpdateSettingActivity.g1(AutoUpdateSettingActivity.this).setEnabled(AutoUpdateSettingActivity.this.q1());
                LinearLayout layout_auto_update_schedule = (LinearLayout) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.layout_auto_update_schedule);
                j.d(layout_auto_update_schedule, "layout_auto_update_schedule");
                layout_auto_update_schedule.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AutoUpdateSettingActivity.this.r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<AutoUpdateInfo> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(AutoUpdateInfo autoUpdateInfo) {
            if (autoUpdateInfo != null) {
                AutoUpdateSettingActivity autoUpdateSettingActivity = AutoUpdateSettingActivity.this;
                autoUpdateSettingActivity.p2 = AutoUpdateSettingActivity.j1(autoUpdateSettingActivity).j(autoUpdateInfo.getTime());
                boolean isOn = OptionSwitch.Companion.isOn(autoUpdateInfo.getEnabled());
                CheckBox auto_update_switch = (CheckBox) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.auto_update_switch);
                j.d(auto_update_switch, "auto_update_switch");
                auto_update_switch.setChecked(isOn);
                AutoUpdateSettingActivity autoUpdateSettingActivity2 = AutoUpdateSettingActivity.this;
                int n1 = autoUpdateSettingActivity2.n1(autoUpdateSettingActivity2.p2);
                TextView auto_update_time = (TextView) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.auto_update_time);
                j.d(auto_update_time, "auto_update_time");
                auto_update_time.setText(AutoUpdateSettingActivity.this.p0[n1]);
                LinearLayout layout_auto_update_schedule = (LinearLayout) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.layout_auto_update_schedule);
                j.d(layout_auto_update_schedule, "layout_auto_update_schedule");
                layout_auto_update_schedule.setVisibility(isOn ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Integer> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            if (num.intValue() == 0) {
                AutoUpdateSettingActivity.this.finish();
            } else if (num.intValue() == -1) {
                AutoUpdateSettingActivity autoUpdateSettingActivity = AutoUpdateSettingActivity.this;
                s0.p(autoUpdateSettingActivity, autoUpdateSettingActivity.getString(R.string.common_operation_failed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (org.apache.commons.lang.b.b(bool)) {
                ((CameraLoadingView) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.loading_view)).b();
            } else {
                ((CameraLoadingView) AutoUpdateSettingActivity.this.e1(com.tplink.iot.a.loading_view)).a();
            }
        }
    }

    public static final /* synthetic */ MenuItem g1(AutoUpdateSettingActivity autoUpdateSettingActivity) {
        MenuItem menuItem = autoUpdateSettingActivity.p3;
        if (menuItem == null) {
            j.t("mMenuSave");
        }
        return menuItem;
    }

    public static final /* synthetic */ AutoUpdateSettingViewMode j1(AutoUpdateSettingActivity autoUpdateSettingActivity) {
        AutoUpdateSettingViewMode autoUpdateSettingViewMode = autoUpdateSettingActivity.z;
        if (autoUpdateSettingViewMode == null) {
            j.t("viewModel");
        }
        return autoUpdateSettingViewMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n1(int i) {
        return (i / 60) % 24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q1() {
        AutoUpdateSettingViewMode autoUpdateSettingViewMode = this.z;
        if (autoUpdateSettingViewMode == null) {
            j.t("viewModel");
        }
        if (autoUpdateSettingViewMode.f10717f == null) {
            return true;
        }
        int i = com.tplink.iot.a.auto_update_switch;
        if (((CheckBox) e1(i)) == null) {
            return true;
        }
        OptionSwitch.Companion companion = OptionSwitch.Companion;
        AutoUpdateSettingViewMode autoUpdateSettingViewMode2 = this.z;
        if (autoUpdateSettingViewMode2 == null) {
            j.t("viewModel");
        }
        boolean isOn = companion.isOn(autoUpdateSettingViewMode2.f10717f.getEnabled());
        CheckBox auto_update_switch = (CheckBox) e1(i);
        j.d(auto_update_switch, "auto_update_switch");
        if (isOn != auto_update_switch.isChecked()) {
            return true;
        }
        AutoUpdateSettingViewMode autoUpdateSettingViewMode3 = this.z;
        if (autoUpdateSettingViewMode3 == null) {
            j.t("viewModel");
        }
        AutoUpdateSettingViewMode autoUpdateSettingViewMode4 = this.z;
        if (autoUpdateSettingViewMode4 == null) {
            j.t("viewModel");
        }
        return autoUpdateSettingViewMode3.j(autoUpdateSettingViewMode4.f10717f.getTime()) != this.p2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1() {
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog = this.p1;
        if (autoUpdateTimePickerDialog != null) {
            j.c(autoUpdateTimePickerDialog);
            if (autoUpdateTimePickerDialog.isVisible()) {
                return;
            }
        }
        AutoUpdateTimePickerDialog A0 = AutoUpdateTimePickerDialog.A0(this.p2);
        this.p1 = A0;
        if (A0 != null) {
            A0.B0(this);
        }
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog2 = this.p1;
        if (autoUpdateTimePickerDialog2 != null) {
            autoUpdateTimePickerDialog2.show(getSupportFragmentManager(), (String) null);
        }
    }

    public View e1(int i) {
        if (this.H3 == null) {
            this.H3 = new HashMap();
        }
        View view = (View) this.H3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.H3.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void o1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.y = stringExtra;
        if (stringExtra == null) {
            j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(AutoUpdateSettingViewMode.class);
        j.d(viewModel, "ViewModelProviders.of(th…tingViewMode::class.java)");
        this.z = (AutoUpdateSettingViewMode) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o1();
        p1();
        s1();
        AutoUpdateSettingViewMode autoUpdateSettingViewMode = this.z;
        if (autoUpdateSettingViewMode == null) {
            j.t("viewModel");
        }
        autoUpdateSettingViewMode.f();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        j.d(findItem, "menu.findItem(R.id.common_save)");
        this.p3 = findItem;
        if (findItem == null) {
            j.t("mMenuSave");
        }
        findItem.setEnabled(q1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.common_save) {
            AutoUpdateSettingViewMode autoUpdateSettingViewMode = this.z;
            if (autoUpdateSettingViewMode == null) {
                j.t("viewModel");
            }
            CheckBox auto_update_switch = (CheckBox) e1(com.tplink.iot.a.auto_update_switch);
            j.d(auto_update_switch, "auto_update_switch");
            autoUpdateSettingViewMode.A(auto_update_switch.isChecked(), this.p2);
        }
        return super.onOptionsItemSelected(item);
    }

    public final void p1() {
        setContentView(R.layout.activity_auto_update);
        b1(R.string.firmware_auto_update);
        ((CheckBox) e1(com.tplink.iot.a.auto_update_switch)).setOnCheckedChangeListener(new a());
        int n1 = n1(this.p2);
        int i = com.tplink.iot.a.auto_update_time;
        TextView auto_update_time = (TextView) e1(i);
        j.d(auto_update_time, "auto_update_time");
        auto_update_time.setText(this.p0[n1]);
        ((TextView) e1(i)).setOnClickListener(new b());
    }

    public final void s1() {
        AutoUpdateSettingViewMode autoUpdateSettingViewMode = this.z;
        if (autoUpdateSettingViewMode == null) {
            j.t("viewModel");
        }
        autoUpdateSettingViewMode.g().observe(this, new c());
        AutoUpdateSettingViewMode autoUpdateSettingViewMode2 = this.z;
        if (autoUpdateSettingViewMode2 == null) {
            j.t("viewModel");
        }
        autoUpdateSettingViewMode2.i().observe(this, new d());
        AutoUpdateSettingViewMode autoUpdateSettingViewMode3 = this.z;
        if (autoUpdateSettingViewMode3 == null) {
            j.t("viewModel");
        }
        autoUpdateSettingViewMode3.h().observe(this, new e());
    }

    @Override // com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog.a
    public void v(int i) {
        this.p2 = i * 60;
        TextView auto_update_time = (TextView) e1(com.tplink.iot.a.auto_update_time);
        j.d(auto_update_time, "auto_update_time");
        auto_update_time.setText(this.p0[i]);
        MenuItem menuItem = this.p3;
        if (menuItem == null) {
            j.t("mMenuSave");
        }
        menuItem.setEnabled(q1());
    }
}
