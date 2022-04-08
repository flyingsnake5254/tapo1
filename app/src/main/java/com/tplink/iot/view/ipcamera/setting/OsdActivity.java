package com.tplink.iot.view.ipcamera.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityOsdNewIpcBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;

/* loaded from: classes2.dex */
public class OsdActivity extends BaseActivity implements View.OnClickListener {
    private ActivityOsdNewIpcBinding y;
    private OsdViewModel z;

    private void e1() {
        this.z.l.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.p3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OsdActivity.this.g1((Boolean) obj);
            }
        });
        this.z.m.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.m3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OsdActivity.this.i1((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(Boolean bool) {
        if (bool.booleanValue()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(Boolean bool) {
        if (bool.booleanValue()) {
            TSnackbar.y(this, getString(R.string.general_failed), -1).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(String str, View view) {
        this.z.B(false);
        g.p(str, this.z.f10809b.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(String str, View view) {
        this.z.B(true);
        g.o(str, this.z.f10810c.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(String str, View view) {
        this.z.C();
        g.n(str, this.z.f10813f.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.z.D();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cl_text) {
            OSDTextSettingActivity.y.a(this.z.j, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityOsdNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_osd_new_ipc);
        OsdViewModel osdViewModel = (OsdViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(OsdViewModel.class);
        this.z = osdViewModel;
        this.y.i(osdViewModel);
        this.y.h(this);
        this.y.p1.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.n3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OsdActivity.this.k1(view);
            }
        });
        this.z.z();
        this.y.x.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OsdActivity.this.m1(stringExtra, view);
            }
        });
        this.y.z.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.o3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OsdActivity.this.o1(stringExtra, view);
            }
        });
        this.y.y.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.l3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OsdActivity.this.q1(stringExtra, view);
            }
        });
        e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
