package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAlarmSettingBinding;
import com.tplink.iot.view.ipcamera.setting.AlarmSoundActivity;
import com.tplink.iot.view.ipcamera.setting.AlarmTypeActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDay;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: AlarmSettingActivity.kt */
/* loaded from: classes2.dex */
public final class AlarmSettingActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private HashMap H3;
    private ActivityAlarmSettingBinding p0;
    private AlarmSettingViewModel p1;
    private String p2;
    private final int z = 10001;
    private int p3 = 3;

    /* compiled from: AlarmSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            j.e(context, "context");
            j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, AlarmSettingActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(AlarmSettingActivity.this);
            } else {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                AlarmSettingActivity alarmSettingActivity = AlarmSettingActivity.this;
                TSnackbar.y(alarmSettingActivity, alarmSettingActivity.getString(R.string.general_failed), -1).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                AlarmSettingActivity.f1(AlarmSettingActivity.this).p2.check(R.id.custom_item);
                RadioButton radioButton = AlarmSettingActivity.f1(AlarmSettingActivity.this).q;
                j.d(radioButton, "binding.allDayItem");
                radioButton.setClickable(true);
                RadioButton radioButton2 = AlarmSettingActivity.f1(AlarmSettingActivity.this).x;
                j.d(radioButton2, "binding.customItem");
                radioButton2.setClickable(false);
                RelativeLayout relativeLayout = AlarmSettingActivity.f1(AlarmSettingActivity.this).y;
                j.d(relativeLayout, "binding.itemScheduleContainer");
                relativeLayout.setVisibility(0);
                return;
            }
            AlarmSettingActivity.f1(AlarmSettingActivity.this).p2.check(R.id.all_day_item);
            RadioButton radioButton3 = AlarmSettingActivity.f1(AlarmSettingActivity.this).q;
            j.d(radioButton3, "binding.allDayItem");
            radioButton3.setClickable(false);
            RadioButton radioButton4 = AlarmSettingActivity.f1(AlarmSettingActivity.this).x;
            j.d(radioButton4, "binding.customItem");
            radioButton4.setClickable(true);
            RelativeLayout relativeLayout2 = AlarmSettingActivity.f1(AlarmSettingActivity.this).y;
            j.d(relativeLayout2, "binding.itemScheduleContainer");
            relativeLayout2.setVisibility(8);
        }
    }

    public static final /* synthetic */ ActivityAlarmSettingBinding f1(AlarmSettingActivity alarmSettingActivity) {
        ActivityAlarmSettingBinding activityAlarmSettingBinding = alarmSettingActivity.p0;
        if (activityAlarmSettingBinding == null) {
            j.t("binding");
        }
        return activityAlarmSettingBinding;
    }

    private final void g1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p2 = stringExtra;
        this.p3 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.p2;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(AlarmSettingViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ingViewModel::class.java)");
        this.p1 = (AlarmSettingViewModel) viewModel;
        ActivityAlarmSettingBinding activityAlarmSettingBinding = this.p0;
        if (activityAlarmSettingBinding == null) {
            j.t("binding");
        }
        AlarmSettingViewModel alarmSettingViewModel = this.p1;
        if (alarmSettingViewModel == null) {
            j.t("viewModel");
        }
        activityAlarmSettingBinding.i(alarmSettingViewModel);
        ActivityAlarmSettingBinding activityAlarmSettingBinding2 = this.p0;
        if (activityAlarmSettingBinding2 == null) {
            j.t("binding");
        }
        activityAlarmSettingBinding2.h(this);
        AlarmSettingViewModel alarmSettingViewModel2 = this.p1;
        if (alarmSettingViewModel2 == null) {
            j.t("viewModel");
        }
        alarmSettingViewModel2.l(this.p3);
    }

    private final void h1() {
        AlarmSettingViewModel alarmSettingViewModel = this.p1;
        if (alarmSettingViewModel == null) {
            j.t("viewModel");
        }
        alarmSettingViewModel.a.observe(this, new b());
        AlarmSettingViewModel alarmSettingViewModel2 = this.p1;
        if (alarmSettingViewModel2 == null) {
            j.t("viewModel");
        }
        alarmSettingViewModel2.f10681b.observe(this, new c());
        AlarmSettingViewModel alarmSettingViewModel3 = this.p1;
        if (alarmSettingViewModel3 == null) {
            j.t("viewModel");
        }
        alarmSettingViewModel3.f10682c.observe(this, new d());
    }

    private final void i1() {
        b1(R.string.camera_alarm_new);
    }

    private final List<BitwiseWeekDay> k1(boolean[] zArr) {
        ArrayList arrayList = new ArrayList();
        List<BitwiseWeekDay> allDays = BitwiseWeekDayUtils.getAllDays();
        if (zArr.length == allDays.size()) {
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    arrayList.add(allDays.get(i));
                }
            }
        }
        return arrayList;
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

    public final void j1() {
        Intent intent = new Intent(this, ScheduleEditActivity.class);
        intent.putExtra("canPastMidnight", true);
        intent.putExtra(RtspHeaders.Values.MODE, "modify");
        intent.putExtra("deletable", false);
        AlarmSettingViewModel alarmSettingViewModel = this.p1;
        if (alarmSettingViewModel == null) {
            j.t("viewModel");
        }
        intent.putExtra("startTime", alarmSettingViewModel.h.get());
        AlarmSettingViewModel alarmSettingViewModel2 = this.p1;
        if (alarmSettingViewModel2 == null) {
            j.t("viewModel");
        }
        intent.putExtra("endTime", alarmSettingViewModel2.i.get());
        String str = this.p2;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        intent.putExtra("device_id_md5", str);
        AlarmSettingViewModel alarmSettingViewModel3 = this.p1;
        if (alarmSettingViewModel3 == null) {
            j.t("viewModel");
        }
        com.tplink.libtpnetwork.cameranetwork.business.model.a j = alarmSettingViewModel3.j();
        j.d(j, "viewModel.alarmSchedule");
        int i = 127;
        if (j != null) {
            i = j.b().getType();
        }
        AlarmSettingViewModel alarmSettingViewModel4 = this.p1;
        if (alarmSettingViewModel4 == null) {
            j.t("viewModel");
        }
        intent.putExtra("weekDayArr", alarmSettingViewModel4.Q(i));
        startActivityForResult(intent, this.z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i2 == 101) {
            String stringExtra = intent.getStringExtra("startTime");
            String str = "";
            if (stringExtra == null) {
                stringExtra = str;
            }
            j.d(stringExtra, "data.getStringExtra(\"startTime\") ?: \"\"");
            String stringExtra2 = intent.getStringExtra("endTime");
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            j.d(str, "data.getStringExtra(\"endTime\") ?: \"\"");
            Serializable serializableExtra = intent.getSerializableExtra("weekDayArr");
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type kotlin.BooleanArray");
            boolean[] zArr = (boolean[]) serializableExtra;
            AlarmSettingViewModel alarmSettingViewModel = this.p1;
            if (alarmSettingViewModel == null) {
                j.t("viewModel");
            }
            alarmSettingViewModel.U(true, stringExtra, str, k1(zArr));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.tplink.iot.a.alarm_switch;
        if (j.a(view, (CheckBox) e1(i))) {
            AlarmSettingViewModel alarmSettingViewModel = this.p1;
            if (alarmSettingViewModel == null) {
                j.t("viewModel");
            }
            CheckBox alarm_switch = (CheckBox) e1(i);
            j.d(alarm_switch, "alarm_switch");
            alarmSettingViewModel.T(alarm_switch.isChecked());
        } else if (j.a(view, (RelativeLayout) e1(com.tplink.iot.a.alert_type))) {
            AlarmTypeActivity.a aVar = AlarmTypeActivity.y;
            String str = this.p2;
            if (str == null) {
                j.t("deviceIdMD5");
            }
            aVar.a(this, str, this.p3);
        } else if (j.a(view, (RelativeLayout) e1(com.tplink.iot.a.sound_type))) {
            AlarmSoundActivity.a aVar2 = AlarmSoundActivity.y;
            String str2 = this.p2;
            if (str2 == null) {
                j.t("deviceIdMD5");
            }
            aVar2.a(this, str2, this.p3);
        } else if (j.a(view, (RadioButton) e1(com.tplink.iot.a.all_day_item))) {
            AlarmSettingViewModel alarmSettingViewModel2 = this.p1;
            if (alarmSettingViewModel2 == null) {
                j.t("viewModel");
            }
            alarmSettingViewModel2.O();
        } else if (j.a(view, (RadioButton) e1(com.tplink.iot.a.custom_item))) {
            AlarmSettingViewModel alarmSettingViewModel3 = this.p1;
            if (alarmSettingViewModel3 == null) {
                j.t("viewModel");
            }
            alarmSettingViewModel3.P();
        } else if (j.a(view, (RelativeLayout) e1(com.tplink.iot.a.item_schedule_container))) {
            j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_alarm_setting);
        j.d(contentView, "DataBindingUtil.setConte…t.activity_alarm_setting)");
        this.p0 = (ActivityAlarmSettingBinding) contentView;
        i1();
        g1();
        h1();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        AlarmSettingViewModel alarmSettingViewModel = this.p1;
        if (alarmSettingViewModel == null) {
            j.t("viewModel");
        }
        alarmSettingViewModel.N();
    }
}
