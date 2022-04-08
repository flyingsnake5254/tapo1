package com.tplink.iot.view.quicksetup.firmware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class QuickSetupFirmwareSuccessActivity extends BaseActivity implements View.OnClickListener {
    private CommonQuickSetupBean y;

    private void e1() {
        if (f1() < 2 || k1()) {
            h1();
        } else {
            g1();
        }
    }

    private int f1() {
        CommonQuickSetupBean commonQuickSetupBean = this.y;
        if (commonQuickSetupBean != null) {
            return d.u(commonQuickSetupBean.getComponentResult());
        }
        return 0;
    }

    private void g1() {
        AutoUpdateHintActivity.y.a(this, this.y);
        finish();
    }

    private void h1() {
        String r = d.r(this.y);
        if (c.i(r)) {
            LightStripPlacementGuideActivity.y.b(this, r, true, this.y.isFromQuickDiscovery());
        } else {
            i1();
        }
    }

    private void i1() {
        a.d(this, this.y.isFromQuickDiscovery());
    }

    private void j1() {
        EnumDeviceType enumDeviceType;
        Bundle extras;
        Intent intent = getIntent();
        String str = null;
        if (intent == null || (extras = intent.getExtras()) == null) {
            enumDeviceType = null;
        } else {
            CommonQuickSetupBean commonQuickSetupBean = (CommonQuickSetupBean) extras.getSerializable("common_quick_setup_bean");
            this.y = commonQuickSetupBean;
            EnumDeviceType s = d.s(commonQuickSetupBean);
            str = d.r(this.y);
            enumDeviceType = s;
        }
        Button button = (Button) findViewById(R.id.btn_done);
        button.setOnClickListener(this);
        if (c.i(str)) {
            button.setText(R.string.precautions_for_use);
            TextView textView = (TextView) findViewById(R.id.tv_skip);
            textView.setVisibility(0);
            textView.setOnClickListener(this);
        }
        ((ImageView) findViewById(R.id.image_device)).setImageResource(com.tplink.iot.view.quicksetup.base.c.Y(enumDeviceType, str));
    }

    private boolean k1() {
        CommonQuickSetupBean commonQuickSetupBean = this.y;
        return commonQuickSetupBean != null && commonQuickSetupBean.isKeepInherit();
    }

    public static void l1(Context context, CommonQuickSetupBean commonQuickSetupBean) {
        Intent intent = new Intent(context, QuickSetupFirmwareSuccessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("common_quick_setup_bean", commonQuickSetupBean);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_done) {
            e1();
        } else if (id == R.id.tv_skip) {
            i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_firmware_success);
            j1();
        }
    }
}
