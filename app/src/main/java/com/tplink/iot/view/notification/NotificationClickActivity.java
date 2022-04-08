package com.tplink.iot.view.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.core.o;
import com.tplink.iot.firebase.CloudMessageBean;
import com.tplink.iot.view.welcome.StartupActivity;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NotificationClickActivity extends AppCompatActivity {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumMsgSubscribeType.values().length];
            a = iArr;
            try {
                iArr[EnumMsgSubscribeType.CAMERA_MOTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_CRYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_SD_NEED_INITIALIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_SD_INSUFFICIENT_STORAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_AREA_INTRUSION_DETECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_LINE_CROSSING_DETECTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumMsgSubscribeType.CAMERA_TAMPERING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_HUB_TRIGGERED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_MOTION_SENSOR_TRIGGERED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_CONTACT_SENSOR_TRIGGERED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_SMART_BUTTON_TRIGGERED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_DAILY_SUMMARY_CREATED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[EnumMsgSubscribeType.TAPO_DAILY_SUMMARY_CAN_CREATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private void P0(Activity activity, CloudMessageBean cloudMessageBean) {
        if (o.a() != 0) {
            Intent a2 = b.a(activity, cloudMessageBean);
            if (a2 != null) {
                startActivity(a2);
            }
            finish();
            return;
        }
        S0(activity, cloudMessageBean);
    }

    private CloudMessageBean Q0(Intent intent) {
        String str = "";
        String R0 = R0(intent, "msgId", str);
        String R02 = R0(intent, "title", str);
        String R03 = R0(intent, FirebaseAnalytics.Param.CONTENT, str);
        String R04 = R0(intent, "msgType", str);
        String R05 = R0(intent, RtspHeaders.Values.TIME, str);
        R0(intent, "deviceCount", String.valueOf(0));
        String R06 = R0(intent, "userName", str);
        String R07 = R0(intent, "deviceId", str);
        String R08 = R0(intent, "imgUrl", str);
        String R09 = R0(intent, "alias", str);
        String R010 = R0(intent, "uuid", str);
        String R011 = R0(intent, "iac", str);
        String R012 = R0(intent, "summaryDate", str);
        if (!TextUtils.isEmpty(R011) && !TextUtils.isEmpty(U0(R011))) {
            R04 = U0(R011);
            str = V0(R011, R04);
        }
        CloudMessageBean cloudMessageBean = new CloudMessageBean(R0, R04, R05);
        cloudMessageBean.setTitle(R02);
        cloudMessageBean.setContent(R03);
        cloudMessageBean.setUserName(R06);
        cloudMessageBean.setDeviceId(R07);
        cloudMessageBean.setImgUrl(R08);
        cloudMessageBean.setAlias(R09);
        cloudMessageBean.setUuid(R010);
        cloudMessageBean.setTaskId(str);
        cloudMessageBean.setSummaryDate(R012);
        return cloudMessageBean;
    }

    private String R0(Intent intent, String str, String str2) {
        String stringExtra;
        return (intent == null || !intent.hasExtra(str) || (stringExtra = intent.getStringExtra(str)) == null) ? str2 : stringExtra;
    }

    private void S0(Context context, CloudMessageBean cloudMessageBean) {
        Intent intent = new Intent();
        intent.setClass(context, StartupActivity.class);
        intent.setFlags(268435456);
        if (!TextUtils.isEmpty(cloudMessageBean.getTaskId())) {
            intent.putExtra("task_id", cloudMessageBean.getTaskId());
        }
        switch (a.a[EnumMsgSubscribeType.fromString(cloudMessageBean.getMessageType()).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                W0(intent, cloudMessageBean);
                break;
        }
        context.startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    private void T0() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        CloudMessageBean Q0 = Q0(intent);
        if (TextUtils.isEmpty(Q0.getMessageType())) {
            finish();
        } else {
            P0(this, Q0);
        }
    }

    public static String U0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("msgType", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String V0(String str, String str2) {
        if (TextUtils.isEmpty(str) || !"pushWithTaskId".equals(str2)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("taskId", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void W0(Intent intent, CloudMessageBean cloudMessageBean) {
        intent.putExtra("fcm_device_id", cloudMessageBean.getDeviceId());
        intent.putExtra("fcm_event_time", cloudMessageBean.getTimestamp());
        intent.putExtra("notification_msg_type", cloudMessageBean.getMessageType());
        intent.putExtra("fcm_uuid", cloudMessageBean.getUuid());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.activity_notification_click);
        T0();
    }
}
