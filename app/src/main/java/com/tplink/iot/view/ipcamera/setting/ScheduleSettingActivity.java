package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityScheduleSettingBinding;
import com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog;
import com.tplink.iot.view.ipcamera.setting.ScheduleSettingActivity;
import com.tplink.iot.view.ipcamera.setting.detection.DetectionSettingActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordTypeDialogFragment;
import com.tplink.iot.viewmodel.ipcamera.setting.l9;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import io.reactivex.g0.g;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ScheduleSettingActivity extends AppCompatActivity implements RecordTypeDialogFragment.a, View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private RecordPlanViewModel f9150c;

    /* renamed from: d  reason: collision with root package name */
    private ActivityScheduleSettingBinding f9151d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DetectionCloseDialog.a {
        final /* synthetic */ DetectionCloseDialog a;

        a(DetectionCloseDialog detectionCloseDialog) {
            this.a = detectionCloseDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(Boolean bool) throws Exception {
            ScheduleSettingActivity.this.f9150c.a.set(false);
            ScheduleSettingActivity.this.finish();
        }

        @Override // com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog.a
        public void a() {
            ScheduleSettingActivity.this.f9150c.a.set(true);
            ScheduleSettingActivity.this.f9150c.f().G0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.x3
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    ScheduleSettingActivity.a.this.d((Boolean) obj);
                }
            });
            this.a.dismiss();
        }

        @Override // com.tplink.iot.view.ipcamera.setting.DetectionCloseDialog.a
        public void b() {
            ScheduleSettingActivity scheduleSettingActivity = ScheduleSettingActivity.this;
            DetectionSettingActivity.s1(scheduleSettingActivity, scheduleSettingActivity.f9150c.g());
            this.a.dismiss();
            ScheduleSettingActivity.this.finish();
        }
    }

    private void Q0() {
        if (!this.f9150c.j() && this.f9150c.i() && this.f9150c.k()) {
            b.d.w.c.a.e("ScheduleSettingActivity", "detect disable");
            new UniversalDialog.a().q(getString(R.string.device_setting_detetion_close_msg_v2)).u(getString(R.string.device_enable)).s(getString(R.string.action_cancel)).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.setting.a4
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    ScheduleSettingActivity.this.T0();
                }
            }).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.d4
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    ScheduleSettingActivity.this.V0();
                }
            }).l().show(getSupportFragmentManager(), "");
        } else if (!this.f9150c.j() && this.f9150c.i()) {
            b.d.w.c.a.e("ScheduleSettingActivity", "detect disable but detect required");
            DetectionCloseDialog detectionCloseDialog = new DetectionCloseDialog();
            detectionCloseDialog.H0(new a(detectionCloseDialog));
            detectionCloseDialog.show(getSupportFragmentManager(), "");
        } else if (this.f9150c.i() || this.f9150c.k()) {
            b.d.w.c.a.e("ScheduleSettingActivity", "normal exit");
            finish();
        } else {
            b.d.w.c.a.e("ScheduleSettingActivity", "schedule table is empty");
            new UniversalDialog.a().q(getString(R.string.device_record_schedule_empty)).u(getString(R.string.common_add)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.y3
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    ScheduleSettingActivity.this.X0();
                }
            }).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.setting.c4
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    ScheduleSettingActivity.this.Z0();
                }
            }).l().show(getSupportFragmentManager(), "");
        }
    }

    private void R0() {
        this.f9151d.p2.setMaxPeriodsNumOneDay(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0() {
        DetectionSettingActivity.s1(this, this.f9150c.g());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0() {
        this.f9150c.f10824c.set(true);
        this.f9151d.p2.F(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0() {
        this.f9150c.a.set(true);
        this.f9150c.f().G0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.b4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                ScheduleSettingActivity.this.b1((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1(Boolean bool) throws Exception {
        this.f9150c.a.set(false);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1() {
        this.f9151d.p2.setRecordPlanCustomBeans(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(String str) {
        TSnackbar.y(this, str, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(View view) {
        onBackPressed();
    }

    public static void j1(Context context, String str) {
        Intent intent = new Intent(context, ScheduleSettingActivity.class);
        intent.putExtra("device_id_md5", str);
        context.startActivity(intent);
    }

    private void k1() {
        this.f9150c.D(false);
        this.f9151d.p2.setRecordPlanCustomBeans(this.f9150c.h());
        this.f9151d.p2.F(false);
    }

    private void l1() {
        new UniversalDialog.a().q(getString(R.string.schedule_clear_all_notice)).s(getString(R.string.common_cancel)).u(getString(R.string.common_clear_all)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.e4
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                ScheduleSettingActivity.this.d1();
            }
        }).l().show(getSupportFragmentManager(), "CLEAR");
    }

    private void m1(boolean z) {
        if (!z) {
            ArrayList<RecordPlanBean> allRecordPlanBeans = this.f9151d.p2.getAllRecordPlanBeans();
            b.d.w.c.a.e("ScheduleSettingActivity", "savePlans" + allRecordPlanBeans.size());
            String F = this.f9150c.F(allRecordPlanBeans);
            if (!TextUtils.isEmpty(F)) {
                UniversalDialog.a aVar = new UniversalDialog.a();
                aVar.q(getString(R.string.up_to_time_can_set_a_day, new Object[]{10}) + "\n" + getString(R.string.exceeded_on, new Object[]{F})).u(getString(R.string.common_ok)).l().show(getSupportFragmentManager(), "Error");
                return;
            }
        }
        this.f9150c.D(z);
        this.f9151d.p2.F(z);
        l9.a().b(this.f9150c.g()).U();
    }

    private void n1() {
        new RecordTypeDialogFragment().show(getSupportFragmentManager(), "SELECT-ALL");
    }

    private void o1() {
        Toolbar toolbar = this.f9151d.K3;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.f4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScheduleSettingActivity.this.h1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int i2 = 1;
        if (i == R.id.item_motion) {
            i2 = 2;
        }
        this.f9151d.p2.setCurrentRecordType(i2);
    }

    @Override // com.tplink.iot.viewmodel.ipcamera.setting.RecordTypeDialogFragment.a
    public void Y(int i) {
        this.f9151d.p2.setAllWeekRecordPlanByType(i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9150c.a.get()) {
            finish();
        } else if (this.f9150c.l()) {
            k1();
        } else {
            Q0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit /* 2131362501 */:
                m1(!this.f9150c.f10824c.get());
                return;
            case R.id.record_custom_clear_all_tv /* 2131363783 */:
                l1();
                return;
            case R.id.record_custom_select_all_tv /* 2131363784 */:
                n1();
                return;
            case R.id.right_btn /* 2131363868 */:
                m1(!this.f9150c.f10824c.get());
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
        this.f9151d = (ActivityScheduleSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_schedule_setting);
        RecordPlanViewModel recordPlanViewModel = (RecordPlanViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(RecordPlanViewModel.class);
        this.f9150c = recordPlanViewModel;
        this.f9151d.l(recordPlanViewModel);
        this.f9151d.i(this);
        this.f9151d.h(new RadioGroup.OnCheckedChangeListener() { // from class: com.tplink.iot.view.ipcamera.setting.g4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                ScheduleSettingActivity.this.onCheckedChanged(radioGroup, i);
            }
        });
        o1();
        R0();
        RecordPlanViewModel recordPlanViewModel2 = this.f9150c;
        final RecordCustomSettingView recordCustomSettingView = this.f9151d.p2;
        recordCustomSettingView.getClass();
        recordPlanViewModel2.H(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.q3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecordCustomSettingView.this.setRecordPlanCustomBeans((ArrayList) obj);
            }
        });
        this.f9150c.a.set(true);
        this.f9150c.C(stringExtra);
        j.c(this.f9150c.m, this, new b() { // from class: com.tplink.iot.view.ipcamera.setting.z3
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                ScheduleSettingActivity.this.f1((String) obj);
            }
        });
    }
}
