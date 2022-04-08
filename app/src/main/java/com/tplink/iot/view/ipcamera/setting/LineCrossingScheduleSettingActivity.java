package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityLineCrossingScheduleSettingBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingScheduleViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LineCrossingScheduleSettingActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private LineCrossingScheduleViewModel f9099c;

    /* renamed from: d  reason: collision with root package name */
    private ActivityLineCrossingScheduleSettingBinding f9100d;

    /* renamed from: f  reason: collision with root package name */
    private int f9101f = 3;

    private void P0() {
        this.f9100d.z.setMaxPeriodsNumOneDay(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0() {
        this.f9100d.z.setRecordPlanCustomBeans(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(ArrayList arrayList) {
        this.f9100d.z.setRecordPlanCustomBeans(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(String str) {
        TSnackbar.y(this, str, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(View view) {
        onBackPressed();
    }

    public static void Y0(Context context, String str, int i) {
        Intent intent = new Intent(context, LineCrossingScheduleSettingActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("detection_home_mode", i);
        context.startActivity(intent);
    }

    private void Z0() {
        this.f9099c.w(false);
        this.f9100d.z.setRecordPlanCustomBeans(this.f9099c.h());
        this.f9100d.z.F(false);
    }

    private void a1() {
        new UniversalDialog.a().q(getString(R.string.schedule_clear_all_notice)).s(getString(R.string.common_cancel)).u(getString(R.string.common_clear_all)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.s2
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                LineCrossingScheduleSettingActivity.this.R0();
            }
        }).l().show(getSupportFragmentManager(), "CLEAR");
    }

    private void b1(boolean z) {
        if (!z) {
            ArrayList<RecordPlanBean> allRecordPlanBeans = this.f9100d.z.getAllRecordPlanBeans();
            a.e("ScheduleSettingActivity", "savePlans" + allRecordPlanBeans.size());
            String z2 = this.f9099c.z(allRecordPlanBeans);
            if (!TextUtils.isEmpty(z2)) {
                UniversalDialog.a aVar = new UniversalDialog.a();
                aVar.q(getString(R.string.setting_set_schedules_tip, new Object[]{6}) + "\n" + getString(R.string.exceeded_on, new Object[]{z2})).u(getString(R.string.common_ok)).l().show(getSupportFragmentManager(), "Error");
                return;
            }
        }
        this.f9099c.w(z);
        this.f9100d.z.F(z);
    }

    private void c1() {
        this.f9100d.z.setAllWeekRecordPlanByType(1);
    }

    private void d1() {
        Toolbar toolbar = this.f9100d.H3;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.q2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LineCrossingScheduleSettingActivity.this.X0(view);
                }
            });
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9099c.f10757c.get()) {
            finish();
        } else if (this.f9099c.k()) {
            Z0();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit /* 2131362501 */:
                b1(!this.f9099c.g.get());
                return;
            case R.id.record_custom_clear_all_tv /* 2131363783 */:
                a1();
                return;
            case R.id.record_custom_select_all_tv /* 2131363784 */:
                c1();
                return;
            case R.id.right_btn /* 2131363868 */:
                b1(!this.f9099c.g.get());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.f9101f = getIntent().getIntExtra("detection_home_mode", 3);
        this.f9100d = (ActivityLineCrossingScheduleSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_line_crossing_schedule_setting);
        LineCrossingScheduleViewModel lineCrossingScheduleViewModel = (LineCrossingScheduleViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(LineCrossingScheduleViewModel.class);
        this.f9099c = lineCrossingScheduleViewModel;
        this.f9100d.i(lineCrossingScheduleViewModel);
        this.f9100d.h(this);
        d1();
        P0();
        this.f9099c.i().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.r2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LineCrossingScheduleSettingActivity.this.T0((ArrayList) obj);
            }
        });
        this.f9099c.j(this.f9101f);
        this.f9099c.u();
        j.c(this.f9099c.i, this, new b() { // from class: com.tplink.iot.view.ipcamera.setting.t2
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                LineCrossingScheduleSettingActivity.this.V0((String) obj);
            }
        });
    }
}
