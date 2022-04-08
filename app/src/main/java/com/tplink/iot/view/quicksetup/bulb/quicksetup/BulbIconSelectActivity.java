package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.IoTIconAdapter;
import com.tplink.iot.adapter.quicksetup.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class BulbIconSelectActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBundle p0;
    private QuickSetupDeviceInfoBean p1;
    private BulbQuickSetupViewModel p2;
    private TPRefreshableButton p3;
    private IoTIconAdapter z;
    private final String y = "BulbIconSelectActivity";
    boolean H3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<Boolean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<Boolean> iVar) {
            BulbIconSelectActivity.this.h1(iVar == null || iVar.b() != 0);
        }
    }

    private void f1() {
        TPRefreshableButton tPRefreshableButton = this.p3;
        if (tPRefreshableButton != null) {
            tPRefreshableButton.setText(getString(R.string.try_again));
            this.p3.h();
        }
    }

    private void g1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p0 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
            this.p1 = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(boolean z) {
        CommonQuickSetupBean commonQuickSetupBean = new CommonQuickSetupBean(this.p0.getDeviceIdMD5(), this.p0.getComponentResult());
        commonQuickSetupBean.setFromQuickDiscovery(this.p0.isFromQuickDiscovery());
        SetupSuccessActivity.p1(this, commonQuickSetupBean, z ? this.p1 : null, this.p0.getOnboardingStartTime());
        j1(z);
        finish();
    }

    private void i1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        TPRefreshableButton tPRefreshableButton = (TPRefreshableButton) findViewById(R.id.btn_bottom);
        this.p3 = tPRefreshableButton;
        tPRefreshableButton.setOnClickListener(this);
        m1();
    }

    private void j1(boolean z) {
        if (z) {
            r.l(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5());
        } else {
            r.m(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5());
        }
    }

    private void k1() {
        String str;
        b.d.w.c.a.d("setDeviceInfo");
        IoTIconAdapter ioTIconAdapter = this.z;
        if (ioTIconAdapter != null) {
            str = ioTIconAdapter.o();
        } else {
            str = EnumIoTAvatarType.PLUG.getName();
        }
        this.p1.setAvatar(str);
        this.p2.G0(this.p1, d.x(this.p0.getComponentResult()));
        if (!this.H3) {
            b.d.w.c.a.d("setDeviceInfo setDeviceFamilyAndRoom2Cloud");
            this.p2.A0(this.p1.getLocation());
            this.H3 = true;
        }
    }

    private void l1() {
        this.p2.b0().observe(this, new a());
    }

    private void m1() {
        ArrayList arrayList = new ArrayList();
        for (String str : b.m(this.p0.getDeviceModel())) {
            new e().c(str);
            arrayList.add(new e(str, false));
        }
        ((e) arrayList.get(0)).d(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.icon_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        IoTIconAdapter ioTIconAdapter = new IoTIconAdapter(arrayList, b.l(this.p0.getDeviceModel()), this.p0.getDeviceModel());
        this.z = ioTIconAdapter;
        recyclerView.setAdapter(ioTIconAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            k1();
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
            g1();
            QuickSetupInfoBundle quickSetupInfoBundle = this.p0;
            this.p2 = (BulbQuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBundle == null ? "" : quickSetupInfoBundle.getDeviceIdMD5())).get(BulbQuickSetupViewModel.class);
            i1();
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f1();
        super.onDestroy();
    }
}
