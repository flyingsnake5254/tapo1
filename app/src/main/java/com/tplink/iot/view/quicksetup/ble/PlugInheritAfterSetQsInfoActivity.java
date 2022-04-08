package com.tplink.iot.view.quicksetup.ble;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.PlugNickNameInputActivity;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;

/* loaded from: classes2.dex */
public class PlugInheritAfterSetQsInfoActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupViewModel p0;
    private String p1;
    private long p2 = 0;
    private QuickSetupInfoBean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<Boolean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<Boolean> iVar) {
            if (iVar == null || !iVar.a().booleanValue()) {
                s0.g();
                PlugInheritAfterSetQsInfoActivity.this.o1();
                return;
            }
            PlugInheritAfterSetQsInfoActivity.this.p0.F0(PlugInheritAfterSetQsInfoActivity.this.p1);
            PlugInheritAfterSetQsInfoActivity.this.k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                PlugInheritAfterSetQsInfoActivity.this.m1();
            } else {
                PlugInheritAfterSetQsInfoActivity.this.n1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        this.p2 = System.currentTimeMillis();
        this.p0.P(this.y.getResultDeviceIdMD5(), this.z, true);
    }

    private void l1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        ConnectWiFiPairActivity.r1(this, this.y, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        CommonQuickSetupBean commonQuickSetupBean;
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            if (this.z) {
                quickSetupInfoBean.setDeviceIdMD5(quickSetupInfoBean.getResultDeviceIdMD5());
            }
            commonQuickSetupBean = new CommonQuickSetupBean(this.y.getDeviceIdMD5(), this.y.getComponentResult(), this.y.isKeepInherit());
        } else {
            commonQuickSetupBean = null;
        }
        SetupSuccessActivity.p1(this, commonQuickSetupBean, null, 0L);
        q1();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        PlugNickNameInputActivity.p1(this, this.y);
    }

    private void p1() {
        ((Button) findViewById(R.id.btn_follow)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(this);
    }

    private void q1() {
        if (this.y != null) {
            r.u(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.p2) / 1000));
        }
    }

    public static void r1(Context context, QuickSetupInfoBean quickSetupInfoBean) {
        Intent intent = new Intent(context, PlugInheritAfterSetQsInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("device_info_bean", quickSetupInfoBean);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void s1(boolean z) {
        s0.l(this);
        this.p0.K0(new InheritInfoParams(z));
    }

    private void t1() {
        this.p0.g0().observe(this, new a());
        this.p0.b0().observe(this, new b());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_follow) {
            QuickSetupInfoBean quickSetupInfoBean = this.y;
            if (quickSetupInfoBean != null) {
                quickSetupInfoBean.setKeepInherit(true);
            }
            s1(true);
        } else if (id == R.id.tv_skip) {
            s1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_plug_inherit_after_set_qs_info);
            l1();
            QuickSetupInfoBean quickSetupInfoBean = this.y;
            if (quickSetupInfoBean != null) {
                this.p1 = quickSetupInfoBean.getDeviceIdMD5();
            }
            boolean L = d.L(this.y);
            this.z = L;
            if (L) {
                QuickSetupInfoBean quickSetupInfoBean2 = this.y;
                this.p0 = (QuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBean2 == null ? "" : quickSetupInfoBean2.getDeviceIdMD5())).get(QuickSetupViewModel.class);
            }
            p1();
            t1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
        if (this.z) {
            this.p0.F0(this.p1);
        }
    }
}
