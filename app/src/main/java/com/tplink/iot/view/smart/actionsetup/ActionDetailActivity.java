package com.tplink.iot.view.smart.actionsetup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.LocationPrepareActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.actionsetup.ActionSetupFragment;
import com.tplink.iot.view.smart.actionsetup.ConditionAddFragment;
import com.tplink.iot.view.smart.actionsetup.ConditionDeviceChooseFragment;
import com.tplink.iot.view.smart.actionsetup.ConditionTriggerTimerFragment;
import com.tplink.iot.view.smart.actionsetup.TaskAddFragment;
import com.tplink.iot.view.smart.actionsetup.TaskAutomationEnableFragment;
import com.tplink.iot.view.smart.actionsetup.TaskAutomationFragment;
import com.tplink.iot.view.smart.actionsetup.TaskDeviceChooseFragment;
import com.tplink.iot.view.smart.actionsetup.TaskDeviceControlFragment;
import com.tplink.iot.view.smart.actionsetup.TaskShortcutFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.i;

/* loaded from: classes2.dex */
public class ActionDetailActivity extends BaseActivity {
    private TaskDeviceChooseFragment H3;
    private ConditionTriggerTimerFragment I3;
    private ConditionDeviceChooseFragment J3;
    private ActionSetupViewModel K3;
    private int L3 = -1;
    private int M3 = 1;
    private boolean N3 = false;
    private TaskAddFragment p0;
    private TaskShortcutFragment p1;
    private TaskAutomationFragment p2;
    private TaskAutomationEnableFragment p3;
    private ActionIconChooseFragment y;
    private ConditionAddFragment z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ActionSetupFragment.a {
        a() {
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void a() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.x1());
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void b(boolean z) {
            if (z) {
                ActionDetailActivity.this.I1();
            } else {
                ActionDetailActivity.this.finish();
            }
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void c() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.y);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void d() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.w1());
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void e() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.z);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void f() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.p3);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void g() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.p0);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void h() {
            if (ActionDetailActivity.this.N3) {
                ActionDetailActivity.this.setResult(-1);
            }
            ActionDetailActivity.this.finish();
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ActionSetupFragment.a
        public void i() {
            ActionDetailActivity.this.J1(new EffectiveTimeFragment());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ConditionAddFragment.f {

        /* loaded from: classes2.dex */
        class a implements ConditionTriggerTimerFragment.b {
            a() {
            }

            @Override // com.tplink.iot.view.smart.actionsetup.ConditionTriggerTimerFragment.b
            public void a() {
                ActionDetailActivity.this.U0();
            }

            @Override // com.tplink.iot.view.smart.actionsetup.ConditionTriggerTimerFragment.b
            public void b() {
                ActionDetailActivity.this.u1();
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.w1());
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ConditionAddFragment.f
        public void a() {
            ActionDetailActivity.this.U0();
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ConditionAddFragment.f
        public void b() {
            ActionDetailActivity.this.I3 = new ConditionTriggerTimerFragment();
            ActionDetailActivity.this.I3.S0(new a());
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.I3);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.ConditionAddFragment.f
        public void c() {
            ActionDetailActivity.this.J3 = new ConditionDeviceChooseFragment();
            ActionDetailActivity.this.J3.S0(new ConditionDeviceChooseFragment.a() { // from class: com.tplink.iot.view.smart.actionsetup.b
                @Override // com.tplink.iot.view.smart.actionsetup.ConditionDeviceChooseFragment.a
                public final void a() {
                    ActionDetailActivity.b.this.e();
                }
            });
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.J3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TaskAddFragment.f {
        c() {
        }

        @Override // com.tplink.iot.view.smart.actionsetup.TaskAddFragment.f
        public void a() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.p1);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.TaskAddFragment.f
        public void b() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.p2);
        }

        @Override // com.tplink.iot.view.smart.actionsetup.TaskAddFragment.f
        public void c() {
            ActionDetailActivity actionDetailActivity = ActionDetailActivity.this;
            actionDetailActivity.J1(actionDetailActivity.H3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public /* synthetic */ void C1() {
        J1(x1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1 */
    public /* synthetic */ void E1(View view) {
        finish();
    }

    public static void F1(Context context, int i, int i2) {
        Intent intent = new Intent(context, ActionDetailActivity.class);
        intent.putExtra("action_item_index", i);
        intent.putExtra("action_detail_type", i2);
        context.startActivity(intent);
    }

    public static Intent G1(Context context, SmartInfo smartInfo) {
        Intent intent = new Intent(context, ActionDetailActivity.class);
        intent.putExtra("action_smart_info", i.f(smartInfo));
        intent.putExtra("action_from_featured_action", true);
        return intent;
    }

    private void H1(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            bundle.remove("android:fragments");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.smart_action_quit_edit)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_leave, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.smart.actionsetup.e
            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public final void onClick(View view) {
                ActionDetailActivity.this.E1(view);
            }
        }).g(8, 8).setCancelable(false).c(false).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(Fragment fragment) {
        d1(R.id.container, fragment, fragment.getTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceTriggerContainerFragment w1() {
        DeviceTriggerContainerFragment deviceTriggerContainerFragment = new DeviceTriggerContainerFragment();
        deviceTriggerContainerFragment.b1(new DeviceTriggerContainerFragment.a() { // from class: com.tplink.iot.view.smart.actionsetup.k0
            @Override // com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment.a
            public final void a() {
                ActionDetailActivity.this.U0();
            }
        });
        return deviceTriggerContainerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Fragment x1() {
        BaseALIoTDevice t = this.K3.t();
        if (t == null || t.isBulb() || t.isPlug() || t.isSwitch()) {
            TaskDeviceControlFragment taskDeviceControlFragment = new TaskDeviceControlFragment();
            taskDeviceControlFragment.q1(new TaskDeviceControlFragment.e() { // from class: com.tplink.iot.view.smart.actionsetup.j0
                @Override // com.tplink.iot.view.smart.actionsetup.TaskDeviceControlFragment.e
                public final void a() {
                    ActionDetailActivity.this.U0();
                }
            });
            return taskDeviceControlFragment;
        }
        DeviceControlContainerFragment deviceControlContainerFragment = new DeviceControlContainerFragment();
        deviceControlContainerFragment.P0(t.getDeviceIdMD5());
        deviceControlContainerFragment.c1(new DeviceControlContainerFragment.a() { // from class: com.tplink.iot.view.smart.actionsetup.v
            @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment.a
            public final void a() {
                ActionDetailActivity.this.U0();
            }
        });
        return deviceControlContainerFragment;
    }

    private void y1() {
        ActionSetupFragment actionSetupFragment = (ActionSetupFragment) V0(ActionSetupFragment.class, ActionSetupFragment.class.getSimpleName());
        this.y = (ActionIconChooseFragment) V0(ActionIconChooseFragment.class, ActionIconChooseFragment.class.getSimpleName());
        this.z = (ConditionAddFragment) V0(ConditionAddFragment.class, ConditionAddFragment.class.getSimpleName());
        this.p0 = (TaskAddFragment) V0(TaskAddFragment.class, TaskAddFragment.class.getSimpleName());
        this.p1 = (TaskShortcutFragment) V0(TaskShortcutFragment.class, TaskShortcutFragment.class.getSimpleName());
        this.p2 = (TaskAutomationFragment) V0(TaskAutomationFragment.class, TaskAutomationFragment.class.getSimpleName());
        this.p3 = (TaskAutomationEnableFragment) V0(TaskAutomationEnableFragment.class, TaskAutomationEnableFragment.class.getSimpleName());
        this.H3 = (TaskDeviceChooseFragment) V0(TaskDeviceChooseFragment.class, TaskDeviceChooseFragment.class.getSimpleName());
        J1(actionSetupFragment);
        actionSetupFragment.b1(new a());
        this.z.R0(new b());
        this.p0.P0(new c());
        this.p1.L0(new TaskShortcutFragment.c() { // from class: com.tplink.iot.view.smart.actionsetup.w
            @Override // com.tplink.iot.view.smart.actionsetup.TaskShortcutFragment.c
            public final void a() {
                ActionDetailActivity.this.U0();
            }
        });
        this.p2.L0(new TaskAutomationFragment.c() { // from class: com.tplink.iot.view.smart.actionsetup.c
            @Override // com.tplink.iot.view.smart.actionsetup.TaskAutomationFragment.c
            public final void a() {
                ActionDetailActivity.this.A1();
            }
        });
        this.H3.Q0(new TaskDeviceChooseFragment.a() { // from class: com.tplink.iot.view.smart.actionsetup.d
            @Override // com.tplink.iot.view.smart.actionsetup.TaskDeviceChooseFragment.a
            public final void a() {
                ActionDetailActivity.this.C1();
            }
        });
        this.p3.K0(new TaskAutomationEnableFragment.a() { // from class: com.tplink.iot.view.smart.actionsetup.l0
            @Override // com.tplink.iot.view.smart.actionsetup.TaskAutomationEnableFragment.a
            public final void a() {
                ActionDetailActivity.this.U0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z1 */
    public /* synthetic */ void A1() {
        J1(this.p3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        H1(bundle);
        super.onCreate(bundle);
        setContentView(R.layout.activity_smart_action_detail);
        if (getIntent() != null) {
            this.L3 = getIntent().getIntExtra("action_item_index", -1);
            this.M3 = getIntent().getIntExtra("action_detail_type", 1);
            this.N3 = getIntent().getBooleanExtra("action_from_featured_action", false);
            str = getIntent().getStringExtra("action_smart_info");
        } else {
            str = null;
        }
        this.K3 = (ActionSetupViewModel) ViewModelProviders.of(this).get(ActionSetupViewModel.class);
        if (!this.N3 || TextUtils.isEmpty(str)) {
            this.K3.c0(this.L3);
            this.K3.b0(this.M3);
        } else {
            SmartInfo smartInfo = (SmartInfo) i.d(str, SmartInfo.class);
            if (smartInfo != null) {
                this.K3.c0(-1);
                this.K3.b0(2);
                this.K3.p0(smartInfo);
            } else {
                this.K3.c0(-1);
                this.K3.b0(1);
            }
        }
        y1();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void u1() {
        if (!com.tplink.iot.view.quicksetup.base.f.a.a(this)) {
            startActivity(new Intent(this, LocationPrepareActivity.class));
        } else {
            v1();
        }
    }

    public void v1() {
        this.I3.L0();
    }
}
