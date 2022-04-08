package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAlarmTypeBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmTypeViewModel;
import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: AlarmTypeActivity.kt */
/* loaded from: classes2.dex */
public final class AlarmTypeActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private AlarmTypeViewModel p0;
    private String p1;
    private int p2 = 3;
    private HashMap p3;
    private ActivityAlarmTypeBinding z;

    /* compiled from: AlarmTypeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            j.e(context, "context");
            j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, AlarmTypeActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmTypeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<AlertOption> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(AlertOption alertOption) {
            int i;
            if (alertOption != null) {
                int i2 = y4.a[alertOption.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    i = R.id.sound;
                } else if (i2 == 2) {
                    i = R.id.light;
                } else if (i2 == 3) {
                    i = R.id.sound_light;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                AlarmTypeActivity.g1(AlarmTypeActivity.this).f6492d.check(i);
                AlarmTypeActivity alarmTypeActivity = AlarmTypeActivity.this;
                boolean z2 = alertOption != AlertOption.SOUND;
                boolean z3 = alertOption != AlertOption.LIGHT;
                if (alertOption == AlertOption.BOTH) {
                    z = false;
                }
                alarmTypeActivity.h1(z2, z3, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmTypeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                s0.l(AlarmTypeActivity.this);
            } else {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmTypeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                AlarmTypeActivity alarmTypeActivity = AlarmTypeActivity.this;
                TSnackbar.y(alarmTypeActivity, alarmTypeActivity.getString(R.string.general_failed), -1).N();
            }
        }
    }

    public static final /* synthetic */ ActivityAlarmTypeBinding g1(AlarmTypeActivity alarmTypeActivity) {
        ActivityAlarmTypeBinding activityAlarmTypeBinding = alarmTypeActivity.z;
        if (activityAlarmTypeBinding == null) {
            j.t("binding");
        }
        return activityAlarmTypeBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(boolean z, boolean z2, boolean z3) {
        ActivityAlarmTypeBinding activityAlarmTypeBinding = this.z;
        if (activityAlarmTypeBinding == null) {
            j.t("binding");
        }
        RadioButton radioButton = activityAlarmTypeBinding.f6493f;
        j.d(radioButton, "binding.sound");
        radioButton.setClickable(z);
        ActivityAlarmTypeBinding activityAlarmTypeBinding2 = this.z;
        if (activityAlarmTypeBinding2 == null) {
            j.t("binding");
        }
        RadioButton radioButton2 = activityAlarmTypeBinding2.f6491c;
        j.d(radioButton2, "binding.light");
        radioButton2.setClickable(z2);
        ActivityAlarmTypeBinding activityAlarmTypeBinding3 = this.z;
        if (activityAlarmTypeBinding3 == null) {
            j.t("binding");
        }
        RadioButton radioButton3 = activityAlarmTypeBinding3.q;
        j.d(radioButton3, "binding.soundLight");
        radioButton3.setClickable(z3);
    }

    private final void i1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p1 = stringExtra;
        this.p2 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.p1;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(AlarmTypeViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ypeViewModel::class.java)");
        this.p0 = (AlarmTypeViewModel) viewModel;
        ActivityAlarmTypeBinding activityAlarmTypeBinding = this.z;
        if (activityAlarmTypeBinding == null) {
            j.t("binding");
        }
        AlarmTypeViewModel alarmTypeViewModel = this.p0;
        if (alarmTypeViewModel == null) {
            j.t("viewModel");
        }
        activityAlarmTypeBinding.i(alarmTypeViewModel);
        ActivityAlarmTypeBinding activityAlarmTypeBinding2 = this.z;
        if (activityAlarmTypeBinding2 == null) {
            j.t("binding");
        }
        activityAlarmTypeBinding2.h(this);
        AlarmTypeViewModel alarmTypeViewModel2 = this.p0;
        if (alarmTypeViewModel2 == null) {
            j.t("viewModel");
        }
        alarmTypeViewModel2.g(this.p2);
    }

    private final void j1() {
        AlarmTypeViewModel alarmTypeViewModel = this.p0;
        if (alarmTypeViewModel == null) {
            j.t("viewModel");
        }
        alarmTypeViewModel.f10693c.observe(this, new b());
        AlarmTypeViewModel alarmTypeViewModel2 = this.p0;
        if (alarmTypeViewModel2 == null) {
            j.t("viewModel");
        }
        alarmTypeViewModel2.a.observe(this, new c());
        AlarmTypeViewModel alarmTypeViewModel3 = this.p0;
        if (alarmTypeViewModel3 == null) {
            j.t("viewModel");
        }
        alarmTypeViewModel3.f10692b.observe(this, new d());
    }

    public View e1(int i) {
        if (this.p3 == null) {
            this.p3 = new HashMap();
        }
        View view = (View) this.p3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.p3.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a(view, (RadioButton) e1(com.tplink.iot.a.sound))) {
            AlarmTypeViewModel alarmTypeViewModel = this.p0;
            if (alarmTypeViewModel == null) {
                j.t("viewModel");
            }
            alarmTypeViewModel.w(AlertOption.SOUND);
        } else if (j.a(view, (RadioButton) e1(com.tplink.iot.a.light))) {
            AlarmTypeViewModel alarmTypeViewModel2 = this.p0;
            if (alarmTypeViewModel2 == null) {
                j.t("viewModel");
            }
            alarmTypeViewModel2.w(AlertOption.LIGHT);
        } else if (j.a(view, (RadioButton) e1(com.tplink.iot.a.sound_light))) {
            AlarmTypeViewModel alarmTypeViewModel3 = this.p0;
            if (alarmTypeViewModel3 == null) {
                j.t("viewModel");
            }
            alarmTypeViewModel3.w(AlertOption.BOTH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_alarm_type);
        j.d(contentView, "DataBindingUtil.setConte…yout.activity_alarm_type)");
        this.z = (ActivityAlarmTypeBinding) contentView;
        i1();
        j1();
    }
}
