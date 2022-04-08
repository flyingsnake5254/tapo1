package com.tplink.iot.view.quicksetup.bulb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;

/* loaded from: classes2.dex */
public class BulbApNoFindAPActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBundle y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            BulbApNoFindAPActivity.this.g1();
        }
    }

    private void f1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        Intent intent = new Intent(this, BulbApNamePasswordInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", this.y);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void h1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        d0.d(this, (TextView) findViewById(R.id.tv_other), R.string.quicksetup_ap_can_not_find_wifi_name, getString(R.string.quicksetup_ap_other), new a());
    }

    public static void i1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, BulbApNoFindAPActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        intent.putExtras(bundle);
        context.startActivity(intent);
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
            setContentView(R.layout.activity_no_find_ap);
            f1();
            h1();
        }
    }
}
