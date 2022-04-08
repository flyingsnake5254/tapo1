package com.tplink.iot.view.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import b.d.n.i.h;
import com.tplink.iot.R;
import com.tplink.iot.Utils.p;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.viewmodel.welcome.StartupViewModel;

/* loaded from: classes2.dex */
public class StartupActivity extends BaseActivity {
    private String H3;
    private String J3;
    private String K3;
    private String p0;
    private String p1;
    private String z;
    private StartupViewModel y = null;
    private boolean p2 = false;
    private boolean p3 = false;
    private Integer I3 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                StartupActivity.this.q1(true);
            } else {
                StartupActivity.this.q1(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            if (StartupActivity.this.p3 || num == null) {
                StartupActivity.this.m1(num);
            }
            StartupActivity.this.p2 = true;
            StartupActivity.this.I3 = num;
        }
    }

    private void j1(Intent intent) {
        if (intent != null) {
            this.z = intent.getStringExtra("fcm_device_id");
            this.p0 = intent.getStringExtra("fcm_event_time");
            this.p1 = intent.getStringExtra("notification_msg_type");
            this.H3 = intent.getStringExtra("task_id");
            this.J3 = intent.getStringExtra("deviceId");
            this.K3 = intent.getStringExtra("summaryDate");
        }
    }

    private void k1() {
        b.d.n.f.b.l().clear();
        p.c();
        s0.g();
        W0(LoginActivity.class);
        overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_between_interface_bottom_out);
        finish();
    }

    private void l1(boolean z) {
        this.y.t(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                com.tplink.iot.Utils.x0.p.i();
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(67108864);
                if (!TextUtils.isEmpty(this.H3)) {
                    intent.putExtra("task_id", this.H3);
                    this.H3 = null;
                }
                String str = this.z;
                if (!(str == null || this.p0 == null)) {
                    intent.putExtra("fcm_device_id", str);
                    intent.putExtra("fcm_event_time", this.p0);
                    intent.putExtra("notification_msg_type", this.p1);
                    this.z = null;
                    this.p0 = null;
                    this.p1 = null;
                }
                if (!TextUtils.isEmpty(this.J3)) {
                    intent.putExtra("deviceId", this.J3);
                }
                if (!TextUtils.isEmpty(this.K3)) {
                    intent.putExtra("summaryDate", this.K3);
                }
                startActivity(intent);
                finish();
            } else if (intValue != 1) {
                k1();
            } else {
                k1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1() {
        Integer num;
        if (!this.p2 || (num = this.I3) == null) {
            b.d.n.f.b.l().b();
        } else {
            m1(num);
        }
        this.p3 = true;
    }

    private void p1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 512 | 256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(boolean z) {
        l1(z);
    }

    private void r1() {
        c.l();
        this.y.n().observe(this, new a());
        this.y.m().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            if ((getIntent().getFlags() & 4194304) != 0) {
                finish();
                return;
            }
            p1();
            setContentView(R.layout.activity_startup);
            this.y = (StartupViewModel) ViewModelProviders.of(this).get(StartupViewModel.class);
            u.a(this);
            b.d.n.f.b.l().h(new h() { // from class: com.tplink.iot.view.welcome.a
                @Override // b.d.n.i.h
                public final void onFinish() {
                    StartupActivity.this.o1();
                }
            });
            b.d.n.f.b.l().d(this);
            this.y.p();
            r1();
            j1(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        j1(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (o.a() != 0) {
            this.y.v();
        }
    }
}
