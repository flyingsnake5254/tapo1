package com.tplink.iot.view.notification;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.adapter.notification.MotionDetectionAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.notification.DeviceNotificationBean;
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import java.util.List;

/* loaded from: classes2.dex */
public class TriggeredDeviceTypeActivity extends BaseActivity implements MotionDetectionAdapter.b {
    @BindView
    RecyclerView mMotionDetectionDeviceRV;
    @BindView
    TextView mNoMotionDeviceTv;
    @BindView
    TextView mToolbarTitle;
    private int p0;
    private String p1;
    private MotionDetectionAdapter y;
    private MessagePushViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<BaseALIoTDevice>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            if (list == null || list.size() == 0) {
                TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(8);
                TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(0);
                return;
            }
            List<DeviceNotificationBean> y = TriggeredDeviceTypeActivity.this.z.y(TriggeredDeviceTypeActivity.this.z.i(list, TriggeredDeviceTypeActivity.this.p0));
            if (y == null || y.size() <= 0) {
                TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(8);
                TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(0);
                return;
            }
            TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(8);
            TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(0);
            TriggeredDeviceTypeActivity.this.y.n(y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements NotificationCloseDialog.a {
        b() {
        }

        @Override // com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog.a
        public void a() {
        }

        @Override // com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog.a
        public void b() {
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", TriggeredDeviceTypeActivity.this.getPackageName());
                intent.putExtra("android.intent.extra.CHANNEL_ID", TriggeredDeviceTypeActivity.this.getApplicationInfo().uid);
                intent.putExtra("app_package", TriggeredDeviceTypeActivity.this.getPackageName());
                intent.putExtra("app_uid", TriggeredDeviceTypeActivity.this.getApplicationInfo().uid);
                if ("MI 6".equals(Build.MODEL)) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", TriggeredDeviceTypeActivity.this.getPackageName(), null));
                }
                TriggeredDeviceTypeActivity.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", TriggeredDeviceTypeActivity.this.getPackageName(), null));
                TriggeredDeviceTypeActivity.this.startActivity(intent2);
            }
        }
    }

    private boolean h1() {
        return NotificationManagerCompat.from(this).areNotificationsEnabled();
    }

    private void i1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.p0 = intent.getIntExtra("device_type", 0);
            this.p1 = intent.getStringExtra("device_type_name");
        }
    }

    private void j1() {
        String str = this.p1;
        if (str != null) {
            this.mToolbarTitle.setText(str);
        }
        this.mMotionDetectionDeviceRV.addItemDecoration(new HomeSpaceItemDecoration(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mMotionDetectionDeviceRV.setLayoutManager(linearLayoutManager);
        MotionDetectionAdapter motionDetectionAdapter = new MotionDetectionAdapter(this);
        this.y = motionDetectionAdapter;
        this.mMotionDetectionDeviceRV.setAdapter(motionDetectionAdapter);
        this.y.o(this);
    }

    private void k1() {
        NotificationCloseDialog notificationCloseDialog = new NotificationCloseDialog();
        notificationCloseDialog.H0(new b());
        notificationCloseDialog.show(getSupportFragmentManager(), "");
    }

    private void l1() {
        this.z.g().observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_triggered_device_type);
        ButterKnife.a(this);
        this.z = (MessagePushViewModel) ViewModelProviders.of(this).get(MessagePushViewModel.class);
        i1();
        j1();
        l1();
    }

    @Override // com.tplink.iot.adapter.notification.MotionDetectionAdapter.b
    public void u(CompoundButton compoundButton, String str, boolean z, boolean z2) {
        if (str != null) {
            if (!z || h1()) {
                this.z.w(str, EnumMsgSubscribeType.CAMERA_MOTION, z, z2);
                q.n(z, "DeviceTriggered");
                return;
            }
            compoundButton.setChecked(false);
            k1();
        }
    }
}
