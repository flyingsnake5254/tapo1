package com.tplink.iot.view.ipcamera.setting.detection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDetectSettingBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.ipcamera.setting.AlarmSettingActivity;
import com.tplink.iot.view.ipcamera.setting.AreaIntrusionActivity;
import com.tplink.iot.view.ipcamera.setting.LineCrossingDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.MotionDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.MsgPushActivity;
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog;
import com.tplink.iot.view.ipcamera.setting.VideoTamperingActivity;
import com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.detection.DetectionSettingsViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.o;

@SuppressLint({"Registered"})
/* loaded from: classes2.dex */
public class DetectionSettingActivity extends BaseActivity {
    protected DetectionSettingsViewModel p0;
    protected ActivityDetectSettingBinding z;
    private final String y = DetectionSettingActivity.class.getSimpleName();
    private io.reactivex.e0.b p1 = new io.reactivex.e0.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (org.apache.commons.lang.b.b(bool)) {
                DetectionSettingActivity.this.f1();
            }
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
                intent.putExtra("android.provider.extra.APP_PACKAGE", DetectionSettingActivity.this.getPackageName());
                intent.putExtra("android.intent.extra.CHANNEL_ID", DetectionSettingActivity.this.getApplicationInfo().uid);
                intent.putExtra("app_package", DetectionSettingActivity.this.getPackageName());
                intent.putExtra("app_uid", DetectionSettingActivity.this.getApplicationInfo().uid);
                if ("MI 6".equals(Build.MODEL)) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", DetectionSettingActivity.this.getPackageName(), null));
                }
                DetectionSettingActivity.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", DetectionSettingActivity.this.getPackageName(), null));
                DetectionSettingActivity.this.startActivity(intent2);
            }
        }
    }

    private void e1() {
        b.d.w.c.a.e("DetectSettingActivity", "type:" + this.p0.R.get());
        this.p0.S.set(getResources().getDrawable(c.b(this.p0.R.get())));
    }

    private void g1() {
        this.p0.A.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.detection.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DetectionSettingActivity.this.j1((Boolean) obj);
            }
        });
        this.p0.z.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.detection.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DetectionSettingActivity.this.l1((String) obj);
            }
        });
        this.p0.D.observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(Boolean bool) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(String str) {
        TSnackbar.y(this, str, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1() {
        this.p0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ai_detection /* 2131361946 */:
                AIDetectionActivity.y.a(this, this.p0.y, 3);
                return;
            case R.id.alarm_setting /* 2131361949 */:
                AlarmSettingActivity.y.a(this, this.p0.y, 3);
                return;
            case R.id.ll_intrusion /* 2131363294 */:
                if (this.p0.f10914d.get()) {
                    AreaIntrusionActivity.y.a(this, this.p0.y, 3);
                    return;
                }
                return;
            case R.id.ll_line_crossing /* 2131363304 */:
                if (this.p0.f10915e.get()) {
                    LineCrossingDetectionActivity.y.a(this, this.p0.y, 3);
                    return;
                }
                return;
            case R.id.ll_motion /* 2131363310 */:
                MotionDetectionActivity.y.a(this, this.p0.y, 3);
                return;
            case R.id.ll_tamper /* 2131363342 */:
                if (this.p0.f10913c.get()) {
                    VideoTamperingActivity.y.a(this, this.p0.y, 3);
                    return;
                }
                return;
            case R.id.notification_setting /* 2131363562 */:
                if (this.p0.n.get()) {
                    MsgPushActivity.y.a(this, this.p0.y, 3);
                    return;
                }
                return;
            case R.id.target_track /* 2131364156 */:
                TargetTrackActivity.y.a(this, this.p0.y, 3);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1(View view) {
        onBackPressed();
    }

    public static void s1(Activity activity, String str) {
        if (str != null) {
            Intent intent = new Intent(activity, DetectionSettingActivity.class);
            intent.putExtra("device_id_md5", str);
            activity.startActivity(intent);
        }
    }

    public void f1() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
        boolean z = System.currentTimeMillis() - o.h0().W() > 86400000;
        if (!areNotificationsEnabled && z) {
            NotificationCloseDialog notificationCloseDialog = new NotificationCloseDialog();
            notificationCloseDialog.H0(new b());
            notificationCloseDialog.show(getSupportFragmentManager(), "");
            o.h0().b1(System.currentTimeMillis());
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.p0.w()) {
            new UniversalDialog.a().q(getString(R.string.cloud_notification_check_messsage)).u(getString(R.string.turn_on)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.detection.b
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    DetectionSettingActivity.this.n1();
                }
            }).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.setting.detection.f
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    DetectionSettingActivity.this.p1();
                }
            }).l().show(getSupportFragmentManager(), "");
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.z = (ActivityDetectSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_detect_setting);
        if (stringExtra == null) {
            stringExtra = "";
        }
        DetectionSettingsViewModel detectionSettingsViewModel = (DetectionSettingsViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(DetectionSettingsViewModel.class);
        this.p0 = detectionSettingsViewModel;
        this.z.i(detectionSettingsViewModel);
        this.z.h(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.detection.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectionSettingActivity.this.onClick(view);
            }
        });
        setSupportActionBar(this.z.p2);
        this.z.p2.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.detection.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectionSettingActivity.this.r1(view);
            }
        });
        e1();
        this.p0.X(this);
        this.p0.T();
        g1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.p1.dispose();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.p0.Z();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
