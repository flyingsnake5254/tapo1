package com.tplink.iot.view.ipcamera.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import butterknife.OnClick;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityScheduleEditBinding;
import com.tplink.iot.view.ipcamera.setting.TimeWheelDialog;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes2.dex */
public class ScheduleEditActivity extends BaseActivity implements View.OnClickListener, TimeWheelDialog.a {
    boolean[] M3;
    TimeWheelDialog N3;
    String O3;
    boolean p0;
    private ActivityScheduleEditBinding y;
    private AlarmSettingViewModel z;
    int p1 = -1;
    int p2 = -1;
    int p3 = 0;
    int H3 = 0;
    int I3 = 0;
    int J3 = 0;
    int K3 = -1;
    int L3 = -1;

    private void e1() {
        if (f1()) {
            new UniversalDialog.a().q(getString(R.string.camera_alarm_leave_message)).u(getString(R.string.camera_alarm_stay)).s(getString(R.string.camera_alarm_leave)).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.setting.v3
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    ScheduleEditActivity.this.i1();
                }
            }).l().show(getSupportFragmentManager(), "");
        } else {
            finish();
        }
    }

    private boolean f1() {
        boolean[] chosenArray = this.y.q.getChosenArray();
        for (int i = 0; i < chosenArray.length; i++) {
            if (chosenArray[i] != this.M3[i]) {
                return true;
            }
        }
        return (this.K3 == this.p1 && this.L3 == this.p2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(View view) {
        p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(View view) {
        r1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(View view) {
        q1();
    }

    private void p1() {
        if (this.p1 == -1) {
            TSnackbar.x(this, R.string.Mode_edit_start_time_tip, -1).N();
        } else if (this.p2 == -1) {
            TSnackbar.x(this, R.string.Mode_edit_end_time_tip, -1).N();
        } else {
            boolean[] chosenArray = this.y.q.getChosenArray();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= chosenArray.length) {
                    break;
                } else if (chosenArray[i]) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                TSnackbar.x(this, R.string.Mode_edit_week_day_tip, -1).N();
                return;
            }
            int i2 = this.p1;
            int i3 = this.p2;
            if (i2 == i3) {
                TSnackbar.x(this, R.string.Mode_edit_time_pick_equal, -1).N();
            } else if (this.p0 || i2 <= i3) {
                Intent intent = new Intent();
                intent.putExtra("startTime", this.y.y.getText().toString());
                intent.putExtra("endTime", this.y.f6663c.getText().toString());
                intent.putExtra("weekDayArr", chosenArray);
                if (this.O3.equals("add")) {
                    setResult(100, intent);
                } else {
                    setResult(101, intent);
                }
                finish();
            } else {
                TSnackbar.x(this, R.string.Mode_edit_time_pick_later, -1).N();
            }
        }
    }

    protected void g1() {
        Intent intent = getIntent();
        this.O3 = intent.getStringExtra(RtspHeaders.Values.MODE);
        boolean booleanExtra = intent.getBooleanExtra("deletable", true);
        this.p0 = intent.getBooleanExtra("canPastMidnight", false);
        if (this.O3.equals("modify")) {
            String stringExtra = intent.getStringExtra("startTime");
            this.p3 = Integer.parseInt(stringExtra.split(SSLClient.COLON)[0]);
            int parseInt = Integer.parseInt(stringExtra.split(SSLClient.COLON)[1]);
            this.H3 = parseInt;
            int i = (this.p3 * 60) + parseInt;
            this.K3 = i;
            this.p1 = i;
            this.y.y.setText(stringExtra);
            String stringExtra2 = intent.getStringExtra("endTime");
            this.I3 = Integer.parseInt(stringExtra2.split(SSLClient.COLON)[0]);
            int parseInt2 = Integer.parseInt(stringExtra2.split(SSLClient.COLON)[1]);
            this.J3 = parseInt2;
            int i2 = (this.I3 * 60) + parseInt2;
            this.L3 = i2;
            this.p2 = i2;
            this.y.f6663c.setText(stringExtra2);
            this.z.h.set(stringExtra);
            this.z.i.set(stringExtra2);
            this.y.z.setTitle(R.string.mode_edit_schedule_entry_title);
            boolean[] zArr = (boolean[]) intent.getSerializableExtra("weekDayArr");
            this.M3 = new boolean[zArr.length];
            for (int i3 = 0; i3 < zArr.length; i3++) {
                this.M3[i3] = zArr[i3];
            }
            this.y.q.setInitial(zArr);
            if (!booleanExtra) {
                this.y.x.setVisibility(8);
                return;
            }
            return;
        }
        this.y.z.setTitle(R.string.mode_edit_add_schedule_title);
        this.y.x.setVisibility(8);
    }

    @Override // com.tplink.iot.view.ipcamera.setting.TimeWheelDialog.a
    public void n(int i, int i2, boolean z) {
        String str;
        if (i2 < 10) {
            str = "0" + i2;
        } else {
            str = String.valueOf(i2);
        }
        if (z) {
            this.p1 = (i * 60) + i2;
            this.p3 = i;
            this.H3 = i2;
            this.y.y.setText(i + SSLClient.COLON + str);
        } else {
            this.p2 = (i * 60) + i2;
            this.I3 = i;
            this.J3 = i2;
            this.y.f6663c.setText(i + SSLClient.COLON + str);
        }
        int i3 = this.p2;
        int i4 = this.p1;
        if (i3 >= i4 || i4 == -1 || i3 == -1) {
            this.y.f6664d.setVisibility(8);
        } else {
            this.y.f6664d.setVisibility(0);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityScheduleEditBinding) DataBindingUtil.setContentView(this, R.layout.activity_schedule_edit);
        AlarmSettingViewModel alarmSettingViewModel = (AlarmSettingViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(AlarmSettingViewModel.class);
        this.z = alarmSettingViewModel;
        this.y.h(alarmSettingViewModel);
        g1();
        this.y.q.setInitial((boolean[]) getIntent().getSerializableExtra("weekDayArr"));
        this.y.q.invalidate();
        this.y.f6665f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.t3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduleEditActivity.this.k1(view);
            }
        });
        this.y.y.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduleEditActivity.this.m1(view);
            }
        });
        this.y.f6663c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.w3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduleEditActivity.this.o1(view);
            }
        });
        setSupportActionBar(this.y.z);
    }

    @OnClick
    public void onDeleteClick() {
        setResult(102);
        finish();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        e1();
        return false;
    }

    void q1() {
        if (this.N3 == null) {
            TimeWheelDialog C0 = TimeWheelDialog.C0();
            this.N3 = C0;
            C0.G0(this);
        }
        this.N3.A0(this.I3, this.J3, false);
        this.N3.show(getSupportFragmentManager(), "modeTimePickerDialog");
    }

    void r1() {
        if (this.N3 == null) {
            TimeWheelDialog C0 = TimeWheelDialog.C0();
            this.N3 = C0;
            C0.G0(this);
        }
        this.N3.A0(this.p3, this.H3, true);
        this.N3.show(getSupportFragmentManager(), "modeTimePickerDialog");
    }
}
