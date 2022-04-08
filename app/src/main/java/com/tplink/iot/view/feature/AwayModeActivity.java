package com.tplink.iot.view.feature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.viewmodel.iotcommon.feature.AwayModeViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.WeekdayPickerView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class AwayModeActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout H3;
    private TPRefreshableButton I3;
    private Button J3;
    private String M3;
    private RuleTimeType N3;
    private RuleTimeType O3;
    private int P3;
    private int Q3;
    private AwayModeViewModel S3;
    private TextView p0;
    private TextView p1;
    private TextView p2;
    private WeekdayPickerView p3;
    private TextView y;
    private TextView z;
    private int K3 = 1170;
    private int L3 = 360;
    private ThingRuleAwayMode R3 = new ThingRuleAwayMode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<ThingRuleAwayMode> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingRuleAwayMode thingRuleAwayMode) {
            if (thingRuleAwayMode != null) {
                AwayModeActivity.this.R3 = thingRuleAwayMode;
                AwayModeActivity awayModeActivity = AwayModeActivity.this;
                awayModeActivity.t1(awayModeActivity.R3);
                if (thingRuleAwayMode.isEnable()) {
                    AwayModeActivity.this.r1(1);
                } else {
                    AwayModeActivity.this.r1(0);
                }
            } else {
                AwayModeActivity.this.r1(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            AwayModeActivity.this.u1(num);
        }
    }

    public AwayModeActivity() {
        RuleTimeType ruleTimeType = RuleTimeType.NORMAL;
        this.N3 = ruleTimeType;
        this.O3 = ruleTimeType;
    }

    private ThingRuleAwayMode j1() {
        if (this.R3 == null) {
            this.R3 = new ThingRuleAwayMode();
        }
        this.R3.setId(null);
        if (p1(this.N3)) {
            this.N3 = RuleTimeType.NORMAL;
            this.R3.setStartTimeMin(this.S3.j(this.K3));
        } else {
            this.R3.setStartTimeOffset(this.P3);
        }
        if (p1(this.O3)) {
            this.O3 = RuleTimeType.NORMAL;
            this.R3.setEndTimeMin(this.S3.j(this.L3));
        } else {
            this.R3.setEndTimeOffset(this.Q3);
        }
        ThingRuleAwayMode thingRuleAwayMode = this.R3;
        RuleTimeType ruleTimeType = this.N3;
        if (ruleTimeType == null) {
            ruleTimeType = RuleTimeType.NORMAL;
        }
        thingRuleAwayMode.setStartTimeType(ruleTimeType);
        ThingRuleAwayMode thingRuleAwayMode2 = this.R3;
        RuleTimeType ruleTimeType2 = this.O3;
        if (ruleTimeType2 == null) {
            ruleTimeType2 = RuleTimeType.NORMAL;
        }
        thingRuleAwayMode2.setEndTimeType(ruleTimeType2);
        this.R3.setWeekOfDays((byte) this.p3.getWeekDay());
        this.R3.setEnable(true);
        this.R3.setFrequency(5);
        this.R3.setYear(null);
        this.R3.setMonth(null);
        this.R3.setDay(null);
        if (this.p3.getWeekDay() == 0) {
            this.R3.setMode(RuleMode.ONCE);
        } else {
            this.R3.setMode(RuleMode.REPEAT);
        }
        return this.R3;
    }

    private void m1() {
        c1(getString(R.string.plug_away_mode));
        this.z = (TextView) findViewById(R.id.tv_away_mode_instr);
        this.p0 = (TextView) findViewById(R.id.tv_period_start_time);
        this.y = (TextView) findViewById(R.id.tv_away_mode_active_tips);
        this.p1 = (TextView) findViewById(R.id.tv_period_end_time);
        this.p2 = (TextView) findViewById(R.id.tv_next_day);
        WeekdayPickerView weekdayPickerView = (WeekdayPickerView) findViewById(R.id.weekday_picker_view);
        this.p3 = weekdayPickerView;
        weekdayPickerView.setDescriptionVisibility(true);
        this.I3 = (TPRefreshableButton) findViewById(R.id.btn_start);
        this.J3 = (Button) findViewById(R.id.btn_stop);
        this.p0.setOnClickListener(this);
        this.H3 = (LinearLayout) findViewById(R.id.ll_alpha_view);
        this.p1.setOnClickListener(this);
        this.p2.setOnClickListener(this);
        this.I3.setOnClickListener(this);
        this.J3.setOnClickListener(this);
        this.p0.setText(o0.c(this, this.K3, this.N3));
        this.p1.setText(o0.c(this, this.L3, this.O3));
        this.p2.setVisibility(o1() ? 0 : 4);
        this.I3.setEnabled(n1());
    }

    private boolean n1() {
        if (p1(this.N3) && p1(this.O3)) {
            if (this.K3 != this.L3) {
                return true;
            }
        } else if (this.N3 != this.O3) {
            return true;
        }
        return false;
    }

    private boolean o1() {
        ThingRuleAwayMode thingRuleAwayMode = this.R3;
        if (thingRuleAwayMode == null) {
            return true;
        }
        return (p1(thingRuleAwayMode.getStartTimeType()) && p1(this.R3.getEndTimeType())) && this.K3 > this.L3;
    }

    private boolean p1(RuleTimeType ruleTimeType) {
        return ruleTimeType == null || ruleTimeType == RuleTimeType.NONE || ruleTimeType == RuleTimeType.NORMAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i) {
        if (i == 0) {
            this.z.setText(getString(R.string.away_mode_common_create_instr));
            this.p0.setEnabled(true);
            this.H3.setAlpha(1.0f);
            this.p1.setEnabled(true);
            this.p2.setEnabled(true);
            this.p3.l(127, true);
            this.J3.setVisibility(4);
            this.I3.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i == 1) {
            this.z.setText(getString(R.string.away_mode_common_active_instr));
            this.p0.setEnabled(false);
            this.H3.setAlpha(0.5f);
            this.y.setVisibility(0);
            this.p1.setEnabled(false);
            this.p2.setEnabled(false);
            this.p3.i();
            this.I3.setVisibility(4);
            this.J3.setVisibility(0);
        }
    }

    private void s1() {
        this.S3.h().observe(this, new a());
        this.S3.m().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(ThingRuleAwayMode thingRuleAwayMode) {
        this.K3 = this.S3.l(thingRuleAwayMode.getStartTimeMin());
        this.L3 = this.S3.l(thingRuleAwayMode.getEndTimeMin());
        this.N3 = thingRuleAwayMode.getStartTimeType();
        this.O3 = thingRuleAwayMode.getEndTimeType();
        this.P3 = thingRuleAwayMode.getStartTimeOffset();
        this.Q3 = thingRuleAwayMode.getEndTimeOffset();
        this.p3.setWeekDay(thingRuleAwayMode.getWeekOfDays());
        this.p0.setText(o0.c(this, this.K3, this.N3));
        this.p1.setText(o0.c(this, this.L3, this.O3));
        this.p2.setVisibility(o1() ? 0 : 4);
        this.I3.setEnabled(n1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.I3.g();
            this.p0.setEnabled(false);
            this.p1.setEnabled(false);
            return;
        }
        this.I3.h();
        boolean n = this.S3.n();
        this.p0.setEnabled(!n);
        this.p1.setEnabled(!n);
        if (num.intValue() == -1) {
            s0.n(this, R.string.operation_failed_try_again);
        } else if (num.intValue() == 10000) {
            s0.u(this, R.string.schedule_event_conflict, null, 2000L);
        }
    }

    public int k1(int i) {
        return p1(this.R3.getEndTimeType()) ? i : this.R3.getEndTimeOffset();
    }

    public int l1(int i) {
        return p1(this.R3.getStartTimeType()) ? i : this.R3.getStartTimeOffset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
        } else if (i == 1) {
            this.P3 = intent.getIntExtra("tag_sunset_offset", 0);
            RuleTimeType ruleTimeType = (RuleTimeType) intent.getSerializableExtra("tag_mode");
            this.N3 = ruleTimeType;
            q1(1, this.P3, ruleTimeType);
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else {
            this.Q3 = intent.getIntExtra("tag_sunset_offset", 0);
            RuleTimeType ruleTimeType2 = (RuleTimeType) intent.getSerializableExtra("tag_mode");
            this.O3 = ruleTimeType2;
            q1(2, this.Q3, ruleTimeType2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start /* 2131362109 */:
                ThingRuleAwayMode j1 = j1();
                this.S3.g(j1);
                i.E(this.M3, j1, this.S3.o(), this.S3.k());
                return;
            case R.id.btn_stop /* 2131362110 */:
                this.R3.setEnable(false);
                this.R3.setYear(null);
                this.R3.setMonth(null);
                this.R3.setDay(null);
                this.S3.p(this.R3);
                i.G(this.M3);
                return;
            case R.id.tv_next_day /* 2131364539 */:
            case R.id.tv_period_end_time /* 2131364569 */:
                SelectAwayModeActivity.p1(this, this.M3, 2, this.R3.getEndTimeType(), k1(this.L3));
                return;
            case R.id.tv_period_start_time /* 2131364570 */:
                SelectAwayModeActivity.p1(this, this.M3, 1, this.R3.getStartTimeType(), l1(this.K3));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_away_mode);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("device_id_md5");
            this.M3 = stringExtra;
            this.S3 = (AwayModeViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(AwayModeViewModel.class);
            m1();
            r1(this.S3.n() ? 1 : 0);
            s1();
            this.S3.i();
            i.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p0.setText(o0.c(this, this.K3, this.N3));
        this.p1.setText(o0.c(this, this.L3, this.O3));
    }

    public void q1(int i, int i2, RuleTimeType ruleTimeType) {
        if (i == 1) {
            if (!p1(ruleTimeType)) {
                this.R3.setStartTimeOffset(i2);
            } else {
                this.R3.setStartTimeMin(i2);
                this.K3 = i2;
            }
            this.R3.setStartTimeType(ruleTimeType);
            this.p0.setText(o0.c(this, i2, ruleTimeType));
        } else if (i == 2) {
            if (!p1(ruleTimeType)) {
                this.R3.setEndTimeOffset(i2);
            } else {
                this.R3.setEndTimeMin(i2);
                this.L3 = i2;
            }
            this.R3.setEndTimeType(ruleTimeType);
            this.p1.setText(o0.c(this, i2, ruleTimeType));
        }
        this.I3.setEnabled(n1());
        this.p2.setVisibility(o1() ? 0 : 4);
    }
}
