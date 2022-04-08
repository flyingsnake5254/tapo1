package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTimeSetting;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.widget.TimeScrollPickerDialog;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.WeekdayPickerView;

/* loaded from: classes2.dex */
public class EffectiveTimeFragment extends BaseFragment implements View.OnClickListener, TimeScrollPickerDialog.a {
    private TextView I3;
    private TextView J3;
    private TextView K3;
    private TextView L3;
    private TextView M3;
    private TextView N3;
    private TextView O3;
    private WeekdayPickerView P3;
    private LinearLayout Q3;
    private ActionSetupViewModel R3;
    private ActionDetailActivity U3;
    private View y;
    private final String q = "tag_start_time";
    private final String x = "tag_end_time";
    private int z = 0;
    private int p0 = 1439;
    private int p1 = 127;
    private int p2 = 0;
    private int p3 = 1439;
    private int H3 = 127;
    private String S3 = SmartPeriodSetting.PeriodType.ALL_DAY;
    private String T3 = SmartPeriodSetting.PeriodType.ALL_DAY;

    private void H0() {
        if (this.p2 == this.p3) {
            TSnackbar.B(this, R.string.Mode_edit_time_pick_equal, -1).N();
        } else if (this.P3.getWeekDay() == 0) {
            TSnackbar.B(this, R.string.smart_effect_time_tip, -1).N();
        } else {
            SmartPeriodSetting smartPeriodSetting = new SmartPeriodSetting();
            SmartTimeSetting smartTimeSetting = new SmartTimeSetting();
            if (this.T3.equals(SmartPeriodSetting.PeriodType.CUSTOM)) {
                smartTimeSetting.setStartTime(this.p2);
                smartTimeSetting.setEndTime(this.p3);
                smartPeriodSetting.setCustomTime(smartTimeSetting);
                smartPeriodSetting.setDaysOfWeek((byte) this.P3.getWeekDay());
            } else {
                smartTimeSetting.setStartTime(0);
                smartTimeSetting.setEndTime(1439);
                smartPeriodSetting.setCustomTime(smartTimeSetting);
                smartPeriodSetting.setDaysOfWeek(Byte.MAX_VALUE);
            }
            smartPeriodSetting.setPeriodType(this.T3);
            this.R3.v().setEffectivePeriod(smartPeriodSetting);
            B0();
        }
    }

    private void I0() {
        if (J0()) {
            new UniversalDialog.a().q(getString(R.string.camera_alarm_leave_message)).u(getString(R.string.camera_alarm_stay)).s(getString(R.string.camera_alarm_leave)).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.smart.actionsetup.a
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    EffectiveTimeFragment.this.B0();
                }
            }).l().show(getChildFragmentManager(), "");
        } else {
            B0();
        }
    }

    private boolean J0() {
        return (this.z == this.p2 && this.p0 == this.p3 && this.p1 == this.P3.getWeekDay() && this.S3.equals(this.T3)) ? false : true;
    }

    private void K0() {
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.U3 = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        this.R3 = (ActionSetupViewModel) ViewModelProviders.of(this.U3).get(ActionSetupViewModel.class);
    }

    private void L0() {
        this.R3.D().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EffectiveTimeFragment.this.P0((SmartInfo) obj);
            }
        });
    }

    private void N0() {
        d.J(this.U3, this.y.findViewById(R.id.tool_bar));
        setHasOptionsMenu(true);
        this.I3 = (TextView) this.y.findViewById(R.id.start_time);
        this.J3 = (TextView) this.y.findViewById(R.id.end_time);
        this.K3 = (TextView) this.y.findViewById(R.id.item_schedule_next_day_tv);
        this.P3 = (WeekdayPickerView) this.y.findViewById(R.id.weekday_picker_view);
        this.L3 = (TextView) this.y.findViewById(R.id.tv_all_day);
        this.M3 = (TextView) this.y.findViewById(R.id.tv_custom_time);
        this.Q3 = (LinearLayout) this.y.findViewById(R.id.ll_custom_time);
        this.N3 = (TextView) this.y.findViewById(R.id.tv_back);
        this.O3 = (TextView) this.y.findViewById(R.id.tv_save);
        this.I3.setOnClickListener(this);
        this.J3.setOnClickListener(this);
        this.K3.setOnClickListener(this);
        this.L3.setOnClickListener(this);
        this.M3.setOnClickListener(this);
        this.N3.setOnClickListener(this);
        this.O3.setOnClickListener(this);
        this.P3.setWeekDay(this.H3);
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(SmartInfo smartInfo) {
        SmartPeriodSetting effectivePeriod;
        if (!(smartInfo == null || (effectivePeriod = smartInfo.getEffectivePeriod()) == null)) {
            String periodType = effectivePeriod.getPeriodType();
            this.T3 = periodType;
            this.S3 = periodType;
            if (periodType.equals(SmartPeriodSetting.PeriodType.CUSTOM)) {
                if (effectivePeriod.getCustomTime() != null) {
                    int startTime = effectivePeriod.getCustomTime().getStartTime();
                    this.p2 = startTime;
                    this.z = startTime;
                    int endTime = effectivePeriod.getCustomTime().getEndTime();
                    this.p3 = endTime;
                    this.p0 = endTime;
                }
                byte daysOfWeek = effectivePeriod.getDaysOfWeek();
                this.H3 = daysOfWeek;
                this.p1 = daysOfWeek;
                this.P3.setWeekDay(daysOfWeek);
            }
        }
        Q0();
    }

    private void Q0() {
        int i = 0;
        if (this.T3.equals(SmartPeriodSetting.PeriodType.ALL_DAY)) {
            this.M3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.home_plug_on_selecter_selected, 0);
            this.Q3.setVisibility(8);
            return;
        }
        this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        this.M3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.home_plug_on_selecter_selected, 0);
        this.Q3.setVisibility(0);
        this.I3.setText(o0.a(getActivity(), this.p2));
        this.J3.setText(o0.a(getActivity(), this.p3));
        TextView textView = this.K3;
        if (this.p2 <= this.p3) {
            i = 4;
        }
        textView.setVisibility(i);
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        I0();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.end_time /* 2131362541 */:
            case R.id.item_schedule_next_day_tv /* 2131362953 */:
                n0.b(getChildFragmentManager(), this.p3, true, true, this.p2, this, "tag_end_time");
                return;
            case R.id.start_time /* 2131364107 */:
                n0.b(getChildFragmentManager(), this.p2, true, false, this.p3, this, "tag_start_time");
                return;
            case R.id.tv_all_day /* 2131364339 */:
                this.T3 = SmartPeriodSetting.PeriodType.ALL_DAY;
                Q0();
                return;
            case R.id.tv_back /* 2131364352 */:
                I0();
                return;
            case R.id.tv_custom_time /* 2131364390 */:
                this.T3 = SmartPeriodSetting.PeriodType.CUSTOM;
                Q0();
                return;
            case R.id.tv_save /* 2131364613 */:
                H0();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.y = layoutInflater.inflate(R.layout.fragment_smart_effctive_time, viewGroup, false);
        K0();
        N0();
        L0();
        return this.y;
    }

    @Override // com.tplink.iot.widget.TimeScrollPickerDialog.a
    public void z0(TimeScrollPickerDialog timeScrollPickerDialog, int i) {
        if ("tag_start_time".equals(timeScrollPickerDialog.getTag())) {
            this.p2 = i;
            this.I3.setText(o0.a(getActivity(), this.p2));
        } else if ("tag_end_time".equals(timeScrollPickerDialog.getTag())) {
            this.p3 = i;
            this.J3.setText(o0.a(getActivity(), this.p3));
        }
        this.K3.setVisibility(this.p2 > this.p3 ? 0 : 4);
    }
}
