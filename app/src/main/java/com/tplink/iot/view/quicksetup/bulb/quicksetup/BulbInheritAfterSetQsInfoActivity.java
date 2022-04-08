package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;

/* loaded from: classes2.dex */
public class BulbInheritAfterSetQsInfoActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBundle y;
    private BulbQuickSetupViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<Boolean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<Boolean> iVar) {
            s0.g();
            if (iVar == null || !iVar.a().booleanValue()) {
                BulbInheritAfterSetQsInfoActivity.this.y.setInheritAndSuccess(false);
                BulbInheritAfterSetQsInfoActivity.this.j1();
                return;
            }
            BulbInheritAfterSetQsInfoActivity.this.y.setInheritAndSuccess(true);
            BulbInheritAfterSetQsInfoActivity.this.i1();
        }
    }

    private void h1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        com.tplink.iot.view.quicksetup.bulb.utils.a.c(this, this.y);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        BulbNickNameInputActivity.m1(this, this.y);
        finish();
    }

    private void k1() {
        ((Button) findViewById(R.id.btn_follow)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(this);
    }

    public static void l1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, BulbInheritAfterSetQsInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void m1(boolean z) {
        s0.l(this);
        this.z.D0(new InheritInfoParams(z));
    }

    private void n1() {
        this.z.a0().observe(this, new a());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_follow) {
            m1(true);
        } else if (id == R.id.tv_skip) {
            m1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_bulb_inherit_after_set_qs_info);
            h1();
            QuickSetupInfoBundle quickSetupInfoBundle = this.y;
            BulbQuickSetupViewModel bulbQuickSetupViewModel = (BulbQuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBundle == null ? "" : quickSetupInfoBundle.getDeviceIdMD5())).get(BulbQuickSetupViewModel.class);
            this.z = bulbQuickSetupViewModel;
            bulbQuickSetupViewModel.B0(this.y.getDeviceModel());
            k1();
            n1();
        }
    }
}
