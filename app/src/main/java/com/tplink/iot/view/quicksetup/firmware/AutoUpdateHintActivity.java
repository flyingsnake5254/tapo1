package com.tplink.iot.view.quicksetup.firmware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QsFirmwareViewModel;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: AutoUpdateHintActivity.kt */
/* loaded from: classes2.dex */
public final class AutoUpdateHintActivity extends BaseActivity implements View.OnClickListener, AutoUpdateTimePickerDialog.a {
    public static final a y = new a(null);
    private HashMap H3;
    private QsFirmwareViewModel p0;
    private AutoUpdateTimePickerDialog p2;
    private CommonQuickSetupBean z;
    private final String[] p1 = h.d();
    private int p3 = 180;

    /* compiled from: AutoUpdateHintActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, CommonQuickSetupBean quickSetupInfoBean) {
            j.e(context, "context");
            j.e(quickSetupInfoBean, "quickSetupInfoBean");
            Intent intent = new Intent(context, AutoUpdateHintActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("common_quick_setup_bean", quickSetupInfoBean);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void f1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.z = (CommonQuickSetupBean) extras.getSerializable("common_quick_setup_bean");
        }
    }

    private final boolean g1() {
        CommonQuickSetupBean commonQuickSetupBean = this.z;
        if (commonQuickSetupBean != null) {
            return commonQuickSetupBean.isFromQuickDiscovery();
        }
        return false;
    }

    private final void h1() {
        com.tplink.iot.view.quicksetup.bulb.utils.a.d(this, g1());
    }

    private final void i1() {
        QuickSetupComponentResult componentResult;
        QuickSetupComponentExtraInfoBean extraInfo;
        CommonQuickSetupBean commonQuickSetupBean = this.z;
        String deviceModel = (commonQuickSetupBean == null || (componentResult = commonQuickSetupBean.getComponentResult()) == null || (extraInfo = componentResult.getExtraInfo()) == null) ? null : extraInfo.getDeviceModel();
        if (c.i(deviceModel)) {
            LightStripPlacementGuideActivity.a aVar = LightStripPlacementGuideActivity.y;
            if (deviceModel == null) {
                deviceModel = "";
            }
            aVar.b(this, deviceModel, true, g1());
            return;
        }
        h1();
    }

    private final void j1() {
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog = this.p2;
        if (autoUpdateTimePickerDialog != null) {
            j.c(autoUpdateTimePickerDialog);
            if (autoUpdateTimePickerDialog.isVisible()) {
                return;
            }
        }
        AutoUpdateTimePickerDialog A0 = AutoUpdateTimePickerDialog.A0(this.p3);
        this.p2 = A0;
        if (A0 != null) {
            A0.B0(this);
        }
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog2 = this.p2;
        if (autoUpdateTimePickerDialog2 != null) {
            autoUpdateTimePickerDialog2.show(getSupportFragmentManager(), (String) null);
        }
    }

    public View e1(int i) {
        if (this.H3 == null) {
            this.H3 = new HashMap();
        }
        View view = (View) this.H3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.H3.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a(view, (Button) e1(com.tplink.iot.a.btn_got_it))) {
            QsFirmwareViewModel qsFirmwareViewModel = this.p0;
            if (qsFirmwareViewModel == null) {
                j.t("viewModel");
            }
            qsFirmwareViewModel.x(this.p3);
            i1();
        } else if (j.a(view, (TextView) e1(com.tplink.iot.a.auto_update_time))) {
            j1();
        } else if (j.a(view, (TextView) e1(com.tplink.iot.a.tv_skip))) {
            QsFirmwareViewModel qsFirmwareViewModel2 = this.p0;
            if (qsFirmwareViewModel2 == null) {
                j.t("viewModel");
            }
            qsFirmwareViewModel2.x(this.p3);
            h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        QuickSetupComponentResult componentResult;
        QuickSetupComponentExtraInfoBean extraInfo;
        super.onCreate(bundle);
        setContentView(R.layout.activity_auto_update_hint);
        f1();
        CommonQuickSetupBean commonQuickSetupBean = this.z;
        String str = null;
        if (c.i((commonQuickSetupBean == null || (componentResult = commonQuickSetupBean.getComponentResult()) == null || (extraInfo = componentResult.getExtraInfo()) == null) ? null : extraInfo.getDeviceModel())) {
            Button btn_got_it = (Button) e1(com.tplink.iot.a.btn_got_it);
            j.d(btn_got_it, "btn_got_it");
            btn_got_it.setText(getString(R.string.precautions_for_use));
            int i = com.tplink.iot.a.tv_skip;
            TextView tv_skip = (TextView) e1(i);
            j.d(tv_skip, "tv_skip");
            tv_skip.setVisibility(0);
            ((TextView) e1(i)).setOnClickListener(this);
        }
        CommonQuickSetupBean commonQuickSetupBean2 = this.z;
        if (commonQuickSetupBean2 == null) {
            str = "";
        } else if (commonQuickSetupBean2 != null) {
            str = commonQuickSetupBean2.getDeviceIdMD5();
        }
        ViewModel viewModel = ViewModelProviders.of(this, new IoTViewModelFactory(this, str)).get(QsFirmwareViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…areViewModel::class.java]");
        this.p0 = (QsFirmwareViewModel) viewModel;
        int i2 = com.tplink.iot.a.auto_update_time;
        TextView auto_update_time = (TextView) e1(i2);
        j.d(auto_update_time, "auto_update_time");
        auto_update_time.setText(this.p1[3]);
        ((TextView) e1(i2)).setOnClickListener(this);
        ((Button) e1(com.tplink.iot.a.btn_got_it)).setOnClickListener(this);
    }

    @Override // com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog.a
    public void v(int i) {
        this.p3 = i * 60;
        TextView auto_update_time = (TextView) e1(com.tplink.iot.a.auto_update_time);
        j.d(auto_update_time, "auto_update_time");
        auto_update_time.setText(this.p1[i]);
    }
}
