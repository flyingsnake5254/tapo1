package com.tplink.iot.view.feature;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.widget.InnerTimePicker;
import com.tplink.iot.widget.ItemSunriseSunsetSetting;
import com.tplink.iot.widget.TimeOffsetPickerDialog;

/* loaded from: classes2.dex */
public class SelectAwayModeActivity extends BaseLocationActivity implements InnerTimePicker.a, TimeOffsetPickerDialog.a, View.OnClickListener, ItemSunriseSunsetSetting.b {
    private int H3;
    private int I3;
    private int J3;
    private RuleTimeType K3 = RuleTimeType.NORMAL;
    private int L3;
    private ItemSunriseSunsetSetting p0;
    private ItemSunriseSunsetSetting p1;
    private ItemSunriseSunsetSetting p2;
    private String p3;
    private InnerTimePicker z;

    private void n1() {
        int i;
        Resources resources;
        if (getIntent() != null) {
            this.p3 = getIntent().getStringExtra("device_id_md5");
            RuleTimeType ruleTimeType = (RuleTimeType) getIntent().getSerializableExtra("tag_mode");
            this.K3 = ruleTimeType;
            if (ruleTimeType == null) {
                this.K3 = RuleTimeType.NORMAL;
            }
            RuleTimeType ruleTimeType2 = this.K3;
            if (ruleTimeType2 == RuleTimeType.SUNRISE) {
                this.H3 = getIntent().getIntExtra("tag_sunset_offset", 0);
            } else if (ruleTimeType2 == RuleTimeType.SUNSET) {
                this.I3 = getIntent().getIntExtra("tag_sunset_offset", 0);
            } else {
                this.J3 = getIntent().getIntExtra("tag_sunset_offset", 0);
            }
            if (getIntent().getIntExtra("request_code", 1) == 1) {
                resources = getResources();
                i = R.string.common_start_time;
            } else {
                resources = getResources();
                i = R.string.common_end_time;
            }
            c1(resources.getString(i));
        }
    }

    private void o1() {
        this.z = (InnerTimePicker) findViewById(R.id.inner_time_select_view);
        this.p0 = (ItemSunriseSunsetSetting) findViewById(R.id.item_sunrise);
        this.p1 = (ItemSunriseSunsetSetting) findViewById(R.id.item_sunset);
        this.p2 = (ItemSunriseSunsetSetting) findViewById(R.id.item_custom);
        this.p0.setOnClickListener(this);
        this.p1.setOnClickListener(this);
        this.p2.setOnClickListener(this);
        this.p0.setOnOffsetSettingClickListener(this);
        this.p1.setOnOffsetSettingClickListener(this);
        this.p2.setOnOffsetSettingClickListener(this);
        this.z.setOnTimePickerChangeListener(this);
        this.z.setMinuteOfDay(this.J3);
        RuleTimeType ruleTimeType = this.K3;
        if (ruleTimeType == RuleTimeType.SUNSET) {
            this.p1.setChecked(true);
            this.p0.setChecked(false);
            this.p2.setChecked(false);
            this.p1.setOffset(o0.n(this, this.I3));
            this.z.setVisibility(8);
        } else if (ruleTimeType == RuleTimeType.SUNRISE) {
            this.p1.setChecked(false);
            this.p0.setChecked(true);
            this.p2.setChecked(false);
            this.z.setVisibility(8);
            this.p0.setOffset(o0.n(this, this.H3));
        } else {
            this.p1.setChecked(false);
            this.p0.setChecked(false);
            this.p2.setChecked(true);
            this.z.setVisibility(0);
        }
        if (!a.k(this.p3)) {
            this.p0.setVisibility(8);
            this.p1.setVisibility(8);
        }
    }

    public static void p1(Activity activity, String str, int i, RuleTimeType ruleTimeType, int i2) {
        Intent intent = new Intent(activity, SelectAwayModeActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("tag_sunset_offset", i2);
        intent.putExtra("tag_mode", ruleTimeType);
        intent.putExtra("request_code", i);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.tplink.iot.widget.TimeOffsetPickerDialog.a
    public void F0(TimeOffsetPickerDialog timeOffsetPickerDialog, int i) {
        if (TextUtils.equals(timeOffsetPickerDialog.getTag(), "tag_sunrise_offset_picker")) {
            this.H3 = i;
            this.K3 = RuleTimeType.SUNRISE;
            this.p0.setOffset(o0.n(this, i));
        } else if (TextUtils.equals(timeOffsetPickerDialog.getTag(), "tag_sunset_offset_picker")) {
            this.I3 = i;
            this.K3 = RuleTimeType.SUNSET;
            this.p1.setOffset(o0.n(this, i));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("tag_mode", this.K3);
        RuleTimeType ruleTimeType = this.K3;
        if (ruleTimeType == RuleTimeType.SUNRISE) {
            intent.putExtra("tag_sunset_offset", this.H3);
        } else if (ruleTimeType == RuleTimeType.SUNSET) {
            intent.putExtra("tag_sunset_offset", this.I3);
        } else {
            intent.putExtra("tag_sunset_offset", this.J3);
        }
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.tplink.iot.base.BaseLocationActivity
    public void h1() {
        if (k1(this.p3)) {
            int i = this.L3;
            if (i == R.id.item_sunrise) {
                onClick(this.p0);
            } else if (i == R.id.item_sunset) {
                onClick(this.p1);
            }
        }
    }

    @Override // com.tplink.iot.widget.InnerTimePicker.a
    public void m() {
        this.J3 = this.z.getMinutesOfDay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (k1(this.p3) || view.getId() == R.id.item_custom) {
            int id = view.getId();
            if (id == R.id.item_custom) {
                this.K3 = RuleTimeType.NORMAL;
                this.p0.setChecked(false);
                this.p1.setChecked(false);
                this.p2.setChecked(true);
                this.z.setVisibility(0);
            } else if (id == R.id.item_sunrise) {
                this.K3 = RuleTimeType.SUNRISE;
                this.p0.setChecked(true);
                this.p1.setChecked(false);
                this.p2.setChecked(false);
                this.z.setVisibility(8);
            } else if (id == R.id.item_sunset) {
                this.K3 = RuleTimeType.SUNSET;
                this.p0.setChecked(false);
                this.p1.setChecked(true);
                this.p2.setChecked(false);
                this.z.setVisibility(8);
            }
        } else {
            this.L3 = view.getId();
            f1(this.p3);
            onClick(this.p2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseLocationActivity, com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_select_away_mode);
        n1();
        o1();
    }

    @Override // com.tplink.iot.widget.ItemSunriseSunsetSetting.b
    public void onOffsetSettingClick(View view) {
        int id = view.getId();
        if (id == R.id.item_sunrise) {
            n0.c(getSupportFragmentManager(), this.H3, this, "tag_sunrise_offset_picker");
        } else if (id == R.id.item_sunset) {
            n0.c(getSupportFragmentManager(), this.I3, this, "tag_sunset_offset_picker");
        }
    }
}
