package com.tplink.iot.view.authflip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.authflip.GoogleAssistantViewModel;

/* loaded from: classes2.dex */
public class GoogleAssistantActivity extends BaseActivity {
    private View p0;
    private GoogleAssistantViewModel y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            s0.g();
            if (bool.booleanValue()) {
                GoogleAssistantActivity.this.z.setVisibility(0);
                GoogleAssistantActivity.this.p0.setVisibility(8);
                return;
            }
            GoogleAssistantActivity.this.z.setVisibility(8);
            GoogleAssistantActivity.this.p0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            GoogleAssistantActivity.this.y.s();
        }
    }

    private void h1(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(View view) {
        h1(b.d.k.d.a.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(View view) {
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == -100) {
                s0.l(this);
            } else if (intValue != 1) {
                s0.n(this, R.string.general_failed);
            } else {
                s0.A(this, R.string.wss_success, null);
            }
        }
    }

    private void o1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.unlink_third_party_tips)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.action_unlink, R.color.common_iot_red, new b()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void p1() {
        this.y.h().observe(this, new a());
        this.y.i().observe(this, new Observer() { // from class: com.tplink.iot.view.authflip.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GoogleAssistantActivity.this.n1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_google_assistant);
        this.y = (GoogleAssistantViewModel) ViewModelProviders.of(this).get(GoogleAssistantViewModel.class);
        this.z = findViewById(R.id.layout_authorized);
        this.p0 = findViewById(R.id.layout_unauthorized);
        b1(R.string.google_assistant);
        findViewById(R.id.btn_go_google).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.authflip.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoogleAssistantActivity.this.j1(view);
            }
        });
        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.authflip.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoogleAssistantActivity.this.l1(view);
            }
        });
        s0.l(this);
        this.y.g();
        p1();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        s0.l(this);
        this.y.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (s0.j()) {
            s0.g();
        }
    }
}
