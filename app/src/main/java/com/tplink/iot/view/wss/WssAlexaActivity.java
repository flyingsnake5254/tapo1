package com.tplink.iot.view.wss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.wss.WssViewModel;
import com.tplink.libtpnetwork.libwss.bean.result.AlexaLinkInfoResult;
import org.apache.commons.lang.b;

/* loaded from: classes2.dex */
public class WssAlexaActivity extends BaseActivity implements View.OnClickListener {
    private AlexaLinkInfoResult H3;
    private TextView p0;
    private Button p1;
    private WssViewModel p2;
    private View y;
    private View z;
    private boolean p3 = false;
    private boolean I3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            WssAlexaActivity.this.p2.H();
        }
    }

    private Boolean f1(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return Boolean.FALSE;
        }
        this.I3 = true;
        this.p2.p(intent.getData());
        return Boolean.TRUE;
    }

    private void g1() {
        b1(R.string.amazon_alexa);
        this.y = findViewById(R.id.ll_content_unbind);
        this.z = findViewById(R.id.ll_content_bind);
        this.p0 = (TextView) findViewById(R.id.btn_bottom);
        this.p1 = (Button) findViewById(R.id.btn_unbind);
        this.p0.setOnClickListener(this);
        this.p1.setOnClickListener(this);
        this.p0.setVisibility(8);
        this.p1.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(AlexaLinkInfoResult alexaLinkInfoResult) {
        if (alexaLinkInfoResult != null) {
            this.p3 = alexaLinkInfoResult.getLinkStatus();
            this.H3 = alexaLinkInfoResult;
            s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(Boolean bool) {
        this.p3 = b.b(bool);
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(Boolean bool) {
        this.I3 = false;
        if (b.b(bool)) {
            s0.A(this, R.string.wss_success, null);
        } else {
            s0.n(this, R.string.general_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Boolean bool) {
        if (b.b(bool)) {
            s0.l(this);
        } else {
            s0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == -2) {
                r1();
            } else if (intValue != 1) {
                s0.n(this, R.string.general_failed);
            } else {
                s0.A(this, R.string.wss_success, null);
                this.p3 = false;
                s1();
            }
        }
    }

    private void r1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.wss_alexa_unlink_go_alexa_app_tips)).o(R.string.action_got_it, R.color.common_iot_main_blue, null).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void s1() {
        if (this.p3) {
            this.y.setVisibility(8);
            this.z.setVisibility(0);
            this.p0.setVisibility(8);
            this.p1.setVisibility(0);
            return;
        }
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.p0.setVisibility(0);
        this.p1.setVisibility(8);
    }

    private void t1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.unlink_third_party_tips)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.action_unlink, R.color.common_iot_red, new a()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void u1() {
        this.p2.o().observe(this, new Observer() { // from class: com.tplink.iot.view.wss.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WssAlexaActivity.this.i1((AlexaLinkInfoResult) obj);
            }
        });
        this.p2.k().observe(this, new Observer() { // from class: com.tplink.iot.view.wss.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WssAlexaActivity.this.k1((Boolean) obj);
            }
        });
        this.p2.l().observe(this, new Observer() { // from class: com.tplink.iot.view.wss.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WssAlexaActivity.this.m1((Boolean) obj);
            }
        });
        this.p2.m().observe(this, new Observer() { // from class: com.tplink.iot.view.wss.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WssAlexaActivity.this.o1((Boolean) obj);
            }
        });
        this.p2.n().observe(this, new Observer() { // from class: com.tplink.iot.view.wss.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WssAlexaActivity.this.q1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 111) {
            this.p3 = true;
            s1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_bottom) {
            if (id == R.id.btn_unbind) {
                t1();
            }
        } else if (this.H3 != null) {
            startActivityForResult(new Intent(this, WssAccountLinkWebActivity.class), 111);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wss_alexa);
        this.p2 = (WssViewModel) ViewModelProviders.of(this).get(WssViewModel.class);
        g1();
        if (!f1(getIntent()).booleanValue()) {
            s0.l(this);
            this.p2.i();
        }
        u1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f1(intent);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.I3) {
            this.p2.i();
        }
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
