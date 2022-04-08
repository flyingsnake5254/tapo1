package com.tplink.iot.view.cloudconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class CloudConnectSuccessActivity extends BaseActivity implements View.OnClickListener {
    private void e1() {
        setResult(-1);
        finish();
    }

    protected void f1() {
        ((Button) findViewById(R.id.btn_done)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_done || id == R.id.img_back) {
            e1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_cloud_connect_success);
            f1();
        }
    }
}
