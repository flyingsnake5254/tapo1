package com.tplink.iot.view.quicksetup.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.g0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.PlugScanAPListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.ble.BlePlugConnectAPActivity;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugAPListActivity extends BaseActivity implements View.OnClickListener {
    private TPMaterialDialogV2 p0;
    private boolean p1;
    private QuickSetupInfoBean y;
    private List<WirelessScanInfoBean> z = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements com.tplink.iot.adapter.quicksetup.f {
        a() {
        }

        @Override // com.tplink.iot.adapter.quicksetup.f
        public void a(View view, int i) {
            PlugAPListActivity.this.s1(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements d0.g {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            PlugAPListActivity.this.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements d0.g {
        c() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            PlugAPListActivity.this.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Comparator<WirelessScanInfoBean> {
        d() {
        }

        /* renamed from: a */
        public int compare(WirelessScanInfoBean wirelessScanInfoBean, WirelessScanInfoBean wirelessScanInfoBean2) {
            return wirelessScanInfoBean2.getSignalLevel() - wirelessScanInfoBean.getSignalLevel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV2.d {
        final /* synthetic */ WirelessScanInfoBean a;

        e(WirelessScanInfoBean wirelessScanInfoBean) {
            this.a = wirelessScanInfoBean;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            PlugAPListActivity.this.z1(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV2.d {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            PlugAPListActivity.this.p1 = true;
            com.tplink.iot.view.quicksetup.base.d.Z(PlugAPListActivity.this.y, "ChooseWiFiPage");
        }
    }

    private void j1() {
        Bundle extras;
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            this.y = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            List<WirelessScanInfoBean> list = (List) extras.getSerializable("ap_ssid_list");
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                for (WirelessScanInfoBean wirelessScanInfoBean : list) {
                    if ("wep".equalsIgnoreCase(wirelessScanInfoBean.getKeyType())) {
                        arrayList.add(wirelessScanInfoBean);
                    } else {
                        this.z.add(wirelessScanInfoBean);
                    }
                }
                y1(this.z);
                y1(arrayList);
                this.z.addAll(arrayList);
            }
        }
    }

    private void k1(WirelessScanInfoBean wirelessScanInfoBean) {
        com.tplink.iot.view.quicksetup.base.d.D(this, ApPasswordInputActivity.class, this.y, new WirelessInfoParams(wirelessScanInfoBean.getSsid(), wirelessScanInfoBean.getKeyType()));
        v1(wirelessScanInfoBean);
    }

    private void l1() {
        com.tplink.iot.view.quicksetup.base.d.D(this, ApNamePasswordInputActivity.class, this.y, null);
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        com.tplink.iot.view.quicksetup.base.d.D(this, NoFindAPActivity.class, this.y, null);
    }

    private void n1(WirelessScanInfoBean wirelessScanInfoBean) {
        com.tplink.iot.view.quicksetup.base.d.E(this, BlePlugConnectAPActivity.class, this.y, new WirelessInfoParams(wirelessScanInfoBean.getSsid(), wirelessScanInfoBean.getKeyType()), 160);
        v1(wirelessScanInfoBean);
    }

    private void o1() {
        ((ImageView) findViewById(R.id.content_img_close)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_rescan_content)).setOnClickListener(this);
    }

    private void p1() {
        PlugScanAPListAdapter plugScanAPListAdapter = new PlugScanAPListAdapter(this, this.z);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ssid_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(plugScanAPListAdapter);
        plugScanAPListAdapter.o(new a());
        d0.h((TextView) findViewById(R.id.tv_no_find_ap), getString(R.string.quicksetup_ap_can_not_find_wifi), ContextCompat.getColor(this, R.color.common_iot_purple), new b());
    }

    private void q1() {
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_other)).setOnClickListener(this);
        d0.h((TextView) findViewById(R.id.tv_bottom), getString(R.string.quicksetup_ap_can_not_find_wifi), ContextCompat.getColor(this, R.color.common_iot_purple), new c());
    }

    private void r1() {
        View findViewById = findViewById(R.id.view_content);
        View findViewById2 = findViewById(R.id.view_empty);
        o1();
        List<WirelessScanInfoBean> list = this.z;
        if (list == null || list.isEmpty()) {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(8);
            q1();
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(8);
        p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(int i) {
        if (i >= this.z.size()) {
            l1();
            return;
        }
        WirelessScanInfoBean wirelessScanInfoBean = this.z.get(i);
        if ("none".equals(wirelessScanInfoBean.getKeyType())) {
            x1(wirelessScanInfoBean);
        } else {
            k1(wirelessScanInfoBean);
        }
    }

    private void t1() {
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            r.f(quickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
        }
    }

    private void u1() {
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            r.n(quickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
        }
    }

    private void v1(WirelessScanInfoBean wirelessScanInfoBean) {
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            r.q(quickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), wirelessScanInfoBean.getSignalLevel(), wirelessScanInfoBean.getKeyType());
        }
    }

    private void w1() {
        com.tplink.iot.view.quicksetup.base.d.e0(this, new f());
    }

    private void x1(WirelessScanInfoBean wirelessScanInfoBean) {
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(this).setMessage(R.string.quicksetup_ap_password_key_none).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.quicksetup_ap_password_key_none_continue, R.color.common_iot_main_blue, new e(wirelessScanInfoBean)).g(8, 8).create();
        this.p0 = a2;
        a2.show();
    }

    private void y1(List<WirelessScanInfoBean> list) {
        if (list != null && list.size() > 1) {
            g0.a(list, new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(WirelessScanInfoBean wirelessScanInfoBean) {
        n1(wirelessScanInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 160) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        switch (i2) {
            case -1705:
                s0.r(this, getString(R.string.quicksetup_encryption_not_supported), 5000L);
                return;
            case -1704:
                s0.r(this, getString(R.string.quicksetup_can_not_find), 5000L);
                return;
            case -1703:
                s0.r(this, getString(R.string.quicksetup_double_check), 5000L);
                return;
            default:
                return;
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        w1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom /* 2131362037 */:
            case R.id.tv_rescan_content /* 2131364603 */:
                setResult(-1);
                u1();
                finish();
                return;
            case R.id.btn_other /* 2131362084 */:
                l1();
                return;
            case R.id.content_img_close /* 2131362325 */:
                w1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_plug_ap_list_all);
            j1();
            r1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TPMaterialDialogV2 tPMaterialDialogV2 = this.p0;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.dismiss();
            this.p0 = null;
        }
        s0.g();
        if (this.p1) {
            com.tplink.iot.view.quicksetup.base.d.h(this.y);
        }
    }
}
