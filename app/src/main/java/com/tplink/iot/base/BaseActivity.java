package com.tplink.iot.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.b;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.o;
import com.tplink.iot.i.a;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.welcome.StartupActivity;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseActivity extends AppCompatActivity implements b.a {

    /* renamed from: c  reason: collision with root package name */
    protected b f6070c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6071d = false;

    /* renamed from: f  reason: collision with root package name */
    private long f6072f = 0;
    private Toolbar q = null;
    private TextView x = null;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseActivity.this.q == null) {
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.q = (Toolbar) baseActivity.findViewById(R.id.toolbar);
            }
            if (BaseActivity.this.q != null) {
                BaseActivity baseActivity2 = BaseActivity.this;
                baseActivity2.setSupportActionBar(baseActivity2.q);
            }
            if (BaseActivity.this.x == null) {
                BaseActivity baseActivity3 = BaseActivity.this;
                baseActivity3.x = (TextView) baseActivity3.findViewById(R.id.toolbar_title);
            }
        }
    }

    private void T0() {
        if (o.a() == 0) {
            if (this instanceof StartupActivity) {
                o.b(1);
                return;
            }
            Intent intent = new Intent(this, StartupActivity.class);
            intent.addFlags(268468224);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    public void U0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            supportFragmentManager.popBackStackImmediate();
        }
    }

    public <T extends Fragment> T V0(@NonNull Class<T> cls, String str) {
        T t = (T) getSupportFragmentManager().findFragmentByTag(str);
        if (t != null) {
            return t;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return t;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return t;
        }
    }

    public void W0(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void X0(Class<?> cls, String str) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("device_id_md5", str);
        startActivity(intent);
    }

    public void Y0() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_between_interface_bottom_out);
    }

    public void Z0(boolean z) {
        if (this.x == null) {
            this.q = (Toolbar) findViewById(R.id.toolbar);
            this.x = (TextView) findViewById(R.id.toolbar_title);
        }
        Toolbar toolbar = this.q;
        if (toolbar != null) {
            toolbar.getChildAt(0).setEnabled(z);
        }
    }

    public void a1(int i) {
        if (this.x == null) {
            this.q = (Toolbar) findViewById(R.id.toolbar);
            this.x = (TextView) findViewById(R.id.toolbar_title);
        }
        Toolbar toolbar = this.q;
        if (toolbar != null) {
            toolbar.setNavigationIcon(i);
        }
    }

    public void b1(int i) {
        if (this.x == null) {
            this.q = (Toolbar) findViewById(R.id.toolbar);
            this.x = (TextView) findViewById(R.id.toolbar_title);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void c1(CharSequence charSequence) {
        if (this.x == null) {
            this.q = (Toolbar) findViewById(R.id.toolbar);
            this.x = (TextView) findViewById(R.id.toolbar_title);
            this.q.setTitle("");
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void d1(int i, Fragment fragment, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments.size() != 0) {
            beginTransaction.setCustomAnimations(R.anim.push_in_from_right, R.anim.push_out_to_left, R.anim.push_in_from_left, R.anim.push_out_to_right);
            Fragment fragment2 = fragments.get(fragments.size() - 1);
            beginTransaction.hide(fragment2).addToBackStack(fragment2.getTag());
        }
        if (fragment.isAdded()) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.add(i, fragment, str);
        }
        beginTransaction.commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f6071d || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6072f >= 2000) {
            s0.p(this, getString(R.string.exit_app_promot));
            this.f6072f = currentTimeMillis;
            return true;
        }
        AppContext.f6185c.b();
        return true;
    }

    @Override // com.tplink.iot.base.b.a
    public void handleMessage(Message message) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!a.C0212a.b(this)) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b.d.w.c.a.d("Activity Action:" + getClass().getSimpleName() + " Created!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        b bVar = new b(this);
        this.f6070c = bVar;
        bVar.post(new a());
        T0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.d.w.c.a.d("Activity Action:" + getClass().getSimpleName() + " destroyed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (int size = fragments.size() - 1; size >= 0; size--) {
                Fragment fragment = fragments.get(size);
                if (fragment != null && (fragment instanceof BaseFragment) && ((BaseFragment) fragment).G0(intent)) {
                    break;
                }
            }
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
