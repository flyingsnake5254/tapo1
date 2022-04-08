package com.tplink.iot.view.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.feedback.DeviceTypeListActivity;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.g;
import com.tplink.iot.widget.viewgroup.LedBlinkTitleView;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class DeviceOfflineTroubleshootingActivity extends BaseActivity {
    private View p0;
    private String y;
    private String z;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceOfflineTroubleshootingActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    class b implements d0.g {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            DeviceOfflineTroubleshootingActivity.this.W0(DeviceTypeListActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements d0.g {
        c() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            DeviceOfflineTroubleshootingActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            a = iArr;
            try {
                iArr[EnumDeviceType.PLUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumDeviceType.BULB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumDeviceType.CAMERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumDeviceType.HUB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumDeviceType.SENSOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumDeviceType.SWITCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumDeviceType.ENERGY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void f1(String str) {
        switch (d.a[EnumDeviceType.fromType(str).ordinal()]) {
            case 1:
                k1();
                return;
            case 2:
                g1();
                return;
            case 3:
                h1();
                return;
            case 4:
                j1();
                return;
            case 5:
                l1();
                return;
            case 6:
                m1();
                return;
            case 7:
                i1();
                return;
            default:
                return;
        }
    }

    private void g1() {
        if (com.tplink.iot.g.b.c.c.i(this.y)) {
            h.a(this.p0.findViewById(R.id.tv_tip3), getString(R.string.offline_troubleshooting_turn_off_device_and_on));
        }
    }

    private void h1() {
        LedBlinkTitleView ledBlinkTitleView = (LedBlinkTitleView) this.p0.findViewById(R.id.tv_camera_led_blink_slowly);
        if (ledBlinkTitleView != null) {
            ledBlinkTitleView.setTitleText(com.tplink.iot.view.ipcamera.base.c.g(DeviceModel.fromValue(this.y), this.z));
            ledBlinkTitleView.setDynamicLedColor(getResources().getColor(com.tplink.iot.view.ipcamera.base.c.h(DeviceModel.fromValue(this.y), this.z)));
        }
        LedBlinkTitleView ledBlinkTitleView2 = (LedBlinkTitleView) this.p0.findViewById(R.id.tv_camera_led_solid);
        if (ledBlinkTitleView2 != null) {
            int i = com.tplink.iot.view.ipcamera.base.c.i(DeviceModel.fromValue(this.y), this.z);
            ledBlinkTitleView2.setTitleText(i);
            ledBlinkTitleView2.setStaticLedColor(getResources().getColor(R.color.led_green));
            if (R.string.offline_troubleshooting_led_green_or_amber == i) {
                ledBlinkTitleView2.c(Integer.valueOf(getResources().getColor(R.color.led_orange)), null, 0);
            }
        }
    }

    private void i1() {
        if ("E100".equals(this.y)) {
            h.a(this.p0.findViewById(R.id.tv_reset_hint), getString(R.string.subg_qs_press_reset_button_hint, new Object[]{5}));
        }
    }

    private void j1() {
    }

    private void k1() {
        LedBlinkTitleView ledBlinkTitleView = (LedBlinkTitleView) this.p0.findViewById(R.id.ts_plug_led_1);
        LedBlinkTitleView ledBlinkTitleView2 = (LedBlinkTitleView) this.p0.findViewById(R.id.ts_plug_led_2);
        if ("P110".equals(this.y)) {
            if (ledBlinkTitleView != null) {
                ledBlinkTitleView.setTitleText(R.string.offline_troubleshooting_led_red);
                ledBlinkTitleView.setStaticLedColor(getResources().getColor(R.color.led_red));
            }
            if (ledBlinkTitleView2 != null) {
                ledBlinkTitleView2.setTitleText(R.string.offline_troubleshooting_led_orange_or_green);
                ledBlinkTitleView2.setStaticLedColor(getResources().getColor(R.color.led_orange));
                ledBlinkTitleView2.c(Integer.valueOf(getResources().getColor(R.color.led_green)), null, 0);
            }
        } else if ("P115".equals(this.y)) {
            if (ledBlinkTitleView != null) {
                ledBlinkTitleView.setTitleText(R.string.offline_troubleshooting_led_red);
                ledBlinkTitleView.setStaticLedColor(getResources().getColor(R.color.led_red));
            }
            if (ledBlinkTitleView2 != null) {
                ledBlinkTitleView2.setTitleText(R.string.offline_troubleshooting_led_pink_or_blue);
                ledBlinkTitleView2.setStaticLedColor(getResources().getColor(R.color.led_rose_red));
                ledBlinkTitleView2.c(Integer.valueOf(getResources().getColor(R.color.led_blue_p115)), null, 0);
            }
            LedBlinkTitleView ledBlinkTitleView3 = (LedBlinkTitleView) this.p0.findViewById(R.id.tv_plug_led_blink_quickly);
            View findViewById = this.p0.findViewById(R.id.tv_led_blink_quickly_tip);
            if (ledBlinkTitleView3 != null) {
                ledBlinkTitleView3.setTitleText(R.string.offline_troubleshooting_led_blink_blue_quickly);
                ledBlinkTitleView3.setDynamicLedColor(getResources().getColor(R.color.led_blue_p115));
            }
            h.a(findViewById, getString(R.string.offline_troubleshooting_led_blink_blue_tip));
        }
    }

    private void l1() {
        h.a((TextView) this.p0.findViewById(R.id.tv_reset_hint), g.a(SubDeviceModel.fromValue(this.y)).c());
        if ("S200B".equals(this.y)) {
            View findViewById = this.p0.findViewById(R.id.tv_tip4);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            h.a(this.p0.findViewById(R.id.tv_tip3), getString(R.string.switch_offline_trigger_device_by_single_tap));
        }
    }

    private void m1() {
    }

    @LayoutRes
    private int n1(String str) {
        switch (d.a[EnumDeviceType.fromType(str).ordinal()]) {
            case 1:
                return R.layout.layout_device_offline_troubleshooting_plug;
            case 2:
                return R.layout.layout_device_offline_troubleshooting_bulb;
            case 3:
                return R.layout.layout_device_offline_troubleshooting_camera;
            case 4:
                return R.layout.layout_device_offline_troubleshooting_hub;
            case 5:
                return R.layout.layout_device_offline_troubleshooting_sensor;
            case 6:
                return R.layout.layout_device_offline_troubleshooting_switch;
            case 7:
                return R.layout.layout_device_offline_troubleshooting_energy;
            default:
                finish();
                return R.layout.layout_device_offline_troubleshooting_bulb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        com.tplink.iot.view.quicksetup.base.b.h(this, this.y);
    }

    public static void p1(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, DeviceOfflineTroubleshootingActivity.class);
        intent.putExtra("device_type", str);
        intent.putExtra("device_model", str2);
        intent.putExtra("device_hw_ver", str3);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_in_from_bottom, R.anim.anim_fake_out);
    }

    private void q1(TextView textView) {
        String string = getString(R.string.reconnect_tip_content);
        d0.c(textView, getString(R.string.reconnect_tip, new Object[]{string}), string, ContextCompat.getColor(this, R.color.common_iot_purple), new c());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.push_out_to_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_offline_troubleshooting);
        findViewById(R.id.img_close).setOnClickListener(new a());
        String stringExtra = getIntent().getStringExtra("device_type");
        this.y = getIntent().getStringExtra("device_model");
        this.z = getIntent().getStringExtra("device_hw_ver");
        ViewStub viewStub = (ViewStub) findViewById(R.id.offline_troubleshooting_container);
        viewStub.setLayoutResource(n1(stringExtra));
        this.p0 = viewStub.inflate();
        f1(stringExtra);
        q1((TextView) this.p0.findViewById(R.id.tv_reconnect));
        String upperCase = getString(R.string.quicksetup_common_contact_us_end).toUpperCase();
        d0.c((TextView) findViewById(R.id.tv_contact_us), getString(R.string.quicksetup_common_contact_us_problem, new Object[]{upperCase}), upperCase, ContextCompat.getColor(this, R.color.common_iot_purple), new b());
    }
}
