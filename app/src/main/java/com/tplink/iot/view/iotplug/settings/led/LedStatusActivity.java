package com.tplink.iot.view.iotplug.settings.led;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.LedStatusViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedNightModeBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;

/* loaded from: classes2.dex */
public class LedStatusActivity extends BaseActivity implements View.OnClickListener, TPRadioButton.a {
    private LedStatusViewModel H3;
    private boolean J3;
    private String K3;
    private ItemSettingLayout p0;
    private TPRadioButton p1;
    private String p2;
    private RadioGroup y;
    private View z;
    private LedNightModeBean p3 = new LedNightModeBean();
    boolean I3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<LedInfoBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable LedInfoBean ledInfoBean) {
            LedStatusActivity.this.p1(ledInfoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            s0.g();
            if (num != null && num.intValue() == -1012) {
                w.f();
            } else if (num != null && num.intValue() == -1) {
                LedStatusActivity ledStatusActivity = LedStatusActivity.this;
                s0.p(ledStatusActivity, ledStatusActivity.getString(R.string.common_operation_failed));
            }
        }
    }

    private void f1() {
        LedNightModeBean ledNightModeBean = this.p3;
        if (ledNightModeBean == null || TextUtils.isEmpty(ledNightModeBean.getNightModeType()) || (!"sunrise_sunset".equals(this.p3.getNightModeType()) && !DefaultStatesBean.TYPE_CUSTOM.equals(this.p3.getNightModeType()))) {
            this.p3 = new LedNightModeBean();
            if (!this.I3 || !com.tplink.iot.Utils.w0.a.k(this.p2)) {
                this.p3.setNightModeType(DefaultStatesBean.TYPE_CUSTOM);
                this.p3.setStartTime(Integer.valueOf(this.H3.i(1200)));
                this.p3.setEndTime(Integer.valueOf(this.H3.i(420)));
                return;
            }
            this.p3.setNightModeType("sunrise_sunset");
            this.p3.setSunsetOffset(0);
            this.p3.setSunriseOffset(0);
        }
    }

    private LedInfoBean g1() {
        LedInfoBean ledInfoBean = new LedInfoBean();
        ledInfoBean.setLedRule(this.K3);
        if (TextUtils.equals(this.K3, "night_mode")) {
            f1();
            if (TextUtils.equals(this.p3.getNightModeType(), DefaultStatesBean.TYPE_CUSTOM)) {
                this.p3.setSunriseOffset(null);
                this.p3.setSunsetOffset(null);
            } else {
                this.p3.setStartTime(null);
                this.p3.setEndTime(null);
            }
            ledInfoBean.setNightMode(this.p3);
        }
        return ledInfoBean;
    }

    private SpannableString h1(String str, String str2) {
        String format = String.format(getString(R.string.led_off_time_interval_desc), str, str2);
        SpannableString spannableString = new SpannableString(format);
        int indexOf = format.indexOf(str);
        int indexOf2 = format.indexOf(str2);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_colorAccent)), indexOf, str.length() + indexOf, 17);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_colorAccent)), indexOf2, str2.length() + indexOf2, 17);
        return spannableString;
    }

    private int i1(String str) {
        return TextUtils.equals(str, "never") ? R.id.turn_off_rb : TextUtils.equals(str, "night_mode") ? R.id.rb_night_mode : R.id.turn_on_rb;
    }

    private void j1() {
        this.z.setVisibility(8);
        f1();
        if (TextUtils.equals(DefaultStatesBean.TYPE_CUSTOM, this.p3.getNightModeType())) {
            this.p0.setItemInfo(h1(o0.a(this, this.H3.j(this.p3.getStartTime().intValue())), o0.a(this, this.H3.j(this.p3.getEndTime().intValue()))));
            return;
        }
        this.p0.setItemInfo(h1(getString(R.string.sunset), getString(R.string.sunrise)));
    }

    private void k1() {
        LocalIoTBaseDevice value = ((PlugRepository) e.d(this.p2, PlugRepository.class)).j1().getValue();
        if (value != null) {
            this.I3 = value.isHasSetLocationInfo();
        }
    }

    private void l1() {
        c1(getString(R.string.led_status_title));
        this.y = (RadioGroup) findViewById(R.id.rg_led_rule);
        this.z = findViewById(R.id.ll_schedule);
        ItemSettingLayout itemSettingLayout = (ItemSettingLayout) findViewById(R.id.item_night_mode_schedule);
        this.p0 = itemSettingLayout;
        itemSettingLayout.setOnClickListener(this);
        this.p1 = (TPRadioButton) findViewById(R.id.turn_on_rb);
        this.p1.setOnCheckedChangeListener(this);
        ((TPRadioButton) findViewById(R.id.turn_off_rb)).setOnCheckedChangeListener(this);
        ((TPRadioButton) findViewById(R.id.rb_night_mode)).setOnCheckedChangeListener(this);
        m1();
    }

    private void m1() {
        BaseALIoTDevice h = this.H3.h();
        if (h != null && h.isHub()) {
            this.p1.setText(R.string.common_on);
        }
    }

    public static void n1(Activity activity, String str) {
        Intent intent = new Intent(activity, LedStatusActivity.class);
        intent.putExtra("device_id_md5", str);
        activity.startActivity(intent);
    }

    private void o1() {
        this.H3.k().observe(this, new a());
        this.H3.l().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(LedInfoBean ledInfoBean) {
        if (ledInfoBean != null) {
            this.y.check(i1(ledInfoBean.getLedRule()));
            this.z.setVisibility(i1(ledInfoBean.getLedRule()) == R.id.rb_night_mode ? 0 : 8);
            if (ledInfoBean.getNightMode() != null && !TextUtils.isEmpty(ledInfoBean.getNightMode().getNightModeType())) {
                LedNightModeBean nightMode = ledInfoBean.getNightMode();
                this.p3 = nightMode;
                if (TextUtils.equals(DefaultStatesBean.TYPE_CUSTOM, nightMode.getNightModeType())) {
                    this.p0.setItemInfo(h1(o0.a(this, this.H3.j(this.p3.getStartTime().intValue())), o0.a(this, this.H3.j(this.p3.getEndTime().intValue()))));
                } else {
                    this.p0.setItemInfo(h1(getString(R.string.sunset), getString(R.string.sunrise)));
                }
            }
        }
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a
    public void c(CompoundButton compoundButton, boolean z, boolean z2) {
        if (z2) {
            switch (compoundButton.getId()) {
                case R.id.rb_night_mode /* 2131363764 */:
                    this.K3 = "night_mode";
                    this.z.setVisibility(0);
                    break;
                case R.id.turn_off_rb /* 2131364314 */:
                    this.K3 = "never";
                    this.z.setVisibility(8);
                    break;
                case R.id.turn_on_rb /* 2131364315 */:
                    this.K3 = "always";
                    this.z.setVisibility(8);
                    break;
            }
            this.H3.m(g1());
            s0.l(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.item_night_mode_schedule) {
            LedScheduleActivity.p1(this, this.p2, this.p3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_led_status);
        this.J3 = o0.p(this);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.p2 = stringExtra;
        this.H3 = (LedStatusViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(LedStatusViewModel.class);
        k1();
        l1();
        j1();
        o1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        LedNightModeBean ledNightModeBean;
        super.onResume();
        if (this.J3 != o0.p(this) && (ledNightModeBean = this.p3) != null && TextUtils.equals(ledNightModeBean.getNightModeType(), DefaultStatesBean.TYPE_CUSTOM)) {
            this.p0.setItemInfo(h1(o0.a(this, this.H3.j(this.p3.getStartTime().intValue())), o0.a(this, this.H3.j(this.p3.getEndTime().intValue()))));
        }
    }
}
