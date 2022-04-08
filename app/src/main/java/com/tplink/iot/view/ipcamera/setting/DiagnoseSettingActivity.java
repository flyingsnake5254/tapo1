package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDiagnoseStatusBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class DiagnoseSettingActivity extends BaseActivity {
    private String p0;
    private DiagnoseSettingViewModel y;
    private ActivityDiagnoseStatusBinding z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed() && z != ((Boolean) j.e(DiagnoseSettingActivity.this.y.a, Boolean.FALSE)).booleanValue()) {
                DiagnoseSettingActivity.this.y.f(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            Boolean a;
            if (aVar != null && !aVar.b() && (a = aVar.a()) != null && a.booleanValue()) {
                new UniversalDialog.a().w(DiagnoseSettingActivity.this.getString(R.string.no_sd_card_title)).q(DiagnoseSettingActivity.this.getString(R.string.no_sd_card_hint)).u(DiagnoseSettingActivity.this.getString(R.string.action_got_it)).l().show(DiagnoseSettingActivity.this.getSupportFragmentManager(), "");
            }
        }
    }

    private void f1() {
        this.p0 = getIntent().getStringExtra("device_id_md5");
        DiagnoseSettingViewModel diagnoseSettingViewModel = (DiagnoseSettingViewModel) ViewModelProviders.of(this).get(DiagnoseSettingViewModel.class);
        this.y = diagnoseSettingViewModel;
        diagnoseSettingViewModel.s(this);
        this.y.r(this.p0);
    }

    private void g1() {
        this.y.g.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.o1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DiagnoseSettingActivity.this.j1((a) obj);
            }
        });
        this.y.h.observe(this, new b());
    }

    private void h1() {
        ActivityDiagnoseStatusBinding activityDiagnoseStatusBinding = (ActivityDiagnoseStatusBinding) DataBindingUtil.setContentView(this, R.layout.activity_diagnose_status);
        this.z = activityDiagnoseStatusBinding;
        activityDiagnoseStatusBinding.setLifecycleOwner(this);
        this.z.h(this.y);
        this.z.f6552d.setOnCheckedChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        if (aVar != null && !aVar.b()) {
            String str = (String) aVar.a();
            if (!TextUtils.isEmpty(str)) {
                TSnackbar.y(this, str, -1).N();
            }
        }
    }

    private void k1() {
        setTitle(R.string.diagnostics_setting);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        f1();
        h1();
        g1();
        k1();
    }
}
