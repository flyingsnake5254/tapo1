package com.tplink.iot.view.authflip;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import b.d.k.f.a;
import com.tplink.iot.R;
import com.tplink.iot.thirdpartlink.ThirdPartLinkNetworkType;
import com.tplink.iot.view.ipcamera.base.d;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class AppFlipAuthActivity extends AppCompatActivity implements z1 {

    /* renamed from: c  reason: collision with root package name */
    private Stack<f> f8323c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8324d = true;

    /* renamed from: f  reason: collision with root package name */
    private AppFlipAuthViewModel f8325f;
    private String q;

    private void P0() {
        if (this.f8323c.size() <= 1) {
            finish();
            return;
        }
        this.f8323c.pop();
        f peek = this.f8323c.peek();
        W0(peek.b(), peek.a(), 4);
    }

    private AuthFragment Q0() {
        AuthFragment authFragment = (AuthFragment) getSupportFragmentManager().findFragmentByTag(AuthFragment.class.getSimpleName());
        return authFragment == null ? new AuthFragment() : authFragment;
    }

    private ForgetPasswordFragment R0() {
        ForgetPasswordFragment forgetPasswordFragment = (ForgetPasswordFragment) getSupportFragmentManager().findFragmentByTag(ForgetPasswordFragment.class.getSimpleName());
        return forgetPasswordFragment == null ? new ForgetPasswordFragment() : forgetPasswordFragment;
    }

    private LoginFragment S0() {
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(LoginFragment.class.getSimpleName());
        return loginFragment == null ? new LoginFragment() : loginFragment;
    }

    private WebViewFragment T0() {
        WebViewFragment webViewFragment = (WebViewFragment) getSupportFragmentManager().findFragmentByTag(WebViewFragment.class.getSimpleName());
        return webViewFragment == null ? new WebViewFragment() : webViewFragment;
    }

    private void U0() {
        String m = this.f8325f.m();
        Bundle bundle = new Bundle();
        bundle.putBoolean("bundle_anim_tag", false);
        if (TextUtils.isEmpty(m)) {
            e0("LoginFragment", bundle);
        } else {
            e0("AuthFragment", bundle);
        }
    }

    private void W0(String str, Bundle bundle, int i) {
        Fragment S0 = S0();
        this.q = str;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1980005015:
                if (str.equals("WebViewFragment")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1892528072:
                if (str.equals("AuthFragment")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1779110727:
                if (str.equals("LoginFragment")) {
                    c2 = 2;
                    break;
                }
                break;
            case -605450696:
                if (str.equals("ForgetPasswordFragment")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                S0 = T0();
                break;
            case 1:
                S0 = Q0();
                break;
            case 2:
                S0 = S0();
                break;
            case 3:
                S0 = R0();
                break;
        }
        this.f8324d = true;
        V0(S0, str, bundle, i, R.id.fragment_container);
    }

    protected void V0(Fragment fragment, String str, Bundle bundle, int i, int i2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (bundle != null && bundle.size() > 0) {
            if (fragment.isAdded() || fragment.isVisible() || fragment.getArguments() != null) {
                Bundle arguments = fragment.getArguments();
                if (arguments != null) {
                    for (String str2 : bundle.keySet()) {
                        if (str2 != null) {
                            if (bundle.get(str2) instanceof String) {
                                arguments.putString(str2, bundle.getString(str2));
                            } else if (bundle.get(str2) instanceof Boolean) {
                                arguments.putBoolean(str2, bundle.getBoolean(str2));
                            } else if (bundle.get(str2) instanceof Long) {
                                arguments.putLong(str2, bundle.getLong(str2));
                            } else if (bundle.get(str2) instanceof Serializable) {
                                arguments.putSerializable(str2, bundle.getSerializable(str2));
                            } else if (bundle.get(str2) instanceof Parcelable) {
                                arguments.putParcelable(str2, bundle.getParcelable(str2));
                            }
                        }
                    }
                }
            } else {
                fragment.setArguments(bundle);
            }
        }
        int[] a = d.a(i);
        if (!(a[0] == 0 || a[1] == 0)) {
            beginTransaction.setCustomAnimations(a[0], a[1]);
        }
        beginTransaction.replace(i2, fragment, str).commitAllowingStateLoss();
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void e0(String str, Bundle bundle) {
        boolean z;
        boolean z2;
        f fVar = new f();
        fVar.d(str);
        fVar.c(bundle);
        if (this.f8323c.size() <= 0 || !TextUtils.equals(str, this.f8323c.peek().b())) {
            Iterator<f> it = this.f8323c.iterator();
            while (true) {
                z = true;
                if (it.hasNext()) {
                    if (it.next().b().equalsIgnoreCase(str)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                while (!this.f8323c.pop().b().equalsIgnoreCase(str) && this.f8323c.size() > 0) {
                }
            }
            this.f8323c.push(fVar);
            if (bundle != null) {
                z = bundle.getBoolean("bundle_anim_tag", true);
            }
            if (!z) {
                W0(str, bundle, 2);
            } else if (z2) {
                W0(str, bundle, 4);
            } else {
                W0(str, bundle, 0);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8324d) {
            P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_flip_auth);
        this.f8325f = (AppFlipAuthViewModel) ViewModelProviders.of(this).get(AppFlipAuthViewModel.class);
        this.f8323c = new Stack<>();
        if (a.d(getIntent()).booleanValue()) {
            this.f8325f.z(ThirdPartLinkNetworkType.AMAZON);
        } else if (a.c(getApplicationContext(), getCallingActivity(), getIntent())) {
            this.f8325f.z(ThirdPartLinkNetworkType.GOOGLE);
        } else {
            finish();
            return;
        }
        U0();
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void q0() {
        this.f8324d = false;
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void y0(String str) {
    }
}
