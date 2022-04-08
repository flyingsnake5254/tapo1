package com.tplink.iot.view.iotplug.settings.led;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.TimeOffsetPickerDialog;

/* loaded from: classes2.dex */
public class LedOffsetSettingActivity extends BaseActivity implements View.OnClickListener, TimeOffsetPickerDialog.a {
    private int p0;
    private int p1;
    private ItemSettingLayout y;
    private ItemSettingLayout z;

    public static void e1(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, LedOffsetSettingActivity.class);
        intent.putExtra("tag_sunset_offset", i);
        intent.putExtra("tag_sunrise_offset", i2);
        activity.startActivityForResult(intent, 101);
    }

    @Override // com.tplink.iot.widget.TimeOffsetPickerDialog.a
    public void F0(TimeOffsetPickerDialog timeOffsetPickerDialog, int i) {
        if ("tag_sunset_offset".equals(timeOffsetPickerDialog.getTag())) {
            this.p0 = i;
            this.y.setItemInfo(o0.n(this, i));
        }
        if ("tag_sunrise_offset".equals(timeOffsetPickerDialog.getTag())) {
            this.p1 = i;
            this.z.setItemInfo(o0.n(this, i));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent(this, LedScheduleActivity.class);
        intent.putExtra("tag_sunset_offset", this.p0);
        intent.putExtra("tag_sunrise_offset", this.p1);
        setResult(101, intent);
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.item_sunrise_offset) {
            n0.c(getSupportFragmentManager(), this.p1, this, "tag_sunrise_offset");
        } else if (id == R.id.item_sunset_offset) {
            n0.c(getSupportFragmentManager(), this.p0, this, "tag_sunset_offset");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_led_offset_setting);
        c1(getString(R.string.led_offset_settings));
        if (getIntent() != null) {
            this.p0 = getIntent().getIntExtra("tag_sunset_offset", 0);
            this.p1 = getIntent().getIntExtra("tag_sunrise_offset", 0);
        }
        this.y = (ItemSettingLayout) findViewById(R.id.item_sunset_offset);
        this.z = (ItemSettingLayout) findViewById(R.id.item_sunrise_offset);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.y.setItemInfo(o0.n(this, this.p0));
        this.z.setItemInfo(o0.n(this, this.p1));
    }
}
