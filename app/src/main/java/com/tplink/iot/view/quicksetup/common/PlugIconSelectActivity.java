package com.tplink.iot.view.quicksetup.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.x0.u;
import com.tplink.iot.adapter.quicksetup.PlugIconAdapter;
import com.tplink.iot.adapter.quicksetup.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.ConnectWiFiPairActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugIconSelectActivity extends BaseActivity implements View.OnClickListener {
    private TPRefreshableButton H3;
    private String I3;
    private boolean J3;
    private boolean K3;
    private ImageView L3;
    private boolean M3;
    private boolean N3;
    private boolean O3;
    private QuickSetupInfoBean p1;
    private QuickSetupDeviceInfoBean p2;
    private QuickSetupViewModel p3;
    private String y = PlugIconSelectActivity.class.getSimpleName();
    private PlugIconAdapter z = null;
    private List<g> p0 = new ArrayList();
    private long P3 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<Boolean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<Boolean> iVar) {
            PlugIconSelectActivity.this.O3 = iVar == null || iVar.b() != 0;
            PlugIconSelectActivity plugIconSelectActivity = PlugIconSelectActivity.this;
            plugIconSelectActivity.A1(plugIconSelectActivity.O3);
            if (PlugIconSelectActivity.this.J3) {
                if (PlugIconSelectActivity.this.K3) {
                    PlugIconSelectActivity.this.p3.F0(PlugIconSelectActivity.this.I3);
                }
                PlugIconSelectActivity.this.r1();
                return;
            }
            PlugIconSelectActivity.this.u1();
            PlugIconSelectActivity.this.x1(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                PlugIconSelectActivity.this.t1();
            } else if (PlugIconSelectActivity.this.J3) {
                PlugIconSelectActivity.this.u1();
            } else {
                PlugIconSelectActivity.this.C1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(boolean z) {
        if (this.p2 != null) {
            if (z) {
                r.l(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
            } else {
                r.m(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
            }
        }
    }

    private void B1() {
        CommonQuickSetupBean commonQuickSetupBean;
        QuickSetupInfoBean quickSetupInfoBean = this.p1;
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = null;
        if (quickSetupInfoBean != null) {
            if (this.J3) {
                quickSetupInfoBean.setDeviceIdMD5(quickSetupInfoBean.getResultDeviceIdMD5());
            }
            commonQuickSetupBean = new CommonQuickSetupBean(this.p1.getDeviceIdMD5(), this.p1.getComponentResult());
        } else {
            commonQuickSetupBean = null;
        }
        if (this.O3) {
            quickSetupDeviceInfoBean = this.p2;
        }
        QuickSetupInfoBean quickSetupInfoBean2 = this.p1;
        SetupSuccessActivity.p1(this, commonQuickSetupBean, quickSetupDeviceInfoBean, quickSetupInfoBean2 != null ? quickSetupInfoBean2.getOnboardingStartTime() : 0L);
        z1();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        this.p2.setAvatar(this.z.n().getName());
        QuickSetupInfoBean quickSetupInfoBean = this.p1;
        int x = quickSetupInfoBean != null ? d.x(quickSetupInfoBean.getComponentResult()) : 1;
        QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean(this.p2.getNickname(), this.p2.getAvatar());
        if (!this.K3) {
            quickSetupDeviceInfoBean.setLocation(this.p2.getLocation());
        }
        this.p3.J0(quickSetupDeviceInfoBean, x);
        if (this.K3) {
            this.p3.I0(this.p1.getResultDeviceId(), this.p2.getLocation());
        }
    }

    private void D1() {
        this.p3.f0().observe(this, new a());
        this.p3.b0().observe(this, new b());
    }

    private void q1() {
        TPRefreshableButton tPRefreshableButton = this.H3;
        if (tPRefreshableButton != null) {
            tPRefreshableButton.setText(getString(R.string.try_again));
            this.H3.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        this.P3 = System.currentTimeMillis();
        this.p3.P(this.p1.getResultDeviceIdMD5(), this.J3, this.K3);
    }

    private void s1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p1 = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            this.p2 = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        ConnectWiFiPairActivity.r1(this, this.p1, this.O3 ? this.p2 : null);
        y1();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        if (this.J3) {
            this.N3 = true;
        }
        B1();
    }

    private void v1() {
        EnumIoTAvatarType[] values;
        String q = d.q(this.p1);
        for (EnumIoTAvatarType enumIoTAvatarType : EnumIoTAvatarType.values()) {
            if (!w.b() || !"P105".equals(q) || w.e(enumIoTAvatarType)) {
                new g().c(enumIoTAvatarType);
                this.p0.add(new g(enumIoTAvatarType));
            }
        }
        this.p0.get(0).d(true);
    }

    private void w1() {
        ImageView imageView = (ImageView) findViewById(R.id.img_back);
        this.L3 = imageView;
        imageView.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.icon_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        PlugIconAdapter plugIconAdapter = new PlugIconAdapter(this, this.p0);
        this.z = plugIconAdapter;
        recyclerView.setAdapter(plugIconAdapter);
        TPRefreshableButton tPRefreshableButton = (TPRefreshableButton) findViewById(R.id.btn_bottom);
        this.H3 = tPRefreshableButton;
        tPRefreshableButton.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(i<Boolean> iVar) {
        if (iVar != null && iVar.b() != 0) {
            u.g(iVar.b());
        }
    }

    private void y1() {
        if (this.p1 != null) {
            r.v(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.P3) / 1000));
        }
    }

    private void z1() {
        if (this.p1 != null) {
            r.u(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.P3) / 1000));
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.M3) {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            this.M3 = true;
            this.L3.setVisibility(4);
            if (this.J3) {
                C1();
            } else {
                r1();
            }
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_plug_icon_select_icon);
            s1();
            QuickSetupInfoBean quickSetupInfoBean = this.p1;
            if (quickSetupInfoBean != null) {
                this.I3 = quickSetupInfoBean.getDeviceIdMD5();
            }
            this.J3 = d.L(this.p1);
            this.K3 = d.W(this.p1);
            if (this.J3) {
                QuickSetupInfoBean quickSetupInfoBean2 = this.p1;
                this.p3 = (QuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBean2 == null ? "" : quickSetupInfoBean2.getDeviceIdMD5())).get(QuickSetupViewModel.class);
            } else {
                this.p3 = (QuickSetupViewModel) ViewModelProviders.of(this).get(QuickSetupViewModel.class);
            }
            v1();
            w1();
            D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QuickSetupViewModel quickSetupViewModel = this.p3;
        if (quickSetupViewModel != null) {
            quickSetupViewModel.F();
            if (this.N3) {
                this.p3.F0(this.I3);
            }
        }
        q1();
        super.onDestroy();
    }
}
