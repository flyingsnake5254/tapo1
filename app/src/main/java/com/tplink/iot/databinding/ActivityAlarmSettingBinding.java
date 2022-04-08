package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityAlarmSettingBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final RelativeLayout I3;
    @NonNull
    public final LinearLayout J3;
    @NonNull
    public final View K3;
    @NonNull
    public final TextView L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final ScheduleWeekdayTextView N3;
    @Bindable
    protected View.OnClickListener O3;
    @Bindable
    protected AlarmSettingViewModel P3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CheckBox f6485c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6486d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6487f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final RadioGroup p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final RadioButton q;
    @NonNull
    public final RadioButton x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAlarmSettingBinding(Object obj, View view, int i, CheckBox checkBox, RelativeLayout relativeLayout, TextView textView, RadioButton radioButton, RadioButton radioButton2, RelativeLayout relativeLayout2, TextView textView2, TextView textView3, TextView textView4, RadioGroup radioGroup, TextView textView5, TextView textView6, RelativeLayout relativeLayout3, LinearLayout linearLayout, View view2, TextView textView7, TextView textView8, ScheduleWeekdayTextView scheduleWeekdayTextView) {
        super(obj, view, i);
        this.f6485c = checkBox;
        this.f6486d = relativeLayout;
        this.f6487f = textView;
        this.q = radioButton;
        this.x = radioButton2;
        this.y = relativeLayout2;
        this.z = textView2;
        this.p0 = textView3;
        this.p1 = textView4;
        this.p2 = radioGroup;
        this.p3 = textView5;
        this.H3 = textView6;
        this.I3 = relativeLayout3;
        this.J3 = linearLayout;
        this.K3 = view2;
        this.L3 = textView7;
        this.M3 = textView8;
        this.N3 = scheduleWeekdayTextView;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable AlarmSettingViewModel alarmSettingViewModel);
}
