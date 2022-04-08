package com.tplink.iot.view.quicksetup.bulb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

/* loaded from: classes2.dex */
public class BulbInheritBeforeSetQsInfoActivity extends BaseActivity implements View.OnClickListener {
    private e p0;
    private QuickSetupInfoBundle y;
    private WirelessInfoParams z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.tplink.iot.view.quicksetup.base.a {
        a() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            BulbInheritBeforeSetQsInfoActivity.this.j1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends com.tplink.iot.view.quicksetup.base.a {
        b() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            BulbInheritBeforeSetQsInfoActivity.this.j1(false);
        }
    }

    private void f1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
            this.z = (WirelessInfoParams) extras.getSerializable("ap_ssid");
        }
    }

    private void g1() {
        this.p0 = new e(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_follow)).setOnClickListener(new a());
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(new b());
    }

    public static void h1(Context context, QuickSetupInfoBundle quickSetupInfoBundle, WirelessInfoParams wirelessInfoParams) {
        Intent intent = new Intent(context, BulbInheritBeforeSetQsInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        if (wirelessInfoParams != null) {
            bundle.putSerializable("ap_ssid", wirelessInfoParams);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void i1(boolean z) {
        this.y.setSelectFollowInherit(z);
        SoftAPBulbConnectAPActivity.y1(this, this.y, this.z);
        r.t(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(boolean z) {
        if (com.tplink.iot.view.quicksetup.bulb.utils.a.f(this, this.y)) {
            i1(z);
        } else {
            this.p0.d(this.y.getBulbSSID());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_bulb_inherit_before_set_qs_info);
            f1();
            g1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.p0;
        if (eVar != null) {
            eVar.b();
        }
    }
}
