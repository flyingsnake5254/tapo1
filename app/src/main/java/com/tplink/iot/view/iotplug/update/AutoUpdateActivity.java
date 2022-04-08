package com.tplink.iot.view.iotplug.update;

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
import com.tplink.iot.viewmodel.iotplug.AutoUpdateViewMode;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import java.util.HashMap;
import kotlin.jvm.internal.j;

/* compiled from: AutoUpdateActivity.kt */
/* loaded from: classes2.dex */
public final class AutoUpdateActivity extends BaseActivity implements AutoUpdateTimePickerDialog.a {
    private HashMap H3;
    private AutoUpdateTimePickerDialog p1;
    private MenuItem p3;
    private String y;
    private AutoUpdateViewMode z;
    private final String[] p0 = h.d();
    private int p2 = 180;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j.d(compoundButton, "compoundButton");
            if (compoundButton.isPressed()) {
                AutoUpdateActivity.g1(AutoUpdateActivity.this).setEnabled(AutoUpdateActivity.this.p1());
                LinearLayout layout_auto_update_schedule = (LinearLayout) AutoUpdateActivity.this.e1(com.tplink.iot.a.layout_auto_update_schedule);
                j.d(layout_auto_update_schedule, "layout_auto_update_schedule");
                layout_auto_update_schedule.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AutoUpdateActivity.this.q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<AutoUpdateBean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(AutoUpdateBean autoUpdateBean) {
            if (autoUpdateBean != null) {
                AutoUpdateActivity.this.p2 = autoUpdateBean.getTime();
                CheckBox auto_update_switch = (CheckBox) AutoUpdateActivity.this.e1(com.tplink.iot.a.auto_update_switch);
                j.d(auto_update_switch, "auto_update_switch");
                auto_update_switch.setChecked(autoUpdateBean.isEnable());
                AutoUpdateActivity autoUpdateActivity = AutoUpdateActivity.this;
                int m1 = autoUpdateActivity.m1(autoUpdateActivity.p2);
                TextView auto_update_time = (TextView) AutoUpdateActivity.this.e1(com.tplink.iot.a.auto_update_time);
                j.d(auto_update_time, "auto_update_time");
                auto_update_time.setText(AutoUpdateActivity.this.p0[m1]);
                LinearLayout layout_auto_update_schedule = (LinearLayout) AutoUpdateActivity.this.e1(com.tplink.iot.a.layout_auto_update_schedule);
                j.d(layout_auto_update_schedule, "layout_auto_update_schedule");
                layout_auto_update_schedule.setVisibility(autoUpdateBean.isEnable() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateActivity.kt */
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
                AutoUpdateActivity.this.finish();
            } else if (num.intValue() == -1) {
                AutoUpdateActivity autoUpdateActivity = AutoUpdateActivity.this;
                s0.p(autoUpdateActivity, autoUpdateActivity.getString(R.string.common_operation_failed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                ((CameraLoadingView) AutoUpdateActivity.this.e1(com.tplink.iot.a.loading_view)).a();
            } else {
                ((CameraLoadingView) AutoUpdateActivity.this.e1(com.tplink.iot.a.loading_view)).b();
            }
        }
    }

    public static final /* synthetic */ MenuItem g1(AutoUpdateActivity autoUpdateActivity) {
        MenuItem menuItem = autoUpdateActivity.p3;
        if (menuItem == null) {
            j.t("mMenuSave");
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m1(int i) {
        return (i / 60) % 24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p1() {
        AutoUpdateViewMode autoUpdateViewMode = this.z;
        if (autoUpdateViewMode == null) {
            j.t("viewModel");
        }
        if (autoUpdateViewMode.g == null) {
            return true;
        }
        int i = com.tplink.iot.a.auto_update_switch;
        if (((CheckBox) e1(i)) == null) {
            return true;
        }
        AutoUpdateViewMode autoUpdateViewMode2 = this.z;
        if (autoUpdateViewMode2 == null) {
            j.t("viewModel");
        }
        AutoUpdateBean autoUpdateBean = autoUpdateViewMode2.g;
        j.d(autoUpdateBean, "viewModel.autoUpdateCache");
        boolean isEnable = autoUpdateBean.isEnable();
        CheckBox auto_update_switch = (CheckBox) e1(i);
        j.d(auto_update_switch, "auto_update_switch");
        if (isEnable != auto_update_switch.isChecked()) {
            return true;
        }
        AutoUpdateViewMode autoUpdateViewMode3 = this.z;
        if (autoUpdateViewMode3 == null) {
            j.t("viewModel");
        }
        AutoUpdateBean autoUpdateBean2 = autoUpdateViewMode3.g;
        j.d(autoUpdateBean2, "viewModel.autoUpdateCache");
        return autoUpdateBean2.getTime() != this.p2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
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

    public final void n1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.y = stringExtra;
        if (stringExtra == null) {
            j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(AutoUpdateViewMode.class);
        j.d(viewModel, "ViewModelProviders.of(th…dateViewMode::class.java)");
        this.z = (AutoUpdateViewMode) viewModel;
    }

    public final void o1() {
        setContentView(R.layout.activity_auto_update);
        b1(R.string.firmware_auto_update);
        ((CheckBox) e1(com.tplink.iot.a.auto_update_switch)).setOnCheckedChangeListener(new a());
        int m1 = m1(this.p2);
        int i = com.tplink.iot.a.auto_update_time;
        TextView auto_update_time = (TextView) e1(i);
        j.d(auto_update_time, "auto_update_time");
        auto_update_time.setText(this.p0[m1]);
        ((TextView) e1(i)).setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n1();
        o1();
        r1();
        AutoUpdateViewMode autoUpdateViewMode = this.z;
        if (autoUpdateViewMode == null) {
            j.t("viewModel");
        }
        autoUpdateViewMode.f();
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
        findItem.setEnabled(p1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.common_save) {
            AutoUpdateViewMode autoUpdateViewMode = this.z;
            if (autoUpdateViewMode == null) {
                j.t("viewModel");
            }
            CheckBox auto_update_switch = (CheckBox) e1(com.tplink.iot.a.auto_update_switch);
            j.d(auto_update_switch, "auto_update_switch");
            autoUpdateViewMode.z(auto_update_switch.isChecked(), this.p2);
        }
        return super.onOptionsItemSelected(item);
    }

    public final void r1() {
        AutoUpdateViewMode autoUpdateViewMode = this.z;
        if (autoUpdateViewMode == null) {
            j.t("viewModel");
        }
        autoUpdateViewMode.g().observe(this, new c());
        AutoUpdateViewMode autoUpdateViewMode2 = this.z;
        if (autoUpdateViewMode2 == null) {
            j.t("viewModel");
        }
        autoUpdateViewMode2.i().observe(this, new d());
        AutoUpdateViewMode autoUpdateViewMode3 = this.z;
        if (autoUpdateViewMode3 == null) {
            j.t("viewModel");
        }
        autoUpdateViewMode3.h().observe(this, new e());
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
        menuItem.setEnabled(p1());
    }
}
