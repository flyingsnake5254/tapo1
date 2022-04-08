package com.tplink.iot.view.ipcamera.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAdvancedSettingNewIpcBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.AdvancedSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class AdvancedSettingActivity extends BaseActivity implements View.OnClickListener {
    private UniversalDialog H3;
    private CloudTerraceControlViewModel p0;
    private LensMaskViewModel p1;
    private LdcSettingViewModel p2;
    private DiagnoseSettingViewModel p3;
    private ActivityAdvancedSettingNewIpcBinding y;
    private AdvancedSettingViewModel z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1() {
        this.p0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1() {
        this.p0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1() {
        this.p1.g(Boolean.FALSE, new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.g
            @Override // java.lang.Runnable
            public final void run() {
                AdvancedSettingActivity.this.f1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1() {
        this.H3.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1(a aVar) {
        String str;
        if (aVar != null && (str = (String) aVar.a()) != null) {
            TSnackbar.y(this, str, 0).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1(a aVar) {
        String str;
        if (aVar != null && (str = (String) aVar.a()) != null) {
            TSnackbar.y(this, str, 0).N();
        }
    }

    private void s1() {
        g.q(this.z.f10678d);
    }

    private void t1() {
        if (this.H3 == null) {
            UniversalDialog.a aVar = new UniversalDialog.a();
            aVar.q(getString(R.string.cloud_terrace_correct_condition));
            aVar.u(getString(R.string.cloud_terrace_correct_confirm));
            aVar.s(getString(R.string.action_cancel));
            aVar.t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.c
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    AdvancedSettingActivity.this.l1();
                }
            });
            aVar.r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.setting.f
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    AdvancedSettingActivity.this.n1();
                }
            });
            aVar.o(R.layout.dialog_cloud_terrace_correct);
            UniversalDialog l = aVar.l();
            this.H3 = l;
            l.setCancelable(false);
        }
        this.H3.show(getSupportFragmentManager(), "CorrectDialog");
    }

    private void u1() {
        this.p0.Q3.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdvancedSettingActivity.this.p1((a) obj);
            }
        });
        this.z.t.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdvancedSettingActivity.this.r1((a) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cloud_terrace_correct /* 2131362265 */:
                s1();
                if (j.h(this.p1.f10527c)) {
                    t1();
                    return;
                } else if (this.p0.z()) {
                    TSnackbar.x(this, R.string.cloud_terrace_cruising_hint, PathInterpolatorCompat.MAX_NUM_POINTS).N();
                    return;
                } else {
                    this.p0.n(true, new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AdvancedSettingActivity.this.h1();
                        }
                    });
                    return;
                }
            case R.id.diagnose_mode /* 2131362423 */:
                Intent intent = new Intent(this, DiagnoseSettingActivity.class);
                intent.putExtra("device_id_md5", this.z.f10678d);
                startActivity(intent);
                return;
            case R.id.ldc_mode /* 2131363217 */:
                Intent intent2 = new Intent(this, LdcSettingActivity.class);
                intent2.putExtra("device_id_md5", this.z.f10678d);
                startActivity(intent2);
                return;
            case R.id.light_frequency /* 2131363230 */:
                if (this.z.g()) {
                    Intent intent3 = new Intent(this, LightFrequencyActivity.class);
                    intent3.putExtra("device_id_md5", this.z.f10678d);
                    startActivity(intent3);
                    return;
                }
                return;
            case R.id.osd /* 2131363601 */:
                Intent intent4 = new Intent(this, OsdActivity.class);
                intent4.putExtra("device_id_md5", this.z.f10678d);
                startActivity(intent4);
                return;
            case R.id.password /* 2131363619 */:
                if (this.z.f()) {
                    Intent intent5 = new Intent(this, PasswordSettingActivity.class);
                    intent5.putExtra("device_id_md5", this.z.f10678d);
                    startActivity(intent5);
                    return;
                }
                return;
            case R.id.privacy_mode /* 2131363700 */:
                if (this.p0.y()) {
                    TSnackbar.x(this, R.string.cloud_terrace_correcting_hint, PathInterpolatorCompat.MAX_NUM_POINTS).N();
                    return;
                } else if (this.p0.z()) {
                    TSnackbar.x(this, R.string.cloud_terrace_cruising_hint, PathInterpolatorCompat.MAX_NUM_POINTS).N();
                    return;
                } else {
                    startActivity(new Intent(this, LensMaskActivity.class).putExtra("device_id_md5", this.z.f10678d));
                    return;
                }
            case R.id.record_audio /* 2131363780 */:
                Intent intent6 = new Intent(this, RecordAudioSettingActivity.class);
                intent6.putExtra("device_id_md5", this.z.f10678d);
                startActivity(intent6);
                return;
            case R.id.upnp_setting /* 2131364751 */:
                if (this.z.h()) {
                    Intent intent7 = new Intent(this, UpnpSettingActivity.class);
                    intent7.putExtra("device_id_md5", this.z.f10678d);
                    startActivity(intent7);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityAdvancedSettingNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_advanced_setting_new_ipc);
        this.z = (AdvancedSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(AdvancedSettingViewModel.class);
        CloudTerraceControlViewModel cloudTerraceControlViewModel = (CloudTerraceControlViewModel) ViewModelProviders.of(this).get(CloudTerraceControlViewModel.class);
        this.p0 = cloudTerraceControlViewModel;
        cloudTerraceControlViewModel.o0(false);
        this.p0.m0(stringExtra);
        LensMaskViewModel lensMaskViewModel = (LensMaskViewModel) ViewModelProviders.of(this).get(LensMaskViewModel.class);
        this.p1 = lensMaskViewModel;
        lensMaskViewModel.C(stringExtra);
        this.z.w();
        LdcSettingViewModel ldcSettingViewModel = (LdcSettingViewModel) ViewModelProviders.of(this).get(LdcSettingViewModel.class);
        this.p2 = ldcSettingViewModel;
        ldcSettingViewModel.o(stringExtra);
        this.p2.p(this);
        DiagnoseSettingViewModel diagnoseSettingViewModel = (DiagnoseSettingViewModel) ViewModelProviders.of(this).get(DiagnoseSettingViewModel.class);
        this.p3 = diagnoseSettingViewModel;
        diagnoseSettingViewModel.r(stringExtra);
        this.p3.s(this);
        this.y.o(this.z);
        this.y.n(this.p1);
        this.y.i(this.p0);
        this.y.m(this.p2);
        this.y.l(this.p3);
        this.y.h(this);
        this.y.T3.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvancedSettingActivity.this.j1(view);
            }
        });
        this.y.setLifecycleOwner(this);
        this.z.j();
        this.p1.D(this);
        u1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UniversalDialog universalDialog = this.H3;
        if (universalDialog != null && universalDialog.isVisible()) {
            this.H3.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.z.x();
    }
}
