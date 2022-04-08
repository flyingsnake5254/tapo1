package com.tplink.iot.view.quicksetup.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySubGOnBoardingBinding;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupAvatarFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupGuideFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupLocationCustomFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupLocationSelectFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupNameFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class SubGOnBoardingActivity extends BaseActivity implements z1 {
    private ActivitySubGOnBoardingBinding p0;
    private SubGViewModel p1;
    private String p2;
    private String p3;
    private Stack<f> y;
    private boolean z = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1 */
    public /* synthetic */ void B1() {
        L1();
        d.H(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1 */
    public /* synthetic */ void D1(a aVar) {
        Integer num = (Integer) aVar.a();
        if (num != null) {
            if (num.intValue() == 20001) {
                G1();
            } else if (num.intValue() == 20002) {
                onBackPressed();
            }
        }
    }

    public static void E1(Context context, String str, String str2) {
        Intent intent = new Intent(context, SubGOnBoardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device", str2);
        bundle.putString("device_id_md5", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void F1(Context context, String str) {
        Intent intent = new Intent(context, SubGOnBoardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void G1() {
        new UniversalDialog.a().q(getString(R.string.onboarding_new_ipc_almost_done_hint)).u(getString(R.string.action_exit)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.quicksetup.sub.k
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                SubGOnBoardingActivity.this.B1();
            }
        }).l().show(getSupportFragmentManager(), "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void J1(String str, Bundle bundle, int i) {
        int i2;
        Fragment subGHubListFragment = new SubGHubListFragment();
        this.p3 = str;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1873082429:
                if (str.equals("SubGSetupLocationSelectFragment.TAG")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1573373106:
                if (str.equals("SubGHubFirmwareUpdateFragment.TAG")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1559829225:
                if (str.equals("SubGGuideFirstFragment.TAG")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1476370149:
                if (str.equals("SubGHubEmptyFragment.TAG")) {
                    c2 = 3;
                    break;
                }
                break;
            case -944814904:
                if (str.equals("SwitchQuickSetupGuideFragment")) {
                    c2 = 4;
                    break;
                }
                break;
            case -779921736:
                if (str.equals("SubGSetupLocationCustomFragment.TAG")) {
                    c2 = 5;
                    break;
                }
                break;
            case -757728017:
                if (str.equals("SubGCheckStatusFragment.TAG")) {
                    c2 = 6;
                    break;
                }
                break;
            case -445782907:
                if (str.equals("SubGSearchingDeviceFragment.TAG")) {
                    c2 = 7;
                    break;
                }
                break;
            case -295045252:
                if (str.equals("SubGCompleteFragment.TAG")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 20574216:
                if (str.equals("SubGHubListFragment.TAG")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 233599464:
                if (str.equals("SubGRemoveCoverFragment.TAG")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 276144573:
                if (str.equals("SubGSetupNameFragment.TAG")) {
                    c2 = 11;
                    break;
                }
                break;
            case 552443414:
                if (str.equals("SubGNoFoundFragment.TAG")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 675597835:
                if (str.equals("SubGSetupAvatarFragment.TAG")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 720177901:
                if (str.equals("SwitchQuickSetupAvatarFragment")) {
                    c2 = 14;
                    break;
                }
                break;
            case 907219621:
                if (str.equals("SwitchQuickSetupLocationSelectFragment")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1429939226:
                if (str.equals("SwitchQuickSetupLocationCustomFragment")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1442261791:
                if (str.equals("SwitchQuickSetupNameFragment")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2116895336:
                if (str.equals("SubGSaveSettingFragment.TAG")) {
                    c2 = 18;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                subGHubListFragment = t1();
                i2 = i;
                break;
            case 1:
                subGHubListFragment = l1();
                i2 = i;
                break;
            case 2:
                subGHubListFragment = j1();
                i2 = i;
                break;
            case 3:
                subGHubListFragment = k1();
                i2 = 2;
                break;
            case 4:
                subGHubListFragment = w1();
                i2 = i;
                break;
            case 5:
                subGHubListFragment = s1();
                i2 = i;
                break;
            case 6:
                subGHubListFragment = h1();
                i2 = i;
                break;
            case 7:
                subGHubListFragment = q1();
                i2 = i;
                break;
            case '\b':
                subGHubListFragment = i1();
                i2 = i;
                break;
            case '\t':
                subGHubListFragment = m1();
                i2 = i;
                break;
            case '\n':
                subGHubListFragment = o1();
                i2 = i;
                break;
            case 11:
                subGHubListFragment = u1();
                i2 = i;
                break;
            case '\f':
                subGHubListFragment = n1();
                i2 = i;
                break;
            case '\r':
                subGHubListFragment = r1();
                i2 = i;
                break;
            case 14:
                subGHubListFragment = v1();
                i2 = i;
                break;
            case 15:
                subGHubListFragment = y1();
                i2 = i;
                break;
            case 16:
                subGHubListFragment = x1();
                i2 = i;
                break;
            case 17:
                subGHubListFragment = z1();
                i2 = i;
                break;
            case 18:
                subGHubListFragment = p1();
                i2 = i;
                break;
            default:
                i2 = i;
                break;
        }
        this.z = true;
        H1(subGHubListFragment, str, bundle, i2, R.id.content);
    }

    private boolean K1(String str) {
        return "SwitchQuickSetupGuideFragment".equalsIgnoreCase(str) || "SwitchQuickSetupNameFragment".equalsIgnoreCase(str) || "SwitchQuickSetupAvatarFragment".equalsIgnoreCase(str);
    }

    private void L1() {
        this.p1.u0();
    }

    private void M1() {
        this.p1.A().observe(this, new Observer() { // from class: com.tplink.iot.view.quicksetup.sub.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubGOnBoardingActivity.this.D1((a) obj);
            }
        });
    }

    private void e1() {
        if (this.y.size() <= 1) {
            finish();
            return;
        }
        this.y.pop();
        f peek = this.y.peek();
        J1(peek.b(), peek.a(), 4);
    }

    private void f1() {
        if (!TextUtils.isEmpty(this.p2)) {
            this.p1.A0(this.p2);
            e0("SubGRemoveCoverFragment.TAG", null);
            return;
        }
        e0("SubGHubListFragment.TAG", null);
    }

    private void g1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p1.z0(extras.getString("device", "T100"));
            this.p2 = extras.getString("device_id_md5");
        }
    }

    private SubGEnablePairingModeFragment h1() {
        I1(false);
        SubGEnablePairingModeFragment subGEnablePairingModeFragment = (SubGEnablePairingModeFragment) getSupportFragmentManager().findFragmentByTag("SubGCheckStatusFragment.TAG");
        return subGEnablePairingModeFragment == null ? new SubGEnablePairingModeFragment() : subGEnablePairingModeFragment;
    }

    private SubGCompleteFragment i1() {
        I1(false);
        SubGCompleteFragment subGCompleteFragment = (SubGCompleteFragment) getSupportFragmentManager().findFragmentByTag("SubGCompleteFragment.TAG");
        return subGCompleteFragment == null ? new SubGCompleteFragment() : subGCompleteFragment;
    }

    private SubGPowerUpDeviceFragment j1() {
        I1(false);
        SubGPowerUpDeviceFragment subGPowerUpDeviceFragment = (SubGPowerUpDeviceFragment) getSupportFragmentManager().findFragmentByTag("SubGGuideFirstFragment.TAG");
        return subGPowerUpDeviceFragment == null ? new SubGPowerUpDeviceFragment() : subGPowerUpDeviceFragment;
    }

    private SubGHubEmptyFragment k1() {
        I1(false);
        SubGHubEmptyFragment subGHubEmptyFragment = (SubGHubEmptyFragment) getSupportFragmentManager().findFragmentByTag("SubGHubEmptyFragment.TAG");
        return subGHubEmptyFragment == null ? new SubGHubEmptyFragment() : subGHubEmptyFragment;
    }

    private SubGHubFirmwareUpdateFragment l1() {
        I1(false);
        SubGHubFirmwareUpdateFragment subGHubFirmwareUpdateFragment = (SubGHubFirmwareUpdateFragment) getSupportFragmentManager().findFragmentByTag("SubGHubFirmwareUpdateFragment.TAG");
        return subGHubFirmwareUpdateFragment == null ? new SubGHubFirmwareUpdateFragment() : subGHubFirmwareUpdateFragment;
    }

    private SubGHubListFragment m1() {
        I1(false);
        SubGHubListFragment subGHubListFragment = (SubGHubListFragment) getSupportFragmentManager().findFragmentByTag("SubGHubListFragment.TAG");
        return subGHubListFragment == null ? new SubGHubListFragment() : subGHubListFragment;
    }

    private SubGNoFoundFragment n1() {
        I1(false);
        SubGNoFoundFragment subGNoFoundFragment = (SubGNoFoundFragment) getSupportFragmentManager().findFragmentByTag("SubGNoFoundFragment.TAG");
        return subGNoFoundFragment == null ? new SubGNoFoundFragment() : subGNoFoundFragment;
    }

    private SubGRemoveCoverFragment o1() {
        I1(false);
        SubGRemoveCoverFragment subGRemoveCoverFragment = (SubGRemoveCoverFragment) getSupportFragmentManager().findFragmentByTag("SubGRemoveCoverFragment.TAG");
        return subGRemoveCoverFragment == null ? new SubGRemoveCoverFragment() : subGRemoveCoverFragment;
    }

    private SubGSaveSettingFragment p1() {
        I1(true);
        SubGSaveSettingFragment subGSaveSettingFragment = (SubGSaveSettingFragment) getSupportFragmentManager().findFragmentByTag("SubGSaveSettingFragment.TAG");
        return subGSaveSettingFragment == null ? new SubGSaveSettingFragment() : subGSaveSettingFragment;
    }

    private SubGSearchingDeviceFragment q1() {
        I1(true);
        SubGSearchingDeviceFragment subGSearchingDeviceFragment = (SubGSearchingDeviceFragment) getSupportFragmentManager().findFragmentByTag("SubGSearchingDeviceFragment.TAG");
        return subGSearchingDeviceFragment == null ? new SubGSearchingDeviceFragment() : subGSearchingDeviceFragment;
    }

    private SubGSetupAvatarFragment r1() {
        I1(false);
        SubGSetupAvatarFragment subGSetupAvatarFragment = (SubGSetupAvatarFragment) getSupportFragmentManager().findFragmentByTag("SubGSetupAvatarFragment.TAG");
        return subGSetupAvatarFragment == null ? new SubGSetupAvatarFragment() : subGSetupAvatarFragment;
    }

    private SubGSetupLocationCustomFragment s1() {
        I1(false);
        SubGSetupLocationCustomFragment subGSetupLocationCustomFragment = (SubGSetupLocationCustomFragment) getSupportFragmentManager().findFragmentByTag("SubGSetupLocationCustomFragment.TAG");
        return subGSetupLocationCustomFragment == null ? new SubGSetupLocationCustomFragment() : subGSetupLocationCustomFragment;
    }

    private SubGSetupLocationSelectFragment t1() {
        I1(false);
        SubGSetupLocationSelectFragment subGSetupLocationSelectFragment = (SubGSetupLocationSelectFragment) getSupportFragmentManager().findFragmentByTag("SubGSetupLocationSelectFragment.TAG");
        return subGSetupLocationSelectFragment == null ? new SubGSetupLocationSelectFragment() : subGSetupLocationSelectFragment;
    }

    private SubGSetupNameFragment u1() {
        I1(false);
        SubGSetupNameFragment subGSetupNameFragment = (SubGSetupNameFragment) getSupportFragmentManager().findFragmentByTag("SubGSetupNameFragment.TAG");
        return subGSetupNameFragment == null ? new SubGSetupNameFragment() : subGSetupNameFragment;
    }

    private SwitchQuickSetupAvatarFragment v1() {
        I1(false);
        SwitchQuickSetupAvatarFragment switchQuickSetupAvatarFragment = (SwitchQuickSetupAvatarFragment) getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupAvatarFragment");
        return switchQuickSetupAvatarFragment == null ? new SwitchQuickSetupAvatarFragment() : switchQuickSetupAvatarFragment;
    }

    private SwitchQuickSetupGuideFragment w1() {
        I1(false);
        SwitchQuickSetupGuideFragment switchQuickSetupGuideFragment = (SwitchQuickSetupGuideFragment) getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupGuideFragment");
        return switchQuickSetupGuideFragment == null ? new SwitchQuickSetupGuideFragment() : switchQuickSetupGuideFragment;
    }

    private SwitchQuickSetupLocationCustomFragment x1() {
        I1(false);
        SwitchQuickSetupLocationCustomFragment switchQuickSetupLocationCustomFragment = (SwitchQuickSetupLocationCustomFragment) getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupLocationCustomFragment");
        return switchQuickSetupLocationCustomFragment == null ? new SwitchQuickSetupLocationCustomFragment() : switchQuickSetupLocationCustomFragment;
    }

    private SwitchQuickSetupLocationSelectFragment y1() {
        I1(false);
        SwitchQuickSetupLocationSelectFragment switchQuickSetupLocationSelectFragment = (SwitchQuickSetupLocationSelectFragment) getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupLocationSelectFragment");
        return switchQuickSetupLocationSelectFragment == null ? new SwitchQuickSetupLocationSelectFragment() : switchQuickSetupLocationSelectFragment;
    }

    private SwitchQuickSetupNameFragment z1() {
        I1(false);
        SwitchQuickSetupNameFragment switchQuickSetupNameFragment = (SwitchQuickSetupNameFragment) getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupNameFragment");
        return switchQuickSetupNameFragment == null ? new SwitchQuickSetupNameFragment() : switchQuickSetupNameFragment;
    }

    protected void H1(Fragment fragment, String str, Bundle bundle, int i, int i2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (bundle != null && bundle.size() > 0) {
            if (fragment.isAdded() || fragment.isVisible() || fragment.getArguments() != null) {
                for (String str2 : bundle.keySet()) {
                    if (bundle.get(str2) instanceof String) {
                        fragment.getArguments().putString(str2, bundle.getString(str2));
                    } else if (bundle.get(str2) instanceof Boolean) {
                        fragment.getArguments().putBoolean(str2, bundle.getBoolean(str2));
                    } else if (bundle.get(str2) instanceof Long) {
                        fragment.getArguments().putLong(str2, bundle.getLong(str2));
                    } else if (bundle.get(str2) instanceof Serializable) {
                        fragment.getArguments().putSerializable(str2, bundle.getSerializable(str2));
                    } else if (bundle.get(str2) instanceof Parcelable) {
                        fragment.getArguments().putParcelable(str2, bundle.getParcelable(str2));
                    }
                }
            } else {
                fragment.setArguments(bundle);
            }
        }
        int[] a = com.tplink.iot.view.ipcamera.base.d.a(i);
        if (!(a[0] == 0 || a[1] == 0)) {
            beginTransaction.setCustomAnimations(a[0], a[1]);
        }
        beginTransaction.replace(i2, fragment, str).commitAllowingStateLoss();
    }

    public void I1(boolean z) {
        d.b0(this, z ? R.color.common_colorAccent : R.color.white);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void e0(String str, Bundle bundle) {
        f fVar = new f();
        fVar.d(str);
        fVar.c(bundle);
        if (this.y.size() <= 0 || !TextUtils.equals(str, this.y.peek().b())) {
            boolean z = false;
            Iterator<f> it = this.y.iterator();
            while (true) {
                if (it.hasNext() && !K1(str)) {
                    if (it.next().b().equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                while (!this.y.pop().b().equalsIgnoreCase(str) && this.y.size() > 0) {
                }
            }
            this.y.push(fVar);
            if (z) {
                J1(str, bundle, 4);
            } else {
                J1(str, bundle, 3);
            }
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.z) {
            e1();
        } else if ("SubGHubEmptyFragment.TAG".equals(this.p3)) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p0 = (ActivitySubGOnBoardingBinding) DataBindingUtil.setContentView(this, R.layout.activity_sub_g_on_boarding);
        SubGViewModel subGViewModel = (SubGViewModel) ViewModelProviders.of(this).get(SubGViewModel.class);
        this.p1 = subGViewModel;
        this.p0.h(subGViewModel);
        this.y = new Stack<>();
        g1();
        M1();
        f1();
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void q0() {
        this.z = false;
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void y0(String str) {
        Stack<f> stack = this.y;
        if (stack == null) {
            this.y = new Stack<>();
        } else if (stack.size() >= 0) {
            f peek = this.y.peek();
            while (!this.y.peek().b().equalsIgnoreCase(str)) {
                this.y.pop();
                if (this.y.size() <= 0) {
                    break;
                }
            }
            if (peek != null) {
                this.y.push(peek);
            }
        }
    }
}
