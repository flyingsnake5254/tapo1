package com.tplink.iot.view.pse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.ble.BleAddPlugActivity;

/* loaded from: classes2.dex */
public class PSEOnBoardingTipsActivity extends BaseActivity implements View.OnClickListener {
    private String y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            PSEOnBoardingTipsActivity.this.finish();
        }
    }

    private void e1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = extras.getString("device_model");
        }
    }

    private void f1() {
        BleAddPlugActivity.C1(this, this.y);
        finish();
    }

    private void g1() {
        findViewById(R.id.iv_close).setOnClickListener(this);
        findViewById(R.id.btn_agree).setOnClickListener(this);
        findViewById(R.id.btn_disagree).setOnClickListener(this);
        String string = getString(R.string.pse_remote_control_content_p1);
        String string2 = getString(R.string.pse_remote_control_content_p2);
        String string3 = getString(R.string.pse_remote_control_content_p3);
        String string4 = getString(R.string.pse_remote_control_content_p4);
        String string5 = getString(R.string.pse_remote_control_content_p5);
        String string6 = getString(R.string.pse_remote_control_content_p6);
        String string7 = getString(R.string.pse_remote_control_content_p7);
        String string8 = getString(R.string.pse_remote_control_content_p8);
        ((TextView) findViewById(R.id.tv_content)).setText(string + "\n" + string2 + "\n" + string3 + "\n" + string4 + "\n" + string5 + "\n" + string6 + "\n" + string7 + "\n" + string8);
    }

    public static void h1(Context context, String str) {
        Intent intent = new Intent(context, PSEOnBoardingTipsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_model", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void i1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.pse_disagree_warn_dialog_content)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.privacy_disagree, R.color.common_iot_main_blue, new a()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_agree) {
            f1();
        } else if (id == R.id.btn_disagree) {
            i1();
        } else if (id == R.id.iv_close) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pse_onboarding_tips);
        e1();
        g1();
    }
}
