package com.tplink.iot.view.ipcamera.onboardingv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityCameraV2OnboardingBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class CameraOnBoardingV2Activity extends AppCompatActivity implements z1 {

    /* renamed from: c  reason: collision with root package name */
    private Stack<f> f8785c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8786d = true;

    /* renamed from: f  reason: collision with root package name */
    private ActivityCameraV2OnboardingBinding f8787f;
    private CameraOnBoardingViewModel q;
    private String x;

    private CameraWiredConnectingFragment A1() {
        J1(true);
        CameraWiredConnectingFragment cameraWiredConnectingFragment = (CameraWiredConnectingFragment) getSupportFragmentManager().findFragmentByTag("CameraWiredConnectingFragment.TAG");
        return cameraWiredConnectingFragment == null ? new CameraWiredConnectingFragment() : cameraWiredConnectingFragment;
    }

    private CameraWiredSetWirelessFailedFragment B1() {
        J1(false);
        CameraWiredSetWirelessFailedFragment cameraWiredSetWirelessFailedFragment = (CameraWiredSetWirelessFailedFragment) getSupportFragmentManager().findFragmentByTag("CameraWiredSetWirelessFailedFragment.TAG");
        return cameraWiredSetWirelessFailedFragment == null ? new CameraWiredSetWirelessFailedFragment() : cameraWiredSetWirelessFailedFragment;
    }

    private void C1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.q.f2(DeviceModel.fromValue(extras.getString("device", "C200")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1 */
    public /* synthetic */ void E1() {
        e0.a(this);
        com.tplink.iot.Utils.x0.f.k(this.q.B(), this.x);
        d.H(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1 */
    public /* synthetic */ void G1(a aVar) {
        Integer num = (Integer) aVar.a();
        if (num != null) {
            if (num.intValue() == 20001) {
                H1();
            } else if (num.intValue() == 20002) {
                onBackPressed();
            }
        }
    }

    private void K1(String str, Bundle bundle, int i) {
        Fragment T0 = T0();
        this.x = str;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2078871525:
                if (str.equals("CameraWiredConnectApFragment.TAG")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1977640039:
                if (str.equals("CameraSdHintFragment.TAG")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1612627066:
                if (str.equals("CameraRescanWifiFragment.TAG")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1582334756:
                if (str.equals("CameraPairingFailedFragment.TAG")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1516659752:
                if (str.equals("CameraRoomSelectFragment.TAG")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1288075539:
                if (str.equals("CameraIdentifyFragment.TAG")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1248588411:
                if (str.equals("CameraInstructionFragment.TAG")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1112117856:
                if (str.equals("CameraAutoUpdateHintFragment.TAG")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1106653554:
                if (str.equals("CameraWiredConnectingFragment.TAG")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1101762370:
                if (str.equals("CameraConfiguredBeforeFragment.TAG")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -1001579015:
                if (str.equals("CameraTapoCareIntroduceFragment.TAG")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -772422689:
                if (str.equals("CameraWiredSetWirelessFailedFragment.TAG")) {
                    c2 = 11;
                    break;
                }
                break;
            case -733694149:
                if (str.equals("CameraConnectTypeFragment.TAG")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -544527954:
                if (str.equals("CameraSetLocationFragment.TAG")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -426291367:
                if (str.equals("CameraConnectingFragment.TAG")) {
                    c2 = 14;
                    break;
                }
                break;
            case -423499059:
                if (str.equals("CameraRoomCustomFragment.TAG")) {
                    c2 = 15;
                    break;
                }
                break;
            case -344620035:
                if (str.equals("CameraCannotFindFragment.TAG")) {
                    c2 = 16;
                    break;
                }
                break;
            case -330190086:
                if (str.equals("CameraSSIDListFragment.TAG")) {
                    c2 = 17;
                    break;
                }
                break;
            case -262092205:
                if (str.equals("CameraBeforeInstallFragment.TAG")) {
                    c2 = 18;
                    break;
                }
                break;
            case -255809040:
                if (str.equals("CameraConnectApFragment.TAG")) {
                    c2 = 19;
                    break;
                }
                break;
            case 82444273:
                if (str.equals("CameraTroubleShootingFragment.TAG")) {
                    c2 = 20;
                    break;
                }
                break;
            case 88992822:
                if (str.equals("CameraInstallHelpfulItemsFragment.TAG")) {
                    c2 = 21;
                    break;
                }
                break;
            case 190356596:
                if (str.equals("CameraInputPwdFragment.TAG")) {
                    c2 = 22;
                    break;
                }
                break;
            case 316128518:
                if (str.equals("CameraResetFragment.TAG")) {
                    c2 = 23;
                    break;
                }
                break;
            case 488484746:
                if (str.equals("CameraSaveSettingFragment.TAG")) {
                    c2 = 24;
                    break;
                }
                break;
            case 613492404:
                if (str.equals("CameraWifiListFragment.TAG")) {
                    c2 = 25;
                    break;
                }
                break;
            case 629894554:
                if (str.equals("CameraCompleteFragment.TAG")) {
                    c2 = 26;
                    break;
                }
                break;
            case 800795190:
                if (str.equals("CameraConnectToPairFragment.TAG")) {
                    c2 = 27;
                    break;
                }
                break;
            case 814977102:
                if (str.equals("CameraInstallPreviewFragment.TAG")) {
                    c2 = 28;
                    break;
                }
                break;
            case 848180751:
                if (str.equals("CameraWiredCompleteFragment.TAG")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1179968464:
                if (str.equals("CameraNotFoundFragment.TAG")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1546490882:
                if (str.equals("CameraInstallGuideFragment.TAG")) {
                    c2 = 31;
                    break;
                }
                break;
            case 1685992330:
                if (str.equals("CameraConnectRouterFragment.TAG")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 1873820164:
                if (str.equals("CameraSetNameFragment.TAG")) {
                    c2 = '!';
                    break;
                }
                break;
            case 1908828689:
                if (str.equals("CameraCheckStatusFragment.TAG")) {
                    c2 = StringUtil.DOUBLE_QUOTE;
                    break;
                }
                break;
            case 1951242650:
                if (str.equals("CameraManualInputPwdFragment.TAG")) {
                    c2 = '#';
                    break;
                }
                break;
            case 1959267626:
                if (str.equals("CameraSearchAfterSetupFragment.TAG")) {
                    c2 = '$';
                    break;
                }
                break;
            case 2034670853:
                if (str.equals("CameraLocationPermissionFragment.TAG")) {
                    c2 = '%';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                T0 = z1();
                break;
            case 1:
                T0 = r1();
                break;
            case 2:
                T0 = l1();
                break;
            case 3:
                T0 = k1();
                break;
            case 4:
                T0 = o1();
                break;
            case 5:
                T0 = b1();
                break;
            case 6:
                T0 = g1();
                break;
            case 7:
                T0 = Q0();
                break;
            case '\b':
                T0 = A1();
                break;
            case '\t':
                T0 = V0();
                break;
            case '\n':
                T0 = v1();
                break;
            case 11:
                T0 = B1();
                break;
            case '\f':
                T0 = Z0();
                break;
            case '\r':
                T0 = t1();
                break;
            case 14:
                T0 = a1();
                break;
            case 15:
                T0 = n1();
                break;
            case 16:
                T0 = S0();
                break;
            case 17:
                T0 = p1();
                break;
            case 18:
                T0 = R0();
                break;
            case 19:
                T0 = W0();
                break;
            case 20:
                T0 = w1();
                break;
            case 21:
                T0 = e1();
                break;
            case 22:
                T0 = c1();
                break;
            case 23:
                T0 = m1();
                break;
            case 24:
                T0 = q1();
                break;
            case 25:
                T0 = x1();
                break;
            case 26:
                T0 = U0();
                break;
            case 27:
                T0 = Y0();
                break;
            case 28:
                T0 = f1();
                break;
            case 29:
                T0 = y1();
                break;
            case 30:
                T0 = j1();
                break;
            case 31:
                T0 = d1();
                break;
            case ' ':
                T0 = X0();
                break;
            case '!':
                T0 = u1();
                break;
            case '\"':
                T0 = T0();
                break;
            case '#':
                T0 = i1();
                break;
            case '$':
                T0 = s1();
                break;
            case '%':
                T0 = h1();
                break;
        }
        this.f8786d = true;
        I1(T0, str, bundle, i, R.id.content);
    }

    private void L1() {
        this.q.R().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.o0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraOnBoardingV2Activity.this.G1((a) obj);
            }
        });
    }

    private void P0() {
        if (this.f8785c.size() <= 1) {
            finish();
            return;
        }
        this.f8785c.pop();
        f peek = this.f8785c.peek();
        K1(peek.b(), peek.a(), 4);
    }

    private CameraAutoUpdateHintFragment Q0() {
        J1(false);
        CameraAutoUpdateHintFragment cameraAutoUpdateHintFragment = (CameraAutoUpdateHintFragment) getSupportFragmentManager().findFragmentByTag("CameraAutoUpdateHintFragment.TAG");
        return cameraAutoUpdateHintFragment == null ? new CameraAutoUpdateHintFragment() : cameraAutoUpdateHintFragment;
    }

    private CameraBeforeInstallFragment R0() {
        J1(false);
        CameraBeforeInstallFragment cameraBeforeInstallFragment = (CameraBeforeInstallFragment) getSupportFragmentManager().findFragmentByTag("CameraBeforeInstallFragment.TAG");
        return cameraBeforeInstallFragment == null ? new CameraBeforeInstallFragment() : cameraBeforeInstallFragment;
    }

    private CameraCannotFindFragment S0() {
        J1(false);
        CameraCannotFindFragment cameraCannotFindFragment = (CameraCannotFindFragment) getSupportFragmentManager().findFragmentByTag("CameraCannotFindFragment.TAG");
        return cameraCannotFindFragment == null ? new CameraCannotFindFragment() : cameraCannotFindFragment;
    }

    private CameraCheckStatusFragment T0() {
        J1(false);
        CameraCheckStatusFragment cameraCheckStatusFragment = (CameraCheckStatusFragment) getSupportFragmentManager().findFragmentByTag("CameraCheckStatusFragment.TAG");
        return cameraCheckStatusFragment == null ? new CameraCheckStatusFragment() : cameraCheckStatusFragment;
    }

    private CameraCompleteFragment U0() {
        J1(false);
        CameraCompleteFragment cameraCompleteFragment = (CameraCompleteFragment) getSupportFragmentManager().findFragmentByTag("CameraCompleteFragment.TAG");
        return cameraCompleteFragment == null ? new CameraCompleteFragment() : cameraCompleteFragment;
    }

    private CameraConfiguredBeforeFragment V0() {
        J1(false);
        CameraConfiguredBeforeFragment cameraConfiguredBeforeFragment = (CameraConfiguredBeforeFragment) getSupportFragmentManager().findFragmentByTag("CameraConfiguredBeforeFragment.TAG");
        return cameraConfiguredBeforeFragment == null ? new CameraConfiguredBeforeFragment() : cameraConfiguredBeforeFragment;
    }

    private CameraConnectApFragment W0() {
        J1(true);
        CameraConnectApFragment cameraConnectApFragment = (CameraConnectApFragment) getSupportFragmentManager().findFragmentByTag("CameraConnectApFragment.TAG");
        return cameraConnectApFragment == null ? new CameraConnectApFragment() : cameraConnectApFragment;
    }

    private CameraConnectRouterFragment X0() {
        J1(false);
        CameraConnectRouterFragment cameraConnectRouterFragment = (CameraConnectRouterFragment) getSupportFragmentManager().findFragmentByTag("CameraConnectRouterFragment.TAG");
        return cameraConnectRouterFragment == null ? new CameraConnectRouterFragment() : cameraConnectRouterFragment;
    }

    private CameraConnectToPairFragment Y0() {
        J1(false);
        CameraConnectToPairFragment cameraConnectToPairFragment = (CameraConnectToPairFragment) getSupportFragmentManager().findFragmentByTag("CameraConnectToPairFragment.TAG");
        return cameraConnectToPairFragment == null ? new CameraConnectToPairFragment() : cameraConnectToPairFragment;
    }

    private CameraConnectTypeFragment Z0() {
        J1(false);
        CameraConnectTypeFragment cameraConnectTypeFragment = (CameraConnectTypeFragment) getSupportFragmentManager().findFragmentByTag("CameraConnectTypeFragment.TAG");
        return cameraConnectTypeFragment == null ? new CameraConnectTypeFragment() : cameraConnectTypeFragment;
    }

    private CameraConnectingFragment a1() {
        J1(true);
        CameraConnectingFragment cameraConnectingFragment = (CameraConnectingFragment) getSupportFragmentManager().findFragmentByTag("CameraConnectingFragment.TAG");
        return cameraConnectingFragment == null ? new CameraConnectingFragment() : cameraConnectingFragment;
    }

    private CameraIdentifyFragment b1() {
        J1(false);
        CameraIdentifyFragment cameraIdentifyFragment = (CameraIdentifyFragment) getSupportFragmentManager().findFragmentByTag("CameraIdentifyFragment.TAG");
        return cameraIdentifyFragment == null ? new CameraIdentifyFragment() : cameraIdentifyFragment;
    }

    private CameraInputPwdFragment c1() {
        J1(false);
        CameraInputPwdFragment cameraInputPwdFragment = (CameraInputPwdFragment) getSupportFragmentManager().findFragmentByTag("CameraInputPwdFragment.TAG");
        return cameraInputPwdFragment == null ? new CameraInputPwdFragment() : cameraInputPwdFragment;
    }

    private CameraInstallGuideFragment d1() {
        J1(false);
        CameraInstallGuideFragment cameraInstallGuideFragment = (CameraInstallGuideFragment) getSupportFragmentManager().findFragmentByTag("CameraInstallGuideFragment.TAG");
        return cameraInstallGuideFragment == null ? new CameraInstallGuideFragment() : cameraInstallGuideFragment;
    }

    private CameraInstallHelpfulItemsFragment e1() {
        J1(false);
        CameraInstallHelpfulItemsFragment cameraInstallHelpfulItemsFragment = (CameraInstallHelpfulItemsFragment) getSupportFragmentManager().findFragmentByTag("CameraInstallHelpfulItemsFragment.TAG");
        return cameraInstallHelpfulItemsFragment == null ? new CameraInstallHelpfulItemsFragment() : cameraInstallHelpfulItemsFragment;
    }

    private CameraInstallPreviewFragment f1() {
        J1(false);
        CameraInstallPreviewFragment cameraInstallPreviewFragment = (CameraInstallPreviewFragment) getSupportFragmentManager().findFragmentByTag("CameraInstallPreviewFragment.TAG");
        return cameraInstallPreviewFragment == null ? new CameraInstallPreviewFragment() : cameraInstallPreviewFragment;
    }

    private CameraInstructionFragment g1() {
        J1(false);
        CameraInstructionFragment cameraInstructionFragment = (CameraInstructionFragment) getSupportFragmentManager().findFragmentByTag("CameraInstructionFragment.TAG");
        return cameraInstructionFragment == null ? new CameraInstructionFragment() : cameraInstructionFragment;
    }

    private CameraLocationPermissionFragment h1() {
        J1(false);
        CameraLocationPermissionFragment cameraLocationPermissionFragment = (CameraLocationPermissionFragment) getSupportFragmentManager().findFragmentByTag("CameraLocationPermissionFragment.TAG");
        return cameraLocationPermissionFragment == null ? new CameraLocationPermissionFragment() : cameraLocationPermissionFragment;
    }

    private CameraManualInputPwdFragment i1() {
        J1(false);
        CameraManualInputPwdFragment cameraManualInputPwdFragment = (CameraManualInputPwdFragment) getSupportFragmentManager().findFragmentByTag("CameraManualInputPwdFragment.TAG");
        return cameraManualInputPwdFragment == null ? new CameraManualInputPwdFragment() : cameraManualInputPwdFragment;
    }

    private CameraNotFoundFragment j1() {
        J1(false);
        CameraNotFoundFragment cameraNotFoundFragment = (CameraNotFoundFragment) getSupportFragmentManager().findFragmentByTag("CameraNotFoundFragment.TAG");
        return cameraNotFoundFragment == null ? new CameraNotFoundFragment() : cameraNotFoundFragment;
    }

    private CameraPairingFailedFragment k1() {
        J1(false);
        CameraPairingFailedFragment cameraPairingFailedFragment = (CameraPairingFailedFragment) getSupportFragmentManager().findFragmentByTag("CameraPairingFailedFragment.TAG");
        return cameraPairingFailedFragment == null ? new CameraPairingFailedFragment() : cameraPairingFailedFragment;
    }

    private CameraRescanWifiFragment l1() {
        J1(true);
        CameraRescanWifiFragment cameraRescanWifiFragment = (CameraRescanWifiFragment) getSupportFragmentManager().findFragmentByTag("CameraRescanWifiFragment.TAG");
        return cameraRescanWifiFragment == null ? new CameraRescanWifiFragment() : cameraRescanWifiFragment;
    }

    private CameraResetFragment m1() {
        CameraResetFragment cameraResetFragment = (CameraResetFragment) getSupportFragmentManager().findFragmentByTag("CameraResetFragment.TAG");
        return cameraResetFragment == null ? new CameraResetFragment() : cameraResetFragment;
    }

    private CameraRoomCustomFragment n1() {
        J1(false);
        CameraRoomCustomFragment cameraRoomCustomFragment = (CameraRoomCustomFragment) getSupportFragmentManager().findFragmentByTag("CameraRoomCustomFragment.TAG");
        return cameraRoomCustomFragment == null ? new CameraRoomCustomFragment() : cameraRoomCustomFragment;
    }

    private CameraRoomSelectFragment o1() {
        J1(false);
        CameraRoomSelectFragment cameraRoomSelectFragment = (CameraRoomSelectFragment) getSupportFragmentManager().findFragmentByTag("CameraRoomSelectFragment.TAG");
        return cameraRoomSelectFragment == null ? new CameraRoomSelectFragment() : cameraRoomSelectFragment;
    }

    private CameraSSIDListFragment p1() {
        J1(false);
        CameraSSIDListFragment cameraSSIDListFragment = (CameraSSIDListFragment) getSupportFragmentManager().findFragmentByTag("CameraSSIDListFragment.TAG");
        return cameraSSIDListFragment == null ? new CameraSSIDListFragment() : cameraSSIDListFragment;
    }

    private CameraSaveSettingFragment q1() {
        J1(true);
        CameraSaveSettingFragment cameraSaveSettingFragment = (CameraSaveSettingFragment) getSupportFragmentManager().findFragmentByTag("CameraSaveSettingFragment.TAG");
        return cameraSaveSettingFragment == null ? new CameraSaveSettingFragment() : cameraSaveSettingFragment;
    }

    private CameraSdHintFragment r1() {
        J1(false);
        CameraSdHintFragment cameraSdHintFragment = (CameraSdHintFragment) getSupportFragmentManager().findFragmentByTag("CameraSdHintFragment.TAG");
        return cameraSdHintFragment == null ? new CameraSdHintFragment() : cameraSdHintFragment;
    }

    private CameraSearchAfterSetupFragment s1() {
        J1(true);
        CameraSearchAfterSetupFragment cameraSearchAfterSetupFragment = (CameraSearchAfterSetupFragment) getSupportFragmentManager().findFragmentByTag("CameraSearchAfterSetupFragment.TAG");
        return cameraSearchAfterSetupFragment == null ? new CameraSearchAfterSetupFragment() : cameraSearchAfterSetupFragment;
    }

    private CameraSetLocationFragment t1() {
        J1(false);
        CameraSetLocationFragment cameraSetLocationFragment = (CameraSetLocationFragment) getSupportFragmentManager().findFragmentByTag("CameraSetLocationFragment.TAG");
        return cameraSetLocationFragment == null ? new CameraSetLocationFragment() : cameraSetLocationFragment;
    }

    private CameraSetNameFragment u1() {
        J1(false);
        CameraSetNameFragment cameraSetNameFragment = (CameraSetNameFragment) getSupportFragmentManager().findFragmentByTag("CameraSetNameFragment.TAG");
        return cameraSetNameFragment == null ? new CameraSetNameFragment() : cameraSetNameFragment;
    }

    private CameraTapoCareIntroduceFragment v1() {
        J1(false);
        CameraTapoCareIntroduceFragment cameraTapoCareIntroduceFragment = (CameraTapoCareIntroduceFragment) getSupportFragmentManager().findFragmentByTag("CameraTapoCareIntroduceFragment.TAG");
        return cameraTapoCareIntroduceFragment == null ? new CameraTapoCareIntroduceFragment() : cameraTapoCareIntroduceFragment;
    }

    private CameraTroubleShootingFragment w1() {
        J1(false);
        CameraTroubleShootingFragment cameraTroubleShootingFragment = (CameraTroubleShootingFragment) getSupportFragmentManager().findFragmentByTag("CameraTroubleShootingFragment.TAG");
        return cameraTroubleShootingFragment == null ? new CameraTroubleShootingFragment() : cameraTroubleShootingFragment;
    }

    private CameraWifiListFragment x1() {
        J1(false);
        CameraWifiListFragment cameraWifiListFragment = (CameraWifiListFragment) getSupportFragmentManager().findFragmentByTag("CameraWifiListFragment.TAG");
        return cameraWifiListFragment == null ? new CameraWifiListFragment() : cameraWifiListFragment;
    }

    private CameraWiredCompleteFragment y1() {
        J1(false);
        CameraWiredCompleteFragment cameraWiredCompleteFragment = (CameraWiredCompleteFragment) getSupportFragmentManager().findFragmentByTag("CameraWiredCompleteFragment.TAG");
        return cameraWiredCompleteFragment == null ? new CameraWiredCompleteFragment() : cameraWiredCompleteFragment;
    }

    private CameraWiredConnectApFragment z1() {
        J1(true);
        CameraWiredConnectApFragment cameraWiredConnectApFragment = (CameraWiredConnectApFragment) getSupportFragmentManager().findFragmentByTag("CameraWiredConnectApFragment.TAG");
        return cameraWiredConnectApFragment == null ? new CameraWiredConnectApFragment() : cameraWiredConnectApFragment;
    }

    public void H1() {
        new UniversalDialog.a().q(getString(R.string.onboarding_new_ipc_almost_done_hint)).u(getString(R.string.action_exit)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.p0
            @Override // com.tplink.iot.widget.UniversalDialog.c
            public final void a() {
                CameraOnBoardingV2Activity.this.E1();
            }
        }).l().show(getSupportFragmentManager(), "");
    }

    protected void I1(Fragment fragment, String str, Bundle bundle, int i, int i2) {
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

    public void J1(boolean z) {
        d.b0(this, z ? R.color.common_colorAccent : R.color.white);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void e0(String str, Bundle bundle) {
        f fVar = new f();
        fVar.d(str);
        fVar.c(bundle);
        if (this.f8785c.size() <= 0 || !TextUtils.equals(str, this.f8785c.peek().b())) {
            boolean z = false;
            Iterator<f> it = this.f8785c.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                while (!this.f8785c.pop().b().equalsIgnoreCase(str) && this.f8785c.size() > 0) {
                }
            }
            this.f8785c.push(fVar);
            if (z) {
                K1(str, bundle, 4);
            } else {
                K1(str, bundle, 3);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8786d) {
            P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f8787f = (ActivityCameraV2OnboardingBinding) DataBindingUtil.setContentView(this, R.layout.activity_camera_v2_onboarding);
        CameraOnBoardingViewModel cameraOnBoardingViewModel = (CameraOnBoardingViewModel) ViewModelProviders.of(this).get(CameraOnBoardingViewModel.class);
        this.q = cameraOnBoardingViewModel;
        this.f8787f.h(cameraOnBoardingViewModel);
        this.f8785c = new Stack<>();
        C1();
        L1();
        if (c.w(this.q.D())) {
            e0("CameraConnectTypeFragment.TAG", null);
        } else {
            e0("CameraCheckStatusFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e0.a(AppContext.f6185c);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void q0() {
        this.f8786d = false;
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.z1
    public void y0(String str) {
        Stack<f> stack = this.f8785c;
        if (stack == null) {
            this.f8785c = new Stack<>();
        } else if (stack.size() >= 0) {
            f peek = this.f8785c.peek();
            while (!this.f8785c.peek().b().equalsIgnoreCase(str)) {
                this.f8785c.pop();
                if (this.f8785c.size() <= 0) {
                    break;
                }
            }
            if (peek != null) {
                this.f8785c.push(peek);
            }
        }
    }
}
