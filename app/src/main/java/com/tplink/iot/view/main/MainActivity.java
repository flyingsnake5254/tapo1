package com.tplink.iot.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.i.a;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.home.HomeFragment;
import com.tplink.iot.view.me.MeFragment;
import com.tplink.iot.view.smart.SmartFragment;
import com.tplink.iot.view.welcome.b;
import com.tplink.libtpnetwork.Utils.o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MainActivity extends BaseActivity {
    private String H3;
    private String I3;
    private String J3;
    private String K3;
    private BottomNavigationView p0;
    private String p1;
    private String p2;
    private String p3;
    private String y;
    private Map<String, BaseFragment> z = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements BottomNavigationView.OnNavigationItemSelectedListener {
        a() {
        }

        @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.tab_home) {
                MainActivity.this.t1("main_home");
                return true;
            } else if (itemId == R.id.tab_me) {
                MainActivity.this.t1("main_me");
                return true;
            } else if (itemId != R.id.tab_smart) {
                return true;
            } else {
                MainActivity.this.t1("main_smart");
                return true;
            }
        }
    }

    private void f1() {
        if (!o.h0().i0()) {
            o.h0().D0();
            com.tplink.iot.Utils.x0.o.k(b.a(this), b.b(this));
        }
    }

    private void m1() {
        if (!TextUtils.isEmpty(this.I3)) {
            b.d.n.f.b.l().i(this.I3);
            this.I3 = null;
        }
    }

    private void n1() {
        t1("main_home");
    }

    private void o1(Bundle bundle) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bv_bottomNavigation);
        this.p0 = bottomNavigationView;
        bottomNavigationView.setItemIconTintList(null);
        this.p0.setItemTextAppearanceActive(R.style.bottom_selected_text);
        this.p0.setItemTextAppearanceInactive(R.style.bottom_normal_text);
        this.p0.inflateMenu(R.menu.main_tab_iot_cloud);
        this.p0.setOnNavigationItemSelectedListener(new a());
        if (bundle == null) {
            n1();
        } else {
            q1(bundle.getString("current_tag", "main_home"));
        }
    }

    @NonNull
    private BaseFragment p1(String str) {
        if (str == null) {
            return new HomeFragment();
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -251374683:
                if (str.equals("main_home")) {
                    c2 = 0;
                    break;
                }
                break;
            case 807407555:
                if (str.equals("main_smart")) {
                    c2 = 1;
                    break;
                }
                break;
            case 831022558:
                if (str.equals("main_me")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SmartFragment();
            case 2:
                return new MeFragment();
            default:
                return new HomeFragment();
        }
    }

    private void q1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "main_home";
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            if (fragment instanceof HomeFragment) {
                this.z.put("main_home", (BaseFragment) fragment);
            } else if (fragment instanceof SmartFragment) {
                this.z.put("main_smart", (BaseFragment) fragment);
            } else if (fragment instanceof MeFragment) {
                this.z.put("main_me", (BaseFragment) fragment);
            }
            beginTransaction.hide(fragment);
        }
        this.y = str;
        BaseFragment baseFragment = this.z.get(str);
        if (baseFragment == null) {
            baseFragment = p1(this.y);
            this.z.put(this.y, baseFragment);
        }
        if (baseFragment.isAdded()) {
            beginTransaction.show(baseFragment);
        } else {
            beginTransaction.add(R.id.container_layout, baseFragment, this.y);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(String str) {
        BaseFragment baseFragment;
        String str2 = this.y;
        if (str2 == null || !str2.equals(str)) {
            BaseFragment baseFragment2 = this.z.get(str);
            if (baseFragment2 == null) {
                baseFragment2 = p1(str);
                this.z.put(str, baseFragment2);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            String str3 = this.y;
            if (!(str3 == null || (baseFragment = this.z.get(str3)) == null)) {
                beginTransaction.hide(baseFragment);
            }
            if (baseFragment2.isAdded()) {
                beginTransaction.show(baseFragment2);
            } else {
                beginTransaction.add(R.id.container_layout, baseFragment2, str);
            }
            beginTransaction.commitAllowingStateLoss();
            this.y = str;
        }
    }

    public String g1() {
        String str = this.J3;
        this.J3 = null;
        return str;
    }

    public String h1() {
        String str = this.p1;
        this.p1 = null;
        return str;
    }

    public String i1() {
        String str = this.K3;
        this.K3 = null;
        return str;
    }

    public String j1() {
        return this.p2;
    }

    public String k1() {
        return this.H3;
    }

    public String l1() {
        return this.p3;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        MeFragment meFragment;
        super.onActivityResult(i, i2, intent);
        if (i == 1345 && (meFragment = (MeFragment) getSupportFragmentManager().findFragmentByTag("main_me")) != null) {
            meFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!a.C0212a.b(this)) {
            moveTaskToBack(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("fcm_device_id");
            this.p2 = getIntent().getStringExtra("fcm_event_time");
            this.p3 = getIntent().getStringExtra("notification_msg_type");
            this.H3 = getIntent().getStringExtra("fcm_uuid");
            this.I3 = getIntent().getStringExtra("task_id");
            if (stringExtra != null) {
                this.p1 = b.d.w.h.a.g(stringExtra);
            }
            this.J3 = getIntent().getStringExtra("deviceId");
            this.K3 = getIntent().getStringExtra("summaryDate");
        }
        o1(bundle);
        m1();
        f1();
        c.a();
        c.b();
        p.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("fcm_device_id");
        this.p2 = intent.getStringExtra("fcm_event_time");
        this.p3 = intent.getStringExtra("notification_msg_type");
        this.H3 = intent.getStringExtra("fcm_uuid");
        this.J3 = intent.getStringExtra("deviceId");
        this.K3 = intent.getStringExtra("summaryDate");
        boolean booleanExtra = intent.getBooleanExtra("app_downgrade_required", false);
        int i = R.id.tab_home;
        if (booleanExtra) {
            BaseFragment baseFragment = this.z.get("main_home");
            if (baseFragment instanceof HomeFragment) {
                t1("main_home");
                BottomNavigationView bottomNavigationView = this.p0;
                if (bottomNavigationView != null) {
                    bottomNavigationView.setSelectedItemId(R.id.tab_home);
                }
                ((HomeFragment) baseFragment).f3();
            }
        } else if (stringExtra != null) {
            this.p1 = b.d.w.h.a.g(stringExtra);
            BaseFragment baseFragment2 = this.z.get("main_home");
            if (baseFragment2 instanceof HomeFragment) {
                t1("main_home");
                BottomNavigationView bottomNavigationView2 = this.p0;
                if (bottomNavigationView2 != null) {
                    bottomNavigationView2.setSelectedItemId(R.id.tab_home);
                }
                ((HomeFragment) baseFragment2).p5(this);
            }
        } else {
            String stringExtra2 = intent.getStringExtra("tag_main_selected_item");
            if (!TextUtils.isEmpty(stringExtra2)) {
                if (!"main_home".equals(stringExtra2)) {
                    if ("main_smart".equals(stringExtra2)) {
                        i = R.id.tab_smart;
                    } else {
                        i = "main_me".equals(stringExtra2) ? R.id.tab_me : -1;
                    }
                }
                if (i != -1) {
                    this.p0.setSelectedItemId(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_tag", this.y);
    }

    public void r1(boolean z) {
        BottomNavigationView bottomNavigationView = this.p0;
        if (bottomNavigationView != null) {
            bottomNavigationView.getMenu().findItem(R.id.tab_me).setIcon(getResources().getDrawable(z ? R.drawable.main_me_red_point_selector : R.drawable.main_me_tab_selector));
        }
    }

    public void s1(boolean z) {
        this.p0.setVisibility(z ? 0 : 8);
    }
}
